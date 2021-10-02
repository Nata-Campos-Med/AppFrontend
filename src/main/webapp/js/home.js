//ALTERNAR MODO OSCURO
const BODY = document.body
const THEME_SWITCH = document.getElementById("theme-switch")
THEME_SWITCH.addEventListener("click", () => {
    BODY.classList.toggle("light-theme")
})

// const BTN_HOME = document.getElementById("btn-home")
// const BTN_USER = document.getElementById("btn-users")
// const BTN_CUSTOMER = document.getElementById("btn-customers")
// const BTN_SUPPLIER = document.getElementById("btn-suppliers")
// const BTN_PRODUCT = document.getElementById("btn-products")
// const BTN_SALE = document.getElementById("btn-sales")
// const BTN_REPORT = document.getElementById("btn-reports")

const WELCOME_MSG = document.getElementById("welcome-message")

//Página de bienvenida
const WELCOME_IMG = document.getElementById("welcome-img")
const RANDOM_NUM = (min, max) => {
    let num = Math.random()*(max-min) + min
    return Math.floor(num)
}
WELCOME_IMG.setAttribute('src', `../images/${RANDOM_NUM(1, 8)}.png`)

///CERRAR MENSAJES con Boton
let btnCloseMessage = document.getElementsByClassName('close-message')
let messages = document.getElementsByClassName('message')
for(let i = 0; i < messages.length; i++) {
    btnCloseMessage[i].addEventListener('click', () => {
        messages[i].style.display = 'none'
    })
}

// BTN_HOME.addEventListener('click', () => {
//     window.location.href = '../home.html'
// })
// BTN_USER.addEventListener('click', () => {
//     window.location.href = '../users.html'
// })
// BTN_CUSTOMER.addEventListener('click', () => {
//     window.location.href = '../customers.html'
// })
// BTN_SUPPLIER.addEventListener('click', () => {
//     window.location.href = '../suppliers.html'
// })
// BTN_PRODUCT.addEventListener('click', () => {
//     window.location.href = '../products.html'
// })
// BTN_SALE.addEventListener('click', () => {
//     window.location.href = '../sales.html'
// })
// BTN_REPORT.addEventListener('click', () => {
//     window.location.href = '../reports.html'
// })