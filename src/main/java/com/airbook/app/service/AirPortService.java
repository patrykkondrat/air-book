package com.airbook.app.service;

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

}
