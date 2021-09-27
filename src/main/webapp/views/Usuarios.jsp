<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>USUARIOS</title>
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
					<a class="navbar-brand" href="#">Menu Tienda</a>
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

		<h5>AGREGAR USUARIOS</h5>
		<div class="d-flex">
			<div class="card" col-sm-6>
				<div class="card-body">
					<form>
						<div class="form-group">
							<label>CEDULA</label> <input type="text" name="txtDni"
								class="form-control">
						</div>
						<div class="form-group">
							<label>NOMBRE</label> <input type="text" name="txtNombres"
								class="form-control">
						</div>
						<div class="form-group">
							<label>EMAIL</label> <input type="text" name="txtTel"
								class="form-control">
						</div>
						<div class="form-group">
							<label>USUARIO</label> <input type="text" name="txtestado"
								class="form-control">
						</div>
						<div class="form-group">
							<label>PASSWORD</label> <input type="text" name="txtUsuario"
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
							<th scope="col">CEDULA</th>
							<th scope="col">NOMBRES</th>
							<th scope="col">EMAIL</th>
							<th scope="col">USUARIO</th>
							<th scope="col">PASSWORD</th>
							<th scope="col">ACCIONES</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>119283746</td>
							<td>PEPITO PEREZ</td>
							<td>pepito.perez@papeleriawww.com</td>
							<td>adminicial</td>
							<td>admin123456</td>
							<td>Editar - Eliminar</td>
						</tr>
						<tr>
							<td>123456789</td>
							<td>CAROLINA CHACON</td>
							<td>carolina.chacon@papeleriawww.com</td>
							<td>caro.chacon</td>
							<td>caro.c123</td>
							<td>Editar - Eliminar</td>
						</tr>
						<tr>
							<td>987654321</td>
							<td>LAURA BERRIO</td>
							<td>laura.berrio@papeleriawww.com</td>
							<td>laura.berrio</td>
							<td>laura.b123</td>
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