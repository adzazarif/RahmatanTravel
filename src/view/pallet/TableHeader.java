package view.pallet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

public class TableHeader extends JLabel {

    public TableHeader(String text) {
        super(text);
        setOpaque(true);
        setBackground(new Color(255, 121, 0));
//        setBackground(Color.WHITE);
        setFont(new Font("Quicksand", Font.BOLD, 15));
        setForeground(new Color(0,0,0));
        setBorder(new EmptyBorder(10, 5, 10, 5));
        setHorizontalAlignment(JLabel.CENTER);
    }
    
    public JLabel getLabel(){
        return this;
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
//        Graphics2D g2 = (Graphics2D) grphcs;
//        g2.setColor(new Color(255, 121, 0));
//        g2.fillRoundRect(0, 0, WIDTH, HEIGHT, 20, 20);
        super.paintComponent(grphcs);
        grphcs.setColor(new Color(230, 230, 230));
//        grphcs.drawLine(0, getHeight() - 1, getWidth(), getHeight() - 1);
    }
}

