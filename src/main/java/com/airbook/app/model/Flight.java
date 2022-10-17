package com.airbook.app.model;

import jdk.jfr.DataAmount;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;


//
//          ADD RELATIONS AND UKNOWN TYPES       !!!!!!!!!!!!!!!!!!!!!!
//

@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long flightId;
    @Column(name = "max_seats")
    private Integer maxSeats;
    @OneToOne(cascade = CascadeType.ALL, targetEntity = Employee.class)
    @JoinColumn(name = "fk_emp_id")
    private Employee captain;
    @OneToOne(cascade = CascadeType.ALL, targetEntity = AirPort.class)
    @JoinColumn(name = "fk_airport_id")
    private AirPort airportStart;
    @OneToOne(cascade = CascadeType.ALL, targetEntity = AirPort.class)
    @JoinColumn(name = "fk_airport_id", insertable = false, updatable = false)
    private AirPort airportEnd;

    //status should be binding, changed, canceled
    private String status;
    @Temporal(TemporalType.TIMESTAMP)
    private Date departureTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date arrivalTime;
    @OneToOne(cascade = CascadeType.ALL, targetEntity = AirPort.class)
    @JoinColumn(name = "fk_seat_id")
    private SeatPlacement seatPlacement;

    public Flight(Long flightId, Integer maxSeats, Employee captainName, AirPort airportStart, AirPort airportEnd, Date departureTime, Date arrivalTime, SeatPlacement seatPlacement) {
        this.flightId = flightId;
        this.maxSeats = maxSeats;
        this.captain = captainName;
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

    public Employee getCaptain() {
        return captain;
    }

    public void setCaptain(Employee captain) {
        this.captain = captain;
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

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public SeatPlacement getSeatPlacement() {
        return seatPlacement;
    }

    public void setSeatPlacement(SeatPlacement seatPlacement) {
        this.seatPlacement = seatPlacement;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
