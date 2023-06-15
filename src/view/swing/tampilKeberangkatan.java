
package view.swing;

import entity.Keberangkatan;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import repository.KeberangkatanRepository;
import view.event.EventMenuSelected;
import view.panel.KeberangkatanForm;

public class tampilKeberangkatan extends javax.swing.JPanel {

    private String nomorpanel;
    private String nomorpanel1;
    private JPanel container;
    private List<JPanel> panellist;
    KeberangkatanRepository keberangkatanrepo = new KeberangkatanRepository();
    public tampilKeberangkatan() {
        initComponents();
        panellist = new ArrayList<>();
        getpanel();
    }
public void getpanel(){
        try{
            String sql = "Select * from keberangkatan";
            Connection con =(Connection)util.Conn.configDB();
            PreparedStatement psw = con.prepareStatement(sql);
            ResultSet res = psw.executeQuery();
            int marginKiri = 10;
            int baris = 0;
            int kolom = 0;
            int dimensi = baris + 1;
            container = new JPanel();
            for(Keberangkatan p:keberangkatanrepo.get()){    
//            while(res.next()){
                final String id_barang = String.valueOf(p.getId());
                String nama_paket = p.getPaket().getMenu();
                String hargapaket123 = String.valueOf(p.getPaket().getHarga());
                ItemKeberangkatan pnn = new ItemKeberangkatan();
                pnn.hargapaket.setText("Rp. "+hargapaket123);
                pnn.nama_paket1.setText(nama_paket);
                int index = panellist.size() + 1;
                pnn.setIndex(index);
                pnn.nama_paket1.setText(nama_paket);
                container.setLayout(null);
                pnn.setSize(1000, 130);
                container.add(pnn);
                container.setPreferredSize(new Dimension(1000, 200 + (165 * baris)));
                container.setBackground(new Color(255,249,243));
//                container.setOpaque(false);
//                container.setBorder(null);
                jScrollPane1.setPreferredSize(new Dimension(1000, 200 * dimensi));
                
                jScrollPane1.setViewportView(container);
                scrollBarCustom1.setOpaque(false);
                jScrollPane1.setVerticalScrollBar(scrollBarCustom1);
                if (kolom <= 0) {
                pnn.setLocation(kolom * 200, baris * 145);
                    } else {
                baris++;
                kolom = 0;
                pnn.setLocation(kolom * 200, baris * 145);
                
                    }
                kolom ++;
                container.revalidate();
                container.repaint();
                pnn.addMouseListener(new MouseAdapter(){
                    @Override
                    public void mouseEntered(MouseEvent e){
                        super.mouseEntered(e);
                        nomorpanel = id_barang;                   
                        
                    }
                }
                );
                pnn.addEvent(new EventMenuSelected() {
                    @Override
                    public void selected(int index) {
                        clearMenu(index);
                        nomorpanel1 = id_barang;
                        KeberangkatanForm.id = Integer.parseInt(nomorpanel);
                    }
                });
                panellist.add(pnn);
            }
            
        }catch( Exception e ){
            e.printStackTrace();
        }
    }
    private void clearMenu(int exceptIndex) {
        for (Component com : container.getComponents()) {
            ItemKeberangkatan item = (ItemKeberangkatan) com;
            if (item.getIndex() != exceptIndex) {
                item.setSelected(false);
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        scrollBarCustom1 = new view.swing.ScrollBarCustom();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 249, 243));

        jScrollPane1.setBackground(new Color(0,0,0,0));
        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBar(scrollBarCustom1);

        scrollBarCustom1.setForeground(new java.awt.Color(255, 90, 0));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/title item keberangkatan1.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 985, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(scrollBarCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                    .addComponent(scrollBarCustom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private view.swing.ScrollBarCustom scrollBarCustom1;
    // End of variables declaration//GEN-END:variables
}
