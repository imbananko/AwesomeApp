/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.db.awesomeapp.dao.DaoFactory;
import com.db.awesomeapp.dao.Identified;
import com.db.awesomeapp.models.Deal;
import com.db.awesomeapp.mysql.MySqlCounterPartyDao;
import com.db.awesomeapp.mysql.MySqlDaoFactory;
import com.db.awesomeapp.mysql.MySqlDealDao;
import org.junit.*;

import static org.junit.Assert.*;

/**
 *
 * @author Graduate
 */
//@Test
public class DaoSomeTest {

    @Test
    public void testGetAll() throws Exception {
        DaoFactory daoFactory = new MySqlDaoFactory();
        List<Deal> list;
        try (Connection con = (Connection) daoFactory.getContext()) {
            MySqlDealDao dao = (MySqlDealDao) daoFactory.getDao(con, Deal.class);
            list = dao.getAll();
        }
        Assert.assertNotNull(list);
        Assert.assertTrue(list.size() > 0);
    }

    //@Test
    //public void testCreate() throws Exception {
    //    Identified dto = dao().create();
//
    //    Assert.assertNotNull(dto);
    //    Assert.assertNotNull(dto.getId());
//
    //}

}