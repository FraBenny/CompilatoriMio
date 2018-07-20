package ast;

public class STentry {

    private int nestingLevel;
    private Node node;
    private int offset;
    private boolean isAttribute;

    public STentry(int nestingLevel, Node Node, int offset) {
        this.nestingLevel = nestingLevel;
        this.node = Node;
        this.offset = offset;
        this.isAttribute = false;
    }

    public STentry(int nestingLevel, Node Node, int offset, boolean isAttribute) {
        this.nestingLevel = nestingLevel;
        this.node = Node;
        this.offset = offset;
        this.isAttribute = isAttribute;
    }

    public void addNode(Node m) {
        node = m;
    }

    public Node getNode() {
        return node;
    }

    public int getOffset() {
        return offset;
    }

    public int getNestinglevel() {
        return nestingLevel;
    }

    public void setNestingLevel(int nestingLevel) {
        this.nestingLevel = nestingLevel;
    }

    // Used only for class attributes
    public boolean isAttribute() {
        return isAttribute;
    }

    public String toString(String s) { //
        return s;
    }
}
