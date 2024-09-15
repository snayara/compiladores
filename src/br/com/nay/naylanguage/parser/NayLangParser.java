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

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class NayLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		AP=10, FP=11, SC=12, OP=13, ATTR=14, VIR=15, ACH=16, FCH=17, OPREL=18, 
		STRING=19, ID=20, NUMBER=21, WS=22;
	public static final int
		RULE_prog = 0, RULE_decl = 1, RULE_declaravar = 2, RULE_tipo = 3, RULE_bloco = 4, 
		RULE_cmd = 5, RULE_cmdleitura = 6, RULE_cmdescrita = 7, RULE_cmdattrib = 8, 
		RULE_cmdselecao = 9, RULE_expr = 10, RULE_termo = 11;
	public static final String[] ruleNames = {
		"prog", "decl", "declaravar", "tipo", "bloco", "cmd", "cmdleitura", "cmdescrita", 
		"cmdattrib", "cmdselecao", "expr", "termo"
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

	@Override
	public String getGrammarFileName() { return "NayLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


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

	public NayLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NayLangListener ) ((NayLangListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NayLangListener ) ((NayLangListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			match(T__0);
			setState(25);
			decl();
			setState(26);
			bloco();
			setState(27);
			match(T__1);
			 	
						program.setVarTable(symbolTable);
						program.setComandos(stack.pop()); 
					
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

	public static class DeclContext extends ParserRuleContext {
		public List<DeclaravarContext> declaravar() {
			return getRuleContexts(DeclaravarContext.class);
		}
		public DeclaravarContext declaravar(int i) {
			return getRuleContext(DeclaravarContext.class,i);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NayLangListener ) ((NayLangListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NayLangListener ) ((NayLangListener)listener).exitDecl(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(30);
				declaravar();
				}
				}
				setState(33); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4))) != 0) );
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

	public static class DeclaravarContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(NayLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(NayLangParser.ID, i);
		}
		public TerminalNode SC() { return getToken(NayLangParser.SC, 0); }
		public List<TerminalNode> VIR() { return getTokens(NayLangParser.VIR); }
		public TerminalNode VIR(int i) {
			return getToken(NayLangParser.VIR, i);
		}
		public DeclaravarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaravar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NayLangListener ) ((NayLangListener)listener).enterDeclaravar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NayLangListener ) ((NayLangListener)listener).exitDeclaravar(this);
		}
	}

	public final DeclaravarContext declaravar() throws RecognitionException {
		DeclaravarContext _localctx = new DeclaravarContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaravar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			tipo();
			setState(36);
			match(ID);

				                  _varName = _input.LT(-1).getText();
				                  _varValue = null;
				                  symbol = new NayVariable(_varName, _tipo, _varValue);
				                  if (!symbolTable.exists(_varName)){
				                     symbolTable.add(symbol);	
				                  }
				                  else{
				                  	 throw new NaySemanticException("Symbol "+_varName+" already declared");
				                  }
			                    
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIR) {
				{
				{
				setState(38);
				match(VIR);
				setState(39);
				match(ID);

					                  _varName = _input.LT(-1).getText();
					                  _varValue = null;
					                  symbol = new NayVariable(_varName, _tipo, _varValue);
					                  if (!symbolTable.exists(_varName)){
					                     symbolTable.add(symbol);	
					                  }
					                  else{
					                  	 throw new NaySemanticException("Symbol "+_varName+" already declared");
					                  }
				                    
				}
				}
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(46);
			match(SC);
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

	public static class TipoContext extends ParserRuleContext {
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NayLangListener ) ((NayLangListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NayLangListener ) ((NayLangListener)listener).exitTipo(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_tipo);
		try {
			setState(54);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(48);
				match(T__2);
				_tipo = NayVariable.NUMBER;
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(50);
				match(T__3);
				_tipo = NayVariable.DOUBLE;
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 3);
				{
				setState(52);
				match(T__4);
				_tipo = NayVariable.TEXT;
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

	public static class BlocoContext extends ParserRuleContext {
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public BlocoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloco; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NayLangListener ) ((NayLangListener)listener).enterBloco(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NayLangListener ) ((NayLangListener)listener).exitBloco(this);
		}
	}

	public final BlocoContext bloco() throws RecognitionException {
		BlocoContext _localctx = new BlocoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_bloco);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 curThread = new ArrayList<AbstractCommand>();
					  stack.push(curThread);
					
			setState(58); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(57);
				cmd();
				}
				}
				setState(60); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << ID))) != 0) );
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

	public static class CmdContext extends ParserRuleContext {
		public CmdleituraContext cmdleitura() {
			return getRuleContext(CmdleituraContext.class,0);
		}
		public CmdescritaContext cmdescrita() {
			return getRuleContext(CmdescritaContext.class,0);
		}
		public CmdattribContext cmdattrib() {
			return getRuleContext(CmdattribContext.class,0);
		}
		public CmdselecaoContext cmdselecao() {
			return getRuleContext(CmdselecaoContext.class,0);
		}
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NayLangListener ) ((NayLangListener)listener).enterCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NayLangListener ) ((NayLangListener)listener).exitCmd(this);
		}
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_cmd);
		try {
			setState(66);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				cmdleitura();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(63);
				cmdescrita();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(64);
				cmdattrib();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 4);
				{
				setState(65);
				cmdselecao();
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

	public static class CmdleituraContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(NayLangParser.AP, 0); }
		public TerminalNode ID() { return getToken(NayLangParser.ID, 0); }
		public TerminalNode FP() { return getToken(NayLangParser.FP, 0); }
		public TerminalNode SC() { return getToken(NayLangParser.SC, 0); }
		public CmdleituraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdleitura; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NayLangListener ) ((NayLangListener)listener).enterCmdleitura(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NayLangListener ) ((NayLangListener)listener).exitCmdleitura(this);
		}
	}

	public final CmdleituraContext cmdleitura() throws RecognitionException {
		CmdleituraContext _localctx = new CmdleituraContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmdleitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			match(T__5);
			setState(69);
			match(AP);
			setState(70);
			match(ID);

											verificaID(_input.LT(-1).getText());
											_readID = _input.LT(-1).getText();
										
			setState(72);
			match(FP);
			setState(73);
			match(SC);
				
								 	NayVariable var = (NayVariable)symbolTable.get(_readID);
								 	ReadCommand cmd = new ReadCommand(_readID, var);
								 	stack.peek().add(cmd);
								 
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

	public static class CmdescritaContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(NayLangParser.AP, 0); }
		public TerminalNode FP() { return getToken(NayLangParser.FP, 0); }
		public TerminalNode SC() { return getToken(NayLangParser.SC, 0); }
		public TerminalNode STRING() { return getToken(NayLangParser.STRING, 0); }
		public TerminalNode ID() { return getToken(NayLangParser.ID, 0); }
		public CmdescritaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdescrita; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NayLangListener ) ((NayLangListener)listener).enterCmdescrita(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NayLangListener ) ((NayLangListener)listener).exitCmdescrita(this);
		}
	}

	public final CmdescritaContext cmdescrita() throws RecognitionException {
		CmdescritaContext _localctx = new CmdescritaContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cmdescrita);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			match(T__6);
			setState(77);
			match(AP);
			setState(82);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				{
				setState(78);
				match(STRING);
				 _writeID = _input.LT(-1).getText(); 
				}
				break;
			case ID:
				{
				setState(80);
				match(ID);
				 _writeID = _input.LT(-1).getText(); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(84);
			match(FP);
			setState(85);
			match(SC);

				                            boolean isString = _writeID.startsWith("\"") && _writeID.endsWith("\"");
				                            WriteCommand cmd = new WriteCommand(_writeID, isString);
				                            stack.peek().add(cmd);
										 
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

	public static class CmdattribContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(NayLangParser.ID, 0); }
		public TerminalNode ATTR() { return getToken(NayLangParser.ATTR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SC() { return getToken(NayLangParser.SC, 0); }
		public CmdattribContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdattrib; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NayLangListener ) ((NayLangListener)listener).enterCmdattrib(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NayLangListener ) ((NayLangListener)listener).exitCmdattrib(this);
		}
	}

	public final CmdattribContext cmdattrib() throws RecognitionException {
		CmdattribContext _localctx = new CmdattribContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmdattrib);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(ID);

							verificaID(_input.LT(-1).getText());
							_exprID = _input.LT(-1).getText();
							
			setState(90);
			match(ATTR);
			 _exprContent = ""; 
			setState(92);
			expr();
			setState(93);
			match(SC);

							AttributionCommand cmd = new AttributionCommand(_exprID, _exprContent);
							stack.peek().add(cmd);
						
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

	public static class CmdselecaoContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(NayLangParser.AP, 0); }
		public List<TerminalNode> ID() { return getTokens(NayLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(NayLangParser.ID, i);
		}
		public TerminalNode OPREL() { return getToken(NayLangParser.OPREL, 0); }
		public TerminalNode FP() { return getToken(NayLangParser.FP, 0); }
		public List<TerminalNode> ACH() { return getTokens(NayLangParser.ACH); }
		public TerminalNode ACH(int i) {
			return getToken(NayLangParser.ACH, i);
		}
		public List<TerminalNode> FCH() { return getTokens(NayLangParser.FCH); }
		public TerminalNode FCH(int i) {
			return getToken(NayLangParser.FCH, i);
		}
		public TerminalNode NUMBER() { return getToken(NayLangParser.NUMBER, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdselecaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdselecao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NayLangListener ) ((NayLangListener)listener).enterCmdselecao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NayLangListener ) ((NayLangListener)listener).exitCmdselecao(this);
		}
	}

	public final CmdselecaoContext cmdselecao() throws RecognitionException {
		CmdselecaoContext _localctx = new CmdselecaoContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cmdselecao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(T__7);
			setState(97);
			match(AP);
			setState(98);
			match(ID);
			 _exprDecision = _input.LT(-1).getText(); 
			setState(100);
			match(OPREL);
			 _exprDecision += _input.LT(-1).getText(); 
			setState(102);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==NUMBER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			_exprDecision += _input.LT(-1).getText(); 
			setState(104);
			match(FP);
			setState(105);
			match(ACH);
			 curThread = new ArrayList<AbstractCommand>(); 
			                      stack.push(curThread);
			                    
			setState(108); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(107);
				cmd();
				}
				}
				setState(110); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << ID))) != 0) );
			setState(112);
			match(FCH);

			                       listaTrue = stack.pop();	
			                    
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(114);
				match(T__8);
				setState(115);
				match(ACH);

				                   	 	curThread = new ArrayList<AbstractCommand>();
				                   	 	stack.push(curThread);
				                   	 
				{
				setState(118); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(117);
					cmd();
					}
					}
					setState(120); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << ID))) != 0) );
				}
				setState(122);
				match(FCH);

				                   		listaFalse = stack.pop();
				                   		DecisionCommand cmd = new DecisionCommand(_exprDecision, listaTrue, listaFalse);
				                   		stack.peek().add(cmd);
				                   	
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

	public static class ExprContext extends ParserRuleContext {
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
		}
		public List<TerminalNode> OP() { return getTokens(NayLangParser.OP); }
		public TerminalNode OP(int i) {
			return getToken(NayLangParser.OP, i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NayLangListener ) ((NayLangListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NayLangListener ) ((NayLangListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			termo();
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP) {
				{
				{
				setState(128);
				match(OP);
				_exprContent += _input.LT(-1).getText();
				setState(130);
				termo();
				}
				}
				setState(135);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class TermoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(NayLangParser.ID, 0); }
		public TerminalNode NUMBER() { return getToken(NayLangParser.NUMBER, 0); }
		public TerminalNode STRING() { return getToken(NayLangParser.STRING, 0); }
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NayLangListener ) ((NayLangListener)listener).enterTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NayLangListener ) ((NayLangListener)listener).exitTermo(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_termo);
		try {
			setState(142);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(136);
				match(ID);

							verificaID(_input.LT(-1).getText());
							_exprContent += _input.LT(-1).getText();
							
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(138);
				match(NUMBER);

							_exprContent += _input.LT(-1).getText();
						
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(140);
				match(STRING);

				            _exprContent += _input.LT(-1).getText();
				        
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\30\u0093\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\2\3\2\3\2\3\3\6\3\"\n\3\r\3\16\3#"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\7\4,\n\4\f\4\16\4/\13\4\3\4\3\4\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\5\59\n\5\3\6\3\6\6\6=\n\6\r\6\16\6>\3\7\3\7\3\7\3\7\5\7E\n"+
		"\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\5\tU\n\t\3"+
		"\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\6\13o\n\13\r\13\16\13p\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\6\13y\n\13\r\13\16\13z\3\13\3\13\3\13\5\13\u0080\n"+
		"\13\3\f\3\f\3\f\3\f\7\f\u0086\n\f\f\f\16\f\u0089\13\f\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\5\r\u0091\n\r\3\r\2\2\16\2\4\6\b\n\f\16\20\22\24\26\30\2\3\3"+
		"\2\26\27\2\u0095\2\32\3\2\2\2\4!\3\2\2\2\6%\3\2\2\2\b8\3\2\2\2\n:\3\2"+
		"\2\2\fD\3\2\2\2\16F\3\2\2\2\20N\3\2\2\2\22Z\3\2\2\2\24b\3\2\2\2\26\u0081"+
		"\3\2\2\2\30\u0090\3\2\2\2\32\33\7\3\2\2\33\34\5\4\3\2\34\35\5\n\6\2\35"+
		"\36\7\4\2\2\36\37\b\2\1\2\37\3\3\2\2\2 \"\5\6\4\2! \3\2\2\2\"#\3\2\2\2"+
		"#!\3\2\2\2#$\3\2\2\2$\5\3\2\2\2%&\5\b\5\2&\'\7\26\2\2\'-\b\4\1\2()\7\21"+
		"\2\2)*\7\26\2\2*,\b\4\1\2+(\3\2\2\2,/\3\2\2\2-+\3\2\2\2-.\3\2\2\2.\60"+
		"\3\2\2\2/-\3\2\2\2\60\61\7\16\2\2\61\7\3\2\2\2\62\63\7\5\2\2\639\b\5\1"+
		"\2\64\65\7\6\2\2\659\b\5\1\2\66\67\7\7\2\2\679\b\5\1\28\62\3\2\2\28\64"+
		"\3\2\2\28\66\3\2\2\29\t\3\2\2\2:<\b\6\1\2;=\5\f\7\2<;\3\2\2\2=>\3\2\2"+
		"\2><\3\2\2\2>?\3\2\2\2?\13\3\2\2\2@E\5\16\b\2AE\5\20\t\2BE\5\22\n\2CE"+
		"\5\24\13\2D@\3\2\2\2DA\3\2\2\2DB\3\2\2\2DC\3\2\2\2E\r\3\2\2\2FG\7\b\2"+
		"\2GH\7\f\2\2HI\7\26\2\2IJ\b\b\1\2JK\7\r\2\2KL\7\16\2\2LM\b\b\1\2M\17\3"+
		"\2\2\2NO\7\t\2\2OT\7\f\2\2PQ\7\25\2\2QU\b\t\1\2RS\7\26\2\2SU\b\t\1\2T"+
		"P\3\2\2\2TR\3\2\2\2UV\3\2\2\2VW\7\r\2\2WX\7\16\2\2XY\b\t\1\2Y\21\3\2\2"+
		"\2Z[\7\26\2\2[\\\b\n\1\2\\]\7\20\2\2]^\b\n\1\2^_\5\26\f\2_`\7\16\2\2`"+
		"a\b\n\1\2a\23\3\2\2\2bc\7\n\2\2cd\7\f\2\2de\7\26\2\2ef\b\13\1\2fg\7\24"+
		"\2\2gh\b\13\1\2hi\t\2\2\2ij\b\13\1\2jk\7\r\2\2kl\7\22\2\2ln\b\13\1\2m"+
		"o\5\f\7\2nm\3\2\2\2op\3\2\2\2pn\3\2\2\2pq\3\2\2\2qr\3\2\2\2rs\7\23\2\2"+
		"s\177\b\13\1\2tu\7\13\2\2uv\7\22\2\2vx\b\13\1\2wy\5\f\7\2xw\3\2\2\2yz"+
		"\3\2\2\2zx\3\2\2\2z{\3\2\2\2{|\3\2\2\2|}\7\23\2\2}~\b\13\1\2~\u0080\3"+
		"\2\2\2\177t\3\2\2\2\177\u0080\3\2\2\2\u0080\25\3\2\2\2\u0081\u0087\5\30"+
		"\r\2\u0082\u0083\7\17\2\2\u0083\u0084\b\f\1\2\u0084\u0086\5\30\r\2\u0085"+
		"\u0082\3\2\2\2\u0086\u0089\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2"+
		"\2\2\u0088\27\3\2\2\2\u0089\u0087\3\2\2\2\u008a\u008b\7\26\2\2\u008b\u0091"+
		"\b\r\1\2\u008c\u008d\7\27\2\2\u008d\u0091\b\r\1\2\u008e\u008f\7\25\2\2"+
		"\u008f\u0091\b\r\1\2\u0090\u008a\3\2\2\2\u0090\u008c\3\2\2\2\u0090\u008e"+
		"\3\2\2\2\u0091\31\3\2\2\2\r#-8>DTpz\177\u0087\u0090";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}