
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
        nama_paket.setFont(font);
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

        jLabel1 = new javax.swing.JLabel();
        nama_paket = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        bgitem2 = new javax.swing.JLabel();
        bgitem1 = new javax.swing.JLabel();

        setBackground(new Color(0,0,0,0));
        setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/button detail.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
        });
        add(jLabel1);
        jLabel1.setBounds(850, 55, 90, 30);

        nama_paket.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(nama_paket);
        nama_paket.setBounds(60, 30, 170, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/icon keberangkatan.png"))); // NOI18N
        add(jLabel2);
        jLabel2.setBounds(430, 40, 90, 47);

        bgitem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/item keberangkatan2.png"))); // NOI18N
        add(bgitem2);
        bgitem2.setBounds(0, 2, 997, 130);

        bgitem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/item keberangkatan1.png"))); // NOI18N
        add(bgitem1);
        bgitem1.setBounds(6, 0, 991, 129);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
    jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/button detail1.png")));
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
    jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/button detail.png")));
    }//GEN-LAST:event_jLabel1MouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bgitem1;
    private javax.swing.JLabel bgitem2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel nama_paket;
    // End of variables declaration//GEN-END:variables

}
