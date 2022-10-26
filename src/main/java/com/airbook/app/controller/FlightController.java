package com.airbook.app.controller;

import com.airbook.app.exception.FlightNotFoundException;
import com.airbook.app.model.Flight;
import com.airbook.app.model.SeatPlacement;
import com.airbook.app.repo.SeatPlacementRepo;
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
    @Autowired
    private SeatPlacementRepo seatPlacementRepo;

    @PostMapping("/add") // works with complicated request body, maybe will less complicated with thymeleaf (MVC)
    public void createFlight(@RequestBody Flight flight) {
        /* example
        {
    "flightId": "100",
    "arrivalTime": "2022-11-28T23:44:00",
    "departureTime": "2022-11-29T02:40:00",
    "maxSeats": 129,
    "status": "binded",
    "airportStart": {
        "airportId": "PLW",
        "airportName": "Modlin, Warsaw, Poland",
        "airportCode": 513
    },
    "airportEnd": {
        "airportId": "PLK",
        "airportName": "Krakow, Poland",
        "airportCode": 103
    },
    "captain": {
            "id": 2,
            "name": "Przemysław Wrona",
            "birthday": "1971-11-14",
            "dateOfEmployment": "2006-08-07",
            "salary": 210452.0
        },
    "seatPlacement": {
        "id": 2,
        "seatPlacement": {}
    }
}
         */
        flightService.addFlight(flight);
    }


    // del method
    @DeleteMapping("/del/{Id}") // TO DO ! can't delate flight when we have relation with foreign key
    public void deleteById(@PathVariable Long Id) {
        seatPlacementRepo.deleteById(Id);
        flightService.delFlightById(Id);
    }

    //update method
    @PutMapping("/update/{Id}") // Doesn't work
    public void updateFlight(@PathVariable Long Id, @RequestBody Flight flight) {
        flightService.updateFlight(Id, flight);
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
