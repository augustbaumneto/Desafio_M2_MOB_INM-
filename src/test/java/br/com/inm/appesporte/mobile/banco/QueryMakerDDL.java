/**
 * 
 */
package br.com.inm.appesporte.mobile.banco;



/**
 * 
 * Classe responsável por criar as querys DDL
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

	public void executaQueryDDL(String string) {
		
		bdeq.executaQuery(string);
	}
	
	
}
