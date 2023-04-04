package br.com.inm.appesporte.mobile.acceptance.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import io.appium.java_client.AppiumDriver;


public class CadastroPageObject extends PageObjectBase{

	private WebElement camponome;
	private WebElement camposenha;
	private WebElement campoconfirmarsenha;
	private WebElement botao_cadastrar;
	private WebElement msg_erro_cadastro_senha;
	
	private final By cmp_nome_localizador;
	private final By cmp_senha_localizador;
	private final By cmp_confirmarsenha_localizador;
	private final By bt_cadastrar_localizador;
	private final By msg_errocadastro_localizador;
	
	public CadastroPageObject(AppiumDriver driver) {
		super(driver);
		cmp_nome_localizador=By.id("br.com.alura.aluraesporte:id/input_nome");
		cmp_senha_localizador=By.id("br.com.alura.aluraesporte:id/input_senha");
		cmp_confirmarsenha_localizador=By.id("br.com.alura.aluraesporte:id/input_confirmar_senha");
		bt_cadastrar_localizador=By.id("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");
		msg_errocadastro_localizador=By.id("br.com.alura.aluraesporte:id/erro_cadastro");
	}
	
	@Override
	public void buscarElementos() {
    	camponome = driver.findElement(cmp_nome_localizador);
    	camposenha = driver.findElement(cmp_senha_localizador);
    	campoconfirmarsenha = driver.findElement(cmp_confirmarsenha_localizador);
    	botao_cadastrar = driver.findElement(bt_cadastrar_localizador);
	}

	private void preencherElementos(String usuario, String senha, String confirmasenha) {
		camponome.sendKeys(usuario);
    	camposenha.sendKeys(senha);
    	campoconfirmarsenha.sendKeys(confirmasenha);
	}

	private void clicarCadastro() {
		botao_cadastrar.click();
	}
	
	public LoginPageObject Cadastrar(String usuario, String senha, String confirmasenha) {
		preencherElementos(usuario, senha, confirmasenha);
		clicarCadastro();
		return new LoginPageObject(driver);
	}

	public String verificamensagemerro() {
		
		String retorno = "";
		
		logger.info("Verificando mensagem de erro");
		msg_erro_cadastro_senha = elementoPresente(msg_errocadastro_localizador);
		
		if (msg_erro_cadastro_senha!=null)
			retorno = msg_erro_cadastro_senha.getText();
		return retorno;
	}
	
	
	public void voltarLogin() {
		driver.navigate().back();
	}
	
}
