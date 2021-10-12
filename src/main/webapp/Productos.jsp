<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="AppFrontend.src.main.java.servlet.modelo.DTO.Productos"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Creacion de Productos</title>
</head>
<body>
	<div class="row">
		<div class="card col-md-4">
			<div class="card-body">
				<h5 class="card-title">Productos</h5>
				<h6 class="card-subtitle mb-2 text-muted">En este panel podras
					gestionar los datos de los Productos del sistema</h6>
				<div>
					<form class="form-sign" method="get" action="Controlador">

						<div class="form-group">
							<input type="hidden" name="menu" value="Productos"> <label>Codigo:</label>
							<input type="text" name="txtcodigo" class="form-control"
								value="${productoSeleccionado.getCodigoProducto()}">
						</div>
						<div class="form-group">
							<label>Nombre:</label> <input type="text" name="txtnombre"
								class="form-control"
								value="${productoSeleccionado.getNombreProducto()}">
						</div>
						<div class="form-group">
							<label>NitProveedor:</label> <input type="text" name="txtnit_proveedor"
								class="form-control"
								value="${productoSeleccionado.getNitProveedor()}">
						</div>
						<div class="form-group">
							<label>PrecioCompra:</label> <input type="text" name="txtprecio_compra"
								class="form-control" value="${productoSeleccionado.getPrecioCompra()}">
						</div>
						<div class="form-group">
							<label>IvaCompra:</label> <input type="text"	name="txtiva_compra" 
							class="form-control" value="${productoSeleccionado.getIvaCompra()}">
						</div>
						<div class="form-group">
							<label>PrecioVenta:</label> <input type="text"	name="txtprecio_venta" 
							class="form-control" value="${productoSeleccionado.getPrecioVenta()}">
						</div>
						<input type="submit" class="btn btn-primary" name="accion"
							value="Agregar"> <input type="submit"
							class="btn btn-success" name="accion" value="Actualizar">
							<input type="submit"
							class="btn btn-info" name="accion" value="Consultar">
							<input type="submit"
							class="btn btn-info" name="accion" value="Mostrar Todo">
					</form>
				</div>
			</div>
		</div>
		<div class="col-md-8">
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col">Codigo</th>
						<th scope="col">Nombre</th>
						<th scope="col">Nit Proveedor</th>
						<th scope="col">Precio Compra</th>
						<th scope="col">Iva Compra</th>
						<th scope="col">Precio Venta</th>
					</tr>
				</thead>
				<tbody>
					<%
					ArrayList<Productos> lista = (ArrayList<Productos>) request.getAttribute("lista");
					for (Productos producto : lista) {
					%>
					<tr>
						<td><%=producto.getCodigoProducto()%></td>
						<td><%=producto.getNombreProducto()%></td>
						<td><%=producto.getNitProveedor()%></td>
						<td><%=producto.getPrecioCompra()%></td>
						<td><%=producto.getIvaCompra()%></td>
						<td><%=producto.getPrecioVenta()%></td>
						<td><a class="btn btn-warning"
							href="Controlador?menu=Productos&accion=Cargar&id=<%=producto.getCodigoProducto()%>">Editar</a>
							<a class="btn btn-danger"
							href="Controlador?menu=Productos&accion=Eliminar&id=<%=producto.getCodigoProducto()%>">Eliminar</a>
						</td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</div>
		<!-- Optional JavaScript -->
		<!-- jQuery first, then Popper.js, then Bootstrap JS -->
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
			integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
			crossorigin="anonymous"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
			integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
			crossorigin="anonymous"></script>
</body>
</html>