/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mahPackage2;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;
import javazoom.jl.player.Player;

/**
 *
 * @author Syd
 */
public class dashBoard extends javax.swing.JFrame {
    myFunctions my;
    /**
     * Creates new form dashboard2
     */
    Font myPReg= null;
    Font myPSemiBold= null;
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
        
        my = new myFunctions();
        initComponents();
        myInitComponents();
        loadTabs();
        loadTabIcons();
        setTableColoumnWidth();
        
        menu.setText(myVariables.getUserLoggedInName());
                
        menu.setFont(myPReg);
        
//        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icons/enrollmentIcon.png")));
        
        loadColoredButtons();
        loadLabels();
        
        loadTextFields();
        sortTables();
        
        setScrollSpeeds();
        loadYearDropDowns(12);
        
        setCustomFontsForOtherViews();
        
        tab1.setBackground(Color.decode("#FDE8F0"));
        tab2.setBackground(Color.decode("#FBB9D3"));
        tab3.setBackground(Color.decode("#FBB9D3"));
        
        lbUsername.setText(myVariables.getUserLoggedInName());
        lbAccess.setText(myVariables.getAccessLevelName(-1));;
        
        try{
            myPReg = Font.createFont(Font.TRUETYPE_FONT,new File("fonts/Poppins-Regular.ttf"));
            myPSemiBold = Font.createFont(Font.TRUETYPE_FONT,new File("fonts/Poppins-SemiBold.ttf"));

        }catch (Exception e){
            System.out.println("Error loading custom font..");
        }
        
        
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

        kGradientPanel1 = new keeptoo.KGradientPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        lbWelcome = new javax.swing.JLabel();
        lbUsername = new javax.swing.JLabel();
        lbAccess = new javax.swing.JLabel();
        tab1 = new javax.swing.JPanel();
        tab1Label = new javax.swing.JLabel();
        tab3 = new javax.swing.JPanel();
        tab3Label = new javax.swing.JLabel();
        tab2 = new javax.swing.JPanel();
        tab2Label = new javax.swing.JLabel();
        myCards = new javax.swing.JPanel();
        manageSectionsTab = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        left = new javax.swing.JPanel();
        lbSearchResult = new javax.swing.JLabel();
        tfSearchSection = new javax.swing.JTextField();
        btnSearchSection = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        sectionsTable = new javax.swing.JTable();
        jcbSchoolYear4 = new javax.swing.JComboBox<>();
        right = new javax.swing.JPanel();
        sectionsTab = new javax.swing.JTabbedPane();
        addNewSectionPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfSectionName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        usersTable = new javax.swing.JTable();
        btnSearchUser = new javax.swing.JButton();
        tfSearchUser = new javax.swing.JTextField();
        btnSearchLoad = new javax.swing.JButton();
        tfSearchLoad = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        loadsTable = new javax.swing.JTable();
        btnAddNewSection = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jcbSchoolYear = new javax.swing.JComboBox<>();
        editSectionPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tfSectionName1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        usersTable1 = new javax.swing.JTable();
        btnSearchUser1 = new javax.swing.JButton();
        tfSearchUser1 = new javax.swing.JTextField();
        btnSearchLoad1 = new javax.swing.JButton();
        tfSearchLoad1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        loadsTable1 = new javax.swing.JTable();
        btnSaveSectionChanges = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lbSectionId = new javax.swing.JLabel();
        jcbSchoolYear1 = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        manageEnroleesTab = new javax.swing.JPanel();
        jSplitPane2 = new javax.swing.JSplitPane();
        left1 = new javax.swing.JPanel();
        jcbSchoolYear2 = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        enrollmentTable = new javax.swing.JTable();
        btnSearchStudent = new javax.swing.JButton();
        tfSearchStudent = new javax.swing.JTextField();
        lbSearchResult1 = new javax.swing.JLabel();
        right1 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        enrollStudentPanel = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel24 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfSearchStudent1 = new javax.swing.JTextField();
        btnSearchStudent1 = new javax.swing.JButton();
        jScrollPane15 = new javax.swing.JScrollPane();
        studentTable = new javax.swing.JTable();
        jScrollPane16 = new javax.swing.JScrollPane();
        sectionsTable1 = new javax.swing.JTable();
        tfSearchSection1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btnSearchSection1 = new javax.swing.JButton();
        btnEnrollStudent = new javax.swing.JButton();
        assignSubjectTeacherTab = new javax.swing.JPanel();
        jSplitPane3 = new javax.swing.JSplitPane();
        left2 = new javax.swing.JPanel();
        jcbSchoolYear3 = new javax.swing.JComboBox<>();
        lbSearchResult2 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        sectionsTable2 = new javax.swing.JTable();
        tfSearchSection2 = new javax.swing.JTextField();
        btnSearchSection2 = new javax.swing.JButton();
        right2 = new javax.swing.JPanel();
        subjectTeacherTab = new javax.swing.JTabbedPane();
        detailsTab = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        assignedTeacherTable = new javax.swing.JTable();
        btnSaveSubjectTeacherChanges = new javax.swing.JButton();
        btnEditSubjectTeacher = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        subjectTable = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        btnRefreshList = new javax.swing.JButton();
        selectTeacherTab = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jPanel9 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        tfSearchUser2 = new javax.swing.JTextField();
        btnSearchUser2 = new javax.swing.JButton();
        jScrollPane17 = new javax.swing.JScrollPane();
        usersTable2 = new javax.swing.JTable();
        btnAssignTeacher = new javax.swing.JButton();
        btnNone = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu = new javax.swing.JMenu();
        logout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Dashboard");
        setIconImage(my.getImgIcn(myVariables.getEnrollmentWindowIcon()).getImage()
        );
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                logoutHandler(evt);
            }
        });

        kGradientPanel1.setkEndColor(new java.awt.Color(249, 239, 227));
        kGradientPanel1.setkStartColor(new java.awt.Color(249, 239, 227));

        jPanel10.setBackground(new java.awt.Color(251, 185, 211));
        jPanel10.setMinimumSize(new java.awt.Dimension(270, 723));
        jPanel10.setPreferredSize(new java.awt.Dimension(270, 723));

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(58, 57, 57));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("SHS");

        jLabel96.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(58, 57, 57));
        jLabel96.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel96.setText("ENROLLMENT SYSTEM");

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage2/icons/cbshs.png"))); // NOI18N

        lbWelcome.setBackground(new java.awt.Color(255, 255, 255));
        lbWelcome.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lbWelcome.setForeground(new java.awt.Color(58, 57, 57));
        lbWelcome.setText("Welcome");

        lbUsername.setBackground(new java.awt.Color(255, 255, 255));
        lbUsername.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lbUsername.setForeground(new java.awt.Color(58, 57, 57));
        lbUsername.setText("Username");

        lbAccess.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lbAccess.setForeground(new java.awt.Color(58, 57, 57));
        lbAccess.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbAccess.setText("Access Level");

        tab1.setMinimumSize(new java.awt.Dimension(147, 49));
        tab1.setPreferredSize(new java.awt.Dimension(147, 49));
        tab1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab1MouseClicked(evt);
            }
        });

        tab1Label.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tab1Label.setForeground(new java.awt.Color(58, 57, 57));
        tab1Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage2/icons/icons8_page_20px.png"))); // NOI18N
        tab1Label.setText("Manage Section");

        javax.swing.GroupLayout tab1Layout = new javax.swing.GroupLayout(tab1);
        tab1.setLayout(tab1Layout);
        tab1Layout.setHorizontalGroup(
            tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(tab1Label)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tab1Layout.setVerticalGroup(
            tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(tab1Label)
                .addContainerGap())
        );

        tab3.setBackground(new java.awt.Color(251, 185, 211));
        tab3.setMinimumSize(new java.awt.Dimension(147, 49));
        tab3.setPreferredSize(new java.awt.Dimension(147, 49));
        tab3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab3MouseClicked(evt);
            }
        });

        tab3Label.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tab3Label.setForeground(new java.awt.Color(58, 57, 57));
        tab3Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage2/icons/icons8_audit_20px.png"))); // NOI18N
        tab3Label.setText("Assign Subject Teacher");

        javax.swing.GroupLayout tab3Layout = new javax.swing.GroupLayout(tab3);
        tab3.setLayout(tab3Layout);
        tab3Layout.setHorizontalGroup(
            tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(tab3Label)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tab3Layout.setVerticalGroup(
            tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab3Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(tab3Label)
                .addContainerGap())
        );

        tab2.setBackground(new java.awt.Color(251, 185, 211));
        tab2.setMinimumSize(new java.awt.Dimension(147, 49));
        tab2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab2MouseClicked(evt);
            }
        });

        tab2Label.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tab2Label.setForeground(new java.awt.Color(58, 57, 57));
        tab2Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage2/icons/icons8_user_groups_skin_type_7_20px_1.png"))); // NOI18N
        tab2Label.setText("Manage Enrolee");

        javax.swing.GroupLayout tab2Layout = new javax.swing.GroupLayout(tab2);
        tab2.setLayout(tab2Layout);
        tab2Layout.setHorizontalGroup(
            tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(tab2Label)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tab2Layout.setVerticalGroup(
            tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab2Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(tab2Label)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(tab3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
            .addComponent(tab1, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
            .addComponent(jLabel96, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
            .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel17))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbAccess))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(tab2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel96)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tab1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tab2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tab3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbUsername)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbAccess)
                .addGap(28, 28, 28))
        );

        myCards.setLayout(new java.awt.CardLayout());

        jSplitPane1.setBorder(null);
        jSplitPane1.setDividerLocation(700);

        left.setBackground(new java.awt.Color(203, 184, 160));

        lbSearchResult.setForeground(new java.awt.Color(255, 255, 255));
        lbSearchResult.setText("Search using the search bar...");

        tfSearchSection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchSectionHandler(evt);
            }
        });

        btnSearchSection.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage2/icons/search_24px.png"))); // NOI18N
        btnSearchSection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchSectionHandler(evt);
            }
        });

        sectionsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Section Name", "Adv ID", "Adviser", "Gender", "Lod ID", "Subject Load", "Grade Level", "School Year"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        sectionsTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        sectionsTable.getTableHeader().setReorderingAllowed(false);
        sectionsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sectionsTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(sectionsTable);
        if (sectionsTable.getColumnModel().getColumnCount() > 0) {
            sectionsTable.getColumnModel().getColumn(1).setResizable(false);
            sectionsTable.getColumnModel().getColumn(1).setPreferredWidth(200);
            sectionsTable.getColumnModel().getColumn(3).setPreferredWidth(200);
            sectionsTable.getColumnModel().getColumn(4).setResizable(false);
            sectionsTable.getColumnModel().getColumn(4).setPreferredWidth(80);
            sectionsTable.getColumnModel().getColumn(6).setPreferredWidth(100);
            sectionsTable.getColumnModel().getColumn(7).setResizable(false);
            sectionsTable.getColumnModel().getColumn(7).setPreferredWidth(100);
            sectionsTable.getColumnModel().getColumn(8).setResizable(false);
            sectionsTable.getColumnModel().getColumn(8).setPreferredWidth(150);
        }

        jcbSchoolYear4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2019", "2020" }));

        javax.swing.GroupLayout leftLayout = new javax.swing.GroupLayout(left);
        left.setLayout(leftLayout);
        leftLayout.setHorizontalGroup(
            leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(leftLayout.createSequentialGroup()
                        .addComponent(lbSearchResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbSchoolYear4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfSearchSection, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearchSection)))
                .addContainerGap())
        );
        leftLayout.setVerticalGroup(
            leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(tfSearchSection, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbSearchResult)
                            .addComponent(btnSearchSection)))
                    .addComponent(jcbSchoolYear4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane1.setLeftComponent(left);

        addNewSectionPanel.setBackground(new java.awt.Color(255, 255, 204));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 204));
        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setOpaque(false);

        jPanel1.setBackground(new java.awt.Color(249, 239, 227));

        jPanel4.setBackground(new java.awt.Color(203, 184, 160));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Add New Section");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setText("Section Name");

        jLabel6.setText("Select Adviser");

        usersTable.setAutoCreateRowSorter(true);
        usersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID (H)", "Name", "Gender", "Access Level"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        usersTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        usersTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane11.setViewportView(usersTable);
        if (usersTable.getColumnModel().getColumnCount() > 0) {
            usersTable.getColumnModel().getColumn(1).setPreferredWidth(200);
            usersTable.getColumnModel().getColumn(2).setResizable(false);
            usersTable.getColumnModel().getColumn(2).setPreferredWidth(100);
            usersTable.getColumnModel().getColumn(3).setResizable(false);
            usersTable.getColumnModel().getColumn(3).setPreferredWidth(100);
        }

        btnSearchUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage2/icons/search_24px.png"))); // NOI18N
        btnSearchUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchUserHandler(evt);
            }
        });

        tfSearchUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchUserHandler(evt);
            }
        });

        btnSearchLoad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage2/icons/search_24px.png"))); // NOI18N
        btnSearchLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchLoadHandler(evt);
            }
        });

        tfSearchLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchLoadHandler(evt);
            }
        });

        jLabel7.setText("Select Subject Load");

        loadsTable.setAutoCreateRowSorter(true);
        loadsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID (H)", "Name", "Grade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        loadsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane12.setViewportView(loadsTable);
        if (loadsTable.getColumnModel().getColumnCount() > 0) {
            loadsTable.getColumnModel().getColumn(1).setPreferredWidth(200);
            loadsTable.getColumnModel().getColumn(2).setResizable(false);
        }

        btnAddNewSection.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage2/icons/icons8_add_16px.png"))); // NOI18N
        btnAddNewSection.setText("Add");
        btnAddNewSection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createNewSectionHandler(evt);
            }
        });

        jLabel11.setText("School Year");

        jcbSchoolYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2019", "2020" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 226, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddNewSection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(tfSearchLoad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearchLoad))
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(tfSearchUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearchUser))
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfSectionName, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jcbSchoolYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfSectionName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSearchUser)
                    .addComponent(tfSearchUser, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSearchLoad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfSearchLoad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbSchoolYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAddNewSection)
                .addContainerGap())
        );

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout addNewSectionPanelLayout = new javax.swing.GroupLayout(addNewSectionPanel);
        addNewSectionPanel.setLayout(addNewSectionPanelLayout);
        addNewSectionPanelLayout.setHorizontalGroup(
            addNewSectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
        );
        addNewSectionPanelLayout.setVerticalGroup(
            addNewSectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
        );

        sectionsTab.addTab("Add Section", addNewSectionPanel);

        editSectionPanel.setBackground(new java.awt.Color(255, 255, 204));

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 204));
        jScrollPane3.setBorder(null);
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setOpaque(false);

        jPanel2.setBackground(new java.awt.Color(249, 239, 227));

        jPanel5.setBackground(new java.awt.Color(203, 184, 160));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Edit Section");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel8.setText("Section Name");

        jLabel9.setText("Select Adviser");

        usersTable1.setAutoCreateRowSorter(true);
        usersTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID (H)", "Name", "Gender", "Access Level"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        usersTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        usersTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane13.setViewportView(usersTable1);
        if (usersTable1.getColumnModel().getColumnCount() > 0) {
            usersTable1.getColumnModel().getColumn(1).setResizable(false);
            usersTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
            usersTable1.getColumnModel().getColumn(2).setResizable(false);
            usersTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
            usersTable1.getColumnModel().getColumn(3).setResizable(false);
            usersTable1.getColumnModel().getColumn(3).setPreferredWidth(100);
        }

        btnSearchUser1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage2/icons/search_24px.png"))); // NOI18N
        btnSearchUser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchUserHandler1(evt);
            }
        });

        tfSearchUser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchUserHandler1(evt);
            }
        });

        btnSearchLoad1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage2/icons/search_24px.png"))); // NOI18N
        btnSearchLoad1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchLoadHandler1(evt);
            }
        });

        tfSearchLoad1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchLoadHandler1(evt);
            }
        });

        jLabel10.setText("Select Curriculum");

        loadsTable1.setAutoCreateRowSorter(true);
        loadsTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID (H)", "Name", "Grade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        loadsTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane14.setViewportView(loadsTable1);
        if (loadsTable1.getColumnModel().getColumnCount() > 0) {
            loadsTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
            loadsTable1.getColumnModel().getColumn(2).setResizable(false);
        }

        btnSaveSectionChanges.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage2/icons/icons8_save_16px.png"))); // NOI18N
        btnSaveSectionChanges.setText("Save Changes");
        btnSaveSectionChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveSectionChangesHandler(evt);
            }
        });

        jLabel3.setText("Section ID:");

        lbSectionId.setText("0");

        jcbSchoolYear1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2019", "2020" }));

        jLabel13.setText("School Year");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 271, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSaveSectionChanges, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(tfSearchLoad1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearchLoad1))
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(tfSearchUser1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearchUser1))
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfSectionName1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbSectionId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jcbSchoolYear1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfSectionName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSearchUser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfSearchUser1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSearchLoad1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfSearchLoad1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbSchoolYear1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSaveSectionChanges)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbSectionId))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(jPanel2);

        javax.swing.GroupLayout editSectionPanelLayout = new javax.swing.GroupLayout(editSectionPanel);
        editSectionPanel.setLayout(editSectionPanelLayout);
        editSectionPanelLayout.setHorizontalGroup(
            editSectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
        );
        editSectionPanelLayout.setVerticalGroup(
            editSectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
        );

        sectionsTab.addTab("Edit Section", editSectionPanel);

        javax.swing.GroupLayout rightLayout = new javax.swing.GroupLayout(right);
        right.setLayout(rightLayout);
        rightLayout.setHorizontalGroup(
            rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightLayout.createSequentialGroup()
                .addComponent(sectionsTab, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        rightLayout.setVerticalGroup(
            rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sectionsTab, javax.swing.GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
        );

        jSplitPane1.setRightComponent(right);

        javax.swing.GroupLayout manageSectionsTabLayout = new javax.swing.GroupLayout(manageSectionsTab);
        manageSectionsTab.setLayout(manageSectionsTabLayout);
        manageSectionsTabLayout.setHorizontalGroup(
            manageSectionsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
        manageSectionsTabLayout.setVerticalGroup(
            manageSectionsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );

        myCards.add(manageSectionsTab, "card4");

        jSplitPane2.setBorder(null);
        jSplitPane2.setDividerLocation(700);

        left1.setBackground(new java.awt.Color(203, 184, 160));
        left1.setMinimumSize(new java.awt.Dimension(442, 682));

        jcbSchoolYear2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2019", "2020" }));
        jcbSchoolYear2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbSchoolYear2ActionPerformed(evt);
            }
        });

        jScrollPane4.setBorder(null);
        jScrollPane4.setMinimumSize(new java.awt.Dimension(568, 616));
        jScrollPane4.setPreferredSize(new java.awt.Dimension(568, 616));

        enrollmentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "LRN", "Name", "Gender", "Section", "Adviser", "Curriculum", "Level", "School Year", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        enrollmentTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        enrollmentTable.setMaximumSize(new java.awt.Dimension(2147483647, 1000));
        enrollmentTable.setMinimumSize(new java.awt.Dimension(568, 616));
        enrollmentTable.setPreferredSize(new java.awt.Dimension(700, 616));
        enrollmentTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(enrollmentTable);
        if (enrollmentTable.getColumnModel().getColumnCount() > 0) {
            enrollmentTable.getColumnModel().getColumn(1).setPreferredWidth(100);
            enrollmentTable.getColumnModel().getColumn(3).setPreferredWidth(50);
            enrollmentTable.getColumnModel().getColumn(6).setPreferredWidth(50);
            enrollmentTable.getColumnModel().getColumn(7).setPreferredWidth(50);
            enrollmentTable.getColumnModel().getColumn(8).setPreferredWidth(70);
        }

        btnSearchStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage2/icons/search_24px.png"))); // NOI18N
        btnSearchStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchStudentHandler(evt);
            }
        });

        tfSearchStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchStudentHandler(evt);
            }
        });

        lbSearchResult1.setForeground(new java.awt.Color(255, 255, 255));
        lbSearchResult1.setText("Search using the search bar...");

        javax.swing.GroupLayout left1Layout = new javax.swing.GroupLayout(left1);
        left1.setLayout(left1Layout);
        left1Layout.setHorizontalGroup(
            left1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(left1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(left1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(left1Layout.createSequentialGroup()
                        .addComponent(lbSearchResult1, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbSchoolYear2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfSearchStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearchStudent)))
                .addContainerGap())
        );
        left1Layout.setVerticalGroup(
            left1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(left1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(left1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(left1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbSearchResult1)
                        .addComponent(btnSearchStudent))
                    .addComponent(jcbSchoolYear2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfSearchStudent))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane2.setLeftComponent(left1);

        enrollStudentPanel.setBackground(new java.awt.Color(255, 255, 204));

        jScrollPane5.setBorder(null);
        jScrollPane5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel24.setBackground(new java.awt.Color(249, 239, 227));

        jPanel6.setBackground(new java.awt.Color(203, 184, 160));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Enroll New Student");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel34)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel34)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Select Student");

        tfSearchStudent1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchStudentToEnrollHandler(evt);
            }
        });

        btnSearchStudent1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage2/icons/search_24px.png"))); // NOI18N
        btnSearchStudent1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchStudentToEnrollHandler(evt);
            }
        });

        jScrollPane15.setMinimumSize(new java.awt.Dimension(469, 419));

        studentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID (H)", "LRN", "Name", "Gender", "Curr. Grade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        studentTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        studentTable.setMinimumSize(new java.awt.Dimension(469, 419));
        studentTable.setPreferredSize(new java.awt.Dimension(700, 419));
        studentTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane15.setViewportView(studentTable);

        jScrollPane16.setMinimumSize(new java.awt.Dimension(469, 419));

        sectionsTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID (H)", "Name", "Adviser", "Grade", "S.Y."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        sectionsTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        sectionsTable1.setMinimumSize(new java.awt.Dimension(469, 419));
        sectionsTable1.setPreferredSize(new java.awt.Dimension(700, 419));
        sectionsTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane16.setViewportView(sectionsTable1);
        if (sectionsTable1.getColumnModel().getColumnCount() > 0) {
            sectionsTable1.getColumnModel().getColumn(3).setPreferredWidth(10);
            sectionsTable1.getColumnModel().getColumn(4).setPreferredWidth(10);
        }
        sectionsTable1.getAccessibleContext().setAccessibleDescription("");

        tfSearchSection1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchSectionToEnrollHandler(evt);
            }
        });

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Select Section");

        btnSearchSection1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage2/icons/search_24px.png"))); // NOI18N
        btnSearchSection1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchSectionToEnrollHandler(evt);
            }
        });

        btnEnrollStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage2/icons/icons8_add_16px.png"))); // NOI18N
        btnEnrollStudent.setText("Enroll");
        btnEnrollStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enrollStudentHandler(evt);
            }
        });

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(tfSearchStudent1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearchStudent1))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(tfSearchSection1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearchSection1))
                    .addComponent(btnEnrollStudent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSearchStudent1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfSearchStudent1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSearchSection1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfSearchSection1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 204, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEnrollStudent)
                .addGap(208, 208, 208))
        );

        jScrollPane5.setViewportView(jPanel24);

        javax.swing.GroupLayout enrollStudentPanelLayout = new javax.swing.GroupLayout(enrollStudentPanel);
        enrollStudentPanel.setLayout(enrollStudentPanelLayout);
        enrollStudentPanelLayout.setHorizontalGroup(
            enrollStudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
        );
        enrollStudentPanelLayout.setVerticalGroup(
            enrollStudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Enroll Student", enrollStudentPanel);

        javax.swing.GroupLayout right1Layout = new javax.swing.GroupLayout(right1);
        right1.setLayout(right1Layout);
        right1Layout.setHorizontalGroup(
            right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        right1Layout.setVerticalGroup(
            right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        jSplitPane2.setRightComponent(right1);

        javax.swing.GroupLayout manageEnroleesTabLayout = new javax.swing.GroupLayout(manageEnroleesTab);
        manageEnroleesTab.setLayout(manageEnroleesTabLayout);
        manageEnroleesTabLayout.setHorizontalGroup(
            manageEnroleesTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2)
        );
        manageEnroleesTabLayout.setVerticalGroup(
            manageEnroleesTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2)
        );

        myCards.add(manageEnroleesTab, "card3");

        jSplitPane3.setBorder(null);

        left2.setBackground(new java.awt.Color(203, 184, 160));

        jcbSchoolYear3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2019", "2020" }));

        lbSearchResult2.setForeground(new java.awt.Color(255, 255, 255));
        lbSearchResult2.setText("Search using the search bar...");

        jScrollPane6.setPreferredSize(new java.awt.Dimension(770, 64));

        sectionsTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Section Name", "Adv ID", "Adviser", "Gender", "Lod ID", "Curriculum", "Level", "School Year", "Subjects Contained"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        sectionsTable2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        sectionsTable2.setPreferredSize(new java.awt.Dimension(770, 64));
        sectionsTable2.getTableHeader().setReorderingAllowed(false);
        sectionsTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loadSubjectsContainedHandler(evt);
            }
        });
        jScrollPane6.setViewportView(sectionsTable2);
        if (sectionsTable2.getColumnModel().getColumnCount() > 0) {
            sectionsTable2.getColumnModel().getColumn(1).setPreferredWidth(100);
            sectionsTable2.getColumnModel().getColumn(3).setPreferredWidth(150);
            sectionsTable2.getColumnModel().getColumn(4).setPreferredWidth(50);
            sectionsTable2.getColumnModel().getColumn(7).setPreferredWidth(50);
            sectionsTable2.getColumnModel().getColumn(8).setPreferredWidth(50);
        }

        tfSearchSection2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchSectionHandler2(evt);
            }
        });

        btnSearchSection2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage2/icons/search_24px.png"))); // NOI18N
        btnSearchSection2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchSectionHandler2(evt);
            }
        });

        javax.swing.GroupLayout left2Layout = new javax.swing.GroupLayout(left2);
        left2.setLayout(left2Layout);
        left2Layout.setHorizontalGroup(
            left2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(left2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(left2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(left2Layout.createSequentialGroup()
                        .addComponent(lbSearchResult2, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbSchoolYear3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfSearchSection2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearchSection2)))
                .addContainerGap())
        );
        left2Layout.setVerticalGroup(
            left2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(left2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(left2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(left2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbSearchResult2)
                        .addComponent(btnSearchSection2))
                    .addComponent(tfSearchSection2)
                    .addComponent(jcbSchoolYear3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane3.setLeftComponent(left2);

        jScrollPane7.setBorder(null);

        jPanel3.setBackground(new java.awt.Color(249, 239, 227));

        jPanel7.setBackground(new java.awt.Color(203, 184, 160));

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("View Section Details");

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

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Assigned Teacher");

        jScrollPane8.setPreferredSize(new java.awt.Dimension(670, 192));

        assignedTeacherTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Section ID", "Adv ID", "Name", "Gender", "Subject ID", "Code", "Description", "Grade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        assignedTeacherTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        assignedTeacherTable.getTableHeader().setReorderingAllowed(false);
        assignedTeacherTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                assignedTeacherTableMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(assignedTeacherTable);
        if (assignedTeacherTable.getColumnModel().getColumnCount() > 0) {
            assignedTeacherTable.getColumnModel().getColumn(3).setPreferredWidth(150);
            assignedTeacherTable.getColumnModel().getColumn(4).setMaxWidth(60);
            assignedTeacherTable.getColumnModel().getColumn(6).setPreferredWidth(40);
            assignedTeacherTable.getColumnModel().getColumn(7).setPreferredWidth(60);
            assignedTeacherTable.getColumnModel().getColumn(8).setMaxWidth(50);
        }

        btnSaveSubjectTeacherChanges.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage2/icons/icons8_save_16px.png"))); // NOI18N
        btnSaveSubjectTeacherChanges.setText("Save Changes");
        btnSaveSubjectTeacherChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveSubjectTeacherChanges(evt);
            }
        });

        btnEditSubjectTeacher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage2/icons/icons8_edit_16px.png"))); // NOI18N
        btnEditSubjectTeacher.setText("Edit Teachers");
        btnEditSubjectTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditSubjectTeacherActionPerformed(evt);
            }
        });

        subjectTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Code", "Name", "Grade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        subjectTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        subjectTable.setPreferredSize(new java.awt.Dimension(900, 64));
        subjectTable.getTableHeader().setReorderingAllowed(false);
        subjectTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                subjectTableMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(subjectTable);
        if (subjectTable.getColumnModel().getColumnCount() > 0) {
            subjectTable.getColumnModel().getColumn(1).setPreferredWidth(50);
            subjectTable.getColumnModel().getColumn(3).setPreferredWidth(50);
        }

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Allowed Subjects To Edit");

        btnRefreshList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage2/icons/icons8_sync_16px.png"))); // NOI18N
        btnRefreshList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshListToEditHandler(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnEditSubjectTeacher)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSaveSubjectTeacherChanges))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRefreshList)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveSubjectTeacherChanges)
                    .addComponent(btnEditSubjectTeacher))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(btnRefreshList))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane7.setViewportView(jPanel3);

        javax.swing.GroupLayout detailsTabLayout = new javax.swing.GroupLayout(detailsTab);
        detailsTab.setLayout(detailsTabLayout);
        detailsTabLayout.setHorizontalGroup(
            detailsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7)
        );
        detailsTabLayout.setVerticalGroup(
            detailsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
        );

        subjectTeacherTab.addTab("Section Details", detailsTab);

        jScrollPane9.setBorder(null);

        jPanel9.setBackground(new java.awt.Color(249, 239, 227));

        jPanel8.setBackground(new java.awt.Color(203, 184, 160));

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Assign Subject Teacher");

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

        jLabel15.setText("Select Teacher");

        tfSearchUser2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchUserHandler2(evt);
            }
        });

        btnSearchUser2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage2/icons/search_24px.png"))); // NOI18N
        btnSearchUser2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchUserHandler2(evt);
            }
        });

        usersTable2.setAutoCreateRowSorter(true);
        usersTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID (H)", "Name", "Gender", "Access Level"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        usersTable2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        usersTable2.setPreferredSize(new java.awt.Dimension(900, 64));
        usersTable2.getTableHeader().setReorderingAllowed(false);
        usersTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                assignTeacherHandler(evt);
            }
        });
        jScrollPane17.setViewportView(usersTable2);
        if (usersTable2.getColumnModel().getColumnCount() > 0) {
            usersTable2.getColumnModel().getColumn(3).setHeaderValue("Access Level");
        }

        btnAssignTeacher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage2/icons/icons8_ok_16px.png"))); // NOI18N
        btnAssignTeacher.setText("Assign Teacher");
        btnAssignTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignTeacherHandler2(evt);
            }
        });

        btnNone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage2/icons/icons8_delete_bin_16px.png"))); // NOI18N
        btnNone.setText("Assign None");
        btnNone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(tfSearchUser2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearchUser2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnNone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAssignTeacher)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSearchUser2)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfSearchUser2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAssignTeacher)
                    .addComponent(btnNone))
                .addContainerGap())
        );

        jScrollPane9.setViewportView(jPanel9);

        javax.swing.GroupLayout selectTeacherTabLayout = new javax.swing.GroupLayout(selectTeacherTab);
        selectTeacherTab.setLayout(selectTeacherTabLayout);
        selectTeacherTabLayout.setHorizontalGroup(
            selectTeacherTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane9)
        );
        selectTeacherTabLayout.setVerticalGroup(
            selectTeacherTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
        );

        subjectTeacherTab.addTab("Select Teacher", selectTeacherTab);

        javax.swing.GroupLayout right2Layout = new javax.swing.GroupLayout(right2);
        right2.setLayout(right2Layout);
        right2Layout.setHorizontalGroup(
            right2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(subjectTeacherTab)
        );
        right2Layout.setVerticalGroup(
            right2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(subjectTeacherTab)
        );

        jSplitPane3.setRightComponent(right2);

        javax.swing.GroupLayout assignSubjectTeacherTabLayout = new javax.swing.GroupLayout(assignSubjectTeacherTab);
        assignSubjectTeacherTab.setLayout(assignSubjectTeacherTabLayout);
        assignSubjectTeacherTabLayout.setHorizontalGroup(
            assignSubjectTeacherTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1084, Short.MAX_VALUE)
        );
        assignSubjectTeacherTabLayout.setVerticalGroup(
            assignSubjectTeacherTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane3)
        );

        myCards.add(assignSubjectTeacherTab, "card2");

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(myCards, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(myCards, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );

        menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage2/icons/icons8-male-user_circle-20.png"))); // NOI18N

        logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage2/icons/icons8-logout-rounded-up-20.png"))); // NOI18N
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
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void logoutHandler(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_logoutHandler
        my.openWindow(this, new login());
    }//GEN-LAST:event_logoutHandler

    private void enrollStudentHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enrollStudentHandler
        int studentRow = studentTable.getSelectedRow();
        int sectionRow = sectionsTable1.getSelectedRow();

        if(studentRow == -1){
            Toolkit.getDefaultToolkit().beep();
            my.showMessage("Please select a STUDENT to enroll.", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(sectionRow == -1){
            Toolkit.getDefaultToolkit().beep();
            my.showMessage("Please select a SECTION to enroll this student to.", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String studentId = studentTable.getValueAt(studentRow, 0).toString();
        String sectionId = sectionsTable1.getValueAt(sectionRow, 0).toString();

        //Check if student is already enrolled to the same section
        String duplicate [] = my.return_values("*", "enrollment", "WHERE studentId='"+studentId+"' AND sectionId ='"+sectionId+"'",new int [] {0,1,2,3});
        String date [] = my.return_values("substr(now(),1,10) as 'dateNow'", "", "", new int [] {0});
        String dateNow = "";
        try {
            dateNow = my.getValueAtColumn(date[0], 0);
        } catch (Exception e) {
            dateNow = " ";
        }

        if(duplicate != null){
            playError();
            my.showMessage("Student is already enrolled to this section.", JOptionPane.ERROR_MESSAGE);

            //Update date only if overwriting is allowed.
            return;
        }

        //Check if section to enroll is appropriate.
        int currentGradeLevel = Integer.parseInt(studentTable.getValueAt(studentRow, 4).toString());
        int sectionGradeLevel = Integer.parseInt(sectionsTable1.getValueAt(sectionRow, 3).toString());
        String remarks = " ! !";

        if(currentGradeLevel == 0){
//            if(sectionGradeLevel != 11){
//                if(!my.getConfirmation("This student should be enrolled to a GRADE 11 section.\nContinue?")){
//                    Toolkit.getDefaultToolkit().beep();
//                    my.showMessage("Enrollment Cancelled.", JOptionPane.PLAIN_MESSAGE);
//                    return;
//                }
//            }
            if(my.getConfirmation("This is this Student's first time being enrolled.\n"
                + "Would you like to put a status of (TRANSFERRED IN) for this student?")){
            remarks = "T/I: "+dateNow+"!T/I: "+dateNow+"!";
        }
        }else{
            if(currentGradeLevel+1 != sectionGradeLevel){
                if(!my.getConfirmation("This student should be enrolled to a GRADE "+(currentGradeLevel)+" section.\nContinue?")){
                    Toolkit.getDefaultToolkit().beep();
                    my.showMessage("Enrollment Cancelled.", JOptionPane.PLAIN_MESSAGE);
                    return;
                }
            }
        }

        //Proceed to enrollment
        String studentName = studentTable.getValueAt(studentRow, 2).toString();
        String sectionName = sectionsTable1.getValueAt(sectionRow, 1).toString();

        if(my.getConfirmation("Enroll this student? \n"+studentName+" to "+sectionName+"?")){
            String fields [] = {
                "null",studentId,sectionId,"now()",remarks
            };

            if(my.add_values("enrollment", "id,studentId,sectionId,dateEnrolled,remarks", fields)){
                //Update current grade level
                String sets [] = {"curGrLvl='"+sectionGradeLevel+"'"};
                if(my.update_values("students", sets, "id='"+studentId+"'")){
                    playSuccess();
                    my.showMessage("Enrolled Successfully. Updating Records successful.", JOptionPane.INFORMATION_MESSAGE);
                    btnSearchStudentHandler(evt);
                }else{
                    Toolkit.getDefaultToolkit().beep();
                    my.showMessage("Enrolled Successfully. Updating Records failed.", JOptionPane.WARNING_MESSAGE);
                    btnSearchStudentHandler(evt);
                }
            }else{
                playError();
                my.showMessage("Enrollment Failed. Please make sure you are connected to the school network.", JOptionPane.ERROR_MESSAGE);
            }

        }else{
            Toolkit.getDefaultToolkit().beep();
            my.showMessage("Enrollment Cancelled.", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_enrollStudentHandler

    private void searchSectionToEnrollHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchSectionToEnrollHandler
        String toSearch = tfSearchSection1.getText();
        String schoolYear = jcbSchoolYear2.getSelectedItem().toString();

        String where = "";

        if(jcbSchoolYear4.getSelectedIndex() == 0){
            where = "WHERE sectionName LIKE '%"+toSearch+"%'";
        }else{
            where = "WHERE sectionName LIKE '%"+toSearch+"%' AND schoolYear="+schoolYear;
        }

        my.searchItem(where, sectionsTable1, 4, new int [] {2,6,7,8}, new int [] {2,3,4}, true, true, null, tfSearchSection1, true);
    }//GEN-LAST:event_searchSectionToEnrollHandler

    private void searchStudentToEnrollHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchStudentToEnrollHandler
        String toSearch = my.convertEscapeCharacters(tfSearchStudent1.getText().trim());
        String where = "";

        if(toSearch.contains(",")){
            String additionalQuery;
            additionalQuery = my.multipleColumnSearch("lName,fName,mName", "Last Name,First Name,Middle Name","LIKE,LIKE,LIKE",toSearch);
            if(additionalQuery == null){
                return;
            }

            where+="WHERE ("+additionalQuery+")";
        }else{
            where+="WHERE (lName LIKE'%"+toSearch+"%' OR fName LIKE'%"+toSearch+"%' OR mName LIKE'%"+toSearch+"%')";
        }

        my.searchItem(where, studentTable, 0, new int [] {6}, new int [] {2,3,4}, true, true, null, tfSearchStudent1, true);
    }//GEN-LAST:event_searchStudentToEnrollHandler

    private void btnSearchStudentHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchStudentHandler
        String yearFilter = jcbSchoolYear2.getSelectedItem().toString();

        String toSearch = my.convertEscapeCharacters(tfSearchStudent.getText().trim());
        String where = "WHERE ";

        if(toSearch.contains(",")){
            String additionalQuery;
            additionalQuery = my.multipleColumnSearch("lName,fName,mName", "Last Name,First Name,Middle Name","LIKE,LIKE,LIKE",toSearch);
            if(additionalQuery == null){
                return;
            }

            where+=" ("+additionalQuery+")";
        }else{
            where+=" (lName LIKE'%"+toSearch+"%' OR fName LIKE'%"+toSearch+"%' OR mName LIKE'%"+toSearch+"%')";
        }
        where +=(jcbSchoolYear2.getSelectedIndex()!=0?"AND schoolYear='"+yearFilter+"'":"");

        String [] result = my.return_values("*", "v_enrollment", where, myVariables.getEnrollmentViewOrder());

        my.clear_table_rows(enrollmentTable);
        if(result != null){
            for(String n : result){
                n = my.toNameFormat(n, new int [] {10,11,12});
                n = my.toNameFormat(n, new int [] {3,4,5});
                n = my.skipColumns(n, new int [] {1,5,7,9});

                my.add_table_row(n, enrollmentTable);
            }
            clearEnrollStudentFields();
            lbSearchResult1.setText("Showing "+result.length+" "+(result.length>1?"results":"result")+" for '"+toSearch+"'");
        }else{
            lbSearchResult1.setText("No Results Found.");
        }
    }//GEN-LAST:event_btnSearchStudentHandler

    private void saveSectionChangesHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveSectionChangesHandler
        int advIndex = usersTable1.getSelectedRow();
        int currIndex = loadsTable1.getSelectedRow();
        String sectionId = lbSectionId.getText();
        String sectionName = tfSectionName1.getText();
        String schoolYear = jcbSchoolYear1.getSelectedItem().toString();

        if(sectionName.length() <= 0){
            Toolkit.getDefaultToolkit().beep();
            my.showMessage("Please provide a name for this section.", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(advIndex == -1){
            Toolkit.getDefaultToolkit().beep();
            my.showMessage("Please select an Adviser.", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(currIndex == -1){
            Toolkit.getDefaultToolkit().beep();
            my.showMessage("Please select a Curriculum", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String [] sets = {
            "sectionName='"+sectionName+"'",
            "adviserId='"+usersTable1.getValueAt(advIndex, 0).toString()+"'",
            "loadId='"+loadsTable1.getValueAt(currIndex, 0).toString()+"'",
            "schoolYear='"+schoolYear+"'",
        };

        if(my.update_values("sections", sets, "id='"+sectionId+"'")){
            playSuccess();
            my.showMessage("Update Successful.", JOptionPane.INFORMATION_MESSAGE);

            btnSearchSectionHandler(evt);
        }else{
            playError();
            my.showMessage("Update Failed. Please make sure you are connected to the school network.", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_saveSectionChangesHandler

    private void searchLoadHandler1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchLoadHandler1
        String toSearch = my.convertEscapeCharacters(tfSearchLoad1.getText().trim());
        String where = "WHERE b_loadName LIKE '%"+toSearch+"%' ORDER BY c_gradeLevel ASC";
        my.searchItem(where, loadsTable1, 2, null, null, false, true, null, tfSearchLoad1, true);
    }//GEN-LAST:event_searchLoadHandler1

    private void searchUserHandler1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchUserHandler1
        String toSearch = my.convertEscapeCharacters(tfSearchUser1.getText().trim());
        String where = "WHERE user_level='1' ";

        if(toSearch.contains(",")){
            String additionalQuery;
            additionalQuery = my.multipleColumnSearch("user_Lname,user_Fname,user_Mname", "Last Name,First Name,Middle Name","LIKE,LIKE,LIKE",toSearch);
            if(additionalQuery == null){
                return;
            }

            where+="AND ("+additionalQuery+")";
        }else{
            where+="AND (user_Lname LIKE'%"+toSearch+"%' OR user_Fname LIKE'%"+toSearch+"%' OR user_Mname LIKE'%"+toSearch+"%')";
        }
        my.searchItem(where, usersTable1, 3, new int[]{5,6}, new int[]{1,2,3}, true, true, null, tfSearchUser1, true);
    }//GEN-LAST:event_searchUserHandler1

    private void createNewSectionHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createNewSectionHandler
        int advIndex = usersTable.getSelectedRow();
        int currIndex = loadsTable.getSelectedRow();
        String sectionName = tfSectionName.getText();
        String schoolYear = jcbSchoolYear.getSelectedItem().toString();

        if(sectionName.length() <= 0){
            Toolkit.getDefaultToolkit().beep();
            my.showMessage("Please provide a name for this section.", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(advIndex == -1){
            Toolkit.getDefaultToolkit().beep();
            my.showMessage("Please select an Adviser.", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(currIndex == -1){
            Toolkit.getDefaultToolkit().beep();
            my.showMessage("Please select a Curriculum", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String fields [] = {
            "null",
            sectionName,
            usersTable.getValueAt(advIndex, 0).toString(),
            loadsTable.getValueAt(currIndex, 0).toString(),
            schoolYear,
            "SHS"
        };

        if(my.add_values("sections", "id,sectionName,adviserId,loadId,schoolYear,dep_type", fields)){
            playSuccess();
            my.showMessage("Adding Successful.", JOptionPane.INFORMATION_MESSAGE);

            clearAddSectionFields();
            btnSearchSectionHandler(evt);
        }else{
            playError();
            my.showMessage("Adding Failed. Please make sure you are connected to the school network.", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_createNewSectionHandler

    private void searchLoadHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchLoadHandler
        String toSearch = my.convertEscapeCharacters(tfSearchLoad.getText().trim());
        String where = "WHERE b_loadName LIKE '%"+toSearch+"%' ORDER BY c_gradeLevel ASC";

        my.searchItem(where, loadsTable, 2, null, null, false, true, null, tfSearchLoad, true);
    }//GEN-LAST:event_searchLoadHandler

    private void searchUserHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchUserHandler
        String toSearch = my.convertEscapeCharacters(tfSearchUser.getText().trim());
        String where = "WHERE user_level='1' ";

        if(toSearch.contains(",")){
            String additionalQuery;
            additionalQuery = my.multipleColumnSearch("user_Lname,user_Fname,user_Mname", "Last Name,First Name,Middle Name","LIKE,LIKE,LIKE",toSearch);
            if(additionalQuery == null){
                return;
            }

            where+="AND ("+additionalQuery+")";
        }else{
            where+="AND (user_Lname LIKE'%"+toSearch+"%' OR user_Fname LIKE'%"+toSearch+"%' OR user_Mname LIKE'%"+toSearch+"%')";
        }
        my.searchItem(where, usersTable, 3, new int[]{5,6}, new int[]{1,2,3}, true, true, null, tfSearchUser, true);
    }//GEN-LAST:event_searchUserHandler

    private void sectionsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sectionsTableMouseClicked
        if(evt.getClickCount() == 2){
            int row = sectionsTable.getSelectedRow();
            String sectionId = sectionsTable.getValueAt(row, 0).toString();
            String sectionName = sectionsTable.getValueAt(row, 1).toString();
            int schoolYear = Integer.parseInt(sectionsTable.getValueAt(row, 8).toString());

            //<editor-fold desc="Clear & add Teacher and Curriculum">
            String adviserId = sectionsTable.getValueAt(row, 2).toString();
            String adviserName = sectionsTable.getValueAt(row, 3).toString();
            String gender = sectionsTable.getValueAt(row, 4).toString();
            String accessLevel = "1";

            String loadId = sectionsTable.getValueAt(row, 5).toString();
            String loadName = sectionsTable.getValueAt(row, 6).toString();
            String gradeLevel = sectionsTable.getValueAt(row, 7).toString();

            my.clear_table_rows(usersTable1);
            my.clear_table_rows(loadsTable1);

            my.add_table_row(adviserId+"@@"+adviserName+"@@"+gender+"@@"+accessLevel+"@@", usersTable1);
            my.add_table_row(loadId+"@@"+loadName+"@@"+gradeLevel+"@@", loadsTable1);
            //</editor-fold>

            tfSectionName1.setText(sectionName);
            lbSectionId.setText(sectionId);

            for(int n=0;n<jcbSchoolYear1.getItemCount();n++){
                try {
                    int currYear = Integer.parseInt(jcbSchoolYear1.getItemAt(n));

                    if(currYear == schoolYear){
                        jcbSchoolYear1.setSelectedIndex(n);
                        System.err.println("Match Found");
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Invalid Number.");
                }
            }

            if(sectionsTab.getTabCount() <= 1){
                sectionsTab.addTab("Edit Section", editSectionPanel);
                sectionsTab.setSelectedIndex(1);
            }
        }else{
            if(sectionsTab.getTabCount() > 1){
                sectionsTab.removeTabAt(1);
            }
        }
    }//GEN-LAST:event_sectionsTableMouseClicked

    private void btnSearchSectionHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchSectionHandler
        String toSearch = tfSearchSection.getText();
        String schoolYear = jcbSchoolYear4.getSelectedItem().toString();

        String where = "";

        if(jcbSchoolYear4.getSelectedIndex() == 0){
            where = "WHERE sectionName LIKE '%"+toSearch+"%'";
        }else{
            where = "WHERE sectionName LIKE '%"+toSearch+"%' AND schoolYear="+schoolYear;
        }

        my.searchItem(where, sectionsTable, 4,null, new int [] {3,4,5}, true, true, lbSearchResult, tfSearchSection, true);
        if(sectionsTab.getTabCount() > 1){
            sectionsTab.removeTabAt(1);
        }
    }//GEN-LAST:event_btnSearchSectionHandler

    private void btnNoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoneActionPerformed
        assignTeacher(true);
    }//GEN-LAST:event_btnNoneActionPerformed

    private void assignTeacherHandler2(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignTeacherHandler2
        assignTeacher(false);
    }//GEN-LAST:event_assignTeacherHandler2

    private void assignTeacherHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_assignTeacherHandler
        if(evt.getClickCount() == 2){
            assignTeacher(false);
        }
    }//GEN-LAST:event_assignTeacherHandler

    private void searchUserHandler2(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchUserHandler2
        String toSearch = my.convertEscapeCharacters(tfSearchUser2.getText().trim());
        String where = "WHERE user_level='1' ";

        if(toSearch.contains(",")){
            String additionalQuery;
            additionalQuery = my.multipleColumnSearch("user_Lname,user_Fname,user_Mname", "Last Name,First Name,Middle Name","LIKE,LIKE,LIKE",toSearch);
            if(additionalQuery == null){
                return;
            }

            where+="AND ("+additionalQuery+")";
        }else{
            where+="AND (user_Lname LIKE'%"+toSearch+"%' OR user_Fname LIKE'%"+toSearch+"%' OR user_Mname LIKE'%"+toSearch+"%')";
        }
        my.searchItem(where, usersTable2, 3, new int[]{5,6}, new int[]{1,2,3}, true, true, null, tfSearchUser2, true);
    }//GEN-LAST:event_searchUserHandler2

    private void refreshListToEditHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshListToEditHandler
        int userId = myVariables.getUserLoggedInId();
        String [] result = my.return_values("*", "userdetails", "WHERE userId='"+userId+"'", myVariables.getUsersPersonalInfoOrder());

        if(myVariables.getAccessLevel() == 5){
            jLabel16.setText("Allowed Subjects To Edit (Ignored by Admin)");
        }else{
            jLabel16.setText("Allowed Subjects To Edit");
        }

        if(result != null){
            String managedSubjects = my.getValueAtColumn(result[0], 9);
            if(managedSubjects.contains("NONE")){
                my.clear_table_rows(subjectTable);
                return;
            }

            managedSubjects = managedSubjects.replace(':', ',');

            int length = managedSubjects.length();
            if(managedSubjects.charAt(length-1) == ','){
                System.err.println("Comma found...Deleting");
                managedSubjects = managedSubjects.substring(0, length-1);
            }

            String [] subjects = my.return_values("*", "subjects", "WHERE id IN ("+managedSubjects+")", myVariables.getSubjectOrder());

            my.clear_table_rows(subjectTable);
            if(subjects != null){
                for(String n : subjects){
                    my.add_table_row(n, subjectTable);
                }
            }
        }else{
            my.clear_table_rows(subjectTable);
        }
    }//GEN-LAST:event_refreshListToEditHandler

    private void subjectTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subjectTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_subjectTableMouseClicked

    private void btnEditSubjectTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditSubjectTeacherActionPerformed
        enableDisableAssignSubjectTeacherFields(false, true, true);

        assignedTeacherTable.setRowSelectionInterval(0, 0);
    }//GEN-LAST:event_btnEditSubjectTeacherActionPerformed

    private void saveSubjectTeacherChanges(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveSubjectTeacherChanges
        //Get Values
        int sectionRow = sectionsTable2.getSelectedRow();

        String sectionId = sectionsTable2.getValueAt(sectionRow, 0).toString();
        int count = assignedTeacherTable.getRowCount();

        String [] rows = new String[count];
        for(int n=0;n<count;n++){
            String id = assignedTeacherTable.getValueAt(n, 0).toString();
            String teacherId = assignedTeacherTable.getValueAt(n, 2).toString();
            String subjectId = assignedTeacherTable.getValueAt(n, 5).toString();
            //ID,Section ID,Teacher ID,Subject ID
            rows[n] = id+","+sectionId+","+teacherId+","+subjectId;
        }

        if(my.update_multiple_values("teacherloads", "id,sectionId,teacherId,subjectId", "teacherId = VALUES(teacherId)", rows)){
            playSuccess();
            my.showMessage("Update Succesfull.", JOptionPane.INFORMATION_MESSAGE);
            btnSearchSectionHandler2(evt);
        }else{
            playError();
            my.showMessage("Update Failed. Please make sure you are connected to the school network.", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_saveSubjectTeacherChanges

    private void assignedTeacherTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_assignedTeacherTableMouseClicked
        if(evt.getClickCount() == 2 && assignedTeacherTable.isEnabled()){
            //Check if selected subject is on allowed subjects table
            int row = assignedTeacherTable.getSelectedRow();
            int selectedSubjectId = Integer.parseInt(assignedTeacherTable.getValueAt(row, 5).toString());

            //Filter if user is not an admin
            if(myVariables.getAccessLevel() != 5 && myVariables.getAccessLevel() != 4){
                boolean matchFound = false;
                for(int n=0;n<subjectTable.getRowCount();n++){
                    int currentId = Integer.parseInt(subjectTable.getValueAt(n, 0).toString());
                    if(selectedSubjectId == currentId){
                        System.out.println("Selected subject is found on the list.");
                        matchFound = true;
                        break;
                    }
                }

                if(!matchFound){
                    Toolkit.getDefaultToolkit().beep();
                    my.showMessage("This subject is not assigned to you.\nPlease [Refresh] your list below if you think this is an error.\nIf problem persists, please contact a REGISTRAR user.", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }else{
                System.out.println("Admin account detected. All subjects are allowed to be assigned.");
            }

            if(subjectTeacherTab.getTabCount() <= 1){
                subjectTeacherTab.addTab("Select Teacher", selectTeacherTab);
                subjectTeacherTab.setSelectedIndex(1);
            }
        }else{
            if(subjectTeacherTab.getTabCount() >= 2){
                subjectTeacherTab.removeTabAt(1);
            }
        }
    }//GEN-LAST:event_assignedTeacherTableMouseClicked

    private void btnSearchSectionHandler2(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchSectionHandler2
        String toSearch = tfSearchSection2.getText();
        String schoolYear = jcbSchoolYear3.getSelectedItem().toString();

        String where = "";

        if(jcbSchoolYear3.getSelectedIndex() == 0){
            where = "WHERE sectionName LIKE '%"+toSearch+"%'";
        }else{
            where = "WHERE sectionName LIKE '%"+toSearch+"%' AND schoolYear="+schoolYear;
        }

        my.searchItem(where, sectionsTable2, 4,null, new int [] {3,4,5}, true, true, lbSearchResult2, tfSearchSection2, true);
        if(subjectTeacherTab.getTabCount() > 1){
            subjectTeacherTab.removeTabAt(1);
        }
        my.clear_table_rows(assignedTeacherTable);

        refreshListToEditHandler(evt);

        enableDisableAssignSubjectTeacherFields(false, false,false);
    }//GEN-LAST:event_btnSearchSectionHandler2

    private void loadSubjectsContainedHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loadSubjectsContainedHandler
        if(evt.getClickCount() == 2){
            int row = sectionsTable2.getSelectedRow();
            String subjectsContained = "";
            subjectsContained = sectionsTable2.getValueAt(row, 9) == null?null : sectionsTable2.getValueAt(row, 9).toString();

            if(subjectsContained == null || subjectsContained.length() <= 0){
                Toolkit.getDefaultToolkit().beep();
                my.showMessage("This section has no subjects added to it.\nPlease contact your curriculum head if you think this is an error.", JOptionPane.WARNING_MESSAGE);
                my.clear_table_rows(assignedTeacherTable);
                return;
            }

            String where = "";
            String sectionId = sectionsTable2.getValueAt(row, 0).toString();

            //Check if there is at least one subject to search
            subjectsContained = sectionsTable2.getValueAt(row, 9).toString();
            subjectsContained = subjectsContained.replace(':', ',');

            if(subjectsContained.charAt(subjectsContained.length()-1) == ','){
                subjectsContained = subjectsContained.substring(0, subjectsContained.length()-1);
                System.err.println("Comma found...deleting");
            }

            where = "WHERE subjectId IN ("+subjectsContained+") AND sectionId='"+sectionId+"'";

            //Check if section is already finalized in teacherLoads table
            String result [] = my.return_values("*", "v_teacherloads", where, myVariables.getTeacherLoadsViewOrder());

            if(result == null){
                //Prompt to finalize section
                if(my.getConfirmation("This section has not been finalized yet.\nFinalize now?\n\n"
                    + "-You can no longer change the curruiculum of this section.\n"
                    + "-You can now assign Subject Teachers.")){
                //Build Query
                String subjects [] = subjectsContained.split(",");
                String values [] = new String[subjects.length];

                for(int n=0;n<values.length;n++){
                    values[n] = "null,"+sectionId+",-1,"+subjects[n];
                }

                if(my.add_multiple_values("teacherLoads", "id,sectionId,teacherId,subjectId", values)){
                    playSuccess();
                    my.showMessage("Finalizing Completed. You can now assign Subject Teachers to this section.", JOptionPane.INFORMATION_MESSAGE);

                    btnSearchSectionHandler2(my.getButtonPressedEvent(btnSearchSection2));
                    return;
                }else{
                    playError();
                    my.showMessage("Finalizing Failed. Please make sure you are connected to the school network.", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }else{
                Toolkit.getDefaultToolkit().beep();
                my.showMessage("Finalizing canceled.", JOptionPane.PLAIN_MESSAGE);
            }
            return;
        }
        //Check for missing subjects
        String expectedSubjectIds [] = subjectsContained.split(",");

        boolean prompForMissingSubjects;
        for(String n : expectedSubjectIds){
            int expectedId = Integer.parseInt(n);
            prompForMissingSubjects = true;

            for(String x : result){
                int resultId = Integer.parseInt(my.getValueAtColumn(x, 7));
                //System.err.println("Expected: "+expectedId+" result: "+resultId);
                if(expectedId == resultId){
                    //System.out.println("Match Found for subject Id: "+expectedId);
                    prompForMissingSubjects = false;
                    break;
                }
            }

            if(prompForMissingSubjects){
                System.out.println("Missing entry for subject Id: "+expectedId);
                //Update list for missing subjects code here
                if(my.getConfirmation("This section has missing subjects.\n"
                    + "Add them now?\n\nPossible causes:\n"
                    + "-Curriculum Head User changed this section's current curriculum.\n"
                    + "-Curriuculum Head User changed subjects assigned to this section's curriculum.\n"
                    + "-Developer changed the curriculum's subjects forcefully.")){
                //Build update multiple values query
                String values [] = new String[expectedSubjectIds.length];

                int subjectId = 0;
                int existingId = 0;
                String teacherLoadId = "";
                String teacherId = "";
                boolean matchFound;
                for(int y=0;y<values.length;y++){
                    subjectId = Integer.parseInt(expectedSubjectIds[y]);

                    matchFound = false;
                    for(String z : result){
                        existingId = Integer.parseInt(my.getValueAtColumn(z, 7));

                        if(subjectId == existingId){
                            teacherLoadId = my.getValueAtColumn(z, 0);
                            teacherId = my.getValueAtColumn(z, 2);
                            matchFound = true;
                            break;
                        }
                    }

                    if(matchFound){
                        //id,sectionId,teacherId,subjectId
                        values[y] = teacherLoadId+","+sectionId+","+teacherId+","+subjectId;
                    }else{
                        values[y] = "null,"+sectionId+",-1,"+subjectId;
                    }
                }

                for(String a : values){
                    System.out.println(a);
                }

                if(my.update_multiple_values("teacherloads", "id,sectionId,teacherId,subjectId", "teacherId = VALUES(teacherId)", values)){
                    playSuccess();
                    my.showMessage("Finalizing Completed. You can now assign Subject Teachers to this section.", JOptionPane.INFORMATION_MESSAGE);
                    btnSearchSectionHandler2(new ActionEvent(btnSearchSection2,ActionEvent.ACTION_FIRST, ""));
                    return;
                }else{
                    playError();
                    my.showMessage("Finalizing Failed. Please make sure you are connected to the school network.", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }else{
                Toolkit.getDefaultToolkit().beep();
                my.showMessage("Finalizing canceled.", JOptionPane.PLAIN_MESSAGE);
            }
            break;
        }
        }

        my.clear_table_rows(assignedTeacherTable);
        enableDisableAssignSubjectTeacherFields(true, false, false);
        for(String n : result){
            n = my.toNameFormat(n, new int [] {3,4,5});

            if(my.getValueAtColumn(n, 2).contains("-1")){
                n = my.setValueAtColumn(n, 3, "None");
            }

            my.add_table_row(n, assignedTeacherTable);
        }
        }else{
            my.clear_table_rows(assignedTeacherTable);
            enableDisableAssignSubjectTeacherFields(false, false, false);

            if(subjectTeacherTab.getTabCount() >= 2){
                subjectTeacherTab.removeTabAt(1);
            }
        }
    }//GEN-LAST:event_loadSubjectsContainedHandler

    
   
    private void tab1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab1MouseClicked
        // TODO add your handling code here:
        myCards.removeAll();
        myCards.add(manageSectionsTab);
        myCards.repaint();
        myCards.revalidate();

        tab1.setBackground(Color.decode("#FDE8F0"));

        tab2.setBackground(Color.decode("#FBB9D3"));
        tab3.setBackground(Color.decode("#FBB9D3"));
      
    }//GEN-LAST:event_tab1MouseClicked

    private void tab3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab3MouseClicked
        // TODO add your handling code here:
        myCards.removeAll();
        myCards.add(assignSubjectTeacherTab);
        myCards.repaint();
        myCards.revalidate();

        tab3.setBackground(Color.decode("#FDE8F0"));

        tab1.setBackground(Color.decode("#FBB9D3"));
        tab2.setBackground(Color.decode("#FBB9D3"));
        
    }//GEN-LAST:event_tab3MouseClicked

    private void jcbSchoolYear2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbSchoolYear2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbSchoolYear2ActionPerformed

    private void tab2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab2MouseClicked
        // TODO add your handling code here:
        myCards.removeAll();
        myCards.add(manageEnroleesTab);
        myCards.repaint();
        myCards.revalidate();

        tab2.setBackground(Color.decode("#FDE8F0"));

        tab1.setBackground(Color.decode("#FBB9D3"));
        tab3.setBackground(Color.decode("#FBB9D3"));
    }//GEN-LAST:event_tab2MouseClicked

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
        /* Set the Windows look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Windows (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
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
    public void clearAddSectionFields(){
        tfSectionName.setText("");
        tfSearchUser.setText("");
        tfSearchLoad.setText("");
        
        my.clear_table_rows(usersTable);
        my.clear_table_rows(loadsTable);
    }
    public void clearEnrollStudentFields(){
        tfSearchStudent1.setText("");
        tfSearchSection1.setText("");
        
        my.clear_table_rows(studentTable);
        my.clear_table_rows(sectionsTable1);
    }
    public void enableDisableAssignSubjectTeacherFields(boolean enableDisable,boolean enableSaveChanges,boolean enableTable){
        btnEditSubjectTeacher.setEnabled(enableDisable);
        btnSaveSubjectTeacherChanges.setEnabled(enableSaveChanges);
        
        assignedTeacherTable.setEnabled(enableTable);
    }
    public void assignTeacher(boolean noneSelected){
        int row = usersTable2.getSelectedRow();
        int slotRow = assignedTeacherTable.getSelectedRow();
        
        if(noneSelected){
            assignedTeacherTable.setValueAt("-1", slotRow, 2);
            assignedTeacherTable.setValueAt("None", slotRow, 3);
            assignedTeacherTable.setValueAt("None", slotRow, 4);
        }else{
            if(row == -1){
                Toolkit.getDefaultToolkit().beep();
                my.showMessage("Please select a teacher.", JOptionPane.WARNING_MESSAGE);
            }
            
            //Get values and pass to assignedTeachers table
            String teacherId = usersTable2.getValueAt(row, 0).toString();
            String name = usersTable2.getValueAt(row, 1).toString();
            String gender = usersTable2.getValueAt(row, 2).toString();

            assignedTeacherTable.setValueAt(teacherId, slotRow, 2);
            assignedTeacherTable.setValueAt(name, slotRow, 3);
            assignedTeacherTable.setValueAt(gender, slotRow, 4);
        }
        if(subjectTeacherTab.getTabCount() >= 2){
            subjectTeacherTab.removeTabAt(1);
        }
    }
    //<editor-fold desc="Custom Functions"> 
    private void setScrollSpeeds(){
        JScrollPane scrollpanes [] = {
            jScrollPane2,jScrollPane3,jScrollPane5,jScrollPane7,jScrollPane9,
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
            my.hideColumns(sectionsTable, new int [] {0,2,5});
            my.hideColumns(usersTable, new int[] {0});
            my.hideColumns(loadsTable, new int[] {0});
            my.hideColumns(usersTable1, new int[] {0});
            my.hideColumns(loadsTable1, new int[] {0});
            
            my.hideColumns(enrollmentTable, new int [] {0});
            my.hideColumns(studentTable, new int [] {0});
            my.hideColumns(sectionsTable1, new int [] {0});
            
            my.hideColumns(sectionsTable2, new int [] {0,2,5,7,9});
            my.hideColumns(assignedTeacherTable, new int [] {0,1,2,5});
            my.hideColumns(usersTable2, new int[] {0});
            my.hideColumns(subjectTable, new int [] {0});
        }
        
        //Set table fonts
        JTable tables [] = {
            sectionsTable,
            usersTable,
            loadsTable,
            usersTable1,
            loadsTable1,
            
            enrollmentTable,
            studentTable,
            sectionsTable1,
            
            sectionsTable2,
            assignedTeacherTable,
            usersTable2,
            subjectTable,
        };
        //customizeTableColumnColors(sf1SectionTable, new int [] {0,1,2,3}, Color.RED,Color.WHITE,new Font("Segoe UI",Font.PLAIN,11),true);
        //customHeaders(sf1SectionTable, new int []{0,1,2,3}, Color.RED, Color.WHITE, new Font("Comic Sans MS", Font.BOLD, 12), true);
        for(int n=0;n<tables.length;n++){
            tables[n].getTableHeader().setFont(myPSemiBold.deriveFont(12F));
            tables[n].setFont(myPReg.deriveFont(12F));
            
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
//        mainTab.add("Manage Sections",manageSectionsTab);
//        mainTab.add("Enrollment",manageEnroleesTab);
//        mainTab.add("Assign Subject Teachers",assignSubjectTeacherTab);
//        
//        mainTab.setFont(myVariables.TAB_HEADER_FONT);
    }
    private void loadTabIcons(){
        Icon tabIcons [] = {
            my.getImgIcn(myVariables.getSectionsIcon()),
            my.getImgIcn(myVariables.getEnrollmentIcon()),
            my.getImgIcn(myVariables.getAssignSubjectTeacherIcon()),
        };
        
        for(int n=0;n<tabIcons.length;n++){
//            mainTab.setIconAt(n,tabIcons[n]);
        }
    }
    private void loadColoredButtons(){
        
         try{
            myPReg = Font.createFont(Font.TRUETYPE_FONT,new File("fonts/Poppins-Regular.ttf"));
            myPSemiBold = Font.createFont(Font.TRUETYPE_FONT,new File("fonts/Poppins-SemiBold.ttf"));

        }catch (Exception e){
            System.out.println("Error loading custom font..");
        }
         
        JButton buttons [] = {
            //Manage Sections
            btnSearchSection,
            btnSearchUser,
            btnSearchLoad,
            btnSearchLoad1,
            btnSearchUser1,
            btnAddNewSection,
            btnSaveSectionChanges,
            //Enrollment
            btnSearchStudent,btnSearchStudent1,btnSearchSection1,btnEnrollStudent,
            //Assign Subject Teachers
            btnSearchSection2,
            btnEditSubjectTeacher,
            btnSaveSubjectTeacherChanges,
            btnSearchUser2,
            btnAssignTeacher,
            btnNone,
            
            btnRefreshList,
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
            buttons[n].setFont(myPReg.deriveFont(12F));
            //buttons[n].setCursor(my.getCursor(myVariables.getHandCursor()));
            buttons[n].setCursor(new Cursor(Cursor.HAND_CURSOR));
            buttons[n].setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
        
        for(int n=0;n<lightButtons.length;n++){
            lightButtons[n].setUI(new custom_styledButtonIU());
            //buttons[n].setBackground(new Color(22,66,33));
            lightButtons[n].setBackground(Color.WHITE);
            lightButtons[n].setForeground(new Color(22,66,33));            
            lightButtons[n].setFont(myPReg.deriveFont(12F));
            //buttons[n].setCursor(my.getCursor(myVariables.getHandCursor()));
            lightButtons[n].setCursor(new Cursor(Cursor.HAND_CURSOR));
            lightButtons[n].setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
    }
    private void loadLabels(){
        JLabel titleHeaderLabels [] = {
            jLabel1,jLabel2,jLabel34,jLabel35,jLabel36,
        };
        JLabel labels [] = {
            lbSearchResult,lbSearchResult1,lbSearchResult2,
        };
        
        JLabel formsHeaderLabels [] = {
            jLabel4,jLabel12,jLabel14,jLabel16,
        };
        JLabel textFieldHeaderLabels [] = {
            jLabel5,jLabel6,jLabel7,jLabel8,jLabel9,jLabel10,jLabel13,jLabel11,jLabel15,
        };
        
        for (JLabel n : titleHeaderLabels) {
            n.setFont(myPSemiBold.deriveFont(12F));
            n.setForeground(Color.WHITE);
        }
        
        for(JLabel n : labels){
            n.setFont(myPReg.deriveFont(12F));
            n.setForeground(Color.WHITE);
        }
        
        for(JLabel n : formsHeaderLabels){
            n.setFont(myPSemiBold.deriveFont(12F));
            n.setForeground(Color.BLACK);
        }
        
        for(JLabel n : textFieldHeaderLabels){
            n.setFont(myPSemiBold.deriveFont(12F));
            n.setForeground(Color.BLACK);
        }
    }
    private void loadTextFields(){
        JTextField searchFields [] = {
            tfSearchLoad,
            tfSearchSection,
            tfSearchUser,
            tfSearchUser1,
            tfSearchLoad1,
            tfSearchSection2,
            
            tfSearchStudent,tfSearchStudent1,tfSearchSection1,
            
            tfSearchUser2,
        };
        JTextField forms [] = {
            tfSectionName,tfSectionName1
        };
        
        for(JTextField n : searchFields){
            n.setFont(myPReg.deriveFont(12F));
        }
        for(JTextField n : forms){
            n.setFont(myPReg.deriveFont(12F));
        }
    }
    private void loadYearDropDowns(int numberOfYears){
        JComboBox [] yearDropDowns = {
            jcbSchoolYear,jcbSchoolYear1,
        };
        
        JComboBox [] yearDropDownsWithAllOption = {
            jcbSchoolYear2,jcbSchoolYear3,jcbSchoolYear4,
        };
        JComboBox [] dropDowns = {
            
        };
        int startingYear = 2019;
        
        for(JComboBox n : yearDropDowns){
            n.removeAllItems();
            n.setFont(myPReg.deriveFont(12F));
            for(int x=0;x<numberOfYears;x++){
                n.addItem(String.valueOf(startingYear+x));
            }
        }
        for(JComboBox n : yearDropDownsWithAllOption){
            n.removeAllItems();
            n.setFont(myPReg.deriveFont(12F));
            n.addItem("All");
            for(int x=0;x<numberOfYears;x++){
                n.addItem(String.valueOf(startingYear+x));
            }
        }
        for(JComboBox n : dropDowns){
            n.setFont(myPReg.deriveFont(12F));
        }
    }
    
    private void setCustomFontsForOtherViews(){
      
        JLabel otherViews [] = {tab1Label,tab2Label,tab3Label};
        
        for (JLabel lb: otherViews){
            lb.setFont(poppins14);
        }
        
        jLabel38.setFont(poppins48);
        jLabel96.setFont(poppins19);
        
        lbWelcome.setFont(poppins12R);
        lbUsername.setFont(poppins14);
        lbAccess.setFont(poppins12R);
        
       
        
    }
    
    public final void myInitComponents(){
        lbSearchResult.setForeground(new java.awt.Color(0,0,0));
        lbSearchResult.setText("Search using the search bar...");
        
//        btnSearchSection.setBackground(new java.awt.Color(251,185,211));
        
        tab1Label.setFont(poppins16);
        tab2Label.setFont(poppins16);
        tab3Label.setFont(poppins16);
//        tab4Label.setFont(poppins16);
//        tab5Label.setFont(poppins16);
//        tab6Label.setFont(poppins16);
        jLabel38.setFont(poppins48);
        jLabel96.setFont(poppins19);
//        label1.setFont(poppins16);
//        label2.setFont(poppins16);
//        label3.setFont(poppins16);
        
        tab1.setBackground(new java.awt.Color(253,232,240));
//        tab2.setBackground(new java.awt.Color(251,185,211));
//        tab3.setBackground(new java.awt.Color(251,185,211));
        
        
        
    }
    void setTableColoumnWidth(){
    TableColumnModel columnModel = enrollmentTable.getColumnModel();
    columnModel.getColumn(1).setPreferredWidth(150);
    columnModel.getColumn(2).setPreferredWidth(180);
    columnModel.getColumn(3).setPreferredWidth(50);
    columnModel.getColumn(4).setPreferredWidth(180);
    columnModel.getColumn(5).setPreferredWidth(180);
    columnModel.getColumn(6).setPreferredWidth(180);
    columnModel.getColumn(7).setPreferredWidth(180);
    columnModel.getColumn(8).setPreferredWidth(180);
    
    TableColumnModel columnModelStudentTable = studentTable.getColumnModel();
    columnModelStudentTable.getColumn(1).setPreferredWidth(150);
    columnModelStudentTable.getColumn(2).setPreferredWidth(180);
    columnModelStudentTable.getColumn(3).setPreferredWidth(180);
    columnModelStudentTable.getColumn(4).setPreferredWidth(180);
    
    TableColumnModel columnModelSectionsTable1 = sectionsTable1.getColumnModel();
    columnModelSectionsTable1.getColumn(1).setPreferredWidth(150);
    columnModelSectionsTable1.getColumn(2).setPreferredWidth(180);
    columnModelSectionsTable1.getColumn(3).setPreferredWidth(180);
    columnModelSectionsTable1.getColumn(4).setPreferredWidth(180);
    
    TableColumnModel columnModelUsersTable1 = usersTable1.getColumnModel();
    columnModelUsersTable1.getColumn(1).setPreferredWidth(180);
    columnModelUsersTable1.getColumn(2).setPreferredWidth(150);
    columnModelUsersTable1.getColumn(3).setPreferredWidth(180);
    
    TableColumnModel columnModelUsersTable = usersTable.getColumnModel();
    columnModelUsersTable.getColumn(1).setPreferredWidth(150);
    columnModelUsersTable.getColumn(2).setPreferredWidth(150);
    columnModelUsersTable.getColumn(3).setPreferredWidth(150);

    TableColumnModel columnModelSectionsTable2 = sectionsTable2.getColumnModel();
    columnModelSectionsTable2.getColumn(1).setPreferredWidth(150);
    columnModelSectionsTable2.getColumn(2).setPreferredWidth(180);
    columnModelSectionsTable2.getColumn(3).setPreferredWidth(180);
    columnModelSectionsTable2.getColumn(4).setPreferredWidth(180);
    columnModelSectionsTable2.getColumn(5).setPreferredWidth(180);
    columnModelSectionsTable2.getColumn(6).setPreferredWidth(180);
    columnModelSectionsTable2.getColumn(7).setPreferredWidth(180);
    columnModelSectionsTable2.getColumn(8).setPreferredWidth(180);
    columnModelSectionsTable2.getColumn(9).setPreferredWidth(180);
    
    TableColumnModel columnModelAssignedTeacherTable = assignedTeacherTable.getColumnModel();
    columnModelAssignedTeacherTable.getColumn(1).setPreferredWidth(150);
    columnModelAssignedTeacherTable.getColumn(2).setPreferredWidth(150);
    columnModelAssignedTeacherTable.getColumn(3).setPreferredWidth(150);
    columnModelAssignedTeacherTable.getColumn(4).setPreferredWidth(150);
    columnModelAssignedTeacherTable.getColumn(5).setPreferredWidth(150);
    columnModelAssignedTeacherTable.getColumn(6).setPreferredWidth(150);
    columnModelAssignedTeacherTable.getColumn(7).setPreferredWidth(100);
    columnModelAssignedTeacherTable.getColumn(8).setPreferredWidth(100);



    }
    
    //</editor-fold>
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addNewSectionPanel;
    private javax.swing.JPanel assignSubjectTeacherTab;
    private javax.swing.JTable assignedTeacherTable;
    private javax.swing.JButton btnAddNewSection;
    private javax.swing.JButton btnAssignTeacher;
    private javax.swing.JButton btnEditSubjectTeacher;
    private javax.swing.JButton btnEnrollStudent;
    private javax.swing.JButton btnNone;
    private javax.swing.JButton btnRefreshList;
    private javax.swing.JButton btnSaveSectionChanges;
    private javax.swing.JButton btnSaveSubjectTeacherChanges;
    private javax.swing.JButton btnSearchLoad;
    private javax.swing.JButton btnSearchLoad1;
    private javax.swing.JButton btnSearchSection;
    private javax.swing.JButton btnSearchSection1;
    private javax.swing.JButton btnSearchSection2;
    private javax.swing.JButton btnSearchStudent;
    private javax.swing.JButton btnSearchStudent1;
    private javax.swing.JButton btnSearchUser;
    private javax.swing.JButton btnSearchUser1;
    private javax.swing.JButton btnSearchUser2;
    private javax.swing.JPanel detailsTab;
    private javax.swing.JPanel editSectionPanel;
    private javax.swing.JPanel enrollStudentPanel;
    private javax.swing.JTable enrollmentTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel3;
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
    private javax.swing.JSplitPane jSplitPane3;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JComboBox<String> jcbSchoolYear;
    private javax.swing.JComboBox<String> jcbSchoolYear1;
    private javax.swing.JComboBox<String> jcbSchoolYear2;
    private javax.swing.JComboBox<String> jcbSchoolYear3;
    private javax.swing.JComboBox<String> jcbSchoolYear4;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lbAccess;
    private javax.swing.JLabel lbSearchResult;
    private javax.swing.JLabel lbSearchResult1;
    private javax.swing.JLabel lbSearchResult2;
    private javax.swing.JLabel lbSectionId;
    private javax.swing.JLabel lbUsername;
    private javax.swing.JLabel lbWelcome;
    private javax.swing.JPanel left;
    private javax.swing.JPanel left1;
    private javax.swing.JPanel left2;
    private javax.swing.JTable loadsTable;
    private javax.swing.JTable loadsTable1;
    private javax.swing.JMenuItem logout;
    private javax.swing.JPanel manageEnroleesTab;
    private javax.swing.JPanel manageSectionsTab;
    private javax.swing.JMenu menu;
    private javax.swing.JPanel myCards;
    private javax.swing.JPanel right;
    private javax.swing.JPanel right1;
    private javax.swing.JPanel right2;
    private javax.swing.JTabbedPane sectionsTab;
    private javax.swing.JTable sectionsTable;
    private javax.swing.JTable sectionsTable1;
    private javax.swing.JTable sectionsTable2;
    private javax.swing.JPanel selectTeacherTab;
    private javax.swing.JTable studentTable;
    private javax.swing.JTable subjectTable;
    private javax.swing.JTabbedPane subjectTeacherTab;
    private javax.swing.JPanel tab1;
    private javax.swing.JLabel tab1Label;
    private javax.swing.JPanel tab2;
    private javax.swing.JLabel tab2Label;
    private javax.swing.JPanel tab3;
    private javax.swing.JLabel tab3Label;
    private javax.swing.JTextField tfSearchLoad;
    private javax.swing.JTextField tfSearchLoad1;
    private javax.swing.JTextField tfSearchSection;
    private javax.swing.JTextField tfSearchSection1;
    private javax.swing.JTextField tfSearchSection2;
    private javax.swing.JTextField tfSearchStudent;
    private javax.swing.JTextField tfSearchStudent1;
    private javax.swing.JTextField tfSearchUser;
    private javax.swing.JTextField tfSearchUser1;
    private javax.swing.JTextField tfSearchUser2;
    private javax.swing.JTextField tfSectionName;
    private javax.swing.JTextField tfSectionName1;
    private javax.swing.JTable usersTable;
    private javax.swing.JTable usersTable1;
    private javax.swing.JTable usersTable2;
    // End of variables declaration//GEN-END:variables
}
