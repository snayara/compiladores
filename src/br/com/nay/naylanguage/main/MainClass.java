package br.com.nay.naylanguage.main;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import br.com.nay.naylanguage.exceptions.NaySemanticException;
import br.com.nay.naylanguage.parser.NayLangLexer;
import br.com.nay.naylanguage.parser.NayLangParser;

/*Esta é a classe responsável por criar a interação com o usuário
 *instanciando nosso parser e apontando para o arquivo fonte
 *
 *Arquivo fonte: extensão .nay
 *
 */

public class MainClass {
    public static void main(String[] args) {
        try {
        	NayLangLexer lexer;
        	NayLangParser parser;
            // Leio o arquivo "input.nay" e isso é entrada para o Analisador Léxico
            lexer = new NayLangLexer(CharStreams.fromFileName("input.nay"));
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            
            parser = new NayLangParser(tokenStream);
            
            parser.prog();
            
            System.out.println("Compilation Successful!");
            
            parser.exibeComandos();
            
            parser.generateCode();
           
        } 
        catch (NaySemanticException ex) {
        	System.err.println("Semantic error - "+ex.getMessage());
        }
        catch(Exception ex) {
            System.err.println("ERROR: " + ex.getMessage());
        }
    }
}
