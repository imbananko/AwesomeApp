/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.db;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.db.awesomeapp.dao.GenericDao;
import com.db.awesomeapp.dao.Identified;
import com.db.awesomeapp.exceptions.PersistException;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

/**
 *
 * @author Graduate
 */
public abstract class GenericDaoTest<Context> {

    /**
     * Класс тестируемого дао объекта
     */
    protected Class daoClass;

    /**
     * Экземпляр доменного объекта, которому не соответствует запись в системе хранения
     */
    protected Identified notPersistedDto;

    /**
     * Экземпляр тестируемого дао объекта
     */
    public abstract GenericDao dao();

    /**
     * Контекст взаимодействия с системой хранения данных
     */
    public abstract Context context();

    @Test
    public void testCreate() throws PersistException {
        Identified dto = dao().create();

        Assert.assertNotNull(dto);
        Assert.assertNotNull(dto.getId());
    }

    @Test
    public void testPersist() throws Exception {
        Assert.assertNull("Id befor persist is not null.", notPersistedDto.getId());

        notPersistedDto = dao().persist(notPersistedDto);

        Assert.assertNotNull("After persist id is null.", notPersistedDto.getId());
    }

    @Test
    public void testGetByPK() throws Exception {
        Serializable id = dao().create().getId();
        Identified dto = dao().getByPK(id);
        Assert.assertNotNull(dto);
    }

    @Test
    public void testDelete() throws Exception {
        Identified dto = dao().create();
        Assert.assertNotNull(dto);

        List list = dao().getAll();
        Assert.assertNotNull(list);

        int oldSize = list.size();
        Assert.assertTrue(oldSize > 0);

        dao().delete(dto);

        list = dao().getAll();
        Assert.assertNotNull(list);

        int newSize = list.size();
        Assert.assertEquals(1, oldSize - newSize);
    }

    @Test
    public void testGetAll() throws Exception {
        List list = dao().getAll();
        Assert.assertNotNull(list);
        Assert.assertTrue(list.size() > 0);
    }

    public GenericDaoTest(Class clazz, Identified<Integer> notPersistedDto) {
        this.daoClass = clazz;
        this.notPersistedDto = notPersistedDto;
    }

}