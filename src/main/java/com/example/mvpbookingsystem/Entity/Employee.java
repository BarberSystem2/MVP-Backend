package com.example.mvpbookingsystem.Entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255, nullable = false)
    private String name;

    @Column(length = 255, nullable = false)
    private String email;

    @Column(length = 20, nullable = false)
    private String number;

    @Lob
    private String image; // base64-billede gemmes som LOB (TEXT/CLOB)

    @ManyToOne(optional = false)
    private Salon salon;

    @ManyToMany
    @JoinTable(
            name = "employee_service",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "service_type_id")
    )
    private Set<ServiceType> serviceTypes = new HashSet<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<WeeklyAvailability> weeklyAvailability = new HashSet<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<DayOff> dayOffs = new HashSet<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Booking> bookings = new HashSet<>();
    // Constructors
    public Employee() {}
    public Employee(String name, String email, String number, String image, Salon salon) {
        this.name = name;
        this.email = email;
        this.number = number;
        this.image = image;
        this.salon = salon;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }

    public Salon getSalon() { return salon; }
    public void setSalon(Salon salon) { this.salon = salon; }

    public Set<ServiceType> getServiceTypes() { return serviceTypes; }
    public void setServiceTypes(Set<ServiceType> serviceTypes) { this.serviceTypes = serviceTypes; }

    public Set<DayOff> getDayOffs() { return dayOffs; }
    public void setDayOffs(Set<DayOff> dayOffs) { this.dayOffs = dayOffs; }

    public Set<WeeklyAvailability> getWeeklyAvailabilities() { return weeklyAvailability; }
    public void setWeeklyAvailabilities(Set<WeeklyAvailability> weeklyAvailabilities) { this.weeklyAvailability = weeklyAvailabilities; }

    public Set<Booking> getBookings() { return bookings; }
    public void setBookings(Set<Booking> bookings) { this.bookings = bookings; }

    // Helper methods for dayOffs
    public void addDayOff(DayOff dayOff) {
        dayOffs.add(dayOff);
        dayOff.setEmployee(this);
    }

    public void removeDayOff(DayOff dayOff) {
        dayOffs.remove(dayOff);
        dayOff.setEmployee(null);
    }
}
