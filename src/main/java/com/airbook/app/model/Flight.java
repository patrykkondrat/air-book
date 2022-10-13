package com.airbook.app.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.UUID;
@Entity
@Table(name = "flights")
public class Flight {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long flightId;
    @Column(name = "id_uuid")
    private UUID idUniq;
    @Column(name = "max_seat")
    private Integer maxSeats;
    @Column(name = "captain_name")
    private String captainName;
    @Column(name = "airport_start")
    private AirPort airportStart;
    @Column(name = "airport_end")
    private AirPort airportEnd;
    @Column(name = "departure_time")
    private LocalDate departureTime;
    @Column(name = "arrival_time")
    private LocalDate arrivalTime;
    @Column(name = "seat_placement")
    private HashMap<String, Client> seatPlacement;

    public Flight(Long flightId, Integer maxSeats, String captainName, AirPort airportStart, AirPort airportEnd, LocalDate departureTime, LocalDate arrivalTime, HashMap<String, Client> seatPlacement) {
        this.flightId = flightId;
        this.idUniq = UUID.randomUUID();
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

    public String getCaptainName() {
        return captainName;
    }

    public void setCaptainName(String captainName) {
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

    public HashMap<String, Client> getSeatPlacement() {
        return seatPlacement;
    }

    public void setSeatPlacement(HashMap<String, Client> seatPlacement) {
        this.seatPlacement = seatPlacement;
    }
}
