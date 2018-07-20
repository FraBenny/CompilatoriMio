package ast;

import java.util.ArrayList;
import util.Environment;
import util.SemanticError;

public class IntNode implements Node {

    private Integer val;

    public IntNode(Integer n) {
        val = n;
    }

    @Override
    public String toPrint(String s) {
        return s + "Int:" + Integer.toString(val) + "\n";
    }

    @Override
    public Node typeCheck() {
        return new IntTypeNode();
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        return new ArrayList<>();
    }

    @Override
    public String codeGeneration() {
        return "push " + val + "\n";
    }

    @Override
    public boolean isSubTypeOf(Node m) {
        return (m instanceof IntNode || m instanceof IntTypeNode);
    }

}
