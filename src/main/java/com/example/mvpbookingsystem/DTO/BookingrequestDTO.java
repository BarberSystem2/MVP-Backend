package com.example.mvpbookingsystem.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

public class BookingrequestDTO {

    private LocalDate bookingdate;
    private LocalTime bookingtime;
    private Long costumerId;
    private Long employeeId;
    private Long salonId;
    private Long serviceTypeId;


    public BookingrequestDTO(LocalDate bookingdate, LocalTime bookingtime, Long costumerId, Long employeeId, Long salonId, Long serviceTypeId) {
        this.bookingdate = bookingdate;
        this.bookingtime = bookingtime;
        this.costumerId = costumerId;
        this.employeeId = employeeId;
        this.salonId = salonId;
        this.serviceTypeId = serviceTypeId;
    }
public Long getCostumerId() {
    return costumerId;
}
public void setCostumerId(Long costumerId) {
    this.costumerId = costumerId;
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
