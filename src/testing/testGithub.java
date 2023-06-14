/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testing;

import entity.Keberangkatan;
import entity.Presensi;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.TimeUnit;
import repository.DashboardRepository;
import repository.KeberangkatanRepository;
import repository.PresensiRepository;
import util.DateUtil;
/**
 *
 * @author adzaz
 */public class testGithub {
      public int daysBetweenDates(String date1, String date2) {
        LocalDate dt1 = LocalDate.parse(date1);
        LocalDate dt2= LocalDate.parse(date2);

        long diffDays = ChronoUnit.DAYS.between(dt1, dt2);

        return Math.abs((int)diffDays);
    }
    public static void main(String[] args) {
//        testGithub test = new testGithub();
        
        
//        for(Keberangkatan k:keberangkatanRepo.getById(12)){
//            int lama = test.daysBetweenDates(dateUtil.dateNow(), k.getTanggal().toString());
//        System.out.println(lama);
//        }
        
//        try {
//              String date1 = "2023-01-03";
//        String date2 = "2023-01-02";
//        Date datee1 = new SimpleDateFormat("yyyy-MM-dd").parse(date1);
//        Date datee2 = new SimpleDateFormat("yyyy-MM-dd").parse(date2);
//        Date diff = new Date(datee1.getTime() - datee2.getTime());
//            System.out.println(diff.toString());
//        } catch (Exception e) {
//        }
//        int lama = dateUtil.daysBetweenDates(date1, date2);
//        System.out.println(lama);
    
//    SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");  
//    Date date = new Date();  
//    System.out.println(formatter.format(date));  

//        try {
//            String time1 = "07:00:00";
//            String time2 = "07:10:00";
//
//SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
//Date date1 = format.parse(time1);
//Date date2 = format.parse(time2);
//long difference = date2.getTime() - date1.getTime(); 
//            System.out.println(difference);
//        } catch (Exception e) {
//        }


//        PresensiRepository presensiRepo = new PresensiRepository();
//        System.out.println(dateUtil.dateNow());
//        boolean a = presensiRepo.checkData(1, dateUtil.dateStart(), dateUtil.dateEnd());
//        if(a){
//            System.out.println("ada");
//        }else{
//            System.out.println("ga ada");
//        }

//
//        try {
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
//        Date firstDate = sdf.parse("2020-01-05");
//        Date secondDate = sdf.parse("2020-01-02");
//
//        long diff = secondDate.getTime() - firstDate.getTime();
//
//        TimeUnit time = TimeUnit.DAYS; 
//        long diffrence = time.convert(diff, TimeUnit.MILLISECONDS);
//        System.out.println("The difference in days is : "+diffrence);
//        } catch (Exception e) {
//        }
    
//        try {
//            DateUtil dateUtil = new DateUtil();
//            String dateNow = dateUtil.dateNow();
//            KeberangkatanRepository keberangkatanRepo = new KeberangkatanRepository();
//            for(Keberangkatan k:keberangkatanRepo.get()){
//                String dateStartKeberangkatan = k.getTanggal().toString();
//                int lamaPaket = k.getPaket().getLamaPaket();
//                String dateEnd = dateUtil.endPaket(dateStartKeberangkatan, lamaPaket);
//                long diferentStartKeberangkatan = dateUtil.subtractionTwoDate(dateNow, dateStartKeberangkatan);
//                long diferentEndKeberangkatan = dateUtil.subtractionTwoDate(dateEnd, dateNow);
//                String status = k.getStatus();
//                String sts = "";
//                String resultUpdated = "";
//                if(diferentStartKeberangkatan <= 0 && diferentEndKeberangkatan < 0){
//                    if(!status.equals("Sedang Berangkat")){
//                        sts = "Sedang Berangkat";
//                        boolean updated = keberangkatanRepo.updateStatus(sts, k.getId());
//                        resultUpdated = updated ? "Berhasil di updated" : "gagal di updated";
//                    }
//                }else if(diferentEndKeberangkatan >= 0){
//                    if(!status.equals("Selesai Berangkat")){
//                        sts = "Selesai Berangkat";
//                        boolean updated = keberangkatanRepo.updateStatus(sts, k.getId());
//                        resultUpdated = updated ? "Berhasil di updated" : "gagal di updated";
//                    }
//                }else if(diferentStartKeberangkatan >= 0){
//                    if(!status.equals("Belum Berangkat")){
//                        if(!status.equals("Selesai Berangkat")){
//                        sts = "Belum Berangkat";
//                        boolean updated = keberangkatanRepo.updateStatus(sts, k.getId());
//                        resultUpdated = updated ? "Berhasil di updated" : "gagal di updated";
//                        }
//                    }
//                }
//                System.out.println(resultUpdated);
//            }
//       
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
        DashboardRepository db = new DashboardRepository();
        System.out.println(db.getIncome());
    }
}


