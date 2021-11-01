/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mahPackage5;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.util.Date;
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
import java.awt.Dimension;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.*;
import javax.swing.table.DefaultTableModel;
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
    Font poppins14R;
    Font poppins12;
    Font poppins12R;
    
    public dashBoard() {
        my = new myFunctions();
        initComponents();
        
        jLabel98.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage5/icons/cbshs.png"))); // NOI18N
        
        
        
        loadTabs();
        loadTabIcons();
        
        loadColoredButtons();
        loadLabels();
        
        loadTextFields();
        sortTables();
        
        setScrollSpeeds();
        loadYearDropDowns(12);
        
        tab1.setBackground(Color.decode("#FDE8F0"));
        
        tab2.setBackground(Color.decode("#FBB9D3"));
        tab3.setBackground(Color.decode("#FBB9D3"));
        tab4.setBackground(Color.decode("#FBB9D3"));
        
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
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Poppins-Regular.ttf")));	
                        
                        poppins14R = Font.createFont(Font.TRUETYPE_FONT, new File("Poppins-Regular.ttf")).deriveFont(14f);	
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Poppins-Regular.ttf")));	
                        
                        poppins12 = Font.createFont(Font.TRUETYPE_FONT, new File("Poppins-SemiBold.ttf")).deriveFont(12f);	
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Poppins-Regular.ttf")));	
                        
                        poppins12R = Font.createFont(Font.TRUETYPE_FONT, new File("Poppins-Regular.ttf")).deriveFont(12f);	
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Poppins-Regular.ttf")));	
		}
		catch(IOException | FontFormatException e){
			
		}
            menu.setText(myVariables.getUserLoggedInName());
                
            jcbBookGradeLevel.setFont(poppins14R);
            jcbTemplateGradeLevel.setFont(poppins14R);
            jcbTemplateGradeLevel1.setFont(poppins14R);
            jcbSchoolYear1.setFont(poppins14R);
            jLabel35.setFont(poppins19);
            jLabel38.setFont(poppins19);
            jLabel43.setFont(poppins48);
            jLabel96.setFont(poppins19);
            tab1Label.setFont(poppins14);
            tab2Label.setFont(poppins14);
            tab3Label.setFont(poppins14);
            lbWelcome.setFont(poppins12R);
            lbUsername.setText(myVariables.getUserLoggedInName());
            lbUsername.setFont(poppins14);
            lbAccess.setText(myVariables.getAccessLevelName(-1));
            lbAccess.setFont(poppins12R);
            
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

        chooseDateGroup = new javax.swing.ButtonGroup();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jPanel3 = new javax.swing.JPanel();
        lbWelcome = new javax.swing.JLabel();
        lbUsername = new javax.swing.JLabel();
        lbAccess = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        tab1 = new javax.swing.JPanel();
        tab1Label = new javax.swing.JLabel();
        tab2 = new javax.swing.JPanel();
        tab2Label = new javax.swing.JLabel();
        tab3 = new javax.swing.JPanel();
        tab3Label = new javax.swing.JLabel();
        tab4 = new javax.swing.JPanel();
        tab4Label = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        myCards = new javax.swing.JPanel();
        manageBooksTab = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        right = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfBookName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jcbBookGradeLevel = new javax.swing.JComboBox<>();
        btnSaveBook = new javax.swing.JButton();
        tfBookCode = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        left = new javax.swing.JPanel();
        lbSearchResult1 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        booksTable = new javax.swing.JTable();
        btnSearchBook = new javax.swing.JButton();
        tfSearchBook = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        editBookDialog = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tfBookName1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jcbBookGradeLevel1 = new javax.swing.JComboBox<>();
        btnSaveBook1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lbBookId = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfBookCode1 = new javax.swing.JTextField();
        jPanel17 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        manageBookTemplatesTab = new javax.swing.JPanel();
        jSplitPane3 = new javax.swing.JSplitPane();
        right2 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnAddBookTemplate = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jcbTemplateGradeLevel = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        tfTemplateName = new javax.swing.JTextField();
        left2 = new javax.swing.JPanel();
        lbSearchResult3 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        bookTemplatesTable = new javax.swing.JTable();
        tfSearchBookTemplate = new javax.swing.JTextField();
        btnSearchBookTemplate = new javax.swing.JButton();
        editBookTemplateDialog = new javax.swing.JPanel();
        jSplitPane4 = new javax.swing.JSplitPane();
        left3 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        booksTable1 = new javax.swing.JTable();
        tfSearchBook1 = new javax.swing.JTextField();
        btnSearchBook1 = new javax.swing.JButton();
        btnAddBookToList = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        right3 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        booksTable2 = new javax.swing.JTable();
        btnRemobeBookFromList = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tfTemplateName1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jcbTemplateGradeLevel1 = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        btnSaveBookTemplateChanges = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        lbTemplateID = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        selectSectionTab = new javax.swing.JPanel();
        lbSearchResult = new javax.swing.JLabel();
        tfSearchTeacherLoad = new javax.swing.JTextField();
        btnSearchSection = new javax.swing.JButton();
        jcbSchoolYear1 = new javax.swing.JComboBox<>();
        jScrollPane8 = new javax.swing.JScrollPane();
        assignedTeacherTable = new javax.swing.JTable();
        selectBookTemplateDialog = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        btnSaveTemplateSelected = new javax.swing.JButton();
        jSplitPane5 = new javax.swing.JSplitPane();
        left4 = new javax.swing.JPanel();
        tfSearchBookTemplate1 = new javax.swing.JTextField();
        btnSearchBookTemplate1 = new javax.swing.JButton();
        jScrollPane13 = new javax.swing.JScrollPane();
        bookTemplatesTable1 = new javax.swing.JTable();
        right4 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        booksTable3 = new javax.swing.JTable();
        distributeReturnBooksTab = new javax.swing.JPanel();
        jSplitPane2 = new javax.swing.JSplitPane();
        left1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        enrolledStudentsTable = new javax.swing.JTable();
        lbSearchResult2 = new javax.swing.JLabel();
        tfSearchEnrolledStudent = new javax.swing.JTextField();
        btnSearchEnrolledStudent = new javax.swing.JButton();
        right1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        booksUsedTable = new javax.swing.JTable();
        btnSaveStatusChanges = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        dateChooserDialog = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jcbDateSelected = new com.toedter.calendar.JDateChooser();
        rbDate = new javax.swing.JRadioButton();
        rbFm = new javax.swing.JRadioButton();
        rbNeg = new javax.swing.JRadioButton();
        rbTdo = new javax.swing.JRadioButton();
        rbNone = new javax.swing.JRadioButton();
        cbLLTR = new javax.swing.JCheckBox();
        cbPTL = new javax.swing.JCheckBox();
        cbTLTR = new javax.swing.JCheckBox();
        btnSetStatus = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu = new javax.swing.JMenu();
        logout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Dashboard");
        setIconImage(my.getImgIcn(myVariables.getBookKeepingWindowIcon()).getImage()
        );
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        kGradientPanel1.setBackground(new java.awt.Color(249, 239, 227));
        kGradientPanel1.setkEndColor(new java.awt.Color(249, 239, 227));
        kGradientPanel1.setkStartColor(new java.awt.Color(249, 239, 227));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(1003, 600));

        jPanel3.setBackground(new java.awt.Color(251, 185, 211));
        jPanel3.setPreferredSize(new java.awt.Dimension(270, 665));

        lbWelcome.setBackground(new java.awt.Color(255, 255, 255));
        lbWelcome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbWelcome.setForeground(new java.awt.Color(58, 57, 57));
        lbWelcome.setText("Welcome");

        lbUsername.setBackground(new java.awt.Color(255, 255, 255));
        lbUsername.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbUsername.setForeground(new java.awt.Color(58, 57, 57));
        lbUsername.setText("Username");

        lbAccess.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbAccess.setForeground(new java.awt.Color(58, 57, 57));
        lbAccess.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbAccess.setText("Access Level");

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(58, 57, 57));
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("SHS");

        jLabel96.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(58, 57, 57));
        jLabel96.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel96.setText("BOOKKEEPING SYSTEM");

        jLabel98.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel98.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage5/icons/cbshs.png"))); // NOI18N

        tab1.setPreferredSize(new java.awt.Dimension(300, 37));
        tab1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab1MouseClicked(evt);
            }
        });

        tab1Label.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tab1Label.setForeground(new java.awt.Color(58, 57, 57));
        tab1Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage5/icons/icons8_books_20px.png"))); // NOI18N
        tab1Label.setText("   Manage Books");
        tab1Label.setMaximumSize(new java.awt.Dimension(124, 30));
        tab1Label.setMinimumSize(new java.awt.Dimension(124, 30));
        tab1Label.setPreferredSize(new java.awt.Dimension(143, 20));

        javax.swing.GroupLayout tab1Layout = new javax.swing.GroupLayout(tab1);
        tab1.setLayout(tab1Layout);
        tab1Layout.setHorizontalGroup(
            tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(tab1Label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tab1Layout.setVerticalGroup(
            tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tab1Label, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
        );

        tab2.setBackground(new java.awt.Color(251, 185, 211));
        tab2.setPreferredSize(new java.awt.Dimension(300, 37));
        tab2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab2MouseClicked(evt);
            }
        });

        tab2Label.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tab2Label.setForeground(new java.awt.Color(58, 57, 57));
        tab2Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage5/icons/icons8_book_shelf_20px.png"))); // NOI18N
        tab2Label.setText("   Manage Book Templates");

        javax.swing.GroupLayout tab2Layout = new javax.swing.GroupLayout(tab2);
        tab2.setLayout(tab2Layout);
        tab2Layout.setHorizontalGroup(
            tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(tab2Label)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tab2Layout.setVerticalGroup(
            tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tab2Label)
                .addContainerGap())
        );

        tab3.setBackground(new java.awt.Color(251, 185, 211));
        tab3.setPreferredSize(new java.awt.Dimension(300, 37));
        tab3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab3MouseClicked(evt);
            }
        });

        tab3Label.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tab3Label.setForeground(new java.awt.Color(58, 57, 57));
        tab3Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage5/icons/icons8_add_book_16px.png"))); // NOI18N
        tab3Label.setText("    Select Book section");
        tab3Label.setMaximumSize(new java.awt.Dimension(149, 15));
        tab3Label.setMinimumSize(new java.awt.Dimension(149, 15));
        tab3Label.setPreferredSize(new java.awt.Dimension(149, 20));

        javax.swing.GroupLayout tab3Layout = new javax.swing.GroupLayout(tab3);
        tab3.setLayout(tab3Layout);
        tab3Layout.setHorizontalGroup(
            tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(tab3Label, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        tab3Layout.setVerticalGroup(
            tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tab3Label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tab4.setBackground(new java.awt.Color(251, 185, 211));
        tab4.setPreferredSize(new java.awt.Dimension(300, 37));
        tab4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab4MouseClicked(evt);
            }
        });

        tab4Label.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tab4Label.setForeground(new java.awt.Color(58, 57, 57));
        tab4Label.setText("Distribute Return Book");
        tab4Label.setPreferredSize(new java.awt.Dimension(143, 20));

        javax.swing.GroupLayout tab4Layout = new javax.swing.GroupLayout(tab4);
        tab4.setLayout(tab4Layout);
        tab4Layout.setHorizontalGroup(
            tab4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab4Layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addComponent(tab4Label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );
        tab4Layout.setVerticalGroup(
            tab4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tab4Label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(tab2, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
            .addComponent(tab3, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
            .addComponent(tab4, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
            .addComponent(jLabel96, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tab1, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel98)
                .addGap(84, 84, 84))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbAccess))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel98)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel43)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel96)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tab1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tab2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tab3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(tab4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 242, Short.MAX_VALUE)
                .addComponent(lbWelcome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbUsername)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbAccess)
                .addGap(26, 26, 26))
        );

        jPanel4.setBackground(new java.awt.Color(249, 239, 227));

        myCards.setPreferredSize(new java.awt.Dimension(995, 782));
        myCards.setLayout(new java.awt.CardLayout());

        jSplitPane1.setBackground(new java.awt.Color(249, 239, 227));
        jSplitPane1.setBorder(null);
        jSplitPane1.setDividerLocation(350);
        jSplitPane1.setDividerSize(0);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane1.setAlignmentX(0.5F);
        jSplitPane1.setAlignmentY(0.5F);

        right.setBackground(new java.awt.Color(249, 239, 227));
        right.setFocusable(false);
        right.setMinimumSize(new java.awt.Dimension(470, 231));
        right.setPreferredSize(new java.awt.Dimension(470, 231));

        jPanel1.setBackground(new java.awt.Color(203, 184, 160));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Book Name");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel2.setText("Grade Level");

        jcbBookGradeLevel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Grade 11", "Grade 12" }));

        btnSaveBook.setBackground(new java.awt.Color(249, 239, 227));
        btnSaveBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage5/icons/icons8_save_16px.png"))); // NOI18N
        btnSaveBook.setText("Save");
        btnSaveBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveBookActionPerformed(evt);
            }
        });

        tfBookCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfBookCodeActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Book Code");

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Add New Book");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfBookCode, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tfBookName, javax.swing.GroupLayout.DEFAULT_SIZE, 957, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jcbBookGradeLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSaveBook, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel35)
                .addGap(25, 25, 25)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfBookCode, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfBookName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbBookGradeLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSaveBook))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout rightLayout = new javax.swing.GroupLayout(right);
        right.setLayout(rightLayout);
        rightLayout.setHorizontalGroup(
            rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        rightLayout.setVerticalGroup(
            rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jSplitPane1.setTopComponent(right);
        right.getAccessibleContext().setAccessibleParent(jSplitPane1);

        left.setBackground(new java.awt.Color(249, 239, 227));
        left.setPreferredSize(new java.awt.Dimension(147, 262));

        lbSearchResult1.setBackground(new java.awt.Color(0, 0, 0));
        lbSearchResult1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lbSearchResult1.setText("Search using the search bar...");

        jScrollPane9.setBackground(new java.awt.Color(249, 239, 227));

        booksTable.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        booksTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Code", "Book Name", "Grade Level"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        booksTable.getTableHeader().setReorderingAllowed(false);
        booksTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                booksTableMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(booksTable);

        btnSearchBook.setFont(new java.awt.Font("Century Gothic", 0, 19)); // NOI18N
        btnSearchBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage5/icons/Search.png"))); // NOI18N
        btnSearchBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBookHandler(evt);
            }
        });

        tfSearchBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBookHandler(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel16.setText("Available Books");

        javax.swing.GroupLayout leftLayout = new javax.swing.GroupLayout(left);
        left.setLayout(leftLayout);
        leftLayout.setHorizontalGroup(
            leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9)
                    .addGroup(leftLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbSearchResult1)
                        .addGap(18, 18, 18)
                        .addComponent(tfSearchBook, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearchBook)))
                .addContainerGap())
        );
        leftLayout.setVerticalGroup(
            leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(lbSearchResult1))
                    .addComponent(btnSearchBook)
                    .addComponent(tfSearchBook, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane1.setBottomComponent(left);

        javax.swing.GroupLayout manageBooksTabLayout = new javax.swing.GroupLayout(manageBooksTab);
        manageBooksTab.setLayout(manageBooksTabLayout);
        manageBooksTabLayout.setHorizontalGroup(
            manageBooksTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 997, Short.MAX_VALUE)
        );
        manageBooksTabLayout.setVerticalGroup(
            manageBooksTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 716, Short.MAX_VALUE)
        );

        myCards.add(manageBooksTab, "card2");

        editBookDialog.setBackground(new java.awt.Color(249, 239, 227));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel3.setText("Name");

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel4.setText("Grade Level");

        jcbBookGradeLevel1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Grade 11", "Grade 12" }));
        jcbBookGradeLevel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbBookGradeLevel1ActionPerformed(evt);
            }
        });

        btnSaveBook1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage5/icons/icons8_save_16px.png"))); // NOI18N
        btnSaveBook1.setText("Save Changes");
        btnSaveBook1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveBook1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel5.setText("Record ID:");

        lbBookId.setText("0");

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel7.setText("Book Code");

        jPanel17.setBackground(new java.awt.Color(203, 184, 160));

        jLabel37.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Edit Book");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
            .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel17Layout.createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addComponent(jLabel37)
                    .addContainerGap(39, Short.MAX_VALUE)))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 47, Short.MAX_VALUE)
            .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel17Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel37)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout editBookDialogLayout = new javax.swing.GroupLayout(editBookDialog);
        editBookDialog.setLayout(editBookDialogLayout);
        editBookDialogLayout.setHorizontalGroup(
            editBookDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editBookDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editBookDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfBookName1)
                    .addComponent(btnSaveBook1, javax.swing.GroupLayout.DEFAULT_SIZE, 977, Short.MAX_VALUE)
                    .addGroup(editBookDialogLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbBookId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(tfBookCode1)
                    .addGroup(editBookDialogLayout.createSequentialGroup()
                        .addGroup(editBookDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbBookGradeLevel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(editBookDialogLayout.createSequentialGroup()
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 847, Short.MAX_VALUE))
        );
        editBookDialogLayout.setVerticalGroup(
            editBookDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editBookDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfBookCode1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfBookName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbBookGradeLevel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSaveBook1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editBookDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lbBookId))
                .addContainerGap())
        );

        myCards.add(editBookDialog, "card3");

        jSplitPane3.setBorder(null);
        jSplitPane3.setDividerLocation(300);
        jSplitPane3.setDividerSize(0);
        jSplitPane3.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        right2.setBackground(new java.awt.Color(249, 239, 227));

        jPanel2.setBackground(new java.awt.Color(203, 184, 160));

        btnAddBookTemplate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage5/icons/icons8_save_16px.png"))); // NOI18N
        btnAddBookTemplate.setText("Save");
        btnAddBookTemplate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddBookTemplateActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel9.setText("Grade Level");

        jcbTemplateGradeLevel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Grade 11", "Grade 12" }));
        jcbTemplateGradeLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTemplateGradeLevelActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel8.setText("Template Name");

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel38.setText("Add New Book Template");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfTemplateName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 957, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jcbTemplateGradeLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAddBookTemplate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfTemplateName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbTemplateGradeLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddBookTemplate))
                .addContainerGap(176, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout right2Layout = new javax.swing.GroupLayout(right2);
        right2.setLayout(right2Layout);
        right2Layout.setHorizontalGroup(
            right2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(right2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        right2Layout.setVerticalGroup(
            right2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, right2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jSplitPane3.setTopComponent(right2);

        left2.setBackground(new java.awt.Color(249, 239, 227));
        left2.setMinimumSize(new java.awt.Dimension(470, 477));

        lbSearchResult3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lbSearchResult3.setForeground(new java.awt.Color(1, 1, 1));
        lbSearchResult3.setText("Search using the search bar...");

        bookTemplatesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Grade Level", "Books Contained"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bookTemplatesTable.getTableHeader().setReorderingAllowed(false);
        bookTemplatesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bookTemplatesTableMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(bookTemplatesTable);

        tfSearchBookTemplate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBookTemplateHandler(evt);
            }
        });

        btnSearchBookTemplate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage5/icons/Search.png"))); // NOI18N
        btnSearchBookTemplate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBookTemplateHandler(evt);
            }
        });

        javax.swing.GroupLayout left2Layout = new javax.swing.GroupLayout(left2);
        left2.setLayout(left2Layout);
        left2Layout.setHorizontalGroup(
            left2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(left2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(left2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 977, Short.MAX_VALUE)
                    .addGroup(left2Layout.createSequentialGroup()
                        .addComponent(lbSearchResult3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfSearchBookTemplate, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearchBookTemplate)))
                .addContainerGap())
        );
        left2Layout.setVerticalGroup(
            left2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(left2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(left2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfSearchBookTemplate, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbSearchResult3)
                    .addComponent(btnSearchBookTemplate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                .addGap(72, 72, 72))
        );

        jSplitPane3.setBottomComponent(left2);

        javax.swing.GroupLayout manageBookTemplatesTabLayout = new javax.swing.GroupLayout(manageBookTemplatesTab);
        manageBookTemplatesTab.setLayout(manageBookTemplatesTabLayout);
        manageBookTemplatesTabLayout.setHorizontalGroup(
            manageBookTemplatesTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane3)
        );
        manageBookTemplatesTabLayout.setVerticalGroup(
            manageBookTemplatesTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 822, Short.MAX_VALUE)
        );

        myCards.add(manageBookTemplatesTab, "card4");

        editBookTemplateDialog.setBackground(new java.awt.Color(249, 239, 227));

        jSplitPane4.setDividerLocation(300);
        jSplitPane4.setDividerSize(1);

        left3.setBackground(new java.awt.Color(249, 239, 227));

        booksTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Code", "Book Name", "Grade Level"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        booksTable1.getTableHeader().setReorderingAllowed(false);
        booksTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                booksTable1MouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(booksTable1);

        tfSearchBook1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBookToAddHandler(evt);
            }
        });

        btnSearchBook1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage5/icons/Search.png"))); // NOI18N
        btnSearchBook1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBookToAddHandler(evt);
            }
        });

        btnAddBookToList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage5/icons/icons8_add_16px.png"))); // NOI18N
        btnAddBookToList.setText("Add Books To List");
        btnAddBookToList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddBookToListActionPerformed(evt);
            }
        });

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Select Books To Add");

        javax.swing.GroupLayout left3Layout = new javax.swing.GroupLayout(left3);
        left3.setLayout(left3Layout);
        left3Layout.setHorizontalGroup(
            left3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(left3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(left3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, left3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(left3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, left3Layout.createSequentialGroup()
                                .addComponent(tfSearchBook1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSearchBook1))
                            .addComponent(btnAddBookToList, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        left3Layout.setVerticalGroup(
            left3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(left3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(left3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSearchBook1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfSearchBook1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddBookToList)
                .addContainerGap())
        );

        jSplitPane4.setLeftComponent(left3);

        right3.setBackground(new java.awt.Color(249, 239, 227));

        booksTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Code", "Book Name", "Grade Level"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        booksTable2.getTableHeader().setReorderingAllowed(false);
        booksTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                booksTable2MouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(booksTable2);

        btnRemobeBookFromList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage5/icons/icons8_delete_bin_16px.png"))); // NOI18N
        btnRemobeBookFromList.setText("Remove Selected Books");
        btnRemobeBookFromList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemobeBookFromListActionPerformed(evt);
            }
        });

        jLabel10.setText("Books Contained");

        jLabel11.setText("Template Name");

        jLabel12.setText("Grade Level");

        jcbTemplateGradeLevel1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Grade 11", "Grade 12" }));
        jcbTemplateGradeLevel1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbTemplateGradeLevel1ItemStateChanged(evt);
            }
        });

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Template Details");

        javax.swing.GroupLayout right3Layout = new javax.swing.GroupLayout(right3);
        right3.setLayout(right3Layout);
        right3Layout.setHorizontalGroup(
            right3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(right3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(right3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, right3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnRemobeBookFromList))
                    .addComponent(tfTemplateName1)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
                    .addGroup(right3Layout.createSequentialGroup()
                        .addGroup(right3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jcbTemplateGradeLevel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        right3Layout.setVerticalGroup(
            right3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(right3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfTemplateName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbTemplateGradeLevel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRemobeBookFromList)
                .addContainerGap())
        );

        jSplitPane4.setRightComponent(right3);

        btnSaveBookTemplateChanges.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage5/icons/icons8_save_16px.png"))); // NOI18N
        btnSaveBookTemplateChanges.setText("Save Changes");
        btnSaveBookTemplateChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveBookTemplateChangesActionPerformed(evt);
            }
        });

        jLabel15.setText("Record ID: ");

        lbTemplateID.setText("0");

        jPanel5.setBackground(new java.awt.Color(203, 184, 160));
        jPanel5.setPreferredSize(new java.awt.Dimension(140, 47));

        jLabel39.setBackground(new java.awt.Color(0, 0, 0));
        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Edit Book Template");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel39)
                .addGap(25, 25, 25))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel39)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout editBookTemplateDialogLayout = new javax.swing.GroupLayout(editBookTemplateDialog);
        editBookTemplateDialog.setLayout(editBookTemplateDialogLayout);
        editBookTemplateDialogLayout.setHorizontalGroup(
            editBookTemplateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 997, Short.MAX_VALUE)
            .addGroup(editBookTemplateDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTemplateID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSaveBookTemplateChanges, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(editBookTemplateDialogLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        editBookTemplateDialogLayout.setVerticalGroup(
            editBookTemplateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editBookTemplateDialogLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSplitPane4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editBookTemplateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSaveBookTemplateChanges)
                    .addGroup(editBookTemplateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(lbTemplateID)))
                .addContainerGap())
        );

        myCards.add(editBookTemplateDialog, "card5");

        selectSectionTab.setBackground(new java.awt.Color(249, 239, 227));

        lbSearchResult.setForeground(new java.awt.Color(1, 1, 1));
        lbSearchResult.setText("Search using the search bar...");

        tfSearchTeacherLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchSectionHandler(evt);
            }
        });

        btnSearchSection.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage5/icons/Search.png"))); // NOI18N
        btnSearchSection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchSectionHandler(evt);
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
                "ID", "Section ID", "Section Name", "Adv ID", "Name", "Gender", "Subject ID", "Code", "Description", "Grade", "School Year", "Template ID", "Template Name", "Books Cotained"
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
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 977, Short.MAX_VALUE)
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
                .addGroup(selectSectionTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSearchResult)
                    .addComponent(tfSearchTeacherLoad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchSection)
                    .addComponent(jcbSchoolYear1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE)
                .addContainerGap())
        );

        myCards.add(selectSectionTab, "card6");

        selectBookTemplateDialog.setBackground(new java.awt.Color(249, 239, 227));

        jPanel12.setBackground(new java.awt.Color(203, 184, 160));

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Select Book Template");

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

        btnSaveTemplateSelected.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage5/icons/icons8_save_16px.png"))); // NOI18N
        btnSaveTemplateSelected.setText("Save");
        btnSaveTemplateSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveTemplateSelectedActionPerformed(evt);
            }
        });

        jSplitPane5.setDividerLocation(350);

        left4.setBackground(new java.awt.Color(203, 184, 160));

        tfSearchBookTemplate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBookTemplateToUseHandler(evt);
            }
        });

        btnSearchBookTemplate1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage5/icons/icons8_search_property_16px.png"))); // NOI18N
        btnSearchBookTemplate1.setText("Search");
        btnSearchBookTemplate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBookTemplateToUseHandler(evt);
            }
        });

        bookTemplatesTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Grade Level", "Books Contained"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bookTemplatesTable1.getTableHeader().setReorderingAllowed(false);
        bookTemplatesTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bookTemplatesTable1MouseClicked(evt);
            }
        });
        jScrollPane13.setViewportView(bookTemplatesTable1);

        javax.swing.GroupLayout left4Layout = new javax.swing.GroupLayout(left4);
        left4.setLayout(left4Layout);
        left4Layout.setHorizontalGroup(
            left4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(left4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(left4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(left4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(tfSearchBookTemplate1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearchBookTemplate1))
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        left4Layout.setVerticalGroup(
            left4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(left4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(left4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfSearchBookTemplate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchBookTemplate1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane5.setLeftComponent(left4);

        right4.setBackground(new java.awt.Color(249, 239, 227));

        jPanel13.setBackground(new java.awt.Color(203, 184, 160));

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Books Contained");

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

        booksTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Code", "Book Name", "Grade Level"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        booksTable3.getTableHeader().setReorderingAllowed(false);
        booksTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                booksTable3MouseClicked(evt);
            }
        });
        jScrollPane14.setViewportView(booksTable3);

        javax.swing.GroupLayout right4Layout = new javax.swing.GroupLayout(right4);
        right4.setLayout(right4Layout);
        right4Layout.setHorizontalGroup(
            right4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(right4Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(right4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        right4Layout.setVerticalGroup(
            right4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(right4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane5.setRightComponent(right4);

        javax.swing.GroupLayout selectBookTemplateDialogLayout = new javax.swing.GroupLayout(selectBookTemplateDialog);
        selectBookTemplateDialog.setLayout(selectBookTemplateDialogLayout);
        selectBookTemplateDialogLayout.setHorizontalGroup(
            selectBookTemplateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(selectBookTemplateDialogLayout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(selectBookTemplateDialogLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnSaveTemplateSelected)
                .addContainerGap())
            .addComponent(jSplitPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 997, Short.MAX_VALUE)
        );
        selectBookTemplateDialogLayout.setVerticalGroup(
            selectBookTemplateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(selectBookTemplateDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSplitPane5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSaveTemplateSelected)
                .addContainerGap())
        );

        myCards.add(selectBookTemplateDialog, "card7");

        distributeReturnBooksTab.setBackground(new java.awt.Color(249, 239, 227));
        distributeReturnBooksTab.setPreferredSize(new java.awt.Dimension(996, 782));

        jSplitPane2.setBorder(null);
        jSplitPane2.setDividerLocation(550);
        jSplitPane2.setDividerSize(2);

        left1.setBackground(new java.awt.Color(249, 239, 227));

        enrolledStudentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Student ID", "LRN", "Name", "Gender", "Section ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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

        lbSearchResult2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lbSearchResult2.setForeground(new java.awt.Color(58, 57, 57));
        lbSearchResult2.setText("Search using the search bar...");

        tfSearchEnrolledStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSearchEnrolledStudentsearchEnrolledStudentsHandler(evt);
            }
        });

        btnSearchEnrolledStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage5/icons/Search.png"))); // NOI18N
        btnSearchEnrolledStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchEnrolledStudentsearchEnrolledStudentsHandler(evt);
            }
        });

        javax.swing.GroupLayout left1Layout = new javax.swing.GroupLayout(left1);
        left1.setLayout(left1Layout);
        left1Layout.setHorizontalGroup(
            left1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(left1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(left1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(left1Layout.createSequentialGroup()
                        .addComponent(lbSearchResult2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfSearchEnrolledStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearchEnrolledStudent)))
                .addContainerGap())
        );
        left1Layout.setVerticalGroup(
            left1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(left1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(left1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(left1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbSearchResult2)
                        .addComponent(btnSearchEnrolledStudent))
                    .addComponent(tfSearchEnrolledStudent, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane2.setLeftComponent(left1);

        right1.setBackground(new java.awt.Color(249, 239, 227));

        booksUsedTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Book ID", "Code", "Name", "Grade", "Date ID", "Issued", "Returned", "Updated"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        booksUsedTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        booksUsedTable.getTableHeader().setReorderingAllowed(false);
        booksUsedTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                booksUsedTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(booksUsedTable);
        if (booksUsedTable.getColumnModel().getColumnCount() > 0) {
            booksUsedTable.getColumnModel().getColumn(2).setPreferredWidth(200);
            booksUsedTable.getColumnModel().getColumn(5).setPreferredWidth(100);
            booksUsedTable.getColumnModel().getColumn(5).setMaxWidth(70);
            booksUsedTable.getColumnModel().getColumn(6).setPreferredWidth(100);
            booksUsedTable.getColumnModel().getColumn(6).setMaxWidth(70);
            booksUsedTable.getColumnModel().getColumn(7).setPreferredWidth(200);
        }

        btnSaveStatusChanges.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage5/icons/icons8_save_16px.png"))); // NOI18N
        btnSaveStatusChanges.setText("Save");
        btnSaveStatusChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveStatusChangesActionPerformed(evt);
            }
        });

        jPanel18.setBackground(new java.awt.Color(203, 184, 160));

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("View Student Details");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 196, Short.MAX_VALUE)
            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel18Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel36)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 47, Short.MAX_VALUE)
            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel18Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel36)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout right1Layout = new javax.swing.GroupLayout(right1);
        right1.setLayout(right1Layout);
        right1Layout.setHorizontalGroup(
            right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(right1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, right1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSaveStatusChanges))
                    .addGroup(right1Layout.createSequentialGroup()
                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        right1Layout.setVerticalGroup(
            right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(right1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSaveStatusChanges)
                .addContainerGap())
        );

        jSplitPane2.setRightComponent(right1);

        javax.swing.GroupLayout distributeReturnBooksTabLayout = new javax.swing.GroupLayout(distributeReturnBooksTab);
        distributeReturnBooksTab.setLayout(distributeReturnBooksTabLayout);
        distributeReturnBooksTabLayout.setHorizontalGroup(
            distributeReturnBooksTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 997, Short.MAX_VALUE)
        );
        distributeReturnBooksTabLayout.setVerticalGroup(
            distributeReturnBooksTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2)
        );

        myCards.add(distributeReturnBooksTab, "card8");

        dateChooserDialog.setBackground(new java.awt.Color(249, 239, 227));

        jPanel14.setBackground(new java.awt.Color(203, 184, 160));

        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Choose Status");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel42)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel42)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        chooseDateGroup.add(rbDate);
        rbDate.setFont(myVariables.TEXTFIELD_FONT);
        rbDate.setSelected(true);
        rbDate.setText("Custom Date");
        rbDate.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage5/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        rbDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage5/icons/icons8_round_20px.png"))); // NOI18N
        rbDate.setIconTextGap(10);
        rbDate.setOpaque(false);
        rbDate.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage5/icons/icons8_ok_20px.png"))); // NOI18N

        chooseDateGroup.add(rbFm);
        rbFm.setFont(myVariables.TEXTFIELD_FONT);
        rbFm.setText("(FM) Force Majeure");
        rbFm.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage5/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        rbFm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage5/icons/icons8_round_20px.png"))); // NOI18N
        rbFm.setIconTextGap(10);
        rbFm.setOpaque(false);
        rbFm.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage5/icons/icons8_ok_20px.png"))); // NOI18N

        chooseDateGroup.add(rbNeg);
        rbNeg.setFont(myVariables.TEXTFIELD_FONT);
        rbNeg.setText("(NEG) Negligence");
        rbNeg.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage5/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        rbNeg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage5/icons/icons8_round_20px.png"))); // NOI18N
        rbNeg.setIconTextGap(10);
        rbNeg.setOpaque(false);
        rbNeg.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage5/icons/icons8_ok_20px.png"))); // NOI18N

        chooseDateGroup.add(rbTdo);
        rbTdo.setFont(myVariables.TEXTFIELD_FONT);
        rbTdo.setText("(TDO) Transferred/ Dropped Out");
        rbTdo.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage5/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        rbTdo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage5/icons/icons8_round_20px.png"))); // NOI18N
        rbTdo.setIconTextGap(10);
        rbTdo.setOpaque(false);
        rbTdo.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage5/icons/icons8_ok_20px.png"))); // NOI18N
        rbTdo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTdoActionPerformed(evt);
            }
        });

        chooseDateGroup.add(rbNone);
        rbNone.setFont(myVariables.TEXTFIELD_FONT);
        rbNone.setText("None");
        rbNone.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage5/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        rbNone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage5/icons/icons8_round_20px.png"))); // NOI18N
        rbNone.setIconTextGap(10);
        rbNone.setOpaque(false);
        rbNone.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage5/icons/icons8_ok_20px.png"))); // NOI18N
        rbNone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNoneActionPerformed(evt);
            }
        });

        cbLLTR.setFont(myVariables.TEXTFIELD_FONT);
        cbLLTR.setText("LLTR");
        cbLLTR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage5/icons/icons8_unchecked_checkbox_20px.png"))); // NOI18N
        cbLLTR.setIconTextGap(10);
        cbLLTR.setOpaque(false);
        cbLLTR.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage5/icons/icons8_tick_box_20px.png"))); // NOI18N
        cbLLTR.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage5/icons/icons8_checked_checkbox_20px.png"))); // NOI18N

        cbPTL.setFont(myVariables.TEXTFIELD_FONT);
        cbPTL.setText("PTL");
        cbPTL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage5/icons/icons8_unchecked_checkbox_20px.png"))); // NOI18N
        cbPTL.setIconTextGap(10);
        cbPTL.setOpaque(false);
        cbPTL.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage5/icons/icons8_tick_box_20px.png"))); // NOI18N
        cbPTL.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage5/icons/icons8_checked_checkbox_20px.png"))); // NOI18N

        cbTLTR.setFont(myVariables.TEXTFIELD_FONT);
        cbTLTR.setText("TLTR");
        cbTLTR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage5/icons/icons8_unchecked_checkbox_20px.png"))); // NOI18N
        cbTLTR.setIconTextGap(10);
        cbTLTR.setOpaque(false);
        cbTLTR.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage5/icons/icons8_tick_box_20px.png"))); // NOI18N
        cbTLTR.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage5/icons/icons8_checked_checkbox_20px.png"))); // NOI18N

        btnSetStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage5/icons/icons8_ok_16px.png"))); // NOI18N
        btnSetStatus.setText("OK");
        btnSetStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetStatusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dateChooserDialogLayout = new javax.swing.GroupLayout(dateChooserDialog);
        dateChooserDialog.setLayout(dateChooserDialogLayout);
        dateChooserDialogLayout.setHorizontalGroup(
            dateChooserDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dateChooserDialogLayout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(dateChooserDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dateChooserDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSetStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dateChooserDialogLayout.createSequentialGroup()
                        .addGroup(dateChooserDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rbNone, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rbTdo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rbNeg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rbFm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(dateChooserDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbLLTR, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbPTL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbTLTR, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jcbDateSelected, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        dateChooserDialogLayout.setVerticalGroup(
            dateChooserDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dateChooserDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rbDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbDateSelected, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(dateChooserDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbFm)
                    .addComponent(cbLLTR))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dateChooserDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbNeg)
                    .addComponent(cbPTL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dateChooserDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbTdo)
                    .addComponent(cbTLTR))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbNone)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSetStatus)
                .addContainerGap())
        );

        myCards.add(dateChooserDialog, "card9");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1017, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(myCards, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(myCards, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jMenuBar1.setToolTipText("");
        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage5/icons/icons8-male-user_circle-20.png"))); // NOI18N

        logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage5/icons/icons8-logout-rounded-up-20.png"))); // NOI18N
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

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        my.openWindow(this, new login());
    }//GEN-LAST:event_formWindowClosed

    private void assignedTeacherTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_assignedTeacherTableMouseClicked
        if(evt.getClickCount() == 2){
            int row = assignedTeacherTable.getSelectedRow();
            int templateId = Integer.parseInt(assignedTeacherTable.getValueAt(row, 11).toString());
            tab4.setBackground(Color.decode("#FDE8F0"));
            tab3.setBackground(Color.decode("#FBB9D3"));
            
            if(templateId != -1){
                loadBookTemplatesToTable();
                //my.showMessage("Loading", JOptionPane.INFORMATION_MESSAGE);
            }else{
                if(myVariables.getAccessLevel() != 4 && myVariables.getAccessLevel() != 5){
                    playError();
                    my.showMessage("This Section has no Book Template Assigned yet.\nPlease contact a "+
                            myVariables.getAccessLevelName(4)+" user to assign one", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                if(my.getConfirmation("This Section has no Book Template Assigned yet. Assign One now?")){
                    clearSelectBookTemplateFields(false, true, true);
                    myCards.removeAll();
                    myCards.add(selectBookTemplateDialog);
                    myCards.repaint();
                    myCards.revalidate();
                    
               
                    //showCustomDialog("Select a template for this Section", selectBookTemplateDialog, true, 600, 500, true);
                }
            }
        }else{
            if(myVariables.getAccessLevel() == 1){
                //my.remove_multiple_tabs(mainTab, new int [] {1});
            }else{
                //my.remove_multiple_tabs(mainTab, new int [] {3});
            }
        }
    }//GEN-LAST:event_assignedTeacherTableMouseClicked

    private void enrolledStudentsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_enrolledStudentsTableMouseClicked
        if(evt.getClickCount() != 2){
            clearBooksIssuedTable();
            return;
        }

        //Load Data from booksIssued/Returned Table
        int row = enrolledStudentsTable.getSelectedRow();
        
        String sectionId = enrolledStudentsTable.getValueAt(row, 5).toString();
        String studentId = enrolledStudentsTable.getValueAt(row, 1).toString();
        
        int bookCount = booksUsedTable.getRowCount();
        
        String bookIds = "";
        for(int n=0;n<bookCount;n++){
            bookIds+=booksUsedTable.getValueAt(n, 0).toString();
            if(n<bookCount-1){
                bookIds+=",";
            }
        }
        String where = "WHERE sectionId='"+sectionId+"' AND studentId='"+studentId+"' AND bookId IN("+bookIds+")";
        
        String [] result = my.return_values("*", "booksissuedreturned", where, myVariables.getBooksIssuedReturnedOrder());
        
        if(result == null){
            if(my.getConfirmation("This student has no records for this template.\nAdd them all now?")){
                String [] values = new String[bookCount];
                for(int n=0;n<bookCount;n++){
                    values[n] = "null,'"+sectionId+"','"+studentId+"','"+booksUsedTable.getValueAt(n, 0).toString()+"',' ',' ',now()";
                    if(n<bookCount-1){
                        bookIds+=",";
                    }
                }
                if(my.add_multiple_values("booksissuedreturned", "id,sectionId,studentId,bookId,dateIssued,dateReturned,dateUpdated", values)){
                    playSuccess();
                    my.showMessage("Adding Success. Please select the student again.", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    playError();
                    my.showMessage("Adding Failed. Please make sure you are connected to the School Network.", JOptionPane.ERROR_MESSAGE);
                }
                clearBooksIssuedTable();
            }else{
                clearBooksIssuedTable();
                enrolledStudentsTable.clearSelection();
            }
        }else{
            //Check for missing book records
            bookIds = "";
            boolean matchFound;
            int currentId=0,resultId=0;
            //match book IDS
            for(int n=0;n<bookCount;n++){
                matchFound = false;
                currentId = Integer.parseInt(booksUsedTable.getValueAt(n, 0).toString());
                for(int x=0;x<result.length;x++){
                    resultId = Integer.parseInt(my.getValueAtColumn(result[x], 3));
                    if(currentId == resultId){
                        //System.err.println(result[x]);
                        String values [] = result[x].split("@@");
                        String dateId = values[0];
                        String dateIssued = values[4];
                        String dateReturned = values[5];
                        String dateUpdated = values[6];
                        
                        booksUsedTable.setValueAt(dateId, n, 4);
                        booksUsedTable.setValueAt(dateIssued, n, 5);
                        booksUsedTable.setValueAt(dateReturned, n, 6);
                        booksUsedTable.setValueAt(dateUpdated, n, 7);
                        
                        matchFound = true;
                        break;
                    }
                }
                if(!matchFound){
                    bookIds+=currentId+",";
                }
            }
            
            if(bookIds.length()>0){
                if(my.getConfirmation("This student has missing records on other Books.\nWould you like to them now?"
                        + "\n\nPossible Reasons: \n-Registrar added/removed a Book to the Template.\n-Administrator forcibly deleted that record.")){
                    String [] missingIds = bookIds.split(",");
                    String [] values = new String[missingIds.length];
                    
                    for(int n=0;n<values.length;n++){
                        values[n] = "null,'"+sectionId+"','"+studentId+"','"+missingIds[n]+"',' ',' ',now()";
                    }
                    
                    if(my.add_multiple_values("booksissuedreturned", "id,sectionId,studentId,bookId,dateIssued,dateReturned,dateUpdated", values)){
                        playSuccess();
                        my.showMessage("Adding Success. Please select the student again.", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        playError();
                        my.showMessage("Adding Failed. Please make sure you are connected to the School Network.", JOptionPane.ERROR_MESSAGE);
                    }
                    clearBooksIssuedTable();
                }else{
                    clearBooksIssuedTable();
                    enrolledStudentsTable.clearSelection();
                }
            }else{
                booksUsedTable.setEnabled(true);
                btnSaveStatusChanges.setEnabled(true);
            }
        }
    }//GEN-LAST:event_enrolledStudentsTableMouseClicked

    private void tfSearchEnrolledStudentsearchEnrolledStudentsHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSearchEnrolledStudentsearchEnrolledStudentsHandler
        //DUPLICATED SEARCH
        int row = assignedTeacherTable.getSelectedRow();

        if(row == -1){
            Toolkit.getDefaultToolkit().beep();
            my.showMessage("Please select a section first.", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String sectionId = assignedTeacherTable.getValueAt(row, 1).toString();
        String toSearch = tfSearchEnrolledStudent.getText();

        String where = "WHERE sectionId='"+sectionId+"' AND (lrn='"+toSearch+"' OR lName LIKE '%"+toSearch+"%')";
        my.searchItem(where, enrolledStudentsTable, 6, null, new int [] {3,4,5}, true, true, lbSearchResult2, tfSearchEnrolledStudent, true);
        clearBooksIssuedTable();
    }//GEN-LAST:event_tfSearchEnrolledStudentsearchEnrolledStudentsHandler

    private void btnSearchEnrolledStudentsearchEnrolledStudentsHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchEnrolledStudentsearchEnrolledStudentsHandler
        //DUPLICATED SEARCH
        int row = assignedTeacherTable.getSelectedRow();

        if(row == -1){
            Toolkit.getDefaultToolkit().beep();
            my.showMessage("Please select a section first.", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String sectionId = assignedTeacherTable.getValueAt(row, 1).toString();
        String toSearch = tfSearchEnrolledStudent.getText();

        String where = "WHERE sectionId='"+sectionId+"' AND (lrn='"+toSearch+"' OR lName LIKE '%"+toSearch+"%' OR fName LIKE '%"+toSearch+"%')";
        my.searchItem(where, enrolledStudentsTable, 6, null, new int [] {3,4,5}, true, true, lbSearchResult2, tfSearchEnrolledStudent, true);
        clearBooksIssuedTable();
    }//GEN-LAST:event_btnSearchEnrolledStudentsearchEnrolledStudentsHandler

    private void bookTemplatesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookTemplatesTableMouseClicked
        if(evt.getClickCount() == 2){
            int row = bookTemplatesTable.getSelectedRow();
            String templateId = bookTemplatesTable.getValueAt(row, 0).toString();
            String name = bookTemplatesTable.getValueAt(row, 1).toString();
            String booksContained = "";
            try {
                booksContained = bookTemplatesTable.getValueAt(row, 3).toString().replace(":", ",");
            } catch (Exception e) {
                System.err.println("Null Books Contained");
            }
            
            int gradeLevel = Integer.parseInt(bookTemplatesTable.getValueAt(row, 2).toString());
            
            lbTemplateID.setText(templateId);
            tfTemplateName1.setText(name);
            switch(gradeLevel){
                case 11:{
                    jcbTemplateGradeLevel1.setSelectedIndex(0);
                    break;
                }case 12:{
                    jcbTemplateGradeLevel1.setSelectedIndex(1);
                    break;
                }
            }
            my.clear_table_rows(booksTable2);
            
            if(booksContained.length() > 0){
                booksContained = booksContained.substring(0, booksContained.length()-1);
                
                String [] result = my.return_values("*", "books", "WHERE id IN("+booksContained+")", myVariables.getBooksOrder());
                if(result != null){
                    for(String n : result){
                        my.add_table_row(n, booksTable2);
                    }
                }else{
                    playError();
                    my.showMessage("Ooops! These books might have been Deleted Just Now. Please contact your administraror.", JOptionPane.ERROR_MESSAGE);
                }
                
            }else{
                System.err.println("No books contained.");
            }
            myCards.removeAll();
            myCards.add(editBookTemplateDialog);
            myCards.repaint();
            myCards.revalidate();
            
            //showCustomDialog("Edit Template Selected", editBookTemplateDialog, true, 600, 500, true);
        }
    }//GEN-LAST:event_bookTemplatesTableMouseClicked

    private void searchBookTemplateHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBookTemplateHandler
        String toSearch = my.convertEscapeCharacters(tfSearchBookTemplate.getText().trim());
        String where = "WHERE templateName LIKE'%"+toSearch+"%' ORDER BY gradeLevel ASC, templateName ASC";
        my.searchItem(where, bookTemplatesTable, 9, null, null, false, true, lbSearchResult2, tfSearchBookTemplate, true);
        clearAddBookTemplateFields();
    }//GEN-LAST:event_searchBookTemplateHandler

    private void booksTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_booksTable1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_booksTable1MouseClicked

    private void booksTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_booksTable2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_booksTable2MouseClicked

    private void btnAddBookTemplateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddBookTemplateActionPerformed
        String name = my.convertEscapeCharacters(tfTemplateName.getText().trim());
        String gradeLevel = "";
        
        if(name.length()<=0){
            playError();
            my.showMessage("Please fill-up all fields.", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        switch (jcbTemplateGradeLevel.getSelectedIndex()){
            case 0:{
                gradeLevel = "11";
                break;
            }case 1:{
                gradeLevel = "12";
                break;
            }
        }
        
        String [] values = {
            "null,'"+name+"','"+gradeLevel+"',''",
        };
        
        if(my.add_values("booktemplates", "id,templateName,gradeLevel,booksContained", values)){
            playSuccess();
            my.showMessage("Added Successfully. Please select your newly added template to edit it.", JOptionPane.INFORMATION_MESSAGE);
            searchBookTemplateHandler(my.getButtonPressedEvent(evt.getSource()));
        }else{
            playError();
            my.showMessage("Adding Failed. Please make sure you are connected to the School Network.", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAddBookTemplateActionPerformed

    private void btnSaveBookTemplateChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveBookTemplateChangesActionPerformed
        String id = lbTemplateID.getText();
        String name = my.convertEscapeCharacters(tfTemplateName1.getText().trim());
        String gradeLevel = jcbTemplateGradeLevel1.getSelectedItem().toString().split(" ")[1];
        
        String booksContained="";
        for(int n=0;n<booksTable2.getRowCount();n++){
            String bookId = booksTable2.getValueAt(n, 0).toString();
            booksContained+=bookId+":";
        }
        String [] sets = {
            "templateName='"+name+"'",
            "gradeLevel='"+gradeLevel+"'",
            "booksContained='"+booksContained+"'",
        };
        
        if(my.update_values("booktemplates", sets, "id='"+id+"'")){
            playSuccess();
            my.showMessage("Update Successful.", JOptionPane.INFORMATION_MESSAGE);
            closeCustomDialog();
            searchBookTemplateHandler(my.getButtonPressedEvent(evt.getSource()));
        }else{
            playError();
            my.showMessage("Update Failed. Please make sure you are connected to the School Network.", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveBookTemplateChangesActionPerformed

    private void searchBookToAddHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBookToAddHandler
        String toSearch = my.convertEscapeCharacters(tfSearchBook1.getText().trim());
        String gradeLevel = "";
        switch (jcbTemplateGradeLevel1.getSelectedIndex()){
            case 0:{
                gradeLevel = "11";
                break;
            }case 1:{
                gradeLevel = "12";
                break;
            }
        }
        String where = "WHERE bookName LIKE '%"+toSearch+"%' AND gradeLevel='"+gradeLevel+"' ORDER BY bookCode ASC, bookName ASC";
        my.searchItem(where, booksTable1, 8, null, null, false, true, null, tfSearchBook1, true);
    }//GEN-LAST:event_searchBookToAddHandler

    private void jcbTemplateGradeLevel1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbTemplateGradeLevel1ItemStateChanged
        System.err.println("Item State Changed");
        clearEditBookTemplateTables();
    }//GEN-LAST:event_jcbTemplateGradeLevel1ItemStateChanged

    private void btnAddBookToListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddBookToListActionPerformed
        if(booksTable1.getSelectedRowCount() > 0){
            //Skip duplicates
            int selectedId=0,currentId=0,maxBooks = 10;
            int [] selectedRows = booksTable1.getSelectedRows();
            boolean matchFound;
            for(int n=0;n<selectedRows.length;n++){
                selectedId = Integer.parseInt(booksTable1.getValueAt(selectedRows[n], 0).toString());
                matchFound = false;
                
                for(int x=0;x<booksTable2.getRowCount();x++){
                    currentId = Integer.parseInt(booksTable2.getValueAt(x, 0).toString());
                    //Check for duplicates
                    if(selectedId == currentId){
                        matchFound = true;
                        break;
                    }
                }
                
                if(!matchFound){
                    if(booksTable2.getRowCount()+1 <= maxBooks){
                        String code = booksTable1.getValueAt(selectedRows[n], 1).toString();
                        String name = booksTable1.getValueAt(selectedRows[n], 2).toString();
                        String gradeLevel = booksTable1.getValueAt(selectedRows[n], 3).toString();

                        my.add_table_row(selectedId+"@@"+code+"@@"+name+"@@"+gradeLevel+"@@", booksTable2);
                    }else{
                        playError();
                        my.showMessage("Maximum of '"+maxBooks+"' are only allowed.", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                }
            }
        }else{
            Toolkit.getDefaultToolkit().beep();
            my.showMessage("Please select at least 1 book to add.", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAddBookToListActionPerformed

    private void btnRemobeBookFromListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemobeBookFromListActionPerformed
        if(booksTable2.getSelectedRowCount() > 0){
            int [] selectedRows = booksTable2.getSelectedRows();
            
            for(int n=selectedRows.length-1;n>=0;n--){
                my.remove_table_row(booksTable2, selectedRows[n]);
            }
        }else{
            Toolkit.getDefaultToolkit().beep();
            my.showMessage("Please select at least 1 Book to remove.", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnRemobeBookFromListActionPerformed

    private void bookTemplatesTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookTemplatesTable1MouseClicked
        if(evt.getClickCount() == 2){
            int row = bookTemplatesTable1.getSelectedRow();
            String templateId = bookTemplatesTable1.getValueAt(row, 0).toString();
            String name = bookTemplatesTable1.getValueAt(row, 1).toString();
            String booksContained = "";
            try {
                booksContained = bookTemplatesTable1.getValueAt(row, 3).toString().replace(":", ",");
            } catch (Exception e) {
                System.err.println("Null Books Contained");
            }

            int gradeLevel = Integer.parseInt(bookTemplatesTable1.getValueAt(row, 2).toString());
            //tfTemplateName1.setText(name);
            my.clear_table_rows(booksTable3);

            if(booksContained.length() > 0){
                booksContained = booksContained.substring(0, booksContained.length()-1);

                String [] result = my.return_values("*", "books", "WHERE id IN("+booksContained+")", myVariables.getBooksOrder());
                if(result != null){
                    for(String n : result){
                        my.add_table_row(n, booksTable3);
                    }
                }else{
                    playError();
                    my.showMessage("Ooops! These books might have been Deleted Just Now. Please contact your administraror.", JOptionPane.ERROR_MESSAGE);
                }

            }else{
                System.err.println("No books contained.");
            }
        }else{
            clearSelectBookTemplateFields(false,false,true);
        }
    }//GEN-LAST:event_bookTemplatesTable1MouseClicked

    private void searchBookTemplateToUseHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBookTemplateToUseHandler
        String toSearch = my.convertEscapeCharacters(tfSearchBookTemplate1.getText().trim());
        int row = assignedTeacherTable.getSelectedRow();
        
        if(row == -1){
            Toolkit.getDefaultToolkit().beep();
            my.showMessage("Please select a section.", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String gradeLevel = assignedTeacherTable.getValueAt(row, 9).toString();
        
        String where = "WHERE gradeLevel='"+gradeLevel+"' AND (templateName LIKE'%"+toSearch+"%') ORDER BY templateName ASC";
        
        clearSelectBookTemplateFields(false, false, true);
        my.searchItem(where, bookTemplatesTable1, 9, null, null, false, true, null, tfSearchBookTemplate1, true);
    }//GEN-LAST:event_searchBookTemplateToUseHandler

    private void booksTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_booksTable3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_booksTable3MouseClicked

    private void btnSaveTemplateSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveTemplateSelectedActionPerformed
        int row = assignedTeacherTable.getSelectedRow();
        int rowTemplate = bookTemplatesTable1.getSelectedRow();
        
        if(rowTemplate == -1){
            Toolkit.getDefaultToolkit().beep();
            my.showMessage("Please select a template.", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String sectionId = assignedTeacherTable.getValueAt(row, 1).toString();
        String templateId = bookTemplatesTable1.getValueAt(rowTemplate, 0).toString();
        
        String [] sets = {
            "bookTemplateId='"+templateId+"'",
        };
        if(my.update_values("sections", sets, "id='"+sectionId+"'")){
            playSuccess();
            my.showMessage("Update Successful. Please select the section again.", JOptionPane.INFORMATION_MESSAGE);
            closeCustomDialog();
            
            DefaultTableModel tMOdel = (DefaultTableModel)  assignedTeacherTable.getModel();
            tMOdel.setRowCount(0);
            
        }else{
            playError();
            my.showMessage("Update failed. Please make sure you are connected to the School Network.", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveTemplateSelectedActionPerformed
 
    private void booksUsedTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_booksUsedTableMouseClicked
        int studentRow = enrolledStudentsTable.getSelectedRow();
        int row = booksUsedTable.getSelectedRow();
        int col = booksUsedTable.getSelectedColumn();
        
        int dateId = 0;
        try {
            dateId = Integer.parseInt(booksUsedTable.getValueAt(row, 4).toString());
        } catch (Exception e) {return;}
        if(dateId == -1){
            return;
        }
        
        if(studentRow == -1){
            Toolkit.getDefaultToolkit().beep();
            my.showMessage("Please Select a Student.", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if(row != -1 && col != -1){
            switch (col){
                case 5:{
                    loadSelectStatusOptions(true,row,col);
                    myCards.removeAll();
                    myCards.add(dateChooserDialog);
                    myCards.repaint();
                    myCards.revalidate();
                    //showCustomDialog("Set Book Status", dateChooserDialog, true, 400, 350, false);
                    break;
                }case 6:{
                    loadSelectStatusOptions(false,row,col);
                    myCards.removeAll();
                    myCards.add(dateChooserDialog);
                    myCards.repaint();
                    myCards.revalidate();
                    //showCustomDialog("Set Book Status", dateChooserDialog, true, 400, 350, false);
                    break;
                }
            }
        }
    }//GEN-LAST:event_booksUsedTableMouseClicked

    private void rbTdoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTdoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbTdoActionPerformed

    private void rbNoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbNoneActionPerformed

    private void btnSetStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetStatusActionPerformed
        int row = booksUsedTable.getSelectedRow();
        int col = booksUsedTable.getSelectedColumn();
        
        String newStatus = "";
        if(rbDate.isSelected()){
            try {
                newStatus = my.jCalendarToNumberDate(jcbDateSelected.getDate().toString(), false);
            } catch (Exception e) {
                Toolkit.getDefaultToolkit().beep();
                my.showMessage("No Date selected.", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }
        if(rbFm.isSelected()){
            newStatus = cbLLTR.isSelected()? "FM:LLTR" : "FM";
        }
        if(rbNeg.isSelected()){
            newStatus = cbPTL.isSelected()? "NEG:PTL" : "NEG";
        }
        if(rbTdo.isSelected()){
            newStatus = cbTLTR.isSelected()? "TDO:TLTR" : "TDO";
        }
        if(rbNone.isSelected()){
            newStatus = " ";
        }
        
        booksUsedTable.setValueAt(newStatus, row, col);
        myCards.removeAll();
        myCards.add(distributeReturnBooksTab);
        myCards.repaint();
        myCards.revalidate();
    }//GEN-LAST:event_btnSetStatusActionPerformed

    private void btnSaveStatusChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveStatusChangesActionPerformed
        int studentRow = enrolledStudentsTable.getSelectedRow();
        int booksCount = booksUsedTable.getRowCount();
        
        String sectionId = enrolledStudentsTable.getValueAt(studentRow, 5).toString();
        String studentId = enrolledStudentsTable.getValueAt(studentRow, 1).toString();
        
        String bookId,dateId,dateIssued,dateReturned;
        String [] values = new String[booksCount];
        for(int n=0;n<booksCount;n++){
            try {
                dateId = booksUsedTable.getValueAt(n, 4).toString();
                bookId = booksUsedTable.getValueAt(n, 0).toString();
                dateIssued = booksUsedTable.getValueAt(n, 5).toString();
                dateReturned = booksUsedTable.getValueAt(n, 6).toString();
                
                values[n] = dateId+","+sectionId+","+studentId+","+bookId+",'"+dateIssued+"','"+dateReturned+"',now()";
                //System.err.println(values[n]);
            } catch (Exception e) {
                System.err.println("Skipped a Subject @ row "+n);
            }
        }
        
        if(my.update_multiple_values("booksissuedreturned", "id,sectionId,studentId,bookId,dateIssued,dateReturned,dateUpdated", "dateIssued=VALUES(dateIssued),dateReturned=VALUES(dateReturned),dateUpdated=VALUES(dateUpdated)", values)){
            playSuccess();
            my.showMessage("Updated Successfully.", JOptionPane.INFORMATION_MESSAGE);
            clearBooksIssuedTable();
        }else{
            playError();
            my.showMessage("Updated Failed. Please make sure you are connected to the School Network.", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveStatusChangesActionPerformed

    private void searchSectionHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchSectionHandler
        String toSearch = my.convertEscapeCharacters(tfSearchTeacherLoad.getText().trim());
        String schoolYear = jcbSchoolYear1.getSelectedItem().toString();

        //my.remove_multiple_tabs(mainTab, new int [] {1,2});
        //String where = "WHERE subjectCode LIKE 'ADV%'";
        String where = "WHERE subjectCode LIKE '%"+toSearch+"%' AND (gradeLevel = 11 OR gradeLevel = 12)";
        
        //Filter search based on Access Level
        switch (myVariables.getAccessLevel()){
            case 1:{    //Teacher or Subject Teacher
                where += " AND teacherId='"+myVariables.getUserLoggedInId()+"'";
                break;
            }case 2:{   //Department Head
                
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
            where +=" OR sectionName LIKE '%"+toSearch+"%'";
        }

        String [] result = my.return_values("*", "v_managedsubjects_wbooktemplate", where, myVariables.getManagedSubjectsWTemplateViewOrder());

        my.clear_table_rows(assignedTeacherTable);
        
        if(myVariables.getAccessLevel() == 1){
            //my.remove_multiple_tabs(mainTab, new int [] {1});
        }else{
            //my.remove_multiple_tabs(mainTab, new int [] {3});
        }
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
    }//GEN-LAST:event_searchSectionHandler

    private void searchBookHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBookHandler
        String toSearch = my.convertEscapeCharacters(tfSearchBook.getText().trim());
        clearAddBookFields();
        String where = "WHERE bookName LIKE'%"+toSearch+"%' OR bookCode LIKE'%"+toSearch+"%' ORDER BY gradeLevel ASC,bookName ASC,bookCode ASC";
        my.searchItem(where, booksTable, 8, null, null, false, true, lbSearchResult1, tfSearchBook, true);
    }//GEN-LAST:event_searchBookHandler

    private void booksTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_booksTableMouseClicked
        if(evt.getClickCount() == 2){
            int row = booksTable.getSelectedRow();
            String bookId = booksTable.getValueAt(row, 0).toString();
            String code = booksTable.getValueAt(row, 1).toString();
            String name = booksTable.getValueAt(row, 2).toString();

            int gradeLevel = Integer.parseInt(booksTable.getValueAt(row, 3).toString());

            lbBookId.setText(bookId);
            tfBookCode1.setText(code);
            tfBookName1.setText(name);

            switch(gradeLevel){
                case 11:{
                    jcbBookGradeLevel1.setSelectedIndex(0);
                    break;
                }case 12:{
                    jcbBookGradeLevel1.setSelectedIndex(1);
                    break;
                }
            }
            myCards.removeAll();
            myCards.add(editBookDialog);
            myCards.repaint();
            myCards.revalidate();
            //showCustomDialog("Edit Book Selected", editBookDialog, true, 250, 350, false);
        }else{

        }
    }//GEN-LAST:event_booksTableMouseClicked

    private void btnSaveBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveBookActionPerformed
        String code = my.convertEscapeCharacters(tfBookCode.getText().trim());
        String name = my.convertEscapeCharacters(tfBookName.getText().trim());
        String gradeLevel = "";

        if(code.length()<=0 || name.length()<=0){
            playError();
            my.showMessage("Please fill-up all fields.", JOptionPane.ERROR_MESSAGE);
            return;
        }

        switch (jcbBookGradeLevel.getSelectedIndex()){
            case 0:{
                gradeLevel = "11";
                break;
            }case 1:{
                gradeLevel = "12";
                break;
            }
        }

        String [] values = {
            "null,'"+code+"','"+name+"','"+gradeLevel+"'",
        };
        if(my.add_values("books", "id,bookCode,bookName,gradeLevel", values)){
            playSuccess();
            my.showMessage("Addedd Succesfully.", JOptionPane.INFORMATION_MESSAGE);
            searchBookHandler(my.getButtonPressedEvent(evt.getSource()));
        }else{
            playError();
            my.showMessage("Adding Failed. Please make sure you are connected to the School Network.", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveBookActionPerformed

    private void btnSaveBook1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveBook1ActionPerformed
        String bookId = lbBookId.getText();
        String code = my.convertEscapeCharacters(tfBookCode1.getText().trim());
        String name = my.convertEscapeCharacters(tfBookName1.getText().trim());
        String gradeLevel = "";

        if(code.length()<=0 || name.length()<=0){
            playError();
            my.showMessage("Please fill-up all fields.", JOptionPane.ERROR_MESSAGE);
            return;
        }

        switch (jcbBookGradeLevel1.getSelectedIndex()){
            case 0:{
                gradeLevel = "11";
                break;
            }case 1:{
                gradeLevel = "12";
                break;
            }
        }

        String [] sets = {
            "bookCode='"+code+"'",
            "bookName='"+name+"'",
            "gradeLevel='"+gradeLevel+"'",
        };

        if(my.update_values("books", sets, "id='"+bookId+"'")){
            playSuccess();
            my.showMessage("Update Successful.", JOptionPane.INFORMATION_MESSAGE);
            closeCustomDialog();
            searchBookHandler(my.getButtonPressedEvent(evt.getSource()));
        }else{
            playError();
            my.showMessage("Update Failed. Please make sure you are connected to the School Network.", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveBook1ActionPerformed

    private void tfBookCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfBookCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfBookCodeActionPerformed

    private void tab1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab1MouseClicked
        // TODO add your handling code here:
        myCards.removeAll();
        myCards.add(manageBooksTab);
        myCards.repaint();
        myCards.revalidate();

        tab1.setBackground(Color.decode("#FDE8F0"));

        tab2.setBackground(Color.decode("#FBB9D3"));
        tab3.setBackground(Color.decode("#FBB9D3"));
        tab4.setBackground(Color.decode("#FBB9D3"));
    }//GEN-LAST:event_tab1MouseClicked

    private void tab2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab2MouseClicked
        // TODO add your handling code here:
        myCards.removeAll();
        myCards.add(manageBookTemplatesTab);
        myCards.repaint();
        myCards.revalidate();

        tab2.setBackground(Color.decode("#FDE8F0"));

        tab1.setBackground(Color.decode("#FBB9D3"));
        tab3.setBackground(Color.decode("#FBB9D3"));
        tab4.setBackground(Color.decode("#FBB9D3"));
    }//GEN-LAST:event_tab2MouseClicked

    private void tab3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab3MouseClicked
        // TODO add your handling code here:
        myCards.removeAll();
        myCards.add(selectSectionTab);
        myCards.repaint();
        myCards.revalidate();
        
        DefaultTableModel tMOdel = (DefaultTableModel)  assignedTeacherTable.getModel();
        tMOdel.setRowCount(0);
        
        tab3.setBackground(Color.decode("#FDE8F0"));

        tab1.setBackground(Color.decode("#FBB9D3"));
        tab2.setBackground(Color.decode("#FBB9D3"));
        tab4.setBackground(Color.decode("#FBB9D3"));
    }//GEN-LAST:event_tab3MouseClicked

    private void tab4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab4MouseClicked
        // TODO add your handling code here:
        myCards.removeAll();
        myCards.add(distributeReturnBooksTab);
        myCards.repaint();
        myCards.revalidate();

        tab4.setBackground(Color.decode("#FDE8F0"));

        tab1.setBackground(Color.decode("#FBB9D3"));
        tab3.setBackground(Color.decode("#FBB9D3"));
        tab2.setBackground(Color.decode("#FBB9D3"));
    }//GEN-LAST:event_tab4MouseClicked

    private void jcbBookGradeLevel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbBookGradeLevel1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbBookGradeLevel1ActionPerformed

    private void jcbTemplateGradeLevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTemplateGradeLevelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbTemplateGradeLevelActionPerformed

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
    private void loadBookTemplatesToTable(){
        int row = assignedTeacherTable.getSelectedRow();
        String booksContained = "None";
        try {
            booksContained = assignedTeacherTable.getValueAt(row, 13).toString();
        } catch (Exception e) {System.err.println("Null books");}  
        
        if(booksContained.contains("None")){
            System.err.println("Don't Load. Empty Books");
            playError();
            my.showMessage("The TEMPLATE used by this section seems to have no Books in it.\nPlease contact a "+myVariables.getAccessLevelName(4)+" User for this error.", JOptionPane.ERROR_MESSAGE);
            return;
        }else{
            tab4.setVisible(true);
            
            myCards.removeAll();
            myCards.add(distributeReturnBooksTab);
            myCards.repaint();
            myCards.revalidate();
            //my.addTab("Distribute/Return Books", my.getImgIcn(myVariables.getViewStudentsIcon()), distributeReturnBooksTab);
            if(myVariables.getAccessLevel() == 1){
                //myCards.setSelectedIndex(1);
            }else{
                //myCards.setSelectedIndex(3);
            }
            
            booksContained = booksContained.replace(":", ",");
            booksContained = booksContained.substring(0,booksContained.length()-1);
            String [] result = my.return_values("*", "books", "WHERE id IN ("+booksContained+")",myVariables.getBooksOrder());
            
            my.clear_table_rows(booksUsedTable);
            if(result != null){
                for(String n : result){
                    my.add_table_row(n+"@@@@@@", booksUsedTable);
                }
            }
        }
    }
    private void loadSelectStatusOptions(boolean isDateIssued,int row,int col){
        //Clear Selections
        rbFm.setSelected(false);
        rbNeg.setSelected(false);
        rbTdo.setSelected(false);
        
        cbLLTR.setSelected(false);
        cbPTL.setSelected(false);
        cbTLTR.setSelected(false);
        
        //Load Selected Status
        String status = booksUsedTable.getValueAt(row, col).toString();
        if(status.length() == 1){
            rbNone.setSelected(true);
        }
        if(status.contains("-")){
            String [] date = status.split("-");
            int year =Integer.parseInt(date[0]),month=Integer.parseInt(date[1]),day = Integer.parseInt(date[2]);
            rbDate.setSelected(true);
            jcbDateSelected.setDate(new Date(year-1900, month-1, day));
        }
        
        if(isDateIssued){
            rbFm.setEnabled(false);
            rbNeg.setEnabled(false);
            rbTdo.setEnabled(false);
            
            cbLLTR.setEnabled(false);
            cbPTL.setEnabled(false);
            cbTLTR.setEnabled(false);
        }else{
            rbFm.setEnabled(true);
            rbNeg.setEnabled(true);
            rbTdo.setEnabled(true);
            
            cbLLTR.setEnabled(true);
            cbPTL.setEnabled(true);
            cbTLTR.setEnabled(true);
            
            if(status.contains("FM")){
                rbFm.setSelected(true);
                cbLLTR.setSelected(status.contains("LLTR")?true:false);return;
            }
            if(status.contains("NEG")){
                rbNeg.setSelected(true);
                cbPTL.setSelected(status.contains("PTL")?true:false);return;
            }
            if(status.contains("TDO")){
                rbTdo.setSelected(true);
                cbTLTR.setSelected(status.contains("TLTR")?true:false);
            }
        }
    }
    
    private void clearSelectBookTemplateFields(boolean clearSearchField,boolean clearTemplatesTable,boolean clearBooksTable){
        if(clearSearchField)
            tfSearchBookTemplate1.setText("");
        if(clearTemplatesTable)
            my.clear_table_rows(bookTemplatesTable1);
        if(clearBooksTable)
            my.clear_table_rows(booksTable3);
    }
    private void clearAddBookFields(){
        tfBookCode.setText("");
        tfBookName.setText("");
    }
    private void clearAddBookTemplateFields(){
        tfTemplateName.setText("");
    }
    private void clearEditBookTemplateTables(){
        my.clear_table_rows(booksTable1);
        my.clear_table_rows(booksTable2);
    }
    private void clearBooksIssuedTable(){
        for(int n=0;n<booksUsedTable.getRowCount();n++){
            booksUsedTable.setValueAt("-1", n, 4);
            booksUsedTable.setValueAt(" ", n, 5);
            booksUsedTable.setValueAt(" ", n, 6);
            booksUsedTable.setValueAt("", n, 7);
        }
        booksUsedTable.setEnabled(false);
        booksUsedTable.clearSelection();
        
        btnSaveStatusChanges.setEnabled(false);
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
            //jScrollPane2,jScrollPane3,
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
                
        //Hide Table Columns
        if(!myVariables.isDebugModeOn()){
            my.hideColumns(assignedTeacherTable, new int [] {0,1,3,6,11,13});
            my.hideColumns(booksTable, new int [] {0});
            my.hideColumns(booksTable1, new int [] {0});
            my.hideColumns(booksTable2, new int [] {0});
            my.hideColumns(booksTable3, new int [] {0});
            my.hideColumns(bookTemplatesTable, new int [] {0,3});
            my.hideColumns(bookTemplatesTable1, new int [] {0,3});
            my.hideColumns(enrolledStudentsTable, new int [] {0,1,5});
            my.hideColumns(booksUsedTable, new int [] {0,3,4});
        }
        
        
        //Set table fonts
        JTable tables [] = {
            assignedTeacherTable,
            booksTable,bookTemplatesTable,booksTable1,booksTable2,
            bookTemplatesTable1,booksTable3,enrolledStudentsTable,
            booksUsedTable,
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
        if(myVariables.getAccessLevel() == 1){
            jPanel3.remove(tab1);
            jPanel3.remove(tab2);
            jPanel3.repaint();
            jPanel3.revalidate();
            
            myCards.removeAll();   
            myCards.add(selectSectionTab);
            myCards.repaint();
            myCards.revalidate();
        }
        tab4.setVisible(false);
    }   
    private void loadTabIcons(){
        Icon tabIcons [] = {
            my.getImgIcn(myVariables.getBooksIcon()),
            my.getImgIcn(myVariables.getBookTemplatesIcon()),
            my.getImgIcn(myVariables.getSectionsIcon()),
            my.getImgIcn(myVariables.getViewStudentsIcon()),
        };
        
        for(int n=0;n<tabIcons.length;n++){
           // mainTab.setIconAt(n,tabIcons[n]);
        }
        
        if(myVariables.getAccessLevel() == 1){
            //my.remove_multiple_tabs(myCards, new int [] {0,1,3});
        }else{
            //my.remove_multiple_tabs(mainTab, new int [] {3});
        }
    }
    private void loadColoredButtons(){
        JButton buttons [] = {
            btnSearchSection,btnSearchEnrolledStudent,btnSearchBook,
            btnSaveBook1,
            
            btnSearchBook1,btnAddBookToList,btnRemobeBookFromList,
            btnSearchBookTemplate,btnSaveBookTemplateChanges,
            
            btnSearchBookTemplate1,btnSaveTemplateSelected,
            
            btnSetStatus,btnSaveStatusChanges,
        };
        
        JButton lightButtons [] = {
            btnSaveBook,btnAddBookTemplate
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
            lightButtons[n].setBackground(new Color(249, 239, 227));
            lightButtons[n].setForeground(Color.BLACK); 
            buttons[n].setFont(myVariables.BUTTON_FONT);
            //lightButtons[n].setFont(myVariables.BUTTON_FONT);
//            buttons[n].setCursor(my.getCursor(myVariables.getHandCursor()));
            lightButtons[n].setCursor(new Cursor(Cursor.HAND_CURSOR));
            lightButtons[n].setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
    }
    private void loadLabels(){
        
        JLabel dashboardbutton [] = {
            tab1Label,tab2Label,tab3Label,tab4Label
        };
        
        JLabel titleHeaderLabels [] = {
            jLabel36,jLabel37,jLabel39,jLabel40,jLabel41,jLabel42,jLabel43,jLabel96,
        };
        JLabel labels [] = {
            lbSearchResult,lbSearchResult1,lbSearchResult2,lbSearchResult3,
        };
        
        JLabel formsHeaderLabels [] = {
            jLabel13,jLabel14,
        };
        JLabel textFieldHeaderLabels [] = {
            jLabel1,jLabel2,jLabel6,jLabel3,jLabel4,jLabel7,jLabel8,jLabel9,
            jLabel10,jLabel11,jLabel12,
        };
        
//        for (JLabel n : dashboardbutton) {
//            n.setFont(myPSemiBold.deriveFont(12f)); 
//            n.setForeground(Color.BLACK);
//        }
        
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
            jcbDateSelected,
        };
        JSpinner spinners [] = {
            //jsHours,jsMinutes
        };
        
        JTextField searchFields [] = {
            tfSearchTeacherLoad,tfSearchBook,tfSearchBook1,tfSearchBookTemplate,tfSearchBookTemplate1,
            tfSearchEnrolledStudent,
        };
        JTextField forms [] = {
            tfBookName,tfBookName1,tfBookCode,tfBookCode1,tfTemplateName,tfTemplateName1,
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
            jcbBookGradeLevel,jcbBookGradeLevel1,jcbTemplateGradeLevel,jcbTemplateGradeLevel1,
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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable assignedTeacherTable;
    private javax.swing.JTable bookTemplatesTable;
    private javax.swing.JTable bookTemplatesTable1;
    private javax.swing.JTable booksTable;
    private javax.swing.JTable booksTable1;
    private javax.swing.JTable booksTable2;
    private javax.swing.JTable booksTable3;
    private javax.swing.JTable booksUsedTable;
    private javax.swing.JButton btnAddBookTemplate;
    private javax.swing.JButton btnAddBookToList;
    private javax.swing.JButton btnRemobeBookFromList;
    private javax.swing.JButton btnSaveBook;
    private javax.swing.JButton btnSaveBook1;
    private javax.swing.JButton btnSaveBookTemplateChanges;
    private javax.swing.JButton btnSaveStatusChanges;
    private javax.swing.JButton btnSaveTemplateSelected;
    private javax.swing.JButton btnSearchBook;
    private javax.swing.JButton btnSearchBook1;
    private javax.swing.JButton btnSearchBookTemplate;
    private javax.swing.JButton btnSearchBookTemplate1;
    private javax.swing.JButton btnSearchEnrolledStudent;
    private javax.swing.JButton btnSearchSection;
    private javax.swing.JButton btnSetStatus;
    private javax.swing.JCheckBox cbLLTR;
    private javax.swing.JCheckBox cbPTL;
    private javax.swing.JCheckBox cbTLTR;
    private javax.swing.ButtonGroup chooseDateGroup;
    private javax.swing.JPanel dateChooserDialog;
    private javax.swing.JPanel distributeReturnBooksTab;
    private javax.swing.JPanel editBookDialog;
    private javax.swing.JPanel editBookTemplateDialog;
    private javax.swing.JTable enrolledStudentsTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JSplitPane jSplitPane3;
    private javax.swing.JSplitPane jSplitPane4;
    private javax.swing.JSplitPane jSplitPane5;
    private javax.swing.JComboBox<String> jcbBookGradeLevel;
    private javax.swing.JComboBox<String> jcbBookGradeLevel1;
    private com.toedter.calendar.JDateChooser jcbDateSelected;
    private javax.swing.JComboBox<String> jcbSchoolYear1;
    private javax.swing.JComboBox<String> jcbTemplateGradeLevel;
    private javax.swing.JComboBox<String> jcbTemplateGradeLevel1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lbAccess;
    private javax.swing.JLabel lbBookId;
    private javax.swing.JLabel lbSearchResult;
    private javax.swing.JLabel lbSearchResult1;
    private javax.swing.JLabel lbSearchResult2;
    private javax.swing.JLabel lbSearchResult3;
    private javax.swing.JLabel lbTemplateID;
    private javax.swing.JLabel lbUsername;
    private javax.swing.JLabel lbWelcome;
    private javax.swing.JPanel left;
    private javax.swing.JPanel left1;
    private javax.swing.JPanel left2;
    private javax.swing.JPanel left3;
    private javax.swing.JPanel left4;
    private javax.swing.JMenuItem logout;
    private javax.swing.JPanel manageBookTemplatesTab;
    private javax.swing.JPanel manageBooksTab;
    private javax.swing.JMenu menu;
    private javax.swing.JPanel myCards;
    private javax.swing.JRadioButton rbDate;
    private javax.swing.JRadioButton rbFm;
    private javax.swing.JRadioButton rbNeg;
    private javax.swing.JRadioButton rbNone;
    private javax.swing.JRadioButton rbTdo;
    private javax.swing.JPanel right;
    private javax.swing.JPanel right1;
    private javax.swing.JPanel right2;
    private javax.swing.JPanel right3;
    private javax.swing.JPanel right4;
    private javax.swing.JPanel selectBookTemplateDialog;
    private javax.swing.JPanel selectSectionTab;
    private javax.swing.JPanel tab1;
    private javax.swing.JLabel tab1Label;
    private javax.swing.JPanel tab2;
    private javax.swing.JLabel tab2Label;
    private javax.swing.JPanel tab3;
    private javax.swing.JLabel tab3Label;
    private javax.swing.JPanel tab4;
    private javax.swing.JLabel tab4Label;
    private javax.swing.JTextField tfBookCode;
    private javax.swing.JTextField tfBookCode1;
    private javax.swing.JTextField tfBookName;
    private javax.swing.JTextField tfBookName1;
    private javax.swing.JTextField tfSearchBook;
    private javax.swing.JTextField tfSearchBook1;
    private javax.swing.JTextField tfSearchBookTemplate;
    private javax.swing.JTextField tfSearchBookTemplate1;
    private javax.swing.JTextField tfSearchEnrolledStudent;
    private javax.swing.JTextField tfSearchTeacherLoad;
    private javax.swing.JTextField tfTemplateName;
    private javax.swing.JTextField tfTemplateName1;
    // End of variables declaration//GEN-END:variables
}
