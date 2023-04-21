/**
 * 
 */
package br.com.inm.appesporte.mobile.resultadoteste;

import java.time.LocalDateTime;

import br.com.inm.appesporte.mobile.banco.logics.QueryMakerDML;

/**
 * Classe responsável por controlar a gravação de testes.
 * 
 * @author August Neto
 *
 */
public class GravadorTeste {

	private QueryMakerDML querylogics = new QueryMakerDML();
	
	/**
	 * Método que inicializa a suite e grava o horário de começo
	 */
	public void inicializaSuite() {
		LocalDateTime inicio = LocalDateTime.now();
		
		querylogics.insereSuiteinicial(inicio);
		
	}
	
	/**
	 * Método que finaliza a suite e grava o horário de fim
	 */
	public void finalizaSuite() {
		LocalDateTime fim = LocalDateTime.now();
		
		querylogics.atulizaSuite(fim);
		
	}
	
	
}
