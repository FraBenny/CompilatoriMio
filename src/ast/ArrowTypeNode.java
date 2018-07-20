package ast;
import java.util.ArrayList;

import util.Environment;
import util.SemanticError;

public class ArrowTypeNode implements Node {

  private ArrayList<Node> parlist; 
  private Node ret;
  
  public ArrowTypeNode (ArrayList<Node> p, Node r) {
    parlist=p;
    ret=r;
  }
    
  public String toPrint(String s) { //
	String parlstr="";
    for (Node par:parlist)
      parlstr+=par.toPrint("  ");
	return s+"ArrowType\n" + parlstr + ret.toPrint(s+"  ->") ; 
  }
  
  public Node getRet () { 
    return ret;
  }
  
  public ArrayList<Node> getParList () { 
    return parlist;
  }

  @Override
	public ArrayList<SemanticError> checkSemantics(Environment env) {
	
		return new ArrayList<SemanticError>();
	}
  
  public Node typeCheck (){
    return this;
  }


  public String codeGeneration() {
		return "";
  }
  
  public boolean isSubTypeOf(Node t){
  if (t instanceof ArrowTypeNode) {
            ArrowTypeNode ArrowTypeNode = (ArrowTypeNode) t;
            boolean check = true;

            //Se hanno lo stesso numero di parametri
            if (this.parlist.size() == ArrowTypeNode.getParList().size()) {
                //Controllo che tutti i parametri abbiano lo stesso tipo(supertype, come da cosegna)
                for (int i = 0; i < this.parlist.size(); i++) {
                    check &= ArrowTypeNode.getParList().get(i).isSubTypeOf(this.parlist.get(i));
                }

                //Controllo che anche il valore di ritorno della funzione
                check &= this.ret.isSubTypeOf(ArrowTypeNode.ret);
            } else {
                check = false;
            }
            return check;
        } else {
            return ret.isSubTypeOf(t);
        }
  
  }

}  