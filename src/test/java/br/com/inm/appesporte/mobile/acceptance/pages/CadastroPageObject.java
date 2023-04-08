package br.com.inm.appesporte.mobile.acceptance.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



public class CadastroPageObject extends PageObjectBase{

	private WebElement campo_nome;
	private WebElement campo_senha;
	private WebElement campo_confirmarsenha;
	private WebElement botao_cadastrar;
	private WebElement msg_erro_cadastro_senha;
	
	private final By cmp_nome_localizador;
	private final By cmp_senha_localizador;
	private final By cmp_confirmarsenha_localizador;
	private final By bt_cadastrar_localizador;
	private final By msg_errocadastro_localizador;
	
	public CadastroPageObject() {
		super();
		cmp_nome_localizador=By.id("br.com.alura.aluraesporte:id/input_nome");
		cmp_senha_localizador=By.id("br.com.alura.aluraesporte:id/input_senha");
		cmp_confirmarsenha_localizador=By.id("br.com.alura.aluraesporte:id/input_confirmar_senha");
		bt_cadastrar_localizador=By.id("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");
		msg_errocadastro_localizador=By.id("br.com.alura.aluraesporte:id/erro_cadastro");
	}
	
	@Override
	public void buscarElementos() {
    	campo_nome = driver.findElement(cmp_nome_localizador);
    	campo_senha = driver.findElement(cmp_senha_localizador);
    	campo_confirmarsenha = driver.findElement(cmp_confirmarsenha_localizador);
    	botao_cadastrar = driver.findElement(bt_cadastrar_localizador);
	}

	private void preencherElementos(String usuario, String senha, String confirmasenha) {
		campo_nome.sendKeys(usuario);
    	campo_senha.sendKeys(senha);
    	campo_confirmarsenha.sendKeys(confirmasenha);
	}

	private void clicarCadastro() {
		botao_cadastrar.click();
	}
	
	public LoginPageObject cadastrar(String usuario, String senha, String confirmasenha) {
		preencherElementos(usuario, senha, confirmasenha);
		clicarCadastro();
		return new LoginPageObject();
	}

	public String verificaMensagemErro() {
		
		String retorno = "";
		
		LOG.mensagemgeral("Verificando mensagem de erro");
		msg_erro_cadastro_senha = elementoPresente(msg_errocadastro_localizador);
		
		if (msg_erro_cadastro_senha!=null)
			retorno = msg_erro_cadastro_senha.getText();
		return retorno;
	}
	
	
	public void voltarLogin() {
		driver.navigate().back();
	}
	
}
