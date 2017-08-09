package com.db.awesomeapp.dao;

import com.db.awesomeapp.models.Deal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class DealDao extends AbstractDao<Deal, Integer> {

    public DealDao(Connection connection) {
        super(connection);
    }

    @Override
    public Deal getByPK(Integer key)  {
        List<Deal> list = new LinkedList<>();
        String sql = getSelectQuery();
        sql += " WHERE deal_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, key);
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
        } catch (Exception e) {
            //todo
        }
        if (list == null || list.size() == 0) {
            //todo throw new PersistException("Record with PK = " + key + " not found.");
        }
        if (list.size() > 1) {
            //todo throw new PersistException("Received more than one record.");
        }
        return list.iterator().next();
    }

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM db_grad_cs_1917.deal";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO db_grad_cs_1917.deal (deal_id, deal_time, deal_counterparty_id, deal_instrument_id, deal_type, deal_amount, deal_quantity) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?);";
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
    protected List<Deal> parseResultSet(ResultSet rs) {
        LinkedList<Deal> result = new LinkedList<>();
        try {
            while (rs.next()) {
                Deal deal = new Deal();

                deal.setId(rs.getInt("deal_id"));
                deal.setDealTime(rs.getDate("deal_time"));
                deal.setCounterPartyId(rs.getInt("deal_counterparty_id"));
                deal.setInstrumentId(rs.getInt("deal_instrument_id"));
                deal.setType(rs.getString("deal_type"));
                deal.setAmount(rs.getDouble("deal_amount"));
                deal.setQuantity(rs.getInt("deal_quantity"));
                result.add(deal);
            }
        } catch (Exception e) {
            //todo
        }
        return result;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Deal deal) {
        try {
            statement.setInt(1, deal.getId());
            statement.setDate(2, deal.getDealTime());
            statement.setInt(3, deal.getCounterPartyId());
            statement.setInt(4, deal.getInstrumentId());
            statement.setString(5, deal.getType());
            statement.setDouble(6, deal.getAmount());
            statement.setInt(7, deal.getQuantity());
        } catch (Exception e) {
//todo
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Deal object) {
        try {
            statement.setInt(1, object.getId());
            statement.setDate(2, object.getDealTime());
            statement.setInt(3, object.getCounterPartyId());
            statement.setInt(4, object.getInstrumentId());
            statement.setString(5, object.getType());
            statement.setDouble(6, object.getAmount());
            statement.setInt(7, object.getQuantity());
        } catch (Exception e) {
            //todo throw new PersistException(e);
        }
    }
}
