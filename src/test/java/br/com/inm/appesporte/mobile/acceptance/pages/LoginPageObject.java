package br.com.inm.appesporte.mobile.acceptance.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import io.appium.java_client.AppiumDriver;

public class LoginPageObject extends PageObjectBase{
	
	private WebElement botaocadastro;
	private WebElement botao_login;

	private final By bt_cadastro_localizador;
	private final By bt_login_localizador;
	
	
	public LoginPageObject(AppiumDriver driver) {
		super(driver);
		bt_cadastro_localizador = By.id("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
		bt_login_localizador = By.id("br.com.alura.aluraesporte:id/login_botao_logar");
	}

	@Override
	public void buscarElementos() {
		botaocadastro = driver.findElement(bt_cadastro_localizador);
		botao_login = driver.findElement(bt_login_localizador); 
	}
	 
	public CadastroPageObject clicarCadastrar() {
		botaocadastro.click();
		return new CadastroPageObject(driver);
	}
	

	public boolean estaTelaLogin() {
		
		logger.info("Verificando se esta na tela de login");
		
		botao_login = elementoPresente(bt_login_localizador);
		
		return (botao_login != null);
		
	}
	
}
