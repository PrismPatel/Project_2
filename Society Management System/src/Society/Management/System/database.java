package Society.Management.System;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class database {
    
    Connection c1;
    java.sql.Statement s1;

    public database(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/scocietymanagement", "root", "Prism@1234");
            s1 = c1.createStatement();
        } 

        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
