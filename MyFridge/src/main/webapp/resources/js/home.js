var app = angular.module('myApp', []);
var items = 0;

app.controller('myController', function($scope, $http, $filter) {
	$scope.sortType = 'itemName';
	$scope.sortReverse = false;
	$scope.searchItems = '';
	$scope.date = new Date();

	$http
		.get("getItems")
		.then(function(response) {
			var items = response.data.items;
			$scope.items = [];
			angular.forEach(items, function(item) {
				if (item.itemStatus == 1) {
					$scope.items.push(item);
				}
			});
		});

	//for calculating difference between dates
	$scope.dateDifference = function(item) {
		var today = ($filter('date')(new Date(), "yyyy-MM-dd"));
		var difference = Date.parse(item.expirationDate) - Date.parse(today);
		return difference;
	}


	//for removing items from list
	$scope.remove = function(item) {
		$http
			.post("removeItemFromFridge", item)
			.then(function success(response) {
				var items = response.data.items;
				$scope.items = [];
				angular.forEach(items, function(item) {
					if (item.itemStatus == 1 || item.itemStatus == 2) {
						$scope.items.push(item);
					}
				});
			}, function error(response) {
				console.log("FAILED TO REMOVE ITEM");
			})
	}

	//for removing items from list
	$scope.update = function(item) {
		$http
			.post("updateItemFromFridge", item)
			.then(function success(response) {
				var items = response.data.items;
				$scope.items = [];
				angular.forEach(items, function(item) {
					if (item.itemStatus == 1 || item.itemStatus == 2) {
						$scope.items.push(item);
					}
				});
			}, function error(response) {
				console.log("FAILED TO REMOVE ITEM");
			})
	}

	//for adding items to list
	$scope.createNewItem = function() {
		makeItem();

		$http
			.post("addItem", $scope.newItem)
			.then(function success(response) {
				var items = response.data.items;
				$scope.items = [];
				angular.forEach(items, function(item) {
					if (item.itemStatus == 1 || item.itemStatus == 2) {
						$scope.items.push(item);
					}
					$scope.newItemName = null;
					$scope.newItemAmount = null;
					$scope.newExpirationDate = null;
					$scope.newItemMeasureType = null;
					$scope.newItemDetails = null;
				});
			}, function error(response) {
				console.log("FAILED GET ITEM NAME");
			});
	}
	var item;
	function makeItem() {
		item = []
		//		item.userItemId = -1;
		item.userId = $scope.items.userId;
		item.itemId = [ {
			"itemId" : -1,
			"itemName" : $scope.newItemName
		} ];
		item.itemStatus = 1;
		item.measureAmount = $scope.newItemAmount;
		item.expirationDate = $scope.newExpirationDate;
		item.measureType = $scope.newItemMeasureType;
		item.itemDetails = $scope.newItemDetails;
		$scope.newItem = item;
	}

});