package com.example.mvpbookingsystem.Service;

import com.example.mvpbookingsystem.DTO.ServiceTypeList;

import com.example.mvpbookingsystem.Entity.ServiceType;
import com.example.mvpbookingsystem.Repository.ServiceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceTypeService {
    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    public List<ServiceTypeList> getAllServiceTypes() {
        List<ServiceType> serviceTypes = serviceTypeRepository.findAll();
        return serviceTypes.stream().map(ser -> new ServiceTypeList
                (ser.getServiceTypeId(), ser.getServiceTypeName(),
                        ser.getServiceTypePrice(),
                        ser.getServiceTypeEstimatedMinutes())).collect(Collectors.toList());
    }

    public List<ServiceTypeList> getServiceTypesByEmployeeId(Long employeeId) {
        List<ServiceType> serviceTypes = serviceTypeRepository.findByEmployees_Id(employeeId);
        return serviceTypes.stream().map(serviceType -> new ServiceTypeList(
                serviceType.getServiceTypeId(),
                serviceType.getServiceTypeName(),
                serviceType.getServiceTypePrice(),
                serviceType.getServiceTypeEstimatedMinutes())).collect(Collectors.toList());
    }
}
