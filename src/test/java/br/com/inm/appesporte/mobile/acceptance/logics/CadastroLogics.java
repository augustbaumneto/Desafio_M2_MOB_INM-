package br.com.inm.appesporte.mobile.acceptance.logics;

import br.com.inm.appesporte.mobile.acceptance.pages.CadastroPageObject;
import br.com.inm.appesporte.mobile.acceptance.pages.LoginPageObject;
import br.com.inm.appesporte.mobile.config.Log;


/**
 * Classe Logics da página de Cadastro
 * 
 * @author August Neto
 *
 */
public class CadastroLogics {

	private CadastroPageObject cadastropage;
	private LoginPageObject loginpage;
	
	private static Log log = new Log();
	
	/**
	 * Constutor padrão da classe Logics
	 * 
	 * @param cadastropage página de cadastro inicial para a página.
	 */
	public CadastroLogics(CadastroPageObject cadastropage) {
		this.cadastropage = cadastropage;
		log.mensagemgeral("Classe CadastroLogics criada.");
	}
	
	/**
	 * Método que efetua um cadastro
	 * 
	 * @param usuario
	 * @param senha
	 * @return classe logics da qual terá os novos passos.
	 */
	public LoginLogics cadastraUsuario(String usuario, String senha) {
		log.mensagemgeral("Tentativa de cadastro com usuario: "+usuario+" e senha: "+senha);

		LoginLogics loginlogics = cadastraUsuario(usuario,senha,senha);
		
		return loginlogics;
	}

	/**
	 * Método que efetua um cadastro passando a senha de confirmação
	 * 
	 * @param usuario
	 * @param senha
	 * @param confirmarsenha
	 * @return objeto da classe logics da qual terá os novos passos.
	 */
	public LoginLogics cadastraUsuario(String usuario, String senha, String confirmarsenha) {
		log.mensagemgeral("Tentativa de cadastro com usuario: "+usuario+", senha: "+senha+" e confirmar senha: "+ confirmarsenha);
		cadastropage.preencherUsuario(usuario);
		cadastropage.preencherSenha(senha);
		cadastropage.preencherConfirmarSenha(confirmarsenha);
		
		loginpage = cadastropage.clicarCadastro();
		
		return new LoginLogics(loginpage);
	}	
    
/*	
	public void acessarTelaLogin() {
		cadastropage.clicarBotaoLogin();
	}


	public boolean isMensagemErroCadastroExibida(String mensagemErro) {
		return cadastropage.isMensagemErroExibida(mensagemErro);
	}
*/

	/**
	 * Verifica se esta na tela de cadastro
	 * 
	 * @return verdadeiro se estiver na tela de cadastro
	 */
	public boolean estaNaTelaCadastro() {
		log.mensagemgeral("Verificando se esta na página de cadastro");
		return cadastropage.contemCampoConfirmarSenha();
	}

	/**
	 * Verifica se mensagem de erro senha não confere é exibida
	 * @return retorna verdadeiro se for exibida
	 */
	public boolean validarMensagemDeErroSenhaNaoConferem() {
		log.mensagemgeral("Verificando mensagem de erro de senha não iguais");
		
		return cadastropage.verificaMensagemErroSenhaDiferente();
	}

	/**
	 * Método que retorna para a tela de login
	 */
	public void retornaLogin() {
		log.mensagemgeral("Retorna para a tela de login");
		cadastropage.voltarLogin();
	}

}

