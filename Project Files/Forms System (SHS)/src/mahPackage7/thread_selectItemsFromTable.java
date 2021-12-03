/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mahPackage7;

import java.awt.Component;
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
public class thread_selectItemsFromTable extends SwingWorker<String, Object>{
    //Main Variables
    JTable tableName;
    Component component;
    
    int columnIndex;
    String idToSearch;
    
    boolean showMessageOnError;
    //Functions Variables
    long threadDelay = 10;
    long pauseDelay = 10;
    private myFunctions my;
    //Dialog Properties
    private JDialog dialog;
    private JFrame jFrameName;
    private JPanel dialogPanel;
    private JLabel lbLoadingMessage;
    private JProgressBar progressBar;

    public thread_selectItemsFromTable(JTable [] tablesToUse,String [] stringsToUse,JTextField [] textFieldsToUse,JButton [] buttonsToUse,boolean [] booleansToUse) {
        //Main Variables
        tableName = tablesToUse[0];
        component = tablesToUse[1];
        columnIndex = Integer.parseInt(stringsToUse[0]);
        idToSearch = stringsToUse[1];
        
        showMessageOnError = booleansToUse[0];
        
        //For Loading Screen & Functions
        my = new myFunctions(true);
        
        jFrameName = myVariables.getCurrentLoadingFrame();
        dialogPanel = myVariables.getLoadingPanel();
        lbLoadingMessage = myVariables.getLbLoadingMessage();
        progressBar = myVariables.getProgressBar();
        
        //For thead Speed
        //long [] threadSpeeds = myVariables.getProcessingSpeedValue();
        //threadDelay = threadSpeeds[0];
        //pauseDelay = threadSpeeds[1];
    }
    
    @Override
    protected String doInBackground() throws Exception {
        showCustomDialog("Searching Loads", dialogPanel, false, 420, 220, true);
        progressBar.setMaximum(1);
        progressBar.setValue(1);
        lbLoadingMessage.setText("Searching...");
        
        tableName.clearSelection();
        int count = tableName.getRowCount();
        
        int firstResult = -1,lastResult = -1;
        for (int n = 0; n < count; n++) {
            String currentValue = tableName.getValueAt(n, columnIndex).toString();
            
            if(idToSearch.equals(currentValue)){
                if(firstResult == -1){
                    firstResult = n;
                    lastResult = n;
                }else{
                    lastResult = n;
                }
            }
            Thread.sleep(threadDelay);
        }
        try {
            my.showSelectedRow(tableName, firstResult);
            tableName.setRowSelectionInterval(firstResult, lastResult);
            //tableName.updateUI();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        if(firstResult == -1){
            if(showMessageOnError){
                my.showMessage("No Results Found...", JOptionPane.PLAIN_MESSAGE);
            }
            
            return "Task Complete...Empty Table";
        }
        
        return "Task Complete...";
    }

    @Override
    protected void done() {
        closeCustomDialog();
        super.done(); //To change body of generated methods, choose Tools | Templates.
    }
    
    //Dialog Functions
    private void showCustomDialog(String title, JPanel customPanel, boolean isModal, int width, int height, boolean isResizable){
        if(dialog != null && dialog.isVisible()){
            dialog.setSize(width, height);
            dialog.setTitle(title);
            dialog.add(customPanel);
            dialog.setLocationRelativeTo(jFrameName);
            System.err.println("Selection Dialog is already visible. Skipping...");
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
