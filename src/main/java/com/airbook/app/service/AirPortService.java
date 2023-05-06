package com.airbook.app.service;

import com.airbook.app.dto.AirportDto;
import com.airbook.app.model.AirPort;
import com.airbook.app.repo.AirPortRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirPortService {

    private AirPortRepo airPortRepo;

    @Autowired
    public AirPortService(AirPortRepo airPortRepo) {
        this.airPortRepo = airPortRepo;
    }

    public List<AirPort> findAllAirPorts() {
        return airPortRepo.findAll();
    }

    public AirPort findById(String id) {
        return airPortRepo.findById(id).orElseThrow(() -> new RuntimeException("Airport not found"));
    }


    public AirportDto mapAirportToDto(AirPort airPort) {
        return AirportDto.builder()
                .airportName(airPort.getAirportName())
                .airportId(airPort.getAirportId())
                .build();
    }


}
