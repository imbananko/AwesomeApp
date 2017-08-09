package com.db;

import com.db.awesomeapp.dao.Identified;
import com.db.awesomeapp.exceptions.PersistException;
import com.db.awesomeapp.models.Deal;
import com.db.awesomeapp.mysql.MySqlDealDao;
import org.junit.Test;

public class MyTest {

    //Deal d = new Deal();


    private Deal getDeal() {
        return new Deal();
    }

    @Test
    public void toTest() throws PersistException {
        GenericDaoTest genericDaoTest = new MySqlDaoTest(Deal.class, new Deal());
        genericDaoTest.testCreate();
        //genericDaoTest.testGetByPK();
    }
}
