<%-- 
    Document   : indexR3.jsp
    Created on : 14-Aug-2017, 09:59:25
    Author     : Graduate
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="jquery-3.0.0.js"></script>
        <script type="text/javascript" src="main.js"></script>
        <title>Deutsche Bank Case Study</title>
    </head>
    <body>
        <h3>See All Tables</h3>
        
        
<form >
  <select id="tables" name="Select Tables">
    <option disabled selected value> -- select an table -- </option>
    <option value="deal">deal</option>
    <option value="instrument">instrument</option>
    <option value="counterparty">counterparty</option>
  </select>
    <button type="button" onclick="getTables()">Submit</button>
   
</form>

 <div id="dataShow"></div>




    </body>
</html>
