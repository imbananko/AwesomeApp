/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.db.awesomeapp.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.Date;

/**
 * @author Graduate
 */
public class Deal {
    private int id;
    private Date dealTime;
    private int counterPartyId;
    private int instrumentId;
    private String type;
    private double amount;
    private int quantity;

    public Integer getId() {
        return id;
    }

    public Date getDealTime() {
        return dealTime;
    }

    public int getCounterPartyId() {
        return counterPartyId;
    }

    public int getInstrumentId() {
        return instrumentId;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }

    public void setCounterPartyId(int counterPartyId) {
        this.counterPartyId = counterPartyId;
    }

    public void setInstrumentId(int instrumentId) {
        this.instrumentId = instrumentId;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Deal{" + "id=" + id + ", dealTime=" + dealTime + ", counterPartyId=" + counterPartyId + ", instrumentId=" + instrumentId + ", type=" + type + ", amount=" + amount + ", quantity=" + quantity + '}';
    }

    public String toJsonString() {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "";
        try {
            jsonString = mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }
}
