package com.airbook.app.repo;

import com.airbook.app.model.AirPort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirPortRepo extends JpaRepository<AirPort, String> {
}
