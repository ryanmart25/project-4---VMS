### An explanation of the code in this folder. A discussion of the structure of the source code, reasonings, proof of work. 

*Login Endpoints*
At the time of writing there are two main endpoints. 
  1. verifyLogin(email, password) : Login
  2. addAccount(firstName, lastName, email, password, pronouns) : Login
# Verify Login
Verify Login takes two parameters in the request URL. email, password. 
The sequence is as follows: 
  1. The API layer ensures both parameters exist and follow the format of an email string and password string.
     After verification, the request is handed off to the Service layer.
  2. The service layer searches for the employee with the supplied email and password.
  3. On successful find, the service layer returns a Good login. On failure, a Bad login is sent.
# Add Account



--Last edit by Ryan Martinez, 4/9/2024
