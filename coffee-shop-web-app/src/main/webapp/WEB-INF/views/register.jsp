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
	
	<form action="/summary" method="post">
		<p>
			Title: <br>
					<input type="radio" name="title" value="Mr."> Mr.<br>
					<input type="radio" name="title" value="Mrs."> Mrs.<br>
					<input type="radio" name="title" value="Dr."> Dr.<br>
					<input type="radio" name="title" value="Rev."> Rev.<br>
					<input type="radio" name="title" value="" checked="checked"> None<br>
		</p>
		<p>
			First Name: <br><input name="first">
		</p>
		<p>
			Last Name: <br><input name="last">
		</p>
		<p>
			Favorite Drink:
			<select name="favorite">
				<option value=""></option>
				<option value="Coffee">Coffee</option>
				<option value="Tea">Tea</option>
				<option value="Soda">Soda</option>
				<option value="Beer">Beer</option>
				<option value="White Wine">Wine(White)</option>
				<option value="Red Wine">Wine(Red)</option>
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