package com.raflo.rentalService.repositories;

import com.raflo.rentalService.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Long> {

}
