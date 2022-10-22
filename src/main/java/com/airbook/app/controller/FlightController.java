package com.airbook.app.controller;

import com.airbook.app.exception.FlightNotFoundException;
import com.airbook.app.model.Flight;
import com.airbook.app.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flight")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PostMapping("/add")
    public String createFlight(@RequestBody Flight flight) {
//        if (!flightService.isValidStatus(flight)) {
//            return "Invalid Status";
//        }
        flightService.addFlight(flight);
        return "Flight saved successfully";
    }


    // del method
    @DeleteMapping(name = "/del/{Id}")
    public void deleteById(@PathVariable Long Id) {
        flightService.delFlightById(Id);
    }

    //update method
    @PutMapping("/update/{Id}")
    public String updateFlight(@PathVariable Long Id, Flight flight) {
        flightService.updateFlight(Id, flight);
        return "Update successful";
    }

    // select method
    @GetMapping     // WORK
    public List<Flight> getFlights() {
            return flightService.findAllFlights();
    }

    @GetMapping("/{idFlight}")    // WORKS
    public Flight getFlightById(@PathVariable Long idFlight) {
        Optional<Flight> flight = flightService.findFlightById(idFlight);
        return flight.get();
    }
}
