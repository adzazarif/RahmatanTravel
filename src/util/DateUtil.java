/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author WINDOWS 10
 */
public class DateUtil {
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
     
      public String getDateMinus(String Keberangkatan, int lamaHari){
        LocalDate thirtyDaysAgo = LocalDate.parse(Keberangkatan).minusDays(lamaHari);
        return String.valueOf(thirtyDaysAgo);
    }
      
    public int daysBetweenDates(String date1, String date2) {
        LocalDate dt1 = LocalDate.parse(date1);
        LocalDate dt2= LocalDate.parse(date2);

        long diffDays = ChronoUnit.DAYS.between(dt1, dt2);

        return Math.abs((int)diffDays);
    }
}
