/**
 * 
 */
package br.com.inm.appesporte.mobile.banco.comunicacao;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.inm.appesporte.mobile.utils.Log;

/**
 * Classe que armazena o resultado de um consulta no banco de dados
 * 
 * @author August Neto
 *
 */
public class BancoDadosResultadoSelect {

	private ResultSet resultadoconsulta;
	
	private Log LOG = new Log();
	
	private int i = 0;
	
	/**
	 * Construtor padrão
	 */
	public BancoDadosResultadoSelect(ResultSet resultado) {
		resultadoconsulta = resultado;
	}
	
	/**
	 * Método que retorna o valor na linha indicada e na coluna com o nome informado. Atenção não possível
	 *     voltar a uma linha já passada. Será necessário fazer um novo select, limitação do SQLite.
	 * @param linha: numero da linha onde deseja buscar
	 * @param coluna: nome da coluna cujo que buscar
	 * @return um objeto genérico com o dado da linha e coluna buscada
	 */
	public Object getResultadoValor(int linha, String coluna) {
		try {
			//Devido o ResultSet não poder voltar, para chegar na linha temos que caminhar 1 a 1
			while (i<linha) {
				resultadoconsulta.next();
				i=i+1;
			}
			Object retorno = resultadoconsulta.getObject(coluna);
			LOG.mensagemElementoEncontrado(retorno);
			return retorno;
		} catch (SQLException e) {
			LOG.erroExcecaoLancada(e);
			return null;
		}
		
	}
	
	/**
	 * Método que retorna o id da primeira linha da consulta.
	 * @return id da primeira linha
	 */
	public int getIDPrimeiraLinha() {
		try {
			resultadoconsulta.next();
			int retorno = resultadoconsulta.getInt(1);
			LOG.mensagemElementoEncontrado(retorno);
			return retorno;
		}catch(SQLException e) {
			LOG.erroExcecaoLancada(e);
			return -1;
		}
		
	}
	
}
