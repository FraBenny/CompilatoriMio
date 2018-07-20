package ast;

import exception.TypeException;
import java.util.ArrayList;

import util.Environment;
import util.SemanticError;
import util.FOOLlib;
import org.antlr.v4.runtime.RuleContext;

public class CallNode implements Node {

    private String id;
    private STentry entry;
    private ArrayList<Node> parlist;
    private int nestinglevel;

    public CallNode(String i, STentry e, ArrayList<Node> p, int nl) {
        id = i;
        entry = e;
        parlist = p;
        nestinglevel = nl;
    }

    public CallNode(String text, ArrayList<Node> args) {
        id = text;
        parlist = args;
    }

    @Override
    public String toPrint(String s) {  //
        String parlstr = "";
        for (Node par : parlist) {
            parlstr += par.toPrint(s + "  ");
        }
        return s + "Call:" + id + " at nestlev " + nestinglevel + "\n"
                + entry.toString(s + "  ")
                + parlstr;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        //create the result
        ArrayList<SemanticError> res = new ArrayList<>();

        int j = env.getNestingLevel();
        STentry tmp = null;
        while (j >= 0 && tmp == null) {
            tmp = (env.getHashMap(j--)).get(id);
        }
        if (tmp == null) {
            res.add(new SemanticError("Id " + id + " not declared"));
        } else {
            this.entry = tmp;
            this.nestinglevel = env.getNestingLevel();

            for (Node arg : parlist) {
                res.addAll(arg.checkSemantics(env));
            }
        }
        return res;
    }

    public Node typeCheck() throws TypeException {  //                           
        ArrowTypeNode t = null;
        if (entry.getNode() instanceof ArrowTypeNode) {
            t = (ArrowTypeNode) entry.getNode(); //controllo che sia un tipo freccia
        } else {
            throw new TypeException("Invocation of a non-function " + id);
        }
        ArrayList<Node> p = t.getParList();
        if (!(p.size() == parlist.size())) {
            throw new TypeException("Wrong number of parameters in the invocation of " + id);
        }
        for (int i = 0; i < parlist.size(); i++) {
            if (!(parlist.get(i)).typeCheck().isSubTypeOf(p.get(i))) {
                throw new TypeException("Wrong type for " + (i + 1) + "-th parameter in the invocation of " + id);
            }
        }
        return t.getRet();
    }

    public String codeGeneration() {
        String parCode = "";
        for (int i = parlist.size() - 1; i >= 0; i--) {
            parCode += parlist.get(i).codeGeneration();
        }

        String getAR = "";
        for (int i = 0; i < nestinglevel - entry.getNestinglevel(); i++) {
            getAR += "lw\n";
        }

        return "lfp\n"
                + //CL
                parCode
                + "lfp\n" + getAR
                + //setto AL risalendo la catena statica
                // ora recupero l'indirizzo a cui saltare e lo metto sullo stack
                "push " + entry.getOffset() + "\n"
                + //metto offset sullo stack
                "lfp\n" + getAR
                + //risalgo la catena statica
                "add\n"
                + "lw\n"
                + //carico sullo stack il valore all'indirizzo ottenuto
                "js\n";
    }

    public boolean isSubTypeOf(Node m) {
       return entry.getNode().isSubTypeOf(m);
    }

    public ArrayList<Node> getParlist() {
        return parlist;
    }

    
}
