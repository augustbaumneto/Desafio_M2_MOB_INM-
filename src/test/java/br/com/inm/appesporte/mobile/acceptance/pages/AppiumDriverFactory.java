package br.com.inm.appesporte.mobile.acceptance.pages;

import java.io.File;
//import java.net.MalformedURLException;
//import java.net.URL;

//import org.openqa.selenium.Capabilities;
//import org.openqa.selenium.WebDriver.Options;
//import org.openqa.selenium.remote.CapabilityType;
//import org.openqa.selenium.remote.DesiredCapabilities;

import br.com.inm.appesporte.mobile.config.ParametrosConfig;
import br.com.inm.appesporte.mobile.utils.Log;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
//import io.appium.java_client.appmanagement.BaseActivateApplicationOptions;
//import io.appium.java_client.appmanagement.BaseOptions;
//import io.appium.java_client.remote.MobileCapabilityType;
//import io.appium.java_client.remote.MobilePlatform;
//import io.appium.java_client.remote.options.SupportsAutomationNameOption;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

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
	
	private static AppiumDriverLocalService servico;
	
	private static Log log = new Log();
	
	
	/**
	 * Método que chama o construtor e retorna o DriverFActory instanciado
	 * 
	 *  @return
	 */
	
	public static AppiumDriverFactory Instance() {
		//Só entra no if a variável ainda não foi inicializada
		if (AppiumDriverFactory._instance==null) {
			AppiumDriverFactory._instance = new AppiumDriverFactory();
			log.mensagemGeral("AppiumDriverFactory instanciado com sucesso");
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
	    log.mensagemGeral("Apk capturado no caminho: "+ParametrosConfig.getCaminhoCompleto());	
	    
	    //Cria as configurações para o driver
	    UiAutomator2Options configuracoes = new UiAutomator2Options()
	    		.setApp(apk.getAbsolutePath())
	    		.setDeviceName("Nexus 4 API 28 - Teste curso")
	    		.eventTimings()//Reporta o tempo das atividades do appium internament no app
	    		.fullReset() //Re-instala sempre o app
	    		.setAppPackage("br.com.alura.aluraesporte")// define o pacote do app para obter mais logs
	    		.setAppActivity("br.com.alura.aluraesporte.ui.activity.MainActivity") // define a atividade para captura mais logs
	    		.autoGrantPermissions(); //Garante sempre as permissões necessárias
	    log.mensagemGeral("Configuracoes realizadas com sucesso");
	    
	    iniciaAppiumServer();
	    	    
	    driver = new AppiumDriver(servico.getUrl(), configuracoes);
    	log.mensagemGeral("Driver inicializado com sucesso! URL Appium: "+servico.getUrl().toString()+", Aplicativo: "+apk.getAbsolutePath());
    	// Se inicializar o appium server externamente
	    /*    URL urlconexao = null;
	    //Verifica a exception da URL
	    try {
	    	urlconexao = new URL("http://"+ParametrosConfig.getIPAppiumHost()+":4723/wd/hub");
	    	log.mensagemGeral("Url de conexão criada: "+ParametrosConfig.getIPAppiumHost()+"/wd/hub");
	    } catch (MalformedURLException e) {
	    	e.printStackTrace();
	    	
	    	log.erroExcecaoLancada(e);
	    }*/
	    		    	
	    	//driver = new AppiumDriver(urlconexao, configuracoes);
	    	//log.mensagemGeral("Driver inicializado com sucesso! URL Appium: "+urlconexao.toString()+", Aplicativo: "+apk.getAbsolutePath());
	    	
	}

	/**
	 * Método que retorna o driver instanciado
	 * 
	 * @return driver instanciado.
	 */
	public AppiumDriver getAppiumDriver() {
		return this.driver;
	}


	/**
	 * Fecha o serviço do appium server
	 */
	public static void fecharAppiumServer() {
		Instance().getAppiumDriver().quit();
		log.mensagemGeral("Driver finalizado com sucesso");
		servico.stop();
		log.mensagemGeral("Appium server finalizado com sucesso");
	}
	
	/**
	 * Inicializa o servico do appium server
	 */
	private static void iniciaAppiumServer() {
		
		//Só entra no if o appium server não tiver sido inicializado
		if (servico==null) {
			//Prepara o appium server
			servico = new AppiumServiceBuilder()
	    			.withIPAddress(ParametrosConfig.getIPAppiumHost())
	    			.usingPort(4735)
	    		//	.withLogFile(new File(ParametrosConfig.getCaminhoLogAppiumServer()))
	    			.build();    
	    	log.mensagemGeral(servico.getUrl().toString());
	    
	    	//Inicializa o appium server
	    	servico.start();
	    	log.mensagemGeral("Appium server inicializado com sucesso");
		} else {
			log.mensagemGeral("Appium server já inicializado");
		}
	}
	
	public static void iniciaGavacao() {
		_instance.getAppiumDriver();
	}
}
