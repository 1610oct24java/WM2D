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
<body data-ng-app="" data-ng-init="currentUser = ${currentUser}">
	<fieldset>
		<legend>Name</legend>
		<!--  Set an input, then set to be the model for "name" -->
		<input type="text" data-ng-model="currentUser"
			placeholder="{{currentUser}}">
		<!-- Access variable via directive  -->
		<p data-ng-bind="currentUser"></p>
		<!-- Access variable via expression  -->
		<p>Your name is: {{currentUser}}</p>
	</fieldset>
	{{currentUser}}
	<%-- <div>${currentUser}</div> --%>
	<form:form action="logout" method="POST"
		class="navbar-form navbar-left">
		<button type="submit" class="btn btn-default">Logout</button>
	</form:form>
</body>
</html>