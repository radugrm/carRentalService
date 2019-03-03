package com.raflo.rentalService.services;

import com.raflo.rentalService.model.Client;

import java.util.List;

public interface ClientService {

    List<Client> getAllClients();

    Client createClient(String firstName, String lastName, String cnp, String phoneNumber);

    void deleteClientById(Long id);
}

