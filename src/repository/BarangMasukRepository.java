/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import entity.Barang;
import entity.BarangMasuk;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.Conn;

/**
 *
 * @author adzaz
 */
public class BarangMasukRepository implements Repository<BarangMasuk>{
private String tableName = BarangMasuk.tableName;
    @Override
    public List<BarangMasuk> get() {
              String sql = "SELECT * FROM " + tableName;
        List<BarangMasuk> barang = new ArrayList<>();
        try {
             Connection koneksi = (Connection)Conn.configDB();
            Statement stm = koneksi.createStatement();
            ResultSet res = stm.executeQuery(sql);
            
            while(res.next()) {
                barang.add(mapToEntity(res));
            }
        } catch (SQLException e) {
        e.printStackTrace();
        }

        return barang;
    }

    @Override
    public BarangMasuk get(Integer id) {
        String sql = "SELECT * FROM " + tableName + " WHERE id = ?";
        BarangMasuk barang = new BarangMasuk();
        try {
            Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement stm = koneksi.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet res = stm.executeQuery();
            
            while(res.next()) {
                return mapToEntity(res); 
            }
        } catch (SQLException e) {
            System.out.println("salah");
        e.printStackTrace();
        }

        return barang;
    }

    @Override
    public boolean add(BarangMasuk barang) {
          String sql = "INSERT INTO "+ tableName +" (`barang_id`, `tanggal`, `jumlah`) VALUES ( ?, ?, ?)";
         try {
            Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement pst = koneksi.prepareStatement(sql);
            pst.setInt(1, barang.getBarang().getId());
            pst.setDate(2, new Date(barang.getTanggal().getTime()));
            pst.setInt(3, barang.getJumlah());
            pst.execute();
            return true;
        } catch (Exception e) {
             e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(BarangMasuk barang) {
                String sql = "UPDATE "+ tableName +" SET barang_id = ?, tanggal = ?, jumlah = ?, password = ? WHERE id = ?";
        
        try {
                 Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement pst = koneksi.prepareStatement(sql);
            pst.setInt(1, barang.getBarang().getId());
            pst.setDate(2, new Date(barang.getTanggal().getTime()));
            pst.setInt(3, barang.getJumlah());
            pst.setInt(4, barang.getId());
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
    
       private BarangMasuk mapToEntity(ResultSet result) throws SQLException {
        BarangMasuk barang = new BarangMasuk(
            new BarangRepository().get(result.getInt("barang_id")),
            result.getDate("tanggal"),
            result.getInt("jumlah")
        );
        barang.setId(result.getInt("id"));
        return barang;
        }
}
