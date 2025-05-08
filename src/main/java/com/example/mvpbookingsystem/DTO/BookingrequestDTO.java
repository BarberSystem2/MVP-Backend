package com.example.mvpbookingsystem.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalTime;

public class BookingrequestDTO {

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate bookingdate;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime bookingtime;
    private String customerName;
    private Long employeeId;
    private Long salonId;
    private Long serviceTypeId;


    public BookingrequestDTO(LocalDate bookingdate, LocalTime bookingtime, String customerName, Long employeeId, Long salonId, Long serviceTypeId) {
        this.bookingdate = bookingdate;
        this.bookingtime = bookingtime;
        this.customerName = customerName;
        this.employeeId = employeeId;
        this.salonId = salonId;
        this.serviceTypeId = serviceTypeId;
    }
public String getCustomerName() {
    return customerName;
}
public void setCustomerName(String customerName) {
    this.customerName = customerName;
}
public Long getEmployeeId() {
    return employeeId;
}
public void setEmployeeId(Long employeeId) {
    this.employeeId = employeeId;
}
public Long getSalonId() {
    return salonId;
}
public void setSalonId(Long salonId) {
    this.salonId = salonId;
}
public Long getServiceTypeId() {
    return serviceTypeId;
}
public void setServiceType(Long serviceTypeId) {
    this.serviceTypeId = serviceTypeId;
}
public LocalDate getBookingdate() {
        return bookingdate;
}
public void setBookingdate(LocalDate bookingdate) {
        this.bookingdate = bookingdate;
}
public LocalTime getBookingtime() {
        return bookingtime;
}
public void setBookingtime(LocalTime bookingtime) {
        this.bookingtime = bookingtime;
}


}
