/*
    Document   : mainR4.js
    Created on : 09-Aug-2017, 18:40:35
    Author     : Richard
*/

var showData = document.getElementById("dealMessage");


function getDealByID(){
	var ajaxRequest = new XMLHttpRequest();
	var dealID = document.getElementById("f_dealID");
	var url = "R4.jsp?id="+ escape(dealID.value);
	//var url = 'https://learnwebcode.github.io/json-example/animals-1.json';
	
        
	$.ajax({url: url,dataType: "html", success: function( result )
    {
        renderData( result );
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

function renderData(message){
	//$('dealMessage').html("<div>ERROR IN PAGE</div>");
	//document.write("test");
	//var dealData = JSON.parse(message);
	document.write(message);
	
}



