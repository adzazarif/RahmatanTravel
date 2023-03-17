/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import util.Conn;
import util.Date;
/**
 *
 * @author WINDOWS 10
 */
public class DashboardRepository {
    Date date = new Date();
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
}
