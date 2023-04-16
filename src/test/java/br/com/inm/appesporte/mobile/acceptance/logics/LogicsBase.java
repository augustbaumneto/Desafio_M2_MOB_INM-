/**
 * 
 */
package br.com.inm.appesporte.mobile.acceptance.logics;

import br.com.inm.appesporte.mobile.acceptance.pages.LoginPageObject;

/**
 * Classe base das classe logics
 * 
 * @author August Neto
 *
 */
public abstract class LogicsBase {

	protected LoginPageObject loginpage;
	
	/**
	 * Método que retorna uma página
	 */
	public void retornaUmaTela() {
		loginpage.voltar();
	}
	
}
