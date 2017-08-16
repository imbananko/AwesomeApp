package com.db.awesomeapp;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

public class JsonHelper {
    public static <T> String getJsonOf(List<T> list) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
    }

    public static <T> String getJsonOf(T object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }

    public static String resultSetToJson(ResultSet rs) throws SQLException {

        ResultSetMetaData rsmd = rs.getMetaData();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.createObjectNode();
        ArrayNode childNodes = mapper.createArrayNode();

        while (rs.next()) {
            JsonNode element = mapper.createObjectNode();

            int numColumns = rsmd.getColumnCount();
            for (int i = 1; i <= numColumns; i++) {
                String column_name = rsmd.getColumnName(i);
                ((ObjectNode) element).put(column_name, rs.getObject(column_name).toString());
            }
            childNodes.add(element);
        }

        ((ObjectNode) rootNode).put("results", childNodes);
        return rootNode.toString();
    }
}
