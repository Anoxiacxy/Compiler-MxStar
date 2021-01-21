// Generated from /Users/anoxiacxy/Documents/GitHub/Compiler-MxStar/src/Parser/MxStar.g4 by ANTLR 4.9
package Parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MxStarParser}.
 */
public interface MxStarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MxStarParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MxStarParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MxStarParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#programComponent}.
	 * @param ctx the parse tree
	 */
	void enterProgramComponent(MxStarParser.ProgramComponentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#programComponent}.
	 * @param ctx the parse tree
	 */
	void exitProgramComponent(MxStarParser.ProgramComponentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDefinition(MxStarParser.FunctionDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDefinition(MxStarParser.FunctionDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(MxStarParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(MxStarParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(MxStarParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(MxStarParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#classDefinition}.
	 * @param ctx the parse tree
	 */
	void enterClassDefinition(MxStarParser.ClassDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#classDefinition}.
	 * @param ctx the parse tree
	 */
	void exitClassDefinition(MxStarParser.ClassDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#classComponent}.
	 * @param ctx the parse tree
	 */
	void enterClassComponent(MxStarParser.ClassComponentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#classComponent}.
	 * @param ctx the parse tree
	 */
	void exitClassComponent(MxStarParser.ClassComponentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(MxStarParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(MxStarParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varDefStatement}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterVarDefStatement(MxStarParser.VarDefStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varDefStatement}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitVarDefStatement(MxStarParser.VarDefStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blockStatement}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(MxStarParser.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blockStatement}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(MxStarParser.BlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifStatement}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(MxStarParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifStatement}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(MxStarParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code whileStatement}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(MxStarParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whileStatement}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(MxStarParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forStatement}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(MxStarParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forStatement}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(MxStarParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code returnStatement}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(MxStarParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code returnStatement}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(MxStarParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code breakStatement}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterBreakStatement(MxStarParser.BreakStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code breakStatement}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitBreakStatement(MxStarParser.BreakStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code continueStatement}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterContinueStatement(MxStarParser.ContinueStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code continueStatement}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitContinueStatement(MxStarParser.ContinueStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionStatement}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(MxStarParser.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionStatement}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(MxStarParser.ExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code emptyStatement}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterEmptyStatement(MxStarParser.EmptyStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code emptyStatement}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitEmptyStatement(MxStarParser.EmptyStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBinaryExpression(MxStarParser.BinaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBinaryExpression(MxStarParser.BinaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterArrayExpression(MxStarParser.ArrayExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitArrayExpression(MxStarParser.ArrayExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNewExpression(MxStarParser.NewExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNewExpression(MxStarParser.NewExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierExpression(MxStarParser.IdentifierExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierExpression(MxStarParser.IdentifierExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code errorExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterErrorExpression(MxStarParser.ErrorExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code errorExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitErrorExpression(MxStarParser.ErrorExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code literalExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLiteralExpression(MxStarParser.LiteralExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code literalExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLiteralExpression(MxStarParser.LiteralExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code memberExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMemberExpression(MxStarParser.MemberExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code memberExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMemberExpression(MxStarParser.MemberExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSubExpression(MxStarParser.SubExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSubExpression(MxStarParser.SubExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code prefExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPrefExpression(MxStarParser.PrefExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code prefExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPrefExpression(MxStarParser.PrefExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFuncExpression(MxStarParser.FuncExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFuncExpression(MxStarParser.FuncExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code succExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSuccExpression(MxStarParser.SuccExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code succExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSuccExpression(MxStarParser.SuccExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(MxStarParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(MxStarParser.ExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#variableDefinition}.
	 * @param ctx the parse tree
	 */
	void enterVariableDefinition(MxStarParser.VariableDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#variableDefinition}.
	 * @param ctx the parse tree
	 */
	void exitVariableDefinition(MxStarParser.VariableDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#singleDefinition}.
	 * @param ctx the parse tree
	 */
	void enterSingleDefinition(MxStarParser.SingleDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#singleDefinition}.
	 * @param ctx the parse tree
	 */
	void exitSingleDefinition(MxStarParser.SingleDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#returnType}.
	 * @param ctx the parse tree
	 */
	void enterReturnType(MxStarParser.ReturnTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#returnType}.
	 * @param ctx the parse tree
	 */
	void exitReturnType(MxStarParser.ReturnTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(MxStarParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(MxStarParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#baseType}.
	 * @param ctx the parse tree
	 */
	void enterBaseType(MxStarParser.BaseTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#baseType}.
	 * @param ctx the parse tree
	 */
	void exitBaseType(MxStarParser.BaseTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolLiteral}
	 * labeled alternative in {@link MxStarParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterBoolLiteral(MxStarParser.BoolLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolLiteral}
	 * labeled alternative in {@link MxStarParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitBoolLiteral(MxStarParser.BoolLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intLiteral}
	 * labeled alternative in {@link MxStarParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterIntLiteral(MxStarParser.IntLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intLiteral}
	 * labeled alternative in {@link MxStarParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitIntLiteral(MxStarParser.IntLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringLiteral}
	 * labeled alternative in {@link MxStarParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(MxStarParser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringLiteral}
	 * labeled alternative in {@link MxStarParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(MxStarParser.StringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nullLiteral}
	 * labeled alternative in {@link MxStarParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterNullLiteral(MxStarParser.NullLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nullLiteral}
	 * labeled alternative in {@link MxStarParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitNullLiteral(MxStarParser.NullLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code thisLiteral}
	 * labeled alternative in {@link MxStarParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterThisLiteral(MxStarParser.ThisLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code thisLiteral}
	 * labeled alternative in {@link MxStarParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitThisLiteral(MxStarParser.ThisLiteralContext ctx);
}