package com.airbook.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AirPort {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String airportId;
    private String airportName;
    private Integer airportCode;
}
