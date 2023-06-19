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
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import repository.PresensiRepository;
import repository.UserRepository;
import view.dialog.DialogAturPresensi;
import view.dialog.DialogDetailPegawai;
import view.dialog.DialogEditPaket;
import view.dialog.DialogEditPegawai;
import view.dialog.DialogTambahPegawai;
import view.main.Main;
import view.swing.Notification;
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
        jPanel2.setOpaque(false);
        jPanel4.setOpaque(false);
        jPanel5.setOpaque(false);
        jPanel6.setOpaque(false);
        jLabel6.setVisible(false);
        btn_logout.setVisible(false);
        if(pilihan.equals("akun")){
            loadTableAkun();
        }else if(pilihan.equals("presensi")){
            loadTablePresensi();
        }
        setValueTime();
        fillComboBoxJamaah();
    }
    private void fillComboBoxJamaah(){
        try {
              for(User jm:userRepo.get()){
           cmbNama.addItem(jm.getNama()+","+jm.getId());
        }
        } catch (Exception e) {
        }
    }
    public void setValueTime(){
        lbl_presensimulai.setText(Presensi.StartPresensi);
        lbl_presensiterlambat.setText(Presensi.LatePresensi);
        lbl_presensitutup.setText(Presensi.EndPresensi);
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
 maindasboard main =(maindasboard)SwingUtilities.getWindowAncestor(this);
    public void loadTableAkun(){
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void delete(int row) {
                int idJ = Integer.valueOf(table.getValueAt(row, 0).toString());
                int response = JOptionPane.showConfirmDialog(null, "Yakin menghapus data pada row = "+ row, "apa cobak?", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                 boolean delete = userRepo.delete(idJ);
        if(delete){
             
            Notification panel = new Notification(main, Notification.Type.SUCCESS, Notification.Location.BOTTOM_RIGHT, "Data berhasil di hapus");
        panel.showNotification();
            loadTableAkun();
        }else {
            Notification panel = new Notification(main, Notification.Type.WARNING, Notification.Location.BOTTOM_RIGHT, "Data gagal di hapus");
        panel.showNotification();
        }
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
            model.addColumn("Username");
            model.addColumn("Role");
            model.addColumn("Aksi");
            int no = 1;
           
           try {
             for(User res:userRepo.get()){
                model.addRow(new Object[]{
                    res.getId(),
                    res.getNama(),
                    res.getUsername(),
                    res.getRole(),
                });
           }
             table.setModel(model);
               table.getColumnModel().getColumn(4).setCellRenderer(render);
        table.getColumnModel().getColumn(4).setCellEditor(render1);
         } catch (Exception e) {
             e.printStackTrace();
         }
    }
   public void loadTableAkun(String search){
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void delete(int row) {
                int idJ = Integer.valueOf(table.getValueAt(row, 0).toString());
                int response = JOptionPane.showConfirmDialog(null, "Yakin menghapus data pada row = "+ row, "apa cobak?", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                 boolean delete = userRepo.delete(idJ);
        if(delete){
             
            Notification panel = new Notification(main, Notification.Type.SUCCESS, Notification.Location.BOTTOM_RIGHT, "Data berhasil di hapus");
        panel.showNotification();
            loadTableAkun();
        }else {
            Notification panel = new Notification(main, Notification.Type.WARNING, Notification.Location.BOTTOM_RIGHT, "Data gagal di hapus");
        panel.showNotification();
        }
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
            model.addColumn("Username");
            model.addColumn("Role");
            model.addColumn("Aksi");
            int no = 1;
           
           try {
             for(User res:userRepo.getSearch(search)){
                model.addRow(new Object[]{
                    res.getId(),
                    res.getNama(),
                    res.getUsername(),
                    res.getRole(),
                });
           }
             table.setModel(model);
               table.getColumnModel().getColumn(4).setCellRenderer(render);
        table.getColumnModel().getColumn(4).setCellEditor(render1);
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
        date = new com.raven.datechooser.DateChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblAkun1 = new javax.swing.JLabel();
        lblPresensi1 = new javax.swing.JLabel();
        lblPilihan = new javax.swing.JLabel();
        btnDetail = new javax.swing.JLabel();
        btnEdit = new javax.swing.JLabel();
        btnTambah = new javax.swing.JLabel();
        panelShadow1 = new view.swing.PanelShadow();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new view.pallet.Table();
        scrollBarCustom1 = new view.swing.ScrollBarCustom();
        jPanel2 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btn_logout = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lbl_presensitutup = new javax.swing.JLabel();
        lbl_presensimulai = new javax.swing.JLabel();
        lbl_presensiterlambat = new javax.swing.JLabel();
        btn_pengaturan = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btn_terapkan = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        cmbNama = new view.pallet.ComboBoxSuggestion();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/button CRUD.png"))); // NOI18N

        jPanel3.setBackground(new Color(0,0,0,0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        date.setDateFormat("yyyy-MM-dd");
        date.setTextRefernce(txtDate);

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

        btnDetail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/buttondetaill.png"))); // NOI18N
        btnDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDetailMouseClicked(evt);
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

        panelShadow1.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane2.setBackground(new Color(0,0,0,0));
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
                .addGap(32, 32, 32)
                .addComponent(jScrollPane2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollBarCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow1Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(scrollBarCustom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE))
                .addGap(31, 31, 31))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtSearch.setFont(new java.awt.Font("Quicksand Bold", 0, 14)); // NOI18N
        txtSearch.setBorder(null);
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        jPanel2.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 160, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/menusearch1.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, 40));

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
        jPanel5.add(btn_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 190, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/menu_ujung.png"))); // NOI18N
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 26, -1, 130));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/button_menu2.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 0, -1, 30));

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
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, 30, 160));

        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel10MouseEntered(evt);
            }
        });
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 210, 10));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_presensitutup.setFont(new java.awt.Font("Quicksand Bold", 0, 14)); // NOI18N
        jPanel4.add(lbl_presensitutup, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 110, 30));

        lbl_presensimulai.setFont(new java.awt.Font("Quicksand Bold", 0, 14)); // NOI18N
        jPanel4.add(lbl_presensimulai, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 110, 30));

        lbl_presensiterlambat.setFont(new java.awt.Font("Quicksand Bold", 0, 14)); // NOI18N
        jPanel4.add(lbl_presensiterlambat, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 110, 30));

        btn_pengaturan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/button_pengaturan1.png"))); // NOI18N
        btn_pengaturan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_pengaturanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_pengaturanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_pengaturanMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_pengaturanMousePressed(evt);
            }
        });
        jPanel4.add(btn_pengaturan, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, 30, 36));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/atur_presensi.png"))); // NOI18N
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 180));

        jLabel5.setText("jLabel5");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, -1, -1));

        jPanel6.setBackground(new Color(0,0,0,0));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_terapkan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/btn_terapkan1.png"))); // NOI18N
        btn_terapkan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_terapkanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_terapkanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_terapkanMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_terapkanMousePressed(evt);
            }
        });
        jPanel6.add(btn_terapkan, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, 150, 40));

        txtDate.setFont(new java.awt.Font("Quicksand Bold", 0, 14)); // NOI18N
        txtDate.setBorder(null);
        jPanel6.add(txtDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 230, 40));
        jPanel6.add(cmbNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 320, 40));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hadir", "Terlambat", "Izin", "Sakit" }));
        jComboBox1.setBorder(null);
        jPanel6.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 320, 50));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/button date.png"))); // NOI18N
        jLabel11.setText("jLabel11");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, 60, 50));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/bg_presensimanual.png"))); // NOI18N
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, 435, 340));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(150, 150, 150)
                                .addComponent(lblPresensi1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblAkun1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPilihan, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 224, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(19, 19, 19)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(btnDetail)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPresensi1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAkun1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPilihan, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE))
                    .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(7, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahMouseClicked
        maindasboard main =(maindasboard)SwingUtilities.getWindowAncestor(this);
      DialogTambahPegawai tambahPegawai = new DialogTambahPegawai(main);
      tambahPegawai.showPopUp();
      loadTableAkun();
    }//GEN-LAST:event_btnTambahMouseClicked

    private void btnDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDetailMouseClicked
       maindasboard main =(maindasboard)SwingUtilities.getWindowAncestor(this);
        DialogDetailPegawai detailPegawai = new DialogDetailPegawai(main);
      detailPegawai.showPopUp();
    }//GEN-LAST:event_btnDetailMouseClicked

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

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        if(pilihan.equals("akun")){
            loadTableAkun(txtSearch.getText());
        }
        
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btn_pengaturanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_pengaturanMouseClicked
            maindasboard main =(maindasboard)SwingUtilities.getWindowAncestor(this);
        DialogAturPresensi editPegawai = new DialogAturPresensi(main);
      editPegawai.showPopUp();
      setValueTime();
    }//GEN-LAST:event_btn_pengaturanMouseClicked

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
    jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/button_menu.png")));
    }//GEN-LAST:event_jLabel4MouseClicked

    private void btn_pengaturanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_pengaturanMouseEntered
    btn_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/buttonlogout2.png")));
    }//GEN-LAST:event_btn_pengaturanMouseEntered

    private void btn_pengaturanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_pengaturanMouseExited
    btn_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/buttonlogout1.png")));
    }//GEN-LAST:event_btn_pengaturanMouseExited

    private void btn_pengaturanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_pengaturanMousePressed
    btn_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/buttonlogout3.png")));
    }//GEN-LAST:event_btn_pengaturanMousePressed

    private void btn_terapkanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_terapkanMouseEntered
    btn_terapkan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/btn_terapkan2.png")));
    }//GEN-LAST:event_btn_terapkanMouseEntered

    private void btn_terapkanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_terapkanMouseExited
    btn_terapkan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/btn_terapkan1.png")));
    }//GEN-LAST:event_btn_terapkanMouseExited

    private void btn_terapkanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_terapkanMousePressed
    btn_terapkan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/btn_terapkan3.png")));
    }//GEN-LAST:event_btn_terapkanMousePressed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        date.showPopup();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void btn_terapkanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_terapkanMouseClicked
        maindasboard main =(maindasboard)SwingUtilities.getWindowAncestor(this);
        try {
            
            String str = String.valueOf(cmbNama.getSelectedItem());
            String [] getId= str.split(",", 2);
            User user = new UserRepository().get(Integer.valueOf(getId[1]));
            String date = txtDate.getText();
            Date waktuPresensi = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            Presensi presensi = new Presensi(user, waktuPresensi, pilihan);
            boolean tambah = presensiRepo.add(presensi);
            if(tambah){
                Notification panel = new Notification(main, Notification.Type.SUCCESS, Notification.Location.BOTTOM_RIGHT, "Data berhasil di tambahkan");
        panel.showNotification();
            }else{
               Notification panel = new Notification(main, Notification.Type.WARNING, Notification.Location.BOTTOM_RIGHT, "Data gagal di tambahkan");
        panel.showNotification(); 
            }
        } catch (Exception e) {
            Notification panel = new Notification(main, Notification.Type.WARNING, Notification.Location.BOTTOM_RIGHT, "Data gagal di tambahkan");
        panel.showNotification(); 
        }
    }//GEN-LAST:event_btn_terapkanMouseClicked

    private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseEntered
     jLabel6.setVisible(false);
        btn_logout.setVisible(false);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/button_menu2.png")));
    }//GEN-LAST:event_jLabel8MouseEntered

    private void jLabel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseEntered
     jLabel6.setVisible(false);
        btn_logout.setVisible(false);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/button_menu2.png")));
    }//GEN-LAST:event_jLabel9MouseEntered

    private void jLabel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseEntered
        jLabel6.setVisible(false);
        btn_logout.setVisible(false);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/button_menu2.png")));
    }//GEN-LAST:event_jLabel10MouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnDetail;
    private javax.swing.JLabel btnEdit;
    private javax.swing.JLabel btnTambah;
    private javax.swing.JLabel btn_logout;
    private javax.swing.JLabel btn_pengaturan;
    private javax.swing.JLabel btn_terapkan;
    private view.pallet.ComboBoxSuggestion cmbNama;
    private com.raven.datechooser.DateChooser date;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAkun1;
    private javax.swing.JLabel lblPilihan;
    private javax.swing.JLabel lblPresensi1;
    private javax.swing.JLabel lbl_presensimulai;
    private javax.swing.JLabel lbl_presensiterlambat;
    private javax.swing.JLabel lbl_presensitutup;
    private view.swing.PanelShadow panelShadow1;
    private view.swing.ScrollBarCustom scrollBarCustom1;
    private view.pallet.Table table;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
