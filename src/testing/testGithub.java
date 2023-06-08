/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testing;

import entity.Keberangkatan;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import repository.KeberangkatanRepository;
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
        testGithub test = new testGithub();
        DateUtil dateUtil = new DateUtil();
        KeberangkatanRepository keberangkatanRepo = new KeberangkatanRepository();
        for(Keberangkatan k:keberangkatanRepo.getById(12)){
            int lama = test.daysBetweenDates(dateUtil.dateNow(), k.getTanggal().toString());
        System.out.println(lama);
        }
        


    }
}
