/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.db.awesomeapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Graduate
 */
public class Main {

    public static void main(String[] args) {
        try {
            Connection connection = null;
            try {
                connection = DriverManager.getConnection("jdbc:mysql://192.168.99.100:3306/db_grad_cs_1917", "test-user", "test-user");
            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Statement statement = null;
            
            if (connection != null) {
                statement = connection.createStatement();
            }
            
            ResultSet resultSet = null;
            if (statement != null) {
                resultSet = statement.executeQuery("select * from db_grad_cs_1917.users");
            }
            
            while (resultSet.next()) {
                System.out.println(resultSet.getString("user_id"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
