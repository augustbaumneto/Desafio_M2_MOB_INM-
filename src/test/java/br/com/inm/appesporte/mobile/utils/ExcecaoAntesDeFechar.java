/**
 * 
 */
package br.com.inm.appesporte.mobile.utils;

import br.com.inm.appesporte.mobile.acceptance.pages.AppiumDriverFactory;
import br.com.inm.appesporte.mobile.resultadoteste.GravadorTeste;

/**
 * 
 * Classe de Excecao para executar o reporte antes de fechar o Java
 * @author August Neto
 *
 */
public class ExcecaoAntesDeFechar extends Thread {

	/**
	 * Método que lanço o gancho antes do fechamento da JVM
	 */
	 public void run(){    
		 	Log log = new Log();
		 	Reporte reporte =  new Reporte();
		 	GravadorTeste gravador = GravadorTeste.Instance();
			AppiumDriverFactory.fecharAppiumServer();
		 	try {
				reporte.criaReporte();
				log.mensagemGeral("Reporte criado com sucesso utilizando o ReportBuilder");
				gravador.gravalog();
			} catch (Exception e) {
				log.erroExcecaoLancada(e);
			}    
			
	 }    
}
