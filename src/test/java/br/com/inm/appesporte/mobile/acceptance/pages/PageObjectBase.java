package br.com.inm.appesporte.mobile.acceptance.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import br.com.inm.appesporte.mobile.config.Log;
import io.appium.java_client.AppiumDriver;

public abstract class PageObjectBase {

	protected Log log = new Log();
	
	protected final AppiumDriver driver;
	
	private WebDriverWait espera;
	
	protected PageObjectBase(AppiumDriver driver) {
		this.driver = driver;
		espera = new WebDriverWait(driver,Duration.ofSeconds(2));
	}

	public abstract void buscarElementos();
	
	protected WebElement elementoPresente(By localizador) {
		
		try {
			WebElement elemento = espera.until(ExpectedConditions.presenceOfElementLocated(localizador));
			log.mensagemElementoEncontrado(elemento);
			return elemento;
		} catch (TimeoutException e) {
			log.erroExcecaoLancada(e);
			return null;
		}
		
	}
}
