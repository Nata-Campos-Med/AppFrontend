//ALTERNAR MODO OSCURO
const BODY = document.body
const THEME_SWITCH = document.getElementById("theme-switch")
THEME_SWITCH.addEventListener("click", () => {
    BODY.classList.toggle("light-theme")
})

const WELCOME_MSG = document.getElementById("welcome-message")

//Página de bienvenida
const WELCOME_IMG = document.getElementById("welcome-img")
const RANDOM_NUM = (min, max) => {
    let num = Math.random()*(max-min) + min
    return Math.floor(num)
}
WELCOME_IMG.setAttribute('src', `./images/${RANDOM_NUM(1, 8)}.png`)

///CERRAR MENSAJES con Boton
let btnCloseMessage = document.getElementsByClassName('close-message')
let messages = document.getElementsByClassName('message')
for(let i = 0; i < messages.length; i++) {
    btnCloseMessage[i].addEventListener('click', () => {
        messages[i].style.display = 'none'
    })
}
