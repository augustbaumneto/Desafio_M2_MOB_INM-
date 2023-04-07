package br.com.inm.appesporte.mobile.acceptance.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



public class LoginPageObject extends PageObjectBase{
	
	private WebElement botaocadastro;
	private WebElement botao_login;

	private final By bt_cadastro_localizador;
	private final By bt_login_localizador;
	
	
	public LoginPageObject() {
		super();
		bt_cadastro_localizador = By.id("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
		bt_login_localizador = By.id("br.com.alura.aluraesporte:id/login_botao_logar");
		//buscarElementos();
	}

	@Override
	public void buscarElementos() {
		botaocadastro = driver.findElement(bt_cadastro_localizador);
		botao_login = driver.findElement(bt_login_localizador); 
	}
	 
	public CadastroPageObject clicarCadastrar() {
		botaocadastro.click();
		return new CadastroPageObject();
	}
	

	public boolean contemBotaoLogin() {
		
		LOG.mensagemgeral("Verificando se aprenseta o botão de login");
		
		botao_login = elementoPresente(bt_login_localizador);
		
		return (botao_login != null);
		
	}

	public void preencherUsuario(String usuario) {
		// TODO Auto-generated method stub
		
	}

	public void preencherSenha(String senha) {
		// TODO Auto-generated method stub
		
	}

	public void clicarNoBotaoLogin() {
		// TODO Auto-generated method stub
		
	}

	public boolean verificarMensagemDeErro(String mensagem) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
