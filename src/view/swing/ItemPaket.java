
package view.swing;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import view.event.EventMenuSelected;
import java.awt.Color;

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

        paketitem = new javax.swing.JLabel();
        paketitemselect = new javax.swing.JLabel();

        setBackground(new Color(0,0,0,0));
        setLayout(null);

        paketitem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/itempaket1.png"))); // NOI18N
        add(paketitem);
        paketitem.setBounds(4, 0, 280, 170);

        paketitemselect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/itempaket2.png"))); // NOI18N
        add(paketitemselect);
        paketitemselect.setBounds(0, 0, 286, 179);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel paketitem;
    private javax.swing.JLabel paketitemselect;
    // End of variables declaration//GEN-END:variables
}
