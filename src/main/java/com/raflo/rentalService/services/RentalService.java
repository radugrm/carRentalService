package com.raflo.rentalService.services;

import com.raflo.rentalService.model.Car;
import com.raflo.rentalService.model.Client;
import com.raflo.rentalService.model.ExtraOption;
import com.raflo.rentalService.model.Rental;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface RentalService {
    Rental createRental(Client client, Car car, LocalDate startDate, LocalDate endDate, boolean insurance,
                        int additionalDrivers, Set<ExtraOption> extraOptions);

    int getTotalPrice(Rental rental);

    List<Rental> getAllRental();

    void deleteRentalById(long id);
}
