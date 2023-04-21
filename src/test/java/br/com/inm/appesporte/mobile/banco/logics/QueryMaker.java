/**
 * 
 */
package br.com.inm.appesporte.mobile.banco.logics;

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
	
	protected static Log LOG = new Log();
	
	protected static BancoDadosExecutorQuery bdeq;
	
	//Nome das tabelas utilizadas
	protected static final String TB_TIPOSTATUS = "tb_tipo_status";
	protected static final String TB_RESULTADOEXECUCAO = "tb_Resultado_Execucao";
	protected static final String TB_MASSAEXECUCAO = "tb_Massa_Execucao";
	protected static final String TB_SUITEEXECUCAO = "tb_Suite_Execucao";
	
	//Nome de campos das tabelas utilizadas
	protected static final String CMP_IDTIPOSTATUS = "int_seq";
	protected static final String CMP_NOMETIPOSTATUS = "vchar_tipo_status";
	
	protected static final String CMP_IDEXECUCAO = "int_id_execucao";
	
	protected static final String CMP_IDSUITE = "int_id_suite";
	
	protected static final String CMP_IDMASSA = "int_id_massa";
	
	/**
	 * Construtor padrão
	 */
	protected QueryMaker() {
		bdeq = new BancoDadosExecutorQuery();
	}
	
	/**
	 * Método que executa um script SQL
	 * 
	 * @param caminhoArquivo Caminho do arquivo .sql que possui o script.
	 */
	public void executaSQLScript(String caminhoArquivo){
		List<String> querys = new ArrayList<>();
		querys = montaQuery(caminhoArquivo);
		Iterator<String> itr = querys.iterator();
		while (itr.hasNext()) {
			bdeq.executaQuery(itr.next());
		}
		LOG.mensagemgeral("Script executado!");
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
