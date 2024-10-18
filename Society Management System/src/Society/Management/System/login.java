package Society.Management.System;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class login {

    JTextField username = new JTextField();
    JPasswordField password = new JPasswordField();
    JFrame frame = new JFrame("LOGIN PAGE");
    
    public login(){

        
        frame.setSize(1020,800);
        frame.setLocation(250, 50);

    //  ─────────────────────────────────────────────────────────────────────────────
    // USERNAME

        JLabel label_1 = new JLabel();
        label_1.setText("USERNAME");
        label_1.setBounds(350, 200, 100, 30);
        frame.add(label_1);

    // TEXTFIELD
        username.setBounds(500, 200, 125, 30);
        frame.add(username);

    //  ─────────────────────────────────────────────────────────────────────────────
    // PASSWORD
    
        JLabel label_2 = new JLabel();
        label_2.setText("PASSWORD");
        label_2.setBounds(350, 270, 100, 30);
        frame.add(label_2);

    // TEXTFIELD
        password.setBounds(500, 270, 125, 30);
        frame.add(password);

    //  ─────────────────────────────────────────────────────────────────────────────
    // BUTTON

        JButton login = new JButton();
        // login.setBackground(Color.BLACK);
        // login.setForeground(Color.white);                            To set the background color of the button.
        // login.setOpaque(true);
        // login.setBorderPainted(false);
        login.setText("Login");
        login.setBounds(425, 350, 100, 30);
        frame.add(login);

        JButton back = new JButton();
        // back.setBackground(Color.BLACK);
        // back.setForeground(Color.white);                             To set the background color of the button.
        // back.setOpaque(true);
        // back.setBorderPainted(false);
        back.setText("Back");
        back.setBounds(575, 350, 100, 30); 
        frame.add(back);

        loginlistener l1 = new loginlistener();
        login.addActionListener(l1);      // adding the action listener to login button by creating new class of action listener.

        backlistener b1 = new backlistener();
        back.addActionListener(b1);       // adding the action listener to back button by creating new class of action listener.

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

    //  ─────────────────────────────────────────────────────────────────────────────
    // ACTIONLISTENERS
    // CREATING NEW CLASSES FOR EACH LISTENER OF EACH BUTTON.

    public class loginlistener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            try {
                String user_name = username.getText();
                String pass_word = password.getText();
                
                database data = new database();
                String query = "select * from login_table where username = '"+user_name+ "' and password = '"+pass_word+"'";
                ResultSet resultSet = data.s1.executeQuery(query);

                if (resultSet.next() == true) {
                    frame.setVisible(false);        
                    new main_2(user_name);                   // opening new frame (new class)
                }
                else{
                    JOptionPane.showMessageDialog(frame, "Invalid username or password");
                }
            } 
            catch (Exception E) {
               System.out.println(E.getMessage());

            }
        }

    }

    public class backlistener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }

    }

    public static void main(String[] args) {
        new login();
    }
}
