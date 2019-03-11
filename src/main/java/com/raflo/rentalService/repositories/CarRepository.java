package com.raflo.rentalService.repositories;

import com.raflo.rentalService.model.Car;
import com.raflo.rentalService.model.CarCategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findAllByCarCategory(CarCategoryEnum carCategory);
    Car findFirstByAvailabilityAndMakeAndModel(boolean availability, String make, String model);
}
