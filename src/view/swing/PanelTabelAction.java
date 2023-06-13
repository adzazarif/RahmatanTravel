
package view.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelTabelAction extends javax.swing.JPanel {

    public PanelTabelAction() {
        initComponents();
    }
    public void initEvent(TableActionEvent event,int row){
        cmdapa.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            event.delete(row);
            }
            
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdapa = new view.swing.ActionButton();

        cmdapa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/button hapustab.png"))); // NOI18N
        cmdapa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cmdapaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cmdapaMouseReleased(evt);
            }
        });
        cmdapa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdapaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmdapa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmdapa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdapaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdapaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdapaActionPerformed

    private void cmdapaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdapaMousePressed
    
    }//GEN-LAST:event_cmdapaMousePressed

    private void cmdapaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdapaMouseReleased
//    cmdapa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/button hapustab.png")));
    }//GEN-LAST:event_cmdapaMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static view.swing.ActionButton cmdapa;
    // End of variables declaration//GEN-END:variables
}
