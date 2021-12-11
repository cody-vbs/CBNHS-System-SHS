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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

/**
 *
 * @author Phil Rey Paderogao
 */
public class thread_loadSf5Details extends SwingWorker<String, Object>{
    long threadDelay = 100;
    long pauseDelay = 500;
    
    private myFunctions my;
    //Main Variables
    JTable sf5Table;
    JTable sf5SummaryTable;
    JTable sf5LevelOfProgress;
    JTable sf6Table;
    JTable rankingTable7;
    JTable rankingTable8;
    JTable rankingTable9;
    JTable rankingTable10;
    
    String sectionId;
    String gradeLevel;
    
    JButton btnLoadStudents;
    JButton btnExport;
    boolean showIncompleteRecords;
    boolean compareToRankings;
    //Dialog Properties
    private JDialog dialog;
    private JFrame jFrameName;
    private JPanel dialogPanel;
    private JLabel lbLoadingMessage;
    private JProgressBar progressBar;

    public thread_loadSf5Details(JTable [] tablesToUse,String [] stringsToUse,JTextField [] textFieldsToUse,JButton [] buttonsToUse,boolean [] booleansToUse) {
        my = new myFunctions(true);
        
        sf5Table = tablesToUse[0];
        sf5SummaryTable = tablesToUse[1];
        sf5LevelOfProgress = tablesToUse[2];
        sf6Table = tablesToUse[3];
        
        rankingTable7 = tablesToUse[4];
        rankingTable8 = tablesToUse[5];
        rankingTable9 = tablesToUse[6];
        rankingTable10 = tablesToUse[7];
        
        sectionId = stringsToUse[0];
        gradeLevel = stringsToUse[1];
        
        btnLoadStudents = buttonsToUse[0];
        btnExport = buttonsToUse[1];
        
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
        try {
            try {
                btnLoadStudents.setEnabled(false);
                btnExport.setEnabled(false);
            } catch (Exception e) {
                System.err.println("No Buttons");
            }
            
            showCustomDialog("Loading Grades...", dialogPanel, false, 420, 220, false);
            my.clear_table_rows(sf5Table);
            my.clear_table_rows(sf5SummaryTable);
            my.clear_table_rows(sf5LevelOfProgress);
            
            if(!loadEmptyCounters()){
                throw new InterruptedException("Interrupted By User");
            }
            
            //Get Students From Database
            lbLoadingMessage.setText("Connecting To Database...");
            String result [] = my.return_values("*", "form_sf5_viewminimal", "WHERE sectionId='"+sectionId+"'", myVariables.getJhsf5MinimalOrder());
            
            if(result==null){
                if(sf6Table == null){
                    my.showMessage("This section's students does not have grades submitted yet.", JOptionPane.ERROR_MESSAGE);
                }
                throw new InterruptedException("No students found");
            }
            Thread.sleep(pauseDelay);
            //Proces & Count Records
            int studCount = result.length;
            int promotedM=0,promotedF=0;
            int conditionalM=0,conditionalF=0;
            int retainedM=0,retainedF=0;
            int incompleteM=0,incompleteF=0;
            
            int male=0;int female=0;
            
            for(int n=0;n<studCount;n++){
                String actionTaken = my.getValueAtColumn(result[n], 11);
                String remarks[] = my.getValueAtColumn(result[n], 9).split("!");
                String gender = my.getValueAtColumn(result[n], 8);
                
                if(actionTaken.contains("Incomplete")){
                    if(showIncompleteRecords){
                        if(gender.contains("Female")){incompleteF++;}
                        else{incompleteM++;}
                    }else{
                        continue;
                    }
                }
                if(remarks[0].startsWith("DRP") || remarks[1].startsWith("DRP")){
                    continue;   //Skip Dropped Student
                }
                
                if(actionTaken.contains("Promoted")){
                    if(gender.contains("Female")){promotedF++;}
                    else{promotedM++;}
                }if(actionTaken.contains("Conditional")){
                    if(gender.contains("Female")){conditionalF++;}
                    else{conditionalM++;}
                }if(actionTaken.contains("Retained")){
                    if(gender.contains("Female")){retainedF++;}
                    else{retainedM++;}
                }
                
                if(gender.contains("Female")){
                    female++;
                }else{
                    male++;
                }
                result[n] = my.toNameFormatFull(result[n], new int [] {5,6,7});
                my.add_table_row(result[n], sf5Table);
                Thread.sleep(threadDelay);
            }
            if(!updateSummaryTable(promotedM, promotedF, conditionalM, conditionalF, retainedM, retainedF, incompleteM, incompleteF)){
                throw new InterruptedException("Interrupted By User");
            }if(!convertGenAverageToWholeNumbers()){
                throw new InterruptedException("Interrupted By User");
            }if(!updateLevelLevelOfProgressTable()){
                throw new InterruptedException("Interrupted By User");
            }if(sf6Table != null){
                if(!sendStatisticsToSf6Table()){throw new InterruptedException("INterrupted By User");}
            }else{
                //Add Counters
                if(!loadCounters()){throw new InterruptedException("INterrupted By User");}
            }
            try {
                btnExport.setEnabled(!showIncompleteRecords);
            } catch (Exception e) {
                
            }
            return "Completed Successfully";
        } catch (InterruptedException e) {
            return "Interrupted By User";
        } catch (Exception x){
            x.printStackTrace();
            return "Error Occured";
        }
    }

    @Override
    protected void done() {
        try {
            System.err.println("SF5 Thread ended: "+get());
        } catch (Exception e) {
        }
        closeCustomDialog();
        try {
            btnLoadStudents.setEnabled(true);
        } catch (Exception e) {
        }
        super.done(); //To change body of generated methods, choose Tools | Templates.
    }
    private boolean loadCounters(){
        try {
            int rowCount = sf5Table.getRowCount();
            progressBar.setValue(0);
            progressBar.setMaximum(rowCount);
            int male=0,female=0,total=0;
            for (int n = 0; n < rowCount; n++) {
                lbLoadingMessage.setText("Counting Students... "+(n+1)+" of "+rowCount);
                progressBar.setValue(n+1);
                
                String gender = sf5Table.getValueAt(n, 6).toString();
                if(gender.equals("Female")){
                    female++;
                }if(gender.equals("Male")){
                    male++;
                }
                total++;
                Thread.sleep(threadDelay);
            }
            
            String maleCount = "--@@--@@--@@--@@"+male+"@@<== TOTAL MALE ==>@@ @@ @@ @@ @@ @@ @@";
            String femaleCount = "--@@--@@--@@--@@"+female+"@@<== TOTAL FEMALE ==>@@ @@ @@ @@ @@ @@ @@";
            String totalCount = "--@@--@@--@@--@@"+total+"@@<== COMBINED TOTAL ==>@@ @@ @@ @@ @@ @@ @@";
            
            my.add_table_row(maleCount, sf5Table);
            my.add_table_row(femaleCount, sf5Table);
            my.add_table_row(totalCount, sf5Table);
            
            return true;
        }catch (InterruptedException x){
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    private boolean sendStatisticsToSf6Table(){
        try {
            progressBar.setMaximum(5);
            progressBar.setValue(0);
            //Get proper Indeces based on grade level
            int countIndeces [] = null;
            switch(Integer.parseInt(gradeLevel)){
                case 7:{
                    countIndeces = new int[]{1,2,3,13,14,15};break;
                }case 8:{
                    countIndeces = new int[]{4,5,6,13,14,15};break;
                }case 9:{
                    countIndeces = new int[]{7,8,9,13,14,15};break;
                }case 10:{
                    countIndeces = new int[]{10,11,12,13,14,15};break;
                }
            }
            progressBar.setValue(1);
            lbLoadingMessage.setText("Updating SF6 Summary... Step 1 of 5");
            Thread.sleep(threadDelay);
            
            //<editor-fold desc="Get Current Values from sf6">
            int currPromotedM = Integer.parseInt(sf6Table.getValueAt(0, countIndeces[0]).toString());
            int currPromotedF = Integer.parseInt(sf6Table.getValueAt(0, countIndeces[1]).toString());
            int currConditionalM = Integer.parseInt(sf6Table.getValueAt(1, countIndeces[0]).toString());
            int currConditionalF = Integer.parseInt(sf6Table.getValueAt(1, countIndeces[1]).toString());
            int currRetainedM = Integer.parseInt(sf6Table.getValueAt(2, countIndeces[0]).toString());
            int currRetainedF = Integer.parseInt(sf6Table.getValueAt(2, countIndeces[1]).toString());
            
            int curr74BelowM = Integer.parseInt(sf6Table.getValueAt(3, countIndeces[0]).toString());
            int curr74BelowF = Integer.parseInt(sf6Table.getValueAt(3, countIndeces[1]).toString());
            
            int curr75to79M = Integer.parseInt(sf6Table.getValueAt(4, countIndeces[0]).toString());
            int curr75to79F = Integer.parseInt(sf6Table.getValueAt(4, countIndeces[1]).toString());
            
            int curr80to84M = Integer.parseInt(sf6Table.getValueAt(5, countIndeces[0]).toString());
            int curr80to84F = Integer.parseInt(sf6Table.getValueAt(5, countIndeces[1]).toString());
            
            int curr85to89M = Integer.parseInt(sf6Table.getValueAt(6, countIndeces[0]).toString());
            int curr85to89F = Integer.parseInt(sf6Table.getValueAt(6, countIndeces[1]).toString());
            
            int curr90to100M = Integer.parseInt(sf6Table.getValueAt(7, countIndeces[0]).toString());
            int curr90to100F = Integer.parseInt(sf6Table.getValueAt(7, countIndeces[1]).toString());
            progressBar.setValue(2);
            lbLoadingMessage.setText("Updating SF6 Summary... Step 2 of 5");
            Thread.sleep(threadDelay);
            //</editor-fold>
            //<editor-fold desc="Get values from Sf5 tables">
            int sPromotedM = Integer.parseInt(sf5SummaryTable.getValueAt(0, 1).toString());
            int sPromotedF = Integer.parseInt(sf5SummaryTable.getValueAt(0, 2).toString());
            int sConditionalM = Integer.parseInt(sf5SummaryTable.getValueAt(1, 1).toString());
            int sConditionalF = Integer.parseInt(sf5SummaryTable.getValueAt(1, 2).toString());
            int sRetainedM = Integer.parseInt(sf5SummaryTable.getValueAt(2, 1).toString());
            int sRetainedF = Integer.parseInt(sf5SummaryTable.getValueAt(2, 2).toString());
            
            int s74BelowM = Integer.parseInt(sf5LevelOfProgress.getValueAt(0, 1).toString());
            int s74BelowF = Integer.parseInt(sf5LevelOfProgress.getValueAt(0, 2).toString());
            
            int s75to79M = Integer.parseInt(sf5LevelOfProgress.getValueAt(1, 1).toString());
            int s75to79F = Integer.parseInt(sf5LevelOfProgress.getValueAt(1, 2).toString());
            
            int s80to84M = Integer.parseInt(sf5LevelOfProgress.getValueAt(2, 1).toString());
            int s80to84F = Integer.parseInt(sf5LevelOfProgress.getValueAt(2, 2).toString());
            
            int s85to89M = Integer.parseInt(sf5LevelOfProgress.getValueAt(3, 1).toString());
            int s85to89F = Integer.parseInt(sf5LevelOfProgress.getValueAt(3, 2).toString());
            
            int s90to100M = Integer.parseInt(sf5LevelOfProgress.getValueAt(4, 1).toString());
            int s90to100F = Integer.parseInt(sf5LevelOfProgress.getValueAt(4, 2).toString());
            
            progressBar.setValue(3);
            lbLoadingMessage.setText("Updating SF6 Summary... Step 3 of 5");
            Thread.sleep(threadDelay);
            //</editor-fold>
            //<editor-fold desc="Set new Values">
            //Promoted
            sf6Table.setValueAt(currPromotedM+sPromotedM, 0, countIndeces[0]);
            sf6Table.setValueAt(currPromotedF+sPromotedF, 0, countIndeces[1]);
            sf6Table.setValueAt(currPromotedM+sPromotedM+currPromotedF+sPromotedF, 0, countIndeces[2]);
            //Conditional
            sf6Table.setValueAt(currConditionalM+sConditionalM, 1, countIndeces[0]);
            sf6Table.setValueAt(currConditionalF+sConditionalF, 1, countIndeces[1]);
            sf6Table.setValueAt(currConditionalM+sConditionalM+currConditionalF+sConditionalF, 1, countIndeces[2]);
            //Retained
            sf6Table.setValueAt(currRetainedM+sRetainedM, 2, countIndeces[0]);
            sf6Table.setValueAt(currRetainedF+sRetainedF, 2, countIndeces[1]);
            sf6Table.setValueAt(currRetainedM+sRetainedM+currRetainedF+sRetainedF, 2, countIndeces[2]);
            //Below 74
            sf6Table.setValueAt(curr74BelowM+s74BelowM, 3, countIndeces[0]);
            sf6Table.setValueAt(curr74BelowF+s74BelowF, 3, countIndeces[1]);
            sf6Table.setValueAt(curr74BelowM+s74BelowM+curr74BelowF+s74BelowF, 3, countIndeces[2]);
            //75 - 79
            sf6Table.setValueAt(curr75to79M+s75to79M, 4, countIndeces[0]);
            sf6Table.setValueAt(curr75to79F+s75to79F, 4, countIndeces[1]);
            sf6Table.setValueAt(curr75to79M+s75to79M+curr75to79F+s75to79F, 4, countIndeces[2]);
            //80 - 84
            sf6Table.setValueAt(curr80to84M+s80to84M, 5, countIndeces[0]);
            sf6Table.setValueAt(curr80to84F+s80to84F, 5, countIndeces[1]);
            sf6Table.setValueAt(curr80to84M+s80to84M+curr80to84F+s80to84F, 5, countIndeces[2]);
            //85 - 89
            sf6Table.setValueAt(curr85to89M+s85to89M, 6, countIndeces[0]);
            sf6Table.setValueAt(curr85to89F+s85to89F, 6, countIndeces[1]);
            sf6Table.setValueAt(curr85to89M+s85to89M+curr85to89F+s85to89F, 6, countIndeces[2]);
            //90 - 100
            sf6Table.setValueAt(curr90to100M+s90to100M, 7, countIndeces[0]);
            sf6Table.setValueAt(curr90to100F+s90to100F, 7, countIndeces[1]);
            sf6Table.setValueAt(curr90to100M+s90to100M+curr90to100F+s90to100F, 7, countIndeces[2]);
            //Total
            sf6Table.setValueAt(
                    currPromotedM+sPromotedM+currConditionalM+sConditionalM+currRetainedM+sRetainedM,
                    8, countIndeces[0]
            );
            sf6Table.setValueAt(
                    currPromotedF+sPromotedF+currConditionalF+sConditionalF+currRetainedF+sRetainedF,
                    8, countIndeces[1]
            );
            sf6Table.setValueAt(
                    currPromotedM+sPromotedM+currPromotedF+sPromotedF+
                    currConditionalM+sConditionalM+currConditionalF+sConditionalF+
                    currRetainedM+sRetainedM+currRetainedF+sRetainedF,
                    8, countIndeces[2]
            );
            progressBar.setValue(4);
            lbLoadingMessage.setText("Updating SF6 Summary... Step 4 of 5");
            Thread.sleep(threadDelay);
            //</editor-fold>
            //<editor-fold desc="Add All Rows By Gender">
            int male = 0,female = 0;
            int currMale = 0, currFemale = 0;
            int [] maleIndeces = {1,4,7,10};
            int [] femaleIndeces = {2,5,8,11};
            int [] totalIndeces = {3,6,9,12};
            for(int n=0;n<9;n++){   //Loop Rows
                male=0;female=0;
                for(int x=0;x<sf6Table.getColumnCount();x++){   //Loop Columns
                    for(int y=0;y<4;y++){   //Loop Indeces
                        if(x==maleIndeces[y]){
                            male+=Integer.parseInt(sf6Table.getValueAt(n, x).toString());
                            break;
                        }if(x==femaleIndeces[y]){
                            female+=Integer.parseInt(sf6Table.getValueAt(n, x).toString());
                            break;
                        }
                    }
                }
                //Update final counters
                currMale = Integer.parseInt(sf6Table.getValueAt(n, 13).toString());
                currFemale = Integer.parseInt(sf6Table.getValueAt(n, 14).toString());
                
                sf6Table.setValueAt(currMale+male, n, 13);
                sf6Table.setValueAt(currFemale+female, n, 14);
                sf6Table.setValueAt(currMale+male+currFemale+female, n, 15);
            }
            progressBar.setValue(5);
            lbLoadingMessage.setText("Updating SF6 Summary... Step 5 of 5");
            Thread.sleep(threadDelay);
            //</editor-fold>
            
            Thread.sleep(pauseDelay);
            return true;
        } catch(InterruptedException x){
            System.err.println("Interrupted @ sendStatisticsToSf6Table");
            return false;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    private boolean updateLevelLevelOfProgressTable(){
        try {
            int studCount = sf5Table.getRowCount();
            progressBar.setMaximum(studCount);
            progressBar.setValue(0);
            
            lbLoadingMessage.setText("Updating Level of Progress...");
            Thread.sleep(pauseDelay);
            
            String gender="";
            float generalAverage=0f;
            int below74M = 0,below74F = 0;
            int in75to79M = 0,in75to79F = 0;
            int in80to84M = 0,in80to84F = 0;
            int in85to89M = 0,in85to89F = 0;
            int in90to100M = 0,in90to100F = 0;
            
            for(int n=0;n<studCount;n++){
                lbLoadingMessage.setText("Updating Level of Progress..."+(n+1)+" of "+studCount);
                progressBar.setValue(n+1);
                
                gender = sf5Table.getValueAt(n, 6).toString();
                generalAverage = Float.parseFloat(sf5Table.getValueAt(n, 8).toString());
                
                if(generalAverage <= 74){
                    if(gender.contains("Female")){below74F++;}
                    else{below74M++;}
                }if(generalAverage > 74 && generalAverage <= 79){
                    if(gender.contains("Female")){in75to79F++;}
                    else{in75to79M++;}
                }if(generalAverage > 79 && generalAverage <= 84){
                    if(gender.contains("Female")){in80to84F++;}
                    else{in80to84M++;}
                }if(generalAverage > 84 && generalAverage <= 89){
                    if(gender.contains("Female")){in85to89F++;}
                    else{in85to89M++;}
                }if(generalAverage > 89 && generalAverage <= 100){
                    if(gender.contains("Female")){in90to100F++;}
                    else{in90to100M++;}
                }
                
                Thread.sleep(threadDelay);
            }
            //Update Level of Progress Table
            int currBelow74M = Integer.parseInt(sf5LevelOfProgress.getValueAt(0, 1).toString());
            int currBelow74F = Integer.parseInt(sf5LevelOfProgress.getValueAt(0, 2).toString());
            
            int curr75to79M = Integer.parseInt(sf5LevelOfProgress.getValueAt(1, 1).toString());
            int curr75to79F = Integer.parseInt(sf5LevelOfProgress.getValueAt(1, 2).toString());
            
            int curr80to84M = Integer.parseInt(sf5LevelOfProgress.getValueAt(2, 1).toString());
            int curr80to84F = Integer.parseInt(sf5LevelOfProgress.getValueAt(2, 2).toString());
            
            int curr85to89M = Integer.parseInt(sf5LevelOfProgress.getValueAt(3, 1).toString());
            int curr85to89F = Integer.parseInt(sf5LevelOfProgress.getValueAt(3, 2).toString());
            
            int curr90to100M = Integer.parseInt(sf5LevelOfProgress.getValueAt(4, 1).toString());
            int curr90to100F = Integer.parseInt(sf5LevelOfProgress.getValueAt(4, 2).toString());
            
            //Below 74
            sf5LevelOfProgress.setValueAt(below74M+currBelow74M, 0, 1);
            sf5LevelOfProgress.setValueAt(below74F+currBelow74F, 0, 2);
            sf5LevelOfProgress.setValueAt(below74M+currBelow74M+below74F+currBelow74F, 0, 3);
            //75 - 79
            sf5LevelOfProgress.setValueAt(in75to79M+curr75to79M, 1, 1);
            sf5LevelOfProgress.setValueAt(in75to79F+curr75to79F, 1, 2);
            sf5LevelOfProgress.setValueAt(in75to79M+curr75to79M+in75to79F+curr75to79F, 1, 3);
            //80 - 84
            sf5LevelOfProgress.setValueAt(in80to84M+curr80to84M, 2, 1);
            sf5LevelOfProgress.setValueAt(in80to84F+curr80to84F, 2, 2);
            sf5LevelOfProgress.setValueAt(in80to84M+curr80to84M+in80to84F+curr80to84F, 2, 3);
            //85 - 89
            sf5LevelOfProgress.setValueAt(in85to89M+curr85to89M, 3, 1);
            sf5LevelOfProgress.setValueAt(in85to89F+curr85to89F, 3, 2);
            sf5LevelOfProgress.setValueAt(in85to89M+curr85to89M+in85to89F+curr85to89F, 3, 3);
            //90 - 100
            sf5LevelOfProgress.setValueAt(in90to100M+curr90to100M, 4, 1);
            sf5LevelOfProgress.setValueAt(in90to100F+curr90to100F, 4, 2);
            sf5LevelOfProgress.setValueAt(in90to100M+curr90to100M+in90to100F+curr90to100F, 4, 3);
            
            Thread.sleep(pauseDelay);
            return true;
        } catch(InterruptedException x){
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    private boolean updateSummaryTable(int promotedM,int promotedF,int conditionalM,int conditionalF,int retainedM,int retainedF,int incompleteM,int incompleteF){
        try {
            lbLoadingMessage.setText("Updating Summary Table...");
            //Update summary table
            int currPromotedM = Integer.parseInt(sf5SummaryTable.getValueAt(0, 1).toString());
            int currPromotedF = Integer.parseInt(sf5SummaryTable.getValueAt(0, 2).toString());
            int currConditionalM = Integer.parseInt(sf5SummaryTable.getValueAt(1, 1).toString());
            int currConditionalF = Integer.parseInt(sf5SummaryTable.getValueAt(1, 2).toString());
            int currRetainedM = Integer.parseInt(sf5SummaryTable.getValueAt(2, 1).toString());
            int currRetainedF = Integer.parseInt(sf5SummaryTable.getValueAt(2, 2).toString());
            int currIncM = 0,currIncF = 0;
            
            if(showIncompleteRecords){
                currIncM = Integer.parseInt(sf5SummaryTable.getValueAt(3, 1).toString());
                currIncF = Integer.parseInt(sf5SummaryTable.getValueAt(3, 2).toString());
            }
            //Promoted
            sf5SummaryTable.setValueAt(promotedM+currPromotedM, 0, 1);
            sf5SummaryTable.setValueAt(promotedF+currPromotedF, 0, 2);
            sf5SummaryTable.setValueAt(promotedM+currPromotedM+promotedF+currPromotedF, 0, 3);
            //Conditional
            sf5SummaryTable.setValueAt(conditionalM+currConditionalM, 1, 1);
            sf5SummaryTable.setValueAt(conditionalF+currConditionalF, 1, 2);
            sf5SummaryTable.setValueAt(conditionalM+currConditionalM+conditionalF+currConditionalF, 1, 3);
            //Retained
            sf5SummaryTable.setValueAt(retainedM+currRetainedM, 2, 1);
            sf5SummaryTable.setValueAt(retainedF+currRetainedF, 2, 2);
            sf5SummaryTable.setValueAt(retainedM+currRetainedM+retainedF+currRetainedF, 2, 3);
            if(showIncompleteRecords){
                sf5SummaryTable.setValueAt(incompleteM+currIncM, 3, 1);
                sf5SummaryTable.setValueAt(incompleteF+currIncF, 3, 2);
                sf5SummaryTable.setValueAt(incompleteM+currIncM+incompleteF+currIncF, 3, 3);
            }
            
            Thread.sleep(pauseDelay);
            return true;
        } catch (InterruptedException e) {
            return false;
        } catch (Exception x){
            System.err.println("Error Occured:");
            x.printStackTrace();
            return false;
        }
    }
    private boolean convertGenAverageToWholeNumbers(){
        try {
            int studCount = sf5Table.getRowCount();
            lbLoadingMessage.setText("Converting General Averages...");
            progressBar.setMaximum(studCount);
            progressBar.setValue(0);
            Thread.sleep(pauseDelay);
            
            for(int n=0;n<studCount;n++){
                lbLoadingMessage.setText("Processing Students..."+(n+1)+" of "+studCount);
                progressBar.setValue(n+1);
                
                int gradeLevel = Integer.parseInt(sf5Table.getValueAt(n, 2).toString());
                int studentId = Integer.parseInt(sf5Table.getValueAt(n, 3).toString());
                float generalAverage = Float.parseFloat(sf5Table.getValueAt(n, 8).toString());
                
                if(compareToRankings){
                    if(!compareToRankings(n,studentId, gradeLevel, generalAverage)){
                        throw new InterruptedException("Interrupted By User @ compareToRankings");
                    }
                }else{
                    sf5Table.setValueAt(String.valueOf((int)generalAverage), n, 8);
                }
                Thread.sleep(threadDelay);
            }
            Thread.sleep(pauseDelay);
            return true;
        } catch (InterruptedException e) {
            return false;
        } catch (Exception x){
            x.printStackTrace();
            return false;
        }
    }
    private boolean compareToRankings(int rowIndex,int studentId,int gradeLevel,float generalAverage){
        try {
            lbLoadingMessage.setText("Comparing Student To Rankings...");
            
            JTable tableToUse = null;
            switch(gradeLevel){
                case 7:{
                    tableToUse = rankingTable7;
                    break;
                }case 8:{
                    tableToUse = rankingTable8;
                    break;
                }case 9:{
                    tableToUse = rankingTable9;
                    break;
                }case 10:{
                    tableToUse = rankingTable10;
                    break;
                }
            }
            if(generalAverage >= 75){
                boolean matchFound = false;
                if(tableToUse.getRowCount() > 0){
                    for(int n=0;n<tableToUse.getRowCount();n++){
                        int rankingStudentId = Integer.parseInt(tableToUse.getValueAt(n, 7).toString());
                        if(studentId == rankingStudentId){
                            matchFound = true;
                            break;
                        }
                    }
                }
                
                if(matchFound){
                    sf5Table.setValueAt(String.valueOf(generalAverage), rowIndex, 8);
                }else{
                    sf5Table.setValueAt(String.valueOf((int)generalAverage), rowIndex, 8);
                }
            }else{
                sf5Table.setValueAt(String.valueOf((int)generalAverage), rowIndex, 8);
            }
            
            
            Thread.sleep(pauseDelay);
            return true;
        } catch(InterruptedException x){
            x.printStackTrace();
            return false;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    private boolean loadEmptyCounters(){
        try {
            lbLoadingMessage.setText("Loading Empty Counters...");
            String summaries [] = null;
            if(showIncompleteRecords){
                summaries = new String []{
                    "Promoted@@0@@0@@0@@",
                    "Conditional@@0@@0@@0@@",
                    "Retained@@0@@0@@0@@",
                    "Incomplete@@0@@0@@0@@",
                };
            }else{
                summaries = new String []{
                    "Promoted@@0@@0@@0@@",
                    "Conditional@@0@@0@@0@@",
                    "Retained@@0@@0@@0@@",
                };
            }
            String levelOfPrgrs [] = {
                "74 Below@@0@@0@@0@@",
                "75 - 79@@0@@0@@0@@",
                "80 - 84@@0@@0@@0@@",
                "85 - 89@@0@@0@@0@@",
                "90 - 100@@0@@0@@0@@"
            };
            for(int n=0;n<summaries.length;n++){
                my.add_table_row(summaries[n], sf5SummaryTable);
            }
            for(int n=0;n<levelOfPrgrs.length;n++){
                my.add_table_row(levelOfPrgrs[n], sf5LevelOfProgress);
            }
            Thread.sleep(pauseDelay);
            return true;
        } catch (Exception e) {
            System.err.println("Interrupted @ loadEmptyCounters");
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
