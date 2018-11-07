<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>form-summary</title>
</head>
<body>
	<h1>Thank you for registering, ${ title } ${ first }!</h1>
		<h3>Please review your information to ensure that everything is correct.</h3>
			<p>Name: <strong>${ first } ${ last }</strong></p>
			<p>Favorite Drink: <strong>${ favorite }</strong></p>
			<p>Email: <strong>${ email }</strong></p>
			<p>Phone Number: <strong>${ number }</strong></p>
	
	<p>
		<a href="http://localhost:8080/"><button>Looks good!</button></a>
	</p>
	

</body>
</html>