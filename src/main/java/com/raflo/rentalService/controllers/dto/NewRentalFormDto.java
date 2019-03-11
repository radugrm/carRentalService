package com.raflo.rentalService.controllers.dto;

import com.raflo.rentalService.model.*;


import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

public class NewRentalFormDto {
    public static final String NEW_RENTAL_FORM = "rentalForm";

    private CarCategoryEnum carCategory;
    private List<Car> carsByCategory = new ArrayList<>();
    private LocalDate startDate;
    private LocalDate endDate;
    private Car car;
    private Client client;
    private boolean insurance;
    private int additionalDrivers;
    private List<ExtraOptionCategoryEnum> extraOptions;

    public boolean getInsurance() {
        return insurance;
    }

    public int getAdditionalDrivers() {
        return additionalDrivers;
    }

    public NewRentalFormDto(List<Car> carsByCategory) {
        this.carsByCategory = carsByCategory;
    }

    public CarCategoryEnum getCarCategory() {
        return carCategory;
    }

    public List<Car> getCarsByCategory() {
        return carsByCategory;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Car getCar() {
        return car;
    }

    public Client getClient() {
        return client;
    }

    public List<ExtraOptionCategoryEnum> getExtraOptions() {
        return extraOptions;
    }
}
