package com.example.mvpbookingsystem.Entity;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Salon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255, nullable = false)
    private String name;

    @Column(length = 255, nullable = false)
    private String address;

    @Column(length = 20, nullable = false)
    private String number;

    @OneToMany(mappedBy = "salon", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Employee> employees = new HashSet<>();
    @OneToMany(mappedBy = "salon", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Booking> bookings = new HashSet<>();
    @OneToOne
    private Admin admin;

    public Salon() {
    }

    // ✅ Getters & setters

    public Salon(String name, String address, String number, Admin admin) {
        this.name = name;
        this.address = address;
        this.number = number;
        this.admin = admin;
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
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public Set<Employee> getEmployees() {
        return employees;
    }
    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
    public Set<Booking> getBookings() {
        return bookings;
    }
    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }
    public Admin getAdmins() {
        return admin;
    }
    public void setAdmin(Admin admins) {
        this.admin= admins;
    }

}
