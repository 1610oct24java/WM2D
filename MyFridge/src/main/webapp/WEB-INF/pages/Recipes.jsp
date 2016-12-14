<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="resources/css/style.css" rel="stylesheet" type="text/css">
<!-- Latest compiled and minified JavaScript -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.0-rc.2/angular.min.js"></script>
<title>MyFridge | Recipes</title>
</head>
<body class="container" data-ng-app="recipeApp"
	data-ng-controller="recipeController">
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#topFixedNavbar1">
					<span class="sr-only">Toggle navigation</span><span
						class="icon-bar"></span><span class="icon-bar"></span><span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/MyFridge/">WM2D</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="topFixedNavbar1">
				<form:form action="viewFridgeHistory" method="POST"
					class="navbar-form navbar-left">
					<button type="submit" class="btn btn-default">History</button>
				</form:form>
				<form:form action="homepage" method="POST"
					class="navbar-form navbar-left">
					<button type="submit" class="btn btn-default">My Fridge</button>
				</form:form>
				<form:form action="sList" method="POST"
					class="navbar-form navbar-left">
					<button type="submit" class="btn btn-default">Shopping
						List</button>
				</form:form>
				<form:form action="logout" method="POST"
					class="navbar-form navbar-left">
					<button type="submit" class="btn btn-default">Logout</button>
				</form:form>
				<form>
					<div class="form-group" id="searchBar">
						<div class="input-group">
							<div class="input-group-addon">
								<i class="fa fa-search"></i>
							</div>

							<!-- Creating a text search field -->
							<input type="text" class="form-control"
								placeholder="Search Recipes" data-ng-model="searchRecipes"
								id="search">
						</div>
					</div>
				</form>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
	<br>
	<br>
	<!-- Temporary storage for the user information to work with -->
	<input type="hidden" id="test" name="x" value="${UserJSON}">
	<br>

	<!-- Printing out the Recipes -->
	<h1>Recipes</h1>
	<!-- test content -->
	<form>
		<input type='text' data-ng-model='recipe.recipeName'
			placeholder='Recipe Name' spellcheck="true"> | <input
			type='text' data-ng-model='recipe.recipeUrl'
			placeholder='Link to instructions'> <br> <br>
		<textarea rows="5" data-ng-model='recipe.recipeDescription' cols="45"
			placeholder="Custom Instructions" spellcheck="true"></textarea>
		<div>
			<select data-ng-repeat="item in recipe.items  track by $index "
				data-ng-model='recipe.items[$index].itemId'>
				<option data-ng-repeat="item in items | orderBy: 'itemName'"
					value={{item.itemId}}>{{item.itemName}}</option>
			</select> <br>
			<button class="btn btn-sm" data-ng-click="addFormField()">Add
				Item</button>
			<button class="btn btn-sm" data-ng-click="submitRecipe()">Save
				Recipe</button>
		</div>
	</form>
	<br>
	<div class="panel-group" id="accordion1" role="tablist"
		aria-multiselectable="true">
		<div class="panel panel-default"
			data-ng-repeat="recipe in recipes | filter:searchRecipes  | orderBy:'-completion'"
			data-ng-class="{green:recipe.completion == 1, yellow:recipe.completion < 1, red:recipe.completion < 0.5}">
			<div class="panel-heading" role="tab" id="title">
				<p class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion1"
						href="#collapse{{$index}}" style="width: 100%;">{{recipe.recipeName}}
						| {{recipe.userAmount}}/{{recipe.items.length}} required item(s) |
						{{recipe.completion * 100}} %</a>
				</p>
			</div>
			<div id="collapse{{$index}}" class="panel-collapse collapse">
				<div class="panel-body">
					<table class="table table-bordered table-striped" id="recipe-table">
						<tr>
							<td width="150px">Instructions</td>
							<td width="100px">Required Items</td>
						</tr>
						<tr>
							<td width="150px">{{recipe.recipeDescription}}<br> <a
								target="_blank" href="http://{{recipe.recipeUrl}}">{{recipe.recipeUrl}}</a></td>
							<td width="100px"><table>
									<tr data-ng-repeat="item in recipe.items">
										<td>{{item.itemName}}</td>
									</tr>
								</table></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
	<script src="resources/js/Recipes.js" type="text/javascript"></script>
	<script src="resources/js/jquery-1.11.2.min.js" type="text/javascript"></script>
	<script src="resources/js/bootstrap.js" type="text/javascript"></script>
</body>
</html>