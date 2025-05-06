package com.example.mvpbookingsystem.Controller;


import com.example.mvpbookingsystem.DTO.EmployeeListDTO;
import com.example.mvpbookingsystem.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
@CrossOrigin("*")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/allEmployees")
    public List<EmployeeListDTO> getEmployeeList(){
       return employeeService.getAllEmployeesBasicInfo();
    }
}
