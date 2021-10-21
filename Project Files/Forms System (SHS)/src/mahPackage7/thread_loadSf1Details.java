/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mahPackage7;

import java.awt.Dialog;
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

/**
 *
 * @author Phil Rey Paderogao
 */
public class thread_loadSf1Details extends SwingWorker<String, Object>{
    long threadDelay = 100;
    long pauseDelay = 500;
    
    //Main Variables
    private int males,females,total;
    private JTable tableName;
    private int birthdateTableColumnIndex;
    private String firstFridayOfJuneDate;
    private boolean waitForMainThreadToFinish;
    
    private JTextField tfMale,tfFemale,tfTotal;
    
    private JButton btnExport;
    //Dialog Properties
    private JDialog dialog;
    private JFrame jFrameName;
    private JPanel dialogPanel;
    private JLabel lbLoadingMessage;
    private JProgressBar progressBar;

    public thread_loadSf1Details(JTable [] tablesToUse, int birthdateTableColumnIndex, String [] stringsToUse,JTextField [] textFieldsToUse, JButton [] buttonsToUse, boolean waitForMainThreadToFinish) {
        this.tableName = tablesToUse[0];
        this.birthdateTableColumnIndex = birthdateTableColumnIndex;
        this.waitForMainThreadToFinish = waitForMainThreadToFinish;
        this.firstFridayOfJuneDate = stringsToUse[0];
        
        jFrameName = myVariables.getCurrentLoadingFrame();
        dialogPanel = myVariables.getLoadingPanel();
        lbLoadingMessage = myVariables.getLbLoadingMessage();
        progressBar = myVariables.getProgressBar();
        
        tfMale = textFieldsToUse[0];
        tfFemale = textFieldsToUse[1];
        tfTotal = textFieldsToUse[2];
        
        btnExport = buttonsToUse[0];
        
        //For thead Speed
        long [] threadSpeeds = myVariables.getProcessingSpeedValue();
        threadDelay = threadSpeeds[0];
        pauseDelay = threadSpeeds[1];
    }
    
    @Override
    protected String doInBackground() throws Exception {
        btnExport.setEnabled(false);
        if(waitForMainThreadToFinish){
            //System.err.println("Waiting for mainThread to Finish first...");
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
        tableName.setEnabled(false);
        showCustomDialog("Calculating Students' Age...", dialogPanel, false, 320, 220, false);
        //System.err.println("Starting Second THread");
        
        //set variables displayed
        males=0;
        females=0;
        total=0;
        lbLoadingMessage.setText("Starting Thread...");
        progressBar.setMinimum(0);
        progressBar.setMaximum(100);
        progressBar.setValue(0);
        tfMale.setText(String.valueOf(males));
        tfFemale.setText(String.valueOf(females));
        tfTotal.setText(String.valueOf(total));
        Thread.sleep(pauseDelay);
        int rowCount = tableName.getRowCount();
        for(int n=0;n<rowCount;n++){
            lbLoadingMessage.setText("Processing Records of Student "+(n+1)+" of "+rowCount);
            String birthDate = tableName.getValueAt(n, birthdateTableColumnIndex).toString();
            String age = getAgeInYearsMonths(firstFridayOfJuneDate, birthDate, false);
            String remarksString = tableName.getValueAt(n, 20).toString();
            String gender = tableName.getValueAt(n, 5).toString();
            
            if(gender.contains("Female")){
                females++;
            }else{
                males++;
            }
            total++;
            
            tableName.setValueAt(rearrangeBirthDate(birthDate), n, 6);
            tableName.setValueAt(gender.substring(0, 1), n, 5);
            tableName.setValueAt(age, n, birthdateTableColumnIndex+1);
            tableName.setValueAt(translateRemarks(remarksString, 1), n, 20);
            tfMale.setText(String.valueOf(males));
            tfFemale.setText(String.valueOf(females));
            tfTotal.setText(String.valueOf(total));
            Thread.sleep(threadDelay);
        }
        btnExport.setEnabled(true);
        return null;
    }

    @Override
    protected void done() {
        closeCustomDialog();
        super.done(); //To change body of generated methods, choose Tools | Templates.
    }
    private String translateRemarks(String remarksString,int schoolFormIndexExact){
        String remarks [] = remarksString.split("!");
        switch (schoolFormIndexExact){  //School Form 1-10
            case 1:{
                return remarks[0];
            }case 2:{
                return remarks[1];
            }
        }
        return null;
    }
    private String rearrangeBirthDate(String birthDate){
        //From yyyy-mm-dd to mm/dd/yyyy
        String temp [] = birthDate.split("-");
        return temp[1]+"/"+temp[2]+"/"+temp[0];
    }
    private String getAgeInYearsMonths(String dateConducted,String dateOfBirth,boolean includeMonths){
        String dateCon [] = dateConducted.split("-");
        String dateOfBrth [] = dateOfBirth.split("-");
        
        int yearConducted = Integer.parseInt(dateCon[0]);
        int monthConducted = Integer.parseInt(dateCon[1]);
        int yearBday = Integer.parseInt(dateOfBrth[0]);
        int monthBday = Integer.parseInt(dateOfBrth[1]);
        
        String finalAge = "";
        if(monthConducted<monthBday){
            finalAge = includeMonths?(yearConducted-yearBday-1)+": "+((12+monthConducted)-monthBday) : String.valueOf(yearConducted-yearBday-1);
        }else{
            finalAge = includeMonths?(yearConducted-yearBday)+": "+(monthConducted-monthBday) : String.valueOf(yearConducted-yearBday);
        }
        return finalAge;
    }
    
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
