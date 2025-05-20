package com.example.mvpbookingsystem.DTO;

import java.util.List;

public class EmployeeCalenderDayDTO {
    private Long employeeId;
    private String employeeName;
    private String image;
    private List<BookingListForDayDTO> bookingList;
    public EmployeeCalenderDayDTO(Long employeeId, String employeeName, String image, List<BookingListForDayDTO> bookingList) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.image = image;
        this.bookingList = bookingList;
    }
    public EmployeeCalenderDayDTO() {

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
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public List<BookingListForDayDTO> getBookingList() {
        return bookingList;
    }
    public void setBookingList(List<BookingListForDayDTO> bookingList) {
        this.bookingList = bookingList;
    }

}
