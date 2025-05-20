package com.example.mvpbookingsystem.DTO;

import java.time.LocalDateTime;

public class BookingListForDayDTO {
    private long bookingId;
    private String costumerName;
    private String serviceName;
    private int servicePrice;
    private String startTime;
    private String endTime;
    public BookingListForDayDTO() {}
   public BookingListForDayDTO(Long bookingId, String costumerName, String serviceName, int servicePrice, String startTime, String endTime) {
        this.bookingId = bookingId;
        this.costumerName = costumerName;
        this.serviceName = serviceName;
        this.servicePrice = servicePrice;
        this.startTime = startTime;
        this.endTime = endTime;
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
    public String getStartTime() {
        return startTime;
    }
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    public String getEndTime() {
        return endTime;
    }
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

}
