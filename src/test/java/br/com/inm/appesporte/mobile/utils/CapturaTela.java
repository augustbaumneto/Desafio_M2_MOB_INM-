/**
 * 
 */
package br.com.inm.appesporte.mobile.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import org.openqa.selenium.OutputType;

import br.com.inm.appesporte.mobile.acceptance.pages.AppiumDriverFactory;

/**
 * Classe responsável por gerar capturas de tela
 */
public class CapturaTela {

	private static Log log = new Log();
	
	private static String caminhoevidencia;
	
	//Guardar a numeração da imagem
	private static int numeroimagem;
	
	/**
	 * Método responsável para tirar o print e gravá-lo
	 * 
	 * @param nomeimagem
	 */
	public static void capturaTela(String nomeimagem) {
		
		String telacapturada = AppiumDriverFactory.Instance().getAppiumDriver().getScreenshotAs(OutputType.BASE64);
		
		log.mensagemGeral("Print de tela capturado");
		
		String texto_numeroimagem = Integer.toString(numeroimagem);
		
		//Ajusta numero de character
		if(texto_numeroimagem.length()==1) {
			texto_numeroimagem = "00"+texto_numeroimagem;
		}
		
		//Ajusta numero de character
		if(texto_numeroimagem.length()==2) {
			texto_numeroimagem = "0"+texto_numeroimagem;
		}
		
		String nomearquivo = caminhoevidencia+"/"+texto_numeroimagem+" - "+nomeimagem+".png";
		
		try (FileOutputStream outputStream = new FileOutputStream(nomearquivo)) {
	            outputStream.write(Base64.getDecoder().decode(telacapturada));
	            log.mensagemGeral("Tela gravada!");
	            numeroimagem=numeroimagem+1;
	            
	        } catch (IOException e) {
	           log.erroExcecaoLancada(e);
	       }
		
	}

	public static void setCaminhoevidencia(String caminhoevidencia) {
		CapturaTela.caminhoevidencia = caminhoevidencia;
		
		numeroimagem = 1;
	}


	public static String getCaminhoEvidencia() {
		return caminhoevidencia;
	}
	
}
