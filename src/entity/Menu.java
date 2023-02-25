/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author WINDOWS 10
 */
public class Menu implements Entity{
    private int id;
    private String nama;
    public static String tableName = "menu";
    
    public Menu(){};
    public Menu(int id, String nama){
        this.id = id;
        this.nama = nama;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    
    public void setNama(String nama){
        this.nama = nama;
    }
    public String getNama(){
        return nama;
    }
}
