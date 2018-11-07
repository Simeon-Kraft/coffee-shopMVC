<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>register</title>
</head>
<body>
	<h1>Complete this form to register.</h1>
	
	<form action="/summary">
		<p>
			First Name: <br><input name="first">
		</p>
		<p>
			Last Name: <br><input name="last">
		</p>
		<p>
			Title: <br>
					<input type="checkbox" name="title" value="Mr."> Mr.<br>
					<input type="checkbox" name="title" value="Mr."> Mrs.<br>
					<input type="checkbox" name="title" value="Mr."> Dr.<br>
					<input type="checkbox" name="title" value="Mr."> Esq.<br>
					<input type="checkbox" name="title" value="" checked="checked"> None<br>
		</p>
		<p>
			Favorite Drink:
			<select name="favorite">
				<option value="Coffee">Coffee</option>
				<option value="Tea">Tea</option>
				<option value="Other">Other</option>
			</select>
		</p>
		<p>
			Email: <br><input name="email">
		</p>
		<p>
			Phone Number: <br><input name="number">
		</p>
		<p>
			Password: <br><input name="password">
		</p>
		<p>
			<button>Register</button>
		</p>
	</form>

</body>
</html>