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
	
	//Nome de campos das tabelas utilizadas TIPO STATUS
	protected static final String CMP_TS_IDTIPOSTATUS = "int_seq";
	protected static final String CMP_TSNOMETIPOSTATUS = "vchar_tipo_status";
	
	//Nome de campos das tabelas utilizadas Resultado execucao
	protected static final String CMP_TRE_IDEXECUCAO = "int_id_execucao";
	protected static final String CMP_TRE_IDSUITE = "int_id_suite";
	protected static final String CMP_TRE_TIPOCENARIO = "enum_tipo_cenario";
	protected static final String CMP_TRE_NOMECENARIO = "vchar_cenario";
	protected static final String CMP_TRE_EXEMPLOCENARIO = "vchar_exemplo";
	protected static final String CMP_TRE_DATAINICIO = "dt_inicio_execucao";
	protected static final String CMP_TRE_DATAFIM = "dt_fim_execucao";
	protected static final String CMP_TRE_RESULTADO = "enum_status";
	
	//Nome de campos das tabelas utilizadas Suite Execução
	protected static final String CMP_TSUITE_IDSUITE = "int_id_suite";
	protected static final String CMP_TSUITE_DATAINICIO = "dt_inicio_execucao_suite";
	protected static final String CMP_TSUITE_DATAFIM = "dt_fim_execucao_suite";
	
	//Nome de campos das tabelas utilizadas Massa execucao
	protected static final String CMP_TM_IDMASSA = "int_id_massa";
	protected static final String CMP_TM_IDEXECUCAO = "int_id_execucao";
	protected static final String CMP_TM_TIPOMASSA = "vchar_tipo_massa";
	protected static final String CMP_TM_VALORMASSA = "vchar_valor_massa";
	
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
