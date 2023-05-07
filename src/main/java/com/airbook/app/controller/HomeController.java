package com.airbook.app.controller;

import com.airbook.app.dto.FlightSearchRequest;
import com.airbook.app.search.FlightSearch;
import com.airbook.app.service.AirPortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    private FlightSearch flightSearch;
    private AirPortService airPortService;

    @Autowired
    public HomeController(FlightSearch flightSearch,
                          AirPortService airPortService) {
        this.flightSearch = flightSearch;
        this.airPortService = airPortService;
    }

    @GetMapping("/")
    public String init(Model model) {
        model.addAttribute("flightSearchRequest", new FlightSearchRequest());
        model.addAttribute("airportsStart", airPortService.findAllAirPorts().stream().map(airPortService::mapAirportToDto).collect(Collectors.toList()));
        model.addAttribute("airportsEnd", airPortService.findAllAirPorts().stream().map(airPortService::mapAirportToDto).collect(Collectors.toList()));
        return "index";
    }

    @PostMapping("/search")
    public ModelAndView searchFlight(@ModelAttribute("flightSearchRequest") FlightSearchRequest searchRequest, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();
        if (result.hasErrors()) {
            modelAndView.setViewName("redirect:/?error=true");
        }
        modelAndView.addObject("searchResultList", flightSearch.search(searchRequest));
        modelAndView.setViewName("searchresult");
        return modelAndView;
    }
}
