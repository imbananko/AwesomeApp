<%-- 
    Document   : R4ins.jsp
    Created on : 16-Aug-2017, 12:06:03
    Author     : Richard
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*" %>
<%@ page import="com.db.awesomeapp.dao.InstrumentDao" %>
<%@ page import="com.db.awesomeapp.models.Instrument" %>
<%@ page import="com.db.awesomeapp.mysql.ConnectionHandler" %>
<%@ page import="com.db.awesomeapp.JsonHelper" %>


<%
    String userId = request.getParameter("id");
    String result = "<h1>Deal ID is INVALID</h1>";

    if (userId != "" || userId != null) {
        ConnectionHandler connectionHandler = new ConnectionHandler();
        Instrument instrument = new Instrument();
        JsonHelper json = new JsonHelper();
        InstrumentDao search = new InstrumentDao(connectionHandler.getConnection());
        instrument = search.getByPK(Integer.valueOf(userId));

        result = json.getJsonOf(instrument);

        out.flush();
        out.print(result);
        //out.print(json);

    } else {
        out.flush();
        out.println(result);
        out.flush();
    }
%>