
package view.dialog;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import view.main.Main;
import view.panel.panel_developer;
import java.awt.Color;

public class dialog_aboutversi extends Dialog {

    
    public dialog_aboutversi(JFrame fram) {
        super(fram);
        initComponents();
//        this.requestFocus();
//        bg.requestFocus();
//        init();
devinfo.setVisible(false);
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        devinfo = new javax.swing.JPanel();
        keluar2 = new javax.swing.JLabel();
        bg2 = new javax.swing.JLabel();
        version = new javax.swing.JPanel();
        keluar = new javax.swing.JLabel();
        developerinformation = new javax.swing.JLabel();
        bg1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        devinfo.setBackground(new Color(0,0,0,0));
        devinfo.setForeground(new Color(0,0,0,0));
        devinfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        devinfo.add(keluar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 20, -1, -1));

        bg2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/developer information.png"))); // NOI18N
        devinfo.add(bg2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 460));

        getContentPane().add(devinfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 460));

        version.setBackground(new Color(0,0,0,0));
        version.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        keluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/silangbutton.png"))); // NOI18N
        keluar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                keluarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                keluarFocusLost(evt);
            }
        });
        keluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                keluarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                keluarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                keluarMouseExited(evt);
            }
        });
        version.add(keluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 70, -1, -1));

        developerinformation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/Developer Information.png"))); // NOI18N
        developerinformation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                developerinformationMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                developerinformationMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                developerinformationMouseExited(evt);
            }
        });
        version.add(developerinformation, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 320, 160, 20));

        bg1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/bg aboutversi.png"))); // NOI18N
        version.add(bg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 660, 330));

        getContentPane().add(version, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 460));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyPressed

    private void keluarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_keluarFocusGained

    }//GEN-LAST:event_keluarFocusGained

    private void keluarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_keluarFocusLost

    }//GEN-LAST:event_keluarFocusLost

    private void keluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_keluarMouseClicked
        closeMessage();
//        dispose();
//        this.setVisible(false);
    }//GEN-LAST:event_keluarMouseClicked

    private void keluarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_keluarMouseEntered
        keluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/silangbutton1.png")));
    }//GEN-LAST:event_keluarMouseEntered

    private void keluarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_keluarMouseExited
        keluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/silangbutton.png")));
    }//GEN-LAST:event_keluarMouseExited

    private void developerinformationMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_developerinformationMouseEntered
    developerinformation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/Developer Information1.png")));
    }//GEN-LAST:event_developerinformationMouseEntered

    private void developerinformationMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_developerinformationMouseExited
    developerinformation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/Developer Information.png")));
    }//GEN-LAST:event_developerinformationMouseExited

    private void developerinformationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_developerinformationMouseClicked
    devinfo.setVisible(true);
    version.setVisible(false);
//   bg1.setVisible(false);
//   keluar.setVisible(false);
//   developerinformation.setVisible(false);
    }//GEN-LAST:event_developerinformationMouseClicked

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
        // TODO add your handling code here:
    }//GEN-LAST:event_keluar2MouseEntered

    private void keluar2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_keluar2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_keluar2MouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg1;
    private javax.swing.JLabel bg2;
    private javax.swing.JLabel developerinformation;
    private javax.swing.JPanel devinfo;
    private javax.swing.JLabel keluar;
    private javax.swing.JLabel keluar2;
    private javax.swing.JPanel version;
    // End of variables declaration//GEN-END:variables
}
