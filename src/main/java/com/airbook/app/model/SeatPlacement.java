package com.airbook.app.model;

import javax.persistence.*;
import java.util.HashMap;

@Entity
public class SeatPlacement {
    @Id
    @GeneratedValue
    @Column(name = "seat_id")
    private Long id;
    private HashMap<String, Client> seatPlacement;



    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SeatPlacement{");
        sb.append("seatPlacement=").append(seatPlacement);
        sb.append('}');
        return sb.toString();
    }
}
