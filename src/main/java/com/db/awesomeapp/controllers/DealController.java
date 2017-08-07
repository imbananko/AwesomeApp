/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.db.awesomeapp.controllers;

import static com.db.awesomeapp.controllers.UserController.SELECT_ALL_USERS;
import com.db.awesomeapp.models.Deal;
import com.db.awesomeapp.models.User;
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
public class DealController extends AbstractController {

    public static final String SELECT_ALL_DEALS = "SELECT * FROM db_grad_cs_1917.deal";
    public static final String SELECT_DEAL = "SELECT * FROM db_grad_cs_1917.deal WHERE deal_id = ";

    
    @Override
    public List getAll() {
        List<Deal> list = new LinkedList<Deal>();
        PreparedStatement ps = getPrepareStatement(SELECT_ALL_DEALS);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Deal deal = new Deal();
                deal.setId(rs.getInt(1));
                deal.setDealTime(rs.getDate(2));
                deal.setCounterPartyId(rs.getInt(3));
                deal.setInstrumentId(rs.getInt(4));
                deal.setType(rs.getString(5));
                deal.setAmount(rs.getDouble(6));
                deal.setQuantity(rs.getInt(7));
                list.add(deal);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closePrepareStatement(ps);
        }

        return list;
    }

    @Override
    public Deal getEntityById(String id) {
        PreparedStatement ps = getPrepareStatement(SELECT_DEAL + id);
        Deal deal = new Deal();

        try {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                deal.setId(rs.getInt(1));
                deal.setDealTime(rs.getDate(2));
                deal.setCounterPartyId(rs.getInt(3));
                deal.setInstrumentId(rs.getInt(4));
                deal.setType(rs.getString(5));
                deal.setAmount(rs.getDouble(6));
                deal.setQuantity(rs.getInt(7));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closePrepareStatement(ps);
        }

        return deal;
    }

}
