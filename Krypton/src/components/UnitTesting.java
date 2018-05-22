/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import jiconfont.icons.Elusive;
import jiconfont.icons.Entypo;
import jiconfont.icons.FontAwesome;

/**
 *
 * @author gauravpunjabi
 */
public class UnitTesting extends javax.swing.JFrame {

    /**
     * Creates new form UnitTesting
     */
    public UnitTesting() {
        initComponents();
        jtfEmail = new CustomTextField(CustomTextField.EMAIL_TEXT_FIELD,"Enter your Email : ",Elusive.SMILEY_ALT);
        jtfEmail.setBounds(100,100,300,42);
        jtfEmail.getTextField().setFont(new Font("Centry Gothic",0,17));
        jtfEmail.setIconColor(new Color(86,61,124));
        jtfEmail.setSeparatorColor(new Color(86,61,124));
        jtfEmail.getTextField().setForeground(new Color(86,61,124));
        jtfEmail.setIconSize(32);
        CustomTextField jtfPassword = new CustomTextField(CustomTextField.EMAIL_TEXT_FIELD,"Enter your Password : ",Elusive.LOCK_ALT);
        jtfPassword.setBounds(100,200,300,42);
        jtfPassword.getTextField().setFont(new Font("Century Gothic",0,17));
        jtfPassword.setIconColor(new Color(86,61,124));
        jtfPassword.setSeparatorColor(new Color(86,61,124));
        jtfPassword.getTextField().setForeground(new Color(86,61,124));
        getContentPane().setBackground(Color.white);
        add(jtfPassword);
        add(jtfEmail);
        setSize(500,400);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Fira Sans", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(86, 61, 124));
        jLabel1.setText("Login");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(230, 0, 100, 70);

        pack();
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UnitTesting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UnitTesting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UnitTesting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UnitTesting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UnitTesting().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
    private CustomTextField jtfEmail;
}
