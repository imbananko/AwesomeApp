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

        <title>View All Deals</title>

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
                        <h2 style="font-weight:bold">View All Deals</h2>
                        <hr class="small">

                        <form >
                            <select id="tables" name="Select Tables" onchange="getTables()">
                                <option disabled selected value> -- select an table -- </option>
                                <option value="deal" style="color:black">Deal</option>
                                <option value="instrument" style="color:black">Instrument</option>
                                <option value="counterparty" style="color:black">Counter Party</option>
                            </select>


                            

                            <button style="color:black" type="button" onclick="getTables()">Submit</button>

                            



                            <button style="color:black" type="button" onclick="getTables()">Submit</button>



                        </form>
                        
                        <div align=center> 
                            <style>
                                table {
                                    font-family: arial, sans-serif;
                                    border-collapse: collapse;
                                    width: 100%;
                                }

                                td, th {
                                    border: 1px solid #dddddd;
                                    text-align: center;
                                    padding: 8px;
                                    color: black;
                                    font-weight:bold;
                                }

                                tr:nth-child(even) {
                                    background-color: #dddddd;
                                }
                            </style>
                            
                        </div>
                        
                        <div align=center id="dataShow">

                        </div>
                        
                        <form>
                            <select id="f_instrument">
                                <option disabled selected value> -- select instrument -- </option>
                                <option value="Astronomica" style="color:black">Astronomica</option>
                                <option value="Borealis" style="color:black">Borealis</option>
                                <option value="Celestial" style="color:black">Celestial</option>
                            </select>
                            
                            <select id="f_counterparty">
                                <option disabled selected value> -- select counterparty -- </option>
                                <option value="Lewis" style="color:black">Lewis</option>
                                <option value="Selvyn" style="color:black">Selvyn</option>
                                <option value="Richard" style="color:black">Richard</option>
                            </select>
                            
                            <select id="f_type">
                                <option disabled selected value> -- select buy or sell -- </option>
                                <option value="B" style="color:black">Buy</option>
                                <option value="S" style="color:black">Sell</option>
                               
                            </select>
                            
                            <p stype="display:inline">Top?: <input type="text" id="f_top" name="id"></p>
                            
                            
                            <button style="color:black" type="button" onclick="dealFilter()">Submit</button>
                            
                            
                            
                        </form>
                      

                        <div id="dataShow2">
                        
                        
                        
                        
                        
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
