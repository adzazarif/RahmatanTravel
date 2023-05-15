
package view.dialog;

import javax.swing.JFrame;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.internet.MimeMessage;
import javax.swing.SwingUtilities;
import service.Auth;
import service.TokenEmail;
import util.Conn;
import view.main.maindasboard;
public class dialog_mintakode extends Dialog {
    Auth a = new Auth();
    private String username = a.username;
    public dialog_mintakode(JFrame fram) {
        super(fram);
        initComponents();
        
        validasiBerhasil.setVisible(false);
        validasiSalah.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg1 = new javax.swing.JLabel();
        validasiBerhasil = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        verifikasi1 = new javax.swing.JPanel();
        verifikasi = new javax.swing.JLabel();
        keluar2 = new javax.swing.JLabel();
        txtKode = new javax.swing.JTextField();
        bg = new javax.swing.JLabel();
        validasiSalah = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        changePass = new javax.swing.JPanel();
        txtRepeatPass = new javax.swing.JTextField();
        txtPass = new javax.swing.JTextField();
        btnChange = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        bg1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/bg kodeverifikasi.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        validasiBerhasil.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        validasiBerhasil.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, 110, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/validasi berhasil.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        validasiBerhasil.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, -1));

        getContentPane().add(validasiBerhasil, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 570, 330));

        verifikasi1.setBackground(new Color(0,0,0,0));
        verifikasi1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        verifikasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/verifikasi.png"))); // NOI18N
        verifikasi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                verifikasiMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                verifikasiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                verifikasiMouseExited(evt);
            }
        });
        verifikasi1.add(verifikasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 370, 70));

        keluar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/silangbutton.png"))); // NOI18N
        keluar2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                keluar2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                keluar2FocusLost(evt);
            }
        });
        keluar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                keluar2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                keluar2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                keluar2MouseExited(evt);
            }
        });
        verifikasi1.add(keluar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, -1, -1));
        verifikasi1.add(txtKode, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 330, 60));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/bg kodeverifikasi.png"))); // NOI18N
        verifikasi1.add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 480));

        getContentPane().add(verifikasi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 450, 480));

        validasiSalah.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/validasi salah token.png"))); // NOI18N
        jLabel3.setText("jLabel2");
        validasiSalah.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, -1));

        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        validasiSalah.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 130, 40));

        getContentPane().add(validasiSalah, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 570, 330));

        changePass.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtRepeatPass.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        txtRepeatPass.setBorder(null);
        changePass.add(txtRepeatPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 282, 270, 40));

        txtPass.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        txtPass.setBorder(null);
        changePass.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 158, 270, 40));

        btnChange.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnChangeMouseClicked(evt);
            }
        });
        changePass.add(btnChange, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 370, 60));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/ganti pass.png"))); // NOI18N
        changePass.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 480));

        getContentPane().add(changePass, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 450, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void verifikasiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verifikasiMouseEntered
    verifikasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/verifikasi1.png")));
    }//GEN-LAST:event_verifikasiMouseEntered

    private void verifikasiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verifikasiMouseExited
    verifikasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/verifikasi.png")));
    }//GEN-LAST:event_verifikasiMouseExited

    private void keluar2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_keluar2FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_keluar2FocusGained

    private void keluar2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_keluar2FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_keluar2FocusLost

    private void keluar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_keluar2MouseClicked
        closeMessage();
    }//GEN-LAST:event_keluar2MouseClicked

    private void keluar2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_keluar2MouseEntered
    keluar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/silangbutton1.png")));
    }//GEN-LAST:event_keluar2MouseEntered

    private void keluar2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_keluar2MouseExited
    keluar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/silangbutton.png")));
    }//GEN-LAST:event_keluar2MouseExited

    private void verifikasiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verifikasiMouseClicked
        String token = txtKode.getText();
        
         String queryCek = "SELECT token FROM user WHERE username = ?";
         
        try {
        Connection koneksi = (Connection) Conn.configDB();
        PreparedStatement pst = koneksi.prepareStatement(queryCek);
        pst.setString(1, username);
        ResultSet res = pst.executeQuery();
        if(res.next()){
            if(txtKode.getText().equals(res.getString("token"))){
             
                a.hapusToken(username);
                a.username = "";
                verifikasi1.setVisible(false);
                changePass.setVisible(false);
                validasiBerhasil.setVisible(true);
            }else{
               verifikasi1.setVisible(false);
               changePass.setVisible(false);
                validasiSalah.setVisible(true);
            }
        }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_verifikasiMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        validasiSalah.setVisible(false);
        changePass.setVisible(false);
        verifikasi1.setVisible(true);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        validasiBerhasil.setVisible(false);
        verifikasi1.setVisible(false);
        changePass.setVisible(true);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void btnChangeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChangeMouseClicked
        String pass = txtPass.getText();
        String repeatPass = txtRepeatPass.getText();
        if(pass.equals(repeatPass)){
              boolean changePassword = a.changePass(pass, repeatPass, username);
        if(changePassword){
            System.out.println("berhasil");
            closeMessage();
        }else{
            System.out.println("gagal");
        }
        }else{
            System.out.println("Tidak sama");
        }
      
        
    }//GEN-LAST:event_btnChangeMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JLabel bg1;
    private javax.swing.JLabel btnChange;
    private javax.swing.JPanel changePass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel keluar2;
    private javax.swing.JTextField txtKode;
    private javax.swing.JTextField txtPass;
    private javax.swing.JTextField txtRepeatPass;
    private javax.swing.JPanel validasiBerhasil;
    private javax.swing.JPanel validasiSalah;
    private javax.swing.JLabel verifikasi;
    private javax.swing.JPanel verifikasi1;
    // End of variables declaration//GEN-END:variables
}
