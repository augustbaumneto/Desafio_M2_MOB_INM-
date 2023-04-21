/**
 * 
 */
package br.com.inm.appesporte.mobile.banco.logics;

import br.com.inm.appesporte.mobile.banco.comunicacao.BancoDadosResultadoSelect;

/**
 * Classe responsável por montar querys do tipo DML (manipulação de dados)
 * 
 * @author August Neto
 *
 */
public class QueryMakerDML extends QueryMaker {

	private BancoDadosResultadoSelect resultadoselect;
	
	/**
	 * Construtor padrão
	 */
	public QueryMakerDML() {
		super();
	}
	
	/**
	 * Excuta uma query do tipo select
	 * @param string, query a ser executada.
	 */
	public void executaQuerySelect(String string) {
		
		resultadoselect = bdeq.executaQueryResultado(string);
	}
	
	/**
	 * Método que retornar o tipo status na segunda linha da tabela
	 * @return A String que representa o valor no local informado
	 */
	public String getTipoStatusID2() {
		String query = montaSelectTipoStatus();
		LOG.mensagemgeral("Query montada com sucesso: "+query);
		resultadoselect = bdeq.executaQueryResultado(query);
		return (resultadoselect.getResultadoValor(2, CMP_NOMETIPOSTATUS)).toString();
		
	}
	
	/**
	 * Monta a query que busca todos os dados da tabela tipo status
	 * @return A query pronta para ser utilizada
	 */
	private String montaSelectTipoStatus() {
		return ("Select * from "+TB_TIPOSTATUS);
	}

	//TODO: implementar os insert e update necessários. implementar as classes resultadoteste. Talvez implementar os select para encontrar os ids
}
