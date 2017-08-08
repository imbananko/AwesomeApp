package com.db.awesomeapp.mysql;

import com.db.awesomeapp.dao.AbstractJDBCDao;
import com.db.awesomeapp.exceptions.PersistException;
import com.db.awesomeapp.models.Deal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class MySqlDealDao extends AbstractJDBCDao<Deal, Integer> {

    private class PersistGroup extends Deal {
        public void setId(int id) {
            super.setId(id);
        }
    }

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM db_grad_cs_1917.deal";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO db_grad_cs_1917.deal (deal_time, deal_counterparty_id, deal_instrument_id, deal_type, deal_amount, deal_quantity) \n" +
                "VALUES (?, ?, ?, ?, ?, ?);";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE db_grad_cs_1917.deal " +
                "deal_time = ?, " +
                "deal_counterparty_id = ?, " +
                "deal_instrument_id= ?, " +
                "deal_type = ? " +
                "deal_amount = ? " +
                "deal_quantity = ?" +
                "WHERE id = ?;";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM db_grad_cs_1917.deal WHERE deal_id = ?;";
    }

    @Override
    public Deal create() throws PersistException {
        Deal d = new Deal();
        return persist(d);
    }

    public MySqlDealDao(Connection connection) {
        super(connection);
    }

    @Override
    protected List<Deal> parseResultSet(ResultSet rs) throws PersistException {
        LinkedList<Deal> result = new LinkedList<>();
        try {
            while (rs.next()) {
                PersistGroup group = new PersistGroup();

                group.setId(rs.getInt("deal_id"));
                group.setDealTime(rs.getDate("deal_time"));
                group.setCounterPartyId(rs.getInt("deal_counterparty_id"));
                group.setInstrumentId(rs.getInt("deal_instrument_id"));
                group.setType(rs.getString("deal_type"));
                group.setAmount(rs.getDouble("deal_amount"));
                group.setQuantity(rs.getInt("deal_quantity"));
                result.add(group);
            }
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return result;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Deal object) throws PersistException {
        try {
            statement.setInt(1, object.getId());
            statement.setDate(2, object.getDealTime());
            statement.setInt(3, object.getCounterPartyId());
            statement.setInt(4, object.getInstrumentId());
            statement.setString(5, object.getType());
            statement.setDouble(6, object.getAmount());
            statement.setInt(7, object.getQuantity());
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Deal object) throws PersistException {
        try {
            statement.setInt(1, object.getId());
            statement.setDate(2, object.getDealTime());
            statement.setInt(3, object.getCounterPartyId());
            statement.setInt(4, object.getInstrumentId());
            statement.setString(5, object.getType());
            statement.setDouble(6, object.getAmount());
            statement.setInt(7, object.getQuantity());
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }
}
