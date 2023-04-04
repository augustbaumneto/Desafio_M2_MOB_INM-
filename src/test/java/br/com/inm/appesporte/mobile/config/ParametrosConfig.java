package br.com.inm.appesporte.mobile.config;

public class ParametrosConfig {

    private static String urlappium = "http://192.168.56.1:4724";
	
	private static String nomeapp = "alura_esporte.apk"; 
	
	public ParametrosConfig() {

	}

	public static String getUrlappium() {
		return urlappium;
	}
	
	public static String getNomeapp() {
		return nomeapp;
	}
}
