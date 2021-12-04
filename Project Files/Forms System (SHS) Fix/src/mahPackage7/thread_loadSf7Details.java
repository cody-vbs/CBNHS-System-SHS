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
public class thread_loadSf7Details extends SwingWorker<String, Object>{
    //Main Variables
    JTable teachersTable;
    JTable loadsTable;
    
    String schoolYear;
    
    JButton btnLoadTeachers;
    JButton btnExportSf7;
    
    boolean removeUnassignedTeachers;
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

    public thread_loadSf7Details(JTable [] tablesToUse,String [] stringsToUse,JTextField [] textFieldsToUse,JButton [] buttonsToUse,boolean [] booleansToUse) {
        teachersTable = tablesToUse[0];
        loadsTable = tablesToUse[1];
        
        schoolYear = stringsToUse[0];
        
        btnLoadTeachers = buttonsToUse[0];
        btnExportSf7 = buttonsToUse[1];
        
        removeUnassignedTeachers = booleansToUse[0];
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
        btnLoadTeachers.setEnabled(false);
        btnExportSf7.setEnabled(false);
        
        showCustomDialog("Loading Teachers...", dialogPanel, false, 420, 220, true);
        
        //<editor-fold desc="Load Teachers">
        progressBar.setMaximum(2);
        progressBar.setValue(0);
        lbLoadingMessage.setText("Connecting to Database...1/2");
        
        my.clear_table_rows(teachersTable);
        String where = "";
        if(myVariables.getAccessLevel() == 5){
            where = "";
        }else{
            where = "WHERE user_level<5";
        }
        String [] result = my.return_values("*", "form_sf7view_teachers", where, myVariables.getJhsf7TeachersOrder());
        progressBar.setValue(1);
        Thread.sleep(pauseDelay);
        if(result != null){
            int teacherCount = result.length;
            progressBar.setMaximum(teacherCount);
            progressBar.setValue(0);
            for (int n = 0; n < teacherCount; n++) {
                lbLoadingMessage.setText("Loading Teacher..."+(n+1)+" of "+teacherCount);
                progressBar.setValue(n+1);
                
                result[n] = my.toNameFormat(result[n], new int []{2,3,4});
                
                my.add_table_row(result[n], teachersTable);
                
                Thread.sleep(threadDelay);
            }
            Thread.sleep(pauseDelay);
            
            //<editor-fold desc="Load Teacher Loads">
            String userId="";
            my.clear_table_rows(loadsTable);
            
            for (int n = 0; n < teacherCount; n++) {
                lbLoadingMessage.setText("Loading Subjects...Teacher "+(n+1)+"/"+teacherCount+" Connecting to Database");
                progressBar.setValue(n+1);
                
                userId = teachersTable.getValueAt(n, 0).toString();
                where = "WHERE teacherId='"+userId+"' AND schoolYear='"+schoolYear+"'";
                String loadsResult[] = my.return_values("*", "form_sf7view_loads", where, myVariables.getJhsf7LoadsOrder());
                
                Thread.sleep(threadDelay);
                
                if(loadsResult != null){
                    int subjectCount = loadsResult.length;
                    progressBar.setMaximum(subjectCount);
                    progressBar.setValue(0);
                    for (int x = 0; x < subjectCount; x++) {
                        lbLoadingMessage.setText("Loading Subjects...Teacher "+(n+1)+"/"+teacherCount+" Subject "+(x+1)+" of "+subjectCount);
                        progressBar.setValue(x+1);
                        
                        my.add_table_row(loadsResult[x], loadsTable);
                        Thread.sleep(threadDelay);
                    }
                }
                
                Thread.sleep(threadDelay);
            }
            //</editor-fold>
            if (removeUnassignedTeachers) {
                if(!removeUnassignedTeachers()){throw new InterruptedException("Removing Teachers Failed...");}
            }
            
            btnExportSf7.setEnabled(true);
        }else{
            
        }
        //</editor-fold>
        return "Task complete...";
    }

    @Override
    protected void done() {
        btnLoadTeachers.setEnabled(true);
        closeCustomDialog();
        super.done(); //To change body of generated methods, choose Tools | Templates.
    }
    
    private boolean removeUnassignedTeachers(){
        try {
            int teacherCount = teachersTable.getRowCount();
            int subjectsCount = loadsTable.getRowCount();
            int currTeacherId,resultTeacherId;
            boolean matchFound;
            
            progressBar.setMaximum(teacherCount);
            progressBar.setValue(0);
            for (int n = teacherCount-1; n >= 0; n--) {
                lbLoadingMessage.setText("Removing Unassigned Teachers..."+(teacherCount-n)+" of "+teacherCount);
                progressBar.setValue(teacherCount-n);
                matchFound = false;
                try {
                    currTeacherId = Integer.parseInt(teachersTable.getValueAt(n, 0).toString());
                } catch (Exception e) {currTeacherId = -1;}
                
                for (int x = 0; x < subjectsCount; x++) {
                    lbLoadingMessage.setText("Removing Unassigned Teachers..."+(teacherCount-n)+" of "+teacherCount+" Subject "+(x+1)+"/"+subjectsCount);
                    resultTeacherId = Integer.parseInt(loadsTable.getValueAt(x, 1).toString());
                    if(currTeacherId == resultTeacherId){
                        matchFound = true;break;
                    }
                    Thread.sleep(threadDelay);
                }
                if(!matchFound){
                    my.remove_table_row(teachersTable, n);
                }
                Thread.sleep(threadDelay);
            }
            
            Thread.sleep(threadDelay);
            return true;
        } catch(InterruptedException x){
            return false;
        }catch (Exception e) {
            e.printStackTrace();
            return true;
        }
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
