package br.com.inm.appesporte.mobile.acceptance.pages;

import java.time.Duration;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import br.com.inm.appesporte.mobile.utils.Log;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/**
 * 
 * Classe base para os pageObjects
 * 
 * @author August Neto
 *
 */
public abstract class PageObjectBase {

	//Log das page objects
	protected final static Log LOG = new Log();
	
	protected final AppiumDriver driver;
		
	private final long TEMPO_ESPERAELEMENTO_SEG = 2;
	
	/**
	 * Construtor padrão
	 */
	protected PageObjectBase() {
	
		this.driver = AppiumDriverFactory.Instance().getAppiumDriver();
		PageFactory.initElements(new AppiumFieldDecorator(this.driver,Duration.ofSeconds(TEMPO_ESPERAELEMENTO_SEG)),this);
		LOG.mensagemGeral("Página carregada com sucesso!");
	}


	/**
	 * Método padrão de verificar se o elemento esta presente 
	 * 
	 * @param localizador do elemento
	 * @return Retorna o elemento se tiver presente, senão retorna null
	 */
	protected boolean elementoPresente(WebElement elemento) {
		
		try {
			elemento.isDisplayed();
			LOG.mensagemElementoEncontrado(elemento);
			return true;
		} catch (NoSuchElementException e) {
			LOG.erroExcecaoLancada(e);
			return false;
		}
		
	}
	
	/**
	 * Retorna uma tela
	 */
	public void voltar() {
		driver.navigate().back();
		//AndroidDriver a = (AndroidDriver)driver;
		//a.activateApp("1");
		//a.terminateApp("1");
	}

	
}
