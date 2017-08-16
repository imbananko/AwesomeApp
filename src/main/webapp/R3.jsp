<%-- 
    Document   : R3.jsp
    Created on : 14-Aug-2017, 10:03:58
    Author     : Richard
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*" %>
<%@ page import="com.db.awesomeapp.dao.DealDao" %>
<%@ page import="com.db.awesomeapp.dao.CounterPartyDao" %>
<%@ page import="com.db.awesomeapp.dao.InstrumentDao" %>
<%@ page import="com.db.awesomeapp.models.Deal" %>
<%@ page import="com.db.awesomeapp.models.CounterParty" %>
<%@ page import="com.db.awesomeapp.models.Instrument" %>

<%@ page import="com.db.awesomeapp.mysql.ConnectionHandler" %>
<%@ page import="com.db.awesomeapp.JsonHelper" %>


<%
    String table = request.getParameter("id");
    String result = "<h1>Input is INVALID</h1>";

    if (table != "" || table != null) {

        ConnectionHandler connectionHandler = new ConnectionHandler();
        JsonHelper json = new JsonHelper();
        List<Deal> deal;
        List<CounterParty> counterparty;
        List<Instrument> instrument;

        //CounterParty counterparty = new CounterParty();
        switch (table) {
            case "deal":
                DealDao dealSearch = new DealDao(connectionHandler.getConnection());
                deal = dealSearch.getTopOf(20);
                result = json.getJsonOf(deal);
                break;

            case "counterparty":
                CounterPartyDao counterpartySearch = new CounterPartyDao(connectionHandler.getConnection());
                counterparty = counterpartySearch.getAll();
                //result = counterparty.toString();
                result = json.getJsonOf(counterparty);
                break;

            case "instrument":
                InstrumentDao instrumentDaoSearch = new InstrumentDao(connectionHandler.getConnection());
                instrument = instrumentDaoSearch.getAll();
                //result = counterparty.toString();
                result = json.getJsonOf(instrument);
                break;
        }

        out.flush();
        out.print(result);

    } else {
        out.flush();
        out.println(result);
        out.flush();
    }
%>
