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



    $.ajax({url: url, dataType: "text", success: function (result)
        {
            var data = document.getElementById("showData");
            //data.insertAdjacentHTML("beforeend", result.length);
            if (result.length == 17) {
                load_jsp();
            } else {

                data.innerHTML += "invalid";
            }

        }});

}

function renderData() {

    var data = document.getElementById("showData");
    data.innerHTML += "invalid";

}

function load_jsp() {
    document.write(document.getElementById("showData").innerHTML = '<object type="text/html" data="indexR4.jsp" ></object>');
}


function testConnection(){
    document.getElementById("showConn").innerHTML = '<object type="text/html" data="TestConnection" ></object>';
}