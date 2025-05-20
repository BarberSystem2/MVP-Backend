package com.example.mvpbookingsystem.DataLoader;

import com.example.mvpbookingsystem.Entity.*;
import com.example.mvpbookingsystem.Repository.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@Component
public class DataLoader {

    @Autowired
    private SalonRepository salonRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    @Autowired
    private WeeklyAvailabiltyRepository weeklyAvailabiltyRepository;

    @Autowired
    private DayOffRepository dayOffRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    AdminRepository adminRepository;

    @PostConstruct
    public void loadData() {
        // Opret Salon
        Admin admin = new Admin("Hans","Test@gmail.com",13456789,"Konto2500!");
        adminRepository.save(admin);

        Salon salon = new Salon("Luxury Salon", "Testgade 123", "12345678", admin);
        salonRepository.save(salon);


        // Opret Services
        ServiceType haircut = new ServiceType("Klip", "Hårklipning", 300, 30);
        ServiceType color = new ServiceType("Farve", "Hårfarvning", 500, 60);
        ServiceType styling = new ServiceType("Styling", "Hårstyling", 250, 20);
        ServiceType highlights = new ServiceType("Striber", "Highlights", 600, 90);
        serviceTypeRepository.saveAll(List.of(haircut, color, styling, highlights));

        // Opret Employees
        Employee emma = new Employee("Emma Hansen", "emma@test.dk", "12345678", "https://images.unsplash.com/photo-1438761681033-6461ffad8d80?fm=jpg&q=60&w=3000&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8cGVyc29ufGVufDB8fDB8fHww",  salon);
        emma.setServiceTypes(Set.of(haircut, color, styling));
        employeeRepository.save(emma);

        Employee jonas = new Employee("Jonas Nielsen", "jonas@test.dk", "87654321", "https://img.freepik.com/free-photo/young-bearded-man-with-striped-shirt_273609-5677.jpg?semt=ais_hybrid&w=740", salon);
        jonas.setServiceTypes(Set.of(haircut, styling));
        employeeRepository.save(jonas);

        Employee sofie = new Employee("Sofie Andersen", "sofie@test.dk", "45678912", "https://plus.unsplash.com/premium_photo-1689551670902-19b441a6afde?fm=jpg&q=60&w=3000&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8cmFuZG9tJTIwcGVvcGxlfGVufDB8fDB8fHww", salon);
        sofie.setServiceTypes(Set.of(color, highlights));
        employeeRepository.save(sofie);
        Customer c1 = new Customer("Anne", "Jensen", "anne@example.com", "12345678");
        Customer c2 = new Customer("Brian", "Hansen", "brian@example.com", "22345678");
        Customer c3 = new Customer("Carla", "Olsen", "carla@example.com", "32345678");
        Customer c4 = new Customer("David", "Larsen", "david@example.com", "42345678");

        customerRepository.save(c1);
        customerRepository.save(c2);
        customerRepository.save(c3);
        customerRepository.save(c4);

        LocalDate today = LocalDate.now();


        Booking b1 = new Booking(today, LocalTime.of(9, 0), LocalTime.of(9, 30), c1, sofie, haircut,salon);
        Booking b2 = new Booking(today, LocalTime.of(10, 0), LocalTime.of(10, 45), c2, jonas, color, salon);
        Booking b3 = new Booking(today, LocalTime.of(11, 30), LocalTime.of(12, 0), c3, emma, styling, salon);
        Booking b4 = new Booking(today, LocalTime.of(13, 0), LocalTime.of(13, 30), c4, jonas, highlights, salon);
        Booking b5 = new Booking(today, LocalTime.of(15, 0), LocalTime.of(16, 30), c1, sofie, styling, salon);
        Booking b6 = new Booking(today.plusDays(1), LocalTime.of(10, 0), LocalTime.of(11, 30), c1, sofie, styling, salon);
        Booking b7 = new Booking(today.plusDays(2), LocalTime.of(12, 0), LocalTime.of(13, 30), c1, sofie, styling, salon);
        Booking b8 = new Booking(today.plusDays(3), LocalTime.of(14, 0), LocalTime.of(15, 30), c1, sofie, styling, salon);
        Booking b9 = new Booking(today.plusDays(4), LocalTime.of(16, 0), LocalTime.of(17, 30), c1, sofie, styling, salon);
        Booking b10 = new Booking(today.plusDays(5), LocalTime.of(15, 0), LocalTime.of(16, 30), c1, sofie, styling, salon);
        bookingRepository.save(b1);
        bookingRepository.save(b2);
        bookingRepository.save(b3);
        bookingRepository.save(b4);
        bookingRepository.save(b5);
        bookingRepository.save(b6);
        bookingRepository.save(b7);
        bookingRepository.save(b8);
        bookingRepository.save(b9);
        bookingRepository.save(b10);


        // Opret WeeklyAvailability - Emma (Man-fre 9-17)
        createWeeklyAvailability(emma, 9, 17, 1, 5);

        // Opret WeeklyAvailability - Jonas (Man, Ons, Fre 10-16)
        createWeeklyAvailability(jonas, 10, 16, List.of(1, 3, 5));

        // Opret WeeklyAvailability - Sofie (Tirsdag-torsdag 11-18)
        createWeeklyAvailability(sofie, 11, 18, 2, 4);

        // Opret DayOffs
        dayOffRepository.save(new DayOff(emma, LocalDate.now().plusDays(2)));
        dayOffRepository.save(new DayOff(jonas, LocalDate.now().plusDays(5)));
        dayOffRepository.save(new DayOff(sofie, LocalDate.now().plusDays(1)));

        System.out.println("✅ Flere medarbejdere og services indlæst");
    }

    private void createWeeklyAvailability(Employee employee, int startHour, int endHour, int startDay, int endDay) {
        for (int day = startDay; day <= endDay; day++) {
            WeeklyAvailability availability = new WeeklyAvailability();
            availability.setEmployee(employee);
            availability.setWeekDay(day);
            availability.setStartTime(LocalTime.of(startHour, 0));
            availability.setEndTime(LocalTime.of(endHour, 0));
            weeklyAvailabiltyRepository.save(availability);
        }
    }

    private void createWeeklyAvailability(Employee employee, int startHour, int endHour, List<Integer> days) {
        for (int day : days) {
            WeeklyAvailability availability = new WeeklyAvailability();
            availability.setEmployee(employee);
            availability.setWeekDay(day);
            availability.setStartTime(LocalTime.of(startHour, 0));
            availability.setEndTime(LocalTime.of(endHour, 0));
            weeklyAvailabiltyRepository.save(availability);
        }
    }
}
