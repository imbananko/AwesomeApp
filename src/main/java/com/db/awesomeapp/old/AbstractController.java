package com.db.awesomeapp.old;

import java.sql.PreparedStatement;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Graduate
 */
public abstract class AbstractController<E> {

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public AbstractController() {
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
            connection = DriverManager.getConnection("jdbc:mysql://192.168.99.100:3306/db_grad_cs_1917", "test-user", "test-user");

            //DriverManager.registerDriver(new com.mysql.jdbc.Driver ());

        } catch (SQLException ex) {
            Logger.getLogger(AbstractController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public abstract List<E> getAll();

    public abstract E getEntityById(String id);

    public PreparedStatement getPrepareStatement(String sql) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(AbstractController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ps;
    }

    public void closePrepareStatement(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(AbstractController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
