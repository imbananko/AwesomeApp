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

    </head>

    <body>


        <h1>Search by deal ID</h1>
        <form>
            <p>Search Deal ID: <input type="text" id="f_dealID" name="id"></p>

            <button type="button" onclick="getDealByID()">Submit</button>
        </form>


        <p>
        <div id="dataShow"></div>
    </p>


    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
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
</head>
<body>

    <table>
        <tr>
            <th>Deal ID</th>
            <th>Deal Time</th>
            <th>counterPartyId</th>
            <th>instrumentId</th>
            <th>type</th>
            <th>amount</th>
            <th>quantity</th>
        </tr>
        <tr>
            <td id="td0" ></td>
            <td id="td1"></td>
            <td id="td2"></td>
            <td id="td3"></td>
            <td id="td4"></td>
            <td id="td5"></td>
            <td id="td6"></td>
            
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        
    </table>    



</body>
</html>