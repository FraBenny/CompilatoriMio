package ast;

import exception.TypeException;
import java.util.ArrayList;

import util.Environment;
import util.SemanticError;

public interface Node {
   
  String toPrint(String indent);

  //fa il type checking e ritorna: 
  //  per una espressione, il suo tipo (oggetto BoolTypeNode o IntTypeNode)
  //  per una dichiarazione, "null"
  Node typeCheck() throws TypeException;
  
  String codeGeneration();
  
  ArrayList<SemanticError> checkSemantics(Environment env);
  
  public boolean isSubTypeOf(Node m);
  
}  