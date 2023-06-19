/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.panel;

import chart.ModelPolarAreaChart;
import com.raven.chart.ModelChart;
import data.DataChartBar;
import data.DataChartLine;
import entity.Pemesanan;
import entity.Pengeluaran;
import entity.PengeluaranOperasional;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.Locale;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import repository.LaporanRepository;
import repository.PemesananRepository;
import repository.PengeluaranOperasionalRepository;
import repository.PengeluaranRepository;
import util.Conn;
import view.dialog.DialogDetailPemesanan;
import view.dialog.DialogRekapLaporan;
import view.main.Main;
import view.main.maindasboard;

/**
 *
 * @author adzaz
 */
public class LaporanForm extends javax.swing.JPanel {
    NumberFormat nf = NumberFormat.getNumberInstance(new Locale("in", "ID"));
    private String pilihan;
    PengeluaranOperasionalRepository pengeluaranOperasionalRepo = new PengeluaranOperasionalRepository();
    PengeluaranRepository pengeluaranRepo = new PengeluaranRepository();
    PemesananRepository pemesananRepo = new PemesananRepository();
    LaporanRepository laporanRepo = new LaporanRepository();
    /**
     * Creates new form LaporanFormm
     */
    public LaporanForm() {
        initComponents();
//        setChart();
jPanel5.setOpaque(false);
        jLabel6.setVisible(false);
        btn_logout.setVisible(false);
        setChartBar();
        setChartLine();
        panelTable.setVisible(false);
        panelKeuntungan.setVisible(false);
        panelPengeluaran.setVisible(false);
    }
 public void setChartBar(){
        chartBar.addLegend("pemasukan", new Color(245, 189, 135));
        chartBar.addLegend("pengeluaran", new Color(135, 189, 245));
        chartBar.addLegend("laba bersih", new Color(189, 135, 245));
        chartBar.addLegend("laba kotor", new Color(139, 229, 222));
  
        for(DataChartBar res:laporanRepo.getChartStats()){
            chartBar.addData(new ModelChart(res.getMonth(), new double[]{res.getPemasukan(), res.getPengeluaran(),res.getLabaBersih(),res.getLabaKotor()}));
        }
        
    }
      private void setChartLine() {
          try {
                    chartLine.setTitle("Chart Data");
        chartLine.addLegend("Umrah", Color.decode("#7b4397"), Color.decode("#dc2430"));
        chartLine.addLegend("Haji", Color.decode("#e65c00"), Color.decode("#F9D423"));
        chartLine.addLegend("Wisata", Color.decode("#0099F7"), Color.decode("#F11712"));
                chartLine.clear();
                for(DataChartLine r:laporanRepo.getChartLine()){
        chartLine.addData(new raven.chart.ModelChart(r.getMonth(), new double[]{r.getAmounthUmrah(), r.getAmounthHaji(), r.getAmounthWisata()}));
    }
          } catch (Exception e) {
          }
        chartLine.start();
    }
//    public void setChart(){
//        try {
//        double jumlahTotal = laporanRepo.getCountJumlah();
//        double jumlahByUmrah = laporanRepo.getCountJamaahByMenu("umrah");
//        double jumlahByHaji = laporanRepo.getCountJamaahByMenu("haji");
//        double jumlahByWisataHalal = laporanRepo.getCountJamaahByMenu("wisata halal");
//        
//        double presentaseUmrah = jumlahByUmrah / jumlahTotal * 100;
//        double presentaseHaji = jumlahByHaji / jumlahTotal * 100;
//        double presenteseWisata = jumlahByWisataHalal / jumlahTotal * 100;
//            System.out.println(jumlahByUmrah);
//            System.out.println(jumlahTotal);
//            System.out.println(presentaseUmrah);
//        chart1.addItem(new ModelPolarAreaChart(new Color(52, 148, 203), "Umrah", presentaseUmrah));
//        chart1.addItem(new ModelPolarAreaChart(new Color(175, 67, 237), "Haji", presentaseHaji));
//        chart1.addItem(new ModelPolarAreaChart(new Color(87, 218, 137), "Wisata Halal", presenteseWisata)); 
//         chart1.start();
//        } catch (Exception e) {
//        }
//        
//    }
    

     public void loadTableOperasional(){
            DefaultTableModel model = new DefaultTableModel();     
            model.addColumn("Id");      
            model.addColumn("Nama");
            model.addColumn("Total");
            model.addColumn("Tanggal");
            model.addColumn("Deskripsi");
         
            
          
           
           try {
             for(PengeluaranOperasional res:pengeluaranOperasionalRepo.get()){
                model.addRow(new Object[]{
                    res.getId(),
                    res.getNamaPengeluaran(),
                    nf.format(res.getJumlah()),
                    res.getTanggal(),
                    res.getDeskripsi(),
                });
           }
             table.setModel(model);
         } catch (Exception e) {
             e.printStackTrace();
         }
    }
     
      public void loadTableProduksi(){
             DefaultTableModel model = new DefaultTableModel();     
            model.addColumn("id");
            model.addColumn("Nama");
            model.addColumn("Tanggal Keberangkatan");
            model.addColumn("Tanggal Pengeluaran");
            model.addColumn("Total pengeluran");
            int no = 1;
           
           try {
             for(Pengeluaran res:pengeluaranRepo.get()){
                model.addRow(new Object[]{
                    res.getId(),
                    res.getKeberangkatan().getPaket().getNama(),
                    res.getKeberangkatan().getTanggal(),
                    res.getTanggal(),
                    nf.format(res.getTotalPengeluaran())
                   
                });
           }
            table.setModel(model);
       
         } catch (Exception e) {
               e.printStackTrace();
         }
    }
    
     public void loadTableKeuntunganKotor(){
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("No");      
            model.addColumn("Nama Paket");
            model.addColumn("Tanggal Keberangkatan");
            model.addColumn("Pemasukan");
            model.addColumn("Pengeluaran");
            model.addColumn("Keuntungan");           
            
           
           try{
            int no = 1;        

        String sql = "SELECT master_paket.nama, keberangkatan.tanggal, SUM(pemesanan.jumlah_bayar) as pemasukann, pengeluaran.total_pengeluaran AS pengeluarann, (SUM(pemesanan.jumlah_bayar) - pengeluaran.total_pengeluaran) AS laba_kotor FROM `keberangkatan` JOIN pemesanan ON keberangkatan.id = pemesanan.keberangkatan_id JOIN pengeluaran ON keberangkatan.id = pengeluaran.keberangkatan_id JOIN master_paket ON keberangkatan.paket_id = master_paket.id GROUP BY keberangkatan.id " ;
        Connection koneksi = (Connection)Conn.configDB();
        Statement stm = koneksi.createStatement();
        ResultSet res = stm.executeQuery(sql);
            while(res.next()){
                model.addRow(new Object[]{
              no++,
                    res.getString("nama"), 
                    res.getString("tanggal"),
                    nf.format(res.getInt("pemasukann")), 
                    nf.format(res.getInt("pengeluarann")),
                    nf.format(res.getInt("laba_kotor"))
                    
                });
            }
            table.setModel(model);
        }catch(Exception e){
               System.out.println(e.getMessage());
        }
        
     }
    
     public void loadTableKeuntunganBersih(){
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("No");      
            model.addColumn("Bulan");
            model.addColumn("Pemasukan");
            model.addColumn("Pengeluaran");
            model.addColumn("Keuntungan");           
            
           
           try{
            int no = 1;        

        String sql = "SELECT DATE_FORMAT(pemesanan.tanggal, '%M') AS month, keberangkatan.tanggal, SUM(pemesanan.jumlah_bayar) as pemasukann, pengeluaran.total_pengeluaran + (SELECT SUM(pengeluaran_operasional.jumlah) AS pengeluaran_op FROM pengeluaran_operasional ) AS pengeluarann, (SUM(pemesanan.jumlah_bayar) - pengeluaran.total_pengeluaran - (SELECT SUM(pengeluaran_operasional.jumlah) AS pengeluaran_op FROM pengeluaran_operasional )) AS laba_bersih FROM `keberangkatan` JOIN pemesanan ON keberangkatan.id = pemesanan.keberangkatan_id JOIN pengeluaran ON keberangkatan.id = pengeluaran.keberangkatan_id JOIN master_paket ON keberangkatan.paket_id = master_paket.id GROUP BY YEAR(pemesanan.tanggal), MONTH(pemesanan.tanggal)" ;
        Connection koneksi = (Connection)Conn.configDB();
        Statement stm = koneksi.createStatement();
        ResultSet res = stm.executeQuery(sql);
            while(res.next()){
                model.addRow(new Object[]{
              no++,
                    res.getString("month"),
                    nf.format(res.getInt("pemasukann")), 
                    nf.format(res.getInt("pengeluarann")),
                    nf.format(res.getInt("laba_bersih"))
                    
                });
            }
            table.setModel(model);
        }catch(Exception e){
               System.out.println(e.getMessage());
        }
     }
     
     public void loadTablePemasukan(){
            DefaultTableModel model = new DefaultTableModel();   
            model.addColumn("Id");      
            model.addColumn("Nama");
            model.addColumn("Paket");
            model.addColumn("Tanggal");
            model.addColumn("Jenis Pembayaran");
            model.addColumn("status");
            model.addColumn("Pemasukan");
            
            int no = 1;
           
           try {
             for(Pemesanan res:pemesananRepo.get()){
                model.addRow(new Object[]{
                    res.getId(),
                    res.getJamaah().getNama(),
                    res.getKeberangkatan().getPaket().getNama(),
                    res.getTanggal(),
                    res.getJenisPembayaran(),
                    res.getStatus(),
                    nf.format(res.getJumlahBayar()),
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

        jLabel4 = new javax.swing.JLabel();
        panelTable = new javax.swing.JPanel();
        panelShadow1 = new view.swing.PanelShadow();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new view.pallet.Table();
        scrollBarCustom1 = new view.swing.ScrollBarCustom();
        panelGrafik = new javax.swing.JPanel();
        chartBar = new com.raven.chart.Chart();
        panelShadow3 = new raven.panel.PanelShadow();
        chartLine = new raven.chart.CurveLineChart();
        panelPengeluaran = new javax.swing.JPanel();
        btnOperasional = new javax.swing.JLabel();
        btnProduksi = new javax.swing.JLabel();
        lblIconOpsiPengeluaran = new javax.swing.JLabel();
        panelKeuntungan = new javax.swing.JPanel();
        btnLabaBersih = new javax.swing.JLabel();
        btnLabaKotor = new javax.swing.JLabel();
        lblIconOpsiKeuntungan = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnKeuntungan = new javax.swing.JLabel();
        btnPengeluaran = new javax.swing.JLabel();
        btnPemasukan = new javax.swing.JLabel();
        btnGrafik = new javax.swing.JLabel();
        iconPilihan = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btn_logout = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 249, 243));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/buttondetaill.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        panelTable.setBackground(new Color(0,0,0,0));
        panelTable.setPreferredSize(new java.awt.Dimension(1200, 500));

        panelShadow1.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new Color(0,0,0,0));
        jScrollPane1.setBorder(null);
        jScrollPane1.setVerticalScrollBar(scrollBarCustom1);

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

        scrollBarCustom1.setForeground(new java.awt.Color(255, 90, 0));

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollBarCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scrollBarCustom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelTableLayout = new javax.swing.GroupLayout(panelTable);
        panelTable.setLayout(panelTableLayout);
        panelTableLayout.setHorizontalGroup(
            panelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelTableLayout.setVerticalGroup(
            panelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTableLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        panelGrafik.setBackground(new Color(0,0,0,0));
        panelGrafik.setPreferredSize(new java.awt.Dimension(1200, 540));

        panelShadow3.setBackground(new java.awt.Color(34, 59, 69));
        panelShadow3.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelShadow3.setColorGradient(new java.awt.Color(17, 38, 47));

        chartLine.setForeground(new java.awt.Color(237, 237, 237));
        chartLine.setFillColor(true);

        javax.swing.GroupLayout panelShadow3Layout = new javax.swing.GroupLayout(panelShadow3);
        panelShadow3.setLayout(panelShadow3Layout);
        panelShadow3Layout.setHorizontalGroup(
            panelShadow3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chartLine, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelShadow3Layout.setVerticalGroup(
            panelShadow3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(chartLine, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelGrafikLayout = new javax.swing.GroupLayout(panelGrafik);
        panelGrafik.setLayout(panelGrafikLayout);
        panelGrafikLayout.setHorizontalGroup(
            panelGrafikLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGrafikLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chartBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelShadow3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9))
        );
        panelGrafikLayout.setVerticalGroup(
            panelGrafikLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGrafikLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelShadow3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelGrafikLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(chartBar, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        panelPengeluaran.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnOperasional.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOperasionalMouseClicked(evt);
            }
        });
        panelPengeluaran.add(btnOperasional, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 30));

        btnProduksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProduksiMouseClicked(evt);
            }
        });
        panelPengeluaran.add(btnProduksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 140, 30));

        lblIconOpsiPengeluaran.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/pilihan pengeluaran operasional.png"))); // NOI18N
        panelPengeluaran.add(lblIconOpsiPengeluaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        panelKeuntungan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnLabaBersih.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLabaBersihMouseClicked(evt);
            }
        });
        panelKeuntungan.add(btnLabaBersih, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 30));

        btnLabaKotor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLabaKotorMouseClicked(evt);
            }
        });
        panelKeuntungan.add(btnLabaKotor, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 140, 30));

        lblIconOpsiKeuntungan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/opsi keuntungan laba bersih.png"))); // NOI18N
        panelKeuntungan.add(lblIconOpsiKeuntungan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel1.setBackground(new Color(0,0,0,0));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/title laporan.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(146, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnKeuntungan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnKeuntunganMouseClicked(evt);
            }
        });

        btnPengeluaran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPengeluaranMouseClicked(evt);
            }
        });

        btnPemasukan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPemasukanMouseClicked(evt);
            }
        });

        btnGrafik.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGrafikMouseClicked(evt);
            }
        });

        iconPilihan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/laporan grafik.png"))); // NOI18N

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
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 100, 24));
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, 30, 170));
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 210, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/button cetak.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelGrafik, javax.swing.GroupLayout.DEFAULT_SIZE, 1340, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(panelKeuntungan, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(panelPengeluaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 1050, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(300, 300, 300)
                                        .addComponent(btnPengeluaran, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(150, 150, 150)
                                        .addComponent(btnPemasukan, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnGrafik, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(450, 450, 450)
                                        .addComponent(btnKeuntungan, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(iconPilihan))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel4)
                                        .addGap(55, 55, 55))
                                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelTable, javax.swing.GroupLayout.DEFAULT_SIZE, 1354, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPengeluaran, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPemasukan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGrafik, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnKeuntungan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(iconPilihan))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelKeuntungan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelPengeluaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelGrafik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(panelTable, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(558, 558, 558))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnKeuntunganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKeuntunganMouseClicked
        iconPilihan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/laporan keuntungan.png")));
        pilihan = "keuntungan";
        panelGrafik.setVisible(false);
        loadTableKeuntunganBersih();
        panelTable.setVisible(true);
        panelKeuntungan.setVisible(true);
        panelPengeluaran.setVisible(false);
        
    }//GEN-LAST:event_btnKeuntunganMouseClicked

    private void btnPengeluaranMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPengeluaranMouseClicked
        iconPilihan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/laporan pengeluaran.png")));
        pilihan = "pengeluaran";
        panelGrafik.setVisible(false);
        loadTableOperasional();
        panelTable.setVisible(true);
        panelPengeluaran.setVisible(true);
        panelKeuntungan.setVisible(false);

    }//GEN-LAST:event_btnPengeluaranMouseClicked

    private void btnPemasukanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPemasukanMouseClicked
        iconPilihan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/laporan pemasukan.png")));
        pilihan = "masukan";
        panelGrafik.setVisible(false);
        loadTablePemasukan();
        panelTable.setVisible(true);
        panelPengeluaran.setVisible(false);
        panelKeuntungan.setVisible(false);
    }//GEN-LAST:event_btnPemasukanMouseClicked

    private void btnGrafikMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGrafikMouseClicked
        iconPilihan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/laporan grafik.png")));
        pilihan = "grafik";
        panelTable.setVisible(false);
        panelGrafik.setVisible(true);
        panelPengeluaran.setVisible(false);
        panelKeuntungan.setVisible(false);
    }//GEN-LAST:event_btnGrafikMouseClicked

    private void btnLabaBersihMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLabaBersihMouseClicked
        lblIconOpsiKeuntungan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/opsi keuntungan laba bersih.png")));
        loadTableKeuntunganBersih();
        panelGrafik.setVisible(false);
        panelTable.setVisible(true);
    }//GEN-LAST:event_btnLabaBersihMouseClicked

    private void btnLabaKotorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLabaKotorMouseClicked
        lblIconOpsiKeuntungan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/opsi keuntungan laba kotor.png")));
        loadTableKeuntunganKotor();
        panelGrafik.setVisible(false);
        panelTable.setVisible(true);
    }//GEN-LAST:event_btnLabaKotorMouseClicked

    private void btnOperasionalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOperasionalMouseClicked
         lblIconOpsiPengeluaran.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/opsi pengeluaran operasional.png")));
        loadTableOperasional();
        panelGrafik.setVisible(false);
        panelTable.setVisible(true);
    }//GEN-LAST:event_btnOperasionalMouseClicked

    private void btnProduksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProduksiMouseClicked
          lblIconOpsiPengeluaran.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/opsi pengeluaran produksi.png")));
        loadTableProduksi();
        panelGrafik.setVisible(false);
        panelTable.setVisible(true);
    }//GEN-LAST:event_btnProduksiMouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        maindasboard main =(maindasboard)SwingUtilities.getWindowAncestor(this);
        DialogRekapLaporan tambahCicilan = new DialogRekapLaporan(main);
        tambahCicilan.showPopUp();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
            MessageFormat header = new MessageFormat("Laporan Pengeluaran");
        MessageFormat footer = new MessageFormat("");
        
        try {
            PrintRequestAttributeSet set = new HashPrintRequestAttributeSet();
            set.add(OrientationRequested.PORTRAIT);
            table.print(JTable.PrintMode.FIT_WIDTH,header,footer,true,set,true);
            JOptionPane.showMessageDialog(null, "sukses","berhasil mencetak Laporan",JOptionPane.INFORMATION_MESSAGE);
            
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Salah",e.getMessage(),JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jLabel2MouseClicked

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
    jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/button_menu.png")));
    }//GEN-LAST:event_jLabel5MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnGrafik;
    private javax.swing.JLabel btnKeuntungan;
    private javax.swing.JLabel btnLabaBersih;
    private javax.swing.JLabel btnLabaKotor;
    private javax.swing.JLabel btnOperasional;
    private javax.swing.JLabel btnPemasukan;
    private javax.swing.JLabel btnPengeluaran;
    private javax.swing.JLabel btnProduksi;
    private javax.swing.JLabel btn_logout;
    private com.raven.chart.Chart chartBar;
    private raven.chart.CurveLineChart chartLine;
    private javax.swing.JLabel iconPilihan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblIconOpsiKeuntungan;
    private javax.swing.JLabel lblIconOpsiPengeluaran;
    private javax.swing.JPanel panelGrafik;
    private javax.swing.JPanel panelKeuntungan;
    private javax.swing.JPanel panelPengeluaran;
    private view.swing.PanelShadow panelShadow1;
    private raven.panel.PanelShadow panelShadow3;
    private javax.swing.JPanel panelTable;
    private view.swing.ScrollBarCustom scrollBarCustom1;
    private view.pallet.Table table;
    // End of variables declaration//GEN-END:variables
}
