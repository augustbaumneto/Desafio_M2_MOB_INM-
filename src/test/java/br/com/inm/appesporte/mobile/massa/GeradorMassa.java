/**
 * 
 *   Classe que será usada para gerar as massas necessários nos testes
 * 
 */
package br.com.inm.appesporte.mobile.massa;

import java.util.Locale;

import com.github.javafaker.Faker;

import br.com.inm.appesporte.mobile.utils.Log;

/**
 * @author August Neto
 *
 */
public class GeradorMassa {

	//Log
	private Log log = new Log();
	
	//Gerador
	private static Faker gerador = null;
	
	
	/**
	 * Inicia o gerador
	 */
	public GeradorMassa() {
		
		//Somente se o gerador não foi iniciado ainda
		if (gerador==null) {
			gerador = new Faker(new Locale("pt-br"));
			log.mensagemGeral("Gerador de massa iniciado para localização pt-br");
		}else {
			log.mensagemGeral("Construtor chamado porém com o gerador já inicializado");
		}
		
	}

	/**
	 *   Gera o primeiro nome de uma pessoa
	 * 
	 * @return primeiro nome
	 */
	public String geraPrimeiroNome() {
		String nome = gerador.name().firstName();
		log.mensagemElementoCriado("Primeiro nome", nome);
		return nome;
	}

	/**
	 *    Gera uma senha com um pokemon e uma cor
	 * 
	 * @return senha
	 */
	public String geraSenha() {
		String senha = gerador.pokemon().name()+gerador.color().name();
		log.mensagemElementoCriado("Senha", senha);
		return senha;
	}
}
