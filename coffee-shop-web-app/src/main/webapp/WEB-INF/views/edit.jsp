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
<title>add-item</title>
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
				<h3>Add Item</h3>
				<form action="/menu/${menuItem.id}/edit" method="post">
					<table class="table table-sm">
						<thead class="thead-dark">
							<tr>
								<th scope="col">Name</th>
								<th scope="col">Price</th>
								<th scope="col">Description</th>
							</tr>
						</thead>
						<tr class="table-success" id="items">
							<td><input type="text" name="name" value="${menuItem.name}" /></td>
							<td><input type="text" name="price" value="${menuItem.price}" /></td>
							<td><input type="text" name="description" value="${menuItem.description}" /></td>
						</tr>
					</table>
					<button id="add" class="btn btn-success">Update Item</button>
				<p>
					<a href="/menu">Cancel</a>
				</p>
				</form>
			</div>
		</div>
	</div>
</body>
</html>