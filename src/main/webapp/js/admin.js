//Variables alternar modo oscuro
const BODY = document.body;
const THEME_SWITCH = document.getElementById("theme-switch");

//Botones cambiar seccion
const BTN_USER = document.getElementById("btn-users");
const BTN_CUSTOMER = document.getElementById("btn-customers");
const BTN_SUPPLIER = document.getElementById("btn-suppliers");
const BTN_PRODUCT = document.getElementById("btn-products");
const BTN_SALE = document.getElementById("btn-sales");
const BTN_REPORT = document.getElementById("btn-reports");

//Inputs primeras 3 secciones
const INPUT_1 = document.getElementById("input-data-1");
const INPUT_2 = document.getElementById("input-data-2");
const INPUT_3 = document.getElementById("input-data-3");
const INPUT_4 = document.getElementById("input-data-4");
const INPUT_5 = document.getElementById("input-data-5");

//TEXTO DE LOS INPUTS
const SPAN_1 = document.getElementById("span-data-1");
const SPAN_2 = document.getElementById("span-data-2");
const SPAN_3 = document.getElementById("span-data-3");
const SPAN_4 = document.getElementById("span-data-4");
const SPAN_5 = document.getElementById("span-data-5");


//CAMBIO DE TEXTO EN LOS INPUTS
BTN_USER.addEventListener('click', () => {
    SPAN_1.innerHTML = "Cédula";
    SPAN_2.innerHTML = "Nombre Completo";
    SPAN_3.innerHTML = "Correo Electrónico";
    SPAN_4.innerHTML = "Usuario";
    SPAN_5.innerHTML = "Contraseña";
})
BTN_CUSTOMER.addEventListener('click', () => {
    SPAN_1.innerHTML = "Cédula";
    SPAN_2.innerHTML = "Nombre Completo";
    SPAN_3.innerHTML = "Dirección";
    SPAN_4.innerHTML = "Teléfono";
    SPAN_5.innerHTML = "Correo Electrónico";
})
BTN_SUPPLIER.addEventListener('click', () => {
    SPAN_1.innerHTML = "NIT";
    SPAN_2.innerHTML = "Nombre Proveedor";
    SPAN_3.innerHTML = "Dirección";
    SPAN_4.innerHTML = "Teléfono";
    SPAN_5.innerHTML = "Ciudad";
})
BTN_PRODUCT.addEventListener('click', () => {
    alert("Característica no disponible.")
})
BTN_SALE.addEventListener('click', () => {
    alert("Característica no disponible.")
})
BTN_REPORT.addEventListener('click', () => {
    alert("Característica no disponible.")
})

//ALTERNAR MODO OSCURO
THEME_SWITCH.addEventListener("click", () => {
    BODY.classList.toggle("light-theme");
})
