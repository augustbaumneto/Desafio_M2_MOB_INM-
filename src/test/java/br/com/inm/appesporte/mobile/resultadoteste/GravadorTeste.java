/**
 * 
 */
package br.com.inm.appesporte.mobile.resultadoteste;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;

import br.com.inm.appesporte.mobile.banco.logics.QueryMakerDML;
import br.com.inm.appesporte.mobile.utils.Log;

/**
 * Classe responsável por controlar a gravação de testes.
 * 
 * @author August Neto
 *
 */
public class GravadorTeste {

	private Log log;
	private QueryMakerDML querylogics;
	private static GravadorTeste instancia;
		
	private static String esquema;
	
	private GravadorTeste() {
		log = new Log();
		querylogics = new QueryMakerDML();
	}
	
	/**
	 * Método que inicializa a instancia caso não tenha sido inicializada
	 * 
	 * @return
	 */
	public static GravadorTeste Instance() {
		//Só entra no if a variável ainda não foi inicializada
		if (GravadorTeste.instancia==null) {
			GravadorTeste.instancia = new GravadorTeste();
		}
		
		return GravadorTeste.instancia;
	}
	
	/**
	 * Método que inicializa a suite e grava o horário de começo
	 */
	public void inicializaSuite() {
		LocalDateTime inicio = LocalDateTime.now();
		querylogics.insereSuiteinicial(inicio);
		log.mensagemGeral("Suite inicializada");
	}
	
	/**
	 * Método que finaliza a suite e grava o horário de fim
	 */
	public void finalizaSuite() {
		LocalDateTime fim = LocalDateTime.now();
		querylogics.atualizaSuite(fim);
		log.mensagemGeral("Suite finalizada");
	}
	
	/**
	 * Grava o inicio de um novo teste
	 * @param cenario Nome do cenario
	 * @param exemplo Nome do exemplo
	 */
	public void iniciaTeste(String cenario) {
		LocalDateTime inicio = LocalDateTime.now();
		querylogics.insereTeste(inicio,cenario);
		esquema = "";
		log.mensagemGeral("Teste inicializado");
	}
	
	/**
	 * Método que finaliza o teste
	 * @param status Status da execução
	 */
	public void finalizaTeste(String status) {
		LocalDateTime fim = LocalDateTime.now();
		if (!esquema.equals(""))
			querylogics.atualizaTeste(fim, status,esquema);
		else
			querylogics.atualizaTeste(fim,status);
		esquema = "";
		log.mensagemGeral("Teste concluido");
	}

	/**
	 * Grava o esquema na variavel esquema
	 * @param exemplo
	 */
	public static void setEsquema(String exemplo) {
		esquema = exemplo;
	}
	
	/**
	 * Método que grava a massa
	 * @param tipo tipo da massa utilizada
	 * @param valor valor da massa utilizada
	 */
	public void gravaMassa(String tipo, String valor) {
		querylogics.insereMassa(tipo,valor);
		log.mensagemGeral("Massa inserida com sucesso!");
		
	}

	/**
	 * Método responsável por subir o log na suite
	 * @throws IOException 
	 */
	public void gravalog() {
		log.mensagemGeral("Gravando o arquivo de LOG no banco de dados");
		File arquivolog = new File("logs/automacao_teste_alura_esporte.log");
		byte[] dados;
		try {
			dados = FileUtils.readFileToByteArray(arquivolog);
			querylogics.atualizaSuiteLog(dados);
		} catch (IOException e) {
			log.erroExcecaoLancada(e);
		}
		
	}
}
