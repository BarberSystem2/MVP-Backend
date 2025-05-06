package com.example.mvpbookingsystem.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class ServiceType {
    @Id
    @GeneratedValue
    private Long id;

    private String navn;
    private String beskrivelse;
    private double pris;
    private int varighedIMinutter;

    @OneToMany(mappedBy = "service")
    private List<Booking> bookinger;
}

