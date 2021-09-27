<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PROVEEDORES</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

</head>
<body>

	<div id="main-content">
		<header id="header">
			<jsp:include page="cerrarSesion.jsp" />
			Bienvenido ${sessionScope.usuario.nombre}
		</header>
		<nav id="nav">
			<nav class="navbar navbar-expand-lg navbar-light bg-info">
				<div class="container-fluid">
					<a class="navbar-brand" href="#">Menu Papeleria WWW</a>
					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="navbar-nav me-auto mb-2 mb-lg-0">
							<li class="nav-item"><a
								style="margin-left: 10px; border: none"
								class="btn btn-outline-light" aria-current="page"
								href="principal.jsp">Inicio</a></li>
							<li class="nav-item"><a
								style="margin-left: 10px; border: none"
								class="btn btn-outline-light" href="Usuarios.jsp">Usuarios</a></li>
							<li class="nav-item"><a
								style="margin-left: 10px; border: none"
								class="btn btn-outline-light" href="Clientes.jsp">Clientes</a></li>
							<li class="nav-item"><a
								style="margin-left: 10px; border: none"
								class="btn btn-outline-light" href="Proveedores.jsp">Proveedores</a>
							</li>
							<li class="nav-item"><a
								style="margin-left: 10px; border: none"
								class="btn btn-outline-light" href="Productos.jsp">Productos</a>
							</li>
							<li class="nav-item"><a
								style="margin-left: 10px; border: none"
								class="btn btn-outline-light" href="RegistrarVenta.jsp">Ventas</a>
							</li>
							<li class="nav-item"><a
								style="margin-left: 10px; border: none"
								class="btn btn-outline-light" href="Reportes.jsp">Reportes</a></li>
						</ul>
					</div>
				</div>
			</nav>
		</nav>
		<div class="d-flex">
			<div class="card" col-sm-6>
				<div class="card-body">
					<form>
						<div class="form-group">
							<label>Nombre del archivo</label> <input type="text" name="txtDni"
								class="form-control">
						</div>
						<input type="submit" name="accion" value="Examinar"
							class="btn btn-info">
						<input type="submit" name="accion" value="Cargar"
							class="btn btn-info">	
					</form>
				</div>
			</div>
			
		</div>
		<footer id="footer">
			<p>Todos los derechos reservados</p>
		</footer>
	</div>

</body>
</html>