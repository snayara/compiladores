package br.com.nay.naylanguage.datastructures;

public abstract class NaySymbol {
	
	protected String name;
	
	public abstract String generateJavaCode();
	public NaySymbol(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "NaySymbol [name=" + name + "]";
	}

}
