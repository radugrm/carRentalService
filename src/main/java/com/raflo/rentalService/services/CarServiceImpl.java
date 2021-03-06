package com.raflo.rentalService.services;

import com.raflo.rentalService.model.Car;
import com.raflo.rentalService.model.CarCategoryEnum;
import com.raflo.rentalService.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Car createCar(String make, String model, CarCategoryEnum carCategory, String numberPlate) {
        Car car = new Car();
        car.setMake(make);
        car.setModel(model);
        car.setCarCategory(carCategory);
        car.setNumberPlate(numberPlate);
        car.setAvailability(true);

        return carRepository.save(car);
    }

    @Override
    public void changeCarAvailability(long id, boolean availability) {
        if(carRepository.findById(id).isPresent()) {
            Car car = carRepository.findById(id).get();
            car.setAvailability(availability);
            carRepository.save(car);
        }
    }

    @Override
    public void deleteCarById(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public Optional<List<Car>> getAvailableCarsByCategory(CarCategoryEnum carCategoryEnum) {
        return carRepository.findAllByAvailabilityAndCarCategory(true,carCategoryEnum);
    }

    @Override
    public Optional<Car> getCarById(long id) {
        return carRepository.findById(id);
    }


}
