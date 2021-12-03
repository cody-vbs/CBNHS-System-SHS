/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mahPackage;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.io.File;
import java.io.FileInputStream;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javazoom.jl.player.Player;
import static mahPackage.dashBoard.playErrorSound;

/**
 *
 * @author Phil Rey
 */
public class login extends javax.swing.JFrame implements java.lang.Runnable {
    
    myFunctions my;
    int attempts =0;
    /**
     * Creates new form login
     */
    public login() {
        my = new myFunctions(false);
        initComponents();
        loadColoredButtons();
        loadLabels();
        
        timer.setVisible(false);
        
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
        SwingUtilities.invokeLater(new dashBoard.PlaySuccessMessageSound());
    }
    
    void playError(){
        SwingUtilities.invokeLater(new dashBoard.PlayErrorMessageSound());
    }
    
    //attempts timer 
    
    @Override
    public void run() {
        this.runTimer();
    }

    public void runTimer(){
        int x = 30;
         while (x>0){
          timer.setVisible(true);
          timer.setText("Number of attempts exceeded. Please try again after " + x + " seconds" );
          
          //disable fields and button
          username.setEnabled(false);
          pass.setEnabled(false);
          jLabel2.setEnabled(false);
          jLabel4.setEnabled(false);
          jCheckBox1.setEnabled(false);
          btnLogin.setEnabled(false);
          try {
            x--;
            Thread.sleep(1000L);
           }
           catch (InterruptedException e) {
               System.out.println(e);
           }
         }
        timer.setVisible(false);
        username.setEnabled(true);
        pass.setEnabled(true);
        jLabel2.setEnabled(true);
        jLabel4.setEnabled(true);
        jCheckBox1.setEnabled(true);
        btnLogin.setEnabled(true);
        
        //set attempts back to 0
        attempts = 0;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        textbutton = new javax.swing.JPanel();
        btnLogin = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        username = new javax.swing.JTextField();
        pass = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        regis = new javax.swing.JLabel();
        timer = new javax.swing.JLabel();
        back = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        contactUs = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Welcome To Registration System");
        setIconImage(my.getImgIcn(myVariables.getRegistrationWindowIcon()).getImage());
        setName("loginFrame"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setOpaque(false);

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new Color(0xCBB8A0));
        jTextArea1.setColumns(10);
        jTextArea1.setFont(new Font ("Poppins", Font.PLAIN, 10));
        jTextArea1.setForeground(Color.BLACK);
        jTextArea1.setLineWrap(true);
        jTextArea1.setText("This system was developed in collaboration with the Department of Education (DepED), University of Southeastern Philippines (USeP) and Crossing Bayabas National High School (CBNHS) intended to automate the registration process.");
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextArea1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextArea1.setEnabled(false);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage/icons/depeduseplogo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jTextArea1)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jTextArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 370, 350, 110));

        textbutton.setOpaque(false);

        btnLogin.setBackground(new Color(0xCBB8A0));
        btnLogin.setFont(new Font ("Poppins", Font.BOLD, 12));
        btnLogin.setForeground(Color.BLACK);
        btnLogin.setText("LOGIN");
        btnLogin.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnLogin.setBorderPainted(false);
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginHandler(evt);
            }
        });

        jCheckBox1.setFont(new Font ("Poppins", Font.PLAIN, 12));
        jCheckBox1.setForeground(Color.BLACK);
        jCheckBox1.setText("SHOW PASSWORD");
        jCheckBox1.setIconTextGap(10);
        jCheckBox1.setOpaque(false);
        jCheckBox1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage/icons/icons8_checked_checkbox_20px.png"))); // NOI18N
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        username.setFont(new Font ("Poppins", Font.PLAIN, 12));
        username.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });

        pass.setFont(new Font ("Poppins", Font.PLAIN, 12));
        pass.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel2.setFont(new Font ("Poppins", Font.PLAIN, 12));
        jLabel2.setForeground(Color.BLACK);
        jLabel2.setText("USERNAME");

        jLabel4.setFont(new Font ("Poppins", Font.PLAIN, 12));
        jLabel4.setForeground(Color.BLACK);
        jLabel4.setText("PASSWORD");

        javax.swing.GroupLayout textbuttonLayout = new javax.swing.GroupLayout(textbutton);
        textbutton.setLayout(textbuttonLayout);
        textbuttonLayout.setHorizontalGroup(
            textbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(textbuttonLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(textbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1)
                    .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        textbuttonLayout.setVerticalGroup(
            textbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(textbuttonLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(5, 5, 5)
                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(textbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, 360, -1));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage/logs.png"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 360, 70));

        regis.setFont(new Font ("Poppins", Font.BOLD, 16));
        regis.setForeground(Color.BLACK);
        regis.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        regis.setText("REGISTRATION SYSTEM");
        getContentPane().add(regis, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, 360, 40));

        timer.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        timer.setForeground(new java.awt.Color(255, 0, 0));
        timer.setText("Number of attempts exceeded. Please try again after xx seconds");
        getContentPane().add(timer, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 330, -1, -1));

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage/final1.png"))); // NOI18N
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 500));

        contactUs.setText("Help");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage/icons/icons8-mail-20.png"))); // NOI18N
        jMenuItem1.setText("Having Trouble ? Contact Us");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        contactUs.add(jMenuItem1);

        jMenuBar1.add(contactUs);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loginHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginHandler
        // TODO add your handling code here:
        
        String userName = username.getText();
        String password = String.valueOf(pass.getPassword());
        
        //convert the password to md5 hash
        int result = my.login(userName, password, new int [] {3,4,5});
        
        switch(result){
            case 0:{
                my.openWindow(this,new dashBoard());
                break;
            }case 1:{
                Toolkit.getDefaultToolkit().beep();
                my.showMessage("Your account does not have the Access Level required\nto use this program.", JOptionPane.WARNING_MESSAGE);
                break;
            }case 2:{
                playError();
                my.showMessage("Incorrect Username or Password", JOptionPane.ERROR_MESSAGE);
                attempts++;
                
                //failed 5 login attempts disable the login system
                if(attempts >= 5){
                    Thread thread = new Thread(this);
                    thread.start();
                }
                
                
                
                break;
            }
        }
    }//GEN-LAST:event_loginHandler

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
         if(jCheckBox1.isSelected()){
             pass.setEchoChar((char) 0);
         }else{
             pass.setEchoChar('●');
         }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new contact().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }
    //<editor-fold desc="Custom Functions">    
    private void loadColoredButtons(){
        JButton buttons [] = {
            btnLogin,
        };
        Cursor tempC;
        for(int n=0;n<buttons.length;n++){
            buttons[n].setUI(new custom_styledButtonIU());
            buttons[n].setBackground(new Color(0xCBB8A0));
            buttons[n].setForeground(Color.BLACK);            
            buttons[n].setFont(myVariables.BUTTON_FONT);
            //buttons[n].setCursor(my.getCursor(myVariables.getHandCursor()));
            buttons[n].setCursor(new Cursor(Cursor.HAND_CURSOR));
            buttons[n].setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
    }
    private void loadLabels(){
        JLabel labelsLight [] = {
            
        };
        JLabel labelsDark [] = {
            
        };
        
        for(int n=0;n<labelsLight.length;n++){
            labelsLight[n].setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
            labelsLight[n].setForeground(Color.WHITE);
        }
        for(int n=0;n<labelsDark.length;n++){
            labelsDark[n].setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
            labelsDark[n].setForeground(Color.BLACK);
        }
    }
    
    //</editor-fold>
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JButton btnLogin;
    private javax.swing.JMenu contactUs;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JPasswordField pass;
    private javax.swing.JLabel regis;
    private javax.swing.JPanel textbutton;
    private javax.swing.JLabel timer;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
