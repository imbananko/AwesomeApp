<%-- 
    Document   : R58.jsp
    Created on : 16-Aug-2017, 13:35:14
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
<%@ page import="com.db.awesomeapp.mysql.FunctionHandler" %>
<%@ page import="com.db.awesomeapp.mysql.ConnectionHandler" %>
<%@ page import="com.db.awesomeapp.JsonHelper" %>


<%
    String info = request.getParameter("id");
    String result = "<h1>Input is INVALID</h1>";

    if (info != "" || info != null) {

        ConnectionHandler connectionHandler = new ConnectionHandler();
        JsonHelper json = new JsonHelper();
        FunctionHandler fhandler = new FunctionHandler(connectionHandler.getConnection());
        
        List<Deal> deal;
        List<CounterParty> counterparty;
        List<Instrument> instrument;

        //CounterParty counterparty = new CounterParty();
        switch (info) {
            case "avg":
                
                result = json.getJsonOf(deal);
                break;

            case "quantity":
                CounterPartyDao counterpartySearch = new CounterPartyDao(connectionHandler.getConnection());
                counterparty = counterpartySearch.getAll();
                //result = counterparty.toString();
                result = json.getJsonOf(counterparty);
                break;

            case "profit":
                InstrumentDao instrumentDaoSearch = new InstrumentDao(connectionHandler.getConnection());
                instrument = instrumentDaoSearch.getAll();
                //result = counterparty.toString();
                result = json.getJsonOf(instrument);
                break;
                
            case "eprofit":
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
