/**
 * 
 */
package br.com.inm.appesporte.mobile.config;

/**
 * 
 * Classe que possui as configurações do banco de dados
 * 
 * @author August Neto
 *
 */
public class BancoConfig {
	
	//Nome do banco. Se for conectar usar ": memory"
	private static String nomebanco = "teste";
	
	//Local onde se encontra o banco de dados, utillizar "/" no inicio e no fim
	private static String caminhobanco = "";
	
	//Prefixo para a conexão. 
	private static String prefixoconexao = "jdbc:sqlite:";
	
	/**
	 * Método que retorna a string de conexão completa
	 * 
	 * @return a string de conexão do banco
	 */
	public static String getStringConexao() {
		return prefixoconexao+caminhobanco+nomebanco+".bd";
	}
	
	/**
	 * Método que retorna a string de conexão na memória
	 * 
	 * @return a string conexão na memória
	 */
	public static String getStringConexaoMemoria() {
		return prefixoconexao+" :memory";
	}

	/**
	 * Retorna o nome do banco de dados
	 * 
	 *  return nome do banco dados
	 */
	public static String getNomeBanco() {
		return nomebanco;
	}
}
