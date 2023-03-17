/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author WINDOWS 10
 */
public class Date {
    public String dateNow(){
        LocalDateTime myDateObj = LocalDateTime.now();   
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
        String formattedDate = myDateObj.format(myFormatObj);  
        return formattedDate;
    }
    
     public String dateMonthAgo(){
        LocalDate thirtyDaysAgo = LocalDate.parse(dateNow()).minusDays(30);
        return String.valueOf(thirtyDaysAgo);
    }
     
     public String dateFormatFull(){
        LocalDateTime myDateObj = LocalDateTime.now();  
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MMM dd yyyy ");  
        String formattedDate = myDateObj.format(myFormatObj);  
        return formattedDate;
    } 
}
