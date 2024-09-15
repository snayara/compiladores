package br.com.nay.naylanguage.datastructures;

import java.util.ArrayList;
import java.util.HashMap;

public class NaySymbolTable {
	
	private HashMap<String, NaySymbol> map;
	
	public NaySymbolTable() {
		map = new HashMap<String, NaySymbol>();
	}
	
	public void add(NaySymbol symbol) {
		map.put(symbol.getName(), symbol);
	}
	
	public boolean exists(String symbolName) {
		return map.get(symbolName) != null;
	}
	
	public NaySymbol get(String symbolName) {
		return map.get(symbolName);
	}
	
	public ArrayList<NaySymbol> getAll(){
		ArrayList<NaySymbol> lista = new ArrayList<NaySymbol>();
		for (NaySymbol symbol : map.values()) {
			lista.add(symbol);
		}
		return lista;
	}
	
}
