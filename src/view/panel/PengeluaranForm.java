/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.panel;

import entity.Keberangkatan;
import entity.Pemesanan;
import entity.Pengeluaran;
import entity.PengeluaranOperasional;
import javax.swing.SwingUtilities;
import view.dialog.DialogTambahPaket;
import view.main.maindasboard;
import java.awt.Color;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.table.DefaultTableModel;
import repository.KeberangkatanRepository;
import repository.PengeluaranOperasionalRepository;
import repository.PengeluaranRepository;
import view.dialog.DialogEditPengeluaranOperasional;
import view.dialog.DialogEditPengeluaranProduksi;
import view.dialog.DialogPengeluaranProduksi;
import view.dialog.DialogTambahPengeluaranOperasional;
import view.main.Main;
/**
 *
 * @author adzaz
 */
public class PengeluaranForm extends javax.swing.JPanel {
    NumberFormat nf = NumberFormat.getNumberInstance(new Locale("in", "ID"));
    private String pilihan = "operasional";
    public static int totalPengeluaran;
    public static int id;
    public static int idKeberangkatan;
    PengeluaranOperasionalRepository pengeluaranOperasionalRepo = new PengeluaranOperasionalRepository();
    PengeluaranRepository pengeluaranRepo = new PengeluaranRepository();
    KeberangkatanRepository keberangkatanRepo = new KeberangkatanRepository();
    /**
     * Creates new form Pengeluaran
     */
    public PengeluaranForm() {
        initComponents();
        jPanel5.setOpaque(false);
        jLabel6.setVisible(false);
        btn_logout.setVisible(false);
        if(pilihan.equals("operasional")){
                    loadTableOperasional();
        }else if(pilihan.equals("produksi")){
            
        }
    }
    
        
         public void loadTableOperasional(){
            DefaultTableModel model = new DefaultTableModel();   
            model.addColumn("Id");      
            model.addColumn("Nama");
    
            model.addColumn("Tanggal");
            model.addColumn("Deskripsi");
            model.addColumn("Total");
         
         
           try {
             for(PengeluaranOperasional res:pengeluaranOperasionalRepo.get()){
                model.addRow(new Object[]{
                    res.getId(),
                    res.getNamaPengeluaran(),
                    res.getTanggal(),
                    res.getDeskripsi(),
                    nf.format(res.getJumlah())
                });
           }
             table.setModel(model);
         } catch (Exception e) {
             e.printStackTrace();
         }
    }
         public void loadTableOperasional(String search){
            DefaultTableModel model = new DefaultTableModel();   
            model.addColumn("Id");      
            model.addColumn("Nama");
    
            model.addColumn("Tanggal");
            model.addColumn("Deskripsi");
            model.addColumn("Total");
         
         
           try {
             for(PengeluaranOperasional res:pengeluaranOperasionalRepo.get()){
                model.addRow(new Object[]{
                    res.getId(),
                    res.getNamaPengeluaran(),
                    res.getTanggal(),
                    res.getDeskripsi(),
                    nf.format(res.getJumlah())
                });
           }
             table.setModel(model);
         } catch (Exception e) {
             e.printStackTrace();
         }
    }

         public void loadTableProduksi(){
             DefaultTableModel model = new DefaultTableModel();
            model.addColumn("id");
            model.addColumn("Nama");
            model.addColumn("Tanggal Keberangkatan");
            model.addColumn("Tanggal Pengeluaran");
            model.addColumn("Total pengeluran");
            int no = 1;
           
           try {
             for(Pengeluaran res:pengeluaranRepo.get()){
                model.addRow(new Object[]{
                    res.getId(),
                    res.getKeberangkatan().getPaket().getNama(),
                    res.getKeberangkatan().getTanggal(),
                    res.getTanggal(),
                    nf.format(res.getTotalPengeluaran())
                   
                });
           }
            table.setModel(model);
       
         } catch (Exception e) {
               e.printStackTrace();
         }
    }
         public void loadTableProduksi(String search){
             DefaultTableModel model = new DefaultTableModel();
            model.addColumn("id");
            model.addColumn("Nama");
            model.addColumn("Tanggal Keberangkatan");
            model.addColumn("Tanggal Pengeluaran");
            model.addColumn("Total pengeluran");
            int no = 1;
           
           try {
             for(Pengeluaran res:pengeluaranRepo.getById(Integer.valueOf(search))){
                model.addRow(new Object[]{
                    res.getId(),
                    res.getKeberangkatan().getPaket().getNama(),
                    res.getKeberangkatan().getTanggal(),
                    res.getTanggal(),
                    nf.format(res.getTotalPengeluaran())
                   
                });
           }
            table.setModel(model);
       
         } catch (Exception e) {
               e.printStackTrace();
         }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnHapus = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnOperasional1 = new javax.swing.JLabel();
        btnProduksi1 = new javax.swing.JLabel();
        lblPilihan1 = new javax.swing.JLabel();
        btnTambah = new javax.swing.JLabel();
        btnEdit = new javax.swing.JLabel();
        panelShadow1 = new view.swing.PanelShadow();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new view.pallet.Table();
        scrollBarCustom1 = new view.swing.ScrollBarCustom();
        jPanel2 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btn_logout = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        btnHapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHapusMouseClicked(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/button CRUD.png"))); // NOI18N

        setBackground(new java.awt.Color(255, 249, 243));
        setPreferredSize(new java.awt.Dimension(1366, 768));

        jPanel1.setBackground(new Color(0,0,0,0));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/title pengeluaran.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnOperasional1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOperasional1MouseClicked(evt);
            }
        });

        btnProduksi1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProduksi1MouseClicked(evt);
            }
        });

        lblPilihan1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/pilihan pengeluaran operasional.png"))); // NOI18N

        btnTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/buttontambah.png"))); // NOI18N
        btnTambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTambahMouseClicked(evt);
            }
        });

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/buttoneditt.png"))); // NOI18N
        btnEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditMouseClicked(evt);
            }
        });

        panelShadow1.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane2.setBorder(null);
        jScrollPane2.setVerticalScrollBar(scrollBarCustom1);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table);

        scrollBarCustom1.setForeground(new java.awt.Color(255, 90, 0));

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jScrollPane2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollBarCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scrollBarCustom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new Color(0,0,0,0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtSearch.setFont(new java.awt.Font("Quicksand Bold", 0, 14)); // NOI18N
        txtSearch.setBorder(null);
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        jPanel2.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 160, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/menusearch1.png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, 40));

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/buttonlogout3.png"))); // NOI18N
        btn_logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_logoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_logoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_logoutMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_logoutMousePressed(evt);
            }
        });
        jPanel5.add(btn_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 190, 50));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/menu_ujung.png"))); // NOI18N
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 26, -1, 130));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/button_menu2.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 0, -1, 30));
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 100, 24));
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, 30, 170));
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 210, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(47, 47, 47)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnOperasional1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10)
                                                .addComponent(btnProduksi1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(lblPilihan1)))
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 621, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnOperasional1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPilihan1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnProduksi1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(120, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahMouseClicked

    if(pilihan.equals("operasional")){
        maindasboard main =(maindasboard)SwingUtilities.getWindowAncestor(this);
        DialogTambahPengeluaranOperasional tambahPengeluaranOPerasional = new DialogTambahPengeluaranOperasional(main);
        tambahPengeluaranOPerasional.showPopUp();
        loadTableOperasional();
    }else if(pilihan.equals("produksi")){
        maindasboard main =(maindasboard)SwingUtilities.getWindowAncestor(this);
        DialogPengeluaranProduksi  tambahPengeluaranProduksi = new DialogPengeluaranProduksi(main);
        tambahPengeluaranProduksi.showPopUp();
        loadTableOperasional();
    }
    }//GEN-LAST:event_btnTambahMouseClicked

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
        
         if(pilihan.equals("operasional")){
        maindasboard main =(maindasboard)SwingUtilities.getWindowAncestor(this);
        DialogEditPengeluaranOperasional EditPengeluaranOPerasional = new DialogEditPengeluaranOperasional(main);
        EditPengeluaranOPerasional.showPopUp();
        loadTableOperasional();
        loadTableOperasional();
    }else if(pilihan.equals("produksi")){
        maindasboard main =(maindasboard)SwingUtilities.getWindowAncestor(this);
             DialogEditPengeluaranProduksi edirPengeluaranProduksi = new DialogEditPengeluaranProduksi(main);
        edirPengeluaranProduksi.showPopUp();
        loadTableOperasional();
    }
    }//GEN-LAST:event_btnEditMouseClicked

    private void btnHapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapusMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHapusMouseClicked

    private void btnProduksi1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProduksi1MouseClicked
    lblPilihan1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/pilihan pengeluaran produksi.png")));
    pilihan = "produksi";
    id = 0;
    loadTableProduksi();
    }//GEN-LAST:event_btnProduksi1MouseClicked

    private void btnOperasional1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOperasional1MouseClicked
        lblPilihan1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/pilihan pengeluaran operasional.png")));
        pilihan = "operasional";
        id = 0;
        loadTableOperasional();
    }//GEN-LAST:event_btnOperasional1MouseClicked

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        int baris = table.rowAtPoint(evt.getPoint());
        String idd = table.getValueAt(baris, 0).toString();
        id = Integer.valueOf(idd);
    }//GEN-LAST:event_tableMouseClicked

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        if(pilihan.equals("operasional")){
            loadTableOperasional(txtSearch.getText());
        }else{
            loadTableProduksi(txtSearch.getText());
        }

    }//GEN-LAST:event_txtSearchKeyReleased

    private void btn_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_logoutMouseClicked

        maindasboard main1 = (maindasboard)SwingUtilities.getWindowAncestor(this);
        main1.dispose();
        new Main().setVisible(true);
    }//GEN-LAST:event_btn_logoutMouseClicked

    private void btn_logoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_logoutMouseEntered
        btn_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/buttonlogout1.png")));
    }//GEN-LAST:event_btn_logoutMouseEntered

    private void btn_logoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_logoutMouseExited
        btn_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/buttonlogout3.png")));
    }//GEN-LAST:event_btn_logoutMouseExited

    private void btn_logoutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_logoutMousePressed
        btn_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/buttonlogout2.png")));
    }//GEN-LAST:event_btn_logoutMousePressed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
    jLabel6.setVisible(true);
    btn_logout.setVisible(true);
    jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/button_menu.png")));
    }//GEN-LAST:event_jLabel4MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnEdit;
    private javax.swing.JLabel btnHapus;
    private javax.swing.JLabel btnOperasional1;
    private javax.swing.JLabel btnProduksi1;
    private javax.swing.JLabel btnTambah;
    private javax.swing.JLabel btn_logout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblPilihan1;
    private view.swing.PanelShadow panelShadow1;
    private view.swing.ScrollBarCustom scrollBarCustom1;
    private view.pallet.Table table;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
