package com.example.mvpbookingsystem.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Customer {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String firstName;
        private String lastName;
        @Column(unique=true)
        private String email;
        private String phone;
        private String password;

        @OneToMany(mappedBy = "costumer")
        private List<Booking> bookings;
}
