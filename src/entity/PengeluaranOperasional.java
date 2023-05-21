/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author adzaz
 */
public class PengeluaranOperasional implements Entity{
    private String namaPengeluaran;
    private int jumlah;
    private Date tanggal;
    private String deskripsi;
    private int id;
    public static String tableName = "pengeluaran_operasional";
    
    public PengeluaranOperasional(){};
    public PengeluaranOperasional(String namaPengeluaran, int jumlah, Date tanggal, String deskripsi){
    this.namaPengeluaran = namaPengeluaran;
    this.jumlah = jumlah;
    this.tanggal = tanggal;
    this.deskripsi = deskripsi;
}
    
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    
    public void setjumlah(int jumlah){
        this.jumlah = jumlah;
    }
    public int getJumlah(){
        return jumlah;
    }
    
    public void setNamaPengeluaran(String namaPengeluaran){
        this.namaPengeluaran = namaPengeluaran;
    }
    public String getNamaPengeluaran(){
        return namaPengeluaran;
    }
    
    public void setDeskripsi(String deskripsi){
        this.deskripsi = deskripsi;
    }
    public String getDeskripsi(){
        return deskripsi;
    }
    
    public void setTanggal(Date tanggal){
        this.tanggal = tanggal;
    }
    public Date getTanggal(){
        return tanggal;
    }
}
