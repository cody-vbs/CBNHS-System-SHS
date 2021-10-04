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
public class thread_loadSf8Details extends SwingWorker<String, Object>{
    long threadDelay = 100;
    long pauseDelay = 500;
    
    private final myFunctions my;
    //Main Variables
    private final JTable sf8Table;
    private final JTable summaryTable;
    
    private final JTextField tfDateOfMeasurement;
    
    private final String sectionId;
    
    private final boolean showStudentsWmissingRecords;
    private final boolean useFirstStudentForDateOfMeasurement;
    
    private final JButton btnLoadStudents;
    private final JButton btnExportSf8;
    
    
    //Dialog Properties
    private JDialog dialog;
    private final JFrame jFrameName;
    private final JPanel dialogPanel;
    private final JLabel lbLoadingMessage;
    private final JProgressBar progressBar;

    public thread_loadSf8Details(JTable [] tablesToUse,String [] stringsToUse,JTextField [] textFieldsToUse,JButton [] buttonsToUse,boolean [] booleansToUse) {
        my = new myFunctions(true);
        
        sf8Table = tablesToUse[0];
        summaryTable = tablesToUse[1];
        
        sectionId = stringsToUse[0];
        
        tfDateOfMeasurement = textFieldsToUse[0];
        
        showStudentsWmissingRecords = booleansToUse[0];
        useFirstStudentForDateOfMeasurement = booleansToUse[1];
        
        btnLoadStudents = buttonsToUse[0];
        btnExportSf8 = buttonsToUse[1];
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
        btnExportSf8.setEnabled(false);
        
        showCustomDialog("Loading Sf8 Details...", dialogPanel, false, 420, 220, false);
        
        //Load Empty Counters
        my.clear_table_rows(sf8Table);
        if(!loadEmptyCounters()){throw new InterruptedException("Failed @ loadiEmptyCounters");}
        
        //Get Values
        lbLoadingMessage.setText("Connecting to Database...");
        String where = "WHERE sectionId='"+sectionId+"'";
        if(!showStudentsWmissingRecords){
            where+=" AND bmiId!='-1'";
        }
        
        String [] result = my.return_values("*", "form_sf8_view",where , myVariables.getJhsf8Order());
        Thread.sleep(pauseDelay);
        if(result != null){
            //Load Results
            int studCount = result.length;
            progressBar.setMaximum(studCount);
            progressBar.setValue(0);
            for(int n=0;n<studCount;n++){
                lbLoadingMessage.setText("Loading Student "+(n+1)+" of "+studCount);
                progressBar.setValue(n+1);
                
                result[n] = my.toNameFormat(result[n], new int []{4,5,6});
                my.add_table_row(result[n], sf8Table);
                Thread.sleep(threadDelay);
            }
            
            if(!countSummary()){throw new InterruptedException("Error @ countSummary()");}
            if(!determineDateOfMeasurement()){throw new InterruptedException("Error @ determineDateOfMeasurement()");}
            btnExportSf8.setEnabled(true);
        }else{
            
        }
        return "Finished";
    }

    @Override
    protected void done() {
        closeCustomDialog();
        btnLoadStudents.setEnabled(true);
        super.done(); //To change body of generated methods, choose Tools | Templates.
    }
    private boolean determineDateOfMeasurement(){
        try {
            int bmiId = 0;
            String dom;
            int studentCount = sf8Table.getRowCount();
            
            if (useFirstStudentForDateOfMeasurement) {
                lbLoadingMessage.setText("Determining Date of Measurement...");
                for (int n = 0; n < studentCount; n++) {
                    bmiId = Integer.parseInt(sf8Table.getValueAt(n, 7).toString());
                    if(bmiId != -1){
                        dom = sf8Table.getValueAt(n, 15).toString().split(" ")[0];  //Get Value,Split into an array, use first index 0
                        String temp [] = dom.split("-");
                        tfDateOfMeasurement.setText(temp[1]+"/"+temp[2]+"/"+temp[0]);
                        return true;
                    }
                    Thread.sleep(0);
                }
            }else{
                //#1. get unique dates
                String uniqueDates = "";
                
                for (int n = 0; n < studentCount; n++) {
                    lbLoadingMessage.setText("Determining Date of Measurement...Finding Unique Dates "+(n+1)+"/"+studentCount);
                    bmiId = Integer.parseInt(sf8Table.getValueAt(n, 7).toString());
                    if(bmiId != -1){
                        dom = sf8Table.getValueAt(n, 15).toString().split(" ")[0];  //Get Value,Split into an array, use first index 0 = yyyy-mm-dd
                        if(!uniqueDates.contains(dom)){
                            uniqueDates += dom+"@@";
                        }
                    }
                    Thread.sleep(0);
                }
                Thread.sleep(pauseDelay);
                //#2. check if there is more than 1 unique date
                String dates [] = uniqueDates.split("@@");
                if(dates.length > 1){
                    String maxDate="";
                    int maxCount=0,currCount;
                    
                    for (int n = 0; n < dates.length; n++) {
                        lbLoadingMessage.setText("Determining Date of Measurement...Finding Most Common Date "+(n+1)+"/"+studentCount);
                        currCount = 0;
                        //#3 Search for instances;
                        for (int x = 0; x < studentCount; x++) {
                            bmiId = Integer.parseInt(sf8Table.getValueAt(x, 7).toString());
                            if(bmiId != -1){
                                dom = sf8Table.getValueAt(x, 15).toString().split(" ")[0];  //Get Value,Split into an array, use first index 0 = yyyy-mm-dd
                                
                                if(dom.equals(dates[n])){
                                    currCount++;
                                }
                            }
                        }
                        
                        //Compare to current max count
                        if(currCount > maxCount){
                            maxDate = dates[n];
                            maxCount = currCount;
                        }
                        Thread.sleep(0);
                    }
                    //#4 Set Value
                    if(maxDate.contains("-")){
                        String temp [] = maxDate.split("-");
                        tfDateOfMeasurement.setText(temp[1]+"/"+temp[2]+"/"+temp[0]);
                    }
                    Thread.sleep(pauseDelay);
                }else{
                    String temp [] = dates[0].split("-");
                    tfDateOfMeasurement.setText(temp[1]+"/"+temp[2]+"/"+temp[0]);
                }
            }
            Thread.sleep(pauseDelay);
            return true;
        } catch(InterruptedException x){
            return false;
        }catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }
    private boolean countSummary(){
        try {
            //lbLoadingMessage.setText("Loading Empty Counters...");
            progressBar.setMaximum(1);
            progressBar.setValue(0);
            
            int studCount = sf8Table.getRowCount();
            int noOfCasesM=0,noOfCasesF=0;
            int sevWastedM=0,sevWastedF=0;
            int wastedM=0,wastedF=0;
            int bmiNormalM=0,bmiNormalF=0;
            int overweightM=0,overweightF=0;
            int obeseM=0,obeseF=0;
            
            int sevStuntedM=0,sevStuntedF=0;
            int stuntedM=0,stuntedF=0;
            int hfaNormalM=0,hfaNormalF=0;
            int tallM=0,tallF=0;
            
            String bmiId="";
            String gender="";
            String nutritionalStatus="";
            String heightForAge="";
            
            for(int n=0;n<studCount;n++){
                lbLoadingMessage.setText("Counting Results... "+(n+1)+" of "+studCount);
                progressBar.setValue(n+1);
                
                bmiId = sf8Table.getValueAt(n, 7).toString();
                
                if(!bmiId.equals("-1")){
                    gender = sf8Table.getValueAt(n, 6).toString();
                    nutritionalStatus = sf8Table.getValueAt(n, 13).toString();
                    heightForAge = sf8Table.getValueAt(n, 14).toString();
                    
                    //<editor-fold desc="Nutritional Status">
                    if(nutritionalStatus.equals("Severely Wasted")){
                        if(gender.equals("Female")){
                            sevWastedF++;
                        }else{
                            sevWastedM++;
                        }
                    }if(nutritionalStatus.equals("Wasted")){
                        if(gender.equals("Female")){
                            wastedF++;
                        }else{
                            wastedM++;
                        }
                    }if(nutritionalStatus.equals("Normal")){
                        if(gender.equals("Female")){
                            bmiNormalF++;
                        }else{
                            bmiNormalM++;
                        }
                    }if(nutritionalStatus.equals("Overweight")){
                        if(gender.equals("Female")){
                            overweightF++;
                        }else{
                            overweightM++;
                        }
                    }if(nutritionalStatus.equals("Obese")){
                        if(gender.equals("Female")){
                            overweightF++;
                        }else{
                            overweightM++;
                        }
                    }
                    //</editor-fold>
                    //<editor-fold desc="Height For Age">
                    if(heightForAge.equals("Severely Stunted")){
                        if(gender.equals("Female")){
                            sevStuntedF++;
                        }else{
                            sevStuntedM++;
                        }
                    }if(heightForAge.equals("Stunted")){
                        if(gender.equals("Female")){
                            stuntedF++;
                        }else{
                            stuntedM++;
                        }
                    }if(heightForAge.equals("Normal")){
                        if(gender.equals("Female")){
                            hfaNormalF++;
                        }else{
                            hfaNormalM++;
                        }
                    }if(heightForAge.equals("Tall")){
                        if(gender.equals("Female")){
                            tallF++;
                        }else{
                            tallM++;
                        }
                    }
                    
                    if(gender.equals("Female")){
                        noOfCasesF++;
                    }else{
                        noOfCasesM++;
                    }
                    //</editor-fold>
                }
                Thread.sleep(threadDelay);
            }
            lbLoadingMessage.setText("Updating Summary Table...");
            //No of Cases
            summaryTable.setValueAt(noOfCasesM, 0, 1);
            summaryTable.setValueAt(noOfCasesF, 0, 2);
            summaryTable.setValueAt(noOfCasesM+noOfCasesF, 0, 3);
            //Severely Wasted
            summaryTable.setValueAt(sevWastedM, 1, 1);
            summaryTable.setValueAt(sevWastedF, 1, 2);
            summaryTable.setValueAt(sevWastedM+sevWastedF, 1, 3);
            //Wasted
            summaryTable.setValueAt(wastedM, 2, 1);
            summaryTable.setValueAt(wastedF, 2, 2);
            summaryTable.setValueAt(wastedM+wastedF, 2, 3);
            //BMI Normal
            summaryTable.setValueAt(bmiNormalM, 3, 1);
            summaryTable.setValueAt(bmiNormalF, 3, 2);
            summaryTable.setValueAt(bmiNormalM+bmiNormalF, 3, 3);
            //Overweight
            summaryTable.setValueAt(overweightM, 4, 1);
            summaryTable.setValueAt(overweightF, 4, 2);
            summaryTable.setValueAt(overweightM+overweightF, 4, 3);
            //Obese
            summaryTable.setValueAt(obeseM, 5, 1);
            summaryTable.setValueAt(obeseF, 5, 2);
            summaryTable.setValueAt(obeseM+obeseF, 5, 3);
            
            //No of Cases
            summaryTable.setValueAt(noOfCasesM, 6, 1);
            summaryTable.setValueAt(noOfCasesF, 6, 2);
            summaryTable.setValueAt(noOfCasesM+noOfCasesF, 6, 3);
            //Severely Stunted
            summaryTable.setValueAt(sevStuntedM, 7, 1);
            summaryTable.setValueAt(sevStuntedF, 7, 2);
            summaryTable.setValueAt(sevStuntedM+sevStuntedF, 7, 3);
            //Stunted
            summaryTable.setValueAt(stuntedM, 8, 1);
            summaryTable.setValueAt(stuntedF, 8, 2);
            summaryTable.setValueAt(stuntedM+stuntedF, 8, 3);
            //HFA Normal
            summaryTable.setValueAt(hfaNormalM, 9, 1);
            summaryTable.setValueAt(hfaNormalF, 9, 2);
            summaryTable.setValueAt(hfaNormalM+hfaNormalF, 9, 3);
            //Tall
            summaryTable.setValueAt(tallM, 10, 1);
            summaryTable.setValueAt(tallF, 10, 2);
            summaryTable.setValueAt(tallM+tallF, 10, 3);
            
            Thread.sleep(pauseDelay);
            return true;
        } catch(InterruptedException x){
            return false;
        }catch (Exception e) {
            return false;
        }
    }
    private boolean loadEmptyCounters(){
        try {
            lbLoadingMessage.setText("Loading Empty Counters...");
            progressBar.setMaximum(1);
            progressBar.setValue(1);
            my.clear_table_rows(summaryTable);
            
            String rows [] = {
                "No. of Cases@@0@@0@@0@@",
                "Severely Wasted@@0@@0@@0@@",
                "Wasted@@0@@0@@0@@",
                "Normal@@0@@0@@0@@",
                "Overweight@@0@@0@@0@@",
                "Obese@@0@@0@@0@@",
                
                "No. of Cases@@0@@0@@0@@",
                "Severely Stunted@@0@@0@@0@@",
                "Stunted@@0@@0@@0@@",
                "Normal@@0@@0@@0@@",
                "Tall@@0@@0@@0@@",
            };
            
            for(int n=0;n<rows.length;n++){
                my.add_table_row(rows[n], summaryTable);
                Thread.sleep(threadDelay);
            }
            
            Thread.sleep(pauseDelay);
            return true;
        }catch(InterruptedException x){
            return false;
        } catch (Exception e) {
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
