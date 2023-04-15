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

	/**
	 * Método que preenche um campo em especifico
	 * 
	 * @param campo o campo a ser preenchido
	 * @param valor o valor a ser preenchido
	 */
	public void preencheCampo(String campo, String valor) {
		log.mensagemgeral("Preenchendo "+ campo+ " com valor: "+valor);
		switch (campo) {
			case "senha":
				cadastropage.preencherSenha(valor);
				break;
			case "confirmarsenha":
				cadastropage.preencherConfirmarSenha(valor);
				break;
			default :
				log.erroParametroNaoValido("campo", campo);
				break;
		}
		
	}

	/**
	 * Método para clicar em visualizar a senha
	 * 
	 * @param campo, do qual o botão será pressionado
	 */
	public void clicarBotaoVisualizarSenha(String campo) {
		log.mensagemgeral("Clicando no botão de visualizar do campo "+ campo);
		switch (campo) {
			case "senha":
				cadastropage.clicarBotaoVisualizarSenha();
				break;
			case "confirmarsenha":
				cadastropage.clicarBotaoVisualizarConfirmarSenha();
				break;
			default :
				log.erroParametroNaoValido("campo", campo);
				break;
		}
		
	}

	/**
	 * Método para verificar a esta legível
	 * 
	 * @param campo Campo que será verificado
	 * @return verdardeiro se o campo estiver visível
	 */
	public boolean validarSenhaEmFormatoLegivel(String campo) {
		log.mensagemgeral("Checando visualização do campo "+ campo);
		switch (campo) {
			case "senha":
				return (cadastropage.senhaVisivel() && cadastropage.botaoVisualizarSenhaEstaDesmarcado());
				
			case "confirmarsenha":
				return (cadastropage.confirmarSenhaVisivel() && cadastropage.botaoVisualizarConfirmarSenhaEstaDesmarcado());
				
			default :
				log.erroParametroNaoValido("campo", campo);
				break;
		}
		return false;
	}

	/**
	 * Método que verifica se a mensagem de erro de usuário existente é exibida
	 * 
	 * @return True se a mensagem é exibida corretamente
	 */
	public boolean validarMensagemDeErroUsuarioExistente() {
		log.mensagemgeral("Verificando mensagem de erro usuário existente");
		
		return cadastropage.verificaMensagemErroUsuarioExistente();
	}

	
}

