//Ver u ocultar contraseña
let btnViewOrHidePassword = document.getElementById('btn-view-password')
let inputPassword = document.getElementById('input-password')
btnViewOrHidePassword.addEventListener('click', () => {
    if(inputPassword.attributes[2].value === 'password') {
        inputPassword.setAttribute('type', 'text')
        btnViewOrHidePassword.style.backgroundImage = 'url("./images/close-eye.png")'
    } else if(inputPassword.attributes[2].value === 'text') {
        inputPassword.setAttribute('type', 'password')
        btnViewOrHidePassword.style.backgroundImage = 'url("./images/eye.png")'
    }
})

//Cerrar mensaje
let errorContainer = document.getElementById('form-message-error')
let btnCloseMessage = document.getElementById('close-message')
btnCloseMessage.addEventListener('click', () => {
    errorContainer.style.display = 'none'
})



//ALTERNAR MODO OSCURO
let body = document.body
let themeSwitch = document.getElementById("theme-switch")

themeSwitch.addEventListener("click", () => {
    body.classList.toggle("light-theme")
})
