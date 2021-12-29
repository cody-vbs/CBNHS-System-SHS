/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mahPackage7;

import java.awt.Dialog;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

/**
 *
 * @author Phil Rey Paderogao
 */
public class thread_loadSf6Details extends SwingWorker<String, Object>{
    long threadDelay = 100;
    long pauseDelay = 500;
    
    private myFunctions my;
    //Main Variables
    private boolean waitForSecondThreadToFinish;
    private JTable sectionsTable;
    private boolean allSectionSelected;
    
    private JButton btnLoadStudents;
    private JButton btnExportSf6;
    
    private String sectionId;
    
    //Sf5 Variables
    JTable sf5Table;
    JTable sf5SummaryTable;
    JTable sf5LevelOfProgress;
    JTable sf6Table;
    JTable rankingTable7;
    JTable rankingTable8;
    JTable rankingTable9;
    JTable rankingTable10;
    
    boolean showIncompleteRecords;
    boolean compareToRankings;
    
    //Dialog Properties
    private JDialog dialog;
    private JFrame jFrameName;
    private JPanel dialogPanel;
    private JLabel lbLoadingMessage;
    private JProgressBar progressBar;

    public thread_loadSf6Details(JTable [] tablesToUse,String [] stringsToUse,JTextField [] textFieldsToUse,JButton [] buttonsToUse,boolean [] booleansToUse) {
        my = new myFunctions(true);
        sectionsTable = tablesToUse[6];
        
        waitForSecondThreadToFinish = booleansToUse[1];
        allSectionSelected = booleansToUse[2];
        
        btnLoadStudents = buttonsToUse[0];
        btnExportSf6 = buttonsToUse[1];
        
        //Sf5 Variables
        sf5Table = tablesToUse[0];
        sf5SummaryTable = tablesToUse[1];
        sf5LevelOfProgress = tablesToUse[2];
        sf6Table = tablesToUse[3];
        
        rankingTable7 = tablesToUse[4];
        rankingTable8 = tablesToUse[5];
        
        
        showIncompleteRecords = booleansToUse[0];
        
        //For Loading Screen
        jFrameName = myVariables.getCurrentLoadingFrame();
        dialogPanel = myVariables.getLoadingPanel();
        lbLoadingMessage = myVariables.getLbLoadingMessage();
        progressBar = myVariables.getProgressBar();
        
        //For thead Speed
        long [] threadSpeeds = myVariables.getProcessingSpeedValue();
        threadDelay = threadSpeeds[0];
        pauseDelay = threadSpeeds[1];
    }
    
    @Override
    protected String doInBackground() throws Exception {
        btnLoadStudents.setEnabled(false);
        btnExportSf6.setEnabled(false);
        
        showCustomDialog("Loading Sf6 Details...", dialogPanel, false, 420, 220, false);
        //Prepare section Counts
        int sectionCount = 0;
        int selectedSections [];
        String gradeLevel = "";

        if(allSectionSelected){
            selectedSections = null;
            sectionCount = sectionsTable.getRowCount();
        }else{
            selectedSections = sectionsTable.getSelectedRows();
            sectionCount = selectedSections.length;
        }
        System.err.println("Section Length :"+sectionCount);
        
        //Load Empty Counters
        if(!loadEmptyCounters()){throw new InterruptedException("Interrupted By User");}
        
        //values
        int g11Mp = 0;
        int g11Fp = 0;
        int g11Tp = 0;
        int g11Mc = 0;
        int g11Fc = 0;
        int g11Tc = 0;
        int g11Mr = 0;
        int g11Fr = 0;
        int g11Tr = 0;
        int g11M74b = 0;
        int g11F74b = 0;
        int g11T74b = 0;
        int g11M7579 = 0;
        int g11F7579 = 0;
        int g11T7579 = 0;
        int g11M8084 = 0;
        int g11F8084 = 0;
        int g11T8084 = 0;
        int g11M8589 = 0;
        int g11F8589 = 0;
        int g11T8589 = 0;
        int g11M90100 = 0;
        int g11F90100 = 0;
        int g11T90100 = 0;
        
        int g12Mp = 0;
        int g12Fp = 0;
        int g12Tp = 0;
        int g12Mc = 0;
        int g12Fc = 0;
        int g12Tc = 0;
        int g12Mr = 0;
        int g12Fr = 0;
        int g12Tr = 0;
        int g12M74b = 0;
        int g12F74b = 0;
        int g12T74b = 0;
        int g12M7579 = 0;
        int g12F7579 = 0;
        int g12T7579 = 0;
        int g12M8084 = 0;
        int g12F8084 = 0;
        int g12T8084 = 0;
        int g12M8589 = 0;
        int g12F8589 = 0;
        int g12T8589 = 0;
        int g12M90100 = 0;
        int g12F90100 = 0;
        int g12T90100 = 0;
        
        int maleTp = 0;
        int femaleTp = 0;
        int totalP = 0;
        int maleTc = 0;
        int femaleTc = 0;
        int totalC = 0;
        int maleTr = 0;
        int femaleTr = 0;
        int totalR = 0;
        int maleT74b = 0;
        int femaleT74b = 0;
        int total74b = 0;
        int maleT7579 = 0;
        int femaleT7579 = 0;
        int total7579 = 0;
        int maleT8084 = 0;
        int femaleT8084 = 0;
        int total8084 = 0;
        int maleT8589 = 0;
        int femaleT8589 = 0;
        int total8589 = 0;
        int maleT90100 = 0;
        int femaleT90100 = 0;
        int total90100 = 0;
        
        //Prepare Section IDs
        for(int n=0;n<sectionCount;n++){
            showCustomDialog("Loading Sf6 Details...", dialogPanel, false, 420, 220, false);
            progressBar.setMaximum(sectionCount);
            progressBar.setValue(n+1);
            lbLoadingMessage.setText("Loading Sections... "+(n+1)+" of "+sectionCount);
            
            sectionId = sectionsTable.getValueAt(allSectionSelected? n : selectedSections[n], 1).toString();
            gradeLevel = sectionsTable.getValueAt(allSectionSelected? n : selectedSections[n], 9).toString();
            System.err.println("Section ID: "+sectionId+" Grade: "+gradeLevel);
            
            String where = "where sectionId='"+sectionId+"'"; 
            String result [] = my.return_values("*", "form_sf5_viewminimal_shs", where, myVariables.getShsf5MinimalOrder());
            int studCount = result.length;
            
            for(int x=0;x<studCount;x++){
                lbLoadingMessage.setText("Loading Student... "+(x+1)+" of "+sectionCount);
                int grade = Integer.parseInt(my.getValueAtColumn(result[x], 10));
                int glevel = Integer.parseInt(my.getValueAtColumn(result[x], 2));
                String status = my.getValueAtColumn(result[x], 11);
                if("Incomplete".equals(status)){
                    if(showIncompleteRecords){
                        //do nothing lol
                    }
                    else{
                        continue;
                    }
                }
                String gender = my.getValueAtColumn(result[x], 8);
                if(status.contains("Promoted")){
                    if(gender.contains("Female")){
                        if(11 == glevel){
                            g11Fp++;
                        }if(12 == glevel){
                            g12Fp++;
                        }
                    }else{
                        if(11 == glevel){
                            g11Mp++;
                        }if(12 == glevel){
                            g12Mp++;
                        }
                    }
                }if(status.contains("Conditional")){
                    if(gender.contains("Female")){
                        if(11 == glevel){
                            g11Fc++;
                        }if(12 == glevel){
                            g12Fc++;
                        }
                    }else{
                        if(11 == glevel){
                            g11Mc++;
                        }if(12 == glevel){
                            g12Mc++;
                        }
                    }
                }if(status.contains("Retained")){
                    if(gender.contains("Female")){
                        if(11 == glevel){
                            g11Fr++;
                        }if(12 == glevel){
                            g12Fr++;
                        }
                    }else{
                        if(11 == glevel){
                            g11Mr++;
                        }if(12 == glevel){
                            g12Mr++;
                        }
                    }
                }
                if(grade <= 74){
                    if(gender.contains("Female")){
                        if(11 == glevel){
                            g11F74b++;
                        }if(12 == glevel){
                            g12F74b++;
                        }
                    }else{
                        if(11 == glevel){
                            g11M74b++;
                        }if(12 == glevel){
                            g12M74b++;
                        }
                    }
                }if(grade > 74 && grade <= 79){
                    if(gender.contains("Female")){
                        if(11 == glevel){
                            g11F7579++;
                        }if(12 == glevel){
                            g12F7579++;
                        }
                    }else{
                        if(11 == glevel){
                            g11M7579++;
                        }if(12 == glevel){
                            g12M7579++;
                        }
                    }
                }if(grade > 79 && grade <= 84){
                    if(gender.contains("Female")){
                        if(11 == glevel){
                            g11F8084++;
                        }if(12 == glevel){
                            g12F8084++;
                        }
                    }else{
                        if(11 == glevel){
                            g11M8084++;
                        }if(12 == glevel){
                            g12M8084++;
                        }
                    }
                }if(grade > 84 && grade <= 89){
                    if(gender.contains("Female")){
                        if(11 == glevel){
                            g11F8589++;
                        }if(12 == glevel){
                            g12F8589++;
                        }
                    }else{
                        if(11 == glevel){
                            g11M8589++;
                        }if(12 == glevel){
                            g12M8589++;
                        }
                    }
                }if(grade > 89 && grade <= 100){
                    if(gender.contains("Female")){
                        if(11 == glevel){
                            g11F90100++;
                        }if(12 == glevel){
                            g12F90100++;
                        }
                    }else{
                        if(11 == glevel){
                            g11M90100++;
                        }if(12 == glevel){
                            g12M90100++;
                        }
                    }
                }
            }
        }
        
        //add nato dre
        g11Tp = g11Mp+g11Fp;
        g11Tc = g11Mc+g11Fc;
        g11Tr = g11Mr+g11Fr;
        g11T74b = g11M74b+g11F74b;
        g11T7579 = g11M7579+g11F7579;
        g11T8084 = g11M8084+g11F8084;
        g11T8589 = g11M8589+g11F8589;
        g11T90100 = g11M90100+g11M90100;
        g12Tp = g12Mp+g12Fp;
        g12Tc = g12Mc+g12Fc;
        g12Tr = g12Mr+g12Fr;
        g12T74b = g12M74b+g12F74b;
        g12T7579 = g12M7579+g12F7579;
        g12T8084 = g12M8084+g12F8084;
        g12T8589 = g12M8589+g12F8589;
        g12T90100 = g12M90100+g12M90100;
        maleTp = g11Mp+g12Mp;
        femaleTp = g11Fp+g12Fp;
        totalP = maleTp+femaleTp;
        maleTc = g11Mc+g12Mc;
        femaleTc = g11Fc+g12Fc;
        totalC = maleTc+femaleTc;
        maleTr = g11Mr+g12Mr;
        femaleTr = g11Fr+g12Fr;
        totalR = maleTr+femaleTr;
        maleT74b = g11M74b+g12M74b;
        femaleT74b = g11F74b+g12F74b;
        total74b = maleT74b+femaleT74b;
        maleT7579 = g11M7579+g12M7579;
        femaleT7579 = g11F7579+g12F7579;
        total7579 = maleT7579+femaleT7579;
        maleT8084 = g11M8084+g12M8084;
        femaleT8084 = g11F8084+g12F8084;
        total8084 = maleT8084+femaleT8084;
        maleT8589 = g11M8589+g12M8589;
        femaleT8589 = g11F8589+g12F8589;
        total8589 = maleT8589+femaleT8589;
        maleT90100 = g11M90100+g12M90100;
        femaleT90100 = g11F90100+g12F90100;
        total90100 = maleT90100+femaleT90100;
        
        //algo to output values to sf6table
        my.clear_table_rows(sf6Table);
        String [] counters = {
                "PROMOTED@@"+g11Mp+"@@"+g11Fp+"@@"+g11Tp+"@@"+g12Mp+"@@"+g12Fp+"@@"+g11Tp+"@@"+maleTp+"@@"+femaleTp+"@@"+totalP+"@@",
                "CONDITIONAL@@"+g11Mc+"@@"+g11Fc+"@@"+g11Tc+"@@"+g12Mc+"@@"+g12Fc+"@@"+g11Tc+"@@"+maleTc+"@@"+femaleTc+"@@"+totalC+"@@",
                "RETAINED@@"+g11Mr+"@@"+g11Fr+"@@"+g11Tr+"@@"+g12Mr+"@@"+g12Fr+"@@"+g11Tr+"@@"+maleTr+"@@"+femaleTr+"@@"+totalR+"@@",
                "Below 74@@"+g11M74b+"@@"+g11F74b+"@@"+g11T74b+"@@"+g12M74b+"@@"+g12F74b+"@@"+g12T74b+"@@"+maleT74b+"@@"+femaleT74b+"@@"+total74b+"@@",
                "75 - 79@@"+g11M7579+"@@"+g11F7579+"@@"+g11T7579+"@@"+g12M7579+"@@"+g12F7579+"@@"+g12T7579+"@@"+maleT7579+"@@"+femaleT7579+"@@"+total7579+"@@",
                "80 - 84@@"+g11M8084+"@@"+g11F8084+"@@"+g11T8084+"@@"+g12M8084+"@@"+g12F8084+"@@"+g12T8084+"@@"+maleT8084+"@@"+femaleT8084+"@@"+total8084+"@@",
                "85 - 89@@"+g11M8589+"@@"+g11F8589+"@@"+g11T8589+"@@"+g12M8589+"@@"+g12F8589+"@@"+g12T8589+"@@"+maleT8589+"@@"+femaleT8589+"@@"+total8589+"@@",
                "90 - 100@@"+g11M90100+"@@"+g11F90100+"@@"+g11T90100+"@@"+g12M90100+"@@"+g12F90100+"@@"+g12T90100+"@@"+maleT90100+"@@"+femaleT90100+"@@"+total90100+"@@",
                "TOTAL@@0@@0@@0@@0@@0@@0@@0@@0@@0@@0@@0@@0@@0@@0@@0@@",
        };
        
        for(int n=0;n<counters.length;n++){
            lbLoadingMessage.setText("Loading Counters... "+(n+1)+" of "+counters.length);
                progressBar.setValue(n+1);
            my.add_table_row(counters[n], sf6Table);
        }
        
        btnExportSf6.setEnabled(true);
        return "Finished Successfully";
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void done() {
        btnLoadStudents.setEnabled(true);
        closeCustomDialog();
        super.done(); //To change body of generated methods, choose Tools | Templates.
    }
    private boolean loadEmptyCounters(){
        try {
            my.clear_table_rows(sf6Table);
            
            String [] counters = {
                "PROMOTED@@0@@0@@0@@0@@0@@0@@0@@0@@0@@0@@0@@0@@0@@0@@0@@",
                "CONDITIONAL@@0@@0@@0@@0@@0@@0@@0@@0@@0@@0@@0@@0@@0@@0@@0@@",
                "RETAINED@@0@@0@@0@@0@@0@@0@@0@@0@@0@@0@@0@@0@@0@@0@@0@@",
                "Below 74@@0@@0@@0@@0@@0@@0@@0@@0@@0@@0@@0@@0@@0@@0@@0@@",
                "75 - 79@@0@@0@@0@@0@@0@@0@@0@@0@@0@@0@@0@@0@@0@@0@@0@@",
                "80 - 84@@0@@0@@0@@0@@0@@0@@0@@0@@0@@0@@0@@0@@0@@0@@0@@",
                "85 - 89@@0@@0@@0@@0@@0@@0@@0@@0@@0@@0@@0@@0@@0@@0@@0@@",
                "90 - 100@@0@@0@@0@@0@@0@@0@@0@@0@@0@@0@@0@@0@@0@@0@@0@@",
                "TOTAL@@0@@0@@0@@0@@0@@0@@0@@0@@0@@0@@0@@0@@0@@0@@0@@",
            };
            progressBar.setMaximum(counters.length);
            progressBar.setValue(0);
            
            for(int n=0;n<counters.length;n++){
                lbLoadingMessage.setText("Loading Counters... "+(n+1)+" of "+counters.length);
                progressBar.setValue(n+1);
                
                my.add_table_row(counters[n], sf6Table);
                Thread.sleep(threadDelay);
            }
            Thread.sleep(pauseDelay);
            return true;
        } catch (InterruptedException e) {
            System.err.println("Interrupted @ loadEmpty Counters");
            return false;
        } catch (Exception x){
            x.printStackTrace();
            return false;
        }
    }
    private void showCustomDialog(String title, JPanel customPanel, boolean isModal, int width, int height, boolean isResizable){
        if(dialog != null && dialog.isVisible()){
            dialog.setSize(width, height);
            dialog.setTitle(title);
            dialog.add(customPanel);
            dialog.setLocationRelativeTo(jFrameName);
            System.err.println("Sf4 Dialog is already visible. Skipping...");
            return;
        }
        dialog = new JDialog(jFrameName);
        dialog.setTitle(title);
        dialog.add(customPanel);
        dialog.setModal(isModal);
        dialog.setModalityType(Dialog.ModalityType.MODELESS);
        dialog.setSize(width, height);
        dialog.setResizable(isResizable);
        dialog.setUndecorated(true);
        
        dialog.setLocationRelativeTo(jFrameName);
        dialog.setVisible(true);
    }
    private void closeCustomDialog(){
        if(dialog != null){
            dialog.dispose();
        }else{
            System.err.println("Dialog is null...skipping");
        }
    }
}
