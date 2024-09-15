package br.com.nay.naylanguage.ast;

public class AttributionCommand extends AbstractCommand{
	private String id;
	private String expr;
	
	public AttributionCommand(String id, String expr) {
		this.id = id;
		this.expr = expr;	
	}

	@Override
	public String generateJavaCode() {
		// TODO Auto-generated method stub
		return id + "=" + expr+";";
	}
	
	@Override
	public String toString() {
		return "AttributionCommand id=" + id + ", expr=" + expr + "]";
	}

}
