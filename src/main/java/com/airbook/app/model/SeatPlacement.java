package com.airbook.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.HashMap;

@Entity
public class SeatPlacement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private HashMap<String, Client> seatPlacement;

    public SeatPlacement(Long id, Long flightId, HashMap<String, Client> seatPlacement) {
        this.id = id;
        this.seatPlacement = seatPlacement;
    }

    public SeatPlacement() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public HashMap<String, Client> getSeatPlacement() {
        return seatPlacement;
    }

    public void setSeatPlacement(HashMap<String, Client> seatPlacement) {
        this.seatPlacement = seatPlacement;
    }
}
