<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="#" class="navbar-brand"> Employee Management System </a>
			</div>

			<%-- 	<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Employees</a></li>
			</ul> --%>

		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<caption>
					<h2>Create an Admin User</h2>
				</caption>

				<form action="Signup" method="post">

					<label>Please Enter Username:</label> <input type="text"
						placeholder="Username" class="form-control" name="uname" required="required"><br>
					<br> <label>Please Enter Password:</label> <input
						type="password" placeholder="Password" class="form-control"
						name="pass" required="required"><br> <input type="submit"
						class='btn btn-danger' value="Save">

				</form>







			</div>
		</div>
	</div>
</body>
</html>