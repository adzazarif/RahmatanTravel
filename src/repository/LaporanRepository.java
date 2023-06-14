/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import data.DataChartBar;
import data.DataChartLine;
import entity.Pemesanan;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import util.Conn;

/**
 *
 * @author adzaz
 */
public class LaporanRepository {
    private int jumlahByMenu;
    private int jumlah;
    public int getCountJamaahByMenu(String menu){     
        try {  
       String queryCek = "SELECT COUNT(pemesanan.jamaah_id) AS jumlahPemesananUmrah FROM `keberangkatan` JOIN master_paket ON keberangkatan.paket_id = master_paket.id JOIN pemesanan ON keberangkatan.id = pemesanan.keberangkatan_id WHERE menu = ?";
 
        Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement stm = koneksi.prepareStatement(queryCek);
            stm.setString(1, menu);
            ResultSet res = stm.executeQuery();
        if(res.next()){
            jumlahByMenu = res.getInt("jumlahPemesananUmrah");
        }    
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return jumlahByMenu;
    }
    
        public int getCountJumlah(){     
        try {  
       String queryCek = "SELECT COUNT(pemesanan.jamaah_id) AS jumlahPemesananUmrah FROM `keberangkatan` JOIN master_paket ON keberangkatan.paket_id = master_paket.id JOIN pemesanan ON keberangkatan.id = pemesanan.keberangkatan_id";
 
        Connection koneksi = (Connection) Conn.configDB();
        Statement pstCek = koneksi.createStatement();
        ResultSet res = pstCek.executeQuery(queryCek);
        if(res.next()){
            jumlah = res.getInt("jumlahPemesananUmrah");
        }    
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return jumlah;
    }
        
    public List<DataChartBar> getChartStats() {
        List<DataChartBar> data = new ArrayList<>();
        String sql = "SELECT DATE_FORMAT(pemesanan.tanggal, '%M') AS months,SUM(pemesanan.jumlah_bayar) as pemasukann, SUM(pengeluaran.total_pengeluaran) + (SELECT SUM(pengeluaran_operasional.jumlah) AS pengeluaran_op FROM pengeluaran_operasional WHERE MONTH('2023-06-02') = 6) AS pengeluarann, (SUM(pemesanan.jumlah_bayar) - pengeluaran.total_pengeluaran - (SELECT SUM(pengeluaran_operasional.jumlah) AS pengeluaran_op FROM pengeluaran_operasional WHERE MONTH('2023-06-02') = 6)) AS laba_bersih, (SUM(pemesanan.jumlah_bayar) - pengeluaran.total_pengeluaran) AS laba_kotor FROM `keberangkatan` JOIN pemesanan ON keberangkatan.id = pemesanan.keberangkatan_id JOIN pengeluaran ON keberangkatan.id = pengeluaran.keberangkatan_id JOIN master_paket ON keberangkatan.paket_id = master_paket.id GROUP BY YEAR(pemesanan.tanggal), MONTH(pemesanan.tanggal) LIMIT 5";

        try {
            
            Connection koneksi = (Connection) Conn.configDB();
        Statement pstCek = koneksi.createStatement();
        ResultSet res = pstCek.executeQuery(sql);

            while(res.next()) {
                data.add(new DataChartBar(
                    res.getString("months"),
                    res.getInt("pemasukann"),
                    res.getInt("pengeluarann"),
                    res.getInt("laba_bersih"),
                    res.getInt("laba_kotor")
                ));}
        }catch(Exception e) { e.printStackTrace(); }

        return data;
    }
    
         
        
          public List<DataChartLine> getChartLine() {
               List<DataChartLine> data = new ArrayList<>();
      try {
            String sqlUmrah = "SELECT DATE_FORMAT(pemesanan.tanggal, '%M') AS months, COUNT(pemesanan.jamaah_id) AS jml FROM pemesanan JOIN keberangkatan ON keberangkatan.id = pemesanan.keberangkatan_id  JOIN master_paket ON keberangkatan.paket_id = master_paket.id WHERE master_paket.menu = 'umrah' GROUP BY YEAR(pemesanan.tanggal), MONTH(pemesanan.tanggal)";
            String sqHaji = "SELECT DATE_FORMAT(pemesanan.tanggal, '%M') AS months, COUNT(pemesanan.jamaah_id) AS jml FROM pemesanan JOIN keberangkatan ON keberangkatan.id = pemesanan.keberangkatan_id  JOIN master_paket ON keberangkatan.paket_id = master_paket.id WHERE master_paket.menu = 'haji' GROUP BY YEAR(pemesanan.tanggal), MONTH(pemesanan.tanggal)";
            String sqlWisata = "SELECT DATE_FORMAT(pemesanan.tanggal, '%M') AS months, COUNT(pemesanan.jamaah_id) AS jml FROM pemesanan JOIN keberangkatan ON keberangkatan.id = pemesanan.keberangkatan_id  JOIN master_paket ON keberangkatan.paket_id = master_paket.id WHERE master_paket.menu = 'wisata halal' GROUP BY YEAR(pemesanan.tanggal), MONTH(pemesanan.tanggal)";
            Connection koneksi = (Connection) Conn.configDB();
        Statement pstCek = koneksi.createStatement();
        ResultSet resUmrah = pstCek.executeQuery(sqlUmrah);
         Statement pstHaji = koneksi.createStatement();
        ResultSet resHaji = pstHaji.executeQuery(sqHaji);
         Statement pstwisata = koneksi.createStatement();
            ResultSet resWisata = pstwisata.executeQuery(sqlWisata);
      
            while(resUmrah.next() && resHaji.next() && resWisata.next()){
                  String month = resUmrah.getString("months");
                int totalUmrah = resUmrah.getInt("jml");
                int totalHaji = resHaji.getInt("jml");
                int totalWisata = resWisata.getInt("jml");
                data.add(new DataChartLine(month, totalUmrah, totalHaji, totalWisata));
                  
            }
          
            
        } catch (Exception e) {
            e.printStackTrace();
        }
      return data;
    }
}
