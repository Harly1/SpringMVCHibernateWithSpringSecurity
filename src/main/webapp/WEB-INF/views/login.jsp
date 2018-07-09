<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login page</title>
		<link href="<c:url value='/static/css/bootstrap.css' />"  rel="stylesheet"></link>

	</head>
	<body>
	<h1 class="login-h1">Login</h1>
	<div class="container">
		<form class="form-signin" name='loginForm' action="" method='POST'>
			<h3>Login</h3>
			<input class="form-control" placeholder="Email" type="text" name="username"/>
			<input class="form-control" placeholder="Password" type="password" name="password"/>
			<div class="${not empty error}?('error') bg-danger" th:text="${error}"></div>
			<div class="${not empty msg}?('msg') bg-danger" th:text="${msg}"></div>
			<br/>
			<input class="btn btn-lg btn-primary btn-block" name="submit" type="submit" value="Login"/>
		</form>
	</div>
	</body>
</html>