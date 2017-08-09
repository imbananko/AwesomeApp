package com.db.awesomeapp.dao;

import com.db.awesomeapp.models.CounterParty;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class CounterPartyDao extends AbstractDao<CounterParty, Integer> {

    public CounterPartyDao(Connection connection) {
        super(connection);
    }

    @Override
    protected String getSelectQuery() {
        return "SELECT * FROM db_grad_cs_1917.counterparty";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO db_grad_cs_1917.deal (counterparty_id, counterparty_name, counterparty_status, counterparty_date_registered) " +
                "VALUES (?, ?, ?, ?);";
    }

    @Override
    public CounterParty getByPK(Integer key) {
        List<CounterParty> list = new LinkedList<>();
        String sql = getSelectQuery();
        sql += " WHERE counterparty_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, (Integer) key);
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
        } catch (Exception e) {

        }
        if (list == null || list.size() == 0) {
            //todo //throw new PersistException("Record with PK = " + key + " not found.");
        }
        if (list.size() > 1) {
            //todo //throw new PersistException("Received more than one record.");
        }
        return list.iterator().next();
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE db_grad_cs_1917.counterparty " +
                "counterparty_id = ?, " +
                "counterparty_name = ?, " +
                "counterparty_status= ?, " +
                "counterparty_date_registered = ?";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM db_grad_cs_1917.counterparty WHERE counterparty_id = ?;";
    }

    @Override
    protected List<CounterParty> parseResultSet(ResultSet rs) {
        LinkedList<CounterParty> result = new LinkedList<>();
        try {
            while (rs.next()) {
                CounterParty party = new CounterParty();

                party.setId(rs.getInt("counterparty_id"));
                party.setName(rs.getString("counterparty_name"));
                party.setStatus(rs.getString("counterparty_status"));
                party.setRegisteredDate(rs.getDate("counterparty_date_registered"));
                result.add(party);
            }
        } catch (Exception e) {
            //todo throw new PersistException(e);
        }
        return result;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, CounterParty party) {
        try {
            statement.setInt(1, party.getId());
            statement.setString(2, party.getName());
            statement.setString(3, party.getStatus());
            statement.setDate(4, party.getRegisteredDate());
        } catch (Exception e) {

        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, CounterParty party) {
        try {
            statement.setInt(1, party.getId());
            statement.setString(2, party.getName());
            statement.setString(3, party.getStatus());
            statement.setDate(4, party.getRegisteredDate());
        } catch (Exception e) {
            //todo throw new PersistException(e);
        }
    }
}
