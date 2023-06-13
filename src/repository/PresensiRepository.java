/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import entity.Keberangkatan;
import entity.Presensi;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import util.Conn;

/**
 *
 * @author adzaz
 */
public class PresensiRepository implements Repository<Presensi>{

    private String tableName = Presensi.tableName;
    @Override
    public List<Presensi> get() {
          String sql = "SELECT * FROM "+tableName;
        List<Presensi> presensi = new ArrayList<>();
        
        try {
            Connection koneksi = (Connection)Conn.configDB();
            Statement stm = koneksi.createStatement();
            ResultSet res = stm.executeQuery(sql);
            
            while(res.next()){
                presensi.add(mapToEntity(res));
            }
        } catch (Exception e) {
        }
        return presensi;
    }

    public boolean checkData(int id, String startDate, String endDate){
             String sql = "SELECT * FROM "+tableName+" WHERE user_id = ? AND tanggal BETWEEN ? AND ?";
        Presensi presensi = new Presensi();
         
        try {
             Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement stm = koneksi.prepareStatement(sql);
            stm.setInt(1, id);
            stm.setString(2, startDate);
            stm.setString(3, endDate);
            ResultSet res = stm.executeQuery();

            if(res.next()){
                return true;
            }else{
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        
    }
    @Override
    public Presensi get(Integer id) {
             String sql = "SELECT * FROM "+tableName+" WHERE id = ?";
        Presensi presensi = new Presensi();
         
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

        return presensi;
    }

    @Override
    public boolean add(Presensi presensi) {
             String sql = "INSERT INTO "+ tableName +" (`user_id`, `tanggal`, `keterangan`) VALUES (?, ?, ?)";
         try {
            Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement pst = koneksi.prepareStatement(sql);
            pst.setInt(1, presensi.getUser().getId());
            pst.setTimestamp(2, new Timestamp(presensi.getWaktuPresensi().getTime()));
            pst.setString(3, presensi.getKeterangan());
            pst.execute();
            return true;
        } catch (Exception e) {
             e.printStackTrace();
            return false;
        }
    }
    


    @Override
    public boolean update(Presensi presensi) {
         String sql = "UPDATE "+ tableName +" SET user_id = ?, tanggal = ?, keterangan = ? WHERE id = ?";
        
        try {
                 Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement pst = koneksi.prepareStatement(sql);
            pst.setInt(1, presensi.getUser().getId());
            pst.setDate(2, new Date(presensi.getWaktuPresensi().getTime()));
            pst.setString(3, presensi.getKeterangan());
            pst.setInt(4, presensi.getId()); 
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
    
     private Presensi mapToEntity(ResultSet result)throws SQLException{
         Presensi presensi = new Presensi(
                 new UserRepository().get(result.getInt("user_id")),
                 result.getTimestamp("tanggal"),
                 result.getString("keterangan"));
        presensi.setId(result.getInt("id"));
        return presensi;
    }
}
