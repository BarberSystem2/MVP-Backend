package com.example.mvpbookingsystem.Entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class DayOff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Employee employee;

    @Column(nullable = false)
    private LocalDate date;

    // Constructors
    public DayOff(Employee employee, LocalDate date) {
        this.employee = employee;
        this.date = date;
    }
    public DayOff() {}

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
}
