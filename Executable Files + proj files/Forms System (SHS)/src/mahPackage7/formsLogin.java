/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mahPackage7;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javazoom.jl.player.Player;

/**
 *
<<<<<<< HEAD:Project Files/Enrollment System Final (SHS)/src/mahPackage2/login.java
 * @author Syd
=======
 * @author Phil Rey Paderogao
>>>>>>> 48bf8b4e31924623245a194efdb8f89e5d250d66:Project Files/Forms System (SHS)/src/mahPackage7/formsLogin.java
 */
public class formsLogin extends javax.swing.JFrame implements java.lang.Runnable {
    myFunctions my;
    int attempts =0;
    public formsLogin() {
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
        SwingUtilities.invokeLater(new PlaySuccessMessageSound());
    }
    
    void playError(){
        SwingUtilities.invokeLater(new PlayErrorMessageSound());
    }
    
    public void run() {
        this.runTimer();
    }

    public void runTimer(){
        int x = 30;
         while (x>0){
          timer.setVisible(true);
          timer.setText("Number of attempts exceeded. Please try again after " + x + " seconds" );
          
          //disable fields and button
          user.setEnabled(false);
          pass.setEnabled(false);
          jLabel2.setEnabled(false);
          //jLabel4.setEnabled(false);
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
        user.setEnabled(true);
        pass.setEnabled(true);
        jLabel2.setEnabled(true);
        //jLabel4.setEnabled(true);
        jCheckBox1.setEnabled(true);
        btnLogin.setEnabled(true);
        
        //set attempts back to 0
        attempts = 0;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logo1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        btnLogin = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        user = new javax.swing.JTextField();
        pass = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        forms = new javax.swing.JLabel();
        timer = new javax.swing.JLabel();
        back = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Welcome to Forms System");
        setIconImage(my.getImgIcn(myVariables.getFormsWindowIcon()).getImage()
        );
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/logs.png"))); // NOI18N
        logo1.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(logo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 360, 70));

        jPanel2.setOpaque(false);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/depeduseplogo.png"))); // NOI18N

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new Color(0xCBB8A0));
        jTextArea1.setColumns(10);
        jTextArea1.setFont(new Font("Poppins", Font.PLAIN, 10));
        jTextArea1.setLineWrap(true);
        jTextArea1.setText("This system was developed in collaboration with the Department of Education (DepED), University of Southeastern Philippines (USeP) and Crossing Bayabas National High School (CBNHS) intended to automate the making of School Forms.");
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextArea1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextArea1.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jTextArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(67, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jTextArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(53, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 360, 360, 130));

        jPanel1.setOpaque(false);

        btnLogin.setBackground(new Color(0xCBB8A0));
        btnLogin.setFont(new Font("Poppins", Font.BOLD, 12));
        btnLogin.setText("LOGIN");
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginloginHandler(evt);
            }
        });

        jCheckBox1.setFont(new Font("Poppins", Font.PLAIN, 12));
        jCheckBox1.setForeground(Color.BLACK);
        jCheckBox1.setText("SHOW PASSWORD");
        jCheckBox1.setIconTextGap(10);
        jCheckBox1.setOpaque(false);
        jCheckBox1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/icons8_tick_box_20px.png"))); // NOI18N
        jCheckBox1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/icons8_checked_checkbox_20px.png"))); // NOI18N
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        user.setFont(new Font("Poppins", Font.PLAIN, 12));
        user.setForeground(Color.BLACK);
        user.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        pass.setFont(new Font("Poppins", Font.PLAIN, 12));
        pass.setForeground(Color.BLACK);
        pass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passActionPerformed(evt);
            }
        });

        jLabel1.setFont(new Font("Poppins", Font.PLAIN, 12));
        jLabel1.setForeground(Color.BLACK);
        jLabel1.setText("USERNAME");

        jLabel2.setFont(new Font("Poppins", Font.PLAIN, 12));
        jLabel2.setText("PASSWORD");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pass, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                        .addComponent(user, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(6, 6, 6)
                .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(5, 5, 5)
                .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, 360, 210));

        forms.setFont(new Font("Poppins", Font.BOLD, 16));
        forms.setForeground(Color.BLACK);
        forms.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        forms.setText("FORMS SYSTEM");
        getContentPane().add(forms, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, 360, 30));

        timer.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        timer.setForeground(new java.awt.Color(255, 0, 0));
        timer.setText("Number of attempts exceeded. Please try again after xx seconds");
        getContentPane().add(timer, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 330, -1, -1));

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage7/icons/final1.png"))); // NOI18N
        back.setMaximumSize(new java.awt.Dimension(9999, 9999));
        back.setMinimumSize(new java.awt.Dimension(1025, 500));
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 500));

        jMenu1.setText("Help");

        jMenuItem1.setText("Having Trouble ? Contact Us");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginloginHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginloginHandler
        // TODO add your handling code here:
        
        String userName = user.getText();
        String password = String.valueOf(pass.getPassword());
        
        //convert the password to md5 hash
        int result = my.login(userName, password, new int [] {1,2,3,4,5});
        
        switch(result){
            case 0:{
                //playSuccess();
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
    }//GEN-LAST:event_btnLoginloginHandler

    private void passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passActionPerformed

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

    private void loadColoredButtons(){
        JButton buttons [] = {
            btnLogin,
        };
        
        JButton lightButtons [] = {
            //btnEdit1
        };
        Cursor tempC;
        for(int n=0;n<buttons.length;n++){
            buttons[n].setUI(new custom_styledButtonIU());
            //buttons[n].setBackground(new Color(22,66,33));
            buttons[n].setBackground(new Color(0xCBB8A0));
            buttons[n].setForeground(Color.BLACK);            
            buttons[n].setFont(myVariables.BUTTON_FONT);
            //buttons[n].setCursor(my.getCursor(myVariables.getHandCursor()));
            buttons[n].setCursor(new Cursor(Cursor.HAND_CURSOR));
            buttons[n].setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
        
        for(int n=0;n<lightButtons.length;n++){
            lightButtons[n].setUI(new custom_styledButtonIU());
            //buttons[n].setBackground(new Color(22,66,33));
            lightButtons[n].setBackground(new Color(0xCBB8A0));
            lightButtons[n].setForeground(Color.BLACK);            
            lightButtons[n].setFont(new Font("Comic Sans MS",Font.BOLD,12));
            //buttons[n].setCursor(my.getCursor(myVariables.getHandCursor()));
            lightButtons[n].setCursor(new Cursor(Cursor.HAND_CURSOR));
            lightButtons[n].setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
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
            java.util.logging.Logger.getLogger(formsLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formsLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formsLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formsLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formsLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel forms;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel logo1;
    private javax.swing.JPasswordField pass;
    private javax.swing.JLabel timer;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
}
