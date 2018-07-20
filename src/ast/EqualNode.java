package ast;

import exception.TypeException;
import java.util.ArrayList;

import util.Environment;
import util.SemanticError;
import util.FOOLlib;

public class EqualNode implements Node{
    
  private Node left;
  private Node right;
  
  public EqualNode (Node l, Node r) {
    super();
    left=l;
    right=r;
  }
  
  public String toPrint(String s) {
    return s+"Equal\n" + left.toPrint(s+"  ")   
                       + right.toPrint(s+"  ") ; 
  }
  
  @Override
	public ArrayList<SemanticError> checkSemantics(Environment env) {
	  //create the result
	  ArrayList<SemanticError> res = new ArrayList<SemanticError>();
	  
	  //check semantics in the left and in the right exp
	  
	  res.addAll(left.checkSemantics(env));
	  res.addAll(right.checkSemantics(env));
	  
	  return res;
	}
  
  public Node typeCheck() throws TypeException {
    Node l = left.typeCheck();
    Node r = right.typeCheck();
    if (! ( l.isSubTypeOf(r) || r.isSubTypeOf(l)) ) {
      throw new TypeException("Incompatible types in equal");
    }
    return new BoolTypeNode();
  }  
  
  public String codeGeneration() {
	  String l1 = FOOLlib.freshLabel(); 
	  String l2 = FOOLlib.freshLabel();
	  return left.codeGeneration()+
			   right.codeGeneration()+
			   "beq "+ l1 +"\n"+
			   "push 0\n"+
			   "b " + l2 + "\n" +
			   l1 + ":\n"+
			   "push 1\n" +
			   l2 + ":\n";
		       
  }
  
  public boolean isSubTypeOf(Node m){
    if(left.isSubTypeOf(right) || right.isSubTypeOf(left))
        return true;
    else
        return false;
  }
  
}  