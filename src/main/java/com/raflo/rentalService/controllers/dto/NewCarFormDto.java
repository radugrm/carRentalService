package com.raflo.rentalService.controllers.dto;

import com.raflo.rentalService.model.CarCategoryEnum;

public class NewCarFormDto {
    public static final String NEW_CAR_FORM = "newCarForm";

    private String make;
    private String model;
    private String numberPlate;
    private CarCategoryEnum carCategory;

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public CarCategoryEnum getCarCategory() {
        return carCategory;
    }

    public void setCarCategory(CarCategoryEnum carCategory) {
        this.carCategory = carCategory;
    }
}
