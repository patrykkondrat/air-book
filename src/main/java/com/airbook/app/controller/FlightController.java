package com.airbook.app.controller;

import com.airbook.app.model.Employee;
import com.airbook.app.model.Flight;
import com.airbook.app.repo.AirPortRepo;
import com.airbook.app.service.AirPortService;
import com.airbook.app.service.EmployeeService;
import com.airbook.app.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/flight")
public class FlightController {

    private FlightService flightService;
    private EmployeeService employeeService;
    private AirPortService airPortService; // TODO change on AirportService

    @Autowired
    public FlightController(FlightService flightService, EmployeeService employeeService, AirPortService airPortService) {
        this.flightService = flightService;
        this.employeeService = employeeService;
        this.airPortService = airPortService;
    }

    @GetMapping
    public String flightList(Model model) {
        model.addAttribute("flights", flightService.findAllFlights());
        return "flight/flightlist";
    }

    @GetMapping("/add")
    public String addFlight(Model model) {
        model.addAttribute("flight", new Flight());
        model.addAttribute("employees", employeeService.findAllEmployees());
        model.addAttribute("airportsStart", airPortService.findAllAirPorts());
        model.addAttribute("airportsEnd", airPortService.findAllAirPorts());
        model.addAttribute("seatPlacement", List.of(1, 2));
        return "flight/flightadd";
    }


    @PostMapping("/add")
    public String addFlight(@ModelAttribute("flight") Flight flight, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
            return "redirect:/flight/add";
        }
        flight.setDepartureTime(LocalDateTime.parse(flight.getDepartureTime().toString()));
        flight.setArrivalTime(LocalDateTime.parse(flight.getArrivalTime().toString()));
        flightService.addFlight(flight);
        return "redirect:/flight/add";
    }

    @PostMapping("/del/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        flightService.delFlightById(id);
        return "Flight deleted successfully";
    }

    //update method
    @PutMapping("/update/{id}")
    public String updateFlight(@PathVariable("id") Long id, Flight flight) {
        flightService.updateFlight(id, flight);
        return "Update successful";
    }

    @GetMapping("/{id}")
    public Optional<Flight> getFlightById(Long Id) {
        return flightService.findFlightById(Id);
    }
}
