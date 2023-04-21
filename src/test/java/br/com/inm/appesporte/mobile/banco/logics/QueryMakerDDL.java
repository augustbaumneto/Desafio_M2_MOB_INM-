/**
 * 
 */
package br.com.inm.appesporte.mobile.banco.logics;



/**
 * 
 * Classe responsável por criar as querys DDL manipulação da estrutura do banco
 * 
 * @author August Neto
 *
 */
public class QueryMakerDDL extends QueryMaker{

	/**
	 * Construtor padrão
	 */
	public QueryMakerDDL() {
		super();
	}
	
	/**
	 * Executa a query informada.
	 * @param string
	 */
	public void executaQueryDDL(String string) {
		
		bdeq.executaQuery(string);
	}
	
	
}
