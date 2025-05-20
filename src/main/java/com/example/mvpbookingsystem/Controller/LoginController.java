package com.example.mvpbookingsystem.Controller;


import com.example.mvpbookingsystem.Entity.Admin;
import com.example.mvpbookingsystem.Repository.AdminRepository;
import com.example.mvpbookingsystem.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    private AdminService adminService;

    @Autowired
    AdminRepository adminRepository;



    @PostMapping("/login")
    public ResponseEntity<?> login (@RequestBody Map<String, String> body) {
        String email = body.get("email");
        String password = body.get("password");

        Optional<Admin> adminOptional = adminRepository.findByEmail(email);
            if (adminOptional.isEmpty() || !adminOptional.get().getPassword().equals(password)) {
                return ResponseEntity.status(401).body("Invalid email or password");

            }
            return ResponseEntity.ok(Map.of("message", "Welcome " + email));
    }
}
