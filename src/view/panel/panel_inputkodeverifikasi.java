/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.panel;


import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import util.Conn;
import view.component.GlassPanePopup;
import view.dialog.dialog_mintakode;
import view.main.Main;
import java.awt.Color;



public class panel_inputkodeverifikasi extends javax.swing.JPanel {
private String email;
    class poo{
    private String text;
//    private String email;
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

    public panel_inputkodeverifikasi() {
        initComponents();
        txtUsername.setBackground(new Color(0,0,0,1));
        txtUsername.setlabelText("input your username");
        txtUsername.setapa("username");
        txtUsername.setapa1("input your username");
        
        
    }
//    public void dapatemail(String email){
//        this.email;
//    }
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
    String to      = email ;
    String subject = "KOde verifikasi rahmatan app";
    String body = randomNumber();

        Message message = new MimeMessage(session);
    message.setFrom(new InternetAddress(from));
    message.setRecipients(Message.RecipientType.TO,
        InternetAddress.parse(to));
    message.setSubject(subject);
    message.setText(body);
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        minta = new javax.swing.JPanel();
        mintakod = new javax.swing.JLabel();
        txtUsername = new view.pallet.JTextfield();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new Color(0,0,0,0));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        minta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mintakod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/kirimkodeverifikasi.png"))); // NOI18N
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
        minta.add(mintakod, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 370, 70));

        txtUsername.setFont(new java.awt.Font("Quicksand", 0, 24)); // NOI18N
        txtUsername.setSelectedTextColor(new java.awt.Color(51, 51, 51));
        minta.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 290, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/bg kodeverifikasi.png"))); // NOI18N
        minta.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 480));

        add(minta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 480));
    }// </editor-fold>//GEN-END:initComponents

    private void mintakodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mintakodMouseClicked

            String sql = "SELECT * FROM user WHERE username = ?";
        
                try {
            
            
                    Connection koneksi = (Connection) Conn.configDB();
                    PreparedStatement pst = koneksi.prepareStatement(sql);
                    pst.setString(1, txtUsername.getText());
                    ResultSet res = pst.executeQuery();
            
            
                        if(res.next()){
                               email = res.getString("email");
                               System.out.println(email);
                               kirim();
                               System.out.println(getapa());
                               
                               
                            }
                        
                    } catch (Exception e) {
                         e.printStackTrace();
                    }
                Main main =(Main)SwingUtilities.getWindowAncestor(this);
                dialog_mintakode a = new dialog_mintakode(main);
                a.showGlass();
                a.showPopUp();
    }//GEN-LAST:event_mintakodMouseClicked

    private void mintakodMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mintakodMouseEntered
        mintakod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/kirimkodeverifikasi1.png")));
    }//GEN-LAST:event_mintakodMouseEntered

    private void mintakodMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mintakodMouseExited
        mintakod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/kirimkodeverifikasi.png")));
    }//GEN-LAST:event_mintakodMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel minta;
    private javax.swing.JLabel mintakod;
    private view.pallet.JTextfield txtUsername;
    // End of variables declaration//GEN-END:variables
}
