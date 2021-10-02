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
            <a class="btn-admin white" id="btn-home" href="Controlador?menu=menu" target="myFrame">
                <span class="btn-span">Inicio</span>
                <div class="logo">
                </div>
            </a>
        </div>
        <div class="navbar-btn">
            <a class="btn-admin" id="btn-users" href="Controlador?menu=Usuarios&accion=Listar" target="myFrame">
                <span class="btn-span">Usuarios</span>
                <img src="./images/user.svg" alt="user">
            </a>
            <a class="btn-admin" id="btn-customers" href="Controlador?menu=Clientes&accion=Listar" target="myFrame">
                <span class="btn-span">Clientes</span>
                <img src="./images/customer.svg" alt="customer">
            </a>
            <a class="btn-admin" id="btn-suppliers" href="Controlador?menu=Proveedores&accion=Listar" target="myFrame">
                <span class="btn-span">Proveedores</span>
                <img src="./images/supplier.svg" alt="supplier">
            </a>
            <a class="btn-admin" id="btn-products" href="Controlador?menu=Productos&accion=Listar" target="myFrame">
                <span class="btn-span">Productos</span>
                <img src="./images/product.svg" alt="product">
            </a>
            <a class="btn-admin" id="btn-sales" href="Controlador?menu=Ventas&accion=Listar" target="myFrame">
                <span class="btn-span">Ventas</span>
                <img src="./images/sale.svg" alt="sales">
            </a>
            <a class="btn-admin" id="btn-reports" href="./reports.jsp" target="myFrame">
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
                        <span>Cerrar sesión</span>
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
        <section id="message-section" class="message-section">
            <div class="message neutral-message">
                <p>
                    Selecciona una de las opciones del menu para empezar
                </p>
                <i class="fas fa-times close-message"></i>
            </div>
            <div class="welcome-message" id = "welcome-message">
                <article>
                    <h3 class="welcome__subtitle">Bienvenido</h3>
                <h2 class="welcome__title">Papeleria WWW</h2>
                <p class="welcome__text">Aplicación web para la gestión comercial del negocio.</p>
                </article>
                <figure class="welcome__img-container">
                    <img id="welcome-img" class="welcome__img" src="#" alt="Imagen relacionada">
                </figure>
            </div>
        </section>
    </main>
    <script src="./js/home.js"></script>
</body>
</html>