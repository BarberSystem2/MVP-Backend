package com.example.mvpbookingsystem.Service;

import com.example.mvpbookingsystem.DTO.*;
import com.example.mvpbookingsystem.Entity.*;
import com.example.mvpbookingsystem.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private SalonRepository salonRepository;

    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    private static final Random random = new Random();

    public BookingResponseDTO createBooking(BookingrequestDTO dto) {
        Employee employee = employeeRepository.findById(dto.getEmployeeId()).orElseThrow();
        ServiceType serviceType = serviceTypeRepository.findById(dto.getServiceTypeId()).orElseThrow();
        Salon salon  = salonRepository.findById(dto.getSalonId()).orElseThrow();

        Booking booking = new Booking();
        Customer customer = new Customer();
        customer.setFirstName(dto.getCustomerName());
        customer.setLastName(dto.getCustomerName());
        customer.setEmail(dto.getCustomerEmail());
        customer.setPhone(dto.getCustomerPhoneNumber());

        customer = customerRepository.save(customer);

        booking.setCustomer(customer);
        booking.setEmployee(employee);
        booking.setServiceType(serviceType);
        booking.setDate(dto.getBookingdate());
        booking.setSalon(salon);
        booking.setStartTime(dto.getBookingtime());
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime end = dto.getBookingtime()
                .plusMinutes(serviceType.getServiceTypeEstimatedMinutes());
        booking.setEndTime(LocalTime.parse(end.format(fmt)));

        System.out.println(dto.getBookingtime().plusMinutes(serviceType.getServiceTypeEstimatedMinutes()));

        Booking saved = bookingRepository.save(booking);

        return new BookingResponseDTO(
                saved.getId(),
                saved.getCustomer().getFirstName(),
                saved.getEmployee().getName(),
                saved.getServiceType().getServiceTypeName(),
                saved.getServiceType().getServiceTypePrice(),
                saved.getServiceType().getServiceTypeEstimatedMinutes(),
                saved.getDate(),
                saved.getStartTime()
        );
    }

    public List<BookingListDTO> getAllBookings() {
        return bookingRepository.findAll().stream()
                .map(booking -> new BookingListDTO(
                        booking.getId().intValue(),
                        booking.getEmployee().getSalon().getName(),
                        booking.getDate(),
                        booking.getStartTime(),
                        booking.getCustomer().getFirstName(),
                        booking.getEmployee().getName(),
                        booking.getServiceType().getServiceTypeName(),
                        booking.getServiceType().getServiceTypePrice()
                ))
                .collect(Collectors.toList());
    }

    private String generateRandomPhoneNumber() {
        StringBuilder phone = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            phone.append(random.nextInt(10));
        }
        return phone.toString();
    }

    public List<EmployeeCalenderDayDTO> getEmployeesWithBookingsForToday(Long salonId) {
        LocalDate today = LocalDate.now();

        return employeeRepository.findBySalonId(salonId).stream()
                .map(employee -> new EmployeeCalenderDayDTO(
                        employee.getId(),
                        employee.getName(),
                        employee.getImage(),
                        employee.getBookings().stream()
                                .filter(b -> b.getDate().isEqual(today))
                                .map(this::toBookingListForDayDTO)
                                .collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }

    public List<EmployeeCalenderDayDTO> getEmployeesBookingListForTheDay(Long salonId, LocalDate date) {
        return employeeRepository.findBySalonId(salonId).stream()
                .map(employee -> new EmployeeCalenderDayDTO(
                        employee.getId(),
                        employee.getName(),
                        employee.getImage(),
                        employee.getBookings().stream()
                                .filter(b -> b.getDate().isEqual(date))
                                .map(this::toBookingListForDayDTO)
                                .collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }

    private BookingListForDayDTO toBookingListForDayDTO(Booking booking) {
        String customerFullName = booking.getCustomer().getFirstName()
                + " " + booking.getCustomer().getLastName();
        String startTime = booking.getDate()
                .atTime(booking.getStartTime()).toString();
        String endTime = booking.getDate()
                .atTime(booking.getEndTime()).toString();

        return new BookingListForDayDTO(
                booking.getId(),
                customerFullName,
                booking.getServiceType().getServiceTypeName(),
                booking.getServiceType().getServiceTypePrice(),
                startTime,
                endTime
        );
    }

}
