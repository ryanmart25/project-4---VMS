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

        console.log(username);
        console.log(password);

        const usernames = ["Cindy", "Amy", "Joe"];
       // const passwords = ["Cats", "Ice", "Lmao"];

        let x = false;
        Boolean(x);

        for (let i = 0; i < usernames.length; i++) {
            if (usernames[i] === username){
                x = true;
                break;
            }
        }
           
        if (!x) {
            console.log("Invalid Username");
        } else { 
            console.log(username);
        }

        document.querySelector('input[type="text"]').value = '';
        document.querySelector('input[type="password"]').value = '';

    });
});