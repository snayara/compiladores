package br.com.nay.naylanguage.ast;

import br.com.nay.naylanguage.datastructures.NayVariable;

public class ReadCommand extends AbstractCommand{
	private String id;
	private NayVariable var;
	
	public ReadCommand (String id, NayVariable var) {
		this.id = id;
		this.var = var;
	}
	
	@Override
	public String generateJavaCode() {
	    String code = "";

	    switch (var.getType()) {
	        case NayVariable.DOUBLE:
	            code = id + " = _key.nextDouble();";
	            break;
	        case NayVariable.NUMBER:
	            code = id + " = _key.nextInt();";
	            break;
	        case NayVariable.TEXT:
	            code = id + " = _key.nextLine();";
	            break;
	        default:
	            throw new IllegalArgumentException("Tipo de variável desconhecido: " + var.getType());
	    }

	    return code;
	}
	@Override
	public String toString() {
		return "ReadCommand [id=" + id + "]";
	}

}
