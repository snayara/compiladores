package br.com.nay.naylanguage.ast;

public class WriteCommand extends AbstractCommand{
	private String value;
    private boolean isString;
    
    public WriteCommand(String value, boolean isString) {
        this.value = value;
        this.isString = isString;
    }
    
    @Override
    public String generateJavaCode() {
        if (isString) {
        	// Se for uma string literal, imprime o texto com aspas
            return "System.out.println(\"" + value + "\");";
        } else {
            // Se for uma variável, imprime o valor da variável
            return "System.out.println(" + value + ");";
        }
    }
    
    @Override
    public String toString() {
        return "WriteCommand [value=" + value + ", isString=" + isString + "]";
    }
	
}
