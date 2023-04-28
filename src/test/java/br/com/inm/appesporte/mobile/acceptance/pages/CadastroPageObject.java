package br.com.inm.appesporte.mobile.acceptance.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;

import io.appium.java_client.pagefactory.AndroidFindBy;



public class CadastroPageObject extends PageObjectBase{

	@CacheLookup
	@AndroidFindBy(id = "br.com.alura.aluraesporte:id/input_nome")
	private WebElement campo_nome;
	
	@CacheLookup
	@AndroidFindBy(id = "br.com.alura.aluraesporte:id/input_senha")
	private WebElement campo_senha;
	
	@CacheLookup
	@AndroidFindBy(id = "br.com.alura.aluraesporte:id/input_confirmar_senha")
	private WebElement campo_confirmarsenha;
	
	@CacheLookup
	@AndroidFindBy(id = "br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar")
	private WebElement botao_cadastrar;
	
	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='br.com.alura.aluraesporte:id/cadastro_usuario_senha']/android.widget.FrameLayout/android.widget.ImageButton")
	private WebElement botao_visualizar_senha;
	
	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='br.com.alura.aluraesporte:id/cadastro_usuario_confirma_senha']/android.widget.FrameLayout/android.widget.ImageButton")
	private WebElement botao_visualizar_confirmarsenha;
	
	@AndroidFindBy(id = "br.com.alura.aluraesporte:id/erro_cadastro")
	private WebElement msg_erro_cadastro;
	
	
	private final String MSG_ERROSENHADIFERENTE = "Senhas não conferem";
	private final String MSG_ERROUSUARIOEXISTENTE = "Usuario já Cadastrado";
	
	//Atributo para verificar se o botão senha foi pressionado
	private static final String ATR_MARCADO = "checked";
	//Atributo para verificar se é campo senha
	private static final String ATR_PASSWORD = "password";
	
	
	/**
	 * Construtor padrão
	 */
	public CadastroPageObject() {
		super();
		if (!contemCampoConfirmarSenha()) {
			LOG.mensagemGeral("Página Cadastro não carregada");
		}else {
			LOG.mensagemGeral("Elementos iniciais instanciados");
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
	 * Método que verifica a mensagem de erro apresentada na tela é a esperada
	 * 
	 * @return retorna verdeiro se for a mensagem esperada
	 */
	public boolean verificaMensagemErroSenhaDiferente() {
		return verificaMensagemErro(MSG_ERROSENHADIFERENTE);
	}
	
	/**
	 * Método que retorna para a tela de login
	 */
	public void voltarLogin() {
		voltar();
	}

	/**
	 * Verifica se o campo confirmar senha esta presente
	 * @return verdadeiro se o campo confirmar senha esta presente
	 */
	public boolean contemCampoConfirmarSenha() {
		LOG.mensagemGeral("Verificando se apresenta o campo confirmar senha ");
		
		return (elementoPresente(campo_confirmarsenha));
	}

	/**
	 * Método que clica no botão visualizar ao lado do campo senha
	 */
	public void clicarBotaoVisualizarSenha() {
		botao_visualizar_senha.click();
		
	}

	/**
	 * Método que clica no botão visualizar ao lado do campo confirmar senha
	 */
	public void clicarBotaoVisualizarConfirmarSenha() {
		botao_visualizar_confirmarsenha.click();
		
	}

	/**
	 * Verifica se botão visualizar senha foi desmarcado
	 * @return true se o botão foi desmarcado
	 */
	public boolean botaoVisualizarSenhaEstaDesmarcado() {
		LOG.mensagemGeral("Verifica se o botão Visualizar do campo Senha esta com o atibuto checked marcado");
		return (botao_visualizar_senha.getAttribute(ATR_MARCADO)).equals("true");
	}
	
	/**
	 * Verifica se campo senha esta vísivel
	 * @return true se estiver visível
	 */
	public boolean senhaVisivel() {
		LOG.mensagemGeral("Verifica se o campo Senha esta com o atibuto password false");
		return (campo_senha.getAttribute(ATR_PASSWORD)).equals("false");
	}
	
	/**
	 * Verifica se botão visualizar confirmarsenha foi desmarcado
	 * @return true se o botão foi desmarcado
	 */
	public boolean botaoVisualizarConfirmarSenhaEstaDesmarcado() {
		LOG.mensagemGeral("Verifica se o botão Visualizar do campo Confirmar Senha esta com o atibuto checked marcado");
		return (botao_visualizar_confirmarsenha.getAttribute(ATR_MARCADO)).equals("true");
	}
	
	/**
	 * Verifica se campo confirmar senha esta vísivel
	 * @return true se estiver visível
	 */
	public boolean confirmarSenhaVisivel() {
		LOG.mensagemGeral("Verifica se o campo Confirmar Senha esta com o atibuto password false");
		return (campo_confirmarsenha.getAttribute(ATR_PASSWORD)).equals("false");
	}

	/**
	 * Método que verifica se a mensagem de erro exibida é a mensagem de usuário não existente
	 * 
	 * @return Verdadeiro se for
	 */
	public boolean verificaMensagemErroUsuarioExistente() {

		return verificaMensagemErro(MSG_ERROUSUARIOEXISTENTE);
	}

	/**
	 * Metodo para verificar a mensagem passada é a mensagem exibida na tela
	 * 
	 * @param mensagemesperada
	 * @return verdadeiro se as mensagens forem iguais, e falso se não tiver mensagem na tela ou ela for diferente
	 */
	private boolean verificaMensagemErro(String mensagemesperada) {
		LOG.mensagemGeral("Mensagem esperada: "+mensagemesperada);
		//msg_erro_cadastro = elementoPresente(msg_errocadastro_localizador);
		
		if (!elementoPresente(msg_erro_cadastro))
			return false;
		String mensagemnatela = msg_erro_cadastro.getText();
		LOG.mensagemGeral("Mensagem obtida na tela: "+mensagemnatela);
		return (mensagemnatela.equals(mensagemesperada));

	}
}
