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

        <!-- Custom Fonts -->
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">

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
                <li class="btn btn-default" style="color:black"><a href="#blah">Analysis (R5-8)</a></li>
              </ul>

            </div><!-- /.navbar-collapse -->
          </div><!-- /.container-fluid -->
        </nav>        
        
        
        <section style="background-color: #BDBAAE" id="services" class="services bg-primary text-white">
            <div class="container">
                <div class="row text-center">
                    <div class="col-lg-10 mx-auto">
                        <h2>Search by deal ID</h2>
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
                            }

                            tr:nth-child(even) {
                                background-color: #dddddd;
                            }
                        </style>
                        
                        <div id="dataShow">


                                              
                                      
                    </div>
                    <!-- /.col-lg-10 -->
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container -->
        </section>
        

</body>
</html>