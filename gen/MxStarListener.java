// Generated from /Users/anoxiacxy/Documents/GitHub/Compiler-MxStar/MxStar.g4 by ANTLR 4.9
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
	 * Enter a parse tree produced by {@link MxStarParser#functionDefination}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDefination(MxStarParser.FunctionDefinationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#functionDefination}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDefination(MxStarParser.FunctionDefinationContext ctx);
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
	 * Enter a parse tree produced by {@link MxStarParser#constructDefination}.
	 * @param ctx the parse tree
	 */
	void enterConstructDefination(MxStarParser.ConstructDefinationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#constructDefination}.
	 * @param ctx the parse tree
	 */
	void exitConstructDefination(MxStarParser.ConstructDefinationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#classDefination}.
	 * @param ctx the parse tree
	 */
	void enterClassDefination(MxStarParser.ClassDefinationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#classDefination}.
	 * @param ctx the parse tree
	 */
	void exitClassDefination(MxStarParser.ClassDefinationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#variableDefination}.
	 * @param ctx the parse tree
	 */
	void enterVariableDefination(MxStarParser.VariableDefinationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#variableDefination}.
	 * @param ctx the parse tree
	 */
	void exitVariableDefination(MxStarParser.VariableDefinationContext ctx);
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
	 * Enter a parse tree produced by {@link MxStarParser#init}.
	 * @param ctx the parse tree
	 */
	void enterInit(MxStarParser.InitContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#init}.
	 * @param ctx the parse tree
	 */
	void exitInit(MxStarParser.InitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code shiftExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterShiftExpression(MxStarParser.ShiftExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code shiftExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitShiftExpression(MxStarParser.ShiftExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bitOrExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBitOrExpression(MxStarParser.BitOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bitOrExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBitOrExpression(MxStarParser.BitOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAssignExpression(MxStarParser.AssignExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAssignExpression(MxStarParser.AssignExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bitXorExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBitXorExpression(MxStarParser.BitXorExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bitXorExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBitXorExpression(MxStarParser.BitXorExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logAndExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLogAndExpression(MxStarParser.LogAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logAndExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLogAndExpression(MxStarParser.LogAndExpressionContext ctx);
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
	 * Enter a parse tree produced by the {@code compareExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCompareExpression(MxStarParser.CompareExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compareExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCompareExpression(MxStarParser.CompareExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bitAndExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBitAndExpression(MxStarParser.BitAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bitAndExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBitAndExpression(MxStarParser.BitAndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAtomExpression(MxStarParser.AtomExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAtomExpression(MxStarParser.AtomExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logOrExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLogOrExpression(MxStarParser.LogOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logOrExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLogOrExpression(MxStarParser.LogOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addiExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAddiExpression(MxStarParser.AddiExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addiExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAddiExpression(MxStarParser.AddiExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMultiExpression(MxStarParser.MultiExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMultiExpression(MxStarParser.MultiExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code listExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterListExpression(MxStarParser.ListExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code listExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitListExpression(MxStarParser.ListExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equalExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEqualExpression(MxStarParser.EqualExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equalExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEqualExpression(MxStarParser.EqualExpressionContext ctx);
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
	 * Enter a parse tree produced by {@link MxStarParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExpression(MxStarParser.PrimaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExpression(MxStarParser.PrimaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#newExpression}.
	 * @param ctx the parse tree
	 */
	void enterNewExpression(MxStarParser.NewExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#newExpression}.
	 * @param ctx the parse tree
	 */
	void exitNewExpression(MxStarParser.NewExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#functionCallExpression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallExpression(MxStarParser.FunctionCallExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#functionCallExpression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallExpression(MxStarParser.FunctionCallExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code array}
	 * labeled alternative in {@link MxStarParser#identifierExpression}.
	 * @param ctx the parse tree
	 */
	void enterArray(MxStarParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code array}
	 * labeled alternative in {@link MxStarParser#identifierExpression}.
	 * @param ctx the parse tree
	 */
	void exitArray(MxStarParser.ArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code this}
	 * labeled alternative in {@link MxStarParser#identifierExpression}.
	 * @param ctx the parse tree
	 */
	void enterThis(MxStarParser.ThisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code this}
	 * labeled alternative in {@link MxStarParser#identifierExpression}.
	 * @param ctx the parse tree
	 */
	void exitThis(MxStarParser.ThisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code member}
	 * labeled alternative in {@link MxStarParser#identifierExpression}.
	 * @param ctx the parse tree
	 */
	void enterMember(MxStarParser.MemberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code member}
	 * labeled alternative in {@link MxStarParser#identifierExpression}.
	 * @param ctx the parse tree
	 */
	void exitMember(MxStarParser.MemberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identitfier}
	 * labeled alternative in {@link MxStarParser#identifierExpression}.
	 * @param ctx the parse tree
	 */
	void enterIdentitfier(MxStarParser.IdentitfierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identitfier}
	 * labeled alternative in {@link MxStarParser#identifierExpression}.
	 * @param ctx the parse tree
	 */
	void exitIdentitfier(MxStarParser.IdentitfierContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#typeName}.
	 * @param ctx the parse tree
	 */
	void enterTypeName(MxStarParser.TypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#typeName}.
	 * @param ctx the parse tree
	 */
	void exitTypeName(MxStarParser.TypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#classIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterClassIdentifier(MxStarParser.ClassIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#classIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitClassIdentifier(MxStarParser.ClassIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#functionIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterFunctionIdentifier(MxStarParser.FunctionIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#functionIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitFunctionIdentifier(MxStarParser.FunctionIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#fundamentalType}.
	 * @param ctx the parse tree
	 */
	void enterFundamentalType(MxStarParser.FundamentalTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#fundamentalType}.
	 * @param ctx the parse tree
	 */
	void exitFundamentalType(MxStarParser.FundamentalTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(MxStarParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(MxStarParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#keyWord}.
	 * @param ctx the parse tree
	 */
	void enterKeyWord(MxStarParser.KeyWordContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#keyWord}.
	 * @param ctx the parse tree
	 */
	void exitKeyWord(MxStarParser.KeyWordContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#standardOperator}.
	 * @param ctx the parse tree
	 */
	void enterStandardOperator(MxStarParser.StandardOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#standardOperator}.
	 * @param ctx the parse tree
	 */
	void exitStandardOperator(MxStarParser.StandardOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#relationOperator}.
	 * @param ctx the parse tree
	 */
	void enterRelationOperator(MxStarParser.RelationOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#relationOperator}.
	 * @param ctx the parse tree
	 */
	void exitRelationOperator(MxStarParser.RelationOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#logicalOperator}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOperator(MxStarParser.LogicalOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#logicalOperator}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOperator(MxStarParser.LogicalOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#bitwiseOperator}.
	 * @param ctx the parse tree
	 */
	void enterBitwiseOperator(MxStarParser.BitwiseOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#bitwiseOperator}.
	 * @param ctx the parse tree
	 */
	void exitBitwiseOperator(MxStarParser.BitwiseOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#assignOperator}.
	 * @param ctx the parse tree
	 */
	void enterAssignOperator(MxStarParser.AssignOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#assignOperator}.
	 * @param ctx the parse tree
	 */
	void exitAssignOperator(MxStarParser.AssignOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#iterateOperator}.
	 * @param ctx the parse tree
	 */
	void enterIterateOperator(MxStarParser.IterateOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#iterateOperator}.
	 * @param ctx the parse tree
	 */
	void exitIterateOperator(MxStarParser.IterateOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#componentOperator}.
	 * @param ctx the parse tree
	 */
	void enterComponentOperator(MxStarParser.ComponentOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#componentOperator}.
	 * @param ctx the parse tree
	 */
	void exitComponentOperator(MxStarParser.ComponentOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#priorityOperator}.
	 * @param ctx the parse tree
	 */
	void enterPriorityOperator(MxStarParser.PriorityOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#priorityOperator}.
	 * @param ctx the parse tree
	 */
	void exitPriorityOperator(MxStarParser.PriorityOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#specialSymbol}.
	 * @param ctx the parse tree
	 */
	void enterSpecialSymbol(MxStarParser.SpecialSymbolContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#specialSymbol}.
	 * @param ctx the parse tree
	 */
	void exitSpecialSymbol(MxStarParser.SpecialSymbolContext ctx);
}