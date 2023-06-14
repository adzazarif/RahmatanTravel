package view.main;

import view.component.Menu;
import view.model.ModelMenu;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import service.Auth;
import view.component.Menu1;
import view.event.EventMenuSelected;
import view.model.ModelMenu1;
import view.panel.BarangForm;
import view.panel.Dasboard;
import view.panel.JamaahForm;
import view.panel.KeberangkatanForm;
import view.panel.LaporanForm;
import view.panel.PaketForm;
import view.panel.Pegawai;
import view.panel.PemesananForm;
import view.panel.PengeluaranForm;
import view.panel.employee.KeberangkatanEmployee;
import view.panel.employee.PaketEmployee;

public class maindasboard extends javax.swing.JFrame {
//    Auth auth = new Auth();
    private String role = Auth.level;
    private Menu1 menu = new Menu1();
    private JPanel main = new JPanel();
    private MigLayout layout;
    private Animator animator;
    private boolean menuShow;

    public maindasboard() {
        initComponents();
        init();
//        Main apa = (Main)SwingUtilities.getWindowAncestor(this);
//        apa.dispose();
    }

    private void init() {
        layout = new MigLayout("fill", "0[]10[]0", "0[fill]0");
        body.setLayout(layout);
        main.setOpaque(false);
        main.setLayout(new BorderLayout());
        menu.setBorder(BorderFactory.createEmptyBorder(0, 5, 30, 30));
        if(role.equals("owner")){
            menu.setEvent(new EventMenuSelected() {
            @Override
            
            
            public void selected(int index) {
                if (index == 0) {
                    showform(new Dasboard());
                } else if (index == 1) {
                    showform(new JamaahForm());
                } else if (index == 2) {
                    showform(new PaketForm());
                } else if (index == 3) {
                    showform(new KeberangkatanForm());
                } else if (index == 4) {
                    showform(new BarangForm());
                } else if (index == 5) {
                    showform(new PemesananForm());
                } else if (index == 6) {
                    showform(new Pegawai());
                } else if (index == 7) {
                    showform(new PengeluaranForm());
                } else if (index == 8) {
                    showform(new LaporanForm());
                }
            }
        });
             menu.addMenu(new ModelMenu1(new ImageIcon(getClass().getResource("/view/icon/dasboard2.png")), new ImageIcon(getClass().getResource("/view/icon/dasboard1.png"))));
        menu.addMenu(new ModelMenu1(new ImageIcon(getClass().getResource("/view/icon/jamaah2.png")), new ImageIcon(getClass().getResource("/view/icon/jamaah1.png"))));
        menu.addMenu(new ModelMenu1(new ImageIcon(getClass().getResource("/view/icon/paket2.png")), new ImageIcon(getClass().getResource("/view/icon/paket1.png"))));
        menu.addMenu(new ModelMenu1(new ImageIcon(getClass().getResource("/view/icon/berangkat2.png")), new ImageIcon(getClass().getResource("/view/icon/berangkat1.png"))));
        menu.addMenu(new ModelMenu1(new ImageIcon(getClass().getResource("/view/icon/barang2.png")), new ImageIcon(getClass().getResource("/view/icon/barang1.png"))));
        menu.addMenu(new ModelMenu1(new ImageIcon(getClass().getResource("/view/icon/pemesanan2.png")), new ImageIcon(getClass().getResource("/view/icon/pemesanan1.png"))));
        menu.addMenu(new ModelMenu1(new ImageIcon(getClass().getResource("/view/icon/pegawai2.png")), new ImageIcon(getClass().getResource("/view/icon/pegawai1.png"))));
        menu.addMenu(new ModelMenu1(new ImageIcon(getClass().getResource("/view/icon/pengeluaran2.png")), new ImageIcon(getClass().getResource("/view/icon/pengeluaran1.png"))));
        menu.addMenu(new ModelMenu1(new ImageIcon(getClass().getResource("/view/icon/laporan2.png")), new ImageIcon(getClass().getResource("/view/icon/laporan1.png"))));
        
        }else if(role.equals("employee")){
             menu.setEvent(new EventMenuSelected() {
            @Override
            
            
            public void selected(int index) {
                if (index == 0) {
                    showform(new Dasboard());
                } else if (index == 1) {
                    showform(new JamaahForm());
                } else if (index == 2) {
                    showform(new PaketEmployee());
                } else if(index == 3){
                    showform(new KeberangkatanEmployee());
                }else if(index == 4){
                    showform(new PemesananForm());
                }
            }
        });
             menu.addMenu(new ModelMenu1(new ImageIcon(getClass().getResource("/view/icon/dasboard2.png")), new ImageIcon(getClass().getResource("/view/icon/dasboard1.png"))));
        menu.addMenu(new ModelMenu1(new ImageIcon(getClass().getResource("/view/icon/jamaah2.png")), new ImageIcon(getClass().getResource("/view/icon/jamaah1.png"))));
        menu.addMenu(new ModelMenu1(new ImageIcon(getClass().getResource("/view/icon/paket2.png")), new ImageIcon(getClass().getResource("/view/icon/paket1.png"))));
        menu.addMenu(new ModelMenu1(new ImageIcon(getClass().getResource("/view/icon/berangkat2.png")), new ImageIcon(getClass().getResource("/view/icon/berangkat1.png"))));
//        menu.addMenu(new ModelMenu1(new ImageIcon(getClass().getResource("/view/icon/barang2.png")), new ImageIcon(getClass().getResource("/view/icon/barang1.png"))));
        menu.addMenu(new ModelMenu1(new ImageIcon(getClass().getResource("/view/icon/pemesanan2.png")), new ImageIcon(getClass().getResource("/view/icon/pemesanan1.png"))));
//        menu.addMenu(new ModelMenu1(new ImageIcon(getClass().getResource("/view/icon/pegawai2.png")), new ImageIcon(getClass().getResource("/view/icon/pegawai1.png"))));
//        menu.addMenu(new ModelMenu1(new ImageIcon(getClass().getResource("/view/icon/pengeluaran2.png")), new ImageIcon(getClass().getResource("/view/icon/pengeluaran1.png"))));
//        menu.addMenu(new ModelMenu1(new ImageIcon(getClass().getResource("/view/icon/laporan2.png")), new ImageIcon(getClass().getResource("/view/icon/laporan1.png"))));
        
        }
        
       
        menu.addEventMenu(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()) {
                    animator.start();
                }
            }
        });

        body.add(menu, "w 79!");
        body.add(main, "w 100%");
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double width;
                if (menuShow) {
                    width = 79 + (150 * (1f - fraction));
                } else {
                    width = 79 + (150 * fraction);
                }
                layout.setComponentConstraints(menu, "w " + width + "!");
                body.revalidate();
            }

            @Override
            public void end() {
                menuShow = !menuShow;
            }
        };
        animator = new Animator(400, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        showform(new Dasboard());
        
    }

    public void showform(Component com) {
        main.removeAll();
        main.add(com);
        main.revalidate();
        main.repaint();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        body = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 249, 243));
        setUndecorated(true);

        body.setBackground(new java.awt.Color(255, 249, 243));

        javax.swing.GroupLayout bodyLayout = new javax.swing.GroupLayout(body);
        body.setLayout(bodyLayout);
        bodyLayout.setHorizontalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1366, Short.MAX_VALUE)
        );
        bodyLayout.setVerticalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 768, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(maindasboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(maindasboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(maindasboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(maindasboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new maindasboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    // End of variables declaration//GEN-END:variables
}
