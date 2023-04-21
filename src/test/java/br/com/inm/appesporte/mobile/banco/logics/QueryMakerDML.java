/**
 * 
 */
package br.com.inm.appesporte.mobile.banco.logics;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.com.inm.appesporte.mobile.banco.comunicacao.BancoDadosResultadoSelect;

/**
 * Classe responsável por montar querys do tipo DML (manipulação de dados)
 * 
 * @author August Neto
 *
 */
public class QueryMakerDML extends QueryMaker {

	//voltar para provado depois
	public BancoDadosResultadoSelect resultadoselect;
	
	private int idsuite;
	
	/**
	 * Construtor padrão
	 */
	public QueryMakerDML() {
		super();
	}
	
	/**
	 * Excuta uma query do tipo select
	 * @param string, query a ser executada.
	 */
	public void executaQuerySelect(String string) {
		
		resultadoselect = bdeq.executaQueryResultado(string);
	}
	
	/**
	 * Método que retornar o tipo status na segunda linha da tabela
	 * @return A String que representa o valor no local informado
	 */
	public String getTipoStatusID2() {
		String query = montaSelectTipoStatus();
		LOG.queryMontada(query);
		resultadoselect = bdeq.executaQueryResultado(query);
		return (resultadoselect.getResultadoValor(2, CMP_TSNOMETIPOSTATUS)).toString();
		
	}

	/**
	 * Método que insere os dados iniciais da suite no banco de dados
	 * @param datahorainicio
	 */
	public void insereSuiteinicial(LocalDateTime datahorainicio) {
		String query;
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		String valores[] = new String[1];
		valores[0] = "'"+datahorainicio.format(formatador)+"'";
		LOG.mensagemgeral(valores[0]);
		
		String campos[] = new String[1];
		campos[0]= CMP_TSUITE_DATAINICIO;
		
		query =  montaQueryInsert(TB_SUITEEXECUCAO, campos, valores);
		LOG.queryMontada(query);
		bdeq.executaQuery(query);
		
		String query2 = montaQuerySelectUltimaLinhaCriada(TB_SUITEEXECUCAO,CMP_TSUITE_IDSUITE);
		LOG.queryMontada(query2);	
		executaQuerySelect(query2);
		
		idsuite = resultadoselect.getIDPrimeiraLinha();
		LOG.mensagemElementoCriado("ID Suite", idsuite);
	}

	public void atulizaSuite(LocalDateTime datahorafimexecucao) {
		
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String valores[] = new String[1];
		valores[0] = "'"+datahorafimexecucao.format(formatador)+"'";
		LOG.mensagemgeral(valores[0]);
		
		String campos[] = new String[1];
		campos[0]= CMP_TSUITE_DATAFIM;
		
		String query =  montaQueryUpdate(TB_SUITEEXECUCAO, campos, valores, CMP_TSUITE_IDSUITE, idsuite);
		LOG.queryMontada(query);
		bdeq.executaQuery(query);
	}
	/**
	 * Método que monta a query para atualização
	 * @param tabela alvo
	 * @param campos campos que serão atualizados
	 * @param valores valores a serem atualizados
	 * @return A query criada
	 */
	private String montaQueryUpdate(String tabela, String[] nomecampos, String[] valores, String nomecampofiltro, int valorfiltro) {
		String query = "UPDATE "+tabela+ " SET ";
		int numerodecampos = nomecampos.length;
		
		query=query+nomecampos[0] + " = "+valores[0];
		for (int i=1;i<numerodecampos;i=i+1) {
			query = query + ", "+ nomecampos[i] + " = "+valores[i];
		}
		
		query = query+ " WHERE "+nomecampofiltro+ " = " + Integer.toString(valorfiltro)+";";
		
		return query;
	}

	/**
	 * Método que cria a query para select da ultima linha criada.
	 * @return Query da ultima linha criada
	 */
	private String montaQuerySelectUltimaLinhaCriada(String tabela, String campoid) {
		
		return "SELECT * FROM "+tabela+" WHERE "+ campoid +" = (SELECT MAX( "+ campoid+" ) FROM "+tabela +");";
	}
	
	/**
	 * Método que cria a query para inserir dados na tabela.
	 * @param tabela A tabela alvo
	 * @param nomecampos os nome dos campos onde serão inseridos dados 
	 * @param valores os valores a serem inseridos
	 * @return Query pronta de inserir
	 */
	private String montaQueryInsert(String tabela, String[] nomecampos, String[] valores) {
		String query = "INSERT INTO "+tabela+ " (";
		int numerodecampos = nomecampos.length;
		
		query=query+nomecampos[0];
		for (int i=1;i<numerodecampos;i=i+1) {
			query = query + ", "+ nomecampos[i];
		}
		
		query = query+ ") values (";
		
		query=query+valores[0];
		for (int i=1;i<numerodecampos;i=i+1) {
			query = query + ", "+ valores[i];
		}
		
		return query+");";
	}
	
	/**
	 * Monta a query que busca todos os dados da tabela tipo status
	 * @return A query pronta para ser utilizada
	 */
	private String montaSelectTipoStatus() {
		return ("Select * from "+TB_TIPOSTATUS);
	}
	//TODO: implementar os insert e update necessários. implementar as classes resultadoteste.
}
