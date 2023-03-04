/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author WINDOWS 10
 */
public class Pemesanan implements Entity{
    private int id;
    private Date tanggal;
    private String jenisPembayaran;
    private int totalTagihan;
    private int jumlahBayar;
    private Jamaah jamaah;
    private Paket paket;
    public static String tableName = "pemesanan";
    public Pemesanan(){
        
    }
    public Pemesanan(int id,Paket paket, Jamaah jamaah, Date tanggal,String jenisPembayaran,int totalTagihan, int jumlahBayar){
        this.id = id;
        this.jamaah = jamaah;
        this.paket = paket;
        this.tanggal = tanggal;
        this.jenisPembayaran = jenisPembayaran;
        this.jumlahBayar = jumlahBayar;
        this.totalTagihan = totalTagihan;
    }
    public Pemesanan(Paket paket, Jamaah jamaah,String jenisPembayaran, Date tanggal,int totalTagihan, int jumlahBayar){
        this.id = id;
        this.jamaah = jamaah;
        this.paket = paket;
        this.tanggal = tanggal;
        this.jenisPembayaran = jenisPembayaran;
        this.jumlahBayar = jumlahBayar;
        this.totalTagihan = totalTagihan;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return  this.id;
    }
    
    public void setPaket(Paket paket){
        this.paket = paket;
    }
    public Paket getPaket(){
        return paket;
    }
    
    public void setJamaah(Jamaah jamaah){
        this.jamaah = jamaah;
    }
    public Jamaah getJamaah(){
        return jamaah;
    }
    
    public void setTanggal(Date tanggal){
        this.tanggal = tanggal;
    }
    public Date getTanggal(){
        return  tanggal;
    }
    
    public void setTotalTagihan(int totalTagihan){
        this.totalTagihan = totalTagihan;
    }
    public int getTotalTagihan(){
        return  this.totalTagihan;
    }
    
    public void setJumlBayar(int jumlahBayar){
        this.jumlahBayar = jumlahBayar;
    }
    public int getJumlahBayar(){
        return  this.jumlahBayar;
    }
    
     public void setJenisPembayaran(String jenisPembayaran){
        this.jenisPembayaran = jenisPembayaran;
    }
    public String getJenisPembayaran(){
        return jenisPembayaran;
    }
}
