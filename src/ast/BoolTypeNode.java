package ast;

import java.util.ArrayList;

import util.Environment;
import util.SemanticError;

public class BoolTypeNode implements Node {
  
  public BoolTypeNode () {
  }
  
  public String toPrint(String s) {
	return s+"BoolType\n";  
  }
    
  //non utilizzato
  public Node typeCheck() {
    return this;
  }
  
  @Override
 	public ArrayList<SemanticError> checkSemantics(Environment env) {

 	  return new ArrayList<SemanticError>();
 	}
  
  //non utilizzato
  public String codeGeneration() {
		return "";
  }

  public boolean isSubTypeOf(Node m){
      if(m instanceof ArrowTypeNode)
          return this.isSubTypeOf(((ArrowTypeNode) m).getRet());
      else
        return (m instanceof BoolNode || m instanceof BoolTypeNode );
      
  }
    
}  