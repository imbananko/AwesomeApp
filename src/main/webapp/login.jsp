<%-- 
    Document   : login.jsp
    Created on : 10-Aug-2017, 16:32:15
    Author     : Richard
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="java.io.*,java.util.*" %>
<%@ page import="com.db.awesomeapp.dao.UserDao" %>
<%@ page import="com.db.awesomeapp.models.User" %>
<%@ page import="com.db.awesomeapp.mysql.ConnectionHandler" %>

<%
    String userId = request.getParameter("id");
    String userPwd = request.getParameter("pwd");
    String validPwd;
    String result = "";
    //String result = "<h1>INVALID USER ID AND PASSWORD</h1>";

    if (userId != "" || userId != null) {
        ConnectionHandler connectionHandler = new ConnectionHandler();
        User user = new User();
        UserDao userSearch = new UserDao(connectionHandler.getConnection());
        user = userSearch.getByPK(userId);
        validPwd = user.getPassword();

        if (validPwd.equals(userPwd)) {

            result = "true";

            out.flush();

            out.print(result);

        } else {
            out.flush();

            out.print(result);
        }

    } else {
        out.flush();
        out.println(result);
        out.flush();
    }
%>




