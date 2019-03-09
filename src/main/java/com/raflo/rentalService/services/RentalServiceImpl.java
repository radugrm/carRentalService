package com.raflo.rentalService.services;

import com.raflo.rentalService.model.Car;
import com.raflo.rentalService.model.Client;
import com.raflo.rentalService.model.ExtraOption;
import com.raflo.rentalService.model.Rental;
import com.raflo.rentalService.repositories.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RentalServiceImpl implements RentalService {
    @Autowired
    RentalRepository rentalRepository;

    private List<ExtraOption> addExtraOptions(ExtraOption... extraOptions){
        List<ExtraOption> extraOptionList=new ArrayList<>();
        for(ExtraOption extraOption:extraOptions){
            extraOptionList.add(extraOption);
        }
        return extraOptionList;
    }

    @Override
    public Rental createRental(Client client, Car car, int numberOfDays,ExtraOption... extraOptions) {
        Rental rental = new Rental();
        rental.setClient(client);
        rental.setCar(car);
        rental.setNumberOfDays(numberOfDays);
        rental.setExtraOptions(addExtraOptions(extraOptions));
        return rental;
    }

    @Override
    public int getTotalPrice(Rental rental) {
        return rental.getTotalPrice();
    }
}
