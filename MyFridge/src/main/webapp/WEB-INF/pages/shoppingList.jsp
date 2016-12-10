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
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">


<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.0-rc.2/angular.min.js"></script>
<title>Shopping List</title>
</head>
<body class="container" data-ng-app="myApp"
	data-ng-controller="myController">

	<input type="hidden" id="test" name="x" value="${UserJSON}">

	<!-- <div>${currentUser}</div> -->
	<form:form action="logout" method="POST"
		class="navbar-form navbar-left">
		<button type="submit" class="btn btn-default">Logout</button>
	</form:form>
	
	<form:form action="homepage" method="GET" class="navbar-form navbar-left">
		<button type="submit" class="btn btn-default">Home</button>
	</form:form>
	<br>

	<br>
	<div class="alert alert-info">
		<p>Sort Type: {{ sortType }}</p>
		<p>Sort Reverse: {{ sortReverse }}</p>
		<p>Search Query: {{ searchItem }}</p>
	</div>
	<br>
	<form>
		<div class="form-group">
			<div class="input-group">
				<div class="input-group-addon">
					<i class="fa fa-search"></i>
				</div>

				<input type="text" class="form-control" placeholder="Search Items"
					data-ng-model="searchItems">
			</div>
		</div>
	</form>

	<h1>Shopping List!</h1>
	<table id=table class="table table-bordered table-striped">
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
				data-ng-repeat="item in items | orderBy:sortType:sortReverse | filter:searchItems | filter:statusFilter ">
				<td>{{item.itemId.itemName}}</td>
				<td>{{item.measureAmount}}</td>
				<td>{{item.itemDetails}}</td>
				<td>
					<form action="deleteItemFromList" method="post">
						<input name="iId" type="hidden" value="${item.getItemId()}">
						<input name="iStatus" type="hidden"
							value="${item.getItemStatus()}"> <input
							class="btn btn-info" type="submit" value="Delete Item">
					</form>
				</td>
		</tbody>
	</table>
	<script src="resources/js/shoppingList.js" type="text/javascript"></script>
</body>
</html>