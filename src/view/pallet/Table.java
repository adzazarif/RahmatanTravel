package view.pallet;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Table extends JTable {

    
    Font f;
    
    public Table() {
        setShowHorizontalLines(true);
        //setShowVerticalLines(true);
        setGridColor(new Color(230, 230, 230));
        ;
        setFont(new Font("Poppins Medium", Font.PLAIN, 12));
        setRowHeight(40);
        getTableHeader().setReorderingAllowed(false);
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                TableHeader header = new TableHeader(o + "");
//                if (o.toString().equals("Aksi")) {
//                    header.setHorizontalAlignment(JLabel.CENTER);
//                } else {
                    header.setHorizontalAlignment(JLabel.CENTER);
//                }

                return header;
            }
        });
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object value, boolean selected, boolean bln1, int i, int i1) {

                Component com = super.getTableCellRendererComponent(jtable, value, selected, bln1, i, i1);
                setFont(new Font("Poppins-Regular", Font.PLAIN, 12));
                setHorizontalAlignment(JLabel.CENTER);
                com.setBackground(Color.WHITE);
                setBorder(noFocusBorder);
                //System.out.println(getFont().getName());
                if (selected) {
                    com.setBackground(new Color(158, 196, 233));
                    f = new Font("Quicksand", Font.BOLD, 15);
                    com.setFont(f);
                    com.setForeground(new Color(80,80,80));
//                    com.set(BorderFactory.createLineBorder(Color.ORANGE));
                } else {
//                    com.setBackground(new Color(102, 102, 102));
                    com.setForeground(new Color(102, 102, 102));
//                    com.setBorder(BorderFactory.createLineBorder(new Color(230, 230, 230)));
                }

                return com;
            }
        });
    }

    public void addRow(Object[] row) {
        DefaultTableModel model = (DefaultTableModel) getModel();
        if (model.getRowCount() == 0) {
        // Set header text when the table is empty
        model.setColumnIdentifiers(new String[]{"Aksi"});
    }
        model.addRow(row);
    }
    public static void main(String[] args) {
        
    }
}
