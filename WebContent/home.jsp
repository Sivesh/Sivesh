<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Olx page</title>
<meta charset="UTF-8">
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
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<ul class="navbar-nav">
		<li class="nav-item active"><a class="nav-link" href="#"> <img
				src="olx.jpg" height="30px" width="40px">
		</a></li>
	</ul>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="collapsibleNavbar">
		<ul class="navbar-nav">
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbardrop"
				data-toggle="dropdown"> Select City </a>

				<div class="dropdown-menu">
					<a class="dropdown-item" href="#">Hyderabad</a> <a
						class="dropdown-item" href="#">Mumbai</a> <a class="dropdown-item"
						href="#">Delhi</a>
				</div></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbardrop"
				data-toggle="dropdown"> Select Locality </a>

				<div class="dropdown-menu">
					<a class="dropdown-item" href="#">Gachibowli</a> <a
						class="dropdown-item" href="#">Madhapur</a> <a
						class="dropdown-item" href="#">Kondapur</a> <a
						class="dropdown-item" href="#">Hitech-City</a>
				</div></li>
		</ul>

		<ul class="navbar-nav ml-auto">
			<li class="nav-item"><a class="nav-link" data-toggle="modal"
				href="#modal1">Sign In</a></li>
			<li class="nav-item"><a class="nav-link" data-toggle="modal"
				href="#modal2">Sign Up</a></li>
			<div class="modal" id="modal1">
				<div class="modal-dialog">
					<div class="modal-content">

						<!-- Modal Header -->
						<div class="modal-header">
							<h4 class="modal-title">Sign In</h4>
							<button type="button" class="close" data-dismiss="modal">&times;</button>
						</div>



						<!-- Modal body -->
						<div class="modal-body">
							<form action="OlxController" method="post">
								<div class="form-group">
									<label for="name">UserName:</label> <input type="email"
										class="form-control" id="email" name="email">
								</div>
								<div class="form-group">
									<label for="name">Password:</label> <input type="password"
										class="form-control" id="password" name="password">
								</div>
								<br>
								<button type="submit" name="action" value="Sign In"
									class="btn btn-primary" align="center">Sign In</button>
							</form>
						</div>


					</div>

				</div>
				#modal1
			</div>

			<div class="modal" id="modal2">
				<div class="modal-dialog">
					<div class="modal-content">

						<!-- Modal Header -->
						<div class="modal-header">
							<h4 class="modal-title">Sign Up</h4>
							<button type="button" class="close" data-dismiss="modal">&times;</button>
						</div>

						<!-- Modal body -->
						<div class="modal-body">
							<form action="OlxController" method="post">
								<div class="form-group">
									<label for="name">Name:</label> <input type="text"
										class="form-control" id="name" name="name">
								</div>
								<div class="form-group">
									<label for="email">Email:</label> <input type="email"
										class="form-control" id="email" name="email">
								</div>
								<div class="form-gr#modal1oup">
									<label for="password">Password:</label> <input type="password"
										class="form-control" id="password" name="password">
								</div>
								<div class="form-group">
									<label for="phone_number">Phone Number:</label> <input
										type="number" class="form-control" id="phone_number"
										name="phone_number">
								</div>
								<br>
								<button type="submit" name="action" value="Sign Up"
									class="btn btn-primary" align="center">Sign Up</button>
							</form>
						</div>

					</div>
				</div>
			</div>


		</ul>
	</nav>
	<br>



	<!--Nav Tabs-->
	<div class="container">
		<ul class="nav nav-tabs">
			<li class="nav-item"><a class="nav-link active" href="#home"
				data-toggle="tab">Home</a></li>
			<c:forEach items="${categoriesList}" var="category">
				<li class="nav-item"><a class="nav-link"
					href="#${category.name }" data-toggle="tab"> ${category.name }
				</a></li>
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
								<p align="center">${item.name}</p>
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
										<p align="center">${item.name}</p>
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