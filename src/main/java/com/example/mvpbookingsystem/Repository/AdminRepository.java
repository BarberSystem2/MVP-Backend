package com.example.mvpbookingsystem.Repository;

import com.example.mvpbookingsystem.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository <Admin, Long> {


    Optional<Admin> findByEmail(String email);
}
