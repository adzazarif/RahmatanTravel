/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view.dialog;
import entity.Barang;
import entity.DetailPengeluaran;
import entity.Keberangkatan;
import entity.Pemesanan;
import entity.Pengeluaran;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import repository.BarangRepository;
import repository.DetailPengeluaranRepository;
import repository.KeberangkatanRepository;
import repository.PemesananRepository;
import repository.PengeluaranRepository;
import view.panel.PengeluaranForm;

/**
 *
 * @author adzaz
 */
public class DialogEditPengeluaranProduksi extends Dialog {
    private int idDetail;
    private int idPengeluaran = PengeluaranForm.id;
    private int idKeberangkatan = PengeluaranForm.idKeberangkatan;
    private List<Barang> listBarang = new ArrayList<>();
    private int idBarang = 0;
    private int StokB = 0;
    private int banyakOrang = 0;
    private int totalPemasukan = 0;
    private int grandTotal = 0;
    private int subHargaLainLain = 0;
    private int subHargaHotel = 0;
    private int subHargaPesawat = 0;
    private  int totalPengeluaranProduksi = PengeluaranForm.totalPengeluaran;
    private int hargaBarangDelete;
    KeberangkatanRepository keberangkatanRepo = new KeberangkatanRepository();
    PemesananRepository pemesananRepo = new PemesananRepository();
    BarangRepository barangRepo = new BarangRepository();
    PengeluaranRepository pengeluaranRepo = new PengeluaranRepository();
    DetailPengeluaranRepository detailPengeluaranRepo = new DetailPengeluaranRepository();
    /**
     * Creates new form DialogEditPengeluaranProduksi
     */
    public DialogEditPengeluaranProduksi(JFrame fram) {
        super(fram);
        initComponents();
        setValue();
        loadTable();
        setTotalPengeluaran();
    }
    
    private void setValue(){
       try {
        
        int banyakOrg = 0;
        int ttlPemasukan = 0;
        for(Pemesanan pm:pemesananRepo.getByIdKeberangkatan(idKeberangkatan)){
            banyakOrg += 1;
            ttlPemasukan += pm.getJumlahBayar();
        }
       
        totalPemasukan = ttlPemasukan;
        banyakOrang = banyakOrg;
         for(Pengeluaran p:pengeluaranRepo.getById(idPengeluaran)){
             totalPengeluaranProduksi = p.getTotalPengeluaran();
            int hargaHotel = p.getHargaHotel();
            int hargaLain = p.getHargaLainLain();
            int hargaPesawat = p.getHargaPesawat();
            int satuanHotel = hargaHotel / banyakOrang;
            int satuanPesawat = hargaPesawat / banyakOrang;
            int satuanLain = hargaLain / banyakOrang;
            lblPengeluaranHotel.setText(String.valueOf(hargaHotel));
            lblpengeluaranLainLain.setText(String.valueOf(hargaLain));
            lblHargaPesawat.setText(String.valueOf(hargaPesawat));
            txtHargaHotel.setText(String.valueOf(satuanHotel));
            txtPesawat.setText(String.valueOf(satuanPesawat));
            txtLainLain.setText(String.valueOf(satuanLain));
               lblNama.setText(p.getKeberangkatan().getPaket().getNama());
           lblTanggal.setText(p.getKeberangkatan().getTanggal().toString());
        }
        
        lblBanyakOrang.setText(String.valueOf(banyakOrang));
        lblBanyakOrang1.setText(String.valueOf(banyakOrang));
        lblBanyakOrang2.setText(String.valueOf(banyakOrang));
        txtStok.setText(String.valueOf(banyakOrang));
        lblTotalPemasukan.setText(String.valueOf(totalPemasukan));
           System.out.println(totalPengeluaranProduksi);
           lblTotalPengeluaran.setText(String.valueOf(totalPengeluaranProduksi));
        } catch (Exception e) {
        }
    }
private void loadTable(){
        try {
             DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID");      
            model.addColumn("Nama");
            model.addColumn("Harga");
            model.addColumn("Jumlah");
            model.addColumn("Sub total");

           
           for(DetailPengeluaran res:detailPengeluaranRepo.getById(idPengeluaran)){
                model.addRow(new Object[]{
                    res.getId(),
                    res.getBarang().getNama(),
                    res.getBarang().getHarga(),
                    res.getBanyak(),
                    res.getHarga(),
                    
           });
            
    }
           table.setModel(model);
        } catch (Exception e) {
        }
    }

private void setTotalPengeluaran(){
        try {
        totalPengeluaranProduksi = subHargaHotel + subHargaLainLain + subHargaPesawat + grandTotal;
        lblTotalPengeluaran.setText(String.valueOf(totalPengeluaranProduksi));

        } catch (Exception e) {
            e.getMessage();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        cmbBarang = new javax.swing.JComboBox<>();
        txtStok = new javax.swing.JTextField();
        btnTambahBarang = new javax.swing.JLabel();
        lblTotalPemasukan = new javax.swing.JLabel();
        lblTotalPengeluaran = new javax.swing.JLabel();
        txtLainLain = new javax.swing.JTextField();
        lblBanyakOrang2 = new javax.swing.JLabel();
        lblpengeluaranLainLain = new javax.swing.JLabel();
        lblPengeluaranHotel = new javax.swing.JLabel();
        lblBanyakOrang1 = new javax.swing.JLabel();
        txtHargaHotel = new javax.swing.JTextField();
        txtPesawat = new javax.swing.JTextField();
        lblBanyakOrang = new javax.swing.JLabel();
        lblHargaPesawat = new javax.swing.JLabel();
        lblNama = new javax.swing.JLabel();
        lblTanggal = new javax.swing.JLabel();
        btnBatal = new javax.swing.JLabel();
        btnEdit = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnHapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHapusMouseClicked(evt);
            }
        });
        getContentPane().add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 610, 60, 50));

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
        jScrollPane1.setViewportView(table);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 230, 420, 350));

        cmbBarang.setBackground(new Color(0,0,0,0));
        cmbBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBarangActionPerformed(evt);
            }
        });
        getContentPane().add(cmbBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 150, 240, 50));

        txtStok.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        txtStok.setBorder(null);
        txtStok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStokActionPerformed(evt);
            }
        });
        getContentPane().add(txtStok, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 160, 50, 30));

        btnTambahBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTambahBarangMouseClicked(evt);
            }
        });
        getContentPane().add(btnTambahBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 150, 60, 50));

        lblTotalPemasukan.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblTotalPemasukan.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblTotalPemasukan, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 540, 260, 40));

        lblTotalPengeluaran.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblTotalPengeluaran.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblTotalPengeluaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 480, 260, 40));

        txtLainLain.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        txtLainLain.setBorder(null);
        txtLainLain.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLainLainKeyReleased(evt);
            }
        });
        getContentPane().add(txtLainLain, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 410, 220, 40));

        lblBanyakOrang2.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblBanyakOrang2.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblBanyakOrang2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 410, 50, 40));

        lblpengeluaranLainLain.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblpengeluaranLainLain.setForeground(new java.awt.Color(0, 0, 0));
        lblpengeluaranLainLain.setText("asd");
        getContentPane().add(lblpengeluaranLainLain, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 410, 270, 40));

        lblPengeluaranHotel.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblPengeluaranHotel.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblPengeluaranHotel, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 290, 270, 50));

        lblBanyakOrang1.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblBanyakOrang1.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblBanyakOrang1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 300, 50, 40));

        txtHargaHotel.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        txtHargaHotel.setBorder(null);
        txtHargaHotel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtHargaHotelKeyReleased(evt);
            }
        });
        getContentPane().add(txtHargaHotel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 220, 40));

        txtPesawat.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        txtPesawat.setBorder(null);
        txtPesawat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesawatKeyReleased(evt);
            }
        });
        getContentPane().add(txtPesawat, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 220, 40));

        lblBanyakOrang.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblBanyakOrang.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblBanyakOrang, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, 50, 50));

        lblHargaPesawat.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblHargaPesawat.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblHargaPesawat, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 190, 270, 50));

        lblNama.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblNama.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 200, 50));

        lblTanggal.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblTanggal.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblTanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 90, 200, 50));

        btnBatal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBatalMouseClicked(evt);
            }
        });
        getContentPane().add(btnBatal, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 600, 180, 40));
        getContentPane().add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 600, 150, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/edit pengeluaran produksi.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1308, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapusMouseClicked
        try {
            boolean hapusDetail = detailPengeluaranRepo.delete(idDetail);
            if(hapusDetail){
                System.out.println("Berhasil");
                totalPengeluaranProduksi -= hargaBarangDelete;
            }else{
                System.out.println("gagal");
            }
            setTotalPengeluaran();
            loadTable();
            table.revalidate();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnHapusMouseClicked

    private void cmbBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBarangActionPerformed

        try {
            String str = String.valueOf(cmbBarang.getSelectedItem());
            String [] getId= str.split(",", 5);
            String [] getStok = str.split("= ", 5);
            idBarang = Integer.valueOf(getId[0]);
            StokB = Integer.valueOf(getStok[1]);
        } catch (Exception e) {
            System.out.println("salah click");
            e.getMessage();
        }

    }//GEN-LAST:event_cmbBarangActionPerformed

    private void txtStokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStokActionPerformed

    private void btnTambahBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahBarangMouseClicked
        try {
            System.out.println(idBarang);
            System.out.println(StokB);
            int inputStok = Integer.parseInt(txtStok.getText());
            for(Barang br:barangRepo.getById(idBarang)){
                if(br.getStok() < inputStok){
                    System.out.println("stok tidak cukup");
                    return;
                }

                int subTotal = br.getHarga() * Integer.valueOf(txtStok.getText());

                listBarang.add(new Barang(br.getId(), br.getNama(), inputStok, br.getHarga(),subTotal));
            }
            int stotal = 0;
            for(Barang i:listBarang){
                stotal = i.getSubTotal();
            }
            grandTotal += stotal;
            setTotalPengeluaran();
            loadTable();
        } catch (Exception e) {
            System.out.println("salah tambah");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnTambahBarangMouseClicked

    private void txtLainLainKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLainLainKeyReleased
        int harga = Integer.parseInt(txtLainLain.getText());
        subHargaLainLain = harga * banyakOrang;
        lblpengeluaranLainLain.setText(String.valueOf(subHargaLainLain));
        setTotalPengeluaran();
    }//GEN-LAST:event_txtLainLainKeyReleased

    private void txtHargaHotelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHargaHotelKeyReleased
        int harga = Integer.parseInt(txtHargaHotel.getText());
        subHargaHotel = harga * banyakOrang;
        lblPengeluaranHotel.setText(String.valueOf(subHargaHotel));
        setTotalPengeluaran();
    }//GEN-LAST:event_txtHargaHotelKeyReleased

    private void txtPesawatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesawatKeyReleased
        int harga = Integer.parseInt(txtPesawat.getText());
        subHargaPesawat = harga * banyakOrang;
        lblHargaPesawat.setText(String.valueOf(subHargaPesawat));
        setTotalPengeluaran();
    }//GEN-LAST:event_txtPesawatKeyReleased

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        int baris = table.rowAtPoint(evt.getPoint());
        String ids = table.getValueAt(baris, 0).toString();
        String harga = table.getValueAt(baris, 4).toString();
        idDetail = Integer.valueOf(ids);
        hargaBarangDelete = Integer.parseInt(harga);
    }//GEN-LAST:event_tableMouseClicked

    private void btnBatalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBatalMouseClicked
        closeMessage();
    }//GEN-LAST:event_btnBatalMouseClicked

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnBatal;
    private javax.swing.JLabel btnEdit;
    private javax.swing.JLabel btnHapus;
    private javax.swing.JLabel btnTambahBarang;
    private javax.swing.JComboBox<String> cmbBarang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBanyakOrang;
    private javax.swing.JLabel lblBanyakOrang1;
    private javax.swing.JLabel lblBanyakOrang2;
    private javax.swing.JLabel lblHargaPesawat;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lblPengeluaranHotel;
    private javax.swing.JLabel lblTanggal;
    private javax.swing.JLabel lblTotalPemasukan;
    private javax.swing.JLabel lblTotalPengeluaran;
    private javax.swing.JLabel lblpengeluaranLainLain;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtHargaHotel;
    private javax.swing.JTextField txtLainLain;
    private javax.swing.JTextField txtPesawat;
    private javax.swing.JTextField txtStok;
    // End of variables declaration//GEN-END:variables
}
