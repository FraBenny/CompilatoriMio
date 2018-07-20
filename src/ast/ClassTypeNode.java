package ast;

import exception.UndeclaredMethodException;
import exception.UndeclaredVarException;
import java.util.ArrayList;
import java.util.HashMap;
import util.DispatchTableEntry;

import util.Environment;
import util.SemanticError;
import util.FOOLlib;

public class ClassTypeNode implements Node {
  
  private String classId = "";
  private ClassTypeNode superType = null;
  
  private ArrayList<VarNode> fields = new ArrayList<>();
  private ArrayList<FunNode> methods = new ArrayList<>();

  public ClassTypeNode(String classID, ClassTypeNode superType, ArrayList<VarNode> fields, ArrayList<FunNode> methods) {
        this.classId = classID;
        this.superType = superType;
        this.fields = fields;
        this.methods = methods;
  }

  
  public ClassTypeNode (String i) {
    classId=i;
    fields=null;
    methods=null;
  }  

    public String getId() {
        return classId;
    }
  
  @Override
	public ArrayList<SemanticError> checkSemantics(Environment env) {
        
        return new ArrayList<SemanticError>();
	}
  
  public String toPrint(String s) {
	
        return s+" ClassType: "+classId;
  }
  
  
  public Node typeCheck () {
    return this;
  }
  
  public String codeGeneration() {
      
        return "";
  }  
    
  public ArrayList<VarNode> getFields() {
        return fields;
    }

    public ClassTypeNode getSuperType() {
        return superType;
    }
  
  

    public HashMap<String, Node> getFieldsMap() {
        HashMap<String, Node> fieldsMap = new HashMap<>();
        if(superType != null) {
            HashMap<String, Node> superFieldsMap = superType.getFieldsMap();
            for (String m : superFieldsMap.keySet())
                fieldsMap.put(m, superFieldsMap.get(m));
        }
        for (VarNode f : fields) {
            fieldsMap.put(f.getId(), f.getType());
        }
        return fieldsMap;
    }
    
     public Node getTypeOfField(String id) {
        return this.getFieldsMap().get(id);
    }

    public ArrayList<FunNode> getMethods() {
        return methods;
    }

    /*
        Returns an HashMap of all methods defined in this class or any subclass
     */
    public HashMap<String, ArrowTypeNode> getMethodsMap() {
        HashMap<String, ArrowTypeNode> methodsMap = new HashMap<>();
        if(superType != null) {
            HashMap<String, ArrowTypeNode> superMethodsMap = superType.getMethodsMap();
            for (String m : superMethodsMap.keySet())
                methodsMap.put(m, superMethodsMap.get(m));
        }
        for (FunNode m : methods) {
            methodsMap.put(m.getId(), (ArrowTypeNode) m.getType());
        }
        return methodsMap;
    }

    public int getOffsetOfMethod(String methodID) throws UndeclaredMethodException {
        HashMap<String, Integer> methodsMap = methodsMapFromSuper();
        Integer offset = methodsMap.get(methodID);
        if (offset != null) {
            return offset+1;
        } else {
            throw new UndeclaredMethodException(methodID);
        }
    }
    
    public int getOffsetOfField(String fieldID) throws UndeclaredVarException {
        HashMap<String, Integer> fieldsMap = fieldsMapFromSuper();
        Integer offset = fieldsMap.get(fieldID);
        if (offset != null) {
            return offset + 1;
        } else {
            throw new UndeclaredVarException(fieldID);
        }
    }

    public HashMap<String, Integer> methodsMapFromSuper() {
        if (superType == null) {
            HashMap<String, Integer> methodsMap = new HashMap<>();
            for (FunNode method : methods) {
                methodsMap.put(method.getId(), methodsMap.size());
            }
            return methodsMap;
        } else {
            HashMap<String, Integer> superMethodsMap = superType.methodsMapFromSuper();
            for (FunNode method : methods) {
                if (!superMethodsMap.containsKey(method.getId())) {
                    superMethodsMap.put(method.getId(), superMethodsMap.size());
                }
            }
            return superMethodsMap;
        }
    }
    
    public HashMap<String, Integer> fieldsMapFromSuper() {
        if (superType == null) {
            HashMap<String, Integer> fieldMap = new HashMap<>();
            for (VarNode field : fields) {
                fieldMap.put(field.getId(), fieldMap.size());
            }
            return fieldMap;
        } else {
            HashMap<String, Integer> superMethodsMap = superType.fieldsMapFromSuper();
            for (VarNode field : fields) {
                if (!superMethodsMap.containsKey(field.getId())) {
                    superMethodsMap.put(field.getId(), superMethodsMap.size());
                }
            }
            return superMethodsMap;
        }
    }

    public Node getTypeOfMethod(String id) {
        FunNode method = this.methods
                .stream()
                .filter(m -> m.getId().equals(id))
                .reduce(null, (prev, curr) -> curr);
        if (method != null) {
            return method.getType();
        } else if (superType != null) {
            return superType.getTypeOfMethod(id);
        } else {
            return new VoidTypeNode();
        }
    }

    public boolean isSubTypeOf(Node t2) {
        // Procedo solo se l'altro tipo e' una classe
        
        if (t2 instanceof ClassTypeNode) {
            ClassTypeNode ct2 = (ClassTypeNode) t2;
            // Se e' della stessa classe
            if (this.classId.equals(ct2.classId)) {
                return true;
            }
            // Procedo solo se la mia classe ha un supertipo
            if (this.superType != null) {
                return this.superType.equals(ct2) || superType.isSubTypeOf(t2);
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "class " + classId;
    }

}  