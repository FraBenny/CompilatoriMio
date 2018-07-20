package ast;

import exception.*;
import util.SemanticError;
import org.antlr.v4.runtime.ParserRuleContext;
import util.Environment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;

public class ProgClassExpNode implements Node {

    private ArrayList<ClassdNode> classDeclarations;
    private Node p;

    public ProgClassExpNode(ParserRuleContext ctx, ArrayList<ClassdNode> classDeclaration, Node ps) {
        this.classDeclarations = classDeclaration;
        this.p=ps;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> res = new ArrayList<>();

        env.pushHashMap();

        // preliminary class inserting in symbol table for order independent references

        for (ClassdNode classNode : classDeclarations) {
            try {
                ArrayList<VarNode> fields = new ArrayList<VarNode>();
                for (VarNode field : classNode.getVardeclist()) {
                    fields.add(new VarNode(field.getId(), field.getType(), null));
                }
                ArrayList<FunNode> methods = new ArrayList<FunNode>();
                for (FunNode method : classNode.getFunDecList()) {
                    ArrayList<Node> paramsType = new ArrayList<>();
                    for (Node parameter : method.getParams()) {
                        VarNode param = (VarNode)parameter;
                        paramsType.add(param.getType());
                    }
                    methods.add(new FunNode(method.getId(), new ArrowTypeNode(paramsType, method.getType())));
                }
                ClassTypeNode classType = new ClassTypeNode(classNode.getClassID(), new ClassTypeNode(classNode.getSuperClassID()), fields, methods);
                env.addEntry(classNode.getClassID(), classType, 0);
            } catch (RedeclaredVarException e) {
                res.add(new SemanticError("Class '" + classNode.getClassID() + "' declared multiple times"));
            }
        }

        for (ClassdNode classNode : classDeclarations) {
            res.addAll(classNode.checkSemantics(env));
        }

        res.addAll(p.checkSemantics(env));

        env.popHashMap();

        return res;
    }

    
    public Node typeCheck() throws TypeException {
        for (ClassdNode classdec : classDeclarations) {
            classdec.typeCheck();
        }
        return p.typeCheck();
    }

    
    @Override
    public String codeGeneration() {
        String declaration = "";
        ArrayList<ClassdNode> orderClassDeclarations = new ArrayList<>();
        HashMap<String, ClassdNode> classesAddedMap = new HashMap<>();

        // this two loops are for order class declaration in top-down order to generate correct code and dispatch tables
        ListIterator iterator = classDeclarations.listIterator();
        while(iterator.hasNext()){
            ClassdNode classDec = (ClassdNode) iterator.next();
            if (classDec.getSuperClassID() == null || classDec.getSuperClassID().isEmpty()){
                orderClassDeclarations.add(classDec);
                classesAddedMap.put(classDec.getClassID(), classDec);
                iterator.remove();
            }
        }

        while (!classDeclarations.isEmpty()) {
            iterator = classDeclarations.listIterator();
            while(iterator.hasNext()){
                ClassdNode childClassDec = (ClassdNode) iterator.next();
                String fatherClassName = childClassDec.getSuperClassID();
                ClassdNode fatherClassDec = classesAddedMap.get(fatherClassName);
                if (fatherClassDec != null){
                    orderClassDeclarations.add(childClassDec);
                    classesAddedMap.put(childClassDec.getClassID(), childClassDec);
                    iterator.remove();
                }
            }
        }

        for (ClassdNode cl : orderClassDeclarations) {
            declaration += cl.codeGeneration();
        }

        return declaration + p.codeGeneration();
    }

    public ArrayList<Node> getChilds() {
        ArrayList<Node> childs = new ArrayList<>();
        childs.addAll(classDeclarations);

        childs.add(p);
        return childs;
    }

    @Override
    public String toPrint(String s) {
        String ss="";
        for(Node n : classDeclarations)
            ss= n.toPrint(ss);
        return  s + "\n" + ss;
    }
    
    @Override
      public boolean isSubTypeOf(Node m){
        return p.isSubTypeOf(m);
    } 
    
}
