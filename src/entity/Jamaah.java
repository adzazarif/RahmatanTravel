/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;


/**
 *
 * @author WINDOWS 10
 */
public class Jamaah implements Entity{
     private int nik;
    private String nama;
    private String jenisKelamin;
    private String alamat;
    private String noTelp;
    private int ammountJammah;
    public static String tableName = "jamaah";
    
    public Jamaah(){
        
    }
    
    public Jamaah(int nik, String nama, String jenisKelamin, String alamat, String noTelp){
        this.nik = nik;
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.alamat = alamat;
        this.noTelp = noTelp;
    }
    
    public void setNik(int nik){
        this.nik = nik;
    }
    public int getNik(){
        return this.nik;
    }
    
    public void setNama(String nama){
        this.nama = nama;
    }
    public String getNama(){
        return this.nama;
    }
    
    public void setJenisKelamin(String jenisKelamin){
        this.jenisKelamin = jenisKelamin;
    }
    public String getJenisKelamin(){
        return this.jenisKelamin;
    }
    
    public void setAlamat(String alamat){
        this.alamat = alamat;
    }
    public String getAlamat(){
        return this.alamat;
    }
    
    public void setNoTelp(String noTelp){
        this.noTelp = noTelp;
    }
    public int getNoTelp(){
        return this.nik;
    }
}
