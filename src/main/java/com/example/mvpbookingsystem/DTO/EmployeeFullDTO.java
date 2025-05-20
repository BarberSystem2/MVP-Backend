package com.example.mvpbookingsystem.DTO;

import com.example.mvpbookingsystem.Entity.Salon;

import java.time.LocalTime;
import java.util.List;

public class EmployeeFullDTO {
    private Long employeeId;
    private String image;
    private String employeeName;
    private String employeeEmail;
    private String employeeNumber;
    private List<WeeklyAvailabilityDTO> weeklyAvailability;
    private List<DayOffDTO> dayOffs;
    private List<Long> serviceIds;
    private Long salonId;


    public EmployeeFullDTO() {
    }

    public EmployeeFullDTO(Long id,String image, String name, String email, String number, List<WeeklyAvailabilityDTO> weeklyDTOs, List<DayOffDTO> dayOffs, List<Long> serviceIds, Long salonId) {
        this.employeeId = id;
        this.image = image;
        this.employeeName = name;
        this.employeeEmail = email;
        this.employeeNumber = number;
        this.weeklyAvailability = weeklyDTOs;
        this.dayOffs = dayOffs;
        this.serviceIds = serviceIds;
        this.salonId = salonId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
    public String getEmployeeName() {
        return employeeName;
    }
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    public String getEmployeeEmail() {
        return employeeEmail;
    }
    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }
    public String getEmployeeNumber() {
        return employeeNumber;
    }
    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }
    public List<WeeklyAvailabilityDTO> getWeeklyAvailability() {
        return weeklyAvailability;
    }
    public void setWeeklyAvailability(List<WeeklyAvailabilityDTO> weeklyAvailability) {
        this.weeklyAvailability = weeklyAvailability;
    }
    public List<DayOffDTO> getDayOffs() {
        return dayOffs;
    }
    public void setDayOffs(List<DayOffDTO> dayOffs) {
        this.dayOffs = dayOffs;
    }
    public List<Long> getServiceIds() {
        return serviceIds;
    }
    public void setServiceIds(List<Long> serviceIds) {
        this.serviceIds = serviceIds;
    }
    public Long getSalonId() {
        return salonId;
    }
    public void setSalonId(Long salonId) {
        this.salonId = salonId;
    }

    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }

    // Getters & setters...
}

