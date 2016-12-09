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
<title>Error</title>
</head>
<body>

	<h3>Error</h3>
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