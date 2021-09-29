<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inicio de secion</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
</head>
<body>
	<div class="form-group text-center">
	<h1>Bienvenidos a mi pagina web</h1>
	</div>
	<div class="container mt-4 col-lg-4">
		<div class="card col-sm-10">
			<div class="card-body">
				<form class="form-sign" method="get" action="./loginServlet">       
					<div class="form-group text-center">
						<h3>Login</h3>
						<img src="./imagen/login.png" width="40" alt="40">

					</div>
					<div class="form-group">
						<label>Usuario: </label> <input type="text" name="txtusuario"
							class="form-control">
					</div>

					<div class="form-group">
						<label>Password: </label> <input type="password"
							name="txtpassword" class="form-control">
					</div>

					<div>
						<input type="submit" name= "accion" value="Ingresar" class="btn btn-primary">
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>