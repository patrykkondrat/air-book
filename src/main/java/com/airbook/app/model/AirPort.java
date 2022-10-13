package com.airbook.app.model;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "airports")
public class AirPort {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "airport_id")
    private Long airportId;
    @Column(name = "airport_name")
    private String airportName;
    @Column(name = "country")
    private String country;
    @Column(name = "coords")
    private ArrayList<Double> coordinatesXY;

    public ArrayList<Double> getCoordinatesXY() {
        return coordinatesXY;
    }

    public void setCoordinatesXY(ArrayList<Double> coordinatesXY) {
        this.coordinatesXY = coordinatesXY;
    }

    public AirPort(Long airportId, String airportName, String country, ArrayList<Double> coordinatesXY) {
        this.airportId = airportId;
        this.airportName = airportName;
        this.country = country;
        this.coordinatesXY = coordinatesXY;
    }

    public AirPort() {
    }

    public Long getAirportId() {
        return airportId;
    }

    public void setAirportId(Long airportId) {
        this.airportId = airportId;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
