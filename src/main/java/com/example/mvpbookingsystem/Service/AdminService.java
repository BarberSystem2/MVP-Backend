package com.example.mvpbookingsystem.Service;


import com.example.mvpbookingsystem.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    AdminRepository aRepository;

}
