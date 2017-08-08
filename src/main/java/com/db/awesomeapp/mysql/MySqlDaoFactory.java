package com.db.awesomeapp.mysql;

import com.db.awesomeapp.dao.DaoFactory;
import com.db.awesomeapp.dao.GenericDao;
import com.db.awesomeapp.exceptions.PersistException;
import com.db.awesomeapp.models.CounterParty;
import com.db.awesomeapp.models.Deal;
import com.db.awesomeapp.models.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class MySqlDaoFactory implements DaoFactory {

    private String user = "test-user";//Логин пользователя
    private String password = "test-user";//Пароль пользователя
    private String url = "jdbc:mysql://192.168.99.100:3306/db_grad_cs_1917";//URL адрес
    private String driver = "com.mysql.jdbc.Driver";//Имя драйвера
    private Map<Class, DaoCreator> creators;

    public Connection getContext() throws PersistException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new PersistException(e);
        }
        return  connection;
    }

    @Override
    public GenericDao getDao(Object connection, Class dtoClass) throws PersistException {
        DaoCreator creator = creators.get(dtoClass);
        if (creator == null) {
            throw new PersistException("Dao object for " + dtoClass + " not found.");
        }
        return creator.create(connection);
    }

    public MySqlDaoFactory() {
        try {
            Class.forName(driver);//Регистрируем драйвер
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        creators = new HashMap<Class, DaoCreator>();
        creators.put(Deal.class, new DaoCreator<Connection>() {
            @Override
            public GenericDao create(Connection connection) {
                return new MySqlDealDao(connection);
            }
        });

        creators.put(User.class, new DaoCreator<Connection>() {
            @Override
            public GenericDao create(Connection connection) {
                return new MySqlUserDao(connection);
            }
        });

        creators.put(CounterParty.class, new DaoCreator<Connection>() {
            @Override
            public GenericDao create(Connection connection) {
                return new MySqlCounterPartyDao(connection);
            }
        });
    }
}
