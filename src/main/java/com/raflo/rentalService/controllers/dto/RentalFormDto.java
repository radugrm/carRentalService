package com.raflo.rentalService.controllers.dto;

import com.raflo.rentalService.model.Car;
import com.raflo.rentalService.model.CarCategoryEnum;


import java.util.ArrayList;
import java.util.List;

public class RentalFormDto {
    public static final String RENTAL_FORM = "rentalForm";

    private CarCategoryEnum carCategory;
    private List<Car> carsByCategory = new ArrayList<>();

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
