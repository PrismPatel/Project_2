package Society.Management.System;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class main_2 {
    JFrame frame = new JFrame();

    public main_2(String user_name){

        frame.setSize(1020,800);
        frame.setLocation(250, 50);
        frame.setTitle(user_name);
    
    //  ─────────────────────────────────────────────────────────────────────────────
    // LABEL

        JLabel label_1 = new JLabel();
        label_1.setBounds(355, 150, 350, 30);
        label_1.setText("Society - Control - Panel");
        label_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
        frame.add(label_1);


    //  ─────────────────────────────────────────────────────────────────────────────
    // BUTTONS

        JButton add = new JButton("ADD A MEMBER");
        add.setBounds(430, 250, 150, 30);

                add.addActionListener(new ActionListener() {          // directly adding action listener without implemention in a new class.

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new add_member(user_name);
                    }
                    
                });

        frame.add(add);

        JButton remove = new JButton("REMOVE A MEMBER");
        remove.setBounds(430, 300, 150, 30);

                remove.addActionListener(new ActionListener() {       // directly adding action listener without implemention in a new class.

                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        new remove();
                    }
                    
                });

        frame.add(remove);

        JButton view = new JButton("VIEW MEMBERS");
        view.setBounds(430, 350, 150, 30);

                view.addActionListener(new ActionListener() {       // directly adding action listener without implemention in a new class.

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new view_members();
                        
                    }
                    
                });

        frame.add(view);


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
        new main_2("Default Username");
    }
}
