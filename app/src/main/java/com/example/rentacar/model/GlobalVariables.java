package com.example.rentacar.model;

import java.time.LocalDate;

public class GlobalVariables {

    public static LocalDate startAt;
    public static LocalDate returnAt;
    public static String pickupLocation = "";

    public static Customer activeUser = null;

    public static LocalDate getStartAt() {
        return startAt;
    }

    public static LocalDate getReturnAt() {
        return returnAt;
    }
}
