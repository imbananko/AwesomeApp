package com.db;

import com.db.awesomeapp.dao.AbstractDao;
import com.db.awesomeapp.dao.CounterPartyDao;
import com.db.awesomeapp.dao.DealDao;
import com.db.awesomeapp.dao.UserDao;
import com.db.awesomeapp.models.CounterParty;
import com.db.awesomeapp.models.Deal;
import com.db.awesomeapp.models.User;
import com.db.awesomeapp.mysql.ConnectionHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class NewDaoTest {
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
