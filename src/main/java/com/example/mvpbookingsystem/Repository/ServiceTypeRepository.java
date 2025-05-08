package com.example.mvpbookingsystem.Repository;

import com.example.mvpbookingsystem.Entity.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ServiceTypeRepository extends JpaRepository<ServiceType, Long> {

}
