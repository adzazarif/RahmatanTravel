/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author adzaz
 */
public class DataChartBar {
        private String month;
    private int pengeluaran, pemasukan,labaBersih,labaKotor;

    public DataChartBar(String month, int pemasukan, int pengeluaran, int labaBersih, int labaKotor) {
        this.month = month;
        this.pemasukan = pemasukan;
        this.pengeluaran = pengeluaran;
        this.labaBersih = labaBersih;
        this.labaKotor = labaKotor;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getPemasukan() {
        return pemasukan;
    }

    public void setPemasukan(int pemasukan) {
        this.pemasukan = pemasukan;
    }
    
     public int getPengeluaran() {
        return pengeluaran;
    }

    public void setPengeluaran(int pengeluaran) {
        this.pengeluaran = pengeluaran;
    }

        public int getLabaBersih() {
        return labaBersih;
    }

    public void setLabaBersih(int labaBersih) {
        this.labaBersih = labaBersih;
    }
    
         public int getLabaKotor() {
        return labaKotor;
    }

    public void setLabaKotor(int labaKotor) {
        this.labaKotor = labaKotor;
    }

}
