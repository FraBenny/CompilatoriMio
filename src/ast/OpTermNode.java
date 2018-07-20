package ast;

import exception.TypeException;
import java.util.ArrayList;
import util.Environment;
import util.SemanticError;

public class OpTermNode implements Node {

    private Node left;
    private Node right;
    private String op;

    public OpTermNode(Node l, Node r, String ops) {
        left = l;
        right = r;
        op = ops;
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
            case "/":
                operation = "div\n";
                break;
            case "*":
                operation = "mult\n";
                break;
        }
        return operation;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        //create the result
        ArrayList<SemanticError> res = new ArrayList<>();

        //check semantics in the left and in the right exp
        res.addAll(left.checkSemantics(env));
        res.addAll(right.checkSemantics(env));

        return res;
    }

    @Override
    public String toPrint(String s) {
        switch (op) {
            case "/":
                return s + "Division of: \n" + left.toPrint(s + "  ")
                        + right.toPrint(s + "  ");

            case "*":
                return s + "Multiplication of: \n" + left.toPrint(s + "  ")
                        + right.toPrint(s + "  ");

            default:
                return "Operazione sbagliata";
        }
    }

    @Override
    public Node typeCheck() throws TypeException {
        if (!(left.typeCheck() instanceof IntTypeNode || left.typeCheck() instanceof IntNode)
                && (right.typeCheck() instanceof IntTypeNode || right.typeCheck() instanceof IntNode)) {
            throw new TypeException("Non integers term operations");
        }
        return new IntTypeNode();
    }

    @Override
    public String codeGeneration() {
      String operation = this.getOperation();
        String ret= left.codeGeneration();
        if (right instanceof OpTermNode){         
            OpTermNode temp = (OpTermNode)right;
            ret += temp.getLeft().codeGeneration() +  operation + temp.getRight().codeGeneration() + temp.getOperation();
        }
        else ret += right.codeGeneration()+  operation ;
        return ret ;
    }

    @Override
    public boolean isSubTypeOf(Node m) {
        return m instanceof IntTypeNode;
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
}
