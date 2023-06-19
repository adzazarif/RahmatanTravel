/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.panel;

import entity.Barang;
import entity.BarangMasuk;
import entity.DetailPengeluaran;
import entity.PengeluaranOperasional;
import javax.swing.SwingUtilities;
import view.dialog.DialogTambahPaket;
import view.main.maindasboard;
import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import repository.BarangMasukRepository;
import repository.BarangRepository;
import repository.DetailPengeluaranRepository;
import service.NotificationStokBarang;
import util.Conn;
import view.dialog.DIalogTambahStok;
import view.dialog.DialogEditBarang;
import view.dialog.DialogTambahBarang;
import view.main.Main;
import view.swing.PanelTabelAction;
import view.swing.TableActionEvent;
/**
 *
 * @author semafie
 */
public class BarangForm extends javax.swing.JPanel {
    BarangRepository barangRepo = new BarangRepository();
    BarangMasukRepository barangMasukRepo = new BarangMasukRepository();
    DetailPengeluaranRepository detailPengeluaranRepo = new DetailPengeluaranRepository();
    private String pilihan = "stok";
    public static int id;
    /**
     * Creates new form Barang
     */
    public BarangForm() {
        initComponents();
        jPanel5.setOpaque(false);
        jLabel6.setVisible(false);
        btn_logout.setVisible(false);
        jScrollPane2.setOpaque(false);
        if(pilihan.equals("stok")){
            loadTableStok();
        }else if(pilihan.equals("masuk")){
            loadTableMasuk();
        }else if(pilihan.equals("keluar")){
            loadTableKeluar();
        }
//        notification();
             ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        
        service.schedule(BarangForm::notification, 1, TimeUnit.SECONDS);
    }
    
    private class apacobak extends DefaultCellEditor{
        
    private TableActionEvent event;
    
    public apacobak(TableActionEvent event){
        super(new JCheckBox());
        this.event = event;
        
    }
    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
    PanelTabelAction action = new PanelTabelAction();
    action.initEvent(event, row);
    action.setBackground(table.getSelectionBackground());
    return action;
    }
    }
    
    private class ImageRenderr extends DefaultTableCellRenderer {

        @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        PanelTabelAction action = new PanelTabelAction();
        if(isSelected == false && row % 2 == 0){
            action.setBackground(Color.WHITE);
        } else {
            action.setBackground(com.getBackground());
        }
        return action;
    }

    }
    
    public static void notification(){
        try {
             boolean status = NotificationStokBarang.status;
        if(status){
            JOptionPane.showMessageDialog(null, "barang menipis");
            NotificationStokBarang.status = false;
        }
        } catch (Exception e) {
        }
    }
        
     public void loadTableStok(){
         TableActionEvent event = new TableActionEvent() {
            @Override
            public void delete(int row) {
                int idJ = Integer.valueOf(table.getValueAt(row, 0).toString());
                int response = JOptionPane.showConfirmDialog(null, "Yakin menghapus data pada row = "+ row+", id"+idJ, "apa cobak?", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                boolean delete = barangRepo.delete(idJ);
                loadTableStok();
            } else {
                // Tindakan yang diambil jika pengguna memilih "No" atau menutup dialog
                // Misalnya, tidak melakukan apa pun atau membatalkan tindakan
            } 
            }
        };
         
        ImageRenderr render = new ImageRenderr();
        apacobak render1 = new apacobak(event);   
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Id");      
            model.addColumn("Nama");
            model.addColumn("Stok");
            model.addColumn("Harga");
            model.addColumn("Aksi");
         
        
           try {
             for(Barang res:barangRepo.get()){
                model.addRow(new Object[]{
                    res.getId(),
                    res.getNama(),
                    res.getStok(),
                    res.getHarga(),
                });
           }
             table.setModel(model);
       table.getColumnModel().getColumn(4).setCellRenderer(render);
        table.getColumnModel().getColumn(4).setCellEditor(render1);
         } catch (Exception e) {
             e.printStackTrace();
         }
    }
     
      public void loadTableStok(String search){
           TableActionEvent event = new TableActionEvent() {
            @Override
            public void delete(int row) {
                int idJ = Integer.valueOf(table.getValueAt(row, 0).toString());
                int response = JOptionPane.showConfirmDialog(null, "Yakin menghapus data pada row = "+ row+", id"+idJ, "apa cobak?", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                boolean delete = barangRepo.delete(idJ);
                loadTableStok();
            } else {
                // Tindakan yang diambil jika pengguna memilih "No" atau menutup dialog
                // Misalnya, tidak melakukan apa pun atau membatalkan tindakan
            } 
            }
        };
         
        ImageRenderr render = new ImageRenderr();
        apacobak render1 = new apacobak(event); 
        
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Id");      
            model.addColumn("Nama");
            model.addColumn("Stok");
            model.addColumn("Harga");
            model.addColumn("Aksi");
         
        
           try {
             for(Barang res:barangRepo.getSearch(search)){
                model.addRow(new Object[]{
                    res.getId(),
                    res.getNama(),
                    res.getStok(),
                    res.getHarga(),
                });
           }
             table.setModel(model);

       table.getColumnModel().getColumn(4).setCellRenderer(render);
        table.getColumnModel().getColumn(4).setCellEditor(render1);
         } catch (Exception e) {
             e.printStackTrace();
         }
    }
     
       public void loadTableMasuk(){
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Id");      
            model.addColumn("Nama");
            model.addColumn("Tanggal");
            model.addColumn("Harga");
            model.addColumn("Jumlah");
            model.addColumn("Total Harga");
            
           try {
             for(BarangMasuk res:barangMasukRepo.get()){
                 int jumlah = res.getJumlah() * res.getBarang().getHarga();
                model.addRow(new Object[]{
                    res.getId(),
                    res.getBarang().getNama(),
                    res.getTanggal().toString(),
                    res.getBarang().getHarga(),
                    res.getJumlah(),
                    jumlah
                });
           }
             table.setModel(model);
         } catch (Exception e) {
             e.printStackTrace();
         }
    }
        public void loadTableMasuk(String Search){
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Id");      
            model.addColumn("Nama");
            model.addColumn("Tanggal");
            model.addColumn("Harga");
            model.addColumn("Jumlah");
            model.addColumn("Total Harga");
            
           try {
             for(BarangMasuk res:barangMasukRepo.getSearch(Search)){
                 int jumlah = res.getJumlah() * res.getBarang().getHarga();
                model.addRow(new Object[]{
                    res.getId(),
                    res.getBarang().getNama(),
                    res.getTanggal().toString(),
                    res.getBarang().getHarga(),
                    res.getJumlah(),
                    jumlah
                });
           }
             table.setModel(model);
         } catch (Exception e) {
             e.printStackTrace();
         }
    }
       
          public void loadTableKeluar(){
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Id");      
            model.addColumn("Nama");
            model.addColumn("Tanggal");
            model.addColumn("Harga");
            model.addColumn("Jumlah");
            model.addColumn("Total Harga");
            
           try {
             for(DetailPengeluaran res:detailPengeluaranRepo.get()){
                 int jumlah = res.getBarang().getHarga() * res.getBanyak();
                model.addRow(new Object[]{
                    res.getId(),
                    res.getBarang().getNama(),
                    res.getPengeluaran().getTanggal().toString(),
                    res.getBarang().getHarga(),
                    res.getBanyak(),
                    jumlah
                });
           }
             table.setModel(model);
         } catch (Exception e) {
             e.printStackTrace();
         }
    }
          
              public void loadTableKeluar(String search){
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Id");      
            model.addColumn("Nama");
            model.addColumn("Tanggal");
            model.addColumn("Harga");
            model.addColumn("Jumlah");
            model.addColumn("Total Harga");
            
           try {
             for(DetailPengeluaran res:detailPengeluaranRepo.getSearch(search)){
                 int jumlah = res.getBarang().getHarga() * res.getBanyak();
                model.addRow(new Object[]{
                    res.getId(),
                    res.getBarang().getNama(),
                    res.getPengeluaran().getTanggal().toString(),
                    res.getBarang().getHarga(),
                    res.getBanyak(),
                    jumlah
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

        jPanel5 = new javax.swing.JPanel();
        btn_logout = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        bntMasuk = new javax.swing.JLabel();
        bntKeluar = new javax.swing.JLabel();
        bntStok1 = new javax.swing.JLabel();
        lblPilihan = new javax.swing.JLabel();
        btnEdit = new javax.swing.JLabel();
        panelShadow1 = new view.swing.PanelShadow();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new view.pallet.Table();
        scrollBarCustom1 = new view.swing.ScrollBarCustom();
        jPanel3 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 249, 243));
        setPreferredSize(new java.awt.Dimension(1366, 768));

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

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/button_menu2.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 0, -1, 30));

        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel8MouseEntered(evt);
            }
        });
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 100, 24));

        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel9MouseEntered(evt);
            }
        });
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, 30, 170));

        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel10MouseEntered(evt);
            }
        });
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 210, 30));

        jPanel1.setBackground(new Color(0,0,0,0));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/title barang.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/button barang.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/button stok.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jPanel2.setBackground(new Color(0,0,0,0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bntMasuk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bntMasukMouseClicked(evt);
            }
        });
        jPanel2.add(bntMasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 130, 30));

        bntKeluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bntKeluarMouseClicked(evt);
            }
        });
        jPanel2.add(bntKeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 130, 30));

        bntStok1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bntStok1MouseClicked(evt);
            }
        });
        jPanel2.add(bntStok1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 30));

        lblPilihan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/menu stok.png"))); // NOI18N
        jPanel2.add(lblPilihan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/buttoneditt.png"))); // NOI18N
        btnEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditMouseClicked(evt);
            }
        });

        panelShadow1.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(null);

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
        table.setGridColor(new java.awt.Color(204, 204, 204));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table);

        scrollBarCustom1.setBackground(new java.awt.Color(255, 51, 0));
        scrollBarCustom1.setForeground(new java.awt.Color(255, 90, 0));

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jScrollPane2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollBarCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                    .addComponent(scrollBarCustom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new Color(0,0,0,0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtSearch.setBorder(null);
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        jPanel3.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 160, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/menusearch1.png"))); // NOI18N
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 231, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 287, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel3))
                            .addComponent(btnEdit)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bntMasukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntMasukMouseClicked
               lblPilihan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/menu masuk.png")));
               pilihan = "masuk";
               loadTableMasuk();
    }//GEN-LAST:event_bntMasukMouseClicked

    private void bntKeluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntKeluarMouseClicked
lblPilihan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/menu keluar.png")));
pilihan = "keluar";
loadTableKeluar();
    }//GEN-LAST:event_bntKeluarMouseClicked

    private void bntStok1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntStok1MouseClicked
        lblPilihan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/menu stok.png")));
        pilihan = "stok";
        loadTableStok();
    }//GEN-LAST:event_bntStok1MouseClicked

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        int baris = table.rowAtPoint(evt.getPoint());
        String idd = table.getValueAt(baris, 0).toString();
        id = Integer.valueOf(idd);
        System.out.println(id);
    }//GEN-LAST:event_tableMouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        maindasboard main =(maindasboard)SwingUtilities.getWindowAncestor(this);
        DIalogTambahStok panggilTambah = new DIalogTambahStok(main);
        panggilTambah.showPopUp();
        loadTableStok();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
        maindasboard main =(maindasboard)SwingUtilities.getWindowAncestor(this);
        DialogEditBarang panggilTambah = new DialogEditBarang(main);
        panggilTambah.showPopUp();
        loadTableStok();
    }//GEN-LAST:event_btnEditMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
          maindasboard main =(maindasboard)SwingUtilities.getWindowAncestor(this);
        DialogTambahBarang panggilTambah = new DialogTambahBarang(main);
        panggilTambah.showPopUp();
        loadTableStok();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        if(pilihan.equals("stok")){
            loadTableStok(txtSearch.getText());
        }else if(pilihan.equals("masuk")){
            loadTableMasuk(txtSearch.getText());
        }else if(pilihan.equals("keluar")){
            loadTableKeluar(txtSearch.getText());
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

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        jLabel6.setVisible(true);
        btn_logout.setVisible(true);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/button_menu.png")));
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseEntered
        jLabel6.setVisible(false);
        btn_logout.setVisible(false);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/button_menu2.png")));
    }//GEN-LAST:event_jLabel8MouseEntered

    private void jLabel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseEntered
        jLabel6.setVisible(false);
        btn_logout.setVisible(false);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/button_menu2.png")));
    }//GEN-LAST:event_jLabel9MouseEntered

    private void jLabel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseEntered
        jLabel6.setVisible(false);
        btn_logout.setVisible(false);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/button_menu2.png")));
    }//GEN-LAST:event_jLabel10MouseEntered

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bntKeluar;
    private javax.swing.JLabel bntMasuk;
    private javax.swing.JLabel bntStok1;
    private javax.swing.JLabel btnEdit;
    private javax.swing.JLabel btn_logout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblPilihan;
    private view.swing.PanelShadow panelShadow1;
    private view.swing.ScrollBarCustom scrollBarCustom1;
    private view.pallet.Table table;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
