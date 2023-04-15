/**
 * 
 */
package br.com.inm.appesporte.mobile.acceptance.steps;

import org.junit.jupiter.api.BeforeEach;

import br.com.inm.appesporte.mobile.acceptance.logics.CadastroLogics;
import br.com.inm.appesporte.mobile.acceptance.logics.ListaProdutosLogics;
import br.com.inm.appesporte.mobile.acceptance.logics.LoginLogics;
import br.com.inm.appesporte.mobile.config.Log;
import br.com.inm.appesporte.mobile.massa.GeradorMassa;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class CadastroSteps {

	private Log log = new Log();
	private GeradorMassa massa = new GeradorMassa();

	private LoginLogics loginlogics;
	private CadastroLogics cadastrologics;

	private String usuario;
	private String senha;
	private String confirmarsenha;

	@BeforeEach
	public void inicioTeste() {
		log.mensagemgeral("---------------------Iniciando novo teste----------------------");
	}

	@Dado("que estou na tela de cadastro")
	public void queEstouNaTelaDeCadastro() {
		loginlogics = new LoginLogics();
    	loginlogics.abrirPaginaDeLogin();
    	cadastrologics=loginlogics.acessaCadastro();
    	assertTrue(cadastrologics.estaNaTelaCadastro());
    	log.mensagemgeral("Step Dado que estou na tela de cadastro realizado com sucesso");
	}

	@Quando("eu tento realizar o cadastro com usuário válido e senha iguais")
	public void euTentoRealizarOCadastroComUsuárioVálidoESenhaIguais() {
		usuario = massa.geraPrimeiroNome();
		senha = massa.geraSenha();
		loginlogics = cadastrologics.cadastraUsuario(usuario, senha);
		log.mensagemgeral("Step Quando eu tento realizar o cadastro com usuário válido e senha iguais realizado com sucesso com usuario: "+usuario+" e senha: "+senha);
	}

	@Então("devo ser direcionado para a tela de login")
	public void devoSerDirecionadoParaATelaDeLogin() {
		assertTrue(loginlogics.estaPaginaLogin());
		log.mensagemgeral("Step Então devo ser direcionado para a tela de login realizado com sucesso");
	}

	@Então("meu cadastro deve ser realizado com sucesso")
	public void meuCadastroDeveSerRealizadoComSucesso() {
		ListaProdutosLogics listaproutologic;
		listaproutologic=loginlogics.realizarLoginComUsuarioESenha(usuario, senha);
		assertTrue(listaproutologic.ePaginaListaProdutos());
		log.mensagemgeral("Step Então meu cadastro deve ser realizado com sucesso realizado com sucesso");
		listaproutologic.sair();
	}

	@Quando("eu tento realizar o cadastro com usuário válido e senhas diferentes")
	public void euTentoRealizarOCadastroComUsuárioVálidoESenhasDiferentes() {
		usuario = massa.geraPrimeiroNome();
		senha = massa.geraSenha();
		confirmarsenha=massa.geraSenha();
		loginlogics = cadastrologics.cadastraUsuario(usuario, senha, confirmarsenha);
		log.mensagemgeral("Step Quando eu tento realizar o cadastro com usuário válido e senhas diferentes realizado com sucesso com usuario: "+usuario+", senha: "+senha+" e senha2: "+confirmarsenha);
	}

	@Então("devo ver a mensagem de erro informando que as senhas não conferem")
	public void devoVerAMensagemDeErroInformandoSenhasNaoConferem() {
		assertTrue(cadastrologics.validarMensagemDeErroSenhaNaoConferem());
		log.mensagemgeral("Step Então devo ver a mensagem de erro informando que as senhas não conferem realizado com sucesso");
	}

	@Então("devo permanecer na tela de cadastro")
	public void devoPermanecerNaTelaDeCadastro() {
		assertTrue(cadastrologics.estaNaTelaCadastro());
		log.mensagemgeral("Step Então devo devo permanecer na tela de cadastro realizado com sucesso");
		cadastrologics.retornaLogin();
	}

	@Dado("com o campo {string} preenchido")
	public void comOCampoPreenchido(String campo) {
		String dadopreencher = "";
		switch(campo) {
			case "senha":
				senha = massa.geraSenha();
				dadopreencher=senha;
				break;
			case "confirmarsenha":
				confirmarsenha =massa.geraSenha();
				dadopreencher=confirmarsenha;
				break;	
			default :
				log.erroParametroNaoValido("campo", campo);
    			assertTrue(false);
				break;
		}
		
		cadastrologics.preencheCampo(campo, dadopreencher);
		log.mensagemgeral("Step Dado com o campo: "+campo+" preenchido com valor: "+dadopreencher+" realizado com sucesso");
	}

	@Quando("clico no botão visualizar senha ao lado do campo {string}")
	public void clicoNoBotãoVisualizarSenhaAoLadoDoCampo(String campo) {
		cadastrologics.clicarBotaoVisualizarSenha(campo);
		log.mensagemgeral("Step Quando clico no botão visualizar senha ao lado do campo: "+campo+" realizado com sucesso");
	}

	@Então("devo ver a senha digitada no campo {string} em formato legível")
	public void devoVerASenhaDigitadaNoCampoEmFormatoLegível(String campo) {
		
		assertTrue(cadastrologics.validarSenhaEmFormatoLegivel(campo));
		log.mensagemgeral("Step Então devo ver a senha digitada no campo: "+campo+" em formato legível realizado com sucesso");
	}

	@Quando("eu tento realizar o cadastro com campo {string} vazio e demais dados válidos")
	public void euTentoRealizarOCadastroComCampoVazioEDemaisDadosVálidos(String campo) {
		usuario = massa.geraPrimeiroNome();
		switch(campo) {
			case "senha":
				senha = "";
				confirmarsenha=massa.geraSenha();
				break;
			case "confirmarsenha":
				confirmarsenha ="";
				senha=massa.geraSenha();
				break;	
			default :
				log.erroParametroNaoValido("campo", campo);
				assertTrue(false);
				break;
		}
		
		cadastrologics.cadastraUsuario(usuario, senha, confirmarsenha);
		log.mensagemgeral("Step Quando eu tento realizar o cadastro com campo: "+campo+" vazio e demais dados válidos realizado com sucesso");
	}
/*
	@Dado("possua um usuário já cadastrado")
	public void possuaUmUsuárioJáCadastrado() {
		cadastrologics.simularCadastroUsuarioExistente();
		log.mensagemgeral("Step Dado possua um usuário já cadastrado realizado com sucesso");
	}

	@Quando("eu tento realizar o cadastro com mesmo usuário")
	public void eu_tento_realizar_o_cadastro_com_mesmo_usuario() {
		String usuarioExistente = "usuarioExistente";
		String senha = "senha123";

		// Cadastra usuário existente
		cadastrologics.realizarCadastro(usuarioExistente, senha, senha);

		// Tenta cadastrar mesmo usuário
		cadastrologics.realizarCadastro(usuarioExistente, senha, senha);
		log.mensagemgeral("Step Quando eu tento realizar o cadastro com mesmo usuário realizado com sucesso")
	}*/
}