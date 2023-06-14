
package view.panel;

import java.awt.BorderLayout;
import view.dialog.dialog_aboutversi;
import view.dialog.dialog_mintakode;
import java.awt.Color;
import java.awt.Container;
import javax.swing.SwingUtilities;
import service.Auth;
import view.component.GlassPanePopup;
import view.main.maindasboard;


//import view.dialog.hayolo;
import view.panel.panel_aboutversi;
import view.main.Main;
public class Login extends javax.swing.JPanel {

    public Login() {
        initComponents();
        
        txtUsername.setBackground(new Color(0,0,0,1));
        txtPassword.setBackground(new Color(0,0,0,1));
        txtUsername.setlabelText("input your username");
        txtPassword.setlabelText("input your password");
        txtUsername.setapa("username");
        txtPassword.setapa("password");
        txtUsername.setapa1("input your username");
        txtPassword.setapa1("input your password");
//        Panel2.setVisible(false);
//        Panel3.setVisible(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtUsername = new view.pallet.JTextfield();
        txtPassword = new view.pallet.JPasswordfield1();
        login = new javax.swing.JLabel();
        keluar = new javax.swing.JLabel();
        aboutversi = new javax.swing.JLabel();
        lupapassword = new javax.swing.JLabel();
        gif1 = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setLayout(null);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 190, 50));
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 190, -1));

        login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/login.png"))); // NOI18N
        login.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                loginFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                loginFocusLost(evt);
            }
        });
        login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginMouseExited(evt);
            }
        });
        jPanel1.add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, 120, -1));

        keluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/silang.png"))); // NOI18N
        keluar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                keluarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                keluarFocusLost(evt);
            }
        });
        keluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                keluarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                keluarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                keluarMouseExited(evt);
            }
        });
        jPanel1.add(keluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 10, 20, 20));

        aboutversi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/versi 1.0.0.1_0.png"))); // NOI18N
        aboutversi.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                aboutversiFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                aboutversiFocusLost(evt);
            }
        });
        aboutversi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aboutversiMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                aboutversiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                aboutversiMouseExited(evt);
            }
        });
        jPanel1.add(aboutversi, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 420, 80, 20));

        lupapassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/Lupa password.png"))); // NOI18N
        lupapassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lupapasswordMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lupapasswordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lupapasswordMouseExited(evt);
            }
        });
        jPanel1.add(lupapassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 350, 110, 20));

        gif1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/KaabahAnimation.gif"))); // NOI18N
        jPanel1.add(gif1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, 520, 450));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/bg login1.png"))); // NOI18N
        jPanel1.add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        add(jPanel1);
        jPanel1.setBounds(0, 0, 1024, 580);
    }// </editor-fold>//GEN-END:initComponents

    private void loginFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_loginFocusGained
    
    }//GEN-LAST:event_loginFocusGained

    private void loginFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_loginFocusLost
    
    }//GEN-LAST:event_loginFocusLost

    private void keluarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_keluarFocusGained
    
    }//GEN-LAST:event_keluarFocusGained

    private void keluarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_keluarFocusLost
    
    }//GEN-LAST:event_keluarFocusLost

    private void aboutversiFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_aboutversiFocusGained
            // TODO add your handling code here:
    }//GEN-LAST:event_aboutversiFocusGained

    private void aboutversiFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_aboutversiFocusLost
    
    }//GEN-LAST:event_aboutversiFocusLost

    private void aboutversiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutversiMouseClicked
    Main apa1 = (Main) SwingUtilities.getWindowAncestor(this);
        dialog_aboutversi apa = new dialog_aboutversi(apa1);
        apa.showGlass();
    
        apa.showPopUpNonGlass();
    
    
    }//GEN-LAST:event_aboutversiMouseClicked

    private void loginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseEntered
    login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/login1.png")));
    }//GEN-LAST:event_loginMouseEntered

    private void loginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseExited
    login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/login.png")));
    }//GEN-LAST:event_loginMouseExited

    private void aboutversiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutversiMouseEntered
    aboutversi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/versi 1.0.0.1_1.png")));
    }//GEN-LAST:event_aboutversiMouseEntered

    private void aboutversiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutversiMouseExited
    aboutversi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/versi 1.0.0.1_0.png")));
    }//GEN-LAST:event_aboutversiMouseExited

    private void keluarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_keluarMouseEntered
     keluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/silang1.png")));
    }//GEN-LAST:event_keluarMouseEntered

    private void keluarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_keluarMouseExited
    keluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/silang.png")));
    }//GEN-LAST:event_keluarMouseExited

    private void keluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_keluarMouseClicked
    Main apa = (Main) SwingUtilities.getWindowAncestor(this);
//        this.setVisible(false);
        apa.dispose();
    }//GEN-LAST:event_keluarMouseClicked

    private void lupapasswordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lupapasswordMouseEntered
    lupapassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/Lupa password1.png")));
    }//GEN-LAST:event_lupapasswordMouseEntered

    private void lupapasswordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lupapasswordMouseExited
    lupapassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/Lupa password.png")));        // TODO add your handling code here:
    }//GEN-LAST:event_lupapasswordMouseExited

    private void lupapasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lupapasswordMouseClicked
        
        
        Container parent = this.getParent();

// Mendapatkan index saat ini dari panel dalam parent container
int currentIndex = parent.getComponentZOrder(this);

// Memindahkan panel ke index terbawah (indeks 0)
parent.setComponentZOrder(this, 0);
        GlassPanePopup.showPopup(new panel_inputkodeverifikasi());
    
        
    }//GEN-LAST:event_lupapasswordMouseClicked

    private void loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseClicked
        String username = txtUsername.getText();
        String pass = txtPassword.getText();
        
        Auth a = new Auth();
        if(a.login(username, pass)){
            this.setVisible(false);
            new maindasboard().setVisible(true);
            System.out.println("berhasil login");
        }else{
            
        }
    }//GEN-LAST:event_loginMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aboutversi;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel gif1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel keluar;
    private javax.swing.JLabel login;
    private javax.swing.JLabel lupapassword;
    private view.pallet.JPasswordfield1 txtPassword;
    private view.pallet.JTextfield txtUsername;
    // End of variables declaration//GEN-END:variables
}
