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
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

/**
 *
 * @author Phil Rey Paderogao
 */
public class thread_loadSf10Details extends SwingWorker<String, Object>{
    //Main variables
    JTable studentTable;
    JTable sf10Table;
    JTable [] sectionTables;
    
    JTextField [] tfGeneralAverageFields;
    JTextField [] tfEvaluationFields;
    
    JButton btnExportSf10;
    
    JTabbedPane tpGradeDetailsPane;
    
    //Functions Variables
    long threadDelay = 100;
    long pauseDelay = 500;
    private final myFunctions my;
    //Dialog Properties
    private JDialog dialog;
    private final JFrame jFrameName;
    private final JPanel dialogPanel;
    private final JLabel lbLoadingMessage;
    private final JProgressBar progressBar;

    public thread_loadSf10Details(JTable [] tablesToUse,String [] stringsToUse,
            JTextField [] textFieldsToUse,JButton [] buttonsToUse,
            boolean [] booleansToUse,JTabbedPane [] tabsToUse) {
        //Main variables
        sf10Table = tablesToUse[0];
        sectionTables = new JTable[]{
            tablesToUse[1],
            tablesToUse[2],
            tablesToUse[3],
            tablesToUse[4],
            tablesToUse[5]
        };
        
        tfGeneralAverageFields = new JTextField[]{
            textFieldsToUse[0],
            textFieldsToUse[1],
            textFieldsToUse[2],
            textFieldsToUse[3],
            textFieldsToUse[4],
        };
        tfEvaluationFields = new JTextField[]{
            textFieldsToUse[5],
            textFieldsToUse[6],
            textFieldsToUse[7],
            textFieldsToUse[8],
            textFieldsToUse[9],
        };
        btnExportSf10 = buttonsToUse[0];
        tpGradeDetailsPane = tabsToUse[0];
        //For Loading Screen & Functions
        my = new myFunctions(true);
        
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
        btnExportSf10.setEnabled(false);
        
        try {
            String studentId;
            String sectionId;
            String sectionName;
            String adviserName;
            String subjectsContained;
            String where;

            int [] selectedSections = sf10Table.getSelectedRows();
            int sectionCount = selectedSections.length;
            for (int n = 0; n < sectionCount; n++) {
                showCustomDialog("Loading Permanent Records...", dialogPanel, false, 420, 220, false);
                lbLoadingMessage.setText("Loading Sections..."+(n+1)+" of "+sectionCount);
                progressBar.setMaximum(sectionCount);
                progressBar.setValue(n+1);

                //Prepare Variables for sf9 thread
                studentId = sf10Table.getValueAt(selectedSections[n], 1).toString();
                sectionId = sf10Table.getValueAt(selectedSections[n], 5).toString();
                sectionName = sf10Table.getValueAt(selectedSections[n], 6).toString();
                adviserName = sf10Table.getValueAt(selectedSections[n], 8).toString();
                subjectsContained = sf10Table.getValueAt(selectedSections[n], 13).toString();

                tpGradeDetailsPane.setTitleAt(n, sectionName);
                tpGradeDetailsPane.setSelectedIndex(n);

                Thread.sleep(pauseDelay);
                //<editor-fold desc="Retrieve General Average">
                progressBar.setMaximum(1);
                progressBar.setValue(0);
                lbLoadingMessage.setText("Connecting To Database...");
                where = "WHERE sectionId='"+sectionId+"' AND studentId='"+studentId+"'";
                String result [] = my.return_values("*", "finalgrades",where, myVariables.getFinalGradesOrder());

                if (result != null) {
                    //String id = my.getValueAtColumn(result[0], 0);
                    String gwa = my.getValueAtColumn(result[0], 3);
                    String evaluation = my.getValueAtColumn(result[0].toUpperCase(), 4);
                    //String failedSubjects = my.getValueAtColumn(result[0], 5);
                    //String dateUpdated = my.getValueAtColumn(result[0], 6);

                    tfGeneralAverageFields[n].setText(gwa);
                    tfEvaluationFields[n].setText(evaluation);
                }else{
                    System.err.println("No Final Grades Found.");
                    if(myVariables.isDebugModeOn()){
                        tfGeneralAverageFields[n].setText("MISSING RECORD");
                        tfEvaluationFields[n].setText("MISSING RECORD");
                    }else{
                        tfGeneralAverageFields[n].setText(" ");
                        tfEvaluationFields[n].setText(" ");
                    }
                }
                progressBar.setValue(1);
                Thread.sleep(threadDelay);
                //</editor-fold>
                //Run Sf9 Thead
                my.runSecondaryThread(6, false, 
                        new JTable[]{sectionTables[n]},
                        new String[]{studentId,sectionId,subjectsContained},
                        new JTextField[]{},//new JTextField[]{tfGeneralAverage,tfFailedSubjects,tfEvaluation},
                        new JButton[]{},
                        new boolean[]{false}
                );
                //Wait for SF9 Thread To Finish First
                System.err.println("Waiting for SecondThread to Finish first...");
                while (true) {                
                    if(myFunctions.getSecondThread() == null){
                        break;
                    }else{
                        if(!myFunctions.getSecondThread().isAlive()){
                            break;
                        }
                    }
                    Thread.sleep(0);
                }
                //Resume Thread
                closeCustomDialog();
                Thread.sleep(pauseDelay);
            }
        } catch (InterruptedException e) {
            throw new InterruptedException("SF10 Interrupted By USer");
        }
        btnExportSf10.setEnabled(true);
        return "Task Complete...";
    }

    @Override
    protected void done() {
        closeCustomDialog();
        super.done(); //To change body of generated methods, choose Tools | Templates.
    }
    
    //Dialog Functions
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
