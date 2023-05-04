package com.airbook.app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

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

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = AirPort.class)
    @JoinColumn(name = "fk_airport_start_id")
    private AirPort airportStart;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = AirPort.class)
    @JoinColumn(name = "fk_airport_end_id", insertable = false, updatable = false)
    private AirPort airportEnd;

    @Enumerated(EnumType.STRING)
    private FlightStatus status;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDate departureTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDate arrivalTime;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = SeatPlacement.class)
    @JoinColumn(name = "fk_seat_id")
    private SeatPlacement seatPlacement;
}
