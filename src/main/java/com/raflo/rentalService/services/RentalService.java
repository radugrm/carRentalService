package com.raflo.rentalService.services;

import com.raflo.rentalService.model.Car;
import com.raflo.rentalService.model.Client;
import com.raflo.rentalService.model.ExtraOption;
import com.raflo.rentalService.model.Rental;

import java.time.LocalDate;

public interface RentalService {
    Rental createRental(Client client, Car car, LocalDate startDate, LocalDate endDate, boolean insurance,
                        int additionalDrivers, ExtraOption... extraOptions);

    int getTotalPrice(Rental rental);
}
