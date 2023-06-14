/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;


import entity.Paket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.Conn;
import util.DateUtil;
/**
 *
 * @author WINDOWS 10
 */
public class DashboardRepository {
    DateUtil date = new DateUtil();
    public int getIncomePerDay(){
        int total = 0;
        String queryCek = "SELECT SUM(jumlah_bayar) AS jml FROM pemesanan WHERE tanggal = ?";
        try {
        Connection koneksi = (Connection) Conn.configDB();
        PreparedStatement pst = koneksi.prepareStatement(queryCek);
        pst.setString(1, date.dateNow());
        ResultSet res = pst.executeQuery();
        if(res.next()){
            total = res.getInt("jml");
        }
        } catch (Exception e) {
        }
        return total;
    }
    
    public int getIncomeExpensesPerDay(){
        int total = 0;
        String queryCek = "SELECT SUM(total_pengeluaran) AS jml FROM pengeluaran WHERE tanggal = ?";
        try {
        Connection koneksi = (Connection) Conn.configDB();
        PreparedStatement pst = koneksi.prepareStatement(queryCek);
        pst.setString(1, date.dateMonthAgo());
        ResultSet res = pst.executeQuery();
        if(res.next()){
            total = res.getInt("jml");
        }
        } catch (Exception e) {
        }
        return total;
                }               
    
    
    public int getIncome(){
          int total = 0;
        String queryCek = "SELECT SUM(jumlah_bayar) AS jml FROM pemesanan ";
        try {
        Connection koneksi = (Connection) Conn.configDB();
        PreparedStatement pst = koneksi.prepareStatement(queryCek);
        ResultSet res = pst.executeQuery();
        if(res.next()){
            total = res.getInt("jml");
        }
        } catch (Exception e) {
        }
        return total;
    }
    
    public int getExpenditure(){
          int total = 0;
        String queryCek = "SELECT SUM(pengeluaran.total_pengeluaran) + (SELECT SUM(pengeluaran_operasional.jumlah) AS pengeluaran_op FROM pengeluaran_operasional) AS pengeluaran FROM pengeluaran";
        try {
        Connection koneksi = (Connection) Conn.configDB();
        PreparedStatement pst = koneksi.prepareStatement(queryCek);
        ResultSet res = pst.executeQuery();
        if(res.next()){
            total = res.getInt("pengeluaran");
        }
        } catch (Exception e) {
        }
        return total;
    }
    
    public int getProfitPerMonth(){
        int totalPemasukan = 0;
        int totalPengeluaran = 0;
        int total = 0;
        String queryPengeluaran = "SELECT SUM(total_pengeluaran) AS jml FROM pengeluaran WHERE tanggal = ?";
        String queryPemasukan = "SELECT SUM(jumlah_bayar) AS jml FROM pemesanan WHERE tanggal = ?";
        try {
        Connection koneksi = (Connection) Conn.configDB();
        PreparedStatement pstPengeluaran = koneksi.prepareStatement(queryPengeluaran);
        pstPengeluaran.setString(1, date.dateMonthAgo());
        PreparedStatement pstPemasukan = koneksi.prepareStatement(queryPemasukan);
        pstPemasukan.setString(1, date.dateMonthAgo());
        ResultSet resPemasukan = pstPemasukan.executeQuery();
        ResultSet resPengeluaran = pstPengeluaran.executeQuery();
        if(resPemasukan.next() && resPengeluaran.next()){
            totalPemasukan = resPemasukan.getInt("jml");
            totalPengeluaran = resPengeluaran.getInt("jml");
        }
        total = totalPemasukan - totalPengeluaran;
        } catch (Exception e) {
        }
        return total;
    }
    
    public String[] getDataUmrah(){
        String[] data = new String[4];
         String queryCek = "SELECT *, COUNT(*) AS jml FROM paket JOIN pemesanan on paket.id = pemesanan.paket_id GROUP BY pemesanan.paket_id ORDER By tgl_keberangkatan ASC LIMIT 1";
        try {
        Connection koneksi = (Connection) Conn.configDB();
        PreparedStatement pst = koneksi.prepareStatement(queryCek);
        ResultSet res = pst.executeQuery();
        if(res.next()){
            data[0] = res.getString("nama");
            data[1] = res.getString("tgl_keberangkatan");
            data[2] = res.getString("harga");
            data[3] = res.getString("jml");
        }
        } catch (Exception e) {
        }
        return data;
    }
    
    public List<Paket> getOftenPaket(){
          String sql = "SELECT master_paket.nama, COUNT(pemesanan.jamaah_id) as jml FROM keberangkatan JOIN master_paket ON keberangkatan.paket_id = master_paket.id JOIN pemesanan ON keberangkatan.id = pemesanan.keberangkatan_id GROUP BY master_paket.id ORDER BY jml DESC";
        List<Paket> paket = new ArrayList<>();
        try {
             Connection koneksi = (Connection)Conn.configDB();
            Statement stm = koneksi.createStatement();
            ResultSet res = stm.executeQuery(sql);
            
            while(res.next()) {
                paket.add(mapToEntityGet(res));
            }
        } catch (SQLException e) {
        e.printStackTrace();
        }

        return paket;
    }
    private Paket mapToEntityGet(ResultSet result) throws SQLException {
         Paket paket = new Paket();
        paket.setNamaPaket(result.getString("nama"));
        return paket;
        }
}
