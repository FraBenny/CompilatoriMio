package ast;

import exception.TypeException;
import java.util.ArrayList;
import util.FOOLlib;
import util.Environment;
import util.SemanticError;

public class ProgLetInNode implements Node {

    private ArrayList<Node> declist;
    private Node exp;

    public ProgLetInNode(ArrayList<Node> d, Node e) {
        declist = d;
        exp = e;
    }

    @Override
    public String toPrint(String s) {
        String declstr = "";
        for (Node dec : declist) {
            declstr += dec.toPrint(s + "  ");
        }
        return s + "Let \n" + declstr + "In \n" + exp.toPrint(s + "  ");
    }

    @Override

    public ArrayList<SemanticError> checkSemantics(Environment env) {

        ArrayList<SemanticError> res = new ArrayList<>();

        env.pushHashMap();
        if (declist.size() > 0) {
            env.offset = -2;
            for (Node n : declist) {
                res.addAll(n.checkSemantics(env));
            }
        }

        res.addAll(exp.checkSemantics(env));
        env.popHashMap();
        return res;
    }

    @Override
    public Node typeCheck() throws TypeException {
        for (Node dec : declist) {
            dec.typeCheck();
        }

        return exp.typeCheck();
    }

    @Override
    public String codeGeneration() {
        String declCode = "";
        for (Node dec : declist) {
            declCode += dec.codeGeneration();
        }
        return "push 0\n"
                + declCode
                + exp.codeGeneration() + "halt\n"
                + FOOLlib.getCode();
    }

    @Override
    public boolean isSubTypeOf(Node m) {
        return exp.isSubTypeOf(m);
    }

}
