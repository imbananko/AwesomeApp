package com.db.awesomeapp;

import com.db.awesomeapp.dao.AbstractJDBCDao;
import com.db.awesomeapp.dao.DaoFactory;
import com.db.awesomeapp.dao.Identified;
import com.db.awesomeapp.exceptions.PersistException;
import com.db.awesomeapp.mysql.MySqlDaoFactory;
import com.db.awesomeapp.mysql.MySqlDealDao;

import java.sql.Connection;

/**
 *
 * @author Graduate
 */
public class Main {
    public static void main(String[] args) throws PersistException {


        DaoFactory daoFactory = new MySqlDaoFactory();
        Connection connection = (Connection) daoFactory.getContext();
        AbstractJDBCDao dao = new MySqlDealDao(connection);

        String test = dao.getSelectQuery();
        Identified d = dao.getByPK(20001);

    }
}
