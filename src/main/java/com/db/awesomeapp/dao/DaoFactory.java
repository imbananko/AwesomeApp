package com.db.awesomeapp.dao;

import com.db.awesomeapp.exceptions.PersistException;

/** Фабрика объектов для работы с базой данных */
public interface DaoFactory<Context> {

    interface DaoCreator<Context> {
        public GenericDao create(Context context);
    }

    /** Возвращает подключение к базе данных */
    Context getContext() throws PersistException;

    /** Возвращает объект для управления персистентным состоянием объекта */
    GenericDao getDao(Context context, Class dtoClass) throws PersistException;
}
