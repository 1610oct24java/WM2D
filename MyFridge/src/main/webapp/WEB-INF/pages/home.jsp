<%@ page
	language="java"
	contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
%>
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
<meta
	http-equiv="Content-Type"
	content="text/html; charset=ISO-8859-1"
>
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
<title>MyFridge | Home</title>
</head>

<!-- Setting up angular app/controller -->
<body
	class="container"
	data-ng-app="myApp"
	data-ng-controller="myController"
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
	<form:form
		action="viewRecipes"
		method="POST"
		class="navbar-form navbar-left"
	>
		<button
			type="submit"
			class="btn btn-default"
		>View Recipes</button>
	</form:form>


	<form:form
		action="sList"
		method="GET"
		class="navbar-form navbar-left"
	>
		<button
			type="submit"
			class="btn btn-default"
		>Shopping List</button>
	</form:form>
	<br>
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

	<!-- Printing out the User's items -->
	<h1>Fridge</h1>
	<table
		id=table
		class="table table-bordered table-striped"
	>
		<!-- Setting up table to be sortable via title click -->
		<thead>
			<tr>
				<th><a
					href='#'
					data-ng-click="sortType = 'name'; sortReverse = !sortReverse"
				> Name <span
						data-ng-show="sortType == 'name' && !sortReverse"
						class="fa fa-caret-down"
					></span> <span
						data-ng-show="sortType == 'name' && sortReverse"
						class="fa fa-caret-up"
					></span>
				</a></th>
				<th><a
					href='#'
					data-ng-click="sortType = 'measureAmount'; sortReverse = !sortReverse"
				> Amount <span
						data-ng-show="sortType == 'measureAmount' && !sortReverse"
						class="fa fa-caret-down"
					></span> <span
						data-ng-show="sortType == 'measureAmount' && sortReverse"
						class="fa fa-caret-up"
					></span>
				</a></th>
				<th><a
					href='#'
					data-ng-click="sortType = 'expirationDate'; sortReverse = !sortReverse"
				> Expiration Date <span
						data-ng-show="sortType == 'expirationDate' && !sortReverse"
						class="fa fa-caret-down"
					></span> <span
						data-ng-show="sortType == 'expirationDate' && sortReverse"
						class="fa fa-caret-up"
					></span>
				</a></th>
				<th><a
					href='#'
					data-ng-click="sortType = 'itemDetails'; sortReverse = !sortReverse"
				> Details <span
						data-ng-show="sortType == 'itemDetails' && !sortReverse"
						class="fa fa-caret-down"
					></span> <span
						data-ng-show="sortType == 'itemDetails' && sortReverse"
						class="fa fa-caret-up"
					></span>
				</a></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><input type="text" data-ng-model="newItemName" /></td>
				<td><input type="number" data-ng-model="newItemAmount" />
				<input type="text" data-ng-model="newItemMeasureType" /></td>
				<td><input type="date" data-ng-model="newExpirationDate" /></td>
				<td><input type="text" data-ng-model="newItemDetails" /></td>
				<td><button data-ng-click="createNewItem()">Create Item</button></td>
			</tr>
		
			<tr data-ng-repeat="item in items | orderBy:sortType:sortReverse | filter:searchItems">
				<!-- Print out of the information (first itemName is from UserItem, 2 from Item-->
				<td>{{item.itemId.itemName}}</td>
				<td>{{item.measureAmount}}{{item.measureType}}</td>
				<td>{{item.expirationDate}}</td>
				<td>{{item.itemDetails}}</td>
				<td><button data-ng-click="remove(item)">X</button></td>
		</tbody>
	</table>
	<!-- <button data-ng-click="remove()">Remove</button> -->
	<button>Add to shopping list</button>

	<script
		src="resources/js/home.js"
		type="text/javascript"
	></script>
</body>
</html>