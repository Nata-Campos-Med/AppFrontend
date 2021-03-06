<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="AppFrontend.src.main.java.servlet.modelo.DTO.Productos"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Aplicación principal de administrador.">
    <title>App tienda WWW</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
    <link rel="preconnect" href="https://use.fontawesome.com">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css">
    <link rel="shortcut icon" href="./images/shop-icon.png" type="image/x-icon">
    <link rel="stylesheet" href="./css/background.css" media="(min-width: 500px)">
    <link rel="stylesheet" href="./css/admin-style.css" >
    <link rel="stylesheet" href="./css/general.css">
    <link rel="stylesheet" href="./css/admin-tablet.css" media="(min-width: 500px)">
    <link rel="stylesheet" href="./css/admin-desktop.css" media="(min-width: 750px)">
</head>
<body>
    <div class="background" style="display: none;">
        <div class="circle circle-1"></div>
        <div class="circle circle-2"></div>
        <div class="circle circle-3"></div>
        <div class="circle circle-4"></div>
        <div class="circle circle-5"></div>
    </div>

    <nav class="navbar">
        <div>
            <a class="btn-admin" id="btn-home" href="Controlador?menu=menu">
                <span class="btn-span">Inicio</span>
                <div class="logo">
                </div>
            </a>
        </div>
        <div class="navbar-btn">
            <a class="btn-admin" id="btn-users" href="Controlador?menu=Usuarios&accion=Listar">
                <span class="btn-span">Usuarios</span>
                <img src="./images/user.svg" alt="user">
            </a>
            <a class="btn-admin" id="btn-customers" href="Controlador?menu=Clientes&accion=Listar">
                <span class="btn-span">Clientes</span>
                <img src="./images/customer.svg" alt="customer">
            </a>
            <a class="btn-admin" id="btn-suppliers" href="Controlador?menu=Proveedores&accion=Listar">
                <span class="btn-span">Proveedores</span>
                <img src="./images/supplier.svg" alt="supplier">
            </a>
            <a class="btn-admin white" id="btn-products" href="Controlador?menu=Productos&accion=Listar">
                <span class="btn-span">Productos</span>
                <img src="./images/product.svg" alt="product">
            </a>
            <a class="btn-admin" id="btn-sales" href="Controlador?menu=Ventas&accion=Listar">
                <span class="btn-span">Ventas</span>
                <img src="./images/sale.svg" alt="sales">
            </a>
            <a class="btn-admin" id="btn-reports" href="./Reportes.jsp">
                <span class="btn-span">Reportes</span>
                <img src="./images/report.svg" alt="reports">
            </a>
        </div>
        <div>
            <div class="menu__container-profile container-icon">
                <i class="fas fa-user-circle"></i>
                <div class="profile">
                    <h3>${usuario.getNombreUsuario()}</h3>
                    <div class="sign-out">
                        <a href="./login.jsp">Cerrar sesión</a>
                        <i class="fas fa-sign-out-alt"></i>
                    </div>
                </div>
            </div>
            <div class="menu__container-settings container-icon">
                <i class="fas fa-cog settings-icon"></i>
                <div class="settings">
                    <h3>Configuración</h3>
                    <div class="container-theme">
                        <span>Tema</span>
                        <div class="theme-switch" id="theme-switch" title="switch theme">
                            <div class="switch"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </nav>

    <main>
        <form id="form-people" class="form-people" action="Controlador" method="get">
        <h2 id="title-section" class="title-section">Productos</h2>
        <div class="file-section" id="file-section">
            <input type="file" id="input-file" class="input-file" accept=".csv"/>
            <button class="btn-file" type="submit">Enviar</button>
        </div>
        <input type="hidden" name="menu" value="Productos">
            <div class="input-group-section" id="input-group-section">
                <label class="input-container-admin input-container-general">
                    <input class="input-general" id="input-data-1" type="number" title="Codigo" name="txtcodigo" value="${productoSeleccionado.getCodigoProducto()}" autocomplete="off">
                    <span class="input-span-general" id="span-data-1">Codigo Producto</span>
                </label>
                <label class="input-container-admin input-container-general">
                    <input class="input-general" id="input-data-2" type="text" title="Nombre" name="txtnombre" value="${productoSeleccionado.getNombreProducto()}" autocomplete="off">
                    <span class="input-span-general" id="span-data-2">Nombre Producto</span>
                </label>
                <label class="input-container-admin input-container-general">
                    <input class="input-general" id="input-data-3" type="number" title="Nit" name="txtnit_proveedor" value="${productoSeleccionado.getNitProveedor()}" autocomplete="off">
                    <span class="input-span-general" id="span-data-3">Nit Proveedor</span>
                </label>
                <label class="input-container-admin input-container-general">
                    <input class="input-general" id="input-data-4" type="number" title="Precio Compra" name="txtprecio_compra" value="${productoSeleccionado.getPrecioCompra()}" autocomplete="off">
                    <span class="input-span-general" id="span-data-4">Precio Compra</span>
                </label>
                <label class="input-container-admin input-container-general">
                    <input class="input-general" id="input-data-5" type="number" title="Iva Compra" name="txtiva_compra" value="${productoSeleccionado.getIvaCompra()}" autocomplete="off">
                    <span class="input-span-general" id="span-data-5">Iva Compra</span>
                </label>
                <label class="input-container-admin input-container-general">
                    <input class="input-general" id="input-data-5" type="number" title="Precio venta" name="txtprecio_venta" value="${productoSeleccionado.getPrecioVenta()}" autocomplete="off">
                    <span class="input-span-general" id="span-data-5">Precio Venta </span>
                </label>
            </div>
            <div id="crud-section" class="crud-section">
                <button class="btn-admin-crud" type="submit" title="Agregar" name="accion" value="Agregar"><img src="./images/plus.svg" alt=""></button>
                <button class="btn-admin-crud" type="submit" title="Actualizar" name="accion" value="Actualizar"><img src="./images/update.svg" alt=""></button>
                <button class="btn-admin-crud" type="submit" title="Consular" name="accion" value="Consultar"><img src="./images/search.svg" alt=""></button>
                <button class="btn-admin-crud" type="submit" title="Eliminar" name="accion" value="Eliminar"><img src="./images/delete.svg" alt=""></button>
            </div>
        </form>
    </main>
    <script src="./js/app.js"></script>

		<div class="col-md-8">
			<table class="table">
				<thead class="thead-dark">
					
				
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