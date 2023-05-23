/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import entity.Pemesanan;
import entity.PengeluaranOperasional;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;
import util.Conn;

/**
 *
 * @author adzaz
 */
public class PengeluaranOperasionalRepository implements Repository<PengeluaranOperasional>{
    private static String tableName = PengeluaranOperasional.tableName;
    @Override
    public List<PengeluaranOperasional> get() {
             String sql = "SELECT * FROM " + tableName;
        List<PengeluaranOperasional> pengeluaranOperasional = new ArrayList<>();
        try {
             Connection koneksi = (Connection)Conn.configDB();
            Statement stm = koneksi.createStatement();
            ResultSet res = stm.executeQuery(sql);
            
            while(res.next()) {
                pengeluaranOperasional.add(mapToEntity(res));
            }
        } catch (SQLException e) {
        e.printStackTrace();
        }

        return pengeluaranOperasional;
    }
    
      public List<PengeluaranOperasional> getById(Integer id) {
             String sql = "SELECT * FROM " + tableName + " WHERE id = ?";
        List<PengeluaranOperasional> pengeluaranOperasional = new ArrayList<>();
        try {
           Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement stm = koneksi.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet res = stm.executeQuery();
            
            while(res.next()) {
                pengeluaranOperasional.add(mapToEntity(res));
            }
        } catch (SQLException e) {
        e.printStackTrace();
        }

        return pengeluaranOperasional;
    }

    @Override
    public PengeluaranOperasional get(Integer id) {
                 String sql = "SELECT * FROM " + tableName + " WHERE id = ?" ;

        PengeluaranOperasional pengeluaranOperasional = new PengeluaranOperasional();
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

        return pengeluaranOperasional;
    }

    @Override
    public boolean add(PengeluaranOperasional pengeluaranOp) {
          String sql = "INSERT INTO "+ tableName +" (`nama_pengeluaran`, `jumlah`, `tanggal`, `deskripsi`) VALUES (?, ?, ?, ?)";
         try {
            Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement pst = koneksi.prepareStatement(sql);
            pst.setString(1, pengeluaranOp.getNamaPengeluaran());
            pst.setInt(2, pengeluaranOp.getJumlah());
            pst.setDate(3, new Date(pengeluaranOp.getTanggal().getTime()));
            pst.setString(4, pengeluaranOp.getDeskripsi());
            pst.execute();
            return true;
        } catch (Exception e) {
             e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(PengeluaranOperasional pengeluaranOp) {
        String sql = "UPDATE "+ tableName +" SET nama_pengeluaran = ?, jumlah = ?, tanggal = ?, deskripsi = ? WHERE id = ?";
        
        try {
                 Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement pst = koneksi.prepareStatement(sql);
             pst.setString(1, pengeluaranOp.getNamaPengeluaran());
            pst.setInt(2, pengeluaranOp.getJumlah());
            pst.setDate(3, new Date(pengeluaranOp.getTanggal().getTime()));
            pst.setString(4, pengeluaranOp.getDeskripsi());
            pst.setInt(5, pengeluaranOp.getId());
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
    
       private PengeluaranOperasional mapToEntity(ResultSet result) throws SQLException {
        PengeluaranOperasional pengeluaranOperasional = new PengeluaranOperasional(
            result.getString("nama_pengeluaran"),
            result.getInt("jumlah"),
            result.getDate("tanggal"),
            result.getString("deskripsi")
        );

        pengeluaranOperasional.setId(result.getInt("id"));
        return pengeluaranOperasional;
        }
    
}
