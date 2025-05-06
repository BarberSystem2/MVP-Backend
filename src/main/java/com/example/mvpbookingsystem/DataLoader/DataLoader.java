package com.example.mvpbookingsystem.DataLoader;


import com.example.mvpbookingsystem.Entity.*;
import com.example.mvpbookingsystem.Repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    private final SalonRepository salonRepository;
    private final EmployeeRepository employeeRepository;
    private final CustomerRepository customerRepository;
    private final ServiceTypeRepository serviceTypeRepository;
    private final BookingRepository bookingRepository;

    public DataLoader(SalonRepository salonRepository,
                      EmployeeRepository employeeRepository,
                      CustomerRepository customerRepository,
                      ServiceTypeRepository serviceTypeRepository,
                      BookingRepository bookingRepository) {
        this.salonRepository = salonRepository;
        this.employeeRepository = employeeRepository;
        this.customerRepository = customerRepository;
        this.serviceTypeRepository = serviceTypeRepository;
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void run(String... args) {
        // 1 Salon
        Salon salon = new Salon("Skønhedshjørnet", "Hovedgade 1, 1234 København", "12345678");
        salonRepository.save(salon);

        // 5 Employees
        Employee[] employees = new Employee[]{
                new Employee("Anna Madsen", "anna@salon.dk", "11111111", salon),
                new Employee("Jonas Hansen", "jonas@salon.dk", "22222222", salon),
                new Employee("Maria Sørensen", "maria@salon.dk", "33333333", salon),
                new Employee("Peter Jensen", "peter@salon.dk", "44444444", salon),
                new Employee("Louise Larsen", "louise@salon.dk", "55555555", salon)
        };
        employeeRepository.saveAll(Arrays.asList(employees));

        // 5 Customers
        Customer[] customers = new Customer[]{
                new Customer("Emil", "Kristensen", "emil@gmail.com", "88888888"),
                new Customer("Freja", "Olsen", "freja@gmail.com", "77777777"),
                new Customer("Noah", "Andersen", "noah@gmail.com", "66666666"),
                new Customer("Ida", "Poulsen", "ida@gmail.com", "55554444"),
                new Customer("William", "Thomsen", "william@gmail.com", "44443333")
        };
        customerRepository.saveAll(Arrays.asList(customers));

        // 5 ServiceTypes
        ServiceType[] services = new ServiceType[]{
                new ServiceType("Hårklip", "Klassisk klipning", 300, 30),
                new ServiceType("Farvning", "Hårfarve inkl. vask", 600, 60),
                new ServiceType("Skægtrim", "Trim og form af skæg", 200, 20),
                new ServiceType("Permanent", "Krøller der holder", 800, 90),
                new ServiceType("Styling", "Professionel styling", 250, 25)
        };
        serviceTypeRepository.saveAll(Arrays.asList(services));

        // 10 Bookings (kombinerer forskelligt)
        for (int i = 0; i < 10; i++) {
            Booking booking = new Booking(
                    LocalDate.now().plusDays(i + 1),
                    LocalTime.of(9 + (i % 5), 0),
                    LocalTime.of(9 + (i % 5), 30),
                    customers[i % customers.length],
                    employees[i % employees.length],
                    services[i % services.length]
            );
            bookingRepository.save(booking);
        }
    }
}

