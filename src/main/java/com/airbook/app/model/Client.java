//package com.airbook.app.model;
//
//import javax.persistence.*;
//import java.util.UUID;
//
//@Entity
//@Table(name = "Client")
//public class Client {
//    @Id
//    private UUID clientId;
//    private String name;
//    private String seat;
//    private Integer cost;
//
//    public Client(UUID clientId, String name, String seat, Integer cost) {
//        this.clientId = UUID.randomUUID();
//        this.name = name;
//        this.seat = seat;
//        this.cost = cost;
//    }
//
//    public Client() {
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getSeat() {
//        return seat;
//    }
//
//    public void setSeat(String seat) {
//        this.seat = seat;
//    }
//
//    public Integer getCost() {
//        return cost;
//    }
//
//    public void setCost(Integer cost) {
//        this.cost = cost;
//    }
//}
