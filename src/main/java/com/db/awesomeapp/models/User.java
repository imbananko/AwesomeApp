package com.db.awesomeapp.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Graduate
 */
public class User {

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
