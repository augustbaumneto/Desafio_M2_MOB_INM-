package br.com.inm.appesporte.mobile.banco.comunicacao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.inm.appesporte.mobile.config.Log;

/**
 * 
 * Classe que acessa o banco e executa querys
 * 
 * @author August Neto
 *
 */
public class BancoDadosExecutorQuery {

	private static Connection conectorbd;
	
	private static Statement st;
	
	private static Log LOG = new Log();
	
	/**
	 * Construtor padrão.
	 */
	public BancoDadosExecutorQuery() {
		conectorbd = BancoDadosConectorFactory.Instance().retornaConexao();
		try {
			st = conectorbd.createStatement();
			LOG.mensagemgeral("Statement criado");
		} catch (SQLException e) {
			LOG.erroExcecaoLancada(e);
		}
		
	}
	
	/**
	 * Método que executa uma query padrão
	 * @param query
	 * @return Verdadeiro se deu certo, ou falso caso o contrário
	 */
	public boolean executaQuery(String query) {
		
		try {
			st.execute(query);
			LOG.mensagemgeral("Query executada com sucesso! : "+query);
			return true;
		} catch (SQLException e) {
			LOG.mensagemgeral(query);
			LOG.erroExcecaoLancada(e);
			return false;
		}
		
	}
}
