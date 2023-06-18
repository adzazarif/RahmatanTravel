/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view.dialog;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JFrame;
import util.Conn;

/**
 *
 * @author adzaz
 */
public class DialogRekapLaporan extends Dialog {
    NumberFormat nf = NumberFormat.getNumberInstance(new Locale("in", "ID"));
    /**
     * Creates new form DialogRekapLaporan
     */
    public DialogRekapLaporan(JFrame frame) {
        super(frame);
        initComponents();
        setValue();
        setValuePenghasilan();
        setValueRataPengeluaranOperasional();
        setValueRataPengeluaranProduksi();
    }

    public void setValue(){
           lblRataJamaah.setText(String.valueOf(getRataJamaah()));
        lblKeputusanBarang.setText(String.valueOf(getRataJamaah()));
        lblPaketDiminati.setText(getPaket());
        lblBulan.setText(getBulan());
        lblKategori.setText(getKategori());
        lblKeputusanBulan.setText(getBulan());
        lblKeputusanKategori.setText(getKategori());
        lblKeputusanPaket.setText(getPaket());
        setValuePemasukan();
    }
    public String getPaket(){
        String paket = "";
        try {
            String sql = "SELECT master_paket.nama AS nama_paket, COUNT(jamaah_id) AS jmlJamaah FROM pemesanan JOIN keberangkatan ON pemesanan.keberangkatan_id = keberangkatan.id JOIN master_paket ON keberangkatan.paket_id = master_paket.id GROUP BY master_paket.id ORDER BY jmlJamaah DESC LIMIT 1" ;
        Connection koneksi = (Connection)Conn.configDB();
        Statement stm = koneksi.createStatement();
        ResultSet res = stm.executeQuery(sql);

        while(res.next()){
            paket = res.getString("nama_paket");
        }
  
        return paket;
        } catch (Exception e) {
        }
        return paket;
    }
    public String getKategori(){
        String kategori = "";
            try {
            String sql = "SELECT master_paket.menu AS menu, COUNT(jamaah_id) AS jmlJamaah FROM pemesanan JOIN keberangkatan ON pemesanan.keberangkatan_id = keberangkatan.id JOIN master_paket ON keberangkatan.paket_id = master_paket.id GROUP BY master_paket.id ORDER BY jmlJamaah DESC LIMIT 1" ;
            Connection koneksi = (Connection)Conn.configDB();
            Statement stm = koneksi.createStatement();
            ResultSet res = stm.executeQuery(sql);

            while(res.next()){
                kategori = res.getString("menu");
                return kategori;
            }
            } catch (Exception e) {
            }  
            return kategori;
    }
     public void setValuePenghasilan(){
        try {
            String sql = "SELECT DATE_FORMAT(pemesanan.tanggal, '%M') AS month, (SUM(pemesanan.jumlah_bayar) - pengeluaran.total_pengeluaran - (SELECT SUM(pengeluaran_operasional.jumlah) AS pengeluaran_op FROM pengeluaran_operasional )) AS laba_bersih FROM `keberangkatan` JOIN pemesanan ON keberangkatan.id = pemesanan.keberangkatan_id JOIN pengeluaran ON keberangkatan.id = pengeluaran.keberangkatan_id JOIN master_paket ON keberangkatan.paket_id = master_paket.id GROUP BY YEAR(pemesanan.tanggal), MONTH(pemesanan.tanggal)" ;
        Connection koneksi = (Connection)Conn.configDB();
        Statement stm = koneksi.createStatement();
        ResultSet res = stm.executeQuery(sql);
        long labaBersih = 0;
        int bulan = 0;
        while(res.next()){
            labaBersih += res.getLong("laba_bersih");
            bulan += 1;
        }
        long rataRataPenghasilan = labaBersih / bulan;
            lblPenghasilan.setText(nf.format(rataRataPenghasilan));
        } catch (Exception e) {
        }
    }
     
    public void setValuePemasukan(){
        try {
            String sql = "SELECT DATE_FORMAT(pemesanan.tanggal, '%M') AS month, SUM(pemesanan.jumlah_bayar) AS pemasukan FROM `pemesanan` GROUP BY YEAR(pemesanan.tanggal), MONTH(pemesanan.tanggal)" ;
        Connection koneksi = (Connection)Conn.configDB();
        Statement stm = koneksi.createStatement();
        ResultSet res = stm.executeQuery(sql);
        long pemasukan = 0;
        int bulan = 0;
        while(res.next()){
            pemasukan += res.getLong("pemasukan");
            bulan += 1;
        }
        long rataRataPenghasilan = pemasukan / bulan;
            lblPemasukan.setText(nf.format(rataRataPenghasilan));
        } catch (Exception e) {
        }
    }

    
    public int getRataJamaah(){
        int RataJamaah = 0;
           try {
            String sql = "SELECT DATE_FORMAT(pemesanan.tanggal, '%M') AS month, COUNT(jamaah_id) AS jmlJamaah FROM `pemesanan` GROUP BY YEAR(pemesanan.tanggal), MONTH(pemesanan.tanggal)" ;
        Connection koneksi = (Connection)Conn.configDB();
        Statement stm = koneksi.createStatement();
        ResultSet res = stm.executeQuery(sql);
        int jamaah = 0;
        int bulan = 0;
        while(res.next()){
            jamaah += res.getLong("jmlJamaah");
            bulan += 1;
        }
        RataJamaah = jamaah / bulan;
            return RataJamaah;
        } catch (Exception e) {
        }
           return RataJamaah;
    }
      
     public String getBulan(){
         String bulan = "";
           try {
            String sql = "SELECT DATE_FORMAT(pemesanan.tanggal, '%M') AS month, COUNT(jamaah_id) AS jmlJamaah FROM `pemesanan` GROUP BY YEAR(pemesanan.tanggal), MONTH(pemesanan.tanggal) ORDER BY jmlJamaah DESC LIMIT 1" ;
        Connection koneksi = (Connection)Conn.configDB();
        Statement stm = koneksi.createStatement();
        ResultSet res = stm.executeQuery(sql);
        long jamaah = 0;
        while(res.next()){
            bulan = res.getString("month");
            return bulan;
        }
  
        } catch (Exception e) {
        }
           return bulan;
    }
     
     public void setValueRataPengeluaranOperasional(){
        try {
            String sql = "SELECT DATE_FORMAT(pengeluaran_operasional.tanggal, '%M') AS month, SUM(pengeluaran_operasional.jumlah) AS jml_pengeluaran FROM pengeluaran_operasional GROUP BY YEAR(pengeluaran_operasional.tanggal), MONTH(pengeluaran_operasional.tanggal) ORDER BY jml_pengeluaran DESC  LIMIT 1" ;
        Connection koneksi = (Connection)Conn.configDB();
        Statement stm = koneksi.createStatement();
        ResultSet res = stm.executeQuery(sql);
        long pengeluaran = 0;
        int bulan = 0;
        while(res.next()){
            pengeluaran += res.getLong("jml_pengeluaran");
            bulan += 1;
        }
        long rataRataPengeluaran = pengeluaran / bulan;
            lblIPengeluaranOperasional.setText(String.valueOf(nf.format(rataRataPengeluaran)));
        } catch (Exception e) {
        }
    }
     
      public void setValueRataPengeluaranProduksi(){
        try {
            String sql = "SELECT DATE_FORMAT(pengeluaran.tanggal, '%M') AS month, SUM(pengeluaran.total_pengeluaran) AS pengeluaran FROM pengeluaran GROUP BY YEAR(pengeluaran.tanggal), MONTH(pengeluaran.tanggal)" ;
        Connection koneksi = (Connection)Conn.configDB();
        Statement stm = koneksi.createStatement();
        ResultSet res = stm.executeQuery(sql);
        long pengeluaran = 0;
        int bulan = 0;
        while(res.next()){
            pengeluaran += res.getLong("pengeluaran");
            bulan += 1;
        }
        long rataRataPengeluaran = pengeluaran / bulan;
            lblProduksi.setText(String.valueOf(nf.format(rataRataPengeluaran)));
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

        lblRataJamaah = new javax.swing.JLabel();
        lblPaketDiminati = new javax.swing.JLabel();
        lblBulan = new javax.swing.JLabel();
        lblIPengeluaranOperasional = new javax.swing.JLabel();
        lblKategori = new javax.swing.JLabel();
        lblProduksi = new javax.swing.JLabel();
        lblKeputusanPaket = new javax.swing.JLabel();
        lblKeputusanKategori = new javax.swing.JLabel();
        lblKeputusanBarang = new javax.swing.JLabel();
        lblKeputusanBulan = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblPemasukan = new javax.swing.JLabel();
        lblPenghasilan = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblRataJamaah.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblRataJamaah.setForeground(new java.awt.Color(0, 0, 0));
        lblRataJamaah.setText("asd");
        getContentPane().add(lblRataJamaah, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 230, 250, 40));

        lblPaketDiminati.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblPaketDiminati.setForeground(new java.awt.Color(0, 0, 0));
        lblPaketDiminati.setText("asd");
        getContentPane().add(lblPaketDiminati, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 295, 250, 40));

        lblBulan.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblBulan.setForeground(new java.awt.Color(0, 0, 0));
        lblBulan.setText("asd");
        getContentPane().add(lblBulan, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 330, 250, 40));

        lblIPengeluaranOperasional.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblIPengeluaranOperasional.setForeground(new java.awt.Color(0, 0, 0));
        lblIPengeluaranOperasional.setText("asd");
        getContentPane().add(lblIPengeluaranOperasional, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 160, 250, 40));

        lblKategori.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblKategori.setForeground(new java.awt.Color(0, 0, 0));
        lblKategori.setText("asd");
        getContentPane().add(lblKategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 263, 250, 40));

        lblProduksi.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblProduksi.setForeground(new java.awt.Color(0, 0, 0));
        lblProduksi.setText("asd");
        getContentPane().add(lblProduksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, 250, 40));

        lblKeputusanPaket.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblKeputusanPaket.setForeground(new java.awt.Color(0, 0, 0));
        lblKeputusanPaket.setText("asd");
        getContentPane().add(lblKeputusanPaket, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 494, 250, 40));

        lblKeputusanKategori.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblKeputusanKategori.setForeground(new java.awt.Color(0, 0, 0));
        lblKeputusanKategori.setText("asd");
        getContentPane().add(lblKeputusanKategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 460, 250, 40));

        lblKeputusanBarang.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblKeputusanBarang.setForeground(new java.awt.Color(0, 0, 0));
        lblKeputusanBarang.setText("asd");
        getContentPane().add(lblKeputusanBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 595, 130, 40));

        lblKeputusanBulan.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblKeputusanBulan.setForeground(new java.awt.Color(0, 0, 0));
        lblKeputusanBulan.setText("asd");
        getContentPane().add(lblKeputusanBulan, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 526, 220, 40));

        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 10, 60, 50));

        lblPemasukan.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblPemasukan.setForeground(new java.awt.Color(0, 0, 0));
        lblPemasukan.setText("asd");
        getContentPane().add(lblPemasukan, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 124, 250, 40));

        lblPenghasilan.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblPenghasilan.setForeground(new java.awt.Color(0, 0, 0));
        lblPenghasilan.setText("asd");
        getContentPane().add(lblPenghasilan, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, 250, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/rekap laporan.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        closeMessage();
    }//GEN-LAST:event_jLabel2MouseClicked



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblBulan;
    private javax.swing.JLabel lblIPengeluaranOperasional;
    private javax.swing.JLabel lblKategori;
    private javax.swing.JLabel lblKeputusanBarang;
    private javax.swing.JLabel lblKeputusanBulan;
    private javax.swing.JLabel lblKeputusanKategori;
    private javax.swing.JLabel lblKeputusanPaket;
    private javax.swing.JLabel lblPaketDiminati;
    private javax.swing.JLabel lblPemasukan;
    private javax.swing.JLabel lblPenghasilan;
    private javax.swing.JLabel lblProduksi;
    private javax.swing.JLabel lblRataJamaah;
    // End of variables declaration//GEN-END:variables
}
