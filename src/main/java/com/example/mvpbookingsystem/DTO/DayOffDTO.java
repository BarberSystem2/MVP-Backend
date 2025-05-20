package com.example.mvpbookingsystem.DTO;

import java.time.LocalDate;

public class DayOffDTO {
    private LocalDate day;

    public DayOffDTO(LocalDate day) {
        this.day = day;
    }
    public LocalDate getDay() {
        return day;
    }
    public void setDay(LocalDate day) {
        this.day = day;
    }

}
