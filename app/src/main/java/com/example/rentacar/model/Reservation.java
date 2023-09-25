package com.example.rentacar.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Reservation {
    private LocalDateTime statAt;
    private LocalDateTime endAt;
    private Customer customer;
    private BigDecimal totalToPay;
}
