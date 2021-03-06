/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JasperSoft;

import Controle.ControleFornecedor;
import Modelo.BEAN.Fornecedor;
import java.awt.Desktop;
import java.io.File;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Guilherme
 */
public class ControleJaspersoft {

    static boolean verificaCodigo(int codigo) {
        List<Fornecedor> fornecedores = ControleFornecedor.listarTodos();
        
        for (Fornecedor f : fornecedores) {
            if (f.getCodigo() == codigo){
                return true;
            }
        }
        return false;
    }

    public void gerarRelatorio1() {
        Connection connection = ConnectionFactory.getConnection();
        
        SimpleDateFormat sdt = new SimpleDateFormat("dd-MM-yyyy");
        
        JasperPrint jp = null;
        try {

            String sourceName = "././Reports/GreenBuy1.jasper";
            Map parameters = new HashMap();
            //Image logo = new ImageIcon(getClass().getResource("file:/C:/Users/Guilherme/Documents/NetBeansProjects/GreenBuy_Oficial/src/Visao.icon/cash-register.png")).getImage();
            parameters.put("logo", "file:/C:/Users/Guilherme/Documents/NetBeansProjects/GreenBuy_Oficial/src/Visao.icon/cash-register.png");

            jp = JasperFillManager.fillReport(sourceName, parameters, connection);
            
            JasperExportManager.exportReportToPdfFile(jp, "././Reports/GreenBuy1" + "-" + sdt.format(Calendar.getInstance().getTime()) + ".pdf");
            
            //JasperViewer jv = new JasperViewer(jp, false);
            
            //jv.setVisible(true);
            
            File arquivo = new File("C:\\Users\\Guilherme\\Documents\\NetBeansProjects\\GreenBuy_Oficial\\Reports\\GreenBuy1" + "-" + sdt.format(Calendar.getInstance().getTime()) + ".pdf");
            Desktop.getDesktop().open(arquivo);
        } catch (Exception e) {
            System.out.println("Deu ruim:");
            e.printStackTrace();
        }
    }
    
    public void gerarRelatorio2(Date dInicio, Date dFim) {
        Connection connection = ConnectionFactory.getConnection();
        
        SimpleDateFormat sdt = new SimpleDateFormat("dd-MM-yyyy");
        
        JasperPrint jp = null;
        
        try {

            String sourceName = "././Reports/GreenBuy2.jasper";
            Map parameters = new HashMap();
            parameters.put("logo", "file:/C:/Users/Guilherme/Documents/NetBeansProjects/GreenBuy_Oficial/src/Visao.icon/cash-register.png");
            parameters.put("dataInicio", dInicio);
            parameters.put("dataFim", dFim);
            
            jp = JasperFillManager.fillReport(sourceName, parameters, connection);
            
            JasperExportManager.exportReportToPdfFile(jp, "././Reports/GreenBuy2" + "-" + sdt.format(Calendar.getInstance().getTime()) + ".pdf");
            
            //JasperViewer jv = new JasperViewer(jp, false);
            
            //jv.setVisible(true);
            
            if (jp == null){
                System.out.println("Tá nulo");
            } else {
                System.out.println("Não tá");
            }
            
            File arquivo = new File("C:\\Users\\Guilherme\\Documents\\NetBeansProjects\\GreenBuy_Oficial\\Reports\\GreenBuy2" + "-" + sdt.format(Calendar.getInstance().getTime()) + ".pdf");
            Desktop.getDesktop().open(arquivo);
        } catch (Exception e) {
            System.out.println("Deu ruim:");
            e.printStackTrace();
        }
    }
    
    public void gerarRelatorio3(Date dInicio, Date dFim) {
        Connection connection = ConnectionFactory.getConnection();
        
        SimpleDateFormat sdt = new SimpleDateFormat("dd-MM-yyyy");
        
        JasperPrint jp = null;
        try {

            String sourceName = "././Reports/GreenBuy3.jasper";
            Map parameters = new HashMap();
            parameters.put("logo", "file:/C:/Users/Guilherme/Documents/NetBeansProjects/GreenBuy_Oficial/src/Visao.icon/cash-register.png");
            parameters.put("DataInicio", dInicio);
            parameters.put("DataFim", dFim);
            
            jp = JasperFillManager.fillReport(sourceName, parameters, connection);
            
            JasperExportManager.exportReportToPdfFile(jp, "././Reports/GreenBuy3" + "-" + sdt.format(Calendar.getInstance().getTime()) + ".pdf");
            
            //JasperViewer jv = new JasperViewer(jp, false);
            
            //jv.setVisible(true);
            
            File arquivo = new File("C:\\Users\\Guilherme\\Documents\\NetBeansProjects\\GreenBuy_Oficial\\Reports\\GreenBuy3" + "-" + sdt.format(Calendar.getInstance().getTime()) + ".pdf");
            Desktop.getDesktop().open(arquivo);
        } catch (Exception e) {
            System.out.println("Deu ruim:");
            e.printStackTrace();
        }
    }
    
    public void gerarRelatorio4(int codigo) {
        Connection connection = ConnectionFactory.getConnection();
        
        SimpleDateFormat sdt = new SimpleDateFormat("dd-MM-yyyy");
        
        JasperPrint jp = null;
        try {

            String sourceName = "././Reports/GreenBuy4.jasper";
            Map parameters = new HashMap();
            parameters.put("logo", "file:/C:/Users/Guilherme/Documents/NetBeansProjects/GreenBuy_Oficial/src/Visao.icon/cash-register.png");
            parameters.put("forCodigo", codigo);
            
            jp = JasperFillManager.fillReport(sourceName, parameters, connection);
            
            JasperExportManager.exportReportToPdfFile(jp, "././Reports/GreenBuy4" + "-" + sdt.format(Calendar.getInstance().getTime()) + ".pdf");
            
            //JasperViewer jv = new JasperViewer(jp, false);
            
            //jv.setVisible(true);
            
            File arquivo = new File("C:\\Users\\Guilherme\\Documents\\NetBeansProjects\\GreenBuy_Oficial\\Reports\\GreenBuy4" + "-" + sdt.format(Calendar.getInstance().getTime()) + ".pdf");
            Desktop.getDesktop().open(arquivo);
        } catch (Exception e) {
            System.out.println("Deu ruim:");
            e.printStackTrace();
        }
    }
    
    public void gerarRelatorioTeste() {
        Connection connection = ConnectionFactory.getConnection();
        
        SimpleDateFormat sdt = new SimpleDateFormat("dd-MM-yyyy");
        
        JasperPrint jp = null;
        try {

            String sourceName = "././Reports/GreenBuyTeste.jasper";
            Map parameters = new HashMap();
            parameters.put("logo", "file:/C:/Users/Guilherme/Documents/NetBeansProjects/GreenBuy_Oficial/src/Visao.icon/cash-register.png");
            
            jp = JasperFillManager.fillReport(sourceName, parameters, connection);
            
            JasperExportManager.exportReportToPdfFile(jp, "././Reports/GreenBuyTeste" + "-" + sdt.format(Calendar.getInstance().getTime()) + ".pdf");
            
            //JasperViewer jv = new JasperViewer(jp, false);
            
            //jv.setVisible(true);
            
            File arquivo = new File("C:\\Users\\Guilherme\\Documents\\NetBeansProjects\\GreenBuy_Oficial\\Reports\\GreenBuyTeste" + "-" + sdt.format(Calendar.getInstance().getTime()) + ".pdf");
            Desktop.getDesktop().open(arquivo);
        } catch (Exception e) {
            System.out.println("Deu ruim:");
            e.printStackTrace();
        }
    }
}
