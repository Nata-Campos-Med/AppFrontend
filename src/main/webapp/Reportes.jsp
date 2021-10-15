<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Reportes</title>
</head>
<body>
	<div class="row">
		<div class="col-md-5 seccion1">
		<form action="Controlador" method="get">
			<div class="card">
				<div class="card-body">
					<div class="form-group">
						<h2>Seleccione tipo de reporte</h2>					
					</div>
					<input type="hidden" name="menu" value="Reportes">
					<div class="form-group d-flex">
						<div class="col-sm-6 d-flex">
							<input type="submit" name="accion" value="ReporteUsuarios" class="btn btn-outline-info" >
							<input type="submit" name="accion" value="ReporteClientes" class="btn btn-outline-info" >
							<input type="submit" name="accion" value="ReporteVentas" class="btn btn-outline-info" >
						</div>
					</div>
				</div>
			</div>
			</form>
		</div>
		<div class="col-md-7 seccion2">
			<div class="card">
				<div class="card-body">
					<div class="form-group">
					<h2> Detalle del Reporte</h2>
					</div>
					
					<!-- <table class="table table-dark table-striped">-->
					<table class="table table-striped"> 
					
					<c:if test="${opcion==1}">
						<thead>
							<tr>
								<th scope="col">Cedula</th>
								<th scope="col">Nombre</th>
								<th scope="col">Email</th>
								<th scope="col">Usuario </th>								
							</tr>							
						</thead>
						<c:forEach var="lista" items="${listaUsuarios}"> 
						<tbody>					
							<tr>
								<td>${lista.getCedulaUsuario()}</td>
								<td>${lista.getNombreUsuario()}</td>
								<td>${lista.getEmailUsuario()}</td>
								<td>${lista.getUsuario()}</td>
							</tr>	
						</c:forEach>				
						</tbody>
					</c:if>
					<c:if test="${opcion==2}">
						<thead>
							<tr>
								<th scope="col">Cedula</th>
								<th scope="col">Nombre</th>
								<th scope="col">Email</th>
								<th scope="col">Direccion </th>								
								<th scope="col">Telefono </th>
							</tr>							
						</thead>
						<c:forEach var="lista" items="${listaClientes}">
						<tbody>					
							<tr>
								<td>${lista.getCedulaCliente()}</td>
								<td>${lista.getDireccionCliente()}</td>
								<td>${lista.getEmailCliente()}</td>
								<td>${lista.getNombreCliente()}</td>
								<td>${lista.getTelefonoCliente()}</td>
							</tr>	
						</c:forEach>				
						</tbody>
					</c:if>
					<c:if test="${opcion==3}">
						<thead>
							<tr>
								<th scope="col">#</th>
								<th scope="col">codigo</th>
								<th scope="col">producto</th>
								<th scope="col">precio</th>
								<th scope="col">cantidad</th>
								<th scope="col">iva</th>
								<th scope="col">total</th>
							</tr>							
						</thead>
						<c:forEach var="lista" items="${listaVentas}">
						<tbody>					
							<tr>
								<th>${lista.getCodigo_detalle_venta()}</th>
								<th>${lista.getCodigo_producto()}</th>
								<th>${lista.getDescripcion_producto()}</th>
								<th>${lista.getPrecio_producto()}</th>
								<th>${lista.getCantidad_producto()}</th>
								<th>${lista.getValor_iva()}</th>
								<th>${lista.getValor_venta()}</th>
							</tr>	
						</c:forEach>				
						</tbody>
					</c:if>
					</table>
				</div>
			</div>
		</div>
	</div>


</body>
</html>