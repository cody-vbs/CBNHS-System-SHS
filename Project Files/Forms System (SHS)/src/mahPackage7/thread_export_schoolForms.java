/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mahPackage7;

import java.awt.Color;
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
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;

/**
 *
 * @author Phil Rey Paderogao
 */
public class thread_export_schoolForms extends SwingWorker<Object, Object>{
    //<editor-fold desc="IMPORTANT VARIABLES">
    //Main Variables
    private header[] headers;
        //SF1
        private JTable sf1Table;
        private String maleCount;
        private String femaleCount;
        private String totalCount;
        //SF2
        private JTable sf2WeekdaysTable;
        private JTable sf2Table;
        private JTable sf2SummaryTable;
        private String sf2MonthSelected;
        private String sf2SchoolDays;
        //SF3
        private JTable sf3Table;
        private JTable sf3BooksTable;
        //SF4
        private String sf4MonthSelected;
        private JTable sf4Table;
        //SF5
        private JTable sf5Table;
        private JTable sf5SummaryTable;
        private JTable sf5LevelOfProgressTable;
        private String sf5Curriculum;
        //SF6
        private JTable sf6Table;
        //SF7
        private JTable sf7Table;
        private JTable sf7AssignedSubjectsTable;
        private boolean useSubjectCodeAsSubjectName;
        private boolean useAcronyms;
        //SF8
        private JTable sf8Table;
        private JTable sf8SummaryTable;
        private String dateOfMeasurement;
        //SF9
        private JTable sf9GradesTable;
        private String sf9GeneralAverage;
        private String sf9FailedSubjects;
        private String sf9Remarks;
        
        private String lrn;
        private String studentName;
        private String gender;
        private String age;
        //SF10
        private String firstName;
        private String middleName;
        private String lastName;
        private String extentionName;
        private String birthDate;
        
        private String elemSchoolName;
        private String elemSchoolAddress;
        private String elemShoolId;
        private String elemGeneralAverage;
        private String generalAverages [];
        private String evaluations [];
        
        private JTable sf10Table;
        private JTable [] sf10GradeTables;
    //Global Variables
    private String sectionName;
    private String adviserName;
    private String gradeLevel;
    private String schoolYear;
    private JButton btnExport;
    
    private String schoolId;
    private String region;
    private String division;
    private String district;
    private String schoolName;
    private String principalName;
    private String representativeName;
    private String superIntendentName;
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
    //</editor-fold>   
    
    public thread_export_schoolForms(JTable [] tablesToUse,String [] stringsToUse,JTextField [] textFieldsToUse,JButton [] buttonsToUse,boolean [] booleansToUse) {
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
        
        //Main Variables
        btnExport = buttonsToUse[0];
        
        schoolId = myVariables.getSchoolId();
        region = myVariables.getRegion();
        division = myVariables.getDivision();
        district = myVariables.getDistrict();
        schoolName = myVariables.getSchoolName();
        
        principalName = myVariables.getPrincipal().toUpperCase();
        representativeName = myVariables.getDivisionRepresentative().toUpperCase();
        superIntendentName = myVariables.getDivisionSuperintendent().toUpperCase();
        
        assignTablesByForm(tablesToUse,stringsToUse,textFieldsToUse,booleansToUse);
    }
    //<editor-fold desc="Constructor Functions">
    private void assignTablesByForm(JTable [] tables,String [] stringsToUse,JTextField [] textFieldsToUse, boolean [] booleans){
        switch(myVariables.getFormSelected()){
            case 1:{
                //Global Variables
                sectionName = my.getSectionNameOnly(textFieldsToUse[0].getText(), true);
                adviserName = textFieldsToUse[1].getText().toUpperCase();
                gradeLevel = textFieldsToUse[2].getText();
                schoolYear = textFieldsToUse[3].getText();
                //SF1 Variables
                sf1Table = tables[0];
                maleCount = textFieldsToUse[4].getText();
                femaleCount = textFieldsToUse[5].getText();
                totalCount = textFieldsToUse[6].getText();
                break;
            }case 2:{
                //Global Variables
                sectionName = my.getSectionNameOnly(textFieldsToUse[0].getText(), true);
                adviserName = textFieldsToUse[1].getText().toUpperCase();
                gradeLevel = textFieldsToUse[2].getText();
                schoolYear = textFieldsToUse[3].getText();
                //SF2 Variables
                sf2WeekdaysTable = tables[0];
                sf2Table = tables[1];
                sf2SummaryTable = tables[2];
                sf2MonthSelected = stringsToUse[0].toUpperCase();
                sf2SchoolDays = textFieldsToUse[4].getText();
                break;
            }case 3:{
                //Global Variables
                sectionName = my.getSectionNameOnly(textFieldsToUse[0].getText(), true);
                adviserName = textFieldsToUse[1].getText().toUpperCase();
                gradeLevel = textFieldsToUse[2].getText();
                schoolYear = textFieldsToUse[3].getText();
                //SF3 Variables
                sf3Table = tables[0];
                sf3BooksTable = tables[1];
                break;
            }case 4:{
                //Global Variables
                schoolYear = textFieldsToUse[0].getText();
                //SF4 Variables
                sf4Table = tables[0];
                sf4MonthSelected = stringsToUse[0].toUpperCase();
                break;
            }case 5:{
                //Global Variables
                sectionName = my.getSectionNameOnly(textFieldsToUse[0].getText(), true);
                adviserName = textFieldsToUse[1].getText().toUpperCase();
                gradeLevel = textFieldsToUse[2].getText();
                schoolYear = textFieldsToUse[3].getText();
                //SF5 Variables
                sf5Curriculum = my.getCurriculumNameOnly(textFieldsToUse[4].getText(), ",", 0, true);
                
                sf5Table = tables[0];
                sf5SummaryTable = tables[1];
                sf5LevelOfProgressTable = tables[2];
                break;
            }case 6:{
                //Global Variables
                schoolYear = textFieldsToUse[0].getText();
                //SF6 Variables
                sf6Table = tables[0];
                break;
            }case 7:{
                //Global Variables
                schoolYear = stringsToUse[0];
                //Sf7 Variables
                sf7Table = tables[0];
                sf7AssignedSubjectsTable = tables[1];
                useSubjectCodeAsSubjectName = booleans[0];
                useAcronyms = booleans[1];
                break;
            }case 8:{
                //Global Variables
                sectionName = my.getSectionNameOnly(textFieldsToUse[0].getText(), true);
                adviserName = textFieldsToUse[1].getText().toUpperCase();
                gradeLevel = textFieldsToUse[2].getText();
                schoolYear = textFieldsToUse[3].getText();
                //SF3 Variables
                dateOfMeasurement = textFieldsToUse[4].getText();
                sf8Table = tables[0];
                sf8SummaryTable = tables[1];
                break;
            }case 9:{
                //Global Variables
                sectionName = my.getSectionNameOnly(textFieldsToUse[0].getText(), true);
                adviserName = textFieldsToUse[1].getText().toUpperCase();
                
                gradeLevel = textFieldsToUse[2].getText();
                gradeLevel = gradeLevel.toLowerCase().replace("grade", " ").trim();
                
                schoolYear = textFieldsToUse[3].getText();
                //SF9 Variables
                sf9GeneralAverage = textFieldsToUse[4].getText();
                sf9FailedSubjects = textFieldsToUse[5].getText();
                sf9Remarks = textFieldsToUse[6].getText();
                
                sf9GradesTable = tables[0];
                
                lrn = stringsToUse[0];
                studentName = stringsToUse[1].toUpperCase();
                gender = stringsToUse[2];
                age = stringsToUse[3];
                break;
            }case 10:{
                //Global Variables
                firstName = textFieldsToUse[0].getText().toUpperCase();
                middleName = textFieldsToUse[1].getText().toUpperCase();
                lastName = textFieldsToUse[2].getText().toUpperCase();
                extentionName = textFieldsToUse[3].getText();
                birthDate = textFieldsToUse[4].getText();
                gender = textFieldsToUse[5].getText().toUpperCase();
                lrn = textFieldsToUse[6].getText();
                elemSchoolName = textFieldsToUse[7].getText().toUpperCase();
                elemSchoolAddress = textFieldsToUse[8].getText().toUpperCase();
                elemShoolId = textFieldsToUse[9].getText();
                elemGeneralAverage = textFieldsToUse[10].getText();
                //SF9 Variables
                generalAverages = new String [] {
                    textFieldsToUse[11].getText(),
                    textFieldsToUse[12].getText(),
                    textFieldsToUse[13].getText(),
                    textFieldsToUse[14].getText(),
                    textFieldsToUse[15].getText()
                };
                evaluations = new String [] {
                    textFieldsToUse[16].getText().toUpperCase(),
                    textFieldsToUse[17].getText().toUpperCase(),
                    textFieldsToUse[18].getText().toUpperCase(),
                    textFieldsToUse[19].getText().toUpperCase(),
                    textFieldsToUse[20].getText().toUpperCase(),
                };
                
                sf10Table = tables[0];
                sf10GradeTables = new JTable[] {
                    tables[1],tables[2],tables[3],tables[4],tables[5]
                };
                break;
            }default:{
                System.err.println("No Form Selected");
                break;
            }
        }
    }
    //</editor-fold>
    
    @Override
    protected Object doInBackground() throws Exception {
        btnExport.setEnabled(false);
        
        //<editor-fold desc="Show Dialogs">
        showCustomDialog("Exporting to Excel File", dialogPanel, false, 420, 220, false);
        lbLoadingMessage.setText("Creating File...1/5");
        progressBar.setMaximum(5);
        progressBar.setValue(0);
        //</editor-fold>
        
        //<editor-fold desc="#1 Create File & Determine which sheet to use">
        if(!my.createExcelFile(getFileName(true))){
            my.showMessage("There was an error Creating the file.\nPlease Make Sure the template exists inside the Templates folder.", JOptionPane.ERROR_MESSAGE);
            throw new InterruptedException("Reading Failed");
        }
        int sheetNumber = getSheetNumberToUse();
        progressBar.setValue(1);
        Thread.sleep(pauseDelay);
        //</editor-fold>
        
        //<editor-fold desc="#2 Write Headers">
        lbLoadingMessage.setText("Writing Headers...2/5");
        progressBar.setValue(2);
        if(!loadHeaders(sheetNumber)){throw new InterruptedException("Loading Headers Failed...");}
        if(!writeHeaders(sheetNumber)){throw new InterruptedException("Writing Headers Failed...");}
        //</editor-fold>
        
        //<editor-fold desc="#3 Write Tables">
        lbLoadingMessage.setText("Writing Tables...3/5");
        progressBar.setValue(3);
        if(!writeTables(sheetNumber)){throw new InterruptedException("Writing Tables Failed...");}
        Thread.sleep(pauseDelay);
        //</editor-fold>
        
        //<editor-fold desc="#4 Remove Extra Sheets">
        progressBar.setMaximum(5);
        lbLoadingMessage.setText("Removing Extra Sheets...4/5");
        if(myVariables.getFormSelected() != 10 && myVariables.getFormSelected() != 9){
            my.keepOneSheetOnly(sheetNumber);
        }else{
            switch(myVariables.getFormSelected()){
                case 9:{
                    my.removeSheetsAt(new int [] {2});
                    break;
                }case 10:{
                    my.removeSheetsAt(new int [] {2,3,4});
                    my.setSheetSelected(0);
                    break;
                }
            }
        }
        progressBar.setValue(4);
        Thread.sleep(pauseDelay);
        //</editor-fold>
        
        //<editor-fold desc="#5 Save File">
        lbLoadingMessage.setText("Saving File...5/5");
        
        if(!my.saveExcelFile(getFileName(false))){
            my.showMessage("There was an error Exporting the file.\nPlease make sure the file you are saving at is not open and try again.", JOptionPane.ERROR_MESSAGE);
            throw new InterruptedException("Save Failed");
        }
        progressBar.setValue(5);
        Thread.sleep(pauseDelay);
        //</editor-fold>
        
        closeCustomDialog();
        btnExport.setEnabled(true);
        return "Task Complete";
    }

    @Override
    protected void done() {
        closeCustomDialog();
        super.done(); //To change body of generated methods, choose Tools | Templates.
    }
    //<editor-fold desc="Custom Functions">
    private int getSheetNumberToUse(){
        int sheetIndex = 0;
        int dataCount = 0;
        
        //NOTE: School Form 6,9 & 10 doesn't require multiple sheets
        switch(myVariables.getFormSelected()){
            case 1:{
                dataCount = sf1Table.getRowCount();break;
            }case 2:{
                dataCount = sf2Table.getRowCount()-3;break;
            }case 3:{
                dataCount = sf3Table.getRowCount()-3;break;
            }case 4:{
                dataCount = sf4Table.getRowCount();break;
            }case 5:{
                dataCount = sf5Table.getRowCount()-3;break;
            }case 7:{
                dataCount = sf7Table.getRowCount();break;
            }case 8:{
                dataCount = sf8Table.getRowCount();break;
            }case 9:{
                dataCount = 0;break;
            }case 10:{
                dataCount = 0;break;
            }default:{
                break;
            }
        }
        
        if(dataCount <= 10){
            sheetIndex = 0;
        }if(dataCount > 10 && dataCount <= 20){
            sheetIndex = 1;
        }if(dataCount > 20 && dataCount <= 30){
            sheetIndex = 2;
        }if(dataCount > 30 && dataCount <= 40){
            sheetIndex = 3;
        }if(dataCount > 40 && dataCount <= 50){
            sheetIndex = 4;
        }if(dataCount > 50 && dataCount <= 60){
            sheetIndex = 5;
        }if(dataCount > 60 && dataCount <= 70){
            sheetIndex = 6;
        }
        return sheetIndex;
    }
    private boolean writeTables(int sheetNumber){
        String startingAddress,startingAddress2,startingAddress3;
        String excelColumnsToSkip;
        try {
            switch(myVariables.getFormSelected()){
                case 1:{
                    //<editor-fold desc="WRITE SF1">
                    int rowCount = sf1Table.getRowCount();
                    startingAddress = "A,"; //A,7 first row
                    excelColumnsToSkip = null;
                    
                    for (int n = 0; n < rowCount; n++) {
                        lbLoadingMessage.setText("Writing Tables...3/4 Line "+(n+1)+" of "+rowCount);
                        
                        String line = my.get_table_row_values(n, sf1Table);
                        //Single Letter Gender
                        String gender = my.getValueAtColumn(line, 5).substring(0, 1);
                        line = my.setValueAtColumn(line, 5, gender);
                        //Remove Unnecessary Columns
                        line = my.skipColumns(line, new int [] {0,1,2});
                        //Write to excel file
                        my.writeExcelLine(sheetNumber, line, excelColumnsToSkip, startingAddress+(n+7));
                        
                        Thread.sleep(threadDelay);
                    }
                    //</editor-fold>
                    break;
                }case 2:{
                    //<editor-fold desc="WRITE SF2">
                    
                    //Write Dates
                    lbLoadingMessage.setText("Writing Tables...3/4 Writing Dates");
                    String days = my.get_table_row_values(0, sf2WeekdaysTable);
                    days = my.skipColumns(days, new int [] {0,1,2,3,4,5,6,32,33});
                    my.writeExcelLine(sheetNumber, days, null, "C,6");
                    Thread.sleep(threadDelay);
                    
                    //Prepare blank days for writing
                    lbLoadingMessage.setText("Writing Tables...3/4 Loading Blank Dates");
                    String blankDays = "";
                    for (int n = 0; n < 25; n++) {
                        blankDays+=" @@";
                    }
                    Thread.sleep(threadDelay);
                    
                    //<editor-fold desc="Extract Counters">
                    lbLoadingMessage.setText("Writing Tables...3/4 Extracting Counters");
                    int rowCount = sf2Table.getRowCount()-3; //Exlude Counters From the bottom
                    String mCount = my.get_table_row_values(rowCount, sf2Table);
                    String fCount = my.get_table_row_values(rowCount+1, sf2Table);
                    String tCount = my.get_table_row_values(rowCount+2, sf2Table);
                    
                    mCount = " @@"+my.skipColumns(mCount, new int [] {0,1,2,4,5,6});
                    fCount = " @@"+my.skipColumns(fCount, new int [] {0,1,2,4,5,6});
                    tCount = " @@"+my.skipColumns(tCount, new int [] {0,1,2,4,5,6});
                    Thread.sleep(threadDelay);
                    //</editor-fold>
                    
                    //Write Sf2 Table
                    String remarks,gender,studentName,absent,tardy,attendanceValue;
                    startingAddress = "A,";
                    boolean firstFemaleFound = false;
                    int row = 0;
                    for (int n = 0; n < rowCount;) {
                        lbLoadingMessage.setText("Writing Tables...3/4 Line "+(n+1)+" of "+rowCount);
                        
                        //Get line
                        String line = my.get_table_row_values(n, sf2Table);
                        studentName = my.getValueAtColumn(line, 3);
                        gender = my.getValueAtColumn(line, 4);
                        
                        absent = my.getValueAtColumn(line, 32);
                        tardy = my.getValueAtColumn(line, 33);
                        
                        //Extract & Move remarks to last part of the line later
                        remarks = my.getValueAtColumn(line, 6);
                        
                        //<editor-fold desc="Check for First Female Occurence & insert male counter & skip n increment">
                        if(!firstFemaleFound){
                            if(gender.contains("Female")){
                                firstFemaleFound = true;
                                //System.err.println(mCount);
                                my.writeExcelLine(sheetNumber, mCount, null, startingAddress+(row+8));
                                row++;
                                Thread.sleep(threadDelay);
                                continue;
                            }
                        }
                        //Merge with blanks
                        String newLine = (n+1)+"@@"+studentName+"@@"+blankDays+absent+"@@"+tardy+"@@"+remarks+"@@";
                        my.writeExcelLine(sheetNumber, newLine, null, startingAddress+(row+8));
                        Thread.sleep(threadDelay);
                        //</editor-fold>
                        
                        //<editor-fold desc="Insert Images If Present,Absent or Tardy">
                        int [] leftIndeces = new int []{7,12,17,22,27};
                        int [] rightIndeces = new int []{11,16,21,26,31};
                        
                        for (int col = 7; col < 32; col++) {
                            lbLoadingMessage.setText("Writing Tables...3/4 Line "+(n+1)+" of "+rowCount+", Attendance "+(col-6)+"/25");
                            attendanceValue = my.getValueAtColumn(line, col);
                            
                            BorderStyle [] borders;
                            if(my.isInsideArray(col, leftIndeces)){
                                borders = new BorderStyle[]{BorderStyle.MEDIUM,BorderStyle.THIN,BorderStyle.THIN,BorderStyle.THIN,};
                            }else{
                                if(my.isInsideArray(col, rightIndeces)){
                                    borders = new BorderStyle[]{BorderStyle.THIN,BorderStyle.MEDIUM,BorderStyle.THIN,BorderStyle.THIN,};
                                }else{
                                    borders = new BorderStyle[]{BorderStyle.THIN,BorderStyle.THIN,BorderStyle.THIN,BorderStyle.THIN,};
                                }
                            }
                            
                            //System.err.println("Attenance Value: "+attendanceValue);
                            if(attendanceValue.equals("P")){
                                my.writeExcelSingleDataWColor(sheetNumber, "P", row+7, col-5,!myVariables.isDebugModeOn()?Color.WHITE:Color.BLUE,borders);
                                continue;
                            }if(attendanceValue.equals("A")){
                                my.writeExcelSingleDataWColor(sheetNumber, "X", row+7, col-5,!myVariables.isDebugModeOn()?Color.BLACK:Color.RED,borders);
                                continue;
                            }if(attendanceValue.equals("TLC")){
                                my.writeExcelSingleDataWColor(sheetNumber, "TLC", row+7, col-5,!myVariables.isDebugModeOn()?Color.WHITE:Color.ORANGE,borders);
                                my.drawImageToCell(sheetNumber, myVariables.getLateCommerIcon(), new int [] {row+7,col-5,row+8,col-4}, false);
                                continue;
                            }if(attendanceValue.equals("TCC")){
                                my.writeExcelSingleDataWColor(sheetNumber, "TCC", row+7, col-5,!myVariables.isDebugModeOn()?Color.WHITE:Color.RED,borders);
                                my.drawImageToCell(sheetNumber, myVariables.getCuttingClassesIcon(), new int [] {row+7,col-5,row+8,col-4}, false);
                                continue;
                            }if(attendanceValue.equals("T")){
                                my.writeExcelSingleDataWColor(sheetNumber, "T", row+7, col-5,!myVariables.isDebugModeOn()?Color.WHITE:Color.ORANGE,borders);
                                my.drawImageToCell(sheetNumber, myVariables.getLateCommerIcon(), new int [] {row+7,col-5,row+8,col-4}, false);
                                continue;
                            }if(attendanceValue.equals("--")){
                                my.writeExcelSingleData(sheetNumber, "--", row+7, col-5);
                            }
                            Thread.sleep(threadDelay);
                        }
                        //</editor-fold>
                        
                        //If there is no female and is last row
                        if(!firstFemaleFound){
                            if(n == rowCount-1){
                                firstFemaleFound = true;
                                row++;
                                my.writeExcelLine(sheetNumber, mCount, null, startingAddress+(row+8));
                                Thread.sleep(threadDelay);
                            }
                        }
                        
                        n++;
                        row++;
                        Thread.sleep(threadDelay);
                    }
                    //Write Female & Total Counters
                    my.writeExcelLine(sheetNumber, fCount, null, startingAddress+(row+8));
                    my.writeExcelLine(sheetNumber, tCount, null, startingAddress+(row+8+1));
                    
                    //Write Summary Table
                    startingAddress2 = "Y,";
                    int [] rowAddresses = new int [] {23,25,29,31,33,35,36,37,39,41};
                    
                    for (int n = 0; n < 10; n++) {
                        lbLoadingMessage.setText("Writing Tables...3/4 Summary "+(n+1)+" of 10");
                        String line = my.get_table_row_values(n, sf2SummaryTable);
                        line = my.skipColumns(line, new int [] {0});
                        
                        my.writeExcelLine(sheetNumber, line, null, startingAddress2+(rowAddresses[n]+(10*sheetNumber)));
                        Thread.sleep(threadDelay);
                    }
                    //</editor-fold>
                    break;
                }case 3:{
                    //<editor-fold desc="WRITE SF3">
                    //#1 Write Book Names
                    int rowCount = sf3BooksTable.getRowCount();
                    startingAddress = "C,5"; //A,7 first row
                    excelColumnsToSkip = "D,F,H,J,L,N,P,R,T,V";
                    
                    String bookTitles = "";
                    for (int n = 0; n < rowCount; n++) {
                        lbLoadingMessage.setText("Writing Tables...3/4 Writing Book Names "+(n+1)+" of "+rowCount);
                        String bookCode = sf3BooksTable.getValueAt(n, 1).toString();
                        bookTitles += (n+1)+". " + bookCode + "@@";
                        Thread.sleep(pauseDelay);
                    }
                    my.writeExcelLine(sheetNumber, bookTitles, excelColumnsToSkip, startingAddress);
                    
                    //#2 Write Sf3 Table
                    rowCount = sf3Table.getRowCount()-3;
                    startingAddress2 = "A,"; //A,7 first row
                    excelColumnsToSkip = null;
                    
                    //Extract Counters;
                    String maleBooks = my.get_table_row_values(rowCount, sf3Table);
                    String femaleBooks = my.get_table_row_values(rowCount+1, sf3Table);
                    String totalBooks = my.get_table_row_values(rowCount+2, sf3Table);
                    
                    maleBooks = " @@"+my.skipColumns(maleBooks, new int [] {0,1,2,4});
                    femaleBooks = " @@"+my.skipColumns(femaleBooks, new int [] {0,1,2,4});
                    totalBooks = " @@"+my.skipColumns(totalBooks, new int [] {0,1,2,4});
                    
                    int row = 0;
                    boolean firstFemaleFound = false;
                    for (int n = 0; n < rowCount;) {
                        lbLoadingMessage.setText("Writing Tables...3/4 Student "+(n+1)+" of "+rowCount);
                        
                        String gender = sf3Table.getValueAt(n, 4).toString();
                        String line = my.get_table_row_values(n, sf3Table);
                        line = (n+1)+"@@"+my.skipColumns(line, new int [] {0,1,2,4});
                        
                        //System.err.println("Line : "+line);
                        if(!firstFemaleFound){
                            if(gender.contains("Female")){
                                firstFemaleFound = true;
                                //System.err.println(mCount);
                                my.writeExcelLine(sheetNumber, maleBooks, excelColumnsToSkip, startingAddress2+(row+8));
                                
                                row++;
                                Thread.sleep(threadDelay);
                                continue;
                            }
                        }
                        //Write Line
                        my.writeExcelLine(sheetNumber, line, excelColumnsToSkip, startingAddress2+(row+8));
                        Thread.sleep(threadDelay);
                        
                        //If there is no female and is last row
                        if(!firstFemaleFound){
                            if(n == rowCount-1){
                                firstFemaleFound = true;
                                row++;
                                my.writeExcelLine(sheetNumber, maleBooks, excelColumnsToSkip, startingAddress2+(row+8));
                                Thread.sleep(threadDelay);
                            }
                        }
                        n++;
                        row++;
                        Thread.sleep(threadDelay);
                    }
                    //Write Female & Total Counters
                    my.writeExcelLine(sheetNumber, femaleBooks, excelColumnsToSkip, startingAddress2+(row+8));
                    my.writeExcelLine(sheetNumber, totalBooks, excelColumnsToSkip, startingAddress2+(row+8+1));
                    
                    //</editor-fold>
                    break;
                }case 4:{
                    //<editor-fold desc="WRITE SF4">
                    int rowCount = sf4Table.getRowCount();
                    startingAddress = "A,";
                    excelColumnsToSkip = "M,N,O,S,T,U,V,W,X,AB,AC,AD,AE,AF,AG,AK,AL,AM";
                    
                    for (int n = 0; n < rowCount; n++) {
                        lbLoadingMessage.setText("Writing Tables...3/4 Section "+(n+1)+" of "+rowCount);
                        
                        String line = my.get_table_row_values(n, sf4Table);
                        String sectionName = my.getSectionNameOnly(sf4Table.getValueAt(n, 1).toString(), true);
                        
                        line = my.setValueAtColumn(line, 1, sectionName);
                        
                        my.writeExcelLine(sheetNumber, line, excelColumnsToSkip, startingAddress+(n+11));
                        Thread.sleep(threadDelay);
                    }
                    //</editor-fold>
                    break;
                }case 5:{
                    //<editor-fold desc="WRITE SF5">
                    int rowCount = sf5Table.getRowCount()-3;
                    startingAddress = "A,";
                    excelColumnsToSkip = "C,D,E";
                    
                    //<editor-fold desc="Extract Counters">
                    String mCount = my.get_table_row_values(rowCount, sf5Table);
                    String fCount = my.get_table_row_values(rowCount+1, sf5Table);
                    String tCount = my.get_table_row_values(rowCount+2, sf5Table);
                    
                    mCount = my.skipColumns(mCount, new int[]{0,1,2,3,6,7,11});
                    fCount = my.skipColumns(fCount, new int[]{0,1,2,3,6,7,11});
                    tCount = my.skipColumns(tCount, new int[]{0,1,2,3,6,7,11});
                    //</editor-fold>
                    
                    //#1 Write Sf5 Table
                    String gender;
                    boolean firstFemaleFound = false;
                    int row = 0;
                    for (int n = 0; n < rowCount; ) {
                        lbLoadingMessage.setText("Writing Tables...3/4 Line "+(n+1)+" of "+rowCount);
                        
                        //Get line
                        String line = my.get_table_row_values(n, sf5Table);
                        gender = my.getValueAtColumn(line, 6);
                        line = my.skipColumns(line, new int[]{0,1,2,3,6,7,11});
                        
                        if(!firstFemaleFound){
                            if(gender.contains("Female")){
                                firstFemaleFound = true;
                                //System.err.println(mCount);
                                my.writeExcelLine(sheetNumber, mCount, excelColumnsToSkip, startingAddress+(row+8));
                                row++;
                                Thread.sleep(threadDelay);
                                continue;
                            }
                        }
                        my.writeExcelLine(sheetNumber, line, excelColumnsToSkip, startingAddress+(row+8));
                        row++;
                        n++;
                        Thread.sleep(threadDelay);
                    }
                    //Write Female & Total Counters
                    my.writeExcelLine(sheetNumber, fCount, excelColumnsToSkip, startingAddress+(row+8));
                    my.writeExcelLine(sheetNumber, tCount, excelColumnsToSkip, startingAddress+(row+8+1));
                    
                    //#2 Write Summary Table
                    startingAddress2 = "K,";
                    excelColumnsToSkip = null;
                    rowCount = sf5SummaryTable.getRowCount();
                    
                    for (int n = 0; n < rowCount; n++) {
                        lbLoadingMessage.setText("Writing Tables...3/4 Summary "+(n+1)+" of "+rowCount);
                        
                        String line = my.get_table_row_values(n, sf5SummaryTable);
                        line = my.skipColumns(line, new int [] {0});
                        
                        my.writeExcelLine(sheetNumber, line, excelColumnsToSkip, startingAddress2+(n+10));
                        Thread.sleep(threadDelay);
                    }
                    
                    //#3 Write Level of Progress & Achievement
                    startingAddress2 = "K,";
                    excelColumnsToSkip = null;
                    rowCount = sf5LevelOfProgressTable.getRowCount();
                    
                    int [] rowsToSkip = new int[]{17,19,21,23,25};
                    row = 0;
                    for (int n = 0; n < rowCount;) {
                        lbLoadingMessage.setText("Writing Tables...3/4 Progress "+(n+1)+" of "+rowCount);
                        
                        if(my.isInsideArray(row+16, rowsToSkip)){
                            row++;
                            continue;
                        }
                        String line = my.get_table_row_values(n, sf5LevelOfProgressTable);
                        line = my.skipColumns(line, new int [] {0});
                        
                        my.writeExcelLine(sheetNumber, line, excelColumnsToSkip, startingAddress2+(row+16));
                        
                        n++;
                        row++;
                        Thread.sleep(threadDelay);
                    }
                    
                    //</editor-fold>
                    break;
                }case 6:{
                    //<editor-fold desc="WRITE SF6">
                    int rowCount = sf6Table.getRowCount();
                    startingAddress = "B,";
                    excelColumnsToSkip = "N,O,P,Q,R,S";
                    int [] rowsToSkip = new int [] {13};
                    
                    int row = 0;
                    for (int n = 0; n < rowCount; ) {
                        lbLoadingMessage.setText("Writing Tables...3/4 Summary "+(n+1)+" of "+rowCount);
                        
                        if(my.isInsideArray(row+10, rowsToSkip)){
                            row++;
                            continue;
                        }
                        
                        String line = my.get_table_row_values(n, sf6Table);
                        line = my.skipColumns(line, new int [] {0});
                        
                        my.writeExcelLine(sheetNumber, line, excelColumnsToSkip, startingAddress+(row+10));
                        
                        row++;
                        n++;
                        Thread.sleep(threadDelay);
                    }
                    //</editor-fold>
                    break;
                }case 7:{
                    //<editor-fold desc="Write SF7">
                    int rowCount = sf7Table.getRowCount(),subjCount;
                    startingAddress = "A,"; //A,7 first row
                    startingAddress2 = "L,";
                    excelColumnsToSkip = "E,J";
                    
                    String staffDetails;
                    String subjName;
                    String subjSection;
                    String subjectDetails;
                    String grLvl;
                    
                    int [] selectedSubjects;
                    
                    //<editor-fold desc="WRITE VALUES">
                    for (int n = rowCount-1; n >= 0; n--) {
                        progressBar.setMaximum(rowCount);
                        progressBar.setValue(rowCount-n);
                        lbLoadingMessage.setText("Writing Tables...3/4 Teacher "+(rowCount-n)+" of "+rowCount);
                        
                        //#1 Get staff details
                        staffDetails = my.get_table_row_values(n, sf7Table);
                        staffDetails = my.skipColumns(staffDetails, new int [] {0,10});
                        
                        my.writeExcelLine(sheetNumber, staffDetails, excelColumnsToSkip, startingAddress+(17+(16*n)));
                        Thread.sleep(threadDelay);
                        //#2 Get subjects assigned to this staff from assignedSubjectsTable
                        //sf7Table.setRowSelectionInterval(n, n); //Optional
                        String userId = sf7Table.getValueAt(n, 0).toString();
                        my.runSecondaryThread(9, true, 
                                new JTable[]{sf7AssignedSubjectsTable,sf7Table}, 
                                new String[]{"1",userId}, 
                                new JTextField[]{},
                                new JButton[]{},
                                new boolean[]{true}
                        );
                        //wait for 2nd thread to finish
                        while (myFunctions.getSecondThread().isAlive()) {                            
                            Thread.sleep(10);
                        }
                        Thread.sleep(threadDelay);
                        //Resume Thread
                        showCustomDialog("Exporting to Excel File", dialogPanel, false, 420, 220, false);
                        progressBar.setMaximum(rowCount);
                        progressBar.setValue(n+1);
                        
                        selectedSubjects = sf7AssignedSubjectsTable.getSelectedRows();
                        subjCount = selectedSubjects.length;
                        
                        for (int x = 0; x < subjCount; x++) {
                            lbLoadingMessage.setText("Writing Tables...3/4 Teacher "+(rowCount-n)+" of "+rowCount+". "+(x+1)+"/"+subjCount);
                            if(!useSubjectCodeAsSubjectName){
                                subjName = sf7AssignedSubjectsTable.getValueAt(selectedSubjects[x], 6).toString();
                                if(useAcronyms){
                                    gradeLevel = sf7AssignedSubjectsTable.getValueAt(selectedSubjects[x], 7).toString();
                                    subjName = my.getAcronym(subjName, true, gradeLevel);
                                }
                            }else{
                                subjName = sf7AssignedSubjectsTable.getValueAt(selectedSubjects[x], 5).toString();
                            }
                            subjSection = my.getSectionNameOnly(sf7AssignedSubjectsTable.getValueAt(selectedSubjects[x], 3).toString(), true);
                            subjectDetails = subjName.toUpperCase()+" - "+subjSection+"@@";
                            
                            my.writeExcelLine(sheetNumber, subjectDetails, null, startingAddress2+((17+(16*n))+x) );
                            Thread.sleep(threadDelay);
                        }
                        Thread.sleep(threadDelay);
                    }
                    //</editor-fold>
                    sf7AssignedSubjectsTable.clearSelection();
                    
                    //#3 Remove Extra rows (Minimum 3-5 rows should be left?)..Descending Order
                    int [] dataCounts = {10,20,30,40,50,60,70};

                    int rowsToRemove;

                    startingAddress3 = "L,";
                    int startRow,endRow,tempRow,dataCount;
                    
                    int lastRowAddress = ( 17+(16*(dataCounts[sheetNumber])) )-1;
                    System.err.println("Initial Last Row: "+lastRowAddress);
                    
                    progressBar.setMaximum(dataCounts[sheetNumber]);
                    progressBar.setValue(0);
                    
                    for (int n = dataCounts[sheetNumber]-1; n >= 0; n--) {
                        progressBar.setValue(dataCounts[sheetNumber]-n);
                        lbLoadingMessage.setText("Writing Tables...3/4 Removing Excess Rows "+(dataCounts[sheetNumber]-n)+"/"+dataCounts[sheetNumber]);
                        startRow = 17+(16*n);
                        endRow = startRow+15;
                        dataCount = 0;
                        
                        //Check for empty values
                        if(my.isCellEmpty(sheetNumber, startingAddress3+startRow)){
                            //Shift rows
                            my.removeRows(sheetNumber, startRow, endRow);
                            lastRowAddress -= 16;
                        }else{
                            //System.err.println("Cell @ row "+startRow+" is not empty");
                            for (int x = startRow; ; x++) {
                                if(my.isCellEmpty(sheetNumber, startingAddress3+x)){
                                    tempRow = x;break;
                                }
                                dataCount++;
                            }
                            
                            if(dataCount < 5){
                                tempRow = startRow+5;
                            }
                            //Shift Rows
                            my.removeRows(sheetNumber, tempRow, endRow-1);
                            
                            
                            
                            lastRowAddress -= endRow-tempRow;
                            System.err.println((endRow-tempRow)+" has been reduced");
                        }
                        Thread.sleep(threadDelay);
                    }
                    
                    //#4 Merge rows
                    System.err.println("Last Row: "+lastRowAddress);

                    String [] columnsToMerge = {"A","B","C","F","G","H","K"};
                    String [][] regionColumnsToMerge = {
                        {"D,","E,"},
                        {"I,","J,"},
                        {"Q,","R,"}
                    };
                    startingAddress3 = "C,"; //Check gender column since it always has a value
                    int lastEmptyRow;
                    for (int n = 17; n <= lastRowAddress; n++) {
                        if(!my.isCellEmpty(sheetNumber, startingAddress3+n)){
                            lastEmptyRow = n;
                            n++;
                            //Search for last empty value
                            for (int x = n; x <= lastRowAddress; x++) {
                                if(!my.isCellEmpty(sheetNumber, startingAddress3+x)){
                                    break;
                                }
                                lastEmptyRow++;
                            }
                            //System.err.println("Start: "+(n-1)+" Last: "+lastEmptyRow);
                            
                            //Merge Row
                            for (String x: columnsToMerge) {
                                my.mergeRows(sheetNumber, x, n-1, lastEmptyRow);
                            }
                            //Merge Regions
                            for(String [] x : regionColumnsToMerge){
                                my.mergeRegion(sheetNumber, x[0]+(n-1), x[1]+(lastEmptyRow));
                            }
                            n = lastEmptyRow;
                        }
                        Thread.sleep(threadDelay);
                    }
                    
                    //Fix Distorted Footers
                    my.mergeColumns(sheetNumber, lastRowAddress+2, "A", "K");
                    my.mergeColumns(sheetNumber, lastRowAddress+2, "M", "P");
                    my.mergeColumns(sheetNumber, lastRowAddress+5, "M", "P");
                    my.mergeColumns(sheetNumber, lastRowAddress+6, "M", "P");
                    
                    my.mergeRegion(sheetNumber, "A,"+(lastRowAddress+3), "K,"+(lastRowAddress+4));
                    my.mergeRegion(sheetNumber, "A,"+(lastRowAddress+5), "K,"+(lastRowAddress+6));
                    my.mergeRegion(sheetNumber, "A,"+(lastRowAddress+7), "K,"+(lastRowAddress+8));
                    my.mergeRegion(sheetNumber, "A,"+(lastRowAddress+9), "K,"+(lastRowAddress+10));
                    
                    
                    //</editor-fold>
                    break;
                }case 8:{
                    //<editor-fold desc="WRITE SF8">
                    //#1 Write Sf8 Table
                    int rowCount = sf8Table.getRowCount();
                    startingAddress = "A,";
                    excelColumnsToSkip = "D,E,F";
                    
                    
                    String mCount = " @@Male@@";
                    String fCount = " @@Female@@";
                    
                    String gender;
                    boolean firstFemaleFound = false;
                    
                    int row = 0;
                    my.writeExcelLine(sheetNumber, mCount, excelColumnsToSkip, startingAddress+(row+11));
                    row++;
                    
                    for (int n = 0; n < rowCount; ) {
                        lbLoadingMessage.setText("Writing Tables...3/4 Line "+(n+1)+" of "+rowCount);
                        
                        //Get line
                        String line = my.get_table_row_values(n, sf8Table);
                        gender = my.getValueAtColumn(line, 6);
                        line = (n+1)+"@@"+my.skipColumns(line, new int[]{0,1,2,6,7,15});
                        
                        if(!firstFemaleFound){
                            if(gender.contains("Female")){
                                firstFemaleFound = true;
                                //System.err.println(mCount);
                                my.writeExcelLine(sheetNumber, fCount, excelColumnsToSkip, startingAddress+(row+11));
                                row++;
                                Thread.sleep(threadDelay);
                                continue;
                            }
                        }
                        my.writeExcelLine(sheetNumber, line, excelColumnsToSkip, startingAddress+(row+11));
                        
                        //If there is no female and is last row
                        if(!firstFemaleFound){
                            if(n == rowCount-1){
                                firstFemaleFound = true;
                                row++;
                                my.writeExcelLine(sheetNumber, fCount, excelColumnsToSkip, startingAddress+(row+11));
                                Thread.sleep(threadDelay);
                            }
                        }
                        
                        row++;
                        n++;
                        Thread.sleep(threadDelay);
                    }
                    //my.writeExcelLine(sheetNumber, tCount, excelColumnsToSkip, startingAddress+(row+11));
                    
                    //#2 Write Summary Table
                    int rowsToSkip [] = new int [] {0,6};
                    rowCount = sf8SummaryTable.getRowCount();
                    
                    String startingColumns [] = new String [] {"I,","C,","E,","F,","G,","H,","N,","J,","K,","L,","M,"};
                    int startingRows [] = new int [] {28,38,48,58,68,78,88};
                    String summaryMale,summaryFemale,summaryTotal;
                    excelColumnsToSkip = "D,O";
                    
                    for (int n = 0; n < rowCount; n++) {
                        lbLoadingMessage.setText("Writing Tables...3/4 Summary "+(n+1)+" of "+rowCount);
                        
                        summaryMale = sf8SummaryTable.getValueAt(n, 1).toString();
                        summaryFemale = sf8SummaryTable.getValueAt(n, 2).toString();
                        summaryTotal = sf8SummaryTable.getValueAt(n, 3).toString();
                        
                        my.writeExcelSingleData(sheetNumber, summaryMale, startingColumns[n]+startingRows[sheetNumber]);
                        my.writeExcelSingleData(sheetNumber, summaryFemale, startingColumns[n]+(startingRows[sheetNumber]+1));
                        my.writeExcelSingleData(sheetNumber, summaryTotal, startingColumns[n]+(startingRows[sheetNumber]+2));
                        Thread.sleep(threadDelay);
                    }
                    //</editor-fold>
                    break;
                }case 9:{
                    //<editor-fold desc="WRITE SF9">
                    int rowCount = sf9GradesTable.getRowCount();
                    startingAddress = "A,";
                    excelColumnsToSkip = "B,C,D,E,G,I,K,M,O,Q,R";
                    
                    for (int n = 0; n < rowCount; n++) {
                        lbLoadingMessage.setText("Writing Tables...3/4 Grade "+(n+1)+" of "+rowCount);
                        
                        String subjectName = sf9GradesTable.getValueAt(n, 5).toString();
                        subjectName = my.removeSubjectGrade(subjectName, " ");
                        
                        String line = my.get_table_row_values(n, sf9GradesTable);
                        line = my.setValueAtColumn(line, 5, subjectName);
                        line = my.skipColumns(line, new int [] {0,1,2,3,4,12});
                        
                        my.writeExcelLine(sheetNumber, line, excelColumnsToSkip, startingAddress+(n+23));
                        Thread.sleep(threadDelay);
                    }
                    //</editor-fold>
                    break;
                }case 10:{
                    //<editor-fold desc="WRITE SF10">
                    //#1 Write Section Headers
                    int rowCount = sf10Table.getRowCount();
                    int sheetNumbers [] = new int [] {0,0,1,1,1};
                    String sectionHeaderAddressess [][] = {
                        new String [] {"C,23","I,23","M,23","Q,23","U,23","C,24","E,24","J,24","N,24"},
                        new String [] {"C,47","I,47","M,47","Q,47","U,47","C,48","E,48","J,48","N,48"},
                        new String [] {"C,2","I,2","M,2","Q,2","U,2","C,3","E,3","J,3","N,3"},
                        new String [] {"C,26","I,26","M,26","Q,26","U,26","C,27","E,27","J,27","N,27"},
                        new String [] {"C,50","I,50","M,50","Q,50","U,50","C,51","E,51","J,51","N,51"},
                    };
                    
                    for (int n = 0; n < rowCount; n++) {
                        lbLoadingMessage.setText("Writing Tables...3/4 Section "+(n+1)+" of "+rowCount);
                        //Get Values from table
                        gradeLevel = sf10Table.getValueAt(n, 12).toString();
                        
                        sectionName = sf10Table.getValueAt(n, 6).toString();
                        sectionName = my.getSectionNameOnly(sectionName, true);
                        
                        schoolYear = sf10Table.getValueAt(n, 14).toString();
                        adviserName = sf10Table.getValueAt(n, 8).toString().toUpperCase();
                        
                        //Prepare Headers
                        header sectionHeader [] = new header [] {
                            new header(schoolName, sectionHeaderAddressess[n][0]),
                            new header(schoolId, sectionHeaderAddressess[n][1]),
                            new header(district, sectionHeaderAddressess[n][2]),
                            new header(division, sectionHeaderAddressess[n][3]),
                            new header(region, sectionHeaderAddressess[n][4]),
                            
                            new header(gradeLevel, sectionHeaderAddressess[n][5]),
                            new header(sectionName, sectionHeaderAddressess[n][6]),
                            new header(schoolYear, sectionHeaderAddressess[n][7]),
                            new header(adviserName, sectionHeaderAddressess[n][8]),
                        };
                        int headerLength = sectionHeader.length;
                        for (int x = 0; x < headerLength; x++) {
                            lbLoadingMessage.setText("Writing Tables...3/4 Section "+(n+1)+" of "+rowCount+" Header "+(x+1)+"/"+headerLength);
                            my.writeExcelSingleData(sheetNumbers[n], sectionHeader[x].getData(),sectionHeader[x].getExcelAddress());
                            Thread.sleep(10);
                        }
                        
                        Thread.sleep(threadDelay);
                    }
                    
                    //#2 Write Grade Tables
                    startingAddress = "A,";
                    excelColumnsToSkip = "B,C,D,E,F,G,H,J,L,N,P,R,T,U";
                    int gradeCount;
                    int startingRows [] = new int [] {28,52,7,31,55};
                    String genAveEvaluationAddressess [] [] = new String [][] {
                        new String [] {"Q,40","S,40"},
                        new String [] {"Q,64","S,64"},
                        new String [] {"Q,19","S,19"},
                        new String [] {"Q,43","S,43"},
                        new String [] {"Q,67","S,67"},
                    };
                    String subjectName;
                    
                    for (int n = 0; n < rowCount; n++) {
                        lbLoadingMessage.setText("Writing Tables...3/4 Table "+(n+1)+" of "+rowCount);
                        gradeCount = sf10GradeTables[n].getRowCount();
                        
                        if(gradeCount < 1){
                            System.err.println("No Grades on this table index "+n+"...Skipping");
                            continue;
                        }
                        //Write grade on Table[n]
                        for (int x = 0; x < gradeCount; x++) {
                            lbLoadingMessage.setText("Writing Tables...3/4 Table "+(n+1)+" of "+rowCount+" Grade "+(x+1)+"/"+gradeCount);
                            subjectName = sf10GradeTables[n].getValueAt(x, 5).toString();
                            subjectName = my.removeSubjectGrade(subjectName, " ");
                            
                            String line = my.get_table_row_values(x, sf10GradeTables[n]);
                            line = my.setValueAtColumn(line, 5, subjectName);
                            line = my.skipColumns(line, new int [] {0,1,2,3,4,12});
                            
                            
                            my.writeExcelLine(sheetNumbers[n], line, excelColumnsToSkip, startingAddress+(startingRows[n]+x));
                            Thread.sleep(10);
                        }
                        //Write General Average & Evaluation
                        my.writeExcelSingleData(sheetNumbers[n], generalAverages[n], genAveEvaluationAddressess[n][0]);
                        my.writeExcelSingleData(sheetNumbers[n], evaluations[n], genAveEvaluationAddressess[n][1]);
                        Thread.sleep(threadDelay);
                    }
                    //</editor-fold>
                    break;
                }default:{
                    
                }
            }
            
            Thread.sleep(pauseDelay);
            return true;
        }catch(InterruptedException x){
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }
    private boolean writeHeaders(int sheetNumber){
        try {
            int headerCount = headers.length;
            
            for (int n = 0; n < headerCount; n++) {
                lbLoadingMessage.setText("Writing Headers...2/4 Header "+(n+1)+" of "+headerCount);
                my.writeExcelSingleData(sheetNumber, headers[n].getData(), headers[n].getExcelAddress());
                Thread.sleep(threadDelay);
            }
            Thread.sleep(pauseDelay);
            return true;
        } catch (InterruptedException e) {
            return false;
        }
    }
    private boolean loadHeaders(int sheetNumber){
        try {
            switch(myVariables.getFormSelected()){
                case 1:{
                    //<editor-fold desc="SF1 Headers">
                    String mCount [] = new String [] {"L,20","L,30","L,40","L,50","L,60","L,70","L,80"};
                    String fCount [] = new String [] {"L,21","L,31","L,41","L,51","L,61","L,71","L,81"};
                    String tCount [] = new String [] {"L,22","L,32","L,42","L,52","L,62","L,72","L,82"};
                    String advName []= new String [] {"N,20","N,30","N,40","N,50","N,60","N,70","N,80"};
                    String prncplName []= new String [] {"Q,20","Q,30","Q,40","Q,50","Q,60","Q,70","Q,80"};
                    headers = new header[]{
                        //Header Parts
                        new header(schoolId, "C,3"),
                        new header(region, "F,3"),
                        new header(division, "K,3"),
                        new header(district, "P,3"),
                        new header(schoolName, "C,4"),
                        new header(schoolYear, "K,4"),
                        new header(gradeLevel, "M,4"),
                        new header(sectionName, "O,4"),
                        //Form's Custom Fields
                        new header(maleCount, mCount[sheetNumber]),
                        new header(femaleCount, fCount[sheetNumber]),
                        new header(totalCount, tCount[sheetNumber]),
                        new header(adviserName, advName[sheetNumber]),
                        new header(principalName, prncplName[sheetNumber])
                    };
                    //</editor-fold>
                    break;
                }case 2:{
                    //<editor-fold desc="SF2 Headers">
                    //Set Addresses by sheetIndex
                    String monthSelected [] = new String [] {"T,22","T,32","T,42","T,52","T,62","T,72","T,82"};
                    String schoolDays [] = new String [] {"W,22","W,32","W,42","W,52","W,62","W,72","W,82"};
                    String advName [] = new String [] {"U,45","U,55","U,65","U,75","U,85","U,95","U,105"};
                    
                    headers = new header[]{
                        //Header Parts
                        new header(schoolId, "C,3"),
                        new header(sf2MonthSelected, "R,3"),
                        new header(schoolName, "C,4"),
                        new header(schoolYear, "I,3"),
                        new header(gradeLevel, "R,4"),
                        new header(sectionName, "AB,4"),
                        //Form's Custom Fields
                        new header(sf2MonthSelected, monthSelected[sheetNumber]),
                        new header(sf2SchoolDays, schoolDays[sheetNumber]),
                        new header(adviserName, advName[sheetNumber]),
                    };
                    //</editor-fold>
                    break;
                }case 3:{
                    //<editor-fold desc="SF3 Headers">
                    //Set Addresses by sheetIndex
                    String advName [] = new String [] {"T,23","T,33","T,43","T,53","T,63","T,73","T,83"};
                    
                    headers = new header[]{
                        //Header Parts
                        new header(schoolId, "C,3"),
                        new header(schoolName, "C,4"),
                        new header(schoolYear, "I,3"),
                        new header(gradeLevel, "P,4"),
                        new header(sectionName, "T,4"),
                        //Form's Custom Fields
                        new header(adviserName, advName[sheetNumber]),
                    };
                    //</editor-fold>
                    break;
                }case 4:{
                    //<editor-fold desc="SF4 Headers">
                    headers = new header[]{
                        //Header Parts
                        new header(schoolId, "D,4"),
                        new header(region, "J,4"),
                        new header(division, "Q,4"),
                        new header(district, "Y,4"),
                        new header(schoolName, "C,6"),
                        new header(schoolYear, "Y,6"),
                        new header(sf4MonthSelected, "AJ,6"),
                    };
                    //</editor-fold>
                    break;
                }case 5:{
                    //<editor-fold desc="SF5 Headers">
                    headers = new header[]{
                        //Header Parts
                        new header(schoolId, "C,5"),
                        new header(region, "C,4"),
                        new header(division, "F,4"),
                        new header(schoolName, "C,6"),
                        new header(schoolYear, "G,5"),
                        new header(gradeLevel, "J,6"),
                        new header(sectionName, "L,6"),
                        new header(sf5Curriculum, "J,5"),
                        //Form's Custom Fields
                        new header(adviserName, "J,29"),
                    };
                    //</editor-fold>
                    break;
                }case 6:{
                    //<editor-fold desc="SF6 Headers">
                    headers = new header[]{
                        //Header Parts
                        new header(schoolId, "D,4"),
                        new header(region, "J,4"),
                        new header(division, "O,4"),
                        new header(schoolName, "D,6"),
                        new header(district, "O,6"),
                        new header(schoolYear, "T,6"),
                        //Form's Custom Fields
                    };
                    //</editor-fold>
                    break;
                }case 7:{
                    //<editor-fold desc="SF7 Headers">
                    String [] shclHead = {"M,181","M,341","M,501","M,661","M,821","M,981","M,1141"};
                    
                    headers = new header[]{
                        //Header Parts
                        new header(schoolId, "C,4"),
                        new header(region, "H,4"),
                        new header(division, "K,4"),
                        new header(schoolName, "C,6"),
                        new header(district, "K,6"),
                        new header(schoolYear, "Q,6"),
                        //Form's Custom Fields
                        new header(myVariables.getPrincipal().toUpperCase(), shclHead[sheetNumber]),
                    };
                    //</editor-fold>
                    break;
                }case 8:{
                    //<editor-fold desc="SF8 Headers">
                    String [] dateOfMearuringAddress = new String [] {"A,34","A,44","A,54","A,64","A,74","A,84","A,94"};
                    
                    headers = new header[]{
                        //Header Parts
                        new header(schoolId, "C,7"),
                        new header(region, "O,5"),
                        new header(division, "L,5"),
                        new header(schoolName, "E,5"),
                        new header(schoolYear, "O,7"),
                        new header(gradeLevel, "F,7"),
                        new header(sectionName, "H,7"),
                        new header(district, "I,5"),
                        //Form's Custom Fields
                        new header(dateOfMeasurement, dateOfMearuringAddress[sheetNumber]),
                    };
                    //</editor-fold>
                    break;
                }case 9:{
                    //<editor-fold desc="SF9 Headers">
                    headers = new header[]{
                        //Header Parts
                        new header(schoolYear, "P,9"),
                        new header(gradeLevel, "C,9"),
                        new header(sectionName, "G,9"),
                        //Form's Custom Fields
                        new header(adviserName, "K,16"),
                        
                        new header(lrn, "C,8"),
                        new header(studentName, "C,7"),
                        new header(gender, "P,8"),
                        new header(age, "L,8"),
                        
                        new header(sf9GeneralAverage, "N,35"),
                        new header(sf9FailedSubjects, "F,44"),
                        new header(sf9Remarks, "P,35"),
                    };
                    //</editor-fold>
                    break;
                }case 10:{
                    //<editor-fold desc="SF10 Headers">
                    String birthDate [] = this.birthDate.split("-");
                    headers = new header[]{
                        new header(lastName, "C,7"),
                        new header(firstName, "H,7"),
                        new header(extentionName, "O,7"),
                        new header(middleName, "S,7"),
                        
                        new header(lrn, "D,8"),
                        new header(birthDate[1], "M,8"),
                        new header(birthDate[2], "O,8"),
                        new header(birthDate[0], "Q,8"),
                        new header(gender, "T,8"),
                        
                        new header(elemGeneralAverage, "I,13"),
                        new header(elemSchoolName, "D,14"),
                        new header(elemShoolId, "L,14"),
                        new header(elemSchoolAddress, "Q,14"),
                    };
                    //</editor-fold>
                    break;
                }
            }
            
            Thread.sleep(pauseDelay);
            return true;
        }catch(InterruptedException x){
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }
    private String getFileName(boolean importExport){
        String fileName = "";
        switch(myVariables.getFormSelected()){
            case 1:{
                fileName = importExport? "templates/jh_sf1.xlsx" : "exports/jh_sf1.xlsx";break;
            }case 2:{
                fileName = importExport? "templates/jh_sf2.xlsx" : "exports/jh_sf2.xlsx";break;
            }case 3:{
                fileName = importExport? "templates/jh_sf3.xlsx" : "exports/jh_sf3.xlsx";break;
            }case 4:{
                fileName = importExport? "templates/jh_sf4.xlsx" : "exports/jh_sf4.xlsx";break;
            }case 5:{
                fileName = importExport? "templates/jh_sf5.xlsx" : "exports/jh_sf5.xlsx";break;
            }case 6:{
                fileName = importExport? "templates/jh_sf6.xlsx" : "exports/jh_sf6.xlsx";break;
            }case 7:{
                fileName = importExport? "templates/jh_sf7.xlsx" : "exports/jh_sf7.xlsx";break;
            }case 8:{
                fileName = importExport? "templates/jh_sf8.xlsx" : "exports/jh_sf8.xlsx";break;
            }case 9:{
                fileName = importExport? "templates/jh_sf9.xlsx" : "exports/jh_sf9.xlsx";break;
            }case 10:{
                fileName = importExport? "templates/jh_sf10.xlsx" : "exports/jh_sf10.xlsx";break;
            }
        }
        
        return fileName;
    }
    //</editor-fold>
    //<editor-fold desc="Extra Classes">
    private class header{
        private String data;
        private String excelAddress;

        public header(String data, String excelAddress) {
            this.data = data;
            this.excelAddress = excelAddress;
        }

        public String getData() {
            return data;
        }
        
        public String getExcelAddress() {
            return excelAddress;
        }
    }
    //</editor-fold>
    //<editor-fold desc="Dialog Functions">
    private void showCustomDialog(String title, JPanel customPanel, boolean isModal, int width, int height, boolean isResizable){
        if(dialog != null && dialog.isVisible()){
            dialog.setSize(width, height);
            dialog.setTitle(title);
            dialog.add(customPanel);
            dialog.setModal(isModal);
            if(isModal){
                dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
            }else{
                dialog.setModalityType(Dialog.ModalityType.MODELESS);
            }
            dialog.setLocationRelativeTo(jFrameName);
            //System.err.println("Sf4 Dialog is already visible. Skipping...");
            return;
        }
        dialog = new JDialog(jFrameName);
        dialog.setTitle(title);
        dialog.add(customPanel);
        dialog.setModal(isModal);
        if(isModal){
            dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        }else{
            dialog.setModalityType(Dialog.ModalityType.MODELESS);
        }
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
    //</editor-fold>
}
