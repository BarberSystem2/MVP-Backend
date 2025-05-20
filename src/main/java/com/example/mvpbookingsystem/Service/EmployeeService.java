package com.example.mvpbookingsystem.Service;

import com.example.mvpbookingsystem.DTO.DayOffDTO;
import com.example.mvpbookingsystem.DTO.EmployeeFullDTO;
import com.example.mvpbookingsystem.DTO.EmployeeListDTO;
import com.example.mvpbookingsystem.DTO.WeeklyAvailabilityDTO;
import com.example.mvpbookingsystem.Entity.*;
import com.example.mvpbookingsystem.Repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
@Transactional
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    WeeklyAvailabiltyRepository weeklyAvailabiltyRepository;

    @Autowired
    DayOffRepository dayOffRepository;

    @Autowired
    ServiceTypeRepository serviceTypeRepository;
    @Autowired
    SalonRepository salonRepository;

    public List<EmployeeListDTO> getAllEmployeesBasicInfo() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(emp -> new EmployeeListDTO(emp.getId(), emp.getName(), emp.getNumber(), emp.getEmail(),emp.getImage()))
                .collect(Collectors.toList());
    }
    public void deleteEmployee(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new RuntimeException("Medarbejder med ID " + id + " findes ikke.");
        }
        employeeRepository.deleteById(id);
    }
    public void updateEmployee(Long id, Employee updated) {
        employeeRepository.findById(id)
                .map(employee -> {
                    employee.setName(updated.getName());
                    employee.setEmail(updated.getEmail());
                    employee.setNumber(updated.getNumber());
                    return employeeRepository.save(employee);
                })
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void saveFullEmployee(EmployeeFullDTO dto) {
        if (dto.getSalonId() == null) {
            throw new RuntimeException("Salon ID er påkrævet og blev ikke sendt.");
        }

        Employee employee = dto.getEmployeeId() != null
                ? employeeRepository.findById(dto.getEmployeeId()).orElse(new Employee())
                : new Employee();

        employee.setName(dto.getEmployeeName());
        employee.setEmail(dto.getEmployeeEmail());
        employee.setNumber(dto.getEmployeeNumber());

        // 💡 Robust hent og valider salon
        Salon salon = salonRepository.findById(dto.getSalonId())
                .orElseThrow(() -> new RuntimeException("Salon ikke fundet med id: " + dto.getSalonId()));
        employee.setSalon(salon);

        // 💡 Sæt services korrekt
        Set<ServiceType> services = new HashSet<>(serviceTypeRepository.findAllById(dto.getServiceIds()));
        employee.setServiceTypes(services);

        // 💡 Først gem employee
        employee = employeeRepository.save(employee);

        // 💡 Slet og genindsæt availability og dayoffs
        weeklyAvailabiltyRepository.deleteByEmployeeId(employee.getId());
        for (WeeklyAvailabilityDTO w : dto.getWeeklyAvailability()) {
            WeeklyAvailability availability = new WeeklyAvailability();
            availability.setEmployee(employee);
            availability.setWeekDay(w.getWeekDay());
            availability.setStartTime(w.getStartTime());
            availability.setEndTime(w.getEndTime());
            weeklyAvailabiltyRepository.save(availability);
        }

        dayOffRepository.deleteByEmployee_Id(employee.getId());
        for (DayOffDTO d : dto.getDayOffs()) {
            DayOff dayOff = new DayOff();
            dayOff.setEmployee(employee);
            dayOff.setDate(d.getDay());
            dayOffRepository.save(dayOff);
        }
    }


    public EmployeeFullDTO getFullEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Medarbejder ikke fundet"));

        List<WeeklyAvailabilityDTO> weeklyDTOs = weeklyAvailabiltyRepository.findByEmployee_Id(employeeId)
                .stream()
                .map(w -> new WeeklyAvailabilityDTO(w.getWeekDay(), w.getStartTime(), w.getEndTime()))
                .collect(Collectors.toList());

        List<DayOffDTO> dayOffs = dayOffRepository.findByEmployeeId(employeeId)
                .stream()
                .map(d -> new DayOffDTO(d.getDate())) // ✅ Brug DTO korrekt
                .collect(Collectors.toList());

        List<Long> serviceIds = Optional.ofNullable(employee.getServiceTypes())
                .orElse(Collections.emptySet())
                .stream()
                .map(ServiceType::getServiceTypeId)
                .collect(Collectors.toList());
        Long salonId = employee.getSalon().getId();

        return new EmployeeFullDTO(
                employee.getId(),
                employee.getImage(),
                employee.getName(),
                employee.getEmail(),
                employee.getNumber(),
                weeklyDTOs,
                dayOffs,
                serviceIds,
                salonId
        );
    }

}
