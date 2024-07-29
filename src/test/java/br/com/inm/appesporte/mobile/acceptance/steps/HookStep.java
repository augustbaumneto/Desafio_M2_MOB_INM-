/**
 * 
 */
package br.com.inm.appesporte.mobile.acceptance.steps;

import br.com.inm.appesporte.mobile.acceptance.pages.AppiumDriverFactory;
import br.com.inm.appesporte.mobile.config.ParametrosConfig;
import br.com.inm.appesporte.mobile.resultadoteste.GravadorTeste;
import br.com.inm.appesporte.mobile.utils.ExcecaoAntesDeFechar;
import br.com.inm.appesporte.mobile.utils.Log;
import br.com.inm.appesporte.mobile.utils.ManipulacaoArquivo;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

/**
 * Classe com os hooks
 * 
 * @author August Neto
 *
 */
public class HookStep {

	private static Log log = new Log();
	
	private static GravadorTeste gravador;
	
	@BeforeAll
	public static void inicioSuite(){
			
			//AppiumDriverFactory.iniciaAppiumServer();
		
			String[] caminhosreportes = ParametrosConfig.getCaminhosReportes();
		
			for (String caminho : caminhosreportes) {
				ManipulacaoArquivo ma = new ManipulacaoArquivo(caminho);
				ma.limpaPasta();
			}
			log.mensagemGeral("Arquivos de reportes limpos!");
			gravador = GravadorTeste.Instance();
			gravador.inicializaSuite();
			
	}
	@Before
	public void inicioTeste(Scenario cenario) {
		log.mensagemGeral("---------------------Iniciando novo teste----------------------");
		
		gravador.iniciaTeste(cenario.getName());
		
	}
	
	@After
	public void fimTeste(Scenario cenario) {
		gravador.finalizaTeste(cenario.getStatus().name());
		log.mensagemGeral("---------------------Teste Concluido----------------------");
	}
	
	@AfterAll
	public static void fimExecucao(){
		gravador.finalizaSuite();
		
		//Lança a exceção para fechar antes de finalizar o programa (JVM).
		Runtime r=Runtime.getRuntime();    
		r.addShutdownHook(new ExcecaoAntesDeFechar());    
	}
}
