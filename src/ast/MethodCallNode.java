package ast;

import exception.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.FOOLlib;
import util.Environment;
import util.SemanticError;
import java.util.HashMap;

/**
 *
 * @author carlo
 */
public class MethodCallNode extends CallNode {

    private int objectNestingLevel;
    private int methodOffset;
    private int nestinglevel;

    private String classId;
    private String objectID;
    private String methodID;
    private Node methodType;
 
    private static HashMap <String, Integer> mapMetOff = new HashMap(); 
    private static int count =0;

    public MethodCallNode(String callId, STentry entry, String objectID, String methodID, ArrayList<Node> args, int nestingLevel) {
        super(callId, entry, args, nestingLevel);
        this.objectID = objectID;
        this.methodID = methodID;
    }

    public MethodCallNode(String obj, String met, ArrayList<Node> args) {
        super(met, args);
        this.objectID = obj;
        this.methodID = met;
    }


    public static HashMap<String, Integer> getMapMetOff() {
        return mapMetOff;
    }

    
    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        mapMetOff.put (methodID, VarNode.getNumDec() - VarNode.getMap().get(this.objectID) + (count++));
        
        ArrayList<SemanticError> res = new ArrayList<>();
        this.nestinglevel = env.getNestingLevel();
        ClassTypeNode classType = null;
        try {
            STentry objectSEntry = env.getLatestEntryOf(objectID);
            Node objectType = objectSEntry.getNode();
            this.objectNestingLevel = objectSEntry.getNestinglevel();

            try {
                env.getLatestEntryOf("this");
                // Se ha trovato il this (aka sono dentro un metodo), decremento il nesting level
                this.nestinglevel--;
            } catch (UndeclaredVarException e) {
            }
            // Controllo che il metodo sia stato chiamato su un oggetto
            if (objectType instanceof ClassTypeNode) {
                classType = (ClassTypeNode) objectType;//((ClassTypeNode) objectType).getClassType();
                classId = classType.getId();
            } else {
                res.add(new SemanticError("Method " + methodID + " called on a non-object type"));
                return res;
            }
        } catch (UndeclaredVarException e) {
            res.add(new SemanticError("variable not declared"));
            return res;
        }

        try {
            STentry classEntry = env.getLatestEntryOf(classType.getId());
            ClassTypeNode objectClass = (ClassTypeNode) classEntry.getNode();
            this.methodType = objectClass.getTypeOfMethod(methodID);
            this.methodOffset = objectClass.getOffsetOfMethod(methodID);
        } catch (UndeclaredMethodException ex) {
            res.add(new SemanticError("Undeclared method " + methodID + " called"));
        } catch (UndeclaredVarException e) {
            res.add(new SemanticError("variable not declared riga in methodCall of" + methodID));
            return res;
        }

        if (this.methodType == null) {
            res.add(new SemanticError("Object " + objectID + " doesn't have a " + methodID + " method."));
            return res;
        }

        ArrowTypeNode t;
        if (this.methodType instanceof VoidTypeNode) {
            t = new ArrowTypeNode(this.getParlist(), new VoidTypeNode());
        } else {
            t = (ArrowTypeNode) this.methodType;
        }

        ArrayList<Node> p = t.getParList();
        if (!(p.size() == getParlist().size())) {
            res.add(new SemanticError("Wrong number of parameters in the invocation of " + methodID));
            return res;
        }

        return res;
    }

    @Override
    public Node typeCheck() throws TypeException {
        ArrowTypeNode t = (ArrowTypeNode) this.methodType;
        ArrayList<Node> p = t.getParList();

        for (int i = 0; i < getParlist().size(); i++) {
            if (!getParlist().get(i).typeCheck().isSubTypeOf(p.get(i))) {
                try {
                    throw new Exception("Wrong type for " + (i + 1) + "-th parameter in the invocation of " + methodID);
                } catch (Exception ex) {
                    Logger.getLogger(MethodCallNode.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return t.getRet();
    }

    @Override
    public String codeGeneration() {
        StringBuilder parCode = new StringBuilder();
        for (int i = getParlist().size() - 1; i >= 0; i--) {
            parCode.append(getParlist().get(i).codeGeneration());
        }

        StringBuilder getAR = new StringBuilder();

        for (int i = 0; i < nestinglevel - objectNestingLevel; i++) {
            getAR.append("lw\n");
        }
        return "lfp\n" // carico il frame pointer
                + parCode // carico i parametri
                + FOOLlib.getDispatchTablePointer(classId) + "\n"
                + "push " + (methodOffset - 1) + "\n" // carico l'offset del metodo rispetto all'inizio della dispatch table
                + "add" + "\n" // carico sullo stack dispatch_table_start + offset
                + "lc\n" // trovo l'indirizzo del metodo
                + "js\n";                               // salto all'istruzione dove e' definito il metodo e salvo $ra
    }

    @Override
    public String toString() {
        return objectID + "." + methodID + "()";
    }

    @Override
    public boolean isSubTypeOf(Node m) {
        return methodType.isSubTypeOf(m);
    }

    @Override
    public String toPrint(String indent) {
        return indent + " methodCall: " + this.toString();
    }

}


