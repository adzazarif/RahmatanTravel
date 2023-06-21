/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view.dialog;

import javax.swing.JFrame;
import view.panel.Dasboard;


/**
 *
 * @author adzaz
 */
public class DialogFilterDashboard extends Dialog {

    /**
     * Creates new form DialogFilter
     */
    public DialogFilterDashboard(JFrame frame) {
        super(frame);
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

        txtEnd = new javax.swing.JTextField();
        txtStart = new javax.swing.JTextField();
        dateStart = new com.raven.datechooser.DateChooser();
        dateEnd = new com.raven.datechooser.DateChooser();
        btnBatal = new javax.swing.JLabel();
        btnTerapkan = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtEnd.setFont(new java.awt.Font("Quicksand Bold", 0, 15)); // NOI18N
        txtEnd.setBorder(null);
        getContentPane().add(txtEnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 140, 270, 30));

        txtStart.setFont(new java.awt.Font("Quicksand Bold", 0, 15)); // NOI18N
        txtStart.setBorder(null);
        getContentPane().add(txtStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 270, 30));

        dateStart.setDateFormat("yyyy-MM-dd");
        dateStart.setTextRefernce(txtStart);
        getContentPane().add(dateStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 260, 200));

        dateEnd.setDateFormat("yyyy-MM-dd");
        dateEnd.setTextRefernce(txtEnd);
        getContentPane().add(dateEnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 190, 260, -1));

        btnBatal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBatalMouseClicked(evt);
            }
        });
        getContentPane().add(btnBatal, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 460, 140, 40));

        btnTerapkan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTerapkanMouseClicked(evt);
            }
        });
        getContentPane().add(btnTerapkan, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 460, 140, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/bg Jangka Waktu.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBatalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBatalMouseClicked
        closeMessage();
    }//GEN-LAST:event_btnBatalMouseClicked

    private void btnTerapkanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTerapkanMouseClicked
        Dasboard.dateStart = txtStart.getText();
        Dasboard.dateEnd = txtEnd.getText();
        closeMessage();
    }//GEN-LAST:event_btnTerapkanMouseClicked



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnBatal;
    private javax.swing.JLabel btnTerapkan;
    private com.raven.datechooser.DateChooser dateEnd;
    private com.raven.datechooser.DateChooser dateStart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtEnd;
    private javax.swing.JTextField txtStart;
    // End of variables declaration//GEN-END:variables
}
