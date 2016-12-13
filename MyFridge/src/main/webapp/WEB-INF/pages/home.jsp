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
<!-- Latest compiled and minified JavaScript -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
<link href="resources/css/style.css" rel="stylesheet" type="text/css">
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.0-rc.2/angular.min.js"></script>
<title>MyFridge | Home</title>
</head>

<!-- Setting up angular app/controller -->
<body class="container" data-ng-app="myApp"
	data-ng-controller="myController">

	<!-- Temporary storage for the user information to work with -->
	<input type="hidden" id="test" name="x" value="${UserJSON}">

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
				<form:form action="viewRecipes" method="POST"
					class="navbar-form navbar-left">
					<button type="submit" class="btn btn-default">View Recipes</button>
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
					<div class="form-group">
						<div class="input-group">
							<div class="input-group-addon">
								<i class="fa fa-search"></i>
							</div>

							<!-- Creating a text search field -->
							<input type="text" class="form-control"
								placeholder="Search Items" data-ng-model="searchItems">

						</div>
					</div>
				</form>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>

	<!-- The JSTL way -->
	<!-- <div>${currentUser}</div> -->
	<br>
	<br>
	<br>
	<h1>Your Fridge</h1>

	<!-- Printing out the User's items -->
	<table id=table class="table table-bordered table-striped">
		<!-- Setting up table to be sortable via title click -->
		<thead>
			<tr>
				<th><a href='#'
					data-ng-click="sortType = 'name'; sortReverse = !sortReverse">
						Name <span data-ng-show="sortType == 'name' && !sortReverse"
						class="fa fa-caret-down"></span> <span
						data-ng-show="sortType == 'name' && sortReverse"
						class="fa fa-caret-up"></span>
				</a></th>
				<th><a href='#'
					data-ng-click="sortType = 'measureAmount'; sortReverse = !sortReverse">
						Amount <span
						data-ng-show="sortType == 'measureAmount' && !sortReverse"
						class="fa fa-caret-down"></span> <span
						data-ng-show="sortType == 'measureAmount' && sortReverse"
						class="fa fa-caret-up"></span>
				</a></th>
				<th><a href='#'
					data-ng-click="sortType = 'measureType'; sortReverse = !sortReverse">
						Measure Type <span
						data-ng-show="sortType == 'measureType' && !sortReverse"
						class="fa fa-caret-down"></span> <span
						data-ng-show="sortType == 'measureType' && sortReverse"
						class="fa fa-caret-up"></span>
				</a></th>
				<th><a href='#'
					data-ng-click="sortType = 'expirationDate'; sortReverse = !sortReverse">
						Expiration Date <span
						data-ng-show="sortType == 'expirationDate' && !sortReverse"
						class="fa fa-caret-down"></span> <span
						data-ng-show="sortType == 'expirationDate' && sortReverse"
						class="fa fa-caret-up"></span>
				</a></th>
				<th><a href='#'
					data-ng-click="sortType = 'itemDetails'; sortReverse = !sortReverse">
						Details <span
						data-ng-show="sortType == 'itemDetails' && !sortReverse"
						class="fa fa-caret-down"></span> <span
						data-ng-show="sortType == 'itemDetails' && sortReverse"
						class="fa fa-caret-up"></span>
				</a></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><input type="text" data-ng-model="newItemName" /></td>
				<td><input type="number" data-ng-model="newItemAmount" /></td>
				<td><input type="text" data-ng-model="newItemMeasureType" /></td>
				<td><input type="date" data-ng-model="newExpirationDate" /></td>
				<td><input type="text" data-ng-model="newItemDetails" /></td>
				<td><button class = "btn" data-ng-click="createNewItem()">Create Item</button></td>
			</tr>
			<tr 
				data-ng-repeat="item in items | orderBy:sortType:sortReverse | filter:searchItems" 
				data-ng-class="{yellowtr:dateDifference(item) > 0, redtr: dateDifference(item) <= 0}">
				<!-- Print out of the information (first itemName is from UserItem, 2 from Item-->
				<td>{{item.itemId.itemName}} {{dateDifference(item)}}</td>
				<td><input type="number" style="width: 110px" data-ng-model="item.measureAmount"/>
				<button id="update" class = "btn btn-sm" data-ng-click="update(item)">Update</button></td>
				<td>{{item.measureType}}</td>
				<td data-ng-class="{yellowtr:dateDifference(item) > 0, redtr: dateDifference(item) <= 0}">{{item.expirationDate}}</td>
				<td>{{item.itemDetails}}</td>
				<td><button id="remove" class = "btn btn-danger btn-sm" data-ng-click="remove(item)">X</button></td>
			</tr>
		</tbody>
	</table>

	<script src="resources/js/home.js" type="text/javascript"></script>
	<script src="resources/js/jquery-1.11.2.min.js" type="text/javascript"></script>
	<script src="resources/js/bootstrap.js" type="text/javascript"></script>
</body>
</html>