/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author adzaz
 */
public class ComboItem {
     private int key;
    private String val;
    
    public ComboItem(int key, String val) {
        this.key = key;
        this.val = val;
    }
    
    public int getKey() {
        return key;
    }
    
    public String getVal() {
        return val;
    }
    
    @Override
    public String toString() {
        return this.val;
    }
}
