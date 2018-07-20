package ast;

import exception.TypeException;
import java.util.ArrayList;

import util.Environment;
import util.SemanticError;
import util.FOOLlib;

public class IfNode implements Node {

  private Node cond;
  private Node th;
  private Node el;
  
  public IfNode (Node c, Node t, Node e) {
    cond=c;
    th=t;
    el=e;
  }
  
  @Override
  public String toPrint(String s) {
    return s  +"If\n" + cond.toPrint(s+"  ") 
                    + th.toPrint(s+"  ")   
                    + el.toPrint(s+"  "); 
  }
  
  
  @Override
	public ArrayList<SemanticError> checkSemantics(Environment env) {
	  //create the result
	  ArrayList<SemanticError> res = new ArrayList<SemanticError>();
	  
	  //check semantics in the condition
	  res.addAll(cond.checkSemantics(env));
	 	  
	  //check semantics in the then and in the else exp
          
	  res.addAll(th.checkSemantics(env));
	  res.addAll(el.checkSemantics(env));
	  
	  return res;
	}
  
  
  public Node typeCheck() throws TypeException{
    if (!(cond.typeCheck() instanceof BoolTypeNode)) {
      throw new TypeException("Non boolean condition in if");
    }
    Node t = th.typeCheck();
    Node e = el.typeCheck();
    if (t.isSubTypeOf(e)) 
      return e;
    if (e.isSubTypeOf(t))
      return t;
    throw new TypeException("Incompatible types in then else branches");
  }
  
  public String codeGeneration() {
	  String l1 = FOOLlib.freshLabel(); 
	  String l2 = FOOLlib.freshLabel();
	  return cond.codeGeneration()+//mette sulla pila il risultato dell'espressiione
			 "push 1\n"+
			 "beq "+ l1 +"\n"+			  
			 el.codeGeneration()+
			 "b " + l2 + "\n" +
			 l1 + ":\n"+
			 th.codeGeneration()+
	         l2 + ":\n"; 
  }
  
  public boolean isSubTypeOf(Node m){
      if(th.isSubTypeOf(m) && el.isSubTypeOf(m))
          return true;
      else
          return false;
  }
  
}  