package ast;

import exception.TypeException;
import java.util.ArrayList;

import util.Environment;
import util.SemanticError;

public class VoidTypeNode implements Node {
  
  public VoidTypeNode () {
  }
  
  public String toPrint(String s) {
	return s+"VoidType\n";  
  }
  
  //non utilizzato
  public Node typeCheck() throws TypeException{
    return this;
  }

  //non utilizzato
  public String codeGeneration() {
		return "";
  }
  
  @Override
	public ArrayList<SemanticError> checkSemantics(Environment env) {

	  return new ArrayList<SemanticError>();
	}
  
  public boolean isSubTypeOf(Node m){
      if(m instanceof ArrowTypeNode)
          return this.isSubTypeOf(((ArrowTypeNode) m).getRet());
      else
        if(m instanceof ClassTypeNode)
            return true;
        else
            return false;
  }      
        
}  