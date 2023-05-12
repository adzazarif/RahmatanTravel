/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author semafie
 */




import java.util.Properties;

import javax.mail.internet.MimeMessage;





public class TokenEmail {
    
    private String token;
    public String randomNumber(){
    GenerateCode apa =new GenerateCode();
    String randomNumbera = apa.getText();
    token = apa.getText();
//        System.out.println(randomNumbera);
    return randomNumbera;
}
     public String getToken(){
        return token;
        
    }
    public void kirim()throws AddressException, MessagingException {
           String host = "smtp.gmail.com";
    int port = 587;
    String username = "restuimamsafii04@gmail.com";
    String password = "syxstfevakapdhnd";
    
    Properties props = new Properties();
    props.put("mail.smtp.auth","true");
    props.put("mail.smtp.starttls.enable","true");
    props.put("mail.smtp.host",host);
    props.put("mail.smtp.port",port);
    
    Session session = Session.getInstance(props,
            new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(username, password);
            }
            });
    String from    = "restuimamsafii04@gmail.com";
    String to      = "restuimamsafii04@gmail.com";
    String subject = "Kode Verifikasi";
    String body = "test";

        Message message = new MimeMessage(session);
    message.setFrom(new InternetAddress(from));
    message.setRecipients(Message.RecipientType.TO,
        InternetAddress.parse(to));
    message.setSubject(subject);
//    message.setText(body);
//    String html = "<html>\n" +
//"  <head>\n" +
//"    <meta charset=\"UTF-8\">\n" +
//"    <title>Persegi Panjang Verifikasi</title>\n" +
//"    <style>\n" +
//".verification-box {\n" +
//"      	margin-left: 30px;\n" +
//"        background-color: #4d90fe;\n" +
//"        border: 3px solid #4d90fe;\n" +
//"        border-radius: 25px;\n" +
//"        box-shadow: 0 2px 9px rgba(0, 0, 0, 0.3);\n" +
//"        display: inline-block;\n" +
//"        padding: 10px;\n" +
//"        text-align: center;\n" +
//"        width: 180px; /* menambahkan lebar */\n" +
//"        height:10px; /* menambahkan tinggi */\n" +
//"        display: flex; /* menggunakan flexbox */\n" +
//"        align-items: center; /* align items ke tengah */\n" +
//"        justify-content: space-evenly;\n" +
//"      }\n" +
//"      .verification-code {\n" +
//"      	\n" +
//"        font-size: 32px;\n" +
//"        font-weight: bold;\n" +
//"        color: #ffffff;\n" +
//"        line-height: 1;\n" +
//"        letter-spacing: 20px;\n" +
//"      }\n" +
//"      .verification-heading {\n" +
//"      	font-weight: bold;\n" +
//"        font-family: \"Quicksand\", sans-serif;\n" +
//"        font-size: 15px;\n" +
//"        color: #ff0000;\n" +
//"        margin-left: 20px;\n" +
//"        line-height: 1;\n" +
//"      }\n" +
//"      .verification-heading22 {\n" +
//"      	font-weight: bold;\n" +
//"        font-family: \"Quicksand\", sans-serif;\n" +
//"        font-size: 20px;\n" +
//"        margin-left: 45px;\n" +
//"        line-height: 1;\n" +
//"      }\n" +
//"      .verification-heading23 {\n" +
//"      	font-weight: medium;\n" +
//"        font-family: \"Quicksand\", sans-serif;\n" +
//"        font-size: 20px;\n" +
//"        margin-left: 10px;\n" +
////"        line-height: 1;\n" +
//"      }\n" +
//"      .verification-heading24 {\n" +
//"      	font-weight: BOLD;\n" +
//"        font-family: \"Quicksand\", sans-serif;\n" +
//"        font-size: 30px;\n" +
//"        color: #be1600;\n" +
//"        margin-left: 23px;\n" +
//"        line-height: 1;\n" +
//"      }\n" +
//"    </style>\n" +
//"  </head>\n" +
//"  <body>\n" +
//"  <p class=\"verification-heading\">JANGAN BERIKAN KODE OTP INI</p>\n" +
//"  <p class=\"verification-heading22\">KEPADA SIAPAPUN</p>\n" +
//"  <p class=\"verification-heading24\">TERMASUK DIA</p>\n" +
//"    <div class=\"verification-box\">\n" +
//"      <p class=\"verification-code\">"+body+"</p>\n" +
//"    </div>\n" +
//"    <p class=\"verification-heading23\">Tolong Inputkan Kode Beerikut</p>\n" +
//"  </body>\n" +
//"</html>";
//    message.setContent(html, "text/html");
    Transport.send(message);
    }
    public static void main(String[] args) throws AddressException, MessagingException {
        TokenEmail email = new TokenEmail();
        email.kirim();
    }
}
