package br.com.inm.appesporte.mobile.acceptance.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;

import io.appium.java_client.pagefactory.AndroidFindBy;


/**
 * Classe PageObject da tela Login
 * 
 * @author August Neto
 *
 */
public class LoginPageObject extends PageObjectBase{
	
	@CacheLookup
	@AndroidFindBy(id = "br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario")
	private WebElement botao_cadastro;
	
	@CacheLookup
	@AndroidFindBy(id = "br.com.alura.aluraesporte:id/login_botao_logar")
	private WebElement botao_login;
	
	@CacheLookup
	@AndroidFindBy(id = "br.com.alura.aluraesporte:id/input_usuario")
	private WebElement campo_idusuario;
	
	@CacheLookup
	@AndroidFindBy(id = "br.com.alura.aluraesporte:id/input_senha")
	private WebElement campo_senha;
	
	@AndroidFindBy(id = "br.com.alura.aluraesporte:id/mensagem_erro_login")
	private WebElement msg_errousuariosenhainvalido;

		
	private final String MSG_ERROLOGININVALIDA = "Usuário ou senha inválidos";
	
	/**
	 * Construtor Padrão
	 * 
	 * 
	 */
	public LoginPageObject() {
		super();
		if (!contemBotaoLogin()) {
			LOG.mensagemGeral("Página Login não carregada");
		}else {
			
			LOG.mensagemGeral("Elementos iniciais instanciados");
		}
	}
	 
	/**
	 * Método que clica no botão cadastrar
	 * 
	 * @return a página de cadastro
	 */
	public CadastroPageObject clicarCadastrar() {
		botao_cadastro.click();
		return new CadastroPageObject();
	}
	
	/**
	 * Método que verificar se o botão login esta na página
	 * @return verdadeiro se o o botão esta presente.
	 */
	public boolean contemBotaoLogin() {
		
		LOG.mensagemGeral("Verificando se apresenta o botão de login");
		
		return (elementoPresente(botao_login));
		
	}

	/**
	 * Método que preenche o usuário
	 * 
	 * @param usuario, login do usuário
	 */
	public void preencherUsuario(String usuario) {
		campo_idusuario.sendKeys(usuario);		
	}

	/**
	 * Método que preenche a senha
	 * 
	 * @param usuario, senha do usuário
	 */
	public void preencherSenha(String senha) {
		campo_senha.sendKeys(senha);
		
	}
	
	/**
	 * Método que clica no botão login
	 * 
	 * @retorna a página de lista de produtos
	 */
	public ListaProdutoPageObject clicarNoBotaoLogin() {
		botao_login.click();
		return new ListaProdutoPageObject();
	}


	/**
	 * Método que verifica se a mensagem de erro esta correta.
	 * 
	 * @return true se a mensagem for a esperada
	 */
	public boolean verificarMensagemDeErro() {
		LOG.mensagemGeral("Mensagem esperada: "+MSG_ERROLOGININVALIDA);
		
		if (!elementoPresente(msg_errousuariosenhainvalido))
			return false;
		String mensagemnatela = msg_errousuariosenhainvalido.getText();
		LOG.mensagemGeral("Mensagem obtida na tela: "+mensagemnatela);
		return (mensagemnatela.equals(MSG_ERROLOGININVALIDA));
	}
	
}
