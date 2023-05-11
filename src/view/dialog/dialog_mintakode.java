
package view.dialog;

import javax.swing.JFrame;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.internet.MimeMessage;
import service.TokenEmail;
import util.Conn;
public class dialog_mintakode extends Dialog {

    public dialog_mintakode(JFrame fram) {
        super(fram);
        initComponents();
        verifikasi1.setVisible(false);
//        mintakode1.setVisible(false);
    
        
    }
    class poo{
    private String text;

    public poo() {
        this.text = generateText();
    }

    private String generateText() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }
    

    public String getText() {
        return this.text;
    }
}
private String apa1;
    public String randomNumber(){
    poo apa =new poo();
    String randomNumbera = apa.getText();
    apa1 = apa.getText();
//        System.out.println(randomNumbera);
    return randomNumbera;
}
    public String getapa(){
        return this.apa1;
        
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
    String to      = "jadiproplayer14@gmail.com" ;
    String subject = "Kode Veriviksi";
    String body = randomNumber();

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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg1 = new javax.swing.JLabel();
        mintakode1 = new javax.swing.JPanel();
        mintakod = new javax.swing.JLabel();
        txtUsername = new view.pallet.JTextfield();
        bg22 = new javax.swing.JLabel();
        verifikasi1 = new javax.swing.JPanel();
        verifikasi = new javax.swing.JLabel();
        keluar2 = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        bg1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/bg kodeverifikasi.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mintakode1.setBackground(new Color(0,0,0,0));
        mintakode1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mintakod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/krimkodeverifikasi.png"))); // NOI18N
        mintakod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mintakodMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mintakodMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mintakodMouseExited(evt);
            }
        });
        mintakode1.add(mintakod, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 370, 70));

        txtUsername.setFont(new java.awt.Font("Quicksand", 0, 24)); // NOI18N
        mintakode1.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 290, 60));

        bg22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/bg kirimkodeotp.png"))); // NOI18N
        mintakode1.add(bg22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 480));

        getContentPane().add(mintakode1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 480));

        verifikasi1.setBackground(new Color(0,0,0,0));
        verifikasi1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        verifikasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/verifikasi.png"))); // NOI18N
        verifikasi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                verifikasiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                verifikasiMouseExited(evt);
            }
        });
        verifikasi1.add(verifikasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 370, 70));

        keluar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/silangbutton.png"))); // NOI18N
        keluar2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                keluar2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                keluar2FocusLost(evt);
            }
        });
        keluar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                keluar2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                keluar2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                keluar2MouseExited(evt);
            }
        });
        verifikasi1.add(keluar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, -1, -1));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/bg kodeverifikasi.png"))); // NOI18N
        verifikasi1.add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 480));

        getContentPane().add(verifikasi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mintakodMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mintakodMouseEntered
    mintakod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/kirimkodeverifikasi1.png")));
    }//GEN-LAST:event_mintakodMouseEntered

    private void mintakodMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mintakodMouseExited
    mintakod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/kirimkodeverifikasi.png")));
    }//GEN-LAST:event_mintakodMouseExited

    private void verifikasiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verifikasiMouseEntered
    verifikasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/verifikasi1.png")));
    }//GEN-LAST:event_verifikasiMouseEntered

    private void verifikasiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verifikasiMouseExited
    verifikasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/verifikasi.png")));
    }//GEN-LAST:event_verifikasiMouseExited

    private void mintakodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mintakodMouseClicked
 
            
       try {
        kirim();
    } catch (AddressException ex) {
        ex.printStackTrace();
        
    } catch (MessagingException ex) {
        ex.printStackTrace();
    }
    System.out.println(getapa());
//    String sql = "SELECT * FROM user WHERE username = ?";
//       
//        try {
//           
//            
//        Connection koneksi = (Connection) Conn.configDB();
//        PreparedStatement pst = koneksi.prepareStatement(sql);
//        pst.setString(1, txtUsername.getText());
//        ResultSet res = pst.executeQuery();
//             
//            
//            if(res.next()){
//               String email = res.getString("email");
//               System.out.println(email);
//               
//            
//                System.out.println(getapa());
//            }
//            mintakode1.setVisible(false);
//    verifikasi1.setVisible(true);
//        } catch (Exception e) {
//             e.printStackTrace();
//        }
        
    
    }//GEN-LAST:event_mintakodMouseClicked

    private void keluar2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_keluar2FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_keluar2FocusGained

    private void keluar2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_keluar2FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_keluar2FocusLost

    private void keluar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_keluar2MouseClicked
        closeMessage();
    }//GEN-LAST:event_keluar2MouseClicked

    private void keluar2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_keluar2MouseEntered
    keluar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/silangbutton1.png")));
    }//GEN-LAST:event_keluar2MouseEntered

    private void keluar2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_keluar2MouseExited
    keluar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/silangbutton.png")));
    }//GEN-LAST:event_keluar2MouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JLabel bg1;
    private javax.swing.JLabel bg22;
    private javax.swing.JLabel keluar2;
    private javax.swing.JLabel mintakod;
    private javax.swing.JPanel mintakode1;
    private view.pallet.JTextfield txtUsername;
    private javax.swing.JLabel verifikasi;
    private javax.swing.JPanel verifikasi1;
    // End of variables declaration//GEN-END:variables
}
