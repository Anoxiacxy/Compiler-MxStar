// Generated from /Users/anoxiacxy/Documents/GitHub/Compiler-MxStar/src/Parser/MxStar.g4 by ANTLR 4.9
package Parser;
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
	static { RuntimeMetaData.checkVersion("4.9", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		BoolLiteral=1, IntegerLiteral=2, StringLiteral=3, NullLiteral=4, Comment=5, 
		WhiteSpace=6, Int=7, Bool=8, String=9, Null=10, Void=11, True=12, False=13, 
		If=14, Else=15, For=16, While=17, Break=18, Continue=19, Return=20, New=21, 
		Class=22, This=23, Identifier=24, Space=25, NewLine=26, Tab=27, CommentSymbol=28, 
		LeftCommentSymbol=29, RightCommentSymbol=30, LeftBrace=31, RightBrace=32, 
		LeftBracket=33, RightBracket=34, LeftParenthesis=35, RightParenthesis=36, 
		Dot=37, Comma=38, Semi=39, Assign=40, PlusPlus=41, MinusMinus=42, RightShift=43, 
		LeftShift=44, BitwiseAnd=45, BitwiseOr=46, BitwiseXor=47, BitwiseNeg=48, 
		LogicalAnd=49, LogicalOr=50, LogicalNeg=51, Greater=52, Less=53, GreaterEqual=54, 
		LessEqual=55, NotEqual=56, Equal=57, Plus=58, Minus=59, Mul=60, Div=61, 
		Mod=62;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"BoolLiteral", "IntegerLiteral", "StringLiteral", "NullLiteral", "PrintableChar", 
			"Comment", "WhiteSpace", "Int", "Bool", "String", "Null", "Void", "True", 
			"False", "If", "Else", "For", "While", "Break", "Continue", "Return", 
			"New", "Class", "This", "Identifier", "IdentifierSymbol", "Space", "NewLine", 
			"Tab", "CommentSymbol", "LeftCommentSymbol", "RightCommentSymbol", "LeftBrace", 
			"RightBrace", "LeftBracket", "RightBracket", "LeftParenthesis", "RightParenthesis", 
			"Dot", "Comma", "Semi", "Assign", "PlusPlus", "MinusMinus", "RightShift", 
			"LeftShift", "BitwiseAnd", "BitwiseOr", "BitwiseXor", "BitwiseNeg", "LogicalAnd", 
			"LogicalOr", "LogicalNeg", "Greater", "Less", "GreaterEqual", "LessEqual", 
			"NotEqual", "Equal", "Plus", "Minus", "Mul", "Div", "Mod"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, "'int'", "'bool'", "'string'", 
			"'null'", "'void'", "'true'", "'false'", "'if'", "'else'", "'for'", "'while'", 
			"'break'", "'continue'", "'return'", "'new'", "'class'", "'this'", null, 
			"' '", "'\n'", "'\t'", "'//'", "'/*'", "'*/'", "'{'", "'}'", "'['", "']'", 
			"'('", "')'", "'.'", "','", "';'", "'='", "'++'", "'--'", "'>>'", "'<<'", 
			"'&'", "'|'", "'^'", "'~'", "'&&'", "'||'", "'!'", "'>'", "'<'", "'>='", 
			"'<='", "'!='", "'=='", "'+'", "'-'", "'*'", "'/'", "'%'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "BoolLiteral", "IntegerLiteral", "StringLiteral", "NullLiteral", 
			"Comment", "WhiteSpace", "Int", "Bool", "String", "Null", "Void", "True", 
			"False", "If", "Else", "For", "While", "Break", "Continue", "Return", 
			"New", "Class", "This", "Identifier", "Space", "NewLine", "Tab", "CommentSymbol", 
			"LeftCommentSymbol", "RightCommentSymbol", "LeftBrace", "RightBrace", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2@\u0179\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\3\2\3\2\5\2\u0086\n\2\3\3\6\3\u0089\n\3\r\3\16"+
		"\3\u008a\3\4\3\4\7\4\u008f\n\4\f\4\16\4\u0092\13\4\3\4\3\4\3\5\3\5\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u009f\n\6\3\7\3\7\7\7\u00a3\n\7\f\7\16\7"+
		"\u00a6\13\7\3\7\3\7\7\7\u00aa\n\7\f\7\16\7\u00ad\13\7\3\7\3\7\5\7\u00b1"+
		"\n\7\3\7\3\7\3\b\3\b\3\b\5\b\u00b8\n\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n"+
		"\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3"+
		"\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3"+
		"\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3"+
		"\32\3\32\7\32\u011a\n\32\f\32\16\32\u011d\13\32\3\33\3\33\3\34\3\34\3"+
		"\35\3\35\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \3!\3!\3!\3\"\3\"\3#\3#\3$\3"+
		"$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3,\3-\3-\3-\3.\3."+
		"\3.\3/\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\64\3"+
		"\65\3\65\3\65\3\66\3\66\3\67\3\67\38\38\39\39\39\3:\3:\3:\3;\3;\3;\3<"+
		"\3<\3<\3=\3=\3>\3>\3?\3?\3@\3@\3A\3A\3\u00ab\2B\3\3\5\4\7\5\t\6\13\2\r"+
		"\7\17\b\21\t\23\n\25\13\27\f\31\r\33\16\35\17\37\20!\21#\22%\23\'\24)"+
		"\25+\26-\27/\30\61\31\63\32\65\2\67\339\34;\35=\36?\37A C!E\"G#I$K%M&"+
		"O\'Q(S)U*W+Y,[-]._/a\60c\61e\62g\63i\64k\65m\66o\67q8s9u:w;y<{=}>\177"+
		"?\u0081@\3\2\7\3\2\62;\6\2\f\f\17\17$$^^\3\2\f\f\4\2C\\c|\6\2\62;C\\a"+
		"ac|\2\u0182\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2"+
		"\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2"+
		"\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2"+
		"\2\61\3\2\2\2\2\63\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2"+
		"\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2"+
		"K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3"+
		"\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2"+
		"\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2"+
		"q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3"+
		"\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\3\u0085\3\2\2\2\5\u0088\3\2\2\2\7"+
		"\u008c\3\2\2\2\t\u0095\3\2\2\2\13\u009e\3\2\2\2\r\u00b0\3\2\2\2\17\u00b7"+
		"\3\2\2\2\21\u00bb\3\2\2\2\23\u00bf\3\2\2\2\25\u00c4\3\2\2\2\27\u00cb\3"+
		"\2\2\2\31\u00d0\3\2\2\2\33\u00d5\3\2\2\2\35\u00da\3\2\2\2\37\u00e0\3\2"+
		"\2\2!\u00e3\3\2\2\2#\u00e8\3\2\2\2%\u00ec\3\2\2\2\'\u00f2\3\2\2\2)\u00f8"+
		"\3\2\2\2+\u0101\3\2\2\2-\u0108\3\2\2\2/\u010c\3\2\2\2\61\u0112\3\2\2\2"+
		"\63\u0117\3\2\2\2\65\u011e\3\2\2\2\67\u0120\3\2\2\29\u0122\3\2\2\2;\u0124"+
		"\3\2\2\2=\u0126\3\2\2\2?\u0129\3\2\2\2A\u012c\3\2\2\2C\u012f\3\2\2\2E"+
		"\u0131\3\2\2\2G\u0133\3\2\2\2I\u0135\3\2\2\2K\u0137\3\2\2\2M\u0139\3\2"+
		"\2\2O\u013b\3\2\2\2Q\u013d\3\2\2\2S\u013f\3\2\2\2U\u0141\3\2\2\2W\u0143"+
		"\3\2\2\2Y\u0146\3\2\2\2[\u0149\3\2\2\2]\u014c\3\2\2\2_\u014f\3\2\2\2a"+
		"\u0151\3\2\2\2c\u0153\3\2\2\2e\u0155\3\2\2\2g\u0157\3\2\2\2i\u015a\3\2"+
		"\2\2k\u015d\3\2\2\2m\u015f\3\2\2\2o\u0161\3\2\2\2q\u0163\3\2\2\2s\u0166"+
		"\3\2\2\2u\u0169\3\2\2\2w\u016c\3\2\2\2y\u016f\3\2\2\2{\u0171\3\2\2\2}"+
		"\u0173\3\2\2\2\177\u0175\3\2\2\2\u0081\u0177\3\2\2\2\u0083\u0086\5\33"+
		"\16\2\u0084\u0086\5\35\17\2\u0085\u0083\3\2\2\2\u0085\u0084\3\2\2\2\u0086"+
		"\4\3\2\2\2\u0087\u0089\t\2\2\2\u0088\u0087\3\2\2\2\u0089\u008a\3\2\2\2"+
		"\u008a\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\6\3\2\2\2\u008c\u0090\7"+
		"$\2\2\u008d\u008f\5\13\6\2\u008e\u008d\3\2\2\2\u008f\u0092\3\2\2\2\u0090"+
		"\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0093\3\2\2\2\u0092\u0090\3\2"+
		"\2\2\u0093\u0094\7$\2\2\u0094\b\3\2\2\2\u0095\u0096\5\27\f\2\u0096\n\3"+
		"\2\2\2\u0097\u009f\n\3\2\2\u0098\u0099\7^\2\2\u0099\u009f\7p\2\2\u009a"+
		"\u009b\7^\2\2\u009b\u009f\7^\2\2\u009c\u009d\7^\2\2\u009d\u009f\7$\2\2"+
		"\u009e\u0097\3\2\2\2\u009e\u0098\3\2\2\2\u009e\u009a\3\2\2\2\u009e\u009c"+
		"\3\2\2\2\u009f\f\3\2\2\2\u00a0\u00a4\5=\37\2\u00a1\u00a3\n\4\2\2\u00a2"+
		"\u00a1\3\2\2\2\u00a3\u00a6\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2"+
		"\2\2\u00a5\u00b1\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a7\u00ab\5? \2\u00a8\u00aa"+
		"\13\2\2\2\u00a9\u00a8\3\2\2\2\u00aa\u00ad\3\2\2\2\u00ab\u00ac\3\2\2\2"+
		"\u00ab\u00a9\3\2\2\2\u00ac\u00ae\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ae\u00af"+
		"\5A!\2\u00af\u00b1\3\2\2\2\u00b0\u00a0\3\2\2\2\u00b0\u00a7\3\2\2\2\u00b1"+
		"\u00b2\3\2\2\2\u00b2\u00b3\b\7\2\2\u00b3\16\3\2\2\2\u00b4\u00b8\5\67\34"+
		"\2\u00b5\u00b8\5;\36\2\u00b6\u00b8\59\35\2\u00b7\u00b4\3\2\2\2\u00b7\u00b5"+
		"\3\2\2\2\u00b7\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00ba\b\b\2\2\u00ba"+
		"\20\3\2\2\2\u00bb\u00bc\7k\2\2\u00bc\u00bd\7p\2\2\u00bd\u00be\7v\2\2\u00be"+
		"\22\3\2\2\2\u00bf\u00c0\7d\2\2\u00c0\u00c1\7q\2\2\u00c1\u00c2\7q\2\2\u00c2"+
		"\u00c3\7n\2\2\u00c3\24\3\2\2\2\u00c4\u00c5\7u\2\2\u00c5\u00c6\7v\2\2\u00c6"+
		"\u00c7\7t\2\2\u00c7\u00c8\7k\2\2\u00c8\u00c9\7p\2\2\u00c9\u00ca\7i\2\2"+
		"\u00ca\26\3\2\2\2\u00cb\u00cc\7p\2\2\u00cc\u00cd\7w\2\2\u00cd\u00ce\7"+
		"n\2\2\u00ce\u00cf\7n\2\2\u00cf\30\3\2\2\2\u00d0\u00d1\7x\2\2\u00d1\u00d2"+
		"\7q\2\2\u00d2\u00d3\7k\2\2\u00d3\u00d4\7f\2\2\u00d4\32\3\2\2\2\u00d5\u00d6"+
		"\7v\2\2\u00d6\u00d7\7t\2\2\u00d7\u00d8\7w\2\2\u00d8\u00d9\7g\2\2\u00d9"+
		"\34\3\2\2\2\u00da\u00db\7h\2\2\u00db\u00dc\7c\2\2\u00dc\u00dd\7n\2\2\u00dd"+
		"\u00de\7u\2\2\u00de\u00df\7g\2\2\u00df\36\3\2\2\2\u00e0\u00e1\7k\2\2\u00e1"+
		"\u00e2\7h\2\2\u00e2 \3\2\2\2\u00e3\u00e4\7g\2\2\u00e4\u00e5\7n\2\2\u00e5"+
		"\u00e6\7u\2\2\u00e6\u00e7\7g\2\2\u00e7\"\3\2\2\2\u00e8\u00e9\7h\2\2\u00e9"+
		"\u00ea\7q\2\2\u00ea\u00eb\7t\2\2\u00eb$\3\2\2\2\u00ec\u00ed\7y\2\2\u00ed"+
		"\u00ee\7j\2\2\u00ee\u00ef\7k\2\2\u00ef\u00f0\7n\2\2\u00f0\u00f1\7g\2\2"+
		"\u00f1&\3\2\2\2\u00f2\u00f3\7d\2\2\u00f3\u00f4\7t\2\2\u00f4\u00f5\7g\2"+
		"\2\u00f5\u00f6\7c\2\2\u00f6\u00f7\7m\2\2\u00f7(\3\2\2\2\u00f8\u00f9\7"+
		"e\2\2\u00f9\u00fa\7q\2\2\u00fa\u00fb\7p\2\2\u00fb\u00fc\7v\2\2\u00fc\u00fd"+
		"\7k\2\2\u00fd\u00fe\7p\2\2\u00fe\u00ff\7w\2\2\u00ff\u0100\7g\2\2\u0100"+
		"*\3\2\2\2\u0101\u0102\7t\2\2\u0102\u0103\7g\2\2\u0103\u0104\7v\2\2\u0104"+
		"\u0105\7w\2\2\u0105\u0106\7t\2\2\u0106\u0107\7p\2\2\u0107,\3\2\2\2\u0108"+
		"\u0109\7p\2\2\u0109\u010a\7g\2\2\u010a\u010b\7y\2\2\u010b.\3\2\2\2\u010c"+
		"\u010d\7e\2\2\u010d\u010e\7n\2\2\u010e\u010f\7c\2\2\u010f\u0110\7u\2\2"+
		"\u0110\u0111\7u\2\2\u0111\60\3\2\2\2\u0112\u0113\7v\2\2\u0113\u0114\7"+
		"j\2\2\u0114\u0115\7k\2\2\u0115\u0116\7u\2\2\u0116\62\3\2\2\2\u0117\u011b"+
		"\t\5\2\2\u0118\u011a\5\65\33\2\u0119\u0118\3\2\2\2\u011a\u011d\3\2\2\2"+
		"\u011b\u0119\3\2\2\2\u011b\u011c\3\2\2\2\u011c\64\3\2\2\2\u011d\u011b"+
		"\3\2\2\2\u011e\u011f\t\6\2\2\u011f\66\3\2\2\2\u0120\u0121\7\"\2\2\u0121"+
		"8\3\2\2\2\u0122\u0123\7\f\2\2\u0123:\3\2\2\2\u0124\u0125\7\13\2\2\u0125"+
		"<\3\2\2\2\u0126\u0127\7\61\2\2\u0127\u0128\7\61\2\2\u0128>\3\2\2\2\u0129"+
		"\u012a\7\61\2\2\u012a\u012b\7,\2\2\u012b@\3\2\2\2\u012c\u012d\7,\2\2\u012d"+
		"\u012e\7\61\2\2\u012eB\3\2\2\2\u012f\u0130\7}\2\2\u0130D\3\2\2\2\u0131"+
		"\u0132\7\177\2\2\u0132F\3\2\2\2\u0133\u0134\7]\2\2\u0134H\3\2\2\2\u0135"+
		"\u0136\7_\2\2\u0136J\3\2\2\2\u0137\u0138\7*\2\2\u0138L\3\2\2\2\u0139\u013a"+
		"\7+\2\2\u013aN\3\2\2\2\u013b\u013c\7\60\2\2\u013cP\3\2\2\2\u013d\u013e"+
		"\7.\2\2\u013eR\3\2\2\2\u013f\u0140\7=\2\2\u0140T\3\2\2\2\u0141\u0142\7"+
		"?\2\2\u0142V\3\2\2\2\u0143\u0144\7-\2\2\u0144\u0145\7-\2\2\u0145X\3\2"+
		"\2\2\u0146\u0147\7/\2\2\u0147\u0148\7/\2\2\u0148Z\3\2\2\2\u0149\u014a"+
		"\7@\2\2\u014a\u014b\7@\2\2\u014b\\\3\2\2\2\u014c\u014d\7>\2\2\u014d\u014e"+
		"\7>\2\2\u014e^\3\2\2\2\u014f\u0150\7(\2\2\u0150`\3\2\2\2\u0151\u0152\7"+
		"~\2\2\u0152b\3\2\2\2\u0153\u0154\7`\2\2\u0154d\3\2\2\2\u0155\u0156\7\u0080"+
		"\2\2\u0156f\3\2\2\2\u0157\u0158\7(\2\2\u0158\u0159\7(\2\2\u0159h\3\2\2"+
		"\2\u015a\u015b\7~\2\2\u015b\u015c\7~\2\2\u015cj\3\2\2\2\u015d\u015e\7"+
		"#\2\2\u015el\3\2\2\2\u015f\u0160\7@\2\2\u0160n\3\2\2\2\u0161\u0162\7>"+
		"\2\2\u0162p\3\2\2\2\u0163\u0164\7@\2\2\u0164\u0165\7?\2\2\u0165r\3\2\2"+
		"\2\u0166\u0167\7>\2\2\u0167\u0168\7?\2\2\u0168t\3\2\2\2\u0169\u016a\7"+
		"#\2\2\u016a\u016b\7?\2\2\u016bv\3\2\2\2\u016c\u016d\7?\2\2\u016d\u016e"+
		"\7?\2\2\u016ex\3\2\2\2\u016f\u0170\7-\2\2\u0170z\3\2\2\2\u0171\u0172\7"+
		"/\2\2\u0172|\3\2\2\2\u0173\u0174\7,\2\2\u0174~\3\2\2\2\u0175\u0176\7\61"+
		"\2\2\u0176\u0080\3\2\2\2\u0177\u0178\7\'\2\2\u0178\u0082\3\2\2\2\f\2\u0085"+
		"\u008a\u0090\u009e\u00a4\u00ab\u00b0\u00b7\u011b\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}