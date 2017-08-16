package com.db.awesomeapp.mysql;

import com.db.awesomeapp.JsonHelper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import javax.json.stream.JsonGenerationException;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;


public class FunctionHandler {

    protected Connection connection;

    public FunctionHandler(Connection connection) {
        this.connection = connection;
    }

    public String getJsonDealInfo(String partyName, String instrumentName, String type) throws SQLException {
        String sql = "CALL getDealInfo(?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, partyName);
            statement.setString(2, instrumentName);
            statement.setString(3, type);
            ResultSet rs = statement.executeQuery();

            return JsonHelper.resultSetToJson(rs);
        } catch (SQLException e) {
            throw new SQLException(e);
        } catch (JsonGenerationException e) {
            throw new SQLException(e);
        }
    }

    public String getJsonAverageBetween(String dateFrom, String dateTo) throws SQLException {
        String sql = "CALL getAverageBetween(?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, dateFrom);
            statement.setString(2, dateTo);
            ResultSet rs = statement.executeQuery();

            return JsonHelper.resultSetToJson(rs);
        } catch (SQLException e) {
            throw new SQLException(e);
        } catch (JsonGenerationException e) {
            throw new SQLException(e);
        }
    }

    public String getJsonTradesQuantity() throws SQLException {
        String sql = "CALL getTradesQuantity()";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();

            return JsonHelper.resultSetToJson(rs);
        } catch (SQLException e) {
            throw new SQLException(e);
        } catch (JsonGenerationException e) {
            throw new SQLException(e);
        }
    }

    public String getJsonRealisedRate() throws SQLException {
        String sql = "CALL getRealisedRate()";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();

            return JsonHelper.resultSetToJson(rs);
        } catch (SQLException e) {
            throw new SQLException(e);
        } catch (JsonGenerationException e) {
            throw new SQLException(e);
        }
    }

    public String getJsonEffectiveRate() throws SQLException {
        String sql = "CALL getEffectiveRate()";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();

            return JsonHelper.resultSetToJson(rs);
        } catch (SQLException e) {
            throw new SQLException(e);
        } catch (JsonGenerationException e) {
            throw new SQLException(e);
        }
    }

}
