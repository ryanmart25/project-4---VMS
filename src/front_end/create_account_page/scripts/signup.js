document.addEventListener('DOMContentLoaded', function() {
    const signupForm = document.getElementById('signup');
    const usernameInput = signupForm.querySelector('input[placeholder="Username"]');
    const passwordInput = signupForm.querySelector('input[placeholder="Password"]');
    const confirmPasswordInput = signupForm.querySelector('input[placeholder="Confirm Password"]');

    signupForm.addEventListener('submit', function(event) {
        event.preventDefault(); 

        const username = usernameInput.value.trim();
        const password = passwordInput.value;
        const confirmPassword = confirmPasswordInput.value;

        if (!username || !password || !confirmPassword) {
            alert('Please fill in all fields.');
            return;
        }

        if (password !== confirmPassword) {
            alert('Passwords do not match. Please re-enter your passwords.');
            confirmPasswordInput.value = ''; 
            confirmPasswordInput.focus();
            return;
        }

        if (password.length < 8) {
            alert('Password must be at least 8 characters long.');
            passwordInput.focus();
            return;
        }
        // add api connection 
        /*url = `http://localhost:8080/api/v1/newVolunteer?username=${username}&password=${password}`;
        
        fetch(url, {
            method: 'GET',
        })
        .then(response => {
            if (response.ok) {
                return response.json();
            } else {
                throw new Error('Invalid Username Or Password');
            }
        })
        .then(data => {
            console.log('Login succesful!', data);
        })
        .catch(error => {
            console.error(error.message);
            alert(error.message);
        }); */

        
        console.log('Form submission successful');
        signupForm.submit(); 
    });
});