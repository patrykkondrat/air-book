package com.airbook.app.dto;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightDto {
    private AirportDto airportStart;
    private AirportDto airportEnd;
    private String departureTime;
    private String arrivalTime;
}
