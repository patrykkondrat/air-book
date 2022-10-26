package com.airbook.app.service;

import com.airbook.app.model.Flight;
import com.airbook.app.repo.FlightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    public boolean isValidStatus(Flight flight) {
        if (flight.getStatus() == "binded"){
            return true;
        } else if (flight.getStatus() == "changed") {
            return true;
        } else if (flight.getStatus() == "canceled") {
            return true;
        } return false;
    }

    public List<Flight> findAllFlights() {
        return flightRepo.findAll();
    }

    public void addFlight(Flight flight) {
        flightRepo.save(flight);
    }

    public void delFlightById(Long Id) {
        flightRepo.deleteById(Id);
    }

    public ResponseEntity<Object> updateFlight(Long Id, Flight flightToUpdate) {

        // 2 options: set previous flight status as changed and set actualy flight as binding

        Optional<Flight> flightOptional = flightRepo.findById(Id);

        if (flightOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        flightRepo.save(flightToUpdate);
        return ResponseEntity.noContent().build();
    }
}
