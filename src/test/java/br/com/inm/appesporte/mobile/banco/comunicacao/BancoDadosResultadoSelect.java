/**
 * 
 */
package br.com.inm.appesporte.mobile.banco.comunicacao;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.inm.appesporte.mobile.config.Log;

/**
 * Classe que armazena o resultado de um consulta no banco de dados
 * 
 * @author August Neto
 *
 */
public class BancoDadosResultadoSelect {

	private ResultSet resultadoconsulta;
	
	private Log LOG = new Log();
	
	/**
	 * Construtor padrão
	 */
	public BancoDadosResultadoSelect(ResultSet resultado) {
		resultadoconsulta = resultado;
	}
	
	/**
	 * Método que retorna o valor na linha indicada e na coluna com o nome informado
	 * @param linha: numero da linha onde deseja buscar
	 * @param coluna: nome da coluna cujo que buscar
	 * @return um objeto genérico com o dado da linha e coluna buscada
	 */
	public Object getResultadoValor(int linha, String coluna) {
		try {
			//Devido o ResultSet não poder voltar, para chegar na linha temos que caminhar 1 a 1
			for (int i=1; i<=2;i=i+1)
				resultadoconsulta.next();
			Object retorno = resultadoconsulta.getObject(coluna);
			LOG.mensagemElementoEncontrado(retorno);
			return retorno;
		} catch (SQLException e) {
			LOG.erroExcecaoLancada(e);
			return null;
		}
		
	}
	
}
