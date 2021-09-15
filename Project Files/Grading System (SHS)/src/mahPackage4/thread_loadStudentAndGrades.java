/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mahPackage4;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

/**
 *
 * @author CIC
 */
public class thread_loadStudentAndGrades extends SwingWorker<String, Object>{
    long threadDelay = 100;
    long pauseDelay = 500;
    
    //Main Variables
    JTable enrolledStudentsTable;
    
    String sectionId;
    String teacherId;
    String subjectId;
    
    JButton btnRefresh;
    
    
    //Dialog Properties
    myFunctions my;
    private JLabel lbLoadingMessage;
    private JProgressBar progressBar;
    
    public thread_loadStudentAndGrades(JTable [] tablesToUse,String [] stringsToUse,JTextField [] textFieldsToUse,JButton [] buttonsToUse,boolean [] booleansToUse) {
        my = new myFunctions(true);
        //Main Variables
        enrolledStudentsTable = tablesToUse[0];
        
        sectionId = stringsToUse[0];
        teacherId = stringsToUse[1];
        subjectId = stringsToUse[2];
        
        btnRefresh = buttonsToUse[0];
        //For Loading Screen
        lbLoadingMessage = myVariables.getLbLoadingMessage();
        progressBar = myVariables.getProgressBar();
        //For thead Speed
        long [] threadSpeeds = myVariables.getProcessingSpeedValue();
        threadDelay = threadSpeeds[0];
        pauseDelay = threadSpeeds[1];
    }
    @Override
    protected String doInBackground() throws Exception {
        btnRefresh.setEnabled(false);
        lbLoadingMessage.setText("Loading...");
        my.clear_table_rows(enrolledStudentsTable);
        
        //#1 Load Students based on section id
        lbLoadingMessage.setText("Connecting to Database...1/2");
        progressBar.setMaximum(1);
        progressBar.setValue(0);        
        int arrLength;
        String [] result = my.return_values(
                "*", "v_enrollment_minimal", "WHERE sectionId='"+sectionId+"'",
                myVariables.getEnrollmentViewMinimalOrder()
        );
        progressBar.setValue(1);
        Thread.sleep(pauseDelay);
        
        arrLength = result.length;
        if(result == null){
            return "No Students Found on this Section";
        }
        //#1.1 Combine all studentIds for search Ex: 12,123,12,54,645
        String studentIds = "";
        
        for(int n=0;n<result.length;n++){
            studentIds+=my.getValueAtColumn(result[n], 1);
            if(n<arrLength-1){
                studentIds+=",";
            }
        }
        
        //#2 Load grades based on section id and subjectId
        lbLoadingMessage.setText("Connecting to Database...2/2");
        progressBar.setValue(0);
        
        String [] result2 = my.return_values(
            "*", "grades",
            "WHERE sectionId='"+sectionId+"' AND subjectId='"+subjectId+"' AND studentId IN ("+studentIds+")",
            myVariables.getGradesOrder()
        );
        progressBar.setValue(1);
        Thread.sleep(pauseDelay);
        
        //#3 Load Everything to table
        lbLoadingMessage.setText("Loading Students...");
        progressBar.setMaximum(result.length);
        progressBar.setValue(0);
        
        int studentIdToFind,currId;
        String gradeDetails;
        boolean matchFound;
        
        for (int n = 0; n < result.length; n++) {
            lbLoadingMessage.setText("Loading Students..." + (n+1) + " of " + result.length);
            progressBar.setValue(n+1);
            //System.err.println(result[n]);
            result[n] = my.toNameFormat(result[n], new int[]{3,4,5});
            studentIdToFind = Integer.parseInt(my.getValueAtColumn(result[n], 1));
            gradeDetails = ""; matchFound = false;
            
            
            //#3.1 Find Grade based on student ID
            if(result2 != null){
                for (int x = 0; x < result2.length; x++) {
                    currId = Integer.parseInt(my.getValueAtColumn(result2[x], 1));
                    //System.err.println(result2[x]);

                    //System.err.println("toFind "+studentIdToFind+": curr "+ currId);
                    if(studentIdToFind == currId){
                        matchFound = true;
                        gradeDetails = my.skipColumns(result2[x], new int [] {1,2,3});
                        break;
                    }
                }
            }
            
            if(matchFound){
                //System.out.println("Match Found..");
                my.add_table_row(
                    my.skipColumns(result[n], new int []{6})+gradeDetails,
                    enrolledStudentsTable
                );
            } else{
                my.add_table_row(
                    my.skipColumns(result[n], new int []{6})+"-1@@--@@--@@--@@--@@--@@--@@--@@",
                    enrolledStudentsTable
                );
            }
            Thread.sleep(threadDelay);
        }
        return "Loading Complete";
    }

    @Override
    protected void done() {
        try {
            lbLoadingMessage.setText(this.get());
        } catch (Exception e) {
            lbLoadingMessage.setText("Loading Failed.");
        }
        btnRefresh.setEnabled(true);
        super.done(); //To change body of generated methods, choose Tools | Templates.
    }
}
