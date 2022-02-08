/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mahPackage6;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import javazoom.jl.player.Player;
/**
 *
 * @author Phil Rey Paderogao
 */
public class dashBoard extends javax.swing.JFrame {

    myFunctions my;
    
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
    
    //  int counter = 0,counter2 = 0,counter3 = 0,counter4 = 0;
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
        
        my = new myFunctions();
        initComponents();
        myInitComponents();
        menu.setText(myVariables.getUserLoggedInName());
        
        
        lbuserwelcome.setFont(poppins12R);
        lbLoggedInUser.setText(myVariables.getUserLoggedInName());
        lbLoggedInUser.setFont(poppins14);        
        lbLoggedInUserLevel.setText(myVariables.getAccessLevelName(-1));
        lbLoggedInUserLevel.setFont(poppins12R);
        loadTabs();
        loadTabIcons();
        
        loadColoredButtons();
        loadLabels();
        
        loadTextFields();
        sortTables();
        
        setScrollSpeeds();
        loadYearDropDowns(12);
        
       // lbSchoolName.setText(myVariables.getSchoolName() + " Weighing System");
        //lbSchoolAddress.setText(myVariables.getSchoolAddress());
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
    
 
    // Toolkit.getDefaultToolkit().beep();

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
            jScrollPane2,jScrollPane7,jScrollPane9,
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
            my.hideColumns(assignedTeacherTable, new int [] {0,1,3,6});
            my.hideColumns(enrolledStudentsTable, new int [] {0,1,6,7});
            
            my.hideColumns(bmiChartMaleTable, new int [] {0});
            my.hideColumns(bmiChartFemaleTable, new int [] {0});
            my.hideColumns(hfaChartMaleTable, new int [] {0});
            my.hideColumns(hfaChartFemaleTable, new int [] {0});
        }
        
        //Set table fonts
        JTable tables [] = {
            assignedTeacherTable,
            enrolledStudentsTable,
            bmiChartMaleTable,bmiChartFemaleTable,
            hfaChartMaleTable,hfaChartFemaleTable,
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
        mainTab.add("Select Managed Section",selectSectionTab);
        mainTab.add("View Students",viewStudentsTab);
        
        mainTab.setFont(myVariables.TAB_HEADER_FONT);
    }
    private void loadTabIcons(){
        Icon tabIcons [] = {
            my.getImgIcn(myVariables.getSectionsIcon()),
            my.getImgIcn(myVariables.getViewStudentsIcon()),
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
            //View Students
            btnSearchEnrolledStudent,btnEvaluate,
            btnSaveEvaluationChanges,
            btnEvaluateTest,
            btnRefreshBmi,btnRefreshHfa,
        };
        
        JButton lightButtons [] = {
            btnMyManagedSubjects,
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
            lightButtons[n].setForeground(new Color(0,0,0));         //251,185,227   
            lightButtons[n].setFont(myVariables.BUTTON_FONT);
            //buttons[n].setCursor(my.getCursor(myVariables.getHandCursor()));
            lightButtons[n].setCursor(new Cursor(Cursor.HAND_CURSOR));
            lightButtons[n].setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
    }
    private void loadLabels(){
        JLabel titleHeaderLabels [] = {
            jLabel35,jLabel36,
        };
        JLabel labels [] = {
            lbSearchResult,lbSearchResult1,
        };
        
        JLabel formsHeaderLabels [] = {
            jLabel14,jLabel16,jLabel18,jLabel1,jLabel2,jLabel3,jLabel4,jLabel28,jLabel32
        };
        JLabel textFieldHeaderLabels [] = {
            jLabel12,jLabel23,jLabel15,jLabel17,jLabel22,jLabel24,jLabel19,
            jLabel20,jLabel5,jLabel6,jLabel7,jLabel8,jLabel13,jLabel25,jLabel26,
            jLabel9,jLabel11,lbNutritionalStatus,lbHeightForAge,jLabel27,
            jLabel33, jLabel30,
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
            jdcDateOfMeasurement,jdcTestDateOfMeasurement,jdcTestDateOfBirt,
        };
        JSpinner spinners [] = {
            //jsHours,jsMinutes
        };
        
        JTextField searchFields [] = {
            tfSearchTeacherLoad,tfSearchEnrolledStudent,
        };
        JTextField forms [] = {
            tfAge,tfWeight,tfHeight,tfBmi,tfHeightSquared,tfBmiForAge,
            tfHeightForAge,tfTestAge,tfTestHeight,tfTestHeightSq,tfTestWeight,
            tfTestBmi,tfstrandM6,
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
        semesterSelectM6.setFont(myVariables.TEXTFIELD_FONT);
    }
    private void loadYearDropDowns(int numberOfYears){
        JComboBox [] yearDropDowns = {
            
        };
        
        JComboBox [] yearDropDownsWithAllOption = {
            jcbSchoolYear1,
        };
        JComboBox [] dropDowns = {
            jcbTestGender,
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        tfAge = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        tfWeight = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        tfHeight = new javax.swing.JTextField();
        btnEvaluate = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        tfBmiForAge = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        tfHeightForAge = new javax.swing.JTextField();
        btnSaveEvaluationChanges = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        lbBmiRecordId = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jdcDateOfMeasurement = new com.toedter.calendar.JDateChooser();
        tfHeightSquared = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        tfBmi = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        semesterSelectM6 = new javax.swing.JComboBox<>();
        jLabel33 = new javax.swing.JLabel();
        tfstrandM6 = new javax.swing.JTextField();
        referenceChartsDialog = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jSplitPane2 = new javax.swing.JSplitPane();
        left1 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        bmiChartMaleTable = new javax.swing.JTable();
        jLabel28 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        bmiChartFemaleTable = new javax.swing.JTable();
        btnRefreshBmi = new javax.swing.JButton();
        right1 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        tfTestHeightSq = new javax.swing.JTextField();
        tfTestAge = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        btnEvaluateTest = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        lbNutritionalStatus = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbHeightForAge = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jcbTestGender = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jdcTestDateOfBirt = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jdcTestDateOfMeasurement = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        tfTestWeight = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfTestHeight = new javax.swing.JTextField();
        tfTestBmi = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        hfaChartMaleTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        hfaChartFemaleTable = new javax.swing.JTable();
        btnRefreshHfa = new javax.swing.JButton();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        mainTab = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lbLoggedInUserLevel = new javax.swing.JLabel();
        lbLoggedInUser = new javax.swing.JLabel();
        btnPanel = new javax.swing.JPanel();
        lbuserwelcome = new javax.swing.JLabel();
        tab1 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        btnMyManagedSubjects = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu = new javax.swing.JMenu();
        logout = new javax.swing.JMenuItem();

        selectSectionTab.setBackground(new java.awt.Color(203, 184, 160));

        lbSearchResult.setText("Search using the search bar...");

        tfSearchTeacherLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchSectionHandler(evt);
            }
        });

        btnSearchSection.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/Search.png"))); // NOI18N
        btnSearchSection.setToolTipText("");
        btnSearchSection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchSectionHandler(evt);
            }
        });

        jcbSchoolYear1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2019", "2020" }));
        jcbSchoolYear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbSchoolYear1ActionPerformed(evt);
            }
        });

        assignedTeacherTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Section ID", "Section Name", "Adv ID", "Name", "Gender", "Subject ID", "Code", "Description", "Grade", "School Year"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
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
                        .addComponent(tfSearchTeacherLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearchSection, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
                .addContainerGap())
        );
        selectSectionTabLayout.setVerticalGroup(
            selectSectionTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(selectSectionTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(selectSectionTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSearchSection, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(selectSectionTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbSearchResult)
                        .addComponent(tfSearchTeacherLoad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcbSchoolYear1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

        lbSearchResult1.setText("Search using the search bar...");

        tfSearchEnrolledStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchEnrolledStudentHandler(evt);
            }
        });

        btnSearchEnrolledStudent.setBackground(new java.awt.Color(255, 255, 255));
        btnSearchEnrolledStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/Search.png"))); // NOI18N
        btnSearchEnrolledStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchEnrolledStudentHandler(evt);
            }
        });

        enrolledStudentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Student ID", "LRN", "Name", "Gender", "Birth Date", "Section ID", "strand", "semester"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        enrolledStudentsTable.getTableHeader().setReorderingAllowed(false);
        enrolledStudentsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                enrolledStudentsTableMouseClicked(evt);
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                    .addGroup(leftLayout.createSequentialGroup()
                        .addComponent(lbSearchResult1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfSearchEnrolledStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearchEnrolledStudent)))
                .addContainerGap())
        );
        leftLayout.setVerticalGroup(
            leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSearchResult1)
                    .addComponent(tfSearchEnrolledStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchEnrolledStudent))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane1.setLeftComponent(left);

        right.setMaximumSize(new java.awt.Dimension(12767, 32767));
        right.setMinimumSize(new java.awt.Dimension(343, 533));

        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setMinimumSize(new java.awt.Dimension(525, 5));
        jScrollPane2.setName(""); // NOI18N

        jPanel2.setBackground(new java.awt.Color(249, 239, 227));

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

        jLabel12.setText("Age (years, months)");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("BASIC");

        tfAge.setEditable(false);

        jLabel15.setText("Weight (kg)");

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Nutrional Status Properties");

        tfWeight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfWeightActionPerformed(evt);
            }
        });

        jLabel17.setText("Height (m)");

        tfHeight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfHeightActionPerformed(evt);
            }
        });

        btnEvaluate.setForeground(new java.awt.Color(255, 255, 255));
        btnEvaluate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/calculator 1.png"))); // NOI18N
        btnEvaluate.setText("Evaluate");
        btnEvaluate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEvaluateActionPerformed(evt);
            }
        });

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Results");

        jLabel19.setText("Bmi For Age");

        tfBmiForAge.setEditable(false);

        jLabel20.setText("Height For Age");

        tfHeightForAge.setEditable(false);

        btnSaveEvaluationChanges.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveEvaluationChanges.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/save.png"))); // NOI18N
        btnSaveEvaluationChanges.setText("Save Evaluation");
        btnSaveEvaluationChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveEvaluationChangesActionPerformed(evt);
            }
        });

        jLabel21.setText("Record ID :");

        lbBmiRecordId.setText("0");

        jLabel23.setText("Date of Measurement");

        tfHeightSquared.setEditable(false);

        jLabel22.setText("Height (m^2)");

        jLabel24.setText("BMI");

        tfBmi.setEditable(false);

        jLabel30.setText("Semester");

        semesterSelectM6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st Semester", "2nd Semester" }));

        jLabel33.setText("Strand");

        tfstrandM6.setEditable(false);
        tfstrandM6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfstrandM6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbBmiRecordId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
                            .addComponent(tfWeight)
                            .addComponent(tfHeight))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfBmi)
                            .addComponent(tfHeightSquared)
                            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(26, 26, 26))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSaveEvaluationChanges, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfHeightForAge, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfBmiForAge, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(btnEvaluate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(1, 1, 1))
                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(290, 290, 290))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(tfAge, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jdcDateOfMeasurement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(100, 100, 100)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfstrandM6)
                                    .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(semesterSelectM6, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(26, 26, 26)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(lbBmiRecordId))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel30))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(semesterSelectM6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(jLabel33))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdcDateOfMeasurement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tfstrandM6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfBmi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfHeightSquared, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEvaluate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfBmiForAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfHeightForAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSaveEvaluationChanges)
                .addContainerGap())
        );

        jScrollPane2.setViewportView(jPanel2);

        javax.swing.GroupLayout rightLayout = new javax.swing.GroupLayout(right);
        right.setLayout(rightLayout);
        rightLayout.setHorizontalGroup(
            rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        rightLayout.setVerticalGroup(
            rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jSplitPane1.setRightComponent(right);

        javax.swing.GroupLayout viewStudentsTabLayout = new javax.swing.GroupLayout(viewStudentsTab);
        viewStudentsTab.setLayout(viewStudentsTabLayout);
        viewStudentsTabLayout.setHorizontalGroup(
            viewStudentsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1112, Short.MAX_VALUE)
        );
        viewStudentsTabLayout.setVerticalGroup(
            viewStudentsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE)
        );

        referenceChartsDialog.setBackground(new java.awt.Color(255, 255, 204));

        jPanel8.setBackground(new java.awt.Color(22, 66, 33));

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Reference Charts");

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

        jSplitPane2.setDividerLocation(460);

        jScrollPane9.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));

        jLabel1.setText("Nutritional Status (Boys)");

        bmiChartMaleTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Age", "Months", "SVR Wasted", "Wasted", "Normal", "Overweight", "Obese"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bmiChartMaleTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(bmiChartMaleTable);
        if (bmiChartMaleTable.getColumnModel().getColumnCount() > 0) {
            bmiChartMaleTable.getColumnModel().getColumn(7).setHeaderValue("Obese");
        }

        jLabel28.setText("Nutritional Status (Girls)");

        bmiChartFemaleTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Age", "Months", "SVR Wasted", "Wasted", "Normal", "Overweight", "Obese"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bmiChartFemaleTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(bmiChartFemaleTable);
        if (bmiChartFemaleTable.getColumnModel().getColumnCount() > 0) {
            bmiChartFemaleTable.getColumnModel().getColumn(7).setHeaderValue("Obese");
        }

        btnRefreshBmi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/refresh.png"))); // NOI18N
        btnRefreshBmi.setText("Refresh");
        btnRefreshBmi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshBmiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane6)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRefreshBmi)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRefreshBmi)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane9.setViewportView(jPanel3);

        javax.swing.GroupLayout left1Layout = new javax.swing.GroupLayout(left1);
        left1.setLayout(left1Layout);
        left1Layout.setHorizontalGroup(
            left1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
        );
        left1Layout.setVerticalGroup(
            left1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
        );

        jSplitPane2.setLeftComponent(left1);

        right1.setBackground(new java.awt.Color(255, 255, 204));

        jLabel25.setText("Height^2");

        tfTestHeightSq.setEditable(false);
        tfTestHeightSq.setFocusable(false);

        tfTestAge.setEditable(false);
        tfTestAge.setFocusable(false);

        jLabel26.setText("Age");

        btnEvaluateTest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/calculator 1.png"))); // NOI18N
        btnEvaluateTest.setText("Evaluate");
        btnEvaluateTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEvaluateTestActionPerformed(evt);
            }
        });

        jLabel9.setText("Nutritional Status :");

        lbNutritionalStatus.setText("RESULT");

        jLabel11.setText("Height-For-Age :");

        lbHeightForAge.setText("RESULT");

        jLabel13.setText("Gender");

        jcbTestGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Formula Tester");

        jLabel5.setText("Date of Birth");

        jLabel6.setText("Date of Measurement");

        jLabel7.setText("Weight (kg)");

        jLabel8.setText("Height (m)");

        tfTestHeight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTestHeightActionPerformed(evt);
            }
        });

        tfTestBmi.setEditable(false);
        tfTestBmi.setFocusable(false);

        jLabel27.setText("BMI");

        javax.swing.GroupLayout right1Layout = new javax.swing.GroupLayout(right1);
        right1.setLayout(right1Layout);
        right1Layout.setHorizontalGroup(
            right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(right1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEvaluateTest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(right1Layout.createSequentialGroup()
                        .addGroup(right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(right1Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(79, 79, 79))
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbNutritionalStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(right1Layout.createSequentialGroup()
                                .addComponent(lbHeightForAge, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                                .addGap(17, 17, 17))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, right1Layout.createSequentialGroup()
                        .addGroup(right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(right1Layout.createSequentialGroup()
                                .addGroup(right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(right1Layout.createSequentialGroup()
                                        .addGroup(right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(tfTestWeight)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 69, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(tfTestAge, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)))
                                    .addGroup(right1Layout.createSequentialGroup()
                                        .addGroup(right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jdcTestDateOfBirt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)))
                                .addGap(29, 29, 29))
                            .addGroup(right1Layout.createSequentialGroup()
                                .addGroup(right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tfTestHeight)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(right1Layout.createSequentialGroup()
                                        .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                                        .addGap(27, 27, 27))
                                    .addGroup(right1Layout.createSequentialGroup()
                                        .addComponent(tfTestHeightSq, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))))
                        .addGroup(right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(right1Layout.createSequentialGroup()
                                .addComponent(jdcTestDateOfMeasurement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(15, 15, 15))
                            .addGroup(right1Layout.createSequentialGroup()
                                .addComponent(jcbTestGender, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(69, 69, 69))
                            .addGroup(right1Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(91, 91, 91))
                            .addGroup(right1Layout.createSequentialGroup()
                                .addGroup(right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tfTestBmi, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(77, 77, 77)))))
                .addContainerGap())
        );
        right1Layout.setVerticalGroup(
            right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(right1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(right1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdcTestDateOfBirt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(right1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdcTestDateOfMeasurement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addGroup(right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, right1Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tfTestWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(right1Layout.createSequentialGroup()
                            .addComponent(jLabel26)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tfTestAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jcbTestGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(right1Layout.createSequentialGroup()
                            .addGroup(right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(jLabel25))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tfTestHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfTestBmi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfTestHeightSq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEvaluateTest)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lbNutritionalStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lbHeightForAge))
                .addContainerGap())
        );

        jSplitPane2.setRightComponent(right1);

        jScrollPane7.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        jLabel2.setText("Height-For-Age (Boys)");

        hfaChartMaleTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Age", "Months", "SVR Stunted", "Stunted", "Normal", "Tall"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        hfaChartMaleTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(hfaChartMaleTable);

        jLabel3.setText("Height-For-Age (Girls)");

        hfaChartFemaleTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Age", "Months", "SVR Stunted", "Stunted", "Normal", "Tall"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        hfaChartFemaleTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(hfaChartFemaleTable);

        btnRefreshHfa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/refresh.png"))); // NOI18N
        btnRefreshHfa.setText("Refresh");
        btnRefreshHfa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshHfaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRefreshHfa)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRefreshHfa)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane7.setViewportView(jPanel1);

        javax.swing.GroupLayout referenceChartsDialogLayout = new javax.swing.GroupLayout(referenceChartsDialog);
        referenceChartsDialog.setLayout(referenceChartsDialogLayout);
        referenceChartsDialogLayout.setHorizontalGroup(
            referenceChartsDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2)
            .addGroup(referenceChartsDialogLayout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane7)
        );
        referenceChartsDialogLayout.setVerticalGroup(
            referenceChartsDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(referenceChartsDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSplitPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))
        );

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jScrollPane10.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Dashboard");
        setIconImage(my.getImgIcn(myVariables.getWeighingWindowIcon()).getImage()
        );
        setMinimumSize(new java.awt.Dimension(1303, 782));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                logOutHandler(evt);
            }
        });

        kGradientPanel1.setBackground(new java.awt.Color(249, 239, 227));
        kGradientPanel1.setkEndColor(new java.awt.Color(249, 239, 227));
        kGradientPanel1.setkStartColor(new java.awt.Color(249, 239, 227));
        kGradientPanel1.setMinimumSize(new java.awt.Dimension(1003, 600));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(1003, 600));

        mainTab.setBackground(new java.awt.Color(203, 184, 160));
        mainTab.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        mainTab.setToolTipText("");
        mainTab.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        mainTab.setMinimumSize(new java.awt.Dimension(100, 100));
        mainTab.setPreferredSize(new java.awt.Dimension(1068, 548));

        jPanel4.setBackground(new java.awt.Color(251, 185, 211));
        jPanel4.setMinimumSize(new java.awt.Dimension(270, 723));
        jPanel4.setName(""); // NOI18N
        jPanel4.setPreferredSize(new java.awt.Dimension(270, 723));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(58, 57, 57));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("WEIGHING SYSTEM");

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(58, 57, 57));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("SHS");

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage6/icons/cbshs.png"))); // NOI18N
        jLabel31.setAlignmentX(0.5F);

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        lbLoggedInUserLevel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbLoggedInUserLevel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbLoggedInUserLevel.setText("ACCESS_LEVEL");
        lbLoggedInUserLevel.setToolTipText("");
        lbLoggedInUserLevel.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lbLoggedInUserLevel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        lbLoggedInUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbLoggedInUser.setText("USER_NAME");
        lbLoggedInUser.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lbLoggedInUser.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnPanel.setBackground(new java.awt.Color(251, 185, 211));
        btnPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPanelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnPanelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout btnPanelLayout = new javax.swing.GroupLayout(btnPanel);
        btnPanel.setLayout(btnPanelLayout);
        btnPanelLayout.setHorizontalGroup(
            btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );
        btnPanelLayout.setVerticalGroup(
            btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        lbuserwelcome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbuserwelcome.setText("Welcome");

        tab1.setBackground(new java.awt.Color(253, 232, 240));
        tab1.setMinimumSize(new java.awt.Dimension(260, 49));

        jLabel32.setForeground(new java.awt.Color(58, 57, 57));
        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage6/icons/icons8_user_groups_skin_type_7_20px_1.png"))); // NOI18N
        jLabel32.setText(" Managed Sections");

        javax.swing.GroupLayout tab1Layout = new javax.swing.GroupLayout(tab1);
        tab1.setLayout(tab1Layout);
        tab1Layout.setHorizontalGroup(
            tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        tab1Layout.setVerticalGroup(
            tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbuserwelcome)
                            .addComponent(lbLoggedInUser)
                            .addComponent(lbLoggedInUserLevel))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jLabel31)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tab1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29)
                .addGap(2, 2, 2)
                .addComponent(jLabel10)
                .addGap(23, 23, 23)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tab1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(btnPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbuserwelcome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbLoggedInUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbLoggedInUserLevel)
                .addGap(19, 19, 19))
        );

        btnMyManagedSubjects.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/chart.png"))); // NOI18N
        btnMyManagedSubjects.setText("Reference Charts  ");
        btnMyManagedSubjects.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMyManagedSubjectsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMyManagedSubjects, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(mainTab, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 992, Short.MAX_VALUE))
                .addContainerGap())
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btnMyManagedSubjects)
                .addGap(18, 18, 18)
                .addComponent(mainTab, javax.swing.GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );

        jMenuBar1.setToolTipText("");
        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage6/icons/icons8-male-user_circle-20.png"))); // NOI18N

        logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage6/icons/icons8-logout-rounded-up-20.png"))); // NOI18N
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
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
public void myInitComponents() {
     lbSearchResult.setForeground(new java.awt.Color(0,0,0));//edited previous 255, 255, 255
     lbSearchResult.setText("Search using the search bar...");    
    
    referenceChartsDialog.setBackground(new java.awt.Color(249, 239, 227));
    
    
       jLabel29.setFont(poppins48);
       jLabel10.setFont(poppins19);
       jLabel32.setFont(new java.awt.Font("Poppins SemiBold", 0, 19));
       lbLoggedInUser. setFont(new java.awt.Font("Poppins SemiBold", 0, 14));
       lbLoggedInUserLevel. setFont(new java.awt.Font("Poppins SemiBold", 0, 14));
       lbuserwelcome. setFont(new java.awt.Font("Poppins SemiBold", 0, 14));
             
        jPanel8.setBackground(new java.awt.Color(251,185,211));
        
        

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255,255 ));
        jLabel36.setText("Reference Charts");
        
        jPanel2.setBackground(new java.awt.Color(249, 239, 227));

        
        
       //  jLabel30.setText("Manage Selected Section");
         //jLabel30.setForeground(new java.awt.Color(0,0,0));
         
        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("View Student Details");
        
       jPanel3.setBackground(new java.awt.Color(203,184,160));
        
       right1.setBackground(new java.awt.Color(249, 239, 227)); //reference chart unod
        
        jPanel1.setBackground(new java.awt.Color(203,184,160));
         
        selectSectionTab.setBackground(new java.awt.Color(203,184,160));  //tabforselectingsection
        
        mainTab.setBackground(new java.awt.Color(203,184,160)); 
        mainTab.setForeground(new java.awt.Color(0,0,0));
         
}

    private void assignedTeacherTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_assignedTeacherTableMouseClicked
        if(evt.getClickCount() == 2){
            if(mainTab.getTabCount() <= 1){
                int row = assignedTeacherTable.getSelectedRow();
                
                String subjectName = assignedTeacherTable.getValueAt(row, 8).toString();
                
                mainTab.addTab("View Students", my.getImgIcn(myVariables.getViewStudentsIcon()), viewStudentsTab);
                mainTab.setSelectedIndex(1);
            }
        }else{
            my.clear_table_rows(enrolledStudentsTable);
            my.remove_multiple_tabs(mainTab, new int [] {1,2});
        }
    }//GEN-LAST:event_assignedTeacherTableMouseClicked

    private void enrolledStudentsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_enrolledStudentsTableMouseClicked
        if(evt.getClickCount() == 2){
            int row = enrolledStudentsTable.getSelectedRow();
            String studentId = enrolledStudentsTable.getValueAt(row, 1).toString();
            String sectionId = enrolledStudentsTable.getValueAt(row, 6).toString();
            
            String where = "WHERE studentId='"+studentId+"' AND sectionId='"+sectionId+"'";
            
            String result [] = my.return_values("*", "bmi", where, myVariables.getBmiOrder());
            
            if(result != null){
                String values [] = result[0].split("@@");
                String recordId = values[0];
                String age = values[3];
                
                String weight = values[4];
                String height = values[5];
                String heightSquared = values[6];
                
                String bmi = values[7];
                String bmiForAge = values[8];
                String heightForAge = values[9];
                String dateMeasured = values[10];
                
                lbBmiRecordId.setText(recordId);
                tfAge.setText(age);
                
                tfWeight.setText(weight);
                tfHeight.setText(height);
                tfHeightSquared.setText(heightSquared);
                
                tfBmi.setText(bmi);
                tfBmiForAge.setText(bmiForAge);
                tfHeightForAge.setText(heightForAge);
                
                jdcDateOfMeasurement.setDate(my.dateTimeTojCalendarDateFormat(dateMeasured));
                clearBmiFields(false, true, false);
            }else{
                if(my.getConfirmation("This student has no records yet.\nAdd one now?")){
                    String [] values = {
                        "null,'"+studentId+"','"+sectionId+"'",
                    };
                    
                    if(my.add_values("bmi", "id,studentId,sectionId", values)){
                        playSuccess();
                        my.showMessage("Added Successfully. Please select the student again.", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        playError();
                        my.showMessage("Adding Failed! Please make sure you are connected to the School Network.", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }else{
            clearBmiFields(true, false, false);
        }
    }//GEN-LAST:event_enrolledStudentsTableMouseClicked

    private void logOutHandler(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_logOutHandler
        my.openWindow(this, new login());
    }//GEN-LAST:event_logOutHandler

    private void searchSectionHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchSectionHandler
        String toSearch = tfSearchTeacherLoad.getText();
        String schoolYear = jcbSchoolYear1.getSelectedItem().toString();

        my.remove_multiple_tabs(mainTab, new int [] {1,2});

        String where = "WHERE subjectCode LIKE 'ADV%' AND gradeLevel > 10 ";

        //Filter search based on Access Level
        switch (myVariables.getAccessLevel()){
            case 1:{    //Teacher or MAPEH Teacher
                where += " AND teacherId='"+myVariables.getUserLoggedInId()+"'";
                break;
            }case 2:{   //Department Head
                /*String managedSubjects = "";

                for(int n=0;n<assignedSubjectsTable.getRowCount();n++){
                    managedSubjects += assignedSubjectsTable.getValueAt(n, 0).toString();
                    if(n < assignedSubjectsTable.getRowCount()-1){
                        managedSubjects+=",";
                    }
                }
                if(managedSubjects.length() > 0){
                    where += " AND subjectId IN ("+managedSubjects+")";
                }else{
                    my.showMessage("You have no subjects assigned to you. Try refreshing again.\nIf the problem persists, please consult your Curruculum Head if you think this is an error.", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                where += " AND teacherId!='-1'";*/
                break;
            }case 4:{
                where += " AND teacherId!='-1'";
                break;
            }case 5:{
                break;
            }
        }

        if(jcbSchoolYear1.getSelectedIndex() != 0){
            where +=" AND schoolYear='"+schoolYear+"'";
        }

        if(toSearch.length() > 0){
            where +=" AND sectionName LIKE '%"+toSearch+"%'";
        }

        String [] result = my.return_values("*", "v_managedsubjects", where, myVariables.getManagedSubjectsViewOrder());

        my.clear_table_rows(assignedTeacherTable);
        if(result == null){
           
            lbSearchResult.setText("Showing 0 results for '"+toSearch+"'.");
             Toolkit.getDefaultToolkit().beep(); 
            my.showMessage("You have no SHS section assigned to you",JOptionPane.WARNING_MESSAGE);

           
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
    }//GEN-LAST:event_searchSectionHandler

    private void btnSaveEvaluationChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveEvaluationChangesActionPerformed
        //Get Values & Update
        String recordId = lbBmiRecordId.getText();
        String age = tfAge.getText();
        String dateOfMeasurement = my.jCalendarToNumberDate(jdcDateOfMeasurement.getDate().toString(), true);
        
        String weight = tfWeight.getText();;
        String height = tfHeight.getText();;
        String heightSquared = tfHeightSquared.getText();;
        
        String bmi = tfBmi.getText();;
        String bmiForAge = tfBmiForAge.getText();;
        String heightForAge = tfHeightForAge.getText();
        
        String sets [] = {
            "age='"+age+"'",
            "weight='"+weight+"'",
            "height='"+height+"'",
            "heightSq='"+heightSquared+"'",
            "bmi='"+bmi+"'",
            "bmiForAge='"+bmiForAge+"'",
            "heightForAge='"+heightForAge+"'",
            "dateExamined='"+dateOfMeasurement+"'"
        };
        
        if(my.update_values("bmi", sets, "id='"+recordId+"'")){
            playSuccess();
            my.showMessage("Update Successful.", JOptionPane.INFORMATION_MESSAGE);
            searchEnrolledStudentHandler(my.getButtonPressedEvent(evt.getSource()));
        }else{
            playError();
            my.showMessage("Update Failed. Please make sure you are connected to the School Network.", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveEvaluationChangesActionPerformed

    private void searchEnrolledStudentHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchEnrolledStudentHandler
        int row = assignedTeacherTable.getSelectedRow();
        String semM6=semesterSelectM6.getSelectedItem().toString();
        if(row == -1){
             Toolkit.getDefaultToolkit().beep();
            my.showMessage("Please select a section first.", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String sectionId = assignedTeacherTable.getValueAt(row, 1).toString();
        String toSearch = tfSearchEnrolledStudent.getText();
        
        //strand
            my.getStrandFromSectionID("v_enrollment_mini_wbdate_shs_wsem","WHERE sectionId='"+sectionId+"'",myVariables.getEnrollmentViewMinWBdateOrderShs2());
           String getStrandM6 = myVariables.getStrandName();     
           tfstrandM6.setText(getStrandM6);
          
           

        String where = "WHERE sectionId='"+sectionId+"' AND sem='"+semM6+"' AND (lrn='"+toSearch+"' OR lName LIKE '%"+toSearch+"%')";
        my.searchItem(where, enrolledStudentsTable, 8, null, new int [] {3,4,5}, true, true, lbSearchResult1, tfSearchEnrolledStudent, true);
        clearBmiFields(true, false, false);
    }//GEN-LAST:event_searchEnrolledStudentHandler

    private void btnEvaluateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEvaluateActionPerformed
        int row = enrolledStudentsTable.getSelectedRow();
        if(row == -1){
             Toolkit.getDefaultToolkit().beep();
            my.showMessage("No Student Selected.", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String dateConducted = "";
        String dateOfBirth = "";
        String weight = tfWeight.getText().trim();
        String height = tfHeight.getText().trim();
        String heightSquared = "";
        String bmi = "";
        String gender = enrolledStudentsTable.getValueAt(row, 4).toString();
        
        try {
            dateConducted = my.jCalendarToNumberDate(jdcDateOfMeasurement.getDate().toString(), false);
            dateOfBirth = enrolledStudentsTable.getValueAt(row, 5).toString();
        } catch (Exception e) {
            Toolkit.getDefaultToolkit().beep();
            my.showMessage("Invalid Date.", JOptionPane.WARNING_MESSAGE);return;}
        try {
     //     Integer.parseInt(weight);
            Float.parseFloat(height);
            boolean heightVal= Pattern.matches("^([0])(\\.[6-9])(\\d{0,3})$|^([1-3])(\\.)(\\d{0,4})$|^[1-3?]$", height);
            //range 0.6000 - 3.9999 meters
            if (!heightVal) {
            Toolkit.getDefaultToolkit().beep();
            my.showMessage("Invalid Height: 1 feet = 0.3048 meters", JOptionPane.WARNING_MESSAGE);return;
            }
            boolean weightVal =Pattern.matches("^[1-9](\\.\\d{1,2}){0,3}$|^[0-9]{2}(\\.\\d{1,2}){0,3}$|^[1-5][0-9]{2}(\\.\\d{1,2}){0,3}$", weight); 
            //range 1- 599.99 kg
            if (!weightVal) {
            Toolkit.getDefaultToolkit().beep();
            my.showMessage("Invalid Weight", JOptionPane.WARNING_MESSAGE);return;
            }
              
        } catch (Exception e) {
            Toolkit.getDefaultToolkit().beep();
            my.showMessage("Invalid Weight/Height.", JOptionPane.WARNING_MESSAGE);return;}

        heightSquared = my.getHeightSquared(height);
        bmi = my.getBmi(weight, heightSquared);
        String ageInYearMonth = my.getAgeInYearsMonths(dateConducted, dateOfBirth);
        String hfa = my.getHeightForAge(height, ageInYearMonth, gender, false);
        String nutritionalStatus = my.getNutritionalStatus(bmi, ageInYearMonth, gender);
        
        tfHeightSquared.setText(heightSquared);
        tfBmi.setText(bmi);
        tfAge.setText(ageInYearMonth);
        tfHeightForAge.setText(hfa);
        tfBmiForAge.setText(nutritionalStatus);
        
        clearBmiFields(false, true, true);
    }//GEN-LAST:event_btnEvaluateActionPerformed

    private void btnEvaluateTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEvaluateTestActionPerformed
        String dateConducted = "";
        String dateOfBirth = "";
        String weight = tfTestWeight.getText().trim();
        String height = tfTestHeight.getText().trim();
        String heightSquared = "";
        String bmi = "";
        int gender = jcbTestGender.getSelectedIndex();
        
        try {
            dateConducted = my.jCalendarToNumberDate(jdcTestDateOfMeasurement.getDate().toString(), false);
            dateOfBirth = my.jCalendarToNumberDate(jdcTestDateOfBirt.getDate().toString(), false);
        } catch (Exception e) {
             Toolkit.getDefaultToolkit().beep();
            my.showMessage("Invalid Date.", JOptionPane.WARNING_MESSAGE);return;}
        try {
        //    Integer.parseInt(weight);
            Float.parseFloat(height);
            boolean heightVal= Pattern.matches("^([0])(\\.[6-9])(\\d{0,3})$|^([1-3])(\\.)(\\d{0,4})$|^[1-3?]$", height);
            //range 0.6000 - 3.9999 meters
            if (!heightVal) {
            Toolkit.getDefaultToolkit().beep();
            my.showMessage("Invalid Height: 1 feet = 0.3048 meters", JOptionPane.WARNING_MESSAGE);return;
            }
            boolean weightVal =Pattern.matches("^[1-9](\\.\\d{1,2}){0,3}$|^[0-9]{2}(\\.\\d{1,2}){0,3}$|^[1-4][0-9]{2}(\\.\\d{1,2}){0,3}$", weight); 
            //range 1- 599.99 kg
            if (!weightVal) {
            Toolkit.getDefaultToolkit().beep();
            my.showMessage("Invalid Weight", JOptionPane.WARNING_MESSAGE);return;
            }    
        } catch (Exception e) {
             Toolkit.getDefaultToolkit().beep();
            my.showMessage("Invalid Weight/Height.", JOptionPane.WARNING_MESSAGE);return;}
        
        heightSquared = my.getHeightSquared(height);
        bmi = my.getBmi(weight, heightSquared);
        String ageInYearMonth = my.getAgeInYearsMonths(dateConducted, dateOfBirth);
        String hfa = my.getHeightForAge(height, ageInYearMonth, gender==0?"Male":"Female", false);
        String nutritionalStatus = my.getNutritionalStatus(bmi, ageInYearMonth, gender==0?"Male":"Female");
        
        tfTestHeightSq.setText(heightSquared);
        tfTestBmi.setText(bmi);
        tfTestAge.setText(ageInYearMonth);
        lbHeightForAge.setText(hfa);
        lbNutritionalStatus.setText(nutritionalStatus);
        
        //Search for age in Table OPTIONAL
        hfaChartMaleTable.clearSelection();
        hfaChartFemaleTable.clearSelection();
        bmiChartMaleTable.clearSelection();
        bmiChartFemaleTable.clearSelection();
        if(gender == 0){
            if(hfaChartMaleTable.getRowCount() > 0){
                for(int n=0;n<hfaChartMaleTable.getRowCount();n++){
                    String currentAge = hfaChartMaleTable.getValueAt(n, 1).toString();
                    if(currentAge.equals(ageInYearMonth)){
                        my.showSelectedRow(hfaChartMaleTable, n);
                        my.showSelectedItemInsideScrollPane(jLabel2,jScrollPane7,10);
                        hfaChartMaleTable.setRowSelectionInterval(n, n);
                    }
                }
            }
            if(bmiChartMaleTable.getRowCount() > 0){
                for(int n=0;n<bmiChartMaleTable.getRowCount();n++){
                    String currentAge = bmiChartMaleTable.getValueAt(n, 1).toString();
                    if(currentAge.equals(ageInYearMonth)){
                        my.showSelectedRow(bmiChartMaleTable, n);
                        my.showSelectedItemInsideScrollPane(jLabel1,jScrollPane9,10);
                        bmiChartMaleTable.setRowSelectionInterval(n, n);
                    }
                }
            }
        }else{
            if(hfaChartFemaleTable.getRowCount() > 0){
                for(int n=0;n<hfaChartFemaleTable.getRowCount();n++){
                    String currentAge = hfaChartFemaleTable.getValueAt(n, 1).toString();
                    if(currentAge.equals(ageInYearMonth)){
                        my.showSelectedRow(hfaChartFemaleTable, n);
                        my.showSelectedItemInsideScrollPane(jLabel3,jScrollPane7,0);
                        hfaChartFemaleTable.setRowSelectionInterval(n, n);
                    }
                }
            }
            if(bmiChartFemaleTable.getRowCount() > 0){
                for(int n=0;n<bmiChartFemaleTable.getRowCount();n++){
                    String currentAge = bmiChartFemaleTable.getValueAt(n, 1).toString();
                    if(currentAge.equals(ageInYearMonth)){
                        my.showSelectedRow(bmiChartFemaleTable, n);
                        my.showSelectedItemInsideScrollPane(jLabel28,jScrollPane9,0);
                        bmiChartFemaleTable.setRowSelectionInterval(n, n);
                    }
                }
            }
        }
    }//GEN-LAST:event_btnEvaluateTestActionPerformed

    private void btnRefreshHfaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshHfaActionPerformed
        refreshHfaChart();
    }//GEN-LAST:event_btnRefreshHfaActionPerformed

    private void btnRefreshBmiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshBmiActionPerformed
        refreshBmiChart();
    }//GEN-LAST:event_btnRefreshBmiActionPerformed

    private void btnMyManagedSubjectsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMyManagedSubjectsActionPerformed
        showCustomDialog("Reference Charts", referenceChartsDialog, true, 800, 660,true);
    }//GEN-LAST:event_btnMyManagedSubjectsActionPerformed

    private void jcbSchoolYear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbSchoolYear1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbSchoolYear1ActionPerformed

    private void btnPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPanelMouseEntered
//        btnPanel.setBackground (new java.awt.Color(253,232,240));
    }//GEN-LAST:event_btnPanelMouseEntered

    private void btnPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPanelMousePressed
//        btnPanel.setBackground(Color.gray);
    }//GEN-LAST:event_btnPanelMousePressed

    private void btnPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPanelMouseExited
//         btnPanel.setBackground (new java.awt.Color(251,185,211));
    }//GEN-LAST:event_btnPanelMouseExited

    private void btnPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPanelMouseClicked
      //how to refresh();
    }//GEN-LAST:event_btnPanelMouseClicked

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
        ImageIcon ic = my.getImgIcn(myVariables.getMsgUrlIconWarning());
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to end your current session ?","Confirm",dialogButton,JOptionPane.WARNING_MESSAGE,ic);

        if(dialogResult == JOptionPane.YES_OPTION){
            this.setVisible(false);
            new login().setVisible(true);
        }
    }//GEN-LAST:event_logoutActionPerformed

    private void tfstrandM6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfstrandM6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfstrandM6ActionPerformed

    private void tfHeightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfHeightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfHeightActionPerformed

    private void tfWeightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfWeightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfWeightActionPerformed

    private void tfTestHeightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTestHeightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTestHeightActionPerformed
    private void clearBmiFields(boolean clearFields,boolean enableDisableEvaluateBtn,boolean enableDisableSaveBtn){
        if(clearFields){
            lbBmiRecordId.setText("--Please Select A Student--");
            tfAge.setText("");

            tfWeight.setText("");
            tfHeight.setText("");
            tfHeightSquared.setText("");

            tfBmi.setText("");
            tfBmiForAge.setText("--Please Select A Student--");
            tfHeightForAge.setText("--Please Select A Student--");
        }
        btnEvaluate.setEnabled(enableDisableEvaluateBtn);
        btnSaveEvaluationChanges.setEnabled(enableDisableSaveBtn);
    }
    private void refreshBmiChart(){
        String [] result = my.return_values("*", "bmichart_male", "", myVariables.getBmiChartOrder());
        String [] result2 = my.return_values("*", "bmichart_female", "", myVariables.getBmiChartOrder());
        
        my.clear_table_rows(bmiChartMaleTable);
        my.clear_table_rows(bmiChartFemaleTable);
        
        if(result != null){
            for(String n: result){
                my.add_table_row(n+"Above@@", bmiChartMaleTable);
            }
        }if(result2 != null){
            for(String n: result2){
                my.add_table_row(n+"Above@@", bmiChartFemaleTable);
            }
        }
    }
    private void refreshHfaChart(){
        String [] result = my.return_values("*", "hfachart_male", "", myVariables.getHfaChartOrder());
        String [] result2 = my.return_values("*", "hfachart_female", "", myVariables.getHfaChartOrder());
        
        my.clear_table_rows(hfaChartMaleTable);
        my.clear_table_rows(hfaChartFemaleTable);
        
        if(result != null){
            for(String n: result){
                my.add_table_row(n, hfaChartMaleTable);
            }
        }if(result2 != null){
            for(String n: result2){
                my.add_table_row(n, hfaChartFemaleTable);
            }
        }
    }
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dashBoard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable assignedTeacherTable;
    private javax.swing.JTable bmiChartFemaleTable;
    private javax.swing.JTable bmiChartMaleTable;
    private javax.swing.JButton btnEvaluate;
    private javax.swing.JButton btnEvaluateTest;
    private javax.swing.JButton btnMyManagedSubjects;
    private javax.swing.JPanel btnPanel;
    private javax.swing.JButton btnRefreshBmi;
    private javax.swing.JButton btnRefreshHfa;
    private javax.swing.JButton btnSaveEvaluationChanges;
    private javax.swing.JButton btnSearchEnrolledStudent;
    private javax.swing.JButton btnSearchSection;
    private javax.swing.JTable enrolledStudentsTable;
    private javax.swing.JTable hfaChartFemaleTable;
    private javax.swing.JTable hfaChartMaleTable;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
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
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JComboBox<String> jcbSchoolYear1;
    private javax.swing.JComboBox<String> jcbTestGender;
    private com.toedter.calendar.JDateChooser jdcDateOfMeasurement;
    private com.toedter.calendar.JDateChooser jdcTestDateOfBirt;
    private com.toedter.calendar.JDateChooser jdcTestDateOfMeasurement;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lbBmiRecordId;
    private javax.swing.JLabel lbHeightForAge;
    private javax.swing.JLabel lbLoggedInUser;
    private javax.swing.JLabel lbLoggedInUserLevel;
    private javax.swing.JLabel lbNutritionalStatus;
    private javax.swing.JLabel lbSearchResult;
    private javax.swing.JLabel lbSearchResult1;
    private javax.swing.JLabel lbuserwelcome;
    private javax.swing.JPanel left;
    private javax.swing.JPanel left1;
    private javax.swing.JMenuItem logout;
    private javax.swing.JTabbedPane mainTab;
    private javax.swing.JMenu menu;
    private javax.swing.JPanel referenceChartsDialog;
    private javax.swing.JPanel right;
    private javax.swing.JPanel right1;
    private javax.swing.JPanel selectSectionTab;
    private javax.swing.JComboBox<String> semesterSelectM6;
    private javax.swing.JPanel tab1;
    private javax.swing.JTextField tfAge;
    private javax.swing.JTextField tfBmi;
    private javax.swing.JTextField tfBmiForAge;
    private javax.swing.JTextField tfHeight;
    private javax.swing.JTextField tfHeightForAge;
    private javax.swing.JTextField tfHeightSquared;
    private javax.swing.JTextField tfSearchEnrolledStudent;
    private javax.swing.JTextField tfSearchTeacherLoad;
    private javax.swing.JTextField tfTestAge;
    private javax.swing.JTextField tfTestBmi;
    private javax.swing.JTextField tfTestHeight;
    private javax.swing.JTextField tfTestHeightSq;
    private javax.swing.JTextField tfTestWeight;
    private javax.swing.JTextField tfWeight;
    private javax.swing.JTextField tfstrandM6;
    private javax.swing.JPanel viewStudentsTab;
    // End of variables declaration//GEN-END:variables
}
