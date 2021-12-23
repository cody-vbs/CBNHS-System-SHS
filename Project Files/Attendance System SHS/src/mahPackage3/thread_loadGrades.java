/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mahPackage3;

import java.awt.Dialog;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

/**
 *
 * @author Phil Rey Paderogao
 */
public class thread_loadGrades extends SwingWorker<String, Object>{
    long threadDelay = 100;
    long pauseDelay = 500;
    myFunctions my;
    //Dialog Properties
    private JDialog dialog;
    private JFrame jFrameName;
    private JPanel dialogPanel;
    private JLabel lbLoadingMessage;
    private JProgressBar progressBar;
    
    //Main Variables
    private JTable studentsTable;
    private JTable gradesTable;
    
    private String sectionId;
    private String studentId;
    private String subjectsContained;
    
    private JTextField tfGeneralAverage;
    private JTextField tfFailedSubjects;
    
    private JButton btnLoadGrades;
    private JButton btnSaveEvaluation;
    
    private JRadioButton rbPromoted;
    private JRadioButton rbConditional;
    private JRadioButton rbRetained;
    private JRadioButton rbIncomplete;
    
    private DecimalFormat df;
    
    public thread_loadGrades(JTable [] tablesToUse,String [] stringsToUse,JTextField [] textFieldsToUse,JButton [] buttonsToUse,JRadioButton [] radioButtonsToUse) {
        my = new myFunctions(true);
        studentsTable = tablesToUse[0];
        gradesTable = tablesToUse[1];
        
        sectionId = stringsToUse[0];
        studentId = stringsToUse[1];
        subjectsContained = stringsToUse[2].substring(0,stringsToUse[2].length()-1);
        
        tfGeneralAverage = textFieldsToUse[0];
        tfFailedSubjects = textFieldsToUse[1];
        
        btnLoadGrades = buttonsToUse[0];
        btnSaveEvaluation = buttonsToUse[1];
        
        rbPromoted = radioButtonsToUse[0];
        rbConditional = radioButtonsToUse[1];
        rbRetained = radioButtonsToUse[2];
        rbIncomplete = radioButtonsToUse[3];
        //For Loading Screen
        jFrameName = myVariables.getCurrentLoadingFrame();
        dialogPanel = myVariables.getLoadingPanel();
        lbLoadingMessage = myVariables.getLbLoadingMessage();
        progressBar = myVariables.getProgressBar();
        
        df=new DecimalFormat("#.000");
        df.setRoundingMode(RoundingMode.DOWN);
    }

    @Override
    protected String doInBackground() throws Exception {
        try {
            btnLoadGrades.setEnabled(false);
            btnSaveEvaluation.setEnabled(false);
            
            showCustomDialog("Loading", dialogPanel, false, 420, 220, false);
            String subjectIds = subjectsContained.replace(":", ",");
            
            //<editor-fold desc="Get Teachers assigned to this section">
            progressBar.setMaximum(2);
            lbLoadingMessage.setText("Connecting to Database...1/2");
            progressBar.setValue(1);
            String assignedTeachers [] = my.return_values("*", "v_teacherloads", "WHERE sectionId='"+sectionId+"' AND subjectId IN("+subjectIds+") AND subjectCode NOT LIKE'ADV%'ORDER BY FIELD(subjectId,"+subjectIds+")", myVariables.getTeacherLoadsViewOrder());
            Thread.sleep(pauseDelay);
            //Load subjects based on teacherId,studentId,subjectId
            lbLoadingMessage.setText("Connecting to Database...2/2");
            progressBar.setValue(2);
            String teacherIds = "";
            for(int n=0;n<assignedTeachers.length;n++){
                if(teacherIds.length() == 0){
                    teacherIds = my.getValueAtColumn(assignedTeachers[n], 2);
                }else{
                    teacherIds+=","+my.getValueAtColumn(assignedTeachers[n], 2);
                }
            }
            String where = "WHERE sectionId='"+sectionId+"' AND studentId='"+studentId+"' AND subjectId IN("+subjectIds+") ORDER BY FIELD(subjectId,"+subjectIds+")";
            String result [] = my.return_values("*", "v_grades", where, myVariables.getGradesViewOrder());
            Thread.sleep(pauseDelay);
            //</editor-fold>
            
            my.clear_table_rows(gradesTable);
            if(result != null){
                //Load Grades
                boolean matchFound;
                int subjectCount = result.length;
                String subjectsOrder [] = subjectsContained.split(":");
                String userIds [] = teacherIds.split(",");
                
                int resultCount = result.length;
                int teacherCount = assignedTeachers.length;
                
                progressBar.setMaximum(teacherCount);
                progressBar.setValue(0);
                
                //System.err.println("Teachers: "+assignedTeachers.length+" Result: "+resultCount);
                //<editor-fold desc="Match ids">
                
                for(int n=0;n<teacherCount;n++){
                    lbLoadingMessage.setText("Loading Grades..."+(n+1)+" of "+teacherCount);
                    progressBar.setValue(n+1);
                    
                    int curUserId = Integer.parseInt(my.getValueAtColumn(assignedTeachers[n], 2));
                    int curSubjectId = Integer.parseInt(my.getValueAtColumn(assignedTeachers[n], 7));
                    String subjectCode = my.getValueAtColumn(assignedTeachers[n], 8);
                    /*
                    String subjectCode = my.getValueAtColumn(assignedTeachers[n], 8);
                    
                    //Add empty if its a mapeh subjec
                    if(subjectCode.startsWith("MPH")){
                        my.add_table_row(" @@"+sectionId+"@@"+studentId+"@@"+curUserId+"@@ @@ @@"+curSubjectId+"@@"+subjectCode+"@@"+my.getValueAtColumn(assignedTeachers[n], 9)+"@@",
                                gradesTable);
                    }
                    */
                    
                    //System.err.println("To Search: "+curUserId+","+curSubjectId);
                    //Find ids inside results
                    matchFound = false;
                    for(int x=0;x<resultCount;x++){
                        int resultUserId = Integer.parseInt(my.getValueAtColumn(result[x], 3));
                        int resultSubjectId = Integer.parseInt(my.getValueAtColumn(result[x], 8));
                        
                        //System.err.println("Result: "+resultUserId+","+resultSubjectId);
                        
                        if(curUserId == resultUserId && curSubjectId == resultSubjectId){
                            String status = my.getValueAtColumn(result[x], 13);
                            String statuses [] = status.split(":");
                            
                            my.add_table_row(my.setValueAtColumn(my.toNameFormat(result[x], new int []{4,5,6}), 11, statuses[4]), gradesTable);
                            matchFound = true;
                            break;
                        }
                    }
                    //Set missing grades
                    if(!matchFound && !subjectCode.startsWith("ADV")){
                        String name = my.getValueAtColumn(assignedTeachers[n], 3)+"@@"+my.getValueAtColumn(assignedTeachers[n], 4)+"@@"+my.getValueAtColumn(assignedTeachers[n], 5)+"@@";
                        String gender = my.getValueAtColumn(assignedTeachers[n], 6);
                        name = my.toNameFormat(name, new int []{0,1,2});
                        my.add_table_row("-1@@"+sectionId+"@@"+studentId+"@@"+curUserId+"@@"+name+gender+"@@"+
                                curSubjectId+"@@"+subjectCode+"@@"+my.getValueAtColumn(assignedTeachers[n], 9)+"@@"+
                                my.getValueAtColumn(assignedTeachers[n], 10)+"@@0@@Incomplete@@Missing@@",
                                gradesTable
                        );
                    }
                    Thread.sleep(threadDelay);
                }
                //</editor-fold>
                
                //Calculate GWA & Failed Subjects
                lbLoadingMessage.setText("Finalizing Stage 1/4: Calculating General Average...");
                progressBar.setMaximum(4);
                progressBar.setValue(0);
                float sum = 0;
                float gwa = 0;
                String subjectCode = "",remarks="",failedSubjects="";
                
                int gradesCount = gradesTable.getRowCount(),failedCount = 0,incCount = 0;
                for(int n=0;n<gradesCount;n++){
                    remarks = gradesTable.getValueAt(n, 11).toString();
                    subjectCode = gradesTable.getValueAt(n, 7).toString();
                    try {
                        sum+=Float.parseFloat(gradesTable.getValueAt(n, 10).toString());
                    } catch (Exception e) {
                    }
                    
                    switch(remarks){
                        case "Passed":{
                            break;
                        }case "Failed":{
                            if(failedSubjects.trim().length()<=0){
                                failedSubjects = subjectCode;
                            }else{
                                failedSubjects+=", "+subjectCode;
                            }
                            failedCount++;
                            break;
                        }case "Incomplete":{
                            if(failedSubjects.trim().length()<=0){
                                failedSubjects = subjectCode;
                            }else{
                                failedSubjects+=", "+subjectCode;
                            }
                            failedCount++;
                            incCount++;
                            break;
                        }
                    }
                }
                progressBar.setValue(1);
                Thread.sleep(pauseDelay);
                
                //Calculate GWA
                lbLoadingMessage.setText("Finalizing Stage 2/4: Calculating GWA...");
                try {
                    gwa = sum/gradesCount;
                } catch (Exception e) {
                    gwa = 0f;
                }
                tfGeneralAverage.setText(df.format(gwa));
                
                progressBar.setValue(2);
                Thread.sleep(pauseDelay);
                
                //Determine failed subjects
                lbLoadingMessage.setText("Finalizing Stage 3/4: Searching for Failed Subjects...");
                if(failedCount == 0){
                    tfFailedSubjects.setText(" ");
                }
                if(failedCount > 0 && failedCount < gradesCount){
                    tfFailedSubjects.setText(failedSubjects);
                }
                if(failedCount >= gradesCount){
                    tfFailedSubjects.setText("All Subjects");
                }
                progressBar.setValue(3);
                Thread.sleep(pauseDelay);
                
                //Set Evaluation
                lbLoadingMessage.setText("Finalizing Stage 4/4: Evaluating Student...");
                if(incCount == 0){
                    if(failedCount <= 0){
                        if(gwa >= 75f){
                            rbPromoted.setSelected(true);
                        }else{
                            rbRetained.setSelected(true);
                        }
                    }else{
                        if(failedCount <= 2){
                            rbConditional.setSelected(true);
                        }else{
                            rbRetained.setSelected(true);
                        }
                    }
                }else{
                    rbIncomplete.setSelected(true);
                }
                progressBar.setValue(4);
                Thread.sleep(pauseDelay);
            }else{
                my.showMessage("Student has no grades yet. Subject Teachers haven't submitted Grades yet.", JOptionPane.ERROR_MESSAGE);
            }
        } catch (InterruptedException e) {
            throw new InterruptedException("Interrupted By User.");
        } catch (NullPointerException x){
            x.printStackTrace();
            return "Error FOund: "+x.getMessage();
        } catch (Exception y){
            y.printStackTrace();
        }
        
        return "Completed Successfully";
    }

    @Override
    protected void done() {
        closeCustomDialog();
        btnLoadGrades.setEnabled(true);
        btnSaveEvaluation.setEnabled(true);
        try {
            System.err.println("Load grades finished: "+get());
        } catch (Exception e) {
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
