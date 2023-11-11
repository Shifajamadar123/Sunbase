package com.sunbase.CustomerClass;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	Connection con = null;

    public Connection getConnection() {
        try {
            if(con==null)
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sunbase","root","shifa@MYSQL11");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return con;
    }
}
