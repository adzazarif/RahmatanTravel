
package view.swing;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import view.event.EventMenuSelected;
import java.awt.Color;
import java.awt.Font;
import static view.swing.ItemKeberangkatan.nama_paket1;

public class ItemPaket extends javax.swing.JPanel {
    
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
        paketitem.setVisible(!selected);
        paketitemselect.setVisible(selected);
        repaint();
    }
    
    
    public ItemPaket() {
        initComponents();
        Font font = new Font("Quicksand", Font.BOLD, 17);
        namapaket123.setFont(font);
        infopaket.setFont(font);
        
        paketitemselect.setVisible(false);
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
    
//    public PanelItemPaket(){
//        lbName.setVisible(false);
//        setOpaque(false);
//        this.index = index;
//    }
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

        namapaket123 = new javax.swing.JLabel();
        harga = new javax.swing.JLabel();
        infopaket = new javax.swing.JLabel();
        selengkapnya = new javax.swing.JLabel();
        paketitem = new javax.swing.JLabel();
        paketitemselect = new javax.swing.JLabel();

        setBackground(new Color(0,0,0,0));
        setLayout(null);
        add(namapaket123);
        namapaket123.setBounds(130, 40, 150, 20);
        add(harga);
        harga.setBounds(130, 80, 150, 20);
        add(infopaket);
        infopaket.setBounds(130, 60, 150, 20);

        selengkapnya.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/selengkapnyapaket.jpg"))); // NOI18N
        selengkapnya.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                selengkapnyaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                selengkapnyaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                selengkapnyaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                selengkapnyaMouseReleased(evt);
            }
        });
        add(selengkapnya);
        selengkapnya.setBounds(140, 110, 100, 20);

        paketitem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/itempaket1.png"))); // NOI18N
        add(paketitem);
        paketitem.setBounds(4, 0, 280, 170);

        paketitemselect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/itempaket2.png"))); // NOI18N
        add(paketitemselect);
        paketitemselect.setBounds(0, 0, 286, 179);
    }// </editor-fold>//GEN-END:initComponents

    private void selengkapnyaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selengkapnyaMouseEntered
    selengkapnya.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/selengkapnyapaket1.jpg")));
    }//GEN-LAST:event_selengkapnyaMouseEntered

    private void selengkapnyaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selengkapnyaMouseExited
    selengkapnya.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/selengkapnyapaket.jpg")));
    }//GEN-LAST:event_selengkapnyaMouseExited

    private void selengkapnyaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selengkapnyaMousePressed
    selengkapnya.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/selengkapnyapaket2.jpg")));
    }//GEN-LAST:event_selengkapnyaMousePressed

    private void selengkapnyaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selengkapnyaMouseReleased
    selengkapnya.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/selengkapnyapaket.jpg")));
    }//GEN-LAST:event_selengkapnyaMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel harga;
    public static javax.swing.JLabel infopaket;
    public static javax.swing.JLabel namapaket123;
    private javax.swing.JLabel paketitem;
    private javax.swing.JLabel paketitemselect;
    private javax.swing.JLabel selengkapnya;
    // End of variables declaration//GEN-END:variables
}
