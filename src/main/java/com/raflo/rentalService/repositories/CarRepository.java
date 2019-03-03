package com.raflo.rentalService.repositories;

import com.raflo.rentalService.model.Car;
import com.raflo.rentalService.model.CarCategory;
import com.raflo.rentalService.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findAllByCarCategory(CarCategory carCategory);
}
