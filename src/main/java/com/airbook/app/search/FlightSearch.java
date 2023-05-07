package com.airbook.app.search;

import com.airbook.app.dto.FlightDto;
import com.airbook.app.dto.FlightSearchRequest;
import com.airbook.app.dto.FlightSearchResponse;
import com.airbook.app.model.AirPort;
import com.airbook.app.model.Flight;
import com.airbook.app.repo.FlightRepo;
import com.airbook.app.service.AirPortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
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

    public FlightSearchResponse search(FlightSearchRequest searchRequest) {
        AirPort airportStart = airPortService.findById(searchRequest.getAirportStartId());
        AirPort airportEnd = airPortService.findById(searchRequest.getAirportEndId());

        List<FlightDto> flightsTarget = findDirectRouteByAirportsAndDate(airportStart, airportEnd, searchRequest.getDepartureTime());
        List<FlightDto> flightsReturn = findDirectRouteByAirportsAndDate(airportEnd, airportStart, searchRequest.getReturnTime());

        if (flightsTarget.size() > 0 && flightsReturn.size() > 0) {
            FlightSearchResponse response = new FlightSearchResponse();
            response.setFlightTarget(flightsTarget.get(0));
            response.setFlightReturn(flightsReturn.get(0));
            return response;
        }

        return null;
    }

    public List<FlightDto> findDirectRouteByAirportsAndDate(AirPort airportStart, AirPort airportEnd, LocalDate date) {
        return flightRepo.findAllByAirportStartAndAirportEnd(airportStart, airportEnd).stream()
                .filter(flight -> flight.getDepartureTime().toLocalDate().equals(date))
                .map(this::mapFlightToDto)
                .toList();
    }

    private FlightDto mapFlightToDto(Flight flight) {
        return FlightDto.builder()
                .airportStart(airPortService.mapAirportToDto(flight.getAirportStart()))
                .airportEnd(airPortService.mapAirportToDto(flight.getAirportEnd()))
                .departureTime(flight.getDepartureTime().toString())
                .arrivalTime(flight.getArrivalTime().toString())
                .build();
    }


}
