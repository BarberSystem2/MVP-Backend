package com.example.mvpbookingsystem.Repository;

import com.example.mvpbookingsystem.Entity.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface ServiceTypeRepository extends JpaRepository<ServiceType, Long> {
    List<ServiceType> findByEmployees_Id(Long employeeId);


}
