package com.db.awesomeapp.mysql;

import com.db.awesomeapp.JsonHelper;

import javax.json.stream.JsonGenerationException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class FunctionHandler {

    protected Connection connection;

    public FunctionHandler(Connection connection) {
        this.connection = connection;
    }

    public String getJsonDealInfo(String partyName, String instrumentName, String type, int top) throws SQLException {
        String sql = "CALL getDealInfoB21(?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, partyName);
            statement.setString(2, instrumentName);
            statement.setString(3, type);
            statement.setInt(4, top);
            ResultSet rs = statement.executeQuery();

            return JsonHelper.resultSetToJson(rs);
        } catch (SQLException e) {
            throw new SQLException(e);
        } catch (JsonGenerationException e) {
            throw new SQLException(e);
        }
    }

    public String getJsonAverageBetween(String dateFrom, String dateTo) throws SQLException {
        String sql = "CALL getAverageBetweenB21(?, ?)";

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
        String sql = "CALL getTradesQuantityB21()";

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
        String sql = "CALL getRealisedRateB21()";

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
        String sql = "CALL getEffectiveRateB21()";

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
