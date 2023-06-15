/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.panel;

import entity.Paket;
import entity.Presensi;
import entity.User;
import javax.swing.SwingUtilities;
import view.dialog.DialogTambahPaket;
import view.main.maindasboard;
import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import repository.PresensiRepository;
import repository.UserRepository;
import view.dialog.DialogEditPaket;
import view.dialog.DialogEditPegawai;
import view.dialog.DialogTambahPegawai;
import view.swing.PanelTabelAction;
import view.swing.TableActionEvent;
/**
 *
 * @author adzaz
 */
public class Pegawai extends javax.swing.JPanel {
    UserRepository userRepo = new UserRepository();
    PresensiRepository presensiRepo = new PresensiRepository();
    public static int id;
    private String pilihan = "akun";
    /**
     * Creates new form Pegawai
     */
    public Pegawai() {
        initComponents();
        if(pilihan.equals("akun")){
            loadTableAkun();
        }else if(pilihan.equals("presensi")){
            loadTablePresensi();
        }
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

    public void loadTableAkun(){
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void delete(int row) {
                int response = JOptionPane.showConfirmDialog(null, "Yakin menghapus data pada row = "+ row, "apa cobak?", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                // Tindakan yang diambil jika pengguna memilih "Yes"
                // Misalnya, menghapus data dari tabel atau melakukan tindakan lainnya
            } else {
                // Tindakan yang diambil jika pengguna memilih "No" atau menutup dialog
                // Misalnya, tidak melakukan apa pun atau membatalkan tindakan
            } 
            }
        };
        ImageRenderr render = new ImageRenderr();
        apacobak render1 = new apacobak(event); 
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("No");      
            model.addColumn("id");      
            model.addColumn("Nama");
            model.addColumn("Username");
            model.addColumn("Role");
            model.addColumn("Aksi");
            int no = 1;
           
           try {
             for(User res:userRepo.get()){
                model.addRow(new Object[]{
                    no++,
                    res.getId(),
                    res.getNama(),
                    res.getUsername(),
                    res.getRole(),
                });
           }
             table.setModel(model);
               table.getColumnModel().getColumn(5).setCellRenderer(render);
        table.getColumnModel().getColumn(5).setCellEditor(render1);
         } catch (Exception e) {
             e.printStackTrace();
         }
    }
    
    public void loadTablePresensi(){
            TableActionEvent event = new TableActionEvent() {
            @Override
            public void delete(int row) {
                int response = JOptionPane.showConfirmDialog(null, "Yakin menghapus data pada row = "+ row, "apa cobak?", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                // Tindakan yang diambil jika pengguna memilih "Yes"
                // Misalnya, menghapus data dari tabel atau melakukan tindakan lainnya
            } else {
                // Tindakan yang diambil jika pengguna memilih "No" atau menutup dialog
                // Misalnya, tidak melakukan apa pun atau membatalkan tindakan
            } 
            }
        };
        ImageRenderr render = new ImageRenderr();
        apacobak render1 = new apacobak(event); 
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("id");      
            model.addColumn("Nama");
            model.addColumn("Waktu");
            model.addColumn("Keterangan");
            model.addColumn("Aksi");
            
            int no = 1;
           
           try {
             for(Presensi res:presensiRepo.get()){
                model.addRow(new Object[]{
                    res.getId(),
                    res.getUser().getNama(),
                    res.getWaktuPresensi(),
                    res.getKeterangan(),
                    
                });
           }
             table.setModel(model);
              table.getColumnModel().getColumn(4).setCellRenderer(render);
        table.getColumnModel().getColumn(4).setCellEditor(render1);
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

        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblAkun1 = new javax.swing.JLabel();
        lblPresensi1 = new javax.swing.JLabel();
        lblPilihan = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new view.pallet.Table();
        btnHapus = new javax.swing.JLabel();
        btnEdit = new javax.swing.JLabel();
        btnTambah = new javax.swing.JLabel();

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/button CRUD.png"))); // NOI18N

        jPanel3.setBackground(new Color(0,0,0,0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        setBackground(new java.awt.Color(255, 249, 243));
        setPreferredSize(new java.awt.Dimension(1247, 768));

        jPanel1.setBackground(new Color(0,0,0,0));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/title pegawai.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblAkun1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAkun1MouseClicked(evt);
            }
        });

        lblPresensi1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPresensi1MouseClicked(evt);
            }
        });

        lblPilihan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/menu akun.png"))); // NOI18N

        jScrollPane2.setBackground(new Color(0,0,0,0));
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
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table);

        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/button hapustab.png"))); // NOI18N
        btnHapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHapusMouseClicked(evt);
            }
        });

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/buttoneditt.png"))); // NOI18N
        btnEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditMouseClicked(evt);
            }
        });

        btnTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/buttontambah.png"))); // NOI18N
        btnTambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTambahMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addGap(38, 38, 38))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(150, 150, 150)
                                .addComponent(lblPresensi1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblAkun1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPilihan, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 516, Short.MAX_VALUE)
                        .addComponent(btnHapus)
                        .addGap(20, 20, 20)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPresensi1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAkun1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPilihan, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahMouseClicked
        maindasboard main =(maindasboard)SwingUtilities.getWindowAncestor(this);
      DialogTambahPegawai tambahPegawai = new DialogTambahPegawai(main);
      tambahPegawai.showPopUp();
      loadTableAkun();
    }//GEN-LAST:event_btnTambahMouseClicked

    private void btnHapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapusMouseClicked
        boolean delete = userRepo.delete(id);
        if(delete){
            System.out.println("berhasil");
            loadTableAkun();
        }else {
            System.out.println("gagal");
        }
    }//GEN-LAST:event_btnHapusMouseClicked

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
        maindasboard main =(maindasboard)SwingUtilities.getWindowAncestor(this);
      DialogEditPegawai editPegawai = new DialogEditPegawai(main);
      editPegawai.showPopUp();
      loadTableAkun();
    }//GEN-LAST:event_btnEditMouseClicked

    private void lblAkun1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAkun1MouseClicked
        lblPilihan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/menu akun.png")));
        pilihan = "akun";
        loadTableAkun();
    }//GEN-LAST:event_lblAkun1MouseClicked

    private void lblPresensi1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPresensi1MouseClicked
        lblPilihan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/menu presensi.png")));
        pilihan = "presensi";
        loadTablePresensi();
    }//GEN-LAST:event_lblPresensi1MouseClicked

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
           int baris = table.rowAtPoint(evt.getPoint());
        String idd = table.getValueAt(baris, 0).toString();
        id = Integer.valueOf(idd);
    }//GEN-LAST:event_tableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnEdit;
    private javax.swing.JLabel btnHapus;
    private javax.swing.JLabel btnTambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAkun1;
    private javax.swing.JLabel lblPilihan;
    private javax.swing.JLabel lblPresensi1;
    private view.pallet.Table table;
    // End of variables declaration//GEN-END:variables
}
