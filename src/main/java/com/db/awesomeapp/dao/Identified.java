package com.db.awesomeapp.dao;

import java.io.Serializable;

public interface Identified<PK extends Serializable> {

    /** Returns project id */
    PK getId();
}
