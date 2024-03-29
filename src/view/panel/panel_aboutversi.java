/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.panel;
import java.awt.Color;
/**
 *
 * @author semafie
 */
public class panel_aboutversi extends javax.swing.JPanel {

    /**
     * Creates new form panel_aboutversi
     */
    public panel_aboutversi() {
        initComponents();
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
        keluar = new javax.swing.JLabel();
        developerinformation = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        jPanel1.setBackground(new Color(0,0,0,90));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel1.add(keluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 130, -1, -1));

        developerinformation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/Developer Information.png"))); // NOI18N
        developerinformation.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                developerinformationFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                developerinformationFocusLost(evt);
            }
        });
        developerinformation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                developerinformationMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                developerinformationMouseExited(evt);
            }
        });
        jPanel1.add(developerinformation, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 380, 160, 20));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/bg aboutversi.png"))); // NOI18N
        jPanel1.add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(179, 119, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void keluarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_keluarFocusGained

    }//GEN-LAST:event_keluarFocusGained

    private void keluarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_keluarFocusLost

    }//GEN-LAST:event_keluarFocusLost

    private void keluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_keluarMouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_keluarMouseClicked

    private void keluarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_keluarMouseEntered
        keluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/silangbutton1.png")));
    }//GEN-LAST:event_keluarMouseEntered

    private void keluarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_keluarMouseExited
        keluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/silangbutton.png")));
    }//GEN-LAST:event_keluarMouseExited

    private void developerinformationFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_developerinformationFocusGained

    }//GEN-LAST:event_developerinformationFocusGained

    private void developerinformationFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_developerinformationFocusLost

    }//GEN-LAST:event_developerinformationFocusLost

    private void developerinformationMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_developerinformationMouseEntered
        developerinformation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/Developer Information1.png")));
    }//GEN-LAST:event_developerinformationMouseEntered

    private void developerinformationMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_developerinformationMouseExited
        developerinformation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/Developer Information.png")));
    }//GEN-LAST:event_developerinformationMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JLabel developerinformation;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel keluar;
    // End of variables declaration//GEN-END:variables
}
