/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view.dialog;

import entity.DetailPemesanan;
import entity.Keberangkatan;
import entity.Paket;
import entity.Pemesanan;
import entity.Pengeluaran;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import repository.KeberangkatanRepository;
import repository.PaketRepository;
import repository.PemesananRepository;
import repository.PengeluaranRepository;
import view.panel.PaketForm;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.Locale;
import util.Conn;

/**
 *
 * @author adzaz
 */
public class DialogDetailPaket extends Dialog {
    PaketRepository paketRepo = new PaketRepository();
    KeberangkatanRepository keberangkatanRepo = new KeberangkatanRepository();
    PemesananRepository pemesananRepo = new PemesananRepository();
    PengeluaranRepository pengeluaranRepo = new PengeluaranRepository();
    private int id = PaketForm.id;
    NumberFormat nf = NumberFormat.getNumberInstance(new Locale("in", "ID"));
    /**
     * Creates new form DialogDetailPaket
     */
    public DialogDetailPaket(JFrame frame) {
        super(frame);
        initComponents();
        setValue();
        loadTable();
    }
    
    private void loadTable(){
       DefaultTableModel model = new DefaultTableModel();
   
            model.addColumn("Tanggal");
            model.addColumn("Status");
            model.addColumn("Jml Orang");
            model.addColumn("Pemasukan");
                        model.addColumn("Pengeluaran");   
            model.addColumn("Laba kotor");
            int no = 1;

            try {
            String sql = "SELECT keberangkatan.tanggal, keberangkatan.status, COUNT(pemesanan.jamaah_id) AS jml_jamaah, SUM(pemesanan.jumlah_bayar) AS pemasukan, SUM(pengeluaran.total_pengeluaran) AS pengeluaran FROM keberangkatan JOIN master_paket ON keberangkatan.paket_id = master_paket.id LEFT JOIN pemesanan ON keberangkatan.id = pemesanan.keberangkatan_id LEFT JOIN pengeluaran ON keberangkatan.id = pengeluaran.keberangkatan_id WHERE master_paket.id = "+id+" GROUP BY keberangkatan.id ";
            Connection conn = (Connection) Conn.configDB();
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(sql);
            while(res.next()){
                int pemasukan = res.getInt("pemasukan");
                int pengeluaran = res.getInt("pengeluaran");
                int labaKotor = pemasukan - pengeluaran;
                model.addRow(new Object[]{
                    res.getString("keberangkatan.tanggal"),
                    res.getString("keberangkatan.status"),
                    res.getString("jml_jamaah"),
                    nf.format(pemasukan), 
                    nf.format(pengeluaran), 
                    nf.format(labaKotor), 
                });
            }
            table.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
}
    
    public void setValue(){
        for(Paket p:paketRepo.getByid(id)){
            lblId.setText(String.valueOf(p.getId()));
            lblNamaPaket.setText(p.getNama());
            lblKategori.setText(p.getMenu());
            lblStartPerjalanan.setText(p.getStart());
            lblRentangWaktu.setText(String.valueOf(p.getLamaPaket()));
            lblMinimDp.setText(String.valueOf(p.getMinimDp()));
            lblHarga.setText(String.valueOf(p.getHarga()));
            lblDiskon.setText(String.valueOf(p.getDiskon()));
            lblDeskripsi.setText(p.getDeskripsi());
            
        }
        int jumlahKeberangkatan = 0;
        int jumlahOrang = 0;
        long pemasukan = 0;
        long pengeluaran = 0;
        for(Keberangkatan k:keberangkatanRepo.getByPaketId(id)){
            int idKeberangkatan = k.getId();
            jumlahKeberangkatan += 1;
            for(Pemesanan pm:pemesananRepo.getByIdKeberangkatan(idKeberangkatan)){
                jumlahOrang += 1;
                pemasukan += pm.getJumlahBayar();
            }
            for(Pengeluaran pg:pengeluaranRepo.getByIdKeberangkatan(idKeberangkatan)){
                pengeluaran += pg.getTotalPengeluaran();
            }
        }
        long labaKotor = pemasukan - pengeluaran;
        lblPengeluaran.setText(String.valueOf(pengeluaran));
        lblPemasukan.setText(String.valueOf(pemasukan));
        lblJmlKeberangkatan.setText(String.valueOf(jumlahKeberangkatan));
        lblJmlOrang.setText(String.valueOf(jumlahOrang));
        lblLabaKotor.setText(String.valueOf(labaKotor));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblKategori = new javax.swing.JLabel();
        lblStartPerjalanan = new javax.swing.JLabel();
        lblRentangWaktu = new javax.swing.JLabel();
        lblMinimDp = new javax.swing.JLabel();
        lblHarga = new javax.swing.JLabel();
        lblDiskon = new javax.swing.JLabel();
        lblDeskripsi = new javax.swing.JLabel();
        lblJmlKeberangkatan = new javax.swing.JLabel();
        lblJmlOrang = new javax.swing.JLabel();
        lblPemasukan = new javax.swing.JLabel();
        lblNamaPaket = new javax.swing.JLabel();
        lblLabaKotor = new javax.swing.JLabel();
        lblPengeluaran = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new view.pallet.Table();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblKategori.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblKategori.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblKategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 162, 220, 40));

        lblStartPerjalanan.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblStartPerjalanan.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblStartPerjalanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, 220, 40));

        lblRentangWaktu.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblRentangWaktu.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblRentangWaktu, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 233, 220, 40));

        lblMinimDp.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblMinimDp.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblMinimDp, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, 220, 40));

        lblHarga.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblHarga.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 306, 220, 40));

        lblDiskon.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblDiskon.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblDiskon, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 342, 220, 40));

        lblDeskripsi.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblDeskripsi.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblDeskripsi, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 380, 220, 40));

        lblJmlKeberangkatan.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblJmlKeberangkatan.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblJmlKeberangkatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 474, 220, 40));

        lblJmlOrang.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblJmlOrang.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblJmlOrang, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 514, 220, 40));

        lblPemasukan.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblPemasukan.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblPemasukan, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 550, 220, 40));

        lblNamaPaket.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblNamaPaket.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblNamaPaket, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 220, 40));

        lblLabaKotor.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblLabaKotor.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblLabaKotor, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 623, 220, 40));

        lblPengeluaran.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblPengeluaran.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblPengeluaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 588, 220, 40));

        lblId.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblId.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 92, 220, 40));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 180, 390, 450));

        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 10, 60, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/detail paket.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        closeMessage();
    }//GEN-LAST:event_jLabel2MouseClicked

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDeskripsi;
    private javax.swing.JLabel lblDiskon;
    private javax.swing.JLabel lblHarga;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblJmlKeberangkatan;
    private javax.swing.JLabel lblJmlOrang;
    private javax.swing.JLabel lblKategori;
    private javax.swing.JLabel lblLabaKotor;
    private javax.swing.JLabel lblMinimDp;
    private javax.swing.JLabel lblNamaPaket;
    private javax.swing.JLabel lblPemasukan;
    private javax.swing.JLabel lblPengeluaran;
    private javax.swing.JLabel lblRentangWaktu;
    private javax.swing.JLabel lblStartPerjalanan;
    private view.pallet.Table table;
    // End of variables declaration//GEN-END:variables
}
