/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * 
 * @author: Richard
 * 
 */

//function to verify user in db for login
function verifyUser() {
    //var ajaxRequest = new XMLHttpRequest();
    var userId = document.getElementById("f_userid");
    var password = document.getElementById("f_password");
    if (userId !== "" && password !== "") {
        var url = "login.jsp?id=" + escape(userId.value) + "&pwd=" + escape(password.value);

        $.ajax({url: url, dataType: "text", success: function (result)
            {

                if (result.length == 17) {
                    //load_jsp();
                    //$("#messageID").load("indexR3.jsp");
                    load_jsp();
                } else {
                    $("#messageID").html("");
                    $("#messageID").html("User ID & Password Invalid");

                    //var data = document.getElementById("showData");


                    //data.innerHTML += "User ID & Password Invalid";


                }

            }});
    } else {
        $("#messageID").html("");
        $("#messageID").html("<p>  User ID & Password Invalid　</p>");
    }
}



//function for getting 1 deal record by Deal ID
function getDealByID() {
    //var ajaxRequest = new XMLHttpRequest();
    var dealID = document.getElementById("f_dealID");
    var url = "R4.jsp?id=" + escape(dealID.value);

    $.ajax({url: url, dataType: "html", success: function (result)
        {
            //displayData(result);
            res = JSON.parse(result);
            var listRes = [res];
            buildHtmlTable(listRes, "#dataShow");
            getcpByID(res.counterPartyId);
            getinsByID(res.instrumentId);
            //var data = document.getElementById("dataShow");
            // data.insertAdjacentHTML("beforeend", res.id);


            //$("#dataShow").innerHTML  += res.id;
            //data = result;

            //displayString(result);

        }});


}

//function to get conterparty by counterparty ID
function getcpByID(id) {
    //var ajaxRequest = new XMLHttpRequest();
    var url = "R4cp.jsp?id=" + escape(id);

    $.ajax({url: url, dataType: "html", success: function (result)
        {
            //displayData(result);
            res = JSON.parse(result);
            var listRes = [res];
            buildHtmlTable(listRes, "#dataShow");

            //var data = document.getElementById("dataShow");
            // data.insertAdjacentHTML("beforeend", res.id);


            //$("#dataShow").innerHTML  += res.id;
            //data = result;

            //displayString(result);

        }});
}

function getinsByID(id) {
    //var ajaxRequest = new XMLHttpRequest();
    var url = "R4ins.jsp?id=" + escape(id);

    $.ajax({url: url, dataType: "html", success: function (result)
        {
            //displayData(result);
            res = JSON.parse(result);
            var listRes = [res];
            buildHtmlTable(listRes, "#dataShow");
            //var data = document.getElementById("dataShow");
            // data.insertAdjacentHTML("beforeend", res.id);


            //$("#dataShow").innerHTML  += res.id;
            //data = result;

            //displayString(result);

        }});
}


// function for getting whole tables by table names 
function getTables() {
    //var ajaxRequest = new XMLHttpRequest();
    var table = document.getElementById("tables");
    var url = "R3.jsp?id=" + escape(table.value);
    $.ajax({url: url, dataType: "html", success: function (result)
        {
            //displayString(result);
            //displayData(result);

            res = JSON.parse(result);
            document.getElementById("dataShow").innerHTML = "";
            //$("#dataShow").html("");

            //var listRes = [res];
            buildHtmlTable(res, "#dataShow");

        }});


}

function dealFilter() {
    var instrument = document.getElementById("f_instrument");
    var party = document.getElementById("f_counterparty");
    var type = document.getElementById("f_type");
    var top = document.getElementById("f_top");
    var url = "dealFilter.jsp?instrument=" + escape(instrument.value) + "&counterparty=" + escape(party.value) + "&type=" + escape(type.value) + "&top=" + escape(top.value);

    //var test = document.getElementById("dataShow2");
    //test.innerHTML+=instrument.value;

    //$("#dataShow2").append(instrument.value);
    //$("#dataShow2").append(party.value);
    //$("#dataShow2").append(type.value);


    $.ajax({url: url, dataType: "html", success: function (result)
        {
            //displayString(result);
            //displayData(result);


            //res = JSON.parse(result);
            res = JSON.parse(result).results;
            document.getElementById("dataShow2").innerHTML = "";
            //$("#dataShow").html("");

            //var listRes = [res];
            buildHtmlTable(res, "#dataShow2");



        }});

}


function getTradeInfo() {
    //var ajaxRequest = new XMLHttpRequest();
    var info = document.getElementById("info");
    var url = "R58.jsp?id=" + escape(info.value);
    //$("#dataShow").append(info.value);
    //$("#dataShow2").append(party.value);
    //$("#dataShow2").append(type.value);

    $.ajax({url: url, dataType: "html", success: function (result)
        {
            //displayString(result);
            //displayData(result);
            //displayString(result);


            res = JSON.parse(result).results;
            //res1 = JSON.parse(res);

            document.getElementById("dataShow").innerHTML = "";
            //$("#dataShow").html("");

            //var listRes = [res];
            buildHtmlTable(res, "#dataShow");

        }});


}




function load_jsp() {
    document.write(document.getElementById("messageID").innerHTML = '<object style="height:100%; width:100%" type="text/html" data="indexR3.jsp" ></object>');
    //document.write('<object type="text/html" data="indexR3.jsp" ></object>');
//    window.location.href = "indexR3.jsp";

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
}



function displayString(message) {
    var data = document.getElementById("dataShow");
    data.insertAdjacentHTML("beforeend", message);


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


function buildHtmlTable(myList, selector) {
    var columns = addAllColumnHeaders(myList, selector);

    for (var i = 0; i < myList.length; i++) {
        var row$ = $('<tr/>');
        for (var colIndex = 0; colIndex < columns.length; colIndex++) {
            var cellValue = myList[i][columns[colIndex]];
            if (cellValue == null)
                cellValue = "";
            row$.append($('<td/>').html(cellValue));
        }
        $(selector).append(row$);
    }
}

// Adds a header row to the table and returns the set of columns.
// Need to do union of keys from all records as some records may not contain
// all records.
function addAllColumnHeaders(myList, selector) {
    var columnSet = [];
    var headerTr$ = $('<tr/>');

    for (var i = 0; i < myList.length; i++) {
        var rowHash = myList[i];
        for (var key in rowHash) {
            if ($.inArray(key, columnSet) == -1) {
                columnSet.push(key);
                headerTr$.append($('<th/>').html(key));
            }
        }
    }
    $(selector).append(headerTr$);

    return columnSet;
}



