package com.db.awesomeapp.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class AbstractDao<T, PK extends Serializable> {
    protected Connection connection;

    protected AbstractDao(Connection connection) {
        this.connection = connection;
    }

    protected abstract String getSelectQuery();

    protected abstract String getUpdateQuery();

    protected abstract String getDeleteQuery();

    protected abstract String getCreateQuery();

    public abstract T getByPK(PK key) throws SQLException;

    protected abstract List<T> parseResultSet(ResultSet rs) throws SQLException;

    protected abstract void prepareStatementForInsert(PreparedStatement statement, T dao) throws SQLException;

    protected abstract void prepareStatementForUpdate(PreparedStatement statement, T dao) throws SQLException;

    public List<T> getAll() throws SQLException {
        List<T> list;
        String sql = getSelectQuery();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
        } catch (SQLException e) {
            throw new SQLException(e);
        }

        list = parseResultSet(rs);
        return list;
    }

    public List<T> getTopOf(int top) throws SQLException {
        List<T> list;
        String sql = getSelectQuery();
        sql += " LIMIT ?";
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, top);
            rs = statement.executeQuery();
        } catch (SQLException e) {
            throw new SQLException(e);
        }

        list = parseResultSet(rs);
        return list;
    }


}
