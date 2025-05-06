package com.example.mvpbookingsystem.DataLoader;


import com.example.mvpbookingsystem.Entity.*;
import com.example.mvpbookingsystem.Repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class DataLoader implements CommandLineRunner {

    private final SalonRepository salonRepository;
    private final EmployeeRepository employeeRepository;
    private final CustomerRepository customerRepository;
    private final ServiceTypeRepository serviceTypeRepository;
    private final BookingRepository bookingRepository;

    public DataLoader(SalonRepository salonRepository,
                      EmployeeRepository employeeRepository,
                      CustomerRepository customerRepository,
                      ServiceTypeRepository serviceTypeRepository,
                      BookingRepository bookingRepository) {
        this.salonRepository = salonRepository;
        this.employeeRepository = employeeRepository;
        this.customerRepository = customerRepository;
        this.serviceTypeRepository = serviceTypeRepository;
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Salon
        Salon salon = new Salon("Beauty Bliss", "Main Street 123", "12345678");
        salonRepository.save(salon);

        // Employee
        Employee employee = new Employee("Laura Jensen", "laura@salon.dk", "88889999", salon);
        employeeRepository.save(employee);

        // Customer
        Customer customer = new Customer("Mikkel", "Andersen", "mikkel@gmail.com", "22223333");
        customerRepository.save(customer);

        // Service Type
        ServiceType serviceType = new ServiceType("Hårklip", "En simpel herreklip", 300, 30);
        serviceTypeRepository.save(serviceType);

        // Booking
        Booking booking = new Booking(
                LocalDate.now().plusDays(1),
                LocalTime.of(10, 0),
                LocalTime.of(10, 30),
                customer,
                employee,
                serviceType
        );
        bookingRepository.save(booking);
    }
}

