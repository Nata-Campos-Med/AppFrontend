<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>
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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <link rel="stylesheet" href="./css/background.css" media="(min-width: 500px)">
    <link rel="stylesheet" href="./css/admin-style.css" >
    <link rel="stylesheet" href="./css/general.css">
    <link rel="stylesheet" href="./css/admin-tablet.css" media="(min-width: 500px)">
    <link rel="stylesheet" href="./css/admin-desktop.css" media="(min-width: 750px)">
    <link rel="stylesheet" href="./css/fix.css">
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
            <a class="btn-admin" id="btn-products" href="Controlador?menu=Productos&accion=Listar">
                <span class="btn-span">Productos</span>
                <img src="./images/product.svg" alt="product">
            </a>
            <a class="btn-admin white" id="btn-sales" href="Controlador?menu=Ventas&accion=Listar">
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
                        <h3>Numero de factura</h3>
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
    </main>
    <script src="./js/app.js"></script>
</body>
</html>