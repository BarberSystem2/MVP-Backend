package com.example.mvpbookingsystem.Repository;

import com.example.mvpbookingsystem.Entity.DayOff;
import com.example.mvpbookingsystem.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface DayOffRepository extends JpaRepository<DayOff, Integer> {

    boolean existsByEmployeeAndDate(Employee employee, LocalDate date);

    void deleteByEmployeeAndDate(Employee employee, LocalDate date);

    void deleteByEmployee_Id(Long employeeId);
    List<DayOff> findByEmployeeId(Long employeeId);

}
