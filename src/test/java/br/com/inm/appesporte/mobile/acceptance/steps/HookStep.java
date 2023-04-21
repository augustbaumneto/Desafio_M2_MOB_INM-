/**
 * 
 */
package br.com.inm.appesporte.mobile.acceptance.steps;

import br.com.inm.appesporte.mobile.config.Log;
import br.com.inm.appesporte.mobile.resultadoteste.GravadorTeste;
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
	public static void inicioSuite() {
			gravador = GravadorTeste.Instance();
			gravador.inicializaSuite();
	}
	@Before
	public void inicioTeste(Scenario cenario) {
		log.mensagemgeral("---------------------Iniciando novo teste----------------------");
		
		gravador.iniciaTeste(cenario.getName());
		
	}
	
	@After
	public void fimTeste(Scenario cenario) {
		gravador.finalizaTeste(cenario.getStatus().name());
		log.mensagemgeral("---------------------Teste Concluido----------------------");
	}
	
	@AfterAll
	public static void fimExecucao() {
		gravador.finalizaSuite();
	}
}
