package com.airbook.app.repo;

import com.airbook.app.model.AirPort;
import com.airbook.app.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FlightRepo extends JpaRepository<Flight, Long> {
    List<Flight> findAllByAirportStartAndAirportEnd(AirPort airportStart, AirPort airportEnd);
}
