/**
 * 
 */
package br.com.inm.appesporte.mobile.banco;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.inm.appesporte.mobile.banco.comunicacao.BancoDadosExecutorQuery;
import br.com.inm.appesporte.mobile.config.Log;
import br.com.inm.appesporte.mobile.utils.LeitorArquivo;

/**
 * 
 * Classe base para as classes que fazem querys
 * 
 * @author August Neto
 *
 */
public abstract class QueryMaker {
	
	private static Log LOG = new Log();
	
	protected static BancoDadosExecutorQuery bdeq;
	
	/**
	 * Construtor padrão
	 */
	protected QueryMaker() {
		bdeq = new BancoDadosExecutorQuery();
	}
	
	/**
	 * Método que executa um script SQL
	 * 
	 * @param caminhoArquivo do arquivo
	 */
	public void executaSQLScript(String caminhoArquivo){
		List<String> querys = new ArrayList<>();
		querys = montaQuery(caminhoArquivo);
		Iterator<String> itr = querys.iterator();
		while (itr.hasNext()) {
			bdeq.executaQuery(itr.next());
		}
	}
	
	/**
	 * Método que lÊ o arquivo e monta as querys para execução 
	 * 
	 * @param caminhoArquivo do arquivo
	 * @return Lista de querys
	 */
	protected List<String> montaQuery(String caminhoArquivo) {
		
		List<String> querys = new ArrayList<>();
		LeitorArquivo la = new LeitorArquivo(caminhoArquivo);
		LOG.mensagemgeral("Inicia leitura do arquivo: "+caminhoArquivo);
		
		String query = "";
		String controle = la.retornaLinha();
		
		while(!controle.equals(null)&&(!controle.equals(""))) {
			while(!(controle.substring(controle.length()-1).equals(";"))) {
				query = query+controle;
				controle = la.retornaLinha();
			}
			query = query+controle;
			querys.add(query);
			LOG.mensagemgeral("Query criada: "+query);
			query = "";
			controle=la.retornaLinha();
		}
		LOG.mensagemgeral("Querys montadas com sucesso!");
		return querys;
	}
	
}
