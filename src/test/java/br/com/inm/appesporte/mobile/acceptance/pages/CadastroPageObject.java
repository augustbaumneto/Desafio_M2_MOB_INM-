package br.com.inm.appesporte.mobile.acceptance.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



public class CadastroPageObject extends PageObjectBase{

	private WebElement campo_nome;
	private WebElement campo_senha;
	private WebElement campo_confirmarsenha;
	private WebElement botao_cadastrar;
	private WebElement msg_erro_cadastro_senha;
	
	private final By cmp_nome_localizador;
	private final By cmp_senha_localizador;
	private final By cmp_confirmarsenha_localizador;
	private final By bt_cadastrar_localizador;
	private final By msg_errocadastro_localizador;
	
	/**
	 * Construtor padrão
	 */
	public CadastroPageObject() {
		super();
		cmp_nome_localizador=By.id("br.com.alura.aluraesporte:id/input_nome");
		cmp_senha_localizador=By.id("br.com.alura.aluraesporte:id/input_senha");
		cmp_confirmarsenha_localizador=By.id("br.com.alura.aluraesporte:id/input_confirmar_senha");
		bt_cadastrar_localizador=By.id("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");
		msg_errocadastro_localizador=By.id("br.com.alura.aluraesporte:id/erro_cadastro");
		LOG.mensagemgeral("Página de Cadastro instanciada");
		buscarElementos();
		
	}
	
	/**
	 * Método de busca dos elementos iniciais da tela
	 */
	@Override
	protected void buscarElementos() {
		campo_confirmarsenha = elementoPresente(cmp_confirmarsenha_localizador);
		if (campo_confirmarsenha==null) {
			LOG.mensagemgeral("Página Cadastro não carregada");
		}else {
			campo_nome = elementoPresente(cmp_nome_localizador);
	    	campo_senha = elementoPresente(cmp_senha_localizador);
	    	botao_cadastrar = elementoPresente(bt_cadastrar_localizador);
			LOG.mensagemgeral("Elementos iniciais instanciados");
		}
		
    	
	}

	/**
	 * Preencher campo usuário
	 * @param usuario
	 */
	public void preencherUsuario(String usuario) {
		campo_nome.sendKeys(usuario);

	}

	/**
	 * Preencher campo senha
	 * @param senha
	 */
	public void preencherSenha(String senha) {
    	campo_senha.sendKeys(senha);
	}

	/**
	 * Preencher campo confirmar senha
	 * @param confirmasenha
	 */
	public void preencherConfirmarSenha(String confirmasenha) {
    	campo_confirmarsenha.sendKeys(confirmasenha);
	}	
	
	/**
	 * Método que clica no botão cadastrar
	 * @return a nova pageobject
	 */
	public LoginPageObject clicarCadastro() {
		botao_cadastrar.click();
		return new LoginPageObject();
	}
	
	/**
	 * Método que verifica a mensagem de erro informada ao tentar fazer um cadastro incorreto
	 * 
	 * @return
	 */
	public String verificaMensagemErro() {
		
		String retorno = "";
		
		LOG.mensagemgeral("Verificando mensagem de erro");
		msg_erro_cadastro_senha = elementoPresente(msg_errocadastro_localizador);
		
		if (msg_erro_cadastro_senha!=null)
			retorno = msg_erro_cadastro_senha.getText();
		return retorno;
	}
	
	/**
	 * Método que retorna para a tela de login
	 */
	public void voltarLogin() {
		driver.navigate().back();
	}
	
}
