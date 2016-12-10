var app = angular.module('recipeApp', []);
var items = 0;

app.controller('recipeController', function($scope, $http) {
	$scope.sortType = '';
	$scope.sortReverse = false;
	$scope.searchItems = ''; 

	$http
		.get("getRecipes")
		.then(function(response) {
			console.log(response.data);
			recipes = response.data;
			//getNames(items);
			$scope.recipes = recipes;
	});
	
	

});


app.controller('NewRecipeCtrl', function($scope) {
  
  $scope.table = { fields: [] };

  $scope.addFormField = function() {
    $scope.table.fields.push('');
  }

  $scope.submitTable = function() {
    console.log($scope.table);
  }
  
});


/**
 * 
 */