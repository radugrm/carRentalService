package com.raflo.rentalService.repositories;

import com.raflo.rentalService.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    List<Client> findAllByFirstName(String firstName);
    Optional<Client> findByCnp(String cnp);
    Client findClientByCnp(String cnp);
}
