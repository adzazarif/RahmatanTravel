/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view.dialog;

import com.barcodelib.barcode.Linear;
import entity.Jamaah;
import entity.Keberangkatan;
import entity.Paket;
import entity.Pemesanan;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import java.util.List;
import java.util.Locale;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import repository.JamaahRepository;
import repository.KeberangkatanRepository;
import repository.PemesananRepository;
import util.Conn;
import util.DateUtil;
import view.main.maindasboard;
import view.panel.PemesananForm;
import view.swing.Notification;

/**
 *
 * @author adzaz
 */
public class DialogTambahPemesanan extends Dialog {
    private String menu = "";
    private int totalTagihan;
    NumberFormat nf = NumberFormat.getNumberInstance(new Locale("in", "ID"));
    private int idKeberangkatan;
    private List<Keberangkatan> keberangkatanList = new ArrayList<>();
    PemesananRepository pemesananRepo = new PemesananRepository();
    KeberangkatanRepository keberngkatanRepo = new KeberangkatanRepository();
    JamaahRepository jamaahRepo = new JamaahRepository();
    /**
     * Creates new form DialogTambahPemesanan
     */
    public DialogTambahPemesanan(JFrame fram) {
        super(fram);
        initComponents();
        fillComboBoxJamaah();
        setId();
    }
     public void generate() {
        int kd_transaksi = pemesananRepo.getIdLast();
        String query = "SELECT pemesanan.id AS id, pemesanan.tanggal AS tanggal, jamaah.nama AS namaJamaah, master_paket.nama AS nama, master_paket.harga AS harga, pemesanan.jenis_pembayaran AS jenis_pembayaran, master_paket.diskon AS diskon, pemesanan.jumlah_bayar AS jumlah_bayar, master_paket.nama AS namaPaket FROM pemesanan JOIN keberangkatan ON pemesanan.keberangkatan_id = keberangkatan.id JOIN master_paket ON keberangkatan.paket_id = master_paket.id JOIN jamaah ON pemesanan.jamaah_id = jamaah.nik WHERE pemesanan.id = "+kd_transaksi;
        String path = "D:/RahmatanTravel/src/report/Nota.jrxml";

        try {
              Connection koneksi = (Connection) Conn.configDB();
            Statement pstCek = koneksi.createStatement();
            ResultSet res = pstCek.executeQuery(query);
            JasperDesign design = JRXmlLoader.load(path);
            JasperReport jr = JasperCompileManager.compileReport(design);
            JRResultSetDataSource rsDataSource = new JRResultSetDataSource(res);
            JasperPrint jp = JasperFillManager.fillReport(jr, new HashMap<>(), rsDataSource);

            JasperViewer.viewReport(jp);
        } catch(Exception e) { e.printStackTrace(); }
    }

    private void setId(){
        DateUtil dateUtil = new DateUtil();
        lblDate.setText(dateUtil.dateNow());
        int id = pemesananRepo.getIdLast() +1;
        
        lblId.setText(String.valueOf(id));
    }
    private void fillComboBoxJamaah(){
        try {
              for(Jamaah jm:jamaahRepo.get()){
           cmbJamaah.addItem(jm.getNama()+","+jm.getNik());
        }
        } catch (Exception e) {
        }
    }
    private void fillComboBoxPembayaran(){
            if(!menu.equals("")){
            if(menu.equals("umrah")){
                cmbPembayaran.addItem("cash");
                cmbPembayaran.addItem("talangan");
            }else{
                cmbPembayaran.addItem("cash");
            }
        }
    }
    private void fillComboBoxKeberangkatan(){
        try {
                   if(!menu.equals("")){
            keberangkatanList = keberngkatanRepo.getByMenu(menu);
        }
        int a = keberangkatanList.size();
        for (int i = 0; i < a; i++) {
            Keberangkatan keberankatanEntity = keberangkatanList.get(i);
            cmbKeberangkatan.addItem(keberankatanEntity.getId()+", "+keberankatanEntity.getPaket().getNama());
        }
        } catch (Exception e) {
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

        cmbJamaah = new view.pallet.ComboBoxSuggestion();
        cmbPembayaran = new javax.swing.JComboBox<>();
        cmbKeberangkatan = new javax.swing.JComboBox<>();
        cmbMenu = new javax.swing.JComboBox<>();
        lblTotalTagihan = new javax.swing.JLabel();
        lblDiskon = new javax.swing.JLabel();
        lblTotalHarga = new javax.swing.JLabel();
        lblMinimDp = new javax.swing.JLabel();
        lblHarga = new javax.swing.JLabel();
        lblTotalOrang = new javax.swing.JLabel();
        lblBerangkat = new javax.swing.JLabel();
        lblTotalPesan = new javax.swing.JLabel();
        lblNoHp = new javax.swing.JLabel();
        lblAlamat = new javax.swing.JLabel();
        lblNama = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        lblNik = new javax.swing.JLabel();
        lblPaket = new javax.swing.JLabel();
        txtBayar = new javax.swing.JTextField();
        btnTambah = new javax.swing.JLabel();
        btnBatal = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmbJamaah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbJamaahActionPerformed(evt);
            }
        });
        getContentPane().add(cmbJamaah, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 220, 500, -1));

        cmbPembayaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPembayaranActionPerformed(evt);
            }
        });
        getContentPane().add(cmbPembayaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 100, 230, 45));

        cmbKeberangkatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbKeberangkatanActionPerformed(evt);
            }
        });
        getContentPane().add(cmbKeberangkatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 500, 45));

        cmbMenu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--pilih--", "umrah", "haji", "wisata halal" }));
        cmbMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMenuActionPerformed(evt);
            }
        });
        getContentPane().add(cmbMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 230, 45));

        lblTotalTagihan.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblTotalTagihan.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblTotalTagihan, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 640, 320, 50));

        lblDiskon.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblDiskon.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblDiskon, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 585, 320, 50));

        lblTotalHarga.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblTotalHarga.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblTotalHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 535, 320, 50));

        lblMinimDp.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblMinimDp.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblMinimDp, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 475, 320, 50));

        lblHarga.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblHarga.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 435, 320, 50));

        lblTotalOrang.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblTotalOrang.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblTotalOrang, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 400, 320, 50));

        lblBerangkat.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblBerangkat.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblBerangkat, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 362, 320, 50));

        lblTotalPesan.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblTotalPesan.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblTotalPesan, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 477, 320, 40));

        lblNoHp.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblNoHp.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblNoHp, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 440, 320, 40));

        lblAlamat.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblAlamat.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblAlamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 400, 320, 50));

        lblNama.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblNama.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 363, 320, 50));

        lblId.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblId.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 140, 50));

        lblNik.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblNik.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblNik, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 330, 320, 50));

        lblPaket.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblPaket.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblPaket, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, 320, 50));

        txtBayar.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        txtBayar.setBorder(null);
        getContentPane().add(txtBayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 550, 270, 40));

        btnTambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTambahMouseClicked(evt);
            }
        });
        getContentPane().add(btnTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 630, 170, 40));

        btnBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/button_batal1.png"))); // NOI18N
        btnBatal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBatalMouseClicked(evt);
            }
        });
        getContentPane().add(btnBatal, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 630, 170, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/tambah pemesanan.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1290, 710));

        lblDate.setText("jLabel2");
        getContentPane().add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 40, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMenuActionPerformed
        menu = String.valueOf(cmbMenu.getSelectedItem());
        cmbPembayaran.removeAllItems();
        cmbKeberangkatan.removeAllItems();
        keberangkatanList.clear();
        fillComboBoxPembayaran();
        fillComboBoxKeberangkatan();
    }//GEN-LAST:event_cmbMenuActionPerformed

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
        for(Keberangkatan kb:keberngkatanRepo.getById(id)){
          lblPaket.setText(kb.getPaket().getNama());
          lblBerangkat.setText(kb.getTanggal().toString());
          lblTotalOrang.setText(String.valueOf(jumlahJamaah));
          lblHarga.setText(String.valueOf(nf.format(kb.getPaket().getHarga())));
          lblMinimDp.setText(String.valueOf(kb.getPaket().getMinimDp()));
          lblTotalHarga.setText(String.valueOf(nf.format(kb.getPaket().getHarga())));
          lblDiskon.setText(String.valueOf(nf.format(kb.getPaket().getDiskon())));
          totalTagihan = kb.getPaket().getHarga() - kb.getPaket().getDiskon();
          lblTotalTagihan.setText(String.valueOf(nf.format(totalTagihan)));
        }
        } catch (Exception e) {
            
        }
           
    }//GEN-LAST:event_cmbKeberangkatanActionPerformed

    private void cmbPembayaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPembayaranActionPerformed
        String pilihanPembayaran = String.valueOf(cmbPembayaran.getSelectedItem());
        if(pilihanPembayaran.equals("talangan")){
            txtBayar.setEnabled(false);
        }else{
            txtBayar.setEnabled(true);
        }
    }//GEN-LAST:event_cmbPembayaranActionPerformed

    private void btnBatalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBatalMouseClicked
       PemesananForm.id = 0;
        closeMessage();
    }//GEN-LAST:event_btnBatalMouseClicked

    private void btnTambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahMouseClicked
        
        try {
            
        String jenisPembayaran = String.valueOf(cmbPembayaran.getSelectedItem());
        int bayar =0;
        int minimDp = Integer.parseInt(lblMinimDp.getText());
        
            int totalTagihanw = totalTagihan;
        String status = "";
        if(jenisPembayaran.equals("cash")){
            bayar = Integer.valueOf(txtBayar.getText());
           if(bayar <= minimDp){
               JOptionPane.showMessageDialog(rootPane, "Uang tidak memenuhi minimal DP");
            return;
        }
            if(bayar >= totalTagihan){
                status = "lunas";
            }else{
                status = "belum lunas";
            }    
        }else if(jenisPembayaran.equals("talangan")){
            status = "belum lunas";
            bayar = 0;
        }
         
            System.out.println(status);
        String date = lblDate.getText();
        Date tanggal = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        String idJamaah = lblNik.getText();
        Keberangkatan keberangkatan = new KeberangkatanRepository().get(idKeberangkatan);
        Jamaah jamaah = new JamaahRepository().get(idJamaah);
        Pemesanan pemesanan = new Pemesanan(keberangkatan, jamaah, jenisPembayaran, status, tanggal, totalTagihanw, bayar);
        
        boolean tambah = pemesananRepo.add(pemesanan);
        if(tambah){
            
            int idLast = pemesananRepo.getIdLast();
            String newpath = "src/UploadBarcode";
            File directory = new File(newpath);
            if(!directory.exists()){
                directory.mkdir();
            }
            Linear barcode = new Linear();
            barcode.setType(Linear.CODE128B);
            barcode.setData(String.valueOf(idLast));
            barcode.setI(11.0f);
            String name = "pms"+idLast;
            barcode.renderBarcode("D:/RahmatanTravel/src/UploadBarcode/"+name+".png");
            maindasboard main =(maindasboard)SwingUtilities.getWindowAncestor(this);
              
              Notification panel = new Notification(main, Notification.Type.SUCCESS, Notification.Location.BOTTOM_RIGHT, "Data berhasil di tambahkan");
        panel.showNotification();
            generate();
            closeMessage();
        }else{
            maindasboard main =(maindasboard)SwingUtilities.getWindowAncestor(this);
              Notification panel = new Notification(main, Notification.Type.WARNING, Notification.Location.BOTTOM_RIGHT, "Data gagal ditambahkan");
        panel.showNotification();
        }
        } catch (Exception e) {
            e.printStackTrace();
            maindasboard main =(maindasboard)SwingUtilities.getWindowAncestor(this);
                         Notification panel = new Notification(main, Notification.Type.WARNING, Notification.Location.BOTTOM_RIGHT, "Data gagal ditambahkan");
        panel.showNotification();
        }
        
    }//GEN-LAST:event_btnTambahMouseClicked

    private void cmbJamaahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbJamaahActionPerformed
       String strJamaah = String.valueOf(cmbJamaah.getSelectedItem());
        try {
            String [] getJamaah = strJamaah.split(",",2);
            String NIK = getJamaah[1];
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

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnBatal;
    private javax.swing.JLabel btnTambah;
    private view.pallet.ComboBoxSuggestion cmbJamaah;
    private javax.swing.JComboBox<String> cmbKeberangkatan;
    private javax.swing.JComboBox<String> cmbMenu;
    private javax.swing.JComboBox<String> cmbPembayaran;
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
    private javax.swing.JTextField txtBayar;
    // End of variables declaration//GEN-END:variables
}
