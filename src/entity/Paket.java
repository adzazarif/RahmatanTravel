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
    private int paketId;
    private String start;
    private String namaPaket;
    private String rentangWaktu;
    private String deskripsi;
    private Date tglKeberangkatan;
    private int minimDp;
    private int harga;
    private int diskon;
    private Menu menu;
    private int totalMasuk;
    public static String tableName = "master_paket";
    
    public Paket(){
        
    }
        public Paket(Menu menu,String start, String namaPaket,String rentangWaktu,String deskripsi,Date tgl_kebberangkatan,int minimDp, int harga, int diskon){
        this.menu = menu;
        this.start = start;
        this.namaPaket = namaPaket;
        this.rentangWaktu = rentangWaktu;
        this.deskripsi = deskripsi;
        this.tglKeberangkatan = tgl_kebberangkatan;
        this.minimDp = minimDp;
        this.harga = harga;
        this.diskon = diskon;
    }
    public Paket(int paketId,String start, String namaPaket,String rentangWaktu,String deskripsi,Date tgl_kebberangkatan,int minimDp, int harga, int diskon){
        this.paketId = paketId;
        this.start = start;
        this.namaPaket = namaPaket;
        this.rentangWaktu = rentangWaktu;
        this.deskripsi = deskripsi;
        this.tglKeberangkatan = tgl_kebberangkatan;
        this.minimDp = minimDp;
        this.harga = harga;
        this.diskon = diskon;
    }
    
    public void setId(int id){
        this.paketId = id;
    }
    public int getId(){
        return this.paketId;
    }
    
    public void setMenu(Menu menu){
        this.menu = menu;
    }
    public Menu getMenu(){
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
    
      public void setTglKeberangkatan(Date tglKeberangkatan){
        this.tglKeberangkatan = tglKeberangkatan;
    }
    public Date getTglKeberangkatan(){
        return this.tglKeberangkatan;
    }
    
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
}
