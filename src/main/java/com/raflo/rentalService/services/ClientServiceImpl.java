package com.raflo.rentalService.services;

import com.raflo.rentalService.model.Client;
import com.raflo.rentalService.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client createClient(String firstName, String lastName, String cnp, String phoneNumber) {
        Client client = new Client();
        client.setFirstName(firstName);
        client.setLastName(lastName);
        client.setCnp(cnp);
        client.setPhoneNumber(phoneNumber);

        return clientRepository.save(client);
    }

    @Override
    public void deleteClientById(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Optional<Client> findByCnp(String cnp) {
        return clientRepository.findByCnp(cnp);
    }
}
