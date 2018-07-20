package ast;

import exception.TypeException;
import java.util.ArrayList;
import util.Environment;
import util.SemanticError;

/**
 *
 * @author carlo
 */
public class FieldAsmNode implements Node {
    
  private FieldCallNode field;
  private Node exp;
  
  public FieldAsmNode (FieldCallNode t, Node v) {
    field=t;
    exp=v;
  }
  
@Override
public ArrayList<SemanticError> checkSemantics(Environment env) {
    //create result list
    ArrayList<SemanticError> res = new ArrayList<>();

    res.addAll(field.checkSemantics(env));
    
    res.addAll(exp.checkSemantics(env));

    return res;
}
  
  @Override
  public String toPrint(String s) {
	return s+"Field assignment:" + field.toPrint(s+"  ") +"\n"  
           +exp.toPrint(s+"  "); 
  }
  
  
  @Override
  public Node typeCheck () throws TypeException{
    if (! (exp.typeCheck().isSubTypeOf(field.typeCheck())) ){
      throw new TypeException("incompatible value for field "+field.toPrint(" "));
    }     
    return field.typeCheck();
  }
  
  @Override
  public String codeGeneration() {
        StringBuilder getAR = new StringBuilder();
        
        for (int i = 0; i < field.getNestinglevel() - field.getObjectNestingLevel(); i++)
            getAR.append("lw\n");
        
        String expCode= exp.codeGeneration();
        return expCode+
                "push "  +field.getObjectOffset() + "\n"         // carico l'offset dell'oggetto nello scope di definizione
                + "lfp\n"                               // carico il frame pointer
                + getAR                                 // faccio gli lw necessari fino a trovarmi sullo stack l'indirizzo in memoria del frame dove e' definito l'oggetto
                + "add\n"                               // faccio $fp + offset per ottenere l'indirizzo in memoria dell'oggetto
                + "lw\n"                                // carico l'indirizzo della dispatch table sullo stack
                + "push " + field.getFieldOffset() + "\n"   // carico l'offset del campo rispetto all'inizio della dispatch table
                + "add\n"+"sw\n"
               ;
  }  
  
  @Override
  public boolean isSubTypeOf(Node m){
      return field.isSubTypeOf(m);
  }
    
}  
