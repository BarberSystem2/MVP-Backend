package com.example.mvpbookingsystem.Service;

import com.example.mvpbookingsystem.DTO.BookingListDTO;
import com.example.mvpbookingsystem.DTO.BookingResponseDTO;
import com.example.mvpbookingsystem.DTO.BookingrequestDTO;
import com.example.mvpbookingsystem.Entity.*;
import com.example.mvpbookingsystem.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    SalonRepository salonRepository;

    @Autowired
    ServiceTypeRepository serviceTypeRepository;

    public BookingResponseDTO createBooking(BookingrequestDTO dto) {
        Customer customer = customerRepository.findById(dto.getCostumerId()).orElseThrow();
        Employee employee = employeeRepository.findById(dto.getEmployeeId()).orElseThrow();
        ServiceType serviceType = serviceTypeRepository.findById(dto.getServiceTypeId()).orElseThrow();
        Salon salon = salonRepository.findById(dto.getSalonId()).orElseThrow();

        Booking booking = new Booking();
        booking.setCustomer(customer);
        booking.setEmployee(employee);
        booking.setServiceType(serviceType);
        booking.setDate(dto.getBookingdate());
        booking.setStartTime(dto.getBookingtime());

        Booking saved = bookingRepository.saveAndFlush(booking);  // Save and flush

        return new BookingResponseDTO(
                saved.getId(),
                saved.getCustomer().getFirstName(),
                saved.getEmployee().getName(),
                saved.getServiceType().getServiceTypeName(),
                saved.getServiceType().getServiceTypePrice(),
                saved.getServiceType().getServiceTypeEstimatedMinutes(),
                saved.getDate(),  // Use getDate() instead of getDate()
                saved.getStartTime()
        );
    }
    public List<BookingListDTO> getAllBookings() {
        return bookingRepository.findAll().stream().map(booking -> new BookingListDTO(
                booking.getId().intValue(),
                booking.getEmployee().getSalon().getName(), // Assuming employee has a salon
                booking.getDate(),
                booking.getStartTime(),
                booking.getCustomer().getFirstName(), // Assuming there's a method or getFirstName + getLastName
                booking.getEmployee().getName(), // Same here
                booking.getServiceType().getServiceTypeName(),
                booking.getServiceType().getServiceTypePrice()
        )).collect(Collectors.toList());
    }




}
