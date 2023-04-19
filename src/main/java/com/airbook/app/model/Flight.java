package com.airbook.app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    private FlightStatus status;

    @Temporal(TemporalType.TIMESTAMP)
    private Date departureTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date arrivalTime;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = SeatPlacement.class)
    @JoinColumn(name = "fk_seat_id")
    private SeatPlacement seatPlacement;
}
