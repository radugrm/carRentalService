package com.raflo.rentalService.services;

import com.raflo.rentalService.model.Car;
import com.raflo.rentalService.model.Client;
import com.raflo.rentalService.model.ExtraOption;
import com.raflo.rentalService.model.Rental;
import com.raflo.rentalService.repositories.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

@Service
public class RentalServiceImpl implements RentalService {
    @Autowired
    RentalRepository rentalRepository;

    @Override
    public Rental createRental(Client client, Car car, LocalDate startDate, LocalDate endDate, boolean insurance,
                               int additionalDrivers, Set<ExtraOption> extraOptions) {
        Rental rental = new Rental();
        int price = 0;
        rental.setClient(client);
        rental.setCar(car);
        rental.setStartDate(startDate);
        rental.setEndDate(endDate);
        rental.setInsurance(insurance);
        rental.setAdditionalDriver(additionalDrivers);
        rental.setExtraOptions(extraOptions);

        price += car.getPrice();
        if(insurance){
            price +=10;
        }
        if(additionalDrivers>0){
            price+= additionalDrivers*8;
        }

        for(ExtraOption e:rental.getExtraOptions()){
            price += e.getPrice();
        }
        Period period = Period.between(startDate,endDate.plusDays(1));
        int days = period.getDays();
        price = price*days;
        rental.setTotalPrice(price);
        return rental;
    }


    @Override
    public int getTotalPrice(Rental rental) {
        return rental.getTotalPrice();
    }
}
