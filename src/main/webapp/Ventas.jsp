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
<title>Ventas</title>
</head>
<body>
	<div class="row">
		<div class="col-md-5 seccion1">
			<form method="get" action="Controlador">
				<div class="card">
					<div class="card-body">
						<div class="form-group">
							<label> Datos Clientes</label>
						</div>
						<input type="hidden" name="menu" value="Ventas"> 
						<input type="hidden" name="UsuarioActivo" value="${usuarioSeleccionado.getCedulaUsuario()}" >
						<div class="form-group d-flex">
							<div class="col-sm-6 d-flex">
								<input type="number" name="cedulacliente" class="form-control"
									placeholder="cedula cliente" value="${clienteSeleccionado.getCedulaCliente()}"> 
								<input type="submit" name="accion" value="BuscarCliente"
									class="btn btn-outline-info">
							</div>
							<div class="col-sm-6">
								<input type="text" name="nombrecliente" class="form-control"
									placeholder="Nombre Cliente" value="${clienteSeleccionado.getNombreCliente()}">
							</div>
						</div>
					</div>
				</div>
				
				<div class="card">
					<div class="card-body">
						<div class="form-group">
							<label> Datos Productos </label>
						</div>
						<div class="form-group d-flex">
							<div class="col-sm-6 d-flex">
								<input type="number" name="codigoproducto" class="form-control"
									placeholder="codigo producto" value="${productoSeleccionado.getCodigoProducto()}"> 
								<input type="submit" name="accion" value="BuscarProducto"
									class="btn btn-outline-info">
							</div>
							<div class="col-sm-6">
								<input type="text" name="nombreproducto" class="form-control"
									placeholder="Nombre producto" value="${productoSeleccionado.getNombreProducto()}">
							</div>
						</div>
						<div class="form-group d-flex">
							<div class="col-sm-6 d-flex">
								<input type="number" name="precioproducto" class="form-control"
									placeholder="$  0000.00" value="${productoSeleccionado.getPrecioVenta()}">

							</div>
							<div class="col-sm-3">
								<input type="number" name="cantidadproducto" class="form-control"
									placeholder="Cantidad" value="">
							</div>
							<div class="col-sm-3">
								<input type="text" name="ivaproducto" class="form-control"
									placeholder="Valor Iva" value="${productoSeleccionado.getIvaCompra()}">
							</div>
						</div>
						<div class="form-group d-flex">
							<input type="submit" name="accion" value="AgregarProducto"
								class="btn btn-outline-dark">
						</div>
					</div>
				</div>
			</form>
		</div>
		
		<div class="col-md-7 seccion2">
			<div class="card">
				<div class="card-header">
					<div class="form-group row">
					<label class="col-sm-3 col-form-label">Numero Factura</label>
					<input class="form-control col-md-4" type="text" name="numerofactura" value="${numerofactura}">			
					</div>				
				</div>
				<div class="card-body">
					<table class="table">
						<thead class="thead-dark">
							<tr>
								<th>#</th>
								<th>codigo</th>
								<th>producto</th>
								<th>precio</th>
								<th>cantidad</th>
								<th>iva</th>
								<th>total</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach var="lista" items="${listaventas}">
							<tr>
								<th>${lista.getCodigoDetalleVenta()}</th>
								<th>${lista.getCodigoProducto()}</th>
								<th>${lista.getDescripcionProducto()}</th>
								<th>${lista.getPrecioProducto()}</th>
								<th>${lista.getCantidadProducto()}</th>
								<th>${lista.getValorIva()}</th>
								<th>${lista.getValorVenta()}</th>
							</tr>
						</c:forEach>
						</tbody>
					</table>				
				</div>
				<div class="card-footer d-flex">
					<div class="col-md-4">
						<label>Subtotal</label></br> </br>
						<label>iva</label></br> </br>
						<label>total a pagar</label></br> </br>
					</div>
					<div class="col-md-4">
						<input type="text" name="txtsubtotal" class="form-control" placeholder="$ 00.000.00" disabled="disabled" value="${totalsubtotal}">
						<input type="text" name="txttotaliva" class="form-control" placeholder="$ 00.000.00" disabled="disabled" value="${totaliva}">
						<input type="text" name="txttotalapagar" class="form-control" placeholder="$ 00.000.00" disabled="disabled" value="${totalapagar}">
					</div>									
				</div>							
			</div>	
			
			<div class="card-footer" d-flex>
				<div class="col-md-8">
				 <!-- enviamos los tres valores al controlador --> 
					<a class="btn btn-success" onclick="print()" href="Controlador?menu=Ventas&accion=GenerarVenta&cedulacliente=${clienteSeleccionado.getCedulaCliente()}&UsuarioActivo=${usuarioSeleccionado.getCedulaUsuario()}&numerofactura=${numerofactura}">Generar Venta</a>
					<a class="btn btn-danger" href="Controlador?menu=Ventas&accion=NuevaVenta">Nueva Venta</a>
				</div>
			</div>				
		</div>
		
		
		
		
		
	</div>
</body>
</html>