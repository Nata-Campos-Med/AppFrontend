<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="AppFrontend.src.main.java.servlet.modelo.DTO.Usuarios"%>
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
            <a class="btn-admin white" id="btn-users" href="Controlador?menu=Usuarios&accion=Listar">
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
<!--          <section id="message-section" class="message-section"> -->
<!--              <div class="message success-message"> -->
<!--                  <p>  -->
<!--                      Selecciona una de las opciones del menu para empezar -->
<!--                  </p> -->
<!--                  <i class="fas fa-times close-message"></i> -->
<!--              </div> -->
<!--          </section> -->
        <form id="form-people" class="form-people" action="Controlador" method="get">
        <input type="hidden" name="menu" value="Usuarios">
            <h2 id="title-section" class="title-section">Usuarios</h2>
            <div class="input-group-section" id="input-group-section">
                <label class="input-container-admin input-container-general">
                    <input class="input-general" id="input-data-1" type="number" title="Cédula" name="txtcedula" value="${usuarioSeleccionado.getCedulaUsuario()}" autocomplete="off">
                    <span class="input-span-general" id="span-data-1">Cédula</span>
                </label>
                <label class="input-container-admin input-container-general">
                    <input class="input-general" id="input-data-2" type="text" title="Nombre" name="txtnombre" value="${usuarioSeleccionado.getNombreUsuario()}" autocomplete="off">
                    <span class="input-span-general" id="span-data-2">Nombre Completo</span>
                </label>
                <label class="input-container-admin input-container-general">
                    <input class="input-general" id="input-data-3" type="text" title="E-mail" name="txtemail" value="${usuarioSeleccionado.getEmailUsuario()}" autocomplete="off">
                    <span class="input-span-general" id="span-data-3">Correo Electronico</span>
                </label>
                <label class="input-container-admin input-container-general">
                    <input class="input-general" id="input-data-4" type="text" title="Nick" name="txtusuario" value="${usuarioSeleccionado.getUsuario()}" autocomplete="off">
                    <span class="input-span-general" id="span-data-4">Usuario</span>
                </label>
                <label class="input-container-admin input-container-general">
                    <input class="input-general" id="input-data-5" type="text" title="Password" name="txtpassword" value="${usuarioSeleccionado.getPassword()}" autocomplete="off">
                    <span class="input-span-general" id="span-data-5">Contraseña</span>
                </label>
            </div>
            <div id="crud-section" class="crud-section">
                <button class="btn-admin-crud" id="button-add" type="submit" title="Agregar" name="accion" value="Agregar"><img src="./images/plus.svg" alt=""></button>
                <button class="btn-admin-crud" type="submit" title="Actualizar" name="accion" value="Actualizar"><img src="./images/update.svg" alt=""></button>
                <button class="btn-admin-crud" type="submit" title="Consular" name="accion" value="Consultar"><img src="./images/search.svg" alt=""></button>
                <button class="btn-admin-crud" type="submit" title="Eliminar" name="accion" value="Eliminar"><img src="./images/delete.svg" alt=""></button>
            </div>
        </form>
    </main>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <script src="./js/app.js"></script>
    <script src="./js/users.js"></script>
</body>
</html>