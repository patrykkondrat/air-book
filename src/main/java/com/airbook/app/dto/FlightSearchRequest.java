package com.airbook.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FlightSearchRequest {
    private String airportStartId;
    private String airportEndId;
    private LocalDate departureTime;
    private LocalDate returnTime;
//    private Integer numberOfPassengers;
}
