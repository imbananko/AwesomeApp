package com.db.awesomeapp.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
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
    public abstract T getByPK(PK key);

    protected abstract List<T> parseResultSet(ResultSet rs);
    protected abstract void prepareStatementForInsert(PreparedStatement statement, T dao);
    protected abstract void prepareStatementForUpdate(PreparedStatement statement, T dao);

    public List<T> getAll() {
        List<T> list = new LinkedList<>();
        String sql = getSelectQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
        } catch (Exception e) {
            //todo throw new PersistException(e);
        }
        return list;
    }
}
