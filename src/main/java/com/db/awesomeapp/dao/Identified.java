package com.db.awesomeapp.dao;

import java.io.Serializable;

public interface Identified<PK extends Serializable> {

    /** Возвращает идентификатор объекта */
    PK getId();
}
