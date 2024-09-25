package com.example.rentacar.model;

import java.time.LocalDate;

public class GlobalVariables {

    public static LocalDate startAt = LocalDate.now();
    public static LocalDate returnAt = LocalDate.now();
    public static String pickupLocation = "";

    public static Customer activeUser;

    public static LocalDate getStartAt() {
        return startAt;
    }

    public static LocalDate getReturnAt() {
        return returnAt;
    }
}
