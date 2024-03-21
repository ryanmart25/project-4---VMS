package com.group4.vms;

//public record Login(long id, boolean loggedIn) {
    // Represents a login. If the user has logged in successfully, the boolean is
    // True. False otherwise.
//}

public class Main {
    public static void main(String[] args) {
        // Creating a new Login object
        Login login = new Login(12345, true);

        // Accessing fields using automatically generated getter methods
        System.out.println("ID: " + login.id());
        System.out.println("Logged In: " + login.loggedIn());
    }
}

// Definition of Login record
public record Login(long id, boolean loggedIn) {
    // Represents a login. If the user has logged in successfully, the boolean is
    // True. False otherwise.

    // Custom constructor
    public Login {
        if (id < 0) {
            throw new IllegalArgumentException("Id cannot be negative");
        }
    }

    // Other methods can be added as needed.
}
// Its just trial and error- Heet Shah
