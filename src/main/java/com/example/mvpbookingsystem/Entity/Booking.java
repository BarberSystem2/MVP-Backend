package com.example.mvpbookingsystem.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime date;


    @ManyToOne
    private Employee employee;

    @ManyToOne
    private ServiceType serviceType;

    @ManyToOne
    private Costumer costumer;

    @ManyToOne
    private Salon salon;
}
