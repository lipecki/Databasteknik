package com;

import password.*;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by jlipecki on 2016-11-19.
 */
public class Connector {

    private String pw;
    private final PasswordField pf;
    public Connector(){
        pf = new PasswordField();
    }


    public Connection getConnection(){
        Connection connection = null;

        try{
            pw = pf.readPassword("Please enter passphrase: ");
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", pw);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return connection;
    }
}
