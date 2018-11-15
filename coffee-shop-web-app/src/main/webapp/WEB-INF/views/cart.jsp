<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet" href="/cart.css" />
<meta charset="ISO-8859-1">
<title>cart</title>
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
				<h3>Cart</h3>
				<table class="table table-sm">
					<thead class="thead-dark">
						<tr>
							<th scope="col">Name</th>
							<th scope="col">Price</th>
							<th scope="col">Quantity</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<c:forEach var="items" items="${ items }">
						<tr class="table-success" id="items">
							<td>${ items.menuItem.name }</td>
							<td>${ items.menuItem.price }</td>
							<td>${ items.quantity }</td>
							<td><a href="/userMenu/${ items.id }/delete"><button class="btn btn-danger">Delete</button></a></td>
						</tr>
					</c:forEach>
					<thead class="thead-dark">
					<tr>
						<th scope="col">Subtotal: $<fmt:formatNumber type="number" maxFractionDigits="2" value="${subtotal}"/></th>
						<th scope="col"></th>
						<th scope="col"></th>
						<th scope="col"></th>
					</tr>
					</thead>
					<thead class="thead-light">
					<tr>
						<th id="total" scope="col">Total: $<fmt:formatNumber type="number" maxFractionDigits="2" value="${total}"/></th>
					</tr>
					</thead>
				</table>
					<a href="/userMenu"><button class="btn btn-info">Back</button></a>
			</div>
		</div>
	</div>
</body>
</html>