package com.example.mvpbookingsystem.Controller;

import com.example.mvpbookingsystem.DTO.BookingListDTO;
import com.example.mvpbookingsystem.DTO.BookingResponseDTO;
import com.example.mvpbookingsystem.DTO.BookingrequestDTO;
import com.example.mvpbookingsystem.Entity.Booking;
import com.example.mvpbookingsystem.Service.BookingService;
import org.hibernate.annotations.AnyKeyJavaClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
@CrossOrigin(origins = "*")
public class BookingController {

    @Autowired
    private BookingService bookingService;


    @PostMapping("/create")
    public ResponseEntity<BookingResponseDTO> createBooking(@RequestBody BookingrequestDTO dto) {
        System.out.println("Modtaget DTO:");
        System.out.println("customerName: " + dto.getCustomerName());
        System.out.println("bookingDate: " + dto.getBookingdate());
        System.out.println("bookingTime: " + dto.getBookingtime());
        System.out.println("employeeId: " + dto.getEmployeeId());
        System.out.println("salonId: " + dto.getSalonId());
        System.out.println("serviceTypeId: " + dto.getServiceTypeId());
        return ResponseEntity.ok(bookingService.createBooking(dto));
    }
    @GetMapping("/getbookings")
    public List<BookingListDTO> getAllBookings() {
        return bookingService.getAllBookings();
    }

}
