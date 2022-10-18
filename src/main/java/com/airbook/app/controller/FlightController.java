package com.airbook.app.controller;

import com.airbook.app.model.Flight;
import com.airbook.app.service.FlightService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/flight")
public class FlightController {

    private FlightService flightService;

    @PostMapping("/add")
    public String createFlight(Flight flight) {
        if (!flightService.isValidStatus(flight)) {
            return "Invalid Status";
        }
        flightService.addFlight(flight);
        return "Flight saved successfully";
    }


    // del method
    @PostMapping("/del/{id}")
    public String deleteById(Long Id) {
        flightService.delFlightById(Id);
        return "Flight deleted successfully";
    }
    //update method
    @PutMapping("/update/{id}")
    public String updateFlight(Long Id, Flight flight) {
        flightService.updateFlight(Id, flight);
        return "Update successful";
    }

    // select method
    @GetMapping
    public List<Flight> getFlights() {
        if (flightService.findAllFlights().isEmpty()) {
            return null;
        } else {
            return flightService.findAllFlights();
        }
    }

    @GetMapping("/{id}")
    public Optional<Flight> getFlightById(Long Id) {
        return flightService.findFlightById(Id);
    }




}
