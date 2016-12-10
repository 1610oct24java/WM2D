<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib
	uri="http://www.springframework.org/tags/form"
	prefix="form"
%>
<%@taglib
	prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Latest compiled and minified CSS -->
<link
	rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous"
>
<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"
></script>

<link
	rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
>


<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.0-rc.2/angular.min.js"
></script>
<title>MyFridge | Recipes</title>
</head>
<body
	class="container"
	data-ng-app="recipeApp"
	data-ng-controller="recipeController"
>

	<!-- Temporary storage for the user information to work with -->
	<input
		type="hidden"
		id="test"
		name="x"
		value="${UserJSON}"
	>

	<!-- The JSTL way -->
	<!-- <div>${currentUser}</div> -->
	<form:form
		action="logout"
		method="POST"
		class="navbar-form navbar-left"
	>
		<button
			type="submit"
			class="btn btn-default"
		>Logout</button>
	</form:form>
	<br>

	
	<form>
		<div class="form-group">
			<div class="input-group">
				<div class="input-group-addon">
					<i class="fa fa-search"></i>
				</div>

				<!-- Creating a text search field -->
				<input
					type="text"
					class="form-control"
					placeholder="Search Items"
					data-ng-model="searchItems"
				>

			</div>
		</div>
	</form>

	<!-- Printing out the Recipes -->
	<h1>Recipes</h1>
		
	<ul>
		<li>
		<!-- test content -->

			<form data-ng-controller="NewRecipeCtrl" data-ng-submit="submitRecipe()" > 
    			<input form="newRecipe" type='text' data-ng-model='table.title' placeholder='*RecipeName' required> |
    			<input form="newRecipe" type="text" name="newRecipeLink" placeholder = "Link to instructions" > <br>
    			<textarea form="newRecipe" rows="5" cols="45" placeholder="Custom Instructions"></textarea> <br>
    			
    			<input data-ng-repeat="field in table.fields track by $index" 
    				type='text' data-ng-model='table.fields[$index]' 
    				placeholder='Item'>
    			<div>
      				
      				<button data-ng-click="addFormField()">New Item</button>
      				<button type='submit'>Submit</button>
    			</div>
  			</form>
		<!-- test content -->
			
		<li data-ng-repeat="recipe in recipes">
			{{recipe.recipeName}} | {{recipe.items.length}} item(s) required | {{recipe.recipeUrl}}
			<table class="table table-bordered table-striped" id="recipe-table">
				<tr>
					<td width="150px"> Instructions </td>
					<td width="100px"> Required Items </td>
				</tr>
				<tr>
					<td width="150px">
						{{recipe.recipeDescription}}
					</td>
					<td width="100px">
						<table>
							<tr data-ng-repeat="item in recipe.items">
								<td >
									{{item.itemName}}
								</td>
							</tr>
						</table>
					</td>
				</tr>
				
			</table>
		</li>
	</ul>

	<script
		src="resources/js/Recipes.js"
		type="text/javascript"
	></script>
</body>
</html>