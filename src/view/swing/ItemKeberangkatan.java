
package view.swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import view.event.EventMenuSelected;

public class ItemKeberangkatan extends javax.swing.JPanel {
    private final List<EventMenuSelected> events = new ArrayList<>();
    private int index;
    private boolean selected;
    private boolean mouseOver;
    private JPanel containerPanel;
    
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        bgitem1.setVisible(!selected);
        bgitem2.setVisible(selected);
        repaint();
    }
    
    
    public ItemKeberangkatan() {
        initComponents();
        Font font = new Font("Quicksand", Font.PLAIN, 36);
        Font font1 = new Font("Quicksand", Font.PLAIN, 18);
        nama_paket1.setFont(font);
        hargapaket.setFont(font1);
        bgitem2.setVisible(false);
        setOpaque(false);
        this.index = index;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                mouseOver = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mouseOver = false;
                repaint();
            }
            @Override
            public void mouseReleased(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me)) {
                    if (mouseOver) {
                        setSelected(true);
                        repaint();
                        runEvent();
                    }
                }
            }
        });
    }
    
    
        private void runEvent() {
        for (EventMenuSelected event : events) {
            event.selected(index);
        }
    }

    public void addEvent(EventMenuSelected event) {
        events.add(event);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        hargapaket = new javax.swing.JLabel();
        nama_paket1 = new javax.swing.JLabel();
        bgitem2 = new javax.swing.JLabel();
        bgitem1 = new javax.swing.JLabel();

        setBackground(new Color(0,0,0,0));
        setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/iconkberangkatan1.png"))); // NOI18N
        add(jLabel2);
        jLabel2.setBounds(430, 40, 90, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/button detail.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
        });
        add(jLabel1);
        jLabel1.setBounds(810, 60, 90, 30);
        add(hargapaket);
        hargapaket.setBounds(777, 36, 150, 20);

        nama_paket1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(nama_paket1);
        nama_paket1.setBounds(60, 30, 170, 60);

        bgitem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/bgitemkeberangkatan1.png"))); // NOI18N
        add(bgitem2);
        bgitem2.setBounds(0, 2, 1000, 130);

        bgitem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/bgitemkeberangkatan.png"))); // NOI18N
        add(bgitem1);
        bgitem1.setBounds(0, 0, 990, 129);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
    jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/button detail1.png")));
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
    jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/button detail.png")));
    }//GEN-LAST:event_jLabel1MouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bgitem1;
    private javax.swing.JLabel bgitem2;
    public static javax.swing.JLabel hargapaket;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel nama_paket1;
    // End of variables declaration//GEN-END:variables

}
