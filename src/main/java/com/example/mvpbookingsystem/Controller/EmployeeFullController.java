package com.example.mvpbookingsystem.Controller;

import com.example.mvpbookingsystem.DTO.EmployeeFullDTO;
import com.example.mvpbookingsystem.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
@CrossOrigin("*")
public class EmployeeFullController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeFullDTO> getEmployee(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getFullEmployee(id));
    }

    @PostMapping("/save")
    public ResponseEntity<Void> saveEmployee(@RequestBody EmployeeFullDTO dto) {
        employeeService.saveFullEmployee(dto);
        return ResponseEntity.ok().build();
    }
}

