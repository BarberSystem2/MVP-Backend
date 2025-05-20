package com.example.mvpbookingsystem.Service;

import com.example.mvpbookingsystem.DTO.DailyAvailabilityDTO;
import com.example.mvpbookingsystem.DTO.WeeklyAvailabilityDTO;
import com.example.mvpbookingsystem.Entity.DayOff;
import com.example.mvpbookingsystem.Entity.Employee;
import com.example.mvpbookingsystem.Entity.WeeklyAvailability;
import com.example.mvpbookingsystem.Repository.DayOffRepository;
import com.example.mvpbookingsystem.Repository.EmployeeRepository;
import com.example.mvpbookingsystem.Repository.WeeklyAvailabiltyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AvailabilityService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    WeeklyAvailabiltyRepository availabiltyRepository;

    @Autowired
    DayOffRepository dayOffRepository;

    public List<DailyAvailabilityDTO> getDailyAvailability(Long salonId, LocalDate date) {
        List<Employee> employees = employeeRepository.findBySalonId(salonId);
        List<DailyAvailabilityDTO> result = new ArrayList<>();

        int weekday = date.getDayOfWeek().getValue() % 7;

        for (Employee employee : employees) {
            boolean isDayOff = dayOffRepository.existsByEmployeeAndDate(employee,date);

            if (isDayOff) {
                result.add(new DailyAvailabilityDTO(
                        employee.getId(),
                        employee.getName(),
                        employee.getImage(),
                        false,
                        null,
                        null
                ));
                continue;
            }
            WeeklyAvailability wa = availabiltyRepository.findByEmployeeAndWeekDay(employee, weekday);
            if (wa != null){
                result.add(new DailyAvailabilityDTO(
                        employee.getId(),
                        employee.getName(),
                        employee.getImage(),
                        true,
                        wa.getStartTime(),
                        wa.getEndTime()
                ));
            } else {
                result.add(new DailyAvailabilityDTO(
                        employee.getId(),
                        employee.getName(),
                        employee.getImage(),
                        false,
                        null,
                        null
                ));
            }
        } return result;
    }

    public void updateWeeklyAvailability(Long employeeId, List<WeeklyAvailabilityDTO> weeklydtos) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new RuntimeException("Employee not found"));

        availabiltyRepository.deleteByEmployee(employee);

        for (WeeklyAvailabilityDTO dto : weeklydtos) {
            WeeklyAvailability wa = new WeeklyAvailability();
            wa.setEmployee(employee);
            wa.setWeekDay(dto.getWeekDay());
            wa.setStartTime(dto.getStartTime());
            wa.setEndTime(dto.getEndTime());
            availabiltyRepository.save(wa);
        }
    }
    public void addDayOff(Long employeeId, LocalDate date) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new RuntimeException("Employee not found"));

        if(!dayOffRepository.existsByEmployeeAndDate(employee,date)){
            DayOff dayOff = new DayOff();
            dayOff.setEmployee(employee);
            dayOff.setDate(date);
            dayOffRepository.save(dayOff);
        }
    }
    public void removeDayOff(Long employeeId, LocalDate date) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new RuntimeException("Employee not found"));
        dayOffRepository.deleteByEmployeeAndDate(employee, date);
    }
    public List<WeeklyAvailability> getWeeklyAvailability(Long employeeId) {
         return availabiltyRepository.findByEmployee_Id(employeeId);
    }
}
