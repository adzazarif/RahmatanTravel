/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.panel;

import entity.Jamaah;
import javax.swing.SwingUtilities;
import view.dialog.dialog_editjamaah;
import view.dialog.dialog_tambahJamaah;
import view.main.maindasboard;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import repository.JamaahRepository;
/**
 *
 * @author semafie
 */
public class JamaahForm extends javax.swing.JPanel {
    public static int idJamaah;
    JamaahRepository jamaahRepo = new JamaahRepository();
    Jamaah jamaah = new Jamaah();
    /**
     * Creates new form Jamaah
     */
    public JamaahForm() {
        initComponents();
        load_table();
        setAmount();
    }
    
    public void setAmount(){
        jamaahRepo.getAmountJamaahMale(jamaah);
        jamaahRepo.getAmountJamaahFemale(jamaah);
        jamaahRepo.getAmountJamaah(jamaah);
        String amountMale = String.valueOf(jamaah.getAmountJamaahMale());
        String amountFemale = String.valueOf(jamaah.getAmountJamaahFemale());
        String amountAll = String.valueOf(jamaah.getAmountJamaah());
        
        lblJumlahLaki.setText(amountMale);
        lblJumlahPr.setText(amountFemale);
        lblJumlahSemua.setText(amountAll);
    }
     public void load_table(){
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("No");      
            model.addColumn("NIK");
            model.addColumn("Alamat");
            model.addColumn("Jenis Kelamin");
            model.addColumn("Alamat");
            model.addColumn("No Telp");
            

            int no = 1;
           
           for(Jamaah res:jamaahRepo.get()){
                model.addRow(new Object[]{
                    no++,
                    res.getNik(),
                    res.getNama(),
                    res.getJenisKelamin(),
                    res.getAlamat(), 
                    res.getNoTelp(),      
                });
           }
            table.setModel(model);
       
        
     }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblJumlahSemua = new javax.swing.JLabel();
        lblJumlahPr = new javax.swing.JLabel();
        lblJumlahLaki = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnEdit = new javax.swing.JLabel();
        btnTambah = new javax.swing.JLabel();
        btnDelete = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 249, 243));
        setPreferredSize(new java.awt.Dimension(1366, 768));

        jPanel4.setBackground(new Color(0,0,0,0));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/title jamaah.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setBackground(new Color(0,0,0,0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblJumlahSemua.setFont(new java.awt.Font("Quicksand Bold", 1, 24)); // NOI18N
        lblJumlahSemua.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(lblJumlahSemua, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, 50, 30));

        lblJumlahPr.setFont(new java.awt.Font("Quicksand Bold", 1, 24)); // NOI18N
        lblJumlahPr.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(lblJumlahPr, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, 50, 30));

        lblJumlahLaki.setFont(new java.awt.Font("Quicksand Bold", 1, 24)); // NOI18N
        lblJumlahLaki.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(lblJumlahLaki, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 50, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/jumlah jamaah.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, -1, 96));

        jPanel2.setBackground(new Color(0,0,0,0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setBorder(null);
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 230, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/Search.png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, 41));

        jPanel3.setBackground(new Color(0,0,0,0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditMouseClicked(evt);
            }
        });
        jPanel3.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 140, 40));

        btnTambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTambahMouseClicked(evt);
            }
        });
        jPanel3.add(btnTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 130, 40));

        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
        });
        jPanel3.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 140, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgbutton/button CRUD.png"))); // NOI18N
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 610, 60));

        table.setFont(new java.awt.Font("Quicksand Bold", 0, 15)); // NOI18N
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
        table.setRowHeight(30);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jScrollPane1)
                .addGap(45, 45, 45))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 20, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(385, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(275, 275, 275))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(54, 54, 54))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
        maindasboard main =(maindasboard)SwingUtilities.getWindowAncestor(this);
      dialog_editjamaah panggiledit = new dialog_editjamaah(main);
      panggiledit.showPopUp();
    }//GEN-LAST:event_btnEditMouseClicked

    private void btnTambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahMouseClicked
        maindasboard main =(maindasboard)SwingUtilities.getWindowAncestor(this);
      dialog_tambahJamaah panggilTambah = new dialog_tambahJamaah(main);
      panggilTambah.showPopUp();
    }//GEN-LAST:event_btnTambahMouseClicked

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
        if(jamaahRepo.delete(idJamaah)){
            System.out.println("Berhasil di delete");
            load_table();
            setAmount();
        }else{
            System.out.println("gagal");
        }
    }//GEN-LAST:event_btnDeleteMouseClicked

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
         int baris = table.rowAtPoint(evt.getPoint());
        String NIK = table.getValueAt(baris, 1).toString();
        idJamaah = Integer.valueOf(NIK);
        
    }//GEN-LAST:event_tableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnDelete;
    private javax.swing.JLabel btnEdit;
    private javax.swing.JLabel btnTambah;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblJumlahLaki;
    private javax.swing.JLabel lblJumlahPr;
    private javax.swing.JLabel lblJumlahSemua;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
