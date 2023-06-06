/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author adzaz
 */
public class DataChartLine {
     private String month;
    private int amountUmrah, amounthaji, amountWisata;
    public void DataChartLine(){};
    public DataChartLine(String month, int amountUmrah,int amountHaji,int amountWisata){
        this.month = month;
        this.amountUmrah = amountUmrah;
        this.amounthaji = amountHaji;
        this.amountWisata = amountWisata;
    }
    
    public void setMonth(String month){
        this.month = month;
    }
    public String getMonth(){
        return month;
    }
    
    public void setAmountUmrah(int amountUmrah){
        this.amountUmrah = amountUmrah;
    }
    public int getAmounthUmrah(){
        return amountUmrah;
    }
    
    public void setAmountHaji(int amountHaji){
        this.amounthaji = amountHaji;
    }
    public int getAmounthHaji(){
        return amounthaji;
    }
    
    public void setAmountWisata(int amountWisata){
        this.amountWisata = amountWisata;
    }
    public int getAmounthWisata(){
        return amountWisata;
    }
    
}
