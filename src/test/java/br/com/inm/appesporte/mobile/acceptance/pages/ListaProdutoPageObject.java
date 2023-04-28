package br.com.inm.appesporte.mobile.acceptance.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;

import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Classe PageObject da tela lista de produtos
 * 
 * @author August Neto
 *
 */
public class ListaProdutoPageObject extends PageObjectBase{

	@CacheLookup
	@AndroidFindBy(id = "br.com.alura.aluraesporte:id/listaProdutos")
	private WebElement aba_produtos;
	
	@CacheLookup
	@AndroidFindBy(id = "br.com.alura.aluraesporte:id/menu_principal_deslogar")
	private WebElement btn_sair;

	
	/**
	 * Construtor Padrão
	 * 
	 * 
	 */
	public ListaProdutoPageObject() {
		super();
		
		if (!contemAbaProdutos()) {
			LOG.mensagemGeral("Página lista produto não carregada");
		}else {
			LOG.mensagemGeral("Elementos iniciais instanciados");
		}
	}


	/**
	 * Método que verifica se a aba produtos esta presente
	 * @return verdadeiro se aba presente
	 */
	public boolean contemAbaProdutos() {
		LOG.mensagemGeral("Verificando se Aba produtos esta presente");
		
		return (elementoPresente(aba_produtos));
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
