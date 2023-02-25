/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import entity.Menu;
import entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.Conn;

/**
 *
 * @author WINDOWS 10
 */
public class MenuRepository implements Repository<Menu>{
    private static String tableName = Menu.tableName;
    @Override
    public List<Menu> get() {
        String sql = "SELECT * FROM " + tableName;
        List<Menu> menu = new ArrayList<>();
        try {
             Connection koneksi = (Connection)Conn.configDB();
            Statement stm = koneksi.createStatement();
            ResultSet res = stm.executeQuery(sql);
            
            while(res.next()) {
                menu.add(mapToEntity(res));
            }
        } catch (SQLException e) {
        e.printStackTrace();
        }

        return menu;
    }

    @Override
    public Menu get(Integer id) {
        String sql = "SELECT * FROM " + tableName + " WHERE id = ?" ;
        Menu menu = new Menu();
        try {
             Connection koneksi = (Connection)Conn.configDB();
            PreparedStatement stm = koneksi.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet res = stm.executeQuery(sql);

            while(res.next()) {
                return mapToEntity(res); 
            }
        } catch (SQLException e) {}

        return menu;
    }

    @Override
    public boolean add(Menu entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(Menu entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private Menu mapToEntity(ResultSet result) throws SQLException {
        Menu menu = new Menu(
             result.getInt("id"),
                result.getString("nama")
        );

        menu.setId(result.getInt("id"));
        return menu;
    }
}
