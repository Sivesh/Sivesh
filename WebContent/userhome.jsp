<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.olx.models.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome Home jsp</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
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
		<%
			User user = (User) session.getAttribute("user");
		%>
		<ul class="navbar-nav ml-auto">
			<li class="nav-item">

				<div class="dropdown">
					<button type="button" class="btn btn-primary dropdown-toggle"
						data-toggle="dropdown">
						<label style="color: white"> Welcome
							${sessionScope.user.name} </label>
					</button>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="#">post Ad</a> <a
							class="dropdown-item" href="#">View your bids</a> <a
							class="dropdown-item" href="#">View Posted Ads</a> <a
							class="dropdown-item" href="#">Logout</a>
					</div>
				</div>
			</li>
		</ul>
	</div>

	</nav>
	<br>

	<!--Search Bar-->


	<!--Nav Tabs-->
	<div class="container">
		<ul class="nav nav-tabs">
			<li class="nav-item"><a class="nav-link active" href="#home"
				data-toggle="tab">Home</a></li>
			<c:forEach items="${categoriesList}" var="category">
				<li class="nav-item"><a class="nav-link"
					href="#${category.name}" data-toggle="tab"> ${category.name } </a></li>
			</c:forEach>
		</ul>

		<!--Tab Panes-->
		<div class="tab-content">
			<div id="home" class="container tab-pane active">
				<br> <br>
				<!-- Grid Division -->
				<div class="container">

					<div class="row">
						<c:forEach items="${itemsList}" var="item">
							<div class="col-sm-4">
								<img src="./items/${item.itemImages[0]}" height="150px"
									;padding="20px" ;width="150px" /><br>

								<form action="OlxController" method="post">
									<input type="hidden" name="item_id" value=${item.id } />
									<button type="submit" name="action" value="product">
										${item.name}</button>
								</form>


							</div>
						</c:forEach>

					</div>

				</div>
			</div>
			<c:forEach items="${categoriesList}" var="category">

				<div id="${category.name}" class="container tab-pane fade">

					<div class="container">
						<div class="row">

							<c:forEach items="${category.subcategoryList}" var="subcategory">
								<c:forEach items="${subcategory.itemsList}" var="item">

									<div class="col-sm-4">
										<img style="width: 200px; height: 200px; padding: 20px"
											align="middle" src="./items/${item.itemImages[0]}" /><br>
										<form action="OlxController" method="post">
											<input type="hidden" name="item_id" value=${item.id } />
											<button type="submit" name="action" value="product">
												${item.name}</button>
										</form>
									</div>

								</c:forEach>

							</c:forEach>

						</div>
					</div>
				</div>

			</c:forEach>
		</div>
	</div>
</body>
</html>