package com.raflo.rentalService.auth.repositories;

import com.raflo.rentalService.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
