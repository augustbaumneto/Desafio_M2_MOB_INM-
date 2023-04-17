/**
 * 
 */
package br.com.inm.appesporte.mobile.acceptance.banco;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.inm.appesporte.mobile.config.BancoConfig;
import br.com.inm.appesporte.mobile.config.Log;

/**
 * 
 * Classe responsável por criar o banco de dados
 * 
 * @author August Neto
 *
 */
public class BancoDadosConectorFactory {

	
	private final Log LOG = new Log();
	
	private final String urlconexao = BancoConfig.getStringConexao();

	private final String nomebanco = BancoConfig.getNomeBanco();

	private Connection conector;
	
	public static BancoDadosConectorFactory instancia;
	
	/**
	 * Método que inicializa a instancia caso não tenha sido inicializada
	 * 
	 * @return
	 */
	public static BancoDadosConectorFactory Instance() {
		//Só entra no if a variável ainda não foi inicializada
		if (BancoDadosConectorFactory.instancia==null) {
			BancoDadosConectorFactory.instancia = new BancoDadosConectorFactory();
		}
		
		return BancoDadosConectorFactory.instancia;
	}
	
	/**
	 * Construtor padrão
	 */
	private BancoDadosConectorFactory() {
		try (Connection con = DriverManager.getConnection(urlconexao)) {

			conector = con;
            LOG.mensagemgeral("Conexão ao Banco de dados: "+nomebanco+" realizada com sucesso");

        } catch (SQLException e) {
            LOG.erroExcecaoLancada(e);
        }
		
	}
	
	/**
	 * Retorna a conexão com o banco de dados
	 */
	public Connection retornaConexao() {
		return conector;
	}
	
}
