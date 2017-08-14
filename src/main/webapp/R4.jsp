<%-- 
    Document   : R4.jsp
    Created on : 09-Aug-2017, 18:40:35
    Author     : Richard
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="org.json.*" %>
<%@ page import="java.io.*,java.util.*" %>
<%@ page import="com.db.awesomeapp.dao.DealDao" %>
<%@ page import="com.db.awesomeapp.models.Deal" %>
<%@ page import="com.db.awesomeapp.mysql.ConnectionHandler" %>

<%
    String userId = request.getParameter("id");
    String result = "<h1>Deal ID is INVALID</h1>";

    if (userId != "" || userId != null) {
        ConnectionHandler connectionHandler = new ConnectionHandler();
        Deal deal = new Deal();
        DealDao dealSearch = new DealDao(connectionHandler.getConnection());
        deal = dealSearch.getByPK(Integer.valueOf(userId));
        //result = deal.toString();
        result = deal.toJsonString();
        
        /*
        JSONObject json = new JSONObject();
        json.put("id",deal.getId());
        json.put("dealTime",deal.getDealTime());
        json.put("counterPartyId",deal.getCounterPartyId());
        json.put("instrumentId",deal.getInstrumentId());
        json.put("type",deal.getType());
        json.put("amount",deal.getAmount());
        json.put("quantity",deal.getQuantity());
        */
       

        out.flush();
        out.print(result);
        //out.print(json);

    } else {
        out.flush();
        out.println(result);
        out.flush();
    }
%>