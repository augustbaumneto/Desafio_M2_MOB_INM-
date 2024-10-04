package br.com.inm.appesporte.mobile.massa;

import java.util.HashMap;

import br.com.inm.appesporte.mobile.utils.Log;

public class MassaDeTeste {

	private static Log log = new Log();
	
	private static HashMap<String,Object> listadedados = new HashMap<>();
	
	public static void adicionaMassa(String tipo, int index, Object valor) {
		listadedados.put(tipo+Integer.toString(index), valor);
		log.mensagemGeral("Massa "+valor+" adicionada do tipo "+tipo);
	}
	
	public static Object retornarMassa(String tipo, int index) {
		return listadedados.get(tipo+Integer.toString(index));
	}
	
	public static void limpaMassa() {
		listadedados.clear();
		log.mensagemGeral("Massa excluída da memória");
	}
	
}
