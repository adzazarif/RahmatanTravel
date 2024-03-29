/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import entity.Paket;
import entity.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import entity.Paket;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import util.Conn;
/**
 *
 * @author WINDOWS 10
 */
public class PaketRepository implements Repository<Paket>{
        private static String tableName = Paket.tableName;
        
    @Override
    public List<Paket> get() {
         String sql = "SELECT * FROM " + tableName ;
        List<Paket> paket = new ArrayList<>();
        try {
             Connection koneksi = (Connection)Conn.configDB();
            Statement stm = koneksi.createStatement();
            ResultSet res = stm.executeQuery(sql);
            
            while(res.next()) {
                paket.add(mapToEntity(res));
            }
        } catch (SQLException e) {
        e.printStackTrace();
        }

        return paket;
    }
    
    public List<Paket> getSearch(String search) {
         String sql = "SELECT * FROM " + tableName + " WHERE id = ? || nama LIKE '%?%' || menu LIKE '%?%'";
        List<Paket> paket = new ArrayList<>();
        try {
             Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement stm = koneksi.prepareStatement(sql);
            stm.setString(1, search);
            stm.setString(2, search);
            stm.setString(3, search);
            ResultSet res = stm.executeQuery();
            
            while(res.next()) {
                paket.add(mapToEntity(res));
            }
        } catch (SQLException e) {
        e.printStackTrace();
        }
        return paket;
    }
    
       public List<Paket> getByid(Integer id) {
         String sql = "SELECT * FROM " + tableName + " WHERE id = ?";
        List<Paket> paket = new ArrayList<>();
        try {
             Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement stm = koneksi.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet res = stm.executeQuery();
            
            while(res.next()) {
                paket.add(mapToEntity(res));
            }
        } catch (SQLException e) {
        e.printStackTrace();
        }

        return paket;
    }
       
      public List<Paket> getByMenu(String menu) {
         String sql = "SELECT * FROM " + tableName + " WHERE menu = ?";
        List<Paket> paket = new ArrayList<>();
        try {
             Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement stm = koneksi.prepareStatement(sql);
            stm.setString(1, menu);
            ResultSet res = stm.executeQuery();
            
            while(res.next()) {
                paket.add(mapToEntity(res));
            }
        } catch (SQLException e) {
        e.printStackTrace();
        }

        return paket;
    }
      

    @Override
    public Paket get(Integer id) {
        String sql = "SELECT * FROM " + tableName + " WHERE id = ?" ;

        Paket paket = new Paket();
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

        return paket;
    }

    @Override
    public boolean add(Paket paket) {
         String sql = "INSERT INTO "+ tableName +" (`menu`, `start`,`nama`,`deskripsi`,`minim_dp`,`harga`,`diskon`,`lama_paket`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
         try {
            Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement pst = koneksi.prepareStatement(sql);
            pst.setString(1, paket.getMenu());
            pst.setString(2, paket.getStart());
            pst.setString(3, paket.getNama()); 
            pst.setString(4, paket.getDeskripsi()); 
            pst.setInt(5, paket.getMinimDp()); 
            pst.setInt(6, paket.getHarga());
            pst.setInt(7, paket.getDiskon()); 
            pst.setInt(8, paket.getLamaPaket()); 
            pst.execute();
            return true;
        } catch (Exception e) {
             e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Paket paket) {
        String sql = "UPDATE "+ tableName +" SET start = ?, deskripsi = ?, nama= ? , menu = ?, minim_dp = ?, harga = ?, diskon = ?, menu = ?, lama_paket = ? WHERE id = ?";
        
        try {
                 Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement pst = koneksi.prepareStatement(sql);
            pst.setString(1, paket.getStart());
            pst.setString(2, paket.getDeskripsi()); 
            pst.setString(3, paket.getNama());
            pst.setString(4, paket.getMenu());
            pst.setInt(5, paket.getMinimDp()); 
            pst.setInt(6, paket.getHarga());
            pst.setInt(7, paket.getDiskon());
            pst.setString(8, paket.getMenu());
            pst.setInt(9, paket.getDiskon());
            pst.setInt(10, paket.getId());
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        String cekId = "SELECT keberangkatan.id AS idKeberangkatan, pemesanan.id AS idPemesanan, pengeluaran.id AS idPengeluaran, detail_pengeluaran.id AS idDetailPengeluaran, detail_pemesanan.id AS idDetailPemesanan FROM master_paket JOIN keberangkatan ON master_paket.id = keberangkatan.paket_id JOIN pemesanan ON keberangkatan.id = pemesanan.keberangkatan_id JOIN pengeluaran ON keberangkatan.id = pengeluaran.keberangkatan_id JOIN detail_pengeluaran ON pengeluaran.id = detail_pengeluaran.pengeluaran_id JOIN detail_pemesanan ON pemesanan.id = detail_pemesanan.pemesanan_id WHERE master_paket.id = "+id;
//        
//        
//      
           try {
                 Connection koneksi = (Connection)Conn.configDB();
                 Statement stm = koneksi.createStatement();
            ResultSet res = stm.executeQuery(cekId);
            if(res.next()){
                try {
                    int idKeberangkatan = res.getInt("idKeberangkatan");
                int idPemesanan = res.getInt("idPemesanan");
                int idPengeluaran = res.getInt("idPengeluaran");
                int idDetailPengeluaran = res.getInt("idDetailPengeluaran");
                int idDetailPemesanan = res.getInt("idDetailPemesanan");
                String sqlDelDetailPemesanan = "DELETE FROM detail_pemesanan WHERE id = "+idDetailPemesanan;
                String sqlDelDetailPengeluaran = "DELETE FROM detail_pengeluaran WHERE id = "+idDetailPengeluaran;
                String sqlDelPengeluaran = "DELETE FROM pengeluaran WHERE id = "+idPengeluaran;
                String sqlDelPemesanan = "DELETE FROM pemesanan WHERE id = "+idPemesanan;
                String sqldelKeberangkatan = "DELETE FROM keberangkatan WHERE id = "+idKeberangkatan;
                 String sqlDelPaket = "DELETE FROM "+ tableName +" WHERE id = "+id;
                 PreparedStatement pstDelDetailPengeluaran = koneksi.prepareStatement(sqlDelDetailPengeluaran);    
            pstDelDetailPengeluaran.execute();
            PreparedStatement pstDelDetailPemesanan = koneksi.prepareStatement(sqlDelDetailPemesanan);    
            pstDelDetailPemesanan.execute();
                PreparedStatement pstDelPengeluaran = koneksi.prepareStatement(sqlDelPengeluaran);    
            pstDelPengeluaran.execute();
            PreparedStatement pstDelPemesanan = koneksi.prepareStatement(sqlDelPemesanan);    
            pstDelPemesanan.execute();
                PreparedStatement pstDelKeberangkatan = koneksi.prepareStatement(sqldelKeberangkatan);    
            pstDelKeberangkatan.execute();
            PreparedStatement pstDelPaket = koneksi.prepareStatement(sqlDelPaket);    
            pstDelPaket.execute();
            return true;
                } catch (Exception e) {
                }
                
            }



            
    
//            
//            PreparedStatement pstDel = koneksi.prepareStatement(sqldelKeberangkatan);    
//            pstDel.executeUpdate();
//            PreparedStatement pst = koneksi.prepareStatement(sql);
//            pst.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
           return true;
    }

     
     private Paket mapToEntity(ResultSet result) throws SQLException {
         Paket paket = new Paket(
                 result.getString("menu"),
                 result.getString("start"),
                 result.getString("nama"),
                 result.getString("deskripsi"),
                 result.getInt("minim_dp"),
                 result.getInt("harga"),
                 result.getInt("diskon"),
                 result.getInt("lama_paket")
         );
        
        paket.setId(result.getInt("id"));
        return paket;
        }
}
