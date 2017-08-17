package com.db;

import com.db.awesomeapp.dao.*;
import com.db.awesomeapp.models.CounterParty;
import com.db.awesomeapp.models.Deal;
import com.db.awesomeapp.models.Instrument;
import com.db.awesomeapp.models.User;
import com.db.awesomeapp.mysql.ConnectionHandler;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class IntegrationDaoTest {

    Connection connection;
    ConnectionHandler connectionHandler;
    UserDao userDao;
    DealDao dealDao;
    InstrumentDao instrumentDao;
    CounterPartyDao counterPartyDao;

    @Before
    public void setUp() {
        connectionHandler = new ConnectionHandler();
        connection = null;
        try {
            connection = connectionHandler.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        userDao = new UserDao(connection);
        instrumentDao = new InstrumentDao(connection);
        counterPartyDao = new CounterPartyDao(connection);
        dealDao = new DealDao(connection);
    }

    @Test
    public void testGetAll() {
        userDao = new UserDao(connection);
        instrumentDao = new InstrumentDao(connection);
        counterPartyDao = new CounterPartyDao(connection);
        dealDao = new DealDao(connection);

        try {
            assertEquals(6, counterPartyDao.getAll().size());
            assertEquals(12, instrumentDao.getAll().size());
            assertEquals(100000, dealDao.getAll().size());
            assertEquals(7, userDao.getAll().size());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetTopOf() {
        userDao = new UserDao(connection);
        instrumentDao = new InstrumentDao(connection);
        counterPartyDao = new CounterPartyDao(connection);
        dealDao = new DealDao(connection);

        int top = 5;

        try {
            assertEquals(5, counterPartyDao.getTopOf(top).size());
            assertEquals(5, instrumentDao.getTopOf(top).size());
            assertEquals(5, dealDao.getTopOf(top).size());
            assertEquals(5, userDao.getTopOf(top).size());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetByPKTest() {
        userDao = new UserDao(connection);
        instrumentDao = new InstrumentDao(connection);
        counterPartyDao = new CounterPartyDao(connection);
        dealDao = new DealDao(connection);

        CounterParty party = new CounterParty();
        Deal deal = new Deal();
        User user = new User();
        Instrument instrument = new Instrument();

        try {
            party = counterPartyDao.getByPK(703);
            deal = dealDao.getByPK(20100);
            user = userDao.getByPK("estelle");
            instrument = instrumentDao.getByPK(1006);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        assertEquals("Richard", party.getName());
        assertEquals("Floral", instrument.getInstrumentName());
        assertEquals(1008, deal.getInstrumentId());
        assertEquals("gradprog2016@05", user.getPassword());

    }
}
