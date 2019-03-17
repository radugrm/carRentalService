package com.raflo.rentalService.controllers.dto;

import com.raflo.rentalService.model.*;
import org.springframework.format.annotation.DateTimeFormat;


import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

public class NewRentalFormDto {
    public static final String NEW_RENTAL_FORM = "rentalForm";

    private Client client;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;


    private List<CarCategoryEnum> carCategoryOptions;
    private CarCategoryEnum carCategory;
    private Car[] carsByCategory;

    private String carMake;
    private String carModel;
    private Car car;

    private boolean insurance;
    private boolean additionalDriver;
    private int additionalDrivers;

    private boolean navigation;
    private boolean toddlerSeat;
    private boolean infantSeat;

    public NewRentalFormDto() {
        this.client = new Client();
        this.carCategoryOptions = Arrays.asList(CarCategoryEnum.values());
        this.carCategory = CarCategoryEnum.ECONOMY;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setCarCategoryOptions(List<CarCategoryEnum> carCategoryOptions) {
        this.carCategoryOptions = carCategoryOptions;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public boolean isAdditionalDriver() {
        return additionalDriver;
    }

    public void setAdditionalDriver(boolean additionalDriver) {
        this.additionalDriver = additionalDriver;
    }

    public void setAdditionalDrivers(int additionalDrivers) {
        this.additionalDrivers = additionalDrivers;
    }

    public Client getClient() {
        return client;
    }

    public boolean isNavigation() {
        return navigation;
    }

    public boolean isInsurance() {
        return insurance;
    }

    public void setInsurance(boolean insurance) {
        this.insurance = insurance;
    }

    public void setNavigation(boolean navigation) {
        this.navigation = navigation;
    }

    public boolean isToddlerSeat() {
        return toddlerSeat;
    }

    public void setToddlerSeat(boolean toddlerSeat) {
        this.toddlerSeat = toddlerSeat;
    }

    public boolean isInfantSeat() {
        return infantSeat;
    }

    public void setInfantSeat(boolean infantSeat) {
        this.infantSeat = infantSeat;
    }

    public List<CarCategoryEnum> getCarCategoryOptions() {
        return carCategoryOptions;
    }

    public void setClient(Client client) {
        this.client = client;
    }


    public int getAdditionalDrivers() {

        return additionalDrivers;
    }


    public void setCarCategory(CarCategoryEnum carCategory) {
        this.carCategory = carCategory;
    }


    public CarCategoryEnum getCarCategory() {
        return carCategory;
    }

    public Car[] getCarsByCategory() {
        return carsByCategory;
    }

    public void setCarsByCategory(Car[] carsByCategory) {
        this.carsByCategory = carsByCategory;
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
