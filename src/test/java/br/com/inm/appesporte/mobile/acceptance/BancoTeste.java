package br.com.inm.appesporte.mobile.acceptance;

import br.com.inm.appesporte.mobile.banco.QueryMakerDDL;
import br.com.inm.appesporte.mobile.config.ArquivoQueryConfig;

public class BancoTeste {

	public static void main(String[] args) {
		QueryMakerDDL a = new QueryMakerDDL();
		a.executaSQLScript(ArquivoQueryConfig.getCaminhoArquivoQuery());
	}

}
