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
public class thread_loadSf9DetailsRevised extends SwingWorker<String, Object>{
    //Main Variables
    JTable sf9Table;
    
    String studentId;
    String sectionId;
    String subjectsContained;
    
    JButton btnLoadGrades;
    JButton btnExportSf9;
    
    boolean enableDisableButtons;
    //Functions Variables
    long threadDelay = 100;
    long pauseDelay = 500;
    private myFunctions my;
    //Dialog Properties
    private JDialog dialog;
    private JFrame jFrameName;
    private JPanel dialogPanel;
    private JLabel lbLoadingMessage;
    private JProgressBar progressBar;

    public thread_loadSf9DetailsRevised(JTable [] tablesToUse,String [] stringsToUse,JTextField [] textFieldsToUse,JButton [] buttonsToUse,boolean [] booleansToUse) {
        //Main Variables
        sf9Table = tablesToUse[0];
        
        studentId = stringsToUse[0];
        sectionId = stringsToUse[1];
        subjectsContained = stringsToUse[2].substring(0,stringsToUse[2].length()-1);
                
        enableDisableButtons = booleansToUse[0];
        
        if(enableDisableButtons){
            btnLoadGrades = buttonsToUse[0];
            btnExportSf9 = buttonsToUse[1];
        }
        
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
        if(enableDisableButtons){
            btnLoadGrades.setEnabled(false);
            btnExportSf9.setEnabled(false);
        }
        
        showCustomDialog("Loading SF9 Details...", dialogPanel, false, 420, 220, false);
        String subjectIds = subjectsContained.replace(":", ",");
        System.err.println("Grade ORDER of IDs: "+subjectIds);
        
        progressBar.setMaximum(2);
        progressBar.setValue(0);
        
        String where = "";
        
        my.clear_table_rows(sf9Table);
        //<editor-fold desc="Load Subjects Only">
        lbLoadingMessage.setText("Connecting to Database...1/2");
        where = "WHERE id IN("+subjectIds+") "
                + "AND subjectCode NOT LIKE'ADV%' "
                + "ORDER BY FIELD(id,"+subjectIds+")";
        String subjectsResult [] = my.return_values("*", "subjects", where, myVariables.getSubjectOrder());
        
        if (subjectsResult == null) {
            System.err.println("No Subjects Contained");
            throw new InterruptedException();
        }
        progressBar.setValue(1);
        Thread.sleep(pauseDelay);
        //</editor-fold>
        //Load Grades
        lbLoadingMessage.setText("Connecting to Database...2/2");
        where = "WHERE sectionId='"+sectionId+"' "
                + "AND studentId='"+studentId+"' "
                + "AND subjectCode NOT LIKE'ADV%' "
                + "ORDER BY FIELD(subjectId,"+subjectIds+")";
        String result [] = my.return_values("*", "form_sf9_view", where, myVariables.getJhsf9Order());
        progressBar.setValue(2);
        Thread.sleep(pauseDelay);
        
        if (result != null) {
            int gradeCount = result.length;
            int subjectCount = subjectsResult.length;
            
            int currSubjectId=-1,foundSubjectId=-1;
                    
            boolean matchFound = false;
            
            progressBar.setMaximum(subjectCount);
            progressBar.setValue(0);
            
            for (int n = 0; n < subjectCount; n++) {
                lbLoadingMessage.setText("Loading Subjects..."+(n+1)+" of "+subjectCount);
                progressBar.setValue(n+1);
                //Find Match Using subjectId
                currSubjectId = Integer.parseInt(my.getValueAtColumn(subjectsResult[n], 0));
                matchFound = false;
                for (int x = 0; x < gradeCount; x++) {
                    foundSubjectId = Integer.parseInt(my.getValueAtColumn(result[x], 3));
                    
                    if(currSubjectId == foundSubjectId){
                        matchFound = true;
                        String temp []= my.getValueAtColumn(result[x], 11).split(":");
                        try {
                            result[x] = my.setValueAtColumn(result[x], 11, temp[4].toUpperCase());
                        } catch (Exception e) {System.err.println("Invalid Status Found");}

                        my.add_table_row(result[x], sf9Table);
                        break;
                    }
                }
                if(!matchFound){
                    String toWrite = "-1@@-1@@-1@@"+my.skipColumns(subjectsResult[n], new int []{3})+" @@ @@ @@ @@ @@INCOMPLETE@@MISSING@@";
                    my.add_table_row(toWrite, sf9Table);
                }
                Thread.sleep(threadDelay);
            }
            //Convert -1 values to blank
            if(!convertNegativeValues(sf9Table)){
                throw new InterruptedException("Interrupted...");
            }
            Thread.sleep(pauseDelay);
        } else {
            //Code Here
            System.err.println("Student ID: "+studentId+" in Section ID: "+sectionId+" has no records.");
        }
        
        if(enableDisableButtons){
            btnExportSf9.setEnabled(true);
        }
        
        return "Task Complete...";
    }

    @Override
    protected void done() {
        if (enableDisableButtons) {
            btnLoadGrades.setEnabled(true);
        }
        closeCustomDialog();
        super.done(); //To change body of generated methods, choose Tools | Templates.
    }
    //Custom Functions
    private boolean convertNegativeValues(JTable tableName){
        int count = tableName.getRowCount();
        
        if(myVariables.isDebugModeOn()){
            return true;
        }
        try {
            for (int n = 0; n < count; n++) {
                //Code Here col 6,7,8,9,10
                for (int x = 6; x < 11; x++) {
                    //Code Here
                    if(tableName.getValueAt(n, x).toString().contains("-1")){
                        tableName.setValueAt(" ", n, x);
                    }
                }
            }
            Thread.sleep(threadDelay);
        }catch(InterruptedException x){
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
        
        return true;
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
