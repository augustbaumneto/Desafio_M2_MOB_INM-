package br.com.inm.appesporte.mobile.acceptance.pages;

import static br.com.inm.appesporte.mobile.config.Log.getLog;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;

import io.appium.java_client.AppiumDriver;

public abstract class PageObjectBase {

	protected Logger logger = getLog();
	
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
			logger.info("Elemento {} encontrado.",elemento);
			return elemento;
		} catch (TimeoutException e) {
			logger.error("Elemento não encontrado", e);
			return null;
		}
		
	}
}
