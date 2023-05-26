/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author WINDOWS 10
 */
public class DetailPengeluaran implements Entity{
    private int id;
    private Barang barang;
    private Pengeluaran pengeluaran;
    private int banyak;
    private int harga;
    public static String tableName = "detail_pengeluaran";
    
    public DetailPengeluaran(){};
    
    public DetailPengeluaran(Pengeluaran pengeluaran, Barang barang, int banyak, int harga){
        this.pengeluaran = pengeluaran;        
        this.barang = barang;
        this.banyak = banyak;
        this.harga = harga;
    }
    
     public void setBarang(Barang barang){
        this.barang = barang;
    }
    public Barang getBarang(){
        return barang;
    }
    
     public void setPengeluaran(Pengeluaran pengeluaran){
        this.pengeluaran = pengeluaran;
    }
    public Pengeluaran getPengeluaran(){
        return pengeluaran;
    }
    
     public void setBanyak(int banyak){
        this.banyak = banyak;
    }
    public int getBanyak(){
        return banyak;
    }
    
      public void setHarga(int harga){
        this.harga = harga;
    }
    public int getHarga(){
        return harga;
    }
    
       public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
}
