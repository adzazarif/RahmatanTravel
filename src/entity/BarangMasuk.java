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
public class BarangMasuk implements Entity{
    private int jumlah;
    private Date tanggal;
    private Barang barang;
    private int id;
    public static String tableName = "barang_masuk";
    public BarangMasuk(){};
    public BarangMasuk(Barang barang, Date tanggal, int jumlah){
        this.jumlah = jumlah;
        this.tanggal = tanggal;
        this.barang = barang;
    }
    
    public void setId(int jumlah){
        this.jumlah = jumlah;
    }
    public int getId(){
        return id;
    }
    
    public void setJumlah(int jumlah){
        this.jumlah = jumlah;
    }
    public int getJumlah(){
        return jumlah;
    }
    
    public void setBarang(Barang barang){
        this.barang = barang;
    }
    public Barang getBarang(){
        return barang;
    }
    
    public void setTanggal(Date tanggal){
        this.tanggal = tanggal;
    }
    public Date getTanggal(){
        return tanggal;
    }
}
