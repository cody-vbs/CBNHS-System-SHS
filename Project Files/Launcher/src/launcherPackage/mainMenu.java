package launcherPackage;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Phil Rey Paderogao
 */
public class mainMenu extends javax.swing.JFrame {
    
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
    /**
     * Creates new form mainMenu
     */
    public mainMenu() {
        
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
        
        reloadSettingFields();
        
        loadLabels();
        loadTextFields();
        loadColoredButtons();
        loadTabIcons();
        setScrollSpeeds();
        
        tab1.setBackground(Color.decode("#FDE8F0"));

        tab2.setBackground(Color.decode("#FBB9D3"));
        tab3.setBackground(Color.decode("#FBB9D3"));
    }
    private void reloadSettingFields(){
//        lbSchoolName.setText(myVariables.getSchoolName());
//        lbSchoolAddress.setText(myVariables.getSchoolAddress());
        
        tfSchoolName.setText(myVariables.getSchoolName());
        tfSchoolAddress.setText(myVariables.getSchoolAddress());
        tfSchoolId.setText(myVariables.getSchoolId());
        
        tfDistrict.setText(myVariables.getDistrict());
        tfDivision.setText(myVariables.getDivision());
        tfRegion.setText(myVariables.getRegion());
        
        tfSchoolHead.setText(myVariables.getPrincipal());
        tfDivisionRepresentative.setText(myVariables.getDivisionRepresentative());
        tfDivisionSuperintendent.setText(myVariables.getDivisionSuperintendent());
        
        try {
            jcbLoadingSpeed.setSelectedIndex(myVariables.getLoadingSpeed());
        } catch (Exception e) {
            jcbLoadingSpeed.setSelectedIndex(0);
        }
        
        tfIpAddress.setText(myVariables.getIpAddressOnly());
    }
    
    private void loadTextFields(){
        JTextField searchFields [] = {
            
        };
        JTextField forms [] = {
            tfSchoolName,
            tfSchoolAddress,
            tfSchoolId,
            
            tfDistrict,
            tfDivision,
            tfRegion,
            
            tfSchoolHead,
            tfDivisionRepresentative,
            tfDivisionSuperintendent,
            
            tfIpAddress,
        };
        
        for(JTextField n : searchFields){
            n.setFont(myVariables.SEARCH_TEXTFIELD_FONT);
        }
        for(JTextField n : forms){
            n.setFont(myVariables.TEXTFIELD_FONT);
        }
    }
    private void setScrollSpeeds(){
        JScrollPane scrollpanes [] = {
            jScrollPane2,
            settings,
            about,
        };
        
        int scrollSpeed = 15;
        
        for(int n=0;n<scrollpanes.length;n++){
            scrollpanes[n].getVerticalScrollBar().setUnitIncrement(scrollSpeed);
            scrollpanes[n].getHorizontalScrollBar().setUnitIncrement(scrollSpeed);
        }
    }
    private void loadTabIcons(){
        Icon tabIcons [] = {
            my.getImgIcn(myVariables.getHomeIcon()),
            my.getImgIcn(myVariables.getSettingsIcon()),
            my.getImgIcn(myVariables.getAboutIcon()),
        };
        
        for(int n=0;n<tabIcons.length;n++){
//            mainTab.setIconAt(n,tabIcons[n]);
        }
        
//        mainTab.setFont(myVariables.TAB_HEADER_FONT);
    }
    private void loadLabels(){
        JLabel titleHeaderLabels [] = {
            jLabel36,jLabel37,jLabel38,jLabel40,
        };
        JLabel labels [] = {
            
        };
        
        JLabel formsHeaderLabels [] = {
            jLabel1,jLabel5,jLabel9,
        };
        JLabel textFieldHeaderLabels [] = {
            jLabel2,jLabel3,jLabel4,jLabel6,jLabel7,jLabel8,jLabel10,jLabel11,jLabel12,
            jLabel13,jLabel14,
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
    private void loadColoredButtons(){
        JButton buttons [] = {
            btnSaveSettings,
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
            lightButtons[n].setBackground(new Color(214, 255, 183));
            lightButtons[n].setForeground(new Color(22,66,33));            
            lightButtons[n].setFont(new Font("Comic Sans MS",Font.BOLD,12));
            //buttons[n].setCursor(my.getCursor(myVariables.getHandCursor()));
            lightButtons[n].setCursor(new Cursor(Cursor.HAND_CURSOR));
            lightButtons[n].setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel2 = new keeptoo.KGradientPanel();
        headerPanel = new javax.swing.JPanel();
        tab1 = new javax.swing.JPanel();
        tab1label = new javax.swing.JLabel();
        tab2 = new javax.swing.JPanel();
        tab2label = new javax.swing.JLabel();
        tab3 = new javax.swing.JPanel();
        tab3label = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        myCards = new javax.swing.JPanel();
        homeTab = new javax.swing.JPanel();
        home = new javax.swing.JSplitPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        btnEnrollment = new javax.swing.JLabel();
        btnRegistration = new javax.swing.JLabel();
        btnAttendance = new javax.swing.JLabel();
        btnWeighing = new javax.swing.JLabel();
        btnBookKeepimg = new javax.swing.JLabel();
        btnGrading = new javax.swing.JLabel();
        btnForms = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtaModuleInformation = new javax.swing.JTextArea();
        jLabel37 = new javax.swing.JLabel();
        settingsTab = new javax.swing.JPanel();
        settings = new javax.swing.JScrollPane();
        kGradientPanel3 = new keeptoo.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfSchoolName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfSchoolAddress = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfSchoolId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfDistrict = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfDivision = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfRegion = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tfSchoolHead = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tfDivisionRepresentative = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        tfDivisionSuperintendent = new javax.swing.JTextField();
        jcbLoadingSpeed = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        btnSaveSettings = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        tfIpAddress = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel40 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        aboutTab = new javax.swing.JPanel();
        about = new javax.swing.JScrollPane();
        kGradientPanel4 = new keeptoo.KGradientPanel();
        jLabel15 = new javax.swing.JLabel();
        mainTab = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HiSRMS v2.0");
        setIconImage(my.getImgIcn(myVariables.getLauncherIcon()).getImage()
        );
        setMinimumSize(new java.awt.Dimension(1284, 770));
        setResizable(false);

        kGradientPanel2.setkEndColor(new java.awt.Color(249, 239, 227));
        kGradientPanel2.setkStartColor(new java.awt.Color(249, 239, 227));

        headerPanel.setBackground(new java.awt.Color(251, 185, 211));
        headerPanel.setMinimumSize(new java.awt.Dimension(270, 723));
        headerPanel.setPreferredSize(new java.awt.Dimension(270, 723));

        tab1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab1MouseClicked(evt);
            }
        });

        tab1label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/launcherPackage/icons/icons8_home_20px_1.png"))); // NOI18N
        tab1label.setText("   Home");

        javax.swing.GroupLayout tab1Layout = new javax.swing.GroupLayout(tab1);
        tab1.setLayout(tab1Layout);
        tab1Layout.setHorizontalGroup(
            tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(tab1label, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        tab1Layout.setVerticalGroup(
            tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tab1label, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        tab2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab2MouseClicked(evt);
            }
        });

        tab2label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/launcherPackage/icons/icons8_settings_20px.png"))); // NOI18N
        tab2label.setText("   Settings");

        javax.swing.GroupLayout tab2Layout = new javax.swing.GroupLayout(tab2);
        tab2.setLayout(tab2Layout);
        tab2Layout.setHorizontalGroup(
            tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(tab2label, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tab2Layout.setVerticalGroup(
            tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tab2label, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        tab3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab3MouseClicked(evt);
            }
        });

        tab3label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/launcherPackage/icons/icons8_about_20px.png"))); // NOI18N
        tab3label.setText("   About");

        javax.swing.GroupLayout tab3Layout = new javax.swing.GroupLayout(tab3);
        tab3.setLayout(tab3Layout);
        tab3Layout.setHorizontalGroup(
            tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(tab3label, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tab3Layout.setVerticalGroup(
            tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tab3label, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/launcherPackage/icons/cbshs.png"))); // NOI18N

        jLabel17.setFont(new java.awt.Font("Century Gothic", 1, 48)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(58, 57, 57));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("SHS");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(58, 57, 57));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("SYSTEMS");

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tab1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tab2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tab3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jLabel16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tab1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tab2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tab3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        myCards.setMinimumSize(new java.awt.Dimension(815, 635));
        myCards.setLayout(new java.awt.CardLayout());

        homeTab.setMinimumSize(new java.awt.Dimension(815, 635));
        homeTab.setPreferredSize(new java.awt.Dimension(815, 635));

        home.setBorder(null);
        home.setDividerLocation(475);
        home.setResizeWeight(1.0);

        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        kGradientPanel1.setkEndColor(new java.awt.Color(203, 184, 160));
        kGradientPanel1.setkStartColor(new java.awt.Color(203, 184, 160));
        kGradientPanel1.setkTransparentControls(false);

        btnEnrollment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/launcherPackage/buttons/Enrollment.png"))); // NOI18N
        btnEnrollment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEnrollment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEnrollmentMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEnrollmentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEnrollmentMouseExited(evt);
            }
        });

        btnRegistration.setIcon(new javax.swing.ImageIcon(getClass().getResource("/launcherPackage/buttons/Registration.png"))); // NOI18N
        btnRegistration.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistration.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistrationMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegistrationMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegistrationMouseExited(evt);
            }
        });

        btnAttendance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/launcherPackage/buttons/Attendance.png"))); // NOI18N
        btnAttendance.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAttendance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAttendanceMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAttendanceMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAttendanceMouseExited(evt);
            }
        });

        btnWeighing.setIcon(new javax.swing.ImageIcon(getClass().getResource("/launcherPackage/buttons/Weighing_.png"))); // NOI18N
        btnWeighing.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnWeighing.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnWeighingMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnWeighingMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnWeighingMouseExited(evt);
            }
        });

        btnBookKeepimg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/launcherPackage/buttons/Book Keeping.png"))); // NOI18N
        btnBookKeepimg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBookKeepimg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBookKeepimgMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBookKeepimgMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBookKeepimgMouseExited(evt);
            }
        });

        btnGrading.setIcon(new javax.swing.ImageIcon(getClass().getResource("/launcherPackage/buttons/Grading.png"))); // NOI18N
        btnGrading.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGrading.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGradingMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGradingMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGradingMouseExited(evt);
            }
        });

        btnForms.setIcon(new javax.swing.ImageIcon(getClass().getResource("/launcherPackage/buttons/Forms.png"))); // NOI18N
        btnForms.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnForms.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFormsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFormsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFormsMouseExited(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Select Module");

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnForms)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(btnWeighing)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBookKeepimg)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGrading))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(btnRegistration)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEnrollment)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAttendance))
                    .addComponent(jLabel36))
                .addContainerGap(423, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel36)
                .addGap(30, 30, 30)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAttendance)
                    .addComponent(btnRegistration)
                    .addComponent(btnEnrollment))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnWeighing)
                    .addComponent(btnBookKeepimg)
                    .addComponent(btnGrading))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnForms)
                .addGap(0, 205, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(kGradientPanel1);

        home.setLeftComponent(jScrollPane2);

        jPanel1.setBackground(new java.awt.Color(203, 184, 160));

        jtaModuleInformation.setEditable(false);
        jtaModuleInformation.setColumns(20);
        jtaModuleInformation.setFont(myVariables.TEXTFIELD_FONT);
        jtaModuleInformation.setLineWrap(true);
        jtaModuleInformation.setRows(5);
        jtaModuleInformation.setText("Select a System for more info.\n");
        jtaModuleInformation.setWrapStyleWord(true);
        jScrollPane3.setViewportView(jtaModuleInformation);

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("System Details");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel37)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
                .addContainerGap())
        );

        home.setRightComponent(jPanel1);

        javax.swing.GroupLayout homeTabLayout = new javax.swing.GroupLayout(homeTab);
        homeTab.setLayout(homeTabLayout);
        homeTabLayout.setHorizontalGroup(
            homeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 815, Short.MAX_VALUE)
            .addGroup(homeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(home, javax.swing.GroupLayout.DEFAULT_SIZE, 815, Short.MAX_VALUE))
        );
        homeTabLayout.setVerticalGroup(
            homeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 635, Short.MAX_VALUE)
            .addGroup(homeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(home, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE))
        );

        myCards.add(homeTab, "card6");

        settingsTab.setMinimumSize(new java.awt.Dimension(815, 635));
        settingsTab.setPreferredSize(new java.awt.Dimension(815, 635));

        settings.setPreferredSize(new java.awt.Dimension(817, 637));

        kGradientPanel3.setkEndColor(new java.awt.Color(203, 184, 160));
        kGradientPanel3.setkStartColor(new java.awt.Color(203, 184, 160));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("School Details");

        jLabel2.setText("School Name");

        jLabel3.setText("Address");

        jLabel4.setText("School ID");

        tfSchoolId.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Department Details");

        jLabel6.setText("District");

        jLabel7.setText("Division");

        jLabel8.setText("Region");

        tfRegion.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Personnel Details");

        jLabel10.setText("School Head");

        jLabel11.setText("Division Representative");

        jLabel12.setText("Division Superintendent");

        jcbLoadingSpeed.setFont(myVariables.TEXTFIELD_FONT);
        jcbLoadingSpeed.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Normal (Default)", "Fast", "Very Fast " }));

        jLabel13.setText("Loading Speed");

        btnSaveSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/launcherPackage/icons/icons8_save_16px.png"))); // NOI18N
        btnSaveSettings.setText("Save Changes");
        btnSaveSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveSettingsActionPerformed(evt);
            }
        });

        jLabel14.setText("IP Address");

        tfIpAddress.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("General");

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Performance");

        javax.swing.GroupLayout kGradientPanel3Layout = new javax.swing.GroupLayout(kGradientPanel3);
        kGradientPanel3.setLayout(kGradientPanel3Layout);
        kGradientPanel3Layout.setHorizontalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel3Layout.createSequentialGroup()
                        .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel38)
                                .addGap(378, 378, 378))
                            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                                .addComponent(jSeparator2)
                                .addGap(34, 34, 34)))
                        .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                                .addContainerGap(340, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfIpAddress)
                                    .addGroup(kGradientPanel3Layout.createSequentialGroup()
                                        .addComponent(jcbLoadingSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel40)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                                .addComponent(jSeparator3)
                                .addContainerGap())))
                    .addGroup(kGradientPanel3Layout.createSequentialGroup()
                        .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfSchoolAddress, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfSchoolId, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfDistrict, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfDivision, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfRegion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfSchoolHead, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfDivisionRepresentative, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfSchoolName, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(kGradientPanel3Layout.createSequentialGroup()
                        .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfDivisionSuperintendent, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSaveSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 937, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        kGradientPanel3Layout.setVerticalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(jLabel40))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfSchoolName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfSchoolAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfSchoolId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfIpAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcbLoadingSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfDistrict, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfDivision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfRegion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfSchoolHead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfDivisionRepresentative, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfDivisionSuperintendent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnSaveSettings)
                .addContainerGap(239, Short.MAX_VALUE))
        );

        settings.setViewportView(kGradientPanel3);

        javax.swing.GroupLayout settingsTabLayout = new javax.swing.GroupLayout(settingsTab);
        settingsTab.setLayout(settingsTabLayout);
        settingsTabLayout.setHorizontalGroup(
            settingsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(settings, javax.swing.GroupLayout.DEFAULT_SIZE, 986, Short.MAX_VALUE)
        );
        settingsTabLayout.setVerticalGroup(
            settingsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(settings, javax.swing.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE)
        );

        myCards.add(settingsTab, "card6");

        aboutTab.setMinimumSize(new java.awt.Dimension(815, 635));
        aboutTab.setPreferredSize(new java.awt.Dimension(815, 635));

        kGradientPanel4.setkEndColor(new java.awt.Color(203, 184, 160));
        kGradientPanel4.setkStartColor(new java.awt.Color(203, 184, 160));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/launcherPackage/icons/About Tab.png"))); // NOI18N

        javax.swing.GroupLayout kGradientPanel4Layout = new javax.swing.GroupLayout(kGradientPanel4);
        kGradientPanel4.setLayout(kGradientPanel4Layout);
        kGradientPanel4Layout.setHorizontalGroup(
            kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 776, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(181, Short.MAX_VALUE))
        );
        kGradientPanel4Layout.setVerticalGroup(
            kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(238, 238, 238))
        );

        about.setViewportView(kGradientPanel4);

        javax.swing.GroupLayout aboutTabLayout = new javax.swing.GroupLayout(aboutTab);
        aboutTab.setLayout(aboutTabLayout);
        aboutTabLayout.setHorizontalGroup(
            aboutTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(about, javax.swing.GroupLayout.DEFAULT_SIZE, 986, Short.MAX_VALUE)
        );
        aboutTabLayout.setVerticalGroup(
            aboutTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(about, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE)
        );

        myCards.add(aboutTab, "card6");

        mainTab.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        mainTab.setToolTipText("");
        mainTab.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        mainTab.setMinimumSize(new java.awt.Dimension(100, 100));
        mainTab.setPreferredSize(new java.awt.Dimension(1068, 548));
        myCards.add(mainTab, "card5");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(myCards, javax.swing.GroupLayout.DEFAULT_SIZE, 986, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(myCards, javax.swing.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrationMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrationMouseEntered
        btnRegistration.setIcon(my.getImgIcn(myVariables.getRegistrationActBtnIcon()));
        selectModuleInfo(1);
    }//GEN-LAST:event_btnRegistrationMouseEntered

    private void btnRegistrationMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrationMouseExited
        btnRegistration.setIcon(my.getImgIcn(myVariables.getRegistrationBtnIcon()));
        selectModuleInfo(0);
    }//GEN-LAST:event_btnRegistrationMouseExited

    private void btnEnrollmentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnrollmentMouseEntered
        btnEnrollment.setIcon(my.getImgIcn(myVariables.getEnrollmentActBtnIcon()));
        selectModuleInfo(2);
    }//GEN-LAST:event_btnEnrollmentMouseEntered

    private void btnEnrollmentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnrollmentMouseExited
        btnEnrollment.setIcon(my.getImgIcn(myVariables.getEnrollmentBtnIcon()));
        selectModuleInfo(0);
    }//GEN-LAST:event_btnEnrollmentMouseExited

    private void btnAttendanceMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAttendanceMouseEntered
        btnAttendance.setIcon(my.getImgIcn(myVariables.getAttendanceActBtnIcon()));
        selectModuleInfo(3);
    }//GEN-LAST:event_btnAttendanceMouseEntered

    private void btnAttendanceMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAttendanceMouseExited
        btnAttendance.setIcon(my.getImgIcn(myVariables.getAttendanceBtnIcon()));
        selectModuleInfo(0);
    }//GEN-LAST:event_btnAttendanceMouseExited

    private void btnWeighingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnWeighingMouseEntered
        btnWeighing.setIcon(my.getImgIcn(myVariables.getWeighingActBtnIcon()));
        selectModuleInfo(4);
    }//GEN-LAST:event_btnWeighingMouseEntered

    private void btnWeighingMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnWeighingMouseExited
        btnWeighing.setIcon(my.getImgIcn(myVariables.getWeighingBtnIcon()));
        selectModuleInfo(0);
    }//GEN-LAST:event_btnWeighingMouseExited

    private void btnBookKeepimgMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBookKeepimgMouseEntered
        btnBookKeepimg.setIcon(my.getImgIcn(myVariables.getBookKeepActBtnIcon()));
        selectModuleInfo(5);
    }//GEN-LAST:event_btnBookKeepimgMouseEntered

    private void btnBookKeepimgMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBookKeepimgMouseExited
        btnBookKeepimg.setIcon(my.getImgIcn(myVariables.getBookKeepBtnIcon()));
        selectModuleInfo(0);
    }//GEN-LAST:event_btnBookKeepimgMouseExited

    private void btnGradingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGradingMouseEntered
        btnGrading.setIcon(my.getImgIcn(myVariables.getGradingActBtnIcon()));
        selectModuleInfo(6);
    }//GEN-LAST:event_btnGradingMouseEntered

    private void btnGradingMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGradingMouseExited
        btnGrading.setIcon(my.getImgIcn(myVariables.getGradingBtnIcon()));
        selectModuleInfo(0);
    }//GEN-LAST:event_btnGradingMouseExited

    private void btnFormsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFormsMouseEntered
        btnForms.setIcon(my.getImgIcn(myVariables.getFormsActBtnIcon()));
        selectModuleInfo(7);
    }//GEN-LAST:event_btnFormsMouseEntered

    private void btnFormsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFormsMouseExited
        btnForms.setIcon(my.getImgIcn(myVariables.getFormsBtnIcon()));
        selectModuleInfo(0);
    }//GEN-LAST:event_btnFormsMouseExited

    private void btnBookKeepimgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBookKeepimgMouseClicked
        runModule(5,true);
    }//GEN-LAST:event_btnBookKeepimgMouseClicked

    private void btnSaveSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveSettingsActionPerformed
        String schoolName = tfSchoolName.getText().trim();
        String schoolAddress = tfSchoolAddress.getText().trim();
        String schoolId = tfSchoolId.getText().trim();
        
        String district = tfDistrict.getText().trim();
        String division = tfDivision.getText().trim();
        String region = tfRegion.getText().trim();
        
        String schoolHead = tfSchoolHead.getText().trim();
        String representative = tfDivisionRepresentative.getText().trim();
        String superintendent = tfDivisionSuperintendent.getText().trim();
        
        String ipAddress = tfIpAddress.getText().trim();
        int speed = jcbLoadingSpeed.getSelectedIndex();
        
        myVariables.setSchoolName(schoolName.length()>0? schoolName:" ");
        myVariables.setSchoolAddress(schoolAddress.length()>0? schoolAddress:" ");
        myVariables.setSchoolId(schoolId.length()>0? schoolId:" ");
        
        myVariables.setDistrict(district.length()>0? district:" ");
        myVariables.setDivision(division.length()>0? division:" ");
        myVariables.setRegion(region.length()>0? region:" ");
        
        myVariables.setPrincipal(schoolHead.length()>0? schoolHead:" ");
        myVariables.setDivisionRepresentative(representative.length()>0? representative:" ");
        myVariables.setDivisionSuperintendent(superintendent.length()>0? superintendent:" ");
        
        myVariables.setIpAddressOnly(ipAddress.length()>0? ipAddress:" ");
        myVariables.setLoadingSpeed(speed);
        if (my.writeSettings()) {
            my.showMessage("Settings Saved.", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveSettingsActionPerformed

    private void btnRegistrationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrationMouseClicked
        runModule(1, true);
    }//GEN-LAST:event_btnRegistrationMouseClicked

    private void btnEnrollmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnrollmentMouseClicked
        runModule(2, true);
    }//GEN-LAST:event_btnEnrollmentMouseClicked

    private void btnAttendanceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAttendanceMouseClicked
        runModule(3, true);
    }//GEN-LAST:event_btnAttendanceMouseClicked

    private void btnWeighingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnWeighingMouseClicked
        runModule(4, true);
    }//GEN-LAST:event_btnWeighingMouseClicked

    private void btnGradingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGradingMouseClicked
        runModule(6, true);
    }//GEN-LAST:event_btnGradingMouseClicked

    private void btnFormsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFormsMouseClicked
        runModule(7, true);
    }//GEN-LAST:event_btnFormsMouseClicked

    private void tab1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab1MouseClicked
        // TODO add your handling code here:
        myCards.removeAll();
        myCards.add(homeTab);
        myCards.repaint();
        myCards.revalidate();

        tab1.setBackground(Color.decode("#FDE8F0"));

        tab2.setBackground(Color.decode("#FBB9D3"));
        tab3.setBackground(Color.decode("#FBB9D3"));
    }//GEN-LAST:event_tab1MouseClicked

    private void tab2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab2MouseClicked
        // TODO add your handling code here:
        myCards.removeAll();
        myCards.add(settingsTab);
        myCards.repaint();
        myCards.revalidate();

        tab2.setBackground(Color.decode("#FDE8F0"));

        tab1.setBackground(Color.decode("#FBB9D3"));
        tab3.setBackground(Color.decode("#FBB9D3"));
    }//GEN-LAST:event_tab2MouseClicked

    private void tab3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab3MouseClicked
        // TODO add your handling code here:
        myCards.removeAll();
        myCards.add(aboutTab);
        myCards.repaint();
        myCards.revalidate();

        tab3.setBackground(Color.decode("#FDE8F0"));

        tab2.setBackground(Color.decode("#FBB9D3"));
        tab1.setBackground(Color.decode("#FBB9D3"));
    }//GEN-LAST:event_tab3MouseClicked

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
            java.util.logging.Logger.getLogger(mainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainMenu().setVisible(true);
            }
        });
    }
    //<editor-fold desc="Custom Functions">
    private static final String moduleInformation [] = {
        "Select a System for more info.",
        "Registration",
        "Enrollment",
        "Attendance",
        "Weighing",
        "Book Keeping",
        "Grading",
        "Forms"
    };
    
    private void selectModuleInfo(int index){
        jtaModuleInformation.setText(moduleInformation[index]);
    }
    private void runModule(int index,boolean minimizeOpened){
        boolean opened = false;
        switch(index){
            case 1:{
                opened = my.runExeFile("modules/Registration_System_Final.jar",false);
                break;
            }case 2:{
                opened = my.runExeFile("modules/Enrollment_System_Final.exe",false);
                break;
            }case 3:{
                opened = my.runExeFile("modules/Attendance_System_Final.jar",false);
                break;
            }case 4:{
                opened = my.runExeFile("modules/Weighing_System_Final__SHS_.exe",false);
                break;
            }case 5:{
                opened = my.runExeFile("modules/Book_Keeping_System.exe",false);
                break;
            }case 6:{
                opened = my.runExeFile("modules/grading.exe",false);
                break;
            }case 7:{
                opened = my.runExeFile("modules/forms.exe",false);
                break;
            }
        }
        if(minimizeOpened){
            if(opened){
                this.setState(JFrame.ICONIFIED);
            }else{
                this.setState(JFrame.NORMAL);
            }
        }
    }
    public void myInitComponents(){
//        lbSearchResult.setForeground(new java.awt.Color(0,0,0));
//        lbSearchResult.setText("Search using the search bar...");
        
//        btnSearchSection.setBackground(new java.awt.Color(251,185,211));
        
        
        jLabel17.setFont(poppins48);
        jLabel18.setFont(poppins24);
        tab1label.setFont(poppins14);
        tab2label.setFont(poppins14);
        tab3label.setFont(poppins14);
//        label2.setFont(poppins16);
//        label3.setFont(poppins16);
        
        tab1.setBackground(new java.awt.Color(253,232,240));
//        tab2.setBackground(new java.awt.Color(251,185,211));
//        tab3.setBackground(new java.awt.Color(251,185,211));
        
        
        
    }
    
    //</editor-fold>
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane about;
    private javax.swing.JPanel aboutTab;
    private javax.swing.JLabel btnAttendance;
    private javax.swing.JLabel btnBookKeepimg;
    private javax.swing.JLabel btnEnrollment;
    private javax.swing.JLabel btnForms;
    private javax.swing.JLabel btnGrading;
    private javax.swing.JLabel btnRegistration;
    private javax.swing.JButton btnSaveSettings;
    private javax.swing.JLabel btnWeighing;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JSplitPane home;
    private javax.swing.JPanel homeTab;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JComboBox<String> jcbLoadingSpeed;
    private javax.swing.JTextArea jtaModuleInformation;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private keeptoo.KGradientPanel kGradientPanel3;
    private keeptoo.KGradientPanel kGradientPanel4;
    private javax.swing.JTabbedPane mainTab;
    private javax.swing.JPanel myCards;
    private javax.swing.JScrollPane settings;
    private javax.swing.JPanel settingsTab;
    private javax.swing.JPanel tab1;
    private javax.swing.JLabel tab1label;
    private javax.swing.JPanel tab2;
    private javax.swing.JLabel tab2label;
    private javax.swing.JPanel tab3;
    private javax.swing.JLabel tab3label;
    private javax.swing.JTextField tfDistrict;
    private javax.swing.JTextField tfDivision;
    private javax.swing.JTextField tfDivisionRepresentative;
    private javax.swing.JTextField tfDivisionSuperintendent;
    private javax.swing.JTextField tfIpAddress;
    private javax.swing.JTextField tfRegion;
    private javax.swing.JTextField tfSchoolAddress;
    private javax.swing.JTextField tfSchoolHead;
    private javax.swing.JTextField tfSchoolId;
    private javax.swing.JTextField tfSchoolName;
    // End of variables declaration//GEN-END:variables
}
