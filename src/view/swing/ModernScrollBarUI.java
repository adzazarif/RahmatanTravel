
package view.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class ModernScrollBarUI extends BasicScrollBarUI {
    
    private final int THUMB_SIZE = 100;

    @Override
    protected Dimension getMaximumThumbSize() {
        // return super.getMaximumThumbSize(); //To change body of generated methods, choose Tools | Templates.
        if ( scrollbar.getOrientation()==JScrollBar.VERTICAL){
            return new Dimension(0, THUMB_SIZE);
        } else {
            return new Dimension(THUMB_SIZE, 0);
        }
    }

    @Override
    protected Dimension getMinimumThumbSize() {
        // return super.getMinimumThumbSize(); //To change body of generated methods, choose Tools | Templates.
        if ( scrollbar.getOrientation()==JScrollBar.VERTICAL){
            return new Dimension(0, THUMB_SIZE);
        } else {
            return new Dimension(THUMB_SIZE, 0);
        }
        
    }

    @Override
    protected JButton createIncreaseButton(int i) {
        // return super.createIncreaseButton(i); //To change body of generated methods, choose Tools | Templates.
        return new ScrollBarButton();
    }

    
    
    @Override
    protected JButton createDecreaseButton(int i) {
        // return super.createDecreaseButton(i); //To change body of generated methods, choose Tools | Templates.
        return new ScrollBarButton();
    }

    

    @Override
    protected void paintTrack(Graphics grphcs, JComponent jc, Rectangle rctngl) {
        // super.paintTrack(grphcs, jc, rctngl); //To change body of generated methods, choose Tools | Templates.
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int orientation = scrollbar.getOrientation();
        int size, x, y, width, height;
        if ( orientation == JScrollBar.VERTICAL ){
            size = rctngl.width / 2;
            x = rctngl.x + ((rctngl.width - size) / 2);
            y = rctngl.y;
            width = size;
            height = rctngl.height;
        } else {
            size = rctngl.height / 2;
            y = rctngl.y + ((rctngl.height - size) / 2);
            x = 0;
            width = rctngl.width;
            height = size;
        }
        g2.setColor(new Color(240, 240, 240));
        g2.fillRect(x, y, width, height);
    }

    @Override
    protected void paintThumb(Graphics grphcs, JComponent jc, Rectangle rctngl) {
        // super.paintThumb(grphcs, jc, rctngl); //To change body of generated methods, choose Tools | Templates.
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int x, y, width, height;
        x = rctngl.x;
        y = rctngl.y;
        width = rctngl.width;
        height = rctngl.height;
        if (scrollbar.getOrientation()==JScrollBar.VERTICAL){
            y += 8;
            height -= 16;
        } else {
            x += 8;
            width -= 16;
        }
        g2.setColor(scrollbar.getForeground());
        g2.fillRoundRect(x, y, width, height, 10, 10);
    }
    
    private class ScrollBarButton extends JButton {

        public ScrollBarButton() {
            setBorder(BorderFactory.createEmptyBorder());
        }

        @Override
        public void paint(Graphics grphcs) {
            // super.paint(grphcs); //To change body of generated methods, choose Tools | Templates.
        }
        
        
    }
    
}
