<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href="/menu.css"/>
<meta charset="ISO-8859-1">
<title>menu</title>
</head>
<body>
	<div class="container">
	<h1>Menu Items</h1>
	<table class="table table-sm">
		<thead class="thead-dark">
			<tr >
				<th scope="col">Name</th><th scope="col">Price</th><th scope="col">Description</th>
			</tr>
		</thead>
		<c:forEach var= "items" items= "${ items }">
		<tr class="table-success" id="items">
			<td>${ items.name }</td>
			<td>${ items.price }</td>
			<td>${ items.description }</td>
		</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>