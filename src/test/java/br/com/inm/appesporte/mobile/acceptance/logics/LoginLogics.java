package br.com.inm.appesporte.mobile.acceptance.logics;

import br.com.inm.appesporte.mobile.acceptance.pages.CadastroPageObject;
import br.com.inm.appesporte.mobile.acceptance.pages.ListaProdutoPageObject;
import br.com.inm.appesporte.mobile.acceptance.pages.LoginPageObject;
import br.com.inm.appesporte.mobile.utils.Log;

/**
 * 
 * Classe Logic do login
 * 
 * @author August Neto
 *
 */
public class LoginLogics extends LogicsBase {

	
	private CadastroPageObject cadastropage;
	private ListaProdutoPageObject listaprodutopage;
	
	
	private static Log log = new Log();
	
	/**
	 * Construtor que mantem o controle de página
	 * 
	 * @param loginpage
	 */
	public LoginLogics(LoginPageObject loginpage) {
		this();
		this.loginpage = loginpage;
	}
	
	/**
	 * Construtor padrão
	 */
	public LoginLogics() {
		loginpage = new LoginPageObject();
		
	}
	
	
	/**
	 * Verifica se esta na página de login.
	 * 
	 */
	public void abrirPaginaDeLogin() {
		log.mensagemGeral("Acessando tela de login");
		estaPaginaLogin();
	}

	/**
	 *   Realiza o login com o usuario e senha fornecidos
	 * 
	 * @param usuario
	 * @param senha
	 * @return o objeto que a classe logic da tela de lista de produtos
	 */
	public ListaProdutosLogics realizarLoginComUsuarioESenha(String usuario, String senha) {
		log.mensagemGeral("Tentativa de login com usuário: "+usuario+" e senha: "+senha);
		loginpage.preencherUsuario(usuario);
        loginpage.preencherSenha(senha);
        listaprodutopage = loginpage.clicarNoBotaoLogin();
        return new ListaProdutosLogics(listaprodutopage);
	}

	/**
	 * Verifica se é apresentado a mensagem de erro informada
	 * 
	 * @return True se a mensagem for apresentad
	 */
	public boolean verificarMensagemDeErro() {
		log.mensagemGeral("Verificando mensagem de erro no login");
		
		return loginpage.verificarMensagemDeErro();
		
	}

	/**
	 * Acessa a tela de cadastro
	 * 
	 * @return a classe Logics de cadastro
	 */
	public CadastroLogics acessaCadastro() {
		log.mensagemGeral("Acessando tela de cadastro");
		cadastropage = loginpage.clicarCadastrar();
		return new CadastroLogics(cadastropage);
	}

	/**
	 * Verifica se esta na pagina de login
	 * 
	 * @return Retorna verdadeiro se estiver na página de login
	 */
	public boolean estaPaginaLogin() {
		log.mensagemGeral("Verificando se esta na página de login");
		return loginpage.contemBotaoLogin();
	}

	
}
