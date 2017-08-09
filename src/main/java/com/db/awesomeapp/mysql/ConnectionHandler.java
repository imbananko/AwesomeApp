package com.db.awesomeapp.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHandler {

    private String user = "root";                                               //sql login
    private String password = "ppp";                                            //sql password
    private String url = "jdbc:mysql://192.168.99.100:3306/db_grad_cs_1917";    //imbananko's docker mysql url
    private String driver = "com.mysql.jdbc.Driver";                            //driver name

    public ConnectionHandler() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            //todo
        }
        return connection;
    }
}