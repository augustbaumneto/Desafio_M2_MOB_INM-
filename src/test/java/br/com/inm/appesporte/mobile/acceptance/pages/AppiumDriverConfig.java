package br.com.inm.appesporte.mobile.acceptance.pages;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import br.com.inm.appesporte.mobile.config.ParametrosConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;



public class AppiumDriverConfig {

	public final AppiumDriver driver;
	
	private static AppiumDriverConfig _instance;
	
	//Método que chama o construtor
	public static AppiumDriverConfig Instance() {
		//Só entra no if a variável ainda não foi inicializada
		if (AppiumDriverConfig._instance==null) {
			AppiumDriverConfig._instance = new AppiumDriverConfig();
		}
		
		return AppiumDriverConfig._instance;
	}
	
	private AppiumDriverConfig()  {
		File apk = new File("C:\\B\\Auto\\Projetos_de_automacao\\treina_Alura_Appium\\AluraAppium\\src\\main\\resources\\"+ParametrosConfig.getNomeapp());
	    	
	    DesiredCapabilities configuracoes = new DesiredCapabilities();
	    	
	    configuracoes.setCapability(MobileCapabilityType.APP,apk.getAbsolutePath());
	    configuracoes.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
	    configuracoes.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
	    
	    URL urlConexao = null;
	    //Verifica a exception da URL
	    try {
	    	urlConexao = new URL(ParametrosConfig.getUrlappium()+"/wd/hub");
	    	
	    } catch (MalformedURLException e) {
	    	e.printStackTrace();
	    }
	    	driver = new AppiumDriver(urlConexao, configuracoes);
	}

}
