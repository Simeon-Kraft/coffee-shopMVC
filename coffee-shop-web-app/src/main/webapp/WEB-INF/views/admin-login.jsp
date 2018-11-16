<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="/admin.css">
<style>
body,h1,h5 {font-family: "Raleway", sans-serif}
body, html {height: 100%}
.bgimg {
    background-image: url('/images/simeon.jpg');
    min-height: 100%;
    background-position: center no-repeat;
    background-size: 20%;
    
}
</style>
<body>

<div class="bgimg w3-display-container w3-text-white">
  <div id="loginbox" class="w3-display-topleft w3-large">
   	 <form action="/admin-login" method="post">
   	 	<p class="login"><label for="username">Email:</label> <input class="input-field" id="email" name="email" value="${ param.email }" required minlength="2" /></p>
   	 	
   	 	<p class="login"><label for="password">Password:</label>   <input class="input-field" id="password" type="password" name="password" required minlength="2" /></p>
   	 	<p id="loginbtn"><button type="submit" class="w3-button w3-white">login</button></p>
   	 	<p class="message">${ message }</p>
   	 </form>
  </div>
 
  <div class="w3-display-bottomright w3-container">
    <p class="w3-small">Just do it.</p>
  </div>
  <div class="w3-display-bottomleft w3-container">
    <p class="w3-small">Simeon Kraft</p>
    <p class="w3-small">Powered by Java and java.</p>
  </div>
</div>
	<!-- Optional JavaScript -->

	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
	</div>
</body>
</html>