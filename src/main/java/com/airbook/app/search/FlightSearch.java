package com.airbook.app.search;

import com.airbook.app.dto.FlightDto;
import com.airbook.app.dto.FlightSearchRequest;
import com.airbook.app.model.AirPort;
import com.airbook.app.model.Flight;
import com.airbook.app.repo.FlightRepo;
import com.airbook.app.service.AirPortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class FlightSearch {

    private FlightRepo flightRepo;

    private AirPortService airPortService;

    @Autowired
    public FlightSearch(FlightRepo flightRepo, AirPortService airPortService) {
        this.flightRepo = flightRepo;
        this.airPortService = airPortService;
    }

    public List<FlightDto> search(FlightSearchRequest searchRequest) {
        AirPort airportStart = airPortService.findById(searchRequest.getAirportStartId());
        AirPort airportEnd = airPortService.findById(searchRequest.getAirportEndId());

        List<Flight> flights = flightRepo.findAllByAirportStartAndAirportEndAndDepartureTime(
                airportStart, airportEnd, LocalDate.parse(searchRequest.getDepartureTime().toString()).atStartOfDay());
        System.out.println(flights);
        return null;
    }
}
