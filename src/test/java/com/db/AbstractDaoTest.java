package com.db;

import com.db.awesomeapp.dao.AbstractDao;
import com.db.awesomeapp.dao.InstrumentDao;
import com.db.awesomeapp.models.Instrument;
import com.mysql.jdbc.PreparedStatement;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AbstractDaoTest {
    Connection mockedConn;
    PreparedStatement mockedStatement;
    ResultSet mockedResultSet;
    AbstractDao realDao;

    @Before
    public void setUp() throws Exception {

        mockedConn = mock(Connection.class);
        mockedStatement = mock(PreparedStatement.class);

        mockedResultSet = mock(ResultSet.class);
        when(mockedResultSet.next()).thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(false);
        when(mockedResultSet.getInt(1)).thenReturn(1).thenReturn(2).thenReturn(3);
        when(mockedResultSet.getString(2)).thenReturn("First").thenReturn("Second").thenReturn("Third");

        when(mockedConn.prepareStatement(anyString())).thenReturn(mockedStatement);
        when(mockedStatement.executeQuery()).thenReturn(mockedResultSet);
    }

    @Test
    public void instrumentGetAll() throws Exception {
        realDao = new InstrumentDao(mockedConn);
        List<Instrument> list = new LinkedList<>();
        try {
            list = realDao.getAll();
        } catch (Exception e) {
            System.out.println(e);
        }
        assertEquals(3, list.size());
    }
}
