<%-- 
    Document   : indexR3.jsp
    Created on : 14-Aug-2017, 09:59:25
    Author     : Richard, Vlad, Jackie 
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <script type="text/javascript" src="jquery-3.0.0.js"></script>
        <script type="text/javascript" src="main.js"></script>

        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="css/stylish-portfolio.css" rel="stylesheet">
        <link href="css/dashboard.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">

        <title>Landing Dashboard</title>

    </head>

    <body style="background: url(img/frankfurtDB.jpg) no-repeat center center scroll; opacity:0.8">
        
        <!-- navbar -->
        <nav class="navbar navbar-inverse navbar-fixed-top">
          <div class="container-fluid">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="index.html">dbTradeViewer</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
              <ul class="nav navbar-nav navbar-right">
                <li><a href="landing.jsp">Dashboard</a></li>
                <li><a href="index.html">Logout</a></li>
                <li><img src="img/dbLogo.jpg" style="width:45px;height:45px;" /></li>
              </ul>
              <form class="navbar-form navbar-right">
                <input type="text" class="form-control" placeholder="Search...">
              </form>
            </div>
          </div>
        </nav>

    
    <div class="container-fluid">
      <div class="row">
        
        <!--<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">-->
        <div>
            <div class="row placeholders" style="background-color: #f5f5f5">
                <h1 class="page-header" style="color:#428bca; font-weight:bold">Welcome!</h1>
            </div>
         
          <div class="row placeholders" style="background-color: #f5f5f5">
            <div class="col-xs-6 col-sm-3 placeholder">
                <br>
                <img src="img/analysis_1.png" width="200" height="200" class="img-responsive" alt=""/>
                <h4><a style="font-weight:bold" href="indexR3.jsp">View All Deals</a></h4>
            </div>
            <div class="col-xs-6 col-sm-3 placeholder">
                <br>
                <img src="img/relationship.png" width="200" height="200" class="img-responsive" alt=""/>
                <h4 ><a style="font-weight:bold" href="indexR4.jsp">Relationships</a></h4>
            </div>
            <div class="col-xs-6 col-sm-3 placeholder">
              <br>
               <img src="img/all_deals.png" width="200" height="200" class="img-responsive" alt=""/>
              <h4><a style="font-weight:bold" href="indexR58.jsp">Analysis</a></h4>
            </div>
            <div class="col-xs-6 col-sm-3 placeholder">
                <br>
                <img src="img/profile.png" width="200" height="200" class="img-responsive" alt=""/>
                <h4 style="font-weight:bold">Profile</h4>
            </div>            
          </div>
        </div>
      </div>
    </div>
        

        <!-- Bootstrap core JavaScript -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/popper/popper.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

        <!-- Plugin JavaScript -->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Custom scripts for this template -->
        <script src="js/stylish-portfolio.js"></script>

    </body>
</html>
