package com.raflo.rentalService.auth.services;

import com.raflo.rentalService.auth.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
