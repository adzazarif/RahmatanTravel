package testing;

import entity.Jamaah;
import entity.Pemesanan;
import entity.User;
import repository.JamaahRepository;
import repository.PemesananRepository;
import repository.UserRepository;

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
        PemesananRepository pemesanan = new PemesananRepository();
        for(Pemesanan pem:pemesanan.get()){
            System.out.print("id Pemesanan : "+pem.getId());
            System.out.print("jenis Pmebayaran : "+pem.getJenisPembayaran());
            System.out.print("status : "+pem.getStatus());
            System.out.print("tanggal :" + pem.getTanggal());
            System.out.print("jumlah bayar :" + pem.getJumlahBayar());
            System.out.print("total tagiham : "+ pem.getTotalTagihan());
            
            System.out.println("");
    }
    }
}
