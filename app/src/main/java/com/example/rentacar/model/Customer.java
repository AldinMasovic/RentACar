package com.example.rentacar.model;

import com.example.rentacar.model.enums.UserType;

import java.util.List;

public class Customer {
    private String firstName;
    private String lastName;
    private UserType userType;
    private List<Reservation> reservations;
}
