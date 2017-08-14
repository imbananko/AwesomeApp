package com.db.awesomeapp.dao;

import com.db.awesomeapp.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class UserDao extends AbstractDao<User, String> {


    public UserDao(Connection connection) {
        super(connection);
    }

    @Override
    public User getByPK(String key) throws SQLException {
        List<User> list;
        String sql = getSelectQuery();
        sql += " WHERE user_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, key);
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        if (list == null || list.size() == 0) {
            throw new SQLException("Record with PK = " + key + " not found.");
        }
        if (list.size() > 1) {
            throw new SQLException("Received more than one record.");
        }
        return list.iterator().next();
    }

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM db_grad_cs_1917.users";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO db_grad_cs_1917.users (user_id, user_pwd) \n" +
                "VALUES (?, ?);";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE db_grad_cs_1917.users " +
                "user_id = ?, " +
                "user_pwd = ?, ";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM db_grad_cs_1917.users WHERE user_id = ?;";
    }

    @Override
    protected List<User> parseResultSet(ResultSet rs) {
        LinkedList<User> result = new LinkedList<>();
        try {
            while (rs.next()) {
                User user = new User();

                user.setId(rs.getString("user_id"));
                user.setPassword(rs.getString("user_pwd"));

                result.add(user);
            }
        } catch (Exception e) {
            //todo throw new PersistException(e);
        }
        return result;
    }

    @Override
    protected void prepareInsertUpdateStatement(PreparedStatement statement, User user) throws SQLException {
        try {
            statement.setString(1, user.getId());
            statement.setString(2, user.getPassword());
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }
}
