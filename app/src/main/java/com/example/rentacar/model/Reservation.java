package com.example.rentacar.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Reservation {
    private final LocalDate statAt;
    private final LocalDate endAt;
    private final Customer customer;
    private final BigDecimal totalToPay;
    private final Car car;

    public Reservation(LocalDate statAt, LocalDate endAt, Customer customer, BigDecimal totalToPay, Car car) {
        this.statAt = statAt;
        this.endAt = endAt;
        this.customer = customer;
        this.totalToPay = totalToPay;
        this.car = car;
    }

    public LocalDate getStatAt() {
        return statAt;
    }

    public LocalDate getEndAt() {
        return endAt;
    }

    public Customer getCustomer() {
        return customer;
    }

    public BigDecimal getTotalToPay() {
        return totalToPay;
    }

    public Car getCar() {
        return car;
    }
}
