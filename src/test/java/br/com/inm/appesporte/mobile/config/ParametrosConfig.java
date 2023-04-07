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
    private static String urlappium = "http://192.168.56.1:4724";
	
	private static String nomeapp = "alura_esporte.apk"; 
	
	private static String caminhopastaapk = "C:\\B\\Auto\\Projetos_de_automacao\\treina_Alura_Appium\\AluraAppium\\src\\main\\resources\\";
	

	/**
	 * Método que retorna a url do appium
	 * 
	 * @return endereço do appim mais a porta
	 */
	public static String getUrlappium() {
		return urlappium;
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
}
