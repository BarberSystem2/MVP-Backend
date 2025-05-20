package com.example.mvpbookingsystem.DTO;

public class EmployeeListDTO {
    private Long employeeId;
    private String employeeName;
    private String employeeNumber;
    private String employeeEmail;
    private String employeeImage;


    public EmployeeListDTO(Long employeeId, String employeeName, String employeeNumber, String employeeEmail, String employeeImage) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeNumber = employeeNumber;
        this.employeeEmail = employeeEmail;
        this.employeeImage = employeeImage;

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
    public String getEmployeeNumber() {
        return employeeNumber;
    }
    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }
    public String getEmployeeEmail() {
        return employeeEmail;
    }
    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }
    public String getEmployeeImage() {
        return employeeImage;
    }
    public void setEmployeeImage(String employeeImage) {
        this.employeeImage = employeeImage;
    }

}
