
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
import service.TokenEmail;
import util.Conn;
public class dialog_mintakode extends Dialog {

    public dialog_mintakode(JFrame fram) {
        super(fram);
        initComponents();
        
    
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg1 = new javax.swing.JLabel();
        verifikasi1 = new javax.swing.JPanel();
        verifikasi = new javax.swing.JLabel();
        keluar2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        bg = new javax.swing.JLabel();

        bg1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/bg kodeverifikasi.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        verifikasi1.setBackground(new Color(0,0,0,0));
        verifikasi1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        verifikasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/verifikasi.png"))); // NOI18N
        verifikasi.addMouseListener(new java.awt.event.MouseAdapter() {
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
        verifikasi1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 330, 60));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/bg kodeverifikasi.png"))); // NOI18N
        verifikasi1.add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 480));

        getContentPane().add(verifikasi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 480));

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JLabel bg1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel keluar2;
    private javax.swing.JLabel verifikasi;
    private javax.swing.JPanel verifikasi1;
    // End of variables declaration//GEN-END:variables
}
