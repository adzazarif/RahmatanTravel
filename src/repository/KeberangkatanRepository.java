/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import entity.Keberangkatan;
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
            
            if(res.next()){
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
           String sql = "INSERT INTO "+ tableName +" (`paket_id`, `tanggal`) VALUES (?, ?)";
         try {
            Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement pst = koneksi.prepareStatement(sql);
            pst.setInt(1, keberangkatan.getPaket().getId());
            pst.setDate(2, new Date(keberangkatan.getTanggal().getTime()));
            pst.execute();
            return true;
        } catch (Exception e) {
             e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Keberangkatan keberangkatan) {
        String sql = "UPDATE "+ tableName +" SET paket_id = ?, tanggal = ? WHERE id = ?";
        
        try {
                 Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement pst = koneksi.prepareStatement(sql);
            pst.setInt(1, keberangkatan.getPaket().getId());
            pst.setDate(2, new Date(keberangkatan.getTanggal().getTime()));
            pst.setInt(3, keberangkatan.getId()); 
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
                result.getDate("tanggal"));
        keberangkatan.setId(result.getInt("id"));
        return keberangkatan;
    }
    
}
