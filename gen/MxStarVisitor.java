// Generated from /Users/anoxiacxy/Documents/GitHub/Compiler-MxStar/MxStar.g4 by ANTLR 4.9
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MxStarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MxStarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MxStarParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MxStarParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#functionDefination}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDefination(MxStarParser.FunctionDefinationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(MxStarParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(MxStarParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#constructDefination}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructDefination(MxStarParser.ConstructDefinationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#classDefination}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDefination(MxStarParser.ClassDefinationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#variableDefination}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDefination(MxStarParser.VariableDefinationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varDefStatement}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDefStatement(MxStarParser.VarDefStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blockStatement}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatement(MxStarParser.BlockStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifStatement}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(MxStarParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whileStatement}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(MxStarParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forStatement}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(MxStarParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code returnStatement}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(MxStarParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code breakStatement}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStatement(MxStarParser.BreakStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code continueStatement}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStatement(MxStarParser.ContinueStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionStatement}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatement(MxStarParser.ExpressionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#init}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInit(MxStarParser.InitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code shiftExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShiftExpression(MxStarParser.ShiftExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bitOrExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitOrExpression(MxStarParser.BitOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignExpression(MxStarParser.AssignExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bitXorExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitXorExpression(MxStarParser.BitXorExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logAndExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogAndExpression(MxStarParser.LogAndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code succExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuccExpression(MxStarParser.SuccExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code compareExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompareExpression(MxStarParser.CompareExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bitAndExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitAndExpression(MxStarParser.BitAndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExpression(MxStarParser.AtomExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logOrExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogOrExpression(MxStarParser.LogOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addiExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddiExpression(MxStarParser.AddiExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiExpression(MxStarParser.MultiExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code listExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListExpression(MxStarParser.ListExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equalExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualExpression(MxStarParser.EqualExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code prefExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefExpression(MxStarParser.PrefExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExpression(MxStarParser.PrimaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#newExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewExpression(MxStarParser.NewExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#functionCallExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallExpression(MxStarParser.FunctionCallExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code array}
	 * labeled alternative in {@link MxStarParser#identifierExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(MxStarParser.ArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code this}
	 * labeled alternative in {@link MxStarParser#identifierExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThis(MxStarParser.ThisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code member}
	 * labeled alternative in {@link MxStarParser#identifierExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMember(MxStarParser.MemberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code identitfier}
	 * labeled alternative in {@link MxStarParser#identifierExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentitfier(MxStarParser.IdentitfierContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#typeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeName(MxStarParser.TypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#classIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassIdentifier(MxStarParser.ClassIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#functionIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionIdentifier(MxStarParser.FunctionIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#fundamentalType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFundamentalType(MxStarParser.FundamentalTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(MxStarParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#keyWord}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyWord(MxStarParser.KeyWordContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#standardOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStandardOperator(MxStarParser.StandardOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#relationOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationOperator(MxStarParser.RelationOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#logicalOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalOperator(MxStarParser.LogicalOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#bitwiseOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitwiseOperator(MxStarParser.BitwiseOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#assignOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignOperator(MxStarParser.AssignOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#iterateOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIterateOperator(MxStarParser.IterateOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#componentOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComponentOperator(MxStarParser.ComponentOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#priorityOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPriorityOperator(MxStarParser.PriorityOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#specialSymbol}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpecialSymbol(MxStarParser.SpecialSymbolContext ctx);
}