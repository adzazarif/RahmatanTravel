
package view.main;
import view.panel.panel_aboutversi;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Panel;
import java.awt.BorderLayout;
import java.awt.geom.RoundRectangle2D;
import javax.accessibility.AccessibleState;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JDesktopPane;
import javax.swing.JLayeredPane;
import javax.swing.text.View;
import view.panel.Login1;
import view.panel.lupapassword;
public class Login extends javax.swing.JFrame {
 

    public Login() {
        initComponents();
        setLocationRelativeTo(this);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
        panggillogin();
        

//        a = new panel_aboutversi();

    }
    public void panggillogin(){
        Login1 a = new Login1();
        a.setSize(1024, 577);
        this.add(a,new JPanel());
//        panel.setComponentZOrder(a, 0);
        this.revalidate();
        this.repaint();
        
    }
    public void panggillupapassword(){
        lupapassword a = new lupapassword();
        Login1 b = new Login1();
        a.setSize(1024, 577);
        this.add(a,new JLayeredPane());
        b.setVisible(false);
//        this.setComponentZOrder(a, 0);
        this.revalidate();
        this.repaint();
    }

    
    
    

//    public void ubah(){
//        panel_aboutversi a = new panel_aboutversi();
//        this.remove(target);
        
//    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        setSize(new java.awt.Dimension(1024, 577));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
