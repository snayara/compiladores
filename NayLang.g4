grammar NayLang;

@header{
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
}

@members {
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
}

prog : 'programa' decl bloco 'fimprog;'
		{ 	
			program.setVarTable(symbolTable);
			program.setComandos(stack.pop()); 
		}
	;
	 
decl : (declaravar)+
	;

declaravar : tipo ID  {
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
              (  VIR 
              	 ID {
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
              )* 
               SC
           ;

tipo     : 'inteiro' {_tipo = NayVariable.NUMBER;}
		 | 'double' {_tipo = NayVariable.DOUBLE;}
		 | 'texto'  {_tipo = NayVariable.TEXT;}
		  ;

bloco : { curThread = new ArrayList<AbstractCommand>();
		  stack.push(curThread);
		}
		(cmd)+
	  ;

cmd : cmdleitura 
	| cmdescrita 
	| cmdattrib 
	| cmdselecao
	;

cmdleitura : 'leia' AP ID {
								verificaID(_input.LT(-1).getText());
								_readID = _input.LT(-1).getText();
							}
					 FP 
					 SC
					 {	
					 	NayVariable var = (NayVariable)symbolTable.get(_readID);
					 	ReadCommand cmd = new ReadCommand(_readID, var);
					 	stack.peek().add(cmd);
					 }
			;

cmdescrita : 'escreva' AP 
							(STRING { _writeID = _input.LT(-1).getText(); } 
                        	| ID { _writeID = _input.LT(-1).getText(); })
							 FP 
							 SC
							 {
	                            boolean isString = _writeID.startsWith("\"") && _writeID.endsWith("\"");
	                            WriteCommand cmd = new WriteCommand(_writeID, isString);
	                            stack.peek().add(cmd);
							 }
			;

cmdattrib : ID {
				verificaID(_input.LT(-1).getText());
				_exprID = _input.LT(-1).getText();
				}
			ATTR { _exprContent = ""; }
			expr 
			SC {
				AttributionCommand cmd = new AttributionCommand(_exprID, _exprContent);
				stack.peek().add(cmd);
			}
		  ;
		  
cmdselecao  :  'se' AP
                    ID    { _exprDecision = _input.LT(-1).getText(); }
                    OPREL { _exprDecision += _input.LT(-1).getText(); }
                    (ID | NUMBER) {_exprDecision += _input.LT(-1).getText(); }
                    FP 
                    ACH 
                    { curThread = new ArrayList<AbstractCommand>(); 
                      stack.push(curThread);
                    }
                    (cmd)+ 
                    
                    FCH 
                    {
                       listaTrue = stack.pop();	
                    } 
                   ('senao' 
                   	 ACH
                   	 {
                   	 	curThread = new ArrayList<AbstractCommand>();
                   	 	stack.push(curThread);
                   	 } 
                   	(cmd+) 
                   	FCH
                   	{
                   		listaFalse = stack.pop();
                   		DecisionCommand cmd = new DecisionCommand(_exprDecision, listaTrue, listaFalse);
                   		stack.peek().add(cmd);
                   	}
                   )?
            ;
		   
expr : termo ( 
				OP {_exprContent += _input.LT(-1).getText();}
				termo
				)*
	;

termo : ID {
			verificaID(_input.LT(-1).getText());
			_exprContent += _input.LT(-1).getText();
			}
		| NUMBER {
			_exprContent += _input.LT(-1).getText();
		}
		| STRING {
            _exprContent += _input.LT(-1).getText();
        }
	  ;

AP	: '('
	;
	
FP	: ')'
	;
	
SC	: ';'
	;
	
OP	: '+' | '-' | '*' | '/'
	;
	
ATTR : '='
	 ;
	 
VIR  : ','
     ;
     
ACH  : '{'
     ;
     
FCH  : '}'
     ;
	 
OPREL : '>' | '<' | '>=' | '<=' | '==' | '!='
      ;

STRING  : '"' ('\\' . | ~('\\' | '"'))* '"'
		;
      
ID	: [a-z] ([a-z] | [A-Z] | [0-9])*
	;


NUMBER	: [0-9]+ ('.' [0-9]+)?
		;
		
WS	: (' ' | '\t' | '\n' | '\r') -> skip;      
