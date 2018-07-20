package ast;

import exception.TypeException;
import java.util.ArrayList;
import util.FOOLlib;
import util.Environment;
import util.SemanticError;

/**
 *
 * @author carlo
 */
public class ConfNode implements Node {
  
  private String op;
  private Node left;
  private Node right;
  
  public ConfNode (Node l, Node r, String s) {
    op=s;
    left=l;
    right=r;
  }
  
 public String toPrint(String s) {
    return s+"Conf \n" + left.toPrint(s+"  ") + op   
                       + right.toPrint(s+"  ") ; 
 }
  
public ArrayList<SemanticError> checkSemantics(Environment env) {
	  //create the result
	  ArrayList<SemanticError> res = new ArrayList<SemanticError>();
	  
	  //check semantics in the left and in the right exp
	  
	  res.addAll(left.checkSemantics(env));
	  res.addAll(right.checkSemantics(env));
	  
	  return res;
	}
  
  public Node typeCheck()throws TypeException {
    Node l = left.typeCheck();
    Node r = right.typeCheck();
    if (! ( l.isSubTypeOf(r) || r.isSubTypeOf(l) ) ) {
      throw new TypeException("Incompatible types in Confrontation");
    }
    return new BoolTypeNode();
  }  
  
  public String codeGeneration() {
      String l1 = FOOLlib.freshLabel(); 
      String l2 = FOOLlib.freshLabel();
      String l=left.codeGeneration();
      String r=right.codeGeneration();
        String op2= "";
          switch(op){
              case ">=":
                op2= r+l+
                "bleq " + l1 + "\n" +
                "push 0\n" +
                "b " + l2 + "\n" +
                l1 + ":\n" +
                "push 1\n" +
                l2 + ":\n";
                break;
               case ">":
                op2=r+
                "push 1\n" +
                "add\n" +
                l +
                "bleq " + l1 + "\n" +
                "push 0\n" +
                "b " + l2 + "\n" +
                l1 + ":\n" +
                "push 1\n" +
                l2 + ":\n";
                break;
               case "<=":
                op2=l+r +
                "bleq " + l1 + "\n" +
                "push 0\n" +
                "b " + l2 + "\n" +
                l1 + ":\n" +
                "push 1\n" +
                l2 + ":\n";;
                break;
               case "<":
                op2=l +
                "push 1\n" +
                "add\n" +
                r +
                "bleq " + l1 + "\n" +
                "push 0\n" +
                "b " + l2 + "\n" +
                l1 + ":\n" +
                "push 1\n" +
                l2 + ":\n";
                break;
                     
          }
	  
	  return op2;
		       
  }
 
  public boolean isSubTypeOf(Node m){
      if(m instanceof BoolTypeNode)
          return true;
      else
          return false;
  }
  
}
