package com.db;

import com.db.awesomeapp.JsonHelper;
import com.db.awesomeapp.dao.*;
import com.db.awesomeapp.models.CounterParty;
import com.db.awesomeapp.models.Deal;
import com.db.awesomeapp.models.Instrument;
import com.db.awesomeapp.models.User;
import com.db.awesomeapp.mysql.ConnectionHandler;
import com.db.awesomeapp.mysql.FunctionHandler;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class NewDaoTest {

    @Test
    public void instrumentDaoTets() {
        ConnectionHandler connectionHandler = new ConnectionHandler();
        Connection c = null;
        try {
            c = connectionHandler.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        FunctionHandler functionHandler = new FunctionHandler(c);
        //String result;
        //String dateFrom = new Date(2017, 7, 28, 17, 06, 300).toString();
        //String dateTo = new Date(2017, 7, 28, 17, 06, 600).toString();
        //try {
        //    result = functionHandler.getJsonAverageBetween("2017-07-28T17:06:29.955", "2017-07-28 17:06:30.60");
        //} catch (SQLException e) {
        //    e.printStackTrace();
        //}
        ////2017-07-28 17:06:30', '2017-07-28 17:06:30.635


        InstrumentDao dao = new InstrumentDao(c);
        List<Instrument> list;
        Instrument i;

        try {

            list = dao.getAll();
            i = dao.getByPK(1002);
            String x1 = JsonHelper.getJsonOf(i);
            String x2 = functionHandler.getEffectiveRate(701);
            list = dao.getTopOf(2);
            String x = JsonHelper.getJsonOf(list);
            System.out.println("test");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void getByPKTest() {
        ConnectionHandler connectionHandler = new ConnectionHandler();
        Connection c = null;
        try {
            c = connectionHandler.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        DealDao dealDao = new DealDao(c);
        UserDao userDao = new UserDao(c);
        AbstractDao<CounterParty, Integer> partyDao = new CounterPartyDao(c);
        Deal deal;
        CounterParty party;
        User user;
        try {
            deal = dealDao.getByPK(20001);
            user = userDao.getByPK("estelle");
            party = partyDao.getByPK(703);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getAllTest() {
        ConnectionHandler connectionHandler = new ConnectionHandler();
        Connection c = null;
        try {
            c = connectionHandler.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DealDao dealDao = new DealDao(c);
        UserDao userDao = new UserDao(c);
        CounterPartyDao partyDao = new CounterPartyDao(c);
        List<Deal> deal = new LinkedList<>();
        List<CounterParty> party;
        List<User> user;
        try {
            party = partyDao.getAll();
            party = partyDao.getTopOf(2);
            deal = dealDao.getAll();
            user = userDao.getAll();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
