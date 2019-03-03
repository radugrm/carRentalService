package com.raflo.rentalService.controllers.dto;

public class DeleteClientFormDto {
    public static final String DELETE_CLIENT_FORM = "deleteClientForm";

    private Long id;

    public Long getClientId() {
        return id;
    }

    public void setClientId(Long id) {
        this.id = id;
    }
}
