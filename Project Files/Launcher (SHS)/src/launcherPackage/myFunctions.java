/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package launcherPackage;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import org.json.JSONArray;
import org.json.JSONObject;

public class myFunctions {
    public myFunctions(){
        try {
            loadSettings();
        } catch (Exception e) {
            System.err.println("Error Loading Settings");
        }
    }
    
    public void openWindow(JFrame currentWindow,JFrame targetWindow){
        currentWindow.dispose();
        targetWindow.setVisible(true);
    }
    public boolean writeSettings(){
        String fileName = "modules/settings.txt";
        try {
            //Prepare Values
            String [] values = {
                "[0] ip_address="+myVariables.getIpAddressOnly(),
                "[1] school_name="+myVariables.getSchoolName(),
                "[2] school_address="+myVariables.getSchoolAddress(),
                "[3] school_id="+myVariables.getSchoolId(),
                "[4] district="+myVariables.getDistrict(),
                "[5] division="+myVariables.getDivision(),
                "[6] region="+myVariables.getRegion(),
                "[7] remember_me=false",
                "[8] auto_login=false",
                "[9] saved_userName=username",
                "[10] saved_password=password",
                "[11] debug_mode="+myVariables.isDebugModeOn(),
                "[12] school_head_name="+myVariables.getPrincipal(),
                "[13] division_representative="+myVariables.getDivisionRepresentative(),
                "[14] division_superintendent="+myVariables.getDivisionSuperintendent(),
                "[15] speed="+myVariables.getLoadingSpeed()
            };
            
            FileWriter fw = new FileWriter(fileName);
            for (int n = 0; n < values.length; n++) {
                fw.write(values[n]);
                if(n!=values.length-1){
                    fw.write("\n");
                }
            }
            fw.close();
            
            return true;
        } catch (Exception e) {
            System.err.println("Error: "+e.getLocalizedMessage());
            //JOptionPane.showMessageDialog(null, "Cannot Find \""+fileName+"\" file.");
        }
        return false;
    }
    public void loadSettings() throws IOException{
        try {
            File file = new File("modules/settings.txt");
            //File file = new File(getClass().getResource("modules/settings.txt").toURI());
            BufferedReader br = new BufferedReader(new FileReader(file));
            
            
            
            String st = "";
            String result="";
            
            System.out.println("Loading Settings from \"settings.txt\"...");
            
            while ((st = br.readLine()) != null) {
                String value [] = st.split("=");
                result+=value[1]+"@@";
            }
            
            System.out.println("Settings Loaded Successfully");
            String settings[] = result.split("@@");
            
            myVariables.setIpAddress("http://"+settings[0]+"/CBNHSSystemFinal/");
            myVariables.setIpAddressOnly(settings[0]);
            myVariables.setSchoolName(settings[1]);
            myVariables.setSchoolAddress(settings[2]);
            myVariables.setSchoolId(settings[3]);
            myVariables.setDistrict(settings[4]);
            myVariables.setDivision(settings[5]);
            myVariables.setRegion(settings[6]);
            
            myVariables.setPrincipal(settings[12]);
            myVariables.setDivisionRepresentative(settings[13]);
            myVariables.setDivisionSuperintendent(settings[14]);
            
            try {
                myVariables.setLoadingSpeed(Integer.parseInt(settings[15]));
            } catch (Exception e) {
                myVariables.setLoadingSpeed(0);
            }
            
            myVariables.setDebugMode(settings[11].contains("true"));
            
        }catch (Exception e) {
            System.err.println("Error: "+e.getLocalizedMessage());
            JOptionPane.showMessageDialog(null, "Cannot Find \"settings.txt\" file.");
            System.exit(0);
        }
    }
    //<editor-fold desc="Tabbed Pane Functions">
    public void select_tab(JTabbedPane tabName,int selectedIndex){
        tabName.setSelectedIndex(selectedIndex);
    }
    public void remove_multiple_tabs(JTabbedPane tabName,int [] indexASC){
        for(int n=indexASC.length-1 ; n>=0 ; n--){
            try {
                tabName.removeTabAt(indexASC[n]);
            } catch (Exception e) {
                System.err.println("Tab already removed.");
            }
        }
    }
    //</editor-fold>
    //<editor-fold desc="TABLE FUNCTIONS">
    /**
    * By: <b>Phil Rey E. Paderogao</b>
    * <p>
    * Searches an <b>ITEM_TO_SEARCH</b> from the database from the selected TABLE_INDEX. <b>LODI</b>
    * 
    * @param where MYSQL where condition for searching. Can be blank.
    * @param resultTable JTABLE to put the result inside.
    * @param viewTableIndex table to search at.
    * @param skipColumns array of column indexes to skip. CAN BE NULL
    * @param combineColumns array of column indexes to Combine into one column. CAN BE NULL
    * @param toNameFormat of combineColumns array must be combined in a name format. OPTIONAL
    * @param clearTable set TRUE if you want to clear the table before inserting new DATA. FALSE if you wish to append results.
    */
    public void searchItem(String where,JTable resultTable,int viewTableIndex,int [] skipColumns,int [] combineColumns,boolean toNameFormat,boolean clearTable,JLabel resultText,JTextField searchField,boolean allowEmptyFields){
        if(searchField != null){
            if(searchField.getText().length() <=0 && !allowEmptyFields){
                showMessage("Please search someting", JOptionPane.ERROR_MESSAGE);
                if(resultText!= null){
                    resultText.setText("Search using the search bar...");
                }
                return;
            }
        }
        
        
        String from="";
        int [] order = null;
        switch(viewTableIndex){
            case 0:{
                from = "students";
                order = myVariables.getStudentsOrder();
                break;
            }case 1:{
                from = "subjects";
                order = myVariables.getSubjectOrder();
                break;
            }case 2:{
                from = "loads";
                order = myVariables.getSubjectLoadsOrder();
                break;
            }case 3:{
                from = "users";
                order = myVariables.getUsersOrder();
                break;
            }case 4:{
                from = "v_sections";
                order = myVariables.getSectionsOrder();
                break;
            }case 5:{
                from = "v_teacherloads";
                order = myVariables.getTeacherLoadsViewOrder();
                break;
            }case 6:{
                from = "v_enrollment_minimal";
                order = myVariables.getEnrollmentViewMinimalOrder();
                break;
            }case 7:{
                from = "attendance";
                order = myVariables.getAttendanceOrder();
                break;
            }default:{
                System.err.println("View table index out of bounds. Please check your index selected.");
                return;
            }
        }
        
        String  [] result = return_values("*", from, where, order);
        
        
        if(result != null){
            if(clearTable){
                clear_table_rows(resultTable);
            }
            for(int n=0;n<result.length;n++){
                if(skipColumns != null){
                    result[n] = skipColumns(result[n], skipColumns);
                }
                if(combineColumns != null){
                    if(toNameFormat){
                        result[n] = toNameFormat(result[n], combineColumns);
                    }else{
                        result[n] = combineColumns(result[n], combineColumns);
                    }
                }
                //System.err.println(result[n]);
                add_table_row(result[n], resultTable);
            }
            
            if(resultText!= null){
                resultText.setText("Showing "+result.length+" result(s) for '"+searchField.getText()+"'.");
            }
        }else{
            showMessage("No Results found.", JOptionPane.PLAIN_MESSAGE);
            clear_table_rows(resultTable);
            if(resultText!= null){
                resultText.setText("Showing 0 results for '"+searchField.getText()+"'.");
            }
        }
    }
    /**
    * By: <b>Phil Rey E. Paderogao</b>
    * <p>
    * Centers all of the <b>TABLE_NAME's</b> Headers & columns
    * 
    * @param tableName JTABLE name to center.
    * @param cellRenderer Centered cell renderer.
    */
    protected void centerTable(JTable tableName,DefaultTableCellRenderer cellRenderer){
        centerHeaders(tableName);
        centerAllColumns(tableName, cellRenderer);
    }
    /**
    * By: <b>Phil Rey E. Paderogao</b>
    * <p>
    * Centers all of the <b>TABLE_NAME's</b> Headers and with a selected number of columns to center
    * 
    * @param tableName JTABLE name to center.
    * @param selectedColumns array of column indexes to center.
    * @param cellRenderer Centered cell renderer.
    */
    protected void centerTable(JTable tableName,int [] selectedColumns,DefaultTableCellRenderer cellRenderer){
        centerHeaders(tableName);
        centerSelectedColumns(selectedColumns, tableName, cellRenderer);
    }
    private void centerSelectedColumns(int [] toCenter,JTable tableName,DefaultTableCellRenderer cellRenderer){
        for(int n=0;n<tableName.getColumnCount();n++){
            for(int x=0;x<toCenter.length;x++){
                if(n==toCenter[x]){
                    tableName.getColumnModel().getColumn(n).setCellRenderer(cellRenderer);
                    break;
                }
            }
        }
    }
    private void centerAllColumns(JTable tableName,DefaultTableCellRenderer cellRenderer){
        for(int n=0;n<tableName.getColumnCount();n++){
            tableName.getColumnModel().getColumn(n).setCellRenderer(cellRenderer);
        }
    }
    private void centerHeaders(JTable tableName){
        DefaultTableCellRenderer cellRenderer = (DefaultTableCellRenderer) tableName.getTableHeader().getDefaultRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
    }
    protected void hideColumns(JTable tableName,int [] columnIndex){
        TableColumnModel columnModel = tableName.getColumnModel();
        
        for(int n=0;n<columnIndex.length;n++){
            columnModel.getColumn(columnIndex[n]).setWidth(0);
            columnModel.getColumn(columnIndex[n]).setMinWidth(0);
            columnModel.getColumn(columnIndex[n]).setMaxWidth(0);
        }
    }
    
    //</editor-fold>
    //<editor-fold desc="CRUD METHODS">
    //C= Create Method //
    public boolean add_values(String tableName,String columnNames,String [] values){
        String toSend = "";
        String [] column = values;
        for(int n=0;n<column.length;n++){
            if(column[n].contains("null")){
                toSend+=column[n];
            }else{
                if(column[n].contains("now()")){
                    toSend+=column[n];
                }else{
                    toSend+="'"+column[n]+"'";
                }
            }            
            if(n!=column.length-1){
                toSend+=",";
            }
        }
        try {
            String url = myVariables.getIpAddress()+"insertValues.php?tName="+tableName+"&cNames="+columnNames+"&cValues=";
            url = url.replace("%", "%25");
            toSend = toSend.replace("%", "%25");
            toSend = toSend.replace("&", "%26");
            url += toSend;
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
            JSONArray res = myResponse.getJSONArray("queryResult");
            //System.out.println(res.getJSONObject(0).getString("result"));
            
            return true;
        } catch (Exception e) {
            System.err.println("Exception Found");
            return false;
        }
    }
    //C= Create Method Multiple//
    public boolean add_multiple_values(String tableName,String columnNames,String [] values){
        String toSend = "";
        String [] column = values;
        for(int n=0;n<column.length;n++){
            if(column[n].contains("null")){
                toSend+=column[n];
            }else{
                if(column[n].contains("now()")){
                    toSend+=column[n];
                }else{
                    toSend+="'"+column[n]+"'";
                }
            }            
            if(n!=column.length-1){
                toSend+="@@";
            }
        }
        System.out.println(toSend);
        
        try {
            String url = myVariables.getIpAddress()+"insertMultipleValues.php?tName="+tableName+"&cNames="+columnNames+"&cValues=";
            url = url.replace("%", "%25");
            toSend = toSend.replace("%", "%25");
            toSend = toSend.replace("&", "%26");
            url += toSend;
            url = url.replace(" ", "%20");
            url = url.replace("Ñ", "%25C3%2591");
            url = url.replace("ñ", "%25C3%25B1");
            
            System.out.println(url);
            
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            // optional default is GET
            con.setRequestMethod("GET");
            //add request header
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            int responseCode = con.getResponseCode();
            
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);
            
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
            JSONArray res = myResponse.getJSONArray("queryResult");
            //System.out.println(res.getJSONObject(0).getString("result"));
           
            return true;
        } catch (Exception e) {
            System.err.println("Exception Found");
            return false;
        }
    }
    //R= Read Method //
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
            showMessage("Lost Connection to Database. \n\nError: "+e.getLocalizedMessage(), JOptionPane.ERROR_MESSAGE);
            System.err.println("Exception Found "+e.getLocalizedMessage());
        }
        
        return null;
    }
    //U= Update Method //
    protected  boolean update_multiple_values(String tableName,String columnNames,String onDuplicateFoundUpdateWhat,String [] rows){
        String toSend = "";
        String [] columns = rows;
        //Sort rows
        for(int n=0;n<columns.length;n++){
            toSend += columns[n];
            if(n < columns.length-1){
                toSend+="@@";
            }
        }
        
        try {
            String url = myVariables.getIpAddress()+"updateMultipleValues.php?tName="+tableName+"&cNames="+columnNames+"&dPlicate="+onDuplicateFoundUpdateWhat+"&cValues=";
            url = url.replace("%", "%25");
            toSend = toSend.replace("%", "%25");
            toSend = toSend.replace("&", "%26");
            url += toSend;
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
            JSONArray res = myResponse.getJSONArray("queryResult");
            //System.out.println(res.getJSONObject(0).getString("result"));
            
            return true;
        } catch (Exception e) {
            System.err.println("Exception Found");
            return false;
        }
    }
    //JSON Query
    public boolean update_values(String tableName,String [] sets, String where){
        String set = "";
        for(int n=0;n<sets.length;n++){
            if(n!=sets.length-1){
                set+=sets[n]+",";
            }else{
                set+=sets[n];
            }
        }
        
        try {
            String url = myVariables.getIpAddress()+"updateValues.php?table="+tableName+"&set="+set+"&where="+where;
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
            JSONArray res = myResponse.getJSONArray("updateResult");
            //System.out.println(res.getJSONObject(0).getString("result"));
            
            return true;
        } catch (Exception e) {
            System.err.println("Exception Found");
            return false;
        }
        
        
    }
    //D= Delete Method // 
    //JSON query
    protected boolean delete_values(String from,String where){
        try {
            String url = myVariables.getIpAddress()+"deleteValues.php?from="+from+"&where="+where;
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
            JSONArray res = myResponse.getJSONArray("isDeleted");
            //System.out.println(res.getJSONObject(0).getString("status"));
            
            return true;
        } catch (Exception e) {
            System.err.println("Exception Found");
            return false;
        }
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
    //<editor-fold desc="Other Functions">
    public String getDateNow(boolean includeTime){
        String result [] = return_values("now() AS 'dateNow'", "", "", new int [] {0});
        if(result != null){
            String dateNow = getValueAtColumn(result[0], 0);
            
            if(includeTime){
                return dateNow;
            }else{
                String dates [] = dateNow.split(" ");
                return dates[0];
            }
        }else{
            return null;
        }
    }
    
    public String from12To24HourFormat(String time12Hour){
        try {
            String time [] = time12Hour.split(" ");
            String temp [] = time[0].split(":");
            int hour = Integer.valueOf(temp[0]);
            int minute = Integer.valueOf(temp[1]);
            int seconds = Integer.valueOf(temp[2]);
            String meridan = time[1];
            
            String finalTime = "";
            //Check for invalid time
            if(hour > 12 || hour < 1){
                throw new Exception("Invalid Hour.");
            }
            if(minute < 0 || minute > 59){
                throw new Exception("Invalid Minute.");
            }
            
            if(meridan.contains("PM") || meridan.contains("pm")){
               hour+=12;
            }
            finalTime += hour<10? "0"+hour : hour;
            finalTime+=":";
            finalTime += minute<10? "0"+minute : minute;
            finalTime+=":";
            finalTime+=seconds<10? "0"+seconds : seconds;
            
            return finalTime;
        } catch (Exception e) {
            showMessage("Invalid time provided. Time must be in a '12:00:00 AM' format.\nMore info: "+e.getMessage(), JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    public String from24To12HourFormat(String time24Hour){
        
        return null;
    }
    
    public boolean checkForDuplicates(String tableName,String whereLimitExluded,int [] order){
        whereLimitExluded +=" LIMIT 1"; //For fast search. You only need to find at least 1 dupliclate
        String result [] = return_values("*", tableName, whereLimitExluded, order);
        
        if(result != null){
            return true;
        }
        return false;
    }
    public ActionEvent getButtonPressedEvent(Object source){
        return new ActionEvent(source,ActionEvent.ACTION_FIRST, "");
    }
    public int login(String userName,String passWord,int [] accessLevelAllowed){
        String [] result = return_values("*", "users","WHERE user_name ='"+userName+"' AND user_password = '"+passWord+"'",myVariables.getUsersOrder());
        if(result != null){
            String [] tempRow = toNameFormat(result[0], new int [] {1,2,3}).split("@@");
            int accessLevel = Integer.valueOf(tempRow[5]);
            int currId = Integer.valueOf(tempRow[0]);
            
            for(int level : accessLevelAllowed){
                if(accessLevel == level){
                    myVariables.setUserLoggedInId(currId);
                    myVariables.setUserLoggedInName(tempRow[1]);
                    myVariables.setAccessLevel(accessLevel);
                    return 0;
                }
            }
            return 1;
        }else{
            System.err.println("Login Failed");
            return 2;
        }
        
    }
    public void clear_table_rows(JTable table_nameTable){
        DefaultTableModel model=(DefaultTableModel) table_nameTable.getModel();
        model.setRowCount(0);
    }
    protected String get_table_row_values(int rowNumber,JTable tableName){
        String toSend = "";
        for(int n=0;n<tableName.getColumnCount();n++){
            toSend+=tableName.getValueAt(rowNumber, n)+"@@";
        }
        
        return  toSend;
    }
    public String setValueAtColumn(String line, int indexAt, String newValue){
        String [] temp = line.split("@@");
        String newLine = "";
        for(int n=0;n<temp.length;n++){
            if(n == indexAt){
                temp[n] = newValue;
            }            
            newLine+=temp[n]+"@@";
        }
        
        return newLine;
    }
    public String getValueAtColumn(String line,int indexAt){
        String [] temp = line.split("@@");
        return temp[indexAt];
    }
    public boolean remove_table_row(JTable tableName,int index){
        try {
            
            DefaultTableModel model = (DefaultTableModel) tableName.getModel();
            model.removeRow(index);
            
            return true;
        } catch (Exception e) {
            System.err.println("Failed to remove row "+index);
            return false;
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
    
    public String skipColumns(String line,int [] columnsToSkip){
        String [] temp = line.split("@@");
        String finalString = "";
        for(int n=0;n<temp.length;n++){
            boolean isFound = false;
            for(int x=0;x<columnsToSkip.length;x++){
                if(columnsToSkip[x] == n){
                    isFound = true;
                    break;
                }
            }
            if(!isFound){
                finalString+=temp[n]+"@@";
            }
        }
        
        return finalString;
    }
    protected String toNameFormat(String line,int [] columnIndex){
        String [] temp = line.split("@@");
        String finalString = "";
        String extentionName = "";
        for(int n=0;n<temp.length;n++){
            boolean isFound = false;
            boolean isLast = false;
            for(int x=0;x<columnIndex.length;x++){
                if(x==columnIndex.length-1){
                    isLast = true;
                }
                if(columnIndex[x] == n){
                    isFound = true;
                    break;
                }
            }
            if(!isFound){
                finalString+=temp[n]+"@@";
            }else{
                if(!isLast){
                    //Check For Extentions & take 2nd String as Extention Regardless
                    if(temp[n].contains(",")){
                        try {
                            String tempName []= temp[n].split(",");
                            temp[n] = tempName[0];
                            extentionName = tempName[1];
                        } catch (Exception e) {
                            System.err.println("Changing Extention Error @ toNameFormat() in myFunctions.java");
                        }
                    }
                    finalString+=temp[n]+", ";
                }else{
                    if(temp[n].length() > 1){
                        finalString+=temp[n].substring(0, 1)+".";
                    }else{
                        //Remove comma
                        finalString = finalString.substring(0, finalString.length()-2);
                    }
                    //Add Extention at the End
                    finalString+=" "+extentionName.trim();
                }
                if(isLast){
                    finalString+="@@";
                }
            }
        }
        return finalString;
    }
    protected String toNameFormatFull(String line,int [] columnIndex){
        String [] temp = line.split("@@");
        String finalString = "";
        String extentionName = "";
        
        for(int n=0;n<temp.length;n++){
            boolean isFound = false;
            boolean isLast = false;
            for(int x=0;x<columnIndex.length;x++){
                if(x==columnIndex.length-1){
                    isLast = true;
                }
                if(columnIndex[x] == n){
                    isFound = true;
                    break;
                }
            }
            if(!isFound){
                finalString+=temp[n]+"@@";
            }else{
                if(!isLast){
                    //Check For Extentions & take 2nd String as Extention Regardless
                    if(temp[n].contains(",")){
                        try {
                            String tempName []= temp[n].split(",");
                            temp[n] = tempName[0];
                            extentionName = tempName[1];
                        } catch (Exception e) {
                            System.err.println("Changing Extention Error @ toNameFormat() in myFunctions.java");
                        }
                    }
                    finalString+=temp[n]+", ";
                }else{
                    //Add Extention at the End
                    finalString+=" "+extentionName.trim();
                    finalString+=temp[n];
                }
                if(isLast){
                    finalString+="@@";
                }
            }
            
            
        }
        
        return finalString;
    }
    protected String combineColumns(String line,int [] columnIndex){
        String [] temp = line.split("@@");
        String finalString = "";
        
        for(int n=0;n<temp.length;n++){
            boolean isFound = false;
            boolean isLast = false;
            for(int x=0;x<columnIndex.length;x++){
                if(x==columnIndex.length-1){
                    isLast = true;
                }
                if(columnIndex[x] == n){
                    isFound = true;
                    break;
                }
            }
            if(!isFound){
                finalString+=temp[n]+"@@";
            }else{
                finalString+=temp[n]+" ";
                if(isLast){
                    finalString+="@@";
                }
            }
            
            
        }
        return finalString;
    }
    public void remove_dropdown_item(JComboBox dropDownName,int index){
        DefaultComboBoxModel model = (DefaultComboBoxModel) dropDownName.getModel();
        model.removeElementAt(index);
    }
    public String numberToWordDateInsideRow(String line,int column){
        String temp [] = line.split("@@");
        String dateWithTime []  = temp[column].split(" ");
        
        temp[column] = numberToWordDate(dateWithTime[0])+" "+dateWithTime[1];
        
        String toSend = "";
        for(int n=0;n<temp.length;n++){
            toSend+=temp[n];
            
            if(n<temp.length-1){
                toSend+="@@";
            }
        }
        return  toSend;
    }
    public String numberToWordDate(String date){
        String temp [] = date.split(" ");
        String separated [] = temp[0].split("-");
        String finalDate = "";
        
        System.err.println(date);
        // <editor-fold desc="Month">
        switch (Integer.parseInt(separated[1])){
            case 1:{
                finalDate = "January";
                break;
            }case 2:{
                finalDate = "February";
                break;
            }case 3:{
                finalDate = "March";
                break;
            }case 4:{
                finalDate = "April";
                break;
            }case 5:{
                finalDate = "May";
                break;
            }case 6:{
                finalDate = "June";
                break;
            }case 7:{
                finalDate = "July";
                break;
            }case 8:{
                finalDate = "August";
                break;
            }case 9:{
                finalDate = "September";
                break;
            }case 10:{
                finalDate = "October";
                break;
            }case 11:{
                finalDate = "November";
                break;
            }case 12:{
                finalDate = "December";
                break;
            }
        }
        // </editor-fold>
        //Day
        finalDate += " "+separated[2];
        //year
        finalDate +=", "+separated[0];
        
        if(temp.length > 1){
            finalDate+=" "+temp[1];
        }
        return finalDate;
    }
    public String jCalendarToNumberDate(String jCalendarDateString,boolean includeTime){
        String [] temp = jCalendarDateString.split(" ");
        String m = temp[1];
        String d = temp[2];
        String time = temp[3];
        String y = temp[5];
        
        switch(m){
            case "Jan":{
                m = "01";
                break;
            }case "Feb":{
                m = "02";
                break;
            }case "Mar":{
                m = "03";
                break;
            }case "Apr":{
                m = "04";
                break;
            }case "May":{
                m = "05";
                break;
            }case "Jun":{
                m = "06";
                break;
            }case "Jul":{
                m = "07";
                break;
            }case "Aug":{
                m = "08";
                break;
            }case "Sep":{
                m = "09";
                break;
            }case "Oct":{
                m = "10";
                break;
            }case "Nov":{
                m = "11";
                break;
            }case "Dec":{
                m = "12";
                break;
            }
        }
        if(includeTime){
            return y+"-"+m+"-"+d+" "+time;
        }else{
            return y+"-"+m+"-"+d;
        }        
    }
    
    //</editor-fold>
    public boolean runExeFile(String fileName,boolean useClassPath){
        File file;
        
        if(useClassPath){
            try {
                file = new File(getClass().getResource(fileName).toURI());
                Desktop desktop = Desktop.getDesktop();
                
                if(!file.exists()){
                    showMessage(fileName+" is missing from your computer.", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                
                if(!isProcessRunning(file)){
                    desktop.open(file);
                    return true;
                }else{
                    showMessage(fileName+" is already running.", JOptionPane.ERROR_MESSAGE);
                }
            } catch (IOException x){
                x.printStackTrace();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            try {
                file = new File(fileName);
                Desktop desktop = Desktop.getDesktop();
                
                if(!file.exists()){
                    showMessage(fileName+" is missing from your computer.", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                
                if(!isProcessRunning(file)){
                    desktop.open(file);
                    return true;
                }else{
                    showMessage(fileName+" is already running.", JOptionPane.ERROR_MESSAGE);
                }
            } catch (IOException x){
                x.printStackTrace();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    
    private static boolean isProcessRunning(File file){
        try {
            File copy = file;
            
            if(file.renameTo(copy)){
                return false;
            }else{
                return true;
            }
        } catch (Exception e) {
            
            e.printStackTrace();
            return true;
        }
    }
    public ImageIcon getImgIcn(String url){
        return new ImageIcon(getClass().getResource(url));
    }
    
    public Image getImage(String url){
        return new ImageIcon(getClass().getResource(url)).getImage();
    }
}

