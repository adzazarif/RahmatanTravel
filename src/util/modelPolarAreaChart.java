/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.awt.Color;

/**
 *
 * @author adzaz
 */
public class modelPolarAreaChart {
    Color color;
    String name;
    double values;
    
    public modelPolarAreaChart(Color color,String name,double values){
        this.color = color;
        this.name = name;
        this.values = values;
    }
    public void setColor(Color color){
        this.color = color;
    }
    public Color getColor(){
        return color;
    }
    
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    
    public void setValues(double values){
        this.values = values;
    }
    public double getValues(){
        return values;
    }
}
