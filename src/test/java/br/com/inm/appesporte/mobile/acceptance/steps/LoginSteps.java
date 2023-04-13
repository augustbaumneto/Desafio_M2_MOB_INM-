package br.com.inm.appesporte.mobile.acceptance.steps;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;

import br.com.inm.appesporte.mobile.acceptance.logics.CadastroLogics;
import br.com.inm.appesporte.mobile.acceptance.logics.ListaProdutosLogics;
import br.com.inm.appesporte.mobile.acceptance.logics.LoginLogics;
import br.com.inm.appesporte.mobile.config.Log;
import br.com.inm.appesporte.mobile.massa.GeradorMassa;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

/**
 * 
 * Classe step para a funcionalidade de login
 * 
 * @author August Neto
 *
 */
public class LoginSteps {

	private Log log = new Log();
	private GeradorMassa massa = new GeradorMassa();
	
    private LoginLogics loginlogics;
    private CadastroLogics cadastrologics;
    private ListaProdutosLogics listaprodutologics;
    
	private String usuario;
	private String senha;
    
	@BeforeEach
	public void inicioTeste() {
		log.mensagemgeral("---------------------Iniciando novo teste----------------------");
	}
    
    @Dado("que eu estou na tela de login")
    public void queEuEstouNaTelaDeLogin() {
    	loginlogics = new LoginLogics();
    	loginlogics.abrirPaginaDeLogin();
    	log.mensagemgeral("Step Dado que eu estou na tela de login realizado com sucesso");
    }

    @E("tenha um usuário já cadastrado")
    public void tenhaUmUsuarioJaCadastrado() {
        usuario = massa.geraPrimeiroNome();
        senha = massa.geraSenha();
        cadastrologics =loginlogics.acessaCadastro();
        loginlogics = cadastrologics.cadastraUsuario(usuario,senha);
        assertTrue(loginlogics.estaPaginaLogin(),"Erro: Não é a página de login");
        log.mensagemgeral("Step tenha um usuário já cadastro realizado com sucesso");
    }

    @Quando("eu tento realizar o login com usuário {string} e com senha {string}")
    public void euTentoRealizaroLogincomUsuárioeSenha(String condicaousuario, String condicaosenha) {
        String usuariologin;
        String senhalogin;
        
    	switch (condicaousuario) {
    		case "válido":
    			usuariologin = usuario;
    			break;
    		case "inválido":
    			usuariologin = massa.geraPrimeiroNome();
    			break;
    		case "vazio":
    			usuariologin ="";
    			break;
    		default:{
    			log.erroParametroNaoValido("usuario", condicaousuario);
    			assertTrue(false);
    			usuariologin="";
    		}
    	}
    	switch (condicaosenha) {
			case "válido":
				senhalogin = senha;
				break;
			case "inválido":
				senhalogin = massa.geraSenha();
				break;
			case "vazio":
				senhalogin="";
				break;
			default:{
				log.erroParametroNaoValido("senha", condicaosenha);
				assertTrue(false);
				senhalogin="";
			}
    	}
    	
    	listaprodutologics=loginlogics.realizarLoginComUsuarioESenha(usuariologin, senhalogin);
        log.mensagemgeral("Step eu preencho o campo com um usuário: "+condicaousuario+" e senha: "+condicaosenha+" realizado com sucesso");
    }

    @Entao("eu vejo uma mensagem de erro informando que o usuário ou senha estão incorretos")
    public void euVejoUmaMensagemDeErroInformandoQueOUsuarioOuSenhaEstaoIncorretos() {
        assertTrue(loginlogics.verificarMensagemDeErro());
        log.mensagemgeral("Step eu vejo mensagem de erro com usuário ou senha incorretos realizado com sucesso");
    }
    
    @Entao("é efetuado o login redirecionando para a tela lista de produtos")
    public void eEfetuadoLoginRedirecionandoParaTelaListaProdutos() {
    	assertTrue(listaprodutologics.ePaginaListaProdutos());
    	log.mensagemgeral("Step é efetuado o login redirecionando para a tela lista de produtos realizado com sucesso");
    	listaprodutologics.sair();
    }


}
