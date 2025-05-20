package com.example.mvpbookingsystem.DTO;

import java.time.LocalTime;

public class DailyAvailabilityDTO {
    private Long employeeId;
    private String employeeName;
    private String imageUrl;
    private boolean isOpen;
    private LocalTime startTime;
    private LocalTime endTime;
    public DailyAvailabilityDTO() {}
    public DailyAvailabilityDTO(Long employeeId, String employeeName, String imageUrl, boolean isOpen, LocalTime startTime, LocalTime endTime) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.imageUrl = imageUrl;
        this.isOpen = isOpen;
        this.startTime = startTime;
        this.endTime = endTime;
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
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public boolean isOpen() {
        return isOpen;
    }
    public void setOpen(boolean open) {
        isOpen = open;
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
