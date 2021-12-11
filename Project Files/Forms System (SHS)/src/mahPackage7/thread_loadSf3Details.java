/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mahPackage7;

import java.awt.Dialog;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

/**
 *
 * @author Phil Rey Paderogao
 */
public class thread_loadSf3Details extends SwingWorker<String, Object>{
    //<editor-fold desc="Variables">
    long threadDelay = 100;
    long pauseDelay = 500;
    myFunctions my;
    
    //Sf4 Variables (Optional)
    private JTextField tfSectionName;
    private JTextField tfAdviserName;
    private JTextField tfGradeLevel;
    private JTextField tfSchoolYear;
    
    //Main Variables
    private JTable sf3Table;
    private JTable sf3BooksTable;
    
    private String sectionId;
    private String subjectId;
    private String missingValuesSubstitute;
    private String remarksValuesSubstitute;
    private String booksContained;
    
    private boolean waitForMainThreadToFinish;
    
    private JButton btnExport;
    //Dialog Properties
    private JDialog dialog;
    private JFrame jFrameName;
    private JPanel dialogPanel;
    private JLabel lbLoadingMessage;
    private JProgressBar progressBar;
    //</editor-fold>

    public thread_loadSf3Details(JTable [] tablesToUse,String [] stringsToUse,JTextField [] textFieldsToUse,JButton [] buttonsToUse,boolean [] waitForThreadsToFinish) {
        my = new myFunctions(true);
        sf3Table = tablesToUse[0];
        sf3BooksTable = tablesToUse[1];
        
        sectionId = stringsToUse[0];
        subjectId = stringsToUse[1];
        missingValuesSubstitute = stringsToUse[2];
        remarksValuesSubstitute = stringsToUse[3];
        booksContained = stringsToUse[4];
        
        tfSectionName = textFieldsToUse[0];
        tfAdviserName = textFieldsToUse[1];
        tfGradeLevel = textFieldsToUse[2];
        tfSchoolYear = textFieldsToUse[3];
        
        btnExport = buttonsToUse[0];
        
        waitForMainThreadToFinish = waitForThreadsToFinish[1];
        //For Loading Screen
        jFrameName = myVariables.getCurrentLoadingFrame();
        dialogPanel = myVariables.getLoadingPanel();
        lbLoadingMessage = myVariables.getLbLoadingMessage();
        progressBar = myVariables.getProgressBar();
        
        //For thead Speed
        long [] threadSpeeds = myVariables.getProcessingSpeedValue();
        threadDelay = threadSpeeds[0];
        pauseDelay = threadSpeeds[1];
    }
    
    
    @Override
    protected String doInBackground() throws Exception {
        btnExport.setEnabled(false);
        try {
            showCustomDialog("Loading Books...", dialogPanel, false, 320, 220, false);
            lbLoadingMessage.setText("Loading Book Template...");
            progressBar.setMaximum(1);
            progressBar.setValue(0);
            String bookIds = booksContained.substring(0, booksContained.length()-1).replace(":", ",");

            String result [] = my.return_values("*", "books", "WHERE id IN("+bookIds+")", myVariables.getBooksOrder());
            Thread.sleep(pauseDelay);
            if(result != null){
                if(!loadBooks(result)){
                    throw new InterruptedException("Interrupted bt user.");
                }
                my.searchItemThread("", "WHERE sectionId='"+sectionId+"'", sf3Table, 13, new int[]{3,4,5}, new boolean[]{true,false}, null, null, null);
                //<editor-fold desc="Wait for search students to finish">
                if(waitForMainThreadToFinish){
                    while (true) {                    
                        if(myFunctions.getMainThead() != null){
                            if(!myFunctions.getMainThead().isAlive()){
                                break;
                            }
                        }else{
                            break;
                        }
                    }
                }//</editor-fold>
                showCustomDialog("Loading Books...", dialogPanel, waitForMainThreadToFinish, 320, 220, false);
                Thread.sleep(pauseDelay);
                loadEmptyCounters();
                //Load student's book records
                if(!loadStudentBooks()){
                    throw new InterruptedException("Interrupted by user.");
                }
                if(!translateColumns()){
                    throw new InterruptedException("Interrupted by user.");
                }
                if(!countBooks()){
                    throw new InterruptedException("Interrupted by user.");
                }
            }else{
                loadEmptyCounters();
                return "No Students Found";
            }
            btnExport.setEnabled(true);
            return "Ended Successfully";
        } catch (InterruptedException e) {
            return "Interrupted by user";
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void done() {
        try {
            System.err.println("Sf3 Thread Done: "+get());
        } catch (Exception e) {
            System.err.println("Sf3 Thread Error found: "+e.getLocalizedMessage());
        }
        closeCustomDialog();
        super.done(); //To change body of generated methods, choose Tools | Templates.
    }
    private boolean isInDateFormat(String cLine){
        try {
            String temp [] = cLine.split("-");
            if(temp.length == 3){
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
    private boolean countBooks(){
        try {
            int studCount = sf3Table.getRowCount()-3;
            int columnCount = (sf3BooksTable.getRowCount()*2)+5;
            int booksTableCount = sf3BooksTable.getRowCount();
            int booksMale,booksFemale;
            
            progressBar.setMaximum(booksTableCount);
            progressBar.setValue(0);
            for(int col = 5;col<columnCount;col++){
                lbLoadingMessage.setText("Counting Books Issued & Returned...Book "+(getSf3BooksRowIndex(col)+1)+" of "+booksTableCount);
                progressBar.setValue(getSf3BooksRowIndex(col)+1);
                booksMale = 0;booksFemale = 0;
                for(int row=0;row<studCount;row++){
                    String gender = sf3Table.getValueAt(row, 4).toString();
                    
                    
                    if(isInDateFormat(sf3Table.getValueAt(row, col).toString())){
                        if(gender.contains("Female")){
                            booksFemale++;
                        }else{
                            booksMale++;
                        }
                    }
                    Thread.sleep(threadDelay);
                }
                //Put result to counters
                sf3Table.setValueAt(booksMale, studCount, col);
                sf3Table.setValueAt(booksFemale, studCount+1, col);
                sf3Table.setValueAt(booksMale+booksFemale, studCount+2, col);
                
                //Put values to summary
                if(col%2==1){//Issued
                    sf3BooksTable.setValueAt(booksMale+booksFemale, getSf3BooksRowIndex(col), 5);
                }else{//Returned
                    int currIssued = Integer.parseInt(sf3BooksTable.getValueAt(getSf3BooksRowIndex(col), 5).toString());
                    sf3BooksTable.setValueAt(booksMale+booksFemale, getSf3BooksRowIndex(col), 6);
                    sf3BooksTable.setValueAt(currIssued-(booksMale+booksFemale), getSf3BooksRowIndex(col), 7);
                }
                
                
                Thread.sleep(threadDelay);
            }
            
            
            return true;
        } catch (InterruptedException e) {
            System.err.println("Interrupted @ count books");
            return false;
        }
    }
    private int getSf3BooksRowIndex(int columnIndex){
        int bookIndex = 0;
        int sf3BooksIndex = -1;
        if(columnIndex%2==1){   //issued
            bookIndex = columnIndex;
        }else{                  //returned
            bookIndex = columnIndex-1;
        }
        switch(bookIndex){
            case 5:{
                sf3BooksIndex = 0;break;
            }case 7:{
                sf3BooksIndex = 1;break;
            }case 9:{
                sf3BooksIndex = 2;break;
            }case 11:{
                sf3BooksIndex = 3;break;
            }case 13:{
                sf3BooksIndex = 4;break;
            }case 15:{
                sf3BooksIndex = 5;break;
            }case 17:{
                sf3BooksIndex = 6;break;
            }case 19:{
                sf3BooksIndex = 7;break;
            }case 21:{
                sf3BooksIndex = 8;break;
            }case 23:{
                sf3BooksIndex = 9;break;
            }
        }
        return sf3BooksIndex;
    }
    private String [] getBookDetails(int columnIndex){
        int bookIndex = 0;
        int sf3BooksIndex = -1;
        if(columnIndex%2==1){   //issued
            bookIndex = columnIndex;
        }else{                  //returned
            bookIndex = columnIndex-1;
        }
        switch(bookIndex){
            case 5:{
                sf3BooksIndex = 0;break;
            }case 7:{
                sf3BooksIndex = 1;break;
            }case 9:{
                sf3BooksIndex = 2;break;
            }case 11:{
                sf3BooksIndex = 3;break;
            }case 13:{
                sf3BooksIndex = 4;break;
            }case 15:{
                sf3BooksIndex = 5;break;
            }case 17:{
                sf3BooksIndex = 6;break;
            }case 19:{
                sf3BooksIndex = 7;break;
            }case 21:{
                sf3BooksIndex = 8;break;
            }case 23:{
                sf3BooksIndex = 9;break;
            }
        }
        //System.err.println("bookIndex="+bookIndex+" sf3BIndex="+sf3BooksIndex);
        try {
            String result = my.get_table_row_values(sf3BooksIndex, sf3BooksTable);
            return result.split("@@");
        } catch (Exception e) {
            return null;
        }
    }
    private boolean translateColumns(){
        try {
            int studentCount = sf3Table.getRowCount()-3;
            String currentValue="",remarks="";
            showCustomDialog("Loading Books...", dialogPanel, false, 420, 220, false);
            progressBar.setMaximum(20*studentCount);
            //progressBar.setMaximum(studentCount);
            progressBar.setValue(0);
            for(int rows=0;rows<studentCount;rows++){
                try {
                    remarks = sf3Table.getValueAt(rows, 25).toString();
                } catch (Exception e) {
                    remarks=missingValuesSubstitute;
                }
                for(int col=5;col<25;col++){
                    lbLoadingMessage.setText("Interpreting Remarks of Student "+(rows+1)+" of "+studentCount+". "+(col-4)+"/"+(20)+" processed.");
                    progressBar.setValue((col-4)+(rows*20));
                    String [] currentBookDetails = getBookDetails(col);
                    try {
                        currentValue = sf3Table.getValueAt(rows, col).toString();
                        
                        if(col%2==1){   //issued column
                            
                        }else{  //returned column
                            if(currentValue.contains(":")){
                                String codes [] = currentValue.split(":");
                                if(codes.length == 2){
                                    sf3Table.setValueAt(codes[0], rows, col);
                                    //USe remarksSubstituteValues
                                    int indexToUse = 4;
                                    if(remarksValuesSubstitute.equals("CODE")){
                                        indexToUse = 1;
                                    }if(remarksValuesSubstitute.equals("NAME")){
                                        indexToUse = 2;
                                    }
                                    
                                    if(remarks.trim().length() <= 0 || (remarks.length()==2 && remarks.contains("--"))){
                                        remarks = currentBookDetails[indexToUse]+":"+codes[1];
                                    }else{
                                        remarks +=", "+currentBookDetails[indexToUse]+":"+codes[1];
                                    }
                                    System.err.println("Code for Remark: "+codes[1]);
                                    //Add to counter based on CODE
                                    if(codes[1].contains("PTL")){
                                        int currCount = Integer.parseInt(sf3BooksTable.getValueAt(getSf3BooksRowIndex(col), 8).toString());
                                        sf3BooksTable.setValueAt(currCount+1, getSf3BooksRowIndex(col), 8);
                                    }if(codes[1].contains("TDO")){
                                        int currCount = Integer.parseInt(sf3BooksTable.getValueAt(getSf3BooksRowIndex(col), 9).toString());
                                        sf3BooksTable.setValueAt(currCount+1, getSf3BooksRowIndex(col), 9);
                                    }if(codes[1].contains("LLTR")){
                                        int currCount = Integer.parseInt(sf3BooksTable.getValueAt(getSf3BooksRowIndex(col), 10).toString());
                                        sf3BooksTable.setValueAt(currCount+1, getSf3BooksRowIndex(col), 10);
                                    }
                                }else{
                                    //Rejoin index 1 onwards into one string
                                }
                            }
                        }
                        Thread.sleep(threadDelay);
                    } catch (InterruptedException in){
                        return false;
                    } catch (NullPointerException e) {
                        sf3Table.setValueAt(missingValuesSubstitute, rows, col);
                        Thread.sleep(threadDelay);
                    } 
                    
                }
                //set remarks
                sf3Table.setValueAt(remarks, rows, 25);
                Thread.sleep(pauseDelay);
            }
            return true;
        } catch (Exception e) {
            System.err.println("Interrupted @ Translate Columns");
            return false;
        }
    }
    private boolean loadStudentBooks(){
        int studCount = sf3Table.getRowCount();
        progressBar.setMaximum(studCount-3);
        progressBar.setValue(0);
        try {
            for(int n=0;n<studCount-3;n++){ //Loop sf3 table
                lbLoadingMessage.setText("Loading Student "+(n+1)+" of "+(studCount-3));
                progressBar.setValue(n+1);
                String studentId = sf3Table.getValueAt(n, 2).toString();
                Thread.sleep(pauseDelay);
                
                lbLoadingMessage.setText("Connecting to Database...");
                String booksIsdRtn [] = my.return_values("*", "booksissuedreturned", "WHERE sectionId='"+sectionId+"' AND studentId='"+studentId+"'", myVariables.getBooksIssuedReturnedOrder());
                int booksLength = booksIsdRtn.length;
                if(booksIsdRtn != null){
                    for(int x=0;x<booksLength;x++){
                        lbLoadingMessage.setText("Processing Record "+(x+1)+" of "+booksLength);
                        putValuesToBookColumn(n, booksIsdRtn[x]);
                        Thread.sleep(threadDelay);
                    }

                }else{
                    //Fill with empty values
                    for(int x=5;x<25-(sf3BooksTable.getRowCount()*2);x++){
                        sf3Table.setValueAt(missingValuesSubstitute, n, x);
                    }
                    sf3Table.setValueAt("NRA", n, 25);
                }
                Thread.sleep(pauseDelay);
            }
            return true;
        } catch (Exception e) {
            System.err.println("Interrupted @ Load Student Books");
            return false;
        }
    }
    private void putValuesToBookColumn(int row,String cLine){
        String recordValues [] = cLine.split("@@");
        String dateIssued = recordValues[4];
        String dateReturned = recordValues[5];
        
        //Search for matching book ID from sf3Books table
        int booksLength = sf3BooksTable.getRowCount();
        int bookId = Integer.parseInt(recordValues[3]),foundBookId=0;
        boolean matchFound = false;
        int indexSaved = 0;
        for(int n=0;n<booksLength;n++){
            foundBookId = Integer.parseInt(sf3BooksTable.getValueAt(n, 0).toString());
            if(bookId == foundBookId){
                matchFound = true;
                indexSaved = (n*2)+5;
                break;
            }
        }
        if(!matchFound){
            System.err.println("Excess Record Found. Excluding...");return;
        }
        
        sf3Table.setValueAt(dateIssued, row, indexSaved);
        sf3Table.setValueAt(dateReturned, row, indexSaved+1);
    }
    private boolean loadEmptyCounters(){
        try {
            lbLoadingMessage.setText("Loading Counters...");
            String extraFields="";
            for(int n=0;n<21;n++){
                extraFields+=missingValuesSubstitute+"@@";
            }
            String counters [] = {
                "--@@--@@--@@<== Total For Male ==>@@--@@"+extraFields,
                "--@@--@@--@@<== Total For Female ==>@@--@@"+extraFields,
                "--@@--@@--@@<== Total Learners==>@@--@@"+extraFields,
            };

            for(int n=0;n<counters.length;n++){
                my.add_table_row(counters[n], sf3Table);
                Thread.sleep(threadDelay);
            }
            Thread.sleep(pauseDelay);
            return true;
        } catch (Exception e) {
            System.err.println("Interrupted @ Load Empty Counters");
            return false;
        }
    }
    
    private boolean loadBooks (String [] result){
        my.clear_table_rows(sf3BooksTable);
        String booksOrder [] = booksContained.split(":");
        int orderLength = booksOrder.length;
        int currentId = 0,resultId = 0;
        try {
            progressBar.setValue(0);
            progressBar.setMaximum(orderLength);
            //Load books order by template order
            for(int n=0;n<booksOrder.length;n++){
                lbLoadingMessage.setText("Loading Book "+(n+1)+" of "+orderLength);
                progressBar.setValue(n+1);
                currentId = Integer.parseInt(booksOrder[n]);
                for(int x=0;x<result.length;x++){
                    resultId = Integer.parseInt(my.getValueAtColumn(result[x], 0));

                    if(currentId == resultId){
                        my.add_table_row(result[x]+"--@@0@@0@@0@@0@@0@@0@@", sf3BooksTable);
                        break;
                    }
                }
                Thread.sleep(threadDelay);
            }
            lbLoadingMessage.setText("Marking Indeces...");
            //Mark Book index
            for(int n=0;n<sf3BooksTable.getRowCount();n++){
                lbLoadingMessage.setText("Marking Indeces...Book "+(n+1)+" of "+sf3BooksTable.getRowCount());
                sf3BooksTable.setValueAt("B"+(n+1), n, 4);
                Thread.sleep(threadDelay);
            }
            Thread.sleep(pauseDelay);
            return true;
        } catch (InterruptedException e) {
            System.err.println("Interrupted @ LoadBooks");
            return false;
        }
    }
    
    private void showCustomDialog(String title, JPanel customPanel, boolean isModal, int width, int height, boolean isResizable){
        if(dialog != null && dialog.isVisible()){
            dialog.setSize(width, height);
            dialog.setTitle(title);
            dialog.add(customPanel);
            dialog.setLocationRelativeTo(jFrameName);
            System.err.println("Sf3 Dialog is already visible. Skipping...");
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
