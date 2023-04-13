package br.com.inm.appesporte.mobile.acceptance.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


/**
 * Classe PageObject da tela Login
 * 
 * @author August Neto
 *
 */
public class LoginPageObject extends PageObjectBase{
	
	private WebElement botao_cadastro;
	private WebElement botao_login;
	private WebElement campo_idusuario;
	private WebElement campo_senha;
	private WebElement msg_errousuariosenhainvalido;

	private final By cmp_idusuario_localizador;
	private final By cmp_senha_localizador;
	private final By bt_cadastro_localizador;
	private final By bt_login_localizador;
	private final By msg_errousuariosenhainvalido_localizador;
	
	
	private final String MSG_ERROLOGININVALIDA = "Usuário ou senha inválidos";
	
	/**
	 * Construtor Padrão
	 * 
	 * 
	 */
	public LoginPageObject() {
		super();
		bt_cadastro_localizador = By.id("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
		bt_login_localizador = By.id("br.com.alura.aluraesporte:id/login_botao_logar");
		cmp_idusuario_localizador= By.id("br.com.alura.aluraesporte:id/input_usuario");
		cmp_senha_localizador = By.id("br.com.alura.aluraesporte:id/input_senha");
		msg_errousuariosenhainvalido_localizador=By.id("br.com.alura.aluraesporte:id/mensagem_erro_login");
		LOG.mensagemgeral("Página de Login instanciada");
		buscarElementos();
	}

	/**
	 * Método de busca dos elementos iniciais da tela
	 */
	@Override
	protected void buscarElementos() {
		if (!contemBotaoLogin()) {
			LOG.mensagemgeral("Página Login não carregada");
		}else {
			botao_cadastro = elementoPresente(bt_cadastro_localizador);
			campo_idusuario = elementoPresente(cmp_idusuario_localizador);
			campo_senha = elementoPresente(cmp_senha_localizador);
			LOG.mensagemgeral("Elementos iniciais instanciados");
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
		
		LOG.mensagemgeral("Verificando se apresenta o botão de login");
		
		botao_login = elementoPresente(bt_login_localizador);
		
		return (botao_login != null);
		
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
		LOG.mensagemgeral("Mensagem esperada: "+MSG_ERROLOGININVALIDA);
		msg_errousuariosenhainvalido = elementoPresente(msg_errousuariosenhainvalido_localizador);
		
		if (msg_errousuariosenhainvalido==null)
			return false;
		String mensagemnatela = msg_errousuariosenhainvalido.getText();
		LOG.mensagemgeral("Mensagem obtida na tela: "+mensagemnatela);
		return (mensagemnatela.equals(MSG_ERROLOGININVALIDA));
	}
	
}
