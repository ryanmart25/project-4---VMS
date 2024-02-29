package com.group4.vms;

public record Login(long id, boolean loggedIn) {
    // Represents a login. If the user has logged in successfully, the boolean is
    // True. False otherwise.
}
