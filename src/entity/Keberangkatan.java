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
public class Keberangkatan implements Entity{
    private int id;
    private Date tanggal;
    private Paket paket;
    public static String tableName = "keberangkatan";
    
    public Keberangkatan(){}
    public Keberangkatan(Paket paket, Date tanggal){
        this.paket = paket;
        this.tanggal = tanggal;
    }
    
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    
    public void setPaket(Paket paket){
        this.paket = paket;
    }
    public Paket getPaket(){
        return paket;
    }
    
    public void setTanggal(Date tanggal){
        this.tanggal = tanggal;
    }
    public Date getTanggal(){
        return tanggal;
    }
    
    
    
}



