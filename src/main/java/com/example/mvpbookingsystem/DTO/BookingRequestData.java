package com.example.mvpbookingsystem.DTO;

import com.example.mvpbookingsystem.Entity.Booking;
import com.example.mvpbookingsystem.Entity.Employee;

import java.util.List;
import java.util.Set;

public class BookingRequestData {

    private Long salonId;
    private List<EmployeeFullDTO> employees;
    private Set<Booking> bookings;
}