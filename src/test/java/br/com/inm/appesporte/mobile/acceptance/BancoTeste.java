package br.com.inm.appesporte.mobile.acceptance;

import br.com.inm.appesporte.mobile.acceptance.banco.BancoDadosConectorFactory;

public class BancoTeste {

	public static void main(String[] args) {
		BancoDadosConectorFactory a = BancoDadosConectorFactory.Instance();

		System.out.println(a.retornaConexao());
	}

}
