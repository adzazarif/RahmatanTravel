/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import entity.Pemesanan;
import entity.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.Conn;

/**
 *
 * @author WINDOWS 10
 */
public class PemesananRepository implements Repository<Pemesanan>{
    private static String tableName = Pemesanan.tableName;
    @Override
    public List<Pemesanan> get() {
        String sql = "SELECT * FROM " + tableName;
        List<Pemesanan> pemesanan = new ArrayList<>();
        try {
             Connection koneksi = (Connection)Conn.configDB();
            Statement stm = koneksi.createStatement();
            ResultSet res = stm.executeQuery(sql);
            
            while(res.next()) {
                pemesanan.add(mapToEntity(res));
            }
        } catch (SQLException e) {
        e.printStackTrace();
        }

        return pemesanan;
    }
    public List<Pemesanan> getById(int id){
         String sql = "SELECT * FROM " + tableName + " WHERE id = ?";
        List<Pemesanan> pemesanan = new ArrayList<>();
        try {
             Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement stm = koneksi.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet res = stm.executeQuery();
            
            while(res.next()) {
                pemesanan.add(mapToEntity(res));
            }
        } catch (SQLException e) {
        e.printStackTrace();
        }

        return pemesanan;  
    }
    
    public List<Pemesanan> getByIdKeberangkatan(int id_paket){
         String sql = "SELECT * FROM " + tableName + " WHERE keberangkatan_id = ?";
        List<Pemesanan> pemesanan = new ArrayList<>();
        try {
             Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement stm = koneksi.prepareStatement(sql);
            stm.setInt(1, id_paket);
            ResultSet res = stm.executeQuery();
            
            while(res.next()) {
                pemesanan.add(mapToEntity(res));
            }
        } catch (SQLException e) {
        e.printStackTrace();
        }

        return pemesanan;  
    }
    
     public List<Pemesanan> getByIdJamaah(int idJamaah){
         String sql = "SELECT * FROM " + tableName + " WHERE jamaah_id = ?";
        List<Pemesanan> pemesanan = new ArrayList<>();
        try {
             Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement stm = koneksi.prepareStatement(sql);
            stm.setInt(1, idJamaah);
            ResultSet res = stm.executeQuery();
            
            while(res.next()) {
                pemesanan.add(mapToEntity(res));
            }
        } catch (SQLException e) {
        e.printStackTrace();
        }

        return pemesanan;  
    }
    
    @Override
    public Pemesanan get(Integer id) {
               String sql = "SELECT * FROM " + tableName + " WHERE id = ?" ;

        Pemesanan pemesanan = new Pemesanan();
        try {
             Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement stm = koneksi.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet res = stm.executeQuery();

            while(res.next()) {
                return mapToEntity(res); 
            }
        } catch (SQLException e) {
        e.printStackTrace();}

        return pemesanan;
    }

    @Override
    public boolean add(Pemesanan pemesanan) {
            String sql = "INSERT INTO "+ tableName +" (`keberangkatan_id`, `jamaah_id`, `jenis_pembayaran`, `status`, `tanggal`, `jumlah_bayar`, `total_tagihan`) VALUES (?, ?, ?, ?, ?, ?, ?)";
         try {
            Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement pst = koneksi.prepareStatement(sql);
            pst.setInt(1, pemesanan.getKeberangkatan().getId());
            pst.setInt(2, pemesanan.getJamaah().getNik());
            pst.setString(3, pemesanan.getJenisPembayaran());
            pst.setString(4, pemesanan.getStatus());
            pst.setDate(5, new Date(pemesanan.getTanggal().getTime()));
            pst.setInt(6, pemesanan.getJumlahBayar());
            pst.setInt(7, pemesanan.getTotalTagihan());
            pst.execute();
            return true;
        } catch (Exception e) {
             e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Pemesanan pemesanan) {
        
        String sql = "UPDATE "+ tableName +" SET keberangkatan_id = ?, jamaah_id = ?, jenis_pembayaran = ?, status = ?, tanggal = ?, jumlah_bayar = ?, total_tagihan = ? WHERE id = ?";
        
        try {
                 Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement pst = koneksi.prepareStatement(sql);
            pst.setInt(1, pemesanan.getKeberangkatan().getId());
            pst.setInt(2, pemesanan.getJamaah().getNik());
            pst.setString(3, pemesanan.getJenisPembayaran());
            pst.setString(4, pemesanan.getStatus());
            pst.setDate(5, new Date(pemesanan.getTanggal().getTime()));
            pst.setInt(6, pemesanan.getJumlahBayar());
            pst.setInt(7, pemesanan.getTotalTagihan());
            pst.setInt(8, pemesanan.getId());
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean updateStatus(String status, int id) {
        
        String sql = "UPDATE "+ tableName +" SET status = ? WHERE id = ?";
        
        try {
                 Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement pst = koneksi.prepareStatement(sql);
            pst.setString(1, status);
            pst.setInt(2, id);
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM "+ tableName +" WHERE id = ?";
           try {
                 Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement pst = koneksi.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public int getIdLast(){
         int total = 0;
        String queryCek = "SELECT id FROM pemesanan ORDER BY id DESC";
        try {
        Connection koneksi = (Connection) Conn.configDB();
        PreparedStatement pst = koneksi.prepareStatement(queryCek);
        ResultSet res = pst.executeQuery();
        if(res.next()){
            total = res.getInt("id");
        }
        } catch (Exception e) {
        }
        return total;
    }
    private Pemesanan mapToEntity(ResultSet result) throws SQLException {
         Pemesanan pemesanan = new Pemesanan(
                 new KeberangkatanRepository().get(result.getInt("keberangkatan_id")),
                 new JamaahRepository().get(result.getInt("jamaah_id")),
                 result.getString("jenis_pembayaran"),
                 result.getString("status"),
                 result.getDate("tanggal"),
                 result.getInt("total_tagihan"),
                 result.getInt("jumlah_bayar")
         );

        pemesanan.setId(result.getInt("id"));
        return pemesanan;
        }
    
//    public static void main(String[] args) {
//        PemesananRepository pr = new PemesananRepository();
//        
//        for(Pemesanan prs:pr.get()){
//            System.out.println(prs.getId());
//            System.out.println(prs.getJamaah().getNama());
//            System.out.println(prs.getPaket().getHarga());
//        }
//    }
}
