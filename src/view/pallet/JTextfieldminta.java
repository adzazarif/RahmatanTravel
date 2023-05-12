
package view.pallet;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Insets;
import java.awt.geom.Rectangle2D;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;


public class JTextfieldminta extends JTextField {
    
    public String getlabelText(){
        return labelText;
    }
    
    public void setlabelText(String labelText){
        this.labelText = labelText;
    }
    
    public Color getlineColor() {
        return lineColor;
    }
    
    public void setlineColor(Color lineColor) {
        this.lineColor = lineColor;
    }
    public String getapa(){
        return apa;
    }
    
    public void setapa(String apa) {
        this.apa = apa;
    }
    public String getapa1(){
        return apa1;
    }
    
    public void setapa1(String apa1) {
        this.apa1 = apa1;
    }
    private final Animator animator;
    private boolean animateHintText=true;
    private float location;
    private boolean show;
    private boolean mouseOver = false;
    private String apa = "username";
    private String apa1 = "input your username";
    
    private String labelText = "input your username";
    private Color lineColor= new Color(3,155,216);
    private Font font =new Font("Quicksand", Font.PLAIN, 15);
    
    public JTextfieldminta(){
        setBorder(new EmptyBorder(20, 3, 10, 3));
        setFont(font);
        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent me){
                mouseOver = true;
                

                repaint();
            }

            @Override
            public void mouseExited(MouseEvent me) {
                mouseOver = false;
//                animateHintText = getText().equals("");
//                labelText =  apa;
                repaint();
            }
        });
        addFocusListener(new FocusAdapter(){
            @Override
            public void focusGained(FocusEvent fe){
               labelText =  apa;
                showing(false);
                
            }
            
            @Override
            public void focusLost(FocusEvent fe) {
                if(animateHintText = getText().equals("")){
                labelText =  apa1;
                } else {
                labelText = apa;
                }
                showing(true);
            }
        });
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void begin(){
            animateHintText = getText().equals("");
            
            }
            @Override
            public void timingEvent(float fraction){
                location = fraction;
//                labelText =  apa;
                repaint();
            }
        };
        animator = new Animator(300, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
    }
    private void showing(boolean action) {
        if (animator.isRunning()) {
            animator.stop();
        }else{
            location = 1;
        }
        animator.setStartFraction(1f - location);
        show=action;
        location= 1f - location;
        animator.start();
                
    }
    
    @Override
    public void paint(Graphics grphcs) {
        super.paint(grphcs);
        Graphics2D g2=(Graphics2D)grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
        int width = getWidth();
        int height = getHeight();
        if (mouseOver) {
            g2.setColor(Color.WHITE);
        }else{
            g2.setColor(Color.WHITE);
        }
        g2.fillRect(2, height -1 , width - 4, 1);
        createHintText(g2);
        createLineStyle(g2);
        g2.dispose();
    }
    private void createHintText(Graphics2D g2) {
        Insets in = getInsets();
        g2.setColor(Color.WHITE);
        FontMetrics ft = g2.getFontMetrics();
        Rectangle2D r2 = ft.getStringBounds(labelText, g2);
        double height = r2.getHeight() -  in.top ;
        double textY = (height + 4) ;
        double size;
        if (animateHintText) {
            if(show){
                size = 20 * (1 - location);
            } else {
                size = 20 * location;
            }
        } else {
            size = 20;
        }
        g2.drawString(labelText, in.right,(int)(in.top + textY + ft.getAscent() - size));
    }
    private void createLineStyle(Graphics2D g2){
        if(isFocusOwner()) {
            double width = getWidth() -4;
            int heigth = getHeight();
            g2.setColor(Color.ORANGE);
            double size;
            if(show){
                size = width * (1 - location);
            }else{
                size = width * location;
            }
            double x= (width-size)/2;
            g2.fillRect((int)(x + 2), heigth-2, (int)size, 2);
        }
    }
    
    @Override
    public void setText(String string) {
        if (!getText().equals(string)) {
            showing(string.equals(""));
        }
        super.setText(string);
    }
    
  
    
}
