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

	private BancoDadosResultadoSelect resultadoselect;
	
	private int idsuite;
	private int idteste;
	
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
		LOG.mensagemElementoCriado("Horário Inicio execução da Suite: ", valores[0]);
		
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

	/**
	 * Método que atualiza a suite com os dados do fim da execução
	 * @param datahorafimexecucao data do fim da execução da suite
	 */
	public void atualizaSuite(LocalDateTime datahorafimexecucao) {
		
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String valores[] = new String[1];
		valores[0] = "'"+datahorafimexecucao.format(formatador)+"'";
		LOG.mensagemElementoCriado("Horário Fim execução Suite: ", valores[0]);
		
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

	/**
	 * Método que insere os dados iniciais do teste
	 * @param datahorainicio
	 */
	public void insereTeste(LocalDateTime datahorainicio,String nomecenario) {
		String query;
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		String valores[] = new String[3];
		valores[0] = Integer.toString(idsuite);
		valores[1] = "'"+nomecenario+"'";
		valores[2] = "'"+datahorainicio.format(formatador)+"'";
		
		LOG.testeExecucao(valores[1]);
		LOG.mensagemElementoCriado("Horário Inicio execução do Teste: ", valores[2]);
		
		String campos[] = new String[3];
		campos[0]= CMP_TRE_IDSUITE;
		campos[1]= CMP_TRE_NOMECENARIO;
		campos[2]= CMP_TRE_DATAINICIO;
		
		query =  montaQueryInsert(TB_RESULTADOEXECUCAO, campos, valores);
		LOG.queryMontada(query);
		bdeq.executaQuery(query);
		
		String query2 = montaQuerySelectUltimaLinhaCriada(TB_RESULTADOEXECUCAO,CMP_TRE_IDEXECUCAO);
		LOG.queryMontada(query2);	
		executaQuerySelect(query2);
		
		idteste = resultadoselect.getIDPrimeiraLinha();
		LOG.mensagemElementoCriado("ID Teste", idteste);	
	}
	
	/**
	 * Método que atualiza o teste
	 * @param fim data fim da execução dos testes
	 * @param status resultado do teste
	 */
	public void atualizaTeste(LocalDateTime fim, String status) {
		atualizaTeste(fim,status,"");		
	}

	/**
	 * Método que atualiza quando é teste tipo esquema
	 * @param fim data fim do teste
	 * @param status status do teste
	 * @param esquema o esquema do teste
	 */
	public void atualizaTeste(LocalDateTime fim, String status, String esquema) {
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String valores[] = new String[4];
		valores[0] = "'"+fim.format(formatador)+"'";
		switch(status) {
			case "PASSED":
				valores[1]="'Passou'";
				break;
			case "FAILED":
				valores[1]="'Falhou'";
				break;
			default:
				valores[1]="'Erro'";
		}
		if (esquema.equals("")) {
			valores[2] = "'padrão'";
			valores[3] = "'N/A'";
		}else {
			valores[2] = "'esquema'";
			valores[3] = "'"+esquema+"'";
		}
		
		
		LOG.mensagemElementoCriado("Resultado do Teste: ", valores[1]);
		LOG.mensagemElementoCriado("Horário Fim execução Teste: ", valores[0]);
		
		String campos[] = new String[4];
		campos[0]= CMP_TRE_DATAFIM;
		campos[1]= CMP_TRE_RESULTADO;
		campos[2]= CMP_TRE_TIPOCENARIO;
		campos[3]= CMP_TRE_EXEMPLOCENARIO;
		
		String query =  montaQueryUpdate(TB_RESULTADOEXECUCAO, campos, valores, CMP_TRE_IDEXECUCAO, idteste);
		LOG.queryMontada(query);
		bdeq.executaQuery(query);
		
	}

	/**
	 * Método responsável por incluir a massa na base de dados
	 * @param tipo tipo da massa a ser gravado
	 * @param valor Valor da massa
	 */
	public void insereMassa(String tipo, String valor) {
		String valores[] = new String[3];
		valores[0]=Integer.toString(idsuite);
		valores[1]="'"+tipo+"'";
		valores[2]="'"+valor+"'";
		
		String campos[] = new String[3];
		campos[0]= CMP_TM_IDEXECUCAO;
		campos[1]= CMP_TM_TIPOMASSA;
		campos[2]= CMP_TM_VALORMASSA;
		
		LOG.mensagemGeral("Massa de Teste tipo: "+ valores[1]);
		LOG.mensagemGeral("Massa de Teste valor: "+ valores[2]);
		
		String query =  montaQueryInsert(TB_MASSAEXECUCAO, campos, valores);
		LOG.queryMontada(query);
		bdeq.executaQuery(query);
	}

	/**
	 * Método responsável por incluir o arquivos na suite
	 * @param dados do arquivo
	 */
	public void atualizaSuiteLog(byte[] dados) {
		String valores[] = new String[1];
		valores[0] = "?";
		
		String campos[] = new String[1];
		campos[0]= CMP_TSUITE_LOG;
		
		String query =  montaQueryUpdate(TB_SUITEEXECUCAO, campos, valores, CMP_TSUITE_IDSUITE, idsuite);
		System.out.println(query);
		LOG.queryMontada(query);
		bdeq.executaQuerySobeArquivo(query, dados);
		
	}
}
