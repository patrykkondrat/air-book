package com.airbook.app.model;

import javax.persistence.*;

@Entity
public class AirPort {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "airport_id")
    private String airportId;
    private String airportName;
    private Integer airportCode;

    public AirPort(String airportId, String airportName, Integer airportCode) {
        this.airportId = airportId;
        this.airportName = airportName;
        this.airportCode = airportCode;
    }

    public AirPort() {
    }

    public String getAirportId() {
        return airportId;
    }

    public void setAirportId(String airportId) {
        this.airportId = airportId;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public Integer getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(Integer airportCode) {
        this.airportCode = airportCode;
    }
}
