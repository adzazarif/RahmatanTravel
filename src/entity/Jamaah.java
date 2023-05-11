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
    private int ammountJammahMale;
    private int ammountJammahFemale;
    public static String tableName = "jamaah";
    
    public Jamaah(){
        
    }
    
    public Jamaah(String nama, String jenisKelamin, String alamat, String noTelp){
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
        return nama;
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
    public String getNoTelp(){
        return this.noTelp;
    }
    
     public void setAmountJamaah(int amountJamaah){
        this.ammountJammah = amountJamaah;
    }
    public int getAmountJamaah(){
        return ammountJammah;
    }
    
    public void setAmountJamaahMale(int amountJamaahMale){
        this.ammountJammahMale = amountJamaahMale;
    }
    public int getAmountJamaahMale(){
        return ammountJammahMale;
    }
    
    public void setAmountJamaahFemale(int amountJamaahFemale){
        this.ammountJammahFemale = amountJamaahFemale;
    }
    public int getAmountJamaahFemale(){
        return ammountJammahFemale;
    }
}
