package br.com.inm.appesporte.mobile.config;

import br.com.inm.appesporte.mobile.banco.logics.QueryMakerDDL;
import br.com.inm.appesporte.mobile.banco.logics.QueryMakerDML;

/**
 * Programa responsável por montar o banco de dados, ele cria o banco e executa o script para criação das tabelas.
 * Rode ele apenas se o banco de dados não existir ainda.
 * 
 * @author August Neto
 *
 */

public class CriaEstruturaBanco {

	public static void main(String[] args) {
		
		QueryMakerDDL scriptinicial = new QueryMakerDDL();
		scriptinicial.executaSQLScript(ArquivoQueryConfig.getCaminhoArquivoQuery());
		//Teste
		QueryMakerDML teste = new QueryMakerDML();
		System.out.println(teste.getTipoStatusID2());
	}

}
