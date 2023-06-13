package testing;

import data.DataChartLine;
import entity.Jamaah;
import entity.Keberangkatan;
import entity.Paket;
import entity.Pemesanan;
import entity.User;
import java.util.Date;
import repository.DashboardRepository;
import repository.JamaahRepository;
import repository.KeberangkatanRepository;
import repository.LaporanRepository;
import repository.PaketRepository;
import repository.PemesananRepository;
import repository.UserRepository;
import service.Auth;
import util.DateUtil;

public class Test {
    public static void main(String[] args) {
        
        
//  ---------testing untuk CRUD User------------

//        User user = new User(9,"Adza Zarif","Zarif12345","owner","zarif132");         
//        UserRepository userRepo = new UserRepository();
//            
//        if(userRepo.add(user)){
//            System.out.println("berhasil CRUD User");
//        }else{
//            System.out.println("gagal CRUD User");
//        }
//        System.out.println("Data User");
//        for(User usr:userRepo.get()){
//            System.out.print("- "+usr.getNama()+", "+usr.getUsername());
//            System.out.println("");
//        }

//  ---------testing untuk CRUD Jamaah------------
//        Jamaah jamaah = new Jamaah("Zarif","asd","Blitar","09234234523");
//        JamaahRepository jamaahRepo = new JamaahRepository();
//        
//         if(jamaahRepo.add(jamaah)){
//            System.out.println("berhasil CRUD Jamaah");
//        }else{
//            System.out.println("gagal CRUD Jamaah");
//        }
//        System.out.println("Data Jamaah");
//        for(Jamaah jmh:jamaahRepo.get()){
//            System.out.print("- "+jmh.getNama()+", "+jmh.getNik());
//            System.out.println("");
//        }
//        
//        DashboardRepository ds = new DashboardRepository();
//        
//    for(Paket pk:ds.getOftenPaket()){
//        System.out.println("nama " + pk.getNama());
//    }
        
PaketRepository paketRepo = new PaketRepository();
    
     
//    for(Paket p:paketRepo.getByid(1)){
//        System.out.println(p.getNama());
//        System.out.println(p.getDeskripsi());
//    }
     
//        Paket p = new Paket();
//        Date d = new Date();
//        Keberangkatan kb = new Keberangkatan(p, d);
//        KeberangkatanRepository kbr = new KeberangkatanRepository();
//        kbr.add(kb);

//    String str = "";
//    String kalimat2 = "null asd,112,Stok = 123h";
//    String kept = kalimat2.substring( 0, kalimat2.indexOf(","));
//String [] twoStringArray= kalimat2.split(",", 2); //the main line
//System.out.println("String befor comma = "+twoStringArray[0]);//abc
//        
//String [] twoStringArrays= kalimat2.split("= ", 0); //the main line
//System.out.println("String before same = "+twoStringArrays[0]);//abc
    
//        KeberangkatanRepository kbr = new KeberangkatanRepository();
//        for(Keberangkatan k:kbr.getByMenu("umrah")){
//            System.out.println(k.getId());
//            
//            System.out.println(k.getTanggal());
//        }


        LaporanRepository laporanRepo = new LaporanRepository();
//        int totalUmrah = laporanRepo.getCountJamaahByMenu("umrah");
//        System.out.println(totalUmrah);
//    for(DataChartLine r:laporanRepo.getChartLine()){
//        System.out.println(r.getMonth());
//        System.out.println(r.getAmounthHaji());
//        System.out.println(r.getAmounthUmrah());
//    }
//    }
//DateUtil dateUtil = new DateUtil();
//    KeberangkatanRepository keberangkatanRepo = new KeberangkatanRepository();
//    for(Keberangkatan s:keberangkatanRepo.getById(12)){
//        System.out.println(s.getTanggal());
//        String tanggalMinus = dateUtil.getDateMinus(s.getTanggal().toString(), 2);
//        System.out.println(tanggalMinus);
//    }

//int a = 31500000;
//long total = a * 100 / 100;
//        System.out.println(total);
    }
}
