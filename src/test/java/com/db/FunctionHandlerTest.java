package com.db;

import com.db.awesomeapp.mysql.ConnectionHandler;
import com.db.awesomeapp.mysql.FunctionHandler;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.assertTrue;

public class FunctionHandlerTest {

    Connection connection;
    ConnectionHandler connectionHandler;
    FunctionHandler functionHandler;

    @Before
    public void setUp() {
        connectionHandler = new ConnectionHandler();
        connection = null;
        try {
            connection = connectionHandler.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        functionHandler = new FunctionHandler(connection);
    }

    @Test
    public void getAverageBetweenTest() {
        String json = "";
        try {
            json = functionHandler.getJsonAverageBetween("2017-07-28T17:06:30.049", "2017-07-28T17:06:30.079");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String[] divided = json.split("buyAverage");
        assertTrue(10 <= divided.length);
    }

    @Test
    public void getDealInfoTest() {
        String json = "";
        try {
            json = functionHandler.getJsonDealInfo("Lina", "Eclipse", "S", 10);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String[] divided = json.split("instrument_name");
        assertTrue(10 <= divided.length);
    }

    //
    @Test
    public void getTradesQuantityTest() {
        String json = "";
        try {
            json = functionHandler.getJsonTradesQuantity();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String[] divided = json.split("instrument_name");
        assertTrue(10 <= divided.length);
    }

    @Test
    public void getJsonRealisedRateTest() {
        String json = "";
        try {
            json = functionHandler.getJsonRealisedRate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String[] divided = json.split("instrument_name");
        assertTrue(10 <= divided.length);
    }

    @Test
    public void getJsonEffectiveRateTest() {
        String json = "";
        try {
            json = functionHandler.getJsonEffectiveRate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String[] divided = json.split("instrument_name");
        assertTrue(10 <= divided.length);
    }

}
