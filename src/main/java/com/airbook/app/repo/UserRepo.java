package com.airbook.app.repo;

import com.airbook.app.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UserRepo extends CrudRepository<User,Long> {
    Optional<User> findByUsername(String username);
}
