/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import entity.Pemesanan;
import entity.Pengeluaran;
import entity.User;
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
public class PengeluaranRepository implements Repository<Pengeluaran> {
    private static String tableName = Pengeluaran.tableName;
    @Override
    public List<Pengeluaran> get() {
          String sql = "SELECT * FROM " + tableName;
        List<Pengeluaran> pengeluaran = new ArrayList<>();
        try {
             Connection koneksi = (Connection)Conn.configDB();
            Statement stm = koneksi.createStatement();
            ResultSet res = stm.executeQuery(sql);
            
            while(res.next()) {
                pengeluaran.add(mapToEntity(res));
            }
        } catch (SQLException e) {
        e.printStackTrace();
        }

        return pengeluaran;
    }

    @Override
    public Pengeluaran get(Integer id) {
          String sql = "SELECT * FROM " + tableName + " WHERE id = ?" ;

        Pengeluaran pengeluaran = new Pengeluaran();
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
    public boolean add(Pengeluaran pengeluaran) {
             String sql = "INSERT INTO "+ tableName +" (`tanggal`, `keberangkatan_id`, `total_pengeluaran`) VALUES ( ?, ?, ?)";
         try {
            Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement pst = koneksi.prepareStatement(sql);
            pst.setDate(1, new Date(pengeluaran.getTanggal().getTime()));
            pst.setInt(2, pengeluaran.getKeberangkatan().getId());
            pst.setInt(3, pengeluaran.getTotalPengeluaran());
            pst.execute();
            return true;
        } catch (Exception e) {
             e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Pengeluaran pengeluaran) {
        String sql = "UPDATE "+ tableName +" SET tanggal = ?, keberangkatan_id = ?, total_pengeluaran = ? WHERE id = ?";
        
        try {
                 Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement pst = koneksi.prepareStatement(sql);
            pst.setDate(1, new Date(pengeluaran.getTanggal().getTime()));
            pst.setInt(2, pengeluaran.getKeberangkatan().getId());
            pst.setInt(3, pengeluaran.getTotalPengeluaran());
            pst.setInt(4, pengeluaran.getId());
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
     private Pengeluaran mapToEntity(ResultSet result) throws SQLException {
        Pengeluaran pengeluaran = new Pengeluaran(
                result.getInt("id"),
                new KeberangkatanRepository().get(result.getInt("keberangkatan_id")),
                result.getDate("tanggal"),
                result.getInt("total_pengeluaran"));
            return pengeluaran;
        }
}
