/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mahPackage7;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javazoom.jl.player.Player;
import javax.swing.SwingUtilities;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.ImageIcon;

/**
 *
 * @author Phil Rey Paderogao
 */
public class dashBoard extends javax.swing.JFrame {
    myFunctions my;
    JPanel formsPanels [];
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
        formsPanels = new JPanel[]{
            selectFormPanel,
            selectSectionTab,
            sf1Tab,
            sf2Sf4Tab,
            sf3Tab,
            sf5Sf6Tab,
            sf7Tab,
            sf8Tab,
            sf9Tab,
            sf10Tab,
        };
        
        //lbLoggedInUser.setText("Welcome "+myVariables.getUserLoggedInName()+" ("+myVariables.getAccessLevelName(-1)+")");
        
        loadTabs();
        loadTabIcons();
        
        loadColoredButtons();
        loadLabels();
        
        loadTextFields();
        sortTables();
        
        setScrollSpeeds();
        loadYearDropDowns(12);
        
        //lbSchoolName.setText(myVariables.getSchoolName() + " Forms System");
        //lbSchoolAddress.setText(myVariables.getSchoolAddress());
        
        setLoadingVariables();
        loadInstructions();
        loadSchoolFormTabs();
        
        
        
        
    }
    public void myInitComponents() {
    
    //dle muandar unsaun mani pag color .
        selectSectionTab.setBackground(new java.awt.Color(203,184,160));  //tabforselectingsection
        
        mainTab.setBackground(new java.awt.Color(203,184,160)); 
        mainTab.setForeground(new java.awt.Color(0,0,0));
        btnSearchSection.setBackground(new java.awt.Color(251,185,211));
        
        
        jLabel119.setFont(poppins48);
        jLabel118.setFont(poppins19);
//        label1.setFont(poppins14);
    
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
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        selectFormPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        defaultInstructionPanel1 = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        jLabel120 = new javax.swing.JLabel();
        jScrollPane49 = new javax.swing.JScrollPane();
        jTextArea10 = new javax.swing.JTextArea();
        selectSectionTab = new javax.swing.JPanel();
        jSplitPane4 = new javax.swing.JSplitPane();
        left3 = new javax.swing.JPanel();
        lbSearchResult = new javax.swing.JLabel();
        tfSearchTeacherLoad = new javax.swing.JTextField();
        btnSearchSection = new javax.swing.JButton();
        jcbSchoolYear1 = new javax.swing.JComboBox<>();
        jScrollPane8 = new javax.swing.JScrollPane();
        assignedTeacherTable = new javax.swing.JTable();
        tpSelectSectionInstructions = new javax.swing.JTabbedPane();
        defaultInstructionPanel = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jLabel110 = new javax.swing.JLabel();
        jScrollPane42 = new javax.swing.JScrollPane();
        jTextArea5 = new javax.swing.JTextArea();
        sf1InstructionPanel = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        jLabel111 = new javax.swing.JLabel();
        jScrollPane43 = new javax.swing.JScrollPane();
        jTextArea6 = new javax.swing.JTextArea();
        sf2InstructionsPanel = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        sf3InstructionsPanel = new javax.swing.JPanel();
        jPanel34 = new javax.swing.JPanel();
        jLabel112 = new javax.swing.JLabel();
        jScrollPane46 = new javax.swing.JScrollPane();
        jTextArea7 = new javax.swing.JTextArea();
        sf4InstructionsPanel = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        btnOnlySelectedSections = new javax.swing.JButton();
        btnSelectAllSections = new javax.swing.JButton();
        sf5InstructionsPanel = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jScrollPane23 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        sf6InstructionsPanel = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jScrollPane24 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        btnOnlySelectedSections1 = new javax.swing.JButton();
        btnSelectAllSections1 = new javax.swing.JButton();
        sf8InstructionPanel = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        jLabel113 = new javax.swing.JLabel();
        jScrollPane47 = new javax.swing.JScrollPane();
        jTextArea8 = new javax.swing.JTextArea();
        sf9InstructionPanel = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        jLabel114 = new javax.swing.JLabel();
        jScrollPane48 = new javax.swing.JScrollPane();
        jTextArea9 = new javax.swing.JTextArea();
        sf1Tab = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        left1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        sf1StudentsTable = new javax.swing.JTable();
        right1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfSectionName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfAdviserName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfGradeLevel = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfSchoolYear = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jdcFirstDayOfFridate = new com.toedter.calendar.JDateChooser();
        btnLoadStudents = new javax.swing.JButton();
        btnExportSf1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        tfMaleCount = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tfFemaleCount = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        tfTotalCount = new javax.swing.JTextField();
        semesterSelect = new javax.swing.JComboBox<>();
        jLabel101 = new javax.swing.JLabel();
        sf2Sf4Tab = new javax.swing.JPanel();
        jSplitPane2 = new javax.swing.JSplitPane();
        left2 = new javax.swing.JPanel();
        tpSf2Sf4TabbedPane = new javax.swing.JTabbedPane();
        sf2Tab = new javax.swing.JPanel();
        jSplitPane3 = new javax.swing.JSplitPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        weekDaysOfTheMonthTable = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        sf2Table = new javax.swing.JTable();
        sf4Tab = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        sf4Table = new javax.swing.JTable();
        right2 = new javax.swing.JPanel();
        tpSf2Sf4DetailsPane = new javax.swing.JTabbedPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        tfSectionName1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        tfAdviserName1 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        tfGradeLevel1 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        tfSchoolYear1 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jdcFirstDayOfMonth = new com.toedter.calendar.JDateChooser();
        btnLoadStudents1 = new javax.swing.JButton();
        btnExportSf2 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        summarySf2 = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        jdcCutOffDate = new com.toedter.calendar.JDateChooser();
        jLabel22 = new javax.swing.JLabel();
        tfSchoolDays = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jcbMissingValues = new javax.swing.JComboBox<>();
        jScrollPane9 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jdcFirstDayOfMonth1 = new com.toedter.calendar.JDateChooser();
        jcbMissingValues1 = new javax.swing.JComboBox<>();
        btnLoadStudents2 = new javax.swing.JButton();
        btnExportSf4 = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        jdcCutOffDate1 = new com.toedter.calendar.JDateChooser();
        tfSchoolYear7 = new javax.swing.JTextField();
        jLabel106 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        sf3Tab = new javax.swing.JPanel();
        jSplitPane5 = new javax.swing.JSplitPane();
        jScrollPane14 = new javax.swing.JScrollPane();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        sf3BooksTable = new javax.swing.JTable();
        btnLoadStudents3 = new javax.swing.JButton();
        btnExportSf3 = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        tfSchoolYear2 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        tfSectionName2 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        tfAdviserName2 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        tfGradeLevel2 = new javax.swing.JTextField();
        jcbMissingValues2 = new javax.swing.JComboBox<>();
        jLabel40 = new javax.swing.JLabel();
        jcbMissingValues3 = new javax.swing.JComboBox<>();
        jLabel105 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        semesterSelect1 = new javax.swing.JComboBox<>();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        sf3Table = new javax.swing.JTable();
        sf5Sf6Tab = new javax.swing.JPanel();
        jSplitPane6 = new javax.swing.JSplitPane();
        left = new javax.swing.JPanel();
        tpSf5Sf6Pane = new javax.swing.JTabbedPane();
        jScrollPane16 = new javax.swing.JScrollPane();
        sf5Table = new javax.swing.JTable();
        jScrollPane17 = new javax.swing.JScrollPane();
        sf6Table = new javax.swing.JTable();
        right = new javax.swing.JPanel();
        tpSf5Sf6DetailsPane = new javax.swing.JTabbedPane();
        jScrollPane18 = new javax.swing.JScrollPane();
        jPanel13 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jScrollPane20 = new javax.swing.JScrollPane();
        sf5SummaryTable = new javax.swing.JTable();
        jScrollPane21 = new javax.swing.JScrollPane();
        sf5LevelOfProgress = new javax.swing.JTable();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        btnExportSf5 = new javax.swing.JButton();
        btnLoadStudents4 = new javax.swing.JButton();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        tfSectionName3 = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        tfAdviserName3 = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        tfGradeLevel3 = new javax.swing.JTextField();
        tfSchoolYear3 = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        cbShowIncompleteStudents = new javax.swing.JCheckBox();
        cbCompareToRankings = new javax.swing.JCheckBox();
        jLabel109 = new javax.swing.JLabel();
        tfCurriculum = new javax.swing.JTextField();
        semesterSelect5 = new javax.swing.JComboBox<>();
        tfStrand5 = new javax.swing.JTextField();
        jScrollPane19 = new javax.swing.JScrollPane();
        jPanel14 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        cbShowIncompleteStudents1 = new javax.swing.JCheckBox();
        btnLoadStudents5 = new javax.swing.JButton();
        btnExportSf6 = new javax.swing.JButton();
        jLabel55 = new javax.swing.JLabel();
        tfSchoolYear4 = new javax.swing.JTextField();
        sf7Tab = new javax.swing.JPanel();
        jSplitPane10 = new javax.swing.JSplitPane();
        spLeft = new javax.swing.JSplitPane();
        jScrollPane44 = new javax.swing.JScrollPane();
        sf7TeachersTable = new javax.swing.JTable();
        jScrollPane45 = new javax.swing.JScrollPane();
        sf7AssignedSubjectsTable = new javax.swing.JTable();
        jspRight = new javax.swing.JScrollPane();
        jPanel31 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        jLabel96 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        btnLoadTeacher = new javax.swing.JButton();
        btnExportSf7 = new javax.swing.JButton();
        jcbSchoolYear2 = new javax.swing.JComboBox<>();
        jLabel102 = new javax.swing.JLabel();
        cbRemoveTeachersWNoSubjects = new javax.swing.JCheckBox();
        cbUseCodeAsName = new javax.swing.JCheckBox();
        cbUseAcronyms = new javax.swing.JCheckBox();
        jLabel98 = new javax.swing.JLabel();
        semesterSelect7 = new javax.swing.JComboBox<>();
        sf8Tab = new javax.swing.JPanel();
        jSplitPane7 = new javax.swing.JSplitPane();
        jScrollPane29 = new javax.swing.JScrollPane();
        jPanel20 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        tfSectionName4 = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        tfAdviserName4 = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        tfGradeLevel4 = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        tfSchoolYear5 = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        btnLoadStudents6 = new javax.swing.JButton();
        btnExportSf8 = new javax.swing.JButton();
        jScrollPane30 = new javax.swing.JScrollPane();
        sf8SummaryTable = new javax.swing.JTable();
        jLabel63 = new javax.swing.JLabel();
        cbShowIncompleteStudents2 = new javax.swing.JCheckBox();
        jLabel115 = new javax.swing.JLabel();
        tfDateOfMeasurement = new javax.swing.JTextField();
        cbUseFirstStudentForDate = new javax.swing.JCheckBox();
        jLabel123 = new javax.swing.JLabel();
        tfStrand8 = new javax.swing.JTextField();
        jLabel97 = new javax.swing.JLabel();
        semesterSelect8 = new javax.swing.JComboBox<>();
        jPanel22 = new javax.swing.JPanel();
        jScrollPane25 = new javax.swing.JScrollPane();
        sf8Table = new javax.swing.JTable();
        sf9Tab = new javax.swing.JPanel();
        jSplitPane8 = new javax.swing.JSplitPane();
        left4 = new javax.swing.JPanel();
        lbSearchResult1 = new javax.swing.JLabel();
        tfSearchEnrolledStudent = new javax.swing.JTextField();
        btnSearchEnrolledStudent = new javax.swing.JButton();
        jScrollPane31 = new javax.swing.JScrollPane();
        enrolledStudentsTable = new javax.swing.JTable();
        jScrollPane32 = new javax.swing.JScrollPane();
        jPanel23 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jScrollPane33 = new javax.swing.JScrollPane();
        gradesTable = new javax.swing.JTable();
        btnLoadGrades = new javax.swing.JButton();
        jLabel66 = new javax.swing.JLabel();
        tfGeneralAverage = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        lbFinalGradeId = new javax.swing.JLabel();
        btnExportSf9 = new javax.swing.JButton();
        jLabel69 = new javax.swing.JLabel();
        tfFailedSubjects = new javax.swing.JTextField();
        tfEvaluation = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        tfSectionName5 = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        tfAdviserName5 = new javax.swing.JTextField();
        jLabel73 = new javax.swing.JLabel();
        tfGradeLevel5 = new javax.swing.JTextField();
        tfSchoolYear6 = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jdcDateOfExport = new com.toedter.calendar.JDateChooser();
        sf10Tab = new javax.swing.JPanel();
        tpSf10Pane = new javax.swing.JTabbedPane();
        jPanel25 = new javax.swing.JPanel();
        lbSearchResult2 = new javax.swing.JLabel();
        jScrollPane35 = new javax.swing.JScrollPane();
        enrolledStudentsTable1 = new javax.swing.JTable();
        tfSearchEnrolledStudent1 = new javax.swing.JTextField();
        btnSearchEnrolledStudent1 = new javax.swing.JButton();
        jPanel26 = new javax.swing.JPanel();
        jScrollPane36 = new javax.swing.JScrollPane();
        sf10Table = new javax.swing.JTable();
        btnUseSelectedSections = new javax.swing.JButton();
        jLabel75 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        jSplitPane9 = new javax.swing.JSplitPane();
        tpSf10DetailsTab = new javax.swing.JTabbedPane();
        sectionPanel1 = new javax.swing.JPanel();
        jScrollPane34 = new javax.swing.JScrollPane();
        gradesTable1 = new javax.swing.JTable();
        tfGeneralAverage1 = new javax.swing.JTextField();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        tfEvaluation1 = new javax.swing.JTextField();
        sectionPanel2 = new javax.swing.JPanel();
        jScrollPane38 = new javax.swing.JScrollPane();
        gradesTable2 = new javax.swing.JTable();
        jLabel94 = new javax.swing.JLabel();
        tfGeneralAverage2 = new javax.swing.JTextField();
        tfEvaluation2 = new javax.swing.JTextField();
        jLabel95 = new javax.swing.JLabel();
        jScrollPane37 = new javax.swing.JScrollPane();
        jPanel28 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        tfFirstName = new javax.swing.JTextField();
        jLabel79 = new javax.swing.JLabel();
        tfMiddleName = new javax.swing.JTextField();
        jLabel80 = new javax.swing.JLabel();
        tfLastName = new javax.swing.JTextField();
        jLabel81 = new javax.swing.JLabel();
        tfExtentionName = new javax.swing.JTextField();
        jLabel82 = new javax.swing.JLabel();
        tfBirthdate = new javax.swing.JTextField();
        jLabel83 = new javax.swing.JLabel();
        tfLrn = new javax.swing.JTextField();
        jLabel84 = new javax.swing.JLabel();
        tfGender = new javax.swing.JTextField();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        tfSchoolName = new javax.swing.JTextField();
        jLabel87 = new javax.swing.JLabel();
        tfSchoolAddress = new javax.swing.JTextField();
        jLabel88 = new javax.swing.JLabel();
        tfSchoolId = new javax.swing.JTextField();
        jLabel89 = new javax.swing.JLabel();
        tfInitialGrade = new javax.swing.JTextField();
        btnExportSf10 = new javax.swing.JButton();
        jLabel90 = new javax.swing.JLabel();
        tfStrand = new javax.swing.JTextField();
        jLabel122 = new javax.swing.JLabel();
        loadingDialog = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jpbProgressBar = new javax.swing.JProgressBar();
        lbLoadingMessage = new javax.swing.JLabel();
        btnCancelLoading = new javax.swing.JButton();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        headerPanel = new javax.swing.JPanel();
        jLabel117 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        btnShowRankings = new javax.swing.JButton();
        jLabel121 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        contentPanel = new javax.swing.JPanel();
        cards = new javax.swing.JPanel();
        card1 = new javax.swing.JPanel();
        mainTab = new javax.swing.JTabbedPane();
        card2 = new javax.swing.JPanel();
        rankingsDialog = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        tpRankingsTab = new javax.swing.JTabbedPane();
        jScrollPane22 = new javax.swing.JScrollPane();
        grade11RankingTable = new javax.swing.JTable();
        jScrollPane26 = new javax.swing.JScrollPane();
        grade12RankingTable = new javax.swing.JTable();
        btnRefreshRankings = new javax.swing.JButton();
        jcbRankingSchoolYear = new javax.swing.JComboBox<>();
        jcbRankingNumberOfStudents = new javax.swing.JComboBox<>();
        jcbRankingStrand = new javax.swing.JComboBox<>();
        jcbRankingSemester = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu = new javax.swing.JMenu();
        logout = new javax.swing.JMenuItem();

        selectFormPanel.setBackground(new java.awt.Color(11, 102, 35));

        jScrollPane1.setBorder(null);

        jPanel1.setBackground(new java.awt.Color(11, 102, 35));

        defaultInstructionPanel1.setBackground(new java.awt.Color(249, 239, 227));

        jPanel37.setBackground(new java.awt.Color(203, 184, 160));

        jLabel120.setFont(new java.awt.Font("Poppins SemiBold", 0, 18)); // NOI18N
        jLabel120.setText("Select A Form First");

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel120)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel37Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel120)
                .addContainerGap())
        );

        jTextArea10.setEditable(false);
        jTextArea10.setColumns(20);
        jTextArea10.setFont(myVariables.TEXTFIELD_FONT);
        jTextArea10.setLineWrap(true);
        jTextArea10.setRows(5);
        jTextArea10.setText("1. Select a Form to use from the \"Side Panel\".\n\n2. Depending on the form, a different set of instructions will be displayed in the left section.\n\nNOTE: You can hover over the forms on the \"Side Panel\" to know what the corresponding form is about.");
        jTextArea10.setWrapStyleWord(true);
        jScrollPane49.setViewportView(jTextArea10);

        javax.swing.GroupLayout defaultInstructionPanel1Layout = new javax.swing.GroupLayout(defaultInstructionPanel1);
        defaultInstructionPanel1.setLayout(defaultInstructionPanel1Layout);
        defaultInstructionPanel1Layout.setHorizontalGroup(
            defaultInstructionPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(defaultInstructionPanel1Layout.createSequentialGroup()
                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(defaultInstructionPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane49, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
                .addContainerGap())
        );
        defaultInstructionPanel1Layout.setVerticalGroup(
            defaultInstructionPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(defaultInstructionPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane49, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 549, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(defaultInstructionPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 508, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(defaultInstructionPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout selectFormPanelLayout = new javax.swing.GroupLayout(selectFormPanel);
        selectFormPanel.setLayout(selectFormPanelLayout);
        selectFormPanelLayout.setHorizontalGroup(
            selectFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        selectFormPanelLayout.setVerticalGroup(
            selectFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        selectSectionTab.setBackground(new java.awt.Color(203, 184, 160));
        selectSectionTab.setForeground(new java.awt.Color(255, 255, 255));

        jSplitPane4.setBackground(new java.awt.Color(249, 239, 227));
        jSplitPane4.setBorder(null);
        jSplitPane4.setDividerLocation(700);

        left3.setBackground(new java.awt.Color(249, 239, 227));

        lbSearchResult.setForeground(new java.awt.Color(255, 255, 255));
        lbSearchResult.setText("Search using the search bar...");

        tfSearchTeacherLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSearchTeacherLoadsearchSectionHandler(evt);
            }
        });

        btnSearchSection.setBackground(new java.awt.Color(232, 219, 203));
        btnSearchSection.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/search_24px.png"))); // NOI18N
        btnSearchSection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchSectionsearchSectionHandler(evt);
            }
        });

        jcbSchoolYear1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2019", "2020" }));

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
                "ID", "Section ID", "Section Name", "Adv ID", "Name", "Gender", "Subject ID", "Code", "Description", "Grade", "School Year", "Template ID", "Template Name", "Books Contained"
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
        if (assignedTeacherTable.getColumnModel().getColumnCount() > 0) {
            assignedTeacherTable.getColumnModel().getColumn(2).setPreferredWidth(150);
            assignedTeacherTable.getColumnModel().getColumn(4).setPreferredWidth(150);
            assignedTeacherTable.getColumnModel().getColumn(5).setPreferredWidth(50);
            assignedTeacherTable.getColumnModel().getColumn(7).setPreferredWidth(50);
            assignedTeacherTable.getColumnModel().getColumn(8).setPreferredWidth(70);
            assignedTeacherTable.getColumnModel().getColumn(9).setPreferredWidth(50);
            assignedTeacherTable.getColumnModel().getColumn(10).setPreferredWidth(70);
        }

        javax.swing.GroupLayout left3Layout = new javax.swing.GroupLayout(left3);
        left3.setLayout(left3Layout);
        left3Layout.setHorizontalGroup(
            left3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(left3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(left3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8)
                    .addGroup(left3Layout.createSequentialGroup()
                        .addComponent(lbSearchResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbSchoolYear1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfSearchTeacherLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearchSection)))
                .addContainerGap())
        );
        left3Layout.setVerticalGroup(
            left3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(left3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(left3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(left3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbSearchResult)
                        .addComponent(btnSearchSection))
                    .addComponent(tfSearchTeacherLoad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbSchoolYear1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane4.setLeftComponent(left3);

        tpSelectSectionInstructions.setBackground(new java.awt.Color(249, 239, 227));

        defaultInstructionPanel.setBackground(new java.awt.Color(249, 239, 227));

        jPanel30.setBackground(new java.awt.Color(22, 66, 33));

        jLabel110.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel110.setForeground(new java.awt.Color(255, 255, 255));
        jLabel110.setText("Select A Form First");

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel110)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel110)
                .addContainerGap())
        );

        jTextArea5.setEditable(false);
        jTextArea5.setColumns(20);
        jTextArea5.setFont(myVariables.TEXTFIELD_FONT);
        jTextArea5.setLineWrap(true);
        jTextArea5.setRows(5);
        jTextArea5.setText("1. Select a Form to use from the \"Select Form\" tab.\n\n2. Depending on the form, a different set of instructions will be displayed here.");
        jTextArea5.setWrapStyleWord(true);
        jScrollPane42.setViewportView(jTextArea5);

        javax.swing.GroupLayout defaultInstructionPanelLayout = new javax.swing.GroupLayout(defaultInstructionPanel);
        defaultInstructionPanel.setLayout(defaultInstructionPanelLayout);
        defaultInstructionPanelLayout.setHorizontalGroup(
            defaultInstructionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(defaultInstructionPanelLayout.createSequentialGroup()
                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(defaultInstructionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane42, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        defaultInstructionPanelLayout.setVerticalGroup(
            defaultInstructionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(defaultInstructionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane42, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                .addContainerGap())
        );

        tpSelectSectionInstructions.addTab("Instructions", defaultInstructionPanel);

        sf1InstructionPanel.setBackground(new java.awt.Color(249, 239, 227));

        jPanel33.setBackground(new java.awt.Color(203, 184, 160));

        jLabel111.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel111.setForeground(new java.awt.Color(255, 255, 255));
        jLabel111.setText("SF1 Instructions");

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel111)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel33Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel111)
                .addContainerGap())
        );

        jTextArea6.setEditable(false);
        jTextArea6.setColumns(20);
        jTextArea6.setFont(myVariables.TEXTFIELD_FONT);
        jTextArea6.setLineWrap(true);
        jTextArea6.setRows(5);
        jTextArea6.setText("1. Select a Section to use.\n\n2. Select the First Friday of June to accurately calculate each student's age.\n\n3. Load students & Export.");
        jTextArea6.setWrapStyleWord(true);
        jScrollPane43.setViewportView(jTextArea6);

        javax.swing.GroupLayout sf1InstructionPanelLayout = new javax.swing.GroupLayout(sf1InstructionPanel);
        sf1InstructionPanel.setLayout(sf1InstructionPanelLayout);
        sf1InstructionPanelLayout.setHorizontalGroup(
            sf1InstructionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sf1InstructionPanelLayout.createSequentialGroup()
                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(sf1InstructionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane43, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        sf1InstructionPanelLayout.setVerticalGroup(
            sf1InstructionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sf1InstructionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane43, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                .addContainerGap())
        );

        tpSelectSectionInstructions.addTab("Sf1 Instructions", sf1InstructionPanel);

        sf2InstructionsPanel.setBackground(new java.awt.Color(249, 239, 227));

        jPanel8.setBackground(new java.awt.Color(203, 184, 160));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("SF2 Instructions");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel26)
                .addContainerGap())
        );

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(myVariables.TEXTFIELD_FONT);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("1. Select a section to use.\n\n2. Select the desired Month.\nSelect the first day of the Month Selected.\n(Important)\n\n3. Select what to fill-up missing attendances with.\n(Applies to Transferred in Students)\n\n4. Load and Export Students.");
        jTextArea1.setWrapStyleWord(true);
        jScrollPane10.setViewportView(jTextArea1);

        javax.swing.GroupLayout sf2InstructionsPanelLayout = new javax.swing.GroupLayout(sf2InstructionsPanel);
        sf2InstructionsPanel.setLayout(sf2InstructionsPanelLayout);
        sf2InstructionsPanelLayout.setHorizontalGroup(
            sf2InstructionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sf2InstructionsPanelLayout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(sf2InstructionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        sf2InstructionsPanelLayout.setVerticalGroup(
            sf2InstructionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sf2InstructionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                .addContainerGap())
        );

        tpSelectSectionInstructions.addTab("Sf2 Instructions", sf2InstructionsPanel);

        sf3InstructionsPanel.setBackground(new java.awt.Color(249, 239, 227));

        jPanel34.setBackground(new java.awt.Color(203, 184, 160));

        jLabel112.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel112.setForeground(new java.awt.Color(255, 255, 255));
        jLabel112.setText("SF3 Instructions");

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel112)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel112)
                .addContainerGap())
        );

        jTextArea7.setEditable(false);
        jTextArea7.setColumns(20);
        jTextArea7.setFont(myVariables.TEXTFIELD_FONT);
        jTextArea7.setLineWrap(true);
        jTextArea7.setRows(5);
        jTextArea7.setText("1. Search for a Section.\n\n2. Select a section to use.\n\n3. Select a value to substitute empty records.. (Optional)\n\n4. Select a value to use on the remarks column. (Optional)\n\n5. Load & Export Students");
        jTextArea7.setWrapStyleWord(true);
        jScrollPane46.setViewportView(jTextArea7);

        javax.swing.GroupLayout sf3InstructionsPanelLayout = new javax.swing.GroupLayout(sf3InstructionsPanel);
        sf3InstructionsPanel.setLayout(sf3InstructionsPanelLayout);
        sf3InstructionsPanelLayout.setHorizontalGroup(
            sf3InstructionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sf3InstructionsPanelLayout.createSequentialGroup()
                .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(sf3InstructionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane46, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        sf3InstructionsPanelLayout.setVerticalGroup(
            sf3InstructionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sf3InstructionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane46, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                .addContainerGap())
        );

        tpSelectSectionInstructions.addTab("Sf3 Instructions", sf3InstructionsPanel);

        sf4InstructionsPanel.setBackground(new java.awt.Color(249, 239, 227));

        jPanel11.setBackground(new java.awt.Color(203, 184, 160));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("SF4 Instructions");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel29)
                .addContainerGap())
        );

        jTextArea2.setColumns(20);
        jTextArea2.setFont(myVariables.TEXTFIELD_FONT);
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(5);
        jTextArea2.setText("1. Search for Sections. Choose only one specific School Year to use. (Important)\n\n2. You can choose all of the Sections available by pressing the Select All Button.\n\n3. If you only want a certain number of sections, you can Individually select Sections you want to use, and then press the Only Selected Button.\n\n4. Select the desired Month. Select the first day of the Month Selected. (Important)\n\n5. Select what to fill-up missing attendances with. (Applies to Transferred in Students)\n\n6. Load & Export Students.");
        jTextArea2.setWrapStyleWord(true);
        jScrollPane11.setViewportView(jTextArea2);

        btnOnlySelectedSections.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/icons8_to_do_16px.png"))); // NOI18N
        btnOnlySelectedSections.setText("Only Selected Sections");
        btnOnlySelectedSections.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOnlySelectedSectionsActionPerformed(evt);
            }
        });

        btnSelectAllSections.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/icons8_check_all_16px.png"))); // NOI18N
        btnSelectAllSections.setText("Select All Sections");
        btnSelectAllSections.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectAllSectionsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sf4InstructionsPanelLayout = new javax.swing.GroupLayout(sf4InstructionsPanel);
        sf4InstructionsPanel.setLayout(sf4InstructionsPanelLayout);
        sf4InstructionsPanelLayout.setHorizontalGroup(
            sf4InstructionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sf4InstructionsPanelLayout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(sf4InstructionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sf4InstructionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnOnlySelectedSections, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSelectAllSections, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        sf4InstructionsPanelLayout.setVerticalGroup(
            sf4InstructionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sf4InstructionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOnlySelectedSections)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSelectAllSections)
                .addContainerGap())
        );

        tpSelectSectionInstructions.addTab("Sf4 Instructions", sf4InstructionsPanel);

        sf5InstructionsPanel.setBackground(new java.awt.Color(249, 239, 227));

        jPanel18.setBackground(new java.awt.Color(203, 184, 160));

        jLabel52.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("SF5 Instructions");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel52)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel52)
                .addContainerGap())
        );

        jTextArea3.setEditable(false);
        jTextArea3.setColumns(20);
        jTextArea3.setFont(myVariables.TEXTFIELD_FONT);
        jTextArea3.setLineWrap(true);
        jTextArea3.setRows(5);
        jTextArea3.setText("1. Search for a Section.\n\n2. Select a section to use.\n\n3. Load Student Rankings if you're looking for honor students.\n\n4. Match the school year of both rankings & the section you've selected in order to get accurate results. (Important)");
        jTextArea3.setWrapStyleWord(true);
        jScrollPane23.setViewportView(jTextArea3);

        javax.swing.GroupLayout sf5InstructionsPanelLayout = new javax.swing.GroupLayout(sf5InstructionsPanel);
        sf5InstructionsPanel.setLayout(sf5InstructionsPanelLayout);
        sf5InstructionsPanelLayout.setHorizontalGroup(
            sf5InstructionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sf5InstructionsPanelLayout.createSequentialGroup()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(sf5InstructionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        sf5InstructionsPanelLayout.setVerticalGroup(
            sf5InstructionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sf5InstructionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane23, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                .addContainerGap())
        );

        tpSelectSectionInstructions.addTab("Sf5 Instructions", sf5InstructionsPanel);

        sf6InstructionsPanel.setBackground(new java.awt.Color(249, 239, 227));

        jPanel19.setBackground(new java.awt.Color(203, 184, 160));

        jLabel53.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("SF6 Instructions");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel53)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel53)
                .addContainerGap())
        );

        jTextArea4.setColumns(20);
        jTextArea4.setFont(myVariables.TEXTFIELD_FONT);
        jTextArea4.setLineWrap(true);
        jTextArea4.setRows(5);
        jTextArea4.setText("1. Search for Sections. Choose only one specific School Year to use. (Important)\n\n2. You can choose all of the Sections available by pressing the Select All Button.\n\n3. If you only want a certain number of sections, you can Individually select Sections you want to use, and then press the Only Selected Button.\n\n6. Load & Export Students.\n\nNote:\n     This task might be time cosuming depending on the Number of Students this School has. It is advisable that you take a break, drink coffee or do other important tasks while waiting.");
        jTextArea4.setWrapStyleWord(true);
        jScrollPane24.setViewportView(jTextArea4);

        btnOnlySelectedSections1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/icons8_to_do_16px.png"))); // NOI18N
        btnOnlySelectedSections1.setText("Only Selected Sections");
        btnOnlySelectedSections1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOnlySelectedSections1ActionPerformed(evt);
            }
        });

        btnSelectAllSections1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/icons8_check_all_16px.png"))); // NOI18N
        btnSelectAllSections1.setText("Select All Sections");
        btnSelectAllSections1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectAllSections1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sf6InstructionsPanelLayout = new javax.swing.GroupLayout(sf6InstructionsPanel);
        sf6InstructionsPanel.setLayout(sf6InstructionsPanelLayout);
        sf6InstructionsPanelLayout.setHorizontalGroup(
            sf6InstructionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sf6InstructionsPanelLayout.createSequentialGroup()
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(sf6InstructionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sf6InstructionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnOnlySelectedSections1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSelectAllSections1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        sf6InstructionsPanelLayout.setVerticalGroup(
            sf6InstructionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sf6InstructionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane24, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOnlySelectedSections1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSelectAllSections1)
                .addContainerGap())
        );

        tpSelectSectionInstructions.addTab("Sf6 Instructions", sf6InstructionsPanel);

        sf8InstructionPanel.setBackground(new java.awt.Color(249, 239, 227));

        jPanel35.setBackground(new java.awt.Color(203, 184, 160));

        jLabel113.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel113.setForeground(new java.awt.Color(255, 255, 255));
        jLabel113.setText("SF8 Instructions");

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel113)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel35Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel113)
                .addContainerGap())
        );

        jTextArea8.setEditable(false);
        jTextArea8.setColumns(20);
        jTextArea8.setFont(myVariables.TEXTFIELD_FONT);
        jTextArea8.setLineWrap(true);
        jTextArea8.setRows(5);
        jTextArea8.setText("1. Select a Section to use.\n\n2. Choose whether to show & include Students with no records. (Optional)\n\n3. Load students & Export.");
        jTextArea8.setWrapStyleWord(true);
        jScrollPane47.setViewportView(jTextArea8);

        javax.swing.GroupLayout sf8InstructionPanelLayout = new javax.swing.GroupLayout(sf8InstructionPanel);
        sf8InstructionPanel.setLayout(sf8InstructionPanelLayout);
        sf8InstructionPanelLayout.setHorizontalGroup(
            sf8InstructionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sf8InstructionPanelLayout.createSequentialGroup()
                .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(sf8InstructionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane47, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        sf8InstructionPanelLayout.setVerticalGroup(
            sf8InstructionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sf8InstructionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane47, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                .addContainerGap())
        );

        tpSelectSectionInstructions.addTab("Sf8 Instructions", sf8InstructionPanel);

        sf9InstructionPanel.setBackground(new java.awt.Color(249, 239, 227));

        jPanel36.setBackground(new java.awt.Color(203, 184, 160));

        jLabel114.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel114.setForeground(new java.awt.Color(255, 255, 255));
        jLabel114.setText("SF9 Instructions");

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel114)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel36Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel114)
                .addContainerGap())
        );

        jTextArea9.setEditable(false);
        jTextArea9.setColumns(20);
        jTextArea9.setFont(myVariables.TEXTFIELD_FONT);
        jTextArea9.setLineWrap(true);
        jTextArea9.setRows(5);
        jTextArea9.setText("1. Select a Section to use.\n\n2. Select the First Friday of June to accurately calculate each student's age.\n\n3. Load students & Export.");
        jTextArea9.setWrapStyleWord(true);
        jScrollPane48.setViewportView(jTextArea9);

        javax.swing.GroupLayout sf9InstructionPanelLayout = new javax.swing.GroupLayout(sf9InstructionPanel);
        sf9InstructionPanel.setLayout(sf9InstructionPanelLayout);
        sf9InstructionPanelLayout.setHorizontalGroup(
            sf9InstructionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sf9InstructionPanelLayout.createSequentialGroup()
                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(sf9InstructionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane48, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        sf9InstructionPanelLayout.setVerticalGroup(
            sf9InstructionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sf9InstructionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane48, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                .addContainerGap())
        );

        tpSelectSectionInstructions.addTab("Sf9 Instructions", sf9InstructionPanel);

        jSplitPane4.setRightComponent(tpSelectSectionInstructions);

        javax.swing.GroupLayout selectSectionTabLayout = new javax.swing.GroupLayout(selectSectionTab);
        selectSectionTab.setLayout(selectSectionTabLayout);
        selectSectionTabLayout.setHorizontalGroup(
            selectSectionTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
        );
        selectSectionTabLayout.setVerticalGroup(
            selectSectionTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane4)
        );

        jSplitPane1.setBorder(null);
        jSplitPane1.setDividerLocation(740);
        jSplitPane1.setDividerSize(1);

        left1.setBackground(new java.awt.Color(249, 239, 227));

        sf1StudentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Student ID", "Section ID", "Student LRN", "Name", "Gender", "Birth Date", "Age", "Mother Tongue", "IP (Ethnic Group)", "Religion", "House #/St.", "Barangay", "Municipality", "Province", "Father's Name", "Mother's Name", "Guardian's Name", "Relationship", "Contact Number", "Remarks"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        sf1StudentsTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        sf1StudentsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(sf1StudentsTable);
        if (sf1StudentsTable.getColumnModel().getColumnCount() > 0) {
            sf1StudentsTable.getColumnModel().getColumn(3).setPreferredWidth(100);
            sf1StudentsTable.getColumnModel().getColumn(4).setPreferredWidth(200);
            sf1StudentsTable.getColumnModel().getColumn(5).setPreferredWidth(70);
            sf1StudentsTable.getColumnModel().getColumn(6).setPreferredWidth(100);
            sf1StudentsTable.getColumnModel().getColumn(7).setPreferredWidth(50);
            sf1StudentsTable.getColumnModel().getColumn(8).setPreferredWidth(150);
            sf1StudentsTable.getColumnModel().getColumn(9).setPreferredWidth(120);
            sf1StudentsTable.getColumnModel().getColumn(10).setPreferredWidth(150);
            sf1StudentsTable.getColumnModel().getColumn(11).setPreferredWidth(100);
            sf1StudentsTable.getColumnModel().getColumn(12).setPreferredWidth(100);
            sf1StudentsTable.getColumnModel().getColumn(13).setPreferredWidth(100);
            sf1StudentsTable.getColumnModel().getColumn(14).setPreferredWidth(100);
            sf1StudentsTable.getColumnModel().getColumn(15).setPreferredWidth(150);
            sf1StudentsTable.getColumnModel().getColumn(16).setPreferredWidth(150);
            sf1StudentsTable.getColumnModel().getColumn(17).setPreferredWidth(150);
            sf1StudentsTable.getColumnModel().getColumn(18).setPreferredWidth(100);
            sf1StudentsTable.getColumnModel().getColumn(19).setPreferredWidth(120);
            sf1StudentsTable.getColumnModel().getColumn(20).setPreferredWidth(200);
        }

        javax.swing.GroupLayout left1Layout = new javax.swing.GroupLayout(left1);
        left1.setLayout(left1Layout);
        left1Layout.setHorizontalGroup(
            left1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(left1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
                .addContainerGap())
        );
        left1Layout.setVerticalGroup(
            left1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(left1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane1.setLeftComponent(left1);

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel3.setBackground(new java.awt.Color(249, 239, 227));

        jPanel4.setBackground(new java.awt.Color(203, 184, 160));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Section Details");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Basic");

        jLabel4.setText("Section Name");

        tfSectionName.setEditable(false);

        jLabel5.setText("Adviser Name");

        tfAdviserName.setEditable(false);

        jLabel6.setText("Grade Level");

        tfGradeLevel.setEditable(false);
        tfGradeLevel.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel7.setText("School Year");

        tfSchoolYear.setEditable(false);
        tfSchoolYear.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Export Options");

        jLabel9.setText("First Friday of June Date");

        btnLoadStudents.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/load_16px.png"))); // NOI18N
        btnLoadStudents.setText("Load Students");
        btnLoadStudents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadStudentsActionPerformed(evt);
            }
        });

        btnExportSf1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/xls_export_16px.png"))); // NOI18N
        btnExportSf1.setText("Export");
        btnExportSf1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportSf1ActionPerformed(evt);
            }
        });

        jLabel10.setText("Male");

        tfMaleCount.setEditable(false);
        tfMaleCount.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel11.setText("Female");

        tfFemaleCount.setEditable(false);
        tfFemaleCount.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel12.setText("Total");

        tfTotalCount.setEditable(false);
        tfTotalCount.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        semesterSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st semester", "2nd semester" }));

        jLabel101.setText("Semester");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnExportSf1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfSectionName)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfAdviserName)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLoadStudents, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfGradeLevel, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(tfSchoolYear, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jLabel101, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdcFirstDayOfFridate, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfMaleCount, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfFemaleCount, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(tfTotalCount, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(semesterSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfSectionName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfAdviserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfGradeLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfSchoolYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdcFirstDayOfFridate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel101)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(semesterSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfMaleCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfFemaleCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfTotalCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLoadStudents)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExportSf1)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(jPanel3);

        javax.swing.GroupLayout right1Layout = new javax.swing.GroupLayout(right1);
        right1.setLayout(right1Layout);
        right1Layout.setHorizontalGroup(
            right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );
        right1Layout.setVerticalGroup(
            right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );

        jSplitPane1.setRightComponent(right1);

        javax.swing.GroupLayout sf1TabLayout = new javax.swing.GroupLayout(sf1Tab);
        sf1Tab.setLayout(sf1TabLayout);
        sf1TabLayout.setHorizontalGroup(
            sf1TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
        sf1TabLayout.setVerticalGroup(
            sf1TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );

        jSplitPane2.setBorder(null);
        jSplitPane2.setDividerLocation(610);

        left2.setBackground(new java.awt.Color(249, 239, 227));

        tpSf2Sf4TabbedPane.setBackground(new java.awt.Color(203, 184, 160));

        jSplitPane3.setBorder(null);
        jSplitPane3.setDividerLocation(65);
        jSplitPane3.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        weekDaysOfTheMonthTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Section ID", "Student ID", "Name", "Gender", "Date Enrolled", "Remarks", "Mon1", "Tue", "Wed", "Thu", "Fri", "Mon2", "Tue", "Wed", "Thu", "Fri", "Mon3", "Tue", "Wed", "Thu", "Fri", "Mon4", "Tue", "Wed", "Thu", "Fri", "Mon5", "Tue", "Wed", "Thu", "Fri", "Absent", "Tardy"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        weekDaysOfTheMonthTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        weekDaysOfTheMonthTable.setEnabled(false);
        weekDaysOfTheMonthTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(weekDaysOfTheMonthTable);
        if (weekDaysOfTheMonthTable.getColumnModel().getColumnCount() > 0) {
            weekDaysOfTheMonthTable.getColumnModel().getColumn(3).setPreferredWidth(200);
            weekDaysOfTheMonthTable.getColumnModel().getColumn(7).setResizable(false);
            weekDaysOfTheMonthTable.getColumnModel().getColumn(7).setPreferredWidth(45);
            weekDaysOfTheMonthTable.getColumnModel().getColumn(8).setResizable(false);
            weekDaysOfTheMonthTable.getColumnModel().getColumn(8).setPreferredWidth(40);
            weekDaysOfTheMonthTable.getColumnModel().getColumn(9).setResizable(false);
            weekDaysOfTheMonthTable.getColumnModel().getColumn(9).setPreferredWidth(40);
            weekDaysOfTheMonthTable.getColumnModel().getColumn(10).setResizable(false);
            weekDaysOfTheMonthTable.getColumnModel().getColumn(10).setPreferredWidth(40);
            weekDaysOfTheMonthTable.getColumnModel().getColumn(11).setResizable(false);
            weekDaysOfTheMonthTable.getColumnModel().getColumn(11).setPreferredWidth(40);
            weekDaysOfTheMonthTable.getColumnModel().getColumn(12).setResizable(false);
            weekDaysOfTheMonthTable.getColumnModel().getColumn(12).setPreferredWidth(45);
            weekDaysOfTheMonthTable.getColumnModel().getColumn(13).setResizable(false);
            weekDaysOfTheMonthTable.getColumnModel().getColumn(13).setPreferredWidth(40);
            weekDaysOfTheMonthTable.getColumnModel().getColumn(14).setResizable(false);
            weekDaysOfTheMonthTable.getColumnModel().getColumn(14).setPreferredWidth(40);
            weekDaysOfTheMonthTable.getColumnModel().getColumn(15).setResizable(false);
            weekDaysOfTheMonthTable.getColumnModel().getColumn(15).setPreferredWidth(40);
            weekDaysOfTheMonthTable.getColumnModel().getColumn(16).setResizable(false);
            weekDaysOfTheMonthTable.getColumnModel().getColumn(16).setPreferredWidth(40);
            weekDaysOfTheMonthTable.getColumnModel().getColumn(17).setResizable(false);
            weekDaysOfTheMonthTable.getColumnModel().getColumn(17).setPreferredWidth(45);
            weekDaysOfTheMonthTable.getColumnModel().getColumn(18).setResizable(false);
            weekDaysOfTheMonthTable.getColumnModel().getColumn(18).setPreferredWidth(40);
            weekDaysOfTheMonthTable.getColumnModel().getColumn(19).setResizable(false);
            weekDaysOfTheMonthTable.getColumnModel().getColumn(19).setPreferredWidth(40);
            weekDaysOfTheMonthTable.getColumnModel().getColumn(20).setResizable(false);
            weekDaysOfTheMonthTable.getColumnModel().getColumn(20).setPreferredWidth(40);
            weekDaysOfTheMonthTable.getColumnModel().getColumn(21).setResizable(false);
            weekDaysOfTheMonthTable.getColumnModel().getColumn(21).setPreferredWidth(40);
            weekDaysOfTheMonthTable.getColumnModel().getColumn(22).setResizable(false);
            weekDaysOfTheMonthTable.getColumnModel().getColumn(22).setPreferredWidth(45);
            weekDaysOfTheMonthTable.getColumnModel().getColumn(23).setResizable(false);
            weekDaysOfTheMonthTable.getColumnModel().getColumn(23).setPreferredWidth(40);
            weekDaysOfTheMonthTable.getColumnModel().getColumn(24).setResizable(false);
            weekDaysOfTheMonthTable.getColumnModel().getColumn(24).setPreferredWidth(40);
            weekDaysOfTheMonthTable.getColumnModel().getColumn(25).setResizable(false);
            weekDaysOfTheMonthTable.getColumnModel().getColumn(25).setPreferredWidth(40);
            weekDaysOfTheMonthTable.getColumnModel().getColumn(26).setResizable(false);
            weekDaysOfTheMonthTable.getColumnModel().getColumn(26).setPreferredWidth(40);
            weekDaysOfTheMonthTable.getColumnModel().getColumn(27).setResizable(false);
            weekDaysOfTheMonthTable.getColumnModel().getColumn(27).setPreferredWidth(45);
            weekDaysOfTheMonthTable.getColumnModel().getColumn(28).setResizable(false);
            weekDaysOfTheMonthTable.getColumnModel().getColumn(28).setPreferredWidth(40);
            weekDaysOfTheMonthTable.getColumnModel().getColumn(29).setResizable(false);
            weekDaysOfTheMonthTable.getColumnModel().getColumn(29).setPreferredWidth(40);
            weekDaysOfTheMonthTable.getColumnModel().getColumn(30).setResizable(false);
            weekDaysOfTheMonthTable.getColumnModel().getColumn(30).setPreferredWidth(40);
            weekDaysOfTheMonthTable.getColumnModel().getColumn(31).setResizable(false);
            weekDaysOfTheMonthTable.getColumnModel().getColumn(31).setPreferredWidth(40);
            weekDaysOfTheMonthTable.getColumnModel().getColumn(32).setResizable(false);
            weekDaysOfTheMonthTable.getColumnModel().getColumn(33).setResizable(false);
        }

        jSplitPane3.setLeftComponent(jScrollPane6);

        sf2Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Section ID", "Student ID", "Name", "Gender", "Date Enrolled", "Remarks", "Mon1", "Tue", "Wed", "Thu", "Fri", "Mon2", "Tue", "Wed", "Thu", "Fri", "Mon3", "Tue", "Wed", "Thu", "Fri", "Mon4", "Tue", "Wed", "Thu", "Fri", "Mon5", "Tue", "Wed", "Thu", "Fri", "Absent", "Tardy"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        sf2Table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        sf2Table.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(sf2Table);
        if (sf2Table.getColumnModel().getColumnCount() > 0) {
            sf2Table.getColumnModel().getColumn(1).setResizable(false);
            sf2Table.getColumnModel().getColumn(3).setPreferredWidth(200);
            sf2Table.getColumnModel().getColumn(6).setResizable(false);
            sf2Table.getColumnModel().getColumn(7).setResizable(false);
            sf2Table.getColumnModel().getColumn(7).setPreferredWidth(45);
            sf2Table.getColumnModel().getColumn(8).setResizable(false);
            sf2Table.getColumnModel().getColumn(8).setPreferredWidth(40);
            sf2Table.getColumnModel().getColumn(9).setResizable(false);
            sf2Table.getColumnModel().getColumn(9).setPreferredWidth(40);
            sf2Table.getColumnModel().getColumn(10).setResizable(false);
            sf2Table.getColumnModel().getColumn(10).setPreferredWidth(40);
            sf2Table.getColumnModel().getColumn(11).setPreferredWidth(40);
            sf2Table.getColumnModel().getColumn(12).setResizable(false);
            sf2Table.getColumnModel().getColumn(12).setPreferredWidth(45);
            sf2Table.getColumnModel().getColumn(13).setResizable(false);
            sf2Table.getColumnModel().getColumn(13).setPreferredWidth(40);
            sf2Table.getColumnModel().getColumn(14).setResizable(false);
            sf2Table.getColumnModel().getColumn(14).setPreferredWidth(40);
            sf2Table.getColumnModel().getColumn(15).setResizable(false);
            sf2Table.getColumnModel().getColumn(15).setPreferredWidth(40);
            sf2Table.getColumnModel().getColumn(16).setResizable(false);
            sf2Table.getColumnModel().getColumn(16).setPreferredWidth(40);
            sf2Table.getColumnModel().getColumn(17).setResizable(false);
            sf2Table.getColumnModel().getColumn(17).setPreferredWidth(45);
            sf2Table.getColumnModel().getColumn(18).setResizable(false);
            sf2Table.getColumnModel().getColumn(18).setPreferredWidth(40);
            sf2Table.getColumnModel().getColumn(19).setResizable(false);
            sf2Table.getColumnModel().getColumn(19).setPreferredWidth(40);
            sf2Table.getColumnModel().getColumn(20).setResizable(false);
            sf2Table.getColumnModel().getColumn(20).setPreferredWidth(40);
            sf2Table.getColumnModel().getColumn(21).setResizable(false);
            sf2Table.getColumnModel().getColumn(21).setPreferredWidth(40);
            sf2Table.getColumnModel().getColumn(22).setResizable(false);
            sf2Table.getColumnModel().getColumn(22).setPreferredWidth(45);
            sf2Table.getColumnModel().getColumn(23).setResizable(false);
            sf2Table.getColumnModel().getColumn(23).setPreferredWidth(40);
            sf2Table.getColumnModel().getColumn(24).setResizable(false);
            sf2Table.getColumnModel().getColumn(24).setPreferredWidth(40);
            sf2Table.getColumnModel().getColumn(25).setResizable(false);
            sf2Table.getColumnModel().getColumn(25).setPreferredWidth(40);
            sf2Table.getColumnModel().getColumn(26).setResizable(false);
            sf2Table.getColumnModel().getColumn(26).setPreferredWidth(40);
            sf2Table.getColumnModel().getColumn(27).setResizable(false);
            sf2Table.getColumnModel().getColumn(27).setPreferredWidth(45);
            sf2Table.getColumnModel().getColumn(28).setResizable(false);
            sf2Table.getColumnModel().getColumn(28).setPreferredWidth(40);
            sf2Table.getColumnModel().getColumn(29).setResizable(false);
            sf2Table.getColumnModel().getColumn(29).setPreferredWidth(40);
            sf2Table.getColumnModel().getColumn(30).setResizable(false);
            sf2Table.getColumnModel().getColumn(30).setPreferredWidth(40);
            sf2Table.getColumnModel().getColumn(31).setResizable(false);
            sf2Table.getColumnModel().getColumn(31).setPreferredWidth(40);
            sf2Table.getColumnModel().getColumn(32).setResizable(false);
            sf2Table.getColumnModel().getColumn(33).setResizable(false);
        }

        jSplitPane3.setRightComponent(jScrollPane5);

        javax.swing.GroupLayout sf2TabLayout = new javax.swing.GroupLayout(sf2Tab);
        sf2Tab.setLayout(sf2TabLayout);
        sf2TabLayout.setHorizontalGroup(
            sf2TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
        );
        sf2TabLayout.setVerticalGroup(
            sf2TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 766, Short.MAX_VALUE)
        );

        tpSf2Sf4TabbedPane.addTab("SF2 Daily Attendance Report", sf2Tab);

        sf4Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Grade Level", "Section Name", "Adviser", "RgM", "RgF", "RgT", "DaM", "DaF", "DaT", "%M", "%F", "%T", "DrpM", "DrpF", "DrpT", "ToM", "ToF", "ToT", "TiM", "TiF", "TiT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        sf4Table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        sf4Table.getTableHeader().setReorderingAllowed(false);
        jScrollPane12.setViewportView(sf4Table);
        if (sf4Table.getColumnModel().getColumnCount() > 0) {
            sf4Table.getColumnModel().getColumn(0).setPreferredWidth(100);
            sf4Table.getColumnModel().getColumn(1).setPreferredWidth(200);
            sf4Table.getColumnModel().getColumn(2).setPreferredWidth(200);
            sf4Table.getColumnModel().getColumn(3).setPreferredWidth(45);
            sf4Table.getColumnModel().getColumn(4).setPreferredWidth(45);
            sf4Table.getColumnModel().getColumn(5).setPreferredWidth(45);
            sf4Table.getColumnModel().getColumn(6).setPreferredWidth(45);
            sf4Table.getColumnModel().getColumn(7).setPreferredWidth(45);
            sf4Table.getColumnModel().getColumn(8).setPreferredWidth(45);
            sf4Table.getColumnModel().getColumn(9).setPreferredWidth(45);
            sf4Table.getColumnModel().getColumn(10).setPreferredWidth(45);
            sf4Table.getColumnModel().getColumn(11).setPreferredWidth(45);
            sf4Table.getColumnModel().getColumn(12).setPreferredWidth(45);
            sf4Table.getColumnModel().getColumn(13).setPreferredWidth(45);
            sf4Table.getColumnModel().getColumn(14).setPreferredWidth(45);
            sf4Table.getColumnModel().getColumn(15).setPreferredWidth(45);
            sf4Table.getColumnModel().getColumn(16).setPreferredWidth(45);
            sf4Table.getColumnModel().getColumn(17).setPreferredWidth(45);
            sf4Table.getColumnModel().getColumn(18).setPreferredWidth(45);
            sf4Table.getColumnModel().getColumn(19).setPreferredWidth(45);
            sf4Table.getColumnModel().getColumn(20).setPreferredWidth(45);
        }

        javax.swing.GroupLayout sf4TabLayout = new javax.swing.GroupLayout(sf4Tab);
        sf4Tab.setLayout(sf4TabLayout);
        sf4TabLayout.setHorizontalGroup(
            sf4TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
        );
        sf4TabLayout.setVerticalGroup(
            sf4TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 766, Short.MAX_VALUE)
        );

        tpSf2Sf4TabbedPane.addTab("SF4 Monthly Attendance Report", sf4Tab);

        javax.swing.GroupLayout left2Layout = new javax.swing.GroupLayout(left2);
        left2.setLayout(left2Layout);
        left2Layout.setHorizontalGroup(
            left2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpSf2Sf4TabbedPane)
        );
        left2Layout.setVerticalGroup(
            left2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpSf2Sf4TabbedPane)
        );

        jSplitPane2.setLeftComponent(left2);

        right2.setBackground(new java.awt.Color(249, 239, 227));

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel5.setBackground(new java.awt.Color(249, 239, 227));

        jPanel6.setBackground(new java.awt.Color(203, 184, 160));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Section Details");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addContainerGap())
        );

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Basic");

        jLabel15.setText("Section Name");

        tfSectionName1.setEditable(false);

        jLabel16.setText("Adviser Name");

        tfAdviserName1.setEditable(false);

        jLabel17.setText("Grade Level");

        tfGradeLevel1.setEditable(false);
        tfGradeLevel1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel18.setText("School Year");

        tfSchoolYear1.setEditable(false);
        tfSchoolYear1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Export Options");

        jLabel20.setText("1st Day of Desired Month");
        jLabel20.setToolTipText("<html>\n\t<h4>Choose the first day of the month to get attendance from.</h4>\n\t<p>Selecting the first date determines weekdays and weekends<br>for the program to use.</p>\n</html>");

        jdcFirstDayOfMonth.setToolTipText("");

        btnLoadStudents1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/load_16px.png"))); // NOI18N
        btnLoadStudents1.setText("Load Students");
        btnLoadStudents1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadStudents1ActionPerformed(evt);
            }
        });

        btnExportSf2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/xls_export_16px.png"))); // NOI18N
        btnExportSf2.setText("Export");
        btnExportSf2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportSf2ActionPerformed(evt);
            }
        });

        summarySf2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "M", "F", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        summarySf2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        summarySf2.setEnabled(false);
        summarySf2.getTableHeader().setReorderingAllowed(false);
        jScrollPane7.setViewportView(summarySf2);
        if (summarySf2.getColumnModel().getColumnCount() > 0) {
            summarySf2.getColumnModel().getColumn(0).setPreferredWidth(300);
            summarySf2.getColumnModel().getColumn(1).setResizable(false);
            summarySf2.getColumnModel().getColumn(1).setPreferredWidth(40);
            summarySf2.getColumnModel().getColumn(2).setResizable(false);
            summarySf2.getColumnModel().getColumn(2).setPreferredWidth(40);
            summarySf2.getColumnModel().getColumn(3).setResizable(false);
            summarySf2.getColumnModel().getColumn(3).setPreferredWidth(45);
        }

        jLabel21.setText("Enrollment Cut-off Date");
        jLabel21.setToolTipText("<html>\n\t<h4>Choose the date when enrollment ended.</h4>\n\t<p>Selecting the cut-off date determines which student to <br>include or exclude from calculating the attendance<br>depending on their enrollment date</p>\n</html>");

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Summary");

        tfSchoolDays.setEditable(false);
        tfSchoolDays.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel23.setText("School Days");

        jLabel24.setText("Values For Missing Records");

        jcbMissingValues.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None (Default)", "Present", "Absent", "Dashed (--)" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfSectionName1)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfAdviserName1)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnExportSf2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLoadStudents1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jdcFirstDayOfMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jdcCutOffDate, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcbMissingValues, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfGradeLevel1, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfSchoolYear1)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfSchoolDays)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfSectionName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfAdviserName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfSchoolYear1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfSchoolDays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel23)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel17)
                                .addComponent(jLabel18))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tfGradeLevel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdcFirstDayOfMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdcCutOffDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbMissingValues, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLoadStudents1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExportSf2)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        jScrollPane4.setViewportView(jPanel5);

        tpSf2Sf4DetailsPane.addTab("Sf2 Settings", jScrollPane4);

        jPanel2.setBackground(new java.awt.Color(249, 239, 227));

        jPanel7.setBackground(new java.awt.Color(203, 184, 160));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Sf4 Export Options");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel25)
                .addContainerGap())
        );

        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Export Options");

        jLabel28.setText("1st Day of Desired Month");

        jLabel30.setText("Values For Missing Records");

        jcbMissingValues1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None (Default)", "Present", "Absent", "Dashed (--)" }));

        btnLoadStudents2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/icons8_sync_16px.png"))); // NOI18N
        btnLoadStudents2.setText("Load Sections");
        btnLoadStudents2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadStudents2ActionPerformed(evt);
            }
        });

        btnExportSf4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/icons8_print_16px.png"))); // NOI18N
        btnExportSf4.setText("Export");
        btnExportSf4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportSf4ActionPerformed(evt);
            }
        });

        jLabel31.setText("Enrollment Cut-off Date");

        tfSchoolYear7.setEditable(false);
        tfSchoolYear7.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel106.setText("School Year");

        jLabel107.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel107.setText("Basic");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 284, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel107, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExportSf4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLoadStudents2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdcFirstDayOfMonth1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jdcCutOffDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(tfSchoolYear7, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel106, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                            .addComponent(jcbMissingValues1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel107)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel106)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfSchoolYear7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdcFirstDayOfMonth1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdcCutOffDate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbMissingValues1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLoadStudents2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExportSf4)
                .addContainerGap(446, Short.MAX_VALUE))
        );

        jScrollPane9.setViewportView(jPanel2);

        tpSf2Sf4DetailsPane.addTab("Sf4 Settings", jScrollPane9);

        javax.swing.GroupLayout right2Layout = new javax.swing.GroupLayout(right2);
        right2.setLayout(right2Layout);
        right2Layout.setHorizontalGroup(
            right2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpSf2Sf4DetailsPane)
        );
        right2Layout.setVerticalGroup(
            right2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpSf2Sf4DetailsPane, javax.swing.GroupLayout.DEFAULT_SIZE, 794, Short.MAX_VALUE)
        );

        jSplitPane2.setRightComponent(right2);

        javax.swing.GroupLayout sf2Sf4TabLayout = new javax.swing.GroupLayout(sf2Sf4Tab);
        sf2Sf4Tab.setLayout(sf2Sf4TabLayout);
        sf2Sf4TabLayout.setHorizontalGroup(
            sf2Sf4TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2)
        );
        sf2Sf4TabLayout.setVerticalGroup(
            sf2Sf4TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2)
        );

        jSplitPane5.setBorder(null);
        jSplitPane5.setDividerLocation(600);

        jScrollPane14.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel9.setBackground(new java.awt.Color(249, 239, 227));

        jPanel10.setBackground(new java.awt.Color(203, 184, 160));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("List Details");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel32)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel32)
                .addContainerGap())
        );

        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Template Details");

        sf3BooksTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Code", "Book Name", "Grade Level", "Index", "Issued", "Returned", "Unreturned", "PTL", "TDO", "LLTR"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        sf3BooksTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        sf3BooksTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane15.setViewportView(sf3BooksTable);
        if (sf3BooksTable.getColumnModel().getColumnCount() > 0) {
            sf3BooksTable.getColumnModel().getColumn(1).setPreferredWidth(100);
            sf3BooksTable.getColumnModel().getColumn(2).setPreferredWidth(200);
            sf3BooksTable.getColumnModel().getColumn(4).setResizable(false);
            sf3BooksTable.getColumnModel().getColumn(5).setResizable(false);
            sf3BooksTable.getColumnModel().getColumn(5).setPreferredWidth(90);
            sf3BooksTable.getColumnModel().getColumn(6).setResizable(false);
            sf3BooksTable.getColumnModel().getColumn(6).setPreferredWidth(90);
            sf3BooksTable.getColumnModel().getColumn(7).setResizable(false);
            sf3BooksTable.getColumnModel().getColumn(7).setPreferredWidth(90);
            sf3BooksTable.getColumnModel().getColumn(8).setResizable(false);
            sf3BooksTable.getColumnModel().getColumn(8).setPreferredWidth(90);
            sf3BooksTable.getColumnModel().getColumn(9).setResizable(false);
            sf3BooksTable.getColumnModel().getColumn(9).setPreferredWidth(90);
            sf3BooksTable.getColumnModel().getColumn(10).setResizable(false);
            sf3BooksTable.getColumnModel().getColumn(10).setPreferredWidth(90);
        }

        btnLoadStudents3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/load_16px.png"))); // NOI18N
        btnLoadStudents3.setText("Load Students");
        btnLoadStudents3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadStudents3ActionPerformed(evt);
            }
        });

        btnExportSf3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/xls_export_16px.png"))); // NOI18N
        btnExportSf3.setText("Export");
        btnExportSf3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportSf3ActionPerformed(evt);
            }
        });

        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Export Options");

        jLabel35.setText("School Year");

        tfSchoolYear2.setEditable(false);
        tfSchoolYear2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("Basic");

        jLabel37.setText("Section Name");

        tfSectionName2.setEditable(false);

        jLabel38.setText("Adviser Name");

        tfAdviserName2.setEditable(false);

        jLabel39.setText("Grade Level");

        tfGradeLevel2.setEditable(false);
        tfGradeLevel2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jcbMissingValues2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None (Default)", "Dashed (--)" }));

        jLabel40.setText("Values For Missing Records");

        jcbMissingValues3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Book Code (Default)", "Book Name", "Book Index" }));

        jLabel105.setText("Values For Remarks");

        jLabel103.setText("Semester");

        semesterSelect1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st semester", "2nd semester" }));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnExportSf3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLoadStudents3, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfSectionName2)
                    .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfAdviserName2)
                    .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel105, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbMissingValues3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfGradeLevel2)
                                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(43, 43, 43)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfSchoolYear2)
                                    .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jcbMissingValues2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100, 100, 100)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel103)
                                    .addComponent(semesterSelect1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfSectionName2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfAdviserName2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(jLabel35))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfGradeLevel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfSchoolYear2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(jLabel103))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbMissingValues2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(semesterSelect1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel105)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbMissingValues3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLoadStudents3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExportSf3)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jScrollPane14.setViewportView(jPanel9);

        jSplitPane5.setRightComponent(jScrollPane14);

        jPanel12.setBackground(new java.awt.Color(249, 239, 227));

        sf3Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Section ID", "Student ID", "Name", "Gender", "B1 Issued", "B1 Returned", "B2 Issued", "B2 Returned", "B3 Issued", "B3 Returned", "B4 Issued", "B4 Returned", "B5 Issued", "B5 Returned", "B6 Issued", "B6 Returned", "B7 Issued", "B8 Returned", "B8 Issued", "B8 Returned", "B9 Issued", "B9 Returned", "B10 Issued", "B10 Returned", "Remarks"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        sf3Table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        sf3Table.getTableHeader().setReorderingAllowed(false);
        sf3Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sf3TableMouseClicked(evt);
            }
        });
        jScrollPane13.setViewportView(sf3Table);
        if (sf3Table.getColumnModel().getColumnCount() > 0) {
            sf3Table.getColumnModel().getColumn(3).setPreferredWidth(200);
            sf3Table.getColumnModel().getColumn(4).setResizable(false);
            sf3Table.getColumnModel().getColumn(4).setPreferredWidth(70);
            sf3Table.getColumnModel().getColumn(5).setResizable(false);
            sf3Table.getColumnModel().getColumn(5).setPreferredWidth(100);
            sf3Table.getColumnModel().getColumn(6).setResizable(false);
            sf3Table.getColumnModel().getColumn(6).setPreferredWidth(100);
            sf3Table.getColumnModel().getColumn(7).setResizable(false);
            sf3Table.getColumnModel().getColumn(7).setPreferredWidth(100);
            sf3Table.getColumnModel().getColumn(8).setResizable(false);
            sf3Table.getColumnModel().getColumn(8).setPreferredWidth(100);
            sf3Table.getColumnModel().getColumn(9).setResizable(false);
            sf3Table.getColumnModel().getColumn(9).setPreferredWidth(100);
            sf3Table.getColumnModel().getColumn(10).setResizable(false);
            sf3Table.getColumnModel().getColumn(10).setPreferredWidth(100);
            sf3Table.getColumnModel().getColumn(11).setResizable(false);
            sf3Table.getColumnModel().getColumn(11).setPreferredWidth(100);
            sf3Table.getColumnModel().getColumn(12).setResizable(false);
            sf3Table.getColumnModel().getColumn(12).setPreferredWidth(100);
            sf3Table.getColumnModel().getColumn(13).setResizable(false);
            sf3Table.getColumnModel().getColumn(13).setPreferredWidth(100);
            sf3Table.getColumnModel().getColumn(14).setResizable(false);
            sf3Table.getColumnModel().getColumn(14).setPreferredWidth(100);
            sf3Table.getColumnModel().getColumn(15).setResizable(false);
            sf3Table.getColumnModel().getColumn(15).setPreferredWidth(100);
            sf3Table.getColumnModel().getColumn(16).setResizable(false);
            sf3Table.getColumnModel().getColumn(16).setPreferredWidth(100);
            sf3Table.getColumnModel().getColumn(17).setResizable(false);
            sf3Table.getColumnModel().getColumn(17).setPreferredWidth(100);
            sf3Table.getColumnModel().getColumn(18).setResizable(false);
            sf3Table.getColumnModel().getColumn(18).setPreferredWidth(100);
            sf3Table.getColumnModel().getColumn(19).setResizable(false);
            sf3Table.getColumnModel().getColumn(19).setPreferredWidth(100);
            sf3Table.getColumnModel().getColumn(20).setResizable(false);
            sf3Table.getColumnModel().getColumn(20).setPreferredWidth(100);
            sf3Table.getColumnModel().getColumn(21).setResizable(false);
            sf3Table.getColumnModel().getColumn(21).setPreferredWidth(100);
            sf3Table.getColumnModel().getColumn(22).setResizable(false);
            sf3Table.getColumnModel().getColumn(22).setPreferredWidth(100);
            sf3Table.getColumnModel().getColumn(23).setResizable(false);
            sf3Table.getColumnModel().getColumn(23).setPreferredWidth(100);
            sf3Table.getColumnModel().getColumn(24).setResizable(false);
            sf3Table.getColumnModel().getColumn(24).setPreferredWidth(100);
            sf3Table.getColumnModel().getColumn(25).setResizable(false);
            sf3Table.getColumnModel().getColumn(25).setPreferredWidth(300);
        }

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane13)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 771, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane5.setLeftComponent(jPanel12);

        javax.swing.GroupLayout sf3TabLayout = new javax.swing.GroupLayout(sf3Tab);
        sf3Tab.setLayout(sf3TabLayout);
        sf3TabLayout.setHorizontalGroup(
            sf3TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane5)
        );
        sf3TabLayout.setVerticalGroup(
            sf3TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane5)
        );

        jSplitPane6.setBackground(new java.awt.Color(11, 102, 35));
        jSplitPane6.setBorder(null);
        jSplitPane6.setDividerLocation(635);

        left.setBackground(new java.awt.Color(249, 239, 227));

        jScrollPane16.setBorder(null);

        sf5Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Section ID", "Grade Level", "Student ID", "LRN", "Name", "Gender", "Remarks", "General Average", "Action Taken", "Did Not Meet expectations On", "Date Updated", "Strand", "sem"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        sf5Table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        sf5Table.getTableHeader().setReorderingAllowed(false);
        sf5Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sf5TableMouseClicked(evt);
            }
        });
        jScrollPane16.setViewportView(sf5Table);
        if (sf5Table.getColumnModel().getColumnCount() > 0) {
            sf5Table.getColumnModel().getColumn(4).setResizable(false);
            sf5Table.getColumnModel().getColumn(4).setPreferredWidth(100);
            sf5Table.getColumnModel().getColumn(5).setPreferredWidth(250);
            sf5Table.getColumnModel().getColumn(6).setResizable(false);
            sf5Table.getColumnModel().getColumn(6).setPreferredWidth(70);
            sf5Table.getColumnModel().getColumn(7).setPreferredWidth(150);
            sf5Table.getColumnModel().getColumn(8).setResizable(false);
            sf5Table.getColumnModel().getColumn(8).setPreferredWidth(120);
            sf5Table.getColumnModel().getColumn(9).setResizable(false);
            sf5Table.getColumnModel().getColumn(9).setPreferredWidth(100);
            sf5Table.getColumnModel().getColumn(10).setPreferredWidth(200);
            sf5Table.getColumnModel().getColumn(11).setResizable(false);
            sf5Table.getColumnModel().getColumn(11).setPreferredWidth(150);
        }

        tpSf5Sf6Pane.addTab("SF5 Promotion & Level of Proficiency", jScrollPane16);

        jScrollPane17.setBorder(null);

        sf6Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Summary Table", "Gr11 M", "Gr11 F", "Gr11 T", "Gr12 M", "Gr12 F", "Gr12 T", "Male", "Female", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        sf6Table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane17.setViewportView(sf6Table);
        if (sf6Table.getColumnModel().getColumnCount() > 0) {
            sf6Table.getColumnModel().getColumn(0).setPreferredWidth(150);
        }

        tpSf5Sf6Pane.addTab("SF6 Summary of Promotion & Learning Progress", jScrollPane17);

        javax.swing.GroupLayout leftLayout = new javax.swing.GroupLayout(left);
        left.setLayout(leftLayout);
        leftLayout.setHorizontalGroup(
            leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpSf5Sf6Pane, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
        );
        leftLayout.setVerticalGroup(
            leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpSf5Sf6Pane, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE)
        );

        jSplitPane6.setLeftComponent(left);

        right.setBackground(new java.awt.Color(249, 239, 227));

        jScrollPane18.setBorder(null);
        jScrollPane18.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel13.setBackground(new java.awt.Color(249, 239, 227));

        jPanel15.setBackground(new java.awt.Color(203, 184, 160));

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("SF5 Export Options");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel41)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel41)
                .addContainerGap())
        );

        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("Summary");

        sf5SummaryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Status", "Male", "Female", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        sf5SummaryTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane20.setViewportView(sf5SummaryTable);

        sf5LevelOfProgress.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Status", "Male", "Female", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        sf5LevelOfProgress.getTableHeader().setReorderingAllowed(false);
        jScrollPane21.setViewportView(sf5LevelOfProgress);

        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("Level of Progress & Achievement");

        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText("Export Options");

        btnExportSf5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/xls_export_16px.png"))); // NOI18N
        btnExportSf5.setText("Export");
        btnExportSf5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportSf5ActionPerformed(evt);
            }
        });

        btnLoadStudents4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/load_16px.png"))); // NOI18N
        btnLoadStudents4.setText("Load Students");
        btnLoadStudents4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadStudents4ActionPerformed(evt);
            }
        });

        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText("Basic");

        jLabel47.setText("Section Name");

        tfSectionName3.setEditable(false);

        jLabel48.setText("Adviser Name");

        tfAdviserName3.setEditable(false);

        jLabel49.setText("Grade Level");

        tfGradeLevel3.setEditable(false);
        tfGradeLevel3.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        tfSchoolYear3.setEditable(false);
        tfSchoolYear3.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel50.setText("School Year");

        cbShowIncompleteStudents.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        cbShowIncompleteStudents.setText("Show Students With Incomplete Records?");
        cbShowIncompleteStudents.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/icons8_unchecked_checkbox_20px.png"))); // NOI18N
        cbShowIncompleteStudents.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/icons8_checked_checkbox_20px.png"))); // NOI18N

        cbCompareToRankings.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        cbCompareToRankings.setSelected(true);
        cbCompareToRankings.setText("Search for Honor Students?");
        cbCompareToRankings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/icons8_unchecked_checkbox_20px.png"))); // NOI18N
        cbCompareToRankings.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/icons8_checked_checkbox_20px.png"))); // NOI18N

        jLabel109.setText("Curriculum");

        tfCurriculum.setEditable(false);
        tfCurriculum.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        semesterSelect5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st Semester", "2nd Semester", "All" }));

        tfStrand5.setBackground(new java.awt.Color(240, 240, 240));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnExportSf5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLoadStudents4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfGradeLevel3)
                                    .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
                                .addGap(44, 44, 44)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfSchoolYear3)
                                    .addComponent(jLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addComponent(jLabel109, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(22, 22, 22))
                                    .addComponent(tfCurriculum)))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(tfAdviserName3, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(semesterSelect5, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbShowIncompleteStudents, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbCompareToRankings, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(tfSectionName3, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(tfStrand5)))))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel46)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel47)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfSectionName3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfStrand5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel48)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfAdviserName3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(semesterSelect5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel109)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCurriculum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel49)
                            .addComponent(jLabel50))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfGradeLevel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfSchoolYear3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel43)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel44)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel45)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbShowIncompleteStudents)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbCompareToRankings)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLoadStudents4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExportSf5)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jScrollPane18.setViewportView(jPanel13);

        tpSf5Sf6DetailsPane.addTab("SF5 Details", jScrollPane18);

        jScrollPane19.setBorder(null);

        jPanel14.setBackground(new java.awt.Color(249, 239, 227));

        jPanel16.setBackground(new java.awt.Color(203, 184, 160));

        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("SF6 Export Options");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel42)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel42)
                .addContainerGap())
        );

        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel54.setText("Export Options");

        cbShowIncompleteStudents1.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        cbShowIncompleteStudents1.setText("Show Students With Incomplete Records?");
        cbShowIncompleteStudents1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/icons8_unchecked_checkbox_20px.png"))); // NOI18N
        cbShowIncompleteStudents1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/icons8_checked_checkbox_20px.png"))); // NOI18N

        btnLoadStudents5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/icons8_sync_16px.png"))); // NOI18N
        btnLoadStudents5.setText("Load Students");
        btnLoadStudents5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadStudents5ActionPerformed(evt);
            }
        });

        btnExportSf6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/icons8_print_16px.png"))); // NOI18N
        btnExportSf6.setText("Export");
        btnExportSf6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportSf6ActionPerformed(evt);
            }
        });

        jLabel55.setText("School Year");

        tfSchoolYear4.setEditable(false);
        tfSchoolYear4.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfSchoolYear4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExportSf6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLoadStudents5, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addComponent(cbShowIncompleteStudents1))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel54)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel55)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfSchoolYear4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbShowIncompleteStudents1)
                .addGap(39, 39, 39)
                .addComponent(btnLoadStudents5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExportSf6)
                .addContainerGap(565, Short.MAX_VALUE))
        );

        jScrollPane19.setViewportView(jPanel14);

        tpSf5Sf6DetailsPane.addTab("SF6 Details", jScrollPane19);

        javax.swing.GroupLayout rightLayout = new javax.swing.GroupLayout(right);
        right.setLayout(rightLayout);
        rightLayout.setHorizontalGroup(
            rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpSf5Sf6DetailsPane)
        );
        rightLayout.setVerticalGroup(
            rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpSf5Sf6DetailsPane, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE)
        );

        jSplitPane6.setRightComponent(right);

        javax.swing.GroupLayout sf5Sf6TabLayout = new javax.swing.GroupLayout(sf5Sf6Tab);
        sf5Sf6Tab.setLayout(sf5Sf6TabLayout);
        sf5Sf6TabLayout.setHorizontalGroup(
            sf5Sf6TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane6)
        );
        sf5Sf6TabLayout.setVerticalGroup(
            sf5Sf6TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane6)
        );

        sf7Tab.setBackground(new java.awt.Color(11, 102, 35));

        jSplitPane10.setBorder(null);
        jSplitPane10.setDividerLocation(640);

        spLeft.setDividerLocation(200);
        spLeft.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        sf7TeachersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Employee ID", "Name", "Gender", "Fund Source", "Position", "Nature of Appointment", "Degree", "Major", "Minor", "Access Level"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        sf7TeachersTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        sf7TeachersTable.getTableHeader().setReorderingAllowed(false);
        sf7TeachersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sf7TeachersTableMouseClicked(evt);
            }
        });
        jScrollPane44.setViewportView(sf7TeachersTable);
        if (sf7TeachersTable.getColumnModel().getColumnCount() > 0) {
            sf7TeachersTable.getColumnModel().getColumn(1).setResizable(false);
            sf7TeachersTable.getColumnModel().getColumn(1).setPreferredWidth(150);
            sf7TeachersTable.getColumnModel().getColumn(2).setPreferredWidth(200);
            sf7TeachersTable.getColumnModel().getColumn(3).setResizable(false);
            sf7TeachersTable.getColumnModel().getColumn(3).setPreferredWidth(80);
            sf7TeachersTable.getColumnModel().getColumn(4).setPreferredWidth(150);
            sf7TeachersTable.getColumnModel().getColumn(5).setPreferredWidth(150);
            sf7TeachersTable.getColumnModel().getColumn(6).setPreferredWidth(180);
            sf7TeachersTable.getColumnModel().getColumn(7).setPreferredWidth(150);
            sf7TeachersTable.getColumnModel().getColumn(8).setPreferredWidth(150);
            sf7TeachersTable.getColumnModel().getColumn(9).setPreferredWidth(150);
            sf7TeachersTable.getColumnModel().getColumn(10).setPreferredWidth(80);
        }

        spLeft.setLeftComponent(jScrollPane44);

        jScrollPane45.setBorder(null);

        sf7AssignedSubjectsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Teacher ID", "Section ID", "Section Name", "Subject ID", "Code", "Description", "Grade", "Semester", "School Year", "Dep type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        sf7AssignedSubjectsTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        sf7AssignedSubjectsTable.setEnabled(false);
        sf7AssignedSubjectsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane45.setViewportView(sf7AssignedSubjectsTable);
        if (sf7AssignedSubjectsTable.getColumnModel().getColumnCount() > 0) {
            sf7AssignedSubjectsTable.getColumnModel().getColumn(3).setPreferredWidth(200);
            sf7AssignedSubjectsTable.getColumnModel().getColumn(5).setPreferredWidth(100);
            sf7AssignedSubjectsTable.getColumnModel().getColumn(6).setPreferredWidth(200);
            sf7AssignedSubjectsTable.getColumnModel().getColumn(7).setPreferredWidth(80);
            sf7AssignedSubjectsTable.getColumnModel().getColumn(8).setPreferredWidth(150);
            sf7AssignedSubjectsTable.getColumnModel().getColumn(9).setResizable(false);
        }

        spLeft.setRightComponent(jScrollPane45);

        jSplitPane10.setLeftComponent(spLeft);

        jspRight.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel31.setBackground(new java.awt.Color(249, 239, 227));

        jPanel32.setBackground(new java.awt.Color(203, 184, 160));

        jLabel96.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(255, 255, 255));
        jLabel96.setText("SF7 Export Options");

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel96)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel96)
                .addContainerGap())
        );

        jLabel99.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel99.setText("Basic");

        jLabel108.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel108.setText("Export Options");

        btnLoadTeacher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/load_16px.png"))); // NOI18N
        btnLoadTeacher.setText("Load Teachers");
        btnLoadTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadTeacherActionPerformed(evt);
            }
        });

        btnExportSf7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/xls_export_16px.png"))); // NOI18N
        btnExportSf7.setText("Export");
        btnExportSf7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportSf7ActionPerformed(evt);
            }
        });

        jcbSchoolYear2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2019", "2020", "2021" }));

        jLabel102.setText("Select School Year");

        cbRemoveTeachersWNoSubjects.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        cbRemoveTeachersWNoSubjects.setSelected(true);
        cbRemoveTeachersWNoSubjects.setText("Remove Teachers with no Subjects Handled?");
        cbRemoveTeachersWNoSubjects.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/icons8_unchecked_checkbox_20px.png"))); // NOI18N
        cbRemoveTeachersWNoSubjects.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/icons8_checked_checkbox_20px.png"))); // NOI18N

        cbUseCodeAsName.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        cbUseCodeAsName.setText("Use Subject Code as Subject Name?");
        cbUseCodeAsName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/icons8_unchecked_checkbox_20px.png"))); // NOI18N
        cbUseCodeAsName.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/icons8_checked_checkbox_20px.png"))); // NOI18N
        cbUseCodeAsName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbUseCodeAsNameActionPerformed(evt);
            }
        });

        cbUseAcronyms.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        cbUseAcronyms.setSelected(true);
        cbUseAcronyms.setText("Use Subject acronyms? (Mathematics = MATH)");
        cbUseAcronyms.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/icons8_unchecked_checkbox_20px.png"))); // NOI18N
        cbUseAcronyms.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/icons8_checked_checkbox_20px.png"))); // NOI18N
        cbUseAcronyms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbUseAcronymsActionPerformed(evt);
            }
        });

        jLabel98.setText("Semester");

        semesterSelect7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st Semester", "2nd Semester", "All" }));
        semesterSelect7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semesterSelect7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel108, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbUseAcronyms, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbUseCodeAsName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLoadTeacher, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnExportSf7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbRemoveTeachersWNoSubjects, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(55, 55, 55))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel99, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel31Layout.createSequentialGroup()
                                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel102, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                    .addComponent(jcbSchoolYear2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(142, 142, 142)
                                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(semesterSelect7, 0, 144, Short.MAX_VALUE)
                                    .addComponent(jLabel98, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(57, 57, 57))))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel99)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel102)
                    .addComponent(jLabel98))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbSchoolYear2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(semesterSelect7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel108)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbRemoveTeachersWNoSubjects)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbUseAcronyms)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbUseCodeAsName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLoadTeacher)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExportSf7)
                .addContainerGap(524, Short.MAX_VALUE))
        );

        jspRight.setViewportView(jPanel31);

        jSplitPane10.setRightComponent(jspRight);

        javax.swing.GroupLayout sf7TabLayout = new javax.swing.GroupLayout(sf7Tab);
        sf7Tab.setLayout(sf7TabLayout);
        sf7TabLayout.setHorizontalGroup(
            sf7TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 1147, Short.MAX_VALUE)
        );
        sf7TabLayout.setVerticalGroup(
            sf7TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
        );

        sf8Tab.setPreferredSize(new java.awt.Dimension(1039, 800));

        jSplitPane7.setDividerLocation(600);

        jScrollPane29.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel20.setBackground(new java.awt.Color(249, 239, 227));

        jPanel21.setBackground(new java.awt.Color(203, 184, 160));

        jLabel56.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setText("SF8 Export Options");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel56)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel56)
                .addContainerGap())
        );

        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel57.setText("Basic");

        jLabel58.setText("Section Name");

        tfSectionName4.setEditable(false);

        jLabel59.setText("Adviser Name");

        tfAdviserName4.setEditable(false);

        jLabel60.setText("Grade Level");

        tfGradeLevel4.setEditable(false);
        tfGradeLevel4.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel61.setText("School Year");

        tfSchoolYear5.setEditable(false);
        tfSchoolYear5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfSchoolYear5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSchoolYear5ActionPerformed(evt);
            }
        });

        jLabel62.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel62.setText("Export Options");

        btnLoadStudents6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/load_16px.png"))); // NOI18N
        btnLoadStudents6.setText("Load Students");
        btnLoadStudents6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadStudents6ActionPerformed(evt);
            }
        });

        btnExportSf8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/xls_export_16px.png"))); // NOI18N
        btnExportSf8.setText("Export");
        btnExportSf8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportSf8ActionPerformed(evt);
            }
        });

        sf8SummaryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Status", "Male", "Female", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        sf8SummaryTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane30.setViewportView(sf8SummaryTable);
        if (sf8SummaryTable.getColumnModel().getColumnCount() > 0) {
            sf8SummaryTable.getColumnModel().getColumn(0).setPreferredWidth(100);
            sf8SummaryTable.getColumnModel().getColumn(1).setResizable(false);
            sf8SummaryTable.getColumnModel().getColumn(1).setPreferredWidth(40);
            sf8SummaryTable.getColumnModel().getColumn(2).setResizable(false);
            sf8SummaryTable.getColumnModel().getColumn(2).setPreferredWidth(40);
            sf8SummaryTable.getColumnModel().getColumn(3).setResizable(false);
            sf8SummaryTable.getColumnModel().getColumn(3).setPreferredWidth(40);
        }

        jLabel63.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel63.setText("Summary Table");

        cbShowIncompleteStudents2.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        cbShowIncompleteStudents2.setText("Show students with missing records?");
        cbShowIncompleteStudents2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/icons8_unchecked_checkbox_20px.png"))); // NOI18N
        cbShowIncompleteStudents2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/icons8_checked_checkbox_20px.png"))); // NOI18N

        jLabel115.setText("Date of Measurement");

        tfDateOfMeasurement.setEditable(false);
        tfDateOfMeasurement.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        cbUseFirstStudentForDate.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        cbUseFirstStudentForDate.setSelected(true);
        cbUseFirstStudentForDate.setText("Use first Student for Date of Measurement?");
        cbUseFirstStudentForDate.setToolTipText("<html>\n\t<body  style=\"background-color: white; font-family: 'Century Gothic';\">\n\t\t<b>Choose Method of Determining Date of Measurement</b>\n\t\t<br>\n\t\t<br>\n\t\t<p>- Uses the Date of Measurement of  the First Student with a Record\n\t\t\t<br>for the Date of Measurement for all students.\n\t\t</p>\n\t\t<p>- If unchecked, Date of Measurement will be determined by majority a Date.</p>\n\t\t<p>- In case of equal count of Dates, the first Date will be choosen automatically.</p>\n\t</body>\n</html>");
        cbUseFirstStudentForDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/icons8_unchecked_checkbox_20px.png"))); // NOI18N
        cbUseFirstStudentForDate.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/icons8_checked_checkbox_20px.png"))); // NOI18N

        jLabel123.setText("Track/Strand");

        tfStrand8.setEditable(false);
        tfStrand8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfStrand8ActionPerformed(evt);
            }
        });

        jLabel97.setText("Semester");

        semesterSelect8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st Semester", "2nd Semester" }));

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel20Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel20Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tfGradeLevel4)
                        .addGap(71, 71, 71)
                        .addComponent(tfSchoolYear5)
                        .addGap(60, 60, 60)
                        .addComponent(tfDateOfMeasurement)
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel20Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel60, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(76, 76, 76)
                        .addComponent(jLabel61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel115, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(5, 5, 5))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnLoadStudents6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnExportSf8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel62, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane30, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel20Layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(cbUseFirstStudentForDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cbShowIncompleteStudents2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel20Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel58, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfSectionName4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(semesterSelect8, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel97, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(88, 88, 88)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel59, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel123, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfStrand8)
                            .addComponent(tfAdviserName4))
                        .addGap(17, 17, 17)))
                .addGap(31, 31, 31))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel57)
                .addGap(16, 16, 16)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel58)
                    .addComponent(jLabel123))
                .addGap(9, 9, 9)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfStrand8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfSectionName4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel97)
                    .addComponent(jLabel59))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(semesterSelect8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfAdviserName4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel60)
                    .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel61)
                        .addComponent(jLabel115)))
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfSchoolYear5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfDateOfMeasurement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfGradeLevel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel63)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane30, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel62)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbUseFirstStudentForDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbShowIncompleteStudents2)
                .addGap(19, 19, 19)
                .addComponent(btnLoadStudents6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExportSf8)
                .addContainerGap())
        );

        jScrollPane29.setViewportView(jPanel20);

        jSplitPane7.setRightComponent(jScrollPane29);

        jPanel22.setBackground(new java.awt.Color(249, 239, 227));

        sf8Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Student ID", "Section ID", "LRN", "Name", "Birth Date", "Gender", "BMI ID", "Age", "Weight", "Height", "Height^2", "BMI", "Nutritional Status", "Height-For-Age", "Date Recorded", "strand", "sem"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        sf8Table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        sf8Table.getTableHeader().setReorderingAllowed(false);
        jScrollPane25.setViewportView(sf8Table);
        if (sf8Table.getColumnModel().getColumnCount() > 0) {
            sf8Table.getColumnModel().getColumn(3).setPreferredWidth(100);
            sf8Table.getColumnModel().getColumn(4).setPreferredWidth(200);
            sf8Table.getColumnModel().getColumn(13).setPreferredWidth(150);
            sf8Table.getColumnModel().getColumn(14).setPreferredWidth(150);
            sf8Table.getColumnModel().getColumn(15).setPreferredWidth(150);
        }

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane25, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane25, javax.swing.GroupLayout.DEFAULT_SIZE, 766, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane7.setLeftComponent(jPanel22);

        javax.swing.GroupLayout sf8TabLayout = new javax.swing.GroupLayout(sf8Tab);
        sf8Tab.setLayout(sf8TabLayout);
        sf8TabLayout.setHorizontalGroup(
            sf8TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 1107, Short.MAX_VALUE)
        );
        sf8TabLayout.setVerticalGroup(
            sf8TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane7)
        );

        jSplitPane8.setBorder(null);
        jSplitPane8.setDividerLocation(600);

        left4.setBackground(new java.awt.Color(249, 239, 227));

        lbSearchResult1.setForeground(new java.awt.Color(255, 255, 255));
        lbSearchResult1.setText("Search using the search bar...");

        tfSearchEnrolledStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchEnrolledStudentsearchEnrolledStudentsHandler(evt);
            }
        });

        btnSearchEnrolledStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/search_24px.png"))); // NOI18N
        btnSearchEnrolledStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchEnrolledStudentsearchEnrolledStudentsHandler(evt);
            }
        });

        enrolledStudentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Student ID", "LRN", "Name", "Gender", "Birth Date", "Section ID", "Strand"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        enrolledStudentsTable.getTableHeader().setReorderingAllowed(false);
        enrolledStudentsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                enrolledStudentsTableloadStudentsAttendanceHandler(evt);
            }
        });
        jScrollPane31.setViewportView(enrolledStudentsTable);
        if (enrolledStudentsTable.getColumnModel().getColumnCount() > 0) {
            enrolledStudentsTable.getColumnModel().getColumn(2).setPreferredWidth(50);
            enrolledStudentsTable.getColumnModel().getColumn(4).setPreferredWidth(40);
        }

        javax.swing.GroupLayout left4Layout = new javax.swing.GroupLayout(left4);
        left4.setLayout(left4Layout);
        left4Layout.setHorizontalGroup(
            left4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(left4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(left4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane31, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(left4Layout.createSequentialGroup()
                        .addComponent(lbSearchResult1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfSearchEnrolledStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearchEnrolledStudent)))
                .addContainerGap())
        );
        left4Layout.setVerticalGroup(
            left4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(left4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(left4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(left4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbSearchResult1)
                        .addComponent(btnSearchEnrolledStudent))
                    .addComponent(tfSearchEnrolledStudent))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane31, javax.swing.GroupLayout.DEFAULT_SIZE, 831, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane8.setLeftComponent(left4);

        jScrollPane32.setBorder(null);
        jScrollPane32.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel23.setBackground(new java.awt.Color(249, 239, 227));

        jPanel24.setBackground(new java.awt.Color(203, 184, 160));

        jLabel64.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(255, 255, 255));
        jLabel64.setText("View Student's Grades");

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel64)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel64)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel65.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel65.setText("Grade Details");

        gradesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Grade ID", "Student ID", "Section ID", "Subject ID", "Code", "Description", "Q1", "Q2", "Q3", "Q4", "GWA", "Status", "Semester", "Date Updated"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        gradesTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        gradesTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane33.setViewportView(gradesTable);
        if (gradesTable.getColumnModel().getColumnCount() > 0) {
            gradesTable.getColumnModel().getColumn(4).setPreferredWidth(80);
            gradesTable.getColumnModel().getColumn(5).setPreferredWidth(200);
            gradesTable.getColumnModel().getColumn(6).setResizable(false);
            gradesTable.getColumnModel().getColumn(6).setPreferredWidth(50);
            gradesTable.getColumnModel().getColumn(7).setResizable(false);
            gradesTable.getColumnModel().getColumn(7).setPreferredWidth(50);
            gradesTable.getColumnModel().getColumn(8).setResizable(false);
            gradesTable.getColumnModel().getColumn(8).setPreferredWidth(50);
            gradesTable.getColumnModel().getColumn(9).setResizable(false);
            gradesTable.getColumnModel().getColumn(9).setPreferredWidth(50);
            gradesTable.getColumnModel().getColumn(10).setResizable(false);
            gradesTable.getColumnModel().getColumn(10).setPreferredWidth(80);
            gradesTable.getColumnModel().getColumn(11).setResizable(false);
            gradesTable.getColumnModel().getColumn(11).setPreferredWidth(120);
            gradesTable.getColumnModel().getColumn(12).setResizable(false);
            gradesTable.getColumnModel().getColumn(13).setResizable(false);
            gradesTable.getColumnModel().getColumn(13).setPreferredWidth(150);
        }

        btnLoadGrades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/load_16px.png"))); // NOI18N
        btnLoadGrades.setText("Load Grades");
        btnLoadGrades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadGradesActionPerformed(evt);
            }
        });

        jLabel66.setText("General Average");

        tfGeneralAverage.setEditable(false);
        tfGeneralAverage.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel67.setText("Remarks");

        jLabel68.setText("Record ID:");

        lbFinalGradeId.setText("0");

        btnExportSf9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/xls_export_16px.png"))); // NOI18N
        btnExportSf9.setText("Export SF9");
        btnExportSf9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportSf9ActionPerformed(evt);
            }
        });

        jLabel69.setText("Did Not Meet Expectations On");

        tfFailedSubjects.setEditable(false);
        tfFailedSubjects.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        tfEvaluation.setEditable(false);
        tfEvaluation.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel70.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel70.setText("Basic");

        jLabel71.setText("Section Name");

        tfSectionName5.setEditable(false);

        jLabel72.setText("Adviser Name");

        tfAdviserName5.setEditable(false);

        jLabel73.setText("Grade Level");

        tfGradeLevel5.setEditable(false);
        tfGradeLevel5.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        tfSchoolYear6.setEditable(false);
        tfSchoolYear6.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel74.setText("School Year");

        jLabel93.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel93.setText("Export Options");

        jLabel116.setText("Date of Export");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 270, Short.MAX_VALUE))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane33, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(btnExportSf9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                                .addComponent(jLabel68)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbFinalGradeId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(97, 97, 97))
                            .addComponent(tfFailedSubjects, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel69, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfEvaluation, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel70, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel71, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfSectionName5)
                            .addComponent(jLabel72, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfAdviserName5)
                            .addComponent(btnLoadGrades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel93, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel67)
                                    .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(tfGeneralAverage, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel66, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(jLabel116)
                                    .addComponent(jdcDateOfExport, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel23Layout.createSequentialGroup()
                                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(tfGradeLevel5, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                                            .addComponent(jLabel73, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(82, 82, 82)
                                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(tfSchoolYear6)
                                            .addComponent(jLabel74, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel70)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel71)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfSectionName5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel72)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfAdviserName5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jLabel73)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfGradeLevel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                        .addComponent(jLabel74)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfSchoolYear6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel65)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane33, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel68)
                    .addComponent(lbFinalGradeId))
                .addGap(15, 15, 15)
                .addComponent(jLabel66)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfGeneralAverage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel69)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfFailedSubjects, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel67)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfEvaluation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel93)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel116)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdcDateOfExport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLoadGrades)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExportSf9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane32.setViewportView(jPanel23);

        jSplitPane8.setRightComponent(jScrollPane32);

        javax.swing.GroupLayout sf9TabLayout = new javax.swing.GroupLayout(sf9Tab);
        sf9Tab.setLayout(sf9TabLayout);
        sf9TabLayout.setHorizontalGroup(
            sf9TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 1065, Short.MAX_VALUE)
        );
        sf9TabLayout.setVerticalGroup(
            sf9TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
        );

        sf10Tab.setBackground(new java.awt.Color(249, 239, 227));

        tpSf10Pane.setBackground(new java.awt.Color(255, 255, 204));

        jPanel25.setBackground(new java.awt.Color(249, 239, 227));

        lbSearchResult2.setForeground(new java.awt.Color(255, 255, 255));
        lbSearchResult2.setText("Search using the search bar...");

        enrolledStudentsTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "LRN", "Last Name", "First Name", "Middle Name", "Gender", "Initial Grade", "Current Grade", "School ID", "School Name", "School Address"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        enrolledStudentsTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        enrolledStudentsTable1.getTableHeader().setReorderingAllowed(false);
        enrolledStudentsTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                enrolledStudentsTable1loadStudentsAttendanceHandler(evt);
            }
        });
        jScrollPane35.setViewportView(enrolledStudentsTable1);
        if (enrolledStudentsTable1.getColumnModel().getColumnCount() > 0) {
            enrolledStudentsTable1.getColumnModel().getColumn(1).setResizable(false);
            enrolledStudentsTable1.getColumnModel().getColumn(1).setPreferredWidth(100);
            enrolledStudentsTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
            enrolledStudentsTable1.getColumnModel().getColumn(3).setPreferredWidth(100);
            enrolledStudentsTable1.getColumnModel().getColumn(4).setPreferredWidth(100);
            enrolledStudentsTable1.getColumnModel().getColumn(5).setResizable(false);
            enrolledStudentsTable1.getColumnModel().getColumn(5).setPreferredWidth(80);
            enrolledStudentsTable1.getColumnModel().getColumn(6).setResizable(false);
            enrolledStudentsTable1.getColumnModel().getColumn(6).setPreferredWidth(120);
            enrolledStudentsTable1.getColumnModel().getColumn(7).setResizable(false);
            enrolledStudentsTable1.getColumnModel().getColumn(7).setPreferredWidth(120);
            enrolledStudentsTable1.getColumnModel().getColumn(9).setPreferredWidth(200);
            enrolledStudentsTable1.getColumnModel().getColumn(10).setPreferredWidth(200);
        }

        tfSearchEnrolledStudent1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchEnrolledStudent1searchEnrolledStudentsHandler(evt);
            }
        });

        btnSearchEnrolledStudent1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/search_24px.png"))); // NOI18N
        btnSearchEnrolledStudent1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchEnrolledStudent1searchEnrolledStudentsHandler(evt);
            }
        });

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane35, javax.swing.GroupLayout.DEFAULT_SIZE, 1038, Short.MAX_VALUE)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(lbSearchResult2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(8, 8, 8)
                        .addComponent(tfSearchEnrolledStudent1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearchEnrolledStudent1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbSearchResult2)
                        .addComponent(btnSearchEnrolledStudent1))
                    .addComponent(tfSearchEnrolledStudent1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane35, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                .addContainerGap())
        );

        tpSf10Pane.addTab("Select Student", jPanel25);

        jPanel26.setBackground(new java.awt.Color(249, 239, 227));

        sf10Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Student ID", "LRN", "Name", "Gender", "Section ID", "Section Name", "Adv ID", "Adviser Name", "Gender", "Load ID", "Load Name", "Grade", "Subjects Contained", "School Year", "Remarks", "Date Enrolled", "Strand"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        sf10Table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        sf10Table.getTableHeader().setReorderingAllowed(false);
        sf10Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sf10TableloadStudentsAttendanceHandler(evt);
            }
        });
        jScrollPane36.setViewportView(sf10Table);
        if (sf10Table.getColumnModel().getColumnCount() > 0) {
            sf10Table.getColumnModel().getColumn(2).setResizable(false);
            sf10Table.getColumnModel().getColumn(2).setPreferredWidth(100);
            sf10Table.getColumnModel().getColumn(3).setPreferredWidth(200);
            sf10Table.getColumnModel().getColumn(4).setResizable(false);
            sf10Table.getColumnModel().getColumn(4).setPreferredWidth(80);
            sf10Table.getColumnModel().getColumn(6).setPreferredWidth(200);
            sf10Table.getColumnModel().getColumn(8).setPreferredWidth(200);
            sf10Table.getColumnModel().getColumn(9).setResizable(false);
            sf10Table.getColumnModel().getColumn(9).setPreferredWidth(80);
            sf10Table.getColumnModel().getColumn(11).setPreferredWidth(150);
            sf10Table.getColumnModel().getColumn(12).setResizable(false);
            sf10Table.getColumnModel().getColumn(12).setPreferredWidth(100);
            sf10Table.getColumnModel().getColumn(13).setPreferredWidth(200);
            sf10Table.getColumnModel().getColumn(14).setResizable(false);
            sf10Table.getColumnModel().getColumn(14).setPreferredWidth(100);
            sf10Table.getColumnModel().getColumn(15).setPreferredWidth(200);
            sf10Table.getColumnModel().getColumn(16).setResizable(false);
            sf10Table.getColumnModel().getColumn(16).setPreferredWidth(150);
        }

        btnUseSelectedSections.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/icons8_ok_16px.png"))); // NOI18N
        btnUseSelectedSections.setText("Use Selected Sections");
        btnUseSelectedSections.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUseSelectedSectionsActionPerformed(evt);
            }
        });

        jLabel75.setForeground(new java.awt.Color(255, 255, 255));
        jLabel75.setText("Maximum of 2 Entries can be Selected.");

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane36, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                        .addComponent(jLabel75)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 696, Short.MAX_VALUE)
                        .addComponent(btnUseSelectedSections)))
                .addContainerGap())
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane36, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUseSelectedSections)
                    .addComponent(jLabel75))
                .addContainerGap())
        );

        tpSf10Pane.addTab("Select Enrolled Sections", jPanel26);

        jPanel27.setBackground(new java.awt.Color(249, 239, 227));

        jSplitPane9.setBackground(new java.awt.Color(249, 239, 227));
        jSplitPane9.setBorder(null);
        jSplitPane9.setDividerLocation(700);

        sectionPanel1.setBackground(new java.awt.Color(249, 239, 227));

        gradesTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Grade ID", "Student ID", "Section ID", "Subject ID", "Code", "Description", "Q1", "Q2", "Q3", "Q4", "GWA", "Status", "Semester", "Date Updated"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        gradesTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        gradesTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane34.setViewportView(gradesTable1);
        if (gradesTable1.getColumnModel().getColumnCount() > 0) {
            gradesTable1.getColumnModel().getColumn(4).setPreferredWidth(80);
            gradesTable1.getColumnModel().getColumn(5).setPreferredWidth(200);
            gradesTable1.getColumnModel().getColumn(6).setResizable(false);
            gradesTable1.getColumnModel().getColumn(6).setPreferredWidth(50);
            gradesTable1.getColumnModel().getColumn(7).setResizable(false);
            gradesTable1.getColumnModel().getColumn(7).setPreferredWidth(50);
            gradesTable1.getColumnModel().getColumn(8).setResizable(false);
            gradesTable1.getColumnModel().getColumn(8).setPreferredWidth(50);
            gradesTable1.getColumnModel().getColumn(9).setResizable(false);
            gradesTable1.getColumnModel().getColumn(9).setPreferredWidth(50);
            gradesTable1.getColumnModel().getColumn(10).setResizable(false);
            gradesTable1.getColumnModel().getColumn(10).setPreferredWidth(80);
            gradesTable1.getColumnModel().getColumn(11).setResizable(false);
            gradesTable1.getColumnModel().getColumn(11).setPreferredWidth(120);
            gradesTable1.getColumnModel().getColumn(13).setResizable(false);
            gradesTable1.getColumnModel().getColumn(13).setPreferredWidth(150);
        }

        tfGeneralAverage1.setEditable(false);
        tfGeneralAverage1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel91.setForeground(new java.awt.Color(255, 255, 255));
        jLabel91.setText("General Average");

        jLabel92.setForeground(new java.awt.Color(255, 255, 255));
        jLabel92.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel92.setText("Remarks");

        tfEvaluation1.setEditable(false);
        tfEvaluation1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout sectionPanel1Layout = new javax.swing.GroupLayout(sectionPanel1);
        sectionPanel1.setLayout(sectionPanel1Layout);
        sectionPanel1Layout.setHorizontalGroup(
            sectionPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sectionPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sectionPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane34, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
                    .addGroup(sectionPanel1Layout.createSequentialGroup()
                        .addGroup(sectionPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tfGeneralAverage1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel91, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(sectionPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel92, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                            .addComponent(tfEvaluation1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        sectionPanel1Layout.setVerticalGroup(
            sectionPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sectionPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane34, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sectionPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sectionPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel91)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfGeneralAverage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(sectionPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel92)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfEvaluation1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        tpSf10DetailsTab.addTab("SECTION_1", sectionPanel1);

        sectionPanel2.setBackground(new java.awt.Color(249, 239, 227));

        gradesTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Grade ID", "Student ID", "Section ID", "Subject ID", "Code", "Description", "Q1", "Q2", "Q3", "Q4", "GWA", "Status", "Semester", "Date Updated"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        gradesTable2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        gradesTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane38.setViewportView(gradesTable2);
        if (gradesTable2.getColumnModel().getColumnCount() > 0) {
            gradesTable2.getColumnModel().getColumn(4).setPreferredWidth(80);
            gradesTable2.getColumnModel().getColumn(5).setPreferredWidth(200);
            gradesTable2.getColumnModel().getColumn(6).setResizable(false);
            gradesTable2.getColumnModel().getColumn(6).setPreferredWidth(50);
            gradesTable2.getColumnModel().getColumn(7).setResizable(false);
            gradesTable2.getColumnModel().getColumn(7).setPreferredWidth(50);
            gradesTable2.getColumnModel().getColumn(8).setResizable(false);
            gradesTable2.getColumnModel().getColumn(8).setPreferredWidth(50);
            gradesTable2.getColumnModel().getColumn(9).setResizable(false);
            gradesTable2.getColumnModel().getColumn(9).setPreferredWidth(50);
            gradesTable2.getColumnModel().getColumn(10).setResizable(false);
            gradesTable2.getColumnModel().getColumn(10).setPreferredWidth(80);
            gradesTable2.getColumnModel().getColumn(11).setResizable(false);
            gradesTable2.getColumnModel().getColumn(11).setPreferredWidth(120);
            gradesTable2.getColumnModel().getColumn(13).setResizable(false);
            gradesTable2.getColumnModel().getColumn(13).setPreferredWidth(150);
        }

        jLabel94.setForeground(new java.awt.Color(255, 255, 255));
        jLabel94.setText("General Average");

        tfGeneralAverage2.setEditable(false);
        tfGeneralAverage2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        tfEvaluation2.setEditable(false);
        tfEvaluation2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel95.setForeground(new java.awt.Color(255, 255, 255));
        jLabel95.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel95.setText("Remarks");

        javax.swing.GroupLayout sectionPanel2Layout = new javax.swing.GroupLayout(sectionPanel2);
        sectionPanel2.setLayout(sectionPanel2Layout);
        sectionPanel2Layout.setHorizontalGroup(
            sectionPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sectionPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sectionPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane38, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
                    .addGroup(sectionPanel2Layout.createSequentialGroup()
                        .addGroup(sectionPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tfGeneralAverage2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel94, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(sectionPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel95, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfEvaluation2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        sectionPanel2Layout.setVerticalGroup(
            sectionPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sectionPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane38, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sectionPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sectionPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel94)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfGeneralAverage2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(sectionPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel95)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfEvaluation2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        tpSf10DetailsTab.addTab("SECTION_2", sectionPanel2);

        jSplitPane9.setLeftComponent(tpSf10DetailsTab);

        jScrollPane37.setBorder(null);

        jPanel28.setBackground(new java.awt.Color(249, 239, 227));

        jPanel29.setBackground(new java.awt.Color(203, 184, 160));

        jLabel76.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(255, 255, 255));
        jLabel76.setText("Student Details");

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel76)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel76)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel77.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel77.setText("Educational Background");

        jLabel78.setText("First Name");

        tfFirstName.setEditable(false);

        jLabel79.setText("Middle Name");

        tfMiddleName.setEditable(false);

        jLabel80.setText("Last Name");

        tfLastName.setEditable(false);

        jLabel81.setText("Extention Name");

        tfExtentionName.setEditable(false);
        tfExtentionName.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel82.setText("Birth Date");

        tfBirthdate.setEditable(false);
        tfBirthdate.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel83.setText("LRN");

        tfLrn.setEditable(false);
        tfLrn.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel84.setText("Gender");

        tfGender.setEditable(false);
        tfGender.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel85.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel85.setText("Basic");

        jLabel86.setText("Junior High School Name");

        tfSchoolName.setEditable(false);

        jLabel87.setText("Address");

        tfSchoolAddress.setEditable(false);

        jLabel88.setText("School ID");

        tfSchoolId.setEditable(false);
        tfSchoolId.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel89.setText("General Average");

        tfInitialGrade.setEditable(false);
        tfInitialGrade.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnExportSf10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/icons8_print_16px.png"))); // NOI18N
        btnExportSf10.setText("Export SF10");
        btnExportSf10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportSf10ActionPerformed(evt);
            }
        });

        jLabel90.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel90.setText("Export Options");

        tfStrand.setEditable(false);
        tfStrand.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel122.setText("Strand");

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel77, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel78, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfFirstName)
                    .addComponent(jLabel79, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfMiddleName)
                    .addComponent(jLabel80, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfLastName)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel81, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tfExtentionName))
                            .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel84, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tfGender, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 40, Short.MAX_VALUE)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel83, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel82, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                            .addComponent(tfBirthdate)
                            .addComponent(tfLrn)))
                    .addComponent(jLabel86, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfSchoolName)
                    .addComponent(jLabel87, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfSchoolAddress)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel88, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfSchoolId, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 41, Short.MAX_VALUE)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfInitialGrade)
                            .addComponent(jLabel89, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)))
                    .addComponent(btnExportSf10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel90, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel85, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(tfStrand, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel122, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel85)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel78)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel79)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfMiddleName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel80)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(jLabel81)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfExtentionName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(jLabel82)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfBirthdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(jLabel83)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfLrn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(jLabel84)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel122)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfStrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel77)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel86)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfSchoolName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel87)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfSchoolAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(jLabel88)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfSchoolId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(jLabel89)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfInitialGrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel90)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExportSf10)
                .addContainerGap(86, Short.MAX_VALUE))
        );

        jScrollPane37.setViewportView(jPanel28);

        jSplitPane9.setRightComponent(jScrollPane37);

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane9)
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane9)
        );

        tpSf10Pane.addTab("SF10 Learner's Permanent Record", jPanel27);

        javax.swing.GroupLayout sf10TabLayout = new javax.swing.GroupLayout(sf10Tab);
        sf10Tab.setLayout(sf10TabLayout);
        sf10TabLayout.setHorizontalGroup(
            sf10TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpSf10Pane)
        );
        sf10TabLayout.setVerticalGroup(
            sf10TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpSf10Pane)
        );

        loadingDialog.setBackground(new java.awt.Color(249, 239, 227));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/Double Ring 100px.gif"))); // NOI18N

        jpbProgressBar.setValue(50);

        lbLoadingMessage.setText("Loading");

        btnCancelLoading.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/icons8_cancel_20px.png"))); // NOI18N
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
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpbProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                    .addComponent(lbLoadingMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelLoading, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        loadingDialogLayout.setVerticalGroup(
            loadingDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loadingDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
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
        setIconImage(my.getImgIcn(myVariables.getFormsWindowIcon()).getImage()
        );
        setMinimumSize(new java.awt.Dimension(1303, 782));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        kGradientPanel1.setkEndColor(new java.awt.Color(249, 238, 227));
        kGradientPanel1.setkStartColor(new java.awt.Color(249, 238, 227));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(1003, 600));

        headerPanel.setBackground(new java.awt.Color(251, 185, 211));
        headerPanel.setPreferredSize(new java.awt.Dimension(300, 723));

        jLabel118.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        jLabel118.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel118.setText("Forms System");
        jLabel118.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel119.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel119.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel119.setText("SHS");
        jLabel119.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/icons8_google_forms_20px.png"))); // NOI18N
        jButton1.setText("<html> <b>School Form 1</b> <br><small> School Register</small> </html>");
        jButton1.setToolTipText("School Register");
        jButton1.setActionCommand("<html> <b>School Form 1</b> <br><small> School Register</small> </html>");
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton1.setIconTextGap(10);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/icons8_google_forms_20px.png"))); // NOI18N
        jButton2.setText("<html> <b>School Forms 2</b> <br><small> Daily Attendance Report of Learners</small></html>");
        jButton2.setToolTipText("Daily Attendance Report of Learners");
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton2.setIconTextGap(10);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/icons8_google_forms_20px.png"))); // NOI18N
        jButton3.setText("<html><b>School Forms 3</b> <br><small> Books Issued and Returned</small></html>");
        jButton3.setToolTipText("Books Issued and Returned");
        jButton3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton3.setIconTextGap(10);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/icons8_google_forms_20px.png"))); // NOI18N
        jButton4.setText("<html><b>School Form 4</b> <br><small>Monthly Learner's Movement and Attendance</small></html>");
        jButton4.setToolTipText("Monthly Learner's Movement and Attendance");
        jButton4.setActionCommand("SF 4  \nMonthly Learner's Movement and Attendance");
        jButton4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton4.setIconTextGap(10);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/icons8_google_forms_20px.png"))); // NOI18N
        jButton5.setText("<html><b>School Form 5</b> <br><small>Report on Promotion and Level of Proficiency & Achievement</small></html>");
        jButton5.setToolTipText("Report on Promotion and Level of Proficiency & Achievement");
        jButton5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton5.setIconTextGap(10);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/icons8_google_forms_20px.png"))); // NOI18N
        jButton6.setText("<html><b>School Form 6</b> <br><small>Summarized Report on Promotion and Level of Proficiency</small></html>");
        jButton6.setToolTipText("Summarized Report on Promotion and Level of Proficiency");
        jButton6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton6.setIconTextGap(10);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/icons8_google_forms_20px.png"))); // NOI18N
        jButton7.setText("<html><b>School Form 7</b><br><small>School Personnel Assignment List and Basic Profile</small></html>");
        jButton7.setToolTipText("School Personnel Assignment List and Basic Profile");
        jButton7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton7.setIconTextGap(10);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/icons8_google_forms_20px.png"))); // NOI18N
        jButton8.setText("<html><b>School Form 8</b><br><small>Learner's Basic Health and Nutrition Report</small></html>");
        jButton8.setToolTipText("Learner's Basic Health and Nutrition Report");
        jButton8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton8.setIconTextGap(10);
        jButton8.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/icons8_google_forms_20px.png"))); // NOI18N
        jButton9.setText("<html><b>School Form 9</b><br><small>Student's Report Card</small></html>");
        jButton9.setToolTipText("Student's Report Card");
        jButton9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton9.setIconTextGap(10);
        jButton9.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        btnShowRankings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/icons8_prize_16px.png"))); // NOI18N
        btnShowRankings.setText("Student Rankings");
        btnShowRankings.setToolTipText("Student Rankings");
        btnShowRankings.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnShowRankings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowRankingsActionPerformed(evt);
            }
        });

        jLabel121.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/cbshs.png"))); // NOI18N

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/icons8_google_forms_20px.png"))); // NOI18N
        jButton10.setText("<html><b>School Form 10</b><br><small>Learner's Permanent Academic Record for Senior High School</small></html>");
        jButton10.setToolTipText("Learner's Permanent Academic Record for Senior High School");
        jButton10.setIconTextGap(10);
        jButton10.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(btnShowRankings, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jButton8, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jButton9, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jLabel119, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel118, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel117)
                .addGap(32, 32, 32))
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jLabel121, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel117)
                .addGap(26, 26, 26)
                .addComponent(jLabel121, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel119, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel118)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnShowRankings, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        contentPanel.setBackground(new java.awt.Color(249, 238, 227));
        contentPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));

        cards.setBackground(new java.awt.Color(249, 238, 227));
        cards.setLayout(new java.awt.CardLayout());

        card1.setBackground(new java.awt.Color(249, 238, 227));

        mainTab.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        mainTab.setToolTipText("");
        mainTab.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        mainTab.setMinimumSize(new java.awt.Dimension(100, 100));
        mainTab.setPreferredSize(new java.awt.Dimension(1068, 548));

        javax.swing.GroupLayout card1Layout = new javax.swing.GroupLayout(card1);
        card1.setLayout(card1Layout);
        card1Layout.setHorizontalGroup(
            card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1336, Short.MAX_VALUE)
            .addGroup(card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(mainTab, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1336, Short.MAX_VALUE))
        );
        card1Layout.setVerticalGroup(
            card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 789, Short.MAX_VALUE)
            .addGroup(card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(mainTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cards.add(card1, "card2");

        card2.setBackground(new java.awt.Color(249, 238, 227));

        rankingsDialog.setBackground(new java.awt.Color(249, 239, 227));

        jLabel51.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        jLabel51.setText("Student Rankings");

        grade11RankingTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Section ID", "Section Name", "School Year", "Grade", "Adviser ID", "Adviser Name", "Student ID", "LRN", "Student Name", "Strand", "Gender", "Remarks", "General Average", "Action Taken", "Date Updated", "Semester", "Rank"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        grade11RankingTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        grade11RankingTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane22.setViewportView(grade11RankingTable);
        if (grade11RankingTable.getColumnModel().getColumnCount() > 0) {
            grade11RankingTable.getColumnModel().getColumn(2).setPreferredWidth(150);
            grade11RankingTable.getColumnModel().getColumn(3).setResizable(false);
            grade11RankingTable.getColumnModel().getColumn(4).setResizable(false);
            grade11RankingTable.getColumnModel().getColumn(6).setPreferredWidth(200);
            grade11RankingTable.getColumnModel().getColumn(9).setPreferredWidth(200);
            grade11RankingTable.getColumnModel().getColumn(10).setResizable(false);
            grade11RankingTable.getColumnModel().getColumn(13).setResizable(false);
            grade11RankingTable.getColumnModel().getColumn(13).setPreferredWidth(150);
            grade11RankingTable.getColumnModel().getColumn(14).setPreferredWidth(120);
            grade11RankingTable.getColumnModel().getColumn(15).setResizable(false);
            grade11RankingTable.getColumnModel().getColumn(15).setPreferredWidth(150);
            grade11RankingTable.getColumnModel().getColumn(16).setResizable(false);
            grade11RankingTable.getColumnModel().getColumn(17).setResizable(false);
        }

        tpRankingsTab.addTab("Grade 11", jScrollPane22);

        grade12RankingTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Section ID", "Section Name", "School Year", "Grade", "Adviser ID", "Adviser Name", "Student ID", "LRN", "Student Name", "Strand", "Gender", "Remarks", "General Average", "Action Taken", "Date Updated", "Semester", "Rank"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        grade12RankingTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        grade12RankingTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane26.setViewportView(grade12RankingTable);
        if (grade12RankingTable.getColumnModel().getColumnCount() > 0) {
            grade12RankingTable.getColumnModel().getColumn(2).setPreferredWidth(150);
            grade12RankingTable.getColumnModel().getColumn(3).setResizable(false);
            grade12RankingTable.getColumnModel().getColumn(4).setResizable(false);
            grade12RankingTable.getColumnModel().getColumn(6).setPreferredWidth(200);
            grade12RankingTable.getColumnModel().getColumn(9).setPreferredWidth(200);
            grade12RankingTable.getColumnModel().getColumn(10).setResizable(false);
            grade12RankingTable.getColumnModel().getColumn(13).setResizable(false);
            grade12RankingTable.getColumnModel().getColumn(13).setPreferredWidth(150);
            grade12RankingTable.getColumnModel().getColumn(14).setPreferredWidth(120);
            grade12RankingTable.getColumnModel().getColumn(15).setResizable(false);
            grade12RankingTable.getColumnModel().getColumn(15).setPreferredWidth(150);
            grade12RankingTable.getColumnModel().getColumn(16).setResizable(false);
            grade12RankingTable.getColumnModel().getColumn(17).setResizable(false);
        }

        tpRankingsTab.addTab("Grade 12", jScrollPane26);

        btnRefreshRankings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/icons8_sync_16px.png"))); // NOI18N
        btnRefreshRankings.setText("Refresh");
        btnRefreshRankings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshRankingsActionPerformed(evt);
            }
        });

        jcbRankingSchoolYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2019", "2020", "2021" }));
        jcbRankingSchoolYear.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbRankingSchoolYearItemStateChanged(evt);
            }
        });

        jcbRankingNumberOfStudents.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Top 10", "Top 20" }));

        jcbRankingStrand.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "STEM", "ABM", "HUMMS", "GAS", "TVL" }));

        jcbRankingSemester.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st Semester", "2nd Semester" }));

        javax.swing.GroupLayout rankingsDialogLayout = new javax.swing.GroupLayout(rankingsDialog);
        rankingsDialog.setLayout(rankingsDialogLayout);
        rankingsDialogLayout.setHorizontalGroup(
            rankingsDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpRankingsTab, javax.swing.GroupLayout.DEFAULT_SIZE, 1336, Short.MAX_VALUE)
            .addGroup(rankingsDialogLayout.createSequentialGroup()
                .addComponent(jLabel51)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jcbRankingStrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbRankingNumberOfStudents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbRankingSemester, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbRankingSchoolYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRefreshRankings)
                .addContainerGap())
        );
        rankingsDialogLayout.setVerticalGroup(
            rankingsDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rankingsDialogLayout.createSequentialGroup()
                .addGroup(rankingsDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rankingsDialogLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(rankingsDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRefreshRankings)
                            .addComponent(jcbRankingSchoolYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbRankingNumberOfStudents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbRankingStrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbRankingSemester, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel51))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tpRankingsTab, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout card2Layout = new javax.swing.GroupLayout(card2);
        card2.setLayout(card2Layout);
        card2Layout.setHorizontalGroup(
            card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1336, Short.MAX_VALUE)
            .addGroup(card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(rankingsDialog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        card2Layout.setVerticalGroup(
            card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 789, Short.MAX_VALUE)
            .addGroup(card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(rankingsDialog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cards.add(card2, "card3");

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cards, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cards, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 829, Short.MAX_VALUE)
        );

        jMenuBar1.setToolTipText("");
        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/icons8-male-user_circle-20.png"))); // NOI18N

        logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/icons8-logout-rounded-up-20.png"))); // NOI18N
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
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1682, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 829, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        my.openWindow(this, new formsLogin());
        my.interrupMainThread();
        my.interrupSecondThread();
    }//GEN-LAST:event_formWindowClosed

    private void tfSearchTeacherLoadsearchSectionHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSearchTeacherLoadsearchSectionHandler
        searchSections();
    }//GEN-LAST:event_tfSearchTeacherLoadsearchSectionHandler

    private void btnSearchSectionsearchSectionHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchSectionsearchSectionHandler
        searchSections();
    }//GEN-LAST:event_btnSearchSectionsearchSectionHandler

    private void assignedTeacherTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_assignedTeacherTableMouseClicked
        if(evt.getClickCount() == 2){
            int row = assignedTeacherTable.getSelectedRow();
            String sectionName = assignedTeacherTable.getValueAt(row, 2).toString();
            String adviserName = assignedTeacherTable.getValueAt(row, 4).toString();
            String gradeLevel = assignedTeacherTable.getValueAt(row, 9).toString();
            int schoolYear = Integer.parseInt(assignedTeacherTable.getValueAt(row, 10).toString());
            
            switch(myVariables.getFormSelected()){
                case 1:{
                    tfSectionName.setText(sectionName);
                    tfAdviserName.setText(adviserName);
                    tfGradeLevel.setText("Grade "+gradeLevel);
                    tfSchoolYear.setText(schoolYear+"-"+String.valueOf(schoolYear+1));
                    
                    my.select_tab(mainTab, 2);
                    btnExportSf1.setEnabled(false);
                    break;
                }case 2:{
                    tfSectionName1.setText(sectionName);
                    tfAdviserName1.setText(adviserName);
                    tfGradeLevel1.setText("Grade "+gradeLevel);
                    tfSchoolYear1.setText(schoolYear+"-"+String.valueOf(schoolYear+1));
                    
                    my.select_tab(mainTab, 2);
                    my.select_tab(tpSf2Sf4TabbedPane, 0);
                    my.select_tab(tpSf2Sf4DetailsPane, 0);
                    
                    btnExportSf2.setEnabled(false);
                    break;
                }case 3:{
                    tfSectionName2.setText(sectionName);
                    tfAdviserName2.setText(adviserName);
                    tfGradeLevel2.setText("Grade "+gradeLevel);
                    tfSchoolYear2.setText(schoolYear+"-"+String.valueOf(schoolYear+1));
                    
                    my.select_tab(mainTab, 2);
                    btnExportSf3.setEnabled(false);
                    break;
                }case 4:{
                    tfSectionName1.setText(sectionName);
                    tfAdviserName1.setText(adviserName);
                    tfGradeLevel1.setText("Grade "+gradeLevel);
                    tfSchoolYear1.setText(schoolYear+"-"+String.valueOf(schoolYear+1));
                    
                    my.select_tab(mainTab, 2);
                    my.select_tab(tpSf2Sf4TabbedPane, 1);
                    my.select_tab(tpSf2Sf4DetailsPane, 1);
                    
                    btnExportSf2.setEnabled(false);
                    break;
                }case 5:{
                    String curriculum = assignedTeacherTable.getValueAt(row, 12).toString();
                    
                    tfSectionName3.setText(sectionName);
                    tfAdviserName3.setText(adviserName);
                    tfGradeLevel3.setText("Grade "+gradeLevel);
                    tfSchoolYear3.setText(schoolYear+"-"+String.valueOf(schoolYear+1));
                    tfCurriculum.setText(curriculum);
                    
                    my.select_tab(mainTab, 2);
                    my.select_tab(tpSf5Sf6Pane, 0);
                    my.select_tab(tpSf5Sf6DetailsPane, 0);
                    break;
                }case 6:{
                    //String curriculum = assignedTeacherTable.getValueAt(row, 12).toString();
                    
                    tfSectionName3.setText(sectionName);
                    tfAdviserName3.setText(adviserName);
                    tfGradeLevel3.setText("Grade "+gradeLevel);
                    tfSchoolYear3.setText(schoolYear+"-"+String.valueOf(schoolYear+1));
                    //tfCurriculum.setText(curriculum);
                    
                    my.select_tab(mainTab, 2);
                    my.select_tab(tpSf5Sf6Pane, 0);
                    my.select_tab(tpSf5Sf6DetailsPane, 0);
                    break;
                }case 8:{
                    tfSectionName4.setText(sectionName);
                    tfAdviserName4.setText(adviserName);
                    tfGradeLevel4.setText("Grade "+gradeLevel);
                    tfSchoolYear5.setText(schoolYear+"-"+String.valueOf(schoolYear+1));
                    
                    my.select_tab(mainTab, 2);
                    btnExportSf8.setEnabled(false);
                    break;
                }case 9:{
                    tfSectionName5.setText(sectionName);
                    tfAdviserName5.setText(adviserName);
                    tfGradeLevel5.setText("Grade "+gradeLevel);
                    tfSchoolYear6.setText(schoolYear+"-"+String.valueOf(schoolYear+1));
                    
                    my.clear_table_rows(enrolledStudentsTable);
                    my.select_tab(mainTab, 2);
                    clearGrades();
                    break;
                }
            }
        }else{
            
        }
    }//GEN-LAST:event_assignedTeacherTableMouseClicked

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        
    }//GEN-LAST:event_formWindowGainedFocus

    private void btnCancelLoadingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelLoadingActionPerformed
        //my.stopAllThreads();
        my.interruptThirdThread();
        my.interrupSecondThread();
        my.interrupMainThread();
    }//GEN-LAST:event_btnCancelLoadingActionPerformed

    private void btnLoadStudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadStudentsActionPerformed
        String firstFridayDate = "";
        
        if(myVariables.getFormSelected() != 1){
            Toolkit.getDefaultToolkit().beep();
            my.showMessage("SF1 Not Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            firstFridayDate = my.jCalendarToNumberDate(jdcFirstDayOfFridate.getDate().toString(), false);
        } catch (Exception e) {
            Toolkit.getDefaultToolkit().beep();
            my.showMessage("Invalid Date.", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int row = assignedTeacherTable.getSelectedRow();
        if(row == -1){
            Toolkit.getDefaultToolkit().beep();
            my.showMessage("No Section Selected.", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String sectionId = assignedTeacherTable.getValueAt(row, 1).toString();
        String sem = semesterSelect.getSelectedItem().toString();
        
        try{
             my.getStrandFromSectionID("form_sf1_view_shs","WHERE sectionId='"+sectionId+"'",myVariables.getShsf10Order());
             my.getSemFromSectionID("form_sf1_view_shs","WHERE sectionId='"+sectionId+"'",myVariables.getShsf10Order());

        }catch(Exception e){
            e.printStackTrace();
        }
        
       

        
        my.searchItemThread("",
                "WHERE sectionId='"+sectionId+"' AND sem = '"+sem+"'", 
                sf1StudentsTable, 10, 
                new int [] {4,5,6},
                new boolean[]{true,true}, 
                null,null,null
        );
        my.runSecondaryThread(0, true, 
                new JTable[]{sf1StudentsTable},
                new String[]{firstFridayDate},
                new JTextField[]{tfMaleCount,tfFemaleCount,tfTotalCount},
                new JButton[]{btnExportSf1},null
        );
    }//GEN-LAST:event_btnLoadStudentsActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        System.err.println("Frame mouse clicked");
    }//GEN-LAST:event_formMouseClicked

    private void btnExportSf1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportSf1ActionPerformed
        if(myVariables.getFormSelected() != 1){
            Toolkit.getDefaultToolkit().beep();
            my.showMessage("SF1 Not Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        my.runExportThread(
                new JTable[]{sf1StudentsTable},
                new String[]{},
                new JTextField[]{tfSectionName,tfAdviserName,tfGradeLevel,tfSchoolYear,tfMaleCount,tfFemaleCount,tfTotalCount}, 
                new JButton[]{btnExportSf1},
                new boolean[]{}
        );
    }//GEN-LAST:event_btnExportSf1ActionPerformed

    private void btnLoadStudents1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadStudents1ActionPerformed
        if(myVariables.getFormSelected() != 2){
            Toolkit.getDefaultToolkit().beep();
            my.showMessage("SF2 Not Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String firstDayOfMonth = "";
        String cutOffDate = "";
        try {
            firstDayOfMonth = my.jCalendarToNumberDate(jdcFirstDayOfMonth.getDate().toString(), false);
            cutOffDate = my.jCalendarToNumberDate(jdcCutOffDate.getDate().toString(), false);
        } catch (Exception e) {
            Toolkit.getDefaultToolkit().beep();
            my.showMessage("Invalid Date.", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int row = assignedTeacherTable.getSelectedRow();
        if(row == -1){
            Toolkit.getDefaultToolkit().beep();
            my.showMessage("No Section Selected.", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String sectionId = assignedTeacherTable.getValueAt(row, 1).toString();
        String subjectId = assignedTeacherTable.getValueAt(row, 6).toString();
        String substituteValue = "";
        boolean isSf2Selected = true;
        
        switch(jcbMissingValues.getSelectedIndex()){
            case 0:{
                substituteValue=" ";
                break;
            }case 1:{
                substituteValue="P";
                break;
            }case 2:{
                substituteValue="A";
                break;
            }case 3:{
                substituteValue="--";
                break;
            }default:{
                break;
            }
        }
        
        my.searchItemThread("", "WHERE sectionId='"+sectionId+"'", sf2Table, 11, new int [] {3,4,5}, new boolean[]{true,false}, null,new int[]{7,12,17,22},Color.RED);
        my.runSecondaryThread(1, true, 
                new JTable[]{weekDaysOfTheMonthTable,sf2Table,summarySf2,null}, 
                new String[]{sectionId,firstDayOfMonth,subjectId,cutOffDate,substituteValue}, 
                new JTextField[]{tfSchoolDays}, 
                new JButton[]{btnExportSf2},
                new boolean[]{true,isSf2Selected}
        );
    }//GEN-LAST:event_btnLoadStudents1ActionPerformed

    private void btnExportSf2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportSf2ActionPerformed
        if(myVariables.getFormSelected() != 2){
            Toolkit.getDefaultToolkit().beep();
            my.showMessage("SF2 Not Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String dateSelected = my.jCalendarToNumberDate(jdcFirstDayOfMonth.getDate().toString(), false);
        String dates [] = dateSelected.split("-");
        String monthSelected = my.numberToWordMonth(dates[1]);
        
        my.runExportThread(
                new JTable[]{weekDaysOfTheMonthTable,sf2Table,summarySf2},
                new String[]{monthSelected},
                new JTextField[]{tfSectionName1,tfAdviserName1,tfGradeLevel1,tfSchoolYear1,tfSchoolDays}, 
                new JButton[]{btnExportSf2},
                new boolean[]{}
        );
    }//GEN-LAST:event_btnExportSf2ActionPerformed

    private void btnLoadStudents2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadStudents2ActionPerformed
        String firstDayOfMonth = "";
        String cutOffDate = "";
        try {
            firstDayOfMonth = my.jCalendarToNumberDate(jdcFirstDayOfMonth1.getDate().toString(), false);
            cutOffDate = my.jCalendarToNumberDate(jdcCutOffDate1.getDate().toString(), false);
        } catch (Exception e) {
            Toolkit.getDefaultToolkit().beep();
            my.showMessage("Invalid Date.", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String substituteValue = "";
        
        switch(jcbMissingValues.getSelectedIndex()){
            case 0:{
                substituteValue=" ";
                break;
            }case 1:{
                substituteValue="P";
                break;
            }case 2:{
                substituteValue="A";
                break;
            }case 3:{
                substituteValue="--";
                break;
            }default:{
                break;
            }
        }
        
        my.runThirdThread(0, true, 
                new JTable[]{weekDaysOfTheMonthTable,sf2Table,summarySf2,sf4Table,assignedTeacherTable},
                new String[]{null,firstDayOfMonth,null,cutOffDate,substituteValue}, 
                new JTextField[]{tfSchoolDays,tfSectionName1,tfAdviserName1,tfGradeLevel1,tfSchoolYear1},
                new JButton[]{btnExportSf4,},null,null
        );
    }//GEN-LAST:event_btnLoadStudents2ActionPerformed

    private void btnExportSf4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportSf4ActionPerformed
        if(myVariables.getFormSelected() != 4){
            Toolkit.getDefaultToolkit().beep();
            my.showMessage("SF4 Not Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String dateSelected = my.jCalendarToNumberDate(jdcFirstDayOfMonth1.getDate().toString(), false);
        String dates [] = dateSelected.split("-");
        String monthSelected = my.numberToWordMonth(dates[1]);
        
        my.runExportThread(
                new JTable[]{sf4Table},
                new String[]{monthSelected,},
                new JTextField[]{tfSchoolYear7,}, 
                new JButton[]{btnExportSf4},
                new boolean[]{}
        );
    }//GEN-LAST:event_btnExportSf4ActionPerformed

    private void btnSelectAllSectionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectAllSectionsActionPerformed
        if(assignedTeacherTable.getRowCount() <= 0){
            playError();
            my.showMessage("No Sections Found.", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int schoolYear = 0;
        if(jcbSchoolYear1.getSelectedIndex() == 0){
            playError();
            my.showMessage("Please select only ONE School Year.", JOptionPane.ERROR_MESSAGE);
            my.clear_table_rows(assignedTeacherTable);
            return;
        }
        if(myVariables.getAccessLevel() == 5){
            playSuccess();
            System.err.println("Admin logged in.");
        }
        schoolYear = Integer.parseInt(jcbSchoolYear1.getSelectedItem().toString());
        tfSchoolYear7.setText(schoolYear+"-"+String.valueOf(schoolYear+1));
        btnExportSf4.setEnabled(false);
        
        myVariables.setSelectAllSectionsForSf4(true);
        my.select_tab(mainTab, 2);
        my.select_tab(tpSf2Sf4TabbedPane, 1);
        my.select_tab(tpSf2Sf4DetailsPane, 1);
    }//GEN-LAST:event_btnSelectAllSectionsActionPerformed

    private void btnOnlySelectedSectionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOnlySelectedSectionsActionPerformed
        if(assignedTeacherTable.getRowCount() <= 0){
            playError();
            my.showMessage("No Sections Found.", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int schoolYear = 0;
        if(jcbSchoolYear1.getSelectedIndex() == 0){
            playError();
            my.showMessage("Please select only ONE School Year.", JOptionPane.ERROR_MESSAGE);
            my.clear_table_rows(assignedTeacherTable);
            return;
        }
        if(myVariables.getAccessLevel() == 5){
            playSuccess();
            System.err.println("Admin logged in.");
        }
        
        int selectedRows [] = assignedTeacherTable.getSelectedRows();
        schoolYear = Integer.parseInt(jcbSchoolYear1.getSelectedItem().toString());
        
        tfSchoolYear7.setText(schoolYear+"-"+String.valueOf(schoolYear+1));
        btnExportSf4.setEnabled(false);
        
        if(selectedRows != null && selectedRows.length > 0){
            myVariables.setSelectAllSectionsForSf4(false);
            my.select_tab(mainTab, 2);
            my.select_tab(tpSf2Sf4TabbedPane, 1);
            my.select_tab(tpSf2Sf4DetailsPane, 1);
        }else{
            playError();
            my.showMessage("No Section(s) Selected.", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnOnlySelectedSectionsActionPerformed

    private void btnLoadStudents3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadStudents3ActionPerformed
        int row = assignedTeacherTable.getSelectedRow();
        if(row == -1){
            Toolkit.getDefaultToolkit().beep();
            my.showMessage("No Section Selected.", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String sectionId = assignedTeacherTable.getValueAt(row, 1).toString();
        String subjectId = assignedTeacherTable.getValueAt(row, 6).toString();
        String substituteValue = "";
        String remarksSubstituteValue = "";
        String booksContained = assignedTeacherTable.getValueAt(row, 13).toString();
        
        switch(jcbMissingValues2.getSelectedIndex()){
            case 0:{
                substituteValue=" ";
                break;
            }case 1:{
                substituteValue="--";
                break;
            }default:{
                break;
            }
        }
        switch(jcbMissingValues3.getSelectedIndex()){
            case 0:{
                remarksSubstituteValue="CODE";
                break;
            }case 1:{
                remarksSubstituteValue="NAME";
                break;
            }case 2:{
                remarksSubstituteValue="INDEX";
                break;
            }default:{
                break;
            }
        }
        
         try{
            my.getStrandFromSectionID("form_sf3_view_shs","WHERE sectionId='"+sectionId+"'",myVariables.getShsf3Order());
            my.getSemFromSectionID("form_sf3_view_shs","WHERE sectionId='"+sectionId+"'",myVariables.getShsf3Order());
        }catch(Exception e){
            e.printStackTrace();
        }
         
         myVariables.setSem(semesterSelect1.getSelectedItem().toString());
        
        my.runSecondaryThread(2, true,
                new JTable[]{sf3Table,sf3BooksTable},
                new String[]{sectionId,subjectId,substituteValue,remarksSubstituteValue,booksContained}, 
                new JTextField[]{tfSectionName2,tfAdviserName2,tfGradeLevel2,tfSchoolYear2}, 
                new JButton[]{btnExportSf3},
                null
        );
    }//GEN-LAST:event_btnLoadStudents3ActionPerformed

    private void btnExportSf3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportSf3ActionPerformed
        if(myVariables.getFormSelected() != 3){
            Toolkit.getDefaultToolkit().beep();
            my.showMessage("SF3 Not Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        my.runExportThread(
                new JTable[]{sf3Table,sf3BooksTable},
                new String[]{},
                new JTextField[]{tfSectionName2,tfAdviserName2,tfGradeLevel2,tfSchoolYear2}, 
                new JButton[]{btnExportSf3},
                new boolean[]{}
        );
    }//GEN-LAST:event_btnExportSf3ActionPerformed

    private void sf3TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sf3TableMouseClicked
        int row = sf3Table.getSelectedRow();
        int col = sf3Table.getSelectedColumn();
        
        if(col >= 5 && col < 25){
            sf3BooksTable.clearSelection();
            int index = 0;
            if(col%2==0){
                index = col-1;
            }else{
                index = col;
            }
            try {
                switch(index){
                    case 5:{
                        sf3BooksTable.setRowSelectionInterval(0, 0);break;
                    }case 7:{
                        sf3BooksTable.setRowSelectionInterval(1, 1);break;
                    }case 9:{
                        sf3BooksTable.setRowSelectionInterval(2, 2);break;
                    }case 11:{
                        sf3BooksTable.setRowSelectionInterval(3, 3);break;
                    }case 13:{
                        sf3BooksTable.setRowSelectionInterval(4, 4);break;
                    }case 15:{
                        sf3BooksTable.setRowSelectionInterval(5, 5);break;
                    }case 17:{
                        sf3BooksTable.setRowSelectionInterval(6, 6);break;
                    }case 19:{
                        sf3BooksTable.setRowSelectionInterval(7, 7);break;
                    }case 21:{
                        sf3BooksTable.setRowSelectionInterval(8, 8);break;
                    }case 23:{
                        sf3BooksTable.setRowSelectionInterval(9, 9);break;
                    }
                }
            } catch (Exception e) {
                sf3BooksTable.clearSelection();
            }
        }else{
            if(col == 25){
                try {
                    String remarks = sf3Table.getValueAt(row, 25).toString().trim();
                    if(remarks.trim().length() > 0){
                        Toolkit.getDefaultToolkit().beep();
                        my.showMessage("Remarks:\n\n"+remarks, JOptionPane.PLAIN_MESSAGE);
                    }
                    
                } catch (Exception e) {
                }
            }
            sf3BooksTable.clearSelection();
        }
    }//GEN-LAST:event_sf3TableMouseClicked

    private void btnLoadStudents4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadStudents4ActionPerformed
        int row = assignedTeacherTable.getSelectedRow();
        
        if(row == -1){
            Toolkit.getDefaultToolkit().beep();
            my.showMessage("No Section Selected.", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String sectionId = assignedTeacherTable.getValueAt(row, 1).toString();
        String gradeLevel = assignedTeacherTable.getValueAt(row, 9).toString();
        //int schoolYear = Integer.parseInt(assignedTeacherTable.getValueAt(row, 10).toString());
        boolean showIncompleteStudents = cbShowIncompleteStudents.isSelected();
        boolean compareToRankings = cbCompareToRankings.isSelected();
        
        String sem5 = semesterSelect5.getSelectedItem().toString();
        try{
             my.runSecondaryThread(3, false, 
                new JTable[]{sf5Table,sf5SummaryTable,sf5LevelOfProgress,null/*sf6Table*/,grade11RankingTable,grade12RankingTable}, 
                new String[]{sectionId,gradeLevel,sem5}, 
                new JTextField[]{tfStrand5},
                new JButton[]{btnLoadStudents4,btnExportSf5},
                new boolean[]{showIncompleteStudents,compareToRankings}
            );
        }catch(Exception e){
            e.printStackTrace();
        }
       
    }//GEN-LAST:event_btnLoadStudents4ActionPerformed

    private void sf5TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sf5TableMouseClicked
        int row = sf5Table.getSelectedRow();
        int col = sf5Table.getSelectedColumn();
        
        if(col == 10 && row != -1){
            String failedSubjects = sf5Table.getValueAt(row, col).toString();
            
            if(!failedSubjects.contains("All Subjects") && failedSubjects.trim().length()>0){
                Toolkit.getDefaultToolkit().beep();
                my.showMessage("This Student did not meet the School's Expectations on this/these Subject(s):\n\n"+failedSubjects+"\n\nPlease contact this Student's parents to inform them of this unfortunate event.",
                        JOptionPane.WARNING_MESSAGE
                );
            }
            if(failedSubjects.contains("All Subjects")){
                Toolkit.getDefaultToolkit().beep();
                my.showMessage("This Student did not meet the School's Expectations in all of his/her Subjects.\n\nPlease contact this Student's parents to inform them of this unfortunate event.",
                        JOptionPane.WARNING_MESSAGE
                );
            }
        }
    }//GEN-LAST:event_sf5TableMouseClicked

    private void btnShowRankingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowRankingsActionPerformed
        cards.removeAll();
        cards.add(card2);
        cards.repaint();
        cards.revalidate();
        
        btnShowRankings.setBackground(Color.decode("#FDE8F0"));
        
        jButton1.setBackground(Color.decode("#FBB9D3"));
        jButton2.setBackground(Color.decode("#FBB9D3"));
        jButton3.setBackground(Color.decode("#FBB9D3"));
        jButton4.setBackground(Color.decode("#FBB9D3"));
        jButton5.setBackground(Color.decode("#FBB9D3"));
        jButton6.setBackground(Color.decode("#FBB9D3"));
        jButton7.setBackground(Color.decode("#FBB9D3"));
        jButton8.setBackground(Color.decode("#FBB9D3"));
        jButton9.setBackground(Color.decode("#FBB9D3"));
        jButton10.setBackground(Color.decode("#FBB9D3"));
    }//GEN-LAST:event_btnShowRankingsActionPerformed

    private void btnRefreshRankingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshRankingsActionPerformed
        String numberOfStudentsToShow="";
        switch(jcbRankingNumberOfStudents.getSelectedIndex()){
            case 0:{
                numberOfStudentsToShow = "10";
                break;
            }case 1:{
                numberOfStudentsToShow = "20";
                break;
            }
        }
        
        String schoolYear = jcbRankingSchoolYear.getSelectedItem().toString();
        String strand = jcbRankingStrand.getSelectedItem().toString();
        String sem = jcbRankingSemester.getSelectedItem().toString();
        
        my.runSecondaryThread(4, true, 
                new JTable[]{grade11RankingTable,grade12RankingTable},
                new String []{numberOfStudentsToShow,schoolYear,strand,sem},
                new JTextField[]{},
                new JButton[]{btnRefreshRankings},
                new boolean[]{}
        );
    }//GEN-LAST:event_btnRefreshRankingsActionPerformed

    private void jcbRankingSchoolYearItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbRankingSchoolYearItemStateChanged
        System.err.println("Item Changed");
    }//GEN-LAST:event_jcbRankingSchoolYearItemStateChanged

    private void btnOnlySelectedSections1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOnlySelectedSections1ActionPerformed
        if(assignedTeacherTable.getRowCount() <= 0){
            playError();
            my.showMessage("No Sections Found.", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(jcbSchoolYear1.getSelectedIndex() == 0){
            playError();
            my.showMessage("Please select only ONE School Year.", JOptionPane.ERROR_MESSAGE);
            my.clear_table_rows(assignedTeacherTable);
            return;
        }
        if(myVariables.getAccessLevel() == 5){
            playSuccess();
            System.err.println("Admin logged in.");
        }
        
        int selectedRows [] = assignedTeacherTable.getSelectedRows();
        int schoolYear = Integer.parseInt(jcbSchoolYear1.getSelectedItem().toString());
        
        if(selectedRows != null && selectedRows.length > 0){
            btnExportSf6.setEnabled(false);
            
            myVariables.setSelectAllSectionsForSf6(false);
            my.select_tab(mainTab, 2);
            my.select_tab(tpSf5Sf6Pane, 1);
            my.select_tab(tpSf5Sf6DetailsPane, 1);
            
            tfSchoolYear4.setText(schoolYear+"-"+(schoolYear+1));
        }else{
            playError();
            my.showMessage("No Section(s) Selected.", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnOnlySelectedSections1ActionPerformed

    private void btnSelectAllSections1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectAllSections1ActionPerformed
        if(assignedTeacherTable.getRowCount() <= 0){
            playError();
            my.showMessage("No Sections Found.", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(jcbSchoolYear1.getSelectedIndex() == 0){
            playError();
            my.showMessage("Please select only ONE School Year.", JOptionPane.ERROR_MESSAGE);
            my.clear_table_rows(assignedTeacherTable);
            return;
        }
        if(myVariables.getAccessLevel() == 5){
            playSuccess();
            System.err.println("Admin logged in.");
        }
        int schoolYear = Integer.parseInt(jcbSchoolYear1.getSelectedItem().toString());
        
        btnExportSf6.setEnabled(false);
        myVariables.setSelectAllSectionsForSf6(true);
        my.select_tab(mainTab, 2);
        my.select_tab(tpSf5Sf6Pane, 1);
        my.select_tab(tpSf5Sf6DetailsPane, 1);
        tfSchoolYear4.setText(schoolYear+"-"+(schoolYear+1));
    }//GEN-LAST:event_btnSelectAllSections1ActionPerformed

    private void btnLoadStudents5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadStudents5ActionPerformed
        boolean showIncompleteStudents = cbShowIncompleteStudents1.isSelected();
        
        my.runThirdThread(1, true, 
                new JTable[]{sf5Table,sf5SummaryTable,sf5LevelOfProgress,sf6Table,grade11RankingTable,grade12RankingTable,assignedTeacherTable},
                new String[]{},
                new JTextField[]{},
                new JButton[]{btnLoadStudents5,btnExportSf6},
                new boolean[]{showIncompleteStudents,true,myVariables.isSelectAllSectionsForSf6()},
                null
        );
    }//GEN-LAST:event_btnLoadStudents5ActionPerformed

    private void btnSearchEnrolledStudentsearchEnrolledStudentsHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchEnrolledStudentsearchEnrolledStudentsHandler
        int row = assignedTeacherTable.getSelectedRow();

        if(row == -1){
            Toolkit.getDefaultToolkit().beep();
            my.showMessage("Please select a section first.", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String sectionId = assignedTeacherTable.getValueAt(row, 1).toString();
        String toSearch = tfSearchEnrolledStudent.getText();
        
        clearGrades();
        String where = "WHERE sectionId='"+sectionId+"' AND (lrn='"+toSearch+"' OR lName LIKE '%"+toSearch+"%' OR fName LIKE '%"+toSearch+"%' OR mName LIKE '%"+toSearch+"%')";
        my.searchItem(where, enrolledStudentsTable, 15, null, new int [] {3,4,5}, true, true, lbSearchResult1, tfSearchEnrolledStudent, true);
    }//GEN-LAST:event_btnSearchEnrolledStudentsearchEnrolledStudentsHandler

    private void enrolledStudentsTableloadStudentsAttendanceHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_enrolledStudentsTableloadStudentsAttendanceHandler
        int row = enrolledStudentsTable.getSelectedRow();
        
        if(row != -1 && evt.getClickCount() == 2){
            
        }else{
            clearGrades();
        }
    }//GEN-LAST:event_enrolledStudentsTableloadStudentsAttendanceHandler

    private void btnLoadGradesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadGradesActionPerformed
        int sectionRow = assignedTeacherTable.getSelectedRow();
        int studentRow = enrolledStudentsTable.getSelectedRow();

        if(sectionRow == -1){
            Toolkit.getDefaultToolkit().beep();
            my.showMessage("Please Select a Section.", JOptionPane.WARNING_MESSAGE);
            return;
        }if(studentRow == -1){
            Toolkit.getDefaultToolkit().beep();
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
                //Load and compute updated grades
                    //jephthah is here
                    System.out.println("Entry Here");
                    String where2 = "";
                    where2 = "WHERE sectionId='"+sectionId+"' "
                            + "AND studentId='"+studentId+"' ";
                    String result2 [] = my.return_values("*", "form_sf9_view_shs", where2, myVariables.getShsf9Order());

                    //computing general average
                    int generalAverage = 0;
                    for(int x = 0; x < result2.length; x++){
                        String rgwa = my.getValueAtColumn(result2[x], 10);
                        if("".equals(rgwa)){
                            continue;
                        }
                        generalAverage += Integer.parseInt(my.getValueAtColumn(result2[x], 10));
                    }
                    generalAverage = generalAverage/result2.length;
                    String gwa2 = String.valueOf(generalAverage);
                    System.out.print("Total General Average: "+gwa2+" ");
                    //computing general average

                    //checking failed subjects
                    String failedSubjects2 = "";
                    for(int x = 0; x < result2.length; x++){
                        String rgwa = my.getValueAtColumn(result2[x], 10);
                        if("".equals(rgwa)){
                            continue;
                        }
                        int temp = Integer.parseInt(my.getValueAtColumn(result2[x], 10));
                        if(temp < 75){
                            String subjectCode = my.getValueAtColumn(result2[x], 3);
                            failedSubjects2 += subjectCode+":";
                        }
                    }
                    System.out.print("Failed Subjects: "+failedSubjects2+" ");
                    //checking failed subjects

                    //set final status
                    String status = "";
                    String hasIncompleteGrade = "";
                    for(int x = 0; x < result2.length; x++){
                        String temp1 = my.getValueAtColumn(result2[x], 6);
                        String temp2 = my.getValueAtColumn(result2[x], 7);
                        if(temp1 == null || temp2 == null){
                            hasIncompleteGrade = "Yes";
                        }
                    }
                    if(!"".equals(failedSubjects2)){ //kung naay unod ang failed subjects edi bagsak
                        status = "Failed";
                    }else if(generalAverage < 75){
                        status = "Failed";
                    }else if("Yes".equals(hasIncompleteGrade)){
                        status = "Incomplete";
                    }else{
                        status = "Passed";
                    }
                    System.out.print("Final Status: "+status+" ");
                    //set final status

                    String [] sets = {
                        "generalAverage='"+generalAverage+"'",
                        "actionTaken='"+status+"'",
                        "failedSubjects='"+failedSubjects2+"'",
                        "dateUpdated=now()",
                    };
                    
                    System.out.println("Out Here");
                    //jephthah is here
                
                //Load previous grade
                System.out.println("Entry Here 2");
                String result [] = my.return_values("*", "finalgrades",where, myVariables.getFinalGradesOrder());
                String id = my.getValueAtColumn(result[0], 0);
                String gwa = my.getValueAtColumn(result[0], 3);
                String evaluation = my.getValueAtColumn(result[0], 4);
                String failedSubjects = my.getValueAtColumn(result[0], 5);
                //String dateUpdated = my.getValueAtColumn(result[0], 6);
                System.out.println("Out Here 2");
                
                //Compare computed grade and previous grade
                System.out.println("Entry Here 3");
                String needToUpdate = "";
                if( !gwa2.equals(gwa) || !status.equals(evaluation) || !failedSubjects2.equals(failedSubjects)){
                    needToUpdate = "Yes";
                }
                if( "Yes".equals(needToUpdate)){
                    my.update_values("finalgrades", sets, "id='"+id+"'");
                    System.out.println("Update Success");
                }
                System.out.println("Out Here 3");
                //Compare computed grade and previous grade
                
                //Load update grade
                System.out.println("Entry Here 4");
                String result3 [] = my.return_values("*", "finalgrades",where, myVariables.getFinalGradesOrder());
                String id3 = my.getValueAtColumn(result3[0], 0);
                String gwa3 = my.getValueAtColumn(result3[0], 3);
                String evaluation3 = my.getValueAtColumn(result3[0], 4);
                String failedSubjects3 = my.getValueAtColumn(result3[0], 5);
                //String dateUpdated3 = my.getValueAtColumn(result3[0], 6);

                lbFinalGradeId.setText(id3);
                tfGeneralAverage.setText(gwa3);
                tfFailedSubjects.setText(failedSubjects3);
                btnExportSf9.setEnabled(true);
                tfEvaluation.setText(evaluation3.toUpperCase());
                System.out.println("Out Here 4");
                return;
            }else{
                //Ask to add new record
                if(my.getConfirmation("This student has no records yet. Add one now?")){
                    //jephthah is here
                    String where2 = "";
                    where2 = "WHERE sectionId='"+sectionId+"' "
                            + "AND studentId='"+studentId+"' ";
                    String result2 [] = my.return_values("*", "form_sf9_view_shs", where2, myVariables.getShsf9Order());

                    //computing general average
                    int generalAverage = 0;
                    for(int x = 0; x < result2.length; x++){
                        String rgwa = my.getValueAtColumn(result2[x], 10);
                        if("".equals(rgwa)){
                            continue;
                        }
                        generalAverage += Integer.parseInt(my.getValueAtColumn(result2[x], 10));
                    }
                    generalAverage = generalAverage/result2.length;
                    System.out.print("Total General Average: "+generalAverage+" ");
                    //computing general average

                    //checking failed subjects
                    String failedSubjects2 = "";
                    for(int x = 0; x < result2.length; x++){
                        String rgwa = my.getValueAtColumn(result2[x], 10);
                        if("".equals(rgwa)){
                            continue;
                        }
                        int temp = Integer.parseInt(my.getValueAtColumn(result2[x], 10));
                        if(temp < 75){
                            String subjectCode = my.getValueAtColumn(result2[x], 3);
                            failedSubjects2 += subjectCode+":";
                        }
                    }
                    System.out.print("Failed Subjects: "+failedSubjects2+" ");
                    //checking failed subjects

                    //set final status
                    String status = "";
                    String hasIncompleteGrade = "";
                    for(int x = 0; x < result2.length; x++){
                        String temp1 = my.getValueAtColumn(result2[x], 6);
                        String temp2 = my.getValueAtColumn(result2[x], 7);
                        if(temp1 == null || temp2 == null){
                            hasIncompleteGrade = "Yes";
                        }
                    }
                    if(!"".equals(failedSubjects2)){ //kung naay unod ang failed subjects edi bagsak
                        status = "Failed";
                    }else if(generalAverage < 75){
                        status = "Failed";
                    }else if("Yes".equals(hasIncompleteGrade)){
                        status = "Incomplete";
                    }else{
                        status = "Passed";
                    }
                    System.out.print("Final Status: "+status+" ");
                    //set final status

                    String [] values2 = {"null,'"+sectionId+"','"+studentId+"','"+generalAverage+"','"+status+"','"+failedSubjects2+"'",};

                    //jephthah is here
                    if(my.add_values("finalgrades", "id,sectionId,studentId,generalAverage,actionTaken,failedSubjects", values2)){
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
        
        my.runSecondaryThread(6, true,
                new JTable[]{gradesTable},
                new String[]{studentId,sectionId,subjectsContained},
                new JTextField[]{tfGeneralAverage,tfFailedSubjects,tfEvaluation},
                new JButton[]{btnLoadGrades,btnExportSf9},
                new boolean[]{true}
        );
    }//GEN-LAST:event_btnLoadGradesActionPerformed

    private void btnExportSf9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportSf9ActionPerformed
        if(myVariables.getFormSelected() != 9){
            Toolkit.getDefaultToolkit().beep();
            my.showMessage("SF9 Not Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(jdcDateOfExport.getDate() == null){
            Toolkit.getDefaultToolkit().beep();
            my.showMessage("No Date Selected.", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String dateOfExport = my.jCalendarToNumberDate(jdcDateOfExport.getDate().toString(), false);
        
        int row = enrolledStudentsTable.getSelectedRow();
        if(row  == -1 ){
            playError();
            my.showMessage("No Student Selected.", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String dateOfBirth = " ";
        String age = " ";
        
        String lrn = enrolledStudentsTable.getValueAt(row, 2).toString();
        String studentName = enrolledStudentsTable.getValueAt(row, 3).toString();
        String sex = enrolledStudentsTable.getValueAt(row, 4).toString();
        String strand = enrolledStudentsTable.getValueAt(row, 7).toString();
        
        try {
            dateOfBirth = enrolledStudentsTable.getValueAt(row, 5).toString();
            age = my.getAgeInYearsMonths(dateOfExport, dateOfBirth, false);
        } catch (Exception e) {
            playError();
            System.err.println("Error Calculating Age...");
        }
        
        my.runExportThread(
                new JTable[]{gradesTable},
                new String[]{lrn,studentName,sex,strand,age},
                new JTextField[]{tfSectionName5,tfAdviserName5,tfGradeLevel5,tfSchoolYear6,tfGeneralAverage,tfFailedSubjects,tfEvaluation}, 
                new JButton[]{btnExportSf9,},
                new boolean[]{}
        );
    }//GEN-LAST:event_btnExportSf9ActionPerformed

    private void enrolledStudentsTable1loadStudentsAttendanceHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_enrolledStudentsTable1loadStudentsAttendanceHandler
        int row = enrolledStudentsTable1.getSelectedRow();
        
        if(evt.getClickCount() == 2){
            tpSf10Pane.setSelectedIndex(1);
            String studentId = enrolledStudentsTable1.getValueAt(row, 0).toString();
            String lrn = enrolledStudentsTable1.getValueAt(row, 1).toString();
            
            String names [] = my.separateLastNameExtention(enrolledStudentsTable1.getValueAt(row, 2).toString());
            
            String lName = names[0];
            String extName = names[1];
            String fName = enrolledStudentsTable1.getValueAt(row, 3).toString();
            String mName = enrolledStudentsTable1.getValueAt(row, 4).toString();
            
            String gender = enrolledStudentsTable1.getValueAt(row, 5).toString();
            String inGrade = enrolledStudentsTable1.getValueAt(row, 6).toString();
            
            String schoolId = enrolledStudentsTable1.getValueAt(row, 8).toString();
            String schoolName = enrolledStudentsTable1.getValueAt(row, 9).toString();
            String address = enrolledStudentsTable1.getValueAt(row, 10).toString();
            
            tfLrn.setText(lrn);
            tfFirstName.setText(fName);
            tfMiddleName.setText(mName);
            tfLastName.setText(lName);
            tfExtentionName.setText(extName);
            
            tfGender.setText(gender);
            
            tfInitialGrade.setText(inGrade);
            
            tfSchoolId.setText(schoolId);
            tfSchoolName.setText(schoolName);
            tfSchoolAddress.setText(address);
            
            String where = "WHERE studentId='"+studentId+"'";
            String result[] = my.return_values("*", "form_sf10_view_shs", where, myVariables.getShsf10Order());
            String strand = my.getValueAtColumn(result[0], 21);
            tfStrand.setText(strand);
            
            my.runSecondaryThread(7, true,
                    new JTable[]{sf10Table},
                    new String[]{studentId},
                    new JTextField[]{tfBirthdate},
                    new JButton[]{btnUseSelectedSections}, 
                    new boolean[]{}
            );
        }else{
            resetSf10Values(true, true, true, true, false);
        }
    }//GEN-LAST:event_enrolledStudentsTable1loadStudentsAttendanceHandler

    private void btnSearchEnrolledStudent1searchEnrolledStudentsHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchEnrolledStudent1searchEnrolledStudentsHandler
        if(myVariables.getFormSelected() != 10){
            playError();
            my.showMessage("SF10 Not Selected.", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String toSearch = tfSearchEnrolledStudent1.getText();
        
        resetSf10Values(true, true, true, true, false);
        String where = "WHERE lrn='"+toSearch+"' OR lName LIKE '%"+toSearch+"%' OR fName LIKE '%"+toSearch+"%' OR mName LIKE '%"+toSearch+"%'";
        my.searchItem(where, enrolledStudentsTable1, 0, null, null, true, true, lbSearchResult2, tfSearchEnrolledStudent1, true);
    }//GEN-LAST:event_btnSearchEnrolledStudent1searchEnrolledStudentsHandler

    private void sf10TableloadStudentsAttendanceHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sf10TableloadStudentsAttendanceHandler
        // TODO add your handling code here:
    }//GEN-LAST:event_sf10TableloadStudentsAttendanceHandler

    private void btnExportSf10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportSf10ActionPerformed
        if(myVariables.getFormSelected() != 10){
            Toolkit.getDefaultToolkit().beep();
            my.showMessage("SF10 Not Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        my.runExportThread(
                new JTable[]{sf10Table,gradesTable1,gradesTable2,},
                new String[]{},
                new JTextField[]{tfFirstName,tfMiddleName,tfLastName,tfExtentionName,tfBirthdate,tfGender,tfLrn,
                    tfSchoolName,tfSchoolAddress,tfSchoolId,tfInitialGrade,
                    tfGeneralAverage1,tfGeneralAverage2,
                    tfEvaluation1,tfEvaluation2,tfStrand,
                }, 
                new JButton[]{btnExportSf10,},
                new boolean[]{}
        );
    }//GEN-LAST:event_btnExportSf10ActionPerformed

    private void btnUseSelectedSectionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUseSelectedSectionsActionPerformed
        if(sf10Table.getSelectedRowCount() == 0){
            Toolkit.getDefaultToolkit().beep();
            my.showMessage("No Sections Selected. Please select at least ONE.", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (sf10Table.getSelectedRowCount() > 2) {
            Toolkit.getDefaultToolkit().beep();
            my.showMessage("Only a maximum of TWO Sections can only be selected.", JOptionPane.WARNING_MESSAGE);
            return;
        }
        resetSf10Values(false, false, true, false, true);
        
        my.runThirdThread(2, true,
                new JTable[]{sf10Table,gradesTable1,gradesTable2},
                new String[]{},
                new JTextField[]{tfGeneralAverage1,tfGeneralAverage2,
                    tfEvaluation1,tfEvaluation2,
                },
                new JButton[]{btnExportSf10},
                new boolean[]{},
                new JTabbedPane[]{tpSf10DetailsTab}
        );
        tpSf10Pane.setSelectedIndex(2);
    }//GEN-LAST:event_btnUseSelectedSectionsActionPerformed

    private void btnLoadTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadTeacherActionPerformed
        String schoolYear = jcbSchoolYear2.getSelectedItem().toString();
       
        
       //form7add 
       String sem7 = semesterSelect7.getSelectedItem().toString(); 
        
        
        my.runSecondaryThread(8, true,
                new JTable[]{sf7TeachersTable,sf7AssignedSubjectsTable},
                new String[]{schoolYear,sem7},
                new JTextField[]{},
                new JButton[]{btnLoadTeacher,btnExportSf7},
                new boolean[]{cbRemoveTeachersWNoSubjects.isSelected(),}
        );
    }//GEN-LAST:event_btnLoadTeacherActionPerformed

    private void btnExportSf7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportSf7ActionPerformed
        if(myVariables.getFormSelected() != 7){
            Toolkit.getDefaultToolkit().beep();
            my.showMessage("SF7 Not Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        //form7add
        String sem7 = semesterSelect7.getSelectedItem().toString(); 
        if (sem7 == "All"){sem7 = "1st and 2nd Semester";};
        System.out.println(sem7);
        my.runThirdThread(3, false,
                new JTable[]{sf7TeachersTable,sf7AssignedSubjectsTable},
                new String[]{jcbSchoolYear2.getSelectedItem().toString(),sem7},
                new JTextField[]{},
                new JButton[]{btnExportSf7},
                new boolean[]{cbUseCodeAsName.isSelected(),cbUseAcronyms.isSelected()},
                null
        );
    }//GEN-LAST:event_btnExportSf7ActionPerformed

    private void sf7TeachersTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sf7TeachersTableMouseClicked
        if(evt.getClickCount() == 2){
            int row = sf7TeachersTable.getSelectedRow();
            String userId = sf7TeachersTable.getValueAt(row, 0).toString();
            
            //selectItemsFromTable(sf7AssignedSubjectsTable,0, userId, true);
            my.runSecondaryThread(9, true, 
                    new JTable[]{sf7AssignedSubjectsTable,sf7TeachersTable}, 
                    new String[]{"1",userId}, 
                    new JTextField[]{},
                    new JButton[]{},
                    new boolean[]{true}
            );
        }else{
            sf7AssignedSubjectsTable.clearSelection();
        }
    }//GEN-LAST:event_sf7TeachersTableMouseClicked

    private void btnExportSf5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportSf5ActionPerformed
        if(myVariables.getFormSelected() != 5){
            Toolkit.getDefaultToolkit().beep();
            my.showMessage("SF5 Not Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String sem5 = semesterSelect5.getSelectedItem().toString();
        if(sem5 == "All"){sem5 = "1st and 2nd Semester";};
        System.out.println(sem5);
        
        my.runExportThread(
                new JTable[]{sf5Table,sf5SummaryTable,sf5LevelOfProgress},
                new String[]{sem5},
                new JTextField[]{tfSectionName3,tfAdviserName3,tfGradeLevel3,tfSchoolYear3,tfCurriculum,tfStrand5}, 
                new JButton[]{btnExportSf5},
                new boolean[]{}
        );
    }//GEN-LAST:event_btnExportSf5ActionPerformed

    private void btnExportSf6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportSf6ActionPerformed
        if(myVariables.getFormSelected() != 6){
            Toolkit.getDefaultToolkit().beep();
            my.showMessage("SF6 Not Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        my.runExportThread(
                new JTable[]{sf6Table},
                new String[]{},
                new JTextField[]{tfSchoolYear4,}, 
                new JButton[]{btnExportSf6},
                new boolean[]{}
        );
    }//GEN-LAST:event_btnExportSf6ActionPerformed

    private void cbUseCodeAsNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbUseCodeAsNameActionPerformed
        if(cbUseCodeAsName.isSelected()){
            cbUseAcronyms.setSelected(false);
        }
    }//GEN-LAST:event_cbUseCodeAsNameActionPerformed

    private void cbUseAcronymsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbUseAcronymsActionPerformed
        if(cbUseAcronyms.isSelected()){
            cbUseCodeAsName.setSelected(false);
        }
    }//GEN-LAST:event_cbUseAcronymsActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        selectFormToExport(1);
        cards.removeAll();
        cards.add(card1);
        cards.repaint();
        cards.revalidate();
        
        jButton1.setBackground(Color.decode("#FDE8F0"));
        
        jButton2.setBackground(Color.decode("#FBB9D3"));
        jButton3.setBackground(Color.decode("#FBB9D3"));
        jButton4.setBackground(Color.decode("#FBB9D3"));
        jButton5.setBackground(Color.decode("#FBB9D3"));
        jButton6.setBackground(Color.decode("#FBB9D3"));
        jButton7.setBackground(Color.decode("#FBB9D3"));
        jButton8.setBackground(Color.decode("#FBB9D3"));
        jButton9.setBackground(Color.decode("#FBB9D3"));
        jButton10.setBackground(Color.decode("#FBB9D3"));
        btnShowRankings.setBackground(Color.decode("#FBB9D3"));
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        selectFormToExport(2);
        cards.removeAll();
        cards.add(card1);
        cards.repaint();
        cards.revalidate();
        
        jButton2.setBackground(Color.decode("#FDE8F0"));
        
        jButton1.setBackground(Color.decode("#FBB9D3"));
        jButton3.setBackground(Color.decode("#FBB9D3"));
        jButton4.setBackground(Color.decode("#FBB9D3"));
        jButton5.setBackground(Color.decode("#FBB9D3"));
        jButton6.setBackground(Color.decode("#FBB9D3"));
        jButton7.setBackground(Color.decode("#FBB9D3"));
        jButton8.setBackground(Color.decode("#FBB9D3"));
        jButton9.setBackground(Color.decode("#FBB9D3"));
        jButton10.setBackground(Color.decode("#FBB9D3"));
        btnShowRankings.setBackground(Color.decode("#FBB9D3"));
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        selectFormToExport(3);
        cards.removeAll();
        cards.add(card1);
        cards.repaint();
        cards.revalidate();
        
        jButton3.setBackground(Color.decode("#FDE8F0"));
        
        jButton1.setBackground(Color.decode("#FBB9D3"));
        jButton2.setBackground(Color.decode("#FBB9D3"));
        jButton4.setBackground(Color.decode("#FBB9D3"));
        jButton5.setBackground(Color.decode("#FBB9D3"));
        jButton6.setBackground(Color.decode("#FBB9D3"));
        jButton7.setBackground(Color.decode("#FBB9D3"));
        jButton8.setBackground(Color.decode("#FBB9D3"));
        jButton9.setBackground(Color.decode("#FBB9D3"));
        jButton10.setBackground(Color.decode("#FBB9D3"));
        btnShowRankings.setBackground(Color.decode("#FBB9D3"));
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        selectFormToExport(4);
        cards.removeAll();
        cards.add(card1);
        cards.repaint();
        cards.revalidate();
        
        jButton4.setBackground(Color.decode("#FDE8F0"));
        
        jButton2.setBackground(Color.decode("#FBB9D3"));
        jButton3.setBackground(Color.decode("#FBB9D3"));
        jButton1.setBackground(Color.decode("#FBB9D3"));
        jButton5.setBackground(Color.decode("#FBB9D3"));
        jButton6.setBackground(Color.decode("#FBB9D3"));
        jButton7.setBackground(Color.decode("#FBB9D3"));
        jButton8.setBackground(Color.decode("#FBB9D3"));
        jButton9.setBackground(Color.decode("#FBB9D3"));
        jButton10.setBackground(Color.decode("#FBB9D3"));
        btnShowRankings.setBackground(Color.decode("#FBB9D3"));
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        selectFormToExport(5);
        cards.removeAll();
        cards.add(card1);
        cards.repaint();
        cards.revalidate();
        
        jButton5.setBackground(Color.decode("#FDE8F0"));
        
        jButton2.setBackground(Color.decode("#FBB9D3"));
        jButton3.setBackground(Color.decode("#FBB9D3"));
        jButton4.setBackground(Color.decode("#FBB9D3"));
        jButton1.setBackground(Color.decode("#FBB9D3"));
        jButton6.setBackground(Color.decode("#FBB9D3"));
        jButton7.setBackground(Color.decode("#FBB9D3"));
        jButton8.setBackground(Color.decode("#FBB9D3"));
        jButton9.setBackground(Color.decode("#FBB9D3"));
        jButton10.setBackground(Color.decode("#FBB9D3"));
        btnShowRankings.setBackground(Color.decode("#FBB9D3"));
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        selectFormToExport(6);
        cards.removeAll();
        cards.add(card1);
        cards.repaint();
        cards.revalidate();
        
        jButton6.setBackground(Color.decode("#FDE8F0"));
        
        jButton2.setBackground(Color.decode("#FBB9D3"));
        jButton3.setBackground(Color.decode("#FBB9D3"));
        jButton4.setBackground(Color.decode("#FBB9D3"));
        jButton5.setBackground(Color.decode("#FBB9D3"));
        jButton1.setBackground(Color.decode("#FBB9D3"));
        jButton7.setBackground(Color.decode("#FBB9D3"));
        jButton8.setBackground(Color.decode("#FBB9D3"));
        jButton9.setBackground(Color.decode("#FBB9D3"));
        jButton10.setBackground(Color.decode("#FBB9D3"));
        btnShowRankings.setBackground(Color.decode("#FBB9D3"));
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        selectFormToExport(7);
        cards.removeAll();
        cards.add(card1);
        cards.repaint();
        cards.revalidate();
        
        jButton7.setBackground(Color.decode("#FDE8F0"));
        
        jButton2.setBackground(Color.decode("#FBB9D3"));
        jButton3.setBackground(Color.decode("#FBB9D3"));
        jButton4.setBackground(Color.decode("#FBB9D3"));
        jButton5.setBackground(Color.decode("#FBB9D3"));
        jButton6.setBackground(Color.decode("#FBB9D3"));
        jButton1.setBackground(Color.decode("#FBB9D3"));
        jButton8.setBackground(Color.decode("#FBB9D3"));
        jButton9.setBackground(Color.decode("#FBB9D3"));
        jButton10.setBackground(Color.decode("#FBB9D3"));
        btnShowRankings.setBackground(Color.decode("#FBB9D3"));
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        selectFormToExport(8);
        cards.removeAll();
        cards.add(card1);
        cards.repaint();
        cards.revalidate();
        
        jButton8.setBackground(Color.decode("#FDE8F0"));
        
        jButton2.setBackground(Color.decode("#FBB9D3"));
        jButton3.setBackground(Color.decode("#FBB9D3"));
        jButton4.setBackground(Color.decode("#FBB9D3"));
        jButton5.setBackground(Color.decode("#FBB9D3"));
        jButton6.setBackground(Color.decode("#FBB9D3"));
        jButton7.setBackground(Color.decode("#FBB9D3"));
        jButton1.setBackground(Color.decode("#FBB9D3"));
        jButton9.setBackground(Color.decode("#FBB9D3"));
        jButton10.setBackground(Color.decode("#FBB9D3"));
        btnShowRankings.setBackground(Color.decode("#FBB9D3"));
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        selectFormToExport(9);
        cards.removeAll();
        cards.add(card1);
        cards.repaint();
        cards.revalidate();
        
        jButton9.setBackground(Color.decode("#FDE8F0"));
        
        jButton2.setBackground(Color.decode("#FBB9D3"));
        jButton3.setBackground(Color.decode("#FBB9D3"));
        jButton4.setBackground(Color.decode("#FBB9D3"));
        jButton5.setBackground(Color.decode("#FBB9D3"));
        jButton6.setBackground(Color.decode("#FBB9D3"));
        jButton7.setBackground(Color.decode("#FBB9D3"));
        jButton8.setBackground(Color.decode("#FBB9D3"));
        jButton1.setBackground(Color.decode("#FBB9D3"));
        jButton10.setBackground(Color.decode("#FBB9D3"));
        btnShowRankings.setBackground(Color.decode("#FBB9D3"));
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        selectFormToExport(10);
        cards.removeAll();
        cards.add(card1);
        cards.repaint();
        cards.revalidate();
        
        jButton10.setBackground(Color.decode("#FDE8F0"));
        
        jButton2.setBackground(Color.decode("#FBB9D3"));
        jButton3.setBackground(Color.decode("#FBB9D3"));
        jButton4.setBackground(Color.decode("#FBB9D3"));
        jButton5.setBackground(Color.decode("#FBB9D3"));
        jButton6.setBackground(Color.decode("#FBB9D3"));
        jButton7.setBackground(Color.decode("#FBB9D3"));
        jButton8.setBackground(Color.decode("#FBB9D3"));
        jButton9.setBackground(Color.decode("#FBB9D3"));
        jButton1.setBackground(Color.decode("#FBB9D3"));
        btnShowRankings.setBackground(Color.decode("#FBB9D3"));
    }//GEN-LAST:event_jButton10ActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
        ImageIcon ic = my.getImgIcn(myVariables.getMsgUrlIconWarning());
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to end your current session ?","Confirm",dialogButton,JOptionPane.WARNING_MESSAGE,ic);

        if(dialogResult == JOptionPane.YES_OPTION){
            this.setVisible(false);
            new formsLogin().setVisible(true);
        }
    }//GEN-LAST:event_logoutActionPerformed

    private void tfStrand8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfStrand8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfStrand8ActionPerformed

    private void btnExportSf8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportSf8ActionPerformed
        if(myVariables.getFormSelected() != 8){
            Toolkit.getDefaultToolkit().beep();
            my.showMessage("SF8 Not Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }
    
        String sem8 = semesterSelect8.getSelectedItem().toString();
              
        my.runExportThread(
            new JTable[]{sf8Table,sf8SummaryTable},
            new String[]{sem8},
            new JTextField[]{tfSectionName4,tfAdviserName4,tfGradeLevel4,tfSchoolYear5,tfDateOfMeasurement,tfStrand8},
            new JButton[]{btnExportSf8,},
            new boolean[]{}
        );
    }//GEN-LAST:event_btnExportSf8ActionPerformed

    private void btnLoadStudents6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadStudents6ActionPerformed
        int row = assignedTeacherTable.getSelectedRow();

        if(myVariables.getFormSelected() != 8){
            Toolkit.getDefaultToolkit().beep();
            my.showMessage("SF8 Form not Selected.", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(row == -1){
            Toolkit.getDefaultToolkit().beep();
            my.showMessage("No Section Selected.", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String sectionId = assignedTeacherTable.getValueAt(row, 1).toString();

        String sem8 = semesterSelect8.getSelectedItem().toString(); 
        
      
        if(cbShowIncompleteStudents2.isSelected()){
            if(!my.getConfirmation("Showing Students with no Records will not be counted for the Summary Table.\nContinue?")){
                return;
            }
        }

        my.runSecondaryThread(5, true,
            new JTable[]{sf8Table,sf8SummaryTable},
            new String[]{sectionId,sem8},
            new JTextField[]{tfDateOfMeasurement,tfStrand8},
            new JButton[]{btnLoadStudents6,btnExportSf8},
            new boolean[]{cbShowIncompleteStudents2.isSelected(),cbUseFirstStudentForDate.isSelected()}
        );
    }//GEN-LAST:event_btnLoadStudents6ActionPerformed

    private void tfSchoolYear5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSchoolYear5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSchoolYear5ActionPerformed

    private void semesterSelect7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semesterSelect7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_semesterSelect7ActionPerformed
    private void selectFormToExport(int formIndexExact){
        if(myVariables.getFormSelected() != formIndexExact){
            my.clear_table_rows(assignedTeacherTable);
        }
        myVariables.setFormSelected(formIndexExact);
        
        loadSchoolFormTabs();
        loadInstructions();
    }
    private void loadSchoolFormTabs(){
        
        
        int tabsToShow [];
        Icon [] icons;
        int tabSelectedIndex = 0;
        String titles [];
        switch(myVariables.getFormSelected()){
            case 1:{
                tabsToShow = new int [] {0,1,2};
                icons = new Icon [] {my.getImgIcn(myVariables.getSelectFormsIcon()),my.getImgIcn(myVariables.getSectionsIcon()),my.getImgIcn(myVariables.getFormsIcon())};
                titles = new String [] {"Instruction","Select Section","School Form "+myVariables.getFormSelected()};
                tabSelectedIndex = 1;
                break;
            }case 2:{
                tabsToShow = new int [] {0,1,3};
                icons = new Icon [] {my.getImgIcn(myVariables.getSelectFormsIcon()),my.getImgIcn(myVariables.getSectionsIcon()),my.getImgIcn(myVariables.getFormsIcon())};
                titles = new String [] {"Instruction","Select Section","School Form "+myVariables.getFormSelected()};
                tabSelectedIndex = 1;
                break;
            }case 3:{
                tabsToShow = new int [] {0,1,4};
                icons = new Icon [] {my.getImgIcn(myVariables.getSelectFormsIcon()),my.getImgIcn(myVariables.getSectionsIcon()),my.getImgIcn(myVariables.getFormsIcon())};
                titles = new String [] {"Instruction","Select Section","School Form "+myVariables.getFormSelected()};
                tabSelectedIndex = 1;
                break;
            }case 4:{
                tabsToShow = new int [] {0,1,3};
                icons = new Icon [] {my.getImgIcn(myVariables.getSelectFormsIcon()),my.getImgIcn(myVariables.getSectionsIcon()),my.getImgIcn(myVariables.getFormsIcon())};
                titles = new String [] {"Instruction","Select Section","School Form "+myVariables.getFormSelected()};
                tabSelectedIndex = 1;
                break;
            }case 5:{
                tabsToShow = new int [] {0,1,5};
                icons = new Icon [] {my.getImgIcn(myVariables.getSelectFormsIcon()),my.getImgIcn(myVariables.getSectionsIcon()),my.getImgIcn(myVariables.getFormsIcon())};
                titles = new String [] {"Instruction","Select Section","School Form "+myVariables.getFormSelected()};
                tabSelectedIndex = 1;
                break;
            }case 6:{
                tabsToShow = new int [] {0,1,5};
                icons = new Icon [] {my.getImgIcn(myVariables.getSelectFormsIcon()),my.getImgIcn(myVariables.getSectionsIcon()),my.getImgIcn(myVariables.getFormsIcon())};
                titles = new String [] {"Instruction","Select Section","School Form "+myVariables.getFormSelected()};
                tabSelectedIndex = 1;
                break;
            }case 7:{
                tabsToShow = new int [] {0,6};
                icons = new Icon [] {my.getImgIcn(myVariables.getSelectFormsIcon()),my.getImgIcn(myVariables.getFormsIcon())};
                titles = new String [] {"Instruction","School Form "+myVariables.getFormSelected()};
                tabSelectedIndex = 1;
                break;
            }case 8:{
                tabsToShow = new int [] {0,1,7};
                icons = new Icon [] {my.getImgIcn(myVariables.getSelectFormsIcon()),my.getImgIcn(myVariables.getSectionsIcon()),my.getImgIcn(myVariables.getFormsIcon())};
                titles = new String [] {"Instruction","Select Section","School Form "+myVariables.getFormSelected()};
                tabSelectedIndex = 1;
                break;
            }case 9:{
                tabsToShow = new int [] {0,1,8};
                icons = new Icon [] {my.getImgIcn(myVariables.getSelectFormsIcon()),my.getImgIcn(myVariables.getSectionsIcon()),my.getImgIcn(myVariables.getFormsIcon())};
                titles = new String [] {"Instruction","Select Section","School Form "+myVariables.getFormSelected()};
                tabSelectedIndex = 1;
                break;
            }case 10:{
                tabsToShow = new int [] {0,9};
                icons = new Icon [] {my.getImgIcn(myVariables.getSelectFormsIcon()),my.getImgIcn(myVariables.getFormsIcon())};
                titles = new String [] {"Instruction","School Form "+myVariables.getFormSelected()};
                tabSelectedIndex = 1;
                break;
            }default:{
                tabsToShow = new int [] {0};
                icons = new Icon [] {my.getImgIcn(myVariables.getSelectFormsIcon())};
                titles = new String [] {"Instruction"};
                break;
            }
        }
        mainTab.removeAll();
        for (int n = 0; n < tabsToShow.length; n++) {
            mainTab.addTab(titles[n], icons[n], formsPanels[tabsToShow[n]]);
        }
        mainTab.setSelectedIndex(tabSelectedIndex);
    }
    private void loadInstructions(){
        JPanel [] instructionPanel = new JPanel[]{
            defaultInstructionPanel,
            sf1InstructionPanel,
            sf2InstructionsPanel,
            sf3InstructionsPanel,
            sf4InstructionsPanel,
            sf5InstructionsPanel,
            sf6InstructionsPanel,
            null,
            sf8InstructionPanel,
            sf9InstructionPanel,
            null
        };
        tpSelectSectionInstructions.removeAll();
        
        int index = myVariables.getFormSelected();
        switch (myVariables.getFormSelected()){
            case 1:{
                break;
            }case 2:{
                break;
            }case 3:{
                break;
            }case 4:{
                break;
            }case 5:{
                break;
            }case 6:{
                break;
            }case 7:{
                break;
            }case 8:{
                break;
            }case 9:{
                break;
            }case 10:{
                break;
            }default:{
                index = 0;
                break;
            }
        }
        
        if (index != 0 && instructionPanel[index] != null) {
            tpSelectSectionInstructions.add("SF"+(index)+" Instructions", instructionPanel[index]);
        }else{
            if(index == 0){
                tpSelectSectionInstructions.add("Instructions", instructionPanel[0]);
            }
            if(instructionPanel[index] == null){
                tpSelectSectionInstructions.add("No Instructions Found", instructionPanel[0]);
            }
        }
        tpSelectSectionInstructions.setIconAt(0, my.getImgIcn(myVariables.getInfoIcon()));
    }
    private void setLoadingVariables(){
        myVariables.setProgressBar(jpbProgressBar);
        myVariables.setLbLoadingMessage(lbLoadingMessage);
        myVariables.setLoadingPanel(loadingDialog);
        myVariables.setCurrentLoadingFrame(this);
    }
    private void searchSections(){
        String toSearch = my.convertEscapeCharacters(tfSearchTeacherLoad.getText().trim());
        String schoolYear = jcbSchoolYear1.getSelectedItem().toString();

        //my.remove_multiple_tabs(mainTab, new int [] {1,2});

        String where = "WHERE gradeLevel> 10 AND subjectCode LIKE '%"+toSearch+"%' OR subjectCode is NULL ";

        //Filter search based on Access Level
        switch (myVariables.getAccessLevel()){
            case 1:{    //Teacher or MAPEH Teacher
                where += " AND teacherId='"+myVariables.getUserLoggedInId()+"'";
                if(myVariables.getFormSelected() == 3){
                    where += " AND bookTemplateId!='-1'";
                }
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
                if(myVariables.getFormSelected() == 3){
                    where += " AND bookTemplateId!='-1'";
                }
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
        switch (myVariables.getFormSelected()){
            case 3:{
                my.searchItemThread(toSearch,where, assignedTeacherTable, 12, new int [] {4,5,6}, new boolean[]{true,true}, lbSearchResult,null,null);
                break;
            }case 5:{
                my.searchItemThread(toSearch,where, assignedTeacherTable, 14, new int [] {4,5,6}, new boolean[]{true,true}, lbSearchResult,null,null);
                break;
            }case 9:{
                my.searchItemThread(toSearch,where, assignedTeacherTable, 14, new int [] {4,5,6}, new boolean[]{true,true}, lbSearchResult,null,null);
                break;
            }default:{
                my.searchItemThread(toSearch,where, assignedTeacherTable, 9, new int [] {4,5,6}, new boolean[]{true,true}, lbSearchResult,null,null);
                break;
            }
        }
    }
    private void clearGrades(){
        my.clear_table_rows(gradesTable);
        
        lbFinalGradeId.setText("0");
        tfGeneralAverage.setText(" ");
        tfEvaluation.setText(" ");
        tfFailedSubjects.setText(" ");
        
        
        btnExportSf9.setEnabled(false);
    }
    private void resetSf10Values(boolean clearSf10Table,boolean clearSectionTables,boolean clearSectionTitles,boolean clearValues,boolean enableDisableButtons){
        if(clearSf10Table){
            my.clear_table_rows(sf10Table);
        }
        if(clearSectionTables){
            my.clear_table_rows(gradesTable1);
            my.clear_table_rows(gradesTable2);
            
            tfGeneralAverage1.setText(" ");
            tfGeneralAverage2.setText(" ");
            
            tfEvaluation1.setText(" ");
            tfEvaluation2.setText(" ");
        }
        if(clearSectionTitles){
            tpSf10DetailsTab.setTitleAt(0, "SECTION_1");
            tpSf10DetailsTab.setTitleAt(1, "SECTION_2");
        }
        if(clearValues){
            tfFirstName.setText("");
            tfMiddleName.setText("");
            tfLastName.setText("");
            tfExtentionName.setText("");
            
            tfBirthdate.setText("");
            tfGender.setText("");
            tfLrn.setText("");
            
            tfSchoolName.setText("");
            tfSchoolId.setText("");
            tfSchoolAddress.setText("");
            tfInitialGrade.setText("");
        }
        
        btnUseSelectedSections.setEnabled(enableDisableButtons);
        btnExportSf10.setEnabled(enableDisableButtons);
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
            playError();
            System.err.println("Dialog is null...skipping");
        }
    }
    
    private void setScrollSpeeds(){
        JScrollPane scrollpanes [] = {
            jScrollPane1,jScrollPane3,jScrollPane4,jScrollPane9,jScrollPane14,jScrollPane18,
            jScrollPane19,jScrollPane29,jScrollPane32,jScrollPane37,jspRight,
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
            my.hideColumns(sf1StudentsTable, new int [] {0,1,2});
            my.hideColumns(sf2Table, new int [] {0,1,2,5});
            my.hideColumns(weekDaysOfTheMonthTable, new int [] {0,1,2,5});
            
            my.hideColumns(sf3Table, new int [] {0,1,2});
            my.hideColumns(sf3BooksTable, new int [] {0,3});
            my.hideColumns(sf5Table, new int [] {0,1,2,3,7,12,});
            my.hideColumns(sf8Table, new int [] {0,1,2,7,16,17});
            
            my.hideColumns(grade11RankingTable, new int [] {0,1,3,4,5,7,10,12,16});
            my.hideColumns(grade12RankingTable, new int [] {0,1,3,4,5,7,10,12,16});
            
            my.hideColumns(enrolledStudentsTable, new int []{0,1,6});
            my.hideColumns(gradesTable, new int [] {0,1,2,3,8,9});
            
            my.hideColumns(gradesTable1, new int [] {0,1,2,3,8,9});
            my.hideColumns(gradesTable2, new int [] {0,1,2,3,8,9});
            
            my.hideColumns(sf7TeachersTable, new int [] {0,10});
            my.hideColumns(sf7AssignedSubjectsTable, new int [] {0,1,2,4,10});
            
            my.hideColumns(enrolledStudentsTable1, new int [] {0});
            my.hideColumns(sf10Table, new int [] {0,1,5,7,10,13,15});
        }
        my.customHeaders(weekDaysOfTheMonthTable,new int [] {7,12,17,22,27},Color.RED,Color.BLACK,myVariables.COLUMN_HEADER_FONT,true);
        my.customHeaders(sf2Table,new int [] {7,12,17,22,27},Color.RED,Color.BLACK,myVariables.COLUMN_HEADER_FONT,true);
        
        //Set table fonts
        JTable tables [] = {
            assignedTeacherTable,sf1StudentsTable,weekDaysOfTheMonthTable,
            sf2Table,summarySf2,sf4Table,sf3Table,sf3BooksTable,sf5Table,sf6Table,
            sf5SummaryTable,sf5LevelOfProgress,
            grade11RankingTable,grade12RankingTable,
            sf8Table,sf8SummaryTable,enrolledStudentsTable,gradesTable,
            
            sf7TeachersTable,sf7AssignedSubjectsTable,
            
            enrolledStudentsTable1,sf10Table,gradesTable1,gradesTable2,
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
        mainTab.add("Select Form",selectFormPanel);
        mainTab.add("Select Section",selectSectionTab);
        mainTab.add("SF 1",sf1Tab);
        mainTab.add("SF 2 & 4",sf2Sf4Tab);
        mainTab.add("SF 3",sf3Tab);
        mainTab.add("SF 5 & 6",sf5Sf6Tab);
        mainTab.add("SF 7",sf7Tab);
        mainTab.add("SF 8",sf8Tab);
        mainTab.add("SF 9",sf9Tab);
        mainTab.add("SF 10",sf10Tab);
        
        mainTab.setFont(myVariables.TAB_HEADER_FONT);
        tpSf2Sf4TabbedPane.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        tpSf2Sf4DetailsPane.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        
        tpSf5Sf6Pane.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        tpSf5Sf6DetailsPane.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        
        tpSelectSectionInstructions.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        
        tpSf10Pane.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        tpSf10DetailsTab.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        
        tpRankingsTab.setFont(myVariables.TEXTFIELD_HEADER_FONT);
    }
    private void loadTabIcons(){
        Icon tabIcons [] = {
            my.getImgIcn(myVariables.getSelectFormsIcon()),
            my.getImgIcn(myVariables.getSectionsIcon()),
            my.getImgIcn(myVariables.getFormsIcon()),
            my.getImgIcn(myVariables.getFormsIcon()),
            my.getImgIcn(myVariables.getFormsIcon()),
            my.getImgIcn(myVariables.getFormsIcon()),
            my.getImgIcn(myVariables.getFormsIcon()),
            my.getImgIcn(myVariables.getFormsIcon()),
            my.getImgIcn(myVariables.getFormsIcon()),
            my.getImgIcn(myVariables.getFormsIcon()),
        };
        
        Icon sf2sf4Icons [] = {
            my.getImgIcn(myVariables.getDailyIcon()),
            my.getImgIcn(myVariables.getMonthlyIcon()),
        };
        
        Icon sf5sf6Icons [] = {
            my.getImgIcn(myVariables.getPromotionIcon()),
            my.getImgIcn(myVariables.getSummaryOfPromotionIcon()),
        };
        
        Icon instructionsIcons [] = {
            my.getImgIcn(myVariables.getInfoIcon()),
            my.getImgIcn(myVariables.getInfoIcon()),
            my.getImgIcn(myVariables.getInfoIcon()),
            my.getImgIcn(myVariables.getInfoIcon()),
        };
        
        Icon sf10Icons [] = {
            my.getImgIcn(myVariables.getSelectStudentIcon()),
            my.getImgIcn(myVariables.getSelectEnrolledSectionsIcon()),
            my.getImgIcn(myVariables.getPermanentRecordIcon()),
        };
        
        Icon rankingsIcons [] = {
            my.getImgIcn(myVariables.getFreshemenIcon()),
            my.getImgIcn(myVariables.getSophomoreIcon()),
        };
        
        for(int n=0;n<tabIcons.length;n++){
            mainTab.setIconAt(n,tabIcons[n]);
        }
        
        for(int n=0;n<sf2sf4Icons.length;n++){
            tpSf2Sf4TabbedPane.setIconAt(n,sf2sf4Icons[n]);
        }
        
        for(int n=0;n<sf5sf6Icons.length;n++){
            tpSf5Sf6Pane.setIconAt(n,sf5sf6Icons[n]);
        }
        
        for(int n=0;n<sf10Icons.length;n++){
            tpSf10Pane.setIconAt(n,sf10Icons[n]);
        }
        
        for(int n=0;n<rankingsIcons.length;n++){
            tpRankingsTab.setIconAt(n,rankingsIcons[n]);
        }
        
        for(int n=0;n<instructionsIcons.length;n++){
            tpSelectSectionInstructions.setIconAt(n,instructionsIcons[n]);
            try {tpSf2Sf4DetailsPane.setIconAt(n,instructionsIcons[n]);} catch (Exception e) {}
            try {tpSf5Sf6DetailsPane.setIconAt(n,instructionsIcons[n]);} catch (Exception e) {}
        }
        //my.remove_multiple_tabs(mainTab, new int [] {1,2});
    }
    private void loadColoredButtons(){
        JButton buttons [] = {
            btnSearchSection,btnCancelLoading,btnLoadStudents,btnExportSf1,
            btnLoadStudents1,btnExportSf2,btnOnlySelectedSections,btnSelectAllSections,
            btnLoadStudents2,btnExportSf4,btnLoadStudents3,btnExportSf3,
            btnLoadStudents4,btnExportSf5,btnRefreshRankings,btnLoadStudents5,btnExportSf6,
            btnOnlySelectedSections1,btnSelectAllSections1,btnLoadStudents6,btnExportSf8,
            btnSearchEnrolledStudent,btnSearchEnrolledStudent1,
            btnLoadGrades,btnExportSf9,btnExportSf10,btnLoadTeacher,btnExportSf7,
        };
        
        JButton lightButtons [] = {
            btnUseSelectedSections,
        };
        
        JButton sideButtons [] = {
            btnShowRankings,jButton1,jButton2,jButton3,jButton4,jButton5,jButton6,jButton7,jButton8,jButton9,jButton10,
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
            lightButtons[n].setFont(myVariables.BUTTON_FONT);
            //buttons[n].setCursor(my.getCursor(myVariables.getHandCursor()));
            lightButtons[n].setCursor(new Cursor(Cursor.HAND_CURSOR));
            lightButtons[n].setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
        
        for(int n=0;n<sideButtons.length;n++){
            sideButtons[n].setUI(new custom_styledSideBtn());
            sideButtons[n].setBackground(new Color(251,185,211));
            sideButtons[n].setForeground(Color.BLACK);            
            sideButtons[n].setFont(myVariables.BUTTON_FONT);
            sideButtons[n].setCursor(new Cursor(Cursor.HAND_CURSOR));
            //sideButtons[n].setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
        
    }
    private void loadLabels(){
        JLabel titleHeaderLabels [] = {
            jLabel2,jLabel13,jLabel25,jLabel26,jLabel29,jLabel32,jLabel41,jLabel51,
            jLabel52,jLabel53,jLabel42,jLabel56,jLabel64,jLabel76,jLabel96,jLabel110,
            jLabel111,jLabel112,jLabel113,jLabel114,
        };
        JLabel labels [] = {
            lbSearchResult,lbSearchResult1,lbSearchResult2,jLabel75,
            jLabel91,jLabel92,jLabel94,jLabel95,
        };
        
        JLabel formsHeaderLabels [] = {
            jLabel3,jLabel8,jLabel14,jLabel19,jLabel22,jLabel27,jLabel33,jLabel34,jLabel36,
            jLabel43,jLabel44,jLabel45,jLabel46,jLabel54,jLabel57,jLabel62,jLabel63,jLabel65,
            jLabel70,jLabel93,jLabel85,jLabel77,jLabel90,jLabel99,jLabel108,jLabel107,
        };
        JLabel textFieldHeaderLabels [] = {
            lbLoadingMessage,jLabel4,jLabel5,jLabel6,jLabel7,jLabel9,jLabel10,
            jLabel11,jLabel12,jLabel15,jLabel16,jLabel17,jLabel18,jLabel20,jLabel21,
            jLabel23,jLabel24,jLabel28,jLabel30,jLabel31,jLabel35,jLabel37,jLabel38,jLabel39,jLabel40,
            jLabel47,jLabel48,jLabel49,jLabel50,jLabel55,jLabel58,jLabel59,jLabel60,jLabel61,
            jLabel71,jLabel7,jLabel73,jLabel74,jLabel66,jLabel67,jLabel69,
            jLabel78,jLabel79,jLabel80,jLabel81,jLabel82,jLabel83,jLabel84,jLabel86,jLabel87,
            jLabel88,jLabel89,jLabel102,jLabel105,jLabel106,jLabel109,jLabel115,jLabel123,jLabel97,
            jLabel98,
  
            
        };
        
        for (JLabel n : titleHeaderLabels) {
            n.setFont(myVariables.TITLE_HEADER_FONT);
            n.setForeground(Color.BLACK);
        }
        
        for(JLabel n : labels){
            n.setFont(myVariables.LABEL_FONT);
            n.setForeground(Color.BLACK);
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
            jdcFirstDayOfFridate,jdcFirstDayOfMonth,jdcCutOffDate,
            jdcFirstDayOfMonth1,jdcCutOffDate1,jdcDateOfExport,
        };
        JSpinner spinners [] = {
            //jsHours,jsMinutes
        };
        
        JTextField searchFields [] = {
            tfSearchTeacherLoad,tfSearchEnrolledStudent,tfSearchEnrolledStudent1,
        };
        JTextField forms [] = {
            tfAdviserName,tfGradeLevel,tfSchoolYear,tfSectionName,
            tfMaleCount,tfFemaleCount,tfTotalCount,
            
            tfSectionName1,tfAdviserName1,tfGradeLevel1,tfSchoolYear1,tfSchoolDays,
            tfSectionName2,tfAdviserName2,tfGradeLevel2,tfSchoolYear2,
            
            tfSectionName3,tfAdviserName3,tfGradeLevel3,tfSchoolYear3,tfSchoolYear4,
            
            tfSectionName4,tfAdviserName4,tfGradeLevel4,tfSchoolYear5,
            
            tfSectionName5,tfAdviserName5,tfGradeLevel5,tfSchoolYear6,
            tfGeneralAverage,tfFailedSubjects,tfEvaluation,
            
            tfFirstName,tfMiddleName,tfLastName,tfExtentionName,tfBirthdate,
            tfGender,tfLrn,tfSchoolName,tfSchoolAddress,tfSchoolId,tfInitialGrade,
            
            tfSchoolYear7,tfCurriculum,tfDateOfMeasurement,
            
            tfGeneralAverage1,tfGeneralAverage2,
            tfEvaluation1,tfEvaluation2,
            
            tfStrand8,
        };
        for(JSpinner n : spinners){
            n.setFont(myVariables.TEXTFIELD_FONT);
        }
        for(JDateChooser n : dateChoosers){
            n.setFont(myVariables.TEXTFIELD_FONT);
            n.setCursor(new Cursor(Cursor.HAND_CURSOR));
            n.setDateFormatString("yyyy-MM-dd");
        }
        for(JTextField n : searchFields){
            n.setFont(myVariables.SEARCH_TEXTFIELD_FONT);
        }
        for(JTextField n : forms){
            n.setFont(myVariables.TEXTFIELD_FONT);
        }
        semesterSelect8.setFont(myVariables.TEXTFIELD_FONT);
  
    }
    private void loadYearDropDowns(int numberOfYears){
        JComboBox [] yearDropDowns = {
            jcbRankingSchoolYear,jcbSchoolYear2,
        };
        
        JComboBox [] yearDropDownsWithAllOption = {
            jcbSchoolYear1,
        };
        JComboBox [] dropDowns = {
            jcbMissingValues,jcbMissingValues1,jcbMissingValues2,jcbRankingNumberOfStudents,
            jcbMissingValues3,jcbRankingStrand,jcbRankingSemester,
        };
        int startingYear = 2019;
        
        for(JComboBox n : yearDropDowns){
            n.removeAllItems();
            n.setFont(myVariables.TEXTFIELD_FONT);
            n.setCursor(new Cursor(Cursor.HAND_CURSOR));
            for(int x=0;x<numberOfYears;x++){
                n.addItem(String.valueOf(startingYear+x));
            }
        }
        for(JComboBox n : yearDropDownsWithAllOption){
            n.removeAllItems();
            n.setFont(myVariables.TEXTFIELD_FONT);
            n.setCursor(new Cursor(Cursor.HAND_CURSOR));
            n.addItem("All");
            for(int x=0;x<numberOfYears;x++){
                n.addItem(String.valueOf(startingYear+x));
            }
        }
        for(JComboBox n : dropDowns){
            n.setFont(myVariables.TEXTFIELD_FONT);
            n.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
        
        semesterSelect7.setFont(myVariables.TEXTFIELD_FONT);
        semesterSelect7.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
   
    //</editor-fold>
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
    private javax.swing.JButton btnCancelLoading;
    private javax.swing.JButton btnExportSf1;
    private javax.swing.JButton btnExportSf10;
    private javax.swing.JButton btnExportSf2;
    private javax.swing.JButton btnExportSf3;
    private javax.swing.JButton btnExportSf4;
    private javax.swing.JButton btnExportSf5;
    private javax.swing.JButton btnExportSf6;
    private javax.swing.JButton btnExportSf7;
    private javax.swing.JButton btnExportSf8;
    private javax.swing.JButton btnExportSf9;
    private javax.swing.JButton btnLoadGrades;
    private javax.swing.JButton btnLoadStudents;
    private javax.swing.JButton btnLoadStudents1;
    private javax.swing.JButton btnLoadStudents2;
    private javax.swing.JButton btnLoadStudents3;
    private javax.swing.JButton btnLoadStudents4;
    private javax.swing.JButton btnLoadStudents5;
    private javax.swing.JButton btnLoadStudents6;
    private javax.swing.JButton btnLoadTeacher;
    private javax.swing.JButton btnOnlySelectedSections;
    private javax.swing.JButton btnOnlySelectedSections1;
    private javax.swing.JButton btnRefreshRankings;
    private javax.swing.JButton btnSearchEnrolledStudent;
    private javax.swing.JButton btnSearchEnrolledStudent1;
    private javax.swing.JButton btnSearchSection;
    private javax.swing.JButton btnSelectAllSections;
    private javax.swing.JButton btnSelectAllSections1;
    private javax.swing.JButton btnShowRankings;
    private javax.swing.JButton btnUseSelectedSections;
    private javax.swing.JPanel card1;
    private javax.swing.JPanel card2;
    private javax.swing.JPanel cards;
    private javax.swing.JCheckBox cbCompareToRankings;
    private javax.swing.JCheckBox cbRemoveTeachersWNoSubjects;
    private javax.swing.JCheckBox cbShowIncompleteStudents;
    private javax.swing.JCheckBox cbShowIncompleteStudents1;
    private javax.swing.JCheckBox cbShowIncompleteStudents2;
    private javax.swing.JCheckBox cbUseAcronyms;
    private javax.swing.JCheckBox cbUseCodeAsName;
    private javax.swing.JCheckBox cbUseFirstStudentForDate;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JPanel defaultInstructionPanel;
    private javax.swing.JPanel defaultInstructionPanel1;
    private javax.swing.JTable enrolledStudentsTable;
    private javax.swing.JTable enrolledStudentsTable1;
    private javax.swing.JTable grade11RankingTable;
    private javax.swing.JTable grade12RankingTable;
    private javax.swing.JTable gradesTable;
    private javax.swing.JTable gradesTable1;
    private javax.swing.JTable gradesTable2;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
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
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JScrollPane jScrollPane29;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane30;
    private javax.swing.JScrollPane jScrollPane31;
    private javax.swing.JScrollPane jScrollPane32;
    private javax.swing.JScrollPane jScrollPane33;
    private javax.swing.JScrollPane jScrollPane34;
    private javax.swing.JScrollPane jScrollPane35;
    private javax.swing.JScrollPane jScrollPane36;
    private javax.swing.JScrollPane jScrollPane37;
    private javax.swing.JScrollPane jScrollPane38;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane42;
    private javax.swing.JScrollPane jScrollPane43;
    private javax.swing.JScrollPane jScrollPane44;
    private javax.swing.JScrollPane jScrollPane45;
    private javax.swing.JScrollPane jScrollPane46;
    private javax.swing.JScrollPane jScrollPane47;
    private javax.swing.JScrollPane jScrollPane48;
    private javax.swing.JScrollPane jScrollPane49;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane10;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JSplitPane jSplitPane3;
    private javax.swing.JSplitPane jSplitPane4;
    private javax.swing.JSplitPane jSplitPane5;
    private javax.swing.JSplitPane jSplitPane6;
    private javax.swing.JSplitPane jSplitPane7;
    private javax.swing.JSplitPane jSplitPane8;
    private javax.swing.JSplitPane jSplitPane9;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea10;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea5;
    private javax.swing.JTextArea jTextArea6;
    private javax.swing.JTextArea jTextArea7;
    private javax.swing.JTextArea jTextArea8;
    private javax.swing.JTextArea jTextArea9;
    private javax.swing.JComboBox<String> jcbMissingValues;
    private javax.swing.JComboBox<String> jcbMissingValues1;
    private javax.swing.JComboBox<String> jcbMissingValues2;
    private javax.swing.JComboBox<String> jcbMissingValues3;
    private javax.swing.JComboBox<String> jcbRankingNumberOfStudents;
    private javax.swing.JComboBox<String> jcbRankingSchoolYear;
    private javax.swing.JComboBox<String> jcbRankingSemester;
    private javax.swing.JComboBox<String> jcbRankingStrand;
    private javax.swing.JComboBox<String> jcbSchoolYear1;
    private javax.swing.JComboBox<String> jcbSchoolYear2;
    private com.toedter.calendar.JDateChooser jdcCutOffDate;
    private com.toedter.calendar.JDateChooser jdcCutOffDate1;
    private com.toedter.calendar.JDateChooser jdcDateOfExport;
    private com.toedter.calendar.JDateChooser jdcFirstDayOfFridate;
    private com.toedter.calendar.JDateChooser jdcFirstDayOfMonth;
    private com.toedter.calendar.JDateChooser jdcFirstDayOfMonth1;
    private javax.swing.JProgressBar jpbProgressBar;
    private javax.swing.JScrollPane jspRight;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lbFinalGradeId;
    private javax.swing.JLabel lbLoadingMessage;
    private javax.swing.JLabel lbSearchResult;
    private javax.swing.JLabel lbSearchResult1;
    private javax.swing.JLabel lbSearchResult2;
    private javax.swing.JPanel left;
    private javax.swing.JPanel left1;
    private javax.swing.JPanel left2;
    private javax.swing.JPanel left3;
    private javax.swing.JPanel left4;
    private javax.swing.JPanel loadingDialog;
    private javax.swing.JMenuItem logout;
    private javax.swing.JTabbedPane mainTab;
    private javax.swing.JMenu menu;
    private javax.swing.JPanel rankingsDialog;
    private javax.swing.JPanel right;
    private javax.swing.JPanel right1;
    private javax.swing.JPanel right2;
    private javax.swing.JPanel sectionPanel1;
    private javax.swing.JPanel sectionPanel2;
    private javax.swing.JPanel selectFormPanel;
    private javax.swing.JPanel selectSectionTab;
    private javax.swing.JComboBox<String> semesterSelect;
    private javax.swing.JComboBox<String> semesterSelect1;
    private javax.swing.JComboBox<String> semesterSelect5;
    private javax.swing.JComboBox<String> semesterSelect7;
    private javax.swing.JComboBox<String> semesterSelect8;
    private javax.swing.JPanel sf10Tab;
    private javax.swing.JTable sf10Table;
    private javax.swing.JPanel sf1InstructionPanel;
    private javax.swing.JTable sf1StudentsTable;
    private javax.swing.JPanel sf1Tab;
    private javax.swing.JPanel sf2InstructionsPanel;
    private javax.swing.JPanel sf2Sf4Tab;
    private javax.swing.JPanel sf2Tab;
    private javax.swing.JTable sf2Table;
    private javax.swing.JTable sf3BooksTable;
    private javax.swing.JPanel sf3InstructionsPanel;
    private javax.swing.JPanel sf3Tab;
    private javax.swing.JTable sf3Table;
    private javax.swing.JPanel sf4InstructionsPanel;
    private javax.swing.JPanel sf4Tab;
    private javax.swing.JTable sf4Table;
    private javax.swing.JPanel sf5InstructionsPanel;
    private javax.swing.JTable sf5LevelOfProgress;
    private javax.swing.JPanel sf5Sf6Tab;
    private javax.swing.JTable sf5SummaryTable;
    private javax.swing.JTable sf5Table;
    private javax.swing.JPanel sf6InstructionsPanel;
    private javax.swing.JTable sf6Table;
    private javax.swing.JTable sf7AssignedSubjectsTable;
    private javax.swing.JPanel sf7Tab;
    private javax.swing.JTable sf7TeachersTable;
    private javax.swing.JPanel sf8InstructionPanel;
    private javax.swing.JTable sf8SummaryTable;
    private javax.swing.JPanel sf8Tab;
    private javax.swing.JTable sf8Table;
    private javax.swing.JPanel sf9InstructionPanel;
    private javax.swing.JPanel sf9Tab;
    private javax.swing.JSplitPane spLeft;
    private javax.swing.JTable summarySf2;
    private javax.swing.JTextField tfAdviserName;
    private javax.swing.JTextField tfAdviserName1;
    private javax.swing.JTextField tfAdviserName2;
    private javax.swing.JTextField tfAdviserName3;
    private javax.swing.JTextField tfAdviserName4;
    private javax.swing.JTextField tfAdviserName5;
    private javax.swing.JTextField tfBirthdate;
    private javax.swing.JTextField tfCurriculum;
    private javax.swing.JTextField tfDateOfMeasurement;
    private javax.swing.JTextField tfEvaluation;
    private javax.swing.JTextField tfEvaluation1;
    private javax.swing.JTextField tfEvaluation2;
    private javax.swing.JTextField tfExtentionName;
    private javax.swing.JTextField tfFailedSubjects;
    private javax.swing.JTextField tfFemaleCount;
    private javax.swing.JTextField tfFirstName;
    private javax.swing.JTextField tfGender;
    private javax.swing.JTextField tfGeneralAverage;
    private javax.swing.JTextField tfGeneralAverage1;
    private javax.swing.JTextField tfGeneralAverage2;
    private javax.swing.JTextField tfGradeLevel;
    private javax.swing.JTextField tfGradeLevel1;
    private javax.swing.JTextField tfGradeLevel2;
    private javax.swing.JTextField tfGradeLevel3;
    private javax.swing.JTextField tfGradeLevel4;
    private javax.swing.JTextField tfGradeLevel5;
    private javax.swing.JTextField tfInitialGrade;
    private javax.swing.JTextField tfLastName;
    private javax.swing.JTextField tfLrn;
    private javax.swing.JTextField tfMaleCount;
    private javax.swing.JTextField tfMiddleName;
    private javax.swing.JTextField tfSchoolAddress;
    private javax.swing.JTextField tfSchoolDays;
    private javax.swing.JTextField tfSchoolId;
    private javax.swing.JTextField tfSchoolName;
    private javax.swing.JTextField tfSchoolYear;
    private javax.swing.JTextField tfSchoolYear1;
    private javax.swing.JTextField tfSchoolYear2;
    private javax.swing.JTextField tfSchoolYear3;
    private javax.swing.JTextField tfSchoolYear4;
    private javax.swing.JTextField tfSchoolYear5;
    private javax.swing.JTextField tfSchoolYear6;
    private javax.swing.JTextField tfSchoolYear7;
    private javax.swing.JTextField tfSearchEnrolledStudent;
    private javax.swing.JTextField tfSearchEnrolledStudent1;
    private javax.swing.JTextField tfSearchTeacherLoad;
    private javax.swing.JTextField tfSectionName;
    private javax.swing.JTextField tfSectionName1;
    private javax.swing.JTextField tfSectionName2;
    private javax.swing.JTextField tfSectionName3;
    private javax.swing.JTextField tfSectionName4;
    private javax.swing.JTextField tfSectionName5;
    private javax.swing.JTextField tfStrand;
    private javax.swing.JTextField tfStrand5;
    private javax.swing.JTextField tfStrand8;
    private javax.swing.JTextField tfTotalCount;
    private javax.swing.JTabbedPane tpRankingsTab;
    private javax.swing.JTabbedPane tpSelectSectionInstructions;
    private javax.swing.JTabbedPane tpSf10DetailsTab;
    private javax.swing.JTabbedPane tpSf10Pane;
    private javax.swing.JTabbedPane tpSf2Sf4DetailsPane;
    private javax.swing.JTabbedPane tpSf2Sf4TabbedPane;
    private javax.swing.JTabbedPane tpSf5Sf6DetailsPane;
    private javax.swing.JTabbedPane tpSf5Sf6Pane;
    private javax.swing.JTable weekDaysOfTheMonthTable;
    // End of variables declaration//GEN-END:variables
}
