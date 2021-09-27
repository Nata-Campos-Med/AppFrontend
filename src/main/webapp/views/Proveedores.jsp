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
		<h5>PROVEEDOR NUEVO</h5>
		<div class="d-flex">
			<div class="card" col-sm-6>
				<div class="card-body">
					<form>
						<div class="form-group">
							<label>NIT PROVEEDOR</label> <input type="text" name="txtDni"
								class="form-control">
						</div>
						<div class="form-group">
							<label>NOMBRE</label> <input type="text" name="txtNombres"
								class="form-control">
						</div>
						<div class="form-group">
							<label>CIUDAD</label> <input type="text" name="txtTel"
								class="form-control">
						</div>
						<div class="form-group">
							<label>DIRECCION</label> <input type="text" name="txtestado"
								class="form-control">
						</div>
						<div class="form-group">
							<label>TELEFONO</label> <input type="text" name="txtUsuario"
								class="form-control">
						</div>
						<input type="submit" name="accion" value="Agregar"
							class="btn btn-info">
					</form>
				</div>
			</div>
			<div class="col-sm-8">
				<table class="table table-hover">
					<thead class="thead-dark">
						<tr>
							<th scope="col">NIT PROVEEDOR</th>
							<th scope="col">NOMBRES</th>
							<th scope="col">CIUDAD</th>
							<th scope="col">DIRECCION</th>
							<th scope="col">TELEFONO</th>
							<th scope="col">ACCIONES</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>830.130.065-7</td>
							<td>Nika Editorial S A</td>
							<td>nikaeditorialsa@gmail.com</td>
							<td>Cra. 21 # 1F - 79</td>
							<td>4087888</td>
							<td>Editar - Eliminar</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<footer id="footer">
			<p>Todos los derechos reservados</p>
		</footer>
	</div>

</body>
</html>