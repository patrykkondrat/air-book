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

    public void registerUser(User user) {
        user.setRoles("ROLE_USER");
        userRepo.save(user);
    }
}
