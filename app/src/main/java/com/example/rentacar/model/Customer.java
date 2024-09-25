package com.example.rentacar.model;

import com.example.rentacar.model.enums.UserType;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String firstName;
    private final String lastName;
    private final String username;
    private final String password;

    private final UserType userType;
    private final List<Reservation> reservations = new ArrayList<>();

    public Customer(String firstName, String lastName, String username, String password, UserType userType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public UserType getUserType() {
        return userType;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
