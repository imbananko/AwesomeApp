<%-- 
    Document   : indexlogin.jsp
    Created on : 10-Aug-2017, 20:12:58
    Author     : Graduate
--%>




<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="jquery-3.0.0.js"></script>
        <script type="text/javascript" src="mainLogin.js"></script>
        <title>Deutsche Bank Case Study</title>
    </head>
    <body>
      <h3>User verification is required</h3>
        <form action = "login.jsp" method = "GET">
            <p>User ID: <input type="text" id="f_userid" name="id"></p>
            <p>Password: <input type="text" id="f_password" name="password"></p>
            <button type="button" onclick="verifyUser()">Verify</button>
            
        </form>
        <p>
            <div id="userIdMessage"></div>
        
    </body>
</html>
