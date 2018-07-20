package ast;

import exception.*;
import java.util.ArrayList;
import util.Environment;
import util.SemanticError;
/**
 *
 * @author francesco
 */
public class FieldCallNode implements Node{
    
    private int objectOffset;
    private int objectNestingLevel;
    private int fieldOffset;
    private int nestinglevel;
    
    private String objectID;
    private String fieldID;
    private Node fieldType;
    
    public FieldCallNode(String callId, String field) {
        this.objectID = callId;
        this.fieldID = field;
    }

    @Override
    public String toPrint(String indent) {
        return indent + this.toString();
    }
    
    @Override
    public String toString() {
        return objectID + "." + fieldID;
    }

    @Override
    public Node typeCheck() {
      if (!(fieldType instanceof ArrowTypeNode ||fieldType instanceof IntTypeNode ||fieldType instanceof BoolTypeNode ||fieldType instanceof ClassTypeNode )  )
	  System.out.println("Wrong usage of field identifier");
        
     return fieldType;
    }   
    
    

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> res = new ArrayList<>();

        this.nestinglevel = env.getNestingLevel();
        ClassTypeNode classType = null;       
            try{
            STentry objectSEntry = env.getLatestEntryOf(objectID);
            Node objectType = objectSEntry.getNode();
            this.objectOffset = objectSEntry.getOffset();
            this.objectNestingLevel = objectSEntry.getNestinglevel();
            this.nestinglevel--;
            // Controllo che il metodo sia stato chiamato su un oggetto
            if (objectType instanceof ClassTypeNode) {
                classType = (ClassTypeNode) objectType;//((ClassTypeNode) objectType).getClassType();
            } else {
                res.add(new SemanticError("Attribute " + fieldID + " called on a non-object type"));
                return res;
            }
            }catch(UndeclaredVarException e){
                res.add(new SemanticError("variable not declared riga 89 fieldcall"));
            }
        
        try {
        STentry classEntry = env.getLatestEntryOf(classType.getId());
        ClassTypeNode objectClass = (ClassTypeNode) classEntry.getNode();
        //serve getTypeOfField in ClassTypeNode
        this.fieldType = objectClass.getTypeOfField(fieldID);
        //L'offset degli attributi è diversa da quella dei metodi
        this.fieldOffset = objectClass.getOffsetOfField(fieldID);
        //} catch (UndeclaredMethodException ex) {
        //    Logger.getLogger(MethodCallNode.class.getName()).log(Level.SEVERE, null, ex);
        }catch(UndeclaredVarException e){
                res.add(new SemanticError("variable not declared riga 104 fieldcall"));
            }
 
        if (this.fieldType == null) {
            res.add(new SemanticError("Object " + objectID + " doesn't have a " + fieldID + " attribute."));
        }

        return res;
    }

    @Override
    public String codeGeneration() {
        
        StringBuilder getAR = new StringBuilder();

        for (int i = 0; i < nestinglevel - objectNestingLevel; i++)
            getAR.append("lw\n");
        
        return "push "  +objectOffset + "\n"         // carico l'offset dell'oggetto nello scope di definizione
                + "lfp\n"                               // carico il frame pointer
                + getAR                                 // faccio gli lw necessari fino a trovarmi sullo stack l'indirizzo in memoria del frame dove e' definito l'oggetto
                + "add\n"                               // faccio $fp + offset per ottenere l'indirizzo in memoria dell'oggetto
                + "lw\n"                                // carico l'indirizzo della dispatch table sullo stack
                + "push " + fieldOffset + "\n"   // carico l'offset del campo rispetto all'inizio della dispatch table
                + "add\n"                   //sommo i due per ottenere l'inidirizzo del campo
                + "lw\n"                          // carico sullo stack  offset oggetto + offset campo;                               // salto all'istruzione dove e' definito il metodo e salvo $ra
               ;
    }

    @Override
    public boolean isSubTypeOf(Node m) {
        return fieldType.isSubTypeOf (m);
    }

    public int getObjectOffset() {
        return objectOffset;
    }

    public int getFieldOffset() {
        return fieldOffset;
    }

    public int getNestinglevel() {return nestinglevel;}

    public int getObjectNestingLevel() {return objectNestingLevel;}
    
}
