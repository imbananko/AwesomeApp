package com.db.awesomeapp;

import com.db.awesomeapp.models.CounterParty;
import com.db.awesomeapp.controllers.CounterPartyController;
import com.db.awesomeapp.controllers.DealController;
import com.db.awesomeapp.models.Deal;
import java.util.List;

/**
 *
 * @author Graduate
 */
public class Main {
    public static void main(String[] args) {
        CounterPartyController p = new CounterPartyController();
        List<CounterParty> asd = p.getAll();
        
        DealController dp = new DealController();
        Deal deal = dp.getEntityById(Integer.toString(20005));
        List<Deal> asd1 = dp.getAll();
        
        //User test = uc.getEntityById("debs");
        
    }
}
