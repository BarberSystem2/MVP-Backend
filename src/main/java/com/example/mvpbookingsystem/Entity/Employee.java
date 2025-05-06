package com.example.mvpbookingsystem.Entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String email;
    private String number;

    @ManyToOne
    @JoinColumn(name = "salon_id")
    private Salon salon;

    @OneToMany(mappedBy = "employee")
    private List<Booking> bookinger;
    public Employee() {}
    public Employee(String name, String email, String number, Salon salon) {
        this.name = name;
        this.email = email;
        this.number = number;
        this.salon = salon;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public Salon getSalon() {
        return salon;
    }
    public void setSalon(Salon salon) {
        this.salon = salon;
    }
    public List<Booking> getBookinger() {
        return bookinger;
    }
    public void setBookinger(List<Booking> bookinger) {
        this.bookinger = bookinger;
    }
}


