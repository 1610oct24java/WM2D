var app = angular.module('myApp', []);
var items = 0;

app.controller('myController', function($scope, $http) {
	$scope.sortType = '';
	$scope.sortReverse = false;
	$scope.searchItems = ''; 

	$http
		.get("getItems")
		.then(function(response) {
			console.log(response.data);
			items = response.data.items;
			//getNames(items);
			$scope.items = items;
	});
	
	function getNames(items) {
		console.log(items);
		var i = 0;
		items.forEach(function(item) {
			console.log(item);
		});
	}
	
	// for creating items
	//My attempt at using JS for sending the new item to the controller, 
	//it was a complete failure, but its here until I figure out how to 
	//accomplish this
	
//	$scope.newItem = function() {
//		console.log("INSIDE NEWITEM()");
//		makeItem();
//		console.log("DONE");
//		console.log(item);
//		$http
//		.post("addItem", item)
//		.then(function success(response) {
//			
//		}, function error(response) {
//	        console.log("FAILED GET ITEM NAME");
//	    });
//	}
//	var item;
//	function makeItem() {
//		item = {}
//		item.userItemId = -1;
//		item.userId = $scope.items.userId;
//		item.itemId = {
//				"itemId" : -1,
//				"itemName" : $scope.newItemName
//		};
//		item.itemStatus = 1;
//		item.measureAmount = $scope.newItemAmount;
//		item.expirationDate = $scope.newExpirationDate;
//		item.measureType = $scope.newItemMeasureType;
//		item.itemDetails = $scope.newItemDetails;
//		$scope.newItem = item;
//		console.log(item);
//	}
});