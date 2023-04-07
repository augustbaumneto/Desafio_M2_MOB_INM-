package br.com.inm.appesporte.mobile.acceptance.steps;

import static org.junit.jupiter.api.Assertions.assertTrue;

import br.com.inm.appesporte.mobile.acceptance.logics.CadastroLogics;
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
	
    private LoginLogics loginLogics;
    private CadastroLogics cadastroLogics;
    
	private String usuario;
	private String senha;
    
    
    @Dado("que eu estou na tela de login")
    public void queEuEstouNaTelaDeLogin() {
    	loginLogics = new LoginLogics();
    	loginLogics.abrirPaginaDeLogin();
    	log.mensagemgeral("Step Dado que eu estou na tela de login realizado com sucesso");
    }

    @E("tenha um usuário já cadastrado")
    public void tenhaUmUsuarioJaCadastrado() {
        usuario = massa.geraPrimeiroNome();
        senha = massa.geraSenha();
        cadastroLogics =loginLogics.acessaCadastro();
        loginLogics = cadastroLogics.cadastraUsuario(usuario,senha);
        assertTrue(loginLogics.estaPaginaLogin());
        log.mensagemgeral("Step tenha um usuário já cadastro realizado com sucesso");
    }

    @Quando("eu tento realizar o login com usuário inválido e senha inválida")
    public void euTentoRealizaroLogincomUsuárioInválidoeSenhaInválida() {
        loginLogics.realizarLoginComUsuarioESenha(massa.geraPrimeiroNome(), massa.geraSenha());
        log.mensagemgeral("Step eu preencho o campo com um usuário inválido realizado com sucesso");
    }

    @Entao("eu vejo uma mensagem de erro informando que o usuário ou senha estão incorretos")
    public void euVejoUmaMensagemDeErroInformandoQueOUsuarioOuSenhaEstaoIncorretos() {
        assertTrue(loginLogics.verificarMensagemDeErro("Usuário ou senha inválidos."));
        log.mensagemgeral("Step eu vejo mensagem de erro com usuário ou senha incorretos realizado com sucesso");
    }


}
