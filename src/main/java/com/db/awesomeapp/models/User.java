package com.db.awesomeapp.models;

import java.io.Serializable;

/**
 *
 * @author Graduate
 */
public class User implements Serializable {

    private String id;
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String name) {
        this.password = name;
    }

    @Override
    public String toString() {
        return "User{"
                + "id=" + id
                + ", password='" + password + '\''
                + '}';
    }
}
