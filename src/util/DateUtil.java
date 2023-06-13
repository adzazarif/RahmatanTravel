/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

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
    
    public String timeNow(){
          LocalDateTime myDateObj = LocalDateTime.now();   
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm:ss");  
        String formattedDate = myDateObj.format(myFormatObj);  
        return formattedDate;
    }
    
    public String typeDateTime(){
        LocalDateTime myDateObj = LocalDateTime.now();  
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
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
    
          public String dateStart(){
        LocalDateTime myDateObj = LocalDateTime.now();   
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd 00:00:00");  
        String formattedDate = myDateObj.format(myFormatObj);  
        return formattedDate;
    }
    public String dateEnd(){
        LocalDateTime myDateObj = LocalDateTime.now();   
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd 23:59:59");  
        String formattedDate = myDateObj.format(myFormatObj);  
        return formattedDate;
    }
    
    public long subtractionTwoDate(String dateFirst, String dateSecond){
          long diffrence = 0;
         try {
           
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date firstDate = sdf.parse(dateFirst);
        Date secondDate = sdf.parse(dateSecond);

        long diff = secondDate.getTime() - firstDate.getTime();

        TimeUnit time = TimeUnit.DAYS; 
        diffrence = time.convert(diff, TimeUnit.MILLISECONDS);
        
        } catch (Exception e) {
        }
         return diffrence;
    }
    
    public String endPaket(String startDate, int lama){
        String dateEnd = "";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar c = Calendar.getInstance();
            c.setTime(sdf.parse(startDate));
            c.add(Calendar.DATE, lama); 
            dateEnd = sdf.format(c.getTime());  
            return dateEnd;
        } catch (Exception e) {
        }
        return dateEnd;
    }
}
