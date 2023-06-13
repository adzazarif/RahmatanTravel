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
public class Presensi implements Entity{
    private User user;
    private int id;
    private String keterangan;
    private Date waktuPresensi;
    public static String tableName = "absensi";
    public static String StartPresensi = "11:04:00";
    public static String EndPresensi = "11:06:30";
    public static String LatePresensi = "11:05:00";
    public Presensi(){}
    
    public Presensi(User user, Date waktuPresensi, String keterangan){
        this.user = user;
        this.waktuPresensi = waktuPresensi;
        this.keterangan = keterangan;
    }
    
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    
    public void setUser(User user){
        this.user = user;
    }
    public User getUser(){
        return user;
    }
    
    public void setWaktuPresensi(Date waktuPresensi){
        this.waktuPresensi = waktuPresensi;
    }
    public Date getWaktuPresensi(){
        return waktuPresensi;
    }
    
    public void setKeterangan(String keterangan){
        this.keterangan = keterangan;
    }
    public String getKeterangan(){
        return keterangan;
    }
}
