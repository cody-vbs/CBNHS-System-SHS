/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mahPackage4;

import com.toedter.calendar.JDateChooser;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import javazoom.jl.player.Player;

/**
 *
 * @author Phil Rey, reworked by batch 2018
 */
public class dashBoard extends javax.swing.JFrame {
    myFunctions my;
    CardLayout cardLayout;
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
                        
                        poppins14R = Font.createFont(Font.TRUETYPE_FONT, new File("Poppins-Regular.ttf")).deriveFont(14f);	
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
        
        Component [] components = this. getContentPane().getComponents();
        for(Component component : components){
            if(component instanceof JButton){
                ((JButton) component).setUI(new  BasicButtonUI());
                ((JButton) component).setFocusPainted(false);
            }
        }
        
        jLabel22.setFont(poppins12R);
        lbLoggedInUser.setText(myVariables.getUserLoggedInName());
        lbLoggedInUser.setFont(poppins14);        
        lbLoggedInUser1.setText(myVariables.getAccessLevelName(-1));
        lbLoggedInUser1.setFont(poppins12R);
        //cardLayout = (CardLayout)(jPanel4.getLayout());
                       
        loadTabs();
        loadTabIcons();
        
        loadColoredButtons();
        loadLabels();
        
        loadTextFields();
        sortTables();
        
        setScrollSpeeds();
        loadYearDropDowns(12);
        
        myVariables.setProgressBar(pbProgressBar);
        myVariables.setLbLoadingMessage(lbMessage);
                
        hideElementsByAccessLevel();
        refreshAssignedSubjects(false);
        
        btnManageGrades.setBackground(Color.decode("#FDE8F0"));
        
        btnMyManagedSubjects.setBackground(Color.decode("#FBB9D3"));
        btnImportFromSf10.setBackground(Color.decode("#FBB9D3"));
        
        tfSearchTeacherLoad.requestFocus();
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
        viewStudentsTab2 = new javax.swing.JPanel();
        jSplitPane2 = new javax.swing.JSplitPane();
        left2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lbSectionName2 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lbSubjectName2 = new javax.swing.JLabel();
        btnSaveChangesCurrent = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        lbEvaluation = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        lbStatusOptions1 = new javax.swing.JLabel();
        jRadioButton17 = new javax.swing.JRadioButton();
        jRadioButton18 = new javax.swing.JRadioButton();
        jRadioButton19 = new javax.swing.JRadioButton();
        jRadioButton20 = new javax.swing.JRadioButton();
        lbStatusOptions2 = new javax.swing.JLabel();
        jRadioButton21 = new javax.swing.JRadioButton();
        jRadioButton22 = new javax.swing.JRadioButton();
        jRadioButton23 = new javax.swing.JRadioButton();
        jRadioButton24 = new javax.swing.JRadioButton();
        lbStatusOptions3 = new javax.swing.JLabel();
        jRadioButton25 = new javax.swing.JRadioButton();
        jRadioButton26 = new javax.swing.JRadioButton();
        jRadioButton27 = new javax.swing.JRadioButton();
        jRadioButton28 = new javax.swing.JRadioButton();
        lbStatusOptions4 = new javax.swing.JLabel();
        jRadioButton29 = new javax.swing.JRadioButton();
        jRadioButton30 = new javax.swing.JRadioButton();
        jRadioButton31 = new javax.swing.JRadioButton();
        jRadioButton32 = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        btnDphSelected = new javax.swing.JButton();
        btnDphAll = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        btnRgrSelected = new javax.swing.JButton();
        btnRgrAll = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        btnAdvSelected = new javax.swing.JButton();
        btnAdvAll = new javax.swing.JButton();
        right2 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        enrolledStudentsTable1 = new javax.swing.JTable();
        pbProgressBar = new javax.swing.JProgressBar();
        lbMessage = new javax.swing.JLabel();
        btnRefreshStudents = new javax.swing.JButton();
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
        jPanel1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnEditGrades = new javax.swing.JButton();
        lbDateUpdated = new javax.swing.JLabel();
        lbGradeStatus = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfFirstQ = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfSecondQ = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfThirdQ = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfFourthQ = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tfGeneralWeighedAverage = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lbSubjectName = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lbRecordId = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        selectQuarterDialog = new javax.swing.JPanel();
        lbQuarterSelect = new javax.swing.JLabel();
        btnSelectQuarter = new javax.swing.JButton();
        rbQuarter1 = new javax.swing.JRadioButton();
        rbQuarter2 = new javax.swing.JRadioButton();
        rbQuarter3 = new javax.swing.JRadioButton();
        rbQuarter4 = new javax.swing.JRadioButton();
        rbAllQuarters = new javax.swing.JRadioButton();
        editGradeDialog = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        contentsPanel = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tfEditFirstQuarter = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfEditSecondQuarter = new javax.swing.JTextField();
        tfEditThirdQuarter = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tfEditFourthQuarter = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        rbAutomatic = new javax.swing.JRadioButton();
        rbManual = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();
        tfEditGwa = new javax.swing.JTextField();
        btnSaveGradeChanges = new javax.swing.JButton();
        cbAllowDecimalValues = new javax.swing.JCheckBox();
        lbStatusOptions = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();
        jRadioButton10 = new javax.swing.JRadioButton();
        jRadioButton11 = new javax.swing.JRadioButton();
        jRadioButton12 = new javax.swing.JRadioButton();
        jRadioButton13 = new javax.swing.JRadioButton();
        jRadioButton14 = new javax.swing.JRadioButton();
        jRadioButton15 = new javax.swing.JRadioButton();
        jRadioButton16 = new javax.swing.JRadioButton();
        tfEvaluation = new javax.swing.JTextField();
        computationOptionGroup = new javax.swing.ButtonGroup();
        q1StatusGroup = new javax.swing.ButtonGroup();
        q2StatusGroup = new javax.swing.ButtonGroup();
        q3tatusGroup = new javax.swing.ButtonGroup();
        q4StatusGroup = new javax.swing.ButtonGroup();
        selectQuarterGroup = new javax.swing.ButtonGroup();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        headerPanel = new javax.swing.JPanel();
        btnManageGrades = new javax.swing.JButton();
        btnMyManagedSubjects = new javax.swing.JButton();
        btnImportFromSf10 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel28 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        lbLoggedInUser = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        lbLoggedInUser1 = new javax.swing.JLabel();
        contentPanel = new javax.swing.JPanel();
        cards = new javax.swing.JPanel();
        card1 = new javax.swing.JPanel();
        mainTab = new javax.swing.JTabbedPane();
        card2 = new javax.swing.JPanel();
        myAssignedSubjectsDialog = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        assignedSubjectsTable = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        btnRefresh = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        card3 = new javax.swing.JPanel();
        importDialog = new javax.swing.JPanel();
        jtbImportTabs = new javax.swing.JTabbedPane();
        selectStudentTab = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        studentTable = new javax.swing.JTable();
        tfSearchStudent = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        lbSearchResult2 = new javax.swing.JLabel();
        selectSf10Tab = new javax.swing.JPanel();
        jLabel95 = new javax.swing.JLabel();
        jcbFileFormats = new javax.swing.JComboBox<>();
        tfFileLocation = new javax.swing.JTextField();
        btnOpenFileExplorer = new javax.swing.JButton();
        gradeTabs = new javax.swing.JTabbedPane();
        gradeDetailsTab = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        importedGradeDetailsTable = new javax.swing.JTable();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        importedGradesTable = new javax.swing.JTable();
        lbImportedGeneralAverage = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel94 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu = new javax.swing.JMenu();
        logout = new javax.swing.JMenuItem();

        selectSectionTab.setBackground(new java.awt.Color(203, 184, 160));

        lbSearchResult.setForeground(new java.awt.Color(255, 255, 255));
        lbSearchResult.setText("Search using the search bar...");

        tfSearchTeacherLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSearchTeacherLoadsearchManagedSections(evt);
            }
        });

        btnSearchSection.setBackground(new java.awt.Color(255, 255, 255));
        btnSearchSection.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/search_24px.png"))); // NOI18N
        btnSearchSection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchSectionsearchManagedSections(evt);
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
        if (assignedTeacherTable.getColumnModel().getColumnCount() > 0) {
            assignedTeacherTable.getColumnModel().getColumn(5).setPreferredWidth(70);
            assignedTeacherTable.getColumnModel().getColumn(5).setMaxWidth(70);
            assignedTeacherTable.getColumnModel().getColumn(7).setPreferredWidth(70);
            assignedTeacherTable.getColumnModel().getColumn(7).setMaxWidth(70);
            assignedTeacherTable.getColumnModel().getColumn(9).setPreferredWidth(70);
            assignedTeacherTable.getColumnModel().getColumn(9).setMaxWidth(70);
            assignedTeacherTable.getColumnModel().getColumn(10).setPreferredWidth(100);
            assignedTeacherTable.getColumnModel().getColumn(10).setMaxWidth(100);
        }

        javax.swing.GroupLayout selectSectionTabLayout = new javax.swing.GroupLayout(selectSectionTab);
        selectSectionTab.setLayout(selectSectionTabLayout);
        selectSectionTabLayout.setHorizontalGroup(
            selectSectionTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(selectSectionTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(selectSectionTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 783, Short.MAX_VALUE)
                    .addGroup(selectSectionTabLayout.createSequentialGroup()
                        .addComponent(lbSearchResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(31, 31, 31)
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
                .addGroup(selectSectionTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSearchSection, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbSearchResult)
                    .addComponent(jcbSchoolYear1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfSearchTeacherLoad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane2.setBorder(null);
        jSplitPane2.setDividerLocation(350);
        jSplitPane2.setDividerSize(0);
        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        left2.setBackground(new java.awt.Color(203, 184, 160));
        left2.setPreferredSize(new java.awt.Dimension(699, 200));

        jPanel2.setBackground(new java.awt.Color(203, 184, 160));
        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jPanel2.setForeground(new java.awt.Color(1, 1, 1));
        jPanel2.setPreferredSize(new java.awt.Dimension(753, 314));

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(1, 1, 1));
        jLabel38.setText("Grade Details");

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("Basic Information");

        jLabel19.setForeground(new java.awt.Color(1, 1, 1));
        jLabel19.setText("Section Name:");

        lbSectionName2.setForeground(new java.awt.Color(1, 1, 1));
        lbSectionName2.setText("SECTION_NAME");

        jLabel21.setForeground(new java.awt.Color(1, 1, 1));
        jLabel21.setText("Subject Name:");

        lbSubjectName2.setForeground(new java.awt.Color(1, 1, 1));
        lbSubjectName2.setText("SUBJECT_NAME");

        btnSaveChangesCurrent.setText("Save Changes (This Student)");
        btnSaveChangesCurrent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveChangesCurrentActionPerformed(evt);
            }
        });

        jLabel22.setForeground(new java.awt.Color(1, 1, 1));
        jLabel22.setText("Evaluation:");

        lbEvaluation.setForeground(new java.awt.Color(1, 1, 1));
        lbEvaluation.setText("-- Select Student --");

        jPanel4.setBackground(new java.awt.Color(203, 184, 160));

        jLabel23.setForeground(new java.awt.Color(1, 1, 1));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("Grade Details");

        lbStatusOptions1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbStatusOptions1.setText("1st Semester - 1st Quarter Status");

        jRadioButton17.setBackground(new java.awt.Color(203, 184, 160));
        q1StatusGroup.add(jRadioButton17);
        jRadioButton17.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton17.setForeground(new java.awt.Color(0, 102, 0));
        jRadioButton17.setSelected(true);
        jRadioButton17.setText("Open");
        jRadioButton17.setToolTipText("The subject teacher can edit the grades.");
        jRadioButton17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton17.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton17.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton17.setFocusable(false);
        jRadioButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton17.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton30MouseClicked(evt);
            }
        });
        jRadioButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton17ActionPerformed(evt);
            }
        });

        jRadioButton18.setBackground(new java.awt.Color(203, 184, 160));
        q1StatusGroup.add(jRadioButton18);
        jRadioButton18.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton18.setForeground(new java.awt.Color(0, 0, 153));
        jRadioButton18.setText("Submitted");
        jRadioButton18.setToolTipText("Once submitted, subject teachers can't edit the grade anymore and should wait for the Approval of the Department Head");
        jRadioButton18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton18.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton18.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton18.setFocusable(false);
        jRadioButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton18.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton30MouseClicked(evt);
            }
        });
        jRadioButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton18ActionPerformed(evt);
            }
        });

        jRadioButton19.setBackground(new java.awt.Color(203, 184, 160));
        q1StatusGroup.add(jRadioButton19);
        jRadioButton19.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton19.setForeground(new java.awt.Color(188, 0, 200));
        jRadioButton19.setText("Approved");
        jRadioButton19.setToolTipText("Approved by the Department Head and waiting for the Registrar to close it.");
        jRadioButton19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton19.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton19.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton19.setFocusable(false);
        jRadioButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton19.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton30MouseClicked(evt);
            }
        });
        jRadioButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton19ActionPerformed(evt);
            }
        });

        jRadioButton20.setBackground(new java.awt.Color(203, 184, 160));
        q1StatusGroup.add(jRadioButton20);
        jRadioButton20.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton20.setForeground(new java.awt.Color(204, 0, 0));
        jRadioButton20.setText("Closed");
        jRadioButton20.setToolTipText("Closed by the Registrar and means it has been finalized.");
        jRadioButton20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton20.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton20.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton20.setFocusable(false);
        jRadioButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton20.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton30MouseClicked(evt);
            }
        });
        jRadioButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton20ActionPerformed(evt);
            }
        });

        lbStatusOptions2.setForeground(new java.awt.Color(1, 1, 1));
        lbStatusOptions2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbStatusOptions2.setText("1st Semester - 2nd Quarter Status");

        jRadioButton21.setBackground(new java.awt.Color(203, 184, 160));
        q2StatusGroup.add(jRadioButton21);
        jRadioButton21.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton21.setForeground(new java.awt.Color(0, 102, 0));
        jRadioButton21.setText("Open");
        jRadioButton21.setToolTipText("The subject teacher can edit the grades.");
        jRadioButton21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton21.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton21.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton21.setFocusable(false);
        jRadioButton21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton21.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton30MouseClicked(evt);
            }
        });

        jRadioButton22.setBackground(new java.awt.Color(203, 184, 160));
        q2StatusGroup.add(jRadioButton22);
        jRadioButton22.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton22.setForeground(new java.awt.Color(0, 0, 153));
        jRadioButton22.setSelected(true);
        jRadioButton22.setText("Submitted");
        jRadioButton22.setToolTipText("Once submitted, subject teachers can't edit the grade anymore and should wait for the Approval of the Department Head");
        jRadioButton22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton22.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton22.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton22.setFocusable(false);
        jRadioButton22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton22.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton30MouseClicked(evt);
            }
        });

        jRadioButton23.setBackground(new java.awt.Color(203, 184, 160));
        q2StatusGroup.add(jRadioButton23);
        jRadioButton23.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton23.setForeground(new java.awt.Color(188, 0, 200));
        jRadioButton23.setText("Approved");
        jRadioButton23.setToolTipText("Approved by the Department Head and waiting for the Registrar to close it.");
        jRadioButton23.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton23.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton23.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton23.setFocusable(false);
        jRadioButton23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton23.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton30MouseClicked(evt);
            }
        });

        jRadioButton24.setBackground(new java.awt.Color(203, 184, 160));
        q2StatusGroup.add(jRadioButton24);
        jRadioButton24.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton24.setForeground(new java.awt.Color(204, 0, 0));
        jRadioButton24.setText("Closed");
        jRadioButton24.setToolTipText("Closed by the Registrar and means it has been finalized.");
        jRadioButton24.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton24.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton24.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton24.setFocusable(false);
        jRadioButton24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton24.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton30MouseClicked(evt);
            }
        });
        jRadioButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton24ActionPerformed(evt);
            }
        });

        lbStatusOptions3.setForeground(new java.awt.Color(1, 1, 1));
        lbStatusOptions3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbStatusOptions3.setText("2nd Semester - 1st Quarter Status");

        jRadioButton25.setBackground(new java.awt.Color(203, 184, 160));
        q3tatusGroup.add(jRadioButton25);
        jRadioButton25.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton25.setForeground(new java.awt.Color(0, 102, 0));
        jRadioButton25.setText("Open");
        jRadioButton25.setToolTipText("The subject teacher can edit the grades.");
        jRadioButton25.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton25.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton25.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton25.setFocusable(false);
        jRadioButton25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton25.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton30MouseClicked(evt);
            }
        });

        jRadioButton26.setBackground(new java.awt.Color(203, 184, 160));
        q3tatusGroup.add(jRadioButton26);
        jRadioButton26.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton26.setForeground(new java.awt.Color(0, 0, 153));
        jRadioButton26.setText("Submitted");
        jRadioButton26.setToolTipText("Once submitted, subject teachers can't edit the grade anymore and should wait for the Approval of the Department Head");
        jRadioButton26.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton26.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton26.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton26.setFocusable(false);
        jRadioButton26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton26.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton30MouseClicked(evt);
            }
        });
        jRadioButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton26ActionPerformed(evt);
            }
        });

        jRadioButton27.setBackground(new java.awt.Color(203, 184, 160));
        q3tatusGroup.add(jRadioButton27);
        jRadioButton27.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton27.setForeground(new java.awt.Color(188, 0, 200));
        jRadioButton27.setText("Approved");
        jRadioButton27.setToolTipText("Approved by the Department Head and waiting for the Registrar to close it.");
        jRadioButton27.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton27.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton27.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton27.setFocusable(false);
        jRadioButton27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton27.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton30MouseClicked(evt);
            }
        });

        jRadioButton28.setBackground(new java.awt.Color(203, 184, 160));
        q3tatusGroup.add(jRadioButton28);
        jRadioButton28.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton28.setForeground(new java.awt.Color(204, 0, 0));
        jRadioButton28.setText("Closed");
        jRadioButton28.setToolTipText("Closed by the Registrar and means it has been finalized.");
        jRadioButton28.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton28.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton28.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton28.setFocusable(false);
        jRadioButton28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton28.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton30MouseClicked(evt);
            }
        });

        lbStatusOptions4.setForeground(new java.awt.Color(1, 1, 1));
        lbStatusOptions4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbStatusOptions4.setText("2nd Semester - 2nd Quarter Status");

        jRadioButton29.setBackground(new java.awt.Color(203, 184, 160));
        q4StatusGroup.add(jRadioButton29);
        jRadioButton29.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton29.setForeground(new java.awt.Color(0, 102, 0));
        jRadioButton29.setText("Open");
        jRadioButton29.setToolTipText("The subject teacher can edit the grades.");
        jRadioButton29.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton29.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton29.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton29.setFocusable(false);
        jRadioButton29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton29.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton30MouseClicked(evt);
            }
        });

        jRadioButton30.setBackground(new java.awt.Color(203, 184, 160));
        q4StatusGroup.add(jRadioButton30);
        jRadioButton30.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton30.setForeground(new java.awt.Color(0, 0, 153));
        jRadioButton30.setSelected(true);
        jRadioButton30.setText("Submitted");
        jRadioButton30.setToolTipText("Once submitted, subject teachers can't edit the grade anymore and should wait for the Approval of the Department Head");
        jRadioButton30.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton30.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton30.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton30.setFocusable(false);
        jRadioButton30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton30.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton30MouseClicked(evt);
            }
        });

        jRadioButton31.setBackground(new java.awt.Color(203, 184, 160));
        q4StatusGroup.add(jRadioButton31);
        jRadioButton31.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton31.setForeground(new java.awt.Color(188, 0, 200));
        jRadioButton31.setText("Approved");
        jRadioButton31.setToolTipText("Approved by the Department Head and waiting for the Registrar to close it.");
        jRadioButton31.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton31.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton31.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton31.setFocusable(false);
        jRadioButton31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton31.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton30MouseClicked(evt);
            }
        });

        jRadioButton32.setBackground(new java.awt.Color(203, 184, 160));
        q4StatusGroup.add(jRadioButton32);
        jRadioButton32.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton32.setForeground(new java.awt.Color(204, 0, 0));
        jRadioButton32.setText("Closed");
        jRadioButton32.setToolTipText("Closed by the Registrar and means it has been finalized.");
        jRadioButton32.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton32.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton32.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton32.setFocusable(false);
        jRadioButton32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton32.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton30MouseClicked(evt);
            }
        });
        jRadioButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton32ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jRadioButton29)
                .addGap(18, 34, Short.MAX_VALUE)
                .addComponent(jRadioButton30)
                .addGap(18, 34, Short.MAX_VALUE)
                .addComponent(jRadioButton31)
                .addGap(18, 34, Short.MAX_VALUE)
                .addComponent(jRadioButton32))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jRadioButton17)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jRadioButton18)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jRadioButton19)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jRadioButton20))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jRadioButton21)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jRadioButton22)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jRadioButton23)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jRadioButton24))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jRadioButton25)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jRadioButton26)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jRadioButton27)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jRadioButton28))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(lbStatusOptions3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbStatusOptions4, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbStatusOptions1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbStatusOptions2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbStatusOptions1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton17)
                    .addComponent(jRadioButton18)
                    .addComponent(jRadioButton19)
                    .addComponent(jRadioButton20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbStatusOptions2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton21)
                    .addComponent(jRadioButton22)
                    .addComponent(jRadioButton23)
                    .addComponent(jRadioButton24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbStatusOptions3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton25)
                    .addComponent(jRadioButton26)
                    .addComponent(jRadioButton27)
                    .addComponent(jRadioButton28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbStatusOptions4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton29)
                    .addComponent(jRadioButton30)
                    .addComponent(jRadioButton31)
                    .addComponent(jRadioButton32))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel38)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbSectionName2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbSubjectName2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel18)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel22)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbEvaluation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(28, 28, 28)
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnSaveChangesCurrent)))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(lbSectionName2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(lbSubjectName2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(lbEvaluation)))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(btnSaveChangesCurrent)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Main Details", jPanel2);

        jPanel3.setBackground(new java.awt.Color(203, 184, 160));
        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel24.setForeground(new java.awt.Color(1, 1, 1));
        jLabel24.setText("Department Head Controls");

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(1, 1, 1));
        jLabel39.setText("Global Approval Controls");

        btnDphSelected.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_to_do_16px.png"))); // NOI18N
        btnDphSelected.setText("Approve Selected");
        btnDphSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDphSelectedActionPerformed(evt);
            }
        });

        btnDphAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_check_all_16px.png"))); // NOI18N
        btnDphAll.setText("Approve All");
        btnDphAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDphAllActionPerformed(evt);
            }
        });

        jLabel25.setForeground(new java.awt.Color(1, 1, 1));
        jLabel25.setText("Registrar Controls");

        btnRgrSelected.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_to_do_16px.png"))); // NOI18N
        btnRgrSelected.setText("Close Selected");
        btnRgrSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRgrSelectedActionPerformed(evt);
            }
        });

        btnRgrAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_check_all_16px.png"))); // NOI18N
        btnRgrAll.setText("Close All");
        btnRgrAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRgrAllActionPerformed(evt);
            }
        });

        jLabel26.setForeground(new java.awt.Color(1, 1, 1));
        jLabel26.setText("Subject Teacher Controls");

        btnAdvSelected.setForeground(new java.awt.Color(1, 1, 1));
        btnAdvSelected.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_to_do_16px.png"))); // NOI18N
        btnAdvSelected.setText("Submit Selected");
        btnAdvSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdvSelectedActionPerformed(evt);
            }
        });

        btnAdvAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_check_all_16px.png"))); // NOI18N
        btnAdvAll.setText("Submit All");
        btnAdvAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdvAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdvAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDphSelected, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                            .addComponent(btnDphAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAdvSelected, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnRgrAll, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnRgrSelected, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel39)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdvSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRgrSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdvAll, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRgrAll, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDphSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDphAll, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Approval Controls", jPanel3);

        javax.swing.GroupLayout left2Layout = new javax.swing.GroupLayout(left2);
        left2.setLayout(left2Layout);
        left2Layout.setHorizontalGroup(
            left2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
        );
        left2Layout.setVerticalGroup(
            left2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
        );

        jSplitPane2.setTopComponent(left2);

        right2.setBackground(new java.awt.Color(249, 239, 227));

        enrolledStudentsTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Student ID", "LRN", "Name", "Gender", "Section ID", "Grade ID", "S1-Q1", "S1-Q2", "S2-Q1", "S2-Q2", "General Average", "Status", "Date Updated"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        enrolledStudentsTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        enrolledStudentsTable1.getTableHeader().setReorderingAllowed(false);
        enrolledStudentsTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                enrolledStudentsTable1MouseClicked(evt);
            }
        });
        enrolledStudentsTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                enrolledStudentsTable1KeyReleased(evt);
            }
        });
        jScrollPane5.setViewportView(enrolledStudentsTable1);
        if (enrolledStudentsTable1.getColumnModel().getColumnCount() > 0) {
            enrolledStudentsTable1.getColumnModel().getColumn(2).setPreferredWidth(150);
            enrolledStudentsTable1.getColumnModel().getColumn(3).setPreferredWidth(200);
            enrolledStudentsTable1.getColumnModel().getColumn(4).setPreferredWidth(100);
            enrolledStudentsTable1.getColumnModel().getColumn(11).setPreferredWidth(120);
            enrolledStudentsTable1.getColumnModel().getColumn(12).setPreferredWidth(250);
            enrolledStudentsTable1.getColumnModel().getColumn(13).setPreferredWidth(200);
        }

        lbMessage.setForeground(new java.awt.Color(1, 1, 1));
        lbMessage.setText("Progress Here");

        btnRefreshStudents.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_sync_16px.png"))); // NOI18N
        btnRefreshStudents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshStudentsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout right2Layout = new javax.swing.GroupLayout(right2);
        right2.setLayout(right2Layout);
        right2Layout.setHorizontalGroup(
            right2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(right2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(right2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addGroup(right2Layout.createSequentialGroup()
                        .addGroup(right2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pbProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRefreshStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        right2Layout.setVerticalGroup(
            right2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, right2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(right2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(right2Layout.createSequentialGroup()
                        .addComponent(lbMessage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pbProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnRefreshStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane2.setRightComponent(right2);

        javax.swing.GroupLayout viewStudentsTab2Layout = new javax.swing.GroupLayout(viewStudentsTab2);
        viewStudentsTab2.setLayout(viewStudentsTab2Layout);
        viewStudentsTab2Layout.setHorizontalGroup(
            viewStudentsTab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
        );
        viewStudentsTab2Layout.setVerticalGroup(
            viewStudentsTab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
        );

        jSplitPane1.setBorder(null);
        jSplitPane1.setDividerLocation(600);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        left.setBackground(new java.awt.Color(203, 184, 160));

        lbSearchResult1.setForeground(new java.awt.Color(1, 1, 1));
        lbSearchResult1.setText("Search using the search bar...");

        tfSearchEnrolledStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSearchEnrolledStudentsearchEnrolledStudentsHandler(evt);
            }
        });

        btnSearchEnrolledStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/search_24px.png"))); // NOI18N
        btnSearchEnrolledStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchEnrolledStudentsearchEnrolledStudentsHandler(evt);
            }
        });

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

        javax.swing.GroupLayout leftLayout = new javax.swing.GroupLayout(left);
        left.setLayout(leftLayout);
        leftLayout.setHorizontalGroup(
            leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(leftLayout.createSequentialGroup()
                        .addComponent(lbSearchResult1, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
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
                    .addComponent(tfSearchEnrolledStudent, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane1.setLeftComponent(left);

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

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Grade Details");

        btnEditGrades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_edit_16px.png"))); // NOI18N
        btnEditGrades.setText("Edit Grades");
        btnEditGrades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditGradesActionPerformed(evt);
            }
        });

        lbDateUpdated.setText("Date Updated: YYYY-MM-DD HH:MM:SS");

        lbGradeStatus.setText("SUBMISSION_STATUS");

        jLabel5.setText("1st Semester - 1st Quarter");

        tfFirstQ.setEditable(false);
        tfFirstQ.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfFirstQ.setText("90");

        jLabel6.setText("1st Semester - 2nd Quarter");

        tfSecondQ.setEditable(false);
        tfSecondQ.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfSecondQ.setText("90");

        jLabel7.setText("2nd Semester - 1st Quarter");

        tfThirdQ.setEditable(false);
        tfThirdQ.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfThirdQ.setText("90");

        jLabel8.setText("2nd Semester - 2nd Quarter");

        tfFourthQ.setEditable(false);
        tfFourthQ.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfFourthQ.setText("90");

        jLabel9.setText("General Weighed Average");

        tfGeneralWeighedAverage.setEditable(false);
        tfGeneralWeighedAverage.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfGeneralWeighedAverage.setText("90");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Basic Info");

        lbSubjectName.setText("Subject Name: SUBJECT_NAME");

        jLabel15.setText("Record ID:");

        lbRecordId.setText("RECORD_ID");

        jLabel16.setText("Status :");

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
                    .addComponent(btnEditGrades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbDateUpdated, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbSubjectName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbRecordId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(tfFirstQ, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(tfSecondQ, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel7)
                            .addComponent(tfThirdQ, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(tfFourthQ, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfGeneralWeighedAverage, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbGradeStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(lbRecordId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbSubjectName)
                .addGap(10, 10, 10)
                .addComponent(lbDateUpdated)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbGradeStatus)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfFirstQ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfSecondQ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfThirdQ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfFourthQ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfGeneralWeighedAverage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEditGrades)
                .addContainerGap(123, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout rightLayout = new javax.swing.GroupLayout(right);
        right.setLayout(rightLayout);
        rightLayout.setHorizontalGroup(
            rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        rightLayout.setVerticalGroup(
            rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
        );

        jSplitPane1.setRightComponent(right);

        javax.swing.GroupLayout viewStudentsTabLayout = new javax.swing.GroupLayout(viewStudentsTab);
        viewStudentsTab.setLayout(viewStudentsTabLayout);
        viewStudentsTabLayout.setHorizontalGroup(
            viewStudentsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
        viewStudentsTabLayout.setVerticalGroup(
            viewStudentsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );

        selectQuarterDialog.setBackground(new java.awt.Color(249, 239, 227));

        lbQuarterSelect.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbQuarterSelect.setText("Select Quarter:");

        btnSelectQuarter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_16px.png"))); // NOI18N
        btnSelectQuarter.setText("OK");
        btnSelectQuarter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectQuarterActionPerformed(evt);
            }
        });

        rbQuarter1.setBackground(new java.awt.Color(249, 239, 227));
        selectQuarterGroup.add(rbQuarter1);
        rbQuarter1.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        rbQuarter1.setSelected(true);
        rbQuarter1.setText("1st Semester - 1st Quarter");
        rbQuarter1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbQuarter1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        rbQuarter1.setIconTextGap(10);
        rbQuarter1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        rbQuarter1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbQuarter1cbAllowDecimalValuesMouseClicked(evt);
            }
        });
        rbQuarter1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbQuarter1ActionPerformed(evt);
            }
        });

        rbQuarter2.setBackground(new java.awt.Color(249, 239, 227));
        selectQuarterGroup.add(rbQuarter2);
        rbQuarter2.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        rbQuarter2.setText("1st Semester - 2nd Quarter");
        rbQuarter2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbQuarter2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        rbQuarter2.setIconTextGap(10);
        rbQuarter2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        rbQuarter2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbQuarter2cbAllowDecimalValuesMouseClicked(evt);
            }
        });

        rbQuarter3.setBackground(new java.awt.Color(249, 239, 227));
        selectQuarterGroup.add(rbQuarter3);
        rbQuarter3.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        rbQuarter3.setText("2nd Semester - 1st Quarter");
        rbQuarter3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbQuarter3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        rbQuarter3.setIconTextGap(10);
        rbQuarter3.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        rbQuarter3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbQuarter3cbAllowDecimalValuesMouseClicked(evt);
            }
        });

        rbQuarter4.setBackground(new java.awt.Color(249, 239, 227));
        selectQuarterGroup.add(rbQuarter4);
        rbQuarter4.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        rbQuarter4.setText("2nd Semester - 2nd Quarter");
        rbQuarter4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbQuarter4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        rbQuarter4.setIconTextGap(10);
        rbQuarter4.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        rbQuarter4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbQuarter4cbAllowDecimalValuesMouseClicked(evt);
            }
        });

        rbAllQuarters.setBackground(new java.awt.Color(249, 239, 227));
        selectQuarterGroup.add(rbAllQuarters);
        rbAllQuarters.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        rbAllQuarters.setText("All Quarters");
        rbAllQuarters.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbAllQuarters.setEnabled(false);
        rbAllQuarters.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        rbAllQuarters.setIconTextGap(10);
        rbAllQuarters.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        rbAllQuarters.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbAllQuarterscbAllowDecimalValuesMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout selectQuarterDialogLayout = new javax.swing.GroupLayout(selectQuarterDialog);
        selectQuarterDialog.setLayout(selectQuarterDialogLayout);
        selectQuarterDialogLayout.setHorizontalGroup(
            selectQuarterDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(selectQuarterDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(selectQuarterDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbQuarterSelect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, selectQuarterDialogLayout.createSequentialGroup()
                        .addGroup(selectQuarterDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rbAllQuarters, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rbQuarter4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rbQuarter3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rbQuarter2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rbQuarter1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSelectQuarter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        selectQuarterDialogLayout.setVerticalGroup(
            selectQuarterDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(selectQuarterDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbQuarterSelect)
                .addGap(18, 18, 18)
                .addComponent(rbQuarter1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbQuarter2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbQuarter3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbQuarter4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbAllQuarters)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSelectQuarter)
                .addContainerGap())
        );

        jScrollPane3.setBorder(null);
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        contentsPanel.setBackground(new java.awt.Color(249, 239, 227));

        jPanel8.setBackground(new java.awt.Color(203, 184, 160));

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Edit Grades");

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

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("1st Semester - 1st Quarter");

        tfEditFirstQuarter.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfEditFirstQuarter.setText("90");
        tfEditFirstQuarter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                calculateGwaOnKeyReleaseHandler(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("1st Semester - 2nd Quarter");

        tfEditSecondQuarter.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfEditSecondQuarter.setText("90");
        tfEditSecondQuarter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                calculateGwaOnKeyReleaseHandler(evt);
            }
        });

        tfEditThirdQuarter.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfEditThirdQuarter.setText("90");
        tfEditThirdQuarter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                calculateGwaOnKeyReleaseHandler(evt);
            }
        });

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("2nd Semester - 1st Quarter");

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("2nd Semester - 2nd Quarter");

        tfEditFourthQuarter.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfEditFourthQuarter.setText("90");
        tfEditFourthQuarter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                calculateGwaOnKeyReleaseHandler(evt);
            }
        });

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Grade Details");

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Computation Options");

        computationOptionGroup.add(rbAutomatic);
        rbAutomatic.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        rbAutomatic.setText("Automatic");
        rbAutomatic.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbAutomatic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        rbAutomatic.setIconTextGap(10);
        rbAutomatic.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        rbAutomatic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbAllowDecimalValuesMouseClicked(evt);
            }
        });

        computationOptionGroup.add(rbManual);
        rbManual.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        rbManual.setText("Manual");
        rbManual.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbManual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        rbManual.setIconTextGap(10);
        rbManual.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        rbManual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbAllowDecimalValuesMouseClicked(evt);
            }
        });

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("General Weighed Average (GWA)");

        tfEditGwa.setEditable(false);
        tfEditGwa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfEditGwa.setText("90");
        tfEditGwa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEditGwaActionPerformed(evt);
            }
        });

        btnSaveGradeChanges.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_save_16px.png"))); // NOI18N
        btnSaveGradeChanges.setText("Save Changes");
        btnSaveGradeChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveGradeChangesActionPerformed(evt);
            }
        });

        cbAllowDecimalValues.setFont(myVariables.TEXTFIELD_FONT);
        cbAllowDecimalValues.setText("Allow decimal values?");
        cbAllowDecimalValues.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbAllowDecimalValues.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_checkbox_20px.png"))); // NOI18N
        cbAllowDecimalValues.setIconTextGap(10);
        cbAllowDecimalValues.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_checkbox_20px.png"))); // NOI18N
        cbAllowDecimalValues.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_checked_checkbox_20px.png"))); // NOI18N
        cbAllowDecimalValues.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbAllowDecimalValuesMouseClicked(evt);
            }
        });

        lbStatusOptions.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbStatusOptions.setText("Status Options");

        jRadioButton1.setBackground(new java.awt.Color(255, 255, 255));
        q1StatusGroup.add(jRadioButton1);
        jRadioButton1.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton1.setForeground(new java.awt.Color(0, 102, 0));
        jRadioButton1.setText("Open");
        jRadioButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton1.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton1.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton1.setFocusable(false);
        jRadioButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N

        jRadioButton2.setBackground(new java.awt.Color(255, 255, 255));
        q1StatusGroup.add(jRadioButton2);
        jRadioButton2.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton2.setForeground(new java.awt.Color(0, 0, 153));
        jRadioButton2.setText("Submitted");
        jRadioButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton2.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton2.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton2.setFocusable(false);
        jRadioButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N

        jRadioButton3.setBackground(new java.awt.Color(255, 255, 255));
        q1StatusGroup.add(jRadioButton3);
        jRadioButton3.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton3.setForeground(new java.awt.Color(188, 0, 200));
        jRadioButton3.setText("Approved");
        jRadioButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton3.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton3.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton3.setFocusable(false);
        jRadioButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton3.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N

        jRadioButton4.setBackground(new java.awt.Color(255, 255, 255));
        q1StatusGroup.add(jRadioButton4);
        jRadioButton4.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton4.setForeground(new java.awt.Color(204, 0, 0));
        jRadioButton4.setText("Closed");
        jRadioButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton4.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton4.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton4.setFocusable(false);
        jRadioButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton4.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N

        jRadioButton5.setBackground(new java.awt.Color(255, 255, 255));
        q2StatusGroup.add(jRadioButton5);
        jRadioButton5.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton5.setForeground(new java.awt.Color(0, 102, 0));
        jRadioButton5.setText("Open");
        jRadioButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton5.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton5.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton5.setFocusable(false);
        jRadioButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton5.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N

        jRadioButton6.setBackground(new java.awt.Color(255, 255, 255));
        q2StatusGroup.add(jRadioButton6);
        jRadioButton6.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton6.setForeground(new java.awt.Color(0, 0, 153));
        jRadioButton6.setText("Submitted");
        jRadioButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton6.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton6.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton6.setFocusable(false);
        jRadioButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton6.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N

        jRadioButton7.setBackground(new java.awt.Color(255, 255, 255));
        q2StatusGroup.add(jRadioButton7);
        jRadioButton7.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton7.setForeground(new java.awt.Color(188, 0, 200));
        jRadioButton7.setText("Approved");
        jRadioButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton7.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton7.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton7.setFocusable(false);
        jRadioButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton7.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N

        jRadioButton8.setBackground(new java.awt.Color(255, 255, 255));
        q2StatusGroup.add(jRadioButton8);
        jRadioButton8.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton8.setForeground(new java.awt.Color(204, 0, 0));
        jRadioButton8.setText("Closed");
        jRadioButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton8.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton8.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton8.setFocusable(false);
        jRadioButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton8.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N

        jRadioButton9.setBackground(new java.awt.Color(255, 255, 255));
        q3tatusGroup.add(jRadioButton9);
        jRadioButton9.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton9.setForeground(new java.awt.Color(0, 102, 0));
        jRadioButton9.setText("Open");
        jRadioButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton9.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton9.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton9.setFocusable(false);
        jRadioButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton9.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N

        jRadioButton10.setBackground(new java.awt.Color(255, 255, 255));
        q3tatusGroup.add(jRadioButton10);
        jRadioButton10.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton10.setForeground(new java.awt.Color(0, 0, 153));
        jRadioButton10.setText("Submitted");
        jRadioButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton10.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton10.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton10.setFocusable(false);
        jRadioButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton10.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N

        jRadioButton11.setBackground(new java.awt.Color(255, 255, 255));
        q3tatusGroup.add(jRadioButton11);
        jRadioButton11.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton11.setForeground(new java.awt.Color(188, 0, 200));
        jRadioButton11.setText("Approved");
        jRadioButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton11.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton11.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton11.setFocusable(false);
        jRadioButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton11.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N

        jRadioButton12.setBackground(new java.awt.Color(255, 255, 255));
        q3tatusGroup.add(jRadioButton12);
        jRadioButton12.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton12.setForeground(new java.awt.Color(204, 0, 0));
        jRadioButton12.setText("Closed");
        jRadioButton12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton12.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton12.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton12.setFocusable(false);
        jRadioButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton12.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N

        jRadioButton13.setBackground(new java.awt.Color(255, 255, 255));
        q4StatusGroup.add(jRadioButton13);
        jRadioButton13.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton13.setForeground(new java.awt.Color(0, 102, 0));
        jRadioButton13.setText("Open");
        jRadioButton13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton13.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton13.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton13.setFocusable(false);
        jRadioButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton13.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N

        jRadioButton14.setBackground(new java.awt.Color(255, 255, 255));
        q4StatusGroup.add(jRadioButton14);
        jRadioButton14.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton14.setForeground(new java.awt.Color(0, 0, 153));
        jRadioButton14.setText("Submitted");
        jRadioButton14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton14.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton14.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton14.setFocusable(false);
        jRadioButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton14.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N

        jRadioButton15.setBackground(new java.awt.Color(255, 255, 255));
        q4StatusGroup.add(jRadioButton15);
        jRadioButton15.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton15.setForeground(new java.awt.Color(188, 0, 200));
        jRadioButton15.setText("Approved");
        jRadioButton15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton15.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton15.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton15.setFocusable(false);
        jRadioButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton15.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N

        jRadioButton16.setBackground(new java.awt.Color(255, 255, 255));
        q4StatusGroup.add(jRadioButton16);
        jRadioButton16.setFont(myVariables.TEXTFIELD_HEADER_FONT);
        jRadioButton16.setForeground(new java.awt.Color(204, 0, 0));
        jRadioButton16.setText("Closed");
        jRadioButton16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton16.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_unchecked_radio_button_20px.png"))); // NOI18N
        jRadioButton16.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N
        jRadioButton16.setFocusable(false);
        jRadioButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_round_20px.png"))); // NOI18N
        jRadioButton16.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_ok_20px.png"))); // NOI18N

        tfEvaluation.setEditable(false);
        tfEvaluation.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfEvaluation.setText("90");
        tfEvaluation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEvaluationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contentsPanelLayout = new javax.swing.GroupLayout(contentsPanel);
        contentsPanel.setLayout(contentsPanelLayout);
        contentsPanelLayout.setHorizontalGroup(
            contentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentsPanelLayout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSaveGradeChanges, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbAutomatic, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbManual, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(contentsPanelLayout.createSequentialGroup()
                        .addGroup(contentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfEditFirstQuarter, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(contentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(contentsPanelLayout.createSequentialGroup()
                                .addComponent(jRadioButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton4))
                            .addComponent(lbStatusOptions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, contentsPanelLayout.createSequentialGroup()
                        .addGroup(contentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfEditSecondQuarter, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jRadioButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton8))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, contentsPanelLayout.createSequentialGroup()
                        .addGroup(contentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfEditThirdQuarter, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jRadioButton9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton12))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, contentsPanelLayout.createSequentialGroup()
                        .addComponent(cbAllowDecimalValues)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfEditGwa, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfEvaluation, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, contentsPanelLayout.createSequentialGroup()
                        .addGroup(contentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfEditFourthQuarter, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jRadioButton13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton16)))
                .addContainerGap())
        );
        contentsPanelLayout.setVerticalGroup(
            contentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addGap(17, 17, 17)
                .addGroup(contentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbStatusOptions))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfEditFirstQuarter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfEditSecondQuarter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton5)
                    .addComponent(jRadioButton6)
                    .addComponent(jRadioButton7)
                    .addComponent(jRadioButton8))
                .addGap(8, 8, 8)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfEditThirdQuarter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton9)
                    .addComponent(jRadioButton10)
                    .addComponent(jRadioButton11)
                    .addComponent(jRadioButton12))
                .addGap(8, 8, 8)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfEditFourthQuarter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton13)
                    .addComponent(jRadioButton14)
                    .addComponent(jRadioButton15)
                    .addComponent(jRadioButton16))
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbAutomatic)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbManual)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(contentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfEditGwa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbAllowDecimalValues)
                    .addComponent(tfEvaluation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSaveGradeChanges)
                .addContainerGap())
        );

        jScrollPane3.setViewportView(contentsPanel);

        javax.swing.GroupLayout editGradeDialogLayout = new javax.swing.GroupLayout(editGradeDialog);
        editGradeDialog.setLayout(editGradeDialogLayout);
        editGradeDialogLayout.setHorizontalGroup(
            editGradeDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
        );
        editGradeDialogLayout.setVerticalGroup(
            editGradeDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Grading System Dashboard");
        setIconImage(my.getImgIcn(myVariables.getGradingWindowIcon()).getImage()
        );
        setMinimumSize(new java.awt.Dimension(1303, 782));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        kGradientPanel1.setkEndColor(new java.awt.Color(249, 239, 227));
        kGradientPanel1.setkStartColor(new java.awt.Color(249, 239, 227));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(1003, 600));

        headerPanel.setBackground(new java.awt.Color(251, 185, 211));
        headerPanel.setPreferredSize(new java.awt.Dimension(270, 723));

        btnManageGrades.setForeground(new java.awt.Color(58, 57, 57));
        btnManageGrades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/folder.png"))); // NOI18N
        btnManageGrades.setText("   Manage Grades      ");
        btnManageGrades.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnManageGrades.setMaximumSize(new java.awt.Dimension(165, 49));
        btnManageGrades.setMinimumSize(new java.awt.Dimension(165, 49));
        btnManageGrades.setPreferredSize(new java.awt.Dimension(165, 49));
        btnManageGrades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageGradesActionPerformed(evt);
            }
        });

        btnMyManagedSubjects.setForeground(new java.awt.Color(58, 57, 57));
        btnMyManagedSubjects.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/subject.png"))); // NOI18N
        btnMyManagedSubjects.setText("  My Assigned Subjects");
        btnMyManagedSubjects.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnMyManagedSubjects.setMaximumSize(new java.awt.Dimension(165, 49));
        btnMyManagedSubjects.setMinimumSize(new java.awt.Dimension(171, 49));
        btnMyManagedSubjects.setPreferredSize(new java.awt.Dimension(171, 49));
        btnMyManagedSubjects.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMyManagedSubjectsActionPerformed(evt);
            }
        });

        btnImportFromSf10.setForeground(new java.awt.Color(58, 57, 57));
        btnImportFromSf10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/import.png"))); // NOI18N
        btnImportFromSf10.setText("     Import Grades       ");
        btnImportFromSf10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnImportFromSf10.setMaximumSize(new java.awt.Dimension(165, 49));
        btnImportFromSf10.setMinimumSize(new java.awt.Dimension(165, 49));
        btnImportFromSf10.setPreferredSize(new java.awt.Dimension(165, 49));
        btnImportFromSf10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportFromSf10ActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Poppins SemiBold", 0, 19)); // NOI18N
        jLabel28.setText("GRADING SYSTEM");

        jLabel30.setFont(new java.awt.Font("Poppins SemiBold", 0, 48)); // NOI18N
        jLabel30.setText("SHS");

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/cbshs.png"))); // NOI18N

        lbLoggedInUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbLoggedInUser.setForeground(new java.awt.Color(58, 57, 57));
        lbLoggedInUser.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbLoggedInUser.setText("USER_NAME");

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(58, 57, 57));
        jLabel32.setText("Welcome!");

        lbLoggedInUser1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbLoggedInUser1.setForeground(new java.awt.Color(58, 57, 57));
        lbLoggedInUser1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbLoggedInUser1.setText("ACCESS_LEVEL");

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnMyManagedSubjects, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnImportFromSf10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addComponent(btnManageGrades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerPanelLayout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31)
                            .addComponent(jLabel30)))
                    .addGroup(headerPanelLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel28))
                    .addGroup(headerPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLoggedInUser1)
                            .addComponent(jLabel32)
                            .addComponent(lbLoggedInUser))))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel30)
                .addGap(1, 1, 1)
                .addComponent(jLabel28)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnManageGrades, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMyManagedSubjects, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnImportFromSf10, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbLoggedInUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbLoggedInUser1)
                .addGap(20, 20, 20))
        );

        //naka white spaces ra para ma center hehe

        contentPanel.setPreferredSize(new java.awt.Dimension(1068, 548));

        cards.setLayout(new java.awt.CardLayout());

        card1.setBackground(new java.awt.Color(249, 239, 227));
        card1.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));

        mainTab.setBackground(new java.awt.Color(249, 239, 227));
        mainTab.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        mainTab.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        mainTab.setToolTipText("");
        mainTab.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        mainTab.setMinimumSize(new java.awt.Dimension(100, 100));
        mainTab.setPreferredSize(new java.awt.Dimension(1068, 548));

        javax.swing.GroupLayout card1Layout = new javax.swing.GroupLayout(card1);
        card1.setLayout(card1Layout);
        card1Layout.setHorizontalGroup(
            card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainTab, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 987, Short.MAX_VALUE)
        );
        card1Layout.setVerticalGroup(
            card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainTab, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );

        cards.add(card1, "card2");

        myAssignedSubjectsDialog.setBackground(new java.awt.Color(249, 239, 227));
        myAssignedSubjectsDialog.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));

        assignedSubjectsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Subject Code", "Description", "Grade Level"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        assignedSubjectsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(assignedSubjectsTable);
        if (assignedSubjectsTable.getColumnModel().getColumnCount() > 0) {
            assignedSubjectsTable.getColumnModel().getColumn(1).setPreferredWidth(100);
            assignedSubjectsTable.getColumnModel().getColumn(1).setMaxWidth(100);
            assignedSubjectsTable.getColumnModel().getColumn(3).setPreferredWidth(100);
            assignedSubjectsTable.getColumnModel().getColumn(3).setMaxWidth(100);
        }

        jLabel17.setForeground(new java.awt.Color(1, 1, 1));
        jLabel17.setText("These subjects above are given to you by Curriculum Head users.");

        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8_sync_16px.png"))); // NOI18N
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(1, 1, 1));
        jLabel37.setText("Assigned Subjects");

        javax.swing.GroupLayout myAssignedSubjectsDialogLayout = new javax.swing.GroupLayout(myAssignedSubjectsDialog);
        myAssignedSubjectsDialog.setLayout(myAssignedSubjectsDialogLayout);
        myAssignedSubjectsDialogLayout.setHorizontalGroup(
            myAssignedSubjectsDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myAssignedSubjectsDialogLayout.createSequentialGroup()
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane4)
            .addGroup(myAssignedSubjectsDialogLayout.createSequentialGroup()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 530, Short.MAX_VALUE))
        );
        myAssignedSubjectsDialogLayout.setVerticalGroup(
            myAssignedSubjectsDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myAssignedSubjectsDialogLayout.createSequentialGroup()
                .addGroup(myAssignedSubjectsDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout card2Layout = new javax.swing.GroupLayout(card2);
        card2.setLayout(card2Layout);
        card2Layout.setHorizontalGroup(
            card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(myAssignedSubjectsDialog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        card2Layout.setVerticalGroup(
            card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(myAssignedSubjectsDialog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        cards.add(card2, "card3");

        importDialog.setBackground(new java.awt.Color(249, 239, 227));
        importDialog.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));

        jtbImportTabs.setBackground(new java.awt.Color(255, 255, 204));

        selectStudentTab.setBackground(new java.awt.Color(203, 184, 160));

        studentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID (H)", "LRN", "Last Name", "First Name", "Middle Name", "Gender", "Initial Gen. Ave.", "Current Gr. Lvl"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        studentTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane9.setViewportView(studentTable);

        btnSearch.setText("Search");

        lbSearchResult2.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        lbSearchResult2.setText("Search using the search bar...");

        javax.swing.GroupLayout selectStudentTabLayout = new javax.swing.GroupLayout(selectStudentTab);
        selectStudentTab.setLayout(selectStudentTabLayout);
        selectStudentTabLayout.setHorizontalGroup(
            selectStudentTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, selectStudentTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(selectStudentTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane9)
                    .addGroup(selectStudentTabLayout.createSequentialGroup()
                        .addComponent(lbSearchResult2, javax.swing.GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfSearchStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        selectStudentTabLayout.setVerticalGroup(
            selectStudentTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(selectStudentTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(selectStudentTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfSearchStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch)
                    .addComponent(lbSearchResult2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
                .addContainerGap())
        );

        jtbImportTabs.addTab("Select Student", selectStudentTab);

        selectSf10Tab.setBackground(new java.awt.Color(203, 184, 160));

        jLabel95.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel95.setForeground(new java.awt.Color(1, 1, 1));
        jLabel95.setText("Select Excel File Format");

        jcbFileFormats.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "HiSRMS-SF10 JHS (Default)", "SF10 - 4.10.2012" }));

        tfFileLocation.setEditable(false);

        btnOpenFileExplorer.setText("Select File");
        btnOpenFileExplorer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenFileExplorerActionPerformed(evt);
            }
        });

        gradeDetailsTab.setBackground(new java.awt.Color(249, 239, 227));

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Scholastic Record");

        importedGradeDetailsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "School Name", "School ID", "District", "Division", "Region", "Classified As", "Section", "School Year", "Adviser"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        importedGradeDetailsTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        importedGradeDetailsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane10.setViewportView(importedGradeDetailsTable);
        if (importedGradeDetailsTable.getColumnModel().getColumnCount() > 0) {
            importedGradeDetailsTable.getColumnModel().getColumn(0).setPreferredWidth(300);
            importedGradeDetailsTable.getColumnModel().getColumn(1).setPreferredWidth(100);
            importedGradeDetailsTable.getColumnModel().getColumn(2).setPreferredWidth(200);
            importedGradeDetailsTable.getColumnModel().getColumn(3).setPreferredWidth(100);
            importedGradeDetailsTable.getColumnModel().getColumn(4).setPreferredWidth(50);
            importedGradeDetailsTable.getColumnModel().getColumn(5).setPreferredWidth(50);
            importedGradeDetailsTable.getColumnModel().getColumn(6).setPreferredWidth(80);
            importedGradeDetailsTable.getColumnModel().getColumn(7).setPreferredWidth(80);
            importedGradeDetailsTable.getColumnModel().getColumn(8).setPreferredWidth(100);
        }

        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Grades");

        importedGradesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Subject Name", "Q1", "Q2", "Q3", "Q4", "Final Rating", "Remarks"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        importedGradesTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane11.setViewportView(importedGradesTable);
        if (importedGradesTable.getColumnModel().getColumnCount() > 0) {
            importedGradesTable.getColumnModel().getColumn(0).setPreferredWidth(200);
            importedGradesTable.getColumnModel().getColumn(1).setPreferredWidth(50);
            importedGradesTable.getColumnModel().getColumn(2).setPreferredWidth(50);
            importedGradesTable.getColumnModel().getColumn(3).setPreferredWidth(50);
            importedGradesTable.getColumnModel().getColumn(4).setPreferredWidth(50);
            importedGradesTable.getColumnModel().getColumn(5).setPreferredWidth(80);
            importedGradesTable.getColumnModel().getColumn(6).setPreferredWidth(80);
        }

        lbImportedGeneralAverage.setForeground(new java.awt.Color(0, 102, 51));
        lbImportedGeneralAverage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbImportedGeneralAverage.setText("0.00");

        jLabel29.setText("General Average");

        javax.swing.GroupLayout gradeDetailsTabLayout = new javax.swing.GroupLayout(gradeDetailsTab);
        gradeDetailsTab.setLayout(gradeDetailsTabLayout);
        gradeDetailsTabLayout.setHorizontalGroup(
            gradeDetailsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradeDetailsTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gradeDetailsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 937, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane11)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gradeDetailsTabLayout.createSequentialGroup()
                        .addGap(0, 828, Short.MAX_VALUE)
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbImportedGeneralAverage)))
                .addContainerGap())
        );
        gradeDetailsTabLayout.setVerticalGroup(
            gradeDetailsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradeDetailsTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gradeDetailsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbImportedGeneralAverage)
                    .addComponent(jLabel29))
                .addContainerGap())
        );

        gradeTabs.addTab("[ SLOT 1]", gradeDetailsTab);

        jButton1.setText("Import");

        javax.swing.GroupLayout selectSf10TabLayout = new javax.swing.GroupLayout(selectSf10Tab);
        selectSf10Tab.setLayout(selectSf10TabLayout);
        selectSf10TabLayout.setHorizontalGroup(
            selectSf10TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(selectSf10TabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(selectSf10TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gradeTabs)
                    .addGroup(selectSf10TabLayout.createSequentialGroup()
                        .addComponent(jcbFileFormats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfFileLocation)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOpenFileExplorer))
                    .addGroup(selectSf10TabLayout.createSequentialGroup()
                        .addComponent(jLabel95)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, selectSf10TabLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        selectSf10TabLayout.setVerticalGroup(
            selectSf10TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(selectSf10TabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel95)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(selectSf10TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbFileFormats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfFileLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOpenFileExplorer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gradeTabs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        jtbImportTabs.addTab("Select File", selectSf10Tab);

        jLabel94.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(1, 1, 1));
        jLabel94.setText("Import From DepEd LIS");

        javax.swing.GroupLayout importDialogLayout = new javax.swing.GroupLayout(importDialog);
        importDialog.setLayout(importDialogLayout);
        importDialogLayout.setHorizontalGroup(
            importDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtbImportTabs)
            .addGroup(importDialogLayout.createSequentialGroup()
                .addComponent(jLabel94)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        importDialogLayout.setVerticalGroup(
            importDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(importDialogLayout.createSequentialGroup()
                .addComponent(jLabel94)
                .addGap(18, 18, 18)
                .addComponent(jtbImportTabs))
        );

        javax.swing.GroupLayout card3Layout = new javax.swing.GroupLayout(card3);
        card3.setLayout(card3Layout);
        card3Layout.setHorizontalGroup(
            card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(importDialog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        card3Layout.setVerticalGroup(
            card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(importDialog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        cards.add(card3, "card4");

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cards, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cards, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1027, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
            .addComponent(headerPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
        );

        jMenuBar1.setToolTipText("");
        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8-male-user_circle-20.png"))); // NOI18N

        logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage4/icons/icons8-logout-rounded-up-20.png"))); // NOI18N
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

    private void tfSearchTeacherLoadsearchManagedSections(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSearchTeacherLoadsearchManagedSections
        String toSearch = tfSearchTeacherLoad.getText();
        String schoolYear = jcbSchoolYear1.getSelectedItem().toString();

        my.remove_multiple_tabs(mainTab, new int [] {1,2});

        String where = "WHERE subjectCode NOT LIKE 'ADV%'";
        
        //Filter search based on Access Level
        switch (myVariables.getAccessLevel()){
            case 1:{    //Teacher or Subject Teacher
                where += " AND teacherId='"+myVariables.getUserLoggedInId()+"'";
                break;
            }case 2:{   //Department Head
                String managedSubjects = "";
                
                for(int n=0;n<assignedSubjectsTable.getRowCount();n++){
                    managedSubjects += assignedSubjectsTable.getValueAt(n, 0).toString();
                    if(n < assignedSubjectsTable.getRowCount()-1){
                        managedSubjects+=",";
                    }
                }
                if(managedSubjects.length() > 0){
                    where += " AND subjectId IN ("+managedSubjects+")";
                }else{
                    Toolkit.getDefaultToolkit().beep();
                    my.showMessage("There are no subjects assigned to you. Try refreshing again.\nIf the problem persists, please consult your Curruculum Head if you think this is an error.", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                where += " AND teacherId!='-1'";
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
    }//GEN-LAST:event_tfSearchTeacherLoadsearchManagedSections

    private void btnSearchSectionsearchManagedSections(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchSectionsearchManagedSections
        String toSearch = tfSearchTeacherLoad.getText();
        String schoolYear = jcbSchoolYear1.getSelectedItem().toString();

        my.remove_multiple_tabs(mainTab, new int [] {1,2});

        String where = "WHERE subjectCode NOT LIKE 'ADV%'";
        
        //Filter search based on Access Level
        switch (myVariables.getAccessLevel()){
            case 1:{    //Teacher or Subject Teacher
                where += " AND teacherId='"+myVariables.getUserLoggedInId()+"'";
                break;
            }case 2:{   //Department Head
                String managedSubjects = "";
                
                for(int n=0;n<assignedSubjectsTable.getRowCount();n++){
                    managedSubjects += assignedSubjectsTable.getValueAt(n, 0).toString();
                    if(n < assignedSubjectsTable.getRowCount()-1){
                        managedSubjects+=",";
                    }
                }
                
                if(managedSubjects.length() > 0){
                    where += " AND subjectId IN ("+managedSubjects+")";
                }else{
                    Toolkit.getDefaultToolkit().beep();
                    my.showMessage("You have no subjects assigned to you. Try refreshing again.\nIf the problem persists, please consult your Curruculum Head if you think this is an error.", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                where += " AND teacherId!='-1'";
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
    }//GEN-LAST:event_btnSearchSectionsearchManagedSections

    private void assignedTeacherTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_assignedTeacherTableMouseClicked
        if(evt.getClickCount() == 2){
            if(mainTab.getTabCount() <= 1){
                int row = assignedTeacherTable.getSelectedRow();
                
                String sectionName = assignedTeacherTable.getValueAt(row, 2).toString();
                String subjectName = assignedTeacherTable.getValueAt(row, 8).toString();
                
                lbSubjectName2.setText(subjectName.toUpperCase());
                lbSectionName2.setText(sectionName.toUpperCase());
                
                mainTab.addTab("View Students", /*my.getImgIcn(myVariables.getViewStudentsIcon()),*/ viewStudentsTab2);
                mainTab.setSelectedIndex(1);
            }
            //resetStudentDetails(true, true, false);
            loadStudentsAndGrades();
            //calculateAttendanceCount(lbAttendanceCount, attendanceTable);
        }else{
            my.remove_multiple_tabs(mainTab, new int [] {1,2});
        }
    }//GEN-LAST:event_assignedTeacherTableMouseClicked

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

        resetStudentDetails(true, true, false);
        String where = "WHERE sectionId='"+sectionId+"' AND (lrn='"+toSearch+"' OR lName LIKE '%"+toSearch+"%')";
        my.searchItem(where, enrolledStudentsTable, 6, null, new int [] {3,4,5}, true, true, lbSearchResult1, tfSearchEnrolledStudent, true);
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
        
        resetStudentDetails(true, true, false);
        String where = "WHERE sectionId='"+sectionId+"' AND (lrn='"+toSearch+"' OR lName LIKE '%"+toSearch+"%')";
        my.searchItem(where, enrolledStudentsTable, 6, null, new int [] {3,4,5}, true, true, lbSearchResult1, tfSearchEnrolledStudent, true);
    }//GEN-LAST:event_btnSearchEnrolledStudentsearchEnrolledStudentsHandler

    private void enrolledStudentsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_enrolledStudentsTableMouseClicked
        if(evt.getClickCount() == 2){
            int row = enrolledStudentsTable.getSelectedRow();
            int sectionRow = assignedTeacherTable.getSelectedRow();
            
            String sectionId = assignedTeacherTable.getValueAt(sectionRow,1).toString();
            String subjectId = assignedTeacherTable.getValueAt(sectionRow, 6).toString();
            String studentId = enrolledStudentsTable.getValueAt(row, 1).toString();
            
            //Check if record exists...Add if none are found
            String where = "WHERE sectionId='"+sectionId+"' AND subjectId='"+subjectId+"' AND studentId='"+studentId+"'";
            
            if(my.checkForDuplicates("grades", where, myVariables.getGradesOrder())){
                //Load data here
                playSuccess();
                System.err.println("Record found.");
                String result[] = my.return_values("*", "grades", where, myVariables.getGradesOrder());
                
                if(result != null){
                    String values[] = result[0].split("@@");
                    
                    lbRecordId.setText(values[0]);
                    lbDateUpdated.setText("Date:  "+my.numberToWordDate(values[10]));
                    lbGradeStatus.setText(values[9]);
                    
                    tfFirstQ.setText(values[4].contains("-1")||Double.valueOf(values[4])== 0? " " : values[4]);
                    tfSecondQ.setText(values[5].contains("-1")||Double.valueOf(values[5])== 0? " " : values[5]);
                    tfThirdQ.setText(values[6].contains("-1")||Double.valueOf(values[6])== 0? " " : values[6]);
                    tfFourthQ.setText(values[7].contains("-1")||Double.valueOf(values[7])== 0? " " : values[7]);
                    tfGeneralWeighedAverage.setText(values[8].contains("-1")? " " : values[8]);
                    
                    resetStudentDetails(false, false, true);
                }else{
                    playError();
                    my.showMessage("Oooops! This record might have been deleted just now.\nPlease contact your Developer for help.", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                if(my.getConfirmation("This student has no record yet. Add one now?")){
                    String [] toSend = {
                        "null,'"+studentId+"','"+sectionId+"','"+subjectId+"','Open:Open:Open:Open:Incomplete:',now()",
                    };
                    
                    if(my.add_values("grades", "id,studentId,sectionId,subjectId,status,dateUpdated", toSend)){
                        playSuccess();
                        my.showMessage("Adding Successful. Please select the student again", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        playError();
                        my.showMessage("Adding Failed. Please make sure you are connected to the School Network.", JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    Toolkit.getDefaultToolkit().beep();
                    my.showMessage("Adding Grade Records canceled.", JOptionPane.PLAIN_MESSAGE);
                }
            }
        }else{
            resetStudentDetails(false, true, false);
        }
    }//GEN-LAST:event_enrolledStudentsTableMouseClicked

    private void tfEditGwaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfEditGwaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfEditGwaActionPerformed

    private void btnEditGradesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditGradesActionPerformed
        String q1 = tfFirstQ.getText().trim();
        String q2 = tfSecondQ.getText().trim();
        String q3 = tfThirdQ.getText().trim();
        String q4 = tfFourthQ.getText().trim();
        String gwa = tfGeneralWeighedAverage.getText().trim();
        
        tfEditFirstQuarter.setText(q1);
        tfEditSecondQuarter.setText(q2);
        tfEditThirdQuarter.setText(q3);
        tfEditFourthQuarter.setText(q4);
        tfEditGwa.setText(gwa);
        
        //Load Status
        String [] statuses = lbGradeStatus.getText().split(":");
        JTextField [] quarterFields = {tfEditFirstQuarter,tfEditSecondQuarter,tfEditThirdQuarter,tfEditFourthQuarter};
        JRadioButton [][] radioSets = {
            new JRadioButton[] {jRadioButton1,jRadioButton2,jRadioButton3,jRadioButton4},
            new JRadioButton[] {jRadioButton5,jRadioButton6,jRadioButton7,jRadioButton8},
            new JRadioButton[] {jRadioButton9,jRadioButton10,jRadioButton11,jRadioButton12},
            new JRadioButton[] {jRadioButton13,jRadioButton14,jRadioButton15,jRadioButton16},
            
        };
        for(int n=0;n<statuses.length;n++){
            if(n==4){
                tfEvaluation.setText(statuses[n]);
                break;
            }
            loadStatuses(quarterFields[n], statuses[n], radioSets[n], myVariables.getAccessLevel()!=5? true:false);
        }
        enableDisableSaveButtonViaStatus();
        
        if(myVariables.getAccessLevel() == 5){
            lbStatusOptions.setText("Status Options (Ignored By Admin)");
        }else{
            lbStatusOptions.setText("Status Options");
        }
        
        cbAllowDecimalValues.setSelected(false);
        checkCalculationMethod(false,cbAllowDecimalValues.isSelected());
        
        showCustomDialog("Edit Grade Details", editGradeDialog, true, 450, 580, true);
    }//GEN-LAST:event_btnEditGradesActionPerformed

    private void btnSaveGradeChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveGradeChangesActionPerformed
        String recordId = lbRecordId.getText();
        String q1 = tfEditFirstQuarter.getText().trim().length()>0? tfEditFirstQuarter.getText() : "-1";
        String q2 = tfEditSecondQuarter.getText().trim().length()>0? tfEditSecondQuarter.getText() : "-1";
        String q3 = tfEditThirdQuarter.getText().trim().length()>0? tfEditThirdQuarter.getText() : "-1";
        String q4 = tfEditFourthQuarter.getText().trim().length()>0? tfEditFourthQuarter.getText() : "-1";
        String gwa = tfEditGwa.getText().trim();
        String status = retrieveStatuses();
        
        
        if(gwa.contains("NaN")){
            playError();
            my.showMessage("Invalid Grade. Please check your inputs first.", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String [] sets = {
            "firstQuarter='"+q1+"'",
            "secondQuarter='"+q2+"'",
            "thirdQuarter='"+q3+"'",
            "fourthQuarter='"+q4+"'",
            "gwa='"+gwa+"'",
            "status='"+status+"'",
            "dateUpdated=now()",
        };
        
        if(my.update_values("grades", sets, "id='"+recordId+"'")){
            playSuccess();
            my.showMessage("Changes Saved.", JOptionPane.INFORMATION_MESSAGE);
            closeCustomDialog();
            resetStudentDetails(false, true, false);
        }else{
            playError();
            my.showMessage("Update Failed. Please make sure you are connected to the School Network", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveGradeChangesActionPerformed

    private void calculateGwaOnKeyReleaseHandler(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_calculateGwaOnKeyReleaseHandler
        checkCalculationMethod(true,cbAllowDecimalValues.isSelected());
    }//GEN-LAST:event_calculateGwaOnKeyReleaseHandler

    private void cbAllowDecimalValuesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbAllowDecimalValuesMouseClicked
        checkCalculationMethod(true, cbAllowDecimalValues.isSelected());
    }//GEN-LAST:event_cbAllowDecimalValuesMouseClicked

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        refreshAssignedSubjects(true);
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void tfEvaluationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfEvaluationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfEvaluationActionPerformed

    private void enrolledStudentsTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_enrolledStudentsTable1MouseClicked
        int row = enrolledStudentsTable1.getSelectedRow();
        int col = enrolledStudentsTable1.getSelectedColumn();
        
        //jephthah is here
        
        int x = 0;
        String sem = "secret";
        
        if(col == 7){
            x = 1;
            sem = "1st";
        }else if(col == 8){
            x = 2;
            sem = "1st";
        }else if(col == 9){
            x = 1;
            sem = "2nd";
        }else if(col == 10){
            x = 2;
            sem = "2nd";
        }
        
        if(row != -1){
            String statuses = enrolledStudentsTable1.getValueAt(row, 12).toString();            
            btnSaveChangesCurrent.setEnabled(true);
            
            if(!statuses.contains("--")){
                loadStatusRadioBtns(statuses);
                
                if(col >= 7 && col <= 10){  //Q1 to Q4 
                    //Check if status is open And can only be edited by Subject Teacher, Registrar or Admin
                    if(canEditGrade(col) && (myVariables.getAccessLevel() == 1 || myVariables.getAccessLevel() >= 4)){
                        String studentName = enrolledStudentsTable1.getValueAt(row, 3).toString();
                        String currentGrade = enrolledStudentsTable1.getValueAt(row, col).toString();
                        
                        String temp = (String) JOptionPane.showInputDialog(
                                this,
                                col-6!= 5? "" + sem + " Semester, Quarter " + x + " Grade:" : "General Average",
                                studentName,
                                JOptionPane.INFORMATION_MESSAGE,
                                my.getImgIcn(myVariables.getMsgUrlIcon()),
                                null,currentGrade
                        );
                        
                        if(temp != null){
                            try {
                                temp = String.valueOf(
                                        Integer.parseInt(
                                                String.valueOf((int)Float.parseFloat(temp))
                                        ) //Checks if grade is a whole number. If decimal, convert to integer
                                ); 
                                
                                enrolledStudentsTable1.setValueAt(temp, row, col);
                                calculateGrade(row);
                            } catch (NumberFormatException e) {
                                Toolkit.getDefaultToolkit().beep();
                                my.showMessage("Invalid Grade Entered.", JOptionPane.WARNING_MESSAGE);
                            }
                        } else {
                            //enrolledStudentsTable1.setValueAt(0, row, col);
                        }
                    }
                }
                
                return;
            }else {
                int row2 = assignedTeacherTable.getSelectedRow();
                String studentId = enrolledStudentsTable1.getValueAt(row, 1).toString();
                String sectionId = enrolledStudentsTable1.getValueAt(row, 5).toString();
                String subjectId = assignedTeacherTable.getValueAt(row2, 6).toString();
                
                if(my.getConfirmation("This student has no record yet. Add one now?")){
                    String [] toSend = {
                        "null,'"+studentId+"','"+sectionId+"','"+subjectId+"','Open:Open:Open:Open:Incomplete:',now()",
                    };
                    
                    if(my.add_values("grades", "id,studentId,sectionId,subjectId,status,dateUpdated", toSend)){
                        playSuccess();
                        my.showMessage("Adding Successful. Please select the student again", JOptionPane.INFORMATION_MESSAGE);
                        loadStudentsAndGrades();
                    }else{
                        playError();
                        my.showMessage("Adding Failed. Please make sure you are connected to the School Network.", JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    Toolkit.getDefaultToolkit().beep();
                    my.showMessage("Adding Grade Records canceled.", JOptionPane.PLAIN_MESSAGE);
                }
            }
            
            loadStatusRadioBtns(null);
        }        
    }//GEN-LAST:event_enrolledStudentsTable1MouseClicked
    private boolean canEditGrade(int column){
        switch(column){
            case 7:{
                return jRadioButton17.isSelected();
            }case 8:{
                return jRadioButton21.isSelected();
            }case 9:{
                return jRadioButton25.isSelected();
            }case 10:{
                return jRadioButton29.isSelected();
            }case 11:{
                return true;//can edit General Average Directly
            } default: {
                return false;
            }
        }
    }
    
    private void btnRefreshStudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshStudentsActionPerformed
        loadStudentsAndGrades();
    }//GEN-LAST:event_btnRefreshStudentsActionPerformed

    private void enrolledStudentsTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_enrolledStudentsTable1KeyReleased
        int row = enrolledStudentsTable1.getSelectedRow();
        int col = enrolledStudentsTable1.getSelectedColumn();
        
        //jephthah is here
        
        int x = 0;
        String sem = "secret";
        
        if(col == 7){
            x = 1;
            sem = "1st";
        }else if(col == 8){
            x = 2;
            sem = "1st";
        }else if(col == 9){
            x = 1;
            sem = "2nd";
        }else if(col == 10){
            x = 2;
            sem = "2nd";
        }
        
        if(row != -1 && (evt.getKeyCode() == KeyEvent.VK_RIGHT || evt.getKeyCode() == KeyEvent.VK_LEFT)){
            String statuses = enrolledStudentsTable1.getValueAt(row, 12).toString();
            btnSaveChangesCurrent.setEnabled(true);
            
            if(!statuses.contains("--")){
                loadStatusRadioBtns(statuses);
                
                if(col >= 7 && col <= 10){  //Q1 to Q4 Columns
                    //Check if status is open
                    if(canEditGrade(col)){
                        String studentName = enrolledStudentsTable1.getValueAt(row, 3).toString();
                        String currentGrade = enrolledStudentsTable1.getValueAt(row, col).toString();
                        
                        String temp = (String) JOptionPane.showInputDialog(
                                this,
                                col-6!= 5? "" + sem + " Semester, Quarter " + x + " Grade:" : "General Average",
                                studentName,
                                JOptionPane.INFORMATION_MESSAGE,
                                my.getImgIcn(myVariables.getMsgUrlIcon()),
                                null,currentGrade
                        );
                        
                        if(temp != null){
                            try {
                                temp = String.valueOf(
                                        Integer.parseInt(
                                                String.valueOf((int)Float.parseFloat(temp))
                                        ) //Checks if grade is a whole number. If decimal, convert to integer
                                ); 
                                
                                enrolledStudentsTable1.setValueAt(temp, row, col);
                                calculateGrade(row);
                            } catch (NumberFormatException e) {
                                Toolkit.getDefaultToolkit().beep();
                                my.showMessage("Invalid Grade Entered.", JOptionPane.WARNING_MESSAGE);
                            }
                        } else {
                            //enrolledStudentsTable1.setValueAt(0, row, col);
                        }
                    }
                }
                
                return;
            }
            
            loadStatusRadioBtns(null);
        }
    }//GEN-LAST:event_enrolledStudentsTable1KeyReleased

    private void rbQuarter1cbAllowDecimalValuesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbQuarter1cbAllowDecimalValuesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rbQuarter1cbAllowDecimalValuesMouseClicked

    private void rbQuarter2cbAllowDecimalValuesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbQuarter2cbAllowDecimalValuesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rbQuarter2cbAllowDecimalValuesMouseClicked

    private void rbQuarter3cbAllowDecimalValuesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbQuarter3cbAllowDecimalValuesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rbQuarter3cbAllowDecimalValuesMouseClicked

    private void rbQuarter4cbAllowDecimalValuesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbQuarter4cbAllowDecimalValuesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rbQuarter4cbAllowDecimalValuesMouseClicked

    private void btnSelectQuarterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectQuarterActionPerformed
        //Save Here
        closeCustomDialog();
        rbAllQuarters.setEnabled(false);
        
        switch(dialog.getTitle()){
            case "Update Grades":{
                updateGrades(enrolledStudentsTable1.getSelectedRow());
                break;
            }case "Submit Selected":{
                buttonSelected(enrolledStudentsTable1.getSelectedRows(), "Submitted");
                break;
            }case "Submit All":{
                buttonAll("Submitted");
                break;
            }case "Approve Selected":{
                buttonSelected(enrolledStudentsTable1.getSelectedRows(), "Approved");
                break;
            }case "Approve All":{
                buttonAll("Approved");
                break;
            }case "Close Selected":{
                buttonSelected(enrolledStudentsTable1.getSelectedRows(), "Closed");
                break;
            }case "Close All":{
                buttonAll("Closed");
                break;
            }default:{
                
            }
        }
    }//GEN-LAST:event_btnSelectQuarterActionPerformed

    private void rbAllQuarterscbAllowDecimalValuesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbAllQuarterscbAllowDecimalValuesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rbAllQuarterscbAllowDecimalValuesMouseClicked

    private void btnOpenFileExplorerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenFileExplorerActionPerformed
        //showFileChooserDialog("Excel Files","xlsx");
    }//GEN-LAST:event_btnOpenFileExplorerActionPerformed

    private void btnMyManagedSubjectsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMyManagedSubjectsActionPerformed
        cards.removeAll();
        cards.add(card2);
        cards.repaint();
        cards.revalidate();
        
        btnMyManagedSubjects.setBackground(Color.decode("#FDE8F0"));
        
        btnManageGrades.setBackground(Color.decode("#FBB9D3"));
        btnImportFromSf10.setBackground(Color.decode("#FBB9D3"));
    }//GEN-LAST:event_btnMyManagedSubjectsActionPerformed

    private void btnImportFromSf10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportFromSf10ActionPerformed
        cards.removeAll();
        cards.add(card3);
        cards.repaint();
        cards.revalidate();
        
        btnImportFromSf10.setBackground(Color.decode("#FDE8F0"));
        
        btnManageGrades.setBackground(Color.decode("#FBB9D3"));
        btnMyManagedSubjects.setBackground(Color.decode("#FBB9D3"));
    }//GEN-LAST:event_btnImportFromSf10ActionPerformed

    private void btnAdvAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdvAllActionPerformed
        selectQuarter("Submit All");
    }//GEN-LAST:event_btnAdvAllActionPerformed

    private void btnAdvSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdvSelectedActionPerformed
        selectQuarter("Submit Selected");
    }//GEN-LAST:event_btnAdvSelectedActionPerformed

    private void btnRgrAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRgrAllActionPerformed
        selectQuarter("Close All");
    }//GEN-LAST:event_btnRgrAllActionPerformed

    private void btnRgrSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRgrSelectedActionPerformed
        selectQuarter("Close Selected");
    }//GEN-LAST:event_btnRgrSelectedActionPerformed

    private void btnDphAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDphAllActionPerformed
        selectQuarter("Approve All");
    }//GEN-LAST:event_btnDphAllActionPerformed

    private void btnDphSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDphSelectedActionPerformed
        selectQuarter("Approve Selected");
    }//GEN-LAST:event_btnDphSelectedActionPerformed

    private void btnManageGradesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageGradesActionPerformed
        // TODO add your handling code here:
        cards.removeAll();
        cards.add(card1);
        cards.repaint();
        cards.revalidate(); 
        
        btnManageGrades.setBackground(Color.decode("#FDE8F0"));
        
        btnMyManagedSubjects.setBackground(Color.decode("#FBB9D3"));
        btnImportFromSf10.setBackground(Color.decode("#FBB9D3"));
    }//GEN-LAST:event_btnManageGradesActionPerformed

    private void btnSaveChangesCurrentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveChangesCurrentActionPerformed
        int row = enrolledStudentsTable1.getSelectedRow();

        if(row == -1){
            return;
        }
        //updateGrades(row);
        rbAllQuarters.setEnabled(true);
        selectQuarter("Update Grades");
    }//GEN-LAST:event_btnSaveChangesCurrentActionPerformed

    private void jRadioButton30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton30MouseClicked
        int row = enrolledStudentsTable1.getSelectedRow();

        if(row != -1){
            String result = retrieveCheckedStatuses(row, false);
            enrolledStudentsTable1.setValueAt(result, row, 12);
        }
    }//GEN-LAST:event_jRadioButton30MouseClicked

    private void jRadioButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton18ActionPerformed

    private void jRadioButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton24ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton24ActionPerformed

    private void jRadioButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton26ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton26ActionPerformed

    private void jRadioButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton32ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton32ActionPerformed

    private void jRadioButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton19ActionPerformed

    private void jRadioButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton20ActionPerformed

    private void rbQuarter1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbQuarter1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbQuarter1ActionPerformed

    private void jRadioButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton17ActionPerformed

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

    private void jcbSchoolYear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbSchoolYear1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbSchoolYear1ActionPerformed
    
    
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
    
    private void updateGrades(int row){
        //Get id and values
        String gradeId = enrolledStudentsTable1.getValueAt(row, 6).toString();
        
        String updatedStatus = "";
        
        if(myVariables.getAccessLevel() == 1){
            updatedStatus = retrieveCheckedStatuses(row, true);
        }else {
            updatedStatus = my.getConfirmation("Set grade's status from 'Open' to 'Submitted'?\n(Any grade that has 'Open' checked are affected)")?
                                    retrieveCheckedStatuses(row, true):
                                    retrieveCheckedStatuses(row, false);
        }
        
        String q1 = enrolledStudentsTable1.getValueAt(row, 7).toString().trim().length()>0? enrolledStudentsTable1.getValueAt(row, 7).toString() : "";
        String q2 = enrolledStudentsTable1.getValueAt(row, 8).toString().trim().length()>0? enrolledStudentsTable1.getValueAt(row, 8).toString() : "";
        String q3 = enrolledStudentsTable1.getValueAt(row, 9).toString().trim().length()>0? enrolledStudentsTable1.getValueAt(row, 9).toString() : "";
        String q4 = enrolledStudentsTable1.getValueAt(row, 10).toString().trim().length()>0? enrolledStudentsTable1.getValueAt(row, 10).toString() : "";
        String gwa = enrolledStudentsTable1.getValueAt(row, 11).toString().trim();
        
        
        if(gwa.contains("NaN")){
            playError();
            my.showMessage("Invalid Grade. Please check your inputs first.", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        //Check where all quarters should be submitted or not
        
        
        String [] sets = {
            "firstQuarter='"+q1+"'",
            "secondQuarter='"+q2+"'",
            "thirdQuarter='"+q3+"'",
            "fourthQuarter='"+q4+"'",
            "gwa='"+gwa+"'",
            "status='"+updatedStatus+"'",
            "dateUpdated=now()",
        };
        
        if(my.update_values("grades", sets, "id='"+gradeId+"'")){
            playSuccess();
            my.showMessage("Changes Saved.", JOptionPane.INFORMATION_MESSAGE);
            loadStudentsAndGrades();
        }else{
            playError();
            my.showMessage("Update Failed. Please make sure you are connected to the School Network", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void buttonSelected(int[] srows, String cstatus){
        if(enrolledStudentsTable1.getSelectedRowCount() == 0){
            Toolkit.getDefaultToolkit().beep();
            my.showMessage("No Students Selected. Please select at least ONE.", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        //get selected rows
        int rowId[] = srows;
        
        //get selected quarter
        int rbIndexToUpdate = 0;
            
        if(rbQuarter1.isSelected())
            rbIndexToUpdate = 0;
        if(rbQuarter2.isSelected())
            rbIndexToUpdate = 1;
        if(rbQuarter3.isSelected())
            rbIndexToUpdate = 2;
        if(rbQuarter4.isSelected())
            rbIndexToUpdate = 3;
        
        int scount = 0; //count sa successful actions
        int icount = 0; //count sa mga invalid actions
        
        for(int x=0;x < rowId.length;x++){
            //get ids and values
            String gradeId = enrolledStudentsTable1.getValueAt(rowId[x], 6).toString();
            String status = cstatus;
            String updatedStatus = "secret";
            
            String previousStatuses[] = enrolledStudentsTable1.getValueAt(rowId[x], 12).toString().split(":");
            
            if(status == "Submitted"){
                if(!"Open".equals(previousStatuses[rbIndexToUpdate])){
                    System.out.println(previousStatuses[rbIndexToUpdate]);
                    icount++;
                    continue;
                }
            }else if(status == "Approved"){
                if(!"Submitted".equals(previousStatuses[rbIndexToUpdate])){
                    System.out.println(previousStatuses[rbIndexToUpdate]);
                    icount++;
                    continue;
                }
            }else if(status == "Closed"){
                if(!"Approved".equals(previousStatuses[rbIndexToUpdate])){
                    System.out.println(previousStatuses[rbIndexToUpdate]);
                    icount++;
                    continue;
                }
            }
            
            if(rbIndexToUpdate == 0){
                updatedStatus = status+":"+previousStatuses[1]+":"+previousStatuses[2]+":"+previousStatuses[3]+":"+previousStatuses[4]+":";
            }else if(rbIndexToUpdate == 1){
                updatedStatus = previousStatuses[0]+":"+status+":"+previousStatuses[2]+":"+previousStatuses[3]+":"+previousStatuses[4]+":";
            }else if(rbIndexToUpdate == 2){
                updatedStatus = previousStatuses[0]+":"+previousStatuses[1]+":"+status+":"+previousStatuses[3]+":"+previousStatuses[4]+":";
            }else if(rbIndexToUpdate == 3){
                updatedStatus = previousStatuses[0]+":"+previousStatuses[1]+":"+previousStatuses[2]+":"+status+":"+previousStatuses[4]+":";
            }else{
                //wala :>
                break;
            }
            
            String q1 = enrolledStudentsTable1.getValueAt(rowId[x], 7).toString().trim().length()>0? enrolledStudentsTable1.getValueAt(rowId[x], 7).toString() : "";
            String q2 = enrolledStudentsTable1.getValueAt(rowId[x], 8).toString().trim().length()>0? enrolledStudentsTable1.getValueAt(rowId[x], 8).toString() : "";
            String q3 = enrolledStudentsTable1.getValueAt(rowId[x], 9).toString().trim().length()>0? enrolledStudentsTable1.getValueAt(rowId[x], 9).toString() : "";
            String q4 = enrolledStudentsTable1.getValueAt(rowId[x], 10).toString().trim().length()>0? enrolledStudentsTable1.getValueAt(rowId[x], 10).toString() : "";
            String gwa = enrolledStudentsTable1.getValueAt(rowId[x], 11).toString().trim();
            
            String [] sets = {
                "firstQuarter='"+q1+"'",
                "secondQuarter='"+q2+"'",
                "thirdQuarter='"+q3+"'",
                "fourthQuarter='"+q4+"'",
                "gwa='"+gwa+"'",
                "status='"+updatedStatus+"'",
                "dateUpdated=now()",
            };
            
            my.update_values("grades", sets, "id='"+gradeId+"'");
            scount++;
        }
        playSuccess();
        if(icount != 0){
            my.showMessage("Changes Saved. " +icount+ " unchanged.", JOptionPane.INFORMATION_MESSAGE);
        }else{
            my.showMessage("" +scount+ " Changes Saved.", JOptionPane.INFORMATION_MESSAGE);
        }
        loadStudentsAndGrades();
    }
    
    private void buttonAll(String cstatus){
        //get rows
        int rowcount = enrolledStudentsTable1.getRowCount();
        System.out.println(rowcount+" total of students");
        //int rowId[] = new int[rowcount];
        
        //get selected quarter
        int rbIndexToUpdate = 0;
            
        if(rbQuarter1.isSelected())
            rbIndexToUpdate = 0;
        if(rbQuarter2.isSelected())
            rbIndexToUpdate = 1;
        if(rbQuarter3.isSelected())
            rbIndexToUpdate = 2;
        if(rbQuarter4.isSelected())
            rbIndexToUpdate = 3;
        
        int scount = 0; //count sa successful actions
        int icount = 0; //count sa mga invalid actions
        
        for(int x=0;x < rowcount;x++){
            //get ids and values
            String gradeId = enrolledStudentsTable1.getValueAt(x, 6).toString();
            System.out.println(gradeId+" is being updated");
            String status = cstatus;
            String updatedStatus = "secret";
            
            String previousStatuses [] = enrolledStudentsTable1.getValueAt(x, 12).toString().split(":");
            
            if(status == "Submitted"){
                if(!"Open".equals(previousStatuses[rbIndexToUpdate])){
                    System.out.println(previousStatuses[rbIndexToUpdate]);
                    icount++;
                    continue;
                }
            }else if(status == "Approved"){
                if(!"Submitted".equals(previousStatuses[rbIndexToUpdate])){
                    System.out.println(previousStatuses[rbIndexToUpdate]);
                    icount++;
                    continue;
                }
            }else if(status == "Closed"){
                if(!"Approved".equals(previousStatuses[rbIndexToUpdate])){
                    System.out.println(previousStatuses[rbIndexToUpdate]);
                    icount++;
                    continue;
                }
            }
            
            if(rbIndexToUpdate == 0){
                updatedStatus = status+":"+previousStatuses[1]+":"+previousStatuses[2]+":"+previousStatuses[3]+":"+previousStatuses[4]+":";
            }else if(rbIndexToUpdate == 1){
                updatedStatus = previousStatuses[0]+":"+status+":"+previousStatuses[2]+":"+previousStatuses[3]+":"+previousStatuses[4]+":";
            }else if(rbIndexToUpdate == 2){
                updatedStatus = previousStatuses[0]+":"+previousStatuses[1]+":"+status+":"+previousStatuses[3]+":"+previousStatuses[4]+":";
            }else if(rbIndexToUpdate == 3){
                updatedStatus = previousStatuses[0]+":"+previousStatuses[1]+":"+previousStatuses[2]+":"+status+":"+previousStatuses[4]+":";
            }else{
                //wala :>
                break;
            }
            
            String q1 = enrolledStudentsTable1.getValueAt(x, 7).toString().trim().length()>0? enrolledStudentsTable1.getValueAt(x, 7).toString() : "";
            String q2 = enrolledStudentsTable1.getValueAt(x, 8).toString().trim().length()>0? enrolledStudentsTable1.getValueAt(x, 8).toString() : "";
            String q3 = enrolledStudentsTable1.getValueAt(x, 9).toString().trim().length()>0? enrolledStudentsTable1.getValueAt(x, 9).toString() : "";
            String q4 = enrolledStudentsTable1.getValueAt(x, 10).toString().trim().length()>0? enrolledStudentsTable1.getValueAt(x, 10).toString() : "";
            String gwa = enrolledStudentsTable1.getValueAt(x, 11).toString().trim();
            
            String [] sets = {
                "firstQuarter='"+q1+"'",
                "secondQuarter='"+q2+"'",
                "thirdQuarter='"+q3+"'",
                "fourthQuarter='"+q4+"'",
                "gwa='"+gwa+"'",
                "status='"+updatedStatus+"'",
                "dateUpdated=now()",
            };
            
            my.update_values("grades", sets, "id='"+gradeId+"'");
            scount++;
        }
        playSuccess();
        if(icount != 0){
            my.showMessage("Changes Saved. " +icount+ " unchanged.", JOptionPane.INFORMATION_MESSAGE);
        }else{
            my.showMessage("" +scount+ " Changes Saved.", JOptionPane.INFORMATION_MESSAGE);
        }
        loadStudentsAndGrades();
    }
    
    private void selectQuarter(String title){
        switch (enrolledStudentsTable1.getSelectedColumn()){
            case 7: {
                rbQuarter1.setSelected(true);
                break;
            }case 8: {
                rbQuarter2.setSelected(true);
                break;
            }case 9: {
                rbQuarter3.setSelected(true);
                break;
            }case 10: {
                rbQuarter4.setSelected(true);
                break;
            }default: {
                rbQuarter1.setSelected(true);
                break;
            }
        }
        showCustomDialog(title, selectQuarterDialog, true, 250, 300, false);
        
        btnSelectQuarter.requestFocus();
    }
    
    private void updateStatusFields(){
        int row = enrolledStudentsTable1.getSelectedRow();
        
        if(row != -1){
            JRadioButton [][] radioSets = {
                new JRadioButton[] {jRadioButton17,jRadioButton18,jRadioButton19,jRadioButton20},
                new JRadioButton[] {jRadioButton21,jRadioButton22,jRadioButton23,jRadioButton24},
                new JRadioButton[] {jRadioButton25,jRadioButton26,jRadioButton27,jRadioButton28},
                new JRadioButton[] {jRadioButton29,jRadioButton30,jRadioButton31,jRadioButton32},
            };
            String status = retrieveStatuses();
        }
    }
    
    private void resetStudentDetails(boolean clearTable,boolean clearFields, boolean enableEditBtn){
        if(clearTable){
            my.clear_table_rows(enrolledStudentsTable);
        }
        if(clearFields){
            lbRecordId.setText(" --Please Select A Student--");
            lbDateUpdated.setText("Date: --Please Select A Student--");
            lbGradeStatus.setText(" --Please Select A Student--");
            
            tfFirstQ.setText("");
            tfSecondQ.setText("");
            tfThirdQ.setText("");
            tfFourthQ.setText("");
            tfGeneralWeighedAverage.setText("");
        }
        
        btnEditGrades.setEnabled(enableEditBtn);
    }
    private String getEvaluation(double gwa){
        //Check if all fields have values
        if(tfEditFirstQuarter.getText().length() == 0 || tfEditSecondQuarter.getText().length() == 0 
                || tfEditThirdQuarter.getText().length() == 0 || tfEditFourthQuarter.getText().length() == 0)
            return "Incomplete";
        if(gwa<75f){
            return "Failed";
        }else{
            return "Passed";
        }
    }
    private void showEvaluation(String statuses){
        if(statuses == null){
            lbEvaluation.setForeground(Color.BLACK);
            lbEvaluation.setText("-- Select Student --");
        }else{
            String status [] = statuses.split(":");
            switch(status[4]){
                case "Incomplete":{
                    lbEvaluation.setForeground(new Color(255,102,0)); break;    //ORANGE
                }case "Passed":{
                    lbEvaluation.setForeground(new Color(0,102,0)); break;    //GREEN;
                }case "Failed":{
                    lbEvaluation.setForeground(Color.RED); break;    //RED
                }default:{
                    lbEvaluation.setForeground(Color.BLUE); break;    //BLUE
                }
            }
            
            lbEvaluation.setText(status[4]);
        }
    }
    private String getEvaluation(int row, double gwa){
        //Check if all fields have values
        if(enrolledStudentsTable1.getValueAt(row, 7).toString().length() == 0 || 
            enrolledStudentsTable1.getValueAt(row, 8).toString().length() == 0 ||
            enrolledStudentsTable1.getValueAt(row, 9).toString().length() == 0 ||
            enrolledStudentsTable1.getValueAt(row, 10).toString().length() == 0){
            return "Incomplete";
        }
        if(gwa<75f){
            return "Failed";
        }else{
            return "Passed";
        }
    }
    private void calculateGrade(int row){
        int q1,q2,q3,q4,gwa;
        
        //Column 7 = Q1
        
        try {
            q1 = enrolledStudentsTable1.getValueAt(row, 7).toString().length()>0 ?
                    Integer.parseInt(enrolledStudentsTable1.getValueAt(row, 7).toString()) : 0;
            q2 = enrolledStudentsTable1.getValueAt(row, 8).toString().length()>0 ?
                    Integer.parseInt(enrolledStudentsTable1.getValueAt(row, 8).toString()) : 0;
            q3 = enrolledStudentsTable1.getValueAt(row, 9).toString().length()>0 ?
                    Integer.parseInt(enrolledStudentsTable1.getValueAt(row, 9).toString()) : 0;
            q4 = enrolledStudentsTable1.getValueAt(row, 10).toString().length()>0 ?
                    Integer.parseInt(enrolledStudentsTable1.getValueAt(row, 10).toString()) : 0;

            gwa = (q1+q2+q3+q4)/4;

            enrolledStudentsTable1.setValueAt(gwa,row, 11);
            
            String newStatus = my.setValueAtColumn(
                    enrolledStudentsTable1.getValueAt(row, 12).toString().replace(":", "@@"),
                    4, getEvaluation(row,gwa)
            );
            enrolledStudentsTable1.setValueAt(newStatus.replace("@@",":"), row, 12);
            showEvaluation(newStatus.replace("@@",":"));
        } catch (Exception e) {
            playError();
            System.err.println("Invalid Values entered");
            tfEditGwa.setText("NaN");
        }
    }
    
    private void checkCalculationMethod(boolean calculateGwa,boolean allowDecimalValues){
        if(rbAutomatic.isSelected()){
            tfEditGwa.setEditable(false);
            tfEvaluation.setEditable(false);
        }
        if(rbManual.isSelected()){
            tfEditGwa.setEditable(true);
            tfEvaluation.setEditable(true);
            return;
        }
        
        if(calculateGwa && rbAutomatic.isSelected()){
            if(allowDecimalValues){
                DecimalFormat df = new DecimalFormat("#.##");
                double q1,q2,q3,q4,gwa;
                
                try {
                    q1 = tfEditFirstQuarter.getText().length()>0 ? Double.parseDouble(tfEditFirstQuarter.getText()) : 0f;
                    q2 = tfEditSecondQuarter.getText().length()>0 ? Double.parseDouble(tfEditSecondQuarter.getText()) : 0f;
                    q3 = tfEditThirdQuarter.getText().length()>0 ? Double.parseDouble(tfEditThirdQuarter.getText()) : 0f;
                    q4 = tfEditFourthQuarter.getText().length()>0 ? Double.parseDouble(tfEditFourthQuarter.getText()) : 0f;

                    gwa = (q1+q2+q3+q4)/4;

                    tfEditGwa.setText(String.valueOf(df.format(gwa)));
                    tfEvaluation.setText(getEvaluation(gwa));
                } catch (Exception e) {
                    playError();
                    System.err.println("Invalid Values entered");
                    tfEditGwa.setText("NaN");
                }
            }else{
                int q1,q2,q3,q4,gwa;
                try {
                    q1 = tfEditFirstQuarter.getText().length()>0 ? Integer.parseInt(tfEditFirstQuarter.getText()) : 0;
                    q2 = tfEditSecondQuarter.getText().length()>0 ? Integer.parseInt(tfEditSecondQuarter.getText()) : 0;
                    q3 = tfEditThirdQuarter.getText().length()>0 ? Integer.parseInt(tfEditThirdQuarter.getText()) : 0;
                    q4 = tfEditFourthQuarter.getText().length()>0 ? Integer.parseInt(tfEditFourthQuarter.getText()) : 0;

                    gwa = (q1+q2+q3+q4)/4;

                    tfEditGwa.setText(String.valueOf(gwa));
                    tfEvaluation.setText(getEvaluation(gwa));
                } catch (Exception e) {
                    playError();
                    System.err.println("Invalid Values entered");
                    tfEditGwa.setText("NaN");
                }
            }
        }
    }
    private void loadStatuses(JTextField quarterTextField,String status, JRadioButton [] radioButtonsInOrder, boolean disableByUserLevel){
        switch(status){
            case "Open":{
                quarterTextField.setEditable(true);
                radioButtonsInOrder[0].setSelected(true);
                break;
            }case "Submitted":{
                quarterTextField.setEditable(false);
                radioButtonsInOrder[1].setSelected(true);
                break;
            }case "Approved":{
                quarterTextField.setEditable(false);
                radioButtonsInOrder[2].setSelected(true);
                break;
            }case "Closed":{
                quarterTextField.setEditable(false);
                radioButtonsInOrder[3].setSelected(true);
                break;
            }
        }
        
        if(disableByUserLevel){
            switch(myVariables.getAccessLevel()){
                case 5:{
                    for(JRadioButton n : radioButtonsInOrder){
                        n.setEnabled(true);
                    }
                    break;
                }case 4:{
                    radioButtonsInOrder[0].setEnabled(true);    //Open
                    radioButtonsInOrder[1].setEnabled(false);   //Submitted
                    radioButtonsInOrder[2].setEnabled(true);   //Approved
                    radioButtonsInOrder[3].setEnabled(true);    //Closed
                    break;
                }case 2:{
                    if(status.contains("Closed")){
                        //Disable all
                        radioButtonsInOrder[0].setEnabled(false);
                        radioButtonsInOrder[1].setEnabled(false);
                        radioButtonsInOrder[2].setEnabled(false);
                        radioButtonsInOrder[3].setEnabled(false);
                    }else{
                        radioButtonsInOrder[0].setEnabled(true);
                        radioButtonsInOrder[1].setEnabled(true);
                        radioButtonsInOrder[2].setEnabled(true);
                        radioButtonsInOrder[3].setEnabled(false);
                    }
                    break;
                }case 1:{
                    for(JRadioButton n : radioButtonsInOrder){
                        n.setEnabled(false);
                    }
                    break;
                }
                default:{
                    break;
                }
            }
        }
    }
    private void enableDisableSaveButtonViaStatus(){
        //Disable save button if all statuses are not equal to open. Note: Works on Access Level 1 users only.
        if(!jRadioButton1.isSelected() && !jRadioButton5.isSelected() && !jRadioButton9.isSelected() && !jRadioButton13.isSelected() && myVariables.getAccessLevel()==1){
            btnSaveGradeChanges.setEnabled(false);
        }else{
            btnSaveGradeChanges.setEnabled(true);
        }
    }
    private void loadStatusRadioBtns(String statuses){
        JRadioButton [][] radioSets = {
            new JRadioButton[] {jRadioButton17,jRadioButton18,jRadioButton19,jRadioButton20},
            new JRadioButton[] {jRadioButton21,jRadioButton22,jRadioButton23,jRadioButton24},
            new JRadioButton[] {jRadioButton25,jRadioButton26,jRadioButton27,jRadioButton28},
            new JRadioButton[] {jRadioButton29,jRadioButton30,jRadioButton31,jRadioButton32},
        };
        ButtonGroup [] radioGroups = {q1StatusGroup,q2StatusGroup,q3tatusGroup,q4StatusGroup};
        
        if(statuses == null){
            
            //Disable & uncheck all
            for (int n = 0; n < radioSets.length; n++) {
                radioGroups[n].clearSelection();
                for (int x = 0; x < 4; x++) {
                    radioSets[n][x].setEnabled(false);
                }
            }
            showEvaluation(null);
            btnSaveChangesCurrent.setEnabled(false);
        } else {
            String [] status = statuses.split(":");
            
            //Check Based on status
            for (int n = 0; n < radioSets.length; n++) {
                switch (status[n]){
                    case "Open":{
                        radioSets[n][0].setSelected(true); break;
                    }case "Submitted":{
                        radioSets[n][1].setSelected(true); break;
                    }case "Approved":{
                        radioSets[n][2].setSelected(true); break;
                    }case "Closed":{
                        radioSets[n][3].setSelected(true); break;
                    }
                }
            }
            showEvaluation(statuses);
            enableDisableRadioBtnsByUserType();
        }
    }
    private String retrieveCheckedStatuses(int row, boolean checkForSubmittedGrades ){
        String status [] = new String[4];
        String previousStatuses [] = enrolledStudentsTable1.getValueAt(row, 12).toString().split(":");
        
        JRadioButton [][] radioSets = {
            new JRadioButton[] {jRadioButton17,jRadioButton18,jRadioButton19,jRadioButton20},
            new JRadioButton[] {jRadioButton21,jRadioButton22,jRadioButton23,jRadioButton24},
            new JRadioButton[] {jRadioButton25,jRadioButton26,jRadioButton27,jRadioButton28},
            new JRadioButton[] {jRadioButton29,jRadioButton30,jRadioButton31,jRadioButton32},
        };
        int rbIndexToUpdate = 0;
        if(rbQuarter1.isSelected())
            rbIndexToUpdate = 0;
        if(rbQuarter2.isSelected())
            rbIndexToUpdate = 1;
        if(rbQuarter3.isSelected())
            rbIndexToUpdate = 2;
        if(rbQuarter4.isSelected())
            rbIndexToUpdate = 3;
        
        for(int n=0;n<radioSets.length;n++){
            if(radioSets[n][0].isSelected()){   //Open
                //Override and Set to submitted if user is an ADVISER_USER and Column has a value
                System.err.println("Open selected");
                
                String gradeValue = enrolledStudentsTable1.getValueAt(row, n+7).toString().trim();
                
                if(rbAllQuarters.isSelected()){
                    if(checkForSubmittedGrades){
                        if(gradeValue == null){
                            status[n] = "Open";
                        } else {
                            try {                        
                                Integer.parseInt(gradeValue);
                                status[n] = "Submitted";
                            } catch (NumberFormatException e) {
                                status[n] = "Open";
                            }
                        }
                    }else{
                        status[n] = "Open";
                    }
                }else{
                    if(n == rbIndexToUpdate){
                        if(checkForSubmittedGrades){
                            if(gradeValue == null){
                                status[n] = "Open";
                            } else {
                                try {                        
                                    Integer.parseInt(gradeValue);
                                    status[n] = "Submitted";
                                } catch (NumberFormatException e) {
                                    status[n] = "Open";
                                }
                            }
                        }else{
                            status[n] = "Open";
                        }
                    }else {
                        status[n] = "Open";
                    }
                }
            }if(radioSets[n][1].isSelected()){  //Submitted
                status[n] = "Submitted";continue;
            }if(radioSets[n][2].isSelected()){  //Approved
                status[n] = "Approved";continue;
            }if(radioSets[n][3].isSelected()){  //Closed
                status[n] = "Closed";
            }
        }
        String finalStatus = status[0]+":"+status[1]+":"+status[2]+":"+status[3]+":"+previousStatuses[4]+":";
        
        System.out.println("New Status: " + finalStatus);
        return finalStatus;
    }
    
    private String retrieveStatuses(){
        String status [] = new String[4];
        JTextField [] textFields = {tfEditFirstQuarter,tfEditSecondQuarter,tfEditThirdQuarter,tfEditFourthQuarter};
        JRadioButton [][] radioSets = {
            new JRadioButton[] {jRadioButton1,jRadioButton2,jRadioButton3,jRadioButton4},
            new JRadioButton[] {jRadioButton5,jRadioButton6,jRadioButton7,jRadioButton8},
            new JRadioButton[] {jRadioButton9,jRadioButton10,jRadioButton11,jRadioButton12},
            new JRadioButton[] {jRadioButton13,jRadioButton14,jRadioButton15,jRadioButton16},
        };
        for(int n=0;n<radioSets.length;n++){
            if(radioSets[n][0].isSelected()){   //Open
                //Override and Set to submitted if user is an ADVISER_USER and Textfield has a value
                if(myVariables.getAccessLevel() == 1 && textFields[n].getText().trim().length() > 0){
                    status[n] = "Submitted";
                }else{
                    status[n] = "Open";
                }continue;
            }if(radioSets[n][1].isSelected()){  //Submitted
                status[n] = "Submitted";continue;
            }if(radioSets[n][2].isSelected()){  //Approved
                status[n] = "Approved";continue;
            }if(radioSets[n][3].isSelected()){  //Closed
                status[n] = "Closed";
            }
        }
        String finalStatus = status[0]+":"+status[1]+":"+status[2]+":"+status[3]+":"+tfEvaluation.getText()+":";
        System.err.println(finalStatus);
        
        return finalStatus;
    }
    private void hideElementsByAccessLevel(){
        //default 2 & 5 - to hide my managed subjects 
        if(myVariables.getAccessLevel() != 2 && myVariables.getAccessLevel() != 5){
            btnMyManagedSubjects.setVisible(false);
        }
        if(myVariables.getAccessLevel() != 4 && myVariables.getAccessLevel() != 5){
            btnImportFromSf10.setVisible(false);
        }
    }
    private void refreshAssignedSubjects(boolean notifyIfEmpty){
        if(myVariables.getAccessLevel() != 2 && myVariables.getAccessLevel() != 5){
            System.err.println("Not a Department Head or Admin. Skipping");
            return;
        }
        String userId = String.valueOf(myVariables.getUserLoggedInId());
        
        String [] result = my.return_values("*", "userdetails", "WHERE userId='"+userId+"'", myVariables.getUsersPersonalInfoOrder());
        
        if(result != null){
            String assignedSubjects = "";
            assignedSubjects = my.getValueAtColumn(result[0], 9);
            if(assignedSubjects.contains("NONE")){
                 if(notifyIfEmpty){
                     Toolkit.getDefaultToolkit().beep();
                    my.showMessage("There are no subjects assigned to you. Try refreshing again.\nIf the problem persists, please consult your Curruculum Head if you think this is an error.", JOptionPane.WARNING_MESSAGE);
                }
                return;
            }
            
            assignedSubjects = assignedSubjects.replace(":", ",");
            int length = assignedSubjects.length();
            
            if(assignedSubjects.charAt(length-1) == ','){
                assignedSubjects = assignedSubjects.substring(0, length-1);
            }
            
            String [] subjects = my.return_values("*", "subjects", "WHERE id IN ("+assignedSubjects+")", myVariables.getSubjectOrder());
            
            if(subjects != null){
                my.clear_table_rows(assignedSubjectsTable);
                for(String n : subjects){
                    my.add_table_row(n, assignedSubjectsTable);
                }
            }else{
                if(notifyIfEmpty){
                    Toolkit.getDefaultToolkit().beep();
                    my.showMessage("You have no subjects assigned to you. Try refreshing again.\nIf the problem persists, please consult your Curruculum Head if you think this is an error.", JOptionPane.WARNING_MESSAGE);
                }
            }
        }else{
            if(notifyIfEmpty){
                Toolkit.getDefaultToolkit().beep();
                my.showMessage("You have no subjects assigned to you. Try refreshing again.\nIf the problem persists, please consult your Curruculum Head if you think this is an error.", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    
    private void loadStudentsAndGrades(){
        int row = assignedTeacherTable.getSelectedRow();
        
        if(row == -1){
            Toolkit.getDefaultToolkit().beep();
            my.showMessage("No Section Selected.", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String sectionId = assignedTeacherTable.getValueAt(row, 1).toString();
        String adviserId = assignedTeacherTable.getValueAt(row, 3).toString();
        String subjectId = assignedTeacherTable.getValueAt(row, 6).toString();
        
        loadStatusRadioBtns(null);
        lbEvaluation.setText("-- Select Student --");
        
        my.runMainThread(
            0,
            new JTable[]{enrolledStudentsTable1},
            new String[]{sectionId,adviserId,subjectId},
            null,
            new JButton[]{btnRefreshStudents},
            null,
            null
        );
        
        enableDisableGlobalBtnsByUserType();
        btnSaveChangesCurrent.setEnabled(false);
    }
    private void enableDisableGlobalBtnsByUserType(){
        JButton adviserBtns [] = {btnAdvSelected, btnAdvAll};
        JButton depHeadBtns [] = {btnDphSelected, btnDphAll};
        JButton registrarBtns [] = {btnRgrSelected, btnRgrAll};
        
        boolean advisers,depHeads,registrar;
        
        advisers = myVariables.getAccessLevel() == 1 || myVariables.getAccessLevel() >= 4 ? true : false;
        depHeads = myVariables.getAccessLevel() == 2 || myVariables.getAccessLevel() == 5? true : false;
        registrar = myVariables.getAccessLevel() >= 4 ? true : false;
        
        for(int n=0;n<2;n++){
            adviserBtns[n].setEnabled(advisers);
            depHeadBtns[n].setEnabled(depHeads);
            registrarBtns[n].setEnabled(registrar);
        }
    }
    private void enableDisableRadioBtnsByUserType(){
        //System.err.println("Enabling Radio Btns "+ myVariables.getAccessLevel());
        JRadioButton [][] radioSets = {
            new JRadioButton[] {jRadioButton17,jRadioButton18,jRadioButton19,jRadioButton20},
            new JRadioButton[] {jRadioButton21,jRadioButton22,jRadioButton23,jRadioButton24},
            new JRadioButton[] {jRadioButton25,jRadioButton26,jRadioButton27,jRadioButton28},
            new JRadioButton[] {jRadioButton29,jRadioButton30,jRadioButton31,jRadioButton32},
        };
        
        for(int n=0;n<radioSets.length;n++){
            switch(myVariables.getAccessLevel()){
                case 1:{
                    radioSets[n][0].setEnabled(false);
                    radioSets[n][1].setEnabled(false);
                    radioSets[n][2].setEnabled(false);
                    radioSets[n][3].setEnabled(false);
                    break;
                }case 2:{
                    radioSets[n][0].setEnabled(false);
                    radioSets[n][1].setEnabled(true);
                    radioSets[n][2].setEnabled(true);
                    radioSets[n][3].setEnabled(false);
                    break;
                }case 3:{
                    radioSets[n][0].setEnabled(true);
                    radioSets[n][1].setEnabled(true);
                    radioSets[n][2].setEnabled(true);
                    radioSets[n][3].setEnabled(true);
                    break;
                }case 4:{
                    radioSets[n][0].setEnabled(true);
                    radioSets[n][1].setEnabled(false);
                    radioSets[n][2].setEnabled(true);
                    radioSets[n][3].setEnabled(true);
                    break;
                }case 5:{
                    radioSets[n][0].setEnabled(true);
                    radioSets[n][1].setEnabled(true);
                    radioSets[n][2].setEnabled(true);
                    radioSets[n][3].setEnabled(true);
                    break;
                }
            }
        }
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
            playError();
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
            jScrollPane2,jScrollPane3
        };
        
        int scrollSpeed = 100;
        
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
            my.hideColumns(enrolledStudentsTable, new int [] {0,1,5});
            my.hideColumns(enrolledStudentsTable1, new int [] {0,1,5,6}); // 12 is status column
            my.hideColumns(assignedSubjectsTable, new int [] {0});
        }
        
        //Set table fonts
        JTable tables [] = {
            assignedTeacherTable,
            enrolledStudentsTable,
            enrolledStudentsTable1,
            assignedSubjectsTable,
            
        };
        //customizeTableColumnColors(sf1SectionTable, new int [] {0,1,2,3}, Color.RED,Color.WHITE,new Font("Segoe UI",Font.PLAIN,11),true);
        //customHeaders(sf1SectionTable, new int []{0,1,2,3}, Color.RED, Color.WHITE, new Font("Comic Sans MS", Font.BOLD, 12), true);
        for(int n=0;n<tables.length;n++){
            tables[n].getTableHeader().setFont(myVariables.COLUMN_HEADER_FONT);
            tables[n].setFont(myVariables.COLUMN_FONT);
            
            tables[n].setSelectionBackground(new Color(203,184,160));
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
        mainTab.add("View Students",viewStudentsTab2);
        
        mainTab.setFont(myVariables.TAB_HEADER_FONT);
    }
    private void loadTabIcons(){
        /*Icon tabIcons [] = {
            my.getImgIcn(myVariables.getSectionsIcon()),
            my.getImgIcn(myVariables.getViewStudentsIcon()),
        };
        
        for(int n=0;n<tabIcons.length;n++){
            mainTab.setIconAt(n,tabIcons[n]);
        }*/
        
        my.remove_multiple_tabs(mainTab, new int [] {1,2});
    }
    private void loadColoredButtons(){
        JButton buttons [] = {
            //Select Section
            btnSearchSection,
            //View Students
            btnEditGrades,
            btnSearchEnrolledStudent,
            btnSaveChangesCurrent,
            //Select Quarter
            btnSelectQuarter,
            //Approval
            btnAdvSelected,btnAdvAll,
            btnDphSelected,btnDphAll,
            btnRgrSelected,btnRgrAll,
            //Edit Grades Dialog
            btnSaveGradeChanges,
        };
        
        JButton lightButtons [] = { //kani na buttons sa side bar nani
            btnMyManagedSubjects,btnImportFromSf10,btnManageGrades,
        };
        
        JButton wht2buttons [] = {
            //My Assigned Subjects Dialog
            btnRefresh,
        };
        
        JButton whtButtons [] = {
            btnRefreshStudents,
        };
        
        Cursor tempC;
        for(int n=0;n<buttons.length;n++){
            buttons[n].setUI(new custom_styledButtonIU());
            //buttons[n].setBackground(new Color(22,66,33));
            buttons[n].setBackground(new Color(249,239,227));
            buttons[n].setForeground(Color.decode("#3A3939"));            
            buttons[n].setFont(myVariables.BUTTON_FONT);
            //buttons[n].setCursor(my.getCursor(myVariables.getHandCursor()));
            buttons[n].setCursor(new Cursor(Cursor.HAND_CURSOR));
            buttons[n].setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
        
        for(int n=0;n<lightButtons.length;n++){ //side bar only tung pink
            lightButtons[n].setUI(new custom_styledSideBtn());
            //buttons[n].setBackground(new Color(22,66,33));
            buttons[n].setBackground(new Color(251,185,211));
            buttons[n].setForeground(Color.decode("#3A3939"));          
            lightButtons[n].setFont(poppins14);
            //buttons[n].setCursor(my.getCursor(myVariables.getHandCursor()));
            lightButtons[n].setCursor(new Cursor(Cursor.HAND_CURSOR));
            //lightButtons[n].setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
            //lightButtons[n].addActionListener(new changeonclick_buttonside(lightButtons[n]) {});
        }
        
        for(int n=0;n<whtButtons.length;n++){
            whtButtons[n].setUI(new custom_styledButtonIU());
            //buttons[n].setBackground(new Color(22,66,33));
            whtButtons[n].setBackground(new Color(255,255,255));
            whtButtons[n].setForeground(Color.decode("#3A3939"));            
            whtButtons[n].setFont(myVariables.BUTTON_FONT);
            //buttons[n].setCursor(my.getCursor(myVariables.getHandCursor()));
            whtButtons[n].setCursor(new Cursor(Cursor.HAND_CURSOR));
            whtButtons[n].setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }

        for(int n=0;n<wht2buttons.length;n++){
            wht2buttons[n].setUI(new custom_styledButtonIU());
            //buttons[n].setBackground(new Color(22,66,33));
            wht2buttons[n].setBackground(Color.WHITE);
            wht2buttons[n].setForeground(Color.BLACK);            
            wht2buttons[n].setFont(myVariables.BUTTON_FONT);
            //buttons[n].setCursor(my.getCursor(myVariables.getHandCursor()));
            wht2buttons[n].setCursor(new Cursor(Cursor.HAND_CURSOR));
            wht2buttons[n].setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
        
        btnImportFromSf10.setVisible(false);    // pang hide sa import button
        
    }
    private void loadLabels(){
        JLabel titleHeaderLabels [] = {
            jLabel35,jLabel36,jLabel37,jLabel38,jLabel39,
        };
        JLabel labels [] = {
            lbSearchResult,lbSearchResult1,lbMessage,
        };
        
        JLabel formsHeaderLabels [] = {
            jLabel2,jLabel3,jLabel12,jLabel13,jLabel14,
            jLabel18,jLabel23,lbQuarterSelect,
        };
        JLabel textFieldHeaderLabels [] = {
            lbDateUpdated,lbGradeStatus,jLabel5,jLabel6,jLabel7,jLabel8,jLabel9,lbSubjectName,
            jLabel1,jLabel4,jLabel10,jLabel11,jLabel15,lbRecordId,jLabel16,lbStatusOptions,jLabel17,
            jLabel19,lbSectionName2,jLabel21,lbSubjectName2,
            lbStatusOptions1,lbStatusOptions2,lbStatusOptions3,lbStatusOptions4,
            jLabel24,jLabel25,jLabel26,jLabel22,lbEvaluation,
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
            //jdcDate,jdcCustomDate,
        };
        JSpinner spinners [] = {
            //jsHours,jsMinutes
        };
        
        JTextField searchFields [] = {
            tfSearchTeacherLoad,tfSearchEnrolledStudent,
        };
        JTextField forms [] = {
            tfFirstQ,tfSecondQ,tfThirdQ,tfFourthQ,tfGeneralWeighedAverage,
            //Edit Grades Dialog
            tfEditFirstQuarter,tfEditSecondQuarter,tfEditThirdQuarter,tfEditFourthQuarter,
            tfEditGwa,tfEvaluation,
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
            //jcbMeridan,
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
        lbSearchResult.setForeground(new java.awt.Color(255,255,255));
        lbSearchResult.setText("Search using the search bar...");
        
        btnSearchSection.setBackground(new java.awt.Color(251,185,211));
        
        btnManageGrades.setFont(poppins14);
        btnMyManagedSubjects.setFont(poppins14);
        btnImportFromSf10.setFont(poppins14);
        
        jLabel30.setFont(poppins48);
        jLabel28.setFont(poppins19);
//        label1.setFont(poppins16);
////        label2.setFont(poppins16);
////        label3.setFont(poppins16);
//        
//        tab1.setBackground(new java.awt.Color(253,232,240));
//        tab2.setBackground(new java.awt.Color(251,185,211));
//        tab3.setBackground(new java.awt.Color(251,185,211));
        
        
        
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable assignedSubjectsTable;
    private javax.swing.JTable assignedTeacherTable;
    private javax.swing.JButton btnAdvAll;
    private javax.swing.JButton btnAdvSelected;
    private javax.swing.JButton btnDphAll;
    private javax.swing.JButton btnDphSelected;
    private javax.swing.JButton btnEditGrades;
    private javax.swing.JButton btnImportFromSf10;
    private javax.swing.JButton btnManageGrades;
    private javax.swing.JButton btnMyManagedSubjects;
    private javax.swing.JButton btnOpenFileExplorer;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnRefreshStudents;
    private javax.swing.JButton btnRgrAll;
    private javax.swing.JButton btnRgrSelected;
    private javax.swing.JButton btnSaveChangesCurrent;
    private javax.swing.JButton btnSaveGradeChanges;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSearchEnrolledStudent;
    private javax.swing.JButton btnSearchSection;
    private javax.swing.JButton btnSelectQuarter;
    private javax.swing.JPanel card1;
    private javax.swing.JPanel card2;
    private javax.swing.JPanel card3;
    private javax.swing.JPanel cards;
    private javax.swing.JCheckBox cbAllowDecimalValues;
    private javax.swing.ButtonGroup computationOptionGroup;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JPanel contentsPanel;
    private javax.swing.JPanel editGradeDialog;
    private javax.swing.JTable enrolledStudentsTable;
    private javax.swing.JTable enrolledStudentsTable1;
    private javax.swing.JPanel gradeDetailsTab;
    private javax.swing.JTabbedPane gradeTabs;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JPanel importDialog;
    private javax.swing.JTable importedGradeDetailsTable;
    private javax.swing.JTable importedGradesTable;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton10;
    private javax.swing.JRadioButton jRadioButton11;
    private javax.swing.JRadioButton jRadioButton12;
    private javax.swing.JRadioButton jRadioButton13;
    private javax.swing.JRadioButton jRadioButton14;
    private javax.swing.JRadioButton jRadioButton15;
    private javax.swing.JRadioButton jRadioButton16;
    private javax.swing.JRadioButton jRadioButton17;
    private javax.swing.JRadioButton jRadioButton18;
    private javax.swing.JRadioButton jRadioButton19;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton20;
    private javax.swing.JRadioButton jRadioButton21;
    private javax.swing.JRadioButton jRadioButton22;
    private javax.swing.JRadioButton jRadioButton23;
    private javax.swing.JRadioButton jRadioButton24;
    private javax.swing.JRadioButton jRadioButton25;
    private javax.swing.JRadioButton jRadioButton26;
    private javax.swing.JRadioButton jRadioButton27;
    private javax.swing.JRadioButton jRadioButton28;
    private javax.swing.JRadioButton jRadioButton29;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton30;
    private javax.swing.JRadioButton jRadioButton31;
    private javax.swing.JRadioButton jRadioButton32;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox<String> jcbFileFormats;
    private javax.swing.JComboBox<String> jcbSchoolYear1;
    private javax.swing.JTabbedPane jtbImportTabs;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lbDateUpdated;
    private javax.swing.JLabel lbEvaluation;
    private javax.swing.JLabel lbGradeStatus;
    private javax.swing.JLabel lbImportedGeneralAverage;
    private javax.swing.JLabel lbLoggedInUser;
    private javax.swing.JLabel lbLoggedInUser1;
    private javax.swing.JLabel lbMessage;
    private javax.swing.JLabel lbQuarterSelect;
    private javax.swing.JLabel lbRecordId;
    private javax.swing.JLabel lbSearchResult;
    private javax.swing.JLabel lbSearchResult1;
    private javax.swing.JLabel lbSearchResult2;
    private javax.swing.JLabel lbSectionName2;
    private javax.swing.JLabel lbStatusOptions;
    private javax.swing.JLabel lbStatusOptions1;
    private javax.swing.JLabel lbStatusOptions2;
    private javax.swing.JLabel lbStatusOptions3;
    private javax.swing.JLabel lbStatusOptions4;
    private javax.swing.JLabel lbSubjectName;
    private javax.swing.JLabel lbSubjectName2;
    private javax.swing.JPanel left;
    private javax.swing.JPanel left2;
    private javax.swing.JMenuItem logout;
    private javax.swing.JTabbedPane mainTab;
    private javax.swing.JMenu menu;
    private javax.swing.JPanel myAssignedSubjectsDialog;
    private javax.swing.JProgressBar pbProgressBar;
    private javax.swing.ButtonGroup q1StatusGroup;
    private javax.swing.ButtonGroup q2StatusGroup;
    private javax.swing.ButtonGroup q3tatusGroup;
    private javax.swing.ButtonGroup q4StatusGroup;
    private javax.swing.JRadioButton rbAllQuarters;
    private javax.swing.JRadioButton rbAutomatic;
    private javax.swing.JRadioButton rbManual;
    private javax.swing.JRadioButton rbQuarter1;
    private javax.swing.JRadioButton rbQuarter2;
    private javax.swing.JRadioButton rbQuarter3;
    private javax.swing.JRadioButton rbQuarter4;
    private javax.swing.JPanel right;
    private javax.swing.JPanel right2;
    private javax.swing.JPanel selectQuarterDialog;
    private javax.swing.ButtonGroup selectQuarterGroup;
    private javax.swing.JPanel selectSectionTab;
    private javax.swing.JPanel selectSf10Tab;
    private javax.swing.JPanel selectStudentTab;
    private javax.swing.JTable studentTable;
    private javax.swing.JTextField tfEditFirstQuarter;
    private javax.swing.JTextField tfEditFourthQuarter;
    private javax.swing.JTextField tfEditGwa;
    private javax.swing.JTextField tfEditSecondQuarter;
    private javax.swing.JTextField tfEditThirdQuarter;
    private javax.swing.JTextField tfEvaluation;
    private javax.swing.JTextField tfFileLocation;
    private javax.swing.JTextField tfFirstQ;
    private javax.swing.JTextField tfFourthQ;
    private javax.swing.JTextField tfGeneralWeighedAverage;
    private javax.swing.JTextField tfSearchEnrolledStudent;
    private javax.swing.JTextField tfSearchStudent;
    private javax.swing.JTextField tfSearchTeacherLoad;
    private javax.swing.JTextField tfSecondQ;
    private javax.swing.JTextField tfThirdQ;
    private javax.swing.JPanel viewStudentsTab;
    private javax.swing.JPanel viewStudentsTab2;
    // End of variables declaration//GEN-END:variables

}
