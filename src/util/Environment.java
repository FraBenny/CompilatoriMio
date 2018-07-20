package util;

import java.util.ArrayList;
import java.util.HashMap;
import ast.*;
import exception.*;

import java.util.ListIterator;

public class Environment {

    public int offset = 0;
    protected ArrayList<HashMap<String, STentry>> symbolTable = new ArrayList<>();
    private STentry latestClassEntry = null;

    public Environment() {

    }

    public int getNestingLevel() {
        return this.symbolTable.size() - 1;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
    
    public Environment pushHashMap() {
        this.symbolTable.add(new HashMap<>());
        return this;
    }

    public Environment popHashMap() {
        this.symbolTable.remove(this.symbolTable.size() - 1);
        return this;
    }

    public HashMap<String, STentry> getHashMap(int i) {
        return symbolTable.get(i);
    }
    

    public Environment addEntry(String id, Node Node, int offset) throws RedeclaredVarException {
        STentry newEntry = new STentry(getNestingLevel(), Node, offset);
        STentry oldEntry = this.symbolTable
                .get(this.symbolTable.size() - 1)
                .put(id, newEntry);
        if (Node instanceof ClassTypeNode) {
            latestClassEntry = newEntry;
        }
        
        if (oldEntry != null) {
            throw new RedeclaredVarException(id);
        }
        return this;
    }

    public Environment addEntry(String id, Node Node, int offset, boolean isInsideClass) throws RedeclaredVarException {
      // if (!isInsideClass)
      //  System.out.println ("eeeeeeee " + id);
        STentry newEntry = new STentry(getNestingLevel(), Node, offset, isInsideClass);
        STentry oldEntry = this.symbolTable
                .get(this.symbolTable.size() - 1)
                .put(id, newEntry);
        if (Node instanceof ClassTypeNode) {
            latestClassEntry = newEntry;
        }
        if (oldEntry != null) {
            throw new RedeclaredVarException(id);
        }
        return this;
    }

    public Environment setEntryNode(String id, Node newNode, int offset) throws UndeclaredClassException {
        STentry newEntry = new STentry(getNestingLevel(), newNode, offset);
        STentry oldEntry = this.symbolTable.get(this.symbolTable.size() - 1).replace(id, newEntry);
        if (newNode instanceof ClassTypeNode) {
            latestClassEntry = newEntry;
        }
        if (oldEntry == null) {
            throw   new UndeclaredClassException(id);
        }
        return this;
    }

    public STentry getLatestEntryOf(String id) throws UndeclaredVarException {
        ListIterator<HashMap<String, STentry>> li = symbolTable.listIterator(symbolTable.size());
        while (li.hasPrevious()) {
            HashMap<String, STentry> current = li.previous();
            if (current.containsKey(id)) {
                return current.get(id);
            }
        }
        throw new UndeclaredVarException(id);
    }

    public STentry getLatestEntryOfNotFun(String id) throws UndeclaredVarException {
        ListIterator<HashMap<String, STentry>> li = symbolTable.listIterator(symbolTable.size());
        while (li.hasPrevious()) {
            HashMap<String, STentry> current = li.previous();
            if (current.containsKey(id) && !(current.get(id).getNode() instanceof FunNode)) {
                return current.get(id);
            }
        }
        throw new UndeclaredVarException(id);
    }

    public STentry getLatestClassEntry() throws UndeclaredVarException {
        if (latestClassEntry == null) {
            throw new UndeclaredVarException("symbol table not initialized");
        } else {
            return latestClassEntry;
        }
    }

    public Node getNodeOf(String id) throws UndeclaredVarException {
        return this.getLatestEntryOf(id).getNode();
    }   

}
