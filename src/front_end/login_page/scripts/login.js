document.addEventListener('DOMContentLoaded', function() {
    const loginForm = document.getElementById('login');

    loginForm.addEventListener('submit', function(event) {
        event.preventDefault();

        const username = document.querySelector('input[type="text"]').value;
        const password = document.querySelector('input[type="password"]').value;

        if (username.trim() === '' || password.trim() === '') {
            alert('Please enter both username and password.');
            return;
        }
        
        // add api connection
        const url = `http://localhost:63342/api/v1/verify?username=${encodeURIComponent(username)}&password=${encodeURIComponent(password)}`;
        
        fetch(url, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({username, password})
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
        });

        document.querySelector('input[type="text"]').value = '';
        document.querySelector('input[type="password"]').value = '';

    });
});