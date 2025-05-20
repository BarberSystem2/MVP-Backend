package com.example.mvpbookingsystem.Repository;

import com.example.mvpbookingsystem.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findBookingsBySalon_IdAndDate(Long salonId, LocalDate date);

}
