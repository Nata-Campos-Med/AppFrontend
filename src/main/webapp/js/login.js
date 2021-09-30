let btnViewOrHidePassword = document.getElementById('btn-view-password');
let inputPassword = document.getElementById('input-password');
let inputUser = document.getElementById('input-user');
let errorContainer = document.getElementById('form-message-error');
let btnSubmit = document.getElementById('btn-submit');


//Ver u ocultar contraseña
btnViewOrHidePassword.addEventListener('click', () => {
    if(inputPassword.attributes[2].value === 'password') {
        inputPassword.setAttribute('type', 'text');
        btnViewOrHidePassword.style.backgroundImage = 'url("../images/close-eye.png")';
    } else if(inputPassword.attributes[2].value === 'text') {
        inputPassword.setAttribute('type', 'password');
        btnViewOrHidePassword.style.backgroundImage = 'url("../images/eye.png")';
    }
})

//VALIDACION INICION SESIÓN

//El evento de enter solo debe funcionar cuando el formulario este lleno

//Dependiendo del backend que se realice cambiar el tipo de boton y hacer la
//lógica pertinente para que el formulario y los eventos funcionen bien.

//Reevaluar botón cancelar

inputUser.addEventListener('keypress', (e) => {
    if(e.keyCode === 13) {
        if(inputUser.value != '' && inputPassword.value != ''){
            validateAdmin();
        } else {
            inputPassword.focus();
        }
    }
})

inputPassword.addEventListener('keypress', (e) => {
    if(e.keyCode === 13) {
        if(inputUser.value != '' && inputPassword.value != ''){
            validateAdmin();
        } else {
            inputUser.focus();
        }
    }
})

btnSubmit.addEventListener('click', () => validateAdmin())

const validateAdmin = () => {
    if (inputUser.value === 'admininicial' && inputPassword.value === '123456') {
        window.location.href = '../views/admin.html';
    } else {
        errorContainer.style.display = 'block';
    }
}

//ALTERNAR MODO OSCURO

let body = document.body;
let themeSwitch = document.getElementById("theme-switch");

themeSwitch.addEventListener("click", () => {
    body.classList.toggle("light-theme")
})
