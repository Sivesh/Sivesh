<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<style>
/* Make the image fully responsive */
.carousel-inner img {
	width: 30%;
	height: 50%;
}
</style>
</head>
<body>
	<!--Nav Bar-->
	<nav class="navbar navbar-expand-sm bg-dark">
	<ul class="navbar-nav">
		<li class="nav-item"><a class="nav-link" href="#"> <img
				src="olx.jpg" alt="Logo" width="40px">
		</a></li>
	</ul>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="collapsibleNavbar">

		<!--Dropdown Menu in Nav Bar-->
		<ul class="navbar-nav">
			<li class="nav-item dropdown">
				<div class="dropdown">
					<a class="nav-link dropdown-toggle" id="navbardrop1"
						data-toggle="dropdown" href="#" style="color: white"> Select
						City </a>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="#">Hyderabad</a> <a
							class="dropdown-item" href="#">Banglore</a> <a
							class="dropdown-item" href="#">Pune</a>
					</div>
				</div>
			</li>
			<li class="nav-item">
				<div class="dropdown">
					<a class="nav-link dropdown-toggle" id="navbardrop1"
						data-toggle="dropdown" href="#" style="color: white"> Select
						Locality </a>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="#">Madhapur</a> <a
							class="dropdown-item" href="#">DLF</a> <a class="dropdown-item"
							href="#">BHEL</a>
					</div>
				</div>
			</li>
		</ul>
		<ul class="navbar-nav ml-auto">

			<li class="nav-item">
				<div class="dropdown">
					<a class="nav-link dropdown-toggle" id="navbardrop1"
						data-toggle="dropdown" href="#" style="color: white"> <label
						style="color: white">Welcome ${sessionScope.user.name} </label>
					</a>

					<div class="dropdown-menu">
						<a class="dropdown-item" href="#">Post Ad</a> <a
							class="dropdown-item" href="#"> View your bids</a> <a
							class="dropdown-item" href="#"> View Posted Ads</a> <a
							class="dropdown-item" href="#">Logout</a>
					</div>
				</div>
			</li>
		</ul>
	</div>
	</nav>
	<br>
	<h1>${item.name}</h1>
	<div id="demo" class="carousel slide" data-ride="carousel"
		align="center">

		<!-- Indicators -->
		<ul class="carousel-indicators">
			<li data-target="#demo" data-slide-to="0" class="active"></li>
			<c:forEach var="i" begin="1" end="${fn:length(item.itemImages)-1}">
				<li data-target="#demo" data-slide-to="${i}"></li>
			</c:forEach>
		</ul>

		<!-- The slideshow -->
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="./items/${item.itemImages[0]}" width="200" height="300">
			</div>
			<c:forEach var="i" begin="1" end="${fn:length(item.itemImages)-1}">
				<div class="carousel-item">
					<img src="./items/${item.itemImages[i]}" width="200" height="300">
				</div>
			</c:forEach>
		</div>
		<!-- Biding -->
		<div align="center">
			<p>${item.name}</p>
			<p>${item.description}</p>
			<p>Minimum Bid Amount:${item.minPrice}</p>
			<p>Maximum Bid Amount:${item.maxPrice}</p>

			<form action="OlxController" method="post">
				<input type="hidden" name="itemId" value="${item.id}"> 
				<input type="hidden" name="userId" value="${sessionScope.user.user_id}">
				<input type="text" name="bidAmount">
				<button type="submit" name="action" value="bid">Bid</button>
			</form>

		</div>
		<!-- Left and right controls -->
		<a class="carousel-control-prev" href="#demo" data-slide="prev"> <span
			class="carousel-control-prev-icon"></span>
		</a> <a class="carousel-control-next" href="#demo" data-slide="next">
			<span class="carousel-control-next-icon"></span>
		</a>
	</div>


</body>
</html>