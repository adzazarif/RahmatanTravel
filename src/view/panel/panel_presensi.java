/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.panel;

import entity.Keberangkatan;
import entity.Presensi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import repository.PresensiRepository;
import util.DateUtil;
import view.dialog.DialogTambahCicilan;
import view.dialog.DialogTambahPresensi;
import view.main.maindasboard;
import java.awt.Color;
import view.main.Main;
import view.main.Mainpresensi;

/**
 *
 * @author adzaz
 */
public class panel_presensi extends javax.swing.JPanel {
    private String startPresensi = Presensi.StartPresensi;
    private String endPresensi = Presensi.EndPresensi;
    private String latePresensi = Presensi.LatePresensi;
    PresensiRepository presensiRepo = new PresensiRepository();
    DateUtil dateUtil = new DateUtil();
    /**
     * Creates new form panel_presensi
     */
    public panel_presensi() {
        initComponents();
        showTime();
        showDate();
        setValue();
        load_table();
        activeButton();
    }
    
    public void activeButton(){
        try {
            String timeNow = dateUtil.timeNow();

            SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
            Date dateNow = format.parse(timeNow);
            Date dateStart = format.parse(startPresensi);
            long differenceStart = dateNow.getTime() - dateStart.getTime(); 
            
            Date dateEnd = format.parse(endPresensi);
            long differenceEnd = dateEnd.getTime() - dateNow.getTime();
            if(differenceStart >= 0 && differenceEnd >= 0){
               panelButton.setVisible(true);
            }else{
                panelButton.setVisible(false);
            }
        } catch (Exception e) {
        }
    }
    
      public void load_table(){
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("No");      
            model.addColumn("Nama");
            model.addColumn("Waktu Presensi");
            model.addColumn("Keterangan");
                       
            int no = 1;
           
           try {
             for(Presensi pr:presensiRepo.get()){
                model.addRow(new Object[]{
                    
                    no++,
                    pr.getUser().getNama(),
                    pr.getWaktuPresensi().toString(),
                    pr.getKeterangan()
                });
           }
            table.setModel(model);
       
         } catch (Exception e) {
               e.printStackTrace();
         }
        
     }
      
    public void setValue(){
        lblStartTime.setText(startPresensi);
        lblEndTime.setText(endPresensi);
        lblEndTime1.setText(latePresensi);
    }
    
    public void showTime(){
        new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                activeButton();
                Date d = new Date();
                SimpleDateFormat s = new SimpleDateFormat("HH:mm:ss");
                String time = s.format(d);
                lblTime.setText(time);
            }
        }).start();
    }
    
    public void showDate(){
        Date d = new Date();
                SimpleDateFormat s = new SimpleDateFormat("EEEE, MMM dd yyyy");
                String time = s.format(d);
                lblDate.setText(time);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTime = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblEndTime1 = new javax.swing.JLabel();
        lblEndTime = new javax.swing.JLabel();
        lblStartTime = new javax.swing.JLabel();
        panelButton = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new view.pallet.Table();
        jLabel3 = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTime.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        add(lblTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 330, 70));

        lblDate.setFont(new java.awt.Font("Quicksand Bold", 0, 18)); // NOI18N
        add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, 270, 30));

        lblEndTime1.setFont(new java.awt.Font("Segoe UI", 0, 40)); // NOI18N
        add(lblEndTime1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 530, 360, 70));

        lblEndTime.setFont(new java.awt.Font("Segoe UI", 0, 40)); // NOI18N
        add(lblEndTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 650, 360, 70));

        lblStartTime.setFont(new java.awt.Font("Segoe UI", 0, 40)); // NOI18N
        add(lblStartTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 400, 360, 70));

        panelButton.setBackground(new Color(0,0,0,0));
        panelButton.setLayout(null);

        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        panelButton.add(jLabel2);
        jLabel2.setBounds(0, 10, 180, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/button presensi.png"))); // NOI18N
        panelButton.add(jLabel1);
        jLabel1.setBounds(0, 0, 190, 60);

        add(panelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 90, 190, 70));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(table);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 220, 710, 510));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("mbalek");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, 140, 60));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/bg presensi.png"))); // NOI18N
        add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
         Mainpresensi main =(Mainpresensi)SwingUtilities.getWindowAncestor(this);
        DialogTambahPresensi tambahPresensi = new DialogTambahPresensi(main);
        tambahPresensi.showPopUp();
        load_table();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
                Mainpresensi main =(Mainpresensi)SwingUtilities.getWindowAncestor(this);
         main.setVisible(false);
            new Main().setVisible(true);
    }//GEN-LAST:event_jLabel3MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblEndTime;
    private javax.swing.JLabel lblEndTime1;
    private javax.swing.JLabel lblStartTime;
    private javax.swing.JLabel lblTime;
    private javax.swing.JPanel panelButton;
    private view.pallet.Table table;
    // End of variables declaration//GEN-END:variables
}
