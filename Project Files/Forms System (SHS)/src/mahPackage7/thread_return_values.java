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
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Phil Rey Paderogao
 */
public class thread_return_values extends SwingWorker<Integer, Object>{
    long threadDelay = 100;
    long pauseDelay = 500;
    int batchCount = 10;
    myFunctions my;
    //Main Properties
    private String toSearch;
    private String select,from,where;
    private int [] order;
    private JTable tableName;
    private int [] combineColumns;
    private boolean toNameFormat;
    private boolean toPrintFormat;
    private JLabel resultText;
    
    Color selectedColor;
    int [] selectedColumnIndex;
    //Dialog Properties
    JDialog dialog;
    JFrame jFrameName;
    
    JPanel dialogPanel;
    JLabel lbLoadingMessage;
    JProgressBar progressBar;

    public thread_return_values(String toSearch,String select, String from, String where, int[] order, JTable tableName,int [] combineColumns,boolean [] booleansToUse,JLabel resultText,int [] coloredColumnIndex,Color selectedColor) {
        my = new myFunctions(true);
        
        this.select = select;
        this.from = from;
        this.where = where;
        this.order = order;
        this.tableName = tableName;
        this.jFrameName = myVariables.getCurrentLoadingFrame();
        this.dialogPanel = myVariables.getLoadingPanel();
        this.lbLoadingMessage = myVariables.getLbLoadingMessage();
        this.progressBar = myVariables.getProgressBar();
        this.combineColumns = combineColumns;
        this.toNameFormat = booleansToUse[0];
        toPrintFormat = booleansToUse[1];
        this.resultText = resultText;
        this.toSearch = toSearch;
        
        this.selectedColor = selectedColor;
        this.selectedColumnIndex = coloredColumnIndex;
        
        //For thead Speed
        long [] threadSpeeds = myVariables.getProcessingSpeedValue();
        threadDelay = threadSpeeds[0];
        pauseDelay = threadSpeeds[1];
    }
    
    @Override
    protected Integer doInBackground(){
        try {
            tableName.setEnabled(false);
            showCustomDialog("Searching...", dialogPanel, true, 320, 220, false);
            System.err.println("Starting Background THread");
            //dialogPanel.updateUI();
            //initialize dialog values
            
            //set variables displayed
            lbLoadingMessage.setText("Starting Thread...");
            progressBar.setMinimum(0);
            progressBar.setMaximum(100);
            progressBar.setValue(0);
            Thread.sleep(pauseDelay);

            //Start search
            lbLoadingMessage.setText("Retrieving from Database...");
            String [] result = return_values();
            my.clear_table_rows(tableName);
            
            Thread.sleep(pauseDelay);
            if(result != null){
                lbLoadingMessage.setText("Processing Result...");
                if(resultText != null){
                    if(result.length > 1){
                        resultText.setText("Showing "+result.length+" results for '"+toSearch+"'.");
                    }else{
                        resultText.setText("Showing "+result.length+" result for '"+toSearch+"'.");
                    }
                }
                progressBar.setMaximum(result.length);
                Thread.sleep(threadDelay);

                for(int n=0;n<result.length;n++){
                    lbLoadingMessage.setText("Processing Result..."+(n+1)+" of "+result.length);
                    progressBar.setValue(n+1);

                    if(combineColumns != null){
                        if(toNameFormat){
                            if(!toPrintFormat){
                                result[n] = my.toNameFormat(result[n], combineColumns);  
                            }else{
                                result[n] = my.toNameFormatFull2(result[n], combineColumns);
                                //result[n] = my.toNameFormatPrintedName(result[n], combineColumns,true);
                            }
                            
                        }else{
                            result[n] = my.combineColumns(result[n], combineColumns);
                        }
                        
                        if(selectedColor == null){
                            my.add_table_row(result[n], tableName);
                        }else{
                            my.add_table_row(result[n], tableName, selectedColumnIndex, selectedColor);
                        }
                        
                    }else{
                        if(selectedColor == null){
                            my.add_table_row(result[n], tableName);
                        }else{
                            my.add_table_row(result[n], tableName, selectedColumnIndex, selectedColor);
                        }
                    }
                    
                    if(n%batchCount==0 && n!=0){
                        Thread.sleep(pauseDelay); //Hold the process for the CPU to rest.
                        System.err.println("Thread resting.");
                    }else{
                        Thread.sleep(threadDelay);
                    }
                }
            }else{
                if(resultText != null){
                    resultText.setText("Showing 0 results for '"+toSearch+"'.");
                }
                return -1;
            }
        } catch (InterruptedException e) {
            System.err.println("Main Thread Interrupted: "+e.getMessage());
            //e.printStackTrace();
            return -1;
        }
        
        return 0;
    }

    @Override
    protected void done() {
        System.out.println("Background Task Done");
        tableName.setEnabled(true);
        closeCustomDialog();
        super.done();
    }
    
    
    //Custom Functions
    private String [] return_values(){
        String [] lines;
        String cLine;
        
        try {
            String url = myVariables.getIpAddress()+"returnValues.php?select="+select+"&from="+from+"&where="+where;
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
            showMessage("Lost Connection to Database.\n\nMessage: "+e.getLocalizedMessage(),JOptionPane.ERROR_MESSAGE);
        }
        return null;
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
