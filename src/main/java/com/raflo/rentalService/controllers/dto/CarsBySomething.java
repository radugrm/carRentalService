package com.raflo.rentalService.controllers.dto;

import com.raflo.rentalService.model.Car;

import java.util.Collections;
import java.util.List;

public class CarsBySomething {
    private Car[] cars;
    private String[] models;


    public CarsBySomething(List<Car> carsByCategory) {
        this.cars = carsByCategory.toArray(new Car[carsByCategory.size()]);
    }

    public Car[] getCars() {
        return cars;
    }

    public void setCars(Car[] cars) {
        this.cars = cars;
    }

    public String[] getModels() {
        String[] models = new String[cars.length];
        for (int i = 0; i < cars.length ; i++) {
            models[i]=cars[i].getModel();
        }
        return models;
    }

    public void setModel(String[] models) {
        this.models = models;
    }
}



