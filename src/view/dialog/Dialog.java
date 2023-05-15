
package view.dialog;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;

/**
 *
 * @author Mphstar
 */
public class Dialog extends JDialog {
     
    private final JFrame fram;
    private Animator animator;
    private int pilihan;
    private boolean show;
    private Glass glass;
    
    public Dialog(JFrame fram) {
        super(fram, true);
        this.fram = fram;
        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));
        init();
    }
    
    public void hover(JLabel l, String name){
        l.setIcon(new ImageIcon(getClass().getResource("/view/image/" + name + ".png")));
    }
    
    public void hover(JButton l, String name){
        l.setIcon(new ImageIcon(getClass().getResource("/view/image/" + name + ".png")));
    }
    
    private void init() {
        //setDefaultdeOperation(JDialog.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeMessage();
            }
        });
        animator = new Animator(350, new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                float f = show ? fraction : 1f - fraction;
                glass.setAlpha(f - f * 0.3f);
                setOpacity(f);
            }

            @Override
            public void end() {
                if (show == false) {
                    dispose();
                    glass.setVisible(false);
                }
            }
        });
        animator.setResolution(0);
        animator.setAcceleration(.5f);
        animator.setDeceleration(.5f);
        setOpacity(0f);
        glass = new Glass();
    }
    
    public void startAnimator(boolean show) {
        if (animator.isRunning()) {
            float f = animator.getTimingFraction();
            animator.stop();
            animator.setStartFraction(1f - f);
        } else {
            animator.setStartFraction(0f);
        }
        this.show = show;
        animator.start();
    
    }
    
    public void closeMessage() {
        startAnimator(false);
        revalidate();
        repaint();
    }
   
    
    public void setPilihan(int pilihan){
        this.pilihan = pilihan;
    }
    
    public int getPilihan(){
        return this.pilihan;
    }
    
    public void konfirmasi(int pilihan){
        setPilihan(pilihan);
    }
    
    public int getOK(){
        return 1;
    }
    
    public int getCancel(){
        return 0;
    }
    
    public void showPopUp(){
        fram.setGlassPane(glass);
        glass.setVisible(true);
        
        setLocationRelativeTo(fram);
        startAnimator(true);
        setVisible(true);
        repaint();
        revalidate();
    }
    
    public void showPopUpNonGlass(){
        
        setLocationRelativeTo(fram);
        startAnimator(true);
        setVisible(true);
        repaint();
        revalidate();
        
    }
    public void showGlass(){
        fram.setGlassPane(glass);
        glass.setVisible(true);
    }
    public void setContent(JComponent newContent) {
    getContentPane().removeAll();
    getContentPane().add(newContent);
    revalidate();
    repaint();
}
}
