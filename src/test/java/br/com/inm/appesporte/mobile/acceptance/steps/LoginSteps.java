package br.com.inm.appesporte.mobile.acceptance.steps;

import static org.junit.jupiter.api.Assertions.assertTrue;

import br.com.inm.appesporte.mobile.acceptance.logics.LoginLogics;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class LoginSteps {

    private LoginLogics loginLogics;
    public LoginSteps() {
        
        this.loginLogics = new LoginLogics();
    }

    @Dado("que eu estou na tela de login")
    public void queEuEstouNaTelaDeLogin() {
        loginLogics.abrirPaginaDeLogin();
    }

    @E("tenha um usuário já cadastrado")
    public void tenhaUmUsuarioJaCadastrado() {
        assertTrue(loginLogics.verificarSeUsuarioJaCadastrado("usuario_valido"));
    }

    @Quando("eu preencho o campo usuário com um usuário inválido")
    public void euPreenchoOCampoUsuarioComUmUsuarioInvalido() {
        loginLogics.realizarLoginComUsuarioESenha("usuario_invalido", "senha_invalida");
    }

    @Entao("eu vejo uma mensagem de erro informando que o usuário ou senha estão incorretos")
    public void euVejoUmaMensagemDeErroInformandoQueOUsuarioOuSenhaEstaoIncorretos() {
        assertTrue(loginLogics.verificarMensagemDeErro("Usuário ou senha inválidos."));
    }


}
