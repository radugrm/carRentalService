package com.raflo.rentalService.services;

import com.raflo.rentalService.model.Client;
import com.raflo.rentalService.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> getAllClients() {
        return null;
    }

    @Override
    public Client createClient(String firstName, String lastName, String cnp, String phoneNumber) {
        Client client = new Client(cnp, firstName, lastName, phoneNumber);
        return clientRepository.save(client);
    }

    @Override
    public void deleteClientById(Long id) {
        clientRepository.deleteById(id);
    }
}
