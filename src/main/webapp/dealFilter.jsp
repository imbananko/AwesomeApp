<%-- 
    Document   : dealFilter.jsp
    Created on : Aug 17, 2017, 12:44:07 AM
    Author     : Richard
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*" %>
<%@ page import="com.db.awesomeapp.mysql.ConnectionHandler" %>
<%@ page import="com.db.awesomeapp.mysql.FunctionHandler" %>


<%
    String instrument = request.getParameter("instrument");
    String counterparty = request.getParameter("counterparty");
    String type = request.getParameter("type");

    String result;

    ConnectionHandler connectionHandler = new ConnectionHandler();
    FunctionHandler functionHandler = new FunctionHandler(connectionHandler.getConnection());
    result = functionHandler.getJsonDealInfo(counterparty, instrument, type);

    out.flush();
    out.print(result);
    //out.print(json);


%>
</html>
