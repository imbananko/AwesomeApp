/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 Document   : mainLogin.js
 Created on : 09-Aug-2017, 18:40:35
 Author     : Richard
 */




function verifyUser() {
    var ajaxRequest = new XMLHttpRequest();
    var userId = document.getElementById("f_userid");
    var password = document.getElementById("f_password");
    var url = "login.jsp?id=" + escape(userId.value) + "&pwd=" + escape(password.value);
    //var url = 'https://learnwebcode.github.io/json-example/animals-1.json';


    $.ajax({url: url, dataType: "text", success: function (result)
        {
            var data = document.getElementById("showData");
            //data.insertAdjacentHTML("beforeend", result.length);
            if (result.length == 17) {
                load_jsp();
            } else {

                data.innerHTML += "invalid";
            }
            //setMessageUsingDOM( result );
        }});
    /*
     ajaxRequest.open('GET',url);
     ajaxRequest.onload = function(){
     var dealRecord = ajaxRequest.responseText;
     //var dealRecord = JSON.parse(ajaxRequest.responseText);
     };
     ajaxRequest.send();
     //document.write("test");
     //$('dealMessage').html("<div>ERROR IN PAGE</div>");
     */
    //renderData(dealRecord);
    //document.write("<h2>" + dealRecord + "</h2>" );

}

function renderData() {
    //$('dealMessage').html("<div>ERROR IN PAGE</div>");
    //document.write("test");
    //var dealData = JSON.parse(message);
    var data = document.getElementById("showData");
    data.innerHTML += "invalid";

}

function load_jsp() {
    //document.write();
    document.getElementById("showData").innerHTML = '<object type="text/html" data="indexR4.jsp" ></object>';
}