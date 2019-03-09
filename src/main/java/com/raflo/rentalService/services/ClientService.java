package com.raflo.rentalService.services;

import com.raflo.rentalService.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    List<Client> getAllClients();

    Client createClient(String firstName, String lastName, String cnp, String phoneNumber);

    void deleteClientById(Long id);

    Optional<Client> findByCnp(String cnp);
}

