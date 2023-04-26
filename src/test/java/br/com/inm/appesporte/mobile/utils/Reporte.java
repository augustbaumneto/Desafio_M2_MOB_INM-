/**
 * 
 */
package br.com.inm.appesporte.mobile.utils;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.rajatthareja.reportbuilder.Color;
import com.rajatthareja.reportbuilder.ReportBuilder;

/**
 * 
 * Classe responsável por realizar e gerenciar os reportes de execução
 * 
 * @author August Neto
 *
 */
public class Reporte {

    static ReportBuilder reporte = new ReportBuilder();
    
    /**
     * Método que parametriza o reporte
     * @param nomefuncionalidade
     */
    public void criaReporte(String nomefuncionalidade) throws Exception{
    
    	reporte.setReportDirectory("output/");
    
    	reporte.setReportFileName(nomefuncionalidade);
    
    	reporte.setReportTitle("Execução de Teste "+nomefuncionalidade);
    	System.out.println("Teste");
    	reporte.setReportColor(Color.INDIGO);
    	
    	// Add additional info for Report
    	//reporte.setAdditionalInfo("Environment", "My Environment");

    	// Create list or report Files or Directories or URLs or JSONObject or JSONString
    	List<Object> cucumberJsonReports = new ArrayList<>();
    	cucumberJsonReports.add(new File("my/report/path/report.json"));
    	cucumberJsonReports.add(new File("myReportDir/"));
    	cucumberJsonReports.add(new URL("http://myReportUrl/report.json"));
    	cucumberJsonReports.add(new JSONObject("report Json String"));
    
    	reporte.build(cucumberJsonReports);
    	
    }
    
	
	
}
