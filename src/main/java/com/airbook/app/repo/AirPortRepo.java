package com.airbook.app.repo;

import com.airbook.app.model.AirPort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirPortRepo extends CrudRepository<AirPort, Integer> {
}
