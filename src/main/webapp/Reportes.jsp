<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
            <a class="btn-admin" id="btn-sales" href="Controlador?menu=Ventas&accion=Listar">
                <span class="btn-span">Ventas</span>
                <img src="./images/sale.svg" alt="sales">
            </a>
            <a class="btn-admin white" id="btn-reports" href="./Reportes.jsp">
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
            <h2> Detalle del Reporte</h2>
            <div class="col-md-7 seccion2">
                <div class="card">
                    <div class="card-body">
                        <div class="form-group">

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
                                    <td>${lista.getNombreCliente()}</td>                                    
                                    <td>${lista.getEmailCliente()}</td>
                                    <td>${lista.getDireccionCliente()}</td>
                                    <td>${lista.getTelefonoCliente()}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </c:if>
                        <c:if test="${opcion==3}">
                            <thead>
                                <tr>
                                    <th scope="col">Cedula Cliente</th>
                                    <th scope="col">Nombre Cliente</th>
                                    <th scope="col">Total venta</th>
                                </tr>
                            </thead>
                            <c:forEach var="lista" items="${listaVentas}">
                            <tbody>
                                <tr>
                                    <th>${lista.getCedulaCliente()}</th>
                                    <th>${lista.getNombreCliente()}</th>
                                    <th>${lista.getTotalVenta()}</th>
                                </tr>
                            </c:forEach>
                            </tbody>
                            <table>
                            <form>
                            <div class="form-group d-flex">
                            <div class="col-sm-6 d-flex">
                            <tr>
                            <th>${totalVenta}</th>
                            </tr>
                            </div>
                            </div>
                            </form>
                            </table>
                        </c:if>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </main>
    <script src="./js/app.js"></script>
</body>
</html>