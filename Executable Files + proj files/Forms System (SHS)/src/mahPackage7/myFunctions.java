/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mahPackage7;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.DefaultIndexedColorMap;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.extensions.XSSFCellBorder;
import org.json.JSONArray;
import org.json.JSONObject;

public class myFunctions {
    private static Thread mainThead,secondThread,thirdThread,stopThread;
    
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
            
            myVariables.setPrincipal(settings[12]);
            myVariables.setDivisionRepresentative(settings[13]);
            myVariables.setDivisionSuperintendent(settings[14]);
            
            myVariables.setDebugMode(settings[11].contains("true"));
            myVariables.setProcessingSpeed(Integer.parseInt(settings[15]));
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
    public void searchItemThread(String toSearch,String where,JTable resultTable,int viewTableIndex,int [] combineColumns,boolean [] booleansToUse,JLabel resultText,int [] coloredColumnIndex,Color selectedColor){
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
            }case 8:{
                from = "v_enrollment_mini_wbdate";
                order = myVariables.getEnrollmentViewMinWBdateOrder();
                break;
            }case 9:{
                from = "v_managedsubjects";
                order = myVariables.getManagedSubjectsViewOrder();
                break;
            }case 10:{
                from = "form_sf1_view_shs";
                order = myVariables.getShsf1Order();
                break;
            }case 11:{
                from = "form_sf2_view_shs";
                order = myVariables.getJhsf2Order();
                break;
            }case 12:{
                from = "v_managedsubjects_wbooktemplate";
                order = myVariables.getManagedSubjectsWTemplateViewOrder();
                break;
            }case 13:{
                from = "form_sf3_view_shs";
                order = myVariables.getShsf3Order();
                break;
            }case 14:{
                from = "v_managedsubjects_wsubjectscontained";
                order = myVariables.getManagedSubjectsWSubjectsContainedViewOrder();
                break;
            }default:{
                System.err.println("View table index out of bounds. Please check your index selected @ myFunctions.java");
                return;
            }
        }
        
        thread_return_values trv = new thread_return_values(
                toSearch,"*", from, where, order, resultTable,combineColumns,booleansToUse,resultText,coloredColumnIndex,selectedColor
        );
        System.err.println("Starting Thread");
        if(mainThead != null){
            if(mainThead.isAlive()){
                interrupMainThread();
            }
        }
        mainThead = new Thread(trv);
        mainThead.start();
    }
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
            }case 8:{
                from = "v_enrollment_mini_wbdate";
                order = myVariables.getEnrollmentViewMinWBdateOrder();
                break;
            }case 15:{
                from = "v_enrollment_mini_wbdate_shs_wstrand";
                order = myVariables.getEnrollmentViewMinWBdateSHSWStrandOrder();
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
    public void customHeaders(JTable tableName,int [] selectedColumns,Color foreground,Color background,Font font,boolean centerHeaders){
        CustomHeaderRenderer customHeaderRenderer = new CustomHeaderRenderer(background, foreground, font);
        if(centerHeaders){
            customHeaderRenderer.setHorizontalAlignment(JLabel.CENTER);
        }
        
        for(int n=0;n<tableName.getColumnCount();n++){
            for(int selectedColumn : selectedColumns){
                if(selectedColumn == n){
                    tableName.getTableHeader().getColumnModel().getColumn(n).setHeaderRenderer(customHeaderRenderer);
                    break;
                }
            }
        }
    }
    protected void hideColumns(JTable tableName,int [] columnIndex){
        TableColumnModel columnModel = tableName.getColumnModel();
        
        for(int n=0;n<columnIndex.length;n++){
            columnModel.getColumn(columnIndex[n]).setWidth(0);
            columnModel.getColumn(columnIndex[n]).setMinWidth(0);
            columnModel.getColumn(columnIndex[n]).setMaxWidth(0);
        }
    }
    protected void showSelectedRow(JTable tableName,int row){
        tableName.scrollRectToVisible(tableName.getCellRect(row, 0, true));
    }
    protected void showSelectedItemInsideScrollPane(Component component, JScrollPane scrollPane,int adjustment){
        scrollPane.getVerticalScrollBar().setValue(component.getY()-adjustment);
        /*
        
        if(topBottom){
            scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMinimum());
        }else{
            scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
        }
        */
        
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
            JSONArray res;
            //Check for query errors
            try {
                res = myResponse.getJSONArray("result");
            } catch (Exception e) {
                res = myResponse.getJSONArray("error");
                JSONObject row = res.getJSONObject(0);
                
                cLine = row.getString(row.names().getString(0));
                showMessage("Query Error Occured. \n\nError: "+cLine, JOptionPane.ERROR_MESSAGE);
                System.err.println("Exception Found "+e.getLocalizedMessage());
                return null;
            }
            
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
    private static final String acronyms [][] = {
        new String [] {"edukasyon sa pagpapakatao","ESP"},
        new String [] {"physical education","PE"},
        new String [] {"technology and livelihood education","TLE"},
        new String [] {"mathematics","MATH"},
        new String [] {"araling panlipunan","ARAL PAN"},
    };
    public String getAcronym(String subjectName,boolean includeGradeLevel, String gradeLevel){
        String name = removeSubjectGrade(subjectName.toLowerCase(), " ");
        for (int n = 0; n < acronyms.length; n++) {
            if(name.contains(acronyms[n][0])){
                //System.err.println("Acronym Found");
                name = acronyms[n][1];
                break;
            }
        }
        if (includeGradeLevel) {
            return name+" "+gradeLevel;
        }else{
            return name;
        }
    }
    public String getCurriculumNameOnly(String curriculumName,String separator,int indexToGet,boolean toUpperCase){
        if (curriculumName.contains(separator)) {
            try {
                String [] temp = curriculumName.split(separator);
                temp[indexToGet] = toUpperCase? temp[indexToGet].toUpperCase() : temp[indexToGet];
                
                return temp[indexToGet].trim();
            } catch (Exception e) {
                System.err.println("Error extracting curriculumName "+e.getLocalizedMessage());
                return curriculumName;
            }
        }
        
        return null;
    }
    public String getSectionNameOnly(String sectionName,boolean toUppercase){
        if(sectionName.contains("-")){
            try {
                String [] temp = sectionName.split("-");
                temp[1] = toUppercase? temp[1].toUpperCase() : temp[1];
                
                return temp[1].trim();
            } catch (Exception e) {
                System.err.println("Error extracting sectionName "+e.getLocalizedMessage());
                return sectionName;
            }
        }else{
            return sectionName;
        }
    }
    public void showTrayMessage(String title,String message,TrayIcon.MessageType messageType){
        SystemTray tray = SystemTray.getSystemTray();
        Image img = null;
        
        if(messageType == TrayIcon.MessageType.NONE){
            img = getImage(myVariables.getMsgUrlIcon());
        }
        if(messageType == TrayIcon.MessageType.INFO){
            img = getImage(myVariables.getMsgUrlIconSuccess());
        }
        if(messageType == TrayIcon.MessageType.ERROR){
            img = getImage(myVariables.getMsgUrlIconFailed());
        }
        if(messageType == TrayIcon.MessageType.WARNING){
            img = getImage(myVariables.getMsgUrlIconWarning());
        }
        
        TrayIcon tIcon = new TrayIcon(img);
        tIcon.setImageAutoSize(true);
        //tIcon.setToolTip("Icon image tooltip here..");//Optional
        try {
            tray.add(tIcon);
            tIcon.displayMessage(title, message, messageType);
        } catch (Exception e) {
        }
    }
    public void runExportThread(JTable [] tablesToUse,String [] valuesToUse,JTextField [] textFieldsToUse,JButton [] buttonsToUse,boolean  [] booleansToUse){
        Thread toLoad = null;
        
        thread_export_schoolForms sfThread = new thread_export_schoolForms(tablesToUse, valuesToUse, textFieldsToUse, buttonsToUse, booleansToUse);
        toLoad = new Thread(sfThread);
        
        if(secondThread != null){
            if(secondThread.isAlive()){
                interrupSecondThread();
            }
        }
        secondThread = toLoad;
        secondThread.start();
    }
    public void runSecondaryThread(int threadIndex,boolean waitForMainThreadToFinish,JTable [] tablesToUse,String [] valuesToUse,JTextField [] textFieldsToUse,JButton [] buttonsToUse,boolean  [] booleansToUse){
        Thread toLoad = null;
        switch (threadIndex){
            case 0:{
                thread_loadSf1Details tca = new thread_loadSf1Details(tablesToUse, 6, valuesToUse,textFieldsToUse,buttonsToUse, true);
                toLoad = new Thread(tca);
                break;
            }case 1:{
                thread_loadSf2Details ls2d = new thread_loadSf2Details(tablesToUse, valuesToUse, textFieldsToUse, buttonsToUse, booleansToUse);
                toLoad = new Thread(ls2d);
                break;
            }case 2:{
                thread_loadSf3Details ls3d = new thread_loadSf3Details(tablesToUse, valuesToUse, textFieldsToUse, buttonsToUse, new boolean[]{true,true});
                toLoad = new Thread(ls3d);
                break;
            }case 3:{
                thread_loadSf5Details ls5d = new thread_loadSf5Details(tablesToUse, valuesToUse, textFieldsToUse, buttonsToUse, booleansToUse);
                toLoad = new Thread(ls5d);
                break;
            }case 4:{
                thread_loadRankings lR= new thread_loadRankings(tablesToUse, valuesToUse, textFieldsToUse, buttonsToUse, booleansToUse);
                toLoad = new Thread(lR);
                break;
            }case 5:{
                thread_loadSf8Details lR = new thread_loadSf8Details(tablesToUse, valuesToUse, textFieldsToUse, buttonsToUse, booleansToUse);
                toLoad = new Thread(lR);
                break;
            }case 6:{
                thread_loadSf9DetailsRevised lR = new thread_loadSf9DetailsRevised(tablesToUse, valuesToUse, textFieldsToUse, buttonsToUse, booleansToUse);
                //thread_loadSf9Details lR = new thread_loadSf9Details(tablesToUse, valuesToUse, textFieldsToUse, buttonsToUse, booleansToUse);
                toLoad = new Thread(lR);
                break;
            }case 7:{
                thread_loadSf10EnrolledSections lR = new thread_loadSf10EnrolledSections(tablesToUse, valuesToUse, textFieldsToUse, buttonsToUse, booleansToUse);
                toLoad = new Thread(lR);
                break;
            }case 8:{
                thread_loadSf7Details lR = new thread_loadSf7Details(tablesToUse, valuesToUse, textFieldsToUse, buttonsToUse, booleansToUse);
                toLoad = new Thread(lR);
                break;
            }case 9:{
                thread_selectItemsFromTable lR = new thread_selectItemsFromTable(tablesToUse, valuesToUse, textFieldsToUse, buttonsToUse, booleansToUse);
                toLoad = new Thread(lR);
                break;
            }default:{
                System.err.println("No proper thread selected.");
                return;
            }
        }
        if(secondThread != null){
            if(secondThread.isAlive()){
                interrupSecondThread();
            }
        }
        secondThread = toLoad;
        secondThread.start();
    }
    public void runThirdThread(int threadIndex,boolean waitForMainThreadToFinish,JTable [] tablesToUse,String [] valuesToUse,JTextField [] textFieldsToUse,JButton [] buttonsToUse,boolean  [] booleansToUse,JTabbedPane [] tabsToUse){
        Thread toLoad = null;
        switch (threadIndex){
            case 0:{
                thread_loadSf4Details tld = new thread_loadSf4Details(tablesToUse, valuesToUse, textFieldsToUse, buttonsToUse, new boolean[]{true,true,true});
                toLoad = new Thread(tld);
                break;
            }case 1:{
                thread_loadSf6Details tld = new thread_loadSf6Details(tablesToUse, valuesToUse, textFieldsToUse, buttonsToUse, booleansToUse);
                toLoad = new Thread(tld);
                break;
            }case 2:{
                thread_loadSf10Details tld = new thread_loadSf10Details(tablesToUse, valuesToUse, textFieldsToUse, buttonsToUse, booleansToUse, tabsToUse);
                toLoad = new Thread(tld);
                break;
            }case 3:{
                thread_export_schoolForms sfThread = new thread_export_schoolForms(tablesToUse, valuesToUse, textFieldsToUse, buttonsToUse, booleansToUse);
                toLoad = new Thread(sfThread);
                break;
            }default:{
                System.err.println("No proper thread selected.");
                return;
            }
        }
        if(thirdThread != null){
            if(thirdThread.isAlive()){
                interruptThirdThread();
            }
        }
        thirdThread = toLoad;
        thirdThread.start();
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
    public void interruptStopThread(){
        if(stopThread != null){
            if(stopThread.isAlive()){
                System.err.println("Stopping Stop Thread");
                stopThread.interrupt();
                stopThread = null;
                return;
            }else{
                //System.err.println("Second Thread is not running.");
            }
        }
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
            toSend+=tableName.getValueAt(rowNumber, n) != null? tableName.getValueAt(rowNumber, n)+"@@" : " @@";
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
    protected String [] separateLastNameExtention(String lastNameString){
        String temp[];
        if(lastNameString.contains(",")){
            temp = lastNameString.split(",");
            
            return new String [] {temp[0].trim(),temp[1]};
        }else{
            return new String [] {lastNameString," "};
        }
    }
    protected String toNameFormatPrintedName(String line,int [] columnIndex,boolean toUpperCase){
        String [] temp = line.split("@@");
        String finalString = "";
        String firstName = "";
        String lastName = "";
        String middleName = "";
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
                    switch(x){
                        case 0:{
                            lastName = temp[n];break;
                        }case 1:{
                            firstName = temp[n];break;
                        }case 2:{
                            middleName = temp[n];break;
                        }
                    }
                    
                    break;
                }
            }
            if(!isFound){
                finalString+=temp[n]+"@@";
            }else{
                if(isLast){
                    String names [] = separateLastNameExtention(lastName);
                    lastName = names[0].trim();
                    extentionName = names[1].trim();
                    
                    finalString+=firstName.trim()+" "+middleName.trim()+" "+lastName+" "+extentionName+"@@";
                }
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
                    if(temp[n].length() > 1){
                        finalString+=temp[n].trim();
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
    protected String toNameFormatFull2(String line,int [] columnIndex){
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
                            extentionName = tempName[1].toUpperCase();
                        } catch (Exception e) {
                            System.err.println("Changing Extention Error @ toNameFormat() in myFunctions.java");
                        }
                    }
                    finalString+=temp[n].toUpperCase()+", ";
                }else{
                    if(temp[n].length() > 1){
                        finalString+=temp[n].toUpperCase().trim();
                    }else{
                        //Remove comma
                        finalString = finalString.substring(0, finalString.length()-2);
                    }
                    //Add Extention at the End
                    if(extentionName.trim().length()>0){
                        finalString+=", "+extentionName.trim();
                    }
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
    public String numberToWordMonth(String monthNumber){
        String finalDate = "";
        switch (Integer.parseInt(monthNumber)){
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
        return finalDate;
    }
    public Date dateTimeTojCalendarDateFormat(String dateOrDateTime){
        String values [] = dateOrDateTime.split(" ");
        
        String dates [] = values[0].split("-");
        
        int year = Integer.parseInt(dates[0]);
        int month = Integer.parseInt(dates[1]);
        int date = Integer.parseInt(dates[2]);
        return new Date(year-1900, month-1, date);
    }
    public String jCalendarToNumberDate(String jCalendarDateString,boolean includeTime){
        if(jCalendarDateString == null){
            return null;
        }
        
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
    public boolean isInsideArray(int toSearch,int [] array){
        for (int array1 : array) {
            if(array1 == toSearch){
                return true;
            }
        }
        return false;
    }
    public boolean isInsideArray(String toSearch,String [] array){
        for (String array1 : array) {
            if (array1.equals(toSearch)) {
                return true;
            }
        }
        return false;
    }
    //</editor-fold>
    //<editor-fold desc="Nutritional Status Functions">
    public String getNutritionalStatus(String bmiString,String age,String gender){
        String where = "WHERE yearMonth='"+age+"'";
        String table = gender.contains("Female") ? "bmichart_female":"bmichart_male";
        String result [] = return_values("*", table, where, myVariables.getBmiChartOrder());
        
        if(result != null){
            float bmi = Float.parseFloat(bmiString);
            
            String values [] = result[0].split("@@");
            float severelyWasted = Float.parseFloat(String.valueOf(values[3]));
            float wasted = Float.parseFloat(String.valueOf(values[4]));
            float normal = Float.parseFloat(String.valueOf(values[5]));
            float overWeight = Float.parseFloat(String.valueOf(values[6]));
            //System.err.println("Result: "+result[0]+"\nBMI for Nut Status: "+bmi);
            
            if(bmi <= severelyWasted){
                return "Severely Wasted";
            }if(bmi > severelyWasted && bmi <=wasted){
                return "Wasted";
            }if(bmi > wasted && bmi <=normal){
                return "Normal";
            }if(bmi > normal && bmi <=overWeight){
                return "Overweight";
            }if(bmi > overWeight){
                return "Obese";
            }
            
            return "Invalid BMI!";
        }else{
            return "Age out Of Range!";
        }
    }
    public String getHeightForAge(String heightM,String age,String gender,boolean includeId){
        String where = "WHERE yearMonth='"+age+"'";
        String table = gender.contains("Female") ? "hfachart_female":"hfachart_male";
        String result [] = return_values("*", table, where, myVariables.getHfaChartOrder());
        
        if(result != null){
            float height = Float.parseFloat(heightM)*100;
            
            String values [] = result[0].split("@@");
            float severelyStunted = Float.parseFloat(String.valueOf(values[3]));
            float stunted = Float.parseFloat(String.valueOf(values[4]));
            float normal = Float.parseFloat(String.valueOf(values[5]));
            float tall = Float.parseFloat(String.valueOf(values[6]));
            
            if(height <= severelyStunted){
                return "Severely Stunted";
            }if(height > severelyStunted && height <= stunted){
                return "Stunted";
            }if(height > stunted && height <= normal){
                return "Normal";
            }if(height > normal /*&& height <= stunted*/){
                return "Tall";
            }
            
            return "Invalid Height!";
        }else{
            return "Age out Of Range!";
        }
    }
    public String getHeightSquared(String heightM){
        DecimalFormat df = new DecimalFormat("#.####");
        //df.setRoundingMode(RoundingMode.DOWN);
        float height = Float.parseFloat(heightM);
        float heightSq = height*height;
        
        System.err.println("Raw Height Squared: "+heightSq);
        String finalString = df.format(heightSq);
        
        //add missing decimal places
        String decimal[] = finalString.split("\\.");
        if(decimal.length == 2){
            //check length
            for(int n=0;n<4-decimal[1].length();n++){
                finalString+="0";
            }
        }else{
            //System.err.println("No Decimal Places :"+decimal[0]);
            
            finalString+=".0000";
        }
        //System.err.println("Final Height: "+finalString);
        return finalString;
    }
    public String getBmi(String weight,String heightSq){
        DecimalFormat df = new DecimalFormat("#.#");
        df.setRoundingMode(RoundingMode.DOWN);
        float bmi = Float.parseFloat(weight)/Float.parseFloat(heightSq);
        System.err.println("raw BMI :"+bmi);
        
        return df.format(bmi);
    }
    public String getAgeInYearsMonths(String dateConducted,String dateOfBirth,boolean includeMonths){
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
    public void writeExcelSingleData(int sheetNumber,String value,int rowStart,int columnStart){
        XSSFSheet sheet = workbook.getSheetAt(sheetNumber);
        workbook.setActiveSheet(sheetNumber);
        
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
    
    public void writeExcelSingleDataWColor(int sheetNumber,String value,String excelAddress,Color color,BorderStyle [] lrtpBorder){
        //Note: excellAddress must have ',' to separate the address. E.G. ( A,1 )
        int [] location = parseExcelAddress(excelAddress);
        writeExcelSingleDataWColor(sheetNumber, value, location[0], location[1], color, lrtpBorder);
    }
    public void writeExcelSingleDataWColor(int sheetNumber,String value,int rowStart,int columnStart,Color color,BorderStyle [] lrtpBorder){
        XSSFSheet sheet = workbook.getSheetAt(sheetNumber);
        workbook.setActiveSheet(sheetNumber);
        XSSFCellStyle cellStyle;
        XSSFCellStyle style;
        XSSFFont font,newFont;
        XSSFColor myColor = new XSSFColor(color, new DefaultIndexedColorMap());
        
        style = workbook.createCellStyle();
        newFont = workbook.createFont();
        
        if(sheet == null){
            sheet = workbook.createSheet("SHEET_"+(sheetNumber+1));
        }
        
        XSSFRow row = null;
        row = sheet.getRow(rowStart);
        
        if(row != null){
            XSSFCell cell = row.getCell(columnStart);
            cellStyle = cell.getCellStyle();
            font = cellStyle.getFont();
            
            newFont.setColor(myColor);
            newFont.setFontName(font.getFontName());
            
            style.setBorderLeft(lrtpBorder[0]);
            style.setBorderRight(lrtpBorder[1]);
            style.setBorderTop(lrtpBorder[2]);
            style.setBorderBottom(lrtpBorder[3]);
            
            style.setFont(newFont);
            style.setAlignment(cellStyle.getAlignment());
            style.setVerticalAlignment(cellStyle.getVerticalAlignment());
            
            //style.setFillForegroundColor(new XSSFColor(color, new DefaultIndexedColorMap()));
            //style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            
            if(cell != null){
                cell.setCellValue(value);
                cell.setCellStyle(style);
            }else{
                XSSFCell newCell = row.createCell(columnStart);
                newCell.setCellValue(value);
                newCell.setCellStyle(style);
            }
        }else{
            row = sheet.createRow(rowStart);
            XSSFCell newCell = row.createCell(columnStart);
            cellStyle = newCell.getCellStyle();
            font = cellStyle.getFont();
            
            newFont.setColor(myColor);
            newFont.setFontName(font.getFontName());
            
            style.setBorderLeft(cellStyle.getBorderLeft());
            style.setBorderRight(cellStyle.getBorderRight());
            style.setBorderTop(cellStyle.getBorderTop());
            style.setBorderBottom(cellStyle.getBorderBottom());
            
            style.setFont(newFont);
            style.setAlignment(cellStyle.getAlignment());
            
            newCell.setCellValue(value);
            newCell.setCellStyle(style);
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
        workbook.setActiveSheet(sheetNumber);
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
            
            System.err.println("Picture Index: "+pictureIndex);
            
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
    public boolean isCellEmpty(int sheetNumber,String excelAddress){
        int address [] = parseExcelAddress(excelAddress);
        XSSFSheet sheet = workbook.getSheetAt(sheetNumber);
        XSSFRow row = sheet.getRow(address[0]);
        XSSFCell cell = row.getCell(address[1]);
        
        if(cell == null){
            return true;
        }if(cell.getStringCellValue().trim().length()<=0){
            return true;
        }
        return false;
    }
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
    public int [] parseExcelColumns(String excelColumnAddress){
        // Adresses must be in a format of E.G. ( A,B,D,E,G ) in ascending order
        if(excelColumnAddress == null || excelColumnAddress.length() <= 0){
            return null;
        }
        
        String letters [] = excelColumnAddress.toLowerCase().split(",");
        int [] indeces = new int[letters.length];
        
        for (int n = 0; n < indeces.length; n++) {
            indeces[n] = getLetterValueAdvanced( letters[n] );
            if(myVariables.isDebugModeOn()){
                System.err.println("Skipping column: "+letters[n]+"="+indeces[n]);
            }
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
        if(myVariables.isDebugModeOn()){
            System.err.println("Advanced Value: "+currentValue);
        }
        return currentValue;
    }
    public String removeSubjectGrade(String line,String separator){
        String temp = "";
        String text [] = line.split(separator);
        
        for(String word : text){
            try {
                Integer.parseInt(word);
            } catch (Exception e) {
                temp+=word+separator;
            }
        }
        
        return temp.trim();
    }
    public void removeSheetsAt(int sheetIndexInOrder []){
        int sheetCount = workbook.getNumberOfSheets();
        for (int n = sheetCount-1; n >= 0; n--) {
            try {
                workbook.removeSheetAt(sheetIndexInOrder[n]);
            } catch (Exception e) {
            }
        }
    }
    public void keepOneSheetOnly(int sheetIndexToKeep){
        int sheetCount = workbook.getNumberOfSheets();
        for (int n = sheetCount-1; n >= 0; n--) {
            try {
                if(n != sheetIndexToKeep){
                    workbook.removeSheetAt(n);
                }
            } catch (Exception e) {
            }
        }
    }
    public void setSheetSelected(int sheetIndex){
        workbook.setActiveSheet(sheetIndex);
    }
    //</editor-fold>
    //</editor-fold>
    public ImageIcon getImgIcn(String url){
        return new ImageIcon(getClass().getResource(url));
    }
    
    public Image getImage(String url){
        return new ImageIcon(getClass().getResource(url)).getImage();
    }

    public static Thread getMainThead() {
        return mainThead;
    }

    public static Thread getSecondThread() {
        return secondThread;
    }

    public static Thread getThirdThread() {
        return thirdThread;
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
    // call this method if condition contains tvl
    private String getTvlDecription(String tvl){
        String temp = "";
        
        String tempArr[] = tvl.toString().split("@@");
        String tvlStrand = tempArr[6];
        
        //split the tvl to get the tvl desc
        String temp2Arr[] = tvlStrand.split("-");
        //set the final description of tvl
        temp = temp2Arr[1];
        //set the value
        myVariables.setTvl_dec(temp);
        
        
        return temp;
    }
    
    
     public void getStrandFromSectionID(String from,String where, int view_order[]){
        //default table order
        int order [] = view_order;
        Arrays.sort(order);
        String  [] result = return_values("*", from, where,order);
        
        String finalStrand = "";
       
        
        StringBuilder sb = new StringBuilder();
        
         for (int x =0;x<result.length;x++){
             sb.append(result[x]);             
         }
         
        if(sb.toString().contains("ABM")){
             finalStrand = "ABM";   
         }
        if (sb.toString().contains("HUMMS")){
             finalStrand = "HUMMS";
         }
        if(sb.toString().contains("STEM")){
             finalStrand = "STEM";
         }
        if(sb.toString().contains("TVL")){
             finalStrand = "TVL";
             getTvlDecription(sb.toString());
         }
        if(sb.toString().contains("ABM") && sb.toString().contains("STEM")){
             finalStrand = "ABM/STEM";
         }
        if(sb.toString().contains("ABM") && sb.toString().contains("HUMMS")){
             finalStrand = "ABM/HUMMS";
         }
        if(sb.toString().contains("ABM") && sb.toString().contains("TVL")){
             finalStrand = "ABM/TVL";
             getTvlDecription(sb.toString());
         }
        if(sb.toString().contains("HUMMS") && sb.toString().contains("STEM")){
             finalStrand = "HUMMS/STEM";
         }
        if(sb.toString().contains("HUMMS") && sb.toString().contains("TVL")){
             finalStrand = "HUMMS/TVL";
             getTvlDecription(sb.toString());
         }if (sb.toString().contains("STEM") && sb.toString().contains("TVL")){
             finalStrand = "STEM/TVL";
             getTvlDecription(sb.toString());
         }
        
         //setter method
         myVariables.setStrandName(finalStrand);

    }
     
     
     public void getSemFromSectionID(String from,String where, int view_order[]){
        //default table order
        int order [] = view_order;
        Arrays.sort(order);
        String  [] result = return_values("*", from, where,order);
        
        String finalSem = "";
        
        StringBuilder sb = new StringBuilder();
        
         for (int x =0;x<result.length;x++){
             sb.append(result[x]);
         }
         
        if(sb.toString().contains("1st")){
            finalSem = "1st semester";
        }else{
            finalSem = "2nd semester";
        }
        
         //setter method
         myVariables.setSem(finalSem);

    }
     
    
    
}



