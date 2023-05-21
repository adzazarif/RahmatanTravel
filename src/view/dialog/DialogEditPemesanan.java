/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view.dialog;

import entity.Jamaah;
import entity.Keberangkatan;
import entity.Pemesanan;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import repository.JamaahRepository;
import repository.KeberangkatanRepository;
import repository.PemesananRepository;
import view.panel.PemesananForm;

/**
 *
 * @author adzaz
 */
public class DialogEditPemesanan extends Dialog {
    private int id = PemesananForm.id;
    private int idKeberangkatan;
    private String menu;
    private List<Keberangkatan> keberangkatanList = new ArrayList<>();
    PemesananRepository pemesananRepo = new PemesananRepository();
    KeberangkatanRepository keberangkatanRepo = new KeberangkatanRepository();
    JamaahRepository jamaahRepo = new JamaahRepository();
    
    /**
     * Creates new form DialogEditPemesanan
     */
    public DialogEditPemesanan(JFrame fram) {
        super(fram);
        initComponents();
        setValue();
    }

    private void setValue (){
        for(Pemesanan pm:pemesananRepo.getById(id)){
            lblId.setText(String.valueOf(id));
            cmbMenu.setSelectedItem(pm.getKeberangkatan().getPaket().getMenu());
            cmbPembayaran.setSelectedItem(pm.getJenisPembayaran());
            cmbJamaah.setSelectedItem(pm.getJamaah().getNama()+ " ,"+pm.getJamaah().getNik());
            cmbKeberangkatan.setSelectedItem(pm.getId()+", "+pm.getKeberangkatan().getPaket().getNama());
            cmbStatus.setSelectedItem(pm.getStatus());
        }
    }
    
    private void fillComboBoxKeberangkatan(){
            if(!menu.equals("")){
            keberangkatanList = keberangkatanRepo.getByMenu(menu);
        }
        int a = keberangkatanList.size();
        for (int i = 0; i < a; i++) {
            Keberangkatan keberankatanEntity = keberangkatanList.get(i);
            cmbKeberangkatan.addItem(keberankatanEntity.getId()+", "+keberankatanEntity.getPaket().getNama());
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

        lblNoHp = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblMinimDp = new javax.swing.JLabel();
        lblNik = new javax.swing.JLabel();
        lblAlamat = new javax.swing.JLabel();
        lblDiskon = new javax.swing.JLabel();
        lblPaket = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        lblBerangkat = new javax.swing.JLabel();
        cmbPembayaran = new javax.swing.JComboBox<>();
        btnTambah = new javax.swing.JLabel();
        lblTotalHarga = new javax.swing.JLabel();
        lblTotalTagihan = new javax.swing.JLabel();
        cmbMenu = new javax.swing.JComboBox<>();
        btnBatal = new javax.swing.JLabel();
        cmbJamaah = new view.pallet.ComboBoxSuggestion();
        lblTotalOrang = new javax.swing.JLabel();
        lblTotalPesan = new javax.swing.JLabel();
        cmbKeberangkatan = new javax.swing.JComboBox<>();
        lblNama = new javax.swing.JLabel();
        lblHarga = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNoHp.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblNoHp.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblNoHp, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 440, 320, 40));

        lblDate.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblDate.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, 320, 50));

        lblMinimDp.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblMinimDp.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblMinimDp, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 475, 320, 50));

        lblNik.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblNik.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblNik, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 330, 320, 50));

        lblAlamat.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblAlamat.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblAlamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 400, 320, 50));

        lblDiskon.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblDiskon.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblDiskon, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 585, 320, 50));

        lblPaket.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblPaket.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblPaket, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, 320, 50));

        lblId.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblId.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 160, 40));

        lblBerangkat.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblBerangkat.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblBerangkat, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 362, 320, 50));

        cmbPembayaran.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--pilih--", "Cash", "Talangan" }));
        cmbPembayaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPembayaranActionPerformed(evt);
            }
        });
        getContentPane().add(cmbPembayaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 100, 230, 45));

        btnTambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTambahMouseClicked(evt);
            }
        });
        getContentPane().add(btnTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 630, 170, 40));

        lblTotalHarga.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblTotalHarga.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblTotalHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 535, 320, 50));

        lblTotalTagihan.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblTotalTagihan.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblTotalTagihan, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 640, 320, 50));

        cmbMenu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--pilih--", "umrah", "haji", "wisata halal" }));
        cmbMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMenuActionPerformed(evt);
            }
        });
        getContentPane().add(cmbMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 230, 45));

        btnBatal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBatalMouseClicked(evt);
            }
        });
        getContentPane().add(btnBatal, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 630, 170, 40));

        cmbJamaah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbJamaahActionPerformed(evt);
            }
        });
        getContentPane().add(cmbJamaah, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 220, 500, -1));

        lblTotalOrang.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblTotalOrang.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblTotalOrang, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 400, 320, 50));

        lblTotalPesan.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblTotalPesan.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblTotalPesan, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 477, 320, 40));

        cmbKeberangkatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbKeberangkatanActionPerformed(evt);
            }
        });
        getContentPane().add(cmbKeberangkatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 500, 45));

        lblNama.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblNama.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 363, 320, 50));

        lblHarga.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblHarga.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 435, 320, 50));

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih--", "lunas", "belum lunas" }));
        getContentPane().add(cmbStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 560, 280, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/edit pemesanan.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1299, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbPembayaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPembayaranActionPerformed

    }//GEN-LAST:event_cmbPembayaranActionPerformed

    private void btnTambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahMouseClicked
//        try {
//            String jenisPembayaran = String.valueOf(cmbPembayaran.getSelectedItem());
//            
//            int totalTagihan = Integer.parseInt(lblTotalTagihan.getText());
//            String status = "";
//            if(jenisPembayaran.equals("Cash")){
//
//                if(bayar >= totalTagihan){
//                    status = "lunas";
//                }else{
//                    status = "belum lunas";
//                }
//            }else if(jenisPembayaran.equals("Talangan")){
//                status = "belum lunas";
//            }
//
//            String date = lblDate.getText();
//            Date tanggal = new SimpleDateFormat("yyyy-MM-dd").parse(date);
//            int idJamaah = Integer.parseInt(lblNik.getText());
//            Keberangkatan keberangkatan = new KeberangkatanRepository().get(idKeberangkatan);
//            Jamaah jamaah = new JamaahRepository().get(idJamaah);
//            Pemesanan pemesanan = new Pemesanan(keberangkatan, jamaah, jenisPembayaran, status, tanggal, totalTagihan, bayar);
//
//            boolean tambah = pemesananRepo.add(pemesanan);
//            if(tambah){
//                System.out.println("Berhasil");
//                closeMessage();
//            }else{
//                System.out.println("Gagal");
//            }
//        } catch (Exception e) {
//        }

    }//GEN-LAST:event_btnTambahMouseClicked

    private void cmbMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMenuActionPerformed
        menu = String.valueOf(cmbMenu.getSelectedItem());

        cmbKeberangkatan.removeAllItems();
        keberangkatanList.clear();

        fillComboBoxKeberangkatan();
    }//GEN-LAST:event_cmbMenuActionPerformed

    private void btnBatalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBatalMouseClicked
        closeMessage();
    }//GEN-LAST:event_btnBatalMouseClicked

    private void cmbJamaahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbJamaahActionPerformed
        String strJamaah = String.valueOf(cmbJamaah.getSelectedItem());
        try {
            String [] getJamaah = strJamaah.split(",",2);
            int NIK = Integer.valueOf(getJamaah[1]);
            System.out.println(NIK);
            int jumlahPesanan = 0;
            for(Pemesanan pm:pemesananRepo.getByIdJamaah(NIK)){
                jumlahPesanan += 1;
            }
            for(Jamaah jm:jamaahRepo.getById(NIK)){
                lblNik.setText(String.valueOf(jm.getNik()));
                lblNama.setText(jm.getNama());
                lblAlamat.setText(jm.getAlamat());
                lblNoHp.setText(jm.getNoTelp());
                lblTotalPesan.setText(String.valueOf(jumlahPesanan));
            }

        } catch (Exception e) {
        }
    }//GEN-LAST:event_cmbJamaahActionPerformed

    private void cmbKeberangkatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbKeberangkatanActionPerformed
        String str = String.valueOf(cmbKeberangkatan.getSelectedItem());
        try {
            String [] getId= str.split(",", 2);
            int id = Integer.valueOf(getId[0]);
            idKeberangkatan = id;
            int jumlahJamaah = 0;
            for(Pemesanan pm:pemesananRepo.getByIdKeberangkatan(id)){
                jumlahJamaah += 1;
            }
            for(Keberangkatan kb:keberangkatanRepo.getById(id)){
                lblPaket.setText(kb.getPaket().getNama());
                lblBerangkat.setText(kb.getTanggal().toString());
                lblTotalOrang.setText(String.valueOf(jumlahJamaah));
                lblHarga.setText(String.valueOf(kb.getPaket().getHarga()));
                lblMinimDp.setText(String.valueOf(kb.getPaket().getMinimDp()));
                lblTotalHarga.setText(String.valueOf(kb.getPaket().getHarga()));
                lblDiskon.setText(String.valueOf(kb.getPaket().getDiskon()));
                int totalTagihan = kb.getPaket().getHarga() - kb.getPaket().getDiskon();
                lblTotalTagihan.setText(String.valueOf(totalTagihan));
            }
        } catch (Exception e) {

        }

    }//GEN-LAST:event_cmbKeberangkatanActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnBatal;
    private javax.swing.JLabel btnTambah;
    private view.pallet.ComboBoxSuggestion cmbJamaah;
    private javax.swing.JComboBox<String> cmbKeberangkatan;
    private javax.swing.JComboBox<String> cmbMenu;
    private javax.swing.JComboBox<String> cmbPembayaran;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblAlamat;
    private javax.swing.JLabel lblBerangkat;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDiskon;
    private javax.swing.JLabel lblHarga;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblMinimDp;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lblNik;
    private javax.swing.JLabel lblNoHp;
    private javax.swing.JLabel lblPaket;
    private javax.swing.JLabel lblTotalHarga;
    private javax.swing.JLabel lblTotalOrang;
    private javax.swing.JLabel lblTotalPesan;
    private javax.swing.JLabel lblTotalTagihan;
    // End of variables declaration//GEN-END:variables
}
