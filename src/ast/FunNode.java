package ast;

import exception.RedeclaredVarException;
import exception.TypeException;
import exception.UndeclaredVarException;
import java.util.ArrayList;
import java.util.HashMap;

import util.FOOLlib;
import util.Environment;
import util.SemanticError;

public class FunNode implements Node {

    private String id;
    private Node type;
    private ArrayList<Node> parlist = new ArrayList<>();
    private ArrayList<Node> declist;
    private Node body;
    private String classID;
    public static int t = 0;
    public static HashMap<Node, Integer> m = new HashMap(); 

    public FunNode(String i, Node t) {
        id = i;
        type = t;
    }

    public FunNode(String i, Node t, ArrayList<Node> params) {
        id = i;
        type = t;
        parlist = params;
    }

    public void addDecBody(ArrayList<Node> d, Node b) {
        declist = d;
        body = b;
    }

    @Override

    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> res = new ArrayList<>();
        ArrayList<Node> parTypes = new ArrayList<>();

        for (Node param : parlist) {
            VarNode params = (VarNode) param;
            parTypes.add(params.getType());
        }

        //env.offset = -2;
        try {
            // Se restituisco un oggetto, aggiorno le informazione sul ClassType
            if (this.type instanceof InstanceTypeNode) {
                InstanceTypeNode returnType = (InstanceTypeNode) this.type;
                res.addAll(returnType.updateClassType(env));
            }
            env.addEntry(this.id, new ArrowTypeNode(parTypes, type), env.offset--);
        } catch (RedeclaredVarException e) {
            res.add(new SemanticError("function " + id + " already declared"));
        }
        env.pushHashMap();

        if (classID != null) {
            try {
                STentry classEntry = env.getLatestEntryOfNotFun(classID);
                env.addEntry("this", new InstanceTypeNode((ClassTypeNode) classEntry.getNode()), 0);
            } catch (RedeclaredVarException | UndeclaredVarException e) {
            }
        }

        //check args
        for (Node param : parlist) {
            res.addAll(param.checkSemantics(env));
        }

        //check semantics in the dec list
        if (declist.size() > 0) {
            env.offset = -2;
            //if there are children then check semantics for every child and save the results
            for (Node n : declist) {
                res.addAll(n.checkSemantics(env));
            }
        }
        res.addAll(body.checkSemantics(env));
        env.popHashMap();

        return res;
    }

    public void addPar(Node p) {
        parlist.add(p);
    }

    @Override
    public String toPrint(String s) {
        String parlstr = "";
        for (Node par : parlist) {
            parlstr += par.toPrint(s + "  ");
        }
        String declstr = "";
        if (declist != null) {
            for (Node dec : declist) {
                declstr += dec.toPrint(s + "  ");
            }
        }
        return s + "Fun:" + id + "\n"
                + type.toPrint(s + "  ")
                //+ (parlist.isEmpty() ? "" : "   with parameters :")
                + parlstr
                //+ (declstr.isEmpty() ? "" : "with declarations :")
                + declstr
                + body.toPrint(s + "  body: ");
    }

    @Override
    public Node typeCheck() throws TypeException {
        if (declist != null) {
            for (Node dec : declist) {
                dec.typeCheck();
            }
        }
        if (!(type instanceof VoidTypeNode) && !(body.typeCheck().isSubTypeOf(type))) {
            System.out.println("Wrong return type for function " + id);
        }
        return new ArrowTypeNode(parlist, type);
    }

    @Override
    public String codeGeneration() {
        if (MethodCallNode.getMapMetOff().containsKey(id)) {
            t = MethodCallNode.getMapMetOff().get(id);
            if (body instanceof IdNode) {
                m.put(body, t);
            }
            if (body instanceof OpExpNode){
               OpExpNode temp = (OpExpNode)body;
               temp.updateMap(t);
            }
                if (body instanceof OpBExpNode){
               OpBExpNode temp = (OpBExpNode)body;
               temp.updateMap(t);
            }
                    if (body instanceof OpTermNode){
               OpTermNode temp = (OpTermNode)body;
               temp.updateMap(t);
            }
        }
        String declCode = "";
        if (declist != null) {
            for (Node dec : declist) {
                declCode += dec.codeGeneration();
            }
        }

        String popDecl = "";
        if (declist != null) {
            for (Node dec : declist) {
                popDecl += "pop\n";
            }
        }

        String popParl = "";
        for (Node dec : parlist) {
            popParl += "pop\n";
        }

        String funl = FOOLlib.freshFunLabel();
        FOOLlib.putCode(funl + ":\n"
                + "cfp\n"
                + //setta $fp a $sp				
                "lra\n"
                + //inserimento return address
                declCode
                + //inserimento dichiarazioni locali
                body.codeGeneration()
                //      + (body instanceof IdNode ?  

                //          :"")
                + "srv\n"
                + //pop del return value
                popDecl
                + "sra\n"
                //  + // pop del return address
                //"pop\n"
                + // pop di AL
                popParl
                + "sfp\n"
                + // setto $fp a valore del CL
                "lrv\n"
                + // risultato della funzione sullo stack
                "lra\n" + "js\n" // salta a $ra
        );

        if (classID == null) {
            return "push " + funl + "\n";
        } else {
            return funl + "\n";
        }
    }

    public ArrayList<Node> getParams() {
        return parlist;
    }

    public String getId() {
        return id;
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public Node getType() {
        return type;
    }

    @Override
    public boolean isSubTypeOf(Node m) {
        return type.isSubTypeOf(m);
    }

}
