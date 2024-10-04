package br.com.inm.appesporte.mobile.acceptance.pages;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
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
		} catch (NoSuchElementException | StaleElementReferenceException e) {
			LOG.erroExcecaoLancada(e);
			return false;
		}
		
	}
	
	protected void swipeTo(double ySize, String direction) throws InterruptedException {
		Dimension dimension = driver.manage().window().getSize();

		int x = dimension.width / 2;
		int y = (int) (dimension.height * ySize);
		int end = direction.equals("down") ? 0 : dimension.height - 50;

		
	     PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
	        Sequence sequenciamovimentos = new Sequence(finger, 1);
	        sequenciamovimentos.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x, y));
	        sequenciamovimentos.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg())); 
	        sequenciamovimentos.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), x, end));
	        sequenciamovimentos.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg())); 
	        driver.perform(Arrays.asList(sequenciamovimentos));

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
