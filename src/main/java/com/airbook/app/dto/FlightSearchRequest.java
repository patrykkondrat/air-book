package com.airbook.app.dto;

import lombok.*;

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
    private Integer numberOfPassengers;
    private Boolean isOneWay;
}
