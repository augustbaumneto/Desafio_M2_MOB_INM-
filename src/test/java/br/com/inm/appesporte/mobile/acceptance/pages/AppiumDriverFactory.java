package br.com.inm.appesporte.mobile.acceptance.pages;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import br.com.inm.appesporte.mobile.config.ParametrosConfig;
import br.com.inm.appesporte.mobile.utils.Log;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

/**
 * 
 *  Classe que inicializa a instância do Aplicativo 
 * 
 * @author August Neto
 *
 */

public class AppiumDriverFactory {

	private final AppiumDriver driver;
	
	private static AppiumDriverFactory _instance;
	
	private Log log = new Log();
	
	/**
	 * Método que chama o construtor e retorna o DriverFActory instanciado
	 * 
	 *  @return
	 */
	
	public static AppiumDriverFactory Instance() {
		//Só entra no if a variável ainda não foi inicializada
		if (AppiumDriverFactory._instance==null) {
			AppiumDriverFactory._instance = new AppiumDriverFactory();
		}
		
		return AppiumDriverFactory._instance;
	}
	
	
	/**
	 * 
	 * Construtor que inicializa o driver
	 * 
	 * @return o Driver do tipo escolhido
	 */
	private AppiumDriverFactory()  {
		File apk = new File(ParametrosConfig.getCaminhoCompleto());
	    	
	    DesiredCapabilities configuracoes = new DesiredCapabilities();
	    	
	    configuracoes.setCapability(MobileCapabilityType.APP,apk.getAbsolutePath());
	    configuracoes.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
	    configuracoes.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
	    
	    URL urlconexao = null;
	    //Verifica a exception da URL
	    try {
	    	urlconexao = new URL(ParametrosConfig.getUrlappium()+"/wd/hub");
	    	
	    } catch (MalformedURLException e) {
	    	e.printStackTrace();
	    	
	    	log.erroExcecaoLancada(e);
	    }
	    	driver = new AppiumDriver(urlconexao, configuracoes);
	    	
	    	log.mensagemGeral("Driver inicializado com sucesso! URL Appium: "+urlconexao+", Aplicativo: "+apk.getAbsolutePath());
	}

	/**
	 * Método que retorna o driver instanciado
	 * 
	 * @return driver instanciado.
	 */
	public AppiumDriver getAppiumDriver() {
		return this.driver;
	}
}
