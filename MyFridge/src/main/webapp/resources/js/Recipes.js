var app = angular.module('recipeApp', []);
var items = 0;

app.controller('recipeController', function($scope, $http) {
	$scope.sortType = '';
	$scope.sortReverse = false;
	$scope.searchItems = ''; 

	//get all recipes out of database into json objects
	$http
		.get("getRecipes")
		.then(function(response) {
			console.log(response.data);
			recipes = response.data;
			//getNames(items);
			$scope.recipes = recipes;
	});
	
	//get all items out of database into json objects
	$http
		.get("getAllItems")
		.then(function(response){
			console.log(response.data);
			items = response.data;
			$scope.items = items;
	});
	

});


app.controller('NewRecipeCtrl', function($scope, $http) {
	  
	  $scope.recipe = { items:[{itemId: "",itemName: "" }] };

	  $scope.addFormField = function() {
	    $scope.recipe.items.push({itemId: "" ,itemName: "" });
	  }
	  
	  $scope.submitRecipe = function() {
		  $http
		  	.post("addRecipe", $scope.recipe)
		  	.then(function(response){
		  		console.log(response.data);
		  		recipes = response.data;
			
		  		$scope.recipes = recipes;
		  	});
					
	  }
	  
	  
});


/**
 * 
 */