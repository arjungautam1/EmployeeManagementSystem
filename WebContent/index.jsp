<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login/Signup</title>
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
					<h2>LogIn / Sign Up </h2>
				</caption>


				<form action="Login" method="post">
					<label>Enter Username:</label> <input type="text"
						class="form-control" name="uname"><br> <br> <label>Enter
						Password:</label> <input type="password" class="form-control" name="pass"><br>
					<input type="submit" class='btn btn-primary' value="Log In">
					
					<a href="<%=request.getContextPath()%>/signup.jsp" class="btn btn-success">Create </a>

				</form>
				
				





			</div>
		</div>
	</div>
</body>
</html>