/**
 * 
 */
package br.com.inm.appesporte.mobile.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import br.com.inm.appesporte.mobile.config.Log;

/**
 * 
 * Classe responsável por fazer a leitura de um arquivo.
 * O Arquivo não pode ter espaços vazios.
 * 
 * @author August Neto
 *
 */
public class LeitorArquivo {

	private File arquivo;
	private FileReader fr;
	private BufferedReader br;
	private Log LOG = new Log();
	
	/**
	 * Construtor padrão
	 */
	public LeitorArquivo(String caminhoarquivo) {
		arquivo = new File(caminhoarquivo);
		inicializaParaLeitura();
	}
	
	/**
	 * Método que inicializa o Buffer de leitura
	 * 
	 */
	private void inicializaParaLeitura() {
		try {
			fr = new FileReader(arquivo);
			br = new BufferedReader(fr);
			LOG.mensagemgeral("Arquivo pronto para leitura");
		} catch (IOException e) {
			LOG.erroExcecaoLancada(e);
		}
	}
	
	/**
	 * Método que retorna uma linha do arquivo
	 * @return linha do arquivo
	 */
	public String retornaLinha() {
		String linha = null;
		try {
			linha=br.readLine();
			LOG.mensagemgeral("Linha capturada: " +linha);
		} catch (IOException e) {
			LOG.mensagemgeral("Erro ao lê linha");
			LOG.erroExcecaoLancada(e);
		}
		
		return linha;
	}
	
}
