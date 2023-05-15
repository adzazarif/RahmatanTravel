/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;


/**
 *
 * @author WINDOWS 10
 */
public class User implements Entity{
    public static String tableName = "user";
      private int id;
    private String nama;
    private String username;
    private String password;
    private String role;
    private String email;
    private String alamat;
    private String noTelp;
    private String foto;
    
    
    public User(){
        
    }
     public User(String nama,String username,String role,String pass,String email, String alamat, String noTelp, String foto){
        this.nama = nama;
        this.username = username;
        this.password = pass;
        this.role = role;
        this.email = email;
        this.alamat = alamat;
        this.noTelp = noTelp;
        this.foto = foto;
        
    }
    public User(int id,String nama,String username,String role,String pass){
        this.id = id;
        this.nama = nama;
        this.username = username;
        this.password = pass;
        this.role = role;
        
    }
    
     public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    
     public void setNama(String nama){
        this.nama = nama;
    }
    public String getNama(){
        return this.nama;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    public String getUsername(){
        return this.username;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return this.password;
    }
    
    public void setRole(String role){
        this.role = role;
    }
    public String getRole(){
        return this.role;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }
    
    public void setAlamat(String alamat){
        this.alamat = alamat;
    }
    public String getAlamat(){
        return alamat;
    }
    
    public void setNoTelp(String noTelp){
        this.noTelp = noTelp;
    }
    public String getNoTelp(){
        return noTelp;
    }
    
    public void setFoto(String foto){
        this.foto = foto;
    }
    public String getFoto(){
        return foto;
    }
}
