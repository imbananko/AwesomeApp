<%-- 
    Document   : R3.jsp
    Created on : 14-Aug-2017, 10:03:58
    Author     : Graduate
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*" %>
<%@ page import="com.db.awesomeapp.dao.DealDao" %>
<%@ page import="com.db.awesomeapp.dao.CounterPartyDao" %>
<%@ page import="com.db.awesomeapp.models.Deal" %>
<%@ page import="com.db.awesomeapp.models.CounterParty" %>
<%@ page import="com.db.awesomeapp.mysql.ConnectionHandler" %>

<%
    String table = request.getParameter("id");
    String result = "<h1>Input is INVALID</h1>";

    if (table != "" || table != null) {
        
        ConnectionHandler connectionHandler = new ConnectionHandler();
       
        List<Deal> deal;
        List<CounterParty> counterparty;
        
        //CounterParty counterparty = new CounterParty();
        
        switch(table){
                case "deal": 
                    DealDao dealSearch = new DealDao(connectionHandler.getConnection());
                    deal = dealSearch.getTopOf(20);
                    result = deal.toString();
                    break;
                    
                case "counterparty":
                    CounterPartyDao counterpartySearch = new CounterPartyDao(connectionHandler.getConnection());
                    counterparty = counterpartySearch.getAll();
                    result = counterparty.toString();
                    break;
                    
                    
                case "instrument":
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
