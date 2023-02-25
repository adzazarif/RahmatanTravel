/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author WINDOWS 10
 */
public class Pemesanan implements Entity{
    private int id;
    private String tanggal;
    private String pemesanan;
    private int totalTagihan;
    private int jumlahBayar;
    private Jamaah jamaah;
    private Paket paket;
    public Pemesanan(){
        
    }
    public Pemesanan(int id,Paket paket, Jamaah jamaah, String tanggal,String pemesanan,int totalTagihan, int jumlahBayar){
        this.id = id;
        this.jamaah = jamaah;
        this.paket = paket;
        this.tanggal = tanggal;
        this.pemesanan = pemesanan;
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
    
    public void setTanggal(String tanggal){
        this.tanggal = tanggal;
    }
    public String getTanggal(){
        return  this.tanggal;
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
}
