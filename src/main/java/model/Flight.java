package model;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "Flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flightId;
    private ArrayList<Seat> seats;

    public Flight(Long flightId, ArrayList<Seat> seats) {
        this.flightId = flightId;
        this.seats = seats;
    }

    public Flight() {
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public ArrayList<Seat> getSeats() {
        return seats;
    }

    public void setSeats(ArrayList<Seat> seats) {
        this.seats = seats;
    }
}
