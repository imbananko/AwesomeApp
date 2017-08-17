package com.db;

import com.db.awesomeapp.dao.InstrumentDao;
import com.db.awesomeapp.models.Instrument;
import com.db.awesomeapp.mysql.ConnectionHandler;
import com.mysql.jdbc.PreparedStatement;
import org.junit.Test;
import org.mockito.Matchers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockTest {
    @Test
    public void setUp() throws Exception {
        Connection conn = mock(Connection.class);

        ConnectionHandler mockedHandler = mock(ConnectionHandler.class);
        when(mockedHandler.getConnection()).thenReturn(conn);

        PreparedStatement mockedStatement = mock(PreparedStatement.class);
        when(conn.prepareStatement(anyString())).thenReturn(mockedStatement);

        List<Instrument> mockList = new LinkedList<>();
        mockList.add(new Instrument(1, "First"));
        mockList.add(new Instrument(2, "Second"));
        mockList.add(new Instrument(3, "Third"));

        ResultSet mockedResultSet = mock(ResultSet.class);
        when(mockedResultSet.next()).thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(false);

        //InstrumentDao realDao = new InstrumentDao(conn);
        InstrumentDao mockedDao = mock(InstrumentDao.class);
        when(mockedDao.parseResultSet(Matchers.any())).thenReturn(mockList);
        when(mockedDao.getByPK(anyInt())).thenCallRealMethod();

        //InstrumentDao dao = new InstrumentDao(conn);
        //when(dao.parseResultSet(Matchers.<ResultSet>any())).thenReturn(mockList);
        Instrument i;
        try {
            i = mockedDao.getByPK(1);
        }
        catch (Exception e) {
            System.out.println(e);
        }


        PreparedStatement query = mock(PreparedStatement.class);
        //when(conn.prepareStatement(anyString())).thenReturn(query);
        when(query.executeQuery()).thenReturn(mockedResultSet);

    }
}
