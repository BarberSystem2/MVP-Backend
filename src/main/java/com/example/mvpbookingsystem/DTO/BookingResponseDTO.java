package com.example.mvpbookingsystem.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class BookingResponseDTO {

    private Long bookingId;
    private String costumerName;
    private String employerName;
    private String serviceName;
    private int servicePrice;
    private int serviceEstimatedTime;
    private LocalDate bookingDate;
    private LocalTime bookingTimeStart;


    public BookingResponseDTO() {}
    public BookingResponseDTO(
            Long bookingId,
            String costumerName,
            String employerName,
            String serviceName,
            int servicePrice,
            int serviceEstimatedTime,
            LocalDate bookingDate,  // Skiftet til LocalDate
            LocalTime bookingTimeStart) { // Intet ændres her
        this.bookingId = bookingId;
        this.costumerName = costumerName;
        this.employerName = employerName;
        this.serviceName = serviceName;
        this.servicePrice = servicePrice;
        this.serviceEstimatedTime = serviceEstimatedTime;
        this.bookingDate = bookingDate;
        this.bookingTimeStart = bookingTimeStart;
    }
    public Long getBookingId() {
        return bookingId;
    }
    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }
    public String getCostumerName() {
        return costumerName;
    }
    public void setCostumerName(String costumerName) {
        this.costumerName = costumerName;
    }
    public String getEmployerName() {
        return employerName;
    }
    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }
    public String getServiceName() {
        return serviceName;
    }
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
    public int getServicePrice() {
        return servicePrice;
    }
    public void setServicePrice(int servicePrice) {
        this.servicePrice = servicePrice;
    }
    public int getServiceEstimatedTime() {
        return serviceEstimatedTime;
    }
    public void setServiceEstimatedTime(int serviceEstimatedTime) {
        this.serviceEstimatedTime = serviceEstimatedTime;
    }
    public LocalDate getBookingDate() {
        return bookingDate;
    }
    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }
    public LocalTime getBookingTimeStart() {
        return bookingTimeStart;
    }
    public void setBookingTimeStart(LocalTime bookingTimeStart) {
        this.bookingTimeStart = bookingTimeStart;
    }
}
