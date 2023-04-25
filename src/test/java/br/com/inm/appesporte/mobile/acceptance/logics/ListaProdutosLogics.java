package br.com.inm.appesporte.mobile.acceptance.logics;


import br.com.inm.appesporte.mobile.acceptance.pages.ListaProdutoPageObject;
import br.com.inm.appesporte.mobile.config.Log;

/**
 * 
 * Classe Logic da tela lista de produtos
 * 
 * @author August Neto
 *
 */

public class ListaProdutosLogics extends LogicsBase {

	private ListaProdutoPageObject listapage;

	private static Log log = new Log();
	
	/**
	 * Construtor padrão
	 */

	public ListaProdutosLogics() {
		listapage = new ListaProdutoPageObject();
		
	}
	
	/**
	 * Construtor que mantem o controle de página
	 * 
	 * @param loginpage
	 */
	public ListaProdutosLogics(ListaProdutoPageObject listapage) {
		this();
		this.listapage = listapage;
	}

	/**
	 * Método que verifica se esta na pafina de lista de produto
	 * 
	 * @return Retorna verdadeiro se estiver na página de lista de produto
	 */
	public boolean ePaginaListaProdutos() {
		log.mensagemGeral("Verificando se esta na página de lista de produtos");
		return (listapage.contemAbaProdutos() &&
				listapage.abaProdutosAtiva());

	}

	/**
	 * Método que desloga e retorna a página de login
	 * 
	 * @return a página Logics da tela de login
	 */
	public LoginLogics sair() {
		loginpage = listapage.clicarBotaoSair();
		return new LoginLogics(loginpage);
		
	}
	
}
