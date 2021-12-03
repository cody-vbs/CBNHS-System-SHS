package mahPackage2;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
    public void loadSettings() throws IOException{
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
    //</editor-fold>
    //<editor-fold desc="TABLE FUNCTIONS">
    /**
    * By: <b>Syd</b>
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
        if(searchField.getText().length() <=0 && !allowEmptyFields){
            showMessage("Please search someting", JOptionPane.ERROR_MESSAGE);
            if(resultText!= null){
                resultText.setText("Search using the search bar...");
            }
            return;
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
            }default:{
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
                System.out.println(result.length);
            }
        }else{
            showMessage("No Results found.", JOptionPane.PLAIN_MESSAGE);
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
    //</editor-fold>
    public ImageIcon getImgIcn(String url){
        return new ImageIcon(getClass().getResource(url));
    }
    
    public Image getImage(String url){
        return new ImageIcon(getClass().getResource(url)).getImage();
    }
    
    
        
    //method md5 conversion
    public String convertMd5(String input)
    {
        try {
  
            MessageDigest md = MessageDigest.getInstance("MD5");
  
            byte[] messageDigest = md.digest(input.getBytes());
  
            BigInteger no = new BigInteger(1, messageDigest);
  
            // Convert message digest into hex value
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
    
}


