package ast;

import exception.TypeException;
import java.util.ArrayList;

import util.Environment;
import util.SemanticError;

public class PrintNode implements Node {

  private Node val;
  
  public PrintNode (Node v) {
    val=v;
  }
  
  public String toPrint(String s) {
    return s+"Print\n" + val.toPrint(s+"  ") ;
  }
  
  public Node typeCheck() throws TypeException {
    return val.typeCheck();
  }  
  
  @Override
 	public ArrayList<SemanticError> checkSemantics(Environment env) {
 	  return val.checkSemantics(env);
 	}
  
  public String codeGeneration() {
		return val.codeGeneration()+"print\n";
  }
    
    public boolean isSubTypeOf(Node m){
        return val.isSubTypeOf(m);
    } 
  
}  