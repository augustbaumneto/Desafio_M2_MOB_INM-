/**
 * 
 */
package br.com.inm.appesporte.mobile.utils;

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
			try {
				reporte.criaReporte();
				log.mensagemGeral("Reporte criado com sucesso utilizando o ReportBuilder");
			} catch (Exception e) {
				log.erroExcecaoLancada(e);
			}    
	 }    
}
