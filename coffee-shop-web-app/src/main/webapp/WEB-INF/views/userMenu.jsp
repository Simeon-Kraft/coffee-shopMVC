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
<link rel="stylesheet" href="/cart.css" />
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
				<table class="table table-dark">
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
							<td>${ items.name }</td>
							<td>${ items.price }</td>
							<td>${ items.description }</td>
							<td><a href="/userMenu/${ items.id }"><button class="btn btn-success">Add</button></a></td>
						</tr>
					</c:forEach>
				</table>
				<a href="/"><button id="add" class="btn btn-info">Back</button></a>
				<a href="/cart"><button id="add" class="btn btn-success">Go To Cart</button></a>
			</div>
		</div>
	</div>
</body>
</html>