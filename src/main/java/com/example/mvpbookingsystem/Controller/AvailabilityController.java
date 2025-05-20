package com.example.mvpbookingsystem.Controller;

import com.example.mvpbookingsystem.DTO.DailyAvailabilityDTO;
import com.example.mvpbookingsystem.DTO.DayOffDTO;
import com.example.mvpbookingsystem.DTO.WeeklyAvailabilityDTO;
import com.example.mvpbookingsystem.Service.AvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class AvailabilityController {
    @Autowired
    AvailabilityService availabilityService;

    @GetMapping("/salon/{salonId}")
    public List<DailyAvailabilityDTO> getAvailability(@PathVariable Long salonId, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return availabilityService.getDailyAvailability(salonId,date);
    }

    @PostMapping("/updateweek/{employeeId}")
    public ResponseEntity<?> updateWeekly(@PathVariable Long employeeId, @RequestBody List<WeeklyAvailabilityDTO> availability) {
        availabilityService.updateWeeklyAvailability(employeeId,availability);
        return ResponseEntity.ok("Opdateret for ugen");
    }

    @PostMapping("/addDayOff/{employeeId}")
    public ResponseEntity <?> addDayOff(@PathVariable Long employeeId, @RequestBody DayOffDTO dayOffDTO){
        availabilityService.addDayOff(employeeId, dayOffDTO.getDay());
        return ResponseEntity.ok("Day Off Added");
    }
    @DeleteMapping("/deleteDayOff/{employeeId}")
    public ResponseEntity<?> deleteDayOff(@PathVariable Long employeeId, @RequestBody DayOffDTO dayOffDTO){
        availabilityService.removeDayOff(employeeId, dayOffDTO.getDay());
        return ResponseEntity.ok("Day Off Deleted");
    }
}
