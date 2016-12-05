<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.5.8/angular.min.js"></script>
<title>MyFridge | Home</title>
</head>
<body data-ng-app="myApp" ng-controller="myController">
<!-- 	<fieldset> -->
<!-- 		<legend>Name</legend> -->
<!-- 		<!--  Set an input, then set to be the model for "name" --> -->
<!-- 		<input type="text" data-ng-model="currentUser" -->
<!-- 			placeholder="{{currentUser}}"> -->
<!-- 		<!-- Access variable via directive  --> -->
<!-- 		<p data-ng-bind="currentUser"></p> -->
		<!-- Access variable via expression  -->
<!-- 		<p>Your name is: {{currentUser}}</p> -->
<!-- 	</fieldset> -->
	Test: ($location.search()).currentUser
	USER: ${currentUser}
	<br>JSON: ${UserJSON}
	
	<input type="hidden" id="test" name="x" value="${UserJSON}"> 
	
	<!-- <div>${currentUser}</div> -->
	<form:form action="logout" method="POST"
		class="navbar-form navbar-left">
		<button type="submit" class="btn btn-default">Logout</button>
	</form:form>
	<br>
	<br>
	<br>
	<br>
	<table id=table></table>
	
	
	
	<script src="resources/js/home.js" type="text/javascript"></script>
</body>
</html>