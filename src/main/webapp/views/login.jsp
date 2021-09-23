<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Login inicial de una tienda virtual generica. ">
    <title>Papeleria WWW</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
    <link rel="shortcut icon" href="../images/shop-icon.png" type="image/x-icon">
    <link rel="stylesheet" href="../css/background.css" media="(min-width: 500px)">
    <link rel="stylesheet" href="../css/login-style.css" >
    <link rel="stylesheet" href="../css/general.css">
    <link rel="stylesheet" href="../css/login-media.css" media="(min-width: 500px)">
</head>
<body>
    <div class="background" style="display: none;">
        <div class="circle circle-1" id="circle-1"></div>
        <div class="circle circle-2"></div>
        <div class="circle circle-3"></div>
        <div class="circle circle-4"></div>
        <div class="circle circle-5"></div>
    </div>
    <header>
        <a class="container-icon" href="../index.html">
            <div class="icon"></div>
        </a>
        <div class="theme-switch" id="theme-switch" title="switch theme">
            <div class="switch"></div>
        </div>
    </header>
    <main>
        <div class="title-container">
            <h2 class="main-title">Iniciar sesión</h2>
        </div>
        <form id="main-form" class="main-form" action="">
            <div id="form-message-error" class="form-message-error">
                <p>
                    No pudimos encontrar una cuenta con los datos anteriores. Por favor revise que sean correctos o contactese con el administrador.
                </p>
            </div>
            <label class="input-container-login input-container-general input-user-container-login">
                <input class="input-login input-user input-general" id="input-user" type="text" autocomplete="nickname" name="nickname" title="Ingrese su usuario" required>
                <span class="input-span-general" id="input-span-user">Ingrese su usuario</span>
            </label>
            <label class="input-container-login input-container-general input-password-container-login">
                <input class="input-login input-password input-general" id="input-password" type="password" autocomplete="password" name="password" title="Ingrese su contraseña" required>
                <span class="input-span-general">Ingrese su contraseña</span>
                <button type="button" id="btn-view-password" class="btn-view-password" title="Ver u ocultar contraseña"></button>
            </label>
            <div class="btn-container">
                <button id="btn-submit" class="btn-login btn-primary" title="Enviar datos" type="button">Aceptar</button>
                <button class="btn-login btn-secondary" title="Borrar datos" type="reset">Cancelar</button>
            </div>
        </form>
    </main>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="../js/login.js"></script>|
</body>
</html>