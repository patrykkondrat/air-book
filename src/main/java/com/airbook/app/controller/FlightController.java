package com.airbook.app.controller;

import com.airbook.app.model.Flight;
import com.airbook.app.repo.FlightRepo;
import com.airbook.app.service.FlightService;
import org.springframework.web.bind.annotation.*;

import javax.validation.executable.ValidateOnExecution;

@RestController
@RequestMapping("/flight")
public class FlightController {

    private FlightService flightService;

    @PostMapping("/")
    public String createFlight(@RequestBody Flight flight) {
        if (!flightService.isValidStatus(flight)) {
            return "Invalid Status";
        }
        flightService.addFlight(flight);
        return "Flight save successfully";
    }


    // del method

    //update method

    // select method



}
