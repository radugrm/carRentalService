package com.raflo.rentalService.repositories;

import com.raflo.rentalService.model.Car;
import com.raflo.rentalService.model.CarCategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    Optional<List<Car>> findAllByAvailabilityAndCarCategory(boolean availability, CarCategoryEnum carCategory);
    Car findFirstByAvailabilityAndMakeAndModel(boolean availability, String make, String model);
}
