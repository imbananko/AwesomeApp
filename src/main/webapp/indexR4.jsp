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
        <script type="text/javascript" src="mainR4.js"></script>
        <title>Detailed Deal Information</title>
    </head>

    <body>


        <h1>Search by deal ID</h1>
        <form action = "R4.jsp" method = "GET">
            <p>Search Deal ID: <input type="text" id="f_dealID" name="id"></p>
            <button type="button" onclick="getDealByID()">Submit</button>

        </form>
        <p>
        <div id="dealMessage"></div>
    </p>

</body>
</html>