
package repository;

import entity.DetailPemesanan;
import entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
//import java.util.Date;
import java.util.List;
import java.sql.Date;
import util.Conn;


public class DetailPemesananRepository implements Repository<DetailPemesanan>{
    private static String tableName = DetailPemesanan.tableName;
    @Override
    public List<DetailPemesanan> get() {
         String sql = "SELECT * FROM " + tableName;
        List<DetailPemesanan> detailpemesanan = new ArrayList<>();
        try {
             Connection koneksi = (Connection)Conn.configDB();
            Statement stm = koneksi.createStatement();
            ResultSet res = stm.executeQuery(sql);
            
            while(res.next()) {
                detailpemesanan.add(mapToEntity(res));
            }
        } catch (SQLException e) {
        e.printStackTrace();
        }

        return detailpemesanan;
    }
    
    public List<DetailPemesanan> getById(Integer id) {
         String sql = "SELECT * FROM " + tableName + " WHERE pemesanan_id = ?";
        List<DetailPemesanan> detailpemesanan = new ArrayList<>();
        try {
             Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement stm = koneksi.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet res = stm.executeQuery();
            
            while(res.next()) {
                detailpemesanan.add(mapToEntity(res));
            }
        } catch (SQLException e) {
        e.printStackTrace();
        }

        return detailpemesanan;
    }

    @Override
    public DetailPemesanan get(Integer id) {
        String sql = "SELECT * FROM " + tableName + " WHERE id = ?" ;

        DetailPemesanan detailpemesanan = new DetailPemesanan();
        try {
             Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement stm = koneksi.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet res = stm.executeQuery();

            while(res.next()) {
                return mapToEntity(res); 
            }
        } catch (SQLException e) {}

        return detailpemesanan;
    }

    @Override
    public boolean add(DetailPemesanan detailPemesanan) {
             String sql = "INSERT INTO "+ tableName +" (`pemesanan_id`, `tanggal`, `cicilan`) VALUES ( ?, ?, ?)";
         try {
            Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement pst = koneksi.prepareStatement(sql);
            pst.setInt(1, detailPemesanan.getPemesanan().getId());
            pst.setDate(2, new Date(detailPemesanan.getTanggal().getTime())); 
            pst.setInt(3, detailPemesanan.getCicilan());
            pst.execute();
            return true;
        } catch (Exception e) {
             e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(DetailPemesanan detailPemesanan) {
        String sql = "UPDATE "+ tableName +" SET pemesanan_id = ?, tanggal = ?, cicilan = ? WHERE id = ?";
        
        try {
            Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement pst = koneksi.prepareStatement(sql);
            pst.setInt(1, detailPemesanan.getPemesanan().getId());
            pst.setDate(2, new Date(detailPemesanan.getTanggal().getTime()));
            pst.setInt(3, detailPemesanan.getCicilan());
            pst.setInt(4, detailPemesanan.getId()); 
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        
        }
    }

    @Override
    public boolean delete(int id) {
         String sql = "DELETE FROM "+ tableName +" WHERE id = ?";
           try {
                 Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement pst = koneksi.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    private DetailPemesanan mapToEntity(ResultSet result) throws SQLException {
        DetailPemesanan detailpemesanan = new DetailPemesanan(
                new PemesananRepository().get(result.getInt("pemesanan_id")),
                new Date(result.getDate("tanggal").getTime()),
                result.getInt("cicilan")
        );
        detailpemesanan.setId(result.getInt("id"));
        return detailpemesanan;
        }
}
