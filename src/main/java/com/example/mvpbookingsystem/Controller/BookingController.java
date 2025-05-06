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
        return ResponseEntity.ok(bookingService.createBooking(dto));
    }
    @GetMapping("/getbookings")
    public List<BookingListDTO> getAllBookings() {
        return bookingService.getAllBookings();
    }

}
