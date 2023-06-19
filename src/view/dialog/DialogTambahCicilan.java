/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view.dialog;

import entity.DetailPemesanan;
import entity.Pemesanan;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import repository.DetailPemesananRepository;
import repository.PemesananRepository;
import util.Conn;
import view.panel.PemesananForm;

import util.DateUtil;
import view.main.maindasboard;
import view.swing.Notification;
/**
 *
 * @author adzaz
 */
public class DialogTambahCicilan extends Dialog {
    private int id = PemesananForm.id;
    DateUtil date = new DateUtil();
    PemesananRepository pemesananRepo = new PemesananRepository();
    DetailPemesananRepository detailPemesananRepo = new DetailPemesananRepository();
    
    /**
     * Creates new form DialogTambahCicilan
     */
    public DialogTambahCicilan(JFrame fram) {
        super(fram);
        initComponents();
        setValue();
        loadTable();
    }
    
     public void generate() {
        String query = "SELECT *, jamaah.nama AS namaJamaah, detail_pemesanan.tanggal AS tanggalCicilan FROM pemesanan JOIN detail_pemesanan ON pemesanan.id = detail_pemesanan.pemesanan_id JOIN jamaah ON pemesanan.jamaah_id = jamaah.nik JOIN keberangkatan ON pemesanan.keberangkatan_id = keberangkatan.id JOIN master_paket ON keberangkatan.paket_id = master_paket.id WHERE pemesanan.id = "+Integer.parseInt(lblId.getText());
        String path = "D:/RahmatanTravel/src/report/NotaCicilan.jrxml";

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
     
private void loadTable(){
       DefaultTableModel model = new DefaultTableModel();
            model.addColumn("No");      
            model.addColumn("Tanggal");
            model.addColumn("Jumlah cicilan");
         

            int no = 1;
           
           for(DetailPemesanan res:detailPemesananRepo.getByPemesananId(id)){
                model.addRow(new Object[]{
                    no++,
                    res.getTanggal().toString(),
                    res.getCicilan()
                    
           });
    }
             table.setModel(model);
}
    private void setValue(){
        for(Pemesanan pm:pemesananRepo.getById(id)){
            String tanggalKeberangkatan = pm.getKeberangkatan().getTanggal().toString();
            LocalDate batasPembayaran = LocalDate.parse(tanggalKeberangkatan).minusDays(30);
            lblTglTerakhir.setText(String.valueOf(batasPembayaran));
            lblId.setText(String.valueOf(pm.getId()));
            lblNama.setText(pm.getJamaah().getNama());
            lblStatus.setText(pm.getStatus());
            int totalHargaPembelian = pm.getTotalTagihan();
            int totalBayar = pm.getJumlahBayar();
            lblTotalPembelian.setText(String.valueOf(totalHargaPembelian));
            lblTotalBayar.setText(String.valueOf(totalBayar));
            int kurang = totalHargaPembelian - totalBayar;
            lblKurangBayar.setText(String.valueOf(kurang));
            
        }
        if(lblStatus.getText().equals("lunas")){
                txtBayarCicilan.setEnabled(false);
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

        lblTglTerakhir = new javax.swing.JLabel();
        lblKurangBayar = new javax.swing.JLabel();
        lblTotalBayar = new javax.swing.JLabel();
        lblTotalPembelian = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        lblNama = new javax.swing.JLabel();
        lblKembalian = new javax.swing.JLabel();
        lblKurangBayarAfter = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        txtBayarCicilan = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btnTambah = new javax.swing.JLabel();
        btnBatal = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTglTerakhir.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblTglTerakhir.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblTglTerakhir, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 185, 220, 40));

        lblKurangBayar.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblKurangBayar.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblKurangBayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 330, 220, 40));

        lblTotalBayar.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblTotalBayar.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblTotalBayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 295, 220, 40));

        lblTotalPembelian.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblTotalPembelian.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblTotalPembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 258, 220, 40));

        lblStatus.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblStatus.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 217, 220, 40));

        lblNama.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblNama.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, 220, 40));

        lblKembalian.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblKembalian.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblKembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 550, 220, 40));

        lblKurangBayarAfter.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblKurangBayarAfter.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblKurangBayarAfter, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 507, 220, 40));

        lblId.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblId.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 114, 220, 40));

        txtBayarCicilan.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        txtBayarCicilan.setBorder(null);
        txtBayarCicilan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBayarCicilanKeyReleased(evt);
            }
        });
        getContentPane().add(txtBayarCicilan, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, 290, 40));

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
        jScrollPane1.setViewportView(table);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 196, 400, 440));

        btnTambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTambahMouseClicked(evt);
            }
        });
        getContentPane().add(btnTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 610, 170, 40));

        btnBatal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBatalMouseClicked(evt);
            }
        });
        getContentPane().add(btnBatal, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 610, 170, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/tambah cicilan.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1271, 699));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBatalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBatalMouseClicked
        closeMessage();
    }//GEN-LAST:event_btnBatalMouseClicked

    private void btnTambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahMouseClicked
                    maindasboard main =(maindasboard)SwingUtilities.getWindowAncestor(this);
        try {
            
            String dates = date.dateNow();
        Date tanggal = new SimpleDateFormat("yyyy-MM-dd").parse(dates);
        Pemesanan pemesanan = new PemesananRepository().get(id);
        int kurang = Integer.parseInt(lblKurangBayar.getText());
        int cicilan;
        int inputCicilan = Integer.parseInt(txtBayarCicilan.getText());
        int kurangBayar = Integer.parseInt(lblKurangBayarAfter.getText());
        if(inputCicilan <= kurangBayar){
            cicilan = Integer.parseInt(txtBayarCicilan.getText());
        }else{
            cicilan = kurang;
        }
        DetailPemesanan detailPemesanan = new DetailPemesanan(pemesanan, tanggal, cicilan);
        boolean tambah = detailPemesananRepo.add(detailPemesanan);
      
        if(tambah){
            PemesananForm.id = 0;
            Notification panel = new Notification(main, Notification.Type.SUCCESS, Notification.Location.BOTTOM_RIGHT, "Data berhasil ditambahkan");
        panel.showNotification();
            generate();
            loadTable();
            setValue();
              if(kurangBayar <= 0){
            boolean editStatus = pemesananRepo.updateStatus("lunas",id);

        }
        }else{
 
            Notification panel = new Notification(main, Notification.Type.WARNING, Notification.Location.BOTTOM_RIGHT, "Data gagal ditambahkan");
        panel.showNotification();
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnTambahMouseClicked

    private void txtBayarCicilanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBayarCicilanKeyReleased
        int cicilan = Integer.parseInt(txtBayarCicilan.getText());
        int kurang = Integer.valueOf(lblKurangBayar.getText());
        int sesudahCicil = kurang - cicilan;
        int kembalian = cicilan - kurang;
        if(sesudahCicil >= 0){
            lblKurangBayarAfter.setText(String.valueOf(sesudahCicil));
            lblKembalian.setText("0");
        }else{
            lblKurangBayarAfter.setText("0");
            lblKembalian.setText(String.valueOf(kembalian));
        }
        
    }//GEN-LAST:event_txtBayarCicilanKeyReleased



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnBatal;
    private javax.swing.JLabel btnTambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblKembalian;
    private javax.swing.JLabel lblKurangBayar;
    private javax.swing.JLabel lblKurangBayarAfter;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTglTerakhir;
    private javax.swing.JLabel lblTotalBayar;
    private javax.swing.JLabel lblTotalPembelian;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtBayarCicilan;
    // End of variables declaration//GEN-END:variables
}
