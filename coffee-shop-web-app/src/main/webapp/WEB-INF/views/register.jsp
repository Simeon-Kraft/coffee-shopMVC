<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>register</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href="/register.css" />
</head>
<body>
	<div id="background">
	<div class="container">

		<form action="/summary" method="post">
		<h1>Complete this form to register.</h1>
			<p id="buttons">
				Title: <br> <input type="radio" name="title" value="Mr.">
				Mr.<br> <input type="radio" name="title" value="Mrs.">
				Mrs.<br> <input type="radio" name="title" value="Dr.">
				Dr.<br> <input type="radio" name="title" value="Rev.">
				Rev.<br> <input type="radio" name="title" value=""
					checked="checked"> None<br>
			</p>
			<p>
				First Name: <br>
				<input name="first" required pattern="[A-Z][a-z]*">
			</p>
			<p>
				Last Name: <br>
				<input name="last" required pattern="[A-Z][a-z]*">
			</p>
			<p>
				Birthday: <br>
				<input name="birthday" type="date">
			</p>
			<p>
				Favorite Drink: <select name="favorite" required class="btn btn-info">
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
				Email: <br>
				<input name="email" type="email">
			</p>
			<p>
				Phone Number: <br>
				<input name="number" type="number">
			</p>
			<p>
				Password: <br>
				<input type="password" name="password" required minlength="6">
			</p>
			<p>
				<button class="btn btn-success" type="submit">Register</button>
			</p>
		</form>
		</div>
	</div>
</body>
</html>