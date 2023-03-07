/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import entity.DetailPengeluaran;
import java.util.List;

/**
 *
 * @author WINDOWS 10
 */
public class DetailPengeluaranRepository implements Repository<DetailPengeluaran>{

    @Override
    public List<DetailPengeluaran> get() {
        String sql = "SELECT * FROM " + tableName;
        List<Pemesanan> pemesanan = new ArrayList<>();
        try {
             Connection koneksi = (Connection)Conn.configDB();
            Statement stm = koneksi.createStatement();
            ResultSet res = stm.executeQuery(sql);
            
            while(res.next()) {
                pemesanan.add(mapToEntity(res));
            }
        } catch (SQLException e) {
        e.printStackTrace();
        }

        return pemesanan;
    }

    @Override
    public DetailPengeluaran get(Integer id) {
          String sql = "INSERT INTO "+ tableName +" (`pengeluaran_id`, `barang_id`, `jenis_pembayaran`, `banyak`, `harga`) VALUES (?, ?, ?, ?)";
    }

    @Override
    public boolean add(DetailPengeluaran entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(DetailPengeluaran entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
