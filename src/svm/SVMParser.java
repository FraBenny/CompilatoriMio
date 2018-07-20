// Generated from SVM.g4 by ANTLR 4.7.1

    package svm;
    import java.util.HashMap;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SVMParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PUSH=1, POP=2, ADD=3, SUB=4, MULT=5, DIV=6, STOREW=7, LOADW=8, BRANCH=9, 
		BRANCHEQ=10, BRANCHLESSEQ=11, JS=12, LOADRA=13, STORERA=14, LOADRV=15, 
		STORERV=16, LOADFP=17, STOREFP=18, COPYFP=19, LOADHP=20, STOREHP=21, PRINT=22, 
		HALT=23, NEW=24, LC=25, COPY=26, COL=27, LABEL=28, NUMBER=29, WHITESP=30, 
		ERR=31;
	public static final int
		RULE_assembly = 0;
	public static final String[] ruleNames = {
		"assembly"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'push'", "'pop'", "'add'", "'sub'", "'mult'", "'div'", "'sw'", 
		"'lw'", "'b'", "'beq'", "'bleq'", "'js'", "'lra'", "'sra'", "'lrv'", "'srv'", 
		"'lfp'", "'sfp'", "'cfp'", "'lhp'", "'shp'", "'print'", "'halt'", "'new'", 
		"'lc'", "'copy'", "':'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "PUSH", "POP", "ADD", "SUB", "MULT", "DIV", "STOREW", "LOADW", "BRANCH", 
		"BRANCHEQ", "BRANCHLESSEQ", "JS", "LOADRA", "STORERA", "LOADRV", "STORERV", 
		"LOADFP", "STOREFP", "COPYFP", "LOADHP", "STOREHP", "PRINT", "HALT", "NEW", 
		"LC", "COPY", "COL", "LABEL", "NUMBER", "WHITESP", "ERR"
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
	public String getGrammarFileName() { return "SVM.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }



	    private ArrayList<Integer> code = new ArrayList<Integer>();
	    private HashMap<String,Integer> labelAdd = new HashMap<String,Integer>();
	    private HashMap<Integer,String> labelRef = new HashMap<Integer,String>();

	    public int[] getBytecode() {
	        int[] bytecode = new int[this.code.size()];
	        for (int ii = 0; ii < this.code.size(); ii++) {
	            bytecode[ii] = this.code.get(ii);
	        }
	        return bytecode;
	    }

	public SVMParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class AssemblyContext extends ParserRuleContext {
		public Token n;
		public Token l;
		public List<TerminalNode> PUSH() { return getTokens(SVMParser.PUSH); }
		public TerminalNode PUSH(int i) {
			return getToken(SVMParser.PUSH, i);
		}
		public List<TerminalNode> POP() { return getTokens(SVMParser.POP); }
		public TerminalNode POP(int i) {
			return getToken(SVMParser.POP, i);
		}
		public List<TerminalNode> ADD() { return getTokens(SVMParser.ADD); }
		public TerminalNode ADD(int i) {
			return getToken(SVMParser.ADD, i);
		}
		public List<TerminalNode> SUB() { return getTokens(SVMParser.SUB); }
		public TerminalNode SUB(int i) {
			return getToken(SVMParser.SUB, i);
		}
		public List<TerminalNode> MULT() { return getTokens(SVMParser.MULT); }
		public TerminalNode MULT(int i) {
			return getToken(SVMParser.MULT, i);
		}
		public List<TerminalNode> DIV() { return getTokens(SVMParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(SVMParser.DIV, i);
		}
		public List<TerminalNode> STOREW() { return getTokens(SVMParser.STOREW); }
		public TerminalNode STOREW(int i) {
			return getToken(SVMParser.STOREW, i);
		}
		public List<TerminalNode> LOADW() { return getTokens(SVMParser.LOADW); }
		public TerminalNode LOADW(int i) {
			return getToken(SVMParser.LOADW, i);
		}
		public List<TerminalNode> COL() { return getTokens(SVMParser.COL); }
		public TerminalNode COL(int i) {
			return getToken(SVMParser.COL, i);
		}
		public List<TerminalNode> BRANCH() { return getTokens(SVMParser.BRANCH); }
		public TerminalNode BRANCH(int i) {
			return getToken(SVMParser.BRANCH, i);
		}
		public List<TerminalNode> BRANCHEQ() { return getTokens(SVMParser.BRANCHEQ); }
		public TerminalNode BRANCHEQ(int i) {
			return getToken(SVMParser.BRANCHEQ, i);
		}
		public List<TerminalNode> BRANCHLESSEQ() { return getTokens(SVMParser.BRANCHLESSEQ); }
		public TerminalNode BRANCHLESSEQ(int i) {
			return getToken(SVMParser.BRANCHLESSEQ, i);
		}
		public List<TerminalNode> JS() { return getTokens(SVMParser.JS); }
		public TerminalNode JS(int i) {
			return getToken(SVMParser.JS, i);
		}
		public List<TerminalNode> LOADRA() { return getTokens(SVMParser.LOADRA); }
		public TerminalNode LOADRA(int i) {
			return getToken(SVMParser.LOADRA, i);
		}
		public List<TerminalNode> STORERA() { return getTokens(SVMParser.STORERA); }
		public TerminalNode STORERA(int i) {
			return getToken(SVMParser.STORERA, i);
		}
		public List<TerminalNode> LOADRV() { return getTokens(SVMParser.LOADRV); }
		public TerminalNode LOADRV(int i) {
			return getToken(SVMParser.LOADRV, i);
		}
		public List<TerminalNode> STORERV() { return getTokens(SVMParser.STORERV); }
		public TerminalNode STORERV(int i) {
			return getToken(SVMParser.STORERV, i);
		}
		public List<TerminalNode> LOADFP() { return getTokens(SVMParser.LOADFP); }
		public TerminalNode LOADFP(int i) {
			return getToken(SVMParser.LOADFP, i);
		}
		public List<TerminalNode> STOREFP() { return getTokens(SVMParser.STOREFP); }
		public TerminalNode STOREFP(int i) {
			return getToken(SVMParser.STOREFP, i);
		}
		public List<TerminalNode> COPYFP() { return getTokens(SVMParser.COPYFP); }
		public TerminalNode COPYFP(int i) {
			return getToken(SVMParser.COPYFP, i);
		}
		public List<TerminalNode> LOADHP() { return getTokens(SVMParser.LOADHP); }
		public TerminalNode LOADHP(int i) {
			return getToken(SVMParser.LOADHP, i);
		}
		public List<TerminalNode> STOREHP() { return getTokens(SVMParser.STOREHP); }
		public TerminalNode STOREHP(int i) {
			return getToken(SVMParser.STOREHP, i);
		}
		public List<TerminalNode> PRINT() { return getTokens(SVMParser.PRINT); }
		public TerminalNode PRINT(int i) {
			return getToken(SVMParser.PRINT, i);
		}
		public List<TerminalNode> NEW() { return getTokens(SVMParser.NEW); }
		public TerminalNode NEW(int i) {
			return getToken(SVMParser.NEW, i);
		}
		public List<TerminalNode> LC() { return getTokens(SVMParser.LC); }
		public TerminalNode LC(int i) {
			return getToken(SVMParser.LC, i);
		}
		public List<TerminalNode> HALT() { return getTokens(SVMParser.HALT); }
		public TerminalNode HALT(int i) {
			return getToken(SVMParser.HALT, i);
		}
		public List<TerminalNode> COPY() { return getTokens(SVMParser.COPY); }
		public TerminalNode COPY(int i) {
			return getToken(SVMParser.COPY, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(SVMParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(SVMParser.NUMBER, i);
		}
		public List<TerminalNode> LABEL() { return getTokens(SVMParser.LABEL); }
		public TerminalNode LABEL(int i) {
			return getToken(SVMParser.LABEL, i);
		}
		public AssemblyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assembly; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).enterAssembly(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).exitAssembly(this);
		}
	}

	public final AssemblyContext assembly() throws RecognitionException {
		AssemblyContext _localctx = new AssemblyContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_assembly);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PUSH) | (1L << POP) | (1L << ADD) | (1L << SUB) | (1L << MULT) | (1L << DIV) | (1L << STOREW) | (1L << LOADW) | (1L << BRANCH) | (1L << BRANCHEQ) | (1L << BRANCHLESSEQ) | (1L << JS) | (1L << LOADRA) | (1L << STORERA) | (1L << LOADRV) | (1L << STORERV) | (1L << LOADFP) | (1L << STOREFP) | (1L << COPYFP) | (1L << LOADHP) | (1L << STOREHP) | (1L << PRINT) | (1L << HALT) | (1L << NEW) | (1L << LC) | (1L << COPY) | (1L << LABEL))) != 0)) {
				{
				setState(66);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(2);
					match(PUSH);
					setState(3);
					((AssemblyContext)_localctx).n = match(NUMBER);
					   code.add(PUSH);
								                code.add(Integer.parseInt((((AssemblyContext)_localctx).n!=null?((AssemblyContext)_localctx).n.getText():null)));     
					}
					break;
				case 2:
					{
					setState(5);
					match(PUSH);
					setState(6);
					((AssemblyContext)_localctx).l = match(LABEL);
					   code.add(PUSH);
					                                            labelRef.put(code.size(), (((AssemblyContext)_localctx).l!=null?((AssemblyContext)_localctx).l.getText():null));
					                                            code.add(0);                             
					}
					break;
				case 3:
					{
					setState(8);
					match(POP);
					   code.add(POP);  
					}
					break;
				case 4:
					{
					setState(10);
					match(ADD);
					   code.add(ADD);  
					}
					break;
				case 5:
					{
					setState(12);
					match(SUB);
					   code.add(SUB);    
					}
					break;
				case 6:
					{
					setState(14);
					match(MULT);
					   code.add(MULT);   
					}
					break;
				case 7:
					{
					setState(16);
					match(DIV);
					   code.add(DIV);  
					}
					break;
				case 8:
					{
					setState(18);
					match(STOREW);
					   code.add(STOREW);   
					}
					break;
				case 9:
					{
					setState(20);
					match(LOADW);
					   code.add(LOADW);    
					}
					break;
				case 10:
					{
					setState(22);
					((AssemblyContext)_localctx).l = match(LABEL);
					setState(23);
					match(COL);
					   labelAdd.put((((AssemblyContext)_localctx).l!=null?((AssemblyContext)_localctx).l.getText():null), code.size());   
					}
					break;
				case 11:
					{
					setState(25);
					match(BRANCH);
					setState(26);
					((AssemblyContext)_localctx).l = match(LABEL);
					   code.add(BRANCH);
					                                        labelRef.put(code.size(), (((AssemblyContext)_localctx).l!=null?((AssemblyContext)_localctx).l.getText():null));
					                                        code.add(0);                          
					}
					break;
				case 12:
					{
					setState(28);
					match(BRANCHEQ);
					setState(29);
					((AssemblyContext)_localctx).l = match(LABEL);
					   code.add(BRANCHEQ);
					                                        labelRef.put(code.size(), (((AssemblyContext)_localctx).l!=null?((AssemblyContext)_localctx).l.getText():null));
					                                        code.add(0);                          
					}
					break;
				case 13:
					{
					setState(31);
					match(BRANCHLESSEQ);
					setState(32);
					((AssemblyContext)_localctx).l = match(LABEL);
					   code.add(BRANCHLESSEQ);
					                                        labelRef.put(code.size(), (((AssemblyContext)_localctx).l!=null?((AssemblyContext)_localctx).l.getText():null));
					                                        code.add(0);                          
					}
					break;
				case 14:
					{
					setState(34);
					match(JS);
					   code.add(JS);    
					}
					break;
				case 15:
					{
					setState(36);
					match(LOADRA);
					   code.add(LOADRA);   
					}
					break;
				case 16:
					{
					setState(38);
					match(STORERA);
					   code.add(STORERA);  
					}
					break;
				case 17:
					{
					setState(40);
					match(LOADRV);
					   code.add(LOADRV);   
					}
					break;
				case 18:
					{
					setState(42);
					match(STORERV);
					   code.add(STORERV);  
					}
					break;
				case 19:
					{
					setState(44);
					match(LOADFP);
					   code.add(LOADFP);   
					}
					break;
				case 20:
					{
					setState(46);
					match(STOREFP);
					   code.add(STOREFP);  
					}
					break;
				case 21:
					{
					setState(48);
					match(COPYFP);
					   code.add(COPYFP);   
					}
					break;
				case 22:
					{
					setState(50);
					match(LOADHP);
					   code.add(LOADHP);   
					}
					break;
				case 23:
					{
					setState(52);
					match(STOREHP);
					   code.add(STOREHP);  
					}
					break;
				case 24:
					{
					setState(54);
					match(PRINT);
					   code.add(PRINT);    
					}
					break;
				case 25:
					{
					setState(56);
					match(NEW);
					   code.add(NEW);      
					}
					break;
				case 26:
					{
					setState(58);
					match(LC);
					   code.add(LC);       
					}
					break;
				case 27:
					{
					setState(60);
					match(HALT);
					   code.add(HALT);     
					}
					break;
				case 28:
					{
					setState(62);
					((AssemblyContext)_localctx).l = match(LABEL);
					   labelRef.put(code.size(), (((AssemblyContext)_localctx).l!=null?((AssemblyContext)_localctx).l.getText():null));
						                                    code.add(0);        
					}
					break;
				case 29:
					{
					setState(64);
					match(COPY);
					   code.add(COPY);     
					}
					break;
				}
				}
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}

				        for (Integer refAdd: labelRef.keySet()) {
				            code.set(refAdd, labelAdd.get(labelRef.get(refAdd)));
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3!L\4\2\t\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2E\n\2\f\2\16\2H\13\2\3\2\3\2"+
		"\3\2\2\2\3\2\2\2\2g\2F\3\2\2\2\4\5\7\3\2\2\5\6\7\37\2\2\6E\b\2\1\2\7\b"+
		"\7\3\2\2\b\t\7\36\2\2\tE\b\2\1\2\n\13\7\4\2\2\13E\b\2\1\2\f\r\7\5\2\2"+
		"\rE\b\2\1\2\16\17\7\6\2\2\17E\b\2\1\2\20\21\7\7\2\2\21E\b\2\1\2\22\23"+
		"\7\b\2\2\23E\b\2\1\2\24\25\7\t\2\2\25E\b\2\1\2\26\27\7\n\2\2\27E\b\2\1"+
		"\2\30\31\7\36\2\2\31\32\7\35\2\2\32E\b\2\1\2\33\34\7\13\2\2\34\35\7\36"+
		"\2\2\35E\b\2\1\2\36\37\7\f\2\2\37 \7\36\2\2 E\b\2\1\2!\"\7\r\2\2\"#\7"+
		"\36\2\2#E\b\2\1\2$%\7\16\2\2%E\b\2\1\2&\'\7\17\2\2\'E\b\2\1\2()\7\20\2"+
		"\2)E\b\2\1\2*+\7\21\2\2+E\b\2\1\2,-\7\22\2\2-E\b\2\1\2./\7\23\2\2/E\b"+
		"\2\1\2\60\61\7\24\2\2\61E\b\2\1\2\62\63\7\25\2\2\63E\b\2\1\2\64\65\7\26"+
		"\2\2\65E\b\2\1\2\66\67\7\27\2\2\67E\b\2\1\289\7\30\2\29E\b\2\1\2:;\7\32"+
		"\2\2;E\b\2\1\2<=\7\33\2\2=E\b\2\1\2>?\7\31\2\2?E\b\2\1\2@A\7\36\2\2AE"+
		"\b\2\1\2BC\7\34\2\2CE\b\2\1\2D\4\3\2\2\2D\7\3\2\2\2D\n\3\2\2\2D\f\3\2"+
		"\2\2D\16\3\2\2\2D\20\3\2\2\2D\22\3\2\2\2D\24\3\2\2\2D\26\3\2\2\2D\30\3"+
		"\2\2\2D\33\3\2\2\2D\36\3\2\2\2D!\3\2\2\2D$\3\2\2\2D&\3\2\2\2D(\3\2\2\2"+
		"D*\3\2\2\2D,\3\2\2\2D.\3\2\2\2D\60\3\2\2\2D\62\3\2\2\2D\64\3\2\2\2D\66"+
		"\3\2\2\2D8\3\2\2\2D:\3\2\2\2D<\3\2\2\2D>\3\2\2\2D@\3\2\2\2DB\3\2\2\2E"+
		"H\3\2\2\2FD\3\2\2\2FG\3\2\2\2GI\3\2\2\2HF\3\2\2\2IJ\b\2\1\2J\3\3\2\2\2"+
		"\4DF";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}