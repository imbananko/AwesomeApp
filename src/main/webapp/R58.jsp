<%-- 
    Document   : R58.jsp
    Created on : 16-Aug-2017, 13:35:14
    Author     : Richard
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*" %>
<%@ page import="com.db.awesomeapp.mysql.ConnectionHandler" %>
<%@ page import="com.db.awesomeapp.mysql.FunctionHandler" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.SQLException" %>


<%
    String requirement = request.getParameter("id");
    String result = "tbd";

    //out.print(requirement);
    ConnectionHandler connectionHandler = new ConnectionHandler();
    Connection c = null;
        try {
            c = connectionHandler.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    FunctionHandler functionHandler = new FunctionHandler(c);

    switch (requirement) {
        case "avg":

            break;

        case "quantity":

            //result = functionHandler.getJsonTradesQuantity();
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


