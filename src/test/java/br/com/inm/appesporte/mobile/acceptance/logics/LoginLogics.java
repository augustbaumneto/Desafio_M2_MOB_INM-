package br.com.inm.appesporte.mobile.acceptance.logics;

import br.com.inm.appesporte.mobile.acceptance.pages.CadastroPageObject;
import br.com.inm.appesporte.mobile.acceptance.pages.LoginPageObject;
import br.com.inm.appesporte.mobile.config.Log;

/**
 * 
 * Classe Logic do login
 * 
 * @author August Neto
 *
 */
public class LoginLogics {

	
	private LoginPageObject loginPage;
	private CadastroPageObject cadastropage;
	
	
	private static Log log = new Log();
	
	/**
	 * Verifica se esta na página de login e inicializa a página.
	 * 
	 */
	public void abrirPaginaDeLogin() {
		log.mensagemgeral("Acessando tela de login");
		loginPage = new LoginPageObject(); 
		loginPage.buscarElementos();
		estaPaginaLogin();
	} //TODO resolver problema do driver

	/**
	 *   Realiza o login com o usuario e senha fornecidos
	 * 
	 * @param usuario
	 * @param senha
	 */
	public void realizarLoginComUsuarioESenha(String usuario, String senha) {
		log.mensagemgeral("Enviado usuario "+usuario+" e "+senha+" para tentar efetuar login");
		loginPage.preencherUsuario(usuario);
        loginPage.preencherSenha(senha);
        loginPage.clicarNoBotaoLogin();
	}

	/**
	 * Verifica se é apresentado a mensagem de erro informada
	 * 
	 * @param string: mensagem que deve ser exibida
	 * @return True se a mensagem for apresentad
	 */
	public boolean verificarMensagemDeErro(String mensagem) {
		log.mensagemgeral("Verificando mensagem de erro no login");
		return loginPage.verificarMensagemDeErro(mensagem);
	}

	/**
	 * Acessa a tela de cadastro
	 * 
	 * @return a classe Logics de cadastro
	 */
	public CadastroLogics acessaCadastro() {
		log.mensagemgeral("Acessando tela de cadastro");
		cadastropage = loginPage.clicarCadastrar();
		return new CadastroLogics(cadastropage);
	}

	/**
	 * Retorna verdadeiro se estiver na página de login
	 * 
	 * @return
	 */
	public boolean estaPaginaLogin() {
		log.mensagemgeral("Verificando se esta na página de login");
		return loginPage.contemBotaoLogin();
	}

}
