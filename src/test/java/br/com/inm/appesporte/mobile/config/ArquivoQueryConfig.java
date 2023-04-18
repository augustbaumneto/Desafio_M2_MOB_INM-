/**
 * 
 */
package br.com.inm.appesporte.mobile.config;

/**
 * 
 * Classe que contêm os dados do arquivo de Query para construção do banco
 * 
 * @author August Neto
 *
 */
public class ArquivoQueryConfig {

	private static String nomearquivo = "script_criacao_bd.sql";
	
	private static String caminhoarquivo = "./src/main/resources/BancoDados/";
	
	/**
	 *  Método que retorna o nome do arquivo de query para criação do banco de dados
	 * @return o nome do arquivo com extensão
	 */
	public static String getNomeArquivoQuery() {
		return nomearquivo;
	}
	
	/**
	 *  Método que retorna o caminho completo do arquivo que possui o script de criação do banco de dados
	 * @return o caminho completo: caminho da pasta + arquivo + extensão
	 */
	public static String getCaminhoArquivoQuery() {
		return caminhoarquivo+nomearquivo;
	}
	
}
