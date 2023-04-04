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
public class Pengeluaran implements Entity{
    private int id;
    private Keberangkatan keberangkatan;
    private Date tanggal;
    private int totalPengeluaran;
    public static String tableName = "pengeluaran";
    public Pengeluaran(){};
    public Pengeluaran (int id, Keberangkatan keberangkatan, Date tanggal, int totalPengeluaran){
        this.id = id;
        this.keberangkatan = keberangkatan;
        this.tanggal = tanggal;
        this.totalPengeluaran = totalPengeluaran;
    }
    
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    
    public void setKeberangkatan(Keberangkatan keberangkatan){
        this.keberangkatan = keberangkatan;
    }
    public Keberangkatan getKeberangkatan(){
        return keberangkatan;
    }
    
    public void setTanggal(Date tanggal){
        this.tanggal = tanggal;
    }
    public Date getTanggal(){
        return tanggal;
    }
    
    public void setTotalPengeluaran(int totalPengeluaran){
        this.totalPengeluaran = totalPengeluaran;
    }
    public int getTotalPengeluaran(){
        return totalPengeluaran;
    }
}
