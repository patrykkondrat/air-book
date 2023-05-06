package com.airbook.app.service;

import com.airbook.app.model.Flight;
import com.airbook.app.model.FlightStatus;
import com.airbook.app.repo.FlightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    private FlightRepo flightRepo;

    public Optional<Flight> findFlightById(Long Id) {
        return flightRepo.findById(Id);
    }

    public List<Flight> findAllFlights() {
        return flightRepo.findAll();
    }

    public void addFlight(Flight flight) {
        flight.setStatus(FlightStatus.BINDING);
        flightRepo.save(flight);
    }

    public void delFlightById(Long Id) {
        flightRepo.deleteById(Id);
    }

    public void updateFlight(Long Id, Flight flightToUpdate) {
        if (flightRepo.findById(Id).isPresent()) {
            Flight existingFlight = flightRepo.findById(Id).get();

            existingFlight.setStatus(FlightStatus.CHANGED);
            flightRepo.saveAndFlush(flightToUpdate);
        }
    }
}
