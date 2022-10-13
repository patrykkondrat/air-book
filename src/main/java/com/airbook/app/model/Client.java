package com.airbook.app.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "client")
public class Client {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "client_id")
    private Long clientId;
    @Column(name = "name")
    private String name;
    @Column(name = "seat")
    private String seat;
    @Column(name = "cost")
    private Integer cost;

    public Client(Long clientId, String name, String seat, Integer cost) {
        this.clientId = clientId;
        this.name = name;
        this.seat = seat;
        this.cost = cost;
    }

    public Client() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }
}
