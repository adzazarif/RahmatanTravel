/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;


/**
 *
 * @author WINDOWS 10
 */
public class Barang implements Entity{
    public static String tableName = "barang";
        private int id;
    private String nama, foto;
    private int stok;
    private int harga;
    private int ammountBarang;
    private int subTotal;
    
    public Barang(){
        
    }
    public Barang( String nama,int stok,int harga, String foto){
        this.id = id;
        this.nama = nama;
        this.stok = stok;
        this.harga = harga;
        this.foto = foto;
    }
    public Barang(int id, String nama,int stok,int harga, int subTotal){
        this.id = id;
        this.nama = nama;
        this.stok = stok;
        this.harga = harga;
        this.subTotal = subTotal;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    
    public void setNama(String nama){
        this.nama = nama;
    }
    public String getNama(){
        return this.nama;
    }
    
       public void setFoto(String foto){
        this.foto = foto;
    }
    public String getFoto(){
        return this.foto;
    }
    
    public void setStok(int stok){
        this.stok = stok;
    }
    public int getStok(){
        return this.stok;
    }
    
    public void setHarga(int harga){
        this.harga = harga;
    }
    public int getHarga(){
        return this.harga;
    }
    public void setSubTotal(int subDiskon){
        this.subTotal = subTotal;
    }
    public int getSubTotal(){
        return this.subTotal;
    }
}
