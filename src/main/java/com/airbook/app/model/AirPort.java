package com.airbook.app.model;

import javax.persistence.*;

@Entity
public class AirPort {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "airport_id")
    private Long airportId;
    private String airportName;
    private Integer airportCode;
    private String country;

    public AirPort(Long airportId, String airportName, Integer airportCode, String country) {
        this.airportId = airportId;
        this.airportName = airportName;
        this.airportCode = airportCode;
        this.country = country;
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

    public Integer getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(Integer airportCode) {
        this.airportCode = airportCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
