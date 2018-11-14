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
<title>menu</title>
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
					<thead class="thead-dark">
						<tr>
							<th scope="col">Name</th>
							<th scope="col">Price</th>
							<th scope="col">Description</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<c:forEach var="items" items="${ items }">
						<tr class="table-success" id="items">
							<td><a href="/menu/${items.id}">${ items.name }</a></td>
							<td>${ items.price }</td>
							<td>${ items.description }</td>
							<td><a class="btn btn-secondary" href="/menu/${items.id}/edit">Edit</a><span>	</span><a  class="btn btn-danger" href="/menu/${items.id}/delete">Delete</a></td>
						</tr>
					</c:forEach>
				</table>
				<a href="/add"><button id="add" class="btn btn-success">Add
						Item</button></a> <a href="/">Back</a>
			</div>
		</div>
	</div>
</body>
</html>