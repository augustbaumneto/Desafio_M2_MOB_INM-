package br.com.inm.appesporte.mobile.banco.comunicacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.inm.appesporte.mobile.utils.Log;

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
	
	private static PreparedStatement pst;
	
	private static Log LOG = new Log();
	
	/**
	 * Construtor padrão.
	 */
	public BancoDadosExecutorQuery() {
		conectorbd = BancoDadosConectorFactory.Instance().retornaConexao();
		try {
			st = conectorbd.createStatement();
			LOG.mensagemGeral("Statement criado");
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
			LOG.mensagemGeral("Query executada com sucesso! : "+query);
			return true;
		} catch (SQLException e) {
			LOG.mensagemGeral(query);
			LOG.erroExcecaoLancada(e);
			return false;
		}
		
	}
	
	/**
	 * Método que executa uma query com resultados
	 * @param query
	 * @return um objeto que representa todo o resultado obtido
	 */
	public BancoDadosResultadoSelect executaQueryResultado(String query) {
		
		try {
			pst = conectorbd.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			LOG.mensagemGeral("Query executada com sucesso! : "+query);
			return new BancoDadosResultadoSelect(rs);
		} catch (SQLException e) {
			LOG.mensagemGeral(query);
			LOG.erroExcecaoLancada(e);
			return null;
		}
		
	}
}
