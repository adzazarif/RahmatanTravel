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
import service.Auth;



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
        return apa1;
        
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
    String username = "travelrahmatan@gmail.com";
    String password = "adifmmdndqeehmwq";
    
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
    String from    = "travelrahmatan@gmail.com";
    String to      = email ;
    String subject = "Kode Verifikasi Ganti Password Rahmatan App";
    String body = randomNumber();

        Message message = new MimeMessage(session);
    message.setFrom(new InternetAddress(from));
    message.setRecipients(Message.RecipientType.TO,
        InternetAddress.parse(to));
    message.setSubject(subject);
//    message.setText(body);
    String html = "<html>\n" +
"<div style=\"background:#f9f9f9;background-color:#f9f9f9;Margin:0px auto;max-width:600px;\">\n" +
"    <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"background:#f9f9f9;background-color:#f9f9f9;width:100%;\">\n" +
"        <tbody>\n" +
"            <tr>\n" +
"                <td style=\"border-bottom:#333957 solid 5px;direction:ltr;font-size:0px;padding:20px 0;text-align:center;vertical-align:top;\"></td>\n" +
"            </tr>\n" +
"        </tbody>\n" +
"    </table>\n" +
"</div>\n" +
"\n" +
"<div style=\"background:#fff;background-color:#fff;Margin:0px auto;max-width:600px;\">\n" +
"    <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"background:#fff;background-color:#fff;width:100%;\">\n" +
"        <tbody>\n" +
"            <tr>\n" +
"                <td style=\"border:#dddddd solid 1px;border-top:0px;direction:ltr;font-size:0px;padding:20px 0;text-align:center;vertical-align:top;\">\n" +
"                    <div class=\"mj-column-per-100 outlook-group-fix\" style=\"font-size:13px;text-align:left;direction:ltr;display:inline-block;vertical-align:bottom;width:100%;\">\n" +
"                        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"vertical-align:bottom;\" width=\"100%\">\n" +
"                            <tr>\n" +
"                                <td align=\"center\" style=\"font-size:0px;padding:10px 25px;word-break:break-word;\">\n" +
"                                    <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"border-collapse:collapse;border-spacing:0px;\">\n" +
"                                        <tbody>\n" +
"                                            <tr>\n" +
"                                                <td style=\"width:64px;\">\n" +
"                                                    <!-- <img height=\"auto\" src=\"https://i.imgur.com/KO1vcE9.png\" style=\"border:0;display:block;outline:none;text-decoration:none;width:100%;\" width=\"64\" /> -->\n" +
"                                                </td>\n" +
"                                            </tr>\n" +
"                                        </tbody>\n" +
"                                    </table>\n" +
"                                </td>\n" +
"                            </tr>\n" +
"                            <tr>\n" +
"                                <td align=\"center\" style=\"font-size:0px;padding:10px 25px;padding-bottom:40px;word-break:break-word;\">\n" +
"                                    <div style=\"font-family:'Helvetica Neue',Arial,sans-serif;font-size:32px;font-weight:bold;line-height:1;text-align:center;color:#555;\">Kode Verifikasi</div>\n" +
"                                </td>\n" +
"                            </tr>\n" +
"                            <tr>\n" +
"                                <td align=\"center\" style=\"font-size:0px;padding:10px 25px;padding-bottom:20px;word-break:break-word;\">\n" +
"                                    <div style=\"font-family:'Helvetica Neue',Arial,sans-serif;font-size:16px;line-height:22px;text-align:center;color:#555;\">Gunakan kode di bawah untuk mereset password anda</div>\n" +
"                                </td>\n" +
"                            </tr>\n" +
"                            <tr>\n" +
"                                <td align=\"center\" style=\"font-size:0px;padding:10px 25px;padding-top:30px;padding-bottom:40px;word-break:break-word;\">\n" +
"                                    <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"border-collapse:separate;line-height:100%;\">\n" +
"                                        <tr>\n" +
"                                            <td align=\"center\" bgcolor=\"#2F67F6\" role=\"presentation\" style=\"border:none;border-radius:3px;color:#ffffff;cursor:auto;padding:10px 20px;\" valign=\"middle\">\n" +
"                                                <p style=\"background:#2F67F6;color:#ffffff;font-family:'Helvetica Neue',Arial,sans-serif;font-size:30px;letter-spacing:4px;font-weight:bold;line-height:120%;Margin:0;text-decoration:none;text-transform:none;\" id=\"code\">"+body+"</p>\n" +
"                                            </td>\n" +
"                                        </tr>\n" +
"                                    </table>\n" +
"                                </td>\n" +
"                            </tr>\n" +
"                            <tr>\n" +
"                                <td align=\"center\" style=\"font-size:0px;padding:10px 25px;word-break:break-word;\">\n" +
"                                    <div style=\"font-family:'Helvetica Neue',Arial,sans-serif;font-size:14px;line-height:22px;text-align:center;color:#555;\">Rahmatan Transaction System<br> <a href=\"mailto:info@example.com\" style=\"color:#2F67F6\">travelrahmatan@gmail.com</a>\n" +
"                                    </div>\n" +
"                                </td>\n" +
"                            </tr>\n" +
"                        </table>\n" +
"                    </div>\n" +
"                </td>\n" +
"            </tr>\n" +
"        </tbody>\n" +
"    </table>\n" +
"</div>" +
"</html>";
    message.setContent(html, "text/html");
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
        txtUsername = new view.pallet.JTextfieldminta();
        mintakod = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new Color(0,0,0,0));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        minta.setBackground(new Color(0,0,0,0));
        minta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        minta.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 280, -1));

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/bg konfirmasi.png"))); // NOI18N
        minta.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 480));

        add(minta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 480));
    }// </editor-fold>//GEN-END:initComponents

    private void mintakodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mintakodMouseClicked
        Auth at = new Auth();
        
        
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
                               at.username = txtUsername.getText();
                               
                               String token = getapa();
                               at.kirimTokenDB(txtUsername.getText(), token);
                                System.out.println(token);      
                               
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
    private view.pallet.JTextfieldminta txtUsername;
    // End of variables declaration//GEN-END:variables
}
