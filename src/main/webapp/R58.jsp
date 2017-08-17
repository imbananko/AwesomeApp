<%-- 
    Document   : R58.jsp
    Created on : 16-Aug-2017, 13:35:14
    Author     : Richard
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*" %>
<%@ page import="com.db.awesomeapp.mysql.ConnectionHandler" %>
<%@ page import="com.db.awesomeapp.mysql.FunctionHandler" %>


<%
    String requirement = request.getParameter("id");
    String result = "tbd";
    ConnectionHandler connectionHandler = new ConnectionHandler();
    FunctionHandler functionHandler = new FunctionHandler(connectionHandler.getConnection());

    switch (requirement) {
        case "avg":
            
            break;

        case "quantity":

            result = functionHandler.getJsonTradesQuantity();

            break;

        case "profit":

            result = functionHandler.getJsonRealisedRate();
            break;
        case "eprofit":
            
            result = functionHandler.getJsonEffectiveRate();
            break;
    }

    out.flush();
    out.print(result);
    //out.print(json);


%>


