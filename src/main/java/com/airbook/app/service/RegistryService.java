package com.airbook.app.service;

import com.airbook.app.model.User;
import com.airbook.app.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistryService {

    private final UserRepo userRepo;

    @Autowired
    public RegistryService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void registerUser(User user, String role) {
        user.setRoles(role);
        if (userRepo.findByUsername(user.getUsername()).isPresent()) {
            throw new RuntimeException("User " + user.getUsername() + " already exists");
        }
        userRepo.save(user);
    }
}
