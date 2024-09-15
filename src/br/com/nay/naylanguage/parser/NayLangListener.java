// Generated from NayLang.g4 by ANTLR 4.7.1
package br.com.nay.naylanguage.parser;

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

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link NayLangParser}.
 */
public interface NayLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link NayLangParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(NayLangParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link NayLangParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(NayLangParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link NayLangParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(NayLangParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link NayLangParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(NayLangParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link NayLangParser#declaravar}.
	 * @param ctx the parse tree
	 */
	void enterDeclaravar(NayLangParser.DeclaravarContext ctx);
	/**
	 * Exit a parse tree produced by {@link NayLangParser#declaravar}.
	 * @param ctx the parse tree
	 */
	void exitDeclaravar(NayLangParser.DeclaravarContext ctx);
	/**
	 * Enter a parse tree produced by {@link NayLangParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(NayLangParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link NayLangParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(NayLangParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link NayLangParser#bloco}.
	 * @param ctx the parse tree
	 */
	void enterBloco(NayLangParser.BlocoContext ctx);
	/**
	 * Exit a parse tree produced by {@link NayLangParser#bloco}.
	 * @param ctx the parse tree
	 */
	void exitBloco(NayLangParser.BlocoContext ctx);
	/**
	 * Enter a parse tree produced by {@link NayLangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(NayLangParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link NayLangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(NayLangParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link NayLangParser#cmdleitura}.
	 * @param ctx the parse tree
	 */
	void enterCmdleitura(NayLangParser.CmdleituraContext ctx);
	/**
	 * Exit a parse tree produced by {@link NayLangParser#cmdleitura}.
	 * @param ctx the parse tree
	 */
	void exitCmdleitura(NayLangParser.CmdleituraContext ctx);
	/**
	 * Enter a parse tree produced by {@link NayLangParser#cmdescrita}.
	 * @param ctx the parse tree
	 */
	void enterCmdescrita(NayLangParser.CmdescritaContext ctx);
	/**
	 * Exit a parse tree produced by {@link NayLangParser#cmdescrita}.
	 * @param ctx the parse tree
	 */
	void exitCmdescrita(NayLangParser.CmdescritaContext ctx);
	/**
	 * Enter a parse tree produced by {@link NayLangParser#cmdattrib}.
	 * @param ctx the parse tree
	 */
	void enterCmdattrib(NayLangParser.CmdattribContext ctx);
	/**
	 * Exit a parse tree produced by {@link NayLangParser#cmdattrib}.
	 * @param ctx the parse tree
	 */
	void exitCmdattrib(NayLangParser.CmdattribContext ctx);
	/**
	 * Enter a parse tree produced by {@link NayLangParser#cmdselecao}.
	 * @param ctx the parse tree
	 */
	void enterCmdselecao(NayLangParser.CmdselecaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link NayLangParser#cmdselecao}.
	 * @param ctx the parse tree
	 */
	void exitCmdselecao(NayLangParser.CmdselecaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link NayLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(NayLangParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NayLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(NayLangParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NayLangParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(NayLangParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link NayLangParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(NayLangParser.TermoContext ctx);
}