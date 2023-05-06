package com.airbook.app.service;

import com.airbook.app.model.Flight;
import com.airbook.app.model.FlightStatus;
import com.airbook.app.repo.FlightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        try {
            Flight flight = flightRepo.findById(Id).orElseThrow(() -> new IllegalArgumentException("Invalid flight Id:" + Id));
            // remove relations with other tables
            flight.setCaptain(null);
            flight.setAirportStart(null);
            flight.setAirportEnd(null);
            flight.setSeatPlacement(null);
            flightRepo.delete(flight);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateFlight(Long Id, Flight flightToUpdate) {
        if (flightRepo.findById(Id).isPresent()) {
            try {
                Flight existingFlight = flightRepo.findById(Id).get();
                existingFlight.setAirportStart(flightToUpdate.getAirportStart());
                existingFlight.setAirportEnd(flightToUpdate.getAirportEnd());
                existingFlight.setCaptain(flightToUpdate.getCaptain());
                existingFlight.setDepartureTime(flightToUpdate.getDepartureTime());
                existingFlight.setArrivalTime(flightToUpdate.getArrivalTime());
                existingFlight.setSeatPlacement(flightToUpdate.getSeatPlacement());
                existingFlight.setMaxSeats(flightToUpdate.getMaxSeats());
                existingFlight.setStatus(FlightStatus.CHANGED);
                flightRepo.save(existingFlight);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
