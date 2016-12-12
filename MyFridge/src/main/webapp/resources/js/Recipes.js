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
			recipes = response.data;
			//getNames(items);
			$scope.recipes = recipes;

			$http
				.get("getRecipesPercentages")
				.then(function(response) {
					var mappedRecipes = response.data;
					var recipes = $scope.recipes
					$scope.recipes = [];
					angular.forEach(recipes, function(recipe) {
						recipe.userAmount = 0;
						recipe.completion = 0;
						angular.forEach(mappedRecipes, function(mapRecipe) {
							if (recipe.recipeId == mapRecipe[0]) {
								recipe.userAmount = mapRecipe[1];
								recipe.completion = mapRecipe[1] / recipe.items.length;
							}
						});
					});
					$scope.recipes = recipes;

				});
		});

	//get all items out of database into json objects
	$http
		.get("getAllItems")
		.then(function(response) {
			items = response.data;
			$scope.items = items;
		});

	$scope.recipe = {
		items : [ {
			itemId : "",
			itemName : ""
		} ]
	};

	$scope.addFormField = function() {
		$scope.recipe.items.push({
			itemId : "",
			itemName : ""
		});
	}

	$scope.submitRecipe = function() {
		var items = $scope.recipe.items;
		$scope.recipe.items = [];

		angular.forEach(items, function(item) {
			if (item.itemId != "") {
				$scope.recipe.items.push(item);
			}
		})
		$http
			.post("addRecipe", $scope.recipe)
			.then(function(response) {

				$scope.recipes = response.data;
				document.location.reload(true);
			//THIS NEEDS TO RESET THE PAGE CONTENTS, BUT DOESN'T		  	
			});
	}
});