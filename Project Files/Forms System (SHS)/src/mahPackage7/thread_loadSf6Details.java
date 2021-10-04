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
        sectionsTable = tablesToUse[8];
        
        waitForSecondThreadToFinish = booleansToUse[2];
        allSectionSelected = booleansToUse[3];
        
        btnLoadStudents = buttonsToUse[0];
        btnExportSf6 = buttonsToUse[1];
        
        //Sf5 Variables
        sf5Table = tablesToUse[0];
        sf5SummaryTable = tablesToUse[1];
        sf5LevelOfProgress = tablesToUse[2];
        sf6Table = tablesToUse[3];
        
        rankingTable7 = tablesToUse[4];
        rankingTable8 = tablesToUse[5];
        rankingTable9 = tablesToUse[6];
        rankingTable10 = tablesToUse[7];
        
        showIncompleteRecords = booleansToUse[0];
        compareToRankings = booleansToUse[1];
        
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
        
        //Prepare Section IDs
        for(int n=0;n<sectionCount;n++){
            showCustomDialog("Loading Sf6 Details...", dialogPanel, false, 420, 220, false);
            progressBar.setMaximum(sectionCount);
            progressBar.setValue(n+1);
            lbLoadingMessage.setText("Loading Sections... "+(n+1)+" of "+sectionCount);
            
            sectionId = sectionsTable.getValueAt(allSectionSelected? n : selectedSections[n], 1).toString();
            gradeLevel = sectionsTable.getValueAt(allSectionSelected? n : selectedSections[n], 9).toString();
            
            Thread.sleep(pauseDelay);
            my.runSecondaryThread(3, false, 
                    new JTable[]{sf5Table,sf5SummaryTable,sf5LevelOfProgress,sf6Table,rankingTable7,rankingTable8,rankingTable9,rankingTable10}, 
                    new String[]{sectionId,gradeLevel}, 
                    new JTextField[]{},
                    new JButton[]{null,null},
                    new boolean[]{showIncompleteRecords,compareToRankings}
            );
            
            if(waitForSecondThreadToFinish){
                System.err.println("Waiting for SecondThread to Finish first...");
                while (true) {                
                    if(myFunctions.getSecondThread() == null){
                        break;
                    }else{
                        if(!myFunctions.getSecondThread().isAlive()){
                            break;
                        }
                    }
                }
            }
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
                lbLoadingMessage.setText("Loading Empty Counters... "+(n+1)+" of "+counters.length);
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
