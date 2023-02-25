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
public class DetailPemesanan {
    private int id;
    private Date tanggal;
    private int cicilan;
    private Pemesanan pemesanan;
    public DetailPemesanan(){
        
    }
    
    public DetailPemesanan(int id,Date tanggal,int cicilan,Pemesanan pemesanan){
        this.id = id;
        this.tanggal = tanggal;
        this.cicilan = cicilan;
        this.pemesanan = pemesanan;
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
}
