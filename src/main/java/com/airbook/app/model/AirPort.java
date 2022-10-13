//package com.airbook.app.model;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//
//@Entity
//@Table(name = "airports")
//public class AirPort {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "airport-id")
//    private Integer airportId;
//    @Column(name = "airport-name")
//    private String airportName;
//    @Column(name = "coords")
//    private ArrayList<Double> coordinatesXY;
//
//    public ArrayList<Double> getCoordinatesXY() {
//        return coordinatesXY;
//    }
//
//    public void setCoordinatesXY(ArrayList<Double> coordinatesXY) {
//        this.coordinatesXY = coordinatesXY;
//    }
//
//    public AirPort(Integer airportId, String airportName, ArrayList<Double> coordinatesXY) {
//        this.airportId = airportId;
//        this.airportName = airportName;
//        this.coordinatesXY = coordinatesXY;
//    }
//
//    public AirPort() {
//    }
//
//    public Integer getAirportId() {
//        return airportId;
//    }
//
//    public void setAirportId(Integer airportId) {
//        this.airportId = airportId;
//    }
//
//    public String getAirportName() {
//        return airportName;
//    }
//
//    public void setAirportName(String airportName) {
//        this.airportName = airportName;
//    }
//}
