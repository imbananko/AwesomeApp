package com.db;

import com.db.awesomeapp.dao.AbstractDao;
import com.db.awesomeapp.dao.CounterPartyDao;
import com.db.awesomeapp.dao.DealDao;
import com.db.awesomeapp.dao.UserDao;
import com.db.awesomeapp.models.CounterParty;
import com.db.awesomeapp.models.Deal;
import com.db.awesomeapp.models.User;
import com.db.awesomeapp.mysql.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class NewDaoTest {
    @Test
    public void getByPKTest() {
        ConnectionHandler connectionHandler = new ConnectionHandler();

        DealDao dealDao = new DealDao(connectionHandler.getConnection());
        UserDao userDao = new UserDao(connectionHandler.getConnection());
        AbstractDao<CounterParty, Integer> partyDao = new CounterPartyDao(connectionHandler.getConnection());
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

        DealDao dealDao = new DealDao(connectionHandler.getConnection());
        UserDao userDao = new UserDao(connectionHandler.getConnection());
        CounterPartyDao partyDao = new CounterPartyDao(connectionHandler.getConnection());
        List<Deal> deal = new LinkedList<>();
        List<CounterParty> party;
        List<User> user;
        try {
            deal = dealDao.getAll();
            user = userDao.getAll();
            party = partyDao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Assert.assertEquals(true, deal.length());
    }

    @Test
    public void someTest() {
        ConnectionHandler connectionHandler = new ConnectionHandler();

        DealDao dealDao = new DealDao(connectionHandler.getConnection());
        UserDao userDao = new UserDao(connectionHandler.getConnection());
        CounterPartyDao partyDao = new CounterPartyDao(connectionHandler.getConnection());
        List<Deal> deal;
        List<CounterParty> party;
        List<User> user;
        try {
            deal = dealDao.getAll();
            user = userDao.getAll();
            party = partyDao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
