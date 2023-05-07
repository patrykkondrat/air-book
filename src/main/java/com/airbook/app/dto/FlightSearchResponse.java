package com.airbook.app.dto;

import com.airbook.app.model.Flight;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FlightSearchResponse {
    private FlightDto flightTarget;
    private FlightDto flightReturn;
}
