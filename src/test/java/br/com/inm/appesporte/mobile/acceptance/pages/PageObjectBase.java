package br.com.inm.appesporte.mobile.acceptance.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.inm.appesporte.mobile.utils.Log;
import io.appium.java_client.AppiumDriver;

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
	
	//Elemento para configurar o tempo de espera
	private WebDriverWait espera;
	
	private final int TEMPO_ESPERAELEMENTO_SEG = 2;
	
	/**
	 * Construtor padrão
	 */
	protected PageObjectBase() {
	
		this.driver = AppiumDriverFactory.Instance().getAppiumDriver();
		espera = new WebDriverWait(driver,Duration.ofSeconds(TEMPO_ESPERAELEMENTO_SEG));
		
	}

	/**
	 * Método de busca padrão de elementos
	 */
	protected abstract void buscarElementos();
	
	/**
	 * Método padrão de verificar se o elemento esta presente 
	 * 
	 * @param localizador do elemento
	 * @return Retorna o elemento se tiver presente, senão retorna null
	 */
	protected WebElement elementoPresente(By localizador) {
		
		try {
			WebElement elemento = espera.until(ExpectedConditions.presenceOfElementLocated(localizador));
			LOG.mensagemElementoEncontrado(elemento);
			return elemento;
		} catch (TimeoutException e) {
			LOG.erroExcecaoLancada(e);
			return null;
		}
		
	}
	
	/**
	 * Retorna uma tela
	 */
	public void voltar() {
		driver.navigate().back();
	}
}
