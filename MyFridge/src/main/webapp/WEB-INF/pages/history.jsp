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
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.0-rc.2/angular.min.js"></script>
<title>MyFridge | History</title>
</head>

<!-- Setting up angular app/controller -->
<body class="container" data-ng-app="myApp"
	data-ng-controller="myController">

	<!-- Temporary storage for the user information to work with -->
	<input type="hidden" id="test" name="x" value="${UserJSON}">

	<!-- The JSTL way -->
	<!-- <div>${currentUser}</div> -->
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
				<form:form action="homepage" method="POST"
					class="navbar-form navbar-left">
					<button type="submit" class="btn btn-default">My Fridge</button>
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
	<br>
	<br>
	<br>

	<!-- Printing out the User's items -->
	<h1>History</h1>
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

			<tr
				data-ng-repeat="item in items | orderBy:sortType:sortReverse | filter:searchItems | filter:expDateFilter">
				<!-- Print out of the information (first itemName is from UserItem, 2 from Item-->
				<td>{{item.itemId.itemName}}</td>
				<td>{{item.expirationDate}}</td>
				<td>{{item.itemDetails}}</td>
		</tbody>
	</table>

	<script src="resources/js/history.js" type="text/javascript"></script>
	<script src="resources/js/jquery-1.11.2.min.js" type="text/javascript"></script>
	<script src="resources/js/bootstrap.js" type="text/javascript"></script>
</body>
</html>