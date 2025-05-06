package com.example.mvpbookingsystem.Controller;

import com.example.mvpbookingsystem.DTO.ServiceTypeList;
import com.example.mvpbookingsystem.Service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/serviceType")
@CrossOrigin(origins = "*")
public class ServiceTypeController {

    @Autowired
    private ServiceTypeService serviceTypeService;

    @GetMapping("/getAll")
    public List<ServiceTypeList> getAllServiceType(){
       return serviceTypeService.getAllServiceTypes();
    }
}
