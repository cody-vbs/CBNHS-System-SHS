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
public class thread_loadRankings extends SwingWorker<String, Object>{
    long threadDelay = 100;
    long pauseDelay = 500;
    
    private myFunctions my;
    //Main Variables
    JTable grade11Table;
    JTable grade12Table;
    
    String numberOfStudentsToShow;
    String schoolYear;
        
    JButton btnLoadRankings;
    //Dialog Properties
    private JDialog dialog;
    private JFrame jFrameName;
    private JPanel dialogPanel;
    private JLabel lbLoadingMessage;
    private JProgressBar progressBar;

    public thread_loadRankings(JTable [] tablesToUse,String [] stringsToUse,JTextField [] textFieldsToUse,JButton [] buttonsToUse,boolean [] booleansToUse) {
        my = new myFunctions(true);
        
        grade11Table = tablesToUse[0];
        grade12Table = tablesToUse[1];
        
        numberOfStudentsToShow = stringsToUse[0];
        schoolYear = stringsToUse[1];
        
        btnLoadRankings = buttonsToUse[0];
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
        try {
            btnLoadRankings.setEnabled(false);
            
            int studentsToShow = Integer.parseInt(numberOfStudentsToShow);
            my.clear_table_rows(grade11Table);
            my.clear_table_rows(grade12Table);
            
            showCustomDialog("Loading Rankings...", dialogPanel, false, 420, 220, false);
            JTable rankingTables[] = {
                grade11Table,grade12Table,
            };
            
            // ang algo dire di nako ma trace kay way unod ang database
            String [] result = null;
            for(int n=7;n<11;n++){
                progressBar.setMaximum(4);
                progressBar.setValue(n-6);
                lbLoadingMessage.setText("Connecting to Database..."+(n-6)+"/4");
                
                String where =  "WHERE gradeLevel='"+n+"' AND schoolYear='"+schoolYear+
                        "' AND actionTaken='Promoted' AND generalAverage>=75 ORDER BY generalAverage DESC LIMIT 0,"+studentsToShow;
                result = my.return_values("*", "form_sf5_viewfull", where, myVariables.getJhsf5FullOrder());
                
                Thread.sleep(pauseDelay);
                
                if(result != null){
                    int resultCount = result.length;
                    progressBar.setMaximum(resultCount);
                    progressBar.setValue(0);
                    for(int x=0;x<resultCount;x++){
                        lbLoadingMessage.setText("Processing Grade "+n+"...Student "+(x+1)+" of "+resultCount);
                        progressBar.setValue(x+1);
                        
                        result[x] = my.toNameFormat(result[x], new int [] {11,12,13});
                        result[x] = my.toNameFormat(result[x], new int [] {6,7,8});
                        
                        my.add_table_row(result[x], rankingTables[n-7]);
                        
                        Thread.sleep(threadDelay);
                    }
                    
                    //Insert Rankings
                    for(int x=0;x<rankingTables[n-7].getRowCount();x++){
                        try {
                            rankingTables[n-7].setValueAt(x+1, x, 15);
                        } catch (Exception e) {
                        }
                    }
                }
            }
            
            Thread.sleep(pauseDelay);
            return "Finished Sucessfully";
        } catch (InterruptedException e) {
            return "Interrupted By User";
        } catch (Exception x){
            x.printStackTrace();
            return "Error Occured";
        }
    }

    @Override
    protected void done() {
        btnLoadRankings.setEnabled(true);
        closeCustomDialog();
        try {
            System.err.println("Loading Rankings Ended: "+get());
        } catch (Exception e) {
            System.err.println("Error occured at ");
        }
        super.done(); //To change body of generated methods, choose Tools | Templates.
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
