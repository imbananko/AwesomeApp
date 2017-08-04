package com.db.awesomeapp.controllers;

import com.db.awesomeapp.models.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Graduate
 */
public class UserController extends AbstractController<User, Integer> {

    public static final String SELECT_ALL_USERS = "SELECT * FROM db_grad_cs_1917.users";
    public static final String SELECT_USER = "SELECT * FROM db_grad_cs_1917.users WHERE user_id = ";

    /**
     * @author imbananko
     * @return List of all entities
     */
    @Override
    public List<User> getAll() {
        List<User> list = new LinkedList<>();
        PreparedStatement ps = getPrepareStatement(SELECT_ALL_USERS);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getString(1));
                user.setPassword(rs.getString(2));
                list.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closePrepareStatement(ps);
        }

        return list;
    }

    @Override
    public User getEntityById(String id) {
        User user = new User();
        PreparedStatement ps = getPrepareStatement(SELECT_USER + "'" + id + "'");
        try {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user.setId(rs.getString(1));
                user.setPassword(rs.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closePrepareStatement(ps);
        }
        return user;
    }

}
