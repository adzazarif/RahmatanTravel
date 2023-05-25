/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;
import entity.Barang;
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
public class BarangRepository implements Repository<Barang>{
    private static String tableName = Barang.tableName;
    @Override
    public List<Barang> get() {
            String sql = "SELECT * FROM " + tableName;
        List<Barang> barang = new ArrayList<>();
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
    
     public List<Barang> getById(Integer id) {
            String sql = "SELECT * FROM " + tableName + " WHERE id = ?";
        List<Barang> barang = new ArrayList<>();
        try {
            Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement stm = koneksi.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet res = stm.executeQuery();
            
            while(res.next()) {
                barang.add(mapToEntity(res));
            }
        } catch (SQLException e) {
            System.out.println("salah");
        e.printStackTrace();
        }

        return barang;
    }

    @Override
    public Barang get(Integer id) {
       String sql = "SELECT * FROM " + tableName + " WHERE id = ?" ;

        Barang barang = new Barang();
        try {
             Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement stm = koneksi.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet res = stm.executeQuery();

            while(res.next()) {
                return mapToEntity(res); 
            }
        } catch (SQLException e) {}

        return barang; 
    }

    @Override
    public boolean add(Barang barang) {
         String sql = "INSERT INTO "+ tableName +" (`nama`, `stok`, `harga`) VALUES ( ?, ?, ?)";
         try {
            Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement pst = koneksi.prepareStatement(sql);
            pst.setString(1, barang.getNama());
            pst.setInt(2, barang.getStok());
            pst.setInt(3, barang.getHarga());
            pst.execute();
            return true;
        } catch (Exception e) {
             e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Barang barang) {
        String sql = "UPDATE "+ tableName +" SET nama = ?, stok = ?, harga = ?, password = ? WHERE id = ?";
        
        try {
                 Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement pst = koneksi.prepareStatement(sql);
            pst.setString(1, barang.getNama());
            pst.setInt(2, barang.getStok());
            pst.setInt(3, barang.getHarga());
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
    
     private Barang mapToEntity(ResultSet result) throws SQLException {
        Barang barang = new Barang(
            result.getInt("id"),
            result.getString("nama"),
            result.getInt("stok"),
            result.getInt("harga")
        );

        return barang;
        }
}
