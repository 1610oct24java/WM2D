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
	});
	
	//get all items out of database into json objects
	$http
		.get("getAllItems")
		.then(function(response){
			items = response.data;
			$scope.items = items;
	});
	
	$scope.recipe = { items:[{itemId: "",itemName: "" }] };

	$scope.addFormField = function() {
		$scope.recipe.items.push({itemId: "" ,itemName: "" });
	}
	  
	$scope.submitRecipe = function() {
		var items = $scope.recipe.items;
		$scope.recipe.items=[];
		
		angular.forEach(items, function(item){
			if(item.itemId != ""){
				$scope.recipe.items.push(item);
			}
		})
		$http
			.post("addRecipe", $scope.recipe)
			.then(function(response){
		  		console.log("new response");
		  		console.log(response.data);
		  				
		  		$scope.recipes = response.data;
		  		console.log("after set");
		  		console.log($scope.recipes);
		  		document.location.reload(true);
		  		//THIS NEEDS TO RESET THE PAGE CONTENTS, BUT DOESN'T
		  		//THIS NEEDS TO RESET THE PAGE CONTENTS, BUT DOESN'T
		  		//THIS NEEDS TO RESET THE PAGE CONTENTS, BUT DOESN'T		  	
		  		//THIS NEEDS TO RESET THE PAGE CONTENTS, BUT DOESN'T		  	
		  		//THIS NEEDS TO RESET THE PAGE CONTENTS, BUT DOESN'T		  	
		  	});
		  
	  }
	  
	
	
});


