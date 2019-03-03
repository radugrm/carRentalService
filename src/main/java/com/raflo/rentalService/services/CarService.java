package com.raflo.rentalService.services;

import com.raflo.rentalService.model.Car;
import com.raflo.rentalService.model.CarCategory;

import java.util.List;

public interface CarService {

    List<Car> getAllCars();

    Car createCar(String brand, String model, CarCategory carCategory, String numberPlate);

    void deleteCarById(Long id);
}
