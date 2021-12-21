/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mahPackage7;

import java.awt.Color;
import java.awt.Dialog;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;
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
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Phil Rey Paderogao
 */
public class thread_loadSf2Details extends SwingWorker<String, Object>{
    //<editor-fold desc="Variables">
    long threadDelay = 100;
    long pauseDelay = 500;
    myFunctions my;
    //Summary Variables
    private int numberOfSchoolDays;
    private int absent,tardy;
    private int schoolDaysColumnIndex [];
    //Sf4 Variables (Optional)
    private JTable sf4Table;
    private JTextField tfSectionName;
    private JTextField tfAdviserName;
    private JTextField tfGradeLevel;
    private JTextField tfSchoolYear;
    
    //Main Variables
    private JTable dateTable;
    private JTable tableName;
    private JTable summaryTable;
    private String sectionId;
    private String dateSelected;
    private String lastDayOfEnrollment;
    private String subjectId;
    private String missingValuesSubstitute;
    
    
    private String startingDate;
    private String endingDate;
    
    private JTextField tfSchoolDays;
    private boolean waitForMainThreadToFinish;
    private boolean  isSf2Selected;
    
    private JButton btnExport;
    //Dialog Properties
    private JDialog dialog;
    private JFrame jFrameName;
    private JPanel dialogPanel;
    private JLabel lbLoadingMessage;
    private JProgressBar progressBar;
    //</editor-fold>
    public thread_loadSf2Details(JTable [] tablesToUse,String [] stringsToUse,JTextField [] textFieldsToUse,JButton [] buttonsToUse,boolean [] booleansToUse) {
        my = new myFunctions(true);
        dateTable = tablesToUse[0];
        tableName = tablesToUse[1];
        summaryTable = tablesToUse[2];
        sf4Table = tablesToUse[3];
        
        sectionId = stringsToUse[0];
        dateSelected = stringsToUse[1];
        subjectId = stringsToUse[2];
        lastDayOfEnrollment = stringsToUse[3];
        missingValuesSubstitute = stringsToUse[4];
        
        tfSchoolDays = textFieldsToUse[0];
        if(textFieldsToUse.length>1){
            tfSectionName = textFieldsToUse[1];
            tfAdviserName = textFieldsToUse[2];
            tfGradeLevel = textFieldsToUse[3];
            tfSchoolYear = textFieldsToUse[4];
        }
        
        this.waitForMainThreadToFinish = booleansToUse[0];
        isSf2Selected = booleansToUse[1];
        try {
            btnExport = buttonsToUse[0];
        } catch (Exception e) {
        }
        
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
    protected String doInBackground() throws Exception{
        try {
            //<editor-fold desc="Wait For Students to Load">
            if(waitForMainThreadToFinish){
                System.err.println("Waiting for mainThread to Finish first...");
                while (true) {                
                    if(myFunctions.getMainThead() == null){
                        break;
                    }else{
                        if(!myFunctions.getMainThead().isAlive()){
                            break;
                        }
                    }
                }
            }
            //</editor-fold>
            try {
                Runtime.getRuntime().exec("cls");
            } catch (Exception e) {
            }
            //<editor-fold desc="Initialize Variables">
            if(isSf2Selected){
                if(btnExport != null){
                    btnExport.setEnabled(false);
                }
            }
            
            
            tableName.setEnabled(false);
            showCustomDialog("Loading Attendances...", dialogPanel, false, 420, 220, false);
            if(!loadSummary()){
                throw new InterruptedException("Interrupted @ Load Summary");
            }
            loadSchoolDaysIndex();
            //Check if there are students
            if(tableName.getRowCount() <= 0){
                //System.err.println("No students found. SKipping");
                tfSchoolDays.setText("0");
                throw new InterruptedException("Ended");
            }
            //Remove Students That are not enrolled Yet During the month
            if(!removeStudents()){
                throw new InterruptedException("Interrupted @ Remove Students");
            }
            
            if(!translateRemarks()){
                throw new InterruptedException("Interrupted @ Translate Remarks");
            }
            if(!evaluateRemarks()){
                throw new InterruptedException("Interrupted @ Evaluate Remarks");
            }
            //System.err.println("Starting Second THread");
            //Load Dates
            lbLoadingMessage.setText("Determining Days...");
            String dateLine = "-@@-@@-@@-@@-@@-@@-@@"+getStartAndEndDates(dateSelected, false);
            clear_table_rows(dateTable);
            add_table_row(dateLine, dateTable, new int []{7,12,17,22}, Color.RED);

            Thread.sleep(pauseDelay);
            //</editor-fold>
            //<editor-fold desc="Load Attendances">
                lbLoadingMessage.setText("Processing...");

                int studCount = tableName.getRowCount(),attendanceCount=0;
                int currentDateSelected=0,dateResultFound;
                String studentId = "",gender="",dateEnrolled="";

                progressBar.setMinimum(0);
                progressBar.setMaximum(studCount);
                Thread.sleep(threadDelay);

                for(int n=0;n<studCount;n++){   //Loop student table
                    lbLoadingMessage.setText("Processing Student "+(n+1)+" of "+studCount);
                    progressBar.setValue(n+1);
                    studentId = tableName.getValueAt(n, 2).toString();

                    gender = tableName.getValueAt(n, 4).toString();
                    dateEnrolled = tableName.getValueAt(n, 5).toString();
                    if(!checkEnrollmentType(gender, dateEnrolled)){
                        System.err.println("Student ID:"+studentId+" is not enrolled Year At This Time\nSelected: "+dateSelected+"\nEnrolled: "+dateEnrolled);
                        Thread.sleep(threadDelay);
                        continue;
                    }

                    Thread.sleep(pauseDelay);

                    //Get attendaces of student from database
                    String where = "WHERE studentId='"+studentId+"' AND "
                            + "sectionId='"+sectionId+"' AND "
                            + "subjectId='"+subjectId+"' AND "
                            + "dateAdded>='"+startingDate+"' AND "
                            + "dateAdded <='"+endingDate+"' "
                            + "ORDER BY sectionId DESC,studentId DESC,subjectId DESC, dateAdded ASC";
                    Thread.sleep(threadDelay);
                    lbLoadingMessage.setText("Connecting to Database...");

                    String [] attendanceResults = return_values("*", "attendance", where, myVariables.getAttendanceOrder());

                    Thread.sleep(pauseDelay);
                    lbLoadingMessage.setText("Loading Attendance...");

                    boolean matchFound;
                    int currentSchoolDays = 0;
                    if(attendanceResults != null){
                        for(int x=7;x<32;x++){  //Loop Dates
                            lbLoadingMessage.setText("Processing Student "+(n+1)+" of "+studCount+". Date "+(x-6)+" of 25");
                            try {
                                currentDateSelected = Integer.parseInt(dateTable.getValueAt(0, x).toString());
                            } catch (Exception e) {
                                tableName.setValueAt(myVariables.isDebugModeOn()? "ND" : " ", n, x);
                                continue;
                            }
                            //Match attendance dates with day columns
                            attendanceCount = attendanceResults.length;
                            matchFound = false;

                            for(int y=0;y<attendanceCount;y++){ //Loop Attendances
                                String cLine [] = attendanceResults[y].split("@@"); //{29,3,7,52,Present,2020-02-10 17:52:45,Notes}
                                String dateTime [] = cLine[5].split(" ");   //{2020-03-25,10:00:00}
                                String dates [] = dateTime[0].split("-");   //{2020,03,25}

                                dateResultFound = Integer.parseInt(dates[2]);
                                //System.err.println("CD:"+currentDateSelected+" RD:"+dateTime[0]);
                                if(dateResultFound == currentDateSelected){
                                    //System.err.println("Match Found");
                                    //Process attendance
                                    if(cLine[4].contains("Present")){
                                        tableName.setValueAt("P", n, x);
                                    }if(cLine[4].contains("Absent")){
                                        tableName.setValueAt("A", n, x);
                                    }if(cLine[4].contains("Tardy") || cLine[4].contains("Late")){
                                        try {
                                            //Check notes for codes
                                            String codes [] = cLine[6].split(":");
                                            tableName.setValueAt("T"+codes[0], n, x);
                                        } catch (Exception e) {
                                            tableName.setValueAt("T", n, x);
                                        }
                                    }
                                    matchFound = true;
                                    currentSchoolDays++;
                                    try {
                                        schoolDaysColumnIndex[x-7] = x;
                                    } catch (Exception e) {
                                        System.err.println("Column Indexing Error");
                                    }
                                    break;
                                }
                            }
                            if(!matchFound){
                                tableName.setValueAt(myVariables.isDebugModeOn()? "NAFIR" : " ", n, x);  //No attendance found for this day
                            }
                            Thread.sleep(threadDelay);
                        }
                    }else{
                        for(int x=7;x<32;x++){  //Loop Dates
                            try {
                                currentDateSelected = Integer.parseInt(dateTable.getValueAt(0, x).toString());
                            } catch (Exception e) {
                                tableName.setValueAt(myVariables.isDebugModeOn()? "ND" : " ", n, x);
                                continue;
                            }
                            tableName.setValueAt(myVariables.isDebugModeOn()? "NAF" : " ", n, x);  //No attendance found for this day
                        }
                    }
                    //Compare School Days
                    if(currentSchoolDays > numberOfSchoolDays){
                        numberOfSchoolDays = currentSchoolDays;
                    }
                }
            //</editor-fold>
            //<editor-fold desc="Load Summary">
            tfSchoolDays.setText(String.valueOf(numberOfSchoolDays));
            resetSchoolDaysIndex();
            fillUpMissingRecords();
            checkForFiveConsecutiveAbsences();
            getEnrollmentPercentage();
            loadAttendanceCounts();
            loadAverageAttendance();
            calculatePercentageOfAttendance();
            //</editor-fold>
            
            if(isSf2Selected){
                if(btnExport != null){
                    btnExport.setEnabled(true);
                }
            }
        } catch (Exception e) {
            System.err.println("Error Occured @ loadSf2Details : "+e.getMessage());
            throw new InterruptedException("Interrupted by USer");
        }
        return "Success";
    }
    
    @Override
    protected void done() {
        try {
            String result = get();
            System.err.println("Sf2 Thread Finished Successfully: "+result);
        } catch (Exception e) {
            System.err.println("Sf2 Thread Failed.");
        }
        closeCustomDialog();
        if(sf4Table != null){
            sendSummaryToSf4Table();
        }
        super.done(); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void sendSummaryToSf4Table(){
        try {
            String sectionName = tfSectionName.getText();
            String adviserName = tfAdviserName.getText();
            String gradeLevel = tfGradeLevel.getText();
            String schoolYear = tfSchoolYear.getText();

            String cLine = gradeLevel+"@@"+sectionName+"@@"+adviserName+"@@"
                    +summaryTable.getValueAt(2, 1)+"@@"+summaryTable.getValueAt(2, 2)+"@@"+summaryTable.getValueAt(2, 3)+"@@"
                    +summaryTable.getValueAt(4, 1)+"@@"+summaryTable.getValueAt(4, 2)+"@@"+summaryTable.getValueAt(4, 3)+"@@"
                    +summaryTable.getValueAt(5, 1)+"@@"+summaryTable.getValueAt(5, 2)+"@@"+summaryTable.getValueAt(5, 3)+"@@"
                    
                    +summaryTable.getValueAt(7, 1)+"@@"+summaryTable.getValueAt(7, 2)+"@@"+summaryTable.getValueAt(7, 3)+"@@"
                    +summaryTable.getValueAt(8, 1)+"@@"+summaryTable.getValueAt(8, 2)+"@@"+summaryTable.getValueAt(8, 3)+"@@"
                    +summaryTable.getValueAt(9, 1)+"@@"+summaryTable.getValueAt(9, 2)+"@@"+summaryTable.getValueAt(9, 3)+"@@";
            
            add_table_row(cLine, sf4Table);
        } catch (Exception e) {
            System.err.println("Error sending statistics to Sf4 @ sendSummaryToSf4Table: "+e.getMessage());
            //e.printStackTrace();
        }
    }
    private boolean evaluateRemarks(){
        int studCOunt = tableName.getRowCount();
        int transferredIn=0,transferredOut=0,dropped=0;
        try {
            for(int n=0;n<studCOunt;n++){
                transferredIn=0;
                transferredOut=0;
                dropped=0;
                
                lbLoadingMessage.setText("Evaluating Remarks of Student "+(n+1)+" of "+studCOunt);
                String gender = tableName.getValueAt(n, 4).toString();
                String remarks = tableName.getValueAt(n, 6).toString();

                if(remarks.trim().length() > 0){
                    try {
                        String remarkParts [] = remarks.split(":");
                        if(remarkParts.length == 2){    //It has the correct format
                            //System.err.println("Valide Remarks Found: "+remarkParts[0]);
                            if(remarkParts[0].contains("T/I")){
                                transferredIn++;
                            }if(remarkParts[0].contains("T/O")){
                                transferredOut++;
                            }if(remarkParts[0].contains("DRP")){
                                dropped++;
                            }
                        }
                    } catch (Exception e) {
                        System.err.println("Invalid remarks. Ignoring Count");
                    }
                }
                //Update counts
                int maleDrp = Integer.parseInt(summaryTable.getValueAt(7, 1).toString());
                int femaleDrp = Integer.parseInt(summaryTable.getValueAt(7, 2).toString());

                int maleTo = Integer.parseInt(summaryTable.getValueAt(8, 1).toString());
                int femaleTo = Integer.parseInt(summaryTable.getValueAt(8, 2).toString());

                int maleTi = Integer.parseInt(summaryTable.getValueAt(9, 1).toString());
                int femaleTi = Integer.parseInt(summaryTable.getValueAt(9, 2).toString());

                //Add count based on gender
                if(gender.contains("Female")){
                    femaleDrp += dropped;
                    femaleTo += transferredOut;
                    femaleTi += transferredIn;
                }else{
                    maleDrp += dropped;
                    maleTo += transferredOut;
                    maleTi += transferredIn;
                }
                summaryTable.setValueAt(maleDrp, 7, 1);
                summaryTable.setValueAt(femaleDrp, 7, 2);
                summaryTable.setValueAt(maleDrp+femaleDrp, 7, 3);

                summaryTable.setValueAt(maleTo, 8, 1);
                summaryTable.setValueAt(femaleTo, 8, 2);
                summaryTable.setValueAt(maleTo+femaleTo, 8, 3);

                summaryTable.setValueAt(maleTi, 9, 1);
                summaryTable.setValueAt(femaleTi, 9, 2);
                summaryTable.setValueAt(maleTi+femaleTi, 9, 3);
                
                Thread.sleep(threadDelay);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    private boolean removeStudents(){
        try {
            int rowCount = tableName.getRowCount();
            for (int n = rowCount-1; n >= 0; n--) {
                String dateEnrolled = tableName.getValueAt(n, 5).toString();
                if(skipStudent(dateEnrolled)){
                    my.remove_table_row(tableName, n);
                }
                Thread.sleep(threadDelay);
            }
            return true;
        }catch(InterruptedException x){
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    private boolean skipStudent(String dateEnrolled){
        String dtSelected [] = dateSelected.split("-");
        String dtEnrld [] = dateEnrolled.split(" ")[0].split("-");
        
        int sYr = Integer.parseInt(dtEnrld[0]);
        int sM = Integer.parseInt(dtSelected[1]);
        int sD = Integer.parseInt(dtEnrld[2]);
        int eYr = Integer.parseInt(dtEnrld[0]);
        int eM = Integer.parseInt(dtEnrld[1]);
        int eD = Integer.parseInt(dtEnrld[2]);
        
        //Skip this Student if Month Selected < Date Enrolled
        if(sYr != eYr){
            if(sYr<eYr){return true;}
        }else{
            if(sM != eM){
                if (sM < eM) {return true;}
            }else{
                if(sD != eD){
                    if(sD < eD){
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    //<editor-fold desc="Summary Functions">
    private void checkForFiveConsecutiveAbsences(){
        int studCount = tableName.getRowCount();
        int consecutiveAbsences;
        
        for(int n=0;n<studCount;n++){   //Counters have not been added at the last 3 rows
            String gender = tableName.getValueAt(n, 4).toString();
            consecutiveAbsences = 0;
            
            for(int x=0;x<schoolDaysColumnIndex.length;x++){
                
                String status = tableName.getValueAt(n, schoolDaysColumnIndex[x]).toString();
                //Check for consecutive absences by increasing by one if the next attendance is ABSENT and resetting to 0 otherwise
                if(status.length() == 1 && status.contains("P")){
                    consecutiveAbsences = 0;
                    continue;
                }if(status.length() == 1 && status.contains("A")){
                    consecutiveAbsences++;
                    continue;
                }if(status.contains("T")){
                    consecutiveAbsences = 0;
                }
            }
            int currMale = Integer.parseInt(summaryTable.getValueAt(6, 1).toString());
            int currFemale = Integer.parseInt(summaryTable.getValueAt(6, 2).toString());
            
            //System.err.println("Consecutive Absences: "+consecutiveAbsences);
            if(consecutiveAbsences >= 5){
                if(gender.contains("Female")){
                    currFemale++;
                }else{
                    currMale++;
                }
            }
            
            summaryTable.setValueAt(currMale, 6, 1);
            summaryTable.setValueAt(currFemale, 6, 2);
            summaryTable.setValueAt(currMale+currFemale, 6, 3);
        }
    }
    private boolean translateRemarks(){
        int studCount = tableName.getRowCount();
        
        try {
            for(int n=0;n<studCount;n++){
                String remarksString = tableName.getValueAt(n, 6).toString();
                String remarks [] = remarksString.split("!");

                try {
                    tableName.setValueAt(remarks[1], n, 6);
                } catch (Exception e) {
                    System.err.println("Error Occure @ translateRemarks: "+e.getMessage());
                    e.printStackTrace();
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    private void loadAverageAttendance(){
        try {
            lbLoadingMessage.setText("Calculating Average Daily Attendance...");
            int maleTotalPresent=0,femaleTotalPresent=0;
            int studentCount = tableName.getRowCount();
            DecimalFormat df = new DecimalFormat("#.#");
            df.setRoundingMode(RoundingMode.DOWN);
            
            for(int n=0;n<schoolDaysColumnIndex.length;n++){
                int currTotalMalePresent = Integer.parseInt(tableName.getValueAt(studentCount-3, schoolDaysColumnIndex[n]).toString());
                int currTotalFemalePresent = Integer.parseInt(tableName.getValueAt(studentCount-2, schoolDaysColumnIndex[n]).toString());
                
                maleTotalPresent += currTotalMalePresent;
                femaleTotalPresent += currTotalFemalePresent;
            }
            //Set Values in summary
            String aveMale = df.format((float)maleTotalPresent/(float)numberOfSchoolDays);
            String aveFemale = df.format((float)femaleTotalPresent/(float)numberOfSchoolDays);
            String aveTotal = df.format(((float)maleTotalPresent+(float)femaleTotalPresent)/(float)numberOfSchoolDays);
            
            summaryTable.setValueAt(!aveMale.contains("NaN")? aveMale : "0", 4, 1);
            summaryTable.setValueAt(!aveFemale.contains("NaN")? aveFemale : "0", 4, 2);
            summaryTable.setValueAt(!aveTotal.contains("NaN")? aveMale : "0", 4, 3);
            
            Thread.sleep(pauseDelay);
        } catch (Exception e) {
            System.err.println("Error found @ loadAverageAttendances()");
            e.printStackTrace();
        }
    }
    private void calculatePercentageOfAttendance(){
        try {
            lbLoadingMessage.setText("Calculating Pecentage of Attendance...");
            DecimalFormat df = new DecimalFormat("#.#");
            df.setRoundingMode(RoundingMode.DOWN);

            float maleADA = Float.parseFloat(summaryTable.getValueAt(4, 1).toString());
            float femaleADA = Float.parseFloat(summaryTable.getValueAt(4, 2).toString());

            float maleRegistered = Float.parseFloat(summaryTable.getValueAt(2, 1).toString());
            float femaleRegistered = Float.parseFloat(summaryTable.getValueAt(2, 2).toString());

            String percentMale = df.format((maleADA/maleRegistered) * 100);
            String percentFemale = df.format((femaleADA/femaleRegistered) * 100);
            String percentTotal = df.format(((maleADA+femaleADA)/(maleRegistered+femaleRegistered)) * 100);

            summaryTable.setValueAt(!percentMale.contains("NaN")?percentMale:"0", 5, 1);
            summaryTable.setValueAt(!percentFemale.contains("NaN")?percentFemale:"0", 5, 2);
            summaryTable.setValueAt(!percentTotal.contains("NaN")?percentTotal:"0", 5, 3);
            Thread.sleep(pauseDelay);
        } catch (Exception e) {
        }
    }
    private void fillUpMissingRecords(){
        
        int count = tableName.getRowCount();
        lbLoadingMessage.setText("Filling-up Missing Records...");
        progressBar.setMaximum(count);
        progressBar.setValue(0);
        
        try {
            for(int n=0;n<count;n++){   //Loop Students
                lbLoadingMessage.setText("Filling-up Missing Records...Student "+(n+1)+" of "+count);
                progressBar.setValue(n+1);
                for(int x=0;x<schoolDaysColumnIndex.length;x++){  //Loop Date Indeces
                    lbLoadingMessage.setText("Filling-up Missing Records...Student "+(n+1)+" of "+count+", "+(x+1)+"/"+schoolDaysColumnIndex.length+" Days Processed");
                    String currentValue = tableName.getValueAt(n, schoolDaysColumnIndex[x]).toString();
                    if(currentValue.trim().length() <= 0){
                        tableName.setValueAt(missingValuesSubstitute, n, schoolDaysColumnIndex[x]);
                    }
                    Thread.sleep(threadDelay);
                }
                Thread.sleep(pauseDelay);
            }
        } catch (Exception e) {
            System.err.println("Filling-up failed @ fillingUpMissingRecords()");
        }
    }
    private void loadSchoolDaysIndex(){
        schoolDaysColumnIndex = new int[25];
        for(int n=0;n<25;n++){
            schoolDaysColumnIndex[n] = -1;
        }
    }
    private void resetSchoolDaysIndex(){
        int temp [];
        int tempCount = 0;
        for(int n : schoolDaysColumnIndex){
            if(n != -1){
                tempCount++;
            }
        }
        temp = new int [tempCount];
        int index = 0;
        for(int n=0;n<25;n++){
            if(schoolDaysColumnIndex[n] != -1){
                temp[index] = schoolDaysColumnIndex[n];
                index++;
            }
        }
        schoolDaysColumnIndex = temp;
    }
    private boolean checkEnrollmentType(String gender,String dateEnrolled){
        
        boolean isEnrolledOnTime = true;
        
        String dtSelected [] = dateSelected.split("-");
        String dtEnrld [] = dateEnrolled.split(" ")[0].split("-");
        String ctOff [] = lastDayOfEnrollment.split("-");
        
        int sM = Integer.parseInt(dtSelected[1]);
        
        int eYr = Integer.parseInt(dtEnrld[0]);
        int eM = Integer.parseInt(dtEnrld[1]);
        int eD = Integer.parseInt(dtEnrld[2]);
        int cYr = Integer.parseInt(ctOff[0]);
        int cM = Integer.parseInt(ctOff[1]);
        int cD = Integer.parseInt(ctOff[2]);
        
        //Check if enrolled on time or late
        if(eYr != cYr){
            isEnrolledOnTime = eYr < cYr ? true : false;
        }else{
            if(eM != cM){
                isEnrolledOnTime = eM < cM ? true : false;
            }else{
                if(eD != cD){
                    isEnrolledOnTime = eD < cD ? true : false;
                }
            }
        }
        //Check if Month Selected is equal to Date Enrolled Month if Student is enrolled LATE
        if(!isEnrolledOnTime){
            if(sM != eM){
                System.err.println("Month Selected is Not equal to Enrolled Month...setting enrolled on time to true.");
                isEnrolledOnTime = true;
            }
        }
        //System.err.println("Checking Enrollment Type: "+(isEnrolledOnTime?"Enrolled":"Late"));
        
        //Put result to summary
        int crEnrMale = Integer.parseInt(summaryTable.getValueAt(0, 1).toString());
        int crEnrFemale = Integer.parseInt(summaryTable.getValueAt(0, 2).toString());
        
        int lateMale = Integer.parseInt(summaryTable.getValueAt(1, 1).toString());
        int lateFemale = Integer.parseInt(summaryTable.getValueAt(1, 2).toString());
        
        if(isEnrolledOnTime){
            if(gender.contains("Female")){
                crEnrFemale++;
            }else{
                crEnrMale++;
            }
        }else{
            if(gender.contains("Female")){
                lateFemale++;
            }else{
                lateMale++;
            }
        }
        summaryTable.setValueAt(crEnrMale, 0, 1);
        summaryTable.setValueAt(crEnrFemale, 0, 2);
        summaryTable.setValueAt(crEnrMale+crEnrFemale, 0, 3);
        
        summaryTable.setValueAt(lateMale, 1, 1);
        summaryTable.setValueAt(lateFemale, 1, 2);
        summaryTable.setValueAt(lateMale+lateFemale, 1, 3);
        
        summaryTable.setValueAt(crEnrMale+lateMale, 2, 1);
        summaryTable.setValueAt(crEnrFemale+lateFemale, 2, 2);
        summaryTable.setValueAt(crEnrMale+lateMale+crEnrFemale+lateFemale, 2, 3);
        
        return true;
    }
    private void getEnrollmentPercentage(){
        int rgMale = Integer.parseInt(summaryTable.getValueAt(2, 1).toString());
        int rgFemale = Integer.parseInt(summaryTable.getValueAt(2, 2).toString());
        
        int enMale = Integer.parseInt(summaryTable.getValueAt(0, 1).toString());
        int enFemale = Integer.parseInt(summaryTable.getValueAt(0, 2).toString());
        
        summaryTable.setValueAt(calculatePercentageOfEnrollment(rgMale, enMale), 3, 1);
        summaryTable.setValueAt(calculatePercentageOfEnrollment(rgFemale, enFemale), 3, 2);
        summaryTable.setValueAt(calculatePercentageOfEnrollment(rgMale+rgFemale, enMale+enFemale), 3, 3);
    }
    private String calculatePercentageOfEnrollment(float registeredLearners,float enrolledStudentsOnTime){
        DecimalFormat df = new DecimalFormat("#.#");
        df.setRoundingMode(RoundingMode.DOWN);
        
        String result = df.format(((float)enrolledStudentsOnTime/(float)registeredLearners)*100f);
        return result.contains("NaN")? "0" : result;
    }
    private boolean loadSummary(){
        try {
            clear_table_rows(summaryTable);
            String summary [] = {
                "Enrollment (1st Fri of June)@@0@@0@@0@@",
                "Late Enrollment Dur. the Month (Beyond Cut-off)@@0@@0@@0@@",
                "Registered Learners (End of Month)@@0@@0@@0@@",
                "Percentage of Enrollment@@0@@0@@0@@",
                "Average Daily Attendance@@0@@0@@0@@",
                "Percentage of Attendance@@0@@0@@0@@",
                "5 Consecutive Absences@@0@@0@@0@@",
                "Dropped Out@@0@@0@@0@@",
                "Transferred Out@@0@@0@@0@@",
                "Transferred In@@0@@0@@0@@",
            };

            for(String n : summary){
                add_table_row(n, summaryTable);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    private void loadAttendanceCounts(){
        int studentCount = tableName.getRowCount();
        
        try {
            lbLoadingMessage.setText("Counting Attendance...");
            progressBar.setMaximum(studentCount);
            progressBar.setValue(0);
            for(int n=0;n<studentCount;n++){    //Loop Students
                lbLoadingMessage.setText("Counting attendance of Student "+(n+1)+" of "+studentCount);
                progressBar.setValue(n+1);
                
                absent = 0;
                tardy = 0;
                for(int x=0;x<schoolDaysColumnIndex.length;x++){  //Loop School Days Indeces
                    lbLoadingMessage.setText("Counting attendance of Student "+(n+1)+" of "+studentCount
                            +", "+(x+1)+"/"+schoolDaysColumnIndex.length+" processed");
                    
                    String currentValue = tableName.getValueAt(n, schoolDaysColumnIndex[x]).toString();
                    if(currentValue.length()==1 && currentValue.contains("P")){
                        continue;
                    }if(currentValue.length()==1 && currentValue.contains("A")){
                        absent++;continue;
                    }if(currentValue.contains("T")){
                        if(currentValue.contains("TLC")){
                            //Is it considered present?
                            tardy++;
                        }if(currentValue.contains("TCC")){
                            tardy++;
                        }
                    }
                    Thread.sleep(threadDelay);
                }
                //Put results to column
                tableName.setValueAt(absent, n, 32);
                tableName.setValueAt(tardy, n, 33);
                
                Thread.sleep(pauseDelay);
            }
        } catch (Exception e) {
            System.err.println("Error found @ loadAttendanceCounts()"+e.getMessage());
        }
        
        String attendanceCounters [] = {
            "-@@-@@-@@<==Male Total Per Day==>@@-@@-@@-@@",
            "-@@-@@-@@<==Female Total Per Day==>@@-@@-@@-@@",
            "-@@-@@-@@<==Combined Total Per Day==>@@-@@-@@-@@",
        };
        
        for(String n : attendanceCounters){
            add_table_row(n, tableName,new int[]{7,17,22,27},Color.RED);
        }
        int malePresent,femalePresent;
        try {
            lbLoadingMessage.setText("Counting Present values...");
            //Count present
            for(int n=0;n<schoolDaysColumnIndex.length;n++){    //Loop Columns with attendance
                malePresent = 0;femalePresent = 0;
                for(int x=0;x<studentCount;x++){ //Length does not include the last 3 rows
                    String gender = tableName.getValueAt(x, 4).toString();
                    String attendanceStatus = tableName.getValueAt(x, schoolDaysColumnIndex[n]).toString();

                    if(attendanceStatus.length() == 1 && attendanceStatus.contains("P")){
                        if(gender.contains("Female")){
                            femalePresent++;
                        }else{
                            malePresent++;
                        }continue;
                    }
                }
                //Assign Values to the counters
                tableName.setValueAt(malePresent, studentCount, schoolDaysColumnIndex[n]);
                tableName.setValueAt(femalePresent, studentCount+1, schoolDaysColumnIndex[n]);
                tableName.setValueAt(malePresent+femalePresent, studentCount+2, schoolDaysColumnIndex[n]);
                
                Thread.sleep(pauseDelay);
            }
        } catch (Exception e) {
            System.err.println("Error found @ loadAttendanceCounts()"+e.getMessage());
        }
        try {
            lbLoadingMessage.setText("Counting Absent & Tardy values...");
            //Add absent & tardy counts
            int maleAbsent = 0,femaleAbsent = 0;
            int maleTardy = 0,femaleTardy = 0;
            for(int n=0;n<studentCount;n++){    //loop students
                String gender = tableName.getValueAt(n, 4).toString();
                int currentAbsent = Integer.parseInt(tableName.getValueAt(n, 32).toString());
                int currentTardy = Integer.parseInt(tableName.getValueAt(n, 33).toString());

                if(gender.contains("Female")){
                    femaleAbsent += currentAbsent;
                }else{
                    maleAbsent += currentAbsent;
                }
                if(gender.contains("Female")){
                    femaleTardy += currentTardy;
                }else{
                    maleTardy += currentTardy;
                }
            }
            tableName.setValueAt(maleAbsent, studentCount, 32);
            tableName.setValueAt(femaleAbsent, studentCount+1, 32);
            tableName.setValueAt(maleAbsent+femaleAbsent, studentCount+2, 32);

            tableName.setValueAt(maleTardy, studentCount, 33);
            tableName.setValueAt(femaleTardy, studentCount+1, 33);
            tableName.setValueAt(maleTardy+femaleTardy, studentCount+2, 33);
            
            Thread.sleep(pauseDelay);
        } catch (Exception e) {
            System.err.println("Error found @ loadAttendanceCounts()"+e.getMessage());
        }
    }
    //</editor-fold>
    //<editor-fold desc="Custom Functions">
    private void showCustomDialog(String title, JPanel customPanel, boolean isModal, int width, int height, boolean isResizable){
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
    public boolean add_table_row(String line,JTable tableName){
        String [] row=line.split("@@");
        Object [] rows = new Object[row.length];
        
        if(row[0].length() < 1){
            return false;
        }
        for(int n=0;n<row.length;n++){
            if(row[n].contains("null")){
                rows[n] = "";
            }else{
                rows[n] = row[n];
            }
            
        }
        
        DefaultTableModel model;
        
        model=(DefaultTableModel)tableName.getModel();
        model.addRow(rows);
        
        return true;
    }
    public boolean add_table_row(String line,JTable tableName,int [] selectedColumns,Color foreground){
        String [] row=line.split("@@");
        Object [] rows = new Object[row.length];
        
        if(row[0].length() < 1){
            return false;
        }
        for(int n=0;n<row.length;n++){
            if(row[n].contains("null")){
                rows[n] = "";
            }else{
                rows[n] = row[n];
            }
            
        }
        
        DefaultTableModel model;
        
        CustomCellRenderer cellRenderer = new CustomCellRenderer(tableName.getBackground(), foreground, tableName.getFont(),tableName.getSelectionForeground(),tableName.getSelectionBackground());
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        for(int n=0;n<tableName.getColumnCount();n++){
            for(int x=0;x<selectedColumns.length;x++){
                if(n == selectedColumns[x]){
                    tableName.getColumnModel().getColumn(n).setCellRenderer(cellRenderer);
                }
            }
        }
        
        model=(DefaultTableModel)tableName.getModel();
        model.addRow(rows);
        
        return true;
    }
    public void clear_table_rows(JTable table_nameTable){
        DefaultTableModel model=(DefaultTableModel) table_nameTable.getModel();
        model.setRowCount(0);
    }
    public String getStartAndEndDates(String dateT,boolean includeWeekends){
        /*
        //Function Query for getting dates
        
        SELECT 
        functionsoutput.id,
        functionsoutput.name,
        getStartingDay(now()) as 'startingDay',
        getLastDay(now()) as 'lastDay'

        FROM functionsoutput
        */
        lbLoadingMessage.setText("Determining Days...Connecting to Database");
        
        String [] result = return_values("getStartingDay('"+dateT+"+') as 'startingDay',getLastDay('"+dateT+"') as 'getLastDay'", "", "", new int [] {0,1});
        String [] dateStrings = null;
        if(result != null){
            //Convert day name to number
            String [] dates = result[0].split("@@");
            startingDate = dateT;
            endingDate = dates[1];
            if(dates[0].contains("Monday")){
                dates[0] = "1";
            }
            if(dates[0].contains("Tuesday")){
                dates[0] = "2";
            }
            if(dates[0].contains("Wednesday")){
                dates[0] = "3";
            }
            if(dates[0].contains("Thursday")){
                dates[0] = "4";
            }
            if(dates[0].contains("Friday")){
                dates[0] = "5";
            }
            if(dates[0].contains("Saturday")){
                dates[0] = "6";
            }
            if(dates[0].contains("Sunday")){
                dates[0] = "0";
            }
            
            //return new String[] {dates[2],dates[3]};
            dateStrings = new String[] {dates[0],dates[1]};
            
            System.out.println(dateStrings[0]+" "+dateStrings[1]);
            String [] lastDay = dateStrings[1].split("-");
            
            //0 = mon, 5-6 = sat-sun
            int currDay = Integer.parseInt(dateStrings[0]);
            
            
            String finalString = "";
            
            //Add spaces at beginning based on starting day
            if(!dateStrings[0].contains("0")){  //add spaces if day is not Sunday
                for(int n=0;n<Integer.parseInt(dateStrings[0])-1;n++){
                    finalString+=" @@";
                }
            }
            
            
            for(int n=0;n<Integer.parseInt(lastDay[2]);n++){
                if(includeWeekends){
                    finalString+=(n+1)+"@@";
                }else{
                    if(currDay != 0 && currDay != 6){
                        finalString+=(n+1)+"@@";
                    }else{
                        //finalString+=" "+"@@";
                        System.out.println("It's sat/sun. skipping");
                    }
                }
                
                
                if(currDay+1 > 6){
                    currDay = 0;
                }else{
                    currDay++;
                }
            }
            
            //System.err.println("Final dates: "+finalString);
            
            return finalString;
        }else{
            
        }
        return null;
    }
    public String [] return_values(String select,String from,String where,int [] order){
        String [] lines;
        String cLine;
        
        try {
            String url = myVariables.getIpAddress()+"returnValues.php?select="+select+"&from="+from+"&where="+where;
            //System.out.println(url);
            url = url.replace("%", "%25");
            url = url.replace(" ", "%20");
            url = url.replace("Ñ", "%25C3%2591");
            url = url.replace("ñ", "%25C3%25B1");
            
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            // optional default is GET
            con.setRequestMethod("GET");
            //add request header
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);
            
            if(responseCode != 200){
                JOptionPane.showMessageDialog(null, "Server Error. Please check your connection.");
                return null;
            }
            
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
               response.append(inputLine);
            }
            in.close();
            //print in String
            //System.out.println(response.toString());
            

            //Read JSON response and print
            JSONObject myResponse = new JSONObject(response.toString());
            JSONArray res = myResponse.getJSONArray("result");
            
            //Get column names
            
            
            
            if(res.length() > 0){
                //Get column names
                JSONObject sample = res.getJSONObject(0);
                cLine = "";
                
                //Display column index & name
                for(int n=0;n<sample.names().length();n++){
                    System.out.println(n+" "+sample.names().getString(n));
                }
                
                //Get values based on column name keys
                for(int n=0;n<res.length();n++){
                    JSONObject row = res.getJSONObject(n);
                    String temp = "";
                    for(int x=0;x<order.length;x++){
                        //System.err.println(row.names().getString(order[x]));
                        temp+=row.getString(row.names().getString(order[x]))+"@@";
                    }
                    cLine+=temp+"//";
                }
                cLine = cLine.replace("%C3%91", "Ñ");
                cLine = cLine.replace("%C3%B1", "ñ");
                
                lines = cLine.split("//");
                return lines;
            }else{
                System.err.println("No result");
            }
        } catch (Exception e) {
            System.err.println("Exception Found "+e.getLocalizedMessage());
        }
        
        return null;
    }
    //</editor-fold>
    //<editor-fold desc="Show Message Functions">
    public void showMessage(String message,int messageType){
        JFrame frem = new JFrame();
        frem.setAlwaysOnTop(true);
        ImageIcon ic = null;
        try {
            switch(messageType){
                case JOptionPane.PLAIN_MESSAGE:{
                    ic = getImageIcon(myVariables.getMsgUrlIcon());break;
                }case JOptionPane.INFORMATION_MESSAGE:{
                    ic = getImageIcon(myVariables.getMsgUrlIconSuccess());break;
                }case JOptionPane.ERROR_MESSAGE:{
                    ic = getImageIcon(myVariables.getMsgUrlIconFailed());break;
                }case JOptionPane.WARNING_MESSAGE:{
                    ic = getImageIcon(myVariables.getMsgUrlIconWarning());break;
                }
            }
            JOptionPane.showMessageDialog(frem, message, "Message",messageType,ic);
        } catch (Exception e) {
            System.err.println("No Icon found.");
            JOptionPane.showMessageDialog(frem, message, "Message", messageType);
        }
    }
    protected boolean getConfirmation(String message){
        JFrame frem = new JFrame();
        frem.setAlwaysOnTop(true);
        int choice = -1;
        try {
            choice = JOptionPane.showConfirmDialog(
                    frem,
                    message,
                    "Confirm Choice",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    getImageIcon(myVariables.getConfirmUrlIcon())
            );
        } catch (Exception e) {
            System.err.println("No Icons found.");
            choice = JOptionPane.showConfirmDialog(frem, message, "Confirm Choice", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        }
        System.err.println("Choice: "+choice);
        if(choice == JOptionPane.YES_OPTION){
            return true;
        }
        return false;
    }
    private ImageIcon getImageIcon(String fileDir){
        ImageIcon ii= new ImageIcon(getClass().getResource(fileDir));
        
        return ii;
    }
    //</editor-fold>
}
