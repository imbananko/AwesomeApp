/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//function to verify user in db for login
function verifyUser() {
    var ajaxRequest = new XMLHttpRequest();
    var userId = document.getElementById("f_userid");
    var password = document.getElementById("f_password");
    var url = "login.jsp?id=" + escape(userId.value) + "&pwd=" + escape(password.value);

    $.ajax({url: url, dataType: "text", success: function (result)
        {

            if (result.length == 17) {
                load_jsp();
            } else {
                var data = document.getElementById("showData");
                data.innerHTML += "User ID & Password Invalid";
            }

        }});

}

//function for getting 1 deal record by Deal ID
function getDealByID() {
    var ajaxRequest = new XMLHttpRequest();
    var dealID = document.getElementById("f_dealID");
    var url = "R4.jsp?id=" + escape(dealID.value);

    $.ajax({url: url, dataType: "html", success: function (result)
        {
            displayData(result);

        }});


}

// function for getting whole tables by table names 
function getTables() {
    var ajaxRequest = new XMLHttpRequest();
    var table = document.getElementById("tables");
    var url = "R3.jsp?id=" + escape(table.value);
    $.ajax({url: url, dataType: "html", success: function (result)
        {
            displayData(result);

        }});


}

function test_getTables() {

    /* $('#tables').dropbox(function(){
     $('dataShow').alert('abc');
     
     })
     */

    var table = document.getElementById("tables");
    //var table = document.getElementByName("Select Tables");
    // alert(table.value);
    //var  data = document.getElementById("dataShow");
    //data.innerHTML += table.value;
    //data.insertAdjacentHTML("beforeend",table.value);
    document.write(table.value);

}



function load_jsp() {
    document.write(document.getElementById("showData").innerHTML = '<object type="text/html" data="indexR3.jsp" ></object>');
}


function testConnection() {
    document.getElementById("showConn").innerHTML = '<object type="text/html" data="TestConnection" ></object>';
}

function displayData(message) {
    //var data = document.getElementById("dataShow");
    //data.insertAdjacentHTML("beforeend", message);

    res = JSON.parse(message);
    //keys = res.keys(keys);

    var count = 0;
    for (var key in res) {

        //var data = document.getElementById("td"+key);
        var data = document.getElementById("td" + count);
        data.insertAdjacentHTML("beforeend", res[key]);
        count++;
    }

    //data.insertAdjacentHTML("beforeend", res[keys[0]]);
    //data.insertAdjacentHTML("beforeend", keys);
    //var map = ["id","dealTime","counterPartyId","instrumentId","type","amount","quantity"]

    /*
     for (ind = 0; ind < 7; ind ++){
     var data = document.getElementById("td" + ind);
     data.insertAdjacentHTML("beforeend", res[keys[ind]]);
     
     }
     */

    //document.write(data.insertAdjacentHTML("beforeend", message));

    //data.innerHTML += res.id;
    //data.insertAdjacentHTML("beforeend", res.id);
    //data.insertAdjacentHTML("beforeend", JSON.parse(message)[1].name);

}

function getJson() {
    var ajaxRequest = new XMLHttpRequest();
    var url = 'https://learnwebcode.github.io/json-example/animals-1.json';


    $.ajax({url: url, dataType: "text", success: function (result)
        {
            displayData(result);

        }});


}



