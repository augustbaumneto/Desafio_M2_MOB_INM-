package br.com.inm.appesporte.mobile.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * Classe que gerencia o log.
 * 
 * @author August Neto
 *
 */
public class Log {

	//Constante que representa o log.
	private static final Logger logger = LoggerFactory.getLogger(Log.class);
	
	/**
	 *    Método que imprime no log a mensagem de inicio do teste
	 * 
	 * @param nometeste
	 */
	public void inicioNovoTeste(String nometeste) {
		logger.info("      Inicio novo teste: {}",nometeste);
		
	}
	
	/**
	 *   Método que imprime no log uma mensagem geral
	 * 
	 * @param mensagem
	 */
	public void mensagemgeral(String mensagem) {
		logger.info(mensagem);
	}

	/**
	 *   Método que imprime no log que o elemento foi criado
	 * 
	 * @param tipodelemento da forma que sairá na mensagem
	 * @param elemento Objeto criado
	 */
	public void mensagemElementoCriado(String tipodelemento, Object elemento) {
		logger.info(tipodelemento+" criado(a)" + ": {}",elemento);
	}
	
	/**
	 * Método que imprime no log que o elemento foi encontrado
	 * 
	 * @param elemento
	 */
	public void mensagemElementoEncontrado(Object elemento) {
		logger.info("Elemento {} encontrado",elemento);
	}
	
	/**
	 * Método que imprime no log que o elemento não foi encontrado e a exceção lançada
	 * 
	 * @param e
	 */
	public void erroExcecaoLancada(Exception e) {
		logger.error("Elemento não encontrado", e);
	}
	
	/**
	 * Método que imprime no log que o paramatro não é válido
	 * 
	 * @param parametro o parametro incorreto
	 * @param valor o valor do parametro
	 */
	public void erroParametroNaoValido(String parametro, Object valor) {
		logger.error("Parametro {} não válido para o valor {}", parametro, valor);
	}

	/**
	 * Método que registra a query montada
	 * @param query
	 */
	public void queryMontada(String query) {
		logger.info("Query montada com sucesso! Query: {}",query);
		
	}
	
	/**
	 * Método que registra o teste iniciado
	 * @param nome do teste
	 * @param exemplo se tiver do teste
	 * @param tipo do teste padrão ou esquema
	 */
	public void testeExecucao(String nome) {
		logger.info("Teste iniciado com sucesso! Nome: {}",nome);
		
	}
	
}
