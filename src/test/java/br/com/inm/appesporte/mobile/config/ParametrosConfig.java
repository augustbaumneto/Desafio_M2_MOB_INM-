package br.com.inm.appesporte.mobile.config;

/**
 * 
 * Classe que armazena os parametros gerais utilizados.
 * 
 * @author August Neto
 *
 */
public class ParametrosConfig {

	//Porta do appium
    private static String ipappiumhost = "127.0.0.1";
	
	private static String nomeapp = "alura_esporte.apk"; 
	
	private static String caminhopastaapk = "src/main/resources/apk/";
	
	private static String caminhoreportbuilder = "target/Reportes/ReportBuilder/";
	
	private static String caminhojson = "target/Reportes/jsons/";
	
	private static String caminhocucumberreport = "target/Reportes/cucumber/";
	
	private static String caminhologappiumserver = "logs/appiumserver.log";
	
	private static String caminhoevidencias = "target/Evidencias/";

	/**
	 * Método que retorna a url do appium
	 * 
	 * @return endereço do appim mais a porta
	 */
	public static String getIPAppiumHost() {
		return ipappiumhost;
	}
	
	/*public static String getNomeapp() {
		return nomeapp;
	}*/
	
	/**
	 * Método que retorna o caminho completo do apk
	 * 
	 * @return Caminho completo: pasta + nome do apk com extensão
	 */
	public static String getCaminhoCompleto() {
		return caminhopastaapk+nomeapp;
	}
	
	/**
	 * Método que retorna o caminho onde é criado os reportes do cucumber
	 * 
	 * @return Caminho do cucumber report
	 */
	public static String getCaminhoCucumberReport() {
		return caminhocucumberreport;
	}
	
	/**
	 * Método que retorna o caminho onde é criado o reporte do ReportBuilder
	 * 
	 * @return Caminho do ReportBuilder
	 */
	public static String getCaminhoReportBuilder() {
		return caminhoreportbuilder;
	}
	
	/**
	 * Método que retorna o caminho onde são criados os arquivos jsons
	 * 
	 * @return Caminho dos arquivos jsons
	 */
	public static String getCaminhoJson() {
		return caminhojson;
	}
	
	/**
	 * Método que todos os caminhos dos reportes
	 * @return vetor com os caminhos de todos os reportes
	 */
	public static String[] getCaminhosReportes() {
		String[] caminhos = new String[3];
		caminhos[0]=getCaminhoJson();
		caminhos[1]=getCaminhoCucumberReport();
		caminhos[2]=getCaminhoReportBuilder();
		return caminhos;
	}
	
	/**
	 * Método que retorna o caminho do log para o appium server
	 * 
	 * @return Caminho do arquivo de log appium server
	 */
	public static String getCaminhoLogAppiumServer() {
		return caminhologappiumserver;
	}
	
	/**
	 * Método que retorna o caminho da pasta de evidências
	 * 
	 * @return Caminho da pasta de evidências
	 */
	public static String getCaminhoEvidencias() {
		return caminhoevidencias;
	}
}
