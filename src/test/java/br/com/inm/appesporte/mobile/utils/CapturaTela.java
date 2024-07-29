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
	
	/**
	 * Método responsável para tirar o print e gravá-lo
	 * 
	 * @param nomeimagem
	 */
	public static void capturaTela(String nomeimagem) {
		
		String telacapturada = AppiumDriverFactory.Instance().getAppiumDriver().getScreenshotAs(OutputType.BASE64);
		
		log.mensagemGeral("Print de tela capturado");
		
		String nomearquivo = caminhoevidencia+"/"+nomeimagem+".png";
		
		try (FileOutputStream outputStream = new FileOutputStream(nomearquivo)) {
	            outputStream.write(Base64.getDecoder().decode(telacapturada));
	            log.mensagemGeral("Tela gravada!");
	            
	        } catch (IOException e) {
	           log.erroExcecaoLancada(e);
	       }
		
	}

	public static void setCaminhoevidencia(String caminhoevidencia) {
		CapturaTela.caminhoevidencia = caminhoevidencia;
	}


	public static String getCaminhoEvidencia() {
		return caminhoevidencia;
	}
	
}
