package ast;

import java.util.ArrayList;
import util.Environment;
import util.SemanticError;

public class IntTypeNode implements Node {

    public IntTypeNode() {
    }

    @Override
    public String toPrint(String s) {
        return s + "IntType\n";
    }

    //non utilizzato
    @Override
    public Node typeCheck() {
        return this;
    }

    //non utilizzato
    @Override
    public String codeGeneration() {
        return "";
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        return new ArrayList<>();
    }

    @Override
    public boolean isSubTypeOf(Node m) {
        if (m instanceof ArrowTypeNode) {
            return this.isSubTypeOf(((ArrowTypeNode) m).getRet());
        } else {
            return (m instanceof IntTypeNode || m instanceof IntNode);
        }

    }

}
