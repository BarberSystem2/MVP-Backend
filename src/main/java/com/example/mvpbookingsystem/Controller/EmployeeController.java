package com.example.mvpbookingsystem.Controller;


import com.example.mvpbookingsystem.DTO.EmployeeListDTO;
import com.example.mvpbookingsystem.Entity.Employee;
import com.example.mvpbookingsystem.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@CrossOrigin("*")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/allEmployees")
    public List<EmployeeListDTO> getEmployeeList() {
        return employeeService.getAllEmployeesBasicInfo();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteEmployee(@RequestBody Employee employee) {
        if (employee != null && employee.getId() != null) {
            employeeService.deleteEmployee(employee.getId()); // Kald service til at slette
            return ResponseEntity.noContent().build(); // Returner HTTP 204 No Content, ingen data at returnere
        } else {
            return ResponseEntity.badRequest().build(); // Returner HTTP 400 Bad Request, hvis ID ikke er til stede
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateEmployee(@RequestBody Employee employee) {
        if (employee != null && employee.getId() != null) {
            employeeService.updateEmployee(employee.getId(), employee);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> addEmployee(@RequestBody Employee employee) {
        if (employee != null && employee.getId() != null) {
            employeeService.addEmployee(employee);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
