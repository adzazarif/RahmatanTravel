/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.Conn;
import entity.User;

/**
 *
 * @author WINDOWS 10
 */
public class UserRepository implements Repository<User>{
    private static String tableName = User.tableName;
    @Override
    public List<User> get() {
        String sql = "SELECT * FROM " + tableName;
        List<User> user = new ArrayList<>();
        try {
             Connection koneksi = (Connection)Conn.configDB();
            Statement stm = koneksi.createStatement();
            ResultSet res = stm.executeQuery(sql);
            
            while(res.next()) {
                user.add(mapToEntity(res));
            }
        } catch (SQLException e) {
        e.printStackTrace();
        }

        return user;
    }

     public List<User> getById(Integer id) {
        String sql = "SELECT * FROM " + tableName + " WHERE id = ?";
        List<User> user = new ArrayList<>();
        try {
                  Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement stm = koneksi.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet res = stm.executeQuery();
            
            while(res.next()) {
                user.add(mapToEntity(res));
            }
        } catch (SQLException e) {
        e.printStackTrace();
        }

        return user;
    }
     
      public List<User> getByIdCard(String id) {
        String sql = "SELECT * FROM " + tableName + " WHERE id_card = ?";
        List<User> user = new ArrayList<>();
        try {
                  Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement stm = koneksi.prepareStatement(sql);
            stm.setString(1, id);
            ResultSet res = stm.executeQuery();
            
            while(res.next()) {
                user.add(mapToEntity(res));
            }
        } catch (SQLException e) {
        e.printStackTrace();
        }

        return user;
    }
     
    @Override
    public User get(Integer id) {
       String sql = "SELECT * FROM " + tableName + " WHERE id = ?" ;

        User user = new User();
        try {
             Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement stm = koneksi.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet res = stm.executeQuery();

            while(res.next()) {
                return mapToEntity(res); 
            }
        } catch (SQLException e) {}

        return user;
    }


    @Override
    public boolean add(User user) {
            String sql = "INSERT INTO "+ tableName +" (`nama`, `username`, `role`, `password`,`email`,`alamat`,`no_telp`,`foto`,`jenis_kelamin`,`id_card`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
         try {
            Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement pst = koneksi.prepareStatement(sql);
            pst.setString(1, user.getNama());
            pst.setString(2, user.getUsername());
            pst.setString(3, user.getRole());
            pst.setString(4, user.getPassword()); 
            pst.setString(5, user.getEmail()); 
            pst.setString(6, user.getAlamat()); 
            pst.setString(7, user.getNoTelp()); 
            pst.setString(8, user.getFoto()); 
            pst.setString(9, user.getJenisKelamin()); 
            pst.setString(10, user.getICard());
            pst.execute();
            return true;
        } catch (Exception e) {
             e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(User user) {

        String sql = "UPDATE "+ tableName +" SET nama = ?, username = ?, role = ?, password = ?, email = ?, alamat = ?, no_telp = ?, foto = ?, jenis_kelamin = ?, id_card = ? WHERE id = ?";
        
        try {
                 Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement pst = koneksi.prepareStatement(sql);
            pst.setString(1, user.getNama());
            pst.setString(2, user.getUsername());
            pst.setString(3, user.getRole());
            pst.setString(4, user.getPassword());
            pst.setString(5, user.getEmail());
            pst.setString(6, user.getAlamat());
            pst.setString(7, user.getNoTelp());
            pst.setString(8, user.getFoto());
            pst.setString(9, user.getJenisKelamin());
            pst.setString(10, user.getICard());
            pst.setInt(11, user.getId());
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
    
        private User mapToEntity(ResultSet result) throws SQLException {
        User user = new User(
            result.getString("nama"),
            result.getString("username"),
            result.getString("password"),
            result.getString("role"),
            result.getString("email"),
            result.getString("alamat"),
            result.getString("no_telp"),
            result.getString("foto"),
            result.getString("jenis_kelamin"),
             result.getString("id_card")
        );

        user.setId(result.getInt("id"));
        return user;
        }
        
//        public static void main(String[] args) {
//            User usr = new User(9,"bagas uppdated","ari123","employee","ari");
            
//            UserRepository user = new UserRepository();
//            
//            if(user.delete(9)){
//                System.out.println("berhasil");
//            }else{
//                System.out.println("gagal");
//            }
//    
//        for(User usr:user.get()){
//            System.out.print(usr.getNama()+" "+usr.getUsername());
//            System.out.println("");
//        }
//    }
}
