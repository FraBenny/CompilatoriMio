package ast;

import exception.TypeException;
import java.util.ArrayList;
import util.FOOLlib;
import util.Environment;
import util.SemanticError;

/**
 *
 * @author carlo
 */
public class OpBExpNode implements Node {

    private Node left;
    private Node right;
    private String op;

    public OpBExpNode(Node l, Node r, String ops) {
        left = l;
        right = r;
        op = ops;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> res = new ArrayList<>();
        res.addAll(left.checkSemantics(env));
        if (right != null) {
            res.addAll(right.checkSemantics(env));
        }
        return res;
    }

    @Override
    public String toPrint(String s) {
        String ss = "";
        if (right != null) {
            ss = right.toPrint(s + "  ");
        }
        return s + "OpBExp\n" + left.toPrint(s + "  ") + op
                + ss;
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

    @Override
    public Node typeCheck() throws TypeException {
        if (right != null) {
            if ((left.typeCheck() instanceof IntTypeNode || left.typeCheck() instanceof IntNode)
                    && (right.typeCheck() instanceof IntTypeNode || right.typeCheck() instanceof IntNode)) {
                throw new TypeException("Integers in Boolean Operation");
            }
        } else if (left.typeCheck() instanceof IntTypeNode || left.typeCheck() instanceof IntNode) {
            throw new TypeException("Integers in Boolean Operation");
        }
        return new BoolTypeNode();
    }

    @Override
    public String codeGeneration() {
        String l = left.codeGeneration();
        String r = "";
        if (right != null) {
            right.codeGeneration();
        }
        String operation = "";
        String l1 = FOOLlib.freshLabel();
        String l2 = FOOLlib.freshLabel();
        switch (this.op) {
            case "&&":
                String l3 = FOOLlib.freshLabel();
                operation = ""
                        + "beq " + l1 + "\n"
                        + "push 0\n"
                        + "b " + l2 + "\n"
                        + l1 + ":\n"
                        + l
                        + "push 1\n"
                        + "beq " + l3 + "\n"
                        + "push 0\n"
                        + "b " + l2 + "\n"
                        + l3 + ":\n"
                        + "push 1\n"
                        + l2 + ":\n";
                break;
            case "||":
                operation = l
                        + "push 1\n"
                        + "beq " + l1 + "\n"
                        + r
                        + "push 1\n"
                        + "beq " + l1 + "\n"
                        + "push 0\n"
                        + "b " + l2 + "\n"
                        + l1 + ":\n"
                        + "push 1\n"
                        + l2 + ":\n";
                break;
            case "not":
                operation
                        = l + "push 1\n"
                        + "beq " + l1 + "\n"
                        + "push 1\n"
                        + "b " + l2 + "\n"
                        + l1 + ":\n"
                        + "push 0\n" + l2 + ":\n";
        }
        return operation;
    }

    @Override
    public boolean isSubTypeOf(Node m) {
        if (right != null) {
            return left.isSubTypeOf(m) && right.isSubTypeOf(m);
        } else {
            return left.isSubTypeOf(m);
        }
    }

}
