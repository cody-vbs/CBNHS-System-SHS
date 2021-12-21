/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mahPackage;

import java.awt.Font;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author syd
 */
public class splash extends javax.swing.JFrame {

    /**
     * Creates new form splash
     */
    
    Font myPReg= null;
    Font myPSemiBold= null;
    
    public splash() {
        initComponents();
        
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icons/icons8_add_user_male_16px.png")));

       
        try{
            myPReg = Font.createFont(Font.TRUETYPE_FONT,new File("fonts/Poppins-Regular.ttf"));
            myPSemiBold = Font.createFont(Font.TRUETYPE_FONT,new File("fonts/Poppins-SemiBold.ttf"));

        }catch (Exception e){
            System.out.println("Error loading custom font..");
        }
        
        sysName.setFont(myPSemiBold.deriveFont(39F));
        loadingLabel.setFont(myPSemiBold.deriveFont(14F));
        loadingValue.setFont(myPSemiBold.deriveFont(14F));

        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        myProgressBar = new javax.swing.JProgressBar();
        sysName = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        loadingLabel = new javax.swing.JLabel();
        loadingValue = new javax.swing.JLabel();
        bkg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Welcome To Registration System");
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage/icons/CBNHS_LOGO.png"))); // NOI18N
        jPanel1.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, 170, 150));
        jPanel1.add(myProgressBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 480, 1076, 25));

        sysName.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        sysName.setForeground(new java.awt.Color(102, 102, 102));
        sysName.setText("SHS REGISTRATION SYSTEM");
        jPanel1.add(sysName, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, 520, -1));

        loadingLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        loadingLabel.setForeground(new java.awt.Color(255, 255, 255));
        loadingLabel.setText("Loading...");
        jPanel1.add(loadingLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, -1, -1));

        loadingValue.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        loadingValue.setForeground(new java.awt.Color(255, 255, 255));
        loadingValue.setText("0 %");
        jPanel1.add(loadingValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 450, -1, -1));

        bkg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mahPackage/icons/dsc_2003.png"))); // NOI18N
        jPanel1.add(bkg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -5, -1, 490));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
      
        splash sp = new splash();
        sp.setVisible(true);
        
        try{
            
        for (int x=0; x<=100; x++){
            Thread.sleep(10);
            sp.loadingValue.setText(x +" %");
            
            if(x == 10){
                sp.loadingLabel.setText("Turning on modules...");
            }
            
            if(x == 20){
                sp.loadingLabel.setText("Loading on modules...");
            }
            
             if(x == 50){
                sp.loadingLabel.setText("Connecting to database...");
            }
             
            if(x == 70){
                sp.loadingLabel.setText("Connection Successful !");
            }
            
             if(x == 80){
                sp.loadingLabel.setText("Launching Application...");
            }
             
             sp.myProgressBar.setValue(x);
             
        
        }
        //open the new login form

        sp.dispose();
             
        new login().setVisible(true);

        
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bkg;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel loadingLabel;
    private javax.swing.JLabel loadingValue;
    private javax.swing.JLabel logo;
    private javax.swing.JProgressBar myProgressBar;
    private javax.swing.JLabel sysName;
    // End of variables declaration//GEN-END:variables
}