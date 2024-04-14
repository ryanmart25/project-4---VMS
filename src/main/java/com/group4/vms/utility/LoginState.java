package com.group4.vms.utility;

public record LoginState(long id, boolean loggedIn) {
    // Represents a login. If the user has logged in successfully, the boolean is
    // True. False otherwise.
    //Alternatively, could be used to signify if an account was created succesfully - such as for the POST: /newuser endpoint
}
