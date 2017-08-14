package com.db.awesomeapp.dao;

import com.db.awesomeapp.models.Instrument;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class InstrumentDao extends AbstractDao<Instrument, Integer> {

    public InstrumentDao(Connection connection) {
        super(connection);
    }

    @Override
    protected String getSelectQuery() {
        return "SELECT * FROM db_grad_cs_1917.instrument ";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE db_grad_cs_1917.instrument SET instrument_id = ?, instrument_name = ?;";
    }

    @Override
    protected String getDeleteQuery() {
        return "DELETE FROM db_grad_cs_1917.instrument WHERE instrument_id = ?;";
    }

    @Override
    protected String getCreateQuery() {
        return "INSERT INTO db_grad_cs_1917.instrument VALUES (?, ?);";
    }

    @Override
    public Instrument getByPK(Integer key) throws SQLException {
        List<Instrument> list;
        String sql = getSelectQuery();
        sql += " WHERE instrument_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, key);
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
    protected List<Instrument> parseResultSet(ResultSet rs) throws SQLException {
        LinkedList<Instrument> result = new LinkedList<>();
        try {
            while (rs.next()) {
                Instrument instrument = new Instrument();
                instrument.setInstrumentId(rs.getInt("instrument_id"));
                instrument.setInstrumentName(rs.getString("instrument_name"));
                result.add(instrument);
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        return result;
    }

    @Override
    protected void prepareInsertUpdateStatement(PreparedStatement statement, Instrument dao) throws SQLException {
        try {
            statement.setInt(1, dao.getInstrumentId());
            statement.setString(2, dao.getInstrumentName());
        } catch (Exception e) {
            throw new SQLException(e);
        }
    }
}
