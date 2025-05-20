package com.example.mvpbookingsystem.Entity;

import jakarta.persistence.*;

import java.time.LocalTime;
@Entity
public class WeeklyAvailability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Employee employee;

    @Column(nullable = false)
    private int weekDay; // 1 = Mandag, 2 = Tirsdag, osv.

    @Column(nullable = false)
    private LocalTime startTime;

    @Column(nullable = false)
    private LocalTime endTime;

    public WeeklyAvailability() {
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Employee getEmployee() {
        return employee;
    }
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    public int getWeekDay() {
        return weekDay;
    }
    public void setWeekDay(int weekDay) {
        this.weekDay = weekDay;
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

}
