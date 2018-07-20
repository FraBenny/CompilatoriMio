// Generated from Fool.g4 by ANTLR 4.7.1

package parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;



@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FoolParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SEMIC=1, COLON=2, COMMA=3, DOT=4, EQ=5, ASM=6, LT=7, GT=8, LTEQ=9, GTEQ=10, 
		PLUS=11, MINUS=12, TIMES=13, FRACT=14, TRUE=15, FALSE=16, LPAR=17, RPAR=18, 
		CLPAR=19, CRPAR=20, IF=21, THEN=22, ELSE=23, AND=24, OR=25, NOT=26, PRINT=27, 
		LET=28, IN=29, VAR=30, FUN=31, INT=32, BOOL=33, CLASS=34, EXTS=35, NEW=36, 
		NULL=37, VOID=38, INTEGER=39, ID=40, WS=41, LINECOMENTS=42, BLOCKCOMENTS=43;
	public static final int
		RULE_prog = 0, RULE_classd = 1, RULE_let = 2, RULE_vardec = 3, RULE_varasm = 4, 
		RULE_fun = 5, RULE_dec = 6, RULE_type = 7, RULE_exp = 8, RULE_term = 9, 
		RULE_stms = 10, RULE_stm = 11, RULE_factor = 12, RULE_value = 13;
	public static final String[] ruleNames = {
		"prog", "classd", "let", "vardec", "varasm", "fun", "dec", "type", "exp", 
		"term", "stms", "stm", "factor", "value"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "':'", "','", "'.'", "'=='", "'='", "'<'", "'>'", "'<='", 
		"'>='", "'+'", "'-'", "'*'", "'/'", "'true'", "'false'", "'('", "')'", 
		"'{'", "'}'", "'if'", "'then'", "'else'", "'&&'", "'||'", "'not'", "'print'", 
		"'let'", "'in'", "'var'", "'fun'", "'int'", "'bool'", "'class'", "'extends'", 
		"'new'", "'null'", "'void'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "SEMIC", "COLON", "COMMA", "DOT", "EQ", "ASM", "LT", "GT", "LTEQ", 
		"GTEQ", "PLUS", "MINUS", "TIMES", "FRACT", "TRUE", "FALSE", "LPAR", "RPAR", 
		"CLPAR", "CRPAR", "IF", "THEN", "ELSE", "AND", "OR", "NOT", "PRINT", "LET", 
		"IN", "VAR", "FUN", "INT", "BOOL", "CLASS", "EXTS", "NEW", "NULL", "VOID", 
		"INTEGER", "ID", "WS", "LINECOMENTS", "BLOCKCOMENTS"
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
	public String getGrammarFileName() { return "Fool.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public FoolParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
	 
		public ProgContext() { }
		public void copyFrom(ProgContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ClassExpContext extends ProgContext {
		public List<TerminalNode> SEMIC() { return getTokens(FoolParser.SEMIC); }
		public TerminalNode SEMIC(int i) {
			return getToken(FoolParser.SEMIC, i);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode EOF() { return getToken(FoolParser.EOF, 0); }
		public List<ClassdContext> classd() {
			return getRuleContexts(ClassdContext.class);
		}
		public ClassdContext classd(int i) {
			return getRuleContext(ClassdContext.class,i);
		}
		public LetContext let() {
			return getRuleContext(LetContext.class,0);
		}
		public ClassExpContext(ProgContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolVisitor ) return ((FoolVisitor<? extends T>)visitor).visitClassExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LetInExpContext extends ProgContext {
		public LetContext let() {
			return getRuleContext(LetContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode SEMIC() { return getToken(FoolParser.SEMIC, 0); }
		public TerminalNode EOF() { return getToken(FoolParser.EOF, 0); }
		public LetInExpContext(ProgContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolVisitor ) return ((FoolVisitor<? extends T>)visitor).visitLetInExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SingleExpContext extends ProgContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode SEMIC() { return getToken(FoolParser.SEMIC, 0); }
		public TerminalNode EOF() { return getToken(FoolParser.EOF, 0); }
		public SingleExpContext(ProgContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolVisitor ) return ((FoolVisitor<? extends T>)visitor).visitSingleExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			setState(50);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
			case TRUE:
			case FALSE:
			case LPAR:
			case IF:
			case NOT:
			case PRINT:
			case INT:
			case BOOL:
			case NEW:
			case NULL:
			case VOID:
			case INTEGER:
			case ID:
				_localctx = new SingleExpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(28);
				exp();
				setState(29);
				match(SEMIC);
				setState(30);
				match(EOF);
				}
				break;
			case LET:
				_localctx = new LetInExpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(32);
				let();
				setState(33);
				exp();
				setState(34);
				match(SEMIC);
				setState(35);
				match(EOF);
				}
				break;
			case CLASS:
				_localctx = new ClassExpContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(38); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(37);
					classd();
					}
					}
					setState(40); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==CLASS );
				setState(42);
				match(SEMIC);
				setState(44);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LET) {
					{
					setState(43);
					let();
					}
				}

				setState(46);
				exp();
				setState(47);
				match(SEMIC);
				setState(48);
				match(EOF);
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

	public static class ClassdContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(FoolParser.CLASS, 0); }
		public List<TerminalNode> ID() { return getTokens(FoolParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(FoolParser.ID, i);
		}
		public TerminalNode EXTS() { return getToken(FoolParser.EXTS, 0); }
		public TerminalNode LPAR() { return getToken(FoolParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(FoolParser.RPAR, 0); }
		public TerminalNode CLPAR() { return getToken(FoolParser.CLPAR, 0); }
		public TerminalNode CRPAR() { return getToken(FoolParser.CRPAR, 0); }
		public List<VardecContext> vardec() {
			return getRuleContexts(VardecContext.class);
		}
		public VardecContext vardec(int i) {
			return getRuleContext(VardecContext.class,i);
		}
		public List<FunContext> fun() {
			return getRuleContexts(FunContext.class);
		}
		public FunContext fun(int i) {
			return getRuleContext(FunContext.class,i);
		}
		public List<TerminalNode> SEMIC() { return getTokens(FoolParser.SEMIC); }
		public TerminalNode SEMIC(int i) {
			return getToken(FoolParser.SEMIC, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FoolParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FoolParser.COMMA, i);
		}
		public ClassdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classd; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolVisitor ) return ((FoolVisitor<? extends T>)visitor).visitClassd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassdContext classd() throws RecognitionException {
		ClassdContext _localctx = new ClassdContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_classd);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			match(CLASS);
			setState(53);
			match(ID);
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTS) {
				{
				setState(54);
				match(EXTS);
				setState(55);
				match(ID);
				}
			}

			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAR) {
				{
				setState(58);
				match(LPAR);
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << VOID) | (1L << ID))) != 0)) {
					{
					setState(59);
					vardec();
					setState(64);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(60);
						match(COMMA);
						setState(61);
						vardec();
						}
						}
						setState(66);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(69);
				match(RPAR);
				}
			}

			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CLPAR) {
				{
				setState(72);
				match(CLPAR);
				setState(78);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << VOID) | (1L << ID))) != 0)) {
					{
					{
					setState(73);
					fun();
					setState(74);
					match(SEMIC);
					}
					}
					setState(80);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(81);
				match(CRPAR);
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

	public static class LetContext extends ParserRuleContext {
		public TerminalNode LET() { return getToken(FoolParser.LET, 0); }
		public TerminalNode IN() { return getToken(FoolParser.IN, 0); }
		public List<DecContext> dec() {
			return getRuleContexts(DecContext.class);
		}
		public DecContext dec(int i) {
			return getRuleContext(DecContext.class,i);
		}
		public List<TerminalNode> SEMIC() { return getTokens(FoolParser.SEMIC); }
		public TerminalNode SEMIC(int i) {
			return getToken(FoolParser.SEMIC, i);
		}
		public LetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_let; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolVisitor ) return ((FoolVisitor<? extends T>)visitor).visitLet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LetContext let() throws RecognitionException {
		LetContext _localctx = new LetContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_let);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(LET);
			setState(88); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(85);
				dec();
				setState(86);
				match(SEMIC);
				}
				}
				setState(90); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << VOID) | (1L << ID))) != 0) );
			setState(92);
			match(IN);
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

	public static class VardecContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(FoolParser.ID, 0); }
		public VardecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vardec; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolVisitor ) return ((FoolVisitor<? extends T>)visitor).visitVardec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VardecContext vardec() throws RecognitionException {
		VardecContext _localctx = new VardecContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_vardec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			type();
			setState(95);
			match(ID);
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

	public static class VarasmContext extends ParserRuleContext {
		public VarasmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varasm; }
	 
		public VarasmContext() { }
		public void copyFrom(VarasmContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FieldAsmContext extends VarasmContext {
		public Token t;
		public Token f;
		public ExpContext e;
		public TerminalNode DOT() { return getToken(FoolParser.DOT, 0); }
		public TerminalNode ASM() { return getToken(FoolParser.ASM, 0); }
		public List<TerminalNode> ID() { return getTokens(FoolParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(FoolParser.ID, i);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public FieldAsmContext(VarasmContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolVisitor ) return ((FoolVisitor<? extends T>)visitor).visitFieldAsm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DecAsmContext extends VarasmContext {
		public VardecContext vardec() {
			return getRuleContext(VardecContext.class,0);
		}
		public TerminalNode ASM() { return getToken(FoolParser.ASM, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public DecAsmContext(VarasmContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolVisitor ) return ((FoolVisitor<? extends T>)visitor).visitDecAsm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AsmContext extends VarasmContext {
		public TerminalNode ID() { return getToken(FoolParser.ID, 0); }
		public TerminalNode ASM() { return getToken(FoolParser.ASM, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public AsmContext(VarasmContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolVisitor ) return ((FoolVisitor<? extends T>)visitor).visitAsm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarasmContext varasm() throws RecognitionException {
		VarasmContext _localctx = new VarasmContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_varasm);
		try {
			setState(109);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				_localctx = new DecAsmContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(97);
				vardec();
				setState(98);
				match(ASM);
				setState(99);
				exp();
				}
				break;
			case 2:
				_localctx = new AsmContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(101);
				match(ID);
				setState(102);
				match(ASM);
				setState(103);
				exp();
				}
				break;
			case 3:
				_localctx = new FieldAsmContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(104);
				((FieldAsmContext)_localctx).t = match(ID);
				setState(105);
				match(DOT);
				setState(106);
				((FieldAsmContext)_localctx).f = match(ID);
				setState(107);
				match(ASM);
				setState(108);
				((FieldAsmContext)_localctx).e = exp();
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

	public static class FunContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(FoolParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(FoolParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(FoolParser.RPAR, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public List<VardecContext> vardec() {
			return getRuleContexts(VardecContext.class);
		}
		public VardecContext vardec(int i) {
			return getRuleContext(VardecContext.class,i);
		}
		public TerminalNode LET() { return getToken(FoolParser.LET, 0); }
		public TerminalNode IN() { return getToken(FoolParser.IN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(FoolParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FoolParser.COMMA, i);
		}
		public List<VarasmContext> varasm() {
			return getRuleContexts(VarasmContext.class);
		}
		public VarasmContext varasm(int i) {
			return getRuleContext(VarasmContext.class,i);
		}
		public List<TerminalNode> SEMIC() { return getTokens(FoolParser.SEMIC); }
		public TerminalNode SEMIC(int i) {
			return getToken(FoolParser.SEMIC, i);
		}
		public FunContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fun; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolVisitor ) return ((FoolVisitor<? extends T>)visitor).visitFun(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunContext fun() throws RecognitionException {
		FunContext _localctx = new FunContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_fun);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			type();
			setState(112);
			match(ID);
			setState(113);
			match(LPAR);
			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << VOID) | (1L << ID))) != 0)) {
				{
				setState(114);
				vardec();
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(115);
					match(COMMA);
					setState(116);
					vardec();
					}
					}
					setState(121);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(124);
			match(RPAR);
			setState(135);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LET) {
				{
				setState(125);
				match(LET);
				setState(129); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(126);
					varasm();
					setState(127);
					match(SEMIC);
					}
					}
					setState(131); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << VOID) | (1L << ID))) != 0) );
				setState(133);
				match(IN);
				}
			}

			setState(137);
			exp();
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

	public static class DecContext extends ParserRuleContext {
		public DecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dec; }
	 
		public DecContext() { }
		public void copyFrom(DecContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VarAssignmentContext extends DecContext {
		public VarasmContext varasm() {
			return getRuleContext(VarasmContext.class,0);
		}
		public VarAssignmentContext(DecContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolVisitor ) return ((FoolVisitor<? extends T>)visitor).visitVarAssignment(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunDeclarationContext extends DecContext {
		public FunContext fun() {
			return getRuleContext(FunContext.class,0);
		}
		public FunDeclarationContext(DecContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolVisitor ) return ((FoolVisitor<? extends T>)visitor).visitFunDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecContext dec() throws RecognitionException {
		DecContext _localctx = new DecContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_dec);
		try {
			setState(141);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				_localctx = new VarAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(139);
				varasm();
				}
				break;
			case 2:
				_localctx = new FunDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(140);
				fun();
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(FoolParser.INT, 0); }
		public TerminalNode BOOL() { return getToken(FoolParser.BOOL, 0); }
		public TerminalNode VOID() { return getToken(FoolParser.VOID, 0); }
		public TerminalNode ID() { return getToken(FoolParser.ID, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolVisitor ) return ((FoolVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << VOID) | (1L << ID))) != 0)) ) {
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

	public static class ExpContext extends ParserRuleContext {
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
	 
		public ExpContext() { }
		public void copyFrom(ExpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IfThenElseContext extends ExpContext {
		public ExpContext cond;
		public ExpContext thenBranch;
		public ExpContext elseBranch;
		public TerminalNode IF() { return getToken(FoolParser.IF, 0); }
		public TerminalNode THEN() { return getToken(FoolParser.THEN, 0); }
		public List<TerminalNode> CLPAR() { return getTokens(FoolParser.CLPAR); }
		public TerminalNode CLPAR(int i) {
			return getToken(FoolParser.CLPAR, i);
		}
		public List<TerminalNode> CRPAR() { return getTokens(FoolParser.CRPAR); }
		public TerminalNode CRPAR(int i) {
			return getToken(FoolParser.CRPAR, i);
		}
		public TerminalNode ELSE() { return getToken(FoolParser.ELSE, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public IfThenElseContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolVisitor ) return ((FoolVisitor<? extends T>)visitor).visitIfThenElse(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatementContext extends ExpContext {
		public StmsContext stms() {
			return getRuleContext(StmsContext.class,0);
		}
		public StatementContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolVisitor ) return ((FoolVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolExpContext extends ExpContext {
		public TermContext left;
		public Token op;
		public ExpContext right;
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode AND() { return getToken(FoolParser.AND, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode OR() { return getToken(FoolParser.OR, 0); }
		public TerminalNode NOT() { return getToken(FoolParser.NOT, 0); }
		public BoolExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolVisitor ) return ((FoolVisitor<? extends T>)visitor).visitBoolExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntExpContext extends ExpContext {
		public TermContext left;
		public Token op;
		public ExpContext right;
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(FoolParser.PLUS, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(FoolParser.MINUS, 0); }
		public IntExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolVisitor ) return ((FoolVisitor<? extends T>)visitor).visitIntExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_exp);
		try {
			setState(179);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				_localctx = new IntExpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(145);
				((IntExpContext)_localctx).left = term();
				setState(148);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(146);
					((IntExpContext)_localctx).op = match(PLUS);
					setState(147);
					((IntExpContext)_localctx).right = exp();
					}
					break;
				}
				}
				break;
			case 2:
				_localctx = new IntExpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(150);
				((IntExpContext)_localctx).left = term();
				setState(153);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(151);
					((IntExpContext)_localctx).op = match(MINUS);
					setState(152);
					((IntExpContext)_localctx).right = exp();
					}
					break;
				}
				}
				break;
			case 3:
				_localctx = new BoolExpContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(155);
				((BoolExpContext)_localctx).left = term();
				setState(158);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(156);
					((BoolExpContext)_localctx).op = match(AND);
					setState(157);
					((BoolExpContext)_localctx).right = exp();
					}
					break;
				}
				}
				break;
			case 4:
				_localctx = new BoolExpContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(160);
				((BoolExpContext)_localctx).left = term();
				setState(163);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(161);
					((BoolExpContext)_localctx).op = match(OR);
					setState(162);
					((BoolExpContext)_localctx).right = exp();
					}
					break;
				}
				}
				break;
			case 5:
				_localctx = new BoolExpContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(165);
				((BoolExpContext)_localctx).op = match(NOT);
				setState(166);
				exp();
				}
				break;
			case 6:
				_localctx = new StatementContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(167);
				stms();
				}
				break;
			case 7:
				_localctx = new IfThenElseContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(168);
				match(IF);
				setState(169);
				((IfThenElseContext)_localctx).cond = exp();
				setState(170);
				match(THEN);
				setState(171);
				match(CLPAR);
				setState(172);
				((IfThenElseContext)_localctx).thenBranch = exp();
				setState(173);
				match(CRPAR);
				setState(174);
				match(ELSE);
				setState(175);
				match(CLPAR);
				setState(176);
				((IfThenElseContext)_localctx).elseBranch = exp();
				setState(177);
				match(CRPAR);
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

	public static class TermContext extends ParserRuleContext {
		public FactorContext left;
		public Token op;
		public TermContext right;
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TerminalNode TIMES() { return getToken(FoolParser.TIMES, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode FRACT() { return getToken(FoolParser.FRACT, 0); }
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolVisitor ) return ((FoolVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_term);
		try {
			setState(191);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(181);
				((TermContext)_localctx).left = factor();
				setState(184);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(182);
					((TermContext)_localctx).op = match(TIMES);
					setState(183);
					((TermContext)_localctx).right = term();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(186);
				((TermContext)_localctx).left = factor();
				setState(189);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(187);
					((TermContext)_localctx).op = match(FRACT);
					setState(188);
					((TermContext)_localctx).right = term();
					}
					break;
				}
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

	public static class StmsContext extends ParserRuleContext {
		public List<StmContext> stm() {
			return getRuleContexts(StmContext.class);
		}
		public StmContext stm(int i) {
			return getRuleContext(StmContext.class,i);
		}
		public StmsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stms; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolVisitor ) return ((FoolVisitor<? extends T>)visitor).visitStms(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmsContext stms() throws RecognitionException {
		StmsContext _localctx = new StmsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_stms);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(194); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(193);
					stm();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(196); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class StmContext extends ParserRuleContext {
		public StmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stm; }
	 
		public StmContext() { }
		public void copyFrom(StmContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BranchStmContext extends StmContext {
		public ExpContext e;
		public StmsContext b1;
		public StmsContext b2;
		public TerminalNode IF() { return getToken(FoolParser.IF, 0); }
		public TerminalNode THEN() { return getToken(FoolParser.THEN, 0); }
		public List<TerminalNode> CLPAR() { return getTokens(FoolParser.CLPAR); }
		public TerminalNode CLPAR(int i) {
			return getToken(FoolParser.CLPAR, i);
		}
		public List<TerminalNode> CRPAR() { return getTokens(FoolParser.CRPAR); }
		public TerminalNode CRPAR(int i) {
			return getToken(FoolParser.CRPAR, i);
		}
		public TerminalNode ELSE() { return getToken(FoolParser.ELSE, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public List<StmsContext> stms() {
			return getRuleContexts(StmsContext.class);
		}
		public StmsContext stms(int i) {
			return getRuleContext(StmsContext.class,i);
		}
		public BranchStmContext(StmContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolVisitor ) return ((FoolVisitor<? extends T>)visitor).visitBranchStm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StmAsmContext extends StmContext {
		public VarasmContext varasm() {
			return getRuleContext(VarasmContext.class,0);
		}
		public StmAsmContext(StmContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolVisitor ) return ((FoolVisitor<? extends T>)visitor).visitStmAsm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmContext stm() throws RecognitionException {
		StmContext _localctx = new StmContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_stm);
		try {
			setState(210);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case BOOL:
			case VOID:
			case ID:
				_localctx = new StmAsmContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(198);
				varasm();
				}
				break;
			case IF:
				_localctx = new BranchStmContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(199);
				match(IF);
				setState(200);
				((BranchStmContext)_localctx).e = exp();
				setState(201);
				match(THEN);
				setState(202);
				match(CLPAR);
				setState(203);
				((BranchStmContext)_localctx).b1 = stms();
				setState(204);
				match(CRPAR);
				setState(205);
				match(ELSE);
				setState(206);
				match(CLPAR);
				setState(207);
				((BranchStmContext)_localctx).b2 = stms();
				setState(208);
				match(CRPAR);
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

	public static class FactorContext extends ParserRuleContext {
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
	 
		public FactorContext() { }
		public void copyFrom(FactorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IntBoolFactorContext extends FactorContext {
		public ValueContext left;
		public Token op;
		public ValueContext right;
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public TerminalNode GT() { return getToken(FoolParser.GT, 0); }
		public TerminalNode LT() { return getToken(FoolParser.LT, 0); }
		public TerminalNode GTEQ() { return getToken(FoolParser.GTEQ, 0); }
		public TerminalNode LTEQ() { return getToken(FoolParser.LTEQ, 0); }
		public IntBoolFactorContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolVisitor ) return ((FoolVisitor<? extends T>)visitor).visitIntBoolFactor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ValFactorContext extends FactorContext {
		public ValueContext left;
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ValFactorContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolVisitor ) return ((FoolVisitor<? extends T>)visitor).visitValFactor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolFactorContext extends FactorContext {
		public ValueContext left;
		public ValueContext right;
		public TerminalNode EQ() { return getToken(FoolParser.EQ, 0); }
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public BoolFactorContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolVisitor ) return ((FoolVisitor<? extends T>)visitor).visitBoolFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_factor);
		try {
			setState(233);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				_localctx = new BoolFactorContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(212);
				((BoolFactorContext)_localctx).left = value();
				setState(213);
				match(EQ);
				setState(214);
				((BoolFactorContext)_localctx).right = value();
				}
				break;
			case 2:
				_localctx = new IntBoolFactorContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(216);
				((IntBoolFactorContext)_localctx).left = value();
				setState(217);
				((IntBoolFactorContext)_localctx).op = match(GT);
				setState(218);
				((IntBoolFactorContext)_localctx).right = value();
				}
				break;
			case 3:
				_localctx = new IntBoolFactorContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(220);
				((IntBoolFactorContext)_localctx).left = value();
				setState(221);
				((IntBoolFactorContext)_localctx).op = match(LT);
				setState(222);
				((IntBoolFactorContext)_localctx).right = value();
				}
				break;
			case 4:
				_localctx = new IntBoolFactorContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(224);
				((IntBoolFactorContext)_localctx).left = value();
				setState(225);
				((IntBoolFactorContext)_localctx).op = match(GTEQ);
				setState(226);
				((IntBoolFactorContext)_localctx).right = value();
				}
				break;
			case 5:
				_localctx = new IntBoolFactorContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(228);
				((IntBoolFactorContext)_localctx).left = value();
				setState(229);
				((IntBoolFactorContext)_localctx).op = match(LTEQ);
				setState(230);
				((IntBoolFactorContext)_localctx).right = value();
				}
				break;
			case 6:
				_localctx = new ValFactorContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(232);
				((ValFactorContext)_localctx).left = value();
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

	public static class ValueContext extends ParserRuleContext {
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
	 
		public ValueContext() { }
		public void copyFrom(ValueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IntValContext extends ValueContext {
		public TerminalNode INTEGER() { return getToken(FoolParser.INTEGER, 0); }
		public TerminalNode MINUS() { return getToken(FoolParser.MINUS, 0); }
		public IntValContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolVisitor ) return ((FoolVisitor<? extends T>)visitor).visitIntVal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FuncallContext extends ValueContext {
		public ExpContext exp;
		public List<ExpContext> elem = new ArrayList<ExpContext>();
		public TerminalNode ID() { return getToken(FoolParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(FoolParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(FoolParser.RPAR, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FoolParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FoolParser.COMMA, i);
		}
		public FuncallContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolVisitor ) return ((FoolVisitor<? extends T>)visitor).visitFuncall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NullValContext extends ValueContext {
		public TerminalNode NULL() { return getToken(FoolParser.NULL, 0); }
		public NullValContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolVisitor ) return ((FoolVisitor<? extends T>)visitor).visitNullVal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrintContext extends ValueContext {
		public TerminalNode PRINT() { return getToken(FoolParser.PRINT, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public PrintContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolVisitor ) return ((FoolVisitor<? extends T>)visitor).visitPrint(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FieldValContext extends ValueContext {
		public List<TerminalNode> ID() { return getTokens(FoolParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(FoolParser.ID, i);
		}
		public TerminalNode DOT() { return getToken(FoolParser.DOT, 0); }
		public FieldValContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolVisitor ) return ((FoolVisitor<? extends T>)visitor).visitFieldVal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ClassInstantiationContext extends ValueContext {
		public ExpContext exp;
		public List<ExpContext> elem = new ArrayList<ExpContext>();
		public TerminalNode NEW() { return getToken(FoolParser.NEW, 0); }
		public TerminalNode ID() { return getToken(FoolParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(FoolParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(FoolParser.RPAR, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FoolParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FoolParser.COMMA, i);
		}
		public ClassInstantiationContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolVisitor ) return ((FoolVisitor<? extends T>)visitor).visitClassInstantiation(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolValContext extends ValueContext {
		public TerminalNode TRUE() { return getToken(FoolParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(FoolParser.FALSE, 0); }
		public BoolValContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolVisitor ) return ((FoolVisitor<? extends T>)visitor).visitBoolVal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BaseValContext extends ValueContext {
		public TerminalNode LPAR() { return getToken(FoolParser.LPAR, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(FoolParser.RPAR, 0); }
		public BaseValContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolVisitor ) return ((FoolVisitor<? extends T>)visitor).visitBaseVal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarValContext extends ValueContext {
		public TerminalNode ID() { return getToken(FoolParser.ID, 0); }
		public VarValContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolVisitor ) return ((FoolVisitor<? extends T>)visitor).visitVarVal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MethodCallContext extends ValueContext {
		public ExpContext exp;
		public List<ExpContext> elem = new ArrayList<>();
		public List<TerminalNode> ID() { return getTokens(FoolParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(FoolParser.ID, i);
		}
		public TerminalNode DOT() { return getToken(FoolParser.DOT, 0); }
		public TerminalNode LPAR() { return getToken(FoolParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(FoolParser.RPAR, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FoolParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FoolParser.COMMA, i);
		}
		public MethodCallContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoolVisitor ) return ((FoolVisitor<? extends T>)visitor).visitMethodCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_value);
		int _la;
		try {
			setState(295);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				_localctx = new IntValContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(236);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(235);
					match(MINUS);
					}
				}

				setState(238);
				match(INTEGER);
				}
				break;
			case 2:
				_localctx = new BoolValContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(239);
				_la = _input.LA(1);
				if ( !(_la==TRUE || _la==FALSE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 3:
				_localctx = new BaseValContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(240);
				match(LPAR);
				setState(241);
				exp();
				setState(242);
				match(RPAR);
				}
				break;
			case 4:
				_localctx = new VarValContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(244);
				match(ID);
				}
				break;
			case 5:
				_localctx = new FuncallContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(245);
				match(ID);
				setState(258);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LPAR) {
					{
					setState(246);
					match(LPAR);
					setState(255);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << TRUE) | (1L << FALSE) | (1L << LPAR) | (1L << IF) | (1L << NOT) | (1L << PRINT) | (1L << INT) | (1L << BOOL) | (1L << NEW) | (1L << NULL) | (1L << VOID) | (1L << INTEGER) | (1L << ID))) != 0)) {
						{
						setState(247);
						((FuncallContext)_localctx).exp = exp();
						((FuncallContext)_localctx).elem.add(((FuncallContext)_localctx).exp);
						setState(252);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(248);
							match(COMMA);
							setState(249);
							((FuncallContext)_localctx).exp = exp();
							((FuncallContext)_localctx).elem.add(((FuncallContext)_localctx).exp);
							}
							}
							setState(254);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(257);
					match(RPAR);
					}
				}

				}
				break;
			case 6:
				_localctx = new NullValContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(260);
				match(NULL);
				}
				break;
			case 7:
				_localctx = new FieldValContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(261);
				match(ID);
				setState(262);
				match(DOT);
				setState(263);
				match(ID);
				}
				break;
			case 8:
				_localctx = new MethodCallContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(264);
				match(ID);
				setState(265);
				match(DOT);
				setState(266);
				match(ID);
				setState(267);
				match(LPAR);
				setState(276);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << TRUE) | (1L << FALSE) | (1L << LPAR) | (1L << IF) | (1L << NOT) | (1L << PRINT) | (1L << INT) | (1L << BOOL) | (1L << NEW) | (1L << NULL) | (1L << VOID) | (1L << INTEGER) | (1L << ID))) != 0)) {
					{
					setState(268);
					((MethodCallContext)_localctx).exp = exp();
					((MethodCallContext)_localctx).elem.add(((MethodCallContext)_localctx).exp);
					setState(273);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(269);
						match(COMMA);
						setState(270);
						((MethodCallContext)_localctx).exp = exp();
						((MethodCallContext)_localctx).elem.add(((MethodCallContext)_localctx).exp);
						}
						}
						setState(275);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(278);
				match(RPAR);
				}
				break;
			case 9:
				_localctx = new ClassInstantiationContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(279);
				match(NEW);
				setState(280);
				match(ID);
				setState(281);
				match(LPAR);
				setState(290);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << TRUE) | (1L << FALSE) | (1L << LPAR) | (1L << IF) | (1L << NOT) | (1L << PRINT) | (1L << INT) | (1L << BOOL) | (1L << NEW) | (1L << NULL) | (1L << VOID) | (1L << INTEGER) | (1L << ID))) != 0)) {
					{
					setState(282);
					((ClassInstantiationContext)_localctx).exp = exp();
					((ClassInstantiationContext)_localctx).elem.add(((ClassInstantiationContext)_localctx).exp);
					setState(287);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(283);
						match(COMMA);
						setState(284);
						((ClassInstantiationContext)_localctx).exp = exp();
						((ClassInstantiationContext)_localctx).elem.add(((ClassInstantiationContext)_localctx).exp);
						}
						}
						setState(289);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(292);
				match(RPAR);
				}
				break;
			case 10:
				_localctx = new PrintContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(293);
				match(PRINT);
				{
				setState(294);
				exp();
				}
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3-\u012c\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\6\2)\n\2\r\2\16\2*\3\2\3\2\5\2/\n\2\3\2\3\2\3\2\3\2\5\2\65"+
		"\n\2\3\3\3\3\3\3\3\3\5\3;\n\3\3\3\3\3\3\3\3\3\7\3A\n\3\f\3\16\3D\13\3"+
		"\5\3F\n\3\3\3\5\3I\n\3\3\3\3\3\3\3\3\3\7\3O\n\3\f\3\16\3R\13\3\3\3\5\3"+
		"U\n\3\3\4\3\4\3\4\3\4\6\4[\n\4\r\4\16\4\\\3\4\3\4\3\5\3\5\3\5\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6p\n\6\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\7\7x\n\7\f\7\16\7{\13\7\5\7}\n\7\3\7\3\7\3\7\3\7\3\7\6\7\u0084\n"+
		"\7\r\7\16\7\u0085\3\7\3\7\5\7\u008a\n\7\3\7\3\7\3\b\3\b\5\b\u0090\n\b"+
		"\3\t\3\t\3\n\3\n\3\n\5\n\u0097\n\n\3\n\3\n\3\n\5\n\u009c\n\n\3\n\3\n\3"+
		"\n\5\n\u00a1\n\n\3\n\3\n\3\n\5\n\u00a6\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00b6\n\n\3\13\3\13\3\13\5\13\u00bb\n"+
		"\13\3\13\3\13\3\13\5\13\u00c0\n\13\5\13\u00c2\n\13\3\f\6\f\u00c5\n\f\r"+
		"\f\16\f\u00c6\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00d5"+
		"\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00ec\n\16\3\17\5\17\u00ef"+
		"\n\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17"+
		"\u00fd\n\17\f\17\16\17\u0100\13\17\5\17\u0102\n\17\3\17\5\17\u0105\n\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u0112\n\17"+
		"\f\17\16\17\u0115\13\17\5\17\u0117\n\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\7\17\u0120\n\17\f\17\16\17\u0123\13\17\5\17\u0125\n\17\3\17\3\17"+
		"\3\17\5\17\u012a\n\17\3\17\2\2\20\2\4\6\b\n\f\16\20\22\24\26\30\32\34"+
		"\2\4\5\2\"#((**\3\2\21\22\2\u0154\2\64\3\2\2\2\4\66\3\2\2\2\6V\3\2\2\2"+
		"\b`\3\2\2\2\no\3\2\2\2\fq\3\2\2\2\16\u008f\3\2\2\2\20\u0091\3\2\2\2\22"+
		"\u00b5\3\2\2\2\24\u00c1\3\2\2\2\26\u00c4\3\2\2\2\30\u00d4\3\2\2\2\32\u00eb"+
		"\3\2\2\2\34\u0129\3\2\2\2\36\37\5\22\n\2\37 \7\3\2\2 !\7\2\2\3!\65\3\2"+
		"\2\2\"#\5\6\4\2#$\5\22\n\2$%\7\3\2\2%&\7\2\2\3&\65\3\2\2\2\')\5\4\3\2"+
		"(\'\3\2\2\2)*\3\2\2\2*(\3\2\2\2*+\3\2\2\2+,\3\2\2\2,.\7\3\2\2-/\5\6\4"+
		"\2.-\3\2\2\2./\3\2\2\2/\60\3\2\2\2\60\61\5\22\n\2\61\62\7\3\2\2\62\63"+
		"\7\2\2\3\63\65\3\2\2\2\64\36\3\2\2\2\64\"\3\2\2\2\64(\3\2\2\2\65\3\3\2"+
		"\2\2\66\67\7$\2\2\67:\7*\2\289\7%\2\29;\7*\2\2:8\3\2\2\2:;\3\2\2\2;H\3"+
		"\2\2\2<E\7\23\2\2=B\5\b\5\2>?\7\5\2\2?A\5\b\5\2@>\3\2\2\2AD\3\2\2\2B@"+
		"\3\2\2\2BC\3\2\2\2CF\3\2\2\2DB\3\2\2\2E=\3\2\2\2EF\3\2\2\2FG\3\2\2\2G"+
		"I\7\24\2\2H<\3\2\2\2HI\3\2\2\2IT\3\2\2\2JP\7\25\2\2KL\5\f\7\2LM\7\3\2"+
		"\2MO\3\2\2\2NK\3\2\2\2OR\3\2\2\2PN\3\2\2\2PQ\3\2\2\2QS\3\2\2\2RP\3\2\2"+
		"\2SU\7\26\2\2TJ\3\2\2\2TU\3\2\2\2U\5\3\2\2\2VZ\7\36\2\2WX\5\16\b\2XY\7"+
		"\3\2\2Y[\3\2\2\2ZW\3\2\2\2[\\\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]^\3\2\2\2"+
		"^_\7\37\2\2_\7\3\2\2\2`a\5\20\t\2ab\7*\2\2b\t\3\2\2\2cd\5\b\5\2de\7\b"+
		"\2\2ef\5\22\n\2fp\3\2\2\2gh\7*\2\2hi\7\b\2\2ip\5\22\n\2jk\7*\2\2kl\7\6"+
		"\2\2lm\7*\2\2mn\7\b\2\2np\5\22\n\2oc\3\2\2\2og\3\2\2\2oj\3\2\2\2p\13\3"+
		"\2\2\2qr\5\20\t\2rs\7*\2\2s|\7\23\2\2ty\5\b\5\2uv\7\5\2\2vx\5\b\5\2wu"+
		"\3\2\2\2x{\3\2\2\2yw\3\2\2\2yz\3\2\2\2z}\3\2\2\2{y\3\2\2\2|t\3\2\2\2|"+
		"}\3\2\2\2}~\3\2\2\2~\u0089\7\24\2\2\177\u0083\7\36\2\2\u0080\u0081\5\n"+
		"\6\2\u0081\u0082\7\3\2\2\u0082\u0084\3\2\2\2\u0083\u0080\3\2\2\2\u0084"+
		"\u0085\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087\3\2"+
		"\2\2\u0087\u0088\7\37\2\2\u0088\u008a\3\2\2\2\u0089\177\3\2\2\2\u0089"+
		"\u008a\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008c\5\22\n\2\u008c\r\3\2\2"+
		"\2\u008d\u0090\5\n\6\2\u008e\u0090\5\f\7\2\u008f\u008d\3\2\2\2\u008f\u008e"+
		"\3\2\2\2\u0090\17\3\2\2\2\u0091\u0092\t\2\2\2\u0092\21\3\2\2\2\u0093\u0096"+
		"\5\24\13\2\u0094\u0095\7\r\2\2\u0095\u0097\5\22\n\2\u0096\u0094\3\2\2"+
		"\2\u0096\u0097\3\2\2\2\u0097\u00b6\3\2\2\2\u0098\u009b\5\24\13\2\u0099"+
		"\u009a\7\16\2\2\u009a\u009c\5\22\n\2\u009b\u0099\3\2\2\2\u009b\u009c\3"+
		"\2\2\2\u009c\u00b6\3\2\2\2\u009d\u00a0\5\24\13\2\u009e\u009f\7\32\2\2"+
		"\u009f\u00a1\5\22\n\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00b6"+
		"\3\2\2\2\u00a2\u00a5\5\24\13\2\u00a3\u00a4\7\33\2\2\u00a4\u00a6\5\22\n"+
		"\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00b6\3\2\2\2\u00a7\u00a8"+
		"\7\34\2\2\u00a8\u00b6\5\22\n\2\u00a9\u00b6\5\26\f\2\u00aa\u00ab\7\27\2"+
		"\2\u00ab\u00ac\5\22\n\2\u00ac\u00ad\7\30\2\2\u00ad\u00ae\7\25\2\2\u00ae"+
		"\u00af\5\22\n\2\u00af\u00b0\7\26\2\2\u00b0\u00b1\7\31\2\2\u00b1\u00b2"+
		"\7\25\2\2\u00b2\u00b3\5\22\n\2\u00b3\u00b4\7\26\2\2\u00b4\u00b6\3\2\2"+
		"\2\u00b5\u0093\3\2\2\2\u00b5\u0098\3\2\2\2\u00b5\u009d\3\2\2\2\u00b5\u00a2"+
		"\3\2\2\2\u00b5\u00a7\3\2\2\2\u00b5\u00a9\3\2\2\2\u00b5\u00aa\3\2\2\2\u00b6"+
		"\23\3\2\2\2\u00b7\u00ba\5\32\16\2\u00b8\u00b9\7\17\2\2\u00b9\u00bb\5\24"+
		"\13\2\u00ba\u00b8\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00c2\3\2\2\2\u00bc"+
		"\u00bf\5\32\16\2\u00bd\u00be\7\20\2\2\u00be\u00c0\5\24\13\2\u00bf\u00bd"+
		"\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c2\3\2\2\2\u00c1\u00b7\3\2\2\2\u00c1"+
		"\u00bc\3\2\2\2\u00c2\25\3\2\2\2\u00c3\u00c5\5\30\r\2\u00c4\u00c3\3\2\2"+
		"\2\u00c5\u00c6\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\27"+
		"\3\2\2\2\u00c8\u00d5\5\n\6\2\u00c9\u00ca\7\27\2\2\u00ca\u00cb\5\22\n\2"+
		"\u00cb\u00cc\7\30\2\2\u00cc\u00cd\7\25\2\2\u00cd\u00ce\5\26\f\2\u00ce"+
		"\u00cf\7\26\2\2\u00cf\u00d0\7\31\2\2\u00d0\u00d1\7\25\2\2\u00d1\u00d2"+
		"\5\26\f\2\u00d2\u00d3\7\26\2\2\u00d3\u00d5\3\2\2\2\u00d4\u00c8\3\2\2\2"+
		"\u00d4\u00c9\3\2\2\2\u00d5\31\3\2\2\2\u00d6\u00d7\5\34\17\2\u00d7\u00d8"+
		"\7\7\2\2\u00d8\u00d9\5\34\17\2\u00d9\u00ec\3\2\2\2\u00da\u00db\5\34\17"+
		"\2\u00db\u00dc\7\n\2\2\u00dc\u00dd\5\34\17\2\u00dd\u00ec\3\2\2\2\u00de"+
		"\u00df\5\34\17\2\u00df\u00e0\7\t\2\2\u00e0\u00e1\5\34\17\2\u00e1\u00ec"+
		"\3\2\2\2\u00e2\u00e3\5\34\17\2\u00e3\u00e4\7\f\2\2\u00e4\u00e5\5\34\17"+
		"\2\u00e5\u00ec\3\2\2\2\u00e6\u00e7\5\34\17\2\u00e7\u00e8\7\13\2\2\u00e8"+
		"\u00e9\5\34\17\2\u00e9\u00ec\3\2\2\2\u00ea\u00ec\5\34\17\2\u00eb\u00d6"+
		"\3\2\2\2\u00eb\u00da\3\2\2\2\u00eb\u00de\3\2\2\2\u00eb\u00e2\3\2\2\2\u00eb"+
		"\u00e6\3\2\2\2\u00eb\u00ea\3\2\2\2\u00ec\33\3\2\2\2\u00ed\u00ef\7\16\2"+
		"\2\u00ee\u00ed\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u012a"+
		"\7)\2\2\u00f1\u012a\t\3\2\2\u00f2\u00f3\7\23\2\2\u00f3\u00f4\5\22\n\2"+
		"\u00f4\u00f5\7\24\2\2\u00f5\u012a\3\2\2\2\u00f6\u012a\7*\2\2\u00f7\u0104"+
		"\7*\2\2\u00f8\u0101\7\23\2\2\u00f9\u00fe\5\22\n\2\u00fa\u00fb\7\5\2\2"+
		"\u00fb\u00fd\5\22\n\2\u00fc\u00fa\3\2\2\2\u00fd\u0100\3\2\2\2\u00fe\u00fc"+
		"\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0102\3\2\2\2\u0100\u00fe\3\2\2\2\u0101"+
		"\u00f9\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u0105\7\24"+
		"\2\2\u0104\u00f8\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u012a\3\2\2\2\u0106"+
		"\u012a\7\'\2\2\u0107\u0108\7*\2\2\u0108\u0109\7\6\2\2\u0109\u012a\7*\2"+
		"\2\u010a\u010b\7*\2\2\u010b\u010c\7\6\2\2\u010c\u010d\7*\2\2\u010d\u0116"+
		"\7\23\2\2\u010e\u0113\5\22\n\2\u010f\u0110\7\5\2\2\u0110\u0112\5\22\n"+
		"\2\u0111\u010f\3\2\2\2\u0112\u0115\3\2\2\2\u0113\u0111\3\2\2\2\u0113\u0114"+
		"\3\2\2\2\u0114\u0117\3\2\2\2\u0115\u0113\3\2\2\2\u0116\u010e\3\2\2\2\u0116"+
		"\u0117\3\2\2\2\u0117\u0118\3\2\2\2\u0118\u012a\7\24\2\2\u0119\u011a\7"+
		"&\2\2\u011a\u011b\7*\2\2\u011b\u0124\7\23\2\2\u011c\u0121\5\22\n\2\u011d"+
		"\u011e\7\5\2\2\u011e\u0120\5\22\n\2\u011f\u011d\3\2\2\2\u0120\u0123\3"+
		"\2\2\2\u0121\u011f\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u0125\3\2\2\2\u0123"+
		"\u0121\3\2\2\2\u0124\u011c\3\2\2\2\u0124\u0125\3\2\2\2\u0125\u0126\3\2"+
		"\2\2\u0126\u012a\7\24\2\2\u0127\u0128\7\35\2\2\u0128\u012a\5\22\n\2\u0129"+
		"\u00ee\3\2\2\2\u0129\u00f1\3\2\2\2\u0129\u00f2\3\2\2\2\u0129\u00f6\3\2"+
		"\2\2\u0129\u00f7\3\2\2\2\u0129\u0106\3\2\2\2\u0129\u0107\3\2\2\2\u0129"+
		"\u010a\3\2\2\2\u0129\u0119\3\2\2\2\u0129\u0127\3\2\2\2\u012a\35\3\2\2"+
		"\2&*.\64:BEHPT\\oy|\u0085\u0089\u008f\u0096\u009b\u00a0\u00a5\u00b5\u00ba"+
		"\u00bf\u00c1\u00c6\u00d4\u00eb\u00ee\u00fe\u0101\u0104\u0113\u0116\u0121"+
		"\u0124\u0129";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}