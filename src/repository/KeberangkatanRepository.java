/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import entity.Keberangkatan;
import entity.Pemesanan;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import util.Conn;
/**
 *
 * @author WINDOWS 10
 */
public class KeberangkatanRepository implements Repository<Keberangkatan>{
    private String tableName = Keberangkatan.tableName;
    @Override
    public List<Keberangkatan> get() {
        String sql = "SELECT * FROM "+tableName;
        List<Keberangkatan> keberangkatan = new ArrayList<>();
        
        try {
            Connection koneksi = (Connection)Conn.configDB();
            Statement stm = koneksi.createStatement();
            ResultSet res = stm.executeQuery(sql);
            
            while(res.next()){
                keberangkatan.add(mapToEntity(res));
            }
        } catch (Exception e) {
        }
        return keberangkatan;
    }
    
     public List<Keberangkatan> getOrderByDesc() {
        String sql = "SELECT * FROM "+tableName+" ORDER BY tanggal DESC LIMIT 1";
        List<Keberangkatan> keberangkatan = new ArrayList<>();
        
        try {
            Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement stm = koneksi.prepareStatement(sql);
            ResultSet res = stm.executeQuery();
            while(res.next()){
                keberangkatan.add(mapToEntity(res));
            }
        } catch (Exception e) {
        }
        return keberangkatan;
    }
    
      public List<Keberangkatan> getById(int id) {
        String sql = "SELECT * FROM "+tableName+" WHERE id = ?";
        List<Keberangkatan> keberangkatan = new ArrayList<>();
        
        try {
            Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement stm = koneksi.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet res = stm.executeQuery();
            while(res.next()){
                keberangkatan.add(mapToEntity(res));
            }
        } catch (Exception e) {
        }
        return keberangkatan;
    }

    public List<Keberangkatan> getByMenu(String menu) {
        String sql = "SELECT * FROM "+tableName+" LEFT JOIN master_paket ON keberangkatan.paket_id = master_paket.id WHERE menu = ? ORDER BY tanggal DESC";
        List<Keberangkatan> keberangkatan = new ArrayList<>();
        
        try {
             Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement stm = koneksi.prepareStatement(sql);
            stm.setString(1, menu);
            ResultSet res = stm.executeQuery();
            
            while(res.next()){
                keberangkatan.add(mapToEntity(res));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return keberangkatan;
    }
    
    public List<Keberangkatan> getPemesananNull() {
        String sql = "SELECT * FROM "+tableName+" LEFT JOIN pengeluaran ON keberangkatan.id = pengeluaran.keberangkatan_id WHERE pengeluaran.total_pengeluaran IS NULL";
        List<Keberangkatan> keberangkatan = new ArrayList<>();
        
        try {
            Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement stm = koneksi.prepareStatement(sql);

            ResultSet res = stm.executeQuery();
            while(res.next()){
                keberangkatan.add(mapToEntity(res));
                
            }
        } catch (Exception e) {
        }
        return keberangkatan;
    }
    @Override
    public Keberangkatan get(Integer id) {
        String sql = "SELECT * FROM "+tableName+" WHERE id = ?";
        Keberangkatan keberangkatan = new Keberangkatan();
         
        try {
             Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement stm = koneksi.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet res = stm.executeQuery();

            while(res.next()) {
                return mapToEntity(res); 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return keberangkatan;
    }

    @Override
    public boolean add(Keberangkatan keberangkatan) {
           String sql = "INSERT INTO "+ tableName +" (`paket_id`, `tanggal`, `status`) VALUES (?, ?. ?)";
         try {
            Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement pst = koneksi.prepareStatement(sql);
            pst.setInt(1, keberangkatan.getPaket().getId());
            pst.setDate(2, new Date(keberangkatan.getTanggal().getTime()));
            pst.setString(3, keberangkatan.getStatus());
            pst.execute();
            return true;
        } catch (Exception e) {
             e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Keberangkatan keberangkatan) {
        String sql = "UPDATE "+ tableName +" SET paket_id = ?, tanggal = ?, status = ? WHERE id = ?";
        
        try {
                 Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement pst = koneksi.prepareStatement(sql);
            pst.setInt(1, keberangkatan.getPaket().getId());
            pst.setDate(2, new Date(keberangkatan.getTanggal().getTime()));
            pst.setString(3, keberangkatan.getStatus());
            pst.setInt(4, keberangkatan.getId()); 
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
    private Keberangkatan mapToEntity(ResultSet result)throws SQLException{
        Keberangkatan keberangkatan = new Keberangkatan(
                new PaketRepository().get(result.getInt("paket_id")),
                result.getDate("tanggal"),
                result.getString("status")
            );
        keberangkatan.setId(result.getInt("id"));
        return keberangkatan;
    }
    

//    private Pemesanan MapToEntity(ResultSet result)throws SQLException{
//        Pemesanan pemesanan = new Pemesanan(
//                new KeberangkatanRepository().get(result.getInt("Keberangkatan_id")),
//                new JamaahRepository().get(result.getInt("jamaah_id")),
//                result.getString("jenis_pembayaran"),
//                result.getString("status"),
//                result.getDate("tanggal"),
//                result.getInt("total_tagihan"),
//                result.getInt("jumlah_bayar"));
//        pemesanan.setId(result.getInt("pemesanan.id"));
//        return pemesanan;
//    }
    
    
    
}
