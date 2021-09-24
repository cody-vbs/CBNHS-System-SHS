/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mahPackage3;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.SwingUtilities;
import javazoom.jl.player.Player;

/**
 *
 * @author Phil Rey
 */
public class dashBoard extends javax.swing.JFrame {
    myFunctions my;
    timeThread tr;
    Font pixelMplus;
    Font poppins48;
    Font poppins38;
    Font poppins30;
    Font poppins24;
    Font poppins19;
    Font poppins16;
    Font poppins14;
    Font poppins12;
    Font poppins12R;
    
    
    public class RoundJTextField extends JTextField {
        private Shape shape;
        public RoundJTextField(int size) {
            super(size);
            setOpaque(false); // As suggested by @AVD in comment.
        }
        protected void paintComponent(Graphics g) {
             g.setColor(getBackground());
             g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
             super.paintComponent(g);
        }
        protected void paintBorder(Graphics g) {
             g.setColor(getForeground());
             g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
        }
        public boolean contains(int x, int y) {
             if (shape == null || !shape.getBounds().equals(getBounds())) {
                 shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 15, 15);
             }
             return shape.contains(x, y);
        }
    }
    
    
    
    public dashBoard() {
        
        try{
            // load a custom font in your project folder
			pixelMplus = Font.createFont(Font.TRUETYPE_FONT, new File("Poppins-Regular.ttf")).deriveFont(16f);	
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Poppins-Regular.ttf")));		
                        
                        
                        poppins48 = Font.createFont(Font.TRUETYPE_FONT, new File("Poppins-SemiBold.ttf")).deriveFont(48f);	
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Poppins-SemiBold.ttf")));	
                        
                        poppins38 = Font.createFont(Font.TRUETYPE_FONT, new File("Poppins-SemiBold.ttf")).deriveFont(38f);	
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Poppins-SemiBold.ttf")));	
                        
                        poppins30 = Font.createFont(Font.TRUETYPE_FONT, new File("Poppins-SemiBold.ttf")).deriveFont(30f);	
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Poppins-SemiBold.ttf")));	
                        
                        poppins24 = Font.createFont(Font.TRUETYPE_FONT, new File("Poppins-SemiBold.ttf")).deriveFont(24f);	
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Poppins-SemiBold.ttf")));	
                        
                        poppins19 = Font.createFont(Font.TRUETYPE_FONT, new File("Poppins-SemiBold.ttf")).deriveFont(19f);	
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Poppins-SemiBold.ttf")));
                        
                        poppins16 = Font.createFont(Font.TRUETYPE_FONT, new File("Poppins-SemiBold.ttf")).deriveFont(16f);	
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Poppins-SemiBold.ttf")));	
                        
                        poppins14 = Font.createFont(Font.TRUETYPE_FONT, new File("Poppins-SemiBold.ttf")).deriveFont(14f);	
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Poppins-SemiBold.ttf")));	
                        
                        poppins12 = Font.createFont(Font.TRUETYPE_FONT, new File("Poppins-SemiBold.ttf")).deriveFont(12f);	
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Poppins-SemiBold.ttf")));	
                        
                        poppins12R = Font.createFont(Font.TRUETYPE_FONT, new File("Poppins-Regular.ttf")).deriveFont(12f);	
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Poppins-SemiBold.ttf")));	
                        
                       
		}
		catch(IOException | FontFormatException e){
			
		}
        
        
        
        
        
        my = new myFunctions(false);
        initComponents();
        myInitComponents();
        
        menu.setText(myVariables.getUserLoggedInName());
        menu.setFont(poppins14);
        
//        tr = new timeThread(lbDateTime);
        jLabel22.setFont(poppins12R);
        lbLoggedInUser.setText(myVariables.getUserLoggedInName());
        lbLoggedInUser.setFont(poppins14);        
        lbLoggedInUser1.setText(myVariables.getAccessLevelName(-1));
        lbLoggedInUser1.setFont(poppins12R);
//        tr.execute();
        
        loadTabs();
        loadTabIcons();
        
        loadColoredButtons();
        loadLabels();
        
        loadTextFields();
        sortTables();
        
        setScrollSpeeds();
        loadYearDropDowns(12);
        
        
        
        setLoadingVariables();
        
        
        
//        lbSchoolName.setText(myVariables.getSchoolName() + " Attendance System");
//        lbSchoolAddress.setText(myVariables.getSchoolAddress());
    }
    
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
        SwingUtilities.invokeLater(new PlaySuccessMessageSound());
    }
    
    void playError(){
        SwingUtilities.invokeLater(new PlayErrorMessageSound());
    }
    
    
    
    
    
    
    
    
    
    
    private void setLoadingVariables(){
        myVariables.setProgressBar(jpbProgressBar);
        myVariables.setLbLoadingMessage(lbLoadingMessage);
        myVariables.setLoadingPanel(loadingDialog);
        myVariables.setCurrentLoadingFrame(this);
    }
    //<editor-fold desc="Custom Functions"> 
    JDialog dialog;
    JDialog seconDaryDialog;
    
    private void showCustomDialog(String title, JPanel customPanel, boolean isModal, int width, int height, boolean isResizable){
        dialog = new JDialog(this);
        dialog.setTitle(title);
        dialog.add(customPanel);
        dialog.setModal(isModal);
        dialog.setSize(width, height);
        dialog.setResizable(isResizable);
        
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }
    private void closeCustomDialog(){
        if(dialog != null){
            dialog.dispose();
        }else{
            System.err.println("Dialog is null...skipping");
        }
    }
    //Use only when making two jdialogs overlap
    private void showSecondaryCustomDialog(String title, JPanel customPanel, boolean isModal, int width, int height, boolean isResizable){
        seconDaryDialog = new JDialog(this);
        seconDaryDialog.setTitle(title);
        seconDaryDialog.add(customPanel);
        seconDaryDialog.setModal(isModal);
        seconDaryDialog.setSize(width, height);
        seconDaryDialog.setResizable(isResizable);
        
        seconDaryDialog.setLocationRelativeTo(this);
        seconDaryDialog.setVisible(true);
    }
    private void closeSecondaryCustomDialog(){
        if(seconDaryDialog != null){
            seconDaryDialog.dispose();
        }else{
            System.err.println("Dialog is null...skipping");
        }
    }
    
    private void setScrollSpeeds(){
        JScrollPane scrollpanes [] = {
            jScrollPane2,jScrollPane4,jScrollPane13,
        };
        
        int scrollSpeed = 15;
        
        for(int n=0;n<scrollpanes.length;n++){
            scrollpanes[n].getVerticalScrollBar().setUnitIncrement(scrollSpeed);
            scrollpanes[n].getHorizontalScrollBar().setUnitIncrement(scrollSpeed);
        }
    }
    private void sortTables(){
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        
        //Center Tables
        //my.centerTable(studentTable, centerRenderer);
        
        //Hide Table Columns
        if(!myVariables.isDebugModeOn()){
            my.hideColumns(assignedTeacherTable, new int [] {0,1,3,6,11,12,13});
            my.hideColumns(enrolledStudentsTable, new int [] {0,1,5,6});
            my.hideColumns(attendanceTable, new int [] {0,1,2,3});
            my.hideColumns(checkAttendanceTable, new int [] {0,1,5,6});
            my.hideColumns(recheckAttendanceTable, new int [] {0,1,5,6,11});
            
            my.hideColumns(gradesTable, new int [] {0,1,2,3,6,9});
        }
        
        //Set table fonts
        JTable tables [] = {
            assignedTeacherTable,
            attendanceTable,
            enrolledStudentsTable,
            checkAttendanceTable,
            recheckAttendanceTable,
            gradesTable,
        };
        //customizeTableColumnColors(sf1SectionTable, new int [] {0,1,2,3}, Color.RED,Color.WHITE,new Font("Segoe UI",Font.PLAIN,11),true);
        //customHeaders(sf1SectionTable, new int []{0,1,2,3}, Color.RED, Color.WHITE, new Font("Comic Sans MS", Font.BOLD, 12), true);
        for(int n=0;n<tables.length;n++){
            tables[n].getTableHeader().setFont(myVariables.COLUMN_HEADER_FONT);
            tables[n].setFont(myVariables.COLUMN_FONT);
            
            tables[n].setSelectionBackground(Color.decode("#DBCBB7"));
            tables[n].setSelectionForeground(Color.WHITE);
            tables[n].setRowHeight(20);
            
            //Center Tables
            my.centerTable(tables[n], centerRenderer);
            
            //Clear Tables
            my.clear_table_rows(tables[n]);
            
            //tables[n].setAutoCreateRowSorter(true);
        }
        
    }
    private void loadTabs(){
        //mainTab.add("Manage Students", manageStudentsTab);
        mainTab.add("Select Managed Section",selectSectionTab);
        mainTab.add("View Students",viewStudentsTab);
        mainTab.add("Check Attendance",checkAttendanceTab);
        mainTab.setFont(myVariables.TAB_HEADER_FONT);
        
        
    }
    private void loadTabIcons(){
        Icon tabIcons [] = {
            my.getImgIcn(myVariables.getSectionsIcon()),
            my.getImgIcn(myVariables.getViewStudentsIcon()),
            my.getImgIcn(myVariables.getCheckAttendanceIcon()),
        };
        
        for(int n=0;n<tabIcons.length;n++){
            mainTab.setIconAt(n,tabIcons[n]);
        }
        
        my.remove_multiple_tabs(mainTab, new int [] {1,2});
    }
    private void loadColoredButtons(){
        JButton buttons [] = {
            //Select Section
            btnSearchSection,
            btnSearchEnrolledStudent,
            //View Students
            btnSearchDate,
            
            btnEditAttendance,
            btnRecheckAttendance,
            btnCheckAttendance,
            
            btnLoadGrades,btnSaveEvaluation,
            //Check Attendance
            btnFinishAttendance,
            btnSaveChangesToAttendance,
                //Add Notes Dialog
                btnSaveNotes,
            //Recheck Attendance
            btnSaveRecheckAttendanceChanges,
            //Remarks
            btnEditRemarks,btnSaveRemarks,btnSetRemarks,
            //Loading
            btnCancelLoading,
        };
        
        JButton lightButtons [] = {
            //btnEdit1
        };
        Cursor tempC;
        for(int n=0;n<buttons.length;n++){
            buttons[n].setUI(new custom_styledButtonIU());
            //buttons[n].setBackground(new Color(22,66,33));
            buttons[n].setBackground(new Color(251,185,211));
            buttons[n].setForeground(Color.decode("#3A3939"));            
            buttons[n].setFont(myVariables.BUTTON_FONT);
            //buttons[n].setCursor(my.getCursor(myVariables.getHandCursor()));
            buttons[n].setCursor(new Cursor(Cursor.HAND_CURSOR));
            buttons[n].setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
        
        for(int n=0;n<lightButtons.length;n++){
            lightButtons[n].setUI(new custom_styledButtonIU());
            //buttons[n].setBackground(new Color(22,66,33));
            lightButtons[n].setBackground(Color.WHITE);
            lightButtons[n].setForeground(new Color(22,66,33));            
            lightButtons[n].setFont(new Font("Comic Sans MS",Font.BOLD,12));
            //buttons[n].setCursor(my.getCursor(myVariables.getHandCursor()));
            lightButtons[n].setCursor(new Cursor(Cursor.HAND_CURSOR));
            lightButtons[n].setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
    }
    private void loadLabels(){
        JLabel titleHeaderLabels [] = {
            jLabel35,jLabel36,jLabel37,jLabel38,jLabel39,jLabel40,jLabel41,
        };
        JLabel labels [] = {
            lbSearchResult,lbSearchResult1,
        };
        
        JLabel formsHeaderLabels [] = {
            jLabel1,jLabel2,jLabel3,jLabel4,jLabel8,jLabel9,jLabel14,
        };
        JLabel textFieldHeaderLabels [] = {
            lbAttendanceCount,jLabel7,jLabel5,lbDateAdded,jLabel10,jLabel11,lbDateToRecheck,
            jLabel12,jLabel13,jLabel15,jLabel16,jLabel17,jLabel18,lbLoadingMessage,jLabel20,
        };
        
        for (JLabel n : titleHeaderLabels) {
            n.setFont(myVariables.TITLE_HEADER_FONT);
            n.setForeground(Color.WHITE);
        }
        
        for(JLabel n : labels){
            n.setFont(myVariables.LABEL_FONT);
            n.setForeground(Color.WHITE);
        }
        
        for(JLabel n : formsHeaderLabels){
            n.setFont(myVariables.FORMS_HEADER_FONT);
            n.setForeground(Color.BLACK);
        }
        
        for(JLabel n : textFieldHeaderLabels){
            n.setFont(myVariables.TEXTFIELD_HEADER_FONT);
            n.setForeground(Color.BLACK);
        }
    }
    private void loadTextFields(){
        JDateChooser dateChoosers [] = {
            jdcDate,jdcCustomDate,
        };
        JSpinner spinners [] = {
            jsHours,jsMinutes
        };
        
        JTextField searchFields [] = {
            tfSearchTeacherLoad,tfSearchEnrolledStudent,
        };
        JTextField forms [] = {
            tfSf1Remarks,tfSf1RemarksDisplay,tfSf2Remarks,tfSf2RemarksDisplay,
            tfGeneralAverage,tfFailedSubjects,
        };
        for(JSpinner n : spinners){
            n.setFont(myVariables.TEXTFIELD_FONT);
        }
        for(JDateChooser n : dateChoosers){
            n.setFont(myVariables.TEXTFIELD_FONT);
            n.setDateFormatString("yyyy-MM-dd");
        }
        for(JTextField n : searchFields){
            n.setFont(myVariables.SEARCH_TEXTFIELD_FONT);
        }
        for(JTextField n : forms){
            n.setFont(myVariables.TEXTFIELD_FONT);
        }
    }
    private void loadYearDropDowns(int numberOfYears){
        JComboBox [] yearDropDowns = {
            
        };
        
        JComboBox [] yearDropDownsWithAllOption = {
            jcbSchoolYear1,
        };
        JComboBox [] dropDowns = {
            jcbMeridan,
        };
        int startingYear = 2019;
        
        for(JComboBox n : yearDropDowns){
            n.removeAllItems();
            n.setFont(myVariables.TEXTFIELD_FONT);
            for(int x=0;x<numberOfYears;x++){
                n.addItem(String.valueOf(startingYear+x));
            }
        }
        for(JComboBox n : yearDropDownsWithAllOption){
            n.removeAllItems();
            n.setFont(myVariables.TEXTFIELD_FONT);
            n.addItem("All");
            for(int x=0;x<numberOfYears;x++){
                n.addItem(String.valueOf(startingYear+x));
            }
        }
        for(JComboBox n : dropDowns){
            n.setFont(myVariables.TEXTFIELD_FONT);
        }
    }
    //</editor-fold>
    
      public void myInitComponents(){
        lbSearchResult.setForeground(new java.awt.Color(0,0,0));
        lbSearchResult.setText("Search using the search bar...");
        
        btnSearchSection.setBackground(new java.awt.Color(251,185,211));
        
        
        jLabel25.setFont(poppins48);
        jLabel24.setFont(poppins19);
        label1.setFont(poppins14);
//        label2.setFont(poppins16);
//        label3.setFont(poppins16);
        
        tab1.setBackground(new java.awt.Color(253,232,240));
//        tab2.setBackground(new java.awt.Color(251,185,211));
//        tab3.setBackground(new java.awt.Color(251,185,211));
        
        
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        selectSectionTab = new javax.swing.JPanel();
        lbSearchResult = new javax.swing.JLabel();
        tfSearchTeacherLoad = new javax.swing.JTextField();
        btnSearchSection = new javax.swing.JButton();
        jcbSchoolYear1 = new javax.swing.JComboBox<>();
        jScrollPane8 = new javax.swing.JScrollPane();
        assignedTeacherTable = new javax.swing.JTable();
        viewStudentsTab = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        left = new javax.swing.JPanel();
        lbSearchResult1 = new javax.swing.JLabel();
        tfSearchEnrolledStudent = new javax.swing.JTextField();
        btnSearchEnrolledStudent = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        enrolledStudentsTable = new javax.swing.JTable();
        right = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jdcDate = new com.toedter.calendar.JDateChooser();
        btnSearchDate = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        attendanceTable = new javax.swing.JTable();
        btnEditAttendance = new javax.swing.JButton();
        btnRecheckAttendance = new javax.swing.JButton();
        btnCheckAttendance = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lbAttendanceCount = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tfSf1RemarksDisplay = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        tfSf2RemarksDisplay = new javax.swing.JTextField();
        btnEditRemarks = new javax.swing.JButton();
        btnSaveRemarks = new javax.swing.JButton();
        jScrollPane13 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        gradesTable = new javax.swing.JTable();
        btnLoadGrades = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        tfGeneralAverage = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lbFinalGradeId = new javax.swing.JLabel();
        rbPromoted = new javax.swing.JRadioButton();
        rbRetained = new javax.swing.JRadioButton();
        rbConditional = new javax.swing.JRadioButton();
        rbIncomplete = new javax.swing.JRadioButton();
        btnSaveEvaluation = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        tfFailedSubjects = new javax.swing.JTextField();
        checkAttendanceTab = new javax.swing.JPanel();
        jSplitPane2 = new javax.swing.JSplitPane();
        left1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        checkAttendanceTable = new javax.swing.JTable();
        right1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        rbToday = new javax.swing.JRadioButton();
        rbCustomDate = new javax.swing.JRadioButton();
        jdcCustomDate = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jsHours = new javax.swing.JSpinner();
        jsMinutes = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        jcbMeridan = new javax.swing.JComboBox<>();
        btnFinishAttendance = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        setDateGroup = new javax.swing.ButtonGroup();
        setStatusGroup = new javax.swing.ButtonGroup();
        setRemarksGroup = new javax.swing.ButtonGroup();
        testDialog = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        editAttendanceDialog = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbAttendanceID = new javax.swing.JLabel();
        btnSaveChangesToAttendance = new javax.swing.JButton();
        lbDateAdded = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        rbPresent = new javax.swing.JRadioButton();
        rbAbsent = new javax.swing.JRadioButton();
        rbTardy = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtaNotes = new javax.swing.JTextArea();
        addNotesDialog = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jtaLeaveNotes = new javax.swing.JTextArea();
        btnSaveNotes = new javax.swing.JButton();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        recheckAttendanceDialog = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        recheckAttendanceTable = new javax.swing.JTable();
        lbDateToRecheck = new javax.swing.JLabel();
        btnSaveRecheckAttendanceChanges = new javax.swing.JButton();
        setSf1Sf2RemarkDialog = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        tfSf1Remarks = new javax.swing.JTextField();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        tfSf2Remarks = new javax.swing.JTextField();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        btnSetRemarks = new javax.swing.JButton();
        loadingDialog = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jpbProgressBar = new javax.swing.JProgressBar();
        lbLoadingMessage = new javax.swing.JLabel();
        btnCancelLoading = new javax.swing.JButton();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        headerPanel = new javax.swing.JPanel();
        lbLoggedInUser = new javax.swing.JLabel();
        lbLoggedInUser1 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        tab1 = new javax.swing.JPanel();
        label1 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        mainTab = new javax.swing.JTabbedPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu = new javax.swing.JMenu();
        logout = new javax.swing.JMenuItem();

        selectSectionTab.setBackground(new java.awt.Color(203, 184, 160));

        lbSearchResult.setBackground(new java.awt.Color(58, 57, 57));
        lbSearchResult.setForeground(new java.awt.Color(58, 57, 57));
        lbSearchResult.setText("Search using the search bar...");

        tfSearchTeacherLoad.setPreferredSize(new java.awt.Dimension(15, 20));
        tfSearchTeacherLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchManagedSections(evt);
            }
        });

        btnSearchSection.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search_24px.png"))); // NOI18N
        btnSearchSection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchManagedSections(evt);
            }
        });

        jcbSchoolYear1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2019", "2020" }));

        assignedTeacherTable.setBackground(new java.awt.Color(249, 249, 249));
        assignedTeacherTable.setForeground(new java.awt.Color(58, 57, 57));
        assignedTeacherTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Section ID", "Section Name", "Adv ID", "Name", "Gender", "Subject ID", "Code", "Description", "Grade", "School Year", "Load ID", "Load Name", "Subjects Contained"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        assignedTeacherTable.getTableHeader().setReorderingAllowed(false);
        assignedTeacherTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                assignedTeacherTableMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(assignedTeacherTable);

        javax.swing.GroupLayout selectSectionTabLayout = new javax.swing.GroupLayout(selectSectionTab);
        selectSectionTab.setLayout(selectSectionTabLayout);
        selectSectionTabLayout.setHorizontalGroup(
            selectSectionTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(selectSectionTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(selectSectionTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE)
                    .addGroup(selectSectionTabLayout.createSequentialGroup()
                        .addComponent(lbSearchResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbSchoolYear1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfSearchTeacherLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearchSection)))
                .addContainerGap())
        );
        selectSectionTabLayout.setVerticalGroup(
            selectSectionTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(selectSectionTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(selectSectionTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfSearchTeacherLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbSchoolYear1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(selectSectionTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbSearchResult)
                        .addComponent(btnSearchSection)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8)
                .addContainerGap())
        );

        viewStudentsTab.setMinimumSize(new java.awt.Dimension(948, 533));

        jSplitPane1.setBorder(null);
        jSplitPane1.setDividerLocation(600);
        jSplitPane1.setMinimumSize(new java.awt.Dimension(948, 533));
        jSplitPane1.setPreferredSize(new java.awt.Dimension(948, 533));

        left.setBackground(new java.awt.Color(203, 184, 160));
        left.setMinimumSize(new java.awt.Dimension(387, 533));

        lbSearchResult1.setForeground(new java.awt.Color(255, 255, 255));
        lbSearchResult1.setText("Search using the search bar...");

        tfSearchEnrolledStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchEnrolledStudentsHandler(evt);
            }
        });

        btnSearchEnrolledStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search_24px.png"))); // NOI18N
        btnSearchEnrolledStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchEnrolledStudentsHandler(evt);
            }
        });

        enrolledStudentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Student ID", "LRN", "Name", "Gender", "Section ID", "Remarks"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        enrolledStudentsTable.getTableHeader().setReorderingAllowed(false);
        enrolledStudentsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loadStudentsAttendanceHandler(evt);
            }
        });
        jScrollPane1.setViewportView(enrolledStudentsTable);

        javax.swing.GroupLayout leftLayout = new javax.swing.GroupLayout(left);
        left.setLayout(leftLayout);
        leftLayout.setHorizontalGroup(
            leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(leftLayout.createSequentialGroup()
                        .addComponent(lbSearchResult1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfSearchEnrolledStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearchEnrolledStudent)))
                .addContainerGap())
        );
        leftLayout.setVerticalGroup(
            leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbSearchResult1)
                        .addComponent(btnSearchEnrolledStudent))
                    .addComponent(tfSearchEnrolledStudent, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane1.setLeftComponent(left);

        right.setMinimumSize(new java.awt.Dimension(343, 533));

        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel1.setBackground(new java.awt.Color(249, 239, 227));

        jPanel7.setBackground(new java.awt.Color(203, 184, 160));

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("View Student Details");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel35)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel35)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Search Date");

        jdcDate.setToolTipText("Specific date to find");
        jdcDate.setDateFormatString("yyyy-MM-dd");

        btnSearchDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search_24px.png"))); // NOI18N
        btnSearchDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchSpecificAttendanceHandler(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Attendance Details");

        attendanceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Student ID", "Section ID", "Subject ID", "Status", "Date", "Notes"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        attendanceTable.getTableHeader().setReorderingAllowed(false);
        attendanceTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                attendanceTableMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(attendanceTable);

        btnEditAttendance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage3/icons/icons8_edit_16px.png"))); // NOI18N
        btnEditAttendance.setText("Edit Selected Attendance");
        btnEditAttendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditAttendanceActionPerformed(evt);
            }
        });

        btnRecheckAttendance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage3/icons/icons8_rollback_16px.png"))); // NOI18N
        btnRecheckAttendance.setText("Re-check Attendances");
        btnRecheckAttendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecheckAttendanceActionPerformed(evt);
            }
        });

        btnCheckAttendance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage3/icons/icons8_report_card_16px.png"))); // NOI18N
        btnCheckAttendance.setText("Check Attendance Now");
        btnCheckAttendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkAttendanceNowHamdler(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Attendance Options");

        lbAttendanceCount.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbAttendanceCount.setText("Present: 0  Absent: 0  Tardy: 0   Total: 0");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Remarks");

        jLabel12.setText("For SF1");

        tfSf1RemarksDisplay.setEditable(false);

        jLabel13.setText("For SF2");

        tfSf2RemarksDisplay.setEditable(false);

        btnEditRemarks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage3/icons/icons8_edit_16px.png"))); // NOI18N
        btnEditRemarks.setText("Edit");
        btnEditRemarks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditRemarksActionPerformed(evt);
            }
        });

        btnSaveRemarks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage3/icons/icons8_save_16px.png"))); // NOI18N
        btnSaveRemarks.setText("Save Remarks");
        btnSaveRemarks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveRemarksActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jdcDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearchDate))
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnEditAttendance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRecheckAttendance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCheckAttendance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbAttendanceCount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfSf1RemarksDisplay)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfSf2RemarksDisplay)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditRemarks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSaveRemarks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSearchDate)
                    .addComponent(jdcDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbAttendanceCount)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditAttendance)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRecheckAttendance)
                .addGap(18, 18, 18)
                .addComponent(btnCheckAttendance)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfSf1RemarksDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfSf2RemarksDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditRemarks)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSaveRemarks)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel1);

        jTabbedPane1.addTab("Student Details", jScrollPane2);

        jScrollPane13.setBorder(null);
        jScrollPane13.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane13.setRequestFocusEnabled(false);

        jPanel3.setBackground(new java.awt.Color(249, 239, 227));

        jPanel13.setBackground(new java.awt.Color(203, 184, 160));

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("View Student's Grades");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel41)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel41)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Grade Details");

        gradesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Grade ID", "Section ID", "Student ID", "Teacher ID", "Subject Teacher", "Gender", "Subject ID", "Code", "Description", "Grade Level", "GWA", "Status", "Date Updated"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        gradesTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        gradesTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane14.setViewportView(gradesTable);
        if (gradesTable.getColumnModel().getColumnCount() > 0) {
            gradesTable.getColumnModel().getColumn(4).setPreferredWidth(200);
            gradesTable.getColumnModel().getColumn(5).setResizable(false);
            gradesTable.getColumnModel().getColumn(5).setPreferredWidth(60);
            gradesTable.getColumnModel().getColumn(6).setResizable(false);
            gradesTable.getColumnModel().getColumn(7).setResizable(false);
            gradesTable.getColumnModel().getColumn(7).setPreferredWidth(80);
            gradesTable.getColumnModel().getColumn(8).setPreferredWidth(200);
            gradesTable.getColumnModel().getColumn(9).setResizable(false);
            gradesTable.getColumnModel().getColumn(10).setResizable(false);
            gradesTable.getColumnModel().getColumn(10).setPreferredWidth(50);
            gradesTable.getColumnModel().getColumn(11).setResizable(false);
            gradesTable.getColumnModel().getColumn(11).setPreferredWidth(80);
            gradesTable.getColumnModel().getColumn(12).setResizable(false);
            gradesTable.getColumnModel().getColumn(12).setPreferredWidth(150);
        }

        btnLoadGrades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage3/icons/icons8_sync_16px.png"))); // NOI18N
        btnLoadGrades.setText("Load Grades");
        btnLoadGrades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadGradesActionPerformed(evt);
            }
        });

        jLabel17.setText("General Average");

        tfGeneralAverage.setEditable(false);
        tfGeneralAverage.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel18.setText("Remarks");

        jLabel19.setText("Record ID:");

        lbFinalGradeId.setText("0");

        setRemarksGroup.add(rbPromoted);
        rbPromoted.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        rbPromoted.setText("Promoted");
        rbPromoted.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage3/icons/icons8_round_20px.png"))); // NOI18N
        rbPromoted.setOpaque(false);
        rbPromoted.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage3/icons/icons8_ok_20px.png"))); // NOI18N

        setRemarksGroup.add(rbRetained);
        rbRetained.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        rbRetained.setText("Retained");
        rbRetained.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage3/icons/icons8_round_20px.png"))); // NOI18N
        rbRetained.setOpaque(false);
        rbRetained.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage3/icons/icons8_ok_20px.png"))); // NOI18N

        setRemarksGroup.add(rbConditional);
        rbConditional.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        rbConditional.setText("Conditional");
        rbConditional.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage3/icons/icons8_round_20px.png"))); // NOI18N
        rbConditional.setOpaque(false);
        rbConditional.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage3/icons/icons8_ok_20px.png"))); // NOI18N

        setRemarksGroup.add(rbIncomplete);
        rbIncomplete.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        rbIncomplete.setSelected(true);
        rbIncomplete.setText("Incomplete");
        rbIncomplete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage3/icons/icons8_round_20px.png"))); // NOI18N
        rbIncomplete.setOpaque(false);
        rbIncomplete.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage3/icons/icons8_ok_20px.png"))); // NOI18N

        btnSaveEvaluation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage3/icons/icons8_save_16px.png"))); // NOI18N
        btnSaveEvaluation.setText("Save Evaluation");
        btnSaveEvaluation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveEvaluationActionPerformed(evt);
            }
        });

        jLabel20.setText("Did Not Meet Expectations On");

        tfFailedSubjects.setEditable(false);
        tfFailedSubjects.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(btnSaveEvaluation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbFinalGradeId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLoadGrades))
                            .addComponent(tfFailedSubjects, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rbPromoted, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rbConditional, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rbRetained, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addComponent(rbIncomplete, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(tfGeneralAverage, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel19)
                        .addComponent(lbFinalGradeId))
                    .addComponent(btnLoadGrades))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfGeneralAverage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfFailedSubjects, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbPromoted)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbConditional)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbRetained)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbIncomplete)
                .addGap(18, 18, 18)
                .addComponent(btnSaveEvaluation)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane13.setViewportView(jPanel3);

        jTabbedPane1.addTab("Grade Details", jScrollPane13);

        javax.swing.GroupLayout rightLayout = new javax.swing.GroupLayout(right);
        right.setLayout(rightLayout);
        rightLayout.setHorizontalGroup(
            rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
        );
        rightLayout.setVerticalGroup(
            rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
        );

        jSplitPane1.setRightComponent(right);

        javax.swing.GroupLayout viewStudentsTabLayout = new javax.swing.GroupLayout(viewStudentsTab);
        viewStudentsTab.setLayout(viewStudentsTabLayout);
        viewStudentsTabLayout.setHorizontalGroup(
            viewStudentsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        viewStudentsTabLayout.setVerticalGroup(
            viewStudentsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jSplitPane2.setBorder(null);
        jSplitPane2.setDividerLocation(650);

        left1.setBackground(new java.awt.Color(203, 184, 160));

        checkAttendanceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Student ID", "LRN", "Name", "Gender", "Section ID", "Remarks", "Present", "Absent", "Tardy", "Notes"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        checkAttendanceTable.getTableHeader().setReorderingAllowed(false);
        checkAttendanceTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkAttendanceTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(checkAttendanceTable);
        if (checkAttendanceTable.getColumnModel().getColumnCount() > 0) {
            checkAttendanceTable.getColumnModel().getColumn(2).setPreferredWidth(100);
            checkAttendanceTable.getColumnModel().getColumn(2).setMaxWidth(100);
            checkAttendanceTable.getColumnModel().getColumn(4).setMaxWidth(60);
            checkAttendanceTable.getColumnModel().getColumn(7).setPreferredWidth(60);
            checkAttendanceTable.getColumnModel().getColumn(7).setMaxWidth(60);
            checkAttendanceTable.getColumnModel().getColumn(8).setPreferredWidth(60);
            checkAttendanceTable.getColumnModel().getColumn(8).setMaxWidth(60);
            checkAttendanceTable.getColumnModel().getColumn(9).setPreferredWidth(60);
            checkAttendanceTable.getColumnModel().getColumn(9).setMaxWidth(60);
            checkAttendanceTable.getColumnModel().getColumn(10).setPreferredWidth(50);
            checkAttendanceTable.getColumnModel().getColumn(10).setMaxWidth(50);
        }

        javax.swing.GroupLayout left1Layout = new javax.swing.GroupLayout(left1);
        left1.setLayout(left1Layout);
        left1Layout.setHorizontalGroup(
            left1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(left1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
                .addContainerGap())
        );
        left1Layout.setVerticalGroup(
            left1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(left1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane2.setLeftComponent(left1);

        jScrollPane4.setBorder(null);
        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel2.setBackground(new java.awt.Color(249, 239, 227));

        jPanel8.setBackground(new java.awt.Color(203, 184, 160));

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Attendance Options");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel36)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel36)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Set Date");

        setDateGroup.add(rbToday);
        rbToday.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        rbToday.setText("Today");
        rbToday.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage3/icons/icons8_unchecked_checkbox_20px.png"))); // NOI18N
        rbToday.setOpaque(false);
        rbToday.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage3/icons/icons8_tick_box_20px.png"))); // NOI18N
        rbToday.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage3/icons/icons8_checked_checkbox_20px.png"))); // NOI18N
        rbToday.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkAttendanceTypeHandler(evt);
            }
        });

        setDateGroup.add(rbCustomDate);
        rbCustomDate.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        rbCustomDate.setText("Custom");
        rbCustomDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage3/icons/icons8_unchecked_checkbox_20px.png"))); // NOI18N
        rbCustomDate.setOpaque(false);
        rbCustomDate.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage3/icons/icons8_tick_box_20px.png"))); // NOI18N
        rbCustomDate.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage3/icons/icons8_checked_checkbox_20px.png"))); // NOI18N
        rbCustomDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkAttendanceTypeHandler(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Date and Time");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText(":");

        jcbMeridan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AM", "PM" }));

        btnFinishAttendance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage3/icons/icons8_save_16px.png"))); // NOI18N
        btnFinishAttendance.setText("Save Attendance");
        btnFinishAttendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAttendanceHandler(evt);
            }
        });

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Finalize Attendance");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 60, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbCustomDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbToday, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnFinishAttendance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jsHours, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jsMinutes, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jcbMeridan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jdcCustomDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbToday)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbCustomDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdcCustomDate, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jsHours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jsMinutes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbMeridan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFinishAttendance)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane4.setViewportView(jPanel2);

        javax.swing.GroupLayout right1Layout = new javax.swing.GroupLayout(right1);
        right1.setLayout(right1Layout);
        right1Layout.setHorizontalGroup(
            right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4)
        );
        right1Layout.setVerticalGroup(
            right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4)
        );

        jSplitPane2.setRightComponent(right1);

        javax.swing.GroupLayout checkAttendanceTabLayout = new javax.swing.GroupLayout(checkAttendanceTab);
        checkAttendanceTab.setLayout(checkAttendanceTabLayout);
        checkAttendanceTabLayout.setHorizontalGroup(
            checkAttendanceTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2)
        );
        checkAttendanceTabLayout.setVerticalGroup(
            checkAttendanceTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2)
        );

        testDialog.setBackground(new java.awt.Color(153, 255, 255));
        testDialog.setInheritsPopupMenu(true);

        jButton2.setText("Yeah");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout testDialogLayout = new javax.swing.GroupLayout(testDialog);
        testDialog.setLayout(testDialogLayout);
        testDialogLayout.setHorizontalGroup(
            testDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(testDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        testDialogLayout.setVerticalGroup(
            testDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, testDialogLayout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(32, 32, 32))
        );

        editAttendanceDialog.setBackground(new java.awt.Color(249, 239, 227));

        jPanel9.setBackground(new java.awt.Color(203, 184, 160));

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Edit Attendance");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel37)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel37)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setText("Record ID: ");

        lbAttendanceID.setText("ATTENDANCE_ID");

        btnSaveChangesToAttendance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage3/icons/icons8_ok_16px.png"))); // NOI18N
        btnSaveChangesToAttendance.setText("Save Changes");
        btnSaveChangesToAttendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveChangesToAttendanceActionPerformed(evt);
            }
        });

        lbDateAdded.setText("Date: DATE_ADDED");

        jLabel10.setText("Status");

        setStatusGroup.add(rbPresent);
        rbPresent.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        rbPresent.setText("Present");
        rbPresent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage3/icons/icons8_round_20px.png"))); // NOI18N
        rbPresent.setIconTextGap(5);
        rbPresent.setOpaque(false);
        rbPresent.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage3/icons/icons8_ok_20px.png"))); // NOI18N

        setStatusGroup.add(rbAbsent);
        rbAbsent.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        rbAbsent.setText("Absent");
        rbAbsent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage3/icons/icons8_round_20px.png"))); // NOI18N
        rbAbsent.setIconTextGap(5);
        rbAbsent.setOpaque(false);
        rbAbsent.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage3/icons/icons8_ok_20px.png"))); // NOI18N

        setStatusGroup.add(rbTardy);
        rbTardy.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        rbTardy.setText("Tardy");
        rbTardy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage3/icons/icons8_round_20px.png"))); // NOI18N
        rbTardy.setIconTextGap(5);
        rbTardy.setOpaque(false);
        rbTardy.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage3/icons/icons8_ok_20px.png"))); // NOI18N

        jLabel11.setText("Notes (Optional)");

        jtaNotes.setColumns(20);
        jtaNotes.setFont(myVariables.TEXTFIELD_FONT);
        jtaNotes.setLineWrap(true);
        jtaNotes.setRows(5);
        jtaNotes.setText("asda asd asd asd asd asd asd asd asd asd asd asd asdas dasdasd asd asd asdasda ad asd asd asdasdasdas a asd");
        jtaNotes.setWrapStyleWord(true);
        jScrollPane5.setViewportView(jtaNotes);

        javax.swing.GroupLayout editAttendanceDialogLayout = new javax.swing.GroupLayout(editAttendanceDialog);
        editAttendanceDialog.setLayout(editAttendanceDialogLayout);
        editAttendanceDialogLayout.setHorizontalGroup(
            editAttendanceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editAttendanceDialogLayout.createSequentialGroup()
                .addGroup(editAttendanceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editAttendanceDialogLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSaveChangesToAttendance))
                    .addGroup(editAttendanceDialogLayout.createSequentialGroup()
                        .addGroup(editAttendanceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(editAttendanceDialogLayout.createSequentialGroup()
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbAttendanceID))
                            .addGroup(editAttendanceDialogLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(editAttendanceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbDateAdded)
                                    .addComponent(jLabel10)
                                    .addGroup(editAttendanceDialogLayout.createSequentialGroup()
                                        .addComponent(rbPresent, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(rbAbsent, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(rbTardy, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel11))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editAttendanceDialogLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5)))
                .addContainerGap())
        );
        editAttendanceDialogLayout.setVerticalGroup(
            editAttendanceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editAttendanceDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editAttendanceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(editAttendanceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(lbAttendanceID)))
                .addGap(18, 18, 18)
                .addComponent(lbDateAdded)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editAttendanceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbPresent)
                    .addComponent(rbAbsent)
                    .addComponent(rbTardy))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSaveChangesToAttendance)
                .addContainerGap())
        );

        addNotesDialog.setBackground(new java.awt.Color(249, 239, 227));
        addNotesDialog.setMinimumSize(new java.awt.Dimension(287, 397));

        jPanel10.setBackground(new java.awt.Color(203, 184, 160));
        jPanel10.setMinimumSize(new java.awt.Dimension(269, 47));
        jPanel10.setName(""); // NOI18N

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Leave a Note for this Student");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel38)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel38)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtaLeaveNotes.setColumns(20);
        jtaLeaveNotes.setFont(myVariables.TEXTFIELD_FONT);
        jtaLeaveNotes.setRows(5);
        jScrollPane6.setViewportView(jtaLeaveNotes);

        btnSaveNotes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage3/icons/icons8_save_16px.png"))); // NOI18N
        btnSaveNotes.setText("Save");
        btnSaveNotes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveNotesActionPerformed(evt);
            }
        });

        jTextArea3.setColumns(20);
        jTextArea3.setFont(myVariables.TEXTFIELD_FONT);
        jTextArea3.setRows(5);
        jTextArea3.setText("Guidelines:\n   If tardy, type CODE:MESSAGE.\n   -LC Late Commer\n   -CC Cutting Classes\n    (e.g. LC:15 minutes late)");
        jScrollPane12.setViewportView(jTextArea3);

        javax.swing.GroupLayout addNotesDialogLayout = new javax.swing.GroupLayout(addNotesDialog);
        addNotesDialog.setLayout(addNotesDialogLayout);
        addNotesDialogLayout.setHorizontalGroup(
            addNotesDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addNotesDialogLayout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(addNotesDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addNotesDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addNotesDialogLayout.createSequentialGroup()
                        .addGap(267, 267, 267)
                        .addComponent(btnSaveNotes, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane12))
                .addContainerGap())
        );
        addNotesDialogLayout.setVerticalGroup(
            addNotesDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addNotesDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnSaveNotes)
                .addContainerGap())
        );

        recheckAttendanceDialog.setBackground(new java.awt.Color(249, 239, 227));

        jPanel11.setBackground(new java.awt.Color(203, 184, 160));

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Re-check Attendance");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel39)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel39)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        recheckAttendanceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Student ID", "LRN", "Name", "Gender", "Section ID", "Remarks", "Present", "Absent", "Tardy", "Notes", "Attendance ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        recheckAttendanceTable.getTableHeader().setReorderingAllowed(false);
        recheckAttendanceTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                recheckAttendanceTableMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(recheckAttendanceTable);
        if (recheckAttendanceTable.getColumnModel().getColumnCount() > 0) {
            recheckAttendanceTable.getColumnModel().getColumn(2).setPreferredWidth(100);
            recheckAttendanceTable.getColumnModel().getColumn(2).setMaxWidth(100);
            recheckAttendanceTable.getColumnModel().getColumn(4).setMaxWidth(60);
            recheckAttendanceTable.getColumnModel().getColumn(7).setPreferredWidth(60);
            recheckAttendanceTable.getColumnModel().getColumn(7).setMaxWidth(60);
            recheckAttendanceTable.getColumnModel().getColumn(8).setPreferredWidth(60);
            recheckAttendanceTable.getColumnModel().getColumn(8).setMaxWidth(60);
            recheckAttendanceTable.getColumnModel().getColumn(9).setPreferredWidth(60);
            recheckAttendanceTable.getColumnModel().getColumn(9).setMaxWidth(60);
            recheckAttendanceTable.getColumnModel().getColumn(10).setPreferredWidth(50);
            recheckAttendanceTable.getColumnModel().getColumn(10).setMaxWidth(50);
        }

        lbDateToRecheck.setText("Selected Date to Change: DATE_SELECTED");

        btnSaveRecheckAttendanceChanges.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage3/icons/icons8_save_16px.png"))); // NOI18N
        btnSaveRecheckAttendanceChanges.setText("Save Changes");
        btnSaveRecheckAttendanceChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveRecheckAttendanceChangesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout recheckAttendanceDialogLayout = new javax.swing.GroupLayout(recheckAttendanceDialog);
        recheckAttendanceDialog.setLayout(recheckAttendanceDialogLayout);
        recheckAttendanceDialogLayout.setHorizontalGroup(
            recheckAttendanceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(recheckAttendanceDialogLayout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(recheckAttendanceDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(recheckAttendanceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                    .addGroup(recheckAttendanceDialogLayout.createSequentialGroup()
                        .addComponent(lbDateToRecheck)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, recheckAttendanceDialogLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSaveRecheckAttendanceChanges)))
                .addContainerGap())
        );
        recheckAttendanceDialogLayout.setVerticalGroup(
            recheckAttendanceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(recheckAttendanceDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbDateToRecheck)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSaveRecheckAttendanceChanges)
                .addContainerGap())
        );

        setSf1Sf2RemarkDialog.setBackground(new java.awt.Color(249, 239, 227));

        jPanel12.setBackground(new java.awt.Color(203, 184, 160));

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Set Remarks");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel40)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel40)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(myVariables.TEXTFIELD_FONT);
        jTextArea1.setRows(5);
        jTextArea1.setText("Guidelines:\nT/O - Transferred Out\nT/I - Transferred In\nDRP - Dropped\nLE - Late Enrollment\nCCT - CCT Receipient\nB/A - Balik Aral\nLWD - Learner With Disability\nACL - Accelerated");
        jScrollPane9.setViewportView(jTextArea1);

        jLabel15.setText("Remarks For SF1");

        jLabel16.setText("Remarks For SF2");

        jScrollPane11.setAutoscrolls(true);

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setFont(myVariables.TEXTFIELD_FONT);
        jTextArea2.setRows(5);
        jTextArea2.setText("Guidelines:\n1. Transferred Out With Name of School\n2. Transferred In With Name of School\n3. Dropped Out\n    Reasons For Dropping Out\n\n     a. Domestic-Related\n\n     a.1. Had to take care of siblings\n     a.2. Early marriage/pregnancy\n     a.3. Parent's attitude towards schooling\n     a.4. Family Problems\n\n     b. Individual-Related\n\n     b.1. Illness\n     b.2. Overage\n     b.3. Death\n     b.4. Drug Abuse\n     b.5. Poor Academic Performance\n     b.6. Lack of Interest/Distracktions\n     b.7. Hunger/Malnutrition\n\n     c. School Related\n\n     c.1. Teacher Factor\n     c.2. Physical condition of classroom\n     c.3. Peer Influence\n\n     d. Geographic/Environmental\n\n     d.1. Distance between home and school\n     d.2. Armed Conflict\n     d.3. Calamities/Disasters\n\n     e. Financial Related\n\n     e.1. Child labor, work\n\n     f. Others");
        jScrollPane11.setViewportView(jTextArea2);

        btnSetRemarks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage3/icons/icons8_ok_16px.png"))); // NOI18N
        btnSetRemarks.setText("Okay");
        btnSetRemarks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetRemarksActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout setSf1Sf2RemarkDialogLayout = new javax.swing.GroupLayout(setSf1Sf2RemarkDialog);
        setSf1Sf2RemarkDialog.setLayout(setSf1Sf2RemarkDialogLayout);
        setSf1Sf2RemarkDialogLayout.setHorizontalGroup(
            setSf1Sf2RemarkDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(setSf1Sf2RemarkDialogLayout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(setSf1Sf2RemarkDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(setSf1Sf2RemarkDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfSf1Remarks)
                    .addComponent(jScrollPane9)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfSf2Remarks)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSetRemarks, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        setSf1Sf2RemarkDialogLayout.setVerticalGroup(
            setSf1Sf2RemarkDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(setSf1Sf2RemarkDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfSf1Remarks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfSf2Remarks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSetRemarks)
                .addContainerGap())
        );

        loadingDialog.setBackground(new java.awt.Color(249, 239, 227));

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage3/icons/Double Ring 100px.gif"))); // NOI18N

        jpbProgressBar.setValue(50);

        lbLoadingMessage.setText("Loading");

        btnCancelLoading.setText("Cancel");
        btnCancelLoading.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelLoadingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout loadingDialogLayout = new javax.swing.GroupLayout(loadingDialog);
        loadingDialog.setLayout(loadingDialogLayout);
        loadingDialogLayout.setHorizontalGroup(
            loadingDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loadingDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(loadingDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpbProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                    .addComponent(lbLoadingMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelLoading, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        loadingDialogLayout.setVerticalGroup(
            loadingDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loadingDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpbProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbLoadingMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelLoading)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Dashboard");
        setIconImage(my.getImgIcn(myVariables.getAttendanceWindowIcon()).getImage()
        );
        setMinimumSize(new java.awt.Dimension(1303, 782));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                logoutHandler(evt);
            }
        });

        kGradientPanel1.setkEndColor(new java.awt.Color(249, 239, 227));
        kGradientPanel1.setkStartColor(new java.awt.Color(249, 239, 227));
        kGradientPanel1.setMinimumSize(new java.awt.Dimension(1003, 600));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(1003, 600));

        headerPanel.setBackground(new java.awt.Color(251, 185, 211));
        headerPanel.setPreferredSize(new java.awt.Dimension(270, 723));

        lbLoggedInUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbLoggedInUser.setForeground(new java.awt.Color(58, 57, 57));
        lbLoggedInUser.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbLoggedInUser.setText("USER_NAME");

        lbLoggedInUser1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbLoggedInUser1.setForeground(new java.awt.Color(58, 57, 57));
        lbLoggedInUser1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbLoggedInUser1.setText("ACCESS_LEVEL");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(58, 57, 57));
        jLabel22.setText("Welcome!");

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cbshs.png"))); // NOI18N

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(58, 57, 57));
        jLabel25.setText("SHS");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(58, 57, 57));
        jLabel24.setText("ATTENDANCE SYSTEM");

        tab1.setBackground(new java.awt.Color(253, 232, 240));

        label1.setForeground(new java.awt.Color(58, 57, 57));
        label1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/attendance2.png"))); // NOI18N
        label1.setText("Manage Attendance");

        javax.swing.GroupLayout tab1Layout = new javax.swing.GroupLayout(tab1);
        tab1.setLayout(tab1Layout);
        tab1Layout.setHorizontalGroup(
            tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(label1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tab1Layout.setVerticalGroup(
            tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tab1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerPanelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel24))
                    .addGroup(headerPanelLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(headerPanelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel25))
                            .addComponent(jLabel23)))
                    .addGroup(headerPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLoggedInUser1)
                            .addComponent(jLabel22)
                            .addComponent(lbLoggedInUser))))
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(headerPanelLayout.createSequentialGroup()
                    .addGap(90, 90, 90)
                    .addComponent(jLabel119)
                    .addContainerGap(91, Short.MAX_VALUE)))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel25)
                .addGap(1, 1, 1)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tab1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbLoggedInUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbLoggedInUser1)
                .addGap(24, 24, 24))
            .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(headerPanelLayout.createSequentialGroup()
                    .addGap(311, 311, 311)
                    .addComponent(jLabel119)
                    .addContainerGap(312, Short.MAX_VALUE)))
        );

        mainTab.setBackground(new java.awt.Color(203, 184, 160));
        mainTab.setToolTipText("");
        mainTab.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        mainTab.setMinimumSize(new java.awt.Dimension(100, 100));
        mainTab.setPreferredSize(new java.awt.Dimension(1068, 548));

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(mainTab, javax.swing.GroupLayout.DEFAULT_SIZE, 995, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(mainTab, javax.swing.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );

        jMenuBar1.setToolTipText("");
        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage3/icons/icons8_user_20px.png"))); // NOI18N
        menu.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);

        logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage3/icons/logout_rounded_up_24px.png"))); // NOI18N
        logout.setText("Log out");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        menu.add(logout);

        jMenuBar1.add(menu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1303, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

  
    
    private void logoutHandler(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_logoutHandler
//        tr.cancel(true);
        my.openWindow(this, new login());
    }//GEN-LAST:event_logoutHandler

    
    
    private void assignedTeacherTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_assignedTeacherTableMouseClicked
        if(evt.getClickCount() == 2){
            if(mainTab.getTabCount() <= 1){
                mainTab.addTab("View Students", my.getImgIcn(myVariables.getViewStudentsIcon()), viewStudentsTab);
                mainTab.setSelectedIndex(1);
            }
            enableDisableRemarks(false, false, false);
            resetViewStudentsTab(true, true, false);
            calculateAttendanceCount(lbAttendanceCount, attendanceTable);
        }else{
            my.remove_multiple_tabs(mainTab, new int [] {1,2});
        }
    }//GEN-LAST:event_assignedTeacherTableMouseClicked

    private void searchManagedSections(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchManagedSections
        String toSearch = tfSearchTeacherLoad.getText();
        String schoolYear = jcbSchoolYear1.getSelectedItem().toString();
        
        my.remove_multiple_tabs(mainTab, new int [] {1,2});
        
        String where = "WHERE subjectCode LIKE '_%' AND gradeLevel > 10";
        
        if(myVariables.getAccessLevel() < 5){
            if(myVariables.getAccessLevel() == 4){
                where += " AND teacherId!='-1'";
            }else{
                where += " AND teacherId='"+myVariables.getUserLoggedInId()+"'";
            }
        }
        
        if(jcbSchoolYear1.getSelectedIndex() != 0){
            where +=" AND schoolYear='"+schoolYear+"'";
        }
        
        if(toSearch.length() > 0){
           where +=" AND sectionName LIKE '%"+toSearch+"%' OR user_Lname LIKE '%"+toSearch+"%' OR user_Fname LIKE '%"+toSearch+"%' AND schoolYear='"+schoolYear+"'";
//          where +=" AND sectionName='"+toSearch+"'";
        }
        
        String [] result = my.return_values("*", "v_managedsubjects_wsubjectscontained", where, myVariables.getManagedSubjectsWSubjectsContainedViewOrder());
        
        my.clear_table_rows(assignedTeacherTable);
        if(result == null){
            lbSearchResult.setText("Showing 0 results for '"+toSearch+"'.");
            return;
        }else{
            if(result.length > 1){
                lbSearchResult.setText("Showing "+result.length+" results for '"+toSearch+"'.");
            }else{
                lbSearchResult.setText("Showing "+result.length+" result for '"+toSearch+"'.");
            }
        }
        
        for(String row : result){
            row = my.toNameFormat(row, new int [] {4,5,6});
            
            //System.err.println(my.getValueAtColumn(row, 3));
            if(my.getValueAtColumn(row, 3).contains("-1")){
                row = my.setValueAtColumn(row, 4, "None");
            }
            my.add_table_row(row, assignedTeacherTable);
        }
    }//GEN-LAST:event_searchManagedSections

    private void searchEnrolledStudentsHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchEnrolledStudentsHandler
        int row = assignedTeacherTable.getSelectedRow();
        
        if(row == -1){
            my.showMessage("Please select a section first.", JOptionPane.WARNING_MESSAGE);
            return;
        }
        resetViewStudentsTab(false, true, false);
        enableDisableRemarks(false, false, false);
        
        String sectionId = assignedTeacherTable.getValueAt(row, 1).toString();
        String toSearch = tfSearchEnrolledStudent.getText();
        
        String where = "WHERE sectionId='"+sectionId+"' AND (lrn='"+toSearch+"' OR lName LIKE '%"+toSearch+"%')";
        my.searchItem(where, enrolledStudentsTable, 6, null, new int [] {3,4,5}, true, true, lbSearchResult1, tfSearchEnrolledStudent, true);
    }//GEN-LAST:event_searchEnrolledStudentsHandler

    private void attendanceTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_attendanceTableMouseClicked
        if(evt.getClickCount() == 1){
            resetViewStudentsTab(false, false, true);
        }
        if(evt.getClickCount() == 2){
            int row = attendanceTable.getSelectedRow();
            
            String status = attendanceTable.getValueAt(row, 4).toString();
            String date = attendanceTable.getValueAt(row, 5).toString();
            String notes = attendanceTable.getValueAt(row, 6).toString();
            
            
            my.showMessage("Attendance Details\n\nStatus : "+status+"\nDate : "+my.numberToWordDate(date)+"\nNotes : "+notes, JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_attendanceTableMouseClicked

    private void saveAttendanceHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAttendanceHandler
        //Get Values
        int row = assignedTeacherTable.getSelectedRow();
        
        String sectionId = assignedTeacherTable.getValueAt(row, 1).toString();
        String subjectId = assignedTeacherTable.getValueAt(row, 6).toString();
        String dateSelected = "";
        String time = "";
        
        if(rbToday.isSelected()){
            dateSelected = my.getDateNow(false);
        }
        if(rbCustomDate.isSelected()){
            if(jdcCustomDate.getDate() == null){
                my.showMessage("Please select a date.", JOptionPane.WARNING_MESSAGE);
                return;
            }
            dateSelected = my.jCalendarToNumberDate(jdcCustomDate.getDate().toString(), false);
            time = jsHours.getValue().toString()+":"+jsMinutes.getValue().toString()+":00 "+jcbMeridan.getSelectedItem().toString();
            
            time = my.from12To24HourFormat(time);
            
            if(time == null){
                System.err.println("Invalid time. Returning");
                return;
            }
        }
        //<editor-fold desc="Get Values">
        int count = checkAttendanceTable.getRowCount();
        String sets [] = new String[count];
        String studentId,status="",notes;
        
        for(int n=0;n<count;n++){
            studentId = checkAttendanceTable.getValueAt(n, 1).toString();
            
            if(checkAttendanceTable.getValueAt(n, 7).toString().contains("O")){
                status = "Present";
            }if(checkAttendanceTable.getValueAt(n, 8).toString().contains("O")){
                status = "Absent";
            }if(checkAttendanceTable.getValueAt(n, 9).toString().contains("O")){
                status = "Tardy";
            }
            notes = my.convertEscapeCharacters(checkAttendanceTable.getValueAt(n, 10).toString());
            
            //id,studentId,sectionId,subjectId,status,dateAdded,notes
            if(rbToday.isSelected()){
                sets[n] = "null,'"+studentId+"','"+sectionId+"','"+subjectId+"','"+status+"',now(),'"+notes+"'";
                System.err.println("Today's Date Selected");
            }if(rbCustomDate.isSelected()){
                System.err.println("Custom Date Selected");
                sets[n] = "null,'"+studentId+"','"+sectionId+"','"+subjectId+"','"+status+"','"+dateSelected+" "+time+"','"+notes+"'";
            }
        }
        
        //</editor-fold>
        String where = "WHERE sectionId='"+sectionId+"' AND subjectId='"+subjectId+"' AND dateAdded LIKE '"+dateSelected+"%'";
        
        if(my.checkForDuplicates("attendance",where,myVariables.getAttendanceOrder())){
            my.showMessage("This section already had an Attendance conducted for this day.\n"
                    + "Please use the 'Re-Check Attendance' feature to overwrite this attendance.",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }else{
            if(my.add_multiple_values("attendance", "id,studentId,sectionId,subjectId,status,dateAdded,notes", sets)){
                playSuccess();
                my.showMessage("Attendance Saved!", JOptionPane.INFORMATION_MESSAGE);
            }else{
                playError();
                my.showMessage("Saving failed. Please make sure you are connected to the School Network.", JOptionPane.ERROR_MESSAGE);
            }
            //No duplicate. Proceed to save attendance
        }
        
        my.remove_multiple_tabs(mainTab, new int [] {2});
    }//GEN-LAST:event_saveAttendanceHandler

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        closeCustomDialog();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void loadStudentsAttendanceHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loadStudentsAttendanceHandler
        if(evt.getClickCount() == 2){
            int row = enrolledStudentsTable.getSelectedRow();
            int subjectRow = assignedTeacherTable.getSelectedRow();
            
            if(row == -1){
                my.showMessage("Please Select a Student", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if(subjectRow == -1){
                my.showMessage("Please Select a Section First", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            String studentId = enrolledStudentsTable.getValueAt(row, 1).toString();
            String sectionId = enrolledStudentsTable.getValueAt(row, 5).toString();
            String subjectId = assignedTeacherTable.getValueAt(subjectRow, 6).toString();
            
            String where = "WHERE studentId='"+studentId+"' AND sectionId='"+sectionId+"' AND subjectId='"+subjectId+"' ORDER BY dateAdded DESC";
            
            my.searchItem(where, attendanceTable, 7, null, null, false, true, null, null, true);
            
            //Load Remarks
            String remarks [] = enrolledStudentsTable.getValueAt(row, 6).toString().split("!");
            tfSf1RemarksDisplay.setText(remarks[0]);
            tfSf2RemarksDisplay.setText(remarks[1]);
            
            enableDisableRemarks(true, true, true);
            calculateAttendanceCount(lbAttendanceCount,attendanceTable);
        }else{
            enableDisableRemarks(false, false, false);
            resetViewStudentsTab(false, true, false);
            calculateAttendanceCount(lbAttendanceCount, attendanceTable);
        }
    }//GEN-LAST:event_loadStudentsAttendanceHandler

    private void checkAttendanceTypeHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkAttendanceTypeHandler
        checkAttendanceType();
    }//GEN-LAST:event_checkAttendanceTypeHandler

    private void checkAttendanceNowHamdler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkAttendanceNowHamdler
        //Load Students
        int row = assignedTeacherTable.getSelectedRow();
        
        if(row == -1){
            my.showMessage("Please select a section first.", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String sectionId = assignedTeacherTable.getValueAt(row, 1).toString();
        String toSearch = tfSearchEnrolledStudent.getText();
        
        String where = "WHERE sectionId='"+sectionId+"'";
        
        String result [] = my.return_values("*", "v_enrollment_minimal_shs", where, myVariables.getEnrollmentViewMinimalOrder());
        
        if(result == null){
            playError();
            my.showMessage("Can't check attendance without students. Please enroll some first.", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        my.clear_table_rows(checkAttendanceTable);
        for(String n : result){
            n = my.toNameFormat(n, new int []{3,4,5});
            n += "O@@ @@ @@ @@";
            
            my.add_table_row(n, checkAttendanceTable);
        }        
        //my.searchItem(where, checkAttendanceTable, 6, null, new int [] {3,4,5}, true, true, lbSearchResult1, tfSearchEnrolledStudent, true);
        
        //Add the tab        
        if(mainTab.getTabCount() <= 2){
            mainTab.addTab("Check Attendance", my.getImgIcn(myVariables.getCheckAttendanceIcon()),checkAttendanceTab);
        }
        mainTab.setSelectedIndex(2);
        
        rbToday.setSelected(true);
        checkAttendanceType();
    }//GEN-LAST:event_checkAttendanceNowHamdler

    private void searchSpecificAttendanceHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchSpecificAttendanceHandler
        int row = enrolledStudentsTable.getSelectedRow();
        int subjectRow = assignedTeacherTable.getSelectedRow();

        if(row == -1){
            my.showMessage("Please Select a Student", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(subjectRow == -1){
            my.showMessage("Please Select a Section First", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(jdcDate.getDate() == null){
            //my.showMessage("Please select a Date to search.", JOptionPane.WARNING_MESSAGE);
            //return;
        }
        
        String date = "";
        String studentId = enrolledStudentsTable.getValueAt(row, 1).toString();
        String sectionId = enrolledStudentsTable.getValueAt(row, 5).toString();
        String subjectId = assignedTeacherTable.getValueAt(subjectRow, 6).toString();
        
        String where = "";
        
        if(jdcDate.getDate() == null){
            where = "WHERE studentId='"+studentId+"' AND sectionId='"+sectionId+
                "' AND subjectId='"+subjectId+"' ORDER BY dateAdded DESC";
            
            System.err.println("No date selected");
        }else{
            date = my.jCalendarToNumberDate(jdcDate.getDate().toString(),false);
            where = "WHERE studentId='"+studentId+"' AND sectionId='"+sectionId+
                "' AND subjectId='"+subjectId+"' AND dateAdded LIKE '"+date+"%' ORDER BY dateAdded DESC";
        }

        my.searchItem(where, attendanceTable, 7, null, null, false, true, null, null, true);
        calculateAttendanceCount(lbAttendanceCount,attendanceTable);
        
        resetViewStudentsTab(false, false, false);
    }//GEN-LAST:event_searchSpecificAttendanceHandler

    private void btnEditAttendanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditAttendanceActionPerformed
        int row = attendanceTable.getSelectedRow();
        
        String id = attendanceTable.getValueAt(row, 0).toString();
        String status = attendanceTable.getValueAt(row, 4).toString();
        String date = attendanceTable.getValueAt(row, 5).toString();
        String notes = attendanceTable.getValueAt(row, 6).toString();
        
        lbAttendanceID.setText(id);
        switch (status){
            case "Present":{
                rbPresent.setSelected(true);
                break;
            }case "Absent":{
                rbAbsent.setSelected(true);
                break;
            }case "Tardy":{
                rbTardy.setSelected(true);
                break;
            }default:{
                rbPresent.setSelected(true);
                break;
            }
        }
        lbDateAdded.setText("Date : "+my.numberToWordDate(date));
        jtaNotes.setText(notes);
        
        showCustomDialog("Edit Selected Attendance",editAttendanceDialog, true, 400, 350, false);
    }//GEN-LAST:event_btnEditAttendanceActionPerformed

    private void btnSaveChangesToAttendanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveChangesToAttendanceActionPerformed
        String id = lbAttendanceID.getText();
        String status = "";
        String notes = jtaNotes.getText().trim().length()>0? jtaNotes.getText().trim() : " ";
        
        if(rbPresent.isSelected())
            status = "Present";
        if(rbAbsent.isSelected())
            status = "Absent";
        if(rbTardy.isSelected())
            status = "Tardy";
        
        String [] sets = {
            "status='"+status+"'",
            "notes='"+my.convertEscapeCharacters(notes)+"'",
        };
        
        if(my.update_values("attendance", sets, "id='"+id+"'")){
            playSuccess();
            my.showMessage("Update Successful.", JOptionPane.INFORMATION_MESSAGE);
            
            jdcDate.setDate(null);
            searchSpecificAttendanceHandler(evt);
            
            closeCustomDialog();
        }else{
            playError();
            my.showMessage("Update failed. Please make sure you are connected to the school network.", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveChangesToAttendanceActionPerformed

    private void btnSaveNotesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveNotesActionPerformed
        String notes = jtaLeaveNotes.getText().trim();
        String title = dialog.getTitle();
        
        if(title.contains("Check Attendance")){
            int row = checkAttendanceTable.getSelectedRow();
        
            if(notes.length() > 1){
                checkAttendanceTable.setValueAt(notes, row, 10);
            }else{
                checkAttendanceTable.setValueAt(" ", row, 10);
            }
            closeCustomDialog();
        }
        if(title.contains("Re-check Attendance")){
            int row = recheckAttendanceTable.getSelectedRow();
        
            if(notes.length() > 1){
                recheckAttendanceTable.setValueAt(notes, row, 10);
            }else{
                recheckAttendanceTable.setValueAt(" ", row, 10);
            }
            closeSecondaryCustomDialog();
        }
    }//GEN-LAST:event_btnSaveNotesActionPerformed

    private void checkAttendanceTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkAttendanceTableMouseClicked
        if(evt.getClickCount() == 1){
            int row = checkAttendanceTable.getSelectedRow();
            int column = checkAttendanceTable.getSelectedColumn();

            //columns 7,8,9 & 10
            switch (column){
                case 7:{
                    checkAttendanceTable.setValueAt("O", row, 7);
                    checkAttendanceTable.setValueAt(" ", row, 8);
                    checkAttendanceTable.setValueAt(" ", row, 9);
                    break;
                }case 8:{
                    checkAttendanceTable.setValueAt(" ", row, 7);
                    checkAttendanceTable.setValueAt("O", row, 8);
                    checkAttendanceTable.setValueAt(" ", row, 9);
                    break;
                }case 9:{
                    checkAttendanceTable.setValueAt(" ", row, 7);
                    checkAttendanceTable.setValueAt(" ", row, 8);
                    checkAttendanceTable.setValueAt("O", row, 9);
                    break;
                }case 10:{
                    String notes = checkAttendanceTable.getValueAt(row, 10).toString();
                    if(notes.length() > 1){
                        jtaLeaveNotes.setText(notes);
                    }else{
                        jtaLeaveNotes.setText("");
                    }
                    showCustomDialog("Write Notes (Check Attendance)", addNotesDialog, true, 400, 300, false);
                    break;
                }
            }
        }
    }//GEN-LAST:event_checkAttendanceTableMouseClicked

    private void recheckAttendanceTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recheckAttendanceTableMouseClicked
        if(evt.getClickCount() == 1){
            int row = recheckAttendanceTable.getSelectedRow();
            int column = recheckAttendanceTable.getSelectedColumn();

            //columns 6,7,8 & 9
            switch (column){
                case 7:{
                    recheckAttendanceTable.setValueAt("O", row, 7);
                    recheckAttendanceTable.setValueAt(" ", row, 8);
                    recheckAttendanceTable.setValueAt(" ", row, 9);
                    break;
                }case 8:{
                    recheckAttendanceTable.setValueAt(" ", row, 7);
                    recheckAttendanceTable.setValueAt("O", row, 8);
                    recheckAttendanceTable.setValueAt(" ", row, 9);
                    break;
                }case 9:{
                    recheckAttendanceTable.setValueAt(" ", row, 7);
                    recheckAttendanceTable.setValueAt(" ", row, 8);
                    recheckAttendanceTable.setValueAt("O", row, 9);
                    break;
                }case 10:{
                    String notes = recheckAttendanceTable.getValueAt(row, 10).toString();
                    if(notes.length() > 1){
                        jtaLeaveNotes.setText(notes);
                    }else{
                        jtaLeaveNotes.setText("");
                    }
                    showSecondaryCustomDialog("Write Notes (Re-check Attendance)", addNotesDialog, true, 400, 300, false);
                    break;
                }
            }
        }
    }//GEN-LAST:event_recheckAttendanceTableMouseClicked

    private void btnSaveRecheckAttendanceChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveRecheckAttendanceChangesActionPerformed
        //Get values
        int subjectRow = assignedTeacherTable.getSelectedRow();
        int attendanceRow = attendanceTable.getSelectedRow();
        
        String sectionId = assignedTeacherTable.getValueAt(subjectRow, 1).toString();
        String subjectId = assignedTeacherTable.getValueAt(subjectRow, 6).toString();
        String dateSelected = attendanceTable.getValueAt(attendanceRow, 5).toString();
        
        //Prepare values
        int count = recheckAttendanceTable.getRowCount();
        String sets [] = new String[count];
        String attendanceId,studentId,status="",notes;
        
        for(int n=0;n<count;n++){
            attendanceId = recheckAttendanceTable.getValueAt(n, 11).toString();
            attendanceId = attendanceId.contains("-1")? "null" : attendanceId;
            
            studentId = recheckAttendanceTable.getValueAt(n, 1).toString();
            
            if(recheckAttendanceTable.getValueAt(n, 7).toString().contains("O")){
                status = "Present";
            }if(recheckAttendanceTable.getValueAt(n, 8).toString().contains("O")){
                status = "Absent";
            }if(recheckAttendanceTable.getValueAt(n, 9).toString().contains("O")){
                status = "Tardy";
            }
            notes = recheckAttendanceTable.getValueAt(n, 10).toString();
            
            //id,studentId,sectionId,subjectId,status,dateAdded,notes
            sets[n] = attendanceId+","+studentId+","+sectionId+","+subjectId+",'"+status+"','"+dateSelected+"','"+notes+"'";
            
        }
        if(my.update_multiple_values("attendance", "id,studentId,sectionId,subjectId,status,dateAdded,notes", "status=VALUES(status),notes=VALUES(notes)", sets)){
            playSuccess();
            my.showMessage("Update Success.", JOptionPane.INFORMATION_MESSAGE);
            closeCustomDialog();
        }else{
            playError();
            my.showMessage("Update Failed. Please make sure you are connected to the School Network.", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //searchEnrolledStudentsHandler(my.getButtonPressedEvent(evt.getSource()));
    }//GEN-LAST:event_btnSaveRecheckAttendanceChangesActionPerformed

    private void btnRecheckAttendanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecheckAttendanceActionPerformed
        //Prompt user
        if(!my.getConfirmation("Re-checking allows you to change the values of the attendance on\n"
                + "the selected date. Continue?")){
            my.showMessage("Re-checking Canceled.", JOptionPane.PLAIN_MESSAGE);
            return;
        }
        //<editor-fold desc="Load Students">
        int row = assignedTeacherTable.getSelectedRow();
        int attendanceRow = attendanceTable.getSelectedRow();
        
        if(row == -1){
            my.showMessage("Please select a section first.", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String sectionId = assignedTeacherTable.getValueAt(row, 1).toString();
        String subjectId = assignedTeacherTable.getValueAt(row, 6).toString();
        
        String dateSelected = attendanceTable.getValueAt(attendanceRow, 5).toString();
        
        String where = "WHERE sectionId='"+sectionId+"'";
        
        String result [] = my.return_values("*", "v_enrollment_minimal_shs", where, myVariables.getEnrollmentViewMinimalOrder());
        
        if(result == null){
            playError();
            my.showMessage("Can't check attendance without students. Please enroll some first.", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        lbDateToRecheck.setText("Selected Date :    "+dateSelected);
        my.clear_table_rows(recheckAttendanceTable);
        
        String studentIds = "";
        for(int n=0;n<result.length;n++){
            result[n] = my.toNameFormat(result[n], new int []{3,4,5});
            result[n] += "O@@ @@ @@ @@-1@@";  //Start off with negative IDs for easier query later in saving
            
            //For loading existing attendances later
            studentIds += my.getValueAtColumn(result[n], 1);
            if(n!=result.length-1){
                studentIds+=",";
            }
            
            my.add_table_row(result[n], recheckAttendanceTable);
        }
        my.remove_multiple_tabs(mainTab, new int [] {2});
        //</editor-fold>
        //<editor-fold desc="Load attendance record for the selected date">
        String [] attendanceResult = my.return_values("*", "attendance", "WHERE studentId IN("+studentIds+") AND sectionId='"+sectionId+"' AND subjectId='"+subjectId+"' AND dateAdded='"+dateSelected+"'", myVariables.getAttendanceOrder());
        
        if(attendanceResult != null){
            int studentCount = recheckAttendanceTable.getRowCount();
            for(int r=0;r<studentCount;r++){
                int currStudId = Integer.parseInt(recheckAttendanceTable.getValueAt(r, 1).toString());
                
                //Search id in attendanceResult
                for(String attendance : attendanceResult){
                    int foundStudId = Integer.valueOf(my.getValueAtColumn(attendance, 1));
                    
                    
                    if(currStudId == foundStudId){
                        System.err.println("Match found.");
                        
                        String status = my.getValueAtColumn(attendance, 4);
                        String notes = my.getValueAtColumn(attendance, 6);
                        String attendanceId = my.getValueAtColumn(attendance, 0);
                        
                        //Set values
                        switch (status){
                            case "Present":{
                                recheckAttendanceTable.setValueAt("O", r, 7);
                                recheckAttendanceTable.setValueAt(" ", r, 8);
                                recheckAttendanceTable.setValueAt(" ", r, 9);
                                break;
                            }case "Absent":{
                                recheckAttendanceTable.setValueAt(" ", r, 7);
                                recheckAttendanceTable.setValueAt("O", r, 8);
                                recheckAttendanceTable.setValueAt(" ", r, 9);
                                break;
                            }case "Tardy":{
                                recheckAttendanceTable.setValueAt(" ", r, 7);
                                recheckAttendanceTable.setValueAt(" ", r, 8);
                                recheckAttendanceTable.setValueAt("O", r, 9);
                                break;
                            }default:
                                break;
                        }
                        recheckAttendanceTable.setValueAt(notes, r, 10);
                        recheckAttendanceTable.setValueAt(attendanceId, r, 11);
                        break;
                    }
                }
            }
            
        }else{
            System.err.println("No attendance found. Skipping");
        }
        //</editor-fold>
        //Show dialog
        showCustomDialog("Re-check Attendance from selected Date", recheckAttendanceDialog, true, 600, 400, true);
    }//GEN-LAST:event_btnRecheckAttendanceActionPerformed

    private void btnSetRemarksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetRemarksActionPerformed
        String sf1 = tfSf1Remarks.getText().trim();
        String sf2 = tfSf2Remarks.getText().trim();
        
        if(my.findReserveredCharacters(sf1, myVariables.getMyReservedCharacters())
                || my.findReserveredCharacters(sf2, myVariables.getMyReservedCharacters())){
            my.showMessage("Input must not contain \""+myVariables.getMyReservedCharactersString()+"\"", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int row = enrolledStudentsTable.getSelectedRow();
        String studentId = enrolledStudentsTable.getValueAt(row, 1).toString();
        
        sf1 = my.convertEscapeCharacters(sf1.length() > 0 ? sf1 : " ");
        sf2 = my.convertEscapeCharacters(sf2.length() > 0 ? sf2 : " ");
        
        tfSf1RemarksDisplay.setText(sf1);
        tfSf2RemarksDisplay.setText(sf2);
        closeCustomDialog();
    }//GEN-LAST:event_btnSetRemarksActionPerformed

    private void btnEditRemarksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditRemarksActionPerformed
        String sf1 = tfSf1RemarksDisplay.getText();
        String sf2 = tfSf2RemarksDisplay.getText();
        
        tfSf1Remarks.setText(sf1);
        tfSf2Remarks.setText(sf2);
        showCustomDialog("Edit Remarks", setSf1Sf2RemarkDialog, true, 320, 620, true);
    }//GEN-LAST:event_btnEditRemarksActionPerformed

    private void btnSaveRemarksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveRemarksActionPerformed
        int row = enrolledStudentsTable.getSelectedRow();
        
        
        String enrollmentId = enrolledStudentsTable.getValueAt(row, 0).toString();
        String studentId = enrolledStudentsTable.getValueAt(row, 1).toString();
        
        String sf1 = my.convertEscapeCharacters(tfSf1RemarksDisplay.getText());
        String sf2 = my.convertEscapeCharacters(tfSf2RemarksDisplay.getText());
        String remarks = sf1+"!"+sf2+"!";
        String sets [] = {
            "remarks='"+remarks+"'",
        };
        
        if(my.update_values("enrollment", sets, "id='"+enrollmentId+"'")){
            playSuccess();
            my.showMessage("Remarks Saved.", JOptionPane.INFORMATION_MESSAGE);
        }else{
            playError();
            my.showMessage("Saving Failed. Please make sure you are connected to the School Network.", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        searchEnrolledStudentsHandler(my.getButtonPressedEvent(evt.getSource()));
    }//GEN-LAST:event_btnSaveRemarksActionPerformed

    private void btnCancelLoadingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelLoadingActionPerformed
        //my.stopAllThreads();
        my.interrupMainThread();
        my.interrupSecondThread();
        my.interruptThirdThread();
    }//GEN-LAST:event_btnCancelLoadingActionPerformed

    private void btnLoadGradesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadGradesActionPerformed
        int sectionRow = assignedTeacherTable.getSelectedRow();
        int studentRow = enrolledStudentsTable.getSelectedRow();
        
        if(sectionRow == -1){
            my.showMessage("Please Select a Section.", JOptionPane.WARNING_MESSAGE);
            return;
        }if(studentRow == -1){
            my.showMessage("Please Select a Student.", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String sectionId = assignedTeacherTable.getValueAt(sectionRow, 1).toString();
        String studentId = enrolledStudentsTable.getValueAt(studentRow, 1).toString();
        int recordId = Integer.parseInt(lbFinalGradeId.getText());
        if(recordId <= 0){
            String where = "WHERE sectionId='"+sectionId+"' AND studentId='"+studentId+"'";
            //Load student's final grades first.
            if(my.checkForDuplicates("finalgrades",where, myVariables.getFinalGradesOrder())){
                //Load
                String result [] = my.return_values("*", "finalgrades",where, myVariables.getFinalGradesOrder());
                String id = my.getValueAtColumn(result[0], 0);
                String gwa = my.getValueAtColumn(result[0], 3);
                String evaluation = my.getValueAtColumn(result[0], 4);
                String failedSubjects = my.getValueAtColumn(result[0], 5);
                String dateUpdated = my.getValueAtColumn(result[0], 6);
                
                lbFinalGradeId.setText(id);
                tfGeneralAverage.setText(gwa);
                switch(evaluation){
                    case "Promoted":{
                        rbPromoted.setSelected(true);break;
                    }case "Conditional":{
                        rbConditional.setSelected(true);break;
                    }case "Retained":{
                        rbRetained.setSelected(true);break;
                    }case "Incomplete":{
                        rbIncomplete.setSelected(true);break;
                    }
                }
                tfFailedSubjects.setText(failedSubjects);
                btnSaveEvaluation.setEnabled(true);
                return;
            }else{
                //Ask to add new record
                if(my.getConfirmation("This student has no records yet. Add one now?")){
                    String [] values = {
                        "null,'"+sectionId+"','"+studentId+"'",
                    };
                    if(my.add_values("finalgrades", "id,sectionId,studentId", values)){
                        playSuccess();
                        my.showMessage("Adding Successful. Please reload this student.", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }else{
                        playError();
                        my.showMessage("Adding Failed. Please make sure you are connected to the School Network.", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }else{
                    return;
                }
            }
        }
        
        
        String subjectsContained = assignedTeacherTable.getValueAt(sectionRow, 13).toString();
        
        if(subjectsContained.trim().length()<2){
            playError();
            my.showMessage("No Subjects are assigned to this Section's Load.\nPlease contact your Curriculumn Head to add one.", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        my.runMainThread(0, 
                new JTable[]{enrolledStudentsTable,gradesTable}, 
                new String[]{sectionId,studentId,subjectsContained}, 
                new JTextField[]{tfGeneralAverage,tfFailedSubjects}, 
                new JButton[]{btnLoadGrades,btnSaveEvaluation}, 
                new JRadioButton[]{rbPromoted,rbConditional,rbRetained,rbIncomplete}
        );
    }//GEN-LAST:event_btnLoadGradesActionPerformed

    private void btnSaveEvaluationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveEvaluationActionPerformed
        String recordId = lbFinalGradeId.getText();
        String generalAverage = tfGeneralAverage.getText();
        String failedSubjects = tfFailedSubjects.getText();
        String evaluation = "";
        
        if(generalAverage.contains("NaN")){
            playError();
            my.showMessage("Invalid Grade.", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(rbPromoted.isSelected()){
            evaluation = "Promoted";
        }
        if(rbConditional.isSelected()){
            evaluation = "Conditional";
        }
        if(rbRetained.isSelected()){
            evaluation = "Retained";
        }
        if(rbIncomplete.isSelected()){
            evaluation = "Incomplete";
            
            if(my.getConfirmation("This student's records are still incomplete!"
                    + "\nYou are still allowed to save this evaluation,\n"
                    + " but this student will not appear on your list\nwhen exporting SF5 & SF6.\n\nContinue?")){
                
            }else{
                return;
            }
        }
        
        String [] sets = {
            "generalAverage='"+generalAverage+"'",
            "actionTaken='"+evaluation+"'",
            "failedSubjects='"+failedSubjects+"'",
            "dateUpdated=now()",
        };
        
        if(my.update_values("finalgrades", sets, "id='"+recordId+"'")){
            playSuccess();
            my.showMessage("Updated Successfully.", JOptionPane.INFORMATION_MESSAGE);
        }else{
            playError();
            my.showMessage("Update Failed. Please make sure you are connected to the School Network.", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveEvaluationActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
        Toolkit.getDefaultToolkit().beep();
        ImageIcon ic = my.getImgIcn(myVariables.getMsgUrlIconWarning());
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to end your current session ?","Confirm",dialogButton,JOptionPane.WARNING_MESSAGE,ic);

        if(dialogResult == JOptionPane.YES_OPTION){
            this.setVisible(false);
            new login().setVisible(true);
        }
    }//GEN-LAST:event_logoutActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(dashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dashBoard().setVisible(true);
            }
        });
    }
    private void resetViewStudentsTab(boolean clearStudentsTable,boolean clearAttendanceTable,boolean enableAttendanceButtons){
        if(clearStudentsTable){
            my.clear_table_rows(enrolledStudentsTable);
            tfSearchEnrolledStudent.setText("");
        }
        if(clearAttendanceTable){
            jdcDate.setDate(null);
            lbFinalGradeId.setText("0");
            tfGeneralAverage.setText("");
            tfFailedSubjects.setText("");
            btnSaveEvaluation.setEnabled(false);
            
            my.clear_table_rows(attendanceTable);
            my.clear_table_rows(gradesTable);
        }
        
        btnEditAttendance.setEnabled(enableAttendanceButtons);
        btnRecheckAttendance.setEnabled(enableAttendanceButtons);
    }
    private void enableDisableRemarks(boolean isEnabled,boolean editRemarks,boolean saveRemarks){
        btnEditRemarks.setEnabled(editRemarks);
        btnSaveRemarks.setEnabled(saveRemarks);
        
        if(!isEnabled){
            tfSf1RemarksDisplay.setText("");
            tfSf2RemarksDisplay.setText("");
        }
    }
    private void calculateAttendanceCount(JLabel attendanceCounter,JTable attendanceTable){
        int present = 0,absent = 0,tardy = 0;
        for(int n=0;n<attendanceTable.getRowCount();n++){
            String status = attendanceTable.getValueAt(n, 4).toString();
            
            if(status.contains("Present") || status.contains("present"))
                present++;
            if(status.contains("Absent") || status.contains("absent"))
                absent++;
            if(status.contains("Tardy") || status.contains("late"))
                tardy++;
        }
        
        attendanceCounter.setText("Present :"+present+"  Absent :"+absent+"  Tardy :"+tardy+"   Total :"+(present+absent+tardy));
    }
    private void checkAttendanceType(){
        if(rbToday.isSelected()){
            enableDisableCustomDateType(false);
        }
        if(rbCustomDate.isSelected()){
            enableDisableCustomDateType(true);
        }
    }
    private void enableDisableCustomDateType(boolean enabled){
        jdcCustomDate.setEnabled(enabled);
        jsHours.setEnabled(enabled);
        jsMinutes.setEnabled(enabled);
        
        jcbMeridan.setEnabled(enabled);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addNotesDialog;
    private javax.swing.JTable assignedTeacherTable;
    private javax.swing.JTable attendanceTable;
    private javax.swing.JButton btnCancelLoading;
    private javax.swing.JButton btnCheckAttendance;
    private javax.swing.JButton btnEditAttendance;
    private javax.swing.JButton btnEditRemarks;
    private javax.swing.JButton btnFinishAttendance;
    private javax.swing.JButton btnLoadGrades;
    private javax.swing.JButton btnRecheckAttendance;
    private javax.swing.JButton btnSaveChangesToAttendance;
    private javax.swing.JButton btnSaveEvaluation;
    private javax.swing.JButton btnSaveNotes;
    private javax.swing.JButton btnSaveRecheckAttendanceChanges;
    private javax.swing.JButton btnSaveRemarks;
    private javax.swing.JButton btnSearchDate;
    private javax.swing.JButton btnSearchEnrolledStudent;
    private javax.swing.JButton btnSearchSection;
    private javax.swing.JButton btnSetRemarks;
    private javax.swing.JPanel checkAttendanceTab;
    private javax.swing.JTable checkAttendanceTable;
    private javax.swing.JPanel editAttendanceDialog;
    private javax.swing.JTable enrolledStudentsTable;
    private javax.swing.JTable gradesTable;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JComboBox<String> jcbMeridan;
    private javax.swing.JComboBox<String> jcbSchoolYear1;
    private com.toedter.calendar.JDateChooser jdcCustomDate;
    private com.toedter.calendar.JDateChooser jdcDate;
    private javax.swing.JProgressBar jpbProgressBar;
    private javax.swing.JSpinner jsHours;
    private javax.swing.JSpinner jsMinutes;
    private javax.swing.JTextArea jtaLeaveNotes;
    private javax.swing.JTextArea jtaNotes;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel lbAttendanceCount;
    private javax.swing.JLabel lbAttendanceID;
    private javax.swing.JLabel lbDateAdded;
    private javax.swing.JLabel lbDateToRecheck;
    private javax.swing.JLabel lbFinalGradeId;
    private javax.swing.JLabel lbLoadingMessage;
    private javax.swing.JLabel lbLoggedInUser;
    private javax.swing.JLabel lbLoggedInUser1;
    private javax.swing.JLabel lbSearchResult;
    private javax.swing.JLabel lbSearchResult1;
    private javax.swing.JPanel left;
    private javax.swing.JPanel left1;
    private javax.swing.JPanel loadingDialog;
    private javax.swing.JMenuItem logout;
    private javax.swing.JTabbedPane mainTab;
    private javax.swing.JMenu menu;
    private javax.swing.JRadioButton rbAbsent;
    private javax.swing.JRadioButton rbConditional;
    private javax.swing.JRadioButton rbCustomDate;
    private javax.swing.JRadioButton rbIncomplete;
    private javax.swing.JRadioButton rbPresent;
    private javax.swing.JRadioButton rbPromoted;
    private javax.swing.JRadioButton rbRetained;
    private javax.swing.JRadioButton rbTardy;
    private javax.swing.JRadioButton rbToday;
    private javax.swing.JPanel recheckAttendanceDialog;
    private javax.swing.JTable recheckAttendanceTable;
    private javax.swing.JPanel right;
    private javax.swing.JPanel right1;
    private javax.swing.JPanel selectSectionTab;
    private javax.swing.ButtonGroup setDateGroup;
    private javax.swing.ButtonGroup setRemarksGroup;
    private javax.swing.JPanel setSf1Sf2RemarkDialog;
    private javax.swing.ButtonGroup setStatusGroup;
    private javax.swing.JPanel tab1;
    private javax.swing.JPanel testDialog;
    private javax.swing.JTextField tfFailedSubjects;
    private javax.swing.JTextField tfGeneralAverage;
    private javax.swing.JTextField tfSearchEnrolledStudent;
    private javax.swing.JTextField tfSearchTeacherLoad;
    private javax.swing.JTextField tfSf1Remarks;
    private javax.swing.JTextField tfSf1RemarksDisplay;
    private javax.swing.JTextField tfSf2Remarks;
    private javax.swing.JTextField tfSf2RemarksDisplay;
    private javax.swing.JPanel viewStudentsTab;
    // End of variables declaration//GEN-END:variables
}
