<%@page import="java.util.logging.Logger"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.logging.Level"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.db.awesomeapp.models.CounterParty"%>
<%@page import="java.sql.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/stylish-portfolio.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">

<!DOCTYPE html>
<html>

    <div class="alert alert-info alert-dismissible" role="alert">
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
           <span aria-hidden="true">&times;</span>
        </button>
        <strong> <%= request.getAttribute("connectionStatus") %> </strong> 
    </div>
</html>
