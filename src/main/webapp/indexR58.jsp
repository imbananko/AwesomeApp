<%-- 
    Document   : indexR58.jsp
    Created on : 16-Aug-2017, 13:42:12
    Author     : Richard
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

        <!-- Custom Fonts -->
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">

        <title>View All Deals</title>

    </head>

    <body>

        <!-- Navigation -->        
        <nav class="navbar navbar-default" style="background-color: #BDBAAE">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="indexR3.jsp"> 
                        <img src="img/dbLogo.jpg" style="width:30px;height:30px;" />
                    </a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="btn btn-default" style="color:black"><a href="indexR3.jsp">View All Deals (R3)</a></li>
                    </ul>
                    <ul class="nav navbar-nav">
                        <li class="btn btn-default" style="color:black"><a href="indexR4.jsp">Query for Relationships (R4)</a></li>
                    </ul>
                    <ul class="nav navbar-nav">
                        <li class="btn btn-default" style="color:black"><a href="indexR58.jsp">Analysis (R5-8)</a></li>
                    </ul>

                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>     

        <section style="background-color: #BDBAAE" id="services" class="services bg-primary text-white">
            <div class="container">
                <div class="row text-center">
                    <div style="color:black" class="col-lg-10 mx-auto">
                        <h2>Trading Details</h2>
                        <hr class="small">

                        <form >
                            <select id="info" name="View Trading">
                                <option disabled selected value> -- select -- </option>
                                <option value="avg" style="color:black">Average Buy and Sell</option>
                                <option value="quantity" style="color:black">Net Trade</option>
                                <option value="profit" style="color:black">Realized Profit</option>
                                <option value="eprofit" style="color:black">Effective Profit</option>
                            </select>
                            <button type="button" onclick="getTables()">Submit</button>
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
                            }

                            tr:nth-child(even) {
                                background-color: #dddddd;
                            }
                        </style>
                        <div id="dataShow">


                        </div>
                    </div>
                    <!-- /.col-lg-10 -->
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container -->
        </section>




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