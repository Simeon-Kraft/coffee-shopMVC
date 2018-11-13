<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet" href="/menu.css" />
<meta charset="ISO-8859-1">
<title>item</title>
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
				<h3>Menu Items</h3>
				<table class="table table-sm">
					<tr class="table-success" id="items">
						<th scope="row">Name</th>
						<td>${menuItem.name}</td>
					</tr>
					<tr class="table-success" id="items">
						<th scope="row">Price</th>
						<td>${menuItem.price}</td>
					</tr>
					<tr class="table-success" id="items">
						<th scope="row">Description</th>
						<td>${menuItem.description}</td>
					</tr>
				</table>
				<a class="btn btn-secondary" href="/menu/${menuItem.id}/edit">Edit</a>
				<a class="btn btn-danger" href="/menu/${menuItem.id}/delete">Delete</a>
				<a class="btn link" href="/menu">Back to List</a>
			</div>
		</div>
	</div>
</body>
</html>