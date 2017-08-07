package com.db.awesomeapp;

import com.db.TestConnectionServlet;
import com.db.awesomeapp.models.CounterParty;
import com.db.awesomeapp.controllers.CounterPartyController;
import com.db.awesomeapp.controllers.DealController;
import com.db.awesomeapp.models.Deal;
import java.io.InputStream;
import java.util.List;

/**
 *
 * @author Graduate
 */
public class Main {
    public static void main(String[] args) {
        CounterPartyController cpc = new CounterPartyController();
        CounterParty cp = cpc.getEntityById("703");
        
        //InputStream response = TestConnectionServlet.getInputStream();
        //User test = uc.getEntityById("debs");
        
    }
}
