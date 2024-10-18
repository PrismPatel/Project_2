package Society.Management.System;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;


public class add_member {

    JTextField f_name, m_name, l_name,  email, contact;
    @SuppressWarnings("rawtypes")
    JComboBox unit;
    JDateChooser date;
    database data = new database();
    String[] units = {"A101","A102","A103","A104","A105","B201","B202","B203","B204","B205"};
    
    public add_member(String user_name){

        JFrame frame = new JFrame("("+user_name+")ADDING A MEMBER");
        frame.setSize(1020,800);
        frame.setLocation(250,50);

        JLabel label = new JLabel();
        label.setBounds(350, 100, 400, 30);
        label.setText("NEW MEMBER'S DETAILS");
        label.setFont(new Font("Times New Roman", Font.BOLD, 28));
        frame.add(label);


    //  ─────────────────────────────────────────────────────────────────────────────
    // FIRST NAME

        JLabel l_f_name = new JLabel("First Name");
        l_f_name.setFont(new Font("Times New Roman",Font.PLAIN, 16));
        l_f_name.setBounds(200, 250, 100, 30);
        frame.add(l_f_name);

        f_name = new JTextField();
        f_name.setBounds(300, 250, 150, 30);
        frame.add(f_name);

    //  ─────────────────────────────────────────────────────────────────────────────
    // MIDDLE NAME

        JLabel l_m_name = new JLabel("Middle Name");
        l_m_name.setFont(new Font("Times New Roman",Font.PLAIN, 16));
        l_m_name.setBounds(550, 250, 100, 30); 
        frame.add(l_m_name);

        m_name = new JTextField();
        m_name.setBounds(650, 250, 150, 30);
        frame.add(m_name);

    //  ─────────────────────────────────────────────────────────────────────────────
    // LAST NAME

        JLabel l_l_name = new JLabel("Last Name");
        l_l_name.setFont(new Font("Times New Roman",Font.PLAIN, 16));
        l_l_name.setBounds(200, 300, 100, 30);
        frame.add(l_l_name);

        l_name = new JTextField();
        l_name.setBounds(300, 300, 150, 30);
        frame.add(l_name);


    //  ─────────────────────────────────────────────────────────────────────────────
    // HOUSE/UNIT

        JLabel l_unit = new JLabel("House/Unit");
        l_unit.setFont(new Font("Times New Roman",Font.PLAIN, 16));
        l_unit.setBounds(550, 300, 100, 30);
        frame.add(l_unit);

        
        ArrayList<String> updatedList = listupdate();
        String[] updatedUnits = updatedList.toArray(new String[0]); 
        unit = new JComboBox<>(updatedUnits);
        unit.setBounds(650, 300, 150, 30);
        frame.add(unit);


    //  ─────────────────────────────────────────────────────────────────────────────
    // CONTACT 

        JLabel l_contact = new JLabel("Contact");
        l_contact.setFont(new Font("Times New Roman",Font.PLAIN, 16));
        l_contact.setBounds(200, 350, 100, 30);
        frame.add(l_contact);

        contact = new JTextField();
        contact.setBounds(300, 350, 150, 30);
        frame.add(contact);



    //  ─────────────────────────────────────────────────────────────────────────────
    // EMAIL

        JLabel l_email = new JLabel("Email");
        l_email.setFont(new Font("Times New Roman",Font.PLAIN, 16));
        l_email.setBounds(550, 350, 100, 30);
        frame.add(l_email);

        email = new JTextField();
        email.setBounds(650, 350, 150, 30);
        frame.add(email);

    //  ─────────────────────────────────────────────────────────────────────────────
    // Date 

        JLabel l_date = new JLabel("Move-In Date");
        l_date.setFont(new Font("Times New Roman",Font.PLAIN, 16));
        l_date.setBounds(385, 190, 100, 30);
        frame.add(l_date);

        date = new JDateChooser();
        date.setBounds(500, 190, 140, 30);
        frame.add(date);


    //  ─────────────────────────────────────────────────────────────────────────────
    // BUTTONS

    // ADD BUTTON

        JButton add = new JButton("ADD");
        add.setBounds(340, 450, 100, 30);
        add.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String fname = f_name.getText();
                String mname = m_name.getText();
                String lname = l_name.getText();
                String dateString = ((JTextField) date.getDateEditor().getUiComponent()).getText();
                String unit_no = (String) unit.getSelectedItem();
                String contact_string = contact.getText();
                String email_string = email.getText();
   
                if (fname.isEmpty() || mname.isEmpty() || lname.isEmpty() || dateString.isEmpty() || unit_no.isEmpty() || contact_string.isEmpty() || email_string.isEmpty() ) {
                    JOptionPane.showMessageDialog(null, "ALL FIELDS ARE MANDATORY. ENTER ALL DETAILS");
                }
                else if (date.getDate() == null || contact_string.length() != 10 || !contact_string.matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "ENTER VALID DETAILS ONLY");
                }
                else{
                    try {
                        
                        String query = "insert into members_table values('"+dateString+"', '"+fname+"', '"+mname+"', '"+lname+"', '"+unit_no+"', '"+contact_string+"', '"+email_string+"')";
                        data.s1.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "DETAILS ADDED SUCCESSFULLY.");
                        frame.setVisible(false);
                        new main_2(user_name);
                    } 
                    catch (Exception E) {
                        System.out.println(E.getMessage());
                    }    
                }       
            }

        });
        frame.add(add);

    // CLEAR BUTTON

        JButton clear = new JButton("CLEAR");
        clear.setBounds(470, 450, 100, 30);
        clear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                date.setDate(null);
                f_name.setText("");
                m_name.setText("");
                l_name.setText("");
                unit.setSelectedIndex(0);
                contact.setText("");
                email.setText("");

            }
            
        });
        frame.add(clear);

    // BACK BUTTON

        JButton back = new JButton("BACK");
        back.setBounds(600, 450, 100, 30);
        back.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
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


    public ArrayList<String> listupdate(){
        ArrayList<String> updated_list = new ArrayList<>();
        try {
            
            String query_2 = "select unit_no from members_table";
            ResultSet resultSet_2 = data.s1.executeQuery(query_2);
            ArrayList<String> dbunits = new ArrayList<>();
            

            while (resultSet_2.next()) {
                dbunits.add(resultSet_2.getString("unit_no"));        // we add the units from database to this list
            }

            for(String i : units){

                if (!dbunits.contains(i)) {
                    updated_list.add(i);
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return updated_list;                                  // updated list with only the units "not present in database".
    }


    public static void main(String[] args) {
        new add_member("default");
    }
}
