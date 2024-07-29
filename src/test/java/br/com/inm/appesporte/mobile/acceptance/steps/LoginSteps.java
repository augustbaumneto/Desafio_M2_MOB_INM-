package br.com.inm.appesporte.mobile.acceptance.steps;

import static org.junit.jupiter.api.Assertions.assertTrue;

import br.com.inm.appesporte.mobile.acceptance.logics.CadastroLogics;
import br.com.inm.appesporte.mobile.acceptance.logics.ListaProdutosLogics;
import br.com.inm.appesporte.mobile.acceptance.logics.LoginLogics;
import br.com.inm.appesporte.mobile.massa.GeradorMassa;
import br.com.inm.appesporte.mobile.resultadoteste.GravadorTeste;
import br.com.inm.appesporte.mobile.utils.Log;

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

	private static Log log = new Log();
	private GeradorMassa massa = new GeradorMassa();
	private static GravadorTeste gravador = GravadorTeste.Instance();
	
    private LoginLogics loginlogics;
    private CadastroLogics cadastrologics;
    private ListaProdutosLogics listaprodutologics;
    
	private String usuario;
	private String senha;
    

    @Dado("que eu estou na tela de login")
    public void queEuEstouNaTelaDeLogin() {
    	loginlogics = new LoginLogics();
    	loginlogics.abrirPaginaDeLogin();
    	log.mensagemGeral("Step Dado que eu estou na tela de login realizado com sucesso");
    }

    @E("tenha um usuário já cadastrado")
    public void tenhaUmUsuarioJaCadastrado() {
        usuario = massa.geraPrimeiroNome();
        senha = massa.geraSenha();
        
        cadastrologics =loginlogics.acessaCadastro();
        loginlogics = cadastrologics.cadastraUsuario(usuario,senha);
        
        assertTrue(loginlogics.estaPaginaLogin(),"Erro: Não é a página de login");
        
        gravador.gravaMassa("Usuário cadastrado", usuario);
        gravador.gravaMassa("Senha do Usuário cadastrado", senha);
        
        log.mensagemGeral("Step tenha um usuário já cadastro realizado com sucesso");
        
    }

    @Quando("eu tento realizar o login com usuário {string} e com senha {string}")
    public void euTentoRealizaroLogincomUsuárioeSenha(String condicaousuario, String condicaosenha) {
        String usuariologin;
        String senhalogin;
        
        GravadorTeste.setEsquema("Usuário "+condicaousuario+" e Senha "+condicaosenha);
    	
        switch (condicaousuario) {
    		case "válido":
    			usuariologin = usuario;
    			break;
    		case "inválido":
    			usuariologin = massa.geraPrimeiroNome();
    			gravador.gravaMassa("Usuário Inválido", usuariologin);
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
				gravador.gravaMassa("Senha Inválida", senhalogin);
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
        log.mensagemGeral("Step eu preencho o campo com um usuário: "+condicaousuario+" e senha: "+condicaosenha+" realizado com sucesso");
        
    }

    @Entao("eu vejo uma mensagem de erro informando que o usuário ou senha estão incorretos")
    public void euVejoUmaMensagemDeErroInformandoQueOUsuarioOuSenhaEstaoIncorretos() {
        assertTrue(loginlogics.verificarMensagemDeErro());
        log.mensagemGeral("Step eu vejo mensagem de erro com usuário ou senha incorretos realizado com sucesso");  
    }
    
    @Entao("é efetuado o login redirecionando para a tela lista de produtos")
    public void eEfetuadoLoginRedirecionandoParaTelaListaProdutos() {
    	assertTrue(listaprodutologics.ePaginaListaProdutos());
    	log.mensagemGeral("Step é efetuado o login redirecionando para a tela lista de produtos realizado com sucesso");
    	listaprodutologics.sair();
    }
    
}
