package com.example.mvpbookingsystem.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class ServiceType {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;
    private int price;
    private int estimatedMinutes;

    @OneToMany(mappedBy = "serviceType")
    private List<Booking> bookings = new ArrayList<>();

    public ServiceType(String name, String description, int price, int estimatedMinutes) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.estimatedMinutes = estimatedMinutes;
    }

    public ServiceType() {

    }

    public Long getServiceTypeId() {
        return id;
    }
    public void setServiceTypeId(Long id) {
        this.id = id;
    }
    public String getServiceTypeName() {
        return name;
    }
    public void setServiceTypeName(String name) {
        this.name = name;
    }
    public String getServiceTypeDescription() {
        return description;
    }
    public void setServiceTypeDescription(String description) {
        this.description = description;
    }
    public int getServiceTypePrice() {
        return price;
    }
    public void setServiceTypePrice(int price) {
        this.price = price;
    }
    public int getServiceTypeEstimatedMinutes() {
        return estimatedMinutes;
    }
    public void setServiceTypeEstimatedMinutes(int estimatedMinutes) {
        this.estimatedMinutes = estimatedMinutes;
    }
    public List<Booking> getServiceTypeBookings() {
        return bookings;
    }
    public void setServiceTypeBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}

