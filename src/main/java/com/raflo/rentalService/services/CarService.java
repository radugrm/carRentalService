package com.raflo.rentalService.services;

import com.raflo.rentalService.model.Car;
import com.raflo.rentalService.model.CarCategoryEnum;

import java.util.List;

public interface CarService {

    List<Car> getAllCars();

    List<Car> getCarsByCategory(CarCategoryEnum carCategoryEnum);

    Car createCar(String brand, String model, CarCategoryEnum carCategory, String numberPlate);

    void deleteCarById(Long id);
}
