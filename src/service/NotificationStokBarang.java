/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entity.Barang;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import repository.BarangRepository;
import util.Conn;

/**
 *
 * @author adzaz
 */
public class NotificationStokBarang {
    BarangRepository barangRepo = new BarangRepository();
    public static boolean status ;
    
        public void notifBarang(){
        int minimStok = getMinimStok();
        for(Barang b:barangRepo.get()){
            if(b.getStok() <= minimStok){
                status = true;
                break;
            }
        }
    }
        public int getMinimStok(){
        int RataJamaah = 0;
           try {
            String sql = "SELECT DATE_FORMAT(pemesanan.tanggal, '%M') AS month, COUNT(jamaah_id) AS jmlJamaah FROM `pemesanan` GROUP BY YEAR(pemesanan.tanggal), MONTH(pemesanan.tanggal)" ;
        Connection koneksi = (Connection)Conn.configDB();
        Statement stm = koneksi.createStatement();
        ResultSet res = stm.executeQuery(sql);
        int jamaah = 0;
        int bulan = 0;
        while(res.next()){
            jamaah += res.getLong("jmlJamaah");
            bulan += 1;
        }
        RataJamaah = jamaah / bulan;
            return RataJamaah;
        } catch (Exception e) {
        }
           return RataJamaah;
    }
}
