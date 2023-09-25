package com.example.rentacar.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Availability {
    Set<Reservation> reservations = new HashSet<>();

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public boolean isAvailable(LocalDate startAt, LocalDate endAt) {

//        if ((reservation.getStatAt().isAfter(startAt) && reservation.getStatAt().isBefore(endAt))
//                || (reservation.getEndAt().isAfter(startAt) && reservation.getEndAt().isBefore(endAt)))
        for (Reservation reservation : reservations) {
            if ((startAt.isAfter(reservation.getStatAt()) && startAt.isBefore(reservation.getEndAt()))
                    || (endAt.isAfter(reservation.getStatAt()) && endAt.isBefore(reservation.getEndAt())
            || (startAt.isBefore(reservation.getStatAt()) && endAt.isAfter(reservation.getEndAt())))) {
                return false;
            }
        }
        return true;
    }
}
