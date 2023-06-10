/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import entity.DetailPengeluaran;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.Conn;

/**
 *
 * @author WINDOWS 10
 */
public class DetailPengeluaranRepository implements Repository<DetailPengeluaran>{
    private static String tableName = DetailPengeluaran.tableName;
    @Override
    public List<DetailPengeluaran> get() {
        String sql = "SELECT * FROM " + tableName;
        List<DetailPengeluaran> detailpengeluaran = new ArrayList<>();
        try {
             Connection koneksi = (Connection)Conn.configDB();
            Statement stm = koneksi.createStatement();
            ResultSet res = stm.executeQuery(sql);
            
            while(res.next()) {
                detailpengeluaran.add(mapToEntity(res));
            }
        } catch (SQLException e) {
        e.printStackTrace();
        }

        return detailpengeluaran;
    }
    
    public List<DetailPengeluaran> getById(Integer id) {
        String sql = "SELECT * FROM " + tableName + " WHERE pengeluaran_id = ?";
        List<DetailPengeluaran> detailpengeluaran = new ArrayList<>();
        try {
            Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement stm = koneksi.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet res = stm.executeQuery();
            
            while(res.next()) {
                detailpengeluaran.add(mapToEntity(res));
            }
        } catch (SQLException e) {
        e.printStackTrace();
        }

        return detailpengeluaran;
    }

    @Override
    public DetailPengeluaran get(Integer id) {
          
          String sql = "SELECT * FROM " + tableName + " WHERE id = ?" ;

        DetailPengeluaran pengeluaran = new DetailPengeluaran();
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

        return pengeluaran;
    }

    @Override
    public boolean add(DetailPengeluaran detailPengeluaran) {
        String sql = "INSERT INTO "+ tableName +" (`pengeluaran_id`, `barang_id`, `banyak`, `harga`) VALUES (?, ?, ?, ?)";
        try {
            Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement pst = koneksi.prepareStatement(sql);
            pst.setInt(1, detailPengeluaran.getPengeluaran().getId());
            pst.setInt(2, detailPengeluaran.getBarang().getId());
            pst.setInt(3, detailPengeluaran.getBanyak());
            pst.setInt(4, detailPengeluaran.getHarga()); 
            pst.execute();
            return true;
        } catch (Exception e) {
             e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(DetailPengeluaran detailPengeluaran) {
       String sql = "UPDATE "+ tableName +" SET pengeluaran_id = ?, barang_id = ?, banyak = ?, harga = ? WHERE pengeluaran_id = ?";
        
        try {
                 Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement pst = koneksi.prepareStatement(sql);
            pst.setInt(1, detailPengeluaran.getPengeluaran().getId());
            pst.setInt(2, detailPengeluaran.getBarang().getId());
            pst.setInt(3, detailPengeluaran.getBanyak());
            pst.setInt(4, detailPengeluaran.getHarga());
            pst.setInt(5, detailPengeluaran.getPengeluaran().getId());
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
    
      public boolean deleteAllById(int id) {
           String sql = "DELETE FROM "+ tableName +" WHERE pengeluaran_id = ?";
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
    
    private DetailPengeluaran mapToEntity(ResultSet result) throws SQLException {
        DetailPengeluaran detailPengeluaran = new DetailPengeluaran(
                new PengeluaranRepository().get(result.getInt("pengeluaran_id")),
                new BarangRepository().get(result.getInt("barang_id")),
                result.getInt("banyak"),
                result.getInt("harga"));
        detailPengeluaran.setId(result.getInt("id"));
        return detailPengeluaran;
        }
}
