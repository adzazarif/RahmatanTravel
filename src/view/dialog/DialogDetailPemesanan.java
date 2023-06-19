/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view.dialog;

import entity.DetailPemesanan;
import entity.Pemesanan;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import repository.DetailPemesananRepository;
import repository.PemesananRepository;
import util.DateUtil;
import view.panel.PemesananForm;

/**
 *
 * @author adzaz
 */
public class DialogDetailPemesanan extends Dialog {
    private int id = PemesananForm.id;
    NumberFormat nf = NumberFormat.getNumberInstance(new Locale("in", "ID"));
    PemesananRepository pemesananRepo = new PemesananRepository();
    DetailPemesananRepository detailPemesananRepo = new DetailPemesananRepository();
    DateUtil dateUtil = new DateUtil();
    /**
     * Creates new form DialogDetailPemesanan
     */
    public DialogDetailPemesanan(JFrame frame) {
        super(frame);
        initComponents();
        setValue();
        loadTable();
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
                    nf.format(res.getCicilan())
                    
           });
    }
              table.setModel(model);
}
    
    public void setValue(){
        System.out.println(id);
        for(Pemesanan pm:pemesananRepo.getById(id)){
            String tanggalKeberangkatan = pm.getKeberangkatan().getTanggal().toString();
            String tglAkhirBayar = dateUtil.getDateMinus(tanggalKeberangkatan, 7);
            int totalPembelian = pm.getTotalTagihan();
            int jumlahBayar = pm.getJumlahBayar();
            int kurangBayar = totalPembelian - jumlahBayar;
            lblId.setText(String.valueOf(pm.getId()));
            lblNamaPaket.setText(pm.getKeberangkatan().getPaket().getNama());
            lblNamaJamaah.setText(String.valueOf(pm.getJamaah().getNama()));
            lblJenisPembayaran.setText(pm.getJenisPembayaran());
            lblStatus.setText(pm.getStatus());
            lblTotalPembelian.setText(String.valueOf(nf.format(totalPembelian)));
            lblTotalBayar.setText(String.valueOf(nf.format(jumlahBayar)));
            lblTglTerakhir.setText(tglAkhirBayar);
            lblKurangBayar.setText(String.valueOf(nf.format(kurangBayar)));
            lblDiskon.setText(String.valueOf(nf.format(pm.getKeberangkatan().getPaket().getDiskon())));
            
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

        lblId = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        lblNamaPaket = new javax.swing.JLabel();
        lblNamaJamaah = new javax.swing.JLabel();
        lblJenisPembayaran = new javax.swing.JLabel();
        lblTglTerakhir = new javax.swing.JLabel();
        lblDiskon = new javax.swing.JLabel();
        lblTotalPembelian = new javax.swing.JLabel();
        lblTotalBayar = new javax.swing.JLabel();
        lblKurangBayar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new view.pallet.Table();
        jLabel2 = new javax.swing.JLabel();
        lblTotalPembelian1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblId.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblId.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 220, 40));

        lblStatus.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblStatus.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 286, 220, 40));

        lblNamaPaket.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblNamaPaket.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblNamaPaket, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, 220, 40));

        lblNamaJamaah.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblNamaJamaah.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblNamaJamaah, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 220, 40));

        lblJenisPembayaran.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblJenisPembayaran.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblJenisPembayaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, 220, 40));

        lblTglTerakhir.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblTglTerakhir.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblTglTerakhir, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 215, 220, 40));

        lblDiskon.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblDiskon.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblDiskon, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 357, 220, 40));

        lblTotalPembelian.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblTotalPembelian.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblTotalPembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 324, 220, 40));

        lblTotalBayar.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblTotalBayar.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblTotalBayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 393, 220, 40));

        lblKurangBayar.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblKurangBayar.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblKurangBayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 432, 220, 40));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 180, 390, 350));

        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 20, 60, 40));

        lblTotalPembelian1.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        lblTotalPembelian1.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblTotalPembelian1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 290, 220, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/detail pemesanan.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        PemesananForm.id = 0;
        closeMessage();
    }//GEN-LAST:event_jLabel2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDiskon;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblJenisPembayaran;
    private javax.swing.JLabel lblKurangBayar;
    private javax.swing.JLabel lblNamaJamaah;
    private javax.swing.JLabel lblNamaPaket;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTglTerakhir;
    private javax.swing.JLabel lblTotalBayar;
    private javax.swing.JLabel lblTotalPembelian;
    private javax.swing.JLabel lblTotalPembelian1;
    private view.pallet.Table table;
    // End of variables declaration//GEN-END:variables
}
