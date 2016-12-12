var app = angular.module('myApp', []);
var items = 0;

app.controller('myController', function($scope, $http) {
	$scope.sortType = '';
	$scope.sortReverse = false;
	$scope.searchItems = '';

	$http
		.get("getItems")
		.then(function(response) {
			items = response.data.items;
			$scope.items = items;
		});

	$scope.statusFilter = function(item) {
		if (item.itemStatus === 0 || item.itemStatus === 2) {
			return item;
		}
	};


	function getNames(items) {
		var i = 0;
		items.forEach(function(item) {});
	}

	$scope.remove = function(item) {
		$http
			.post("removeItemFromShoppingList", item)
			.then(function success(response) {
				var items = response.data.items;
				$scope.items = items;
			}, function error(response) {
				console.log("FAILED TO REMOVE ITEM");
			})
	}

	//for adding items to list
	$scope.createNewItem = function() {
		makeItem();
		$http
			.post("addItemToShoppingList", $scope.newItem)
			.then(function success(response) {
				var items = response.data.items;
				$scope.items = [];
				angular.forEach(items, function(item) {
					if (item.itemStatus == 0 || item.itemStatus == 2) {
						$scope.items.push(item);
						window.location.reload(true);
					}
				});
			}, function error(response) {
				console.log("FAILED GET ITEM NAME");
			});
	}
	var item;
	function makeItem() {
		item = {}
		item.userId = $scope.items.userId;
		item.itemId = {
			"itemId" : -1,
			"itemName" : $scope.newItemName
		};
		item.itemStatus = 0;
		item.measureAmount = $scope.newItemAmount;
		item.expirationDate = "0";
		item.measureType = "";
		item.itemDetails = $scope.newItemDetails;
		$scope.newItem = item;
	}
});
function printData() {
	var divToPrint = document.getElementById("table").parentNode;
	newWin = window.open("");
	newWin.document.write(divToPrint.outerHTML);
	newWin.print();
	newWin.close();
}
;