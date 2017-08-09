package com.db.awesomeapp.old;

import com.db.awesomeapp.old.AbstractController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionHandler {

    private Connection connection;
    public Connection getConnection() {
        return connection;
    }

    public ConnectionHandler() {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            connection = DriverManager.getConnection("jdbc:mysql://192.168.99.100:3306/db_grad_cs_1917", "test-user", "test-user");
        } catch (SQLException ex) {
            Logger.getLogger(AbstractController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public PreparedStatement getPrepareStatement(String sql) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(AbstractController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return preparedStatement;
    }

    public void closePreparedStatement(PreparedStatement preparedStatement) {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException ex) {
                Logger.getLogger(AbstractController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
