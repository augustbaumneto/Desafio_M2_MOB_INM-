/**
 * 
 */
package br.com.inm.appesporte.mobile.acceptance.steps;

import br.com.inm.appesporte.mobile.acceptance.logics.CadastroLogics;
import br.com.inm.appesporte.mobile.acceptance.logics.ListaProdutosLogics;
import br.com.inm.appesporte.mobile.acceptance.logics.LoginLogics;
import br.com.inm.appesporte.mobile.massa.GeradorMassa;
import br.com.inm.appesporte.mobile.resultadoteste.GravadorTeste;
import br.com.inm.appesporte.mobile.utils.Log;
//import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class CadastroSteps {

	private static Log log = new Log();
	private GeradorMassa massa = new GeradorMassa();
	private static GravadorTeste gravador = GravadorTeste.Instance();
	
	private LoginLogics loginlogics;
	private CadastroLogics cadastrologics;
	
	private String usuario;
	private String senha;
	private String confirmarsenha;


	@Dado("que estou na tela de cadastro")
	public void queEstouNaTelaDeCadastro() {
		loginlogics = new LoginLogics();
    	loginlogics.abrirPaginaDeLogin();
    	cadastrologics=loginlogics.acessaCadastro();
    	assertTrue(cadastrologics.estaNaTelaCadastro());
    	log.mensagemGeral("Step Dado que estou na tela de cadastro realizado com sucesso");
	}

	@Quando("eu tento realizar o cadastro com usuário válido e senha iguais")
	public void euTentoRealizarOCadastroComUsuárioVálidoESenhaIguais() {
		usuario = massa.geraPrimeiroNome();
		senha = massa.geraSenha();
		
		gravador.gravaMassa("Usuário", usuario);
		gravador.gravaMassa("Senha", senha);
		gravador.gravaMassa("ConfirmarSenha", senha);
		
		loginlogics = cadastrologics.cadastraUsuario(usuario, senha);
		log.mensagemGeral("Step Quando eu tento realizar o cadastro com usuário válido e senha iguais realizado com sucesso com usuario: "+usuario+" e senha: "+senha);
	}

	@Então("devo ser direcionado para a tela de login")
	public void devoSerDirecionadoParaATelaDeLogin() {
		assertTrue(loginlogics.estaPaginaLogin());
		log.mensagemGeral("Step Então devo ser direcionado para a tela de login realizado com sucesso");
	}

	@Então("meu cadastro deve ser realizado com sucesso")
	public void meuCadastroDeveSerRealizadoComSucesso() {
		ListaProdutosLogics listaproutologic;
		listaproutologic=loginlogics.realizarLoginComUsuarioESenha(usuario, senha);
		assertTrue(listaproutologic.ePaginaListaProdutos());
		log.mensagemGeral("Step Então meu cadastro deve ser realizado com sucesso realizado com sucesso");
		listaproutologic.sair();
	}

	@Quando("eu tento realizar o cadastro com usuário válido e senhas diferentes")
	public void euTentoRealizarOCadastroComUsuárioVálidoESenhasDiferentes() {
		usuario = massa.geraPrimeiroNome();
		senha = massa.geraSenha();
		confirmarsenha=massa.geraSenha();
		
		gravador.gravaMassa("Usuário", usuario);
		gravador.gravaMassa("Senha", senha);
		gravador.gravaMassa("ConfirmarSenha", confirmarsenha);
		
		loginlogics = cadastrologics.cadastraUsuario(usuario, senha, confirmarsenha);
		log.mensagemGeral("Step Quando eu tento realizar o cadastro com usuário válido e senhas diferentes realizado com sucesso com usuario: "+usuario+", senha: "+senha+" e senha2: "+confirmarsenha);
	}

	@Então("devo ver a mensagem de erro informando que as senhas não conferem")
	public void devoVerAMensagemDeErroInformandoSenhasNaoConferem() {
		assertTrue(cadastrologics.validarMensagemDeErroSenhaNaoConferem());
		log.mensagemGeral("Step Então devo ver a mensagem de erro informando que as senhas não conferem realizado com sucesso");
	}

	@Então("devo permanecer na tela de cadastro")
	public void devoPermanecerNaTelaDeCadastro() {
		assertTrue(cadastrologics.estaNaTelaCadastro());
		log.mensagemGeral("Step Então devo devo permanecer na tela de cadastro realizado com sucesso");
		cadastrologics.retornaLogin();
	}

	@Dado("com o campo {string} preenchido")
	public void comOCampoPreenchido(String campo) {
		String dadopreencher = "";
		GravadorTeste.setEsquema("Campo "+campo+" preenchido");
		switch(campo) {
			case "senha":
				senha = massa.geraSenha();
				
				gravador.gravaMassa("Senha", senha);
				
				dadopreencher=senha;
				break;
			case "confirmarsenha":
				confirmarsenha =massa.geraSenha();
				
				gravador.gravaMassa("ConfirmarSenha", confirmarsenha);
				
				dadopreencher=confirmarsenha;
				break;	
			default :
				log.erroParametroNaoValido("campo", campo);
    			assertTrue(false);
				break;
		}
		
		cadastrologics.preencheCampo(campo, dadopreencher);
		log.mensagemGeral("Step Dado com o campo: "+campo+" preenchido com valor: "+dadopreencher+" realizado com sucesso");
	}

	@Quando("clico no botão visualizar senha ao lado do campo {string}")
	public void clicoNoBotãoVisualizarSenhaAoLadoDoCampo(String campo) {
		cadastrologics.clicarBotaoVisualizarSenha(campo);
		log.mensagemGeral("Step Quando clico no botão visualizar senha ao lado do campo: "+campo+" realizado com sucesso");
	}

	@Então("devo ver a senha digitada no campo {string} em formato legível")
	public void devoVerASenhaDigitadaNoCampoEmFormatoLegível(String campo) {
		
		assertTrue(cadastrologics.validarSenhaEmFormatoLegivel(campo));
		log.mensagemGeral("Step Então devo ver a senha digitada no campo: "+campo+" em formato legível realizado com sucesso");
	}

	@Quando("eu tento realizar o cadastro com campo {string} vazio e demais dados válidos")
	public void euTentoRealizarOCadastroComCampoVazioEDemaisDadosVálidos(String campo) {
		usuario = massa.geraPrimeiroNome();
		
		GravadorTeste.setEsquema("Campo "+campo+" vazio");
		gravador.gravaMassa("Usuário", usuario);
		
		switch(campo) {
			case "senha":
				senha = "";
				confirmarsenha=massa.geraSenha();
				
				gravador.gravaMassa("ConfirmarSenha", confirmarsenha);
				
				break;
			case "confirmarsenha":
				confirmarsenha ="";
				senha=massa.geraSenha();
				
				gravador.gravaMassa("Senha", senha);
				
				break;	
			default :
				log.erroParametroNaoValido("campo", campo);
				assertTrue(false);
				break;
		}
		
		cadastrologics.cadastraUsuario(usuario, senha, confirmarsenha);
		log.mensagemGeral("Step Quando eu tento realizar o cadastro com campo: "+campo+" vazio e demais dados válidos realizado com sucesso");
	}

	@Dado("possua um usuário já cadastrado")
	public void possuaUmUsuárioJáCadastrado() {
		usuario = massa.geraPrimeiroNome();
		senha = massa.geraSenha();
		
		gravador.gravaMassa("Usuario Cadastrado", usuario);
		gravador.gravaMassa("senha do Usuario Cadastrado", senha);
		
		loginlogics = cadastrologics.cadastraUsuario(usuario, senha);
		cadastrologics = loginlogics.acessaCadastro();
		log.mensagemGeral("Step Dado possua um usuário já cadastrado realizado com sucesso");
	}

	@Quando("eu tento realizar o cadastro com mesmo usuário")
	public void eu_tento_realizar_o_cadastro_com_mesmo_usuario() {
		cadastrologics.cadastraUsuario(usuario, senha);
		log.mensagemGeral("Step Quando eu tento realizar o cadastro com mesmo usuário realizado com sucesso");
	}
	
	@Então("devo ver a mensagem de usuário já cadastrado")
	public void devo_ver_a_mensagem_de_usuario_ja_cadastrado(){
		assertTrue(cadastrologics.validarMensagemDeErroUsuarioExistente());
		log.mensagemGeral("Step Então devo ver a mensagem de usuário já cadastrado realizado com sucesso");
	}
	
	//Para garantir que o teste sempre retorna a tela de login
	/*@After
	public void retornalogin() {
		while (!loginlogics.estaPaginaLogin()) {
			loginlogics.retornaUmaTela();
		}
	}*/
	
}