package com.raflo.rentalService.controllers.dto;

import com.raflo.rentalService.model.*;


import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

public class NewRentalFormDto {
    public static final String NEW_RENTAL_FORM = "rentalForm";

    private Client client;
    private CarCategoryEnum carCategory;
    private List<Car> carsByCategory = new ArrayList<>();
    private LocalDate startDate;
    private LocalDate endDate;
    private String carMake;
    private String carModel;
    private boolean insurance;
    private boolean navigation;
    private boolean toddlerSeat;
    private boolean infantSeat;
    private boolean additionalDriver;
    private int additionalDrivers;
    private List<ExtraOptionCategoryEnum> extraOptions;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public boolean getInsurance() {
        return insurance;
    }

    public int getAdditionalDrivers() {
        if (!additionalDriver) return 0;
        else
            return additionalDrivers;
    }

    public NewRentalFormDto(Client client, List<Car> carsByCategory) {
        this.client=client;
        this.carsByCategory = carsByCategory;
    }

    public CarCategoryEnum getCarCategory() {
        return carCategory;
    }

    public List<Car> getCarsByCategory() {
        return carsByCategory;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getCarMake() {
        return carMake;
    }

    public String getCarModel() {
        return carModel;
    }


    public boolean getToddlerSeat() {
        return toddlerSeat;
    }

    public boolean getInfantSeat() {
        return infantSeat;
    }

    public boolean getAdditionalDriver() {
        return additionalDriver;
    }

    public boolean getNavigation() {
        return navigation;
    }

    public List<ExtraOptionCategoryEnum> getExtraOptions() {
        List<ExtraOptionCategoryEnum> extraOptions = null;
        if (toddlerSeat || navigation || infantSeat) {
            extraOptions = new ArrayList<>();
        }
        if (toddlerSeat) extraOptions.add(ExtraOptionCategoryEnum.TODDLER_SEAT);
        if (infantSeat) extraOptions.add(ExtraOptionCategoryEnum.INFANT_SEAT);
        if (navigation) extraOptions.add(ExtraOptionCategoryEnum.NAVIGATION);
        return extraOptions;
    }
}
