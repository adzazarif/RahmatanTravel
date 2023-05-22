/*
 * Click nbfs://nbhoest/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author WINDOWS 10
 */
public class DetailPemesanan implements Entity{
    private int id;
    private Date tanggal;
    private int cicilan;
    private Pemesanan pemesanan;
    public static String tableName = "detail_pemesanan";
    
    public DetailPemesanan(){
        
    }
    
    public DetailPemesanan(Pemesanan pemesanan,Date tanggal,int cicilan){
        
         this.pemesanan = pemesanan;
        this.tanggal = tanggal;
        this.cicilan = cicilan;
       
    }
    
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    
    public void setTanggal(Date tanggal){
        this.tanggal = tanggal;
    }
    public Date getTanggal(){
        return tanggal;
    }
    
    public void setCicilan(int cicilan){
        this.cicilan = cicilan;
    }
    public int getCicilan(){
        return cicilan;
    }
    
    public Pemesanan getPemesanan(){
        return pemesanan;
    }
    public void setPemesanan(Pemesanan pemesanan){
        this.pemesanan = pemesanan;
    }
        
}
