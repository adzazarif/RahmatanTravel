package view.component;

import view.event.EventMenuSelected;
import view.model.ModelMenu;
import view.swing.MenuItem;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.ActionListener;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import org.jdesktop.animation.timing.interpolation.PropertySetter;
import org.jdesktop.swingx.SwingXUtilities;
import view.main.maindasboard;
import view.panel.BarangForm;
import view.panel.Dasboard;
import view.panel.JamaahForm;
import view.panel.KeberangkatanForm;
import view.panel.LaporanForm;
import view.panel.PaketForm;
import view.panel.Pegawai;
import view.panel.PemesananForm;
import view.panel.PengeluaranForm;

public class Menu extends javax.swing.JPanel {
    private int roundTopLeft = 0;
    private int roundTopRight = 40;
    private int roundBottomLeft = 0;
    private int roundBottomRight = 40;
    private MigLayout layout;
    private JPanel panelMenu;
    private JButton cmdMenu;
    private JButton cmdLogOut;
    private Animator animator;

    public Menu() {
        initComponents();
        setOpaque(false);
        init();
        setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 30));
        Font font = new Font("Quicksand", Font.BOLD, 20);
        
        
        
        
//        createButtonMenu();
    }

    private void init() {
        setLayout(new MigLayout("wrap, fillx, insets 0", "[fill]", "150[]0"));
        panelMenu = new JPanel();
        createButtonMenu();
        panelMenu.setOpaque(false);
        layout = new MigLayout("fillx, wrap", "0[fill]0", "0[]0");
        panelMenu.setLayout(layout);
////        panelMenu.setBorder(BorderFactory.createEmptyBorder(0, 5, 30, 30));
        panelMenu.setLayout(new GridLayout(2, 2));
        add(cmdMenu, "pos 1al 0al 100% 65");
//        add(panelMenu);
    }

    public void addMenu(ModelMenu menu) {
        MenuItem item = new MenuItem(menu.getIcon(), menu.getMenuName(), panelMenu.getComponentCount());
        item.addEvent(new EventMenuSelected() {
            @Override
            public void selected(int index) {
                clearMenu(index);
            }
        });
        panelMenu.add(item);
    }

    private void createButtonMenu() {
        cmdMenu = new JButton();
        cmdMenu.setContentAreaFilled(false);
        cmdMenu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cmdMenu.setIcon(new ImageIcon(getClass().getResource("/view/icon/menu.png")));
        cmdMenu.setMargin(new Insets(0, 0, 0, 10));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new javax.swing.JPanel();
        Pengeluaran = new javax.swing.JLabel();
        Berangkat = new javax.swing.JLabel();
        Paket = new javax.swing.JLabel();
        jamaah = new javax.swing.JLabel();
        Dasboard = new javax.swing.JLabel();
        Barang = new javax.swing.JLabel();
        Pemesanan = new javax.swing.JLabel();
        Laporan = new javax.swing.JLabel();
        Pegawai = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setBackground(new Color(0,0,0,0));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel1.setBackground(new Color(0,0,0,0));
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Pengeluaran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PengeluaranMouseClicked(evt);
            }
        });
        panel1.add(Pengeluaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, 200, 50));

        Berangkat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BerangkatMouseClicked(evt);
            }
        });
        panel1.add(Berangkat, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 200, 50));

        Paket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PaketMouseClicked(evt);
            }
        });
        panel1.add(Paket, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 200, 50));

        jamaah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jamaahMouseClicked(evt);
            }
        });
        panel1.add(jamaah, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 200, 50));

        Dasboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DasboardMouseClicked(evt);
            }
        });
        panel1.add(Dasboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 200, 50));

        Barang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BarangMouseClicked(evt);
            }
        });
        panel1.add(Barang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 200, 50));

        Pemesanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PemesananMouseClicked(evt);
            }
        });
        panel1.add(Pemesanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 200, 50));

        Laporan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LaporanMouseClicked(evt);
            }
        });
        panel1.add(Laporan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 200, 50));

        Pegawai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PegawaiMouseClicked(evt);
            }
        });
        panel1.add(Pegawai, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 200, 50));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/sideDasboard.png"))); // NOI18N
        panel1.add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 200, 570));

        add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 580));
    }// </editor-fold>//GEN-END:initComponents

    private void jamaahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jamaahMouseClicked
       bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/sideJamaah.png")));
       maindasboard main1 =(maindasboard)SwingUtilities.getWindowAncestor(this);
       main1.showform(new JamaahForm());
       jamaah.setVisible(false);
       Dasboard.setVisible(true);
       Paket.setVisible(true);
       Berangkat.setVisible(true);
       Barang.setVisible(true);
       Pemesanan.setVisible(true);
       Laporan.setVisible(true);
       Pegawai.setVisible(true);
       Pengeluaran.setVisible(true);
       
    }//GEN-LAST:event_jamaahMouseClicked

    private void DasboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DasboardMouseClicked
       bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/sideDasboard.png")));
       maindasboard main1 =(maindasboard)SwingUtilities.getWindowAncestor(this);
       main1.showform(new Dasboard());
       Dasboard.setVisible(false);
       jamaah.setVisible(true);
       Paket.setVisible(true);
       Berangkat.setVisible(true);
       Barang.setVisible(true);
       Pemesanan.setVisible(true);
       Laporan.setVisible(true);
       Pegawai.setVisible(true);
       Pengeluaran.setVisible(true);

    }//GEN-LAST:event_DasboardMouseClicked

    private void PaketMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PaketMouseClicked
       bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/sidePaket.png")));
       maindasboard main1 =(maindasboard)SwingUtilities.getWindowAncestor(this);
       main1.showform(new PaketForm());
       Dasboard.setVisible(true);
       jamaah.setVisible(true);
       Paket.setVisible(false);
       Berangkat.setVisible(true);
       Barang.setVisible(true);
       Pemesanan.setVisible(true);
       Laporan.setVisible(true);
       Pegawai.setVisible(true);
       Pengeluaran.setVisible(true);
    }//GEN-LAST:event_PaketMouseClicked

    private void BerangkatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BerangkatMouseClicked
       bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/sideBerangkat.png")));
       maindasboard main1 =(maindasboard)SwingUtilities.getWindowAncestor(this);
       main1.showform(new KeberangkatanForm());
       Dasboard.setVisible(true);
       jamaah.setVisible(true);
       Paket.setVisible(true);
       Berangkat.setVisible(false);
       Barang.setVisible(true);
       Pemesanan.setVisible(true);
       Laporan.setVisible(true);
       Pegawai.setVisible(true);
       Pengeluaran.setVisible(true);
       
    }//GEN-LAST:event_BerangkatMouseClicked

    private void PengeluaranMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengeluaranMouseClicked
       bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/sidePengeluaran.png")));
       maindasboard main1 =(maindasboard)SwingUtilities.getWindowAncestor(this);
       main1.showform(new PengeluaranForm());
       Dasboard.setVisible(true);
       jamaah.setVisible(true);
       Paket.setVisible(true);
       Berangkat.setVisible(true);
       Barang.setVisible(true);
       Pemesanan.setVisible(true);
       Laporan.setVisible(true);
       Pegawai.setVisible(true);
       Pengeluaran.setVisible(false);
       
    }//GEN-LAST:event_PengeluaranMouseClicked

    private void BarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BarangMouseClicked
       bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/sideBarang.png")));
       maindasboard main1 =(maindasboard)SwingUtilities.getWindowAncestor(this);
       main1.showform(new BarangForm());
       Dasboard.setVisible(true);
       jamaah.setVisible(true);
       Paket.setVisible(true);
       Berangkat.setVisible(true);
       Barang.setVisible(false);
       Pemesanan.setVisible(true);
       Laporan.setVisible(true);
       Pegawai.setVisible(true);
       Pengeluaran.setVisible(true);
       
    }//GEN-LAST:event_BarangMouseClicked

    private void PemesananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PemesananMouseClicked
       bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/sidePemesanan.png")));
       maindasboard main1 =(maindasboard)SwingUtilities.getWindowAncestor(this);
       main1.showform(new PemesananForm());
       Dasboard.setVisible(true);
       jamaah.setVisible(true);
       Paket.setVisible(true);
       Berangkat.setVisible(true);
       Barang.setVisible(true);
       Pemesanan.setVisible(false);
       Laporan.setVisible(true);
       Pegawai.setVisible(true);
       Pengeluaran.setVisible(true);
       
    }//GEN-LAST:event_PemesananMouseClicked

    private void LaporanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LaporanMouseClicked
       bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/sideLaporan.png")));
       maindasboard main1 =(maindasboard)SwingUtilities.getWindowAncestor(this);
       main1.showform(new LaporanForm());
       Dasboard.setVisible(true);
       jamaah.setVisible(true);
       Paket.setVisible(true);
       Berangkat.setVisible(true);
       Barang.setVisible(true);
       Pemesanan.setVisible(true);
       Laporan.setVisible(false);
       Pegawai.setVisible(true);
       Pengeluaran.setVisible(true);
       
    }//GEN-LAST:event_LaporanMouseClicked

    private void PegawaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PegawaiMouseClicked
       bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/sidePegawai.png")));
       maindasboard main1 =(maindasboard)SwingUtilities.getWindowAncestor(this);
       main1.showform(new Pegawai());
       Dasboard.setVisible(true);
       jamaah.setVisible(true);
       Paket.setVisible(true);
       Berangkat.setVisible(true);
       Barang.setVisible(true);
       Pemesanan.setVisible(true);
       Laporan.setVisible(true);
       Pegawai.setVisible(false);
       Pengeluaran.setVisible(true);
    }//GEN-LAST:event_PegawaiMouseClicked

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        GradientPaint gra = new GradientPaint(0, 0, Color.decode("#FF7900"), 0, getHeight(), Color.decode("#FF3B06"));
        g2.setPaint(gra);
        Area area = new Area(createRoundTopLeft());
        if (roundTopRight > 0) {
            area.intersect(new Area(createRoundTopRight()));
        }
        if (roundBottomLeft > 0) {
            area.intersect(new Area(createRoundBottomLeft()));
        }
        if (roundBottomRight > 0) {
            area.intersect(new Area(createRoundBottomRight()));
        }
        g2.fill(area);

        super.paintComponent(grphcs);
    }
    private Shape createRoundTopLeft() {
        int width = getWidth();
        int height = 768;
        int roundX = Math.min(width, roundTopLeft);
        int roundY = Math.min(height, roundTopLeft);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(roundX / 2, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, roundY / 2, width, height - roundY / 2)));
        return area;
    }

    private Shape createRoundTopRight() {
        int width = getWidth();
        int height = 768;
        int roundX = Math.min(width, roundTopRight);
        int roundY = Math.min(height, roundTopRight);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(0, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, roundY / 2, width, height - roundY / 2)));
        return area;
    }

    private Shape createRoundBottomLeft() {
        int width = getWidth();
        int height = 768;
        int roundX = Math.min(width, roundBottomLeft);
        int roundY = Math.min(height, roundBottomLeft);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(roundX / 2, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, 0, width, height - roundY / 2)));
        return area;
    }

    private Shape createRoundBottomRight() {
        int width = getWidth();
        int height = 768;
        int roundX = Math.min(width, roundBottomRight);
        int roundY = Math.min(height, roundBottomRight);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(0, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, 0, width, height - roundY / 2)));
        return area;
    }
    private void clearMenu(int exceptIndex) {
        for (Component com : panelMenu.getComponents()) {
            MenuItem item = (MenuItem) com;
            if (item.getIndex() != exceptIndex) {
                item.setSelected(false);
            }
        }
    }

    public void addEventMenu(ActionListener event) {
        cmdMenu.addActionListener(event);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Barang;
    private javax.swing.JLabel Berangkat;
    private javax.swing.JLabel Dasboard;
    private javax.swing.JLabel Laporan;
    private javax.swing.JLabel Paket;
    private javax.swing.JLabel Pegawai;
    private javax.swing.JLabel Pemesanan;
    private javax.swing.JLabel Pengeluaran;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel jamaah;
    private javax.swing.JPanel panel1;
    // End of variables declaration//GEN-END:variables
}
