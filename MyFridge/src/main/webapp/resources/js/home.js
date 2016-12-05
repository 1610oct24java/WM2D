var app = angular.module('myApp', []);

window.onload = function() {
	console.log("ONLOAD!!!!");
//    
//	$http
//	.get("getItems")
//    .then(makeItemTable(response));
}

app.controller('myController', function($scope, $http) {
	console.log("BEFORE REQUEST");
    
	$http
	.post("getItems")
    .then(function(response) {
    	console.log(response);
    });	   
});

//function makeItemTable(response) {
//	console.log(response);
//	console.log("inside make item table")
//	var table = document.getElementById("table");
//	var i = 0;
//	response.forEach(function(item) {
//		var row = table.insertRow(i);
//		var cell0 = row.insertCell(0);
//		var cell1 = row.insertCell(1);
//		var cell2 = row.insertCell(2);
//		var cell3 = row.insertCell(3);
//		
//		cell0.innerHTML = item.itemId;
//		cell1.innerHTML = item.itemStatus;
//		cell2.innerHTML = item.measureAmount;
//		cell3.innerHTML = item.expirationDate;
//		
//		i++;
//	});
//}