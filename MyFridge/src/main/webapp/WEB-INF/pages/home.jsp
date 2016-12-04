<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MyFridge | Home</title>
</head>
<body>
	<div>${currentUser}</div>
	<form:form action="logout" method="POST" class="navbar-form navbar-left">
		<button type="submit" class="btn btn-default" >Logout</button>
	</form:form>
</body>
</html>