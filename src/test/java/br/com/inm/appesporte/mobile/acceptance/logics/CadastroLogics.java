package br.com.inm.appesporte.mobile.acceptance.logics;

import br.com.inm.appesporte.mobile.acceptance.pages.CadastroPageObject;

public class CadastroLogics {

	private CadastroPageObject cadastropage;
	
	public CadastroLogics(CadastroPageObject cadastropage) {
		this.cadastropage = cadastropage;
	}
	
	public LoginLogics cadastraUsuario(String usuario, String senha) {
		// TODO Auto-generated method stub
		return new LoginLogics();
	}

}
