package com.raflo.rentalService.controllers.dto;

import com.raflo.rentalService.model.Car;
import com.raflo.rentalService.model.CarCategoryEnum;
import com.raflo.rentalService.model.Client;
import com.raflo.rentalService.model.ExtraOption;



import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

public class RentalFormDto {
    public static final String RENTAL_FORM = "rentalForm";

    private CarCategoryEnum carCategory;
    private List<Car> carsByCategory = new ArrayList<>();
    private LocalDate startDate;
    private LocalDate endDate;
    private Car car;
    private Client client;
    private List<ExtraOption> extraOptions;


    public RentalFormDto(List<Car> carsByCategory) {
        this.carsByCategory = carsByCategory;
    }

    public CarCategoryEnum getCarCategory() {
        return carCategory;
    }

    public List<Car> getCarsByCategory() {
        return carsByCategory;
    }
}
