package com.example.mvpbookingsystem.Entity;

import jakarta.persistence.*;
import org.apache.catalina.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private LocalTime startTime;

    @Column(nullable = false)
    private LocalTime endTime;

    @ManyToOne(optional = false)
    private Customer customer;

    @ManyToOne(optional = false)
    private Employee employee;

    @ManyToOne(optional = false)
    private ServiceType serviceType;

    @ManyToOne (optional = false)
    private Salon salon;

    public Booking() {
    }

    public Booking(LocalDate date, LocalTime startTime, LocalTime endTime, Customer customer, Employee employee, ServiceType serviceType, Salon salon) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.customer = customer;
        this.employee = employee;
        this.serviceType = serviceType;
        this.salon = salon;

    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public LocalTime getStartTime() {
        return startTime;
    }
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }
    public LocalTime getEndTime() {
        return endTime;
    }
    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public Employee getEmployee() {
        return employee;
    }
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    public ServiceType getServiceType() {
        return serviceType;
    }
    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }
    public Salon getSalon() {
        return salon;
    }
    public void setSalon(Salon salon) {
        this.salon = salon;
    }

}

