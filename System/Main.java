package Society.Management.System;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Image;

public class Main  {

    public Main(){

        JFrame frame = new JFrame();
        frame.setSize(1020,800);
        frame.setLocation(250,50);
        frame.setTitle("Society Management");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/image_1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image_label = new JLabel(i3);
        image_label.setBounds(0,0,frame.getWidth(), frame.getHeight());
        frame.add(image_label);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);

        try {
            Thread.sleep(5000);
            frame.setVisible(false);
            new login();    // after main gets closed it opens ne wlogin class after 5 seconds.
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}

