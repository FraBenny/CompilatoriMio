package ast;

import exception.TypeException;
import java.util.ArrayList;
import util.Environment;
import util.SemanticError;

public class OpExpNode implements Node {

    private Node left;
    private Node right;
    private String op;

    public OpExpNode(Node l, Node r, String ops) {
        left = l;
        right = r;
        op = ops;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> res = new ArrayList<>();
        res.addAll(left.checkSemantics(env));
        res.addAll(right.checkSemantics(env));

        return res;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public String getOperation() {
        String operation = "";        
        switch (op) {
            case "-":
                operation = "sub\n";
                break;
            case "+":
                operation = "add\n";
                break;
        }
        return operation;
    }
    
    
    
    @Override
    public String toPrint(String s) {
        switch (op) {
            case "+":
                return s + "Addition of: \n" + left.toPrint(s + "  ")
                        + right.toPrint(s + "  ");

            case "-":
                return s + "Subtraction of: \n" + left.toPrint(s + "  ")
                        + right.toPrint(s + "  ");
            default:
                return "Operazione sbagliata";
        }
    }

    public void updateMap(int t) {
        if (left instanceof IdNode) {
            FunNode.m.put(left, t);
        }
        if (right instanceof IdNode) {
            FunNode.m.put(right, t);
        }
        if (left instanceof OpBExpNode) {
            OpBExpNode temp = (OpBExpNode) left;
            temp.updateMap(t);
        }
        if (right instanceof OpBExpNode) {
            OpBExpNode temp = (OpBExpNode) right;
            temp.updateMap(t);
        }
        if (left instanceof OpExpNode) {
            OpExpNode temp = (OpExpNode) left;
            temp.updateMap(t);
        }
        if (right instanceof OpExpNode) {
            OpExpNode temp = (OpExpNode) right;
            temp.updateMap(t);
        }
        if (left instanceof OpTermNode) {
            OpTermNode temp = (OpTermNode) left;
            temp.updateMap(t);
        }
        if (right instanceof OpTermNode) {
            OpTermNode temp = (OpTermNode) right;
            temp.updateMap(t);
        }
    }
    
    //public is

    @Override
    public Node typeCheck() throws TypeException {
        if (!(left.typeCheck() instanceof IntTypeNode || left.typeCheck() instanceof IntNode)
                && (right.typeCheck() instanceof IntTypeNode || right.typeCheck() instanceof IntNode)) {
            throw new TypeException("Non integers in integer Operation");
        }
        return new IntTypeNode();
    }

    @Override
    public String codeGeneration() {
        String operation = this.getOperation();
        String ret= left.codeGeneration();
        if (right instanceof OpExpNode){
            
            OpExpNode temp = (OpExpNode)right;
            ret += temp.getLeft().codeGeneration() +  operation + temp.getRight().codeGeneration() + temp.getOperation();
        }
        else ret += right.codeGeneration()+  operation ;
        return ret ;
    }

    @Override
    public boolean isSubTypeOf(Node m) {
        return left.isSubTypeOf(m) && right.isSubTypeOf(m);
    }

}
