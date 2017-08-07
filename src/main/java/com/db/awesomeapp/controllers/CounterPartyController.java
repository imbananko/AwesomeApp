/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.db.awesomeapp.controllers;

import com.db.awesomeapp.models.CounterParty;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Graduate
 */
public class CounterPartyController extends AbstractController<CounterParty> {

    public static final String SELECT_ALL_PARTIES = "SELECT * FROM db_grad_cs_1917.counterparty LIMIT 0, 1000";
    public static final String SELECT_PARTY = "SELECT * FROM db_grad_cs_1917.counterparty WHERE counterparty_id = ";

    /**
     * @author imbananko
     * @return List of all entities
     */
    @Override
    public List<CounterParty> getAll() {
        List<CounterParty> list = new LinkedList<CounterParty>();
        PreparedStatement ps = getPrepareStatement(SELECT_ALL_PARTIES);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CounterParty party = new CounterParty();
                party.setId(rs.getInt(1));
                party.setName(rs.getString(2));
                party.setStatus(rs.getString(3));
                party.setRegisteredDate(rs.getDate(4));
                list.add(party);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CounterPartyController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closePrepareStatement(ps);
        }

        return list;
    }

    @Override
    public CounterParty getEntityById(String id) {
        CounterParty party = new CounterParty();
        PreparedStatement ps = getPrepareStatement(SELECT_PARTY + id);
        try {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                party.setId(rs.getInt(1));
                party.setName(rs.getString(2));
                party.setStatus(rs.getString(3));
                party.setRegisteredDate(rs.getDate(4));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closePrepareStatement(ps);
        }
        return party;
    }

}
