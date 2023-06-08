/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import util.Conn;
/**
 *
 * @author WINDOWS 10
 */
public class Auth {
    public static String username ;
    public static String level;
    
    
  public boolean login(String username, String pass){
        try {
            String query = "SELECT * FROM user WHERE username ='"+ username +"' AND password ='" + pass + "'";
            Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement pst = koneksi.prepareStatement(query);
            ResultSet res = pst.executeQuery();
            if(res.next()){
                level = res.getString("role");
                return true;
            }else{
                  return false;
            }
        } catch (Exception e) {
                return false;
        }
    }
  
  public boolean rememberPass(int token, int id){
      try {
            String query = "SELECT * FROM user WHERE token ='"+ token +"' AND id ='" + id + "'";
            Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement pst = koneksi.prepareStatement(query);
            ResultSet res = pst.executeQuery();
            if(res.next()){

                return true;
            }else{
                  return false;
            }
      } catch (Exception e) {
          return false;
      }
  }
  public void kirimTokenDB(String Username, String token){
       String sql = "UPDATE user SET token = ? WHERE username = ?";
        try {
                 Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement pst = koneksi.prepareStatement(sql);
             
            pst.setString(1, token);
            pst.setString(2, Username);
            
            pst.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        
        }
  }
  public void hapusToken(String username){
      String token = "";
      
      String sql = "UPDATE user SET token = ? WHERE username = ?";
        try {
                 Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement pst = koneksi.prepareStatement(sql);
            pst.setString(1, token);
             pst.setString(2, username);
            
            
            pst.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        
        }
  }
  public boolean changePass(String pass, String confirmPass, String username){

         String sql = "UPDATE user SET password = ? WHERE username = ?";
        try {
                 Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement pst = koneksi.prepareStatement(sql);
             pst.setString(1, pass);
            pst.setString(2, username);
            
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        
        }
      
  }
 
}
