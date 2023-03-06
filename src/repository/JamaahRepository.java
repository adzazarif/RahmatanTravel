/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import entity.Jamaah;
import entity.Paket;
import entity.Pemesanan;
import entity.User;
import java.sql.Connection;
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
public class JamaahRepository implements Repository<Jamaah>{
    private static String tableName = Jamaah.tableName;
    @Override
    public List<Jamaah> get() {
        String sql = "SELECT * FROM " + tableName;
        List<Jamaah> jamaah = new ArrayList<>();
        try {
             Connection koneksi = (Connection)Conn.configDB();
            Statement stm = koneksi.createStatement();
            ResultSet res = stm.executeQuery(sql);
            
            while(res.next()) {
                jamaah.add(mapToEntity(res));
            }
        } catch (SQLException e) {
        e.printStackTrace();
        }

        return jamaah;
    }

    @Override
    public Jamaah get(Integer id) {
         String sql = "SELECT * FROM " + tableName + " WHERE nik = ?" ;
         
         Jamaah jamaah = new Jamaah();
         
        try {
             Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement stm = koneksi.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet res = stm.executeQuery(sql);

            while(res.next()) {
                return mapToEntity(res); 
            }
        } catch (SQLException e) {}

        return jamaah;
    }

    @Override
    public boolean add(Jamaah jamaah) {
         String sql = "INSERT INTO "+ tableName +" (`nama`, `jenis_kelamin`, `alamat`, `no_telp`) VALUES (?, ?, ?, ?)";
         try {
            Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement pst = koneksi.prepareStatement(sql);
            pst.setString(1, jamaah.getNama());
            pst.setString(2, jamaah.getJenisKelamin());
            pst.setString(3, jamaah.getAlamat());
            pst.setInt(4, jamaah.getNoTelp()); 
            pst.execute();
            return true;
        } catch (Exception e) {
             e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Jamaah jamaah) {
       
        String sql = "UPDATE "+ tableName +" SET nama = ?, jenis_kelamin = ?, alamat = ?, no_telp = ? WHERE nik = ?";
        
        try {
                 Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement pst = koneksi.prepareStatement(sql);
             pst.setString(1, jamaah.getNama());
            pst.setString(2, jamaah.getJenisKelamin());
            pst.setString(3, jamaah.getAlamat());
            pst.setInt(4, jamaah.getNoTelp()); 
            pst.setInt(5, jamaah.getNik());
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        
        }
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM "+ tableName +" WHERE nik = ?";
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
     private Jamaah mapToEntity(ResultSet result) throws SQLException {
        Jamaah jamaah = new Jamaah(
                result.getInt("nik"),
                result.getString("nama"),
                result.getString("jenis_kelamin"),
                result.getString("alamat"),
                result.getString("nmr_telp")
        );
        return jamaah;
        }
     
     public static void main(String[] args) {
        PemesananRepository p = new PemesananRepository();
        PaketRepository paket = new PaketRepository();
         for(Paket pmsn:paket.get()){
            System.out.println(pmsn.getNama());
            System.out.println(pmsn.getId());
            System.out.println(pmsn.getTotalMasuk());
        }
//        for(Pemesanan pmsn:p.get()){
//            System.out.println(pmsn.getJamaah().getNik());
//            System.out.println(pmsn.getId());
//            System.out.println(pmsn.getPaket().getNama());
//        }
    }
}
