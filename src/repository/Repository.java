/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;
import java.sql.Connection;
import java.util.List;
import java.util.Map;
/**
 *
 * @author WINDOWS 10
 */
public interface Repository<E extends entity.Entity> {
    final Connection conn = util.Conn.getConnection();
    
    
    /**
     * Get all records
     * @return
     */
    public List<E> get();

    /**
     * Return record by id
     * @param id
     * @return
     */
    public E get(Integer id);


    /**
     * Insert record to database
     * @param entity
     * @return
     */
    public boolean add(E entity);

    /**
     * Update the record
     * @param entity
     * @param data
     * @return
     */
    public boolean update(E entity);

    /**
     * Delete the specific record
     * @param id
     * @return
     */
    public boolean delete(int id);
    
}
