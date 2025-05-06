package com.example.mvpbookingsystem.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

public class BookingListDTO {
    private int bookingId;
    private String salonName;
    private LocalDate bookingDate;
    private LocalTime bookingTime;
    private String costumerName;
    private String employeeName;
    private String serviceType;
    private int serviceTypePrice;

    public BookingListDTO() {}
    public BookingListDTO(int bookingId, String salonName, LocalDate bookingDate,LocalTime bookingTime, String costumerName, String employeeName, String serviceType, int serviceTypePrice) {
        this.bookingId = bookingId;
        this.salonName = salonName;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
        this.costumerName = costumerName;
        this.employeeName = employeeName;
        this.serviceType = serviceType;
        this.serviceTypePrice = serviceTypePrice;
    }
    public int getBookingId() {
        return bookingId;
    }
    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }
    public String getSalonName() {
        return salonName;
    }
    public void setSalonName(String salonName) {
        this.salonName = salonName;
    }
    public LocalDate getBookingDate() {
        return bookingDate;
    }
    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }
    public LocalTime getBookingTime() {
        return bookingTime;
    }
    public void setBookingTime(LocalTime bookingTime) {
        this.bookingTime = bookingTime;
    }
    public String getCostumerName() {
        return costumerName;
    }
    public void setCostumerName(String costumerName) {
        this.costumerName = costumerName;
    }
    public String getEmployeeName() {
        return employeeName;
    }
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    public String getServiceType() {
        return serviceType;
    }
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }
    public int getServiceTypePrice() {
        return serviceTypePrice;
    }
    public void setServiceTypePrice(int serviceTypePrice) {
        this.serviceTypePrice = serviceTypePrice;
    }



}

