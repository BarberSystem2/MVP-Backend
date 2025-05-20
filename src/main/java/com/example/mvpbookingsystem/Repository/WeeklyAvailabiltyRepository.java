package com.example.mvpbookingsystem.Repository;

import com.example.mvpbookingsystem.DTO.WeeklyAvailabilityDTO;
import com.example.mvpbookingsystem.Entity.Employee;
import com.example.mvpbookingsystem.Entity.WeeklyAvailability;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface WeeklyAvailabiltyRepository extends JpaRepository<WeeklyAvailability, Long> {

    WeeklyAvailability findByEmployeeAndWeekDay(Employee employee, int weekDay);

    void deleteByEmployee(Employee employee);

    List<WeeklyAvailability> findByEmployee_Id(Long employeeId);


    void deleteByEmployeeId(long employeeId);
}
