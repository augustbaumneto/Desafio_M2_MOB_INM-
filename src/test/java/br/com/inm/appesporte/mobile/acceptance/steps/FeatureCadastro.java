package br.com.inm.appesporte.mobile.acceptance.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import br.com.inm.appesporte.mobile.acceptance.pages.AppiumDriverConfig;
import br.com.inm.appesporte.mobile.acceptance.pages.CadastroPageObject;
import br.com.inm.appesporte.mobile.acceptance.pages.LoginPageObject;
import br.com.inm.appesporte.mobile.massa.GeradorMassa;
import io.appium.java_client.AppiumDriver;
import br.com.inm.appesporte.mobile.config.Log;



public class FeatureCadastro 
{
	private Log log = new Log();
	
	private GeradorMassa massa = new GeradorMassa();
	
    @Test
    public void nao_consigo_cadastrar_usuario_com_senhas_que_nao_conferem()
    {
    	
    	
    	log.inicioNovoTeste("Não cadastrar usuário");
    	
    	AppiumDriver driver = AppiumDriverConfig.Instance().driver; 
    	
    	LoginPageObject telalogin = new LoginPageObject(driver); 
    	
    	log.mensagemgeral("Driver e tela de login incializada");
    	
    	telalogin.buscarElementos();
    	CadastroPageObject telacadastro = telalogin.clicarCadastrar();
    	
    	log.mensagemgeral("Avanço tela de Cadastro");
    	
    	String senha1 = massa.geraSenha();
    	String senha2 = massa.geraSenha();
    	
    	telacadastro.buscarElementos();
    	telacadastro.Cadastrar(massa.geraPrimeiroNome(),senha1,senha2);
    	
    	
        assertEquals(telacadastro.verificamensagemerro(), "Senhas não conferem");
        
        log.mensagemgeral("Validação do cadastro efetuada");
        
        telacadastro.voltarLogin();
        
        log.mensagemgeral("Retorno tela de login");

        
    }
    
    @Test
    public void efetuar_cadastro_usuario_e_senhas_validos()
    {
    	log.inicioNovoTeste("Cadastro usuário");
    	AppiumDriver driver = AppiumDriverConfig.Instance().driver; 
    	
    	LoginPageObject telalogin = new LoginPageObject(driver); 
    	
    	log.mensagemgeral(("Driver e tela login instanciado"));
    	
    	telalogin.buscarElementos();
    	CadastroPageObject telacadastro = telalogin.clicarCadastrar();
    	
    	log.mensagemgeral("Avanço tela de Cadastro");
    	
    	String senha1 = massa.geraSenha();
    	
    	telacadastro.buscarElementos();
    	telalogin = telacadastro.Cadastrar(massa.geraPrimeiroNome(),senha1,senha1);
    	    	  	
        assertTrue(telalogin.estaTelaLogin());
        
        log.mensagemgeral("Validação do cadastro efetuada");
        
    }
}
