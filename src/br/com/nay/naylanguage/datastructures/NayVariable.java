package br.com.nay.naylanguage.datastructures;

public class NayVariable extends NaySymbol{
	
	public static final int NUMBER=0;
	public static final int DOUBLE=1;
	public static final int TEXT = 2;
	
	private int type;
	private String value;
	
	public NayVariable(String name, int type, String value) {
		super(name);
		this.type = type;
		this.value = value;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "NayVariable [name=" + name + ", type=" + type + ", value=" + value + "]";
	}


	public String generateJavaCode() {
	    String str;
	       if (type == NUMBER) {
	    	   str = "int ";
	       }
	       else if (type == DOUBLE) {
	    	   str = "double ";
	       }
	       else {
	    	   str = "String ";
	       }
	       return str + " "+super.name+";";
	}
}
