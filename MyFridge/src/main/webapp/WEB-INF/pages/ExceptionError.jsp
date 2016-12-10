<%@ page
	language="java"
	contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	isErrorPage="true"
%>
<%@taglib
	prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"
%>
<%@ taglib
	uri="http://java.sun.com/jsp/jstl/fmt"
	prefix="fmt"
%>
<!DOCTYPE html>
<html>
<head>
<meta
	http-equiv="Content-Type"
	content="text/html; charset=ISO-8859-1"
>
<link
	href="resources/css/bootstrap.css"
	rel="stylesheet"
	type="text/css"
>
<meta
	http-equiv="refresh"
	content="3;url=/MyFridge/"
/>
<title>Error</title>
</head>
<body>

	<div
		class="alert alert-danger"
		role="alert"
	>
		<strong>Danger!</strong> If you are seeing this page, something <strong>MAJOR</strong>
		happened.
	</div>

	<h3>Error</h3>
	<br> Please contact support...
	<p>
		Cause:<br>
		<%=exception.getCause()%>
	</p>
	<p>
		Message:<br>
		<%=exception.getMessage()%>
	</p>
	<!--
    Failed URL: ${url}
    
    Exception:  ${exception.message}
    
        <c:forEach items="${exception.stackTrace}" var="ste">
            ${ste}   
    </c:forEach>
  -->
</body>
</html>