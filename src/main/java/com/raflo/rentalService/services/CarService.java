package com.raflo.rentalService.services;

import com.raflo.rentalService.model.Car;
import com.raflo.rentalService.model.CarCategoryEnum;

import java.util.List;
import java.util.Optional;

public interface CarService {

    List<Car> getAllCars();

    Optional<List<Car>> getAvailableCarsByCategory(CarCategoryEnum carCategoryEnum);

    Car createCar(String brand, String model, CarCategoryEnum carCategory, String numberPlate);

    void deleteCarById(Long id);

    Optional<Car> getCarById(long id);

    void changeCarAvailability (long id, boolean availability);



}
