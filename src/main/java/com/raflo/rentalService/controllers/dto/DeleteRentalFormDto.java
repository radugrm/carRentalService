package com.raflo.rentalService.controllers.dto;

public class DeleteRentalFormDto {
    public final static String DELETE_RENTAL_FORM = "deleteRental";

    private long rentalId;

    public long getRentalId() {
        return rentalId;
    }

    public void setRentalId(long rentalId) {
        this.rentalId = rentalId;
    }
}
