<%-- 
    Document   : indexR4.jsp
    Created on : 09-Aug-2017, 18:40:35
    Author     : Richard, Jackie
--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="jquery-3.0.0.js"></script>
        <script type="text/javascript" src="main.js"></script>
        <title>Detailed Deal Information</title>
        
        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="css/stylish-portfolio.css" rel="stylesheet">
        <link href="css/dashboard.css" rel="stylesheet">
        
        <!-- Custom Fonts -->
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">

    </head>

    <body style="background: url(img/frankfurtDB.jpg) no-repeat center center scroll; opacity:0.7">
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
              <a style="font-weight:bold; font-size: 2em" class="navbar-brand" href="index.html">dbTradeViewer</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
              <ul class="nav navbar-nav navbar-right">
                <li><a style="font-weight:bold; font-size: 2em" href="landing.jsp">Dashboard</a></li>
                <li><a style="font-weight:bold; font-size: 2em" href="indexR3.jsp">View All Deals</a></li>
                <li><a style="font-weight:bold; font-size: 2em" href="indexR4.jsp">Relationships</a></li>
                <li><a style="font-weight:bold; font-size: 2em" href="indexR58.jsp">Analysis</a></li>
                <li><a style="font-weight:bold; font-size: 2em" href="index.html">Logout</a></li>
                <li><img src="img/dbLogo.jpg" style="width:45px;height:45px;" /></li>
              </ul>
              <form class="navbar-form navbar-right">
                <input type="text" class="form-control" placeholder="Search...">
              </form>
            </div>
          </div>
        </nav>      
        
        
        <section id="portfolio" class="portfolio">
            <div style="background-color: #f5f5f5" class="container">
                <div class="row text-center">
                    <div class="col-lg-10 mx-auto">
                        <h2 style="font-weight:bold">Search by deal ID</h2>
                        <hr class="small">

                        <form>
                            <p>Search Deal ID: <input type="text" id="f_dealID" name="id"></p>

                            <button style="color:black" type="button" onclick="getDealByID()">Submit</button>
                        </form>
                        
                        <style>
                            table {
                                font-family: arial, sans-serif;
                                border-collapse: collapse;
                                width: 100%;
                                color: black;
                            }

                            td, th {
                                border: 1px solid #dddddd;
                                text-align: left;
                                padding: 8px;
                                color: black;
                                font-weight:bold;
                            }

                            tr:nth-child(even) {
                                background-color: #dddddd;
                            }
                        </style>
                        
                        <div align=center id="dataShow">
                            
                        </div>
                    <!-- /.col-lg-10 -->
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container -->
        </section>
        

</body>
</html>