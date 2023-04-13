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
		cadastropage.preencherUsuario(usuario);
		cadastropage.preencherSenha(senha);
		cadastropage.preencherConfirmarSenha(senha);
		
		loginpage = cadastropage.clicarCadastro();
		
		return new LoginLogics(loginpage);
	}

}
