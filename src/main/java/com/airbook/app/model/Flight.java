package com.airbook.app.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

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

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE,
            CascadeType.REFRESH, CascadeType.DETACH}, targetEntity = Employee.class)
    @JoinColumn(name = "fk_emp_id")
    private Employee captain;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = AirPort.class)
    @JoinColumn(name = "fk_airport_start_id")
    private AirPort airportStart;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = AirPort.class)
    @JoinColumn(name = "fk_airport_end_id")
    private AirPort airportEnd;

    @Enumerated(EnumType.STRING)
    private FlightStatus status;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime departureTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime arrivalTime;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE,
            CascadeType.REFRESH, CascadeType.DETACH}, targetEntity = SeatPlacement.class)
    @JoinColumn(name = "fk_seat_id")
    private SeatPlacement seatPlacement;
}
