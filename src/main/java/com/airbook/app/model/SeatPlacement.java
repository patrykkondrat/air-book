package com.airbook.app.model;

import jakarta.persistence.*;

@Entity
public class SeatPlacement {
    @Id
    @GeneratedValue
    @Column(name = "seat_id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Client client;
}
