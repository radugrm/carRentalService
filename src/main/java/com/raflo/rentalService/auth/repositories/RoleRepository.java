package com.raflo.rentalService.auth.repositories;

import com.raflo.rentalService.auth.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
