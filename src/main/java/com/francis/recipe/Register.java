package com.francis.recipe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import static Constants.constants.*;

public class Register {

    public void Connection () throws Exception {
        try {
            Class.forName(DbDriver);
            Connection con = DriverManager.getConnection(DbUrl, accountName, accountPassword);
            Statement st = con.createStatement();
            System.out.println("Connection Successful.");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



}
