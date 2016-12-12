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
			//getNames(items);
			$scope.items = items;
		});

	$scope.expDateFilter = function(item) {
		if (item.itemStatus == -1 && item.expirationDate != 0 && item.expirationDate != null) {
			return item;
		}
	};


	function getNames(items) {
		var i = 0;
		items.forEach(function(item) {});
	}
});