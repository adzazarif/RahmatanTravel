/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view.dialog;

import entity.User;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import repository.UserRepository;
import view.panel.Pegawai;

/**
 *
 * @author adzaz
 */
public class DialogDetailPegawai extends Dialog {
    UserRepository userRepo = new UserRepository();
    private int id = Pegawai.id;
    /**
     * Creates new form DialogDetailPegawai
     */
    public DialogDetailPegawai(JFrame frame) {
        super(frame);
        initComponents();
        setValue();
    }
    public void setValue(){
        for(User p:userRepo.getById(id)){
            lblId.setText(String.valueOf(p.getId()));
            lblAlamat.setText(p.getAlamat());
            lblEmail.setText(p.getEmail());
            lblNama.setText(p.getNama());
            lblUsername.setText(p.getUsername());
            lblNotelp.setText(p.getNoTelp());
            lblGender.setText(p.getJenisKelamin());
            
            try {
                String pathDb = p.getFoto();
                String path = "D:/RahmatanTravel/"+pathDb;
                File f = new File(path);
                ImageIcon icon = new ImageIcon(f.toString());
                Image image = icon.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(image);
                lblFoto.setIcon(ic);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblGender = new javax.swing.JLabel();
        lblNama = new javax.swing.JLabel();
        lblNotelp = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblAlamat = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        lblClose = new javax.swing.JLabel();
        lblFoto = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblGender.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        getContentPane().add(lblGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 130, 280, 40));

        lblNama.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        getContentPane().add(lblNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, 280, 40));

        lblNotelp.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        getContentPane().add(lblNotelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, 280, 40));

        lblUsername.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        getContentPane().add(lblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 400, 280, 40));

        lblEmail.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        getContentPane().add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 400, 280, 40));

        lblAlamat.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        getContentPane().add(lblAlamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 220, 280, 40));

        lblId.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        getContentPane().add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 280, 40));

        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCloseMouseClicked(evt);
            }
        });
        getContentPane().add(lblClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 20, 40, 30));
        getContentPane().add(lblFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 230, 300));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/detail pegawai.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 486));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseClicked
        closeMessage();
    }//GEN-LAST:event_lblCloseMouseClicked



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblAlamat;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lblNotelp;
    private javax.swing.JLabel lblUsername;
    // End of variables declaration//GEN-END:variables
}