package com.raflo.rentalService.controllers.dto;

import com.raflo.rentalService.model.Client;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class DateFormDto {
    public static final String DATE_FORM_DTO = "dateForm";

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate startDate;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate endDate;

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
