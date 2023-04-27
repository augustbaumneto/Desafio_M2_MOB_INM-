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
@IncludeTags("cadastrar")							//Tags executadas
@ConfigurationParameter(key = PLUGIN_PUBLISH_QUIET_PROPERTY_NAME, value = "true") //Configura para não exibir o quadro do cucumber no console
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "me.jvt.cucumber.report.PrettyReports:target/Reportes/cucumber/cadastro,json:target/Reportes/jsons/cadastro.json") //Configura o reporte.
//pretty imprime os steps no console. Summary: imprime o resumo no console. html:pasta/arquivo.html : gera um html simples do resultado na pasta dada.
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "br.com.inm.appesporte.mobile.acceptance.steps") //Configura o caminho das classes com os steps
public class RunCadastroTest {
	
}
