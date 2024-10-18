package Society.Management.System;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import java.awt.Choice;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class view_members {

    JFrame frame = new JFrame("View Members");
    @SuppressWarnings("rawtypes")
    JComboBox box1;
    JButton search;
    JButton print;
    JButton update;
    JButton back;
    JTable table;
    

    @SuppressWarnings("unchecked")
    public view_members(){
       
        frame.setSize(1020,800);
        frame.setLocation(250,50);

    //  ─────────────────────────────────────────────────────────────────────────────
        JLabel label_1 = new JLabel("Search Here");
        label_1.setBounds(350,100,100,30);
        frame.add(label_1);
    //  ─────────────────────────────────────────────────────────────────────────────
        box1 = new JComboBox<>();
        box1.setBounds(500, 100, 100, 30);
        frame.add(box1);

        try {
            database data = new database();
            ResultSet resultset = data.s1.executeQuery("select * from members_table");
            while (resultset.next()) {
                box1.addItem(resultset.getString("unit_no"));
            }
        }  
        catch (Exception e) {
            System.out.println(e.getMessage());
        } 
    //  ─────────────────────────────────────────────────────────────────────────────
    // BUTTONS

        search = new JButton("SEARCH");
        search.setBounds(250, 200, 100, 30);
        search.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    database data = new database();
                    ResultSet resultset = data.s1.executeQuery("select * from members_table where unit_no = '"+box1.getSelectedItem()+"'");
                    table.setModel(DbUtils.resultSetToTableModel(resultset));
                } catch (Exception E) {
                    System.out.println(E.getMessage());
                }
                
            }
        
        });
        frame.add(search);
    //  ─────────────────────────────────────────────────────────────────────────────  
        print = new JButton("PRINT");
        print.setBounds(400, 200, 100, 30);
        print.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent a) {
                try {
                    table.print();
                } catch (Exception e) {
                   System.out.println(e.getMessage());
                }
            }
            
        });
        frame.add(print);
    //  ─────────────────────────────────────────────────────────────────────────────
        update = new JButton("UPDATE");
        update.setBounds(550, 200, 100, 30);
        update.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                String selectedunit = (String) box1.getSelectedItem();
                new update(selectedunit);
                
            }
            
        });
        frame.add(update);
    //  ─────────────────────────────────────────────────────────────────────────────
        back = new JButton("BACK");
        back.setBounds(700, 200, 100, 30);
        back.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                frame.setVisible(false);
                
            }
            
        });
        frame.add(back);

    //  ─────────────────────────────────────────────────────────────────────────────
    // TABLE

        table = new JTable();
        try {
            database data = new database();
            ResultSet resultset = data.s1.executeQuery("select * from members_table");
            table.setModel(DbUtils.resultSetToTableModel(resultset));   
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    
    // ─────────────────────────────────────────────────────────────────────────────
    // SCROLL PANE

        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(60, 300, 900, 100);
        frame.add(jp);

    //  ─────────────────────────────────────────────────────────────────────────────
    // IMAGE

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/image_3.jpg"));
        Image i2 = i1.getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image_label = new JLabel(i3);
        image_label.setBounds(0,0,frame.getWidth(), frame.getHeight());
        frame.add(image_label);

        frame.setLayout(null);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new view_members();
    }

}
