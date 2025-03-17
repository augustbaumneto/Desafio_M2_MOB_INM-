/**
 * 
 */
package br.com.inm.appesporte.mobile.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

/**
 * Classe responsável por manipular arquivos
 * 
 * @author August Neto
 *
 */
public class ManipulacaoArquivo {

	private File arquivobase;

	private static final Log LOG = new Log(); 
	/**
	 * Construtor que recebe a pasta do arquivo
	 * @param pasta
	 */
	public ManipulacaoArquivo(String pasta) {
		arquivobase = new File(pasta);
	}
	
	/**
	 * Método que apaga todos os arquivos de uma determinada pasta
	 */
	public void limpaPasta() {
		File[] listaarquivos = arquivobase.listFiles();
    	if (listaarquivos !=null) {
    		
    		for (File tmp : listaarquivos) {
    			String nome = tmp.getAbsolutePath();
    		
    		
    			if (tmp.isDirectory()) {
    				try {
    					FileUtils.cleanDirectory(tmp);
    					FileUtils.deleteDirectory(tmp);
    					LOG.mensagemGeral("Pasta excluída "+nome);
    				} catch(IOException e) {
    					LOG.erroExcecaoLancada(e);
    				}
    			} else {
    				LOG.mensagemGeral("Arquivo excluído "+nome);
    				tmp.delete();
    			}
    		}
    		
    	}
	}
	
	/**
	 * Método que cria uma pasta
	 */
	public static void criaPasta(String caminhodapasta) {
		File pasta = new File(caminhodapasta);
		
		if(pasta.exists()) {
			LOG.mensagemGeral("Diretório já existente: "+caminhodapasta);
		}else {
			//Se não existir cria a pasta
			try{
                pasta.mkdir();
                LOG.mensagemGeral("Pasta criada com sucesso: "+caminhodapasta);
            } catch (SecurityException e) {
            	LOG.erroExcecaoLancada(e);
            }
		}
		
	}
	
	/**
	 * Método que renomeia uma pasta
	 */
	public static void renomeiaPasta(String nomeantigo, String nomenovo) {
		File pasta = new File(nomeantigo);
		
		if(pasta.exists()) {
			LOG.mensagemGeral("Diretório já existente: "+nomeantigo);
			pasta.renameTo(new File(nomenovo));
		}else {
			  LOG.mensagemGeral("Pasta inexistente");
            } 
		}
		
	
}
