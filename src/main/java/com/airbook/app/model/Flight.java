package com.airbook.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

public class Flight {

    private Long flightId;
    private Integer maxSeats;
    private Employee captainName;
    private AirPort airportStart;
    private AirPort airportEnd;
    private LocalDate departureTime;
    private LocalDate arrivalTime;
    private SeatPlacement seatPlacement;

    public Flight(Long flightId, Integer maxSeats, Employee captainName, AirPort airportStart, AirPort airportEnd, LocalDate departureTime, LocalDate arrivalTime, SeatPlacement seatPlacement) {
        this.flightId = flightId;
        this.maxSeats = maxSeats;
        this.captainName = captainName;
        this.airportStart = airportStart;
        this.airportEnd = airportEnd;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.seatPlacement = seatPlacement;
    }

    public Flight() {
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public Integer getMaxSeats() {
        return maxSeats;
    }

    public void setMaxSeats(Integer maxSeats) {
        this.maxSeats = maxSeats;
    }

    public Employee getCaptainName() {
        return captainName;
    }

    public void setCaptainName(Employee captainName) {
        this.captainName = captainName;
    }

    public AirPort getAirportStart() {
        return airportStart;
    }

    public void setAirportStart(AirPort airportStart) {
        this.airportStart = airportStart;
    }

    public AirPort getAirportEnd() {
        return airportEnd;
    }

    public void setAirportEnd(AirPort airportEnd) {
        this.airportEnd = airportEnd;
    }

    public LocalDate getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDate departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDate getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDate arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public SeatPlacement getSeatPlacement() {
        return seatPlacement;
    }

    public void setSeatPlacement(SeatPlacement seatPlacement) {
        this.seatPlacement = seatPlacement;
    }
}
