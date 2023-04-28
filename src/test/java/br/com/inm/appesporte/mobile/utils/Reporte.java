/**
 * 
 */
package br.com.inm.appesporte.mobile.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.rajatthareja.reportbuilder.Color;
import com.rajatthareja.reportbuilder.ReportBuilder;

import br.com.inm.appesporte.mobile.config.ParametrosConfig;

/**
 * 
 * Classe responsável por realizar e gerenciar os reportes de execução
 * 
 * @author August Neto
 *
 */
public class Reporte {

    private static ReportBuilder reporte = new ReportBuilder();
    
    private static final Log LOG = new Log();
    
    /**
     * Método que parametriza e cria o reporte
     */
    public void criaReporte() {
    
    	LOG.mensagemGeral("Configurando o reporte...");
    	
    	reporte.setReportDirectory(ParametrosConfig.getCaminhoReportBuilder());
    
    	reporte.setReportFileName("reporte_execucao_rbuilder");
    
    	reporte.setReportTitle("Reporte de Execução");
   
    	reporte.setReportColor(Color.INDIGO);
    	
    	// Add additional info for Report
    	//reporte.setAdditionalInfo("Environment", "My Environment");

    	List<Object> cucumberJsonReports = new ArrayList<>();
    	
    	File arquivo = new File(ParametrosConfig.getCaminhoJson());
    	File[] listaarquivos = arquivo.listFiles();
    	
    	for (File tmp : listaarquivos) {
    		cucumberJsonReports.add(tmp);
    	}
    	
    	//cucumberJsonReports.add(new File("my/report/path/report.json"));
    	//cucumberJsonReports.add(new File("myReportDir/"));
    	//cucumberJsonReports.add(new URL("http://myReportUrl/report.json"));
    	//cucumberJsonReports.add(new JSONObject("report Json String"));
    
    	reporte.build(cucumberJsonReports);
    }
    
	
	
}
