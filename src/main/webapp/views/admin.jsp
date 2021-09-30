<%@ page language="java" contentType="text/html; charset=UTF-8"
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
    <link rel="shortcut icon" href="../images/shop-icon.png" type="image/x-icon">
    <link rel="stylesheet" href="../css/background.css" media="(min-width: 500px)">
    <link rel="stylesheet" href="../css/admin-style.css" >
    <link rel="stylesheet" href="../css/general.css">
    <link rel="stylesheet" href="../css/admin-tablet.css" media="(min-width: 500px)">
    <link rel="stylesheet" href="../css/admin-desktop.css" media="(min-width: 750px)">
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
        <div class="">
            <a class="link-index container-icon" href="../index.html">
                <div class="logo">
                </div>
            </a>
        </div>
        <div class="navbar-btn">
        <button class="btn-admin" id="btn-users" type="button"><img src="../images/user.svg" alt="user"></button>
        <button class="btn-admin" id="btn-customers" type="button"><img src="../images/customer.svg" alt="customer"></button>
        <button class="btn-admin" id="btn-suppliers" type="button"><img src="../images/supplier.svg" alt="supplier"></button>
        <button class="btn-admin" id="btn-products" type="button"><img src="../images/product.svg" alt="product"></button>
        <button class="btn-admin" id="btn-sales" type="button"><img src="../images/sale.svg" alt="sales"></button>
        <button class="btn-admin" id="btn-reports" type="button"><img src="../images/report.svg" alt="reports"></button>
        </div>
        <div class="">
            <div class="menu__container-profile container-icon">
                <i class="fas fa-user-circle"></i>
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
        <section class="message-section"></section>
        <form class="form-people" action="">
            <div class="input-group-section">
                <label class="input-container-admin input-container-general">
                    <input class="input-general" id="input-data-1" type="text" title="" required>
                    <span class="input-span-general" id="span-data-1"></span>
                </label>
                <label class="input-container-admin input-container-general">
                    <input class="input-general" id="input-data-2" type="text" title="" required>
                    <span class="input-span-general" id="span-data-2"></span>
                </label>
                <label class="input-container-admin input-container-general">
                    <input class="input-general" id="input-data-3" type="text" title="" required>
                    <span class="input-span-general" id="span-data-3"></span>
                </label>
                <label class="input-container-admin input-container-general">
                    <input class="input-general" id="input-data-4" type="text" title="" required>
                    <span class="input-span-general" id="span-data-4"></span>
                </label>
                <label class="input-container-admin input-container-general">
                    <input class="input-general" id="input-data-5" type="text" title="" required>
                    <span class="input-span-general" id="span-data-5"></span>
                </label>
            </div>
            <div class="crud-section">
                <button class="btn-admin-crud" type="submit"><img src="../images/search.svg" alt="" srcset=""></button>
                <button class="btn-admin-crud" type="submit"><img src="../images/update.svg" alt="" srcset=""></button>
                <button class="btn-admin-crud" type="submit"><img src="../images/plus.svg" alt="" srcset=""></button>
                <button class="btn-admin-crud" type="submit"><img src="../images/delete.svg" alt="" srcset=""></button>
            </div>
        </form>
    </main>
    <script src="../js/admin.js"></script>
</body>
</html>