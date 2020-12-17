// Generated from c:\Users\Anoxiacxy\Documents\GitHub\Compiler-MxStar\MxStar.g4 by ANTLR 4.8
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MxStarLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"TypeName", "ClassIdentifier", "FunctionIdentifier", "FundamentalType", 
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


	public MxStarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MxStar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2N\u01d0\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\3\2\3\2\3\2\3\2\5\2\u00a0\n\2\3\3\3\3\3\4"+
		"\3\4\3\5\3\5\3\5\3\5\5\5\u00aa\n\5\3\6\3\6\5\6\u00ae\n\6\3\7\5\7\u00b1"+
		"\n\7\3\7\6\7\u00b4\n\7\r\7\16\7\u00b5\3\b\3\b\7\b\u00ba\n\b\f\b\16\b\u00bd"+
		"\13\b\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00ca\n\n\3\13\3"+
		"\13\7\13\u00ce\n\13\f\13\16\13\u00d1\13\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r"+
		"\3\r\5\r\u00db\n\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00f0\n\16\3\17\3\17\3\17"+
		"\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22"+
		"\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27"+
		"\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\37\3\37\3\37\3\37\3\37\3 \3 \3!\3!\3!\3!\3!\5!\u0155\n!\3\"\3\"\3\""+
		"\3\"\3\"\3\"\5\"\u015d\n\"\3#\3#\3#\5#\u0162\n#\3$\3$\3$\3$\3$\3$\5$\u016a"+
		"\n$\3%\3%\3&\3&\5&\u0170\n&\3\'\3\'\3(\3(\5(\u0176\n(\3)\3)\3)\3)\5)\u017c"+
		"\n)\3*\3*\3+\3+\3,\3,\3-\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3"+
		"\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\38\38\38\39\39\3"+
		"9\3:\3:\3:\3;\3;\3;\3<\3<\3=\3=\3>\3>\3?\3?\3@\3@\3@\3A\3A\3A\3B\3B\3"+
		"C\3C\3D\3D\3E\3E\3E\3F\3F\3F\3G\3G\3G\3H\3H\3H\3I\3I\3J\3J\3K\3K\3L\3"+
		"L\3M\3M\2\2N\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16"+
		"\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34"+
		"\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g"+
		"\65i\66k\67m8o9q:s;u<w=y>{?}@\177A\u0081B\u0083C\u0085D\u0087E\u0089F"+
		"\u008bG\u008dH\u008fI\u0091J\u0093K\u0095L\u0097M\u0099N\3\2\7\3\2\62"+
		";\6\2\f\f\17\17$$^^\4\2C\\c|\3\2\f\f\6\2\62;C\\aac|\2\u0204\2\3\3\2\2"+
		"\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3"+
		"\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2"+
		"\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2"+
		"\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2"+
		"\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3"+
		"\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2"+
		"\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2"+
		"W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3"+
		"\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2"+
		"\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2"+
		"}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2"+
		"\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2\2\2\u008f"+
		"\3\2\2\2\2\u0091\3\2\2\2\2\u0093\3\2\2\2\2\u0095\3\2\2\2\2\u0097\3\2\2"+
		"\2\2\u0099\3\2\2\2\3\u009f\3\2\2\2\5\u00a1\3\2\2\2\7\u00a3\3\2\2\2\t\u00a9"+
		"\3\2\2\2\13\u00ad\3\2\2\2\r\u00b0\3\2\2\2\17\u00b7\3\2\2\2\21\u00c0\3"+
		"\2\2\2\23\u00c9\3\2\2\2\25\u00cb\3\2\2\2\27\u00d2\3\2\2\2\31\u00da\3\2"+
		"\2\2\33\u00ef\3\2\2\2\35\u00f1\3\2\2\2\37\u00f5\3\2\2\2!\u00fa\3\2\2\2"+
		"#\u0101\3\2\2\2%\u0106\3\2\2\2\'\u010b\3\2\2\2)\u0110\3\2\2\2+\u0116\3"+
		"\2\2\2-\u0119\3\2\2\2/\u011e\3\2\2\2\61\u0122\3\2\2\2\63\u0128\3\2\2\2"+
		"\65\u012e\3\2\2\2\67\u0137\3\2\2\29\u013e\3\2\2\2;\u0142\3\2\2\2=\u0148"+
		"\3\2\2\2?\u014d\3\2\2\2A\u0154\3\2\2\2C\u015c\3\2\2\2E\u0161\3\2\2\2G"+
		"\u0169\3\2\2\2I\u016b\3\2\2\2K\u016f\3\2\2\2M\u0171\3\2\2\2O\u0175\3\2"+
		"\2\2Q\u017b\3\2\2\2S\u017d\3\2\2\2U\u017f\3\2\2\2W\u0181\3\2\2\2Y\u0183"+
		"\3\2\2\2[\u0186\3\2\2\2]\u0188\3\2\2\2_\u018a\3\2\2\2a\u018c\3\2\2\2c"+
		"\u018e\3\2\2\2e\u0190\3\2\2\2g\u0192\3\2\2\2i\u0194\3\2\2\2k\u0196\3\2"+
		"\2\2m\u0198\3\2\2\2o\u019a\3\2\2\2q\u019d\3\2\2\2s\u01a0\3\2\2\2u\u01a3"+
		"\3\2\2\2w\u01a6\3\2\2\2y\u01a8\3\2\2\2{\u01aa\3\2\2\2}\u01ac\3\2\2\2\177"+
		"\u01ae\3\2\2\2\u0081\u01b1\3\2\2\2\u0083\u01b4\3\2\2\2\u0085\u01b6\3\2"+
		"\2\2\u0087\u01b8\3\2\2\2\u0089\u01ba\3\2\2\2\u008b\u01bd\3\2\2\2\u008d"+
		"\u01c0\3\2\2\2\u008f\u01c3\3\2\2\2\u0091\u01c6\3\2\2\2\u0093\u01c8\3\2"+
		"\2\2\u0095\u01ca\3\2\2\2\u0097\u01cc\3\2\2\2\u0099\u01ce\3\2\2\2\u009b"+
		"\u00a0\5\37\20\2\u009c\u00a0\5\35\17\2\u009d\u00a0\5!\21\2\u009e\u00a0"+
		"\5\5\3\2\u009f\u009b\3\2\2\2\u009f\u009c\3\2\2\2\u009f\u009d\3\2\2\2\u009f"+
		"\u009e\3\2\2\2\u00a0\4\3\2\2\2\u00a1\u00a2\5\25\13\2\u00a2\6\3\2\2\2\u00a3"+
		"\u00a4\5\25\13\2\u00a4\b\3\2\2\2\u00a5\u00aa\5\37\20\2\u00a6\u00aa\5\35"+
		"\17\2\u00a7\u00aa\5%\23\2\u00a8\u00aa\5!\21\2\u00a9\u00a5\3\2\2\2\u00a9"+
		"\u00a6\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00a8\3\2\2\2\u00aa\n\3\2\2\2"+
		"\u00ab\u00ae\5\'\24\2\u00ac\u00ae\5)\25\2\u00ad\u00ab\3\2\2\2\u00ad\u00ac"+
		"\3\2\2\2\u00ae\f\3\2\2\2\u00af\u00b1\7/\2\2\u00b0\u00af\3\2\2\2\u00b0"+
		"\u00b1\3\2\2\2\u00b1\u00b3\3\2\2\2\u00b2\u00b4\t\2\2\2\u00b3\u00b2\3\2"+
		"\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6"+
		"\16\3\2\2\2\u00b7\u00bb\7$\2\2\u00b8\u00ba\5\23\n\2\u00b9\u00b8\3\2\2"+
		"\2\u00ba\u00bd\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00be"+
		"\3\2\2\2\u00bd\u00bb\3\2\2\2\u00be\u00bf\7$\2\2\u00bf\20\3\2\2\2\u00c0"+
		"\u00c1\5#\22\2\u00c1\22\3\2\2\2\u00c2\u00ca\n\3\2\2\u00c3\u00c4\7^\2\2"+
		"\u00c4\u00ca\7p\2\2\u00c5\u00c6\7^\2\2\u00c6\u00ca\7^\2\2\u00c7\u00c8"+
		"\7^\2\2\u00c8\u00ca\7$\2\2\u00c9\u00c2\3\2\2\2\u00c9\u00c3\3\2\2\2\u00c9"+
		"\u00c5\3\2\2\2\u00c9\u00c7\3\2\2\2\u00ca\24\3\2\2\2\u00cb\u00cf\t\4\2"+
		"\2\u00cc\u00ce\5? \2\u00cd\u00cc\3\2\2\2\u00ce\u00d1\3\2\2\2\u00cf\u00cd"+
		"\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\26\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d2"+
		"\u00d3\5Y-\2\u00d3\u00d4\n\5\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d6\b\f\2"+
		"\2\u00d6\30\3\2\2\2\u00d7\u00db\5S*\2\u00d8\u00db\5W,\2\u00d9\u00db\5"+
		"U+\2\u00da\u00d7\3\2\2\2\u00da\u00d8\3\2\2\2\u00da\u00d9\3\2\2\2\u00db"+
		"\u00dc\3\2\2\2\u00dc\u00dd\b\r\2\2\u00dd\32\3\2\2\2\u00de\u00f0\5\35\17"+
		"\2\u00df\u00f0\5\37\20\2\u00e0\u00f0\5!\21\2\u00e1\u00f0\5#\22\2\u00e2"+
		"\u00f0\5%\23\2\u00e3\u00f0\5\'\24\2\u00e4\u00f0\5)\25\2\u00e5\u00f0\5"+
		"+\26\2\u00e6\u00f0\5-\27\2\u00e7\u00f0\5/\30\2\u00e8\u00f0\5\61\31\2\u00e9"+
		"\u00f0\5\63\32\2\u00ea\u00f0\5\65\33\2\u00eb\u00f0\5\67\34\2\u00ec\u00f0"+
		"\59\35\2\u00ed\u00f0\5;\36\2\u00ee\u00f0\5=\37\2\u00ef\u00de\3\2\2\2\u00ef"+
		"\u00df\3\2\2\2\u00ef\u00e0\3\2\2\2\u00ef\u00e1\3\2\2\2\u00ef\u00e2\3\2"+
		"\2\2\u00ef\u00e3\3\2\2\2\u00ef\u00e4\3\2\2\2\u00ef\u00e5\3\2\2\2\u00ef"+
		"\u00e6\3\2\2\2\u00ef\u00e7\3\2\2\2\u00ef\u00e8\3\2\2\2\u00ef\u00e9\3\2"+
		"\2\2\u00ef\u00ea\3\2\2\2\u00ef\u00eb\3\2\2\2\u00ef\u00ec\3\2\2\2\u00ef"+
		"\u00ed\3\2\2\2\u00ef\u00ee\3\2\2\2\u00f0\34\3\2\2\2\u00f1\u00f2\7k\2\2"+
		"\u00f2\u00f3\7p\2\2\u00f3\u00f4\7v\2\2\u00f4\36\3\2\2\2\u00f5\u00f6\7"+
		"d\2\2\u00f6\u00f7\7q\2\2\u00f7\u00f8\7q\2\2\u00f8\u00f9\7n\2\2\u00f9 "+
		"\3\2\2\2\u00fa\u00fb\7u\2\2\u00fb\u00fc\7v\2\2\u00fc\u00fd\7t\2\2\u00fd"+
		"\u00fe\7k\2\2\u00fe\u00ff\7p\2\2\u00ff\u0100\7i\2\2\u0100\"\3\2\2\2\u0101"+
		"\u0102\7p\2\2\u0102\u0103\7w\2\2\u0103\u0104\7n\2\2\u0104\u0105\7n\2\2"+
		"\u0105$\3\2\2\2\u0106\u0107\7x\2\2\u0107\u0108\7q\2\2\u0108\u0109\7k\2"+
		"\2\u0109\u010a\7f\2\2\u010a&\3\2\2\2\u010b\u010c\7v\2\2\u010c\u010d\7"+
		"t\2\2\u010d\u010e\7w\2\2\u010e\u010f\7g\2\2\u010f(\3\2\2\2\u0110\u0111"+
		"\7h\2\2\u0111\u0112\7c\2\2\u0112\u0113\7n\2\2\u0113\u0114\7u\2\2\u0114"+
		"\u0115\7g\2\2\u0115*\3\2\2\2\u0116\u0117\7k\2\2\u0117\u0118\7h\2\2\u0118"+
		",\3\2\2\2\u0119\u011a\7g\2\2\u011a\u011b\7n\2\2\u011b\u011c\7u\2\2\u011c"+
		"\u011d\7g\2\2\u011d.\3\2\2\2\u011e\u011f\7h\2\2\u011f\u0120\7q\2\2\u0120"+
		"\u0121\7t\2\2\u0121\60\3\2\2\2\u0122\u0123\7y\2\2\u0123\u0124\7j\2\2\u0124"+
		"\u0125\7k\2\2\u0125\u0126\7n\2\2\u0126\u0127\7g\2\2\u0127\62\3\2\2\2\u0128"+
		"\u0129\7d\2\2\u0129\u012a\7t\2\2\u012a\u012b\7g\2\2\u012b\u012c\7c\2\2"+
		"\u012c\u012d\7m\2\2\u012d\64\3\2\2\2\u012e\u012f\7e\2\2\u012f\u0130\7"+
		"q\2\2\u0130\u0131\7p\2\2\u0131\u0132\7v\2\2\u0132\u0133\7k\2\2\u0133\u0134"+
		"\7p\2\2\u0134\u0135\7w\2\2\u0135\u0136\7g\2\2\u0136\66\3\2\2\2\u0137\u0138"+
		"\7t\2\2\u0138\u0139\7g\2\2\u0139\u013a\7v\2\2\u013a\u013b\7w\2\2\u013b"+
		"\u013c\7t\2\2\u013c\u013d\7p\2\2\u013d8\3\2\2\2\u013e\u013f\7p\2\2\u013f"+
		"\u0140\7g\2\2\u0140\u0141\7y\2\2\u0141:\3\2\2\2\u0142\u0143\7e\2\2\u0143"+
		"\u0144\7n\2\2\u0144\u0145\7c\2\2\u0145\u0146\7u\2\2\u0146\u0147\7u\2\2"+
		"\u0147<\3\2\2\2\u0148\u0149\7v\2\2\u0149\u014a\7j\2\2\u014a\u014b\7k\2"+
		"\2\u014b\u014c\7u\2\2\u014c>\3\2\2\2\u014d\u014e\t\6\2\2\u014e@\3\2\2"+
		"\2\u014f\u0155\5\u0091I\2\u0150\u0155\5\u0093J\2\u0151\u0155\5\u0095K"+
		"\2\u0152\u0155\5\u0097L\2\u0153\u0155\5\u0099M\2\u0154\u014f\3\2\2\2\u0154"+
		"\u0150\3\2\2\2\u0154\u0151\3\2\2\2\u0154\u0152\3\2\2\2\u0154\u0153\3\2"+
		"\2\2\u0155B\3\2\2\2\u0156\u015d\5\u0085C\2\u0157\u015d\5\u0087D\2\u0158"+
		"\u015d\5\u0089E\2\u0159\u015d\5\u008bF\2\u015a\u015d\5\u008dG\2\u015b"+
		"\u015d\5\u008fH\2\u015c\u0156\3\2\2\2\u015c\u0157\3\2\2\2\u015c\u0158"+
		"\3\2\2\2\u015c\u0159\3\2\2\2\u015c\u015a\3\2\2\2\u015c\u015b\3\2\2\2\u015d"+
		"D\3\2\2\2\u015e\u0162\5\177@\2\u015f\u0162\5\u0081A\2\u0160\u0162\5\u0083"+
		"B\2\u0161\u015e\3\2\2\2\u0161\u015f\3\2\2\2\u0161\u0160\3\2\2\2\u0162"+
		"F\3\2\2\2\u0163\u016a\5s:\2\u0164\u016a\5u;\2\u0165\u016a\5w<\2\u0166"+
		"\u016a\5y=\2\u0167\u016a\5{>\2\u0168\u016a\5}?\2\u0169\u0163\3\2\2\2\u0169"+
		"\u0164\3\2\2\2\u0169\u0165\3\2\2\2\u0169\u0166\3\2\2\2\u0169\u0167\3\2"+
		"\2\2\u0169\u0168\3\2\2\2\u016aH\3\2\2\2\u016b\u016c\5m\67\2\u016cJ\3\2"+
		"\2\2\u016d\u0170\5o8\2\u016e\u0170\5q9\2\u016f\u016d\3\2\2\2\u016f\u016e"+
		"\3\2\2\2\u0170L\3\2\2\2\u0171\u0172\5g\64\2\u0172N\3\2\2\2\u0173\u0176"+
		"\5c\62\2\u0174\u0176\5e\63\2\u0175\u0173\3\2\2\2\u0175\u0174\3\2\2\2\u0176"+
		"P\3\2\2\2\u0177\u017c\5S*\2\u0178\u017c\5U+\2\u0179\u017c\5W,\2\u017a"+
		"\u017c\5Y-\2\u017b\u0177\3\2\2\2\u017b\u0178\3\2\2\2\u017b\u0179\3\2\2"+
		"\2\u017b\u017a\3\2\2\2\u017cR\3\2\2\2\u017d\u017e\7\"\2\2\u017eT\3\2\2"+
		"\2\u017f\u0180\7\f\2\2\u0180V\3\2\2\2\u0181\u0182\7\13\2\2\u0182X\3\2"+
		"\2\2\u0183\u0184\7\61\2\2\u0184\u0185\7\61\2\2\u0185Z\3\2\2\2\u0186\u0187"+
		"\7}\2\2\u0187\\\3\2\2\2\u0188\u0189\7\177\2\2\u0189^\3\2\2\2\u018a\u018b"+
		"\7]\2\2\u018b`\3\2\2\2\u018c\u018d\7_\2\2\u018db\3\2\2\2\u018e\u018f\7"+
		"*\2\2\u018fd\3\2\2\2\u0190\u0191\7+\2\2\u0191f\3\2\2\2\u0192\u0193\7\60"+
		"\2\2\u0193h\3\2\2\2\u0194\u0195\7.\2\2\u0195j\3\2\2\2\u0196\u0197\7=\2"+
		"\2\u0197l\3\2\2\2\u0198\u0199\7?\2\2\u0199n\3\2\2\2\u019a\u019b\7-\2\2"+
		"\u019b\u019c\7-\2\2\u019cp\3\2\2\2\u019d\u019e\7/\2\2\u019e\u019f\7/\2"+
		"\2\u019fr\3\2\2\2\u01a0\u01a1\7@\2\2\u01a1\u01a2\7@\2\2\u01a2t\3\2\2\2"+
		"\u01a3\u01a4\7>\2\2\u01a4\u01a5\7>\2\2\u01a5v\3\2\2\2\u01a6\u01a7\7(\2"+
		"\2\u01a7x\3\2\2\2\u01a8\u01a9\7~\2\2\u01a9z\3\2\2\2\u01aa\u01ab\7`\2\2"+
		"\u01ab|\3\2\2\2\u01ac\u01ad\7\u0080\2\2\u01ad~\3\2\2\2\u01ae\u01af\7("+
		"\2\2\u01af\u01b0\7(\2\2\u01b0\u0080\3\2\2\2\u01b1\u01b2\7~\2\2\u01b2\u01b3"+
		"\7~\2\2\u01b3\u0082\3\2\2\2\u01b4\u01b5\7#\2\2\u01b5\u0084\3\2\2\2\u01b6"+
		"\u01b7\7@\2\2\u01b7\u0086\3\2\2\2\u01b8\u01b9\7>\2\2\u01b9\u0088\3\2\2"+
		"\2\u01ba\u01bb\7@\2\2\u01bb\u01bc\7?\2\2\u01bc\u008a\3\2\2\2\u01bd\u01be"+
		"\7>\2\2\u01be\u01bf\7?\2\2\u01bf\u008c\3\2\2\2\u01c0\u01c1\7#\2\2\u01c1"+
		"\u01c2\7?\2\2\u01c2\u008e\3\2\2\2\u01c3\u01c4\7?\2\2\u01c4\u01c5\7?\2"+
		"\2\u01c5\u0090\3\2\2\2\u01c6\u01c7\7-\2\2\u01c7\u0092\3\2\2\2\u01c8\u01c9"+
		"\7/\2\2\u01c9\u0094\3\2\2\2\u01ca\u01cb\7,\2\2\u01cb\u0096\3\2\2\2\u01cc"+
		"\u01cd\7\61\2\2\u01cd\u0098\3\2\2\2\u01ce\u01cf\7\'\2\2\u01cf\u009a\3"+
		"\2\2\2\24\2\u009f\u00a9\u00ad\u00b0\u00b5\u00bb\u00c9\u00cf\u00da\u00ef"+
		"\u0154\u015c\u0161\u0169\u016f\u0175\u017b\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}