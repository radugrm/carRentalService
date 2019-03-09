package com.raflo.rentalService.services;

import com.raflo.rentalService.model.Car;
import com.raflo.rentalService.model.Client;
import com.raflo.rentalService.model.ExtraOption;
import com.raflo.rentalService.model.Rental;

public interface RentalService {
    Rental createRental(Client client, Car car, int numberOfDays, ExtraOption... extraOptions);
    int getTotalPrice(Rental rental);
}
