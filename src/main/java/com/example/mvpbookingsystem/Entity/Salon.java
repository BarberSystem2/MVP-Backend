package com.example.mvpbookingsystem.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Salon {
    @Id
    @GeneratedValue
    private Long id;

    private String navn;
    private String adresse;
    private String telefonnummer;

    @OneToMany(mappedBy = "salon")
    private List<Medarbejder> medarbejdere;
}

