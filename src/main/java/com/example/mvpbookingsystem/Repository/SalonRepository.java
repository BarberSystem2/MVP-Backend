package com.example.mvpbookingsystem.Repository;

import com.example.mvpbookingsystem.Entity.Salon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalonRepository extends JpaRepository<Salon, Long> {
}
