package com.db.awesomeapp.mysql;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import javax.json.stream.JsonGenerationException;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;


public class FunctionHandler {

    private Connection connection;

    public FunctionHandler(Connection connection) {
        this.connection = connection;
    }

    public String getJsonAverageBetween(String dateFrom, String dateTo) throws SQLException {
        String sql = "CALL getAverageBetween(?, ?)";

        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.createObjectNode();
        ArrayNode childNodes = mapper.createArrayNode();

        List<ObjectNode> jsonList = new LinkedList<>();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, dateFrom);
            statement.setString(2, dateTo);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                JsonNode element = mapper.createObjectNode();
                ((ObjectNode) element).put("instrumentName", rs.getString(1));
                ((ObjectNode) element).put("averageBuy", rs.getDouble(2));
                ((ObjectNode) element).put("averageSell", rs.getDouble(3));
                childNodes.add(element);
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        } catch (JsonGenerationException e) {
            throw new SQLException(e);
        }
        ((ObjectNode) rootNode).put("ratings", childNodes);
        return rootNode.toString();
    }

    public String getJsonTradesQuantity(Integer partyId) throws SQLException {
        //String sql = "CALL getTradesQuantityById(?)";
        String sql = "CALL getAvgQuantity2(?)";


        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.createObjectNode();
        ArrayNode childNodes = mapper.createArrayNode();

        List<ObjectNode> jsonList = new LinkedList<>();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, partyId);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                JsonNode element = mapper.createObjectNode();
                ((ObjectNode) element).put("instrumentName", rs.getString(1));
                ((ObjectNode) element).put("quantity", rs.getDouble(2));

                childNodes.add(element);
                ((ObjectNode) rootNode).put("trades_average", childNodes);
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        } catch (JsonGenerationException e) {
            throw new SQLException(e);
        }

        return rootNode.toString();
    }

    public String getEffectiveRate(Integer partyId) throws SQLException {
        String sql = "CALL getEffectiveById(?)";

        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.createObjectNode();
        ArrayNode childNodes = mapper.createArrayNode();

        List<ObjectNode> jsonList = new LinkedList<>();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, partyId);
            ResultSet rs = statement.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next()) {
                JsonNode element = mapper.createObjectNode();

                int numColumns = rsmd.getColumnCount();
                // JSONObject obj = new JSONObject();
                for (int i=1; i<=numColumns; i++) {
                    String column_name = rsmd.getColumnName(i);
                    ((ObjectNode) element).put(column_name, rs.getDouble(column_name));
                }
                childNodes.add(element);

            }
        }
        ((ObjectNode) rootNode).put("effectiveRate", childNodes);
        return rootNode.toString();
    }
}
