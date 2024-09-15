// Generated from NayLang.g4 by ANTLR 4.7.1
package br.com.nay.naylanguage.parser;

	import br.com.nay.naylanguage.datastructures.NaySymbol;
	import br.com.nay.naylanguage.datastructures.NayVariable;
	import br.com.nay.naylanguage.datastructures.NaySymbolTable;
	import br.com.nay.naylanguage.exceptions.NaySemanticException;
	import br.com.nay.naylanguage.ast.NayProgram;
	import br.com.nay.naylanguage.ast.AbstractCommand;
	import br.com.nay.naylanguage.ast.ReadCommand;
	import br.com.nay.naylanguage.ast.WriteCommand;
	import br.com.nay.naylanguage.ast.AttributionCommand;
	import br.com.nay.naylanguage.ast.DecisionCommand;
	import java.util.ArrayList;
	import java.util.Stack;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class NayLangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		AP=10, FP=11, SC=12, OP=13, ATTR=14, VIR=15, ACH=16, FCH=17, OPREL=18, 
		STRING=19, ID=20, NUMBER=21, WS=22;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"AP", "FP", "SC", "OP", "ATTR", "VIR", "ACH", "FCH", "OPREL", "STRING", 
		"ID", "NUMBER", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'programa'", "'fimprog;'", "'inteiro'", "'double'", "'texto'", 
		"'leia'", "'escreva'", "'se'", "'senao'", "'('", "')'", "';'", null, "'='", 
		"','", "'{'", "'}'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, "AP", "FP", 
		"SC", "OP", "ATTR", "VIR", "ACH", "FCH", "OPREL", "STRING", "ID", "NUMBER", 
		"WS"
	};
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


		private int _tipo;
		private String _varName;
		private String _varValue;
		private NaySymbolTable symbolTable = new NaySymbolTable();
		private NaySymbol symbol;
		private NayProgram program = new NayProgram(); 
		private ArrayList<AbstractCommand> curThread;
		private Stack<ArrayList<AbstractCommand>> stack = new Stack<ArrayList<AbstractCommand>>();
		private String _readID;
		private String _writeID;
		private String _exprID;
		private String _exprContent;
		private String _exprDecision;
		private ArrayList<AbstractCommand> listaTrue;
		private ArrayList<AbstractCommand> listaFalse;
		
		public void verificaID(String id){
			if (!symbolTable.exists(id)){
				throw new NaySemanticException("Symbol "+id+" not declared");
			}
		}
		
		public void exibeComandos() {
			for (AbstractCommand c: program.getComandos()) {
				System.out.println(c);
			}
		}
		
		public void generateCode() {
			program.generateTarget();
		}


	public NayLangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "NayLang.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\30\u00aa\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20"+
		"\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\5\23\u0086\n\23\3\24\3\24\3\24\3\24\7\24\u008c\n\24\f\24\16\24\u008f"+
		"\13\24\3\24\3\24\3\25\3\25\7\25\u0095\n\25\f\25\16\25\u0098\13\25\3\26"+
		"\6\26\u009b\n\26\r\26\16\26\u009c\3\26\3\26\6\26\u00a1\n\26\r\26\16\26"+
		"\u00a2\5\26\u00a5\n\26\3\27\3\27\3\27\3\27\2\2\30\3\3\5\4\7\5\t\6\13\7"+
		"\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26+\27-\30\3\2\t\5\2,-//\61\61\4\2>>@@\4\2$$^^\3\2c|\5\2\62;C\\c|\3"+
		"\2\62;\5\2\13\f\17\17\"\"\2\u00b3\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2"+
		"\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2"+
		"\2\2+\3\2\2\2\2-\3\2\2\2\3/\3\2\2\2\58\3\2\2\2\7A\3\2\2\2\tI\3\2\2\2\13"+
		"P\3\2\2\2\rV\3\2\2\2\17[\3\2\2\2\21c\3\2\2\2\23f\3\2\2\2\25l\3\2\2\2\27"+
		"n\3\2\2\2\31p\3\2\2\2\33r\3\2\2\2\35t\3\2\2\2\37v\3\2\2\2!x\3\2\2\2#z"+
		"\3\2\2\2%\u0085\3\2\2\2\'\u0087\3\2\2\2)\u0092\3\2\2\2+\u009a\3\2\2\2"+
		"-\u00a6\3\2\2\2/\60\7r\2\2\60\61\7t\2\2\61\62\7q\2\2\62\63\7i\2\2\63\64"+
		"\7t\2\2\64\65\7c\2\2\65\66\7o\2\2\66\67\7c\2\2\67\4\3\2\2\289\7h\2\29"+
		":\7k\2\2:;\7o\2\2;<\7r\2\2<=\7t\2\2=>\7q\2\2>?\7i\2\2?@\7=\2\2@\6\3\2"+
		"\2\2AB\7k\2\2BC\7p\2\2CD\7v\2\2DE\7g\2\2EF\7k\2\2FG\7t\2\2GH\7q\2\2H\b"+
		"\3\2\2\2IJ\7f\2\2JK\7q\2\2KL\7w\2\2LM\7d\2\2MN\7n\2\2NO\7g\2\2O\n\3\2"+
		"\2\2PQ\7v\2\2QR\7g\2\2RS\7z\2\2ST\7v\2\2TU\7q\2\2U\f\3\2\2\2VW\7n\2\2"+
		"WX\7g\2\2XY\7k\2\2YZ\7c\2\2Z\16\3\2\2\2[\\\7g\2\2\\]\7u\2\2]^\7e\2\2^"+
		"_\7t\2\2_`\7g\2\2`a\7x\2\2ab\7c\2\2b\20\3\2\2\2cd\7u\2\2de\7g\2\2e\22"+
		"\3\2\2\2fg\7u\2\2gh\7g\2\2hi\7p\2\2ij\7c\2\2jk\7q\2\2k\24\3\2\2\2lm\7"+
		"*\2\2m\26\3\2\2\2no\7+\2\2o\30\3\2\2\2pq\7=\2\2q\32\3\2\2\2rs\t\2\2\2"+
		"s\34\3\2\2\2tu\7?\2\2u\36\3\2\2\2vw\7.\2\2w \3\2\2\2xy\7}\2\2y\"\3\2\2"+
		"\2z{\7\177\2\2{$\3\2\2\2|\u0086\t\3\2\2}~\7@\2\2~\u0086\7?\2\2\177\u0080"+
		"\7>\2\2\u0080\u0086\7?\2\2\u0081\u0082\7?\2\2\u0082\u0086\7?\2\2\u0083"+
		"\u0084\7#\2\2\u0084\u0086\7?\2\2\u0085|\3\2\2\2\u0085}\3\2\2\2\u0085\177"+
		"\3\2\2\2\u0085\u0081\3\2\2\2\u0085\u0083\3\2\2\2\u0086&\3\2\2\2\u0087"+
		"\u008d\7$\2\2\u0088\u0089\7^\2\2\u0089\u008c\13\2\2\2\u008a\u008c\n\4"+
		"\2\2\u008b\u0088\3\2\2\2\u008b\u008a\3\2\2\2\u008c\u008f\3\2\2\2\u008d"+
		"\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u0090\3\2\2\2\u008f\u008d\3\2"+
		"\2\2\u0090\u0091\7$\2\2\u0091(\3\2\2\2\u0092\u0096\t\5\2\2\u0093\u0095"+
		"\t\6\2\2\u0094\u0093\3\2\2\2\u0095\u0098\3\2\2\2\u0096\u0094\3\2\2\2\u0096"+
		"\u0097\3\2\2\2\u0097*\3\2\2\2\u0098\u0096\3\2\2\2\u0099\u009b\t\7\2\2"+
		"\u009a\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d"+
		"\3\2\2\2\u009d\u00a4\3\2\2\2\u009e\u00a0\7\60\2\2\u009f\u00a1\t\7\2\2"+
		"\u00a0\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3"+
		"\3\2\2\2\u00a3\u00a5\3\2\2\2\u00a4\u009e\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5"+
		",\3\2\2\2\u00a6\u00a7\t\b\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a9\b\27\2\2"+
		"\u00a9.\3\2\2\2\13\2\u0085\u008b\u008d\u0094\u0096\u009c\u00a2\u00a4\3"+
		"\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}