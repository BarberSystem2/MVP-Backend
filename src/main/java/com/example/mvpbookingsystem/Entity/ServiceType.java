package com.example.mvpbookingsystem.Entity;

import jakarta.persistence.*;

import java.util.List;

public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private double price;
    private int durationInMinutes;

    @ManyToOne
    private Salon salon;

    @OneToMany(mappedBy = "serviceType")
    private List<Booking> bookings;
    public ServiceType() {
    }
}
