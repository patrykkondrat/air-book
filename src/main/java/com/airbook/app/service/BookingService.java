package com.airbook.app.service;

import com.airbook.app.repo.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    private ClientRepo clientRepo;

    public BookingService(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }


}
