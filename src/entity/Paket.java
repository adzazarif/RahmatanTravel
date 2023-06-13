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
public class Paket implements Entity{
    private String start,namaPaket,rentangWaktu,deskripsi,menu;
    private int id, minimDp,harga,diskon,totalMasuk, lamaPaket;
    public static String tableName = "master_paket";
    
    public Paket(){
        
    }
        public Paket(String menu, String start, String namaPaket,String deskripsi,int minimDp, int harga, int diskon, int lamaPaket){
        this.menu = menu;
        this.start = start;
        this.namaPaket = namaPaket;
        this.deskripsi = deskripsi;
        this.minimDp = minimDp;
        this.harga = harga;
        this.diskon = diskon;
        this.lamaPaket = lamaPaket;
    }
    public Paket(int paketId,String menu ,String start, String namaPaket,String deskripsi,int minimDp, int harga, int diskon){
        this.id = paketId;
        this.menu = menu;
        this.start = start;
        this.namaPaket = namaPaket;
        this.deskripsi = deskripsi;
        this.minimDp = minimDp;
        this.harga = harga;
        this.diskon = diskon;
    }
    
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    
    public void setMenu(String menu){
        this.menu = menu;
    }
    public String getMenu(){
        return menu;
    }
    public void setStart(String start){
        this.start = start;
    }
    public String getStart(){
        return this.start;
    }
    
    public void setNamaPaket(String nama){
        this.namaPaket = nama;
    }
    public String getNama(){
        return this.namaPaket;
    }
    
    public void setRentangWaktu(String rentangWaktu){
        this.rentangWaktu = rentangWaktu;
    }
    public String getRentangWaktu(){
        return this.rentangWaktu;
    }
    
    public void setDeskripsi(String deskripsi){
        this.deskripsi = deskripsi;
    }
    public String getDeskripsi(){
        return this.deskripsi;
    }
    
//      public void setTglKeberangkatan(Date tglKeberangkatan){
//        this.tglKeberangkatan = tglKeberangkatan;
//    }
//    public Date getTglKeberangkatan(){
//        return this.tglKeberangkatan;
//    }
    
    public void setMinimDp(int minimDp){
        this.minimDp = minimDp;
    }
    public int getMinimDp(){
        return this.minimDp;
    }
    
    public void setHarga(int harga){
        this.harga = harga;
    }
    public int getHarga(){
        return this.harga;
    }
    
    public void setDiskon(int diskon){
        this.diskon = diskon;
    }
    public int getDiskon(){
        return this.diskon;
    }
    
    public void setTotalMasuk(int totalMasuk){
        this.totalMasuk = totalMasuk;
    }
    public int getTotalMasuk(){
        return totalMasuk;
    }
    
     public void setLamaPaket(int lamaPaket){
        this.lamaPaket = lamaPaket;
    }
    public int getLamaPaket(){
        return lamaPaket;
    }
}
