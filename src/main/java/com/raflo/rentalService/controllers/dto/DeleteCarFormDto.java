package com.raflo.rentalService.controllers.dto;

public class DeleteCarFormDto {
    public static final String DELETE_CAR_FORM = "deleteCarForm";

    private Long id;

    public Long getCarId() {
        return id;
    }

    public void setCarId(Long id) {
        this.id = id;
    }
}
