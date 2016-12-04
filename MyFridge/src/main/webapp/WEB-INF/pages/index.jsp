<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
   
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>MyFridge-Login</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="resources/css/style.css" rel="stylesheet" type="text/css">
<link href="resources/css/bootstrap.css" rel="stylesheet" type="text/css">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->
</head>
<body style="padding-top: 70px">
<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container-fluid"> 
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#topFixedNavbar1"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
			<a class="navbar-brand" href="#">WM2D</a></div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="topFixedNavbar1">
			
            <form class="navbar-form navbar-left" role="search">
				<button type="submit" class="btn btn-default">Logout</button>
			</form>
			<form:form action="login" method="POST" commandName="User" class="navbar-form navbar-left">
				<div class="form-group">
					 
					<form:input path="username" class="form-control" placeholder="Username"/>
      					<form:errors path="username" cssClass="alert alert-danger" element="div" />
      					
                    <form:password path="password" class="form-control" placeholder="Password"/>
                    	<form:errors path="password" cssClass="alert alert-danger" element="div" />
				</div>
				<button type="submit" class="btn btn-default">Login</button>
                <button type="submit" class="btn btn-default" formaction="create">Create User</button>
			</form:form>
		</div>
		<!-- /.navbar-collapse --> 
	</div>
	<!-- /.container-fluid --> 
</nav>

<c:if test="${errorMessage != null}">
	<div class="alert alert-danger">${errorMessage}</div>
</c:if>

<div class="accordion Fridge">
	<ul>
		<li>
			<input type="checkbox" name="select" class="accordion-select"  />
			<div class="accordion-content">
				<form>
					<fieldset>
						<legend>My Fridge</legend>
						<div>
                            This is where a basic app description will go
                        
                        </div>
						
					</fieldset>
				</form>
			</div>
			<div class="accordion-separator"></div>
		</li>
		<li>
			
			<div class="accordion-content"> <img src="resources/images/doorTop.jpg" width="100%" height="100%" alt=""/>
            <div id="door_label">About</div>
            </div>
			<div class="accordion-separator"></div>
		</li>
	</ul>
</div>
<div class="accordion Fridge" id="bottom_door">
	<ul>
		<li>
			<input type="checkbox" name="select" class="accordion-select"/>
			
			<div class="accordion-content">
				<form>
					<fieldset>
						<div>
                            NO! GO AWAY!
                        </div>
					</fieldset>
				</form>
			</div>
			<div class="accordion-separator"></div>
		</li>
		<li>
			<div class="accordion-content"> <img src="resources/images/doorBottom.jpg" width="100%" height="100%" alt=""/>
            <div id="door_label">Contact Us</div>
            </div>
			<div class="accordion-separator"></div>
		</li>
	</ul>
</div>
<script src="resources/js/jquery-1.11.2.min.js" type="text/javascript"></script> 
<script src="resources/js/bootstrap.js" type="text/javascript"></script>
</body>
</html>
