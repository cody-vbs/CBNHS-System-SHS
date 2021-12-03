package mahPackage;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javazoom.jl.player.Player;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;

public class myFunctions {
    private static Thread mainThead,secondThread,thirdThread;
    
    static void playErrorSound() {
        try{
            FileInputStream fs = new FileInputStream(new File("sounds/error.mp3").getAbsoluteFile());
            Player player = new Player(fs);
            player.play();
            System.out.println("playing");
        } catch (Exception e){
            System.out.println(e);
        }
    }
    
    static void playSuccessSound() {
        try{
            FileInputStream fs = new FileInputStream(new File("sounds/success.mp3").getAbsoluteFile());
            Player player = new Player(fs);
            player.play();
            System.out.println("playing");
        } catch (Exception e){
            System.out.println(e);
        }

    }
    
    public static class PlayErrorMessageSound implements Runnable {

        @Override
        public void run() {
            playErrorSound();
        }

    }
    
     public static class PlaySuccessMessageSound implements Runnable {

        @Override
        public void run() {
            playSuccessSound();
        }

    }
    
     //call these methods for message sound
    void playSuccess(){
        SwingUtilities.invokeLater(new dashBoard.PlaySuccessMessageSound());
    }
    
    void playError(){
        SwingUtilities.invokeLater(new dashBoard.PlayErrorMessageSound());
    }
    
    public myFunctions(boolean skipLoadingSettings){
        try {
            loadSettings(skipLoadingSettings);
        } catch (Exception e) {
            System.err.println("Error Loading Settings");
        }
    }
    
    public void openWindow(JFrame currentWindow,JFrame targetWindow){
        currentWindow.dispose();
        targetWindow.setVisible(true);
    }
    public void loadSettings(boolean skipLoadingSettings) throws IOException{
        if(skipLoadingSettings){
            return;
        }
        try {
            File file = new File("settings.txt");
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
            myVariables.setSchoolName(settings[1]);
            myVariables.setSchoolAddress(settings[2]);
            myVariables.setSchoolId(settings[3]);
            myVariables.setDistrict(settings[4]);
            myVariables.setDivision(settings[5]);
            myVariables.setRegion(settings[6]);
            
            myVariables.setDebugMode(settings[11].contains("true"));
            myVariables.setProcessingSpeed(Integer.parseInt(settings[15]));
        }catch (Exception e) {
            System.err.println("Error: "+e.getLocalizedMessage());
            playError();
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
    * By: <b>SYD</b>
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
                playError();
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
                from = "v_students_shs";
                order = myVariables.getStudentsOrder();
                break;
            }case 1:{
                from = "v_subjects_shs";
                order = myVariables.getSubjectOrder();
                break;
            }case 2:{
                from = "v_loads_shs";
                order = myVariables.getSubjectLoadsOrder();
                break;
            }case 3:{
                from = "v_users_shs";
                order = myVariables.getUsersOrder();
                break;
            }case 4:{
                from = "v_sections_shs";
                order = myVariables.getSectionsOrder();
                break;
            }case 5:{
                from = "v_teacherloads_shs";
                order = myVariables.getTeacherLoadsViewOrder();
                break;
            }case 6:{
                from = "v_enrollment_minimal_shs";
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
                System.err.println(result[n]);
                add_table_row(result[n], resultTable);
            }
            
            if(resultText!= null){
                resultText.setText("Showing "+result.length+" result(s) for '"+searchField.getText()+"'.");               
            }
            
            
        }else{
            playError();
            showMessage("No Results found.", JOptionPane.PLAIN_MESSAGE);
            clear_table_rows(resultTable);
            if(resultText!= null){
                resultText.setText("Showing 0 results for '"+searchField.getText()+"'.");
            }
        }
    }
    /**
    * By: <b>Syd</b>
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
    * By: <b>Syd</b>
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
    public String [] return_values(String select,String from,String where,int [] order,boolean debugModeOn){
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
            if(debugModeOn){
                System.out.println("\nSending 'GET' request to URL : " + url);
                System.out.println("Response Code : " + responseCode);
            }
            
            if(responseCode != 200){
                playError();
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
                
                if (debugModeOn) {
                    //Display column index & name
                    for(int n=0;n<sample.names().length();n++){
                        System.out.println(n+" "+sample.names().getString(n));
                    }
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
            playError();
            showMessage("Lost Connection to Database. \n\nError: "+e.getLocalizedMessage(), JOptionPane.ERROR_MESSAGE);
            System.err.println("Exception Found "+e.getLocalizedMessage());
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
                playError();
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
            JSONArray res;
            //Check for query errors
            try {
                res = myResponse.getJSONArray("result");
            } catch (Exception e) {
                res = myResponse.getJSONArray("error");
                JSONObject row = res.getJSONObject(0);
                
                cLine = row.getString(row.names().getString(0));
                playError();
                showMessage("Query Error Occured. \n\nError: "+cLine, JOptionPane.ERROR_MESSAGE);
                System.err.println("Exception Found "+e.getLocalizedMessage());
                return null;
            }
            
            if(res.length() > 0){
                //Get column names
                JSONObject sample = res.getJSONObject(0);
                cLine = "";
                
                //Display column index & name
                if(myVariables.isDebugModeOn()){
                    for(int n=0;n<sample.names().length();n++){
                        System.out.println(n+" "+sample.names().getString(n));
                    }
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
            playError();
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
            
            if (myVariables.isDebugModeOn()) {
                System.out.println("\nSending 'GET' request to URL : " + url);
                System.out.println("Response Code : " + responseCode);
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
        //Note: the WHERE clause is already added in the PHP file
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
            
            if (myVariables.isDebugModeOn()) {
                System.out.println("\nSending 'GET' request to URL : " + url);
                System.out.println("Response Code : " + responseCode);
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
    //<editor-fold desc="Excel Management Functions">
    /*  -----------------------------------
        | Important Dependencies For this |
        -----------------------------------
        poi-4.1.2.jar
        poi-ooxml-4.1.2.jar
        poi-ooxml-schemas-4.1.2.jar
        dom4j-1.6.jar
        commons-collections4-4.3.jar
        commons-compress-1.18.jar
        xmlbeans-3.1.0.jar
    */
    
    //<editor-fold desc="Variables That Matter">
    private static XSSFWorkbook workbook;
    private static final String letters [] = new String [] {
        "a","b","c","d","e","f","g","h","i","j","k","l","m",
        "n","o","p","q","r","s","t","u","v","w","x","y","z"
    };
    //</editor-fold>
    //<editor-fold desc="Open & Save File">
    public boolean createExcelFile(String fileName){
        if(fileName != null){
            try {
                FileInputStream file;
                file = new FileInputStream(new File(fileName));
                
                workbook = new XSSFWorkbook(file);
                
                file.close();
            } catch (Exception e) {
                System.err.println("Creating File Failed..."+fileName+"\n"+e.getLocalizedMessage());
                return false;
            }
        }else{
            workbook = new XSSFWorkbook();
        }
        System.out.println("Creating File Success..."+fileName);
        return true;
    }
    public boolean saveExcelFile(String fileName){
        try {
            FileOutputStream fileOut;
            fileOut = new FileOutputStream(new File(fileName));
            workbook.write(fileOut);
            fileOut.close();
            return true;
        } catch (Exception e) {
            System.err.println("Saving File Failed...");
            return false;
        }
    }
    //</editor-fold>
    //<editor-fold desc="Read Functions">
    public String readSingleValue(int sheetNumber,String excelAddress){
        int [] location = parseExcelAddress(excelAddress);
        return readSingleValue(sheetNumber, location[0], location[1]);
    }
    private String readSingleValue(int sheetNumber,int rowStart,int columnStart){
        DataFormatter df = new DataFormatter();
        XSSFSheet sheet = workbook.getSheetAt(sheetNumber);
        XSSFRow row = sheet.getRow(rowStart);
        XSSFCell cell = row.getCell(columnStart);
        
        if(cell!=null){
            return df.formatCellValue(cell);
        }
        return null;
    }
    public String readExcelLine(int sheetNumber,String skipMergedExcelColumns,String excelAddressStart,String lastColumnAddress){
        //readExcelLine(0,"A,B,D","A,1","Z");
        int startLocation [] = parseExcelAddress(excelAddressStart);
        int [] skippedColumns = parseExcelColumns(skipMergedExcelColumns);
        int lastColumn = lastColumnAddress==null || lastColumnAddress.length()<=0? -1 : getLetterValueAdvanced(lastColumnAddress.toLowerCase());
        return readExcelLine(sheetNumber, skippedColumns, startLocation[0], startLocation[1], lastColumn);
    }
    private String readExcelLine(int sheetNumber,int [] skipExcelColumns,int rowStart,int columnStart,int columnEnd){
        String cLine = "";
        XSSFSheet sheet = workbook.getSheetAt(sheetNumber);
        DataFormatter df = new DataFormatter();
        
        if(sheet == null){
            sheet = workbook.createSheet("SHEET_"+(sheetNumber+1));
        }
        
        XSSFRow row = null;
        XSSFCell cell = null;
        row = sheet.getRow(rowStart);
        //System.err.println("Row: "+rowStart+" Col: "+columnStart);
        int lastColumn = columnEnd!=-1?columnEnd+1 : row.getLastCellNum();    //Put -1 on columnEnd if you want to get until the last column, else specify
        
        for (int n = columnStart; n < lastColumn; n++) {
            if(!isMergedCellIndex(n, skipExcelColumns)){
                cell = row.getCell(n);
                if(cell != null){
                    if(df.formatCellValue(cell).length() > 0){
                        cLine+=df.formatCellValue(cell)+"@@";
                    }else{
                        cLine+=" @@";
                    }
                }else{
                    cLine+=" @@";
                }
            }
        }
        
        return cLine;
    }
    public String [] readRegion(int sheetNumber,String skipMergedExcelColumns,String excelAddressStart,String excelAddressEnd){
        int [] startLoc = parseExcelAddress(excelAddressStart);
        int [] endLoc = parseExcelAddress(excelAddressEnd);
        
        int [] columnsToSkip = parseExcelColumns(skipMergedExcelColumns);
        
        //System.err.println("To Region Config: "+skipMergedExcelColumns+":"+excelAddressStart+":"+excelAddressEnd);
        return readRegion(sheetNumber, columnsToSkip, startLoc[0], startLoc[1], endLoc[0], endLoc[1]);
    }
    private String [] readRegion(int sheetNumber,int [] skipExcelColumns,int row1,int column1,int row2,int column2){
        int rowCount = (row2-row1)+1;
        String [] values = new String [rowCount];
        String cLine;
        for (int n = 0; n < rowCount; n++) {
            cLine = readExcelLine(sheetNumber, skipExcelColumns, n+row1, column1, column2);
            //System.err.println("Line: "+cLine);
            values[n] = cLine;
        }
        return values;
    }
    //</editor-fold>
    //<editor-fold desc="Write Functions">
    //#1 Write Single Data
    public void writeExcelSingleData(int sheetNumber,JTextField textField,String excelAddress){
        writeExcelSingleData(sheetNumber, textField.getText(), excelAddress);
    }
    public void writeExcelSingleData(int sheetNumber,String value,String excelAddress){
        //Note: excellAddress must have ',' to separate the address. E.G. ( A,1 )
        int [] location = parseExcelAddress(excelAddress);
        writeExcelSingleData(sheetNumber, value, location[0], location[1]);
    }
    private void writeExcelSingleData(int sheetNumber,String value,int rowStart,int columnStart){
        XSSFSheet sheet = workbook.getSheetAt(sheetNumber);
        
        if(sheet == null){
            sheet = workbook.createSheet("SHEET_"+(sheetNumber+1));
        }
        
        XSSFRow row = null;
        row = sheet.getRow(rowStart);
        
        if(row != null){
            XSSFCell cell = row.getCell(columnStart);
            if(cell != null){
                cell.setCellValue(value);
            }else{
                XSSFCell newCell = row.createCell(columnStart);
                newCell.setCellValue(value);
            }
        }else{
            row = sheet.createRow(rowStart);
            XSSFCell newCell = row.createCell(columnStart);
            newCell.setCellValue(value);
        }
    }
    //#2 Write One Whole Row
    public void writeExcelLine(int sheetNumber, String line,String skipMergedExcelColumns,String startAddress){
        //Note: excellAddress must have ',' to separate the address. E.G. ( A,1 )
        int [] location = parseExcelAddress(startAddress);
        int [] skipExcelColumns = parseExcelColumns(skipMergedExcelColumns);
        writeExcelLine(sheetNumber, line, skipExcelColumns, location[0], location[1]);
    }
    private void writeExcelLine(int sheetNumber, String line,int [] skipExcelColumns,int rowStart,int columnStart){
        XSSFSheet sheet = workbook.getSheetAt(sheetNumber);
        
        if(sheet == null){
            sheet = workbook.createSheet("SHEET_"+(sheetNumber+1));
        }
        
        String [] values = line.split("@@");
        int dataCount = values.length;
        
        
        XSSFRow row = null;
        
        int currColumn = columnStart;
        for(int n=0;n<dataCount; ){
            row = sheet.getRow(rowStart);
            
            if(!isMergedCellIndex(currColumn, skipExcelColumns)){
                if(row != null){
                    XSSFCell cell = row.getCell(currColumn);

                    if(cell != null){
                        cell.setCellValue(values[n]);
                    }else{
                        XSSFCell newCell = row.createCell(currColumn);
                        newCell.setCellValue(values[n]);
                    }
                }else{
                    row = sheet.createRow(rowStart);
                    XSSFCell newCell = row.createCell(currColumn);
                    newCell.setCellValue(values[n]);
                }
                n++;
            }
            currColumn++;
        }
    }
    //#3 Draw an Image
    public void drawImageToCell(int sheetNumber,String imgUrl,String excelCellAddress,boolean resetSize){
        int location [] = parseExcelAddress(excelCellAddress);
        drawImageToCell(sheetNumber, imgUrl, new int [] {location[0],location[1],location[0]+1,location[1]+1}, resetSize);
    }
    public void drawImageToCell(int sheetNumber,String imgUrl,int [] anchors_X1Y1_X2Y2,boolean resetSize){
        try {
            XSSFSheet sheet = workbook.getSheetAt(sheetNumber);
            
            //Load File
            
            FileInputStream inpStream = new FileInputStream(new File(getClass().getResource(imgUrl).toURI()));
            byte[] bytes = IOUtils.toByteArray(inpStream);
            int pictureIndex = workbook.addPicture(bytes, XSSFWorkbook.PICTURE_TYPE_PNG);
            inpStream.close();
            
            //System.err.println("Picture Index: "+pictureIndex);
            
            if (bytes == null) {
                System.err.println("Bytes are null");
            }
            //Anchor Image
            CreationHelper helper = workbook.getCreationHelper();
            Drawing drawing = sheet.createDrawingPatriarch();
            
            ClientAnchor anchor = helper.createClientAnchor();
            
            anchor.setRow1(anchors_X1Y1_X2Y2[0]);
            anchor.setCol1(anchors_X1Y1_X2Y2[1]);
            anchor.setRow2(anchors_X1Y1_X2Y2[2]);
            anchor.setCol2(anchors_X1Y1_X2Y2[3]);
            
            //Create Picture
            Picture picture = drawing.createPicture(anchor, pictureIndex);
            if(resetSize){
                picture.resize();
            }
        }catch(URISyntaxException x){
            System.err.println("Invalid URI");
            x.printStackTrace();
        }catch (IOException e) {
            System.err.println("File Not Found\n"+e.getMessage());
            e.printStackTrace();
        }
    }
    //</editor-fold>
    //<editor-fold desc="Merge Functions">
    public void mergeRegion(int sheetNumber,String addressFrom,String addressTo){
        int [] addr1 = parseExcelAddress(addressFrom);
        int [] addr2 = parseExcelAddress(addressTo);
        
        mergeRegion(sheetNumber, addr1[0], addr1[1], addr2[0], addr2[1]);
    }
    public void mergeRegion(int sheetNumber,int row1,int column1,int row2,int column2){
        XSSFSheet sheet = workbook.getSheetAt(sheetNumber);
        sheet.addMergedRegion(new CellRangeAddress(row1, row2, column1, column2));
    }
    public void mergeColumns(int sheetNumber,int rowAddress,String columnAddressStart,String columnAddressEnd){
        int values [] = parseExcelColumns(columnAddressStart.toLowerCase()+","+columnAddressEnd.toLowerCase());
        
        mergeColumns(sheetNumber, rowAddress-1, values[0], values[1]);
    }
    public void mergeColumns(int sheetNumber,int rowAddress, int columnIndexStart, int columnIndexEnd){
        XSSFSheet sheet = workbook.getSheetAt(sheetNumber);
        sheet.addMergedRegion(new CellRangeAddress(rowAddress, rowAddress, columnIndexStart, columnIndexEnd));
    }
    public void mergeRows(int sheetNumber,String columnAddress,int rowAddressStart,int rowAddressEnd){
        int column = getLetterValueAdvanced(columnAddress.toLowerCase());
        
        mergeRows(sheetNumber, column, rowAddressStart-1, rowAddressEnd-1);
    }
    public void mergeRows(int sheetNumber,int columnIndex, int rowIndexStart, int rowIndexEnd){
        XSSFSheet sheet = workbook.getSheetAt(sheetNumber);
        sheet.addMergedRegion(new CellRangeAddress(rowIndexStart, rowIndexEnd, columnIndex, columnIndex));
    }
    //</editor-fold>
    //<editor-fold desc="Remove Row Functions">
    public void removeRows(int sheetNumber, int [] rowAddressesAscending){
        // Delete multiple rows with skipping in-between rows e.g {1,5,7,10}
        int rowCount = rowAddressesAscending.length;
        for (int n = rowCount-1; n >= 0; n--) {
            removeRow(sheetNumber, rowAddressesAscending[n]);
        }
    }
    public void removeRows(int sheetNumber, int rowStartAddress,int rowEndAddress){
        // Delete mupltiple rows in a straight order e.g {2,3,4,5,6}
        for (int n = rowEndAddress; n >= rowStartAddress; n--) {
            removeRow(sheetNumber, n);
        }
    }
    public void removeRow(int sheetNumber, int rowAddress){
        XSSFSheet sheet = workbook.getSheetAt(sheetNumber);
        
        try {
            int lastIndex = sheet.getLastRowNum()<= rowAddress? sheet.getLastRowNum()+1 : sheet.getLastRowNum();
            
            //System.out.println("Last Row = "+sheet.getLastRowNum());
            sheet.shiftRows(rowAddress, lastIndex, -1);
        } catch (Exception e) {
            //e.printStackTrace();
            
        }
    }
    //</editor-fold>
    //<editor-fold desc="Other Useful Functions Hehe">
    private boolean isMergedCellIndex(int columnIndex, int [] mergedColumnsList){
        boolean result = false;
        if(mergedColumnsList != null){
            for(int n=0;n<mergedColumnsList.length;n++){
                if(columnIndex == mergedColumnsList[n]){
                    //System.err.println("Merged Column Found: "+mergedColumns[n]);
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
    private int [] parseExcelColumns(String excelColumnAddress){
        // Adresses must be in a format of E.G. ( A,B,D,E,G ) in ascending order
        if(excelColumnAddress == null || excelColumnAddress.length()<=0){
            return null;
        }
        
        String letters [] = excelColumnAddress.toLowerCase().split(",");
        int [] indeces = new int[letters.length];
        
        for (int n = 0; n < indeces.length; n++) {
            indeces[n] = getLetterValueAdvanced(letters[n]);
            //System.err.println("Skipping column: "+letters[n]+"="+indeces[n]);
        }
        
        return indeces;
    }
    private int [] parseExcelAddress(String excelAddress){
        String address [] = excelAddress.toLowerCase().split(",");
        
        int row = Integer.parseInt(address[1])-1;
        int column = 0;
        
        column = getLetterValueAdvanced(address[0]);
        return new int[]{row,column};
    }
    private int getLetterValue(String letter){
        String letterToSearch = "";
        for (int n = 0; n < letters.length; n++) {
            letterToSearch = String.valueOf(letter);
            
            if(letters[n].equals(letterToSearch)){
                return n;
            }
        }
        return 0;
    }
    private int getLetterValueAdvanced(String letters){
        // A = 0 Z = 25
        
        
        //Check if column address has multiple letters
        if(letters.length() <= 1){
            return getLetterValue(letters);
        }
        
        String letterToSearch = "";
        int currentValue = 0;
        
        int characterCount = letters.length();
        for (int n = 0; n < characterCount; n++) {
            letterToSearch = String.valueOf( letters.charAt(n) );
            //If Letter is not the last character, add values
            if(n != characterCount-1){  
                currentValue += (26 + (26*getLetterValue(letterToSearch)));
            }else{
                currentValue += getLetterValue(letterToSearch);
            }
        }
        //System.err.println("Advanced Value: "+currentValue);
        return currentValue;
    }
    private void removeSheetsAt(int sheetIndexInOrder []){
        int sheetCount = workbook.getNumberOfSheets();
        for (int n = sheetCount-1; n >= 0; n--) {
            try {
                workbook.removeSheetAt(n);
            } catch (Exception e) {
            }
        }
    }
    //</editor-fold>
    //</editor-fold>
    //<editor-fold desc="Other Functions">
    //<editor-fold desc="Thread Management Functions">
    public void runMainThread(int threadIndex,JTable [] tablesToUse,String [] valuesToUse,JTextField [] textFieldsToUse,JButton [] buttonsToUse,boolean  [] booleansToUse,File [] filesToUse){
        Thread toLoad = null;
        switch (threadIndex){
            case 0:{
                thread_importSf1 tld = new thread_importSf1(tablesToUse, valuesToUse, textFieldsToUse, buttonsToUse, booleansToUse);
                toLoad = new Thread(tld);
                break;
            }case 1:{
                thread_registerSf1 tld = new thread_registerSf1(tablesToUse, valuesToUse, textFieldsToUse, buttonsToUse, booleansToUse);
                toLoad = new Thread(tld);
                break;
            }case 2:{
                break;
            }case 3:{
                break;
            }default:{
                System.err.println("No proper thread selected.");
                return;
            }
        }
        if(mainThead != null){
            if(mainThead.isAlive()){
                interrupMainThread();
            }
        }
        mainThead = toLoad;
        mainThead.start();
    }
    public void interrupMainThread(){
        if(mainThead != null){
            if(mainThead.isAlive()){
                System.err.println("Stopping Threads");
                mainThead.interrupt();
                mainThead = null;
                return;
            }else{
                //System.err.println("Mainthread is not running.");
            }
        }
    }
    public void interrupSecondThread(){
        if(secondThread != null){
            if(secondThread.isAlive()){
                System.err.println("Stopping Second Thread");
                secondThread.interrupt();
                secondThread = null;
                return;
            }else{
                //System.err.println("Second Thread is not running.");
            }
        }
    }
    public void interruptThirdThread(){
        if(thirdThread != null){
            if(thirdThread.isAlive()){
                System.err.println("Stopping Third Thread");
                thirdThread.interrupt();
                thirdThread = null;
                return;
            }else{
                //System.err.println("Second Thread is not running.");
            }
        }
    }
    //</editor-fold>
    SimpleDateFormat sdf1,sdf2;
    public String changeDateFormat(String date,String originalFormat,String newFormat){
        try {
            String result = "";
            sdf1 = new SimpleDateFormat(originalFormat);
            sdf2 = new SimpleDateFormat(newFormat);
            
            result = sdf2.format(sdf1.parse(date));
            
            return result;
        } catch (Exception e) {
            return null;
        }
    }
    public String convertEscapeCharacters(String toConvert){
        //This function is primarily used for user input with possible escape characters being typed.
        //Usually on SEARCH FIELDS and INPUT FIELDS during add_values and/or update_values
        
        if(toConvert.contains("\\")){
            toConvert = toConvert.replace("\\", "\\\\");
        }
        if(toConvert.contains("\"")){
            toConvert = toConvert.replace("\"", "\\\"");
        }
        if(toConvert.contains("\'")){
            toConvert = toConvert.replace("\'", "\\\'");
        }
        
        return toConvert;
    }
    public String multipleColumnSearch(String columnValues, String columnValuesOnDisplay, String logOperatorPerColumn, String toSearch){
        String [] values = toSearch.split(",");                         //Ricafort,Sydney,Pacana
        String [] columns = columnValues.split(",");                    //lName,fName,mName
        String [] logicalOperators = logOperatorPerColumn.split(",");   //=,=,LIKE
        int valLength = values.length;
        int colLen = columns.length;
        
        String newWhere = "";
        
        if(valLength > colLen){
            Toolkit.getDefaultToolkit().beep();
            showMessage("Search much be in a \""+columnValuesOnDisplay+"\" format.", JOptionPane.WARNING_MESSAGE);
            return null;
        }
        
        for(int n=0;n<valLength;n++){
            switch(logicalOperators[n]){
                case "=":{
                    newWhere+=columns[n]+"='"+values[n].trim()+"' ";
                    break;
                }case "!=":{
                    newWhere+=columns[n]+"!='"+values[n].trim()+"' ";
                    break;
                }case "LIKE":{
                    newWhere+=columns[n]+" LIKE '%"+values[n].trim()+"%' ";
                    break;
                }
            }
            if(n<valLength-1){
                newWhere+="AND ";
            }
        }
        
        return newWhere;
    }
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
            playError();
            showMessage("Invalid time provided. Time must be in a '12:00:00 AM' format.\nMore info: "+e.getMessage(), JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    public String from24To12HourFormat(String time24Hour){
        
        return null;
    }
    
    public boolean checkForDuplicates(String tableName,String whereLimitExluded,int [] order){
        whereLimitExluded +=" LIMIT 1"; //For fast search. You only need to find at least 1 dupliclate
        String result [] = return_values("*", tableName, whereLimitExluded, order, myVariables.isDebugModeOn());
        
        if(result != null){
            return true;
        }
        return false;
    }
    public ActionEvent getButtonPressedEvent(Object source){
        return new ActionEvent(source,ActionEvent.ACTION_FIRST, "");
    }
    public int login(String userName,String passWord,int [] accessLevelAllowed){
        String [] result = return_values("*", "v_users_shs","WHERE user_name ='"+userName+"' AND user_password = '"+passWord+"'",myVariables.getUsersOrder());
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
    protected String capitalizeName(String nameFull,boolean removeDashedMiddleNames){
        String finalString = "";
        String names [] = nameFull.split(",");
        boolean rowSkipped;
        for (int n = 0; n < names.length; n++) {
            //Separate Compound Name
            String temp[] = names[n].trim().split(" ");
            rowSkipped = false;
            
            if(temp.length > 1){
                for (int x = 0; x < temp.length; x++) {
                    if(removeDashedMiddleNames && temp[x].contains("-")){
                        rowSkipped = true;
                        break;
                    }else{
                        finalString+=StringUtils.capitalize(temp[x].trim());
                        if(x<temp.length-1){
                            finalString+=" ";
                        }
                    }
                }
            }else{
                if(removeDashedMiddleNames && names[n].contains("-")){
                    rowSkipped = true;
                }else{
                    finalString+=StringUtils.capitalize(names[n].trim());
                }
                
            }
            if(!rowSkipped){
                if(n<names.length-1){
                    finalString+=",";
                }
            }else{
                //remove comma at last
                int wordLength = finalString.length();
                //System.err.println(finalString+" Last char: "+finalString.charAt(wordLength-1));
                if(finalString.charAt(wordLength-1) == ','){
                    finalString = finalString.substring(0, finalString.length()-1);
                }
            }
        }
        return finalString;
    }
    protected String explodeNameFormat(String line,int columnIndex){
        String value = getValueAtColumn(line, columnIndex);
        String [] names = value.split(",");
        
        String finalString = "";
        int nameCount = names.length;
        //Check length
        
        return setValueAtColumn(line, columnIndex, finalString);
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
    public ImageIcon getImgIcn(String url){
        return new ImageIcon(getClass().getResource(url));
    }
    
    public Image getImage(String url){
        return new ImageIcon(getClass().getResource(url)).getImage();
    }
    
    //getter and setter
    
    public static String studLrn;
    public static String subjectID;
    public static String loadID;
    public static String userID;
    public static String getCurrHashPass;

    public static String getStudLrn() {
        return studLrn;
    }

    public static void setStudLrn(String studLrn) {
        myFunctions.studLrn = studLrn;
    }

    public static String getSubjectID() {
        return subjectID;
    }

    public static void setSubjectID(String subjectID) {
        myFunctions.subjectID = subjectID;
    }

    public static String getLoadID() {
        return loadID;
    }

    public static void setLoadID(String loadID) {
        myFunctions.loadID = loadID;
    }

    public static String getUserID() {
        return userID;
    }

    public static void setUserID(String userID) {
        myFunctions.userID = userID;
    }

    public static String getGetCurrHashPass() {
        return getCurrHashPass;
    }

    public static void setGetCurrHashPass(String getCurrHashPass) {
        myFunctions.getCurrHashPass = getCurrHashPass;
    }
    
    //method md5 conversion
    public String convertMd5(String input)
    {
        try {
  
            MessageDigest md = MessageDigest.getInstance("MD5");
  
            byte[] messageDigest = md.digest(input.getBytes());
  
            BigInteger no = new BigInteger(1, messageDigest);
  
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } 
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    
    //method for send email
    
    public void sendEmail (String targetEmail,String whatHappened){
        final String email = "cbnshssuprt@gmail.com";
        final String password = "@Support123";

        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, password);
            }
          });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email));
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(targetEmail));
            message.setSubject("Thanks for contacting CBNHS Support");
            message.setText("Hi ,"
                + "\n\n We have received your request. \n\n" + whatHappened + "\n\n" + 
                    "We will respond within 1 business day. If you don't hear from us within that time frame, please be sure to check your spam folder."
                        + "\n\n" + "Sincerely," + "\n" +"CBNHS Support Team");
            

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    
    
    
    
    
    
    
    
    
    
    
}

