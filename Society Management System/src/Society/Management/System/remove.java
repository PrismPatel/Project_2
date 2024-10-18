package Society.Management.System;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class remove {
    
    JFrame frame;
    JLabel namef;
    JLabel namem;
    JLabel namel;
    JButton remove;
    JButton back;

    @SuppressWarnings("unchecked")
    public remove(){

        frame = new JFrame("REMOVE MEMBERS");
        frame.setSize(1020,800);
        frame.setLocation(250, 50);

        JLabel unit = new JLabel("House/Unit");
        unit.setFont(new Font("Times New Roman",Font.PLAIN, 16));
        unit.setBounds(380, 150, 100, 40);
        frame.add(unit);

        @SuppressWarnings("rawtypes")
        JComboBox box1 = new JComboBox<>();
        box1.setBounds(480, 150, 150, 30);
        box1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    database data = new database();
                    ResultSet resultset = data.s1.executeQuery("select * from members_table where unit_no = '"+box1.getSelectedItem()+"'");
                    while (resultset.next()) {
                        namef.setText(resultset.getString("name"));
                        namem.setText(resultset.getString("m_name"));
                        namel.setText(resultset.getString("l_name"));
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                
            }
            
        });
        frame.add(box1);


        try {
            database data = new database();
            ResultSet resultset = data.s1.executeQuery("select * from members_table");
            while (resultset.next()) {
                box1.addItem(resultset.getString("unit_no"));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        JLabel fname = new JLabel("First Name:");
        fname.setFont(new Font("Times New Roman",Font.PLAIN, 16));
        fname.setBounds(200, 260, 100, 30);
        frame.add(fname);

        namef = new JLabel();
        namef.setFont(new Font("Times New Roman",Font.PLAIN, 16));
        namef.setBounds(290, 260, 100, 30);
        frame.add(namef);

        JLabel mname = new JLabel("Middle Name:");
        mname.setFont(new Font("Times New Roman",Font.PLAIN, 16));
        mname.setBounds(440, 260, 100, 30);
        frame.add(mname);

        namem = new JLabel();
        namem.setFont(new Font("Times New Roman",Font.PLAIN, 16));
        namem.setBounds(550, 260, 100, 30);
        frame.add(namem);

        JLabel lname = new JLabel("Last Name:");
        lname.setFont(new Font("Times New Roman",Font.PLAIN, 16));
        lname.setBounds(680, 260, 100, 30);
        frame.add(lname);

        namel = new JLabel();
        namel.setFont(new Font("Times New Roman",Font.PLAIN, 16));
        namel.setBounds(770, 260, 100, 30);
        frame.add(namel);

        try {
            database data = new database();
            ResultSet resultset = data.s1.executeQuery("select * from members_table where unit_no = '"+box1.getSelectedItem()+"'");
            while (resultset.next()) {
                namef.setText(resultset.getString("name"));
                namem.setText(resultset.getString("m_name"));
                namel.setText(resultset.getString("l_name"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    //  ─────────────────────────────────────────────────────────────────────────────
    // BUTTONS

        remove = new JButton("REMOVE");
        remove.setBounds(340, 460, 100, 30);
        remove.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    database data = new database();
                    String query = "delete from members_table where unit_no = '"+box1.getSelectedItem()+"'";
                    data.s1.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Member Removed Successfully.");
                    frame.setVisible(false);
                    new main_2("MAIN PAGE");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                
            }
            
        });
        frame.add(remove);

        back = new JButton("BACK");
        back.setBounds(540, 460, 100, 30);
        back.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                frame.setVisible(false);
                
            }
            
        });
        frame.add(back);

    
    //  ─────────────────────────────────────────────────────────────────────────────
    // IMAGE

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/image_3.jpg"));
        Image i2 = i1.getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image_label = new JLabel(i3);
        image_label.setBounds(0,0,frame.getWidth(), frame.getHeight());
        frame.add(image_label);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new remove();
    }
}
