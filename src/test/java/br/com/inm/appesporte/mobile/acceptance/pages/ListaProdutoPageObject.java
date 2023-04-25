package br.com.inm.appesporte.mobile.acceptance.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Classe PageObject da tela lista de produtos
 * 
 * @author August Neto
 *
 */
public class ListaProdutoPageObject extends PageObjectBase{

	private WebElement aba_produtos;
	private WebElement btn_sair;
	
	private final By aba_idrotulos_localizador;
	private final By btn_idsair_localizador;

	
	/**
	 * Construtor Padrão
	 * 
	 * 
	 */
	public ListaProdutoPageObject() {
		super();
		LOG.mensagemGeral("Página Lista de Produtos instanciada");
		aba_idrotulos_localizador = By.id("br.com.alura.aluraesporte:id/listaProdutos");
		btn_idsair_localizador = By.id("br.com.alura.aluraesporte:id/menu_principal_deslogar");
		buscarElementos();
	}

	/**
	 * Método de busca dos elementos iniciais da tela
	 */
	@Override
	protected void buscarElementos() {
		if (!contemAbaProdutos()) {
			LOG.mensagemGeral("Página lista produto não carregada");
		}else {
			btn_sair = elementoPresente(btn_idsair_localizador);
			LOG.mensagemGeral("Elementos iniciais instanciados");
		}
	}

	/**
	 * Método que verifica se a aba produtos esta presente
	 * @return verdadeiro se aba presente
	 */
	public boolean contemAbaProdutos() {
		LOG.mensagemGeral("Verificando se Aba produtos esta presente");
		
		aba_produtos = elementoPresente(aba_idrotulos_localizador);
		
		return (aba_produtos != null);
	}

	/**
	 * Método que verifica se a aba produtos esta ativa
	 * @return verdadeiro se aba produtos esta ativa
	 */
	public boolean abaProdutosAtiva() {
		LOG.mensagemGeral("Verificando se Aba produtos esta selecionada");
		
		return aba_produtos.isSelected();
		
	}

	/**
	 * Método que clica no notão sair
	 * @return
	 */
	public LoginPageObject clicarBotaoSair() {
		btn_sair.click();
		return new LoginPageObject();
	}

}
