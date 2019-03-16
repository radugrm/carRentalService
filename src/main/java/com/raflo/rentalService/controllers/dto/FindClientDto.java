package com.raflo.rentalService.controllers.dto;

import com.raflo.rentalService.model.Client;

public class FindClientDto {
    public static final String FIND_CLIENT_FORM = "findClient";

    private String cnp;
    private String firstName;
    private String lastName;
    private Client client;

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
