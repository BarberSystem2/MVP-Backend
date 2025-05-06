package com.example.mvpbookingsystem.Service;

import com.example.mvpbookingsystem.DTO.EmployeeListDTO;
import com.example.mvpbookingsystem.Entity.Employee;
import com.example.mvpbookingsystem.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public List<EmployeeListDTO> getAllEmployeesBasicInfo() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(emp -> new EmployeeListDTO(emp.getId(), emp.getName()))
                .collect(Collectors.toList());
    }
}
