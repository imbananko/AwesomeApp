package com.db.awesomeapp.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHandler {

    private String user = "test-user";                                               //sql login
    private String password = "test-user";                                            //sql password
    private String url = "jdbc:mysql://34.250.108.7/db_grad_cs_1917";    //imbananko's docker mysql url
    private String driver = "com.mysql.jdbc.Driver";                            //driver name

    public ConnectionHandler() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        return connection;
    }
}