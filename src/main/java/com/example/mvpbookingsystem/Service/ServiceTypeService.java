package com.example.mvpbookingsystem.Service;

import com.example.mvpbookingsystem.Entity.ServiceType;
import com.example.mvpbookingsystem.Repository.ServiceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeService {
    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    public List<ServiceType> getAllServiceTypes() {
        List<>.findAll();
    }

}
