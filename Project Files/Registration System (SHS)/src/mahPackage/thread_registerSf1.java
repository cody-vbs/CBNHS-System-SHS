package mahPackage;

import java.io.File;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import org.apache.commons.validator.GenericValidator;

/**
 *
 * @author Phil Rey Paderogao
 */
public class thread_registerSf1 extends SwingWorker<String, Object>{
    long threadDelay = 100;
    long pauseDelay = 500;
    //Main Variables
    JTable importTable;
    String fileLocation;
    String startingAddress;
    String endingAddress;
    
    int fileTypeSelected;
    
    JButton btnFileChooser;
    JButton btnCancel;
    JButton btnRegister;
    //<editor-fold desc="Load Variables">
    String lrn = "";
    String studentId,personalInfoId;
    String lastName,firstName,middleName,extensionName;
    String gender,age,birthDay,motherTongue,indigenousPeople,religion;
    String houseNo,brgy,mncplty,province;
    String fathersName,mothersName,guardiansName,relationship,contact;
    String remarks;
    //</editor-fold>
    //Dialog Properties
    myFunctions my;
    private JLabel lbLoadingMessage;
    private JProgressBar progressBar;
    private String dateFormats [] = {"MM/dd/yyyy","MM-dd-yyyy","MM/dd/yyyy"};

    public thread_registerSf1(JTable [] tablesToUse,String [] stringsToUse,JTextField [] textFieldsToUse,JButton [] buttonsToUse,boolean [] booleansToUse) {
        my = new myFunctions(true);
        //Main Variables
        importTable = tablesToUse[0];
        fileLocation = textFieldsToUse[0].getText();
        fileTypeSelected = Integer.parseInt(stringsToUse[0]);
        
        btnFileChooser = buttonsToUse[0];
        btnCancel = buttonsToUse[1];
        btnRegister = buttonsToUse[2];
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
        runningThread();
        int rowCount = importTable.getRowCount();
        progressBar.setMaximum(rowCount);
        progressBar.setValue(0);
        
        String result [] = null;
        int registered=0,updated=0,failed=0;
        boolean duplicateFound;
        
        for (int n = 0; n < rowCount; n++) {
            lbLoadingMessage.setText("Importing..."+(n+1)+"/"+rowCount);
            progressBar.setValue(n+1);
            lrn = importTable.getValueAt(n, 0).toString();
            
            switch(setValues(n)){
                case -1:{
                    throw new InterruptedException("Interrupted @ setValues()");
                }case 0:{
                    break;
                }case 1:{
                    continue;
                }default:{break;}
            }
            
            //<editor-fold desc="#1 Check for duplicate LRNs">
            setStatus(n, "Checking for Duplicates");
            duplicateFound = my.checkForDuplicates("students", "WHERE lrn='"+lrn+"'", myVariables.getStudentsOrder());
            Thread.sleep(threadDelay);
            //</editor-fold>
            
            //<editor-fold desc="#2 Register To Students Table">
            setStatus(n, "Saving Student");
            if(duplicateFound){
                //Get student id & Update Only
                result = my.return_values("id", "students", "WHERE lrn='"+lrn+"'", new int[]{0}, myVariables.isDebugModeOn());
                if(result == null){
                    setStatus(n, "Student not Found");
                    failed++;
                    continue;
                }
                studentId = my.getValueAtColumn(result[0], 0);
                
                String lastNameNew = extensionName.trim().length()>0? lastName+","+extensionName:lastName;
                String sets [] = {
                    "lName='"+lastNameNew+"'",
                    "fName='"+firstName+"'",
                    "mName='"+middleName+"'",
                    "sex='"+gender+"'"
                };
                if(!my.update_values("students", sets, "id='"+studentId+"'")){
                    setStatus(n, "Updating Student Failed");
                    failed++;
                    continue;
                }
            }else{
                //Create new entry
                String studentValues [] = {"null",lrn,lastName+","+extensionName,firstName,middleName,gender};
                if(!my.add_values("students", "id,lrn,lName,fName,mName,sex", studentValues)){
                    setStatus(n, "Saving Student Failed");
                    failed++;
                    continue;
                }
            }
            Thread.sleep(threadDelay);
            //</editor-fold>
            
            //<editor-fold desc="#3 Register To Student's Personal Info Table">
            setStatus(n, "Saving Personal Information");
            String sets [];
            //Add or Update Personal Info
            String columns = "id,stdId,bDate,age,mTongue,ip,rlgn,houseN,brgy,mncpl,prvnce,fName,mName,gName,rltnshp,contact,date";
            if (duplicateFound) {
                String setVariables = "bDate=VALUES(bDate),age=VALUES(age),"
                        + "mTongue=VALUES(mTongue),ip=VALUES(ip),rlgn=VALUES(rlgn),"
                        + "houseN=VALUES(houseN),brgy=VALUES(brgy),mncpl=VALUES(mncpl),"
                        + "fName=VALUES(fName),mName=VALUES(mName),gName=VALUES(gName),"
                        + "rltnshp=VALUES(rltnshp),contact=VALUES(contact),date=VALUES(date)";
                //Get student id & Update Only
                result = my.return_values("id", "personalinfo", "WHERE stdId='"+studentId+"'", new int[]{0}, myVariables.isDebugModeOn());
                if(result == null){
                    setStatus(n, "Student not Found");
                    failed++;
                    continue;
                }
                personalInfoId = my.getValueAtColumn(result[0], 0);
                
                sets = new String []{
                    personalInfoId+","+studentId+",'"+birthDay+"','"+age+"','"+motherTongue+"','"
                        +indigenousPeople+"','"+religion+"','"
                        +houseNo+"','"+brgy+"','"+mncplty+"','"+province+"','"
                        +fathersName+"','"+mothersName+"','"+guardiansName+"','"
                        +relationship+"','"+contact+"',now()"
                };
                
                if(!my.update_multiple_values("personalinfo",columns,setVariables,sets)){
                    setStatus(n,"Updating Personal Info Failed");
                    failed++;
                    continue;
                }
                updated++;
            }else{
                //Get student id of new registered student
                result = my.return_values("id", "students", "WHERE lrn='"+lrn+"'", new int[]{0}, myVariables.isDebugModeOn());
                if(result == null){
                    setStatus(n, "Student not Found");
                    failed++;
                    continue;
                }
                studentId = my.getValueAtColumn(result[0], 0);
                
                sets = new String []{
                    "null,"+studentId+",'"+birthDay+"','"+age+"','"+motherTongue+"','"
                        +indigenousPeople+"','"+religion+"','"
                        +houseNo+"','"+brgy+"','"+mncplty+"','"+province+"','"
                        +fathersName+"','"+mothersName+"','"+guardiansName+"','"
                        +relationship+"','"+contact+"',now()"
                };
                if(!my.add_multiple_values("personalinfo", columns, sets)){
                    setStatus(n, "Adding Personal Info Failed");
                    failed++;
                    continue;
                }
                registered++;
            }
            //</editor-fold>
            Thread.sleep(threadDelay);
            //#4 Set Status
            if(duplicateFound){
                setStatus(n, "Updated Registration");
            }else{
                setStatus(n, "Registered");
            }
            Thread.sleep(threadDelay);
        }
        //Show Import Message
        if(failed==0 && updated==0){
            my.showMessage(rowCount+" Students Registered Successfully.", JOptionPane.INFORMATION_MESSAGE);
        }else{
            if(failed == 0){
                my.showMessage(rowCount+" Students Imported.\n\nRegistered: "+registered+"\nUpdated: "+updated, JOptionPane.WARNING_MESSAGE);
            }else{
                my.showMessage(rowCount+ " Students Imported.\n\nRegistered: "+registered+"\nUpdated: "+updated+"\nFailed: "+failed, JOptionPane.ERROR_MESSAGE);
            }
        }
        lbLoadingMessage.setText("Registering Complete");
        return "Registering Complete...";
    }

    @Override
    protected void done() {
        closedThread();
        super.done();
    }
    
    //<editor-fold desc="Other Functions">
    private int setValues(int rowIndex){
        // -1 = interrupted, 0 = success, 1 = missing important values
        
        setStatus(rowIndex, "Processing");
        try {
            //Process Name
            String [] tempName = importTable.getValueAt(rowIndex, 1).toString().split(",");
            switch(tempName.length){
                case 0:{
                    setStatus(rowIndex, "No Name Found");
                    return 1;
                }case 1:{
                    setStatus(rowIndex, "Incomplete Name");
                    return 1;
                }case 2:{
                    lastName = tempName[0];
                    firstName = tempName[1];
                    middleName = " ";
                    extensionName = " ";
                    break;
                }case 3:{
                    lastName = tempName[0];
                    firstName = tempName[1];
                    middleName = tempName[2];
                    
                    extensionName = " ";
                    break;
                }case 4:{
                    lastName = tempName[0];
                    firstName = tempName[1];
                    switch(fileTypeSelected){
                        case 0:{
                            middleName = tempName[2];
                            extensionName = tempName[3];
                            break;
                        }case 1:{
                            middleName = tempName[3];
                            extensionName = tempName[2];
                            break;
                        }
                    }
                    break;
                }
            }
            gender = importTable.getValueAt(rowIndex, 2).toString().contains("F")? "Female" : "Male";
            birthDay = importTable.getValueAt(rowIndex, 3).toString();
            if(!checkBirthDate(birthDay)){
                setStatus(rowIndex, "Invalid Birthday");
                return 1;
            }
            birthDay = my.changeDateFormat(birthDay, dateFormats[fileTypeSelected], "yyyy-MM-dd");
            
            age = importTable.getValueAt(rowIndex, 4).toString();
            //birthPlace = importTable.getValueAt(rowIndex, 5).toString();
            
            motherTongue = importTable.getValueAt(rowIndex, 5).toString();
            indigenousPeople = importTable.getValueAt(rowIndex, 6).toString();
            religion = importTable.getValueAt(rowIndex, 7).toString();
            
            houseNo = importTable.getValueAt(rowIndex, 8).toString();
            brgy = importTable.getValueAt(rowIndex, 9).toString();
            mncplty = importTable.getValueAt(rowIndex, 10).toString();
            province = importTable.getValueAt(rowIndex, 11).toString();
            
            fathersName = importTable.getValueAt(rowIndex, 12).toString();
            mothersName = importTable.getValueAt(rowIndex, 13).toString();
            guardiansName = importTable.getValueAt(rowIndex, 14).toString();
            relationship = importTable.getValueAt(rowIndex, 15).toString();
            contact = importTable.getValueAt(rowIndex, 16).toString();
            
            remarks = importTable.getValueAt(rowIndex, 17).toString();// Remarks is for enrollment importing
            Thread.sleep(threadDelay);
            
            return 0;
        } catch (InterruptedException e) {
            return -1;
        }
    }
    private boolean checkBirthDate(String date){
        //System.err.println("Bdate: "+date);
        return GenericValidator.isDate(date, dateFormats[fileTypeSelected], true);
    }
    private void setStatus(int rowIndex,String message){
        importTable.setValueAt(message, rowIndex, 18); //Status Column index 18, column 19
    }
    //</editor-fold>
    //<editor-fold desc="Running Thread Functions">
    private void runningThread(){
        btnFileChooser.setEnabled(false);
        btnCancel.setEnabled(true);
        btnRegister.setEnabled(false);
    }
    private void closedThread(){
        btnFileChooser.setEnabled(true);
        btnCancel.setEnabled(false);
        btnRegister.setEnabled(true);
        //lbLoadingMessage.setText("Process complete...");
    }
    //</editor-fold>
}
