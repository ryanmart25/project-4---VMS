const form = document.getElementById('form');
const username = document.getElementById('username');
const password = document.getElementById('password');

form.addEventListener('submit', (e) => {
    e.preventDefault();

    validateInputs();
});

//error message for empty string
const setError = (element, message) => {
    const inputControl = element.parentElement;
    const errorDisplay = inputControl.querySelector('.error');

    errorDisplay.innerText = message;
    inputControl.classList.add('error');
    inputControl.classList.remove('success');
}

//if element is present, no error message
const setSuccess = element => {
    const inputControl = element.parentElement;
    const errorDisplay = inputControl.querySelector('.error');
};


const validateInputs = () => {
    const usernameValue = username.value.trim();
    const passwordValue = password.value.trim();
    
    //if username doesn't match
    if(usernameValue === '') {
        setError(username, 'Username is required');
    } else {
        setSuccess(username);
    }

    if(passwordValue === '') {
        setError(password, 'Password is required');
    } 
    
}