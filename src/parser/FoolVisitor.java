// Generated from Fool.g4 by ANTLR 4.7.1

package parser;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FoolParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FoolVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code singleExp}
	 * labeled alternative in {@link FoolParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleExp(FoolParser.SingleExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code letInExp}
	 * labeled alternative in {@link FoolParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetInExp(FoolParser.LetInExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code classExp}
	 * labeled alternative in {@link FoolParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassExp(FoolParser.ClassExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link FoolParser#classd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassd(FoolParser.ClassdContext ctx);
	/**
	 * Visit a parse tree produced by {@link FoolParser#let}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLet(FoolParser.LetContext ctx);
	/**
	 * Visit a parse tree produced by {@link FoolParser#vardec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVardec(FoolParser.VardecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code decAsm}
	 * labeled alternative in {@link FoolParser#varasm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecAsm(FoolParser.DecAsmContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Asm}
	 * labeled alternative in {@link FoolParser#varasm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsm(FoolParser.AsmContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fieldAsm}
	 * labeled alternative in {@link FoolParser#varasm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldAsm(FoolParser.FieldAsmContext ctx);
	/**
	 * Visit a parse tree produced by {@link FoolParser#fun}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFun(FoolParser.FunContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varAssignment}
	 * labeled alternative in {@link FoolParser#dec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarAssignment(FoolParser.VarAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funDeclaration}
	 * labeled alternative in {@link FoolParser#dec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunDeclaration(FoolParser.FunDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link FoolParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(FoolParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intExp}
	 * labeled alternative in {@link FoolParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntExp(FoolParser.IntExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolExp}
	 * labeled alternative in {@link FoolParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolExp(FoolParser.BoolExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statement}
	 * labeled alternative in {@link FoolParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(FoolParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifThenElse}
	 * labeled alternative in {@link FoolParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfThenElse(FoolParser.IfThenElseContext ctx);
	/**
	 * Visit a parse tree produced by {@link FoolParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(FoolParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link FoolParser#stms}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStms(FoolParser.StmsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stmAsm}
	 * labeled alternative in {@link FoolParser#stm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmAsm(FoolParser.StmAsmContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BranchStm}
	 * labeled alternative in {@link FoolParser#stm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBranchStm(FoolParser.BranchStmContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolFactor}
	 * labeled alternative in {@link FoolParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolFactor(FoolParser.BoolFactorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intBoolFactor}
	 * labeled alternative in {@link FoolParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntBoolFactor(FoolParser.IntBoolFactorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code valFactor}
	 * labeled alternative in {@link FoolParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValFactor(FoolParser.ValFactorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intVal}
	 * labeled alternative in {@link FoolParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntVal(FoolParser.IntValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolVal}
	 * labeled alternative in {@link FoolParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolVal(FoolParser.BoolValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code baseVal}
	 * labeled alternative in {@link FoolParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBaseVal(FoolParser.BaseValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varVal}
	 * labeled alternative in {@link FoolParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarVal(FoolParser.VarValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcall}
	 * labeled alternative in {@link FoolParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncall(FoolParser.FuncallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nullVal}
	 * labeled alternative in {@link FoolParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullVal(FoolParser.NullValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fieldVal}
	 * labeled alternative in {@link FoolParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldVal(FoolParser.FieldValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code methodCall}
	 * labeled alternative in {@link FoolParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodCall(FoolParser.MethodCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code classInstantiation}
	 * labeled alternative in {@link FoolParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassInstantiation(FoolParser.ClassInstantiationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code print}
	 * labeled alternative in {@link FoolParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(FoolParser.PrintContext ctx);
}