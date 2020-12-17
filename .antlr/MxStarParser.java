// Generated from c:\Users\Anoxiacxy\Documents\GitHub\Compiler-MxStar\MxStar.g4 by ANTLR 4.8
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MxStarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TypeName=1, ClassIdentifier=2, FunctionIdentifier=3, FundamentalType=4, 
		BooleanLiteral=5, IntegerLiteral=6, StringLiteral=7, NullLiteral=8, PrintableChar=9, 
		Identifier=10, Comment=11, WhiteSpace=12, KeyWord=13, Int=14, Bool=15, 
		String=16, Null=17, Void=18, True=19, False=20, If=21, Else=22, For=23, 
		While=24, Break=25, Continue=26, Return=27, New=28, Class=29, This=30, 
		IdentifierSymbol=31, StandardOperator=32, RelationOperator=33, LogicalOperator=34, 
		BitwiseOperator=35, AssignOperator=36, IterateOperator=37, ComponentOperator=38, 
		PriorityOperator=39, SpecialSymbol=40, Space=41, NewLine=42, Tab=43, CommentSymbol=44, 
		LeftBrace=45, RightBrace=46, LeftBracket=47, RightBracket=48, LeftParenthesis=49, 
		RightParenthesis=50, Dot=51, Comma=52, Semi=53, Assign=54, PlusPlus=55, 
		MinusMinus=56, RightShift=57, LeftShift=58, BitwiseAnd=59, BitwiseOr=60, 
		BitwiseXor=61, BitwiseNeg=62, LogicalAnd=63, LogicalOr=64, LogicalNeg=65, 
		Greater=66, Less=67, GreaterEqual=68, LessEqual=69, NotEqual=70, Equal=71, 
		Plus=72, Minus=73, Mul=74, Div=75, Mod=76;
	public static final int
		RULE_program = 0, RULE_functionDefination = 1, RULE_constructDefination = 2, 
		RULE_classDefination = 3, RULE_variableDefination = 4, RULE_statement = 5, 
		RULE_blockStatement = 6, RULE_ifStatement = 7, RULE_whileStatement = 8, 
		RULE_forStatement = 9, RULE_returnStatement = 10, RULE_breakStatement = 11, 
		RULE_continueStatement = 12, RULE_expressionStatement = 13, RULE_succExpression = 14, 
		RULE_prefExpression = 15, RULE_multiExpression = 16, RULE_addiExpression = 17, 
		RULE_shiftExpression = 18, RULE_compareExpression = 19, RULE_equalExpression = 20, 
		RULE_bitAndExpression = 21, RULE_bitXorExpression = 22, RULE_bitOrExpression = 23, 
		RULE_logAndExpression = 24, RULE_logOrExpression = 25, RULE_assignExpression = 26, 
		RULE_listExpression = 27, RULE_expression = 28, RULE_primaryExpression = 29, 
		RULE_newExpression = 30, RULE_functionCallExpression = 31, RULE_identifierExpression = 32, 
		RULE_literal = 33;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "functionDefination", "constructDefination", "classDefination", 
			"variableDefination", "statement", "blockStatement", "ifStatement", "whileStatement", 
			"forStatement", "returnStatement", "breakStatement", "continueStatement", 
			"expressionStatement", "succExpression", "prefExpression", "multiExpression", 
			"addiExpression", "shiftExpression", "compareExpression", "equalExpression", 
			"bitAndExpression", "bitXorExpression", "bitOrExpression", "logAndExpression", 
			"logOrExpression", "assignExpression", "listExpression", "expression", 
			"primaryExpression", "newExpression", "functionCallExpression", "identifierExpression", 
			"literal"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "'int'", "'bool'", "'string'", "'null'", "'void'", "'true'", 
			"'false'", "'if'", "'else'", "'for'", "'while'", "'break'", "'continue'", 
			"'return'", "'new'", "'class'", "'this'", null, null, null, null, null, 
			null, null, null, null, null, "' '", "'\n'", "'\t'", "'//'", "'{'", "'}'", 
			"'['", "']'", "'('", "')'", "'.'", "','", "';'", "'='", "'++'", "'--'", 
			"'>>'", "'<<'", "'&'", "'|'", "'^'", "'~'", "'&&'", "'||'", "'!'", "'>'", 
			"'<'", "'>='", "'<='", "'!='", "'=='", "'+'", "'-'", "'*'", "'/'", "'%'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "TypeName", "ClassIdentifier", "FunctionIdentifier", "FundamentalType", 
			"BooleanLiteral", "IntegerLiteral", "StringLiteral", "NullLiteral", "PrintableChar", 
			"Identifier", "Comment", "WhiteSpace", "KeyWord", "Int", "Bool", "String", 
			"Null", "Void", "True", "False", "If", "Else", "For", "While", "Break", 
			"Continue", "Return", "New", "Class", "This", "IdentifierSymbol", "StandardOperator", 
			"RelationOperator", "LogicalOperator", "BitwiseOperator", "AssignOperator", 
			"IterateOperator", "ComponentOperator", "PriorityOperator", "SpecialSymbol", 
			"Space", "NewLine", "Tab", "CommentSymbol", "LeftBrace", "RightBrace", 
			"LeftBracket", "RightBracket", "LeftParenthesis", "RightParenthesis", 
			"Dot", "Comma", "Semi", "Assign", "PlusPlus", "MinusMinus", "RightShift", 
			"LeftShift", "BitwiseAnd", "BitwiseOr", "BitwiseXor", "BitwiseNeg", "LogicalAnd", 
			"LogicalOr", "LogicalNeg", "Greater", "Less", "GreaterEqual", "LessEqual", 
			"NotEqual", "Equal", "Plus", "Minus", "Mul", "Div", "Mod"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "MxStar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MxStarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(MxStarParser.EOF, 0); }
		public List<FunctionDefinationContext> functionDefination() {
			return getRuleContexts(FunctionDefinationContext.class);
		}
		public FunctionDefinationContext functionDefination(int i) {
			return getRuleContext(FunctionDefinationContext.class,i);
		}
		public List<ClassDefinationContext> classDefination() {
			return getRuleContexts(ClassDefinationContext.class);
		}
		public ClassDefinationContext classDefination(int i) {
			return getRuleContext(ClassDefinationContext.class,i);
		}
		public List<VariableDefinationContext> variableDefination() {
			return getRuleContexts(VariableDefinationContext.class);
		}
		public VariableDefinationContext variableDefination(int i) {
			return getRuleContext(VariableDefinationContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TypeName) | (1L << Void) | (1L << Class))) != 0)) {
				{
				setState(71);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(68);
					functionDefination();
					}
					break;
				case 2:
					{
					setState(69);
					classDefination();
					}
					break;
				case 3:
					{
					setState(70);
					variableDefination();
					}
					break;
				}
				}
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(76);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionDefinationContext extends ParserRuleContext {
		public TerminalNode FunctionIdentifier() { return getToken(MxStarParser.FunctionIdentifier, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode TypeName() { return getToken(MxStarParser.TypeName, 0); }
		public TerminalNode Void() { return getToken(MxStarParser.Void, 0); }
		public FunctionDefinationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDefination; }
	}

	public final FunctionDefinationContext functionDefination() throws RecognitionException {
		FunctionDefinationContext _localctx = new FunctionDefinationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_functionDefination);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			_la = _input.LA(1);
			if ( !(_la==TypeName || _la==Void) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(79);
			match(FunctionIdentifier);
			setState(80);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstructDefinationContext extends ParserRuleContext {
		public TerminalNode FunctionIdentifier() { return getToken(MxStarParser.FunctionIdentifier, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ConstructDefinationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructDefination; }
	}

	public final ConstructDefinationContext constructDefination() throws RecognitionException {
		ConstructDefinationContext _localctx = new ConstructDefinationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_constructDefination);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(FunctionIdentifier);
			setState(83);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassDefinationContext extends ParserRuleContext {
		public TerminalNode Class() { return getToken(MxStarParser.Class, 0); }
		public TerminalNode ClassIdentifier() { return getToken(MxStarParser.ClassIdentifier, 0); }
		public TerminalNode LeftBrace() { return getToken(MxStarParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(MxStarParser.RightBrace, 0); }
		public TerminalNode Semi() { return getToken(MxStarParser.Semi, 0); }
		public List<FunctionDefinationContext> functionDefination() {
			return getRuleContexts(FunctionDefinationContext.class);
		}
		public FunctionDefinationContext functionDefination(int i) {
			return getRuleContext(FunctionDefinationContext.class,i);
		}
		public List<ConstructDefinationContext> constructDefination() {
			return getRuleContexts(ConstructDefinationContext.class);
		}
		public ConstructDefinationContext constructDefination(int i) {
			return getRuleContext(ConstructDefinationContext.class,i);
		}
		public List<VariableDefinationContext> variableDefination() {
			return getRuleContexts(VariableDefinationContext.class);
		}
		public VariableDefinationContext variableDefination(int i) {
			return getRuleContext(VariableDefinationContext.class,i);
		}
		public ClassDefinationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDefination; }
	}

	public final ClassDefinationContext classDefination() throws RecognitionException {
		ClassDefinationContext _localctx = new ClassDefinationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_classDefination);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(Class);
			setState(86);
			match(ClassIdentifier);
			setState(87);
			match(LeftBrace);
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TypeName) | (1L << FunctionIdentifier) | (1L << Void))) != 0)) {
				{
				setState(91);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(88);
					functionDefination();
					}
					break;
				case 2:
					{
					setState(89);
					constructDefination();
					}
					break;
				case 3:
					{
					setState(90);
					variableDefination();
					}
					break;
				}
				}
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(96);
			match(RightBrace);
			setState(97);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableDefinationContext extends ParserRuleContext {
		public TerminalNode TypeName() { return getToken(MxStarParser.TypeName, 0); }
		public TerminalNode Semi() { return getToken(MxStarParser.Semi, 0); }
		public List<TerminalNode> Identifier() { return getTokens(MxStarParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(MxStarParser.Identifier, i);
		}
		public List<TerminalNode> LeftBracket() { return getTokens(MxStarParser.LeftBracket); }
		public TerminalNode LeftBracket(int i) {
			return getToken(MxStarParser.LeftBracket, i);
		}
		public List<TerminalNode> RightBracket() { return getTokens(MxStarParser.RightBracket); }
		public TerminalNode RightBracket(int i) {
			return getToken(MxStarParser.RightBracket, i);
		}
		public List<TerminalNode> Comma() { return getTokens(MxStarParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(MxStarParser.Comma, i);
		}
		public List<TerminalNode> Assign() { return getTokens(MxStarParser.Assign); }
		public TerminalNode Assign(int i) {
			return getToken(MxStarParser.Assign, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public VariableDefinationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDefination; }
	}

	public final VariableDefinationContext variableDefination() throws RecognitionException {
		VariableDefinationContext _localctx = new VariableDefinationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_variableDefination);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(TypeName);
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LeftBracket) {
				{
				{
				setState(100);
				match(LeftBracket);
				setState(101);
				match(RightBracket);
				}
				}
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			{
			setState(107);
			match(Identifier);
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Assign) {
				{
				setState(108);
				match(Assign);
				setState(109);
				expression();
				}
			}

			}
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(112);
				match(Comma);
				setState(113);
				match(Identifier);
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Assign) {
					{
					setState(114);
					match(Assign);
					setState(115);
					expression();
					}
				}

				}
				}
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(123);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public VariableDefinationContext variableDefination() {
			return getRuleContext(VariableDefinationContext.class,0);
		}
		public BlockStatementContext blockStatement() {
			return getRuleContext(BlockStatementContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public BreakStatementContext breakStatement() {
			return getRuleContext(BreakStatementContext.class,0);
		}
		public ContinueStatementContext continueStatement() {
			return getRuleContext(ContinueStatementContext.class,0);
		}
		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_statement);
		try {
			setState(134);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TypeName:
				enterOuterAlt(_localctx, 1);
				{
				setState(125);
				variableDefination();
				}
				break;
			case LeftBrace:
				enterOuterAlt(_localctx, 2);
				{
				setState(126);
				blockStatement();
				}
				break;
			case If:
				enterOuterAlt(_localctx, 3);
				{
				setState(127);
				ifStatement();
				}
				break;
			case While:
				enterOuterAlt(_localctx, 4);
				{
				setState(128);
				whileStatement();
				}
				break;
			case For:
				enterOuterAlt(_localctx, 5);
				{
				setState(129);
				forStatement();
				}
				break;
			case Return:
				enterOuterAlt(_localctx, 6);
				{
				setState(130);
				returnStatement();
				}
				break;
			case Break:
				enterOuterAlt(_localctx, 7);
				{
				setState(131);
				breakStatement();
				}
				break;
			case Continue:
				enterOuterAlt(_localctx, 8);
				{
				setState(132);
				continueStatement();
				}
				break;
			case FunctionIdentifier:
			case BooleanLiteral:
			case IntegerLiteral:
			case StringLiteral:
			case NullLiteral:
			case Identifier:
			case New:
			case This:
			case LeftParenthesis:
			case PlusPlus:
			case MinusMinus:
			case BitwiseNeg:
			case LogicalNeg:
			case Plus:
			case Minus:
				enterOuterAlt(_localctx, 9);
				{
				setState(133);
				expressionStatement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockStatementContext extends ParserRuleContext {
		public TerminalNode LeftBrace() { return getToken(MxStarParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(MxStarParser.RightBrace, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStatement; }
	}

	public final BlockStatementContext blockStatement() throws RecognitionException {
		BlockStatementContext _localctx = new BlockStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_blockStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			match(LeftBrace);
			setState(140);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TypeName) | (1L << FunctionIdentifier) | (1L << BooleanLiteral) | (1L << IntegerLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << Identifier) | (1L << If) | (1L << For) | (1L << While) | (1L << Break) | (1L << Continue) | (1L << Return) | (1L << New) | (1L << This) | (1L << LeftBrace) | (1L << LeftParenthesis) | (1L << PlusPlus) | (1L << MinusMinus) | (1L << BitwiseNeg))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (LogicalNeg - 65)) | (1L << (Plus - 65)) | (1L << (Minus - 65)))) != 0)) {
				{
				{
				setState(137);
				statement();
				}
				}
				setState(142);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(143);
			match(RightBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStatementContext extends ParserRuleContext {
		public TerminalNode If() { return getToken(MxStarParser.If, 0); }
		public TerminalNode LeftParenthesis() { return getToken(MxStarParser.LeftParenthesis, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightParenthesis() { return getToken(MxStarParser.RightParenthesis, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode Else() { return getToken(MxStarParser.Else, 0); }
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(If);
			setState(146);
			match(LeftParenthesis);
			setState(147);
			expression();
			setState(148);
			match(RightParenthesis);
			setState(149);
			statement();
			setState(152);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(150);
				match(Else);
				setState(151);
				statement();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileStatementContext extends ParserRuleContext {
		public TerminalNode While() { return getToken(MxStarParser.While, 0); }
		public TerminalNode LeftParenthesis() { return getToken(MxStarParser.LeftParenthesis, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightParenthesis() { return getToken(MxStarParser.RightParenthesis, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			match(While);
			setState(155);
			match(LeftParenthesis);
			setState(156);
			expression();
			setState(157);
			match(RightParenthesis);
			setState(158);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForStatementContext extends ParserRuleContext {
		public TerminalNode For() { return getToken(MxStarParser.For, 0); }
		public TerminalNode LeftParenthesis() { return getToken(MxStarParser.LeftParenthesis, 0); }
		public List<TerminalNode> Semi() { return getTokens(MxStarParser.Semi); }
		public TerminalNode Semi(int i) {
			return getToken(MxStarParser.Semi, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RightParenthesis() { return getToken(MxStarParser.RightParenthesis, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_forStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(For);
			setState(161);
			match(LeftParenthesis);
			setState(163);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FunctionIdentifier) | (1L << BooleanLiteral) | (1L << IntegerLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << Identifier) | (1L << New) | (1L << This) | (1L << LeftParenthesis) | (1L << PlusPlus) | (1L << MinusMinus) | (1L << BitwiseNeg))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (LogicalNeg - 65)) | (1L << (Plus - 65)) | (1L << (Minus - 65)))) != 0)) {
				{
				setState(162);
				expression();
				}
			}

			setState(165);
			match(Semi);
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FunctionIdentifier) | (1L << BooleanLiteral) | (1L << IntegerLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << Identifier) | (1L << New) | (1L << This) | (1L << LeftParenthesis) | (1L << PlusPlus) | (1L << MinusMinus) | (1L << BitwiseNeg))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (LogicalNeg - 65)) | (1L << (Plus - 65)) | (1L << (Minus - 65)))) != 0)) {
				{
				setState(166);
				expression();
				}
			}

			setState(169);
			match(Semi);
			setState(170);
			expression();
			setState(171);
			match(RightParenthesis);
			setState(172);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnStatementContext extends ParserRuleContext {
		public TerminalNode Return() { return getToken(MxStarParser.Return, 0); }
		public TerminalNode Semi() { return getToken(MxStarParser.Semi, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_returnStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			match(Return);
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FunctionIdentifier) | (1L << BooleanLiteral) | (1L << IntegerLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << Identifier) | (1L << New) | (1L << This) | (1L << LeftParenthesis) | (1L << PlusPlus) | (1L << MinusMinus) | (1L << BitwiseNeg))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (LogicalNeg - 65)) | (1L << (Plus - 65)) | (1L << (Minus - 65)))) != 0)) {
				{
				setState(175);
				expression();
				}
			}

			setState(178);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BreakStatementContext extends ParserRuleContext {
		public TerminalNode Break() { return getToken(MxStarParser.Break, 0); }
		public TerminalNode Semi() { return getToken(MxStarParser.Semi, 0); }
		public BreakStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakStatement; }
	}

	public final BreakStatementContext breakStatement() throws RecognitionException {
		BreakStatementContext _localctx = new BreakStatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_breakStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			match(Break);
			setState(181);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ContinueStatementContext extends ParserRuleContext {
		public TerminalNode Continue() { return getToken(MxStarParser.Continue, 0); }
		public TerminalNode Semi() { return getToken(MxStarParser.Semi, 0); }
		public ContinueStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continueStatement; }
	}

	public final ContinueStatementContext continueStatement() throws RecognitionException {
		ContinueStatementContext _localctx = new ContinueStatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_continueStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			match(Continue);
			setState(184);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Semi() { return getToken(MxStarParser.Semi, 0); }
		public ExpressionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionStatement; }
	}

	public final ExpressionStatementContext expressionStatement() throws RecognitionException {
		ExpressionStatementContext _localctx = new ExpressionStatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_expressionStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			expression();
			setState(187);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SuccExpressionContext extends ParserRuleContext {
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public TerminalNode PlusPlus() { return getToken(MxStarParser.PlusPlus, 0); }
		public TerminalNode MinusMinus() { return getToken(MxStarParser.MinusMinus, 0); }
		public SuccExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_succExpression; }
	}

	public final SuccExpressionContext succExpression() throws RecognitionException {
		SuccExpressionContext _localctx = new SuccExpressionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_succExpression);
		int _la;
		try {
			setState(193);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(189);
				primaryExpression();
				setState(190);
				_la = _input.LA(1);
				if ( !(_la==PlusPlus || _la==MinusMinus) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(192);
				primaryExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrefExpressionContext extends ParserRuleContext {
		public SuccExpressionContext succExpression() {
			return getRuleContext(SuccExpressionContext.class,0);
		}
		public TerminalNode PlusPlus() { return getToken(MxStarParser.PlusPlus, 0); }
		public TerminalNode MinusMinus() { return getToken(MxStarParser.MinusMinus, 0); }
		public TerminalNode LogicalNeg() { return getToken(MxStarParser.LogicalNeg, 0); }
		public TerminalNode BitwiseNeg() { return getToken(MxStarParser.BitwiseNeg, 0); }
		public TerminalNode Plus() { return getToken(MxStarParser.Plus, 0); }
		public TerminalNode Minus() { return getToken(MxStarParser.Minus, 0); }
		public PrefExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefExpression; }
	}

	public final PrefExpressionContext prefExpression() throws RecognitionException {
		PrefExpressionContext _localctx = new PrefExpressionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_prefExpression);
		int _la;
		try {
			setState(198);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PlusPlus:
			case MinusMinus:
			case BitwiseNeg:
			case LogicalNeg:
			case Plus:
			case Minus:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(195);
				_la = _input.LA(1);
				if ( !(((((_la - 55)) & ~0x3f) == 0 && ((1L << (_la - 55)) & ((1L << (PlusPlus - 55)) | (1L << (MinusMinus - 55)) | (1L << (BitwiseNeg - 55)) | (1L << (LogicalNeg - 55)) | (1L << (Plus - 55)) | (1L << (Minus - 55)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(196);
				succExpression();
				}
				}
				break;
			case FunctionIdentifier:
			case BooleanLiteral:
			case IntegerLiteral:
			case StringLiteral:
			case NullLiteral:
			case Identifier:
			case New:
			case This:
			case LeftParenthesis:
				enterOuterAlt(_localctx, 2);
				{
				setState(197);
				succExpression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultiExpressionContext extends ParserRuleContext {
		public List<PrefExpressionContext> prefExpression() {
			return getRuleContexts(PrefExpressionContext.class);
		}
		public PrefExpressionContext prefExpression(int i) {
			return getRuleContext(PrefExpressionContext.class,i);
		}
		public List<TerminalNode> Mul() { return getTokens(MxStarParser.Mul); }
		public TerminalNode Mul(int i) {
			return getToken(MxStarParser.Mul, i);
		}
		public List<TerminalNode> Div() { return getTokens(MxStarParser.Div); }
		public TerminalNode Div(int i) {
			return getToken(MxStarParser.Div, i);
		}
		public List<TerminalNode> Mod() { return getTokens(MxStarParser.Mod); }
		public TerminalNode Mod(int i) {
			return getToken(MxStarParser.Mod, i);
		}
		public MultiExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiExpression; }
	}

	public final MultiExpressionContext multiExpression() throws RecognitionException {
		MultiExpressionContext _localctx = new MultiExpressionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_multiExpression);
		int _la;
		try {
			int _alt;
			setState(210);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(205);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(200);
						prefExpression();
						setState(201);
						_la = _input.LA(1);
						if ( !(((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & ((1L << (Mul - 74)) | (1L << (Div - 74)) | (1L << (Mod - 74)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						} 
					}
					setState(207);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				}
				setState(208);
				prefExpression();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(209);
				prefExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AddiExpressionContext extends ParserRuleContext {
		public List<MultiExpressionContext> multiExpression() {
			return getRuleContexts(MultiExpressionContext.class);
		}
		public MultiExpressionContext multiExpression(int i) {
			return getRuleContext(MultiExpressionContext.class,i);
		}
		public List<TerminalNode> Plus() { return getTokens(MxStarParser.Plus); }
		public TerminalNode Plus(int i) {
			return getToken(MxStarParser.Plus, i);
		}
		public List<TerminalNode> Minus() { return getTokens(MxStarParser.Minus); }
		public TerminalNode Minus(int i) {
			return getToken(MxStarParser.Minus, i);
		}
		public AddiExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addiExpression; }
	}

	public final AddiExpressionContext addiExpression() throws RecognitionException {
		AddiExpressionContext _localctx = new AddiExpressionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_addiExpression);
		int _la;
		try {
			int _alt;
			setState(222);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(217);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(212);
						multiExpression();
						setState(213);
						_la = _input.LA(1);
						if ( !(_la==Plus || _la==Minus) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						} 
					}
					setState(219);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
				}
				setState(220);
				multiExpression();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(221);
				multiExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ShiftExpressionContext extends ParserRuleContext {
		public List<AddiExpressionContext> addiExpression() {
			return getRuleContexts(AddiExpressionContext.class);
		}
		public AddiExpressionContext addiExpression(int i) {
			return getRuleContext(AddiExpressionContext.class,i);
		}
		public List<TerminalNode> LeftShift() { return getTokens(MxStarParser.LeftShift); }
		public TerminalNode LeftShift(int i) {
			return getToken(MxStarParser.LeftShift, i);
		}
		public List<TerminalNode> RightShift() { return getTokens(MxStarParser.RightShift); }
		public TerminalNode RightShift(int i) {
			return getToken(MxStarParser.RightShift, i);
		}
		public ShiftExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shiftExpression; }
	}

	public final ShiftExpressionContext shiftExpression() throws RecognitionException {
		ShiftExpressionContext _localctx = new ShiftExpressionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_shiftExpression);
		int _la;
		try {
			int _alt;
			setState(234);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(229);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(224);
						addiExpression();
						setState(225);
						_la = _input.LA(1);
						if ( !(_la==RightShift || _la==LeftShift) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						} 
					}
					setState(231);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				}
				setState(232);
				addiExpression();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(233);
				addiExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CompareExpressionContext extends ParserRuleContext {
		public List<ShiftExpressionContext> shiftExpression() {
			return getRuleContexts(ShiftExpressionContext.class);
		}
		public ShiftExpressionContext shiftExpression(int i) {
			return getRuleContext(ShiftExpressionContext.class,i);
		}
		public List<TerminalNode> Less() { return getTokens(MxStarParser.Less); }
		public TerminalNode Less(int i) {
			return getToken(MxStarParser.Less, i);
		}
		public List<TerminalNode> LessEqual() { return getTokens(MxStarParser.LessEqual); }
		public TerminalNode LessEqual(int i) {
			return getToken(MxStarParser.LessEqual, i);
		}
		public List<TerminalNode> Greater() { return getTokens(MxStarParser.Greater); }
		public TerminalNode Greater(int i) {
			return getToken(MxStarParser.Greater, i);
		}
		public List<TerminalNode> GreaterEqual() { return getTokens(MxStarParser.GreaterEqual); }
		public TerminalNode GreaterEqual(int i) {
			return getToken(MxStarParser.GreaterEqual, i);
		}
		public CompareExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compareExpression; }
	}

	public final CompareExpressionContext compareExpression() throws RecognitionException {
		CompareExpressionContext _localctx = new CompareExpressionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_compareExpression);
		int _la;
		try {
			int _alt;
			setState(246);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(241);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(236);
						shiftExpression();
						setState(237);
						_la = _input.LA(1);
						if ( !(((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (Greater - 66)) | (1L << (Less - 66)) | (1L << (GreaterEqual - 66)) | (1L << (LessEqual - 66)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						} 
					}
					setState(243);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
				}
				setState(244);
				shiftExpression();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(245);
				shiftExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EqualExpressionContext extends ParserRuleContext {
		public List<CompareExpressionContext> compareExpression() {
			return getRuleContexts(CompareExpressionContext.class);
		}
		public CompareExpressionContext compareExpression(int i) {
			return getRuleContext(CompareExpressionContext.class,i);
		}
		public List<TerminalNode> Equal() { return getTokens(MxStarParser.Equal); }
		public TerminalNode Equal(int i) {
			return getToken(MxStarParser.Equal, i);
		}
		public List<TerminalNode> NotEqual() { return getTokens(MxStarParser.NotEqual); }
		public TerminalNode NotEqual(int i) {
			return getToken(MxStarParser.NotEqual, i);
		}
		public EqualExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalExpression; }
	}

	public final EqualExpressionContext equalExpression() throws RecognitionException {
		EqualExpressionContext _localctx = new EqualExpressionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_equalExpression);
		int _la;
		try {
			int _alt;
			setState(258);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(253);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(248);
						compareExpression();
						setState(249);
						_la = _input.LA(1);
						if ( !(_la==NotEqual || _la==Equal) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						} 
					}
					setState(255);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
				}
				setState(256);
				compareExpression();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(257);
				compareExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BitAndExpressionContext extends ParserRuleContext {
		public List<EqualExpressionContext> equalExpression() {
			return getRuleContexts(EqualExpressionContext.class);
		}
		public EqualExpressionContext equalExpression(int i) {
			return getRuleContext(EqualExpressionContext.class,i);
		}
		public List<TerminalNode> BitwiseAnd() { return getTokens(MxStarParser.BitwiseAnd); }
		public TerminalNode BitwiseAnd(int i) {
			return getToken(MxStarParser.BitwiseAnd, i);
		}
		public BitAndExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitAndExpression; }
	}

	public final BitAndExpressionContext bitAndExpression() throws RecognitionException {
		BitAndExpressionContext _localctx = new BitAndExpressionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_bitAndExpression);
		try {
			int _alt;
			setState(270);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(265);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(260);
						equalExpression();
						setState(261);
						match(BitwiseAnd);
						}
						} 
					}
					setState(267);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
				}
				setState(268);
				equalExpression();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(269);
				equalExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BitXorExpressionContext extends ParserRuleContext {
		public List<BitAndExpressionContext> bitAndExpression() {
			return getRuleContexts(BitAndExpressionContext.class);
		}
		public BitAndExpressionContext bitAndExpression(int i) {
			return getRuleContext(BitAndExpressionContext.class,i);
		}
		public List<TerminalNode> BitwiseXor() { return getTokens(MxStarParser.BitwiseXor); }
		public TerminalNode BitwiseXor(int i) {
			return getToken(MxStarParser.BitwiseXor, i);
		}
		public BitXorExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitXorExpression; }
	}

	public final BitXorExpressionContext bitXorExpression() throws RecognitionException {
		BitXorExpressionContext _localctx = new BitXorExpressionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_bitXorExpression);
		try {
			int _alt;
			setState(282);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(277);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(272);
						bitAndExpression();
						setState(273);
						match(BitwiseXor);
						}
						} 
					}
					setState(279);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
				}
				setState(280);
				bitAndExpression();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(281);
				bitAndExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BitOrExpressionContext extends ParserRuleContext {
		public List<BitXorExpressionContext> bitXorExpression() {
			return getRuleContexts(BitXorExpressionContext.class);
		}
		public BitXorExpressionContext bitXorExpression(int i) {
			return getRuleContext(BitXorExpressionContext.class,i);
		}
		public List<TerminalNode> BitwiseOr() { return getTokens(MxStarParser.BitwiseOr); }
		public TerminalNode BitwiseOr(int i) {
			return getToken(MxStarParser.BitwiseOr, i);
		}
		public BitOrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitOrExpression; }
	}

	public final BitOrExpressionContext bitOrExpression() throws RecognitionException {
		BitOrExpressionContext _localctx = new BitOrExpressionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_bitOrExpression);
		try {
			int _alt;
			setState(294);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(289);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(284);
						bitXorExpression();
						setState(285);
						match(BitwiseOr);
						}
						} 
					}
					setState(291);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
				}
				setState(292);
				bitXorExpression();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(293);
				bitXorExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LogAndExpressionContext extends ParserRuleContext {
		public List<BitOrExpressionContext> bitOrExpression() {
			return getRuleContexts(BitOrExpressionContext.class);
		}
		public BitOrExpressionContext bitOrExpression(int i) {
			return getRuleContext(BitOrExpressionContext.class,i);
		}
		public List<TerminalNode> LogicalAnd() { return getTokens(MxStarParser.LogicalAnd); }
		public TerminalNode LogicalAnd(int i) {
			return getToken(MxStarParser.LogicalAnd, i);
		}
		public LogAndExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logAndExpression; }
	}

	public final LogAndExpressionContext logAndExpression() throws RecognitionException {
		LogAndExpressionContext _localctx = new LogAndExpressionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_logAndExpression);
		try {
			int _alt;
			setState(306);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(301);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(296);
						bitOrExpression();
						setState(297);
						match(LogicalAnd);
						}
						} 
					}
					setState(303);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
				}
				setState(304);
				bitOrExpression();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(305);
				bitOrExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LogOrExpressionContext extends ParserRuleContext {
		public List<LogAndExpressionContext> logAndExpression() {
			return getRuleContexts(LogAndExpressionContext.class);
		}
		public LogAndExpressionContext logAndExpression(int i) {
			return getRuleContext(LogAndExpressionContext.class,i);
		}
		public List<TerminalNode> LogicalOr() { return getTokens(MxStarParser.LogicalOr); }
		public TerminalNode LogicalOr(int i) {
			return getToken(MxStarParser.LogicalOr, i);
		}
		public LogOrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logOrExpression; }
	}

	public final LogOrExpressionContext logOrExpression() throws RecognitionException {
		LogOrExpressionContext _localctx = new LogOrExpressionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_logOrExpression);
		try {
			int _alt;
			setState(318);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(313);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(308);
						logAndExpression();
						setState(309);
						match(LogicalOr);
						}
						} 
					}
					setState(315);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
				}
				setState(316);
				logAndExpression();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(317);
				logAndExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignExpressionContext extends ParserRuleContext {
		public List<LogOrExpressionContext> logOrExpression() {
			return getRuleContexts(LogOrExpressionContext.class);
		}
		public LogOrExpressionContext logOrExpression(int i) {
			return getRuleContext(LogOrExpressionContext.class,i);
		}
		public List<TerminalNode> Assign() { return getTokens(MxStarParser.Assign); }
		public TerminalNode Assign(int i) {
			return getToken(MxStarParser.Assign, i);
		}
		public AssignExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignExpression; }
	}

	public final AssignExpressionContext assignExpression() throws RecognitionException {
		AssignExpressionContext _localctx = new AssignExpressionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_assignExpression);
		int _la;
		try {
			setState(329);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(320);
				logOrExpression();
				setState(325);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Assign) {
					{
					{
					setState(321);
					match(Assign);
					setState(322);
					logOrExpression();
					}
					}
					setState(327);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(328);
				logOrExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListExpressionContext extends ParserRuleContext {
		public List<AssignExpressionContext> assignExpression() {
			return getRuleContexts(AssignExpressionContext.class);
		}
		public AssignExpressionContext assignExpression(int i) {
			return getRuleContext(AssignExpressionContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(MxStarParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(MxStarParser.Comma, i);
		}
		public ListExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listExpression; }
	}

	public final ListExpressionContext listExpression() throws RecognitionException {
		ListExpressionContext _localctx = new ListExpressionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_listExpression);
		try {
			int _alt;
			setState(341);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(336);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(331);
						assignExpression();
						setState(332);
						match(Comma);
						}
						} 
					}
					setState(338);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
				}
				setState(339);
				assignExpression();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(340);
				assignExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ListExpressionContext listExpression() {
			return getRuleContext(ListExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(343);
			listExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimaryExpressionContext extends ParserRuleContext {
		public TerminalNode This() { return getToken(MxStarParser.This, 0); }
		public IdentifierExpressionContext identifierExpression() {
			return getRuleContext(IdentifierExpressionContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TerminalNode LeftParenthesis() { return getToken(MxStarParser.LeftParenthesis, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightParenthesis() { return getToken(MxStarParser.RightParenthesis, 0); }
		public FunctionCallExpressionContext functionCallExpression() {
			return getRuleContext(FunctionCallExpressionContext.class,0);
		}
		public NewExpressionContext newExpression() {
			return getRuleContext(NewExpressionContext.class,0);
		}
		public PrimaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpression; }
	}

	public final PrimaryExpressionContext primaryExpression() throws RecognitionException {
		PrimaryExpressionContext _localctx = new PrimaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_primaryExpression);
		try {
			setState(354);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case This:
				enterOuterAlt(_localctx, 1);
				{
				setState(345);
				match(This);
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(346);
				identifierExpression(0);
				}
				break;
			case BooleanLiteral:
			case IntegerLiteral:
			case StringLiteral:
			case NullLiteral:
				enterOuterAlt(_localctx, 3);
				{
				setState(347);
				literal();
				}
				break;
			case LeftParenthesis:
				enterOuterAlt(_localctx, 4);
				{
				setState(348);
				match(LeftParenthesis);
				setState(349);
				expression();
				setState(350);
				match(RightParenthesis);
				}
				break;
			case FunctionIdentifier:
				enterOuterAlt(_localctx, 5);
				{
				setState(352);
				functionCallExpression();
				}
				break;
			case New:
				enterOuterAlt(_localctx, 6);
				{
				setState(353);
				newExpression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NewExpressionContext extends ParserRuleContext {
		public TerminalNode New() { return getToken(MxStarParser.New, 0); }
		public TerminalNode TypeName() { return getToken(MxStarParser.TypeName, 0); }
		public List<TerminalNode> LeftBracket() { return getTokens(MxStarParser.LeftBracket); }
		public TerminalNode LeftBracket(int i) {
			return getToken(MxStarParser.LeftBracket, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> RightBracket() { return getTokens(MxStarParser.RightBracket); }
		public TerminalNode RightBracket(int i) {
			return getToken(MxStarParser.RightBracket, i);
		}
		public TerminalNode LeftParenthesis() { return getToken(MxStarParser.LeftParenthesis, 0); }
		public TerminalNode RightParenthesis() { return getToken(MxStarParser.RightParenthesis, 0); }
		public NewExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newExpression; }
	}

	public final NewExpressionContext newExpression() throws RecognitionException {
		NewExpressionContext _localctx = new NewExpressionContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_newExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(356);
			match(New);
			setState(357);
			match(TypeName);
			setState(364);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(358);
					match(LeftBracket);
					setState(359);
					expression();
					setState(360);
					match(RightBracket);
					}
					} 
				}
				setState(366);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			}
			setState(371);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LeftBracket) {
				{
				{
				setState(367);
				match(LeftBracket);
				setState(368);
				match(RightBracket);
				}
				}
				setState(373);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(376);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LeftParenthesis) {
				{
				setState(374);
				match(LeftParenthesis);
				setState(375);
				match(RightParenthesis);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionCallExpressionContext extends ParserRuleContext {
		public TerminalNode FunctionIdentifier() { return getToken(MxStarParser.FunctionIdentifier, 0); }
		public TerminalNode LeftParenthesis() { return getToken(MxStarParser.LeftParenthesis, 0); }
		public TerminalNode RightParenthesis() { return getToken(MxStarParser.RightParenthesis, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FunctionCallExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCallExpression; }
	}

	public final FunctionCallExpressionContext functionCallExpression() throws RecognitionException {
		FunctionCallExpressionContext _localctx = new FunctionCallExpressionContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_functionCallExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(378);
			match(FunctionIdentifier);
			setState(385);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				{
				{
				setState(379);
				match(LeftParenthesis);
				setState(380);
				match(RightParenthesis);
				}
				}
				break;
			case 2:
				{
				{
				setState(381);
				match(LeftParenthesis);
				setState(382);
				expression();
				setState(383);
				match(RightParenthesis);
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierExpressionContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MxStarParser.Identifier, 0); }
		public List<IdentifierExpressionContext> identifierExpression() {
			return getRuleContexts(IdentifierExpressionContext.class);
		}
		public IdentifierExpressionContext identifierExpression(int i) {
			return getRuleContext(IdentifierExpressionContext.class,i);
		}
		public TerminalNode Dot() { return getToken(MxStarParser.Dot, 0); }
		public TerminalNode LeftBracket() { return getToken(MxStarParser.LeftBracket, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightBracket() { return getToken(MxStarParser.RightBracket, 0); }
		public IdentifierExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierExpression; }
	}

	public final IdentifierExpressionContext identifierExpression() throws RecognitionException {
		return identifierExpression(0);
	}

	private IdentifierExpressionContext identifierExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		IdentifierExpressionContext _localctx = new IdentifierExpressionContext(_ctx, _parentState);
		IdentifierExpressionContext _prevctx = _localctx;
		int _startState = 64;
		enterRecursionRule(_localctx, 64, RULE_identifierExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(388);
			match(Identifier);
			}
			_ctx.stop = _input.LT(-1);
			setState(400);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(398);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
					case 1:
						{
						_localctx = new IdentifierExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_identifierExpression);
						setState(390);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(391);
						match(Dot);
						setState(392);
						identifierExpression(2);
						}
						break;
					case 2:
						{
						_localctx = new IdentifierExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_identifierExpression);
						setState(393);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(394);
						match(LeftBracket);
						setState(395);
						expression();
						setState(396);
						match(RightBracket);
						}
						break;
					}
					} 
				}
				setState(402);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode BooleanLiteral() { return getToken(MxStarParser.BooleanLiteral, 0); }
		public TerminalNode IntegerLiteral() { return getToken(MxStarParser.IntegerLiteral, 0); }
		public TerminalNode StringLiteral() { return getToken(MxStarParser.StringLiteral, 0); }
		public TerminalNode NullLiteral() { return getToken(MxStarParser.NullLiteral, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(403);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BooleanLiteral) | (1L << IntegerLiteral) | (1L << StringLiteral) | (1L << NullLiteral))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 32:
			return identifierExpression_sempred((IdentifierExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean identifierExpression_sempred(IdentifierExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3N\u0198\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\3\2\3\2\3\2\7\2J\n\2\f\2\16\2M\13\2\3\2\3\2\3\3\3\3"+
		"\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\7\5^\n\5\f\5\16\5a\13\5\3"+
		"\5\3\5\3\5\3\6\3\6\3\6\7\6i\n\6\f\6\16\6l\13\6\3\6\3\6\3\6\5\6q\n\6\3"+
		"\6\3\6\3\6\3\6\5\6w\n\6\7\6y\n\6\f\6\16\6|\13\6\3\6\3\6\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\5\7\u0089\n\7\3\b\3\b\7\b\u008d\n\b\f\b\16\b\u0090"+
		"\13\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u009b\n\t\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\13\3\13\3\13\5\13\u00a6\n\13\3\13\3\13\5\13\u00aa\n\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\f\3\f\5\f\u00b3\n\f\3\f\3\f\3\r\3\r\3\r\3\16"+
		"\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\20\5\20\u00c4\n\20\3\21\3\21"+
		"\3\21\5\21\u00c9\n\21\3\22\3\22\3\22\7\22\u00ce\n\22\f\22\16\22\u00d1"+
		"\13\22\3\22\3\22\5\22\u00d5\n\22\3\23\3\23\3\23\7\23\u00da\n\23\f\23\16"+
		"\23\u00dd\13\23\3\23\3\23\5\23\u00e1\n\23\3\24\3\24\3\24\7\24\u00e6\n"+
		"\24\f\24\16\24\u00e9\13\24\3\24\3\24\5\24\u00ed\n\24\3\25\3\25\3\25\7"+
		"\25\u00f2\n\25\f\25\16\25\u00f5\13\25\3\25\3\25\5\25\u00f9\n\25\3\26\3"+
		"\26\3\26\7\26\u00fe\n\26\f\26\16\26\u0101\13\26\3\26\3\26\5\26\u0105\n"+
		"\26\3\27\3\27\3\27\7\27\u010a\n\27\f\27\16\27\u010d\13\27\3\27\3\27\5"+
		"\27\u0111\n\27\3\30\3\30\3\30\7\30\u0116\n\30\f\30\16\30\u0119\13\30\3"+
		"\30\3\30\5\30\u011d\n\30\3\31\3\31\3\31\7\31\u0122\n\31\f\31\16\31\u0125"+
		"\13\31\3\31\3\31\5\31\u0129\n\31\3\32\3\32\3\32\7\32\u012e\n\32\f\32\16"+
		"\32\u0131\13\32\3\32\3\32\5\32\u0135\n\32\3\33\3\33\3\33\7\33\u013a\n"+
		"\33\f\33\16\33\u013d\13\33\3\33\3\33\5\33\u0141\n\33\3\34\3\34\3\34\7"+
		"\34\u0146\n\34\f\34\16\34\u0149\13\34\3\34\5\34\u014c\n\34\3\35\3\35\3"+
		"\35\7\35\u0151\n\35\f\35\16\35\u0154\13\35\3\35\3\35\5\35\u0158\n\35\3"+
		"\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u0165\n\37"+
		"\3 \3 \3 \3 \3 \3 \7 \u016d\n \f \16 \u0170\13 \3 \3 \7 \u0174\n \f \16"+
		" \u0177\13 \3 \3 \5 \u017b\n \3!\3!\3!\3!\3!\3!\3!\5!\u0184\n!\3\"\3\""+
		"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\7\"\u0191\n\"\f\"\16\"\u0194\13\""+
		"\3#\3#\3#\2\3B$\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62"+
		"\64\668:<>@BD\2\13\4\2\3\3\24\24\3\29:\6\29:@@CCJK\3\2LN\3\2JK\3\2;<\3"+
		"\2DG\3\2HI\3\2\7\n\2\u01b1\2K\3\2\2\2\4P\3\2\2\2\6T\3\2\2\2\bW\3\2\2\2"+
		"\ne\3\2\2\2\f\u0088\3\2\2\2\16\u008a\3\2\2\2\20\u0093\3\2\2\2\22\u009c"+
		"\3\2\2\2\24\u00a2\3\2\2\2\26\u00b0\3\2\2\2\30\u00b6\3\2\2\2\32\u00b9\3"+
		"\2\2\2\34\u00bc\3\2\2\2\36\u00c3\3\2\2\2 \u00c8\3\2\2\2\"\u00d4\3\2\2"+
		"\2$\u00e0\3\2\2\2&\u00ec\3\2\2\2(\u00f8\3\2\2\2*\u0104\3\2\2\2,\u0110"+
		"\3\2\2\2.\u011c\3\2\2\2\60\u0128\3\2\2\2\62\u0134\3\2\2\2\64\u0140\3\2"+
		"\2\2\66\u014b\3\2\2\28\u0157\3\2\2\2:\u0159\3\2\2\2<\u0164\3\2\2\2>\u0166"+
		"\3\2\2\2@\u017c\3\2\2\2B\u0185\3\2\2\2D\u0195\3\2\2\2FJ\5\4\3\2GJ\5\b"+
		"\5\2HJ\5\n\6\2IF\3\2\2\2IG\3\2\2\2IH\3\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2"+
		"\2\2LN\3\2\2\2MK\3\2\2\2NO\7\2\2\3O\3\3\2\2\2PQ\t\2\2\2QR\7\5\2\2RS\5"+
		"\f\7\2S\5\3\2\2\2TU\7\5\2\2UV\5\f\7\2V\7\3\2\2\2WX\7\37\2\2XY\7\4\2\2"+
		"Y_\7/\2\2Z^\5\4\3\2[^\5\6\4\2\\^\5\n\6\2]Z\3\2\2\2][\3\2\2\2]\\\3\2\2"+
		"\2^a\3\2\2\2_]\3\2\2\2_`\3\2\2\2`b\3\2\2\2a_\3\2\2\2bc\7\60\2\2cd\7\67"+
		"\2\2d\t\3\2\2\2ej\7\3\2\2fg\7\61\2\2gi\7\62\2\2hf\3\2\2\2il\3\2\2\2jh"+
		"\3\2\2\2jk\3\2\2\2km\3\2\2\2lj\3\2\2\2mp\7\f\2\2no\78\2\2oq\5:\36\2pn"+
		"\3\2\2\2pq\3\2\2\2qz\3\2\2\2rs\7\66\2\2sv\7\f\2\2tu\78\2\2uw\5:\36\2v"+
		"t\3\2\2\2vw\3\2\2\2wy\3\2\2\2xr\3\2\2\2y|\3\2\2\2zx\3\2\2\2z{\3\2\2\2"+
		"{}\3\2\2\2|z\3\2\2\2}~\7\67\2\2~\13\3\2\2\2\177\u0089\5\n\6\2\u0080\u0089"+
		"\5\16\b\2\u0081\u0089\5\20\t\2\u0082\u0089\5\22\n\2\u0083\u0089\5\24\13"+
		"\2\u0084\u0089\5\26\f\2\u0085\u0089\5\30\r\2\u0086\u0089\5\32\16\2\u0087"+
		"\u0089\5\34\17\2\u0088\177\3\2\2\2\u0088\u0080\3\2\2\2\u0088\u0081\3\2"+
		"\2\2\u0088\u0082\3\2\2\2\u0088\u0083\3\2\2\2\u0088\u0084\3\2\2\2\u0088"+
		"\u0085\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0087\3\2\2\2\u0089\r\3\2\2\2"+
		"\u008a\u008e\7/\2\2\u008b\u008d\5\f\7\2\u008c\u008b\3\2\2\2\u008d\u0090"+
		"\3\2\2\2\u008e\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0091\3\2\2\2\u0090"+
		"\u008e\3\2\2\2\u0091\u0092\7\60\2\2\u0092\17\3\2\2\2\u0093\u0094\7\27"+
		"\2\2\u0094\u0095\7\63\2\2\u0095\u0096\5:\36\2\u0096\u0097\7\64\2\2\u0097"+
		"\u009a\5\f\7\2\u0098\u0099\7\30\2\2\u0099\u009b\5\f\7\2\u009a\u0098\3"+
		"\2\2\2\u009a\u009b\3\2\2\2\u009b\21\3\2\2\2\u009c\u009d\7\32\2\2\u009d"+
		"\u009e\7\63\2\2\u009e\u009f\5:\36\2\u009f\u00a0\7\64\2\2\u00a0\u00a1\5"+
		"\f\7\2\u00a1\23\3\2\2\2\u00a2\u00a3\7\31\2\2\u00a3\u00a5\7\63\2\2\u00a4"+
		"\u00a6\5:\36\2\u00a5\u00a4\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a7\3\2"+
		"\2\2\u00a7\u00a9\7\67\2\2\u00a8\u00aa\5:\36\2\u00a9\u00a8\3\2\2\2\u00a9"+
		"\u00aa\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ac\7\67\2\2\u00ac\u00ad\5"+
		":\36\2\u00ad\u00ae\7\64\2\2\u00ae\u00af\5\f\7\2\u00af\25\3\2\2\2\u00b0"+
		"\u00b2\7\35\2\2\u00b1\u00b3\5:\36\2\u00b2\u00b1\3\2\2\2\u00b2\u00b3\3"+
		"\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b5\7\67\2\2\u00b5\27\3\2\2\2\u00b6"+
		"\u00b7\7\33\2\2\u00b7\u00b8\7\67\2\2\u00b8\31\3\2\2\2\u00b9\u00ba\7\34"+
		"\2\2\u00ba\u00bb\7\67\2\2\u00bb\33\3\2\2\2\u00bc\u00bd\5:\36\2\u00bd\u00be"+
		"\7\67\2\2\u00be\35\3\2\2\2\u00bf\u00c0\5<\37\2\u00c0\u00c1\t\3\2\2\u00c1"+
		"\u00c4\3\2\2\2\u00c2\u00c4\5<\37\2\u00c3\u00bf\3\2\2\2\u00c3\u00c2\3\2"+
		"\2\2\u00c4\37\3\2\2\2\u00c5\u00c6\t\4\2\2\u00c6\u00c9\5\36\20\2\u00c7"+
		"\u00c9\5\36\20\2\u00c8\u00c5\3\2\2\2\u00c8\u00c7\3\2\2\2\u00c9!\3\2\2"+
		"\2\u00ca\u00cb\5 \21\2\u00cb\u00cc\t\5\2\2\u00cc\u00ce\3\2\2\2\u00cd\u00ca"+
		"\3\2\2\2\u00ce\u00d1\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0"+
		"\u00d2\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d2\u00d5\5 \21\2\u00d3\u00d5\5 "+
		"\21\2\u00d4\u00cf\3\2\2\2\u00d4\u00d3\3\2\2\2\u00d5#\3\2\2\2\u00d6\u00d7"+
		"\5\"\22\2\u00d7\u00d8\t\6\2\2\u00d8\u00da\3\2\2\2\u00d9\u00d6\3\2\2\2"+
		"\u00da\u00dd\3\2\2\2\u00db\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00de"+
		"\3\2\2\2\u00dd\u00db\3\2\2\2\u00de\u00e1\5\"\22\2\u00df\u00e1\5\"\22\2"+
		"\u00e0\u00db\3\2\2\2\u00e0\u00df\3\2\2\2\u00e1%\3\2\2\2\u00e2\u00e3\5"+
		"$\23\2\u00e3\u00e4\t\7\2\2\u00e4\u00e6\3\2\2\2\u00e5\u00e2\3\2\2\2\u00e6"+
		"\u00e9\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00ea\3\2"+
		"\2\2\u00e9\u00e7\3\2\2\2\u00ea\u00ed\5$\23\2\u00eb\u00ed\5$\23\2\u00ec"+
		"\u00e7\3\2\2\2\u00ec\u00eb\3\2\2\2\u00ed\'\3\2\2\2\u00ee\u00ef\5&\24\2"+
		"\u00ef\u00f0\t\b\2\2\u00f0\u00f2\3\2\2\2\u00f1\u00ee\3\2\2\2\u00f2\u00f5"+
		"\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f6\3\2\2\2\u00f5"+
		"\u00f3\3\2\2\2\u00f6\u00f9\5&\24\2\u00f7\u00f9\5&\24\2\u00f8\u00f3\3\2"+
		"\2\2\u00f8\u00f7\3\2\2\2\u00f9)\3\2\2\2\u00fa\u00fb\5(\25\2\u00fb\u00fc"+
		"\t\t\2\2\u00fc\u00fe\3\2\2\2\u00fd\u00fa\3\2\2\2\u00fe\u0101\3\2\2\2\u00ff"+
		"\u00fd\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0102\3\2\2\2\u0101\u00ff\3\2"+
		"\2\2\u0102\u0105\5(\25\2\u0103\u0105\5(\25\2\u0104\u00ff\3\2\2\2\u0104"+
		"\u0103\3\2\2\2\u0105+\3\2\2\2\u0106\u0107\5*\26\2\u0107\u0108\7=\2\2\u0108"+
		"\u010a\3\2\2\2\u0109\u0106\3\2\2\2\u010a\u010d\3\2\2\2\u010b\u0109\3\2"+
		"\2\2\u010b\u010c\3\2\2\2\u010c\u010e\3\2\2\2\u010d\u010b\3\2\2\2\u010e"+
		"\u0111\5*\26\2\u010f\u0111\5*\26\2\u0110\u010b\3\2\2\2\u0110\u010f\3\2"+
		"\2\2\u0111-\3\2\2\2\u0112\u0113\5,\27\2\u0113\u0114\7?\2\2\u0114\u0116"+
		"\3\2\2\2\u0115\u0112\3\2\2\2\u0116\u0119\3\2\2\2\u0117\u0115\3\2\2\2\u0117"+
		"\u0118\3\2\2\2\u0118\u011a\3\2\2\2\u0119\u0117\3\2\2\2\u011a\u011d\5,"+
		"\27\2\u011b\u011d\5,\27\2\u011c\u0117\3\2\2\2\u011c\u011b\3\2\2\2\u011d"+
		"/\3\2\2\2\u011e\u011f\5.\30\2\u011f\u0120\7>\2\2\u0120\u0122\3\2\2\2\u0121"+
		"\u011e\3\2\2\2\u0122\u0125\3\2\2\2\u0123\u0121\3\2\2\2\u0123\u0124\3\2"+
		"\2\2\u0124\u0126\3\2\2\2\u0125\u0123\3\2\2\2\u0126\u0129\5.\30\2\u0127"+
		"\u0129\5.\30\2\u0128\u0123\3\2\2\2\u0128\u0127\3\2\2\2\u0129\61\3\2\2"+
		"\2\u012a\u012b\5\60\31\2\u012b\u012c\7A\2\2\u012c\u012e\3\2\2\2\u012d"+
		"\u012a\3\2\2\2\u012e\u0131\3\2\2\2\u012f\u012d\3\2\2\2\u012f\u0130\3\2"+
		"\2\2\u0130\u0132\3\2\2\2\u0131\u012f\3\2\2\2\u0132\u0135\5\60\31\2\u0133"+
		"\u0135\5\60\31\2\u0134\u012f\3\2\2\2\u0134\u0133\3\2\2\2\u0135\63\3\2"+
		"\2\2\u0136\u0137\5\62\32\2\u0137\u0138\7B\2\2\u0138\u013a\3\2\2\2\u0139"+
		"\u0136\3\2\2\2\u013a\u013d\3\2\2\2\u013b\u0139\3\2\2\2\u013b\u013c\3\2"+
		"\2\2\u013c\u013e\3\2\2\2\u013d\u013b\3\2\2\2\u013e\u0141\5\62\32\2\u013f"+
		"\u0141\5\62\32\2\u0140\u013b\3\2\2\2\u0140\u013f\3\2\2\2\u0141\65\3\2"+
		"\2\2\u0142\u0147\5\64\33\2\u0143\u0144\78\2\2\u0144\u0146\5\64\33\2\u0145"+
		"\u0143\3\2\2\2\u0146\u0149\3\2\2\2\u0147\u0145\3\2\2\2\u0147\u0148\3\2"+
		"\2\2\u0148\u014c\3\2\2\2\u0149\u0147\3\2\2\2\u014a\u014c\5\64\33\2\u014b"+
		"\u0142\3\2\2\2\u014b\u014a\3\2\2\2\u014c\67\3\2\2\2\u014d\u014e\5\66\34"+
		"\2\u014e\u014f\7\66\2\2\u014f\u0151\3\2\2\2\u0150\u014d\3\2\2\2\u0151"+
		"\u0154\3\2\2\2\u0152\u0150\3\2\2\2\u0152\u0153\3\2\2\2\u0153\u0155\3\2"+
		"\2\2\u0154\u0152\3\2\2\2\u0155\u0158\5\66\34\2\u0156\u0158\5\66\34\2\u0157"+
		"\u0152\3\2\2\2\u0157\u0156\3\2\2\2\u01589\3\2\2\2\u0159\u015a\58\35\2"+
		"\u015a;\3\2\2\2\u015b\u0165\7 \2\2\u015c\u0165\5B\"\2\u015d\u0165\5D#"+
		"\2\u015e\u015f\7\63\2\2\u015f\u0160\5:\36\2\u0160\u0161\7\64\2\2\u0161"+
		"\u0165\3\2\2\2\u0162\u0165\5@!\2\u0163\u0165\5> \2\u0164\u015b\3\2\2\2"+
		"\u0164\u015c\3\2\2\2\u0164\u015d\3\2\2\2\u0164\u015e\3\2\2\2\u0164\u0162"+
		"\3\2\2\2\u0164\u0163\3\2\2\2\u0165=\3\2\2\2\u0166\u0167\7\36\2\2\u0167"+
		"\u016e\7\3\2\2\u0168\u0169\7\61\2\2\u0169\u016a\5:\36\2\u016a\u016b\7"+
		"\62\2\2\u016b\u016d\3\2\2\2\u016c\u0168\3\2\2\2\u016d\u0170\3\2\2\2\u016e"+
		"\u016c\3\2\2\2\u016e\u016f\3\2\2\2\u016f\u0175\3\2\2\2\u0170\u016e\3\2"+
		"\2\2\u0171\u0172\7\61\2\2\u0172\u0174\7\62\2\2\u0173\u0171\3\2\2\2\u0174"+
		"\u0177\3\2\2\2\u0175\u0173\3\2\2\2\u0175\u0176\3\2\2\2\u0176\u017a\3\2"+
		"\2\2\u0177\u0175\3\2\2\2\u0178\u0179\7\63\2\2\u0179\u017b\7\64\2\2\u017a"+
		"\u0178\3\2\2\2\u017a\u017b\3\2\2\2\u017b?\3\2\2\2\u017c\u0183\7\5\2\2"+
		"\u017d\u017e\7\63\2\2\u017e\u0184\7\64\2\2\u017f\u0180\7\63\2\2\u0180"+
		"\u0181\5:\36\2\u0181\u0182\7\64\2\2\u0182\u0184\3\2\2\2\u0183\u017d\3"+
		"\2\2\2\u0183\u017f\3\2\2\2\u0184A\3\2\2\2\u0185\u0186\b\"\1\2\u0186\u0187"+
		"\7\f\2\2\u0187\u0192\3\2\2\2\u0188\u0189\f\3\2\2\u0189\u018a\7\65\2\2"+
		"\u018a\u0191\5B\"\4\u018b\u018c\f\4\2\2\u018c\u018d\7\61\2\2\u018d\u018e"+
		"\5:\36\2\u018e\u018f\7\62\2\2\u018f\u0191\3\2\2\2\u0190\u0188\3\2\2\2"+
		"\u0190\u018b\3\2\2\2\u0191\u0194\3\2\2\2\u0192\u0190\3\2\2\2\u0192\u0193"+
		"\3\2\2\2\u0193C\3\2\2\2\u0194\u0192\3\2\2\2\u0195\u0196\t\n\2\2\u0196"+
		"E\3\2\2\2\61IK]_jpvz\u0088\u008e\u009a\u00a5\u00a9\u00b2\u00c3\u00c8\u00cf"+
		"\u00d4\u00db\u00e0\u00e7\u00ec\u00f3\u00f8\u00ff\u0104\u010b\u0110\u0117"+
		"\u011c\u0123\u0128\u012f\u0134\u013b\u0140\u0147\u014b\u0152\u0157\u0164"+
		"\u016e\u0175\u017a\u0183\u0190\u0192";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}