
package view.swing;

//import 
import entity.Paket;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import view.event.EventMenuSelected;
import java.awt.Color;
import java.awt.FlowLayout;
import repository.PaketRepository;
import view.panel.PaketForm;
import static view.swing.ItemPaket.namapaket123;
import static view.swing.ItemPaket.infopaket;
public class tampilscroolPaket extends javax.swing.JPanel {

    private String nomorpanel;
    private String nomorpanel1;
    private JPanel container;
    private List<JPanel> panellist;
    PaketRepository paketRepo = new PaketRepository();
    
    public tampilscroolPaket() {
        initComponents();
        panellist = new ArrayList<>();
        getpanel();
    }

    public void getpanel(){
        try{
            String sql = "Select * from master_paket";
            Connection con =(Connection)util.Conn.configDB();
            PreparedStatement psw = con.prepareStatement(sql);
            ResultSet res = psw.executeQuery();
            int marginKiri = 10;
            int baris = 0;
            int kolom = 0;
            int dimensi = baris + 1;
            container = new JPanel();
                
            for(Paket p:paketRepo.get()){
                   final String id_barang = String.valueOf(p.getId());
                   String namapaket11 = p.getMenu();
                   String lamapaket = String.valueOf(p.getNama());
                   String hargaa = String.valueOf("Rp. "+p.getHarga());
                   System.out.println(namapaket11);
                   System.out.println(lamapaket);
                   
                ItemPaket pnn = new ItemPaket();
                pnn.namapaket123.setText(namapaket11);
                   pnn.infopaket.setText(lamapaket);
                   pnn.harga.setText(lamapaket);
                int index = panellist.size() + 1;
                pnn.setIndex(index);
                container.setLayout(null);
                pnn.setSize(290, 188);
                container.add(pnn);
                container.setPreferredSize(new Dimension(920, 250 + (212 * baris)));
                container.setBackground(Color.WHITE);
//                container.setBorder(null);
                jScrollPane1.setPreferredSize(new Dimension(1000, 220 * dimensi));
                
                jScrollPane1.setViewportView(container);
                jScrollPane1.setVerticalScrollBar(scrollBarCustom1);
                if (kolom <= 2) {
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
                                        
                        
                    }
                });
                pnn.addEvent(new EventMenuSelected() {
                    @Override
                    public void selected(int index) {
                        clearMenu(index);
                        PaketForm.id = Integer.valueOf(id_barang);   
                    }
                });
                panellist.add(pnn); 
            }
//            while(res.next()){
//                final String id_barang = res.getString(1);
//                ItemPaket pnn = new ItemPaket();
//                int index = panellist.size() + 1;
//                pnn.setIndex(index);
//                container.setLayout(null);
//                pnn.setSize(290, 188);
//                container.add(pnn);
//                container.setPreferredSize(new Dimension(920, 250 + (250 * baris)));
//                container.setBackground(Color.WHITE);
////                container.setBorder(null);
//                jScrollPane1.setPreferredSize(new Dimension(1000, 300 * dimensi));
//                
//                jScrollPane1.setViewportView(container);
//                jScrollPane1.setVerticalScrollBar(scrollBarCustom1);
//                if (kolom <= 2) {
//                pnn.setLocation(kolom * 290, baris * 200);
//                    } else {
//                baris++;
//                kolom = 0;
//                pnn.setLocation(kolom * 290, baris * 200);
//                
//                    }
//                kolom ++;
//                container.revalidate();
//                container.repaint();
//                pnn.addMouseListener(new MouseAdapter(){
//                    @Override
//                    public void mouseEntered(MouseEvent e){
//                        super.mouseEntered(e);
//                        nomorpanel = id_barang;                   
//                        
//                    }
//                });
//                pnn.addEvent(new EventMenuSelected() {
//                    @Override
//                    public void selected(int index) {
//                        clearMenu(index);
//                        nomorpanel1 = id_barang;
//                        System.out.println(nomorpanel);
//                    }
//                });
//                panellist.add(pnn);
//            }
            
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
        bg = new javax.swing.JLabel();

        setBackground(new Color(0,0,0,0));
        setLayout(null);

        jScrollPane1.setBackground(new Color(0,0,0,0));
        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBar(scrollBarCustom1);
        add(jScrollPane1);
        jScrollPane1.setBounds(60, 30, 890, 440);

        scrollBarCustom1.setForeground(new java.awt.Color(255, 90, 0));
        add(scrollBarCustom1);
        scrollBarCustom1.setBounds(960, 30, 8, 440);

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/bgform paket.png"))); // NOI18N
        add(bg);
        bg.setBounds(0, 0, 1000, 500);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JScrollPane jScrollPane1;
    private view.swing.ScrollBarCustom scrollBarCustom1;
    // End of variables declaration//GEN-END:variables
}
