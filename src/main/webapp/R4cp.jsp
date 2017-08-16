<%-- 
    Document   : R4cp.jsp
    Created on : 16-Aug-2017, 11:50:12
    Author     : Richard
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*" %>
<%@ page import="com.db.awesomeapp.dao.CounterPartyDao" %>
<%@ page import="com.db.awesomeapp.models.CounterParty" %>
<%@ page import="com.db.awesomeapp.mysql.ConnectionHandler" %>
<%@ page import="com.db.awesomeapp.JsonHelper" %>


<%
    String userId = request.getParameter("id");
    String result = "<h1>Deal ID is INVALID</h1>";

    if (userId != "" || userId != null) {
        ConnectionHandler connectionHandler = new ConnectionHandler();
        CounterParty counterparty = new CounterParty();
        JsonHelper json = new JsonHelper();
        CounterPartyDao search = new CounterPartyDao(connectionHandler.getConnection());
        counterparty = search.getByPK(Integer.valueOf(userId));

        result = json.getJsonOf(counterparty);

        out.flush();
        out.print(result);
        //out.print(json);

    } else {
        out.flush();
        out.println(result);
        out.flush();
    }
%>