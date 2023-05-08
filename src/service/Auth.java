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
  public boolean login(String username, String pass){
        try {
            String query = "SELECT * FROM user WHERE username ='"+ username +"' AND password ='" + pass + "'";
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
  
  public boolean changePass(String pass, String confirmPass, int nik){
      if(pass == confirmPass){
         String sql = "UPDATE user SET password = ? WHERE nik = ?";
        try {
                 Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement pst = koneksi.prepareStatement(sql);
             pst.setString(1, pass);
            pst.setInt(2, nik);
            
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        
        }
      }else{
          return false;
      }
  }
 
//  public void deleteToken(){
//      up
//  }
}
