/**
 * 
 */
package br.com.inm.appesporte.mobile.acceptance.steps;

import java.util.HashMap;

import br.com.inm.appesporte.mobile.config.ParametrosConfig;
import br.com.inm.appesporte.mobile.resultadoteste.GravadorTeste;
import br.com.inm.appesporte.mobile.utils.CapturaTela;
import br.com.inm.appesporte.mobile.utils.ExcecaoAntesDeFechar;
import br.com.inm.appesporte.mobile.utils.Log;
import br.com.inm.appesporte.mobile.utils.ManipulacaoArquivo;
import br.com.inm.appesporte.mobile.acceptance.pages.AppiumDriverFactory;
import br.com.inm.appesporte.mobile.massa.MassaDeTeste;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
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
	
	@AfterStep
	public void anexaEvidencia(Scenario cenario) {
		if (cenario.isFailed()) {
			CapturaTela.capturaTela("Falha_do_teste");
			String codigopagina = AppiumDriverFactory.Instance().getAppiumDriver().getPageSource();
			System.out.println("Código da página que falhou: "+codigopagina);
			log.mensagemGeral("Código da página que falhou: {}");
		}
		
		HashMap<Integer,byte[]> capturas = CapturaTela.getCapturas();
		
		
		if (!capturas.isEmpty()) {
			int tamanho = capturas.size();
			for (int i=0; i< tamanho; i=i+1) {
				cenario.attach(capturas.get(i), "image/png", cenario.getName()+" imagem "+i);
			}
		} else {
			cenario.log("Sem imagem capturada para esse passo");
		}
		CapturaTela.limpaCaptura();
	}
	
	@After
	public void fimTeste(Scenario cenario) {
		//Tira um print caso haja falha
		if(cenario.isFailed()) {
			CapturaTela.capturaTela("Falha_do_teste");
			log.mensagemGeral("Tela final do erro capturada!");
		}
		
		MassaDeTeste.limpaMassa();
		
		gravador.finalizaTeste(cenario.getStatus().name());
		log.mensagemGeral("---------------------Teste Concluido----------------------");
		AppiumDriverFactory.fechaAppiumDriver();
	}
	
	@AfterAll
	public static void fimExecucao(){
		gravador.finalizaSuite();
		
		//Lança a exceção para fechar antes de finalizar o programa (JVM).
		Runtime r=Runtime.getRuntime();    
		r.addShutdownHook(new ExcecaoAntesDeFechar());    
	}
}
