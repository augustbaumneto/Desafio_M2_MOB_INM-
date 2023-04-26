package br.com.inm.appesporte.mobile.acceptance;


import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PUBLISH_QUIET_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

import br.com.inm.appesporte.mobile.utils.Reporte;

/**
 * 
 * Classe responsável pela execução dos testes da feature cadastro
 * 
 * @author August Neto
 *
 */

@Suite
@SuiteDisplayName("Testes: Cadastro App Alura Esporte")	//Nome da suite para exibição
@IncludeEngines("cucumber")						//Motor Executor
@SelectClasspathResource("features")			//Caminho das features
@IncludeTags("CT2")							//Tags executadas
@ConfigurationParameter(key = PLUGIN_PUBLISH_QUIET_PROPERTY_NAME, value = "true") //Configura para não exibir o quadro do cucumber no console
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "html:target/cucumber/report.html, me.jvt.cucumber.report.PrettyReports:target/Report-Execution/cucumber-html-reports") //Configura o reporte.
//pretty imprime os steps no console. Summary: imprime o resumo no console
//@ConfigurationParameter(key = , value = "pretty") //Configura para o Gherkin de cada step sair no console.
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "br.com.inm.appesporte.mobile.acceptance.steps") //Configura o caminho das classes com os steps
public class RunCadastroTest {
	

/*	public RunCadastroTest() throws Exception {
		Reporte reporte = new Reporte();
		System.out.println("tes");
		reporte.criaReporte("Cadastro");
		<dependency>
        <groupId>com.rajatthareja</groupId>
        <artifactId>reportbuilder</artifactId>
        <version>1.0.3</version>
    </dependency> 
		
	}*/
	
}
