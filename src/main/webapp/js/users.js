const inputUsers = document.getElementsByClassName('input-general')
const buttonAdd = document.getElementById('button-add')

buttonAdd.addEventListener('click', () => {
	for(let i = 0; i < inputUsers.length; i++) {
		if(inputUsers[i] === '') {
			alert('datos incompletos')
			inpútUsers[i].focus()
			break
		}
	}
})