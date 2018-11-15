<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>form-summary</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet" href="/summary.css" />
</head>
<style>
body, html {
	height: 100%
}
</style>
<body>
	<div class="bgimg">
		<div>
			<div class="container">
				<form action="/">
					<h3 class="message">Please review your information to ensure
						that everything is correct.</h3>
					<table class="table table-sm">
						<thead class="thead-dark">
							<tr>
								<th scope="col">First Name</th>
								<th scope="col">Last Name</th>
								<th scope="col">Birthday</th>
								<th scope="col">Favorite Drink</th>
								<th scope="col">Phone Number</th>
								<th scope="col">Email</th>
							</tr>
						</thead>
						<tr class="table-success">
							<td>${ user.first }</td>
							<td>${ user.last }</td>
							<td>${ user.birthday }</td>
							<td>${ user.favorite }</td>
							<td>${ user.number }</td>
							<td>${ user.email }</td>
						</tr>
					</table>

					<p>
						<button class="btn btn-secondary" type="submit">Looks good!</button>
					</p>
				</form>
			</div>
		</div>
	</div>
</body>
</html>