package com.db.awesomeapp.mysql;

import com.db.awesomeapp.dao.GenericDao;
import com.db.awesomeapp.dao.Identified;
import com.db.awesomeapp.exceptions.PersistException;

import java.io.Serializable;
import java.sql.Connection;
import java.util.List;

public class MySqlUserDao implements GenericDao {
    public MySqlUserDao(Connection connection) {
    }

    @Override
    public Identified create() throws PersistException {
        return null;
    }

    @Override
    public Identified persist(Identified object) throws PersistException {
        return null;
    }

    @Override
    public Identified getByPK(Serializable key) throws PersistException {
        return null;
    }

    @Override
    public void update(Identified object) throws PersistException {

    }

    @Override
    public void delete(Identified object) throws PersistException {

    }

    @Override
    public List getAll() throws PersistException {
        return null;
    }
}
