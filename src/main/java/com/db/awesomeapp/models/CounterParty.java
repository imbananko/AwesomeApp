/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.db.awesomeapp.models;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Graduate
 */
public class CounterParty implements Serializable{

    private int counterPartyId;
    private String name;
    private String status;
    private Date registered;

    public int getId() {
        return counterPartyId;
    }

    public void setId(int id) {
        this.counterPartyId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRegisteredDate() {
        return registered;
    }

    public void setRegisteredDate(Date date) {
        registered = date;
    }

    @Override
    public String toString() {
        return "CounterParty{" + "counterPartyId=" + counterPartyId + ", name=" + name + ", status=" + status + ", registered=" + registered + '}';
    }
    
}
