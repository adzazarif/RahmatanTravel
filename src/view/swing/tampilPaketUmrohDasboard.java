
package view.swing;

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
import view.event.EventMenuSelected;

public class tampilPaketUmrohDasboard extends javax.swing.JPanel {

    private String nomorpanel;
    private String nomorpanel1;
    private JPanel container;
    private List<JPanel> panellist;
    
    public tampilPaketUmrohDasboard() {
        initComponents();
        panellist = new ArrayList<>();
        getpanel();
    }
    
    public void getpanel(){
        try{
            String sql = "SELECT *, COUNT(pemesanan.jamaah_id) AS jumlah FROM pemesanan JOIN keberangkatan ON pemesanan.keberangkatan_id = keberangkatan.id JOIN master_paket ON keberangkatan.paket_id = master_paket.id GROUP BY master_paket.id ORDER BY jumlah DESC LIMIT 5";
            Connection con =(Connection)util.Conn.configDB();
            PreparedStatement psw = con.prepareStatement(sql);
            ResultSet res = psw.executeQuery();
            int marginKiri = 10;
            int baris = 0;
            int kolom = 0;
            int dimensi = baris + 1;
            container = new JPanel();
                
            while(res.next()){
                final String id_barang = res.getString(1);
                ItemPaket pnn = new ItemPaket();
                int index = panellist.size() + 1;
                pnn.setIndex(index);
                container.setLayout(null);
                pnn.setSize(290, 188);
                container.add(pnn);
                container.setPreferredSize(new Dimension(920, 250 + (275 * baris)));
                container.setBackground(Color.WHITE);
//                container.setBorder(null);
                jScrollPane1.setPreferredSize(new Dimension(1000, 300 * dimensi));
                
                jScrollPane1.setViewportView(container);
                jScrollPane1.setVerticalScrollBar(scrollBarCustom1);
                if (kolom <= 0) {
                pnn.setLocation(kolom * 290, baris * 200);
                    } else {
                baris++;
                kolom = 0;
                pnn.setLocation(kolom * 290, baris * 200);
                
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
                });
                pnn.addEvent(new EventMenuSelected() {
                    @Override
                    public void selected(int index) {
                        clearMenu(index);
                        nomorpanel1 = id_barang;
                    
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
            ItemPaket item = (ItemPaket) com;
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

        setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new Color(0,0,0,0)
        );
        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        scrollBarCustom1.setForeground(new java.awt.Color(255, 51, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollBarCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scrollBarCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private view.swing.ScrollBarCustom scrollBarCustom1;
    // End of variables declaration//GEN-END:variables
}
